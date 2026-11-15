package itemsadder.m;

import itemsadder.m.InstanceRegistry_8;
import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class PluginContractBuilder_3
implements WdFunction {
    private Map Ee;
    private int apD;
    public static final PluginContract_14 aqf = InstanceRegistry_8.aqk;

    private PluginContractBuilder_3 wY() {
        if (this.Ee == null) {
            this.Ee = new ConcurrentHashMap();
        }
        return this;
    }

    public static PluginContractBuilder_3 wZ() {
        return PluginContractBuilder_3.aQ(true);
    }

    public static PluginContractBuilder_3 aQ(boolean bl) {
        return bl ? new PluginContractBuilder_3().wY() : new PluginContractBuilder_3();
    }

    public Map xa() {
        return this.Ee;
    }

    public PluginContractBuilder_3 e(Map map) {
        this.Ee = map;
        return this;
    }

    public PluginContractBuilder_3 c(Integer n, String string) {
        this.Ee.put(n, string);
        return this;
    }

    public int xb() {
        return this.Ee.size();
    }

    public boolean K(Integer n) {
        return this.Ee.containsKey(n);
    }

    public boolean dZ(String string) {
        return this.Ee.containsValue(string);
    }

    public String L(Integer n) {
        return (String)this.Ee.get(n);
    }

    public String M(Integer n) {
        return (String)this.Ee.remove(n);
    }

    public boolean d(Integer n, String string) {
        return this.Ee.remove(n, string);
    }

    @Override
    public PluginContract_14 wd() {
        return InstanceRegistry_8.aqk;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        PluginContractBuilder_3 pluginContractBuilder_3 = (PluginContractBuilder_3)object;
        return Objects.equals(this.Ee, pluginContractBuilder_3.Ee);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.Ee == null ? 0 : this.Ee.hashCode());
        return n;
    }

    public String toString() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        if (!this.Ee.isEmpty()) {
            arrayList.add((CallSite)((Object)("data=" + String.valueOf(this.xa()))));
        }
        return "PPalette{" + String.join((CharSequence)", ", arrayList) + "}";
    }
}
