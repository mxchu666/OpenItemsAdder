package itemsadder.m;

import java.io.DataOutput;
import java.io.OutputStream;

public final class bjq {
    public static final int aFq = 256;
    public static final int aFr = 512;
    final byte[] aFs;
    final int aFt;
    int offset;
    bjq aFu;

    public static bjq Gd() {
        return new bjq(512);
    }

    public static bjq cv(int n) {
        if (n < 256) {
            throw new IllegalArgumentException("256 is the minimum buffer size.");
        }
        return new bjq(n);
    }

    public static bjq a(int n, bjq bjq2) {
        if (n < 256) {
            throw new IllegalArgumentException("256 is the minimum buffer size.");
        }
        return new bjq(n, bjq2);
    }

    public static bjq i(byte[] byArray, int n, int n2) {
        return new bjq(byArray, n, n + n2);
    }

    public static bjq v(byte[] byArray) {
        return bjq.f(byArray, 0);
    }

    public static bjq f(byte[] byArray, int n) {
        assert (n >= 0);
        if (byArray.length - n < 256) {
            throw new IllegalArgumentException("256 is the minimum buffer size.");
        }
        return new bjq(byArray, n, n);
    }

    public static int a(OutputStream outputStream, bjq bjq2) {
        int n = 0;
        do {
            int n2;
            if ((n2 = bjq2.offset - bjq2.aFt) <= 0) continue;
            outputStream.write(bjq2.aFs, bjq2.aFt, n2);
            n += n2;
        } while ((bjq2 = bjq2.aFu) != null);
        return n;
    }

    public static int a(DataOutput dataOutput, bjq bjq2) {
        int n = 0;
        do {
            int n2;
            if ((n2 = bjq2.offset - bjq2.aFt) <= 0) continue;
            dataOutput.write(bjq2.aFs, bjq2.aFt, n2);
            n += n2;
        } while ((bjq2 = bjq2.aFu) != null);
        return n;
    }

    bjq(int n) {
        this(new byte[n], 0, 0);
    }

    bjq(int n, bjq bjq2) {
        this(new byte[n], 0, 0, bjq2);
    }

    bjq(byte[] byArray, int n) {
        this(byArray, n, n);
    }

    bjq(byte[] byArray, int n, int n2) {
        this.aFs = byArray;
        this.aFt = n;
        this.offset = n2;
    }

    bjq(byte[] byArray, int n, bjq bjq2) {
        this(byArray, n, n);
        bjq2.aFu = this;
    }

    bjq(byte[] byArray, int n, int n2, bjq bjq2) {
        this(byArray, n, n2);
        bjq2.aFu = this;
    }

    bjq(bjq bjq2, bjq bjq3) {
        this.aFs = bjq2.aFs;
        this.offset = this.aFt = bjq2.offset;
        bjq3.aFu = this;
    }

    public bjq Ge() {
        this.aFu = null;
        this.offset = this.aFt;
        return this;
    }
}
