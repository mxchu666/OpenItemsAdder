package itemsadder.m;

import itemsadder.m.bcg;
import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

public class ws
extends SimpleJavaFileObject {
    private final String Oh;

    public ws(String string, String string2) {
        super(URI.create("string:///" + string.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
        this.Oh = string2;
    }

    @Override
    @bcg
    public CharSequence getCharContent(boolean bl) {
        return this.Oh;
    }
}
