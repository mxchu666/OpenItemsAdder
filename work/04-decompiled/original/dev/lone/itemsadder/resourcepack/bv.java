package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.b;
import dev.lone.itemsadder.resourcepack.bm;
import dev.lone.itemsadder.resourcepack.bn;
import dev.lone.itemsadder.resourcepack.bo;
import dev.lone.itemsadder.resourcepack.bp;
import dev.lone.itemsadder.resourcepack.bt;
import dev.lone.itemsadder.resourcepack.cd;
import ia.sh.libby.Library;
import ia.sh.libby.classloader.IsolatedClassLoader;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

final class bv
extends Enum
implements bo {
    public static final /* enum */ bv INSTANCE = new bv("INSTANCE", 0);
    private volatile Method method;
    private volatile String unavailable;
    private static final /* synthetic */ bv[] $VALUES;

    public static bv[] values() {
        return (bv[])$VALUES.clone();
    }

    public static bv valueOf(String string) {
        return Enum.valueOf(bv.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private bv() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public bn M(List list) {
        String[] stringArray;
        Method method = this.method;
        if (method == null && this.unavailable == null) {
            stringArray = this;
            // MONITORENTER : this
            if (this.method == null && this.unavailable == null) {
                try {
                    this.method = bv.At();
                }
                catch (Throwable throwable) {
                    this.unavailable = bm.a(throwable);
                }
            }
            method = this.method;
            // MONITOREXIT : stringArray
        }
        if (method == null) {
            String string;
            if (this.unavailable == null) {
                string = "unknown native loader error";
                return bn.fP(string);
            }
            string = this.unavailable;
            return bn.fP(string);
        }
        try {
            stringArray = (String[])list.stream().map(bt2 -> bt2.Ai() == cd.VERTEX ? "vertex" : "fragment").toArray(String[]::new);
            String[] stringArray2 = (String[])list.stream().map(bt::Am).toArray(String[]::new);
            String[] stringArray3 = (String[])method.invoke(null, stringArray, stringArray2);
            ArrayList<bp> arrayList = new ArrayList<bp>();
            int n = 0;
            while (n + 3 < stringArray3.length) {
                arrayList.add(new bp(stringArray3[n], Integer.parseInt(stringArray3[n + 1]), Boolean.parseBoolean(stringArray3[n + 2]), stringArray3[n + 3]));
                n += 4;
            }
            return new bn(true, null, List.copyOf(arrayList));
        }
        catch (InvocationTargetException invocationTargetException) {
            return bn.fP(bm.a(invocationTargetException.getTargetException()));
        }
        catch (Throwable throwable) {
            return bn.fP(bm.a(throwable));
        }
    }

    private static Method At() {
        Class<?> clazz;
        String string = bv.Au();
        b b2 = new b(Main.rS());
        for (String object2 : List.of("lwjgl", "lwjgl-shaderc")) {
            b2.a(bv.am(object2, null), false);
            b2.a(bv.am(object2, string), false);
        }
        IsolatedClassLoader isolatedClassLoader = b2.getIsolatedClassLoaderById("itemsadder-shader-validator");
        if (isolatedClassLoader == null) {
            throw new IllegalStateException("Libby did not create the isolated shader compiler loader");
        }
        String string2 = "/" + "dev.lone.itemsadder.resourcepack.NativeGlslangBridge".replace('.', '/') + ".class";
        try (InputStream inputStream = bm.class.getResourceAsStream(string2);){
            if (inputStream == null) {
                throw new IllegalStateException("missing native shader bridge class");
            }
            clazz = isolatedClassLoader.defineClass("dev.lone.itemsadder.resourcepack.NativeGlslangBridge", inputStream);
        }
        return clazz.getMethod("validate", String[].class, String[].class);
    }

    private static Library am(String string, String string2) {
        Library.Builder builder = Library.builder().groupId("org.lwjgl").artifactId(string).version("3.4.1").resolveTransitiveDependencies(false).loaderId("itemsadder-shader-validator").isolatedLoad(true);
        if (string2 != null) {
            builder.classifier(string2);
        }
        return builder.build();
    }

    private static String Au() {
        boolean bl;
        String string = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
        String string2 = System.getProperty("os.arch", "").toLowerCase(Locale.ROOT);
        boolean bl2 = string2.equals("aarch64") || string2.equals("arm64");
        boolean bl3 = bl = string2.equals("amd64") || string2.equals("x86_64") || string2.equals("x64");
        if (!bl2 && !bl) {
            throw new IllegalStateException("unsupported shader compiler architecture: " + string2);
        }
        if (string.contains("linux")) {
            return bl2 ? "natives-linux-arm64" : "natives-linux";
        }
        if (string.contains("win")) {
            return bl2 ? "natives-windows-arm64" : "natives-windows";
        }
        if (string.contains("mac") || string.contains("darwin")) {
            return bl2 ? "natives-macos-arm64" : "natives-macos";
        }
        throw new IllegalStateException("unsupported shader compiler operating system: " + string);
    }

    private static /* synthetic */ bv[] Av() {
        return new bv[]{INSTANCE};
    }

    static {
        $VALUES = bv.Av();
    }
}
