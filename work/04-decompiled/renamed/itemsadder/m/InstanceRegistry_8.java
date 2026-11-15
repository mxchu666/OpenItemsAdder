package itemsadder.m;

import itemsadder.m.PluginContractBuilder_3;
import itemsadder.m.PluginContractBuilder_4;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InstanceRegistry_8
implements PluginContract_14 {
    private static final InstanceRegistry_8 aqk = new InstanceRegistry_8();
    private static final Map aql = new HashMap();

    public PluginContractBuilder_3 xj() {
        return PluginContractBuilder_3.wZ();
    }

    @Override
    public Class wf() {
        return PluginContractBuilder_3.class;
    }

    @Override
    public String wg() {
        return PluginContractBuilder_3.class.getSimpleName();
    }

    @Override
    public String wh() {
        return PluginContractBuilder_3.class.getName();
    }

    @Deprecated
    public boolean d(PluginContractBuilder_3 pluginContractBuilder_3) {
        return true;
    }

    public void a(PluginContract_11 pluginContract_11, PluginContractBuilder_3 pluginContractBuilder_3) {
        int n;
        block3: while ((n = pluginContract_11.a(this)) != 0) {
            switch (n) {
                case 1: {
                    if (pluginContractBuilder_3.Ee == null) {
                        pluginContractBuilder_3.Ee = new ConcurrentHashMap();
                    }
                    PluginContractBuilder_4 pluginContractBuilder_4 = (PluginContractBuilder_4)pluginContract_11.a(null, PluginContractBuilder_4.aqh);
                    pluginContractBuilder_3.Ee.put(pluginContractBuilder_4.xe(), pluginContractBuilder_4.xg());
                    continue block3;
                }
            }
            pluginContract_11.a(n, (PluginContract_14)this);
        }
        pluginContractBuilder_3.wY();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(PluginContract_12 pluginContract_12, PluginContractBuilder_3 pluginContractBuilder_3) {
        Map map = pluginContractBuilder_3.Ee;
        synchronized (map) {
            for (Map.Entry entry : pluginContractBuilder_3.Ee.entrySet()) {
                PluginContractBuilder_4 pluginContractBuilder_4 = PluginContractBuilder_4.xd().aX((Integer)entry.getKey()).ea((String)entry.getValue());
                pluginContract_12.a(1, pluginContractBuilder_4, PluginContractBuilder_4.aqh, true);
            }
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "data";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)aql.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.xj();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.d((PluginContractBuilder_3)object);
    }

    static {
        aql.put("data", 1);
    }
}
