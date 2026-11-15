package itemsadder.m;

import itemsadder.m.biy;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bkb;
import itemsadder.m.bko;
import itemsadder.m.bkt;
import itemsadder.m.bkv;
import itemsadder.m.bkx;
import java.nio.ByteBuffer;

public final class bix
implements bjm {
    private final ByteBuffer aEE;
    private int aEB = 0;
    private int aEC = 0;
    public final boolean aEF;

    public bix(ByteBuffer byteBuffer, boolean bl) {
        this.aEE = byteBuffer.slice();
        this.aEF = bl;
    }

    public bix F(int n, int n2) {
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
            throw bkb.Gm();
        }
        this.aEB = n;
        return n;
    }

    public void cc(int n) {
        if (this.aEB != n) {
            throw bkb.Gn();
        }
    }

    public boolean cd(int n) {
        switch (bkx.cF(n)) {
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
                    throw bkb.Gk();
                }
                this.aEE.position(this.aEE.position() + n2);
                return true;
            }
            case 3: {
                this.Fq();
                this.cc(bkx.K(bkx.cG(n), 4));
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
        throw bkb.Go();
    }

    public void Fq() {
        int n;
        while ((n = this.Fp()) != 0 && this.cd(n)) {
        }
    }

    @Override
    public void a(int n, bko bko2) {
        this.cd(this.aEB);
    }

    @Override
    public int a(bko bko2) {
        if (!this.aEE.hasRemaining()) {
            this.aEB = 0;
            return 0;
        }
        if (this.Fn()) {
            if (this.aEC < this.aEE.position()) {
                throw bkb.Gj();
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
            throw bkb.Gm();
        }
        if (this.aEF && 4 == (n & 7)) {
            this.aEB = 0;
            return 0;
        }
        this.aEB = n;
        return n2;
    }

    private void Fr() {
        if (this.aEC == 0 && bkx.cF(this.aEB) == 2) {
            int n = this.FJ();
            if (n < 0) {
                throw bkb.Gk();
            }
            if (this.aEE.position() + n > this.aEE.limit()) {
                throw bkb.Gj();
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
            throw bkb.Gk();
        }
        if (this.aEE.remaining() < n) {
            throw bkb.Gj();
        }
        if (this.aEE.hasArray()) {
            int n2 = this.aEE.position();
            this.aEE.position(this.aEE.position() + n);
            return bkt.k(this.aEE.array(), this.aEE.arrayOffset() + n2, n);
        }
        byte[] byArray = new byte[n];
        this.aEE.get(byArray);
        return bkt.x(byArray);
    }

    @Override
    public biy FH() {
        return biy.q(this.FI());
    }

    @Override
    public void a(ByteBuffer byteBuffer) {
        int n = this.FJ();
        if (n < 0) {
            throw bkb.Gk();
        }
        if (this.aEE.remaining() < n) {
            throw bkb.Gj();
        }
        byteBuffer.put(this.aEE);
    }

    @Override
    public byte[] FI() {
        int n = this.FJ();
        if (n < 0) {
            throw bkb.Gk();
        }
        if (this.aEE.remaining() < n) {
            throw bkb.Gj();
        }
        byte[] byArray = new byte[n];
        this.aEE.get(byArray);
        return byArray;
    }

    @Override
    public Object a(Object object, bko bko2) {
        if (this.aEF) {
            return this.b(object, bko2);
        }
        int n = this.FJ();
        if (n < 0) {
            throw bkb.Gk();
        }
        if (this.aEE.remaining() < n) {
            throw bkb.Gj();
        }
        ByteBuffer byteBuffer = this.aEE.slice();
        byteBuffer.limit(n);
        if (object == null) {
            object = bko2.wi();
        }
        bix bix2 = new bix(byteBuffer, this.aEF);
        bko2.a(bix2, object);
        if (!bko2.r(object)) {
            throw new bkv(object, bko2);
        }
        bix2.cc(0);
        this.aEE.position(this.aEE.position() + n);
        return object;
    }

    private Object b(Object object, bko bko2) {
        if (object == null) {
            object = bko2.wi();
        }
        bko2.a(this, object);
        if (!bko2.r(object)) {
            throw new bkv(object, bko2);
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
                        throw bkb.Gl();
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
        throw bkb.Gl();
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
    public void a(bjy bjy2, boolean bl, int n, boolean bl2) {
        int n2 = this.FJ();
        if (n2 < 0) {
            throw bkb.Gk();
        }
        if (bl) {
            if (this.aEE.hasArray()) {
                bjy2.a(true, n, this.aEE.array(), this.aEE.arrayOffset() + this.aEE.position(), n2, bl2);
                this.aEE.position(this.aEE.position() + n2);
            } else {
                byte[] byArray = new byte[n2];
                this.aEE.get(byArray);
                bjy2.a(true, n, byArray, 0, byArray.length, bl2);
            }
        } else {
            if (this.aEE.remaining() < n2) {
                throw bkb.Gj();
            }
            ByteBuffer byteBuffer = this.aEE.slice();
            byteBuffer.limit(n2);
            bjy2.a(n, byteBuffer, bl2);
            this.aEE.position(this.aEE.position() + n2);
        }
    }

    @Override
    public ByteBuffer FN() {
        return ByteBuffer.wrap(this.FI());
    }
}
