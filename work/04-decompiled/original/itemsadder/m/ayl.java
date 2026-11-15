package itemsadder.m;

import itemsadder.m.aym;
import itemsadder.m.bjv;
import itemsadder.m.bko;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Objects;

public final class ayl
implements bjv {
    private int aqg;
    private String Qe;
    private int apD;
    public static final bko aqh = aym.aqi;

    private ayl xc() {
        return this;
    }

    public static ayl xd() {
        return ayl.aR(true);
    }

    public static ayl aR(boolean bl) {
        return bl ? new ayl().xc() : new ayl();
    }

    public int xe() {
        if ((this.apD & 1) == 0) {
            return 0;
        }
        return this.aqg;
    }

    public ayl aX(int n) {
        this.aqg = n;
        this.apD |= 1;
        return this;
    }

    public ayl xf() {
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

    public ayl ea(String string) {
        this.Qe = string;
        this.apD |= 2;
        return this;
    }

    public ayl xh() {
        this.Qe = null;
        this.apD &= 0xFFFFFFFD;
        return this;
    }

    public boolean wL() {
        return (this.apD & 2) == 2;
    }

    @Override
    public bko wd() {
        return aym.aqi;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ayl ayl2 = (ayl)object;
        if (!Objects.equals(this.aqg, ayl2.aqg)) {
            return false;
        }
        return Objects.equals(this.Qe, ayl2.Qe);
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
