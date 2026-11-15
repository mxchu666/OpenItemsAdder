package itemsadder.m;

import itemsadder.m.ayj;
import itemsadder.m.bjv;
import itemsadder.m.bko;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ayi
implements bjv {
    private List aqb;
    private int apD;
    public static final bko aqc = ayj.aqd;

    private ayi wT() {
        if (this.aqb == null) {
            this.aqb = Collections.synchronizedList(new ArrayList());
        }
        return this;
    }

    public static ayi wU() {
        return ayi.aP(true);
    }

    public static ayi aP(boolean bl) {
        return bl ? new ayi().wT() : new ayi();
    }

    public List wV() {
        return this.aqb;
    }

    public ayi G(List list) {
        this.aqb = list;
        return this;
    }

    public ayi dY(String string) {
        this.aqb.add(string);
        return this;
    }

    public ayi H(List list) {
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
    public bko wd() {
        return ayj.aqd;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ayi ayi2 = (ayi)object;
        return Objects.equals(this.aqb, ayi2.aqb);
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
