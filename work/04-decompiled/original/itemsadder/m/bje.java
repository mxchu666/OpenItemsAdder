package itemsadder.m;

import itemsadder.m.biy;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import java.nio.ByteBuffer;

public class bje
implements bjy {
    protected final bjy aEX;

    public bje(bjy bjy2) {
        this.aEX = bjy2;
    }

    @Override
    public void a(int n, boolean bl, boolean bl2) {
        this.aEX.a(n, bl, bl2);
    }

    @Override
    public void a(int n, byte[] byArray, boolean bl) {
        this.aEX.a(n, byArray, bl);
    }

    @Override
    public void a(boolean bl, int n, byte[] byArray, int n2, int n3, boolean bl2) {
        this.aEX.a(bl, n, byArray, n2, n3, bl2);
    }

    @Override
    public void a(int n, biy biy2, boolean bl) {
        this.aEX.a(n, biy2, bl);
    }

    @Override
    public void a(int n, double d, boolean bl) {
        this.aEX.a(n, d, bl);
    }

    @Override
    public void b(int n, int n2, boolean bl) {
        this.aEX.b(n, n2, bl);
    }

    @Override
    public void c(int n, int n2, boolean bl) {
        this.aEX.c(n, n2, bl);
    }

    @Override
    public void a(int n, long l, boolean bl) {
        this.aEX.a(n, l, bl);
    }

    @Override
    public void a(int n, float f, boolean bl) {
        this.aEX.a(n, f, bl);
    }

    @Override
    public void d(int n, int n2, boolean bl) {
        this.aEX.d(n, n2, bl);
    }

    @Override
    public void b(int n, long l, boolean bl) {
        this.aEX.b(n, l, bl);
    }

    @Override
    public void a(int n, Object object, bko bko2, boolean bl) {
        this.aEX.a(n, object, bko2, bl);
    }

    @Override
    public void e(int n, int n2, boolean bl) {
        this.aEX.e(n, n2, bl);
    }

    @Override
    public void c(int n, long l, boolean bl) {
        this.aEX.c(n, l, bl);
    }

    @Override
    public void f(int n, int n2, boolean bl) {
        this.aEX.f(n, n2, bl);
    }

    @Override
    public void d(int n, long l, boolean bl) {
        this.aEX.d(n, l, bl);
    }

    @Override
    public void a(int n, CharSequence charSequence, boolean bl) {
        this.aEX.a(n, charSequence, bl);
    }

    @Override
    public void g(int n, int n2, boolean bl) {
        this.aEX.g(n, n2, bl);
    }

    @Override
    public void e(int n, long l, boolean bl) {
        this.aEX.e(n, l, bl);
    }

    @Override
    public void a(int n, ByteBuffer byteBuffer, boolean bl) {
        this.a(false, n, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), bl);
    }
}
