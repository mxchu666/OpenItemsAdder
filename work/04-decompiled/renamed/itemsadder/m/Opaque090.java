package itemsadder.m;

import itemsadder.m.FluentBuilderBuilder_2;
import itemsadder.m.Opaque103;
import itemsadder.m.PluginContractImpl_3;
import itemsadder.m.PluginContract_10;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import itemsadder.m.RuntimeError_3;
import java.util.ArrayList;

public final class Opaque090
extends PluginContractImpl_3
implements PluginContract_10,
PluginContract_14 {
    private final ArrayList aFd;
    private int aEZ = -1;
    private PluginContract_14 aFa;
    private boolean aFb = false;

    public Opaque090(FluentBuilderBuilder_2 fluentBuilderBuilder_2) {
        super(fluentBuilderBuilder_2);
        assert (fluentBuilderBuilder_2.aER);
        this.aFd = new ArrayList();
    }

    public Opaque090(FluentBuilderBuilder_2 fluentBuilderBuilder_2, int n) {
        super(fluentBuilderBuilder_2);
        assert (fluentBuilderBuilder_2.aER);
        this.aFd = new ArrayList(n);
    }

    @Override
    public void h(Object object, Object object2) {
        int n = this.aFd.size() - 1;
        if (object2 != null && object2 == this.aFd.get(n)) {
            this.aFd.set(n, object);
        }
    }

    @Override
    public boolean FY() {
        return this.aFb;
    }

    @Override
    public int a(PluginContract_14 pluginContract_14) {
        int n = ((FluentBuilderBuilder_2)this.aEW).a(pluginContract_14);
        if (Opaque103.cF(((FluentBuilderBuilder_2)this.aEW).Fo()) == 6) {
            this.aEZ = ((FluentBuilderBuilder_2)this.aEW).FA();
            this.aFb = true;
        } else {
            this.aFb = false;
        }
        return n;
    }

    @Override
    public Object a(Object object, PluginContract_14 pluginContract_14) {
        if (this.aFb) {
            return this.aFd.get(this.aEZ);
        }
        this.aFa = pluginContract_14;
        if (object == null) {
            object = pluginContract_14.wi();
        }
        this.aFd.add(object);
        ((FluentBuilderBuilder_2)this.aEW).a(object, (PluginContract_14)this);
        return object;
    }

    @Override
    public void a(int n, PluginContract_14 pluginContract_14) {
        if (!this.aFb) {
            ((FluentBuilderBuilder_2)this.aEW).cd(((FluentBuilderBuilder_2)this.aEW).Fo());
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
