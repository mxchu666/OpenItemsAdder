package itemsadder.m;

import itemsadder.m.Builder_2;
import itemsadder.m.InstanceRegistry_4;
import itemsadder.m.PluginContractBuilder_3;
import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class Builder_3
implements WdFunction {
    private Map apM;
    private PluginContractBuilder_3 apN;
    private PluginContractBuilder_3 apO;
    private PluginContractBuilder_3 apP;
    private int apD;
    public static final PluginContract_14 apQ = InstanceRegistry_4.apV;

    private Builder_3 ws() {
        if (this.apM == null) {
            this.apM = new ConcurrentHashMap();
        }
        return this;
    }

    public static Builder_3 wt() {
        return Builder_3.aM(true);
    }

    public static Builder_3 aM(boolean bl) {
        return bl ? new Builder_3().ws() : new Builder_3();
    }

    public Map wu() {
        return this.apM;
    }

    public Builder_3 d(Map map) {
        this.apM = map;
        return this;
    }

    public Builder_3 a(String string, Builder_2 builder_2) {
        this.apM.put(string, builder_2);
        return this;
    }

    public int wv() {
        return this.apM.size();
    }

    public boolean dT(String string) {
        return this.apM.containsKey(string);
    }

    public boolean b(Builder_2 builder_2) {
        return this.apM.containsValue(builder_2);
    }

    public Builder_2 dU(String string) {
        return (Builder_2)this.apM.get(string);
    }

    public Builder_2 dV(String string) {
        return (Builder_2)this.apM.remove(string);
    }

    public boolean b(String string, Builder_2 builder_2) {
        return this.apM.remove(string, builder_2);
    }

    public PluginContractBuilder_3 ww() {
        if ((this.apD & 2) == 0) {
            return null;
        }
        return this.apN;
    }

    public Builder_3 a(PluginContractBuilder_3 pluginContractBuilder_3) {
        this.apN = pluginContractBuilder_3;
        this.apD |= 2;
        return this;
    }

    public Builder_3 wx() {
        this.apN = null;
        this.apD &= 0xFFFFFFFD;
        return this;
    }

    public boolean wy() {
        return (this.apD & 2) == 2;
    }

    public PluginContractBuilder_3 wz() {
        if ((this.apD & 4) == 0) {
            return null;
        }
        return this.apO;
    }

    public Builder_3 b(PluginContractBuilder_3 pluginContractBuilder_3) {
        this.apO = pluginContractBuilder_3;
        this.apD |= 4;
        return this;
    }

    public Builder_3 wA() {
        this.apO = null;
        this.apD &= 0xFFFFFFFB;
        return this;
    }

    public boolean wB() {
        return (this.apD & 4) == 4;
    }

    public PluginContractBuilder_3 wC() {
        if ((this.apD & 8) == 0) {
            return null;
        }
        return this.apP;
    }

    public Builder_3 c(PluginContractBuilder_3 pluginContractBuilder_3) {
        this.apP = pluginContractBuilder_3;
        this.apD |= 8;
        return this;
    }

    public Builder_3 wD() {
        this.apP = null;
        this.apD &= 0xFFFFFFF7;
        return this;
    }

    public boolean wE() {
        return (this.apD & 8) == 8;
    }

    @Override
    public PluginContract_14 wd() {
        return InstanceRegistry_4.apV;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Builder_3 builder_3 = (Builder_3)object;
        if (!Objects.equals(this.apM, builder_3.apM)) {
            return false;
        }
        if (!Objects.equals(this.apN, builder_3.apN)) {
            return false;
        }
        if (!Objects.equals(this.apO, builder_3.apO)) {
            return false;
        }
        return Objects.equals(this.apP, builder_3.apP);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.apM == null ? 0 : this.apM.hashCode());
        n = 31 * n + (this.apN == null ? 0 : this.apN.hashCode());
        n = 31 * n + (this.apO == null ? 0 : this.apO.hashCode());
        n = 31 * n + (this.apP == null ? 0 : this.apP.hashCode());
        return n;
    }

    public String toString() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        if (!this.apM.isEmpty()) {
            arrayList.add((CallSite)((Object)("block=" + String.valueOf(this.wu()))));
        }
        if (this.wy()) {
            arrayList.add((CallSite)((Object)("blocksPalette=" + String.valueOf(this.ww()))));
        }
        if (this.wB()) {
            arrayList.add((CallSite)((Object)("biomesPalette=" + String.valueOf(this.wz()))));
        }
        if (this.wE()) {
            arrayList.add((CallSite)((Object)("cropsSeedsPalette=" + String.valueOf(this.wC()))));
        }
        return "PChunk{" + String.join((CharSequence)", ", arrayList) + "}";
    }
}
