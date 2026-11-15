package itemsadder.m;

import itemsadder.m.biy;
import itemsadder.m.bjq;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import itemsadder.m.bks;
import itemsadder.m.bkx;
import itemsadder.m.blf;
import java.io.DataOutput;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class bkf
extends blf
implements bjy {
    public static final int aFG = 4;
    public static final int aFH = 8;

    public bkf(bjq bjq2) {
        super(bjq2);
    }

    public bkf(bjq bjq2, int n) {
        super(bjq2, n);
    }

    public bkf Gr() {
        super.Gs();
        return this;
    }

    @Override
    public void d(int n, int n2, boolean bl) {
        this.aGC = n2 < 0 ? bkf.a(bkx.K(n, 0), (long)n2, (blf)this, this.aGC) : bkf.a(bkx.K(n, 0), n2, (blf)this, this.aGC);
    }

    @Override
    public void g(int n, int n2, boolean bl) {
        this.aGC = bkf.a(bkx.K(n, 0), n2, (blf)this, this.aGC);
    }

    @Override
    public void f(int n, int n2, boolean bl) {
        this.aGC = bkf.a(bkx.K(n, 0), bkf.cy(n2), (blf)this, this.aGC);
    }

    @Override
    public void c(int n, int n2, boolean bl) {
        this.aGC = bkf.b(bkx.K(n, 5), n2, (blf)this, this.aGC);
    }

    @Override
    public void e(int n, int n2, boolean bl) {
        this.aGC = bkf.b(bkx.K(n, 5), n2, (blf)this, this.aGC);
    }

    @Override
    public void b(int n, long l, boolean bl) {
        this.aGC = bkf.a(bkx.K(n, 0), l, (blf)this, this.aGC);
    }

    @Override
    public void e(int n, long l, boolean bl) {
        this.aGC = bkf.a(bkx.K(n, 0), l, (blf)this, this.aGC);
    }

    @Override
    public void d(int n, long l, boolean bl) {
        this.aGC = bkf.a(bkx.K(n, 0), bkf.s(l), (blf)this, this.aGC);
    }

    @Override
    public void a(int n, long l, boolean bl) {
        this.aGC = bkf.b(bkx.K(n, 1), l, (blf)this, this.aGC);
    }

    @Override
    public void c(int n, long l, boolean bl) {
        this.aGC = bkf.b(bkx.K(n, 1), l, (blf)this, this.aGC);
    }

    @Override
    public void a(int n, float f, boolean bl) {
        this.aGC = bkf.b(bkx.K(n, 5), Float.floatToRawIntBits(f), (blf)this, this.aGC);
    }

    @Override
    public void a(int n, double d, boolean bl) {
        this.aGC = bkf.b(bkx.K(n, 1), Double.doubleToRawLongBits(d), (blf)this, this.aGC);
    }

    @Override
    public void a(int n, boolean bl, boolean bl2) {
        this.aGC = bkf.a(bkx.K(n, 0), bl ? 1 : 0, (blf)this, this.aGC);
    }

    @Override
    public void b(int n, int n2, boolean bl) {
        this.d(n, n2, bl);
    }

    @Override
    public void a(int n, CharSequence charSequence, boolean bl) {
        this.aGC = bks.d(charSequence, this, bkf.a(bkx.K(n, 2), this, this.aGC));
    }

    @Override
    public void a(int n, biy biy2, boolean bl) {
        this.a(n, biy2.getBytes(), bl);
    }

    @Override
    public void a(int n, byte[] byArray, boolean bl) {
        this.aGC = bkf.a(bkx.K(n, 2), byArray, 0, byArray.length, this, this.aGC);
    }

    @Override
    public void a(boolean bl, int n, byte[] byArray, int n2, int n3, boolean bl2) {
        this.aGC = bkf.a(bkx.K(n, 2), byArray, n2, n3, this, this.aGC);
    }

    @Override
    public void a(int n, Object object, bko bko2, boolean bl) {
        bjq bjq2;
        if (n < 16 && this.aGC.offset != this.aGC.aFs.length) {
            bjq2 = this.aGC;
            ++this.tK;
            bjq2.aFs[bjq2.offset++] = (byte)bkx.K(n, 2);
        } else {
            this.aGC = bjq2 = bkf.a(bkx.K(n, 2), this, this.aGC);
        }
        int n2 = this.aGC.offset;
        int n3 = this.tK++;
        if (n2 == bjq2.aFs.length) {
            bjq bjq3;
            this.aGC = bjq3 = new bjq(this.aGD);
            bko2.a(this, object);
            int n4 = this.tK - n3;
            byte[] byArray = new byte[bkf.cx(n4)];
            bkf.f(n4, byArray, 0);
            this.tK += byArray.length;
            new bjq((byte[])byArray, (int)0, (int)byArray.length, (bjq)bjq2).aFu = bjq3;
            return;
        }
        ++bjq2.offset;
        bko2.a(this, object);
        int n5 = this.tK - n3 - 1;
        if (n5 < 128) {
            bjq2.aFs[n2] = (byte)n5;
            return;
        }
        bjq bjq4 = new bjq(bjq2.aFs, n2 + 1, bjq2.offset);
        if (bjq2 == this.aGC) {
            this.aGC = bjq4;
        } else {
            bjq4.aFu = bjq2.aFu;
        }
        bjq2.offset = n2;
        byte[] byArray = new byte[bkf.cx(n5)];
        bkf.f(n5, byArray, 0);
        this.tK += byArray.length - 1;
        new bjq((byte[])byArray, (int)0, (int)byArray.length, (bjq)bjq2).aFu = bjq4;
    }

    public static bjq a(int n, blf blf2, bjq bjq2) {
        int n2 = bkf.cx(n);
        if (bjq2.offset + n2 > bjq2.aFs.length) {
            bjq2 = new bjq(blf2.aGD, bjq2);
        }
        byte[] byArray = bjq2.aFs;
        int n3 = bjq2.offset;
        bjq2.offset += n2;
        blf2.tK += n2;
        if (n2 == 1) {
            byArray[n3] = (byte)n;
        } else {
            int n4 = 0;
            int n5 = n2 - 1;
            while (n4 < n5) {
                byArray[n3++] = (byte)(n & 0x7F | 0x80);
                ++n4;
                n >>>= 7;
            }
            byArray[n3] = (byte)n;
        }
        return bjq2;
    }

    public static bjq a(int n, bjq bjq2, blf blf2, bjq bjq3) {
        int n2 = bjq2.offset - bjq2.aFt;
        if (n2 == 0) {
            return bkf.a(n, n2, blf2, bjq3);
        }
        bjq3 = bkf.a(n, n2, blf2, bjq3);
        bjq3.aFu = bjq2;
        int n3 = bjq3.aFs.length - bjq3.offset;
        return n3 == 0 ? new bjq(blf2.aGD, bjq2) : new bjq(bjq3, bjq2);
    }

    public static bjq a(int n, byte[] byArray, int n2, int n3, blf blf2, bjq bjq2) {
        if (n3 == 0) {
            return bkf.a(n, n3, blf2, bjq2);
        }
        bjq2 = bkf.a(n, n3, blf2, bjq2);
        blf2.tK += n3;
        int n4 = bjq2.aFs.length - bjq2.offset;
        if (n3 > n4) {
            if (n4 + blf2.aGD < n3) {
                if (n4 == 0) {
                    return new bjq(blf2.aGD, new bjq(byArray, n2, n2 + n3, bjq2));
                }
                return new bjq(bjq2, new bjq(byArray, n2, n2 + n3, bjq2));
            }
            System.arraycopy(byArray, n2, bjq2.aFs, bjq2.offset, n4);
            bjq2.offset += n4;
            bjq2 = new bjq(blf2.aGD, bjq2);
            int n5 = n3 - n4;
            System.arraycopy(byArray, n2 + n4, bjq2.aFs, 0, n5);
            bjq2.offset += n5;
            return bjq2;
        }
        System.arraycopy(byArray, n2, bjq2.aFs, bjq2.offset, n3);
        bjq2.offset += n3;
        return bjq2;
    }

    public static bjq a(int n, int n2, blf blf2, bjq bjq2) {
        int n3;
        int n4;
        int n5;
        int n6 = bkf.cx(n);
        int n7 = n6 + (n5 = bkf.cx(n2));
        if (bjq2.offset + n7 > bjq2.aFs.length) {
            bjq2 = new bjq(blf2.aGD, bjq2);
        }
        byte[] byArray = bjq2.aFs;
        int n8 = bjq2.offset;
        bjq2.offset += n7;
        blf2.tK += n7;
        if (n6 == 1) {
            byArray[n8++] = (byte)n;
        } else {
            n4 = 0;
            n3 = n6 - 1;
            while (n4 < n3) {
                byArray[n8++] = (byte)(n & 0x7F | 0x80);
                ++n4;
                n >>>= 7;
            }
            byArray[n8++] = (byte)n;
        }
        if (n5 == 1) {
            byArray[n8] = (byte)n2;
        } else {
            n4 = 0;
            n3 = n5 - 1;
            while (n4 < n3) {
                byArray[n8++] = (byte)(n2 & 0x7F | 0x80);
                ++n4;
                n2 >>>= 7;
            }
            byArray[n8] = (byte)n2;
        }
        return bjq2;
    }

    public static bjq a(int n, long l, blf blf2, bjq bjq2) {
        int n2;
        int n3;
        int n4;
        int n5 = bkf.cx(n);
        int n6 = n5 + (n4 = bkf.r(l));
        if (bjq2.offset + n6 > bjq2.aFs.length) {
            bjq2 = new bjq(blf2.aGD, bjq2);
        }
        byte[] byArray = bjq2.aFs;
        int n7 = bjq2.offset;
        bjq2.offset += n6;
        blf2.tK += n6;
        if (n5 == 1) {
            byArray[n7++] = (byte)n;
        } else {
            n3 = 0;
            n2 = n5 - 1;
            while (n3 < n2) {
                byArray[n7++] = (byte)(n & 0x7F | 0x80);
                ++n3;
                n >>>= 7;
            }
            byArray[n7++] = (byte)n;
        }
        if (n4 == 1) {
            byArray[n7] = (byte)l;
        } else {
            n3 = 0;
            n2 = n4 - 1;
            while (n3 < n2) {
                byArray[n7++] = (byte)((int)l & 0x7F | 0x80);
                ++n3;
                l >>>= 7;
            }
            byArray[n7] = (byte)l;
        }
        return bjq2;
    }

    public static bjq b(int n, int n2, blf blf2, bjq bjq2) {
        int n3 = bkf.cx(n);
        int n4 = n3 + 4;
        if (bjq2.offset + n4 > bjq2.aFs.length) {
            bjq2 = new bjq(blf2.aGD, bjq2);
        }
        byte[] byArray = bjq2.aFs;
        int n5 = bjq2.offset;
        bjq2.offset += n4;
        blf2.tK += n4;
        if (n3 == 1) {
            byArray[n5++] = (byte)n;
        } else {
            int n6 = 0;
            int n7 = n3 - 1;
            while (n6 < n7) {
                byArray[n5++] = (byte)(n & 0x7F | 0x80);
                ++n6;
                n >>>= 7;
            }
            byArray[n5++] = (byte)n;
        }
        bkf.g(n2, byArray, n5);
        return bjq2;
    }

    public static bjq b(int n, long l, blf blf2, bjq bjq2) {
        int n2 = bkf.cx(n);
        int n3 = n2 + 8;
        if (bjq2.offset + n3 > bjq2.aFs.length) {
            bjq2 = new bjq(blf2.aGD, bjq2);
        }
        byte[] byArray = bjq2.aFs;
        int n4 = bjq2.offset;
        bjq2.offset += n3;
        blf2.tK += n3;
        if (n2 == 1) {
            byArray[n4++] = (byte)n;
        } else {
            int n5 = 0;
            int n6 = n2 - 1;
            while (n5 < n6) {
                byArray[n4++] = (byte)(n & 0x7F | 0x80);
                ++n5;
                n >>>= 7;
            }
            byArray[n4++] = (byte)n;
        }
        bkf.c(l, byArray, n4);
        return bjq2;
    }

    public static void f(int n, byte[] byArray, int n2) {
        while (true) {
            if ((n & 0xFFFFFF80) == 0) {
                byArray[n2] = (byte)n;
                return;
            }
            byArray[n2++] = (byte)(n & 0x7F | 0x80);
            n >>>= 7;
        }
    }

    public static void a(OutputStream outputStream, int n) {
        while (true) {
            if ((n & 0xFFFFFF80) == 0) {
                outputStream.write(n);
                return;
            }
            outputStream.write(n & 0x7F | 0x80);
            n >>>= 7;
        }
    }

    public static void a(DataOutput dataOutput, int n) {
        while (true) {
            if ((n & 0xFFFFFF80) == 0) {
                dataOutput.write(n);
                return;
            }
            dataOutput.write(n & 0x7F | 0x80);
            n >>>= 7;
        }
    }

    public static byte[] H(int n, int n2) {
        int n3;
        int n4;
        int n5 = bkf.cx(n);
        int n6 = bkf.cx(n2);
        int n7 = 0;
        byte[] byArray = new byte[n5 + n6];
        if (n5 == 1) {
            byArray[n7++] = (byte)n;
        } else {
            n4 = 0;
            n3 = n5 - 1;
            while (n4 < n3) {
                byArray[n7++] = (byte)(n & 0x7F | 0x80);
                ++n4;
                n >>>= 7;
            }
            byArray[n7++] = (byte)n;
        }
        if (n6 == 1) {
            byArray[n7] = (byte)n2;
        } else {
            n4 = 0;
            n3 = n6 - 1;
            while (n4 < n3) {
                byArray[n7++] = (byte)(n2 & 0x7F | 0x80);
                ++n4;
                n2 >>>= 7;
            }
            byArray[n7] = (byte)n2;
        }
        return byArray;
    }

    public static byte[] a(int n, long l) {
        int n2;
        int n3;
        int n4 = bkf.cx(n);
        int n5 = bkf.r(l);
        int n6 = 0;
        byte[] byArray = new byte[n4 + n5];
        if (n4 == 1) {
            byArray[n6++] = (byte)n;
        } else {
            n3 = 0;
            n2 = n4 - 1;
            while (n3 < n2) {
                byArray[n6++] = (byte)(n & 0x7F | 0x80);
                ++n3;
                n >>>= 7;
            }
            byArray[n6++] = (byte)n;
        }
        if (n5 == 1) {
            byArray[n6] = (byte)l;
        } else {
            n3 = 0;
            n2 = n5 - 1;
            while (n3 < n2) {
                byArray[n6++] = (byte)((int)l & 0x7F | 0x80);
                ++n3;
                l >>>= 7;
            }
            byArray[n6] = (byte)l;
        }
        return byArray;
    }

    public static byte[] I(int n, int n2) {
        int n3 = bkf.cx(n);
        int n4 = 0;
        byte[] byArray = new byte[n3 + 4];
        if (n3 == 1) {
            byArray[n4++] = (byte)n;
        } else {
            int n5 = 0;
            int n6 = n3 - 1;
            while (n5 < n6) {
                byArray[n4++] = (byte)(n & 0x7F | 0x80);
                ++n5;
                n >>>= 7;
            }
            byArray[n4++] = (byte)n;
        }
        bkf.g(n2, byArray, n4);
        return byArray;
    }

    public static byte[] b(int n, long l) {
        int n2 = bkf.cx(n);
        int n3 = 0;
        byte[] byArray = new byte[n2 + 8];
        if (n2 == 1) {
            byArray[n3++] = (byte)n;
        } else {
            int n4 = 0;
            int n5 = n2 - 1;
            while (n4 < n5) {
                byArray[n3++] = (byte)(n & 0x7F | 0x80);
                ++n4;
                n >>>= 7;
            }
            byArray[n3++] = (byte)n;
        }
        bkf.c(l, byArray, n3);
        return byArray;
    }

    public static int g(int n, byte[] byArray, int n2) {
        if (byArray.length - n2 < 4) {
            throw new IllegalArgumentException("buffer capacity not enough.");
        }
        byArray[n2++] = (byte)(n & 0xFF);
        byArray[n2++] = (byte)(n >> 8 & 0xFF);
        byArray[n2++] = (byte)(n >> 16 & 0xFF);
        byArray[n2] = (byte)(n >> 24 & 0xFF);
        return 4;
    }

    public static int c(long l, byte[] byArray, int n) {
        if (byArray.length - n < 8) {
            throw new IllegalArgumentException("buffer capacity not enough.");
        }
        byArray[n++] = (byte)(l & 0xFFL);
        byArray[n++] = (byte)(l >> 8 & 0xFFL);
        byArray[n++] = (byte)(l >> 16 & 0xFFL);
        byArray[n++] = (byte)(l >> 24 & 0xFFL);
        byArray[n++] = (byte)(l >> 32 & 0xFFL);
        byArray[n++] = (byte)(l >> 40 & 0xFFL);
        byArray[n++] = (byte)(l >> 48 & 0xFFL);
        byArray[n] = (byte)(l >> 56 & 0xFFL);
        return 8;
    }

    public static byte[] cw(int n) {
        int n2 = bkf.cx(n);
        if (n2 == 1) {
            return new byte[]{(byte)n};
        }
        int n3 = 0;
        byte[] byArray = new byte[n2];
        int n4 = 0;
        int n5 = n2 - 1;
        while (n4 < n5) {
            byArray[n3++] = (byte)(n & 0x7F | 0x80);
            ++n4;
            n >>>= 7;
        }
        byArray[n3] = (byte)n;
        return byArray;
    }

    public static int cx(int n) {
        if ((n & 0xFFFFFF80) == 0) {
            return 1;
        }
        if ((n & 0xFFFFC000) == 0) {
            return 2;
        }
        if ((n & 0xFFE00000) == 0) {
            return 3;
        }
        if ((n & 0xF0000000) == 0) {
            return 4;
        }
        return 5;
    }

    public static int r(long l) {
        if ((l & 0xFFFFFFFFFFFFFF80L) == 0L) {
            return 1;
        }
        if ((l & 0xFFFFFFFFFFFFC000L) == 0L) {
            return 2;
        }
        if ((l & 0xFFFFFFFFFFE00000L) == 0L) {
            return 3;
        }
        if ((l & 0xFFFFFFFFF0000000L) == 0L) {
            return 4;
        }
        if ((l & 0xFFFFFFF800000000L) == 0L) {
            return 5;
        }
        if ((l & 0xFFFFFC0000000000L) == 0L) {
            return 6;
        }
        if ((l & 0xFFFE000000000000L) == 0L) {
            return 7;
        }
        if ((l & 0xFF00000000000000L) == 0L) {
            return 8;
        }
        if ((l & Long.MIN_VALUE) == 0L) {
            return 9;
        }
        return 10;
    }

    public static int cy(int n) {
        return n << 1 ^ n >> 31;
    }

    public static long s(long l) {
        return l << 1 ^ l >> 63;
    }

    @Override
    public void a(int n, ByteBuffer byteBuffer, boolean bl) {
        this.a(false, n, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), bl);
    }

    @Override
    public /* synthetic */ blf Gs() {
        return this.Gr();
    }
}
