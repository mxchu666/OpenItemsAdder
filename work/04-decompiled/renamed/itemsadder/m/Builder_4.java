package itemsadder.m;

import itemsadder.m.Builder_2;
import itemsadder.m.InstanceRegistry_3;
import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Objects;

public final class Builder_4
implements WdFunction {
    private String gv;
    private Builder_2 apR;
    private int apD;
    public static final PluginContract_14 apS = InstanceRegistry_3.apT;

    private Builder_4 wF() {
        return this;
    }

    public static Builder_4 wG() {
        return Builder_4.aN(true);
    }

    public static Builder_4 aN(boolean bl) {
        return bl ? new Builder_4().wF() : new Builder_4();
    }

    public String aF() {
        if ((this.apD & 1) == 0) {
            return null;
        }
        return this.gv;
    }

    public Builder_4 dW(String string) {
        this.gv = string;
        this.apD |= 1;
        return this;
    }

    public Builder_4 wH() {
        this.gv = null;
        this.apD &= 0xFFFFFFFE;
        return this;
    }

    public boolean wI() {
        return (this.apD & 1) == 1;
    }

    public Builder_2 wJ() {
        if ((this.apD & 2) == 0) {
            return null;
        }
        return this.apR;
    }

    public Builder_4 c(Builder_2 builder_2) {
        this.apR = builder_2;
        this.apD |= 2;
        return this;
    }

    public Builder_4 wK() {
        this.apR = null;
        this.apD &= 0xFFFFFFFD;
        return this;
    }

    public boolean wL() {
        return (this.apD & 2) == 2;
    }

    @Override
    public PluginContract_14 wd() {
        return InstanceRegistry_3.apT;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Builder_4 builder_4 = (Builder_4)object;
        if (!Objects.equals(this.gv, builder_4.gv)) {
            return false;
        }
        return Objects.equals(this.apR, builder_4.apR);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.gv == null ? 0 : this.gv.hashCode());
        n = 31 * n + (this.apR == null ? 0 : this.apR.hashCode());
        return n;
    }

    public String toString() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        if (this.wI()) {
            arrayList.add((CallSite)((Object)("key=" + this.aF())));
        }
        if (this.wL()) {
            arrayList.add((CallSite)((Object)("value=" + String.valueOf(this.wJ()))));
        }
        return "BlockEntry{" + String.join((CharSequence)", ", arrayList) + "}";
    }
}
