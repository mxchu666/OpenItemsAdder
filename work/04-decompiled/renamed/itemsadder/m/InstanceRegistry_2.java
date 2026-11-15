package itemsadder.m;

import itemsadder.m.Builder;
import itemsadder.m.Builder_2;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.util.HashMap;
import java.util.Map;

public final class InstanceRegistry_2
implements PluginContract_14 {
    private static final InstanceRegistry_2 apK = new InstanceRegistry_2();
    private static final Map apL = new HashMap();

    public Builder_2 wr() {
        return Builder_2.wk();
    }

    @Override
    public Class wf() {
        return Builder_2.class;
    }

    @Override
    public String wg() {
        return Builder_2.class.getSimpleName();
    }

    @Override
    public String wh() {
        return Builder_2.class.getName();
    }

    @Deprecated
    public boolean a(Builder_2 builder_2) {
        return true;
    }

    public void a(PluginContract_11 pluginContract_11, Builder_2 builder_2) {
        int n;
        block4: while ((n = pluginContract_11.a(this)) != 0) {
            switch (n) {
                case 1: {
                    builder_2.apH = pluginContract_11.Fw();
                    builder_2.apD |= 1;
                    continue block4;
                }
                case 2: {
                    builder_2.apI = (Builder)pluginContract_11.a(builder_2.apI, Builder.apE);
                    builder_2.apD |= 2;
                    continue block4;
                }
            }
            pluginContract_11.a(n, (PluginContract_14)this);
        }
        builder_2.wj();
    }

    public void a(PluginContract_12 pluginContract_12, Builder_2 builder_2) {
        if ((builder_2.apD & 1) == 1) {
            pluginContract_12.d(1, builder_2.apH, false);
        }
        if ((builder_2.apD & 2) == 2) {
            pluginContract_12.a(2, builder_2.apI, Builder.apE, false);
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "blockId";
            }
            case 2: {
                return "additionalProperties";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)apL.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wr();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.a((Builder_2)object);
    }

    static {
        apL.put("blockId", 1);
        apL.put("additionalProperties", 2);
    }
}
