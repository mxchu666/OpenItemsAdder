package itemsadder.m;

import itemsadder.m.BufferCapacityEnough;
import itemsadder.m.FluentBuilder_3;
import itemsadder.m.FluentBuilder_4;
import itemsadder.m.Opaque103;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.nio.ByteBuffer;
import java.util.List;

public final class UTF8
implements PluginContract_12 {
    public FluentBuilder_4 aFy;

    public UTF8() {
        this.aFy = new FluentBuilder_4();
    }

    public UTF8(FluentBuilder_4 fluentBuilder_4) {
        this.aFy = fluentBuilder_4;
    }

    @Override
    public void d(int n, int n2, boolean bl) {
        if (n2 < 0) {
            this.aFy.cu(Opaque103.K(n, 0));
            this.aFy.q(n2);
        } else {
            this.aFy.cu(Opaque103.K(n, 0));
            this.aFy.cu(n2);
        }
    }

    @Override
    public void g(int n, int n2, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 0));
        this.aFy.cu(n2);
    }

    @Override
    public void f(int n, int n2, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 0));
        this.aFy.cu(BufferCapacityEnough.cy(n2));
    }

    @Override
    public void c(int n, int n2, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 5));
        this.aFy.ct(n2);
    }

    @Override
    public void e(int n, int n2, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 5));
        this.aFy.ct(n2);
    }

    @Override
    public void b(int n, long l, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 0));
        this.aFy.q(l);
    }

    @Override
    public void e(int n, long l, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 0));
        this.aFy.q(l);
    }

    @Override
    public void d(int n, long l, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 0));
        this.aFy.q(BufferCapacityEnough.s(l));
    }

    @Override
    public void a(int n, long l, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 1));
        this.aFy.p(l);
    }

    @Override
    public void c(int n, long l, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 1));
        this.aFy.p(l);
    }

    @Override
    public void a(int n, float f, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 5));
        this.aFy.ct(Float.floatToRawIntBits(f));
    }

    @Override
    public void a(int n, double d, boolean bl) {
        this.aFy.cu(Opaque103.K(n, 1));
        this.aFy.p(Double.doubleToRawLongBits(d));
    }

    @Override
    public void a(int n, boolean bl, boolean bl2) {
        this.aFy.cu(Opaque103.K(n, 0));
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
    public void a(int n, FluentBuilder_3 fluentBuilder_3, boolean bl) {
        this.a(n, fluentBuilder_3.getBytes(), bl);
    }

    @Override
    public void a(int n, byte[] byArray, boolean bl) {
        this.a(false, n, byArray, 0, byArray.length, bl);
    }

    @Override
    public void a(boolean bl, int n, byte[] byArray, int n2, int n3, boolean bl2) {
        this.aFy.cu(Opaque103.K(n, 2));
        this.aFy.cu(n3);
        this.aFy.h(byArray, n2, n3);
    }

    @Override
    public void a(int n, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        FluentBuilder_4 fluentBuilder_4 = new FluentBuilder_4(this.aFy.aFm);
        UTF8 uTF8 = new UTF8(fluentBuilder_4);
        pluginContract_14.a(uTF8, object);
        List list = fluentBuilder_4.Gc();
        long l = fluentBuilder_4.FZ();
        this.aFy.cu(Opaque103.K(n, 2));
        this.aFy.q(l);
        for (ByteBuffer byteBuffer : list) {
            this.aFy.c(byteBuffer);
        }
    }

    @Override
    public void a(int n, ByteBuffer byteBuffer, boolean bl) {
        this.a(false, n, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), bl);
    }
}
