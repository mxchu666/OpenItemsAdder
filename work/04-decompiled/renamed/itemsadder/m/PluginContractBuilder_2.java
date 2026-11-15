package itemsadder.m;

import itemsadder.m.InstanceRegistry_6;
import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class PluginContractBuilder_2
implements WdFunction {
    private List aqb;
    private int apD;
    public static final PluginContract_14 aqc = InstanceRegistry_6.aqd;

    private PluginContractBuilder_2 wT() {
        if (this.aqb == null) {
            this.aqb = Collections.synchronizedList(new ArrayList());
        }
        return this;
    }

    public static PluginContractBuilder_2 wU() {
        return PluginContractBuilder_2.aP(true);
    }

    public static PluginContractBuilder_2 aP(boolean bl) {
        return bl ? new PluginContractBuilder_2().wT() : new PluginContractBuilder_2();
    }

    public List wV() {
        return this.aqb;
    }

    public PluginContractBuilder_2 G(List list) {
        this.aqb = list;
        return this;
    }

    public PluginContractBuilder_2 dY(String string) {
        this.aqb.add(string);
        return this;
    }

    public PluginContractBuilder_2 H(List list) {
        this.aqb.addAll(list);
        return this;
    }

    public int wW() {
        return this.aqb.size();
    }

    public String aW(int n) {
        return (String)this.aqb.get(n);
    }

    @Override
    public PluginContract_14 wd() {
        return InstanceRegistry_6.aqd;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        PluginContractBuilder_2 pluginContractBuilder_2 = (PluginContractBuilder_2)object;
        return Objects.equals(this.aqb, pluginContractBuilder_2.aqb);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.aqb == null ? 0 : this.aqb.hashCode());
        return n;
    }

    public String toString() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        if (!this.aqb.isEmpty()) {
            arrayList.add((CallSite)((Object)("item=" + String.valueOf(this.wV()))));
        }
        return "PInventory{" + String.join((CharSequence)", ", arrayList) + "}";
    }
}
