package itemsadder.m;

import itemsadder.m.BufferPreviouslyUsed;
import itemsadder.m.FluentBuilderBuilder;
import itemsadder.m.Opaque096;
import itemsadder.m.PluginContractImpl_5;
import itemsadder.m.PluginContract_11;

final class Opaque097
extends Opaque096 {
    static final /* synthetic */ boolean aFC;
    final /* synthetic */ FluentBuilderBuilder aFD;

    Opaque097(FluentBuilderBuilder fluentBuilderBuilder) {
        this.aFD = fluentBuilderBuilder;
    }

    @Override
    protected PluginContract_11 a(PluginContractImpl_5 pluginContractImpl_5) {
        return this.aFD;
    }

    @Override
    protected void a(PluginContractImpl_5 pluginContractImpl_5, PluginContract_11 pluginContract_11, boolean bl) {
        if (bl) {
            return;
        }
        if (!aFC && pluginContract_11 != this.aFD) {
            throw new AssertionError();
        }
    }

    static {
        aFC = !BufferPreviouslyUsed.class.desiredAssertionStatus();
    }
}
