package itemsadder.m;

import itemsadder.m.axy;
import itemsadder.m.ayb;
import itemsadder.m.bjv;
import itemsadder.m.bko;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Objects;

public final class aya
implements bjv {
    private int apH;
    private axy apI;
    private int apD;
    public static final bko apJ = ayb.apK;

    private aya wj() {
        return this;
    }

    public static aya wk() {
        return aya.aL(true);
    }

    public static aya aL(boolean bl) {
        return bl ? new aya().wj() : new aya();
    }

    public int wl() {
        if ((this.apD & 1) == 0) {
            return 0;
        }
        return this.apH;
    }

    public aya aU(int n) {
        this.apH = n;
        this.apD |= 1;
        return this;
    }

    public aya wm() {
        this.apH = 0;
        this.apD &= 0xFFFFFFFE;
        return this;
    }

    public boolean wn() {
        return (this.apD & 1) == 1;
    }

    public axy wo() {
        if ((this.apD & 2) == 0) {
            return null;
        }
        return this.apI;
    }

    public aya b(axy axy2) {
        this.apI = axy2;
        this.apD |= 2;
        return this;
    }

    public aya wp() {
        this.apI = null;
        this.apD &= 0xFFFFFFFD;
        return this;
    }

    public boolean wq() {
        return (this.apD & 2) == 2;
    }

    @Override
    public bko wd() {
        return ayb.apK;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        aya aya2 = (aya)object;
        if (!Objects.equals(this.apH, aya2.apH)) {
            return false;
        }
        return Objects.equals(this.apI, aya2.apI);
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
