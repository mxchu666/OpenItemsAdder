package itemsadder.m;

import itemsadder.m.Builder_2;
import itemsadder.m.Builder_3;
import itemsadder.m.Builder_4;
import itemsadder.m.PluginContractBuilder_3;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InstanceRegistry_4
implements PluginContract_14 {
    private static final InstanceRegistry_4 apV = new InstanceRegistry_4();
    private static final Map apW = new HashMap();

    public Builder_3 wN() {
        return Builder_3.wt();
    }

    @Override
    public Class wf() {
        return Builder_3.class;
    }

    @Override
    public String wg() {
        return Builder_3.class.getSimpleName();
    }

    @Override
    public String wh() {
        return Builder_3.class.getName();
    }

    @Deprecated
    public boolean c(Builder_3 builder_3) {
        return true;
    }

    public void a(PluginContract_11 pluginContract_11, Builder_3 builder_3) {
        int n;
        block6: while ((n = pluginContract_11.a(this)) != 0) {
            switch (n) {
                case 1: {
                    if (builder_3.apM == null) {
                        builder_3.apM = new ConcurrentHashMap();
                    }
                    Builder_4 builder_4 = (Builder_4)pluginContract_11.a(null, Builder_4.apS);
                    builder_3.apM.put(builder_4.aF(), builder_4.wJ());
                    continue block6;
                }
                case 2: {
                    builder_3.apN = (PluginContractBuilder_3)pluginContract_11.a(builder_3.apN, PluginContractBuilder_3.aqf);
                    builder_3.apD |= 2;
                    continue block6;
                }
                case 3: {
                    builder_3.apO = (PluginContractBuilder_3)pluginContract_11.a(builder_3.apO, PluginContractBuilder_3.aqf);
                    builder_3.apD |= 4;
                    continue block6;
                }
                case 4: {
                    builder_3.apP = (PluginContractBuilder_3)pluginContract_11.a(builder_3.apP, PluginContractBuilder_3.aqf);
                    builder_3.apD |= 8;
                    continue block6;
                }
            }
            pluginContract_11.a(n, (PluginContract_14)this);
        }
        builder_3.ws();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(PluginContract_12 pluginContract_12, Builder_3 builder_3) {
        Map map = builder_3.apM;
        synchronized (map) {
            for (Map.Entry entry : builder_3.apM.entrySet()) {
                Builder_4 builder_4 = Builder_4.wG().dW((String)entry.getKey()).c((Builder_2)entry.getValue());
                pluginContract_12.a(1, builder_4, Builder_4.apS, true);
            }
        }
        if ((builder_3.apD & 2) == 2) {
            pluginContract_12.a(2, builder_3.apN, PluginContractBuilder_3.aqf, false);
        }
        if ((builder_3.apD & 4) == 4) {
            pluginContract_12.a(3, builder_3.apO, PluginContractBuilder_3.aqf, false);
        }
        if ((builder_3.apD & 8) == 8) {
            pluginContract_12.a(4, builder_3.apP, PluginContractBuilder_3.aqf, false);
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "block";
            }
            case 2: {
                return "blocksPalette";
            }
            case 3: {
                return "biomesPalette";
            }
            case 4: {
                return "cropsSeedsPalette";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)apW.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wN();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.c((Builder_3)object);
    }

    static {
        apW.put("block", 1);
        apW.put("blocksPalette", 2);
        apW.put("biomesPalette", 3);
        apW.put("cropsSeedsPalette", 4);
    }
}
