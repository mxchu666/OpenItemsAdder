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

public final class PluginContractImpl
implements PluginContract_11 {
    private final ByteBuffer aEE;
    private int aEB = 0;
    private int aEC = 0;
    public final boolean aEF;

    public PluginContractImpl(ByteBuffer byteBuffer, boolean bl) {
        this.aEE = byteBuffer.slice();
        this.aEF = bl;
    }

    public PluginContractImpl F(int n, int n2) {
        this.aEE.rewind();
        return this;
    }

    public int Fl() {
        return this.aEE.position();
    }

    public int Fm() {
        return this.aEE.limit();
    }

    public boolean Fn() {
        return this.aEC != 0 && this.aEC != this.aEE.position();
    }

    public int Fo() {
        return this.aEB;
    }

    public int Fp() {
        if (!this.aEE.hasRemaining()) {
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
                this.aEE.position(this.aEE.position() + n2);
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
        if (!this.aEE.hasRemaining()) {
            this.aEB = 0;
            return 0;
        }
        if (this.Fn()) {
            if (this.aEC < this.aEE.position()) {
                throw CodedInputEncounteredEmbedded.Gj();
            }
            return this.aEB >>> 3;
        }
        this.aEC = 0;
        int n = this.FJ();
        int n2 = n >>> 3;
        if (n2 == 0) {
            if (this.aEF && 7 == (n & 7)) {
                this.aEB = 0;
                return 0;
            }
            throw CodedInputEncounteredEmbedded.Gm();
        }
        if (this.aEF && 4 == (n & 7)) {
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
            if (this.aEE.position() + n > this.aEE.limit()) {
                throw CodedInputEncounteredEmbedded.Gj();
            }
            this.aEC = this.aEE.position() + n;
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
        return this.aEE.get() != 0;
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
        if (this.aEE.remaining() < n) {
            throw CodedInputEncounteredEmbedded.Gj();
        }
        if (this.aEE.hasArray()) {
            int n2 = this.aEE.position();
            this.aEE.position(this.aEE.position() + n);
            return UTF8_3.k(this.aEE.array(), this.aEE.arrayOffset() + n2, n);
        }
        byte[] byArray = new byte[n];
        this.aEE.get(byArray);
        return UTF8_3.x(byArray);
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
        if (this.aEE.remaining() < n) {
            throw CodedInputEncounteredEmbedded.Gj();
        }
        byteBuffer.put(this.aEE);
    }

    @Override
    public byte[] FI() {
        int n = this.FJ();
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (this.aEE.remaining() < n) {
            throw CodedInputEncounteredEmbedded.Gj();
        }
        byte[] byArray = new byte[n];
        this.aEE.get(byArray);
        return byArray;
    }

    @Override
    public Object a(Object object, PluginContract_14 pluginContract_14) {
        if (this.aEF) {
            return this.b(object, pluginContract_14);
        }
        int n = this.FJ();
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (this.aEE.remaining() < n) {
            throw CodedInputEncounteredEmbedded.Gj();
        }
        ByteBuffer byteBuffer = this.aEE.slice();
        byteBuffer.limit(n);
        if (object == null) {
            object = pluginContract_14.wi();
        }
        PluginContractImpl pluginContractImpl = new PluginContractImpl(byteBuffer, this.aEF);
        pluginContract_14.a(pluginContractImpl, object);
        if (!pluginContract_14.r(object)) {
            throw new RuntimeError_3(object, pluginContract_14);
        }
        pluginContractImpl.cc(0);
        this.aEE.position(this.aEE.position() + n);
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
        byte by = this.aEE.get();
        if (by >= 0) {
            return by;
        }
        int n = by & 0x7F;
        by = this.aEE.get();
        if (by >= 0) {
            n |= by << 7;
        } else {
            n |= (by & 0x7F) << 7;
            by = this.aEE.get();
            if (by >= 0) {
                n |= by << 14;
            } else {
                n |= (by & 0x7F) << 14;
                by = this.aEE.get();
                if (by >= 0) {
                    n |= by << 21;
                } else {
                    n |= (by & 0x7F) << 21;
                    by = this.aEE.get();
                    n |= by << 28;
                    if (by < 0) {
                        for (int i = 0; i < 5; ++i) {
                            if (this.aEE.get() < 0) continue;
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
        long l = 0L;
        for (int i = 0; i < 64; i += 7) {
            byte by = this.aEE.get();
            l |= (long)(by & 0x7F) << i;
            if ((by & 0x80) != 0) continue;
            return l;
        }
        throw CodedInputEncounteredEmbedded.Gl();
    }

    public int FL() {
        byte[] byArray = new byte[4];
        this.aEE.get(byArray);
        return byArray[0] & 0xFF | (byArray[1] & 0xFF) << 8 | (byArray[2] & 0xFF) << 16 | (byArray[3] & 0xFF) << 24;
    }

    public long FM() {
        byte[] byArray = new byte[8];
        this.aEE.get(byArray);
        return (long)byArray[0] & 0xFFL | ((long)byArray[1] & 0xFFL) << 8 | ((long)byArray[2] & 0xFFL) << 16 | ((long)byArray[3] & 0xFFL) << 24 | ((long)byArray[4] & 0xFFL) << 32 | ((long)byArray[5] & 0xFFL) << 40 | ((long)byArray[6] & 0xFFL) << 48 | ((long)byArray[7] & 0xFFL) << 56;
    }

    @Override
    public void a(PluginContract_12 pluginContract_12, boolean bl, int n, boolean bl2) {
        int n2 = this.FJ();
        if (n2 < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (bl) {
            if (this.aEE.hasArray()) {
                pluginContract_12.a(true, n, this.aEE.array(), this.aEE.arrayOffset() + this.aEE.position(), n2, bl2);
                this.aEE.position(this.aEE.position() + n2);
            } else {
                byte[] byArray = new byte[n2];
                this.aEE.get(byArray);
                pluginContract_12.a(true, n, byArray, 0, byArray.length, bl2);
            }
        } else {
            if (this.aEE.remaining() < n2) {
                throw CodedInputEncounteredEmbedded.Gj();
            }
            ByteBuffer byteBuffer = this.aEE.slice();
            byteBuffer.limit(n2);
            pluginContract_12.a(n, byteBuffer, bl2);
            this.aEE.position(this.aEE.position() + n2);
        }
    }

    @Override
    public ByteBuffer FN() {
        return ByteBuffer.wrap(this.FI());
    }
}
