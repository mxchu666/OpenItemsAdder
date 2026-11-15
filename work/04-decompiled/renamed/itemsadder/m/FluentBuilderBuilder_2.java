package itemsadder.m;

import itemsadder.m.CodedInputEncounteredEmbedded;
import itemsadder.m.FluentBuilder_3;
import itemsadder.m.Opaque103;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import itemsadder.m.RuntimeError_3;
import itemsadder.m.UTF8_3;
import java.io.DataInput;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class FluentBuilderBuilder_2
implements PluginContract_11 {
    private final byte[] aEK;
    private int aEL;
    private int aEM;
    private int aEN;
    private final InputStream aEO;
    private int aEB;
    private int aEC = 0;
    private int aEP;
    private int aEQ = Integer.MAX_VALUE;
    public final boolean aER;
    private int aES = 0x4000000;
    static final int aET = 0x4000000;
    static final int aEU = 4096;

    public static FluentBuilderBuilder_2 e(InputStream inputStream) {
        return new FluentBuilderBuilder_2(inputStream, false);
    }

    public static FluentBuilderBuilder_2 t(byte[] byArray) {
        return FluentBuilderBuilder_2.g(byArray, 0, byArray.length);
    }

    public static FluentBuilderBuilder_2 g(byte[] byArray, int n, int n2) {
        return new FluentBuilderBuilder_2(byArray, n, n2, false);
    }

    public int Fp() {
        if (this.FU()) {
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
                this.ck(this.FJ());
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
        return this.FJ() != 0;
    }

    @Override
    public String FG() {
        int n = this.FJ();
        if (n <= this.aEL - this.aEN && n > 0) {
            String string = UTF8_3.k(this.aEK, this.aEN, n);
            this.aEN += n;
            return string;
        }
        return UTF8_3.x(this.cj(n));
    }

    @Override
    public void a(ByteBuffer byteBuffer) {
        int n = this.FJ();
        if (n <= this.aEL - this.aEN && n > 0) {
            byteBuffer.limit(n);
            byteBuffer.put(this.aEK, this.aEN, n);
            this.aEN += n;
        } else {
            byteBuffer.put(this.cj(n));
        }
    }

    @Override
    public Object a(Object object, PluginContract_14 pluginContract_14) {
        if (this.aER) {
            return this.b(object, pluginContract_14);
        }
        int n = this.FJ();
        int n2 = this.ch(n);
        if (object == null) {
            object = pluginContract_14.wi();
        }
        pluginContract_14.a(this, object);
        if (!pluginContract_14.r(object)) {
            throw new RuntimeError_3(object, pluginContract_14);
        }
        this.cc(0);
        this.ci(n2);
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

    @Override
    public FluentBuilder_3 FH() {
        int n = this.FJ();
        if (n == 0) {
            return FluentBuilder_3.aEJ;
        }
        if (n <= this.aEL - this.aEN && n > 0) {
            FluentBuilder_3 fluentBuilder_3 = FluentBuilder_3.e(this.aEK, this.aEN, n);
            this.aEN += n;
            return fluentBuilder_3;
        }
        return FluentBuilder_3.q(this.cj(n));
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
        return FluentBuilderBuilder_2.cf(this.FJ());
    }

    @Override
    public long FF() {
        this.Fr();
        return FluentBuilderBuilder_2.n(this.FK());
    }

    public int FJ() {
        byte by = this.FW();
        if (by >= 0) {
            return by;
        }
        int n = by & 0x7F;
        by = this.FW();
        if (by >= 0) {
            n |= by << 7;
        } else {
            n |= (by & 0x7F) << 7;
            by = this.FW();
            if (by >= 0) {
                n |= by << 14;
            } else {
                n |= (by & 0x7F) << 14;
                by = this.FW();
                if (by >= 0) {
                    n |= by << 21;
                } else {
                    n |= (by & 0x7F) << 21;
                    by = this.FW();
                    n |= by << 28;
                    if (by < 0) {
                        for (int i = 0; i < 5; ++i) {
                            if (this.FW() < 0) continue;
                            return n;
                        }
                        throw CodedInputEncounteredEmbedded.Gl();
                    }
                }
            }
        }
        return n;
    }

    static int f(InputStream inputStream) {
        int n = inputStream.read();
        if (n == -1) {
            throw CodedInputEncounteredEmbedded.Gi();
        }
        if ((n & 0x80) == 0) {
            return n;
        }
        return FluentBuilderBuilder_2.c(inputStream, n);
    }

    static int c(InputStream inputStream, int n) {
        int n2;
        int n3;
        int n4 = n & 0x7F;
        for (n3 = 7; n3 < 32; n3 += 7) {
            n2 = inputStream.read();
            if (n2 == -1) {
                throw CodedInputEncounteredEmbedded.Gi();
            }
            n4 |= (n2 & 0x7F) << n3;
            if ((n2 & 0x80) != 0) continue;
            return n4;
        }
        while (n3 < 64) {
            n2 = inputStream.read();
            if (n2 == -1) {
                throw CodedInputEncounteredEmbedded.Gi();
            }
            if ((n2 & 0x80) == 0) {
                return n4;
            }
            n3 += 7;
        }
        throw CodedInputEncounteredEmbedded.Gl();
    }

    static int a(DataInput dataInput, byte by) {
        byte by2;
        int n;
        int n2 = by & 0x7F;
        for (n = 7; n < 32; n += 7) {
            by2 = dataInput.readByte();
            n2 |= (by2 & 0x7F) << n;
            if ((by2 & 0x80) != 0) continue;
            return n2;
        }
        while (n < 64) {
            by2 = dataInput.readByte();
            if ((by2 & 0x80) == 0) {
                return n2;
            }
            n += 7;
        }
        throw CodedInputEncounteredEmbedded.Gl();
    }

    public long FK() {
        long l = 0L;
        for (int i = 0; i < 64; i += 7) {
            byte by = this.FW();
            l |= (long)(by & 0x7F) << i;
            if ((by & 0x80) != 0) continue;
            return l;
        }
        throw CodedInputEncounteredEmbedded.Gl();
    }

    public int FL() {
        byte by = this.FW();
        byte by2 = this.FW();
        byte by3 = this.FW();
        byte by4 = this.FW();
        return by & 0xFF | (by2 & 0xFF) << 8 | (by3 & 0xFF) << 16 | (by4 & 0xFF) << 24;
    }

    public long FM() {
        byte by = this.FW();
        byte by2 = this.FW();
        byte by3 = this.FW();
        byte by4 = this.FW();
        byte by5 = this.FW();
        byte by6 = this.FW();
        byte by7 = this.FW();
        byte by8 = this.FW();
        return (long)by & 0xFFL | ((long)by2 & 0xFFL) << 8 | ((long)by3 & 0xFFL) << 16 | ((long)by4 & 0xFFL) << 24 | ((long)by5 & 0xFFL) << 32 | ((long)by6 & 0xFFL) << 40 | ((long)by7 & 0xFFL) << 48 | ((long)by8 & 0xFFL) << 56;
    }

    public static int cf(int n) {
        return n >>> 1 ^ -(n & 1);
    }

    public static long n(long l) {
        return l >>> 1 ^ -(l & 1L);
    }

    public FluentBuilderBuilder_2(byte[] byArray, int n, int n2, boolean bl) {
        this.aEK = byArray;
        this.aEL = n + n2;
        this.aEN = n;
        this.aEP = -n;
        this.aEO = null;
        this.aER = bl;
    }

    public FluentBuilderBuilder_2(InputStream inputStream, boolean bl) {
        this(inputStream, new byte[4096], 0, 0, bl);
    }

    public FluentBuilderBuilder_2(InputStream inputStream, byte[] byArray, boolean bl) {
        this(inputStream, byArray, 0, 0, bl);
    }

    public FluentBuilderBuilder_2(InputStream inputStream, byte[] byArray, int n, int n2, boolean bl) {
        this.aEK = byArray;
        this.aEL = n2;
        this.aEN = n;
        this.aEP = -n;
        this.aEO = inputStream;
        this.aER = bl;
    }

    public int cg(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Size limit cannot be negative: " + n);
        }
        int n2 = this.aES;
        this.aES = n;
        return n2;
    }

    public void FR() {
        this.aEP = -this.aEN;
    }

    public void gr() {
        this.aEL = 0;
        this.aEN = 0;
        this.aEM = 0;
        this.aEQ = Integer.MAX_VALUE;
        this.aEB = 0;
        this.aEC = 0;
        this.aES = 0x4000000;
        this.FR();
    }

    public int ch(int n) {
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        int n2 = this.aEQ;
        if ((n += this.aEP + this.aEN) > n2) {
            throw CodedInputEncounteredEmbedded.Gi();
        }
        this.aEQ = n;
        this.FS();
        return n2;
    }

    private void FS() {
        this.aEL += this.aEM;
        int n = this.aEP + this.aEL;
        if (n > this.aEQ) {
            this.aEM = n - this.aEQ;
            this.aEL -= this.aEM;
        } else {
            this.aEM = 0;
        }
    }

    public void ci(int n) {
        this.aEQ = n;
        this.FS();
    }

    public int FT() {
        if (this.aEQ == Integer.MAX_VALUE) {
            return -1;
        }
        int n = this.aEP + this.aEN;
        return this.aEQ - n;
    }

    public boolean Fn() {
        return this.aEC != 0 && this.aEC != this.FV();
    }

    public boolean FU() {
        return this.aEN == this.aEL && !this.bf(false);
    }

    public int FV() {
        return this.aEP + this.aEN;
    }

    private boolean bf(boolean bl) {
        if (this.aEN < this.aEL) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (this.aEP + this.aEL == this.aEQ) {
            if (bl) {
                throw CodedInputEncounteredEmbedded.Gi();
            }
            return false;
        }
        this.aEP += this.aEL;
        this.aEN = 0;
        int n = this.aEL = this.aEO == null ? -1 : this.aEO.read(this.aEK);
        if (this.aEL == 0 || this.aEL < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.aEL + "\nThe InputStream implementation is buggy.");
        }
        if (this.aEL == -1) {
            this.aEL = 0;
            if (bl) {
                throw CodedInputEncounteredEmbedded.Gi();
            }
            return false;
        }
        this.FS();
        int n2 = this.aEP + this.aEL + this.aEM;
        if (n2 > this.aES || n2 < 0) {
            throw CodedInputEncounteredEmbedded.Gq();
        }
        return true;
    }

    public byte FW() {
        if (this.aEN == this.aEL) {
            this.bf(true);
        }
        return this.aEK[this.aEN++];
    }

    public byte[] cj(int n) {
        int n2;
        byte[] byArray;
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (this.aEP + this.aEN + n > this.aEQ) {
            this.ck(this.aEQ - this.aEP - this.aEN);
            throw CodedInputEncounteredEmbedded.Gi();
        }
        if (n <= this.aEL - this.aEN) {
            byte[] byArray2 = new byte[n];
            System.arraycopy(this.aEK, this.aEN, byArray2, 0, n);
            this.aEN += n;
            return byArray2;
        }
        if (n < this.aEK.length) {
            byte[] byArray3 = new byte[n];
            int n3 = this.aEL - this.aEN;
            System.arraycopy(this.aEK, this.aEN, byArray3, 0, n3);
            this.aEN = this.aEL;
            this.bf(true);
            while (n - n3 > this.aEL) {
                System.arraycopy(this.aEK, 0, byArray3, n3, this.aEL);
                n3 += this.aEL;
                this.aEN = this.aEL;
                this.bf(true);
            }
            System.arraycopy(this.aEK, 0, byArray3, n3, n - n3);
            this.aEN = n - n3;
            return byArray3;
        }
        int n4 = this.aEN;
        int n5 = this.aEL;
        this.aEP += this.aEL;
        this.aEN = 0;
        this.aEL = 0;
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        for (int i = n - (n5 - n4); i > 0; i -= byArray.length) {
            int n6;
            byArray = new byte[Math.min(i, this.aEK.length)];
            for (n2 = 0; n2 < byArray.length; n2 += n6) {
                int n7 = n6 = this.aEO == null ? -1 : this.aEO.read(byArray, n2, byArray.length - n2);
                if (n6 == -1) {
                    throw CodedInputEncounteredEmbedded.Gi();
                }
                this.aEP += n6;
            }
            arrayList.add(byArray);
        }
        byArray = new byte[n];
        n2 = n5 - n4;
        System.arraycopy(this.aEK, n4, byArray, 0, n2);
        for (byte[] byArray4 : arrayList) {
            System.arraycopy(byArray4, 0, byArray, n2, byArray4.length);
            n2 += byArray4.length;
        }
        return byArray;
    }

    public void ck(int n) {
        if (n < 0) {
            throw CodedInputEncounteredEmbedded.Gk();
        }
        if (this.aEP + this.aEN + n > this.aEQ) {
            this.ck(this.aEQ - this.aEP - this.aEN);
            throw CodedInputEncounteredEmbedded.Gi();
        }
        if (n <= this.aEL - this.aEN) {
            this.aEN += n;
        } else {
            int n2 = this.aEL - this.aEN;
            this.aEN = this.aEL;
            this.bf(true);
            while (n - n2 > this.aEL) {
                n2 += this.aEL;
                this.aEN = this.aEL;
                this.bf(true);
            }
            this.aEN = n - n2;
        }
    }

    @Override
    public int a(PluginContract_14 pluginContract_14) {
        if (this.FU()) {
            this.aEB = 0;
            return 0;
        }
        if (this.Fn()) {
            if (this.aEC < this.FV()) {
                throw CodedInputEncounteredEmbedded.Gj();
            }
            return this.aEB >>> 3;
        }
        this.aEC = 0;
        int n = this.FJ();
        int n2 = n >>> 3;
        if (n2 == 0) {
            if (this.aER && 7 == (n & 7)) {
                this.aEB = 0;
                return 0;
            }
            throw CodedInputEncounteredEmbedded.Gm();
        }
        if (this.aER && 4 == (n & 7)) {
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
            this.aEC = this.FV() + n;
        }
    }

    @Override
    public byte[] FI() {
        int n = this.FJ();
        if (n <= this.aEL - this.aEN && n > 0) {
            byte[] byArray = new byte[n];
            System.arraycopy(this.aEK, this.aEN, byArray, 0, n);
            this.aEN += n;
            return byArray;
        }
        return this.cj(n);
    }

    @Override
    public void a(int n, PluginContract_14 pluginContract_14) {
        this.cd(this.aEB);
    }

    @Override
    public void a(PluginContract_12 pluginContract_12, boolean bl, int n, boolean bl2) {
        int n2 = this.FJ();
        if (n2 <= this.aEL - this.aEN && n2 > 0) {
            pluginContract_12.a(bl, n, this.aEK, this.aEN, n2, bl2);
            this.aEN += n2;
        } else {
            pluginContract_12.a(bl, n, this.cj(n2), 0, n2, bl2);
        }
    }

    public int Fo() {
        return this.aEB;
    }

    @Override
    public ByteBuffer FN() {
        return ByteBuffer.wrap(this.FI());
    }
}
