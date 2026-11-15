package itemsadder.m;

import itemsadder.m.PluginContractBuilder;
import itemsadder.m.PluginContract_11;
import itemsadder.m.PluginContract_12;
import itemsadder.m.PluginContract_14;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class InstanceRegistry_5
implements PluginContract_14 {
    private static final InstanceRegistry_5 apZ = new InstanceRegistry_5();
    private static final Map aqa = new HashMap();

    public PluginContractBuilder wS() {
        return PluginContractBuilder.wP();
    }

    @Override
    public Class wf() {
        return PluginContractBuilder.class;
    }

    @Override
    public String wg() {
        return PluginContractBuilder.class.getSimpleName();
    }

    @Override
    public String wh() {
        return PluginContractBuilder.class.getName();
    }

    @Deprecated
    public boolean a(PluginContractBuilder pluginContractBuilder) {
        return true;
    }

    public void a(PluginContract_11 pluginContract_11, PluginContractBuilder pluginContractBuilder) {
        int n;
        block3: while ((n = pluginContract_11.a(this)) != 0) {
            switch (n) {
                case 1: {
                    if (pluginContractBuilder.apX == null) {
                        pluginContractBuilder.apX = new ArrayList();
                    }
                    pluginContractBuilder.apX.add(pluginContract_11.FG());
                    continue block3;
                }
            }
            pluginContract_11.a(n, (PluginContract_14)this);
        }
        pluginContractBuilder.wO();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(PluginContract_12 pluginContract_12, PluginContractBuilder pluginContractBuilder) {
        List list = pluginContractBuilder.apX;
        synchronized (list) {
            for (String string : pluginContractBuilder.apX) {
                pluginContract_12.a(1, string, true);
            }
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "chunk";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)aqa.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wS();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.a((PluginContractBuilder)object);
    }

    static {
        aqa.put("chunk", 1);
    }
}
