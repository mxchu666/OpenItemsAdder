package itemsadder.m;

import itemsadder.m.bcg;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

public class wh
extends SimpleJavaFileObject {
    private final ByteArrayOutputStream Ny = new ByteArrayOutputStream();
    private final String Nz;

    public wh(String string, JavaFileObject.Kind kind) {
        super(URI.create("string:///" + string.replace('.', '/') + kind.extension), kind);
        this.Nz = string;
    }

    @Override
    @bcg
    public OutputStream openOutputStream() {
        return this.Ny;
    }

    public byte[] getBytes() {
        return this.Ny.toByteArray();
    }

    public String rw() {
        return this.Nz;
    }
}
