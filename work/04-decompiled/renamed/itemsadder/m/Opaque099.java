package itemsadder.m;

import itemsadder.m.BufferPreviouslyUsed_2;
import itemsadder.m.FluentBuilderBuilder;
import itemsadder.m.Opaque096;
import itemsadder.m.PluginContractImpl_5;
import itemsadder.m.PluginContract_11;

final class Opaque099
extends Opaque096 {
    static final /* synthetic */ boolean aFJ;
    final /* synthetic */ FluentBuilderBuilder aFK;

    Opaque099(FluentBuilderBuilder fluentBuilderBuilder) {
        this.aFK = fluentBuilderBuilder;
    }

    @Override
    protected PluginContract_11 a(PluginContractImpl_5 pluginContractImpl_5) {
        return this.aFK;
    }

    @Override
    protected void a(PluginContractImpl_5 pluginContractImpl_5, PluginContract_11 pluginContract_11, boolean bl) {
        if (bl) {
            return;
        }
        if (!aFJ && pluginContract_11 != this.aFK) {
            throw new AssertionError();
        }
    }

    static {
        aFJ = !BufferPreviouslyUsed_2.class.desiredAssertionStatus();
    }
}
