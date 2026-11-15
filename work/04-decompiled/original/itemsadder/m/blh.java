package itemsadder.m;

import itemsadder.m.bjq;
import itemsadder.m.blf;
import itemsadder.m.bli;
import itemsadder.m.blj;

public abstract class blh
extends Enum {
    public static final /* enum */ blh BUFFERED = new bli();
    public static final /* enum */ blh STREAMED = new blj();
    private static final /* synthetic */ blh[] $VALUES;

    public static blh[] values() {
        return (blh[])$VALUES.clone();
    }

    public static blh valueOf(String string) {
        return Enum.valueOf(blh.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private blh() {
        void var2_-1;
        void var1_-1;
    }

    public abstract bjq a(blf var1, bjq var2);

    public final bjq a(byte[] byArray, blf blf2, bjq bjq2) {
        return this.c(byArray, 0, byArray.length, blf2, bjq2);
    }

    public abstract bjq c(byte[] var1, int var2, int var3, blf var4, bjq var5);

    public final bjq b(byte[] byArray, blf blf2, bjq bjq2) {
        return this.d(byArray, 0, byArray.length, blf2, bjq2);
    }

    public abstract bjq d(byte[] var1, int var2, int var3, blf var4, bjq var5);

    public abstract bjq a(byte var1, blf var2, bjq var3);

    public abstract bjq c(int var1, blf var2, bjq var3);

    public abstract bjq b(long var1, blf var3, bjq var4);

    public final bjq b(float f, blf blf2, bjq bjq2) {
        return this.c(Float.floatToRawIntBits(f), blf2, bjq2);
    }

    public final bjq b(double d, blf blf2, bjq bjq2) {
        return this.b(Double.doubleToRawLongBits(d), blf2, bjq2);
    }

    public abstract bjq d(int var1, blf var2, bjq var3);

    public abstract bjq e(int var1, blf var2, bjq var3);

    public abstract bjq f(int var1, blf var2, bjq var3);

    public abstract bjq c(long var1, blf var3, bjq var4);

    public final bjq c(float f, blf blf2, bjq bjq2) {
        return this.f(Float.floatToRawIntBits(f), blf2, bjq2);
    }

    public final bjq c(double d, blf blf2, bjq bjq2) {
        return this.c(Double.doubleToRawLongBits(d), blf2, bjq2);
    }

    public abstract bjq g(int var1, blf var2, bjq var3);

    public abstract bjq d(long var1, blf var3, bjq var4);

    public abstract bjq h(int var1, blf var2, bjq var3);

    public abstract bjq e(long var1, blf var3, bjq var4);

    public abstract bjq d(float var1, blf var2, bjq var3);

    public abstract bjq d(double var1, blf var3, bjq var4);

    public abstract bjq e(CharSequence var1, blf var2, bjq var3);

    public abstract bjq f(CharSequence var1, blf var2, bjq var3);

    public abstract bjq g(CharSequence var1, blf var2, bjq var3);

    public abstract bjq b(CharSequence var1, boolean var2, blf var3, bjq var4);

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    /* synthetic */ blh(bli bli2) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    static {
        $VALUES = new blh[]{BUFFERED, STREAMED};
    }
}
