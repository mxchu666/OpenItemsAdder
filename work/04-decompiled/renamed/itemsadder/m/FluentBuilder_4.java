package itemsadder.m;

import itemsadder.m.Opaque092;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FluentBuilder_4 {
    public static final int aFl = 256;
    public final int aFm;
    ByteBuffer aFn;
    List aFo = new ArrayList();

    public FluentBuilder_4() {
        this(256);
    }

    public FluentBuilder_4(int n) {
        assert (n >= 8);
        this.aFm = n;
        this.aFn = ByteBuffer.allocate(n);
    }

    public long FZ() {
        long l = 0L;
        for (ByteBuffer byteBuffer : this.aFo) {
            l += (long)byteBuffer.remaining();
        }
        if (this.aFn != null) {
            l += (long)this.aFn.position();
        }
        return l;
    }

    public List Ga() {
        int n = this.aFo.size() + (this.aFn != null ? 1 : 0);
        ArrayList<Object> arrayList = new ArrayList<Object>(n);
        for (ByteBuffer byteBuffer : this.aFo) {
            arrayList.add(byteBuffer.duplicate());
        }
        if (this.aFn != null) {
            ByteBuffer byteBuffer = this.aFn.duplicate();
            byteBuffer.flip();
            arrayList.add(byteBuffer);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private void Gb() {
        this.aFn.flip();
        this.aFo.add(this.aFn);
        this.aFn = ByteBuffer.allocate(this.aFm);
    }

    private void b(ByteBuffer byteBuffer) {
        if (this.aFn.position() == 0) {
            this.aFo.add(byteBuffer);
            return;
        }
        this.aFn.flip();
        this.aFo.add(this.aFn);
        this.aFo.add(byteBuffer);
        this.aFn = ByteBuffer.allocate(this.aFm);
    }

    private void cp(int n) {
        if (this.aFn.remaining() < n) {
            this.Gb();
        }
    }

    public List Gc() {
        this.aFn.flip();
        this.aFo.add(this.aFn);
        this.aFn = null;
        this.aFo = Collections.unmodifiableList(this.aFo);
        return this.Ga();
    }

    public FluentBuilder_4 d(byte by) {
        this.cp(1);
        this.aFn.put(by);
        return this;
    }

    public FluentBuilder_4 cq(int n) {
        this.cp(2);
        this.aFn.putShort((short)n);
        return this;
    }

    public FluentBuilder_4 cr(int n) {
        this.cp(2);
        Opaque092.a(n, this.aFn);
        return this;
    }

    public FluentBuilder_4 cs(int n) {
        this.cp(4);
        this.aFn.putInt(n);
        return this;
    }

    public FluentBuilder_4 ct(int n) {
        this.cp(4);
        Opaque092.b(n, this.aFn);
        return this;
    }

    public FluentBuilder_4 o(long l) {
        this.cp(8);
        this.aFn.putLong(l);
        return this;
    }

    public FluentBuilder_4 p(long l) {
        this.cp(8);
        Opaque092.a(l, this.aFn);
        return this;
    }

    public FluentBuilder_4 cu(int n) {
        byte[] byArray = new byte[5];
        int n2 = 0;
        while (true) {
            if ((n & 0xFFFFFF80) == 0) {
                byArray[n2++] = (byte)n;
                this.cp(n2);
                this.aFn.put(byArray, 0, n2);
                return this;
            }
            byArray[n2++] = (byte)(n & 0x7F | 0x80);
            n >>>= 7;
        }
    }

    public FluentBuilder_4 q(long l) {
        byte[] byArray = new byte[10];
        int n = 0;
        while (true) {
            if ((l & 0xFFFFFFFFFFFFFF80L) == 0L) {
                byArray[n++] = (byte)l;
                this.cp(n);
                this.aFn.put(byArray, 0, n);
                return this;
            }
            byArray[n++] = (byte)((int)l & 0x7F | 0x80);
            l >>>= 7;
        }
    }

    public FluentBuilder_4 D(double d) {
        return this.o(Double.doubleToRawLongBits(d));
    }

    public FluentBuilder_4 E(float f) {
        return this.cs(Float.floatToRawIntBits(f));
    }

    public FluentBuilder_4 h(byte[] byArray, int n, int n2) {
        if (this.aFn.remaining() >= n2) {
            this.aFn.put(byArray, n, n2);
        } else {
            ByteBuffer byteBuffer = ByteBuffer.wrap(byArray, n, n2);
            this.b(byteBuffer);
        }
        return this;
    }

    public FluentBuilder_4 u(byte[] byArray) {
        return this.h(byArray, 0, byArray.length);
    }

    public FluentBuilder_4 c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer.slice();
        if (this.aFn.remaining() >= byteBuffer2.remaining()) {
            this.aFn.put(byteBuffer2);
        } else {
            this.b(byteBuffer2);
        }
        return this;
    }
}
