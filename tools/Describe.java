import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

/**
 * Emit one fact row per class of the renamed JAR, for building the class catalogue.
 * Columns: old, new, kind, access, super, interfaces, fields, methods, statics,
 * events, bukkitTypes, libTypes, uses, enumConstants, recordComponents, fluentSetters.
 */
public class Describe {
    public static void main(String[] args) throws Exception {
        Path jar = Paths.get(args[0]);
        Path mapping = Paths.get(args[1]);
        Path out = Paths.get(args[2]);

        Map<String, String> oldToNew = new LinkedHashMap<>();
        Map<String, String> kindOf = new LinkedHashMap<>();
        List<String[]> rows = new ArrayList<>();
        for (String line : Files.readAllLines(mapping)) {
            String[] p = line.split("\t");
            if (p.length >= 3) {
                oldToNew.put(p[0], p[1]);
                kindOf.put(p[0], p[2]);
            }
        }
        Map<String, ClassNode> classes = new LinkedHashMap<>();
        try (ZipFile zf = new ZipFile(jar.toFile())) {
            Enumeration<? extends ZipEntry> en = zf.entries();
            while (en.hasMoreElements()) {
                ZipEntry e = en.nextElement();
                if (!e.getName().endsWith(".class")) continue;
                try (InputStream in = zf.getInputStream(e)) {
                    ClassNode cn = new ClassNode();
                    new ClassReader(in).accept(cn, 0);
                    classes.put(cn.name, cn);
                }
            }
        }
        for (ClassNode cn : classes.values()) {
            String old = reverse(oldToNew, cn.name);
            if (old == null) continue;                    // not an obfuscated top-level class
            String kind = kindOf.getOrDefault(old, "?");
            List<String> events = new ArrayList<>();
            Set<String> bukkit = new LinkedHashSet<>(), lib = new LinkedHashSet<>(), uses = new LinkedHashSet<>();
            Set<String> enumConsts = new LinkedHashSet<>();
            int statics = 0, fluent = 0;
            for (MethodNode m : cn.methods) {
                if ((m.access & Opcodes.ACC_STATIC) != 0 && !m.name.startsWith("<")) statics++;
                if (!m.name.startsWith("<") && Type.getArgumentTypes(m.desc).length >= 1
                        && Type.getReturnType(m.desc).getDescriptor().equals("L" + cn.name + ";")) fluent++;
                if (m.visibleAnnotations != null) {
                    for (AnnotationNode a : m.visibleAnnotations) {
                        if (!a.desc.equals("Lorg/bukkit/event/EventHandler;")) continue;
                        for (Type t : Type.getArgumentTypes(m.desc)) {
                            if (t.getSort() == Type.OBJECT && t.getInternalName().startsWith("org/bukkit/event/"))
                                events.add(t.getInternalName().substring(t.getInternalName().lastIndexOf('/') + 1));
                        }
                    }
                }
            }
            for (FieldNode f : cn.fields) {
                if ((f.access & Opcodes.ACC_ENUM) != 0) enumConsts.add(f.name);
            }
            for (MethodNode m : cn.methods) {
                for (Type t : Type.getArgumentTypes(m.desc)) collect(t, bukkit, lib);
                collect(Type.getReturnType(m.desc), bukkit, lib);
                for (AbstractInsnNode insn : m.instructions) {
                    if (insn instanceof MethodInsnNode mi) {
                        String n = mi.owner;
                        if (n.startsWith("org/bukkit/") || n.startsWith("net/minecraft/") || n.startsWith("io/papermc/")) {
                            uses.add(simple(n));
                        } else if (n.startsWith("itemsadder/") || n.startsWith("dev/lone/")) {
                            uses.add(mappedName(n, oldToNew));
                        }
                    }
                    if (insn instanceof TypeInsnNode ti && (ti.desc.startsWith("org/bukkit/") || ti.desc.startsWith("itemsadder/"))) {
                        uses.add(ti.desc.startsWith("itemsadder/") ? mappedName(ti.desc, oldToNew) : simple(ti.desc));
                    }
                }
            }
            for (FieldNode f : cn.fields) {
                if (f.desc.startsWith("L") && f.desc.endsWith(";")) {
                    String t = f.desc.substring(1, f.desc.length() - 1);
                    if (t.startsWith("org/bukkit/") || t.startsWith("net/minecraft/")) bukkit.add(simple(t));
                    else if (t.startsWith("itemsadder/") || t.startsWith("dev/lone/")) lib.add(mappedName(t, oldToNew));
                }
            }
            List<String> supers = new ArrayList<>();
            if (cn.superName != null) supers.add(mappedName(cn.superName, oldToNew));
            List<String> itfs = new ArrayList<>();
            for (String i : cn.interfaces) itfs.add(mappedName(i, oldToNew));

            rows.add(new String[]{
                    old,
                    cn.name.substring(cn.name.lastIndexOf('/') + 1),
                    kind,
                    String.valueOf(cn.access),
                    String.join(">", supers),
                    String.join(",", itfs),
                    String.valueOf(cn.fields.size()),
                    String.valueOf(cn.methods.stream().filter(m -> !m.name.startsWith("<")).count()),
                    String.valueOf(statics),
                    String.join(",", events),
                    String.join(",", bukkit.stream().limit(5).toList()),
                    String.join(",", lib.stream().limit(5).toList()),
                    String.join(",", uses.stream().limit(6).toList()),
                    String.join(",", enumConsts.stream().limit(8).toList()),
                    String.join(",", cn.fields.stream().filter(f -> f.desc.length() > 0).limit(6)
                            .map(f -> simple(f.desc.replace("[", ""))).toList()),
                    String.valueOf(fluent),
            });
        }
        try (BufferedWriter w = Files.newBufferedWriter(out)) {
            w.write("old\tnew\tkind\taccess\tsuper\tinterfaces\tfields\tmethods\tstatics\tevents\tbukkit\tlib\tuses\tenum\tfieldTypes\tfluent\n");
            for (String[] r : rows) w.write(String.join("\t", r) + "\n");
        }
        System.out.println("rows=" + rows.size() + " -> " + out);
    }

    static String reverse(Map<String, String> m, String v) {
        for (Map.Entry<String, String> e : m.entrySet()) if (e.getValue().equals(v)) return e.getKey();
        return null;
    }

    static String mappedName(String internal, Map<String, String> map) {
        String n = map.get(internal);
        if (n != null) return n.substring(n.lastIndexOf('/') + 1);
        return simple(internal);
    }

    static void collect(Type t, Set<String> bukkit, Set<String> lib) {
        if (t.getSort() == Type.ARRAY) t = t.getElementType();
        if (t.getSort() != Type.OBJECT) return;
        String n = t.getInternalName();
        if (n.startsWith("org/bukkit/") || n.startsWith("net/minecraft/") || n.startsWith("io/papermc/")) bukkit.add(simple(n));
        else if (n.startsWith("itemsadder/") || n.startsWith("dev/lone/") || n.startsWith("ia/sh/")) lib.add(simple(n));
    }

    static String simple(String internal) {
        String s = internal;
        if (s.endsWith(";")) s = s.substring(0, s.length() - 1);
        if (s.startsWith("L")) s = s.substring(1);
        int i = Math.max(s.lastIndexOf('/'), s.lastIndexOf('$'));
        return i >= 0 ? s.substring(i + 1) : s;
    }
}
