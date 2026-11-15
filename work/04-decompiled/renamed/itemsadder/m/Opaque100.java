package itemsadder.m;

import itemsadder.m.BufferPreviouslyUsed_2;
import itemsadder.m.FluentBuilderBuilder_2;
import itemsadder.m.Opaque096;
import itemsadder.m.PluginContractImpl_5;
import itemsadder.m.PluginContract_11;

final class Opaque100
extends Opaque096 {
    static final /* synthetic */ boolean aFL;
    final /* synthetic */ FluentBuilderBuilder_2 aFM;

    Opaque100(FluentBuilderBuilder_2 fluentBuilderBuilder_2) {
        this.aFM = fluentBuilderBuilder_2;
    }

    @Override
    protected PluginContract_11 a(PluginContractImpl_5 pluginContractImpl_5) {
        return this.aFM;
    }

    @Override
    protected void a(PluginContractImpl_5 pluginContractImpl_5, PluginContract_11 pluginContract_11, boolean bl) {
        if (bl) {
            return;
        }
        if (!aFL && pluginContract_11 != this.aFM) {
            throw new AssertionError();
        }
    }

    static {
        aFL = !BufferPreviouslyUsed_2.class.desiredAssertionStatus();
    }
}
