package itemsadder.m;

import java.io.DataOutput;
import java.io.OutputStream;

public final class FluentBuilder_5 {
    public static final int aFq = 256;
    public static final int aFr = 512;
    final byte[] aFs;
    final int aFt;
    int offset;
    FluentBuilder_5 aFu;

    public static FluentBuilder_5 Gd() {
        return new FluentBuilder_5(512);
    }

    public static FluentBuilder_5 cv(int n) {
        if (n < 256) {
            throw new IllegalArgumentException("256 is the minimum buffer size.");
        }
        return new FluentBuilder_5(n);
    }

    public static FluentBuilder_5 a(int n, FluentBuilder_5 fluentBuilder_5) {
        if (n < 256) {
            throw new IllegalArgumentException("256 is the minimum buffer size.");
        }
        return new FluentBuilder_5(n, fluentBuilder_5);
    }

    public static FluentBuilder_5 i(byte[] byArray, int n, int n2) {
        return new FluentBuilder_5(byArray, n, n + n2);
    }

    public static FluentBuilder_5 v(byte[] byArray) {
        return FluentBuilder_5.f(byArray, 0);
    }

    public static FluentBuilder_5 f(byte[] byArray, int n) {
        assert (n >= 0);
        if (byArray.length - n < 256) {
            throw new IllegalArgumentException("256 is the minimum buffer size.");
        }
        return new FluentBuilder_5(byArray, n, n);
    }

    public static int a(OutputStream outputStream, FluentBuilder_5 fluentBuilder_5) {
        int n = 0;
        do {
            int n2;
            if ((n2 = fluentBuilder_5.offset - fluentBuilder_5.aFt) <= 0) continue;
            outputStream.write(fluentBuilder_5.aFs, fluentBuilder_5.aFt, n2);
            n += n2;
        } while ((fluentBuilder_5 = fluentBuilder_5.aFu) != null);
        return n;
    }

    public static int a(DataOutput dataOutput, FluentBuilder_5 fluentBuilder_5) {
        int n = 0;
        do {
            int n2;
            if ((n2 = fluentBuilder_5.offset - fluentBuilder_5.aFt) <= 0) continue;
            dataOutput.write(fluentBuilder_5.aFs, fluentBuilder_5.aFt, n2);
            n += n2;
        } while ((fluentBuilder_5 = fluentBuilder_5.aFu) != null);
        return n;
    }

    FluentBuilder_5(int n) {
        this(new byte[n], 0, 0);
    }

    FluentBuilder_5(int n, FluentBuilder_5 fluentBuilder_5) {
        this(new byte[n], 0, 0, fluentBuilder_5);
    }

    FluentBuilder_5(byte[] byArray, int n) {
        this(byArray, n, n);
    }

    FluentBuilder_5(byte[] byArray, int n, int n2) {
        this.aFs = byArray;
        this.aFt = n;
        this.offset = n2;
    }

    FluentBuilder_5(byte[] byArray, int n, FluentBuilder_5 fluentBuilder_5) {
        this(byArray, n, n);
        fluentBuilder_5.aFu = this;
    }

    FluentBuilder_5(byte[] byArray, int n, int n2, FluentBuilder_5 fluentBuilder_5) {
        this(byArray, n, n2);
        fluentBuilder_5.aFu = this;
    }

    FluentBuilder_5(FluentBuilder_5 fluentBuilder_5, FluentBuilder_5 fluentBuilder_52) {
        this.aFs = fluentBuilder_5.aFs;
        this.offset = this.aFt = fluentBuilder_5.offset;
        fluentBuilder_52.aFu = this;
    }

    public FluentBuilder_5 Ge() {
        this.aFu = null;
        this.offset = this.aFt;
        return this;
    }
}
