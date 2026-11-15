package itemsadder.m;

import itemsadder.m.CodedInputEncounteredEmbedded;
import itemsadder.m.FluentBuilder_3;
import itemsadder.m.Opaque103;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import itemsadder.m.RuntimeError_3;
import itemsadder.m.UTF8_3;
import java.nio.ByteBuffer;

public final class FluentBuilderBuilder
implements PluginContract_11 {
    private final byte[] aEz;
    private int offset;
    private int aEA;
    private int aEB = 0;
    private int aEC = 0;
    public final boolean aED;

    public FluentBuilderBuilder(byte[] byArray, boolean bl) {
        this(byArray, 0, byArray.length, bl);
    }

    public FluentBuilderBuilder(byte[] byArray, int n, int n2, boolean bl) {
        this.aEz = byArray;
        this.offset = n;
        this.aEA = n + n2;
        this.aED = bl;
    }

    public FluentBuilderBuilder D(int n, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("length cannot be negative.");
        }
        this.offset = n;
        this.aEA = n + n2;
        this.aEC = 0;
        return this;
    }

    public FluentBuilderBuilder E(int n, int n2) {
        this.offset = n;
        this.aEA = n2;
        this.aEC = 0;
        return this;
    }

    public int Fl() {
        return this.offset;
    }

    public int Fm() {
        return this.aEA;
    }

    public boolean Fn() {
        return this.aEC != 0 && this.aEC != this.offset;
    }

    public int Fo() {
        return this.aEB;
    }

    public int Fp() {
        if (this.offset == this.aEA) {
            this.aEB = 0;
            return 0;
        }
        int n = this.FJ();
        if (n >>> 3 == 0) {
            throw CodedInputEncounteredEmbedded.Gm();
        }
        this.aEB = n;
        return n;
    }

    public void cc(int n) {
        if (this.aEB != n) {
            throw CodedInputEncounteredEmbedded.Gn();
        }
    }

    public boolean cd(int n) {
        switch (Opaque103.cF(n)) {
            case 0: {
                this.Fw();
                return true;
            }
            case 1: {
                this.FM();
                return true;
            }
            case 2: {
                int n2 = this.FJ();
                if (n2 < 0) {
                    throw CodedInputEncounteredEmbedded.Gk();
                }
                this.offset += n2;
                return true;
            }
            case 3: {
                this.Fq();
                this.cc(Opaque103.K(Opaque103.cG(n), 4));
                return true;
            }
            case 4: {
                return false;
            }
            case 5: {
                this.FL();
                return true;
            }
        }
        throw CodedInputEncounteredEmbedded.Go();
    }

    public void Fq() {
        int n;
        while ((n = this.Fp()) != 0 && this.cd(n)) {
        }
    }

    @Override
    public void a(int n, PluginContract_14 pluginContract_14) {
        this.cd(this.aEB);
    }

    @Override
    public int a(PluginContract_14 pluginContract_14) {
        if (this.offset == this.aEA) {
            this.aEB = 0;
            return 0;
        }
        if (this.Fn()) {
            if (this.aEC < this.offset) {
                throw CodedInputEncounteredEmbedded.Gj();
            }
            return this.aEB >>> 3;
        }
        this.aEC = 0;
        int n = this.FJ();
        int n2 = n >>> 3;
        if (n2 == 0) {
            if (this.aED && 7 == (n & 7)) {
                this.aEB = 0;
                return 0;
            }
            throw CodedInputEncounteredEmbedded.Gm();
        }
        if (this.aED && 4 == (n & 7)) {
            this.aEB = 0;
            return 0;
        }
        this.aEB = n;
        return n2;
    }

    private void Fr() {
        if (this.aEC == 0 && Opaque103.cF(this.aEB) == 2) {
            int n = this.FJ();
            if (n < 0) {
                throw CodedInputEncounteredEmbedded.Gk();
            }
            if (this.offset + n > this.aEA) {
                throw CodedInputEncounteredEmbedded.Gj();
            }
            this.aEC = this.offset + n;
        }
    }

    @Override
    public double Fs() {
        this.Fr();
        return Double.longBitsToDouble(this.FM());
    }

    @Override
    public float Ft() {
        this.Fr();
        return Float.intBitsToFloat(this.FL());
    }

    @Override
    public long Fu() {
        this.Fr();
        return this.FK();
    }

    @Override
    public long Fv() {
        this.Fr();
        return this.FK();
    }

    @Override
    public int Fw() {
        this.Fr();
        return this.FJ();
    }

    @Override
    public long Fx() {
        this.Fr();
        return this.FM();
    }

    @Override
    public int Fy() {
        this.Fr();
        return this.FL();
    }

    @Override
    public boolean Fz() {
        this.Fr();
        return this.aEz[this.offset++] != 0;
    }

    @Override
    public int FA() {
        this.Fr();
        return this.FJ();
    }

    @Override
    public int FB() {
        this.Fr();
        return this.FJ();
    }

    @Override
    public int FC() {
        this.Fr();
        return this.FL();
    }

    @Override
    public long FD() {
        this.Fr();
        return this.FM();
    }

    @Override
    public int FE() {
        this.Fr();
        int n = this.FJ();
        return n >>> 1 ^ -(n & 1);
    }

    @Override
    public long FF() {
        this.Fr();
        long l = this.FK();
        return l >>> 1 ^ -(l & 1L);
    }

    @Override
    public String FG() {
        int n = this.FJ();
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (this.offset + n > this.aEA) {
            throw CodedInputEncounteredEmbedded.Gj();
        }
        int n2 = this.offset;
        this.offset += n;
        return UTF8_3.k(this.aEz, n2, n);
    }

    @Override
    public FluentBuilder_3 FH() {
        return FluentBuilder_3.q(this.FI());
    }

    @Override
    public void a(ByteBuffer byteBuffer) {
        int n = this.FJ();
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (this.offset + n > this.aEA) {
            throw CodedInputEncounteredEmbedded.Gj();
        }
        byteBuffer.put(this.aEz, this.offset, n);
        this.offset += n;
    }

    @Override
    public byte[] FI() {
        int n = this.FJ();
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (this.offset + n > this.aEA) {
            throw CodedInputEncounteredEmbedded.Gj();
        }
        byte[] byArray = new byte[n];
        System.arraycopy(this.aEz, this.offset, byArray, 0, n);
        this.offset += n;
        return byArray;
    }

    @Override
    public Object a(Object object, PluginContract_14 pluginContract_14) {
        if (this.aED) {
            return this.b(object, pluginContract_14);
        }
        int n = this.FJ();
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        int n2 = this.aEA;
        this.aEA = this.offset + n;
        if (object == null) {
            object = pluginContract_14.wi();
        }
        pluginContract_14.a(this, object);
        if (!pluginContract_14.r(object)) {
            throw new RuntimeError_3(object, pluginContract_14);
        }
        this.cc(0);
        this.aEA = n2;
        return object;
    }

    private Object b(Object object, PluginContract_14 pluginContract_14) {
        if (object == null) {
            object = pluginContract_14.wi();
        }
        pluginContract_14.a(this, object);
        if (!pluginContract_14.r(object)) {
            throw new RuntimeError_3(object, pluginContract_14);
        }
        this.cc(0);
        return object;
    }

    public int FJ() {
        byte by;
        if ((by = this.aEz[this.offset++]) >= 0) {
            return by;
        }
        int n = by & 0x7F;
        if ((by = this.aEz[this.offset++]) >= 0) {
            n |= by << 7;
        } else {
            n |= (by & 0x7F) << 7;
            if ((by = this.aEz[this.offset++]) >= 0) {
                n |= by << 14;
            } else {
                n |= (by & 0x7F) << 14;
                if ((by = this.aEz[this.offset++]) >= 0) {
                    n |= by << 21;
                } else {
                    n |= (by & 0x7F) << 21;
                    by = this.aEz[this.offset++];
                    n |= by << 28;
                    if (by < 0) {
                        for (int i = 0; i < 5; ++i) {
                            if (this.aEz[this.offset++] < 0) continue;
                            return n;
                        }
                        throw CodedInputEncounteredEmbedded.Gl();
                    }
                }
            }
        }
        return n;
    }

    public long FK() {
        byte[] byArray = this.aEz;
        int n = this.offset;
        long l = 0L;
        for (int i = 0; i < 64; i += 7) {
            byte by = byArray[n++];
            l |= (long)(by & 0x7F) << i;
            if ((by & 0x80) != 0) continue;
            this.offset = n;
            return l;
        }
        throw CodedInputEncounteredEmbedded.Gl();
    }

    public int FL() {
        byte[] byArray = this.aEz;
        int n = this.offset;
        byte by = byArray[n++];
        byte by2 = byArray[n++];
        byte by3 = byArray[n++];
        byte by4 = byArray[n++];
        this.offset = n;
        return by & 0xFF | (by2 & 0xFF) << 8 | (by3 & 0xFF) << 16 | (by4 & 0xFF) << 24;
    }

    public long FM() {
        byte[] byArray = this.aEz;
        int n = this.offset;
        byte by = byArray[n++];
        byte by2 = byArray[n++];
        byte by3 = byArray[n++];
        byte by4 = byArray[n++];
        byte by5 = byArray[n++];
        byte by6 = byArray[n++];
        byte by7 = byArray[n++];
        byte by8 = byArray[n++];
        this.offset = n;
        return (long)by & 0xFFL | ((long)by2 & 0xFFL) << 8 | ((long)by3 & 0xFFL) << 16 | ((long)by4 & 0xFFL) << 24 | ((long)by5 & 0xFFL) << 32 | ((long)by6 & 0xFFL) << 40 | ((long)by7 & 0xFFL) << 48 | ((long)by8 & 0xFFL) << 56;
    }

    @Override
    public void a(PluginContract_12 pluginContract_12, boolean bl, int n, boolean bl2) {
        int n2 = this.FJ();
        if (n2 < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        pluginContract_12.a(bl, n, this.aEz, this.offset, n2, bl2);
        this.offset += n2;
    }

    @Override
    public ByteBuffer FN() {
        return ByteBuffer.wrap(this.FI());
    }
}
