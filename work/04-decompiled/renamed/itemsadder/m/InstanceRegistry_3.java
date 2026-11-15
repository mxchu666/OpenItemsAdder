package itemsadder.m;

import itemsadder.m.Builder_2;
import itemsadder.m.Builder_4;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.util.HashMap;
import java.util.Map;

public final class InstanceRegistry_3
implements PluginContract_14 {
    private static final InstanceRegistry_3 apT = new InstanceRegistry_3();
    private static final Map apU = new HashMap();

    public Builder_4 wM() {
        return Builder_4.wG();
    }

    @Override
    public Class wf() {
        return Builder_4.class;
    }

    @Override
    public String wg() {
        return Builder_4.class.getSimpleName();
    }

    @Override
    public String wh() {
        return Builder_4.class.getName();
    }

    @Deprecated
    public boolean a(Builder_4 builder_4) {
        return true;
    }

    public void a(PluginContract_11 pluginContract_11, Builder_4 builder_4) {
        int n;
        block4: while ((n = pluginContract_11.a(this)) != 0) {
            switch (n) {
                case 1: {
                    builder_4.gv = pluginContract_11.FG();
                    builder_4.apD |= 1;
                    continue block4;
                }
                case 2: {
                    builder_4.apR = (Builder_2)pluginContract_11.a(builder_4.apR, Builder_2.apJ);
                    builder_4.apD |= 2;
                    continue block4;
                }
            }
            pluginContract_11.a(n, (PluginContract_14)this);
        }
        builder_4.wF();
    }

    public void a(PluginContract_12 pluginContract_12, Builder_4 builder_4) {
        if ((builder_4.apD & 1) == 1) {
            pluginContract_12.a(1, builder_4.gv, false);
        }
        if ((builder_4.apD & 2) == 2) {
            pluginContract_12.a(2, builder_4.apR, Builder_2.apJ, false);
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "key";
            }
            case 2: {
                return "value";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)apU.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wM();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.a((Builder_4)object);
    }

    static {
        apU.put("key", 1);
        apU.put("value", 2);
    }
}
