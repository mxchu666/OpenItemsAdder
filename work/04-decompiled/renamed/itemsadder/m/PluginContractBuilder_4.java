package itemsadder.m;

import itemsadder.m.InstanceRegistry_7;
import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Objects;

public final class PluginContractBuilder_4
implements WdFunction {
    private int aqg;
    private String Qe;
    private int apD;
    public static final PluginContract_14 aqh = InstanceRegistry_7.aqi;

    private PluginContractBuilder_4 xc() {
        return this;
    }

    public static PluginContractBuilder_4 xd() {
        return PluginContractBuilder_4.aR(true);
    }

    public static PluginContractBuilder_4 aR(boolean bl) {
        return bl ? new PluginContractBuilder_4().xc() : new PluginContractBuilder_4();
    }

    public int xe() {
        if ((this.apD & 1) == 0) {
            return 0;
        }
        return this.aqg;
    }

    public PluginContractBuilder_4 aX(int n) {
        this.aqg = n;
        this.apD |= 1;
        return this;
    }

    public PluginContractBuilder_4 xf() {
        this.aqg = 0;
        this.apD &= 0xFFFFFFFE;
        return this;
    }

    public boolean wI() {
        return (this.apD & 1) == 1;
    }

    public String xg() {
        if ((this.apD & 2) == 0) {
            return null;
        }
        return this.Qe;
    }

    public PluginContractBuilder_4 ea(String string) {
        this.Qe = string;
        this.apD |= 2;
        return this;
    }

    public PluginContractBuilder_4 xh() {
        this.Qe = null;
        this.apD &= 0xFFFFFFFD;
        return this;
    }

    public boolean wL() {
        return (this.apD & 2) == 2;
    }

    @Override
    public PluginContract_14 wd() {
        return InstanceRegistry_7.aqi;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        PluginContractBuilder_4 pluginContractBuilder_4 = (PluginContractBuilder_4)object;
        if (!Objects.equals(this.aqg, pluginContractBuilder_4.aqg)) {
            return false;
        }
        return Objects.equals(this.Qe, pluginContractBuilder_4.Qe);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + Integer.hashCode(this.aqg);
        n = 31 * n + (this.Qe == null ? 0 : this.Qe.hashCode());
        return n;
    }

    public String toString() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        if (this.wI()) {
            arrayList.add((CallSite)((Object)("key=" + this.xe())));
        }
        if (this.wL()) {
            arrayList.add((CallSite)((Object)("value=" + this.xg())));
        }
        return "DataEntry{" + String.join((CharSequence)", ", arrayList) + "}";
    }
}
