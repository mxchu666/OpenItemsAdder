package itemsadder.m;

import itemsadder.m.BufferCapacityEnough;
import itemsadder.m.FluentBuilder_3;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.Opaque103;
import itemsadder.m.Opaque105;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import itemsadder.m.PluginContract_16;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class PluginContractImpl_6
extends Opaque105
implements PluginContract_12 {
    public PluginContractImpl_6(FluentBuilder_5 fluentBuilder_5) {
        super(fluentBuilder_5);
    }

    public PluginContractImpl_6(FluentBuilder_5 fluentBuilder_5, OutputStream outputStream) {
        super(fluentBuilder_5, outputStream);
    }

    public PluginContractImpl_6(FluentBuilder_5 fluentBuilder_5, OutputStream outputStream, PluginContract_16 pluginContract_16, int n) {
        super(fluentBuilder_5, outputStream, pluginContract_16, n);
    }

    public PluginContractImpl_6 Gt() {
        super.Gs();
        return this;
    }

    @Override
    public void d(int n, int n2, boolean bl) {
        this.aGC = n2 < 0 ? this.aGG.d((long)n2, (Opaque105)this, this.aGG.g(Opaque103.K(n, 0), (Opaque105)this, this.aGC)) : this.aGG.g(n2, (Opaque105)this, this.aGG.g(Opaque103.K(n, 0), (Opaque105)this, this.aGC));
    }

    @Override
    public void g(int n, int n2, boolean bl) {
        this.aGC = this.aGG.g(n2, (Opaque105)this, this.aGG.g(Opaque103.K(n, 0), (Opaque105)this, this.aGC));
    }

    @Override
    public void f(int n, int n2, boolean bl) {
        this.aGC = this.aGG.g(BufferCapacityEnough.cy(n2), (Opaque105)this, this.aGG.g(Opaque103.K(n, 0), (Opaque105)this, this.aGC));
    }

    @Override
    public void c(int n, int n2, boolean bl) {
        this.aGC = this.aGG.f(n2, (Opaque105)this, this.aGG.g(Opaque103.K(n, 5), (Opaque105)this, this.aGC));
    }

    @Override
    public void e(int n, int n2, boolean bl) {
        this.aGC = this.aGG.f(n2, (Opaque105)this, this.aGG.g(Opaque103.K(n, 5), (Opaque105)this, this.aGC));
    }

    @Override
    public void b(int n, long l, boolean bl) {
        this.aGC = this.aGG.d(l, (Opaque105)this, this.aGG.g(Opaque103.K(n, 0), (Opaque105)this, this.aGC));
    }

    @Override
    public void e(int n, long l, boolean bl) {
        this.aGC = this.aGG.d(l, (Opaque105)this, this.aGG.g(Opaque103.K(n, 0), (Opaque105)this, this.aGC));
    }

    @Override
    public void d(int n, long l, boolean bl) {
        this.aGC = this.aGG.d(BufferCapacityEnough.s(l), (Opaque105)this, this.aGG.g(Opaque103.K(n, 0), (Opaque105)this, this.aGC));
    }

    @Override
    public void a(int n, long l, boolean bl) {
        this.aGC = this.aGG.c(l, (Opaque105)this, this.aGG.g(Opaque103.K(n, 1), (Opaque105)this, this.aGC));
    }

    @Override
    public void c(int n, long l, boolean bl) {
        this.aGC = this.aGG.c(l, (Opaque105)this, this.aGG.g(Opaque103.K(n, 1), (Opaque105)this, this.aGC));
    }

    @Override
    public void a(int n, float f, boolean bl) {
        this.aGC = this.aGG.f(Float.floatToRawIntBits(f), (Opaque105)this, this.aGG.g(Opaque103.K(n, 5), (Opaque105)this, this.aGC));
    }

    @Override
    public void a(int n, double d, boolean bl) {
        this.aGC = this.aGG.c(Double.doubleToRawLongBits(d), (Opaque105)this, this.aGG.g(Opaque103.K(n, 1), (Opaque105)this, this.aGC));
    }

    @Override
    public void a(int n, boolean bl, boolean bl2) {
        this.aGC = this.aGG.a(bl ? (byte)1 : 0, (Opaque105)this, this.aGG.g(Opaque103.K(n, 0), (Opaque105)this, this.aGC));
    }

    @Override
    public void b(int n, int n2, boolean bl) {
        this.d(n, n2, bl);
    }

    @Override
    public void a(int n, CharSequence charSequence, boolean bl) {
        this.aGC = this.aGG.g(charSequence, (Opaque105)this, this.aGG.g(Opaque103.K(n, 2), (Opaque105)this, this.aGC));
    }

    @Override
    public void a(int n, FluentBuilder_3 fluentBuilder_3, boolean bl) {
        this.a(n, fluentBuilder_3.getBytes(), bl);
    }

    @Override
    public void a(int n, byte[] byArray, boolean bl) {
        this.aGC = this.aGG.d(byArray, 0, byArray.length, this, this.aGG.g(byArray.length, (Opaque105)this, this.aGG.g(Opaque103.K(n, 2), (Opaque105)this, this.aGC)));
    }

    @Override
    public void a(boolean bl, int n, byte[] byArray, int n2, int n3, boolean bl2) {
        this.aGC = this.aGG.d(byArray, n2, n3, this, this.aGG.g(n3, (Opaque105)this, this.aGG.g(Opaque103.K(n, 2), (Opaque105)this, this.aGC)));
    }

    @Override
    public void a(int n, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        this.aGC = this.aGG.g(Opaque103.K(n, 3), (Opaque105)this, this.aGC);
        pluginContract_14.a(this, object);
        this.aGC = this.aGG.g(Opaque103.K(n, 4), (Opaque105)this, this.aGC);
    }

    @Override
    public void a(int n, ByteBuffer byteBuffer, boolean bl) {
        this.a(false, n, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), bl);
    }

    @Override
    public /* synthetic */ Opaque105 Gs() {
        return this.Gt();
    }
}
