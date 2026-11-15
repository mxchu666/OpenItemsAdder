package itemsadder.m;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;

public class fx {
    public final int uL;
    public final int uM;

    public fx(File file) {
        try (InputStream inputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);){
            if (inputStream.read() == 137 && inputStream.read() == 80 && inputStream.read() == 78) {
                inputStream.skip(15L);
                this.uM = fx.a(inputStream);
                inputStream.skip(2L);
                this.uL = fx.a(inputStream);
            } else {
                this.uM = 0;
                this.uL = 0;
            }
        }
    }

    private static int a(InputStream inputStream) {
        int n = 0;
        int n2 = 8;
        for (int i = 0; i < 2; ++i) {
            n |= inputStream.read() << n2;
            n2 -= 8;
        }
        return n;
    }
}
