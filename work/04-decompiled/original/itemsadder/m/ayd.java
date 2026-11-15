package itemsadder.m;

import itemsadder.m.aya;
import itemsadder.m.aye;
import itemsadder.m.bjv;
import itemsadder.m.bko;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Objects;

public final class ayd
implements bjv {
    private String gv;
    private aya apR;
    private int apD;
    public static final bko apS = aye.apT;

    private ayd wF() {
        return this;
    }

    public static ayd wG() {
        return ayd.aN(true);
    }

    public static ayd aN(boolean bl) {
        return bl ? new ayd().wF() : new ayd();
    }

    public String aF() {
        if ((this.apD & 1) == 0) {
            return null;
        }
        return this.gv;
    }

    public ayd dW(String string) {
        this.gv = string;
        this.apD |= 1;
        return this;
    }

    public ayd wH() {
        this.gv = null;
        this.apD &= 0xFFFFFFFE;
        return this;
    }

    public boolean wI() {
        return (this.apD & 1) == 1;
    }

    public aya wJ() {
        if ((this.apD & 2) == 0) {
            return null;
        }
        return this.apR;
    }

    public ayd c(aya aya2) {
        this.apR = aya2;
        this.apD |= 2;
        return this;
    }

    public ayd wK() {
        this.apR = null;
        this.apD &= 0xFFFFFFFD;
        return this;
    }

    public boolean wL() {
        return (this.apD & 2) == 2;
    }

    @Override
    public bko wd() {
        return aye.apT;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ayd ayd2 = (ayd)object;
        if (!Objects.equals(this.gv, ayd2.gv)) {
            return false;
        }
        return Objects.equals(this.apR, ayd2.apR);
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
