package itemsadder.m;

import itemsadder.m.PluginContractBuilder_4;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.util.HashMap;
import java.util.Map;

public final class InstanceRegistry_7
implements PluginContract_14 {
    private static final InstanceRegistry_7 aqi = new InstanceRegistry_7();
    private static final Map aqj = new HashMap();

    public PluginContractBuilder_4 xi() {
        return PluginContractBuilder_4.xd();
    }

    @Override
    public Class wf() {
        return PluginContractBuilder_4.class;
    }

    @Override
    public String wg() {
        return PluginContractBuilder_4.class.getSimpleName();
    }

    @Override
    public String wh() {
        return PluginContractBuilder_4.class.getName();
    }

    @Deprecated
    public boolean a(PluginContractBuilder_4 pluginContractBuilder_4) {
        return true;
    }

    public void a(PluginContract_11 pluginContract_11, PluginContractBuilder_4 pluginContractBuilder_4) {
        int n;
        block4: while ((n = pluginContract_11.a(this)) != 0) {
            switch (n) {
                case 1: {
                    pluginContractBuilder_4.aqg = pluginContract_11.Fw();
                    pluginContractBuilder_4.apD |= 1;
                    continue block4;
                }
                case 2: {
                    pluginContractBuilder_4.Qe = pluginContract_11.FG();
                    pluginContractBuilder_4.apD |= 2;
                    continue block4;
                }
            }
            pluginContract_11.a(n, (PluginContract_14)this);
        }
        pluginContractBuilder_4.xc();
    }

    public void a(PluginContract_12 pluginContract_12, PluginContractBuilder_4 pluginContractBuilder_4) {
        if ((pluginContractBuilder_4.apD & 1) == 1) {
            pluginContract_12.d(1, pluginContractBuilder_4.aqg, false);
        }
        if ((pluginContractBuilder_4.apD & 2) == 2) {
            pluginContract_12.a(2, pluginContractBuilder_4.Qe, false);
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
        Integer n = (Integer)aqj.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.xi();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.a((PluginContractBuilder_4)object);
    }

    static {
        aqj.put("key", 1);
        aqj.put("value", 2);
    }
}
