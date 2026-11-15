package itemsadder.m;

import itemsadder.m.InstanceRegistry_5;
import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class PluginContractBuilder
implements WdFunction {
    private List apX;
    private int apD;
    public static final PluginContract_14 apY = InstanceRegistry_5.apZ;

    private PluginContractBuilder wO() {
        if (this.apX == null) {
            this.apX = Collections.synchronizedList(new ArrayList());
        }
        return this;
    }

    public static PluginContractBuilder wP() {
        return PluginContractBuilder.aO(true);
    }

    public static PluginContractBuilder aO(boolean bl) {
        return bl ? new PluginContractBuilder().wO() : new PluginContractBuilder();
    }

    public List wQ() {
        return this.apX;
    }

    public PluginContractBuilder E(List list) {
        this.apX = list;
        return this;
    }

    public PluginContractBuilder dX(String string) {
        this.apX.add(string);
        return this;
    }

    public PluginContractBuilder F(List list) {
        this.apX.addAll(list);
        return this;
    }

    public int wR() {
        return this.apX.size();
    }

    public String aV(int n) {
        return (String)this.apX.get(n);
    }

    @Override
    public PluginContract_14 wd() {
        return InstanceRegistry_5.apZ;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        PluginContractBuilder pluginContractBuilder = (PluginContractBuilder)object;
        return Objects.equals(this.apX, pluginContractBuilder.apX);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.apX == null ? 0 : this.apX.hashCode());
        return n;
    }

    public String toString() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        if (!this.apX.isEmpty()) {
            arrayList.add((CallSite)((Object)("chunk=" + String.valueOf(this.wQ()))));
        }
        return "PFixedGlitchedChunks{" + String.join((CharSequence)", ", arrayList) + "}";
    }
}
