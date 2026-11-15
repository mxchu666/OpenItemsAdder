package itemsadder.m;

import itemsadder.m.biy;
import itemsadder.m.bjq;
import itemsadder.m.bjy;
import itemsadder.m.bkf;
import itemsadder.m.bko;
import itemsadder.m.bkx;
import itemsadder.m.blf;
import itemsadder.m.blg;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class bkk
extends blf
implements bjy {
    public bkk(bjq bjq2) {
        super(bjq2);
    }

    public bkk(bjq bjq2, OutputStream outputStream) {
        super(bjq2, outputStream);
    }

    public bkk(bjq bjq2, OutputStream outputStream, blg blg2, int n) {
        super(bjq2, outputStream, blg2, n);
    }

    public bkk Gt() {
        super.Gs();
        return this;
    }

    @Override
    public void d(int n, int n2, boolean bl) {
        this.aGC = n2 < 0 ? this.aGG.d((long)n2, (blf)this, this.aGG.g(bkx.K(n, 0), (blf)this, this.aGC)) : this.aGG.g(n2, (blf)this, this.aGG.g(bkx.K(n, 0), (blf)this, this.aGC));
    }

    @Override
    public void g(int n, int n2, boolean bl) {
        this.aGC = this.aGG.g(n2, (blf)this, this.aGG.g(bkx.K(n, 0), (blf)this, this.aGC));
    }

    @Override
    public void f(int n, int n2, boolean bl) {
        this.aGC = this.aGG.g(bkf.cy(n2), (blf)this, this.aGG.g(bkx.K(n, 0), (blf)this, this.aGC));
    }

    @Override
    public void c(int n, int n2, boolean bl) {
        this.aGC = this.aGG.f(n2, (blf)this, this.aGG.g(bkx.K(n, 5), (blf)this, this.aGC));
    }

    @Override
    public void e(int n, int n2, boolean bl) {
        this.aGC = this.aGG.f(n2, (blf)this, this.aGG.g(bkx.K(n, 5), (blf)this, this.aGC));
    }

    @Override
    public void b(int n, long l, boolean bl) {
        this.aGC = this.aGG.d(l, (blf)this, this.aGG.g(bkx.K(n, 0), (blf)this, this.aGC));
    }

    @Override
    public void e(int n, long l, boolean bl) {
        this.aGC = this.aGG.d(l, (blf)this, this.aGG.g(bkx.K(n, 0), (blf)this, this.aGC));
    }

    @Override
    public void d(int n, long l, boolean bl) {
        this.aGC = this.aGG.d(bkf.s(l), (blf)this, this.aGG.g(bkx.K(n, 0), (blf)this, this.aGC));
    }

    @Override
    public void a(int n, long l, boolean bl) {
        this.aGC = this.aGG.c(l, (blf)this, this.aGG.g(bkx.K(n, 1), (blf)this, this.aGC));
    }

    @Override
    public void c(int n, long l, boolean bl) {
        this.aGC = this.aGG.c(l, (blf)this, this.aGG.g(bkx.K(n, 1), (blf)this, this.aGC));
    }

    @Override
    public void a(int n, float f, boolean bl) {
        this.aGC = this.aGG.f(Float.floatToRawIntBits(f), (blf)this, this.aGG.g(bkx.K(n, 5), (blf)this, this.aGC));
    }

    @Override
    public void a(int n, double d, boolean bl) {
        this.aGC = this.aGG.c(Double.doubleToRawLongBits(d), (blf)this, this.aGG.g(bkx.K(n, 1), (blf)this, this.aGC));
    }

    @Override
    public void a(int n, boolean bl, boolean bl2) {
        this.aGC = this.aGG.a(bl ? (byte)1 : 0, (blf)this, this.aGG.g(bkx.K(n, 0), (blf)this, this.aGC));
    }

    @Override
    public void b(int n, int n2, boolean bl) {
        this.d(n, n2, bl);
    }

    @Override
    public void a(int n, CharSequence charSequence, boolean bl) {
        this.aGC = this.aGG.g(charSequence, (blf)this, this.aGG.g(bkx.K(n, 2), (blf)this, this.aGC));
    }

    @Override
    public void a(int n, biy biy2, boolean bl) {
        this.a(n, biy2.getBytes(), bl);
    }

    @Override
    public void a(int n, byte[] byArray, boolean bl) {
        this.aGC = this.aGG.d(byArray, 0, byArray.length, this, this.aGG.g(byArray.length, (blf)this, this.aGG.g(bkx.K(n, 2), (blf)this, this.aGC)));
    }

    @Override
    public void a(boolean bl, int n, byte[] byArray, int n2, int n3, boolean bl2) {
        this.aGC = this.aGG.d(byArray, n2, n3, this, this.aGG.g(n3, (blf)this, this.aGG.g(bkx.K(n, 2), (blf)this, this.aGC)));
    }

    @Override
    public void a(int n, Object object, bko bko2, boolean bl) {
        this.aGC = this.aGG.g(bkx.K(n, 3), (blf)this, this.aGC);
        bko2.a(this, object);
        this.aGC = this.aGG.g(bkx.K(n, 4), (blf)this, this.aGC);
    }

    @Override
    public void a(int n, ByteBuffer byteBuffer, boolean bl) {
        this.a(false, n, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), bl);
    }

    @Override
    public /* synthetic */ blf Gs() {
        return this.Gt();
    }
}
