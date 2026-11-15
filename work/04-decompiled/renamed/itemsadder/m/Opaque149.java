package itemsadder.m;

import itemsadder.m.PluginContract_4;
import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

public class Opaque149
extends SimpleJavaFileObject {
    private final String Oh;

    public Opaque149(String string, String string2) {
        super(URI.create("string:///" + string.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
        this.Oh = string2;
    }

    @Override
    @PluginContract_4
    public CharSequence getCharContent(boolean bl) {
        return this.Oh;
    }
}
