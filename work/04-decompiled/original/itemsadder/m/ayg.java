package itemsadder.m;

import itemsadder.m.ayh;
import itemsadder.m.bjv;
import itemsadder.m.bko;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ayg
implements bjv {
    private List apX;
    private int apD;
    public static final bko apY = ayh.apZ;

    private ayg wO() {
        if (this.apX == null) {
            this.apX = Collections.synchronizedList(new ArrayList());
        }
        return this;
    }

    public static ayg wP() {
        return ayg.aO(true);
    }

    public static ayg aO(boolean bl) {
        return bl ? new ayg().wO() : new ayg();
    }

    public List wQ() {
        return this.apX;
    }

    public ayg E(List list) {
        this.apX = list;
        return this;
    }

    public ayg dX(String string) {
        this.apX.add(string);
        return this;
    }

    public ayg F(List list) {
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
    public bko wd() {
        return ayh.apZ;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ayg ayg2 = (ayg)object;
        return Objects.equals(this.apX, ayg2.apX);
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
