package itemsadder.m;

import itemsadder.m.ExpectedMaxSizeNegative;
import itemsadder.m.Opaque103;
import itemsadder.m.Opaque105;
import itemsadder.m.PluginContractImpl_4;
import itemsadder.m.PluginContractImpl_6;
import itemsadder.m.PluginContract_14;

public final class Opaque091
extends PluginContractImpl_4 {
    private final ExpectedMaxSizeNegative aFf;
    private int aFg = 0;

    public Opaque091(PluginContractImpl_6 pluginContractImpl_6) {
        super(pluginContractImpl_6);
        this.aFf = new ExpectedMaxSizeNegative();
    }

    public Opaque091(PluginContractImpl_6 pluginContractImpl_6, int n) {
        super(pluginContractImpl_6);
        this.aFf = new ExpectedMaxSizeNegative(n);
    }

    @Override
    public void a(int n, Object object, PluginContract_14 pluginContract_14, boolean bl) {
        PluginContractImpl_6 pluginContractImpl_6 = (PluginContractImpl_6)this.aEX;
        if (this.aFf.a(this.aFg, object, pluginContractImpl_6, n)) {
            ++this.aFg;
            pluginContractImpl_6.aGC = pluginContractImpl_6.aGG.g(Opaque103.K(n, 3), (Opaque105)pluginContractImpl_6, pluginContractImpl_6.aGC);
            pluginContract_14.a(this, object);
            pluginContractImpl_6.aGC = pluginContractImpl_6.aGG.g(Opaque103.K(n, 4), (Opaque105)pluginContractImpl_6, pluginContractImpl_6.aGC);
        }
    }
}
