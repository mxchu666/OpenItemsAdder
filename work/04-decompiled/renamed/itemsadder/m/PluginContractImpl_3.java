package itemsadder.m;

import itemsadder.m.FluentBuilder_3;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.nio.ByteBuffer;

public class PluginContractImpl_3
implements PluginContract_11 {
    protected final PluginContract_11 aEW;

    public PluginContractImpl_3(PluginContract_11 pluginContract_11) {
        this.aEW = pluginContract_11;
    }

    @Override
    public void a(int n, PluginContract_14 pluginContract_14) {
        this.aEW.a(n, pluginContract_14);
    }

    @Override
    public int a(PluginContract_14 pluginContract_14) {
        return this.aEW.a(pluginContract_14);
    }

    @Override
    public boolean Fz() {
        return this.aEW.Fz();
    }

    @Override
    public byte[] FI() {
        return this.aEW.FI();
    }

    @Override
    public FluentBuilder_3 FH() {
        return this.aEW.FH();
    }

    @Override
    public void a(ByteBuffer byteBuffer) {
        this.aEW.a(byteBuffer);
    }

    @Override
    public double Fs() {
        return this.aEW.Fs();
    }

    @Override
    public int FB() {
        return this.aEW.FB();
    }

    @Override
    public int Fy() {
        return this.aEW.Fy();
    }

    @Override
    public long Fx() {
        return this.aEW.Fx();
    }

    @Override
    public float Ft() {
        return this.aEW.Ft();
    }

    @Override
    public int Fw() {
        return this.aEW.Fw();
    }

    @Override
    public long Fv() {
        return this.aEW.Fv();
    }

    @Override
    public int FC() {
        return this.aEW.FC();
    }

    @Override
    public long FD() {
        return this.aEW.FD();
    }

    @Override
    public int FE() {
        return this.aEW.FE();
    }

    @Override
    public long FF() {
        return this.aEW.FF();
    }

    @Override
    public String FG() {
        return this.aEW.FG();
    }

    @Override
    public int FA() {
        return this.aEW.FA();
    }

    @Override
    public long Fu() {
        return this.aEW.Fu();
    }

    @Override
    public Object a(Object object, PluginContract_14 pluginContract_14) {
        return this.aEW.a(object, pluginContract_14);
    }

    @Override
    public void a(PluginContract_12 pluginContract_12, boolean bl, int n, boolean bl2) {
        this.aEW.a(pluginContract_12, bl, n, bl2);
    }

    @Override
    public ByteBuffer FN() {
        return ByteBuffer.wrap(this.FI());
    }
}
