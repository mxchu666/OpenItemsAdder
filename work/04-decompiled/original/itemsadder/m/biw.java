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

public final class biw
implements bjm {
    private final byte[] aEz;
    private int offset;
    private int aEA;
    private int aEB = 0;
    private int aEC = 0;
    public final boolean aED;

    public biw(byte[] byArray, boolean bl) {
        this(byArray, 0, byArray.length, bl);
    }

    public biw(byte[] byArray, int n, int n2, boolean bl) {
        this.aEz = byArray;
        this.offset = n;
        this.aEA = n + n2;
        this.aED = bl;
    }

    public biw D(int n, int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("length cannot be negative.");
        }
        this.offset = n;
        this.aEA = n + n2;
        this.aEC = 0;
        return this;
    }

    public biw E(int n, int n2) {
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
                this.offset += n2;
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
        if (this.offset == this.aEA) {
            this.aEB = 0;
            return 0;
        }
        if (this.Fn()) {
            if (this.aEC < this.offset) {
                throw bkb.Gj();
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
            throw bkb.Gm();
        }
        if (this.aED && 4 == (n & 7)) {
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
            if (this.offset + n > this.aEA) {
                throw bkb.Gj();
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
            throw bkb.Gk();
        }
        if (this.offset + n > this.aEA) {
            throw bkb.Gj();
        }
        int n2 = this.offset;
        this.offset += n;
        return bkt.k(this.aEz, n2, n);
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
        if (this.offset + n > this.aEA) {
            throw bkb.Gj();
        }
        byteBuffer.put(this.aEz, this.offset, n);
        this.offset += n;
    }

    @Override
    public byte[] FI() {
        int n = this.FJ();
        if (n < 0) {
            throw bkb.Gk();
        }
        if (this.offset + n > this.aEA) {
            throw bkb.Gj();
        }
        byte[] byArray = new byte[n];
        System.arraycopy(this.aEz, this.offset, byArray, 0, n);
        this.offset += n;
        return byArray;
    }

    @Override
    public Object a(Object object, bko bko2) {
        if (this.aED) {
            return this.b(object, bko2);
        }
        int n = this.FJ();
        if (n < 0) {
            throw bkb.Gk();
        }
        int n2 = this.aEA;
        this.aEA = this.offset + n;
        if (object == null) {
            object = bko2.wi();
        }
        bko2.a(this, object);
        if (!bko2.r(object)) {
            throw new bkv(object, bko2);
        }
        this.cc(0);
        this.aEA = n2;
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
                        throw bkb.Gl();
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
        throw bkb.Gl();
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
    public void a(bjy bjy2, boolean bl, int n, boolean bl2) {
        int n2 = this.FJ();
        if (n2 < 0) {
            throw bkb.Gk();
        }
        bjy2.a(bl, n, this.aEz, this.offset, n2, bl2);
        this.offset += n2;
    }

    @Override
    public ByteBuffer FN() {
        return ByteBuffer.wrap(this.FI());
    }
}
