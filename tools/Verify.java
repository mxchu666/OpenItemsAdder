import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.util.CheckClassAdapter;
import java.io.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.*;

/** Structural validation of a remapped JAR: entry names, internal refs, bytecode verifier. */
public class Verify {
    public static void main(String[] args) throws Exception {
        String jar = args[0];
        Map<String, byte[]> classes = new LinkedHashMap<>();
        Set<String> entries = new LinkedHashSet<>();
        List<String> dupes = new ArrayList<>();
        try (ZipFile zf = new ZipFile(jar)) {
            Enumeration<? extends ZipEntry> en = zf.entries();
            while (en.hasMoreElements()) {
                ZipEntry e = en.nextElement();
                if (!entries.add(e.getName())) dupes.add(e.getName());
                if (e.getName().endsWith(".class")) {
                    try (InputStream in = zf.getInputStream(e)) {
                        classes.put(e.getName().substring(0, e.getName().length() - 6), in.readAllBytes());
                    }
                }
            }
        }
        int badName = 0, badRef = 0, badLiteral = 0, badBytecode = 0;
        Set<String> missingRefs = new TreeSet<>();
        for (Map.Entry<String, byte[]> e : classes.entrySet()) {
            ClassNode cn = new ClassNode();
            new ClassReader(e.getValue()).accept(cn, 0);
            if (!cn.name.equals(e.getKey())) {
                badName++;
                System.out.println("ENTRY MISMATCH " + e.getKey() + " contains " + cn.name);
            }
            Set<String> refs = new LinkedHashSet<>();
            if (cn.superName != null) refs.add(cn.superName);
            refs.addAll(cn.interfaces);
            for (FieldNode f : cn.fields) collectTypes(f.desc, refs);
            for (MethodNode m : cn.methods) {
                collectTypes(m.desc, refs);
                for (AbstractInsnNode insn : m.instructions) {
                    if (insn instanceof MethodInsnNode mi) { refs.add(mi.owner); collectTypes(mi.desc, refs); }
                    if (insn instanceof FieldInsnNode fi) { refs.add(fi.owner); collectTypes(fi.desc, refs); }
                    if (insn instanceof TypeInsnNode ti) refs.add(ti.desc);
                    if (insn instanceof LdcInsnNode ld) {
                        if (ld.cst instanceof Type t) collectTypes(t.getDescriptor(), refs);
                        if (ld.cst instanceof String s && s.startsWith("itemsadder.m.")) {
                            if (!classes.containsKey(s.replace('.', '/'))) {
                                badLiteral++;
                                System.out.println("BAD LITERAL " + s + " in " + cn.name);
                            }
                        }
                    }
                }
            }
            for (String r : refs) {
                if (r.startsWith("itemsadder/")) {
                    // package-level classes only; everything here must exist
                    if (!classes.containsKey(r)) { badRef++; missingRefs.add(r + " <- " + cn.name); }
                }
            }
            StringWriter sw = new StringWriter();
            try {
                CheckClassAdapter.verify(new ClassReader(e.getValue()), false, new PrintWriter(sw));
            } catch (Throwable t) {
                badBytecode++;
                System.out.println("VERIFY CRASH " + cn.name + ": " + t);
            }
            if (sw.toString().contains("Error") || sw.toString().contains("Exception")) {
                badBytecode++;
                if (badBytecode < 6) {
                    String msg = sw.toString();
                    System.out.println("VERIFY " + cn.name + ":\n" + msg.substring(0, Math.min(600, msg.length())));
                }
            }
        }
        System.out.println("classes=" + classes.size() + " entries=" + entries.size() + " dupes=" + dupes.size());
        System.out.println("entryNameMismatch=" + badName + " missingOwnRefs=" + badRef + " badLiterals=" + badLiteral + " bytecodeIssues=" + badBytecode);
        missingRefs.stream().limit(20).forEach(s -> System.out.println("  missing " + s));
    }

    static void collectTypes(String desc, Set<String> out) {
        Type t = Type.getType(desc);
        walk(t, out);
    }

    static void walk(Type t, Set<String> out) {
        switch (t.getSort()) {
            case Type.ARRAY -> walk(t.getElementType(), out);
            case Type.OBJECT -> out.add(t.getInternalName());
            case Type.METHOD -> {
                for (Type a : t.getArgumentTypes()) walk(a, out);
                walk(t.getReturnType(), out);
            }
            default -> { }
        }
    }
}
