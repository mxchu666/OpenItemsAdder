package itemsadder.m;

import itemsadder.m.Builder;
import itemsadder.m.InstanceRegistry_2;
import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Objects;

public final class Builder_2
implements WdFunction {
    private int apH;
    private Builder apI;
    private int apD;
    public static final PluginContract_14 apJ = InstanceRegistry_2.apK;

    private Builder_2 wj() {
        return this;
    }

    public static Builder_2 wk() {
        return Builder_2.aL(true);
    }

    public static Builder_2 aL(boolean bl) {
        return bl ? new Builder_2().wj() : new Builder_2();
    }

    public int wl() {
        if ((this.apD & 1) == 0) {
            return 0;
        }
        return this.apH;
    }

    public Builder_2 aU(int n) {
        this.apH = n;
        this.apD |= 1;
        return this;
    }

    public Builder_2 wm() {
        this.apH = 0;
        this.apD &= 0xFFFFFFFE;
        return this;
    }

    public boolean wn() {
        return (this.apD & 1) == 1;
    }

    public Builder wo() {
        if ((this.apD & 2) == 0) {
            return null;
        }
        return this.apI;
    }

    public Builder_2 b(Builder builder) {
        this.apI = builder;
        this.apD |= 2;
        return this;
    }

    public Builder_2 wp() {
        this.apI = null;
        this.apD &= 0xFFFFFFFD;
        return this;
    }

    public boolean wq() {
        return (this.apD & 2) == 2;
    }

    @Override
    public PluginContract_14 wd() {
        return InstanceRegistry_2.apK;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Builder_2 builder_2 = (Builder_2)object;
        if (!Objects.equals(this.apH, builder_2.apH)) {
            return false;
        }
        return Objects.equals(this.apI, builder_2.apI);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + Integer.hashCode(this.apH);
        n = 31 * n + (this.apI == null ? 0 : this.apI.hashCode());
        return n;
    }

    public String toString() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        if (this.wn()) {
            arrayList.add((CallSite)((Object)("blockId=" + this.wl())));
        }
        if (this.wq()) {
            arrayList.add((CallSite)((Object)("additionalProperties=" + String.valueOf(this.wo()))));
        }
        return "PBlock{" + String.join((CharSequence)", ", arrayList) + "}";
    }
}
