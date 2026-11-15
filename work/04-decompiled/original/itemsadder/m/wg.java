package itemsadder.m;

import itemsadder.m.bcg;
import itemsadder.m.wh;
import java.util.HashMap;
import java.util.Map;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

public class wg
extends ForwardingJavaFileManager {
    private final Map Nx = new HashMap();

    protected wg(JavaFileManager javaFileManager) {
        super(javaFileManager);
    }

    @Override
    @bcg
    public JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String string, JavaFileObject.Kind kind, FileObject fileObject) {
        wh wh2 = new wh(string, kind);
        this.Nx.put(string, wh2);
        return wh2;
    }

    public Map rv() {
        HashMap<String, byte[]> hashMap = new HashMap<String, byte[]>();
        for (wh wh2 : this.Nx.values()) {
            hashMap.put(wh2.rw(), wh2.getBytes());
        }
        return hashMap;
    }
}
