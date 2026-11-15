package itemsadder.m;

import itemsadder.m.PluginContract_4;
import java.util.HashMap;
import java.util.Map;

public class Opaque142
extends ClassLoader {
    private final Map Nw = new HashMap();

    public Opaque142(Map map, ClassLoader classLoader) {
        super(classLoader);
        this.Nw.putAll(map);
    }

    @PluginContract_4
    protected Class findClass(String string) {
        byte[] byArray = (byte[])this.Nw.get(string);
        if (byArray == null) {
            System.err.println("[ItemsAdder] [MemoryClassLoader] Class not found in memory: " + string);
            System.err.println("[ItemsAdder] [MemoryClassLoader] Available classes: " + String.valueOf(this.Nw.keySet()));
            return super.findClass(string);
        }
        return this.defineClass(string, byArray, 0, byArray.length);
    }

    @PluginContract_4
    public Class loadClass(String string, boolean bl) {
        if (this.Nw.containsKey(string)) {
            byte[] byArray = (byte[])this.Nw.get(string);
            Class<?> clazz = this.defineClass(string, byArray, 0, byArray.length);
            if (bl) {
                this.resolveClass(clazz);
            }
            return clazz;
        }
        return super.loadClass(string, bl);
    }
}
