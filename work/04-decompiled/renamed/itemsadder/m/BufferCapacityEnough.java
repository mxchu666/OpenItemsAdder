package itemsadder.m;

import itemsadder.m.FluentBuilder_3;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque102;
import itemsadder.m.Opaque103;
import itemsadder.m.Opaque105;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.io.DataOutput;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class BufferCapacityEnough
extends Opaque105
implements PluginContract_12 {
    public static final int aFG = 4;
    public static final int aFH = 8;

    public BufferCapacityEnough(FluentBuilder_5 fluentBuilder_5) {
        super(fluentBuilder_5);
    }

    public BufferCapacityEnough(FluentBuilder_5 fluentBuilder_5, int n) {
        super(fluentBuilder_5, n);
    }

    public BufferCapacityEnough Gr() {
        super.Gs();
        return this;
    }

    @Override
    public void d(int n, int n2, boolean bl) {
        this.aGC = n2 < 0 ? BufferCapacityEnough.a(Opaque103.K(n, 0), (long)n2, (Opaque105)this, this.aGC) : BufferCapacityEnough.a(Opaque103.K(n, 0), n2, (Opaque105)this, this.aGC);
    }

    @Override
    public void g(int n, int n2, boolean bl) {
        this.aGC = BufferCapacityEnough.a(Opaque103.K(n, 0), n2, (Opaque105)this, this.aGC);
    }

    @Override
    public void f(int n, int n2, boolean bl) {
        this.aGC = BufferCapacityEnough.a(Opaque103.K(n, 0), BufferCapacityEnough.cy(n2), (Opaque105)this, this.aGC);
    }

    @Override
    public void c(int n, int n2, boolean bl) {
        this.aGC = BufferCapacityEnough.b(Opaque103.K(n, 5), n2, (Opaque105)this, this.aGC);
    }

    @Override
    public void e(int n, int n2, boolean bl) {
        this.aGC = BufferCapacityEnough.b(Opaque103.K(n, 5), n2, (Opaque105)this, this.aGC);
    }

    @Override
    public void b(int n, long l, boolean bl) {
        this.aGC = BufferCapacityEnough.a(Opaque103.K(n, 0), l, (Opaque105)this, this.aGC);
    }

    @Override
    public void e(int n, long l, boolean bl) {
        this.aGC = BufferCapacityEnough.a(Opaque103.K(n, 0), l, (Opaque105)this, this.aGC);
    }

    @Override
    public void d(int n, long l, boolean bl) {
        this.aGC = BufferCapacityEnough.a(Opaque103.K(n, 0), BufferCapacityEnough.s(l), (Opaque105)this, this.aGC);
    }

    @Override
    public void a(int n, long l, boolean bl) {
        this.aGC = BufferCapacityEnough.b(Opaque103.K(n, 1), l, (Opaque105)this, this.aGC);
    }

    @Override
    public void c(int n, long l, boolean bl) {
        this.aGC = BufferCapacityEnough.b(Opaque103.K(n, 1), l, (Opaque105)this, this.aGC);
    }

    @Override
    public void a(int n, float f, boolean bl) {
        this.aGC = BufferCapacityEnough.b(Opaque103.K(n, 5), Float.floatToRawIntBits(f), (Opaque105)this, this.aGC);
    }

    @Override
    public void a(int n, double d, boolean bl) {
        this.aGC = BufferCapacityEnough.b(Opaque103.K(n, 1), Double.doubleToRawLongBits(d), (Opaque105)this, this.aGC);
    }

    @Override
    public void a(int n, boolean bl, boolean bl2) {
        this.aGC = BufferCapacityEnough.a(Opaque103.K(n, 0), bl ? 1 : 0, (Opaque105)this, this.aGC);
    }

    @Override
    public void b(int n, int n2, boolean bl) {
        this.d(n, n2, bl);
    }

    @Override
    public void a(int n, CharSequence charSequence, boolean bl) {
        this.aGC = Opaque102.d(charSequence, this, BufferCapacityEnough.a(Opaque103.K(n, 2), this, this.aGC));
    }

    @Override
    public void a(int n, FluentBuilder_3 fluentBuilder_3, boolean bl) {
        this.a(n, fluentBuilder_3.getBytes(), bl);
    }

    @Override
    public void a(int n, byte[] byArray, boolean bl) {
        this.aGC = BufferCapacityEnough.a(Opaque103.K(n, 2), byArray, 0, byArray.length, this, this.aGC);
    }

    @Override
    public void a(boolean bl, int n, byte[] byArray, int n2, int n3, boolean bl2) {
        this.aGC = BufferCapacityEnough.a(Opaque103.K(n, 2), byArray, n2, n3, this, this.aGC);
    }

    @Override
    public void a(int n, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        FluentBuilder_5 fluentBuilder_5;
        if (n < 16 && this.aGC.offset != this.aGC.aFs.length) {
            fluentBuilder_5 = this.aGC;
            ++this.tK;
            fluentBuilder_5.aFs[fluentBuilder_5.offset++] = (byte)Opaque103.K(n, 2);
        } else {
            this.aGC = fluentBuilder_5 = BufferCapacityEnough.a(Opaque103.K(n, 2), this, this.aGC);
        }
        int n2 = this.aGC.offset;
        int n3 = this.tK++;
        if (n2 == fluentBuilder_5.aFs.length) {
            FluentBuilder_5 fluentBuilder_52;
            this.aGC = fluentBuilder_52 = new FluentBuilder_5(this.aGD);
            pluginContract_14.a(this, object);
            int n4 = this.tK - n3;
            byte[] byArray = new byte[BufferCapacityEnough.cx(n4)];
            BufferCapacityEnough.f(n4, byArray, 0);
            this.tK += byArray.length;
            new FluentBuilder_5((byte[])byArray, (int)0, (int)byArray.length, (FluentBuilder_5)fluentBuilder_5).aFu = fluentBuilder_52;
            return;
        }
        ++fluentBuilder_5.offset;
        pluginContract_14.a(this, object);
        int n5 = this.tK - n3 - 1;
        if (n5 < 128) {
            fluentBuilder_5.aFs[n2] = (byte)n5;
            return;
        }
        FluentBuilder_5 fluentBuilder_53 = new FluentBuilder_5(fluentBuilder_5.aFs, n2 + 1, fluentBuilder_5.offset);
        if (fluentBuilder_5 == this.aGC) {
            this.aGC = fluentBuilder_53;
        } else {
            fluentBuilder_53.aFu = fluentBuilder_5.aFu;
        }
        fluentBuilder_5.offset = n2;
        byte[] byArray = new byte[BufferCapacityEnough.cx(n5)];
        BufferCapacityEnough.f(n5, byArray, 0);
        this.tK += byArray.length - 1;
        new FluentBuilder_5((byte[])byArray, (int)0, (int)byArray.length, (FluentBuilder_5)fluentBuilder_5).aFu = fluentBuilder_53;
    }

    public static FluentBuilder_5 a(int n, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n2 = BufferCapacityEnough.cx(n);
        if (fluentBuilder_5.offset + n2 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
        }
        byte[] byArray = fluentBuilder_5.aFs;
        int n3 = fluentBuilder_5.offset;
        fluentBuilder_5.offset += n2;
        opaque105.tK += n2;
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
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 a(int n, FluentBuilder_5 fluentBuilder_5, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_52) {
        int n2 = fluentBuilder_5.offset - fluentBuilder_5.aFt;
        if (n2 == 0) {
            return BufferCapacityEnough.a(n, n2, opaque105, fluentBuilder_52);
        }
        fluentBuilder_52 = BufferCapacityEnough.a(n, n2, opaque105, fluentBuilder_52);
        fluentBuilder_52.aFu = fluentBuilder_5;
        int n3 = fluentBuilder_52.aFs.length - fluentBuilder_52.offset;
        return n3 == 0 ? new FluentBuilder_5(opaque105.aGD, fluentBuilder_5) : new FluentBuilder_5(fluentBuilder_52, fluentBuilder_5);
    }

    public static FluentBuilder_5 a(int n, byte[] byArray, int n2, int n3, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        if (n3 == 0) {
            return BufferCapacityEnough.a(n, n3, opaque105, fluentBuilder_5);
        }
        fluentBuilder_5 = BufferCapacityEnough.a(n, n3, opaque105, fluentBuilder_5);
        opaque105.tK += n3;
        int n4 = fluentBuilder_5.aFs.length - fluentBuilder_5.offset;
        if (n3 > n4) {
            if (n4 + opaque105.aGD < n3) {
                if (n4 == 0) {
                    return new FluentBuilder_5(opaque105.aGD, new FluentBuilder_5(byArray, n2, n2 + n3, fluentBuilder_5));
                }
                return new FluentBuilder_5(fluentBuilder_5, new FluentBuilder_5(byArray, n2, n2 + n3, fluentBuilder_5));
            }
            System.arraycopy(byArray, n2, fluentBuilder_5.aFs, fluentBuilder_5.offset, n4);
            fluentBuilder_5.offset += n4;
            fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
            int n5 = n3 - n4;
            System.arraycopy(byArray, n2 + n4, fluentBuilder_5.aFs, 0, n5);
            fluentBuilder_5.offset += n5;
            return fluentBuilder_5;
        }
        System.arraycopy(byArray, n2, fluentBuilder_5.aFs, fluentBuilder_5.offset, n3);
        fluentBuilder_5.offset += n3;
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 a(int n, int n2, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n3;
        int n4;
        int n5;
        int n6 = BufferCapacityEnough.cx(n);
        int n7 = n6 + (n5 = BufferCapacityEnough.cx(n2));
        if (fluentBuilder_5.offset + n7 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
        }
        byte[] byArray = fluentBuilder_5.aFs;
        int n8 = fluentBuilder_5.offset;
        fluentBuilder_5.offset += n7;
        opaque105.tK += n7;
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
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 a(int n, long l, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n2;
        int n3;
        int n4;
        int n5 = BufferCapacityEnough.cx(n);
        int n6 = n5 + (n4 = BufferCapacityEnough.r(l));
        if (fluentBuilder_5.offset + n6 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
        }
        byte[] byArray = fluentBuilder_5.aFs;
        int n7 = fluentBuilder_5.offset;
        fluentBuilder_5.offset += n6;
        opaque105.tK += n6;
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
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 b(int n, int n2, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n3 = BufferCapacityEnough.cx(n);
        int n4 = n3 + 4;
        if (fluentBuilder_5.offset + n4 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
        }
        byte[] byArray = fluentBuilder_5.aFs;
        int n5 = fluentBuilder_5.offset;
        fluentBuilder_5.offset += n4;
        opaque105.tK += n4;
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
        BufferCapacityEnough.g(n2, byArray, n5);
        return fluentBuilder_5;
    }

    public static FluentBuilder_5 b(int n, long l, Opaque105 opaque105, FluentBuilder_5 fluentBuilder_5) {
        int n2 = BufferCapacityEnough.cx(n);
        int n3 = n2 + 8;
        if (fluentBuilder_5.offset + n3 > fluentBuilder_5.aFs.length) {
            fluentBuilder_5 = new FluentBuilder_5(opaque105.aGD, fluentBuilder_5);
        }
        byte[] byArray = fluentBuilder_5.aFs;
        int n4 = fluentBuilder_5.offset;
        fluentBuilder_5.offset += n3;
        opaque105.tK += n3;
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
        BufferCapacityEnough.c(l, byArray, n4);
        return fluentBuilder_5;
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
        int n5 = BufferCapacityEnough.cx(n);
        int n6 = BufferCapacityEnough.cx(n2);
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
        int n4 = BufferCapacityEnough.cx(n);
        int n5 = BufferCapacityEnough.r(l);
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
        int n3 = BufferCapacityEnough.cx(n);
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
        BufferCapacityEnough.g(n2, byArray, n4);
        return byArray;
    }

    public static byte[] b(int n, long l) {
        int n2 = BufferCapacityEnough.cx(n);
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
        BufferCapacityEnough.c(l, byArray, n3);
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
        int n2 = BufferCapacityEnough.cx(n);
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
    public /* synthetic */ Opaque105 Gs() {
        return this.Gr();
    }
}
