package itemsadder.m;

import itemsadder.m.aya;
import itemsadder.m.ayf;
import itemsadder.m.ayk;
import itemsadder.m.bjv;
import itemsadder.m.bko;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class ayc
implements bjv {
    private Map apM;
    private ayk apN;
    private ayk apO;
    private ayk apP;
    private int apD;
    public static final bko apQ = ayf.apV;

    private ayc ws() {
        if (this.apM == null) {
            this.apM = new ConcurrentHashMap();
        }
        return this;
    }

    public static ayc wt() {
        return ayc.aM(true);
    }

    public static ayc aM(boolean bl) {
        return bl ? new ayc().ws() : new ayc();
    }

    public Map wu() {
        return this.apM;
    }

    public ayc d(Map map) {
        this.apM = map;
        return this;
    }

    public ayc a(String string, aya aya2) {
        this.apM.put(string, aya2);
        return this;
    }

    public int wv() {
        return this.apM.size();
    }

    public boolean dT(String string) {
        return this.apM.containsKey(string);
    }

    public boolean b(aya aya2) {
        return this.apM.containsValue(aya2);
    }

    public aya dU(String string) {
        return (aya)this.apM.get(string);
    }

    public aya dV(String string) {
        return (aya)this.apM.remove(string);
    }

    public boolean b(String string, aya aya2) {
        return this.apM.remove(string, aya2);
    }

    public ayk ww() {
        if ((this.apD & 2) == 0) {
            return null;
        }
        return this.apN;
    }

    public ayc a(ayk ayk2) {
        this.apN = ayk2;
        this.apD |= 2;
        return this;
    }

    public ayc wx() {
        this.apN = null;
        this.apD &= 0xFFFFFFFD;
        return this;
    }

    public boolean wy() {
        return (this.apD & 2) == 2;
    }

    public ayk wz() {
        if ((this.apD & 4) == 0) {
            return null;
        }
        return this.apO;
    }

    public ayc b(ayk ayk2) {
        this.apO = ayk2;
        this.apD |= 4;
        return this;
    }

    public ayc wA() {
        this.apO = null;
        this.apD &= 0xFFFFFFFB;
        return this;
    }

    public boolean wB() {
        return (this.apD & 4) == 4;
    }

    public ayk wC() {
        if ((this.apD & 8) == 0) {
            return null;
        }
        return this.apP;
    }

    public ayc c(ayk ayk2) {
        this.apP = ayk2;
        this.apD |= 8;
        return this;
    }

    public ayc wD() {
        this.apP = null;
        this.apD &= 0xFFFFFFF7;
        return this;
    }

    public boolean wE() {
        return (this.apD & 8) == 8;
    }

    @Override
    public bko wd() {
        return ayf.apV;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ayc ayc2 = (ayc)object;
        if (!Objects.equals(this.apM, ayc2.apM)) {
            return false;
        }
        if (!Objects.equals(this.apN, ayc2.apN)) {
            return false;
        }
        if (!Objects.equals(this.apO, ayc2.apO)) {
            return false;
        }
        return Objects.equals(this.apP, ayc2.apP);
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
