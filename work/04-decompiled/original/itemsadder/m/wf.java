package itemsadder.m;

import itemsadder.m.bcg;
import java.util.HashMap;
import java.util.Map;

public class wf
extends ClassLoader {
    private final Map Nw = new HashMap();

    public wf(Map map, ClassLoader classLoader) {
        super(classLoader);
        this.Nw.putAll(map);
    }

    @bcg
    protected Class findClass(String string) {
        byte[] byArray = (byte[])this.Nw.get(string);
        if (byArray == null) {
            System.err.println("[ItemsAdder] [MemoryClassLoader] Class not found in memory: " + string);
            System.err.println("[ItemsAdder] [MemoryClassLoader] Available classes: " + String.valueOf(this.Nw.keySet()));
            return super.findClass(string);
        }
        return this.defineClass(string, byArray, 0, byArray.length);
    }

    @bcg
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
