package itemsadder.m;

import itemsadder.m.FluentBuilderBuilder;
import itemsadder.m.Opaque103;
import itemsadder.m.PluginContractImpl_3;
import itemsadder.m.PluginContract_10;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import itemsadder.m.RuntimeError_3;
import java.util.ArrayList;

public final class Opaque089
extends PluginContractImpl_3
implements PluginContract_10,
PluginContract_14 {
    private final ArrayList aEY;
    private int aEZ = -1;
    private PluginContract_14 aFa;
    private boolean aFb = false;

    public Opaque089(FluentBuilderBuilder fluentBuilderBuilder) {
        super(fluentBuilderBuilder);
        assert (fluentBuilderBuilder.aED);
        this.aEY = new ArrayList();
    }

    public Opaque089(FluentBuilderBuilder fluentBuilderBuilder, int n) {
        super(fluentBuilderBuilder);
        assert (fluentBuilderBuilder.aED);
        this.aEY = new ArrayList(n);
    }

    @Override
    public void h(Object object, Object object2) {
        int n = this.aEY.size() - 1;
        if (object2 != null && object2 == this.aEY.get(n)) {
            this.aEY.set(n, object);
        }
    }

    @Override
    public boolean FY() {
        return this.aFb;
    }

    @Override
    public int a(PluginContract_14 pluginContract_14) {
        int n = ((FluentBuilderBuilder)this.aEW).a(pluginContract_14);
        if (Opaque103.cF(((FluentBuilderBuilder)this.aEW).Fo()) == 6) {
            this.aEZ = ((FluentBuilderBuilder)this.aEW).FA();
            this.aFb = true;
        } else {
            this.aFb = false;
        }
        return n;
    }

    @Override
    public Object a(Object object, PluginContract_14 pluginContract_14) {
        if (this.aFb) {
            return this.aEY.get(this.aEZ);
        }
        this.aFa = pluginContract_14;
        if (object == null) {
            object = pluginContract_14.wi();
        }
        this.aEY.add(object);
        ((FluentBuilderBuilder)this.aEW).a(object, (PluginContract_14)this);
        return object;
    }

    @Override
    public void a(int n, PluginContract_14 pluginContract_14) {
        if (!this.aFb) {
            ((FluentBuilderBuilder)this.aEW).cd(((FluentBuilderBuilder)this.aEW).Fo());
        }
    }

    @Override
    public String aT(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int dS(String string) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean r(Object object) {
        return true;
    }

    @Override
    public String wh() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String wg() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object wi() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class wf() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a(PluginContract_11 pluginContract_11, Object object) {
        PluginContract_14 pluginContract_14 = this.aFa;
        pluginContract_14.a(this, object);
        if (!pluginContract_14.r(object)) {
            throw new RuntimeError_3(object, pluginContract_14);
        }
        this.aFa = pluginContract_14;
    }

    @Override
    public void a(PluginContract_12 pluginContract_12, Object object) {
        throw new UnsupportedOperationException();
    }
}
