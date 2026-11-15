package itemsadder.m;

import itemsadder.m.PluginContractImpl_5;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;

public abstract class Opaque096 {
    protected PluginContract_11 aEW;
    protected PluginContract_12 aEX;

    protected Opaque096 Gg() {
        this.aEX = null;
        this.aEW = null;
        return this;
    }

    protected abstract PluginContract_11 a(PluginContractImpl_5 var1);

    protected abstract void a(PluginContractImpl_5 var1, PluginContract_11 var2, boolean var3);

    public static void a(PluginContractImpl_5 pluginContractImpl_5, Opaque096 opaque096, PluginContract_11 pluginContract_11, PluginContract_12 pluginContract_12) {
        pluginContractImpl_5.a(opaque096, pluginContract_11, pluginContract_12);
    }
}
