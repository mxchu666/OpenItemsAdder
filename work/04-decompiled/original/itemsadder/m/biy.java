package itemsadder.m;

import itemsadder.m.bjy;
import itemsadder.m.bkt;
import java.io.DataOutput;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class biy {
    private final byte[] aEG;
    public static final String aEH = "";
    public static final byte[] aEI = new byte[0];
    public static final biy aEJ = new biy(aEI);
    private volatile int BP = 0;

    static biy q(byte[] byArray) {
        return new biy(byArray);
    }

    byte[] getBytes() {
        return this.aEG;
    }

    public static void a(OutputStream outputStream, biy biy2) {
        outputStream.write(biy2.aEG);
    }

    public static void a(DataOutput dataOutput, biy biy2) {
        dataOutput.write(biy2.aEG);
    }

    public static void a(bjy bjy2, biy biy2, int n, boolean bl) {
        bjy2.a(n, biy2.aEG, bl);
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.size());
    }

    private biy(byte[] byArray) {
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

    public static biy e(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, n, byArray2, 0, n2);
        return new biy(byArray2);
    }

    public static biy r(byte[] byArray) {
        return biy.e(byArray, 0, byArray.length);
    }

    public static biy aK(String string, String string2) {
        try {
            return new biy(string.getBytes(string2));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(string2 + " not supported?", unsupportedEncodingException);
        }
    }

    public static biy jw(String string) {
        return new biy(bkt.jA(string));
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
        return bkt.x(this.aEG);
    }

    public boolean equals(Object object) {
        return object == this || object instanceof biy && biy.a(this, (biy)object, false);
    }

    public static boolean a(biy biy2, biy biy3, boolean bl) {
        int n = biy2.aEG.length;
        if (n != biy3.aEG.length) {
            return false;
        }
        if (bl) {
            int n2 = biy2.BP;
            int n3 = biy3.BP;
            if (n2 != 0 && n3 != 0 && n2 != n3) {
                return false;
            }
        }
        byte[] byArray = biy2.aEG;
        byte[] byArray2 = biy3.aEG;
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

    public static biy jy(String string) {
        return new biy(biy.jz(string));
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
