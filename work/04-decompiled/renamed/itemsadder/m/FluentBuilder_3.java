package itemsadder.m;

import itemsadder.m.PluginContract_12;
import itemsadder.m.UTF8_3;
import java.io.DataOutput;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class FluentBuilder_3 {
    private final byte[] aEG;
    public static final String aEH = "";
    public static final byte[] aEI = new byte[0];
    public static final FluentBuilder_3 aEJ = new FluentBuilder_3(aEI);
    private volatile int BP = 0;

    static FluentBuilder_3 q(byte[] byArray) {
        return new FluentBuilder_3(byArray);
    }

    byte[] getBytes() {
        return this.aEG;
    }

    public static void a(OutputStream outputStream, FluentBuilder_3 fluentBuilder_3) {
        outputStream.write(fluentBuilder_3.aEG);
    }

    public static void a(DataOutput dataOutput, FluentBuilder_3 fluentBuilder_3) {
        dataOutput.write(fluentBuilder_3.aEG);
    }

    public static void a(PluginContract_12 pluginContract_12, FluentBuilder_3 fluentBuilder_3, int n, boolean bl) {
        pluginContract_12.a(n, fluentBuilder_3.aEG, bl);
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.size());
    }

    private FluentBuilder_3(byte[] byArray) {
        this.aEG = byArray;
    }

    public byte ce(int n) {
        return this.aEG[n];
    }

    public int size() {
        return this.aEG.length;
    }

    public boolean isEmpty() {
        return this.aEG.length == 0;
    }

    public static FluentBuilder_3 e(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, n, byArray2, 0, n2);
        return new FluentBuilder_3(byArray2);
    }

    public static FluentBuilder_3 r(byte[] byArray) {
        return FluentBuilder_3.e(byArray, 0, byArray.length);
    }

    public static FluentBuilder_3 aK(String string, String string2) {
        try {
            return new FluentBuilder_3(string.getBytes(string2));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(string2 + " not supported?", unsupportedEncodingException);
        }
    }

    public static FluentBuilder_3 jw(String string) {
        return new FluentBuilder_3(UTF8_3.jA(string));
    }

    public void e(byte[] byArray, int n) {
        System.arraycopy(this.aEG, 0, byArray, n, this.aEG.length);
    }

    public void a(byte[] byArray, int n, int n2, int n3) {
        System.arraycopy(this.aEG, n, byArray, n2, n3);
    }

    public byte[] FO() {
        int n = this.aEG.length;
        byte[] byArray = new byte[n];
        System.arraycopy(this.aEG, 0, byArray, 0, n);
        return byArray;
    }

    public ByteBuffer FP() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(this.aEG);
        return byteBuffer.asReadOnlyBuffer();
    }

    public String FQ() {
        return UTF8_3.x(this.aEG);
    }

    public boolean equals(Object object) {
        return object == this || object instanceof FluentBuilder_3 && FluentBuilder_3.a(this, (FluentBuilder_3)object, false);
    }

    public static boolean a(FluentBuilder_3 fluentBuilder_3, FluentBuilder_3 fluentBuilder_32, boolean bl) {
        int n = fluentBuilder_3.aEG.length;
        if (n != fluentBuilder_32.aEG.length) {
            return false;
        }
        if (bl) {
            int n2 = fluentBuilder_3.BP;
            int n3 = fluentBuilder_32.BP;
            if (n2 != 0 && n3 != 0 && n2 != n3) {
                return false;
            }
        }
        byte[] byArray = fluentBuilder_3.aEG;
        byte[] byArray2 = fluentBuilder_32.aEG;
        for (int i = 0; i < n; ++i) {
            if (byArray[i] == byArray2[i]) continue;
            return false;
        }
        return true;
    }

    public boolean s(byte[] byArray) {
        return this.f(byArray, 0, byArray.length);
    }

    public boolean f(byte[] byArray, int n, int n2) {
        byte[] byArray2 = this.aEG;
        if (n2 != byArray2.length) {
            return false;
        }
        int n3 = 0;
        while (n3 < n2) {
            if (byArray2[n3++] == byArray[n++]) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        int n = this.BP;
        if (n == 0) {
            int n2;
            byte[] byArray = this.aEG;
            n = n2 = this.aEG.length;
            for (int i = 0; i < n2; ++i) {
                n = n * 31 + byArray[i];
            }
            if (n == 0) {
                n = 1;
            }
            this.BP = n;
        }
        return n;
    }

    public static String jx(String string) {
        try {
            return new String(string.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new IllegalStateException("Java VM does not support a standard character set.", unsupportedEncodingException);
        }
    }

    public static FluentBuilder_3 jy(String string) {
        return new FluentBuilder_3(FluentBuilder_3.jz(string));
    }

    public static byte[] jz(String string) {
        try {
            return string.getBytes("ISO-8859-1");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new IllegalStateException("Java VM does not support a standard character set.", unsupportedEncodingException);
        }
    }
}
