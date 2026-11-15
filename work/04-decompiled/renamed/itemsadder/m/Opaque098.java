package itemsadder.m;

import itemsadder.m.BufferPreviouslyUsed;
import itemsadder.m.FluentBuilderBuilder_2;
import itemsadder.m.Opaque096;
import itemsadder.m.PluginContractImpl_5;
import itemsadder.m.PluginContract_11;

final class Opaque098
extends Opaque096 {
    static final /* synthetic */ boolean aFE;
    final /* synthetic */ FluentBuilderBuilder_2 aFF;

    Opaque098(FluentBuilderBuilder_2 fluentBuilderBuilder_2) {
        this.aFF = fluentBuilderBuilder_2;
    }

    @Override
    protected PluginContract_11 a(PluginContractImpl_5 pluginContractImpl_5) {
        return this.aFF;
    }

    @Override
    protected void a(PluginContractImpl_5 pluginContractImpl_5, PluginContract_11 pluginContract_11, boolean bl) {
        if (bl) {
            return;
        }
        if (!aFE && pluginContract_11 != this.aFF) {
            throw new AssertionError();
        }
    }

    static {
        aFE = !BufferPreviouslyUsed.class.desiredAssertionStatus();
    }
}
