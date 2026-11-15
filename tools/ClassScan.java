import jdk.internal.org.objectweb.asm.*;
import jdk.internal.org.objectweb.asm.tree.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

public class ClassScan {
    public static void main(String[] args) throws Exception {
        String jar = args[0];
        List<String> hits = new ArrayList<>();
        try (ZipFile zf = new ZipFile(jar)) {
            Enumeration<? extends ZipEntry> en = zf.entries();
            while (en.hasMoreElements()) {
                ZipEntry e = en.nextElement();
                if (!e.getName().endsWith(".class")) continue;
                byte[] data;
                try (InputStream in = zf.getInputStream(e)) { data = in.readAllBytes(); }
                ClassNode cn = new ClassNode();
                new ClassReader(data).accept(cn, 0);
                for (MethodNode m : cn.methods) {
                    // string-decryptor candidates
                    if (m.desc.contains("[I") || m.desc.contains("[B") || m.desc.contains("[C")) {
                        if (m.desc.endsWith("Ljava/lang/String;")) {
                            hits.add("DEC " + cn.name + "." + m.name + m.desc);
                        }
                    }
                    for (AbstractInsnNode insn : m.instructions) {
                        if (insn instanceof MethodInsnNode mi) {
                            if (mi.owner.equals("java/lang/Runtime") && mi.name.equals("exec"))
                                hits.add("EXEC " + cn.name + "." + m.name + m.desc);
                            if (mi.owner.equals("java/lang/ProcessBuilder"))
                                hits.add("PROC " + cn.name + "." + m.name + m.desc);
                            if (mi.name.equals("defineClass"))
                                hits.add("DEF " + cn.name + "." + m.name + m.desc);
                            if (mi.owner.startsWith("java/net/") || mi.owner.startsWith("javax/net/"))
                                hits.add("NET " + cn.name + "." + m.name + m.desc + " -> " + mi.owner + "." + mi.name);
                        }
                        if (insn instanceof LdcInsnNode ld && ld.cst instanceof String s) {
                            if (s.startsWith("http") || s.contains("webhook") || s.contains("discord"))
                                hits.add("STR " + cn.name + " :: " + s);
                        }
                    }
                }
            }
        }
        hits.stream().sorted().distinct().forEach(System.out::println);
    }
}
