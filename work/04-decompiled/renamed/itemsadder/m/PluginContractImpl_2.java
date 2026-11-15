package itemsadder.m;

import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;

public abstract class PluginContractImpl_2
implements PluginContract_14 {
    protected final PluginContract_14 aEV;

    public PluginContractImpl_2(PluginContract_14 pluginContract_14) {
        this.aEV = pluginContract_14;
    }

    @Override
    public String aT(int n) {
        return this.aEV.aT(n);
    }

    @Override
    public int dS(String string) {
        return this.aEV.dS(string);
    }

    @Override
    public boolean r(Object object) {
        return this.aEV.r(object);
    }

    @Override
    public void a(PluginContract_11 pluginContract_11, Object object) {
        this.aEV.a(pluginContract_11, object);
    }

    @Override
    public String wh() {
        return this.aEV.wh();
    }

    @Override
    public String wg() {
        return this.aEV.wg();
    }

    @Override
    public Object wi() {
        return this.aEV.wi();
    }

    @Override
    public Class wf() {
        return this.aEV.wf();
    }

    @Override
    public void a(PluginContract_12 pluginContract_12, Object object) {
        this.aEV.a(pluginContract_12, object);
    }
}
