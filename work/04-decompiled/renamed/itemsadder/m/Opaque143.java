package itemsadder.m;

import itemsadder.m.Opaque144;
import itemsadder.m.PluginContract_4;
import java.util.HashMap;
import java.util.Map;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

public class Opaque143
extends ForwardingJavaFileManager {
    private final Map Nx = new HashMap();

    protected Opaque143(JavaFileManager javaFileManager) {
        super(javaFileManager);
    }

    @Override
    @PluginContract_4
    public JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String string, JavaFileObject.Kind kind, FileObject fileObject) {
        Opaque144 opaque144 = new Opaque144(string, kind);
        this.Nx.put(string, opaque144);
        return opaque144;
    }

    public Map rv() {
        HashMap<String, byte[]> hashMap = new HashMap<String, byte[]>();
        for (Opaque144 opaque144 : this.Nx.values()) {
            hashMap.put(opaque144.rw(), opaque144.getBytes());
        }
        return hashMap;
    }
}
