package itemsadder.m;

import java.io.File;
import java.nio.charset.StandardCharsets;

public interface baq {
    default public void b(int n, String string, String string2) {
        this.a(n, string != null ? string.getBytes(StandardCharsets.UTF_8) : null, string2);
    }

    public void a(int var1, byte[] var2, String var3);

    public void a(File var1, String var2, Runnable var3, Runnable var4);
}
