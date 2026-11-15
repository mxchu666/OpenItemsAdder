package itemsadder.m;

import itemsadder.m.Opaque096;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;

public abstract class PluginContractImpl_5
implements PluginContract_14 {
    public final PluginContract_14 aFz;

    public PluginContractImpl_5(PluginContract_14 pluginContract_14) {
        this.aFz = pluginContract_14;
    }

    @Override
    public String aT(int n) {
        return this.aFz.aT(n);
    }

    @Override
    public int dS(String string) {
        return this.aFz.dS(string);
    }

    public boolean a(Opaque096 opaque096) {
        return true;
    }

    @Override
    public String wh() {
        return this.aFz.wh();
    }

    @Override
    public String wg() {
        return this.aFz.wg();
    }

    public Opaque096 Gh() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class wf() {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void a(PluginContract_12 pluginContract_12, Opaque096 opaque096) {
        if (opaque096.aEX == null) {
            opaque096.aEX = pluginContract_12;
            PluginContract_11 pluginContract_11 = opaque096.a(this);
            if (pluginContract_11 == null) {
                opaque096.aEX = null;
                opaque096.a(this, pluginContract_11, true);
                return;
            }
            opaque096.aEW = pluginContract_11;
            boolean bl = false;
            try {
                this.a(opaque096, pluginContract_11, pluginContract_12);
                bl = true;
                opaque096.a(this, pluginContract_11, !bl);
            }
            catch (Throwable throwable) {
                opaque096.a(this, pluginContract_11, !bl);
                throw throwable;
            }
            return;
        }
        opaque096.aEW.a(opaque096, (PluginContract_14)this);
    }

    public final void a(PluginContract_11 pluginContract_11, Opaque096 opaque096) {
        this.a(opaque096, pluginContract_11, opaque096.aEX);
    }

    protected abstract void a(Opaque096 var1, PluginContract_11 var2, PluginContract_12 var3);

    @Override
    public /* synthetic */ Object wi() {
        return this.Gh();
    }

    @Override
    public /* synthetic */ boolean r(Object object) {
        return this.a((Opaque096)object);
    }
}
