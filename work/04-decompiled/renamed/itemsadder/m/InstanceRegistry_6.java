package itemsadder.m;

import itemsadder.m.PluginContractBuilder_2;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class InstanceRegistry_6
implements PluginContract_14 {
    private static final InstanceRegistry_6 aqd = new InstanceRegistry_6();
    private static final Map aqe = new HashMap();

    public PluginContractBuilder_2 wX() {
        return PluginContractBuilder_2.wU();
    }

    @Override
    public Class wf() {
        return PluginContractBuilder_2.class;
    }

    @Override
    public String wg() {
        return PluginContractBuilder_2.class.getSimpleName();
    }

    @Override
    public String wh() {
        return PluginContractBuilder_2.class.getName();
    }

    @Deprecated
    public boolean b(PluginContractBuilder_2 pluginContractBuilder_2) {
        return true;
    }

    public void a(PluginContract_11 pluginContract_11, PluginContractBuilder_2 pluginContractBuilder_2) {
        int n;
        block3: while ((n = pluginContract_11.a(this)) != 0) {
            switch (n) {
                case 1: {
                    if (pluginContractBuilder_2.aqb == null) {
                        pluginContractBuilder_2.aqb = new ArrayList();
                    }
                    pluginContractBuilder_2.aqb.add(pluginContract_11.FG());
                    continue block3;
                }
            }
            pluginContract_11.a(n, (PluginContract_14)this);
        }
        pluginContractBuilder_2.wT();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(PluginContract_12 pluginContract_12, PluginContractBuilder_2 pluginContractBuilder_2) {
        List list = pluginContractBuilder_2.aqb;
        synchronized (list) {
            for (String string : pluginContractBuilder_2.aqb) {
                pluginContract_12.a(1, string, true);
            }
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "item";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)aqe.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wX();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.b((PluginContractBuilder_2)object);
    }

    static {
        aqe.put("item", 1);
    }
}
