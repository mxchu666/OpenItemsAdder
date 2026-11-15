package itemsadder.m;

import itemsadder.m.biy;
import itemsadder.m.bjp;
import itemsadder.m.bjy;
import itemsadder.m.bkf;
import itemsadder.m.bko;
import itemsadder.m.bkx;
import java.nio.ByteBuffer;

public final class bju
implements bjy {
    public bjp aFy;

    public bju() {
        this.aFy = new bjp();
    }

    public bju(bjp bjp2) {
        this.aFy = bjp2;
    }

    @Override
    public void d(int n, int n2, boolean bl) {
        if (n2 < 0) {
            this.aFy.cu(bkx.K(n, 0));
            this.aFy.q(n2);
        } else {
            this.aFy.cu(bkx.K(n, 0));
            this.aFy.cu(n2);
        }
    }

    @Override
    public void g(int n, int n2, boolean bl) {
        this.aFy.cu(bkx.K(n, 0));
        this.aFy.cu(n2);
    }

    @Override
    public void f(int n, int n2, boolean bl) {
        this.aFy.cu(bkx.K(n, 0));
        this.aFy.cu(bkf.cy(n2));
    }

    @Override
    public void c(int n, int n2, boolean bl) {
        this.aFy.cu(bkx.K(n, 5));
        this.aFy.ct(n2);
    }

    @Override
    public void e(int n, int n2, boolean bl) {
        this.aFy.cu(bkx.K(n, 5));
        this.aFy.ct(n2);
    }

    @Override
    public void b(int n, long l, boolean bl) {
        this.aFy.cu(bkx.K(n, 0));
        this.aFy.q(l);
    }

    @Override
    public void e(int n, long l, boolean bl) {
        this.aFy.cu(bkx.K(n, 0));
        this.aFy.q(l);
    }

    @Override
    public void d(int n, long l, boolean bl) {
        this.aFy.cu(bkx.K(n, 0));
        this.aFy.q(bkf.s(l));
    }

    @Override
    public void a(int n, long l, boolean bl) {
        this.aFy.cu(bkx.K(n, 1));
        this.aFy.p(l);
    }

    @Override
    public void c(int n, long l, boolean bl) {
        this.aFy.cu(bkx.K(n, 1));
        this.aFy.p(l);
    }

    @Override
    public void a(int n, float f, boolean bl) {
        this.aFy.cu(bkx.K(n, 5));
        this.aFy.ct(Float.floatToRawIntBits(f));
    }

    @Override
    public void a(int n, double d, boolean bl) {
        this.aFy.cu(bkx.K(n, 1));
        this.aFy.p(Double.doubleToRawLongBits(d));
    }

    @Override
    public void a(int n, boolean bl, boolean bl2) {
        this.aFy.cu(bkx.K(n, 0));
        this.aFy.d(bl ? (byte)1 : 0);
    }

    @Override
    public void b(int n, int n2, boolean bl) {
        this.d(n, n2, bl);
    }

    @Override
    public void a(int n, CharSequence charSequence, boolean bl) {
        byte[] byArray = charSequence.toString().getBytes("UTF-8");
        this.a(n, byArray, bl);
    }

    @Override
    public void a(int n, biy biy2, boolean bl) {
        this.a(n, biy2.getBytes(), bl);
    }

    @Override
    public void a(int n, byte[] byArray, boolean bl) {
        this.a(false, n, byArray, 0, byArray.length, bl);
    }

    @Override
    public void a(boolean bl, int n, byte[] byArray, int n2, int n3, boolean bl2) {
        this.aFy.cu(bkx.K(n, 2));
        this.aFy.cu(n3);
        this.aFy.h(byArray, n2, n3);
    }

    @Override
    public void a(int n, Object object, bko bko2, boolean bl) {
        this.aFy.cu(bkx.K(n, 3));
        bko2.a(this, object);
        this.aFy.cu(bkx.K(n, 4));
    }

    @Override
    public void a(int n, ByteBuffer byteBuffer, boolean bl) {
        this.a(false, n, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), bl);
    }
}
