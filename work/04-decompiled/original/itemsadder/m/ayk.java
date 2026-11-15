package itemsadder.m;

import itemsadder.m.ayn;
import itemsadder.m.bjv;
import itemsadder.m.bko;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class ayk
implements bjv {
    private Map Ee;
    private int apD;
    public static final bko aqf = ayn.aqk;

    private ayk wY() {
        if (this.Ee == null) {
            this.Ee = new ConcurrentHashMap();
        }
        return this;
    }

    public static ayk wZ() {
        return ayk.aQ(true);
    }

    public static ayk aQ(boolean bl) {
        return bl ? new ayk().wY() : new ayk();
    }

    public Map xa() {
        return this.Ee;
    }

    public ayk e(Map map) {
        this.Ee = map;
        return this;
    }

    public ayk c(Integer n, String string) {
        this.Ee.put(n, string);
        return this;
    }

    public int xb() {
        return this.Ee.size();
    }

    public boolean K(Integer n) {
        return this.Ee.containsKey(n);
    }

    public boolean dZ(String string) {
        return this.Ee.containsValue(string);
    }

    public String L(Integer n) {
        return (String)this.Ee.get(n);
    }

    public String M(Integer n) {
        return (String)this.Ee.remove(n);
    }

    public boolean d(Integer n, String string) {
        return this.Ee.remove(n, string);
    }

    @Override
    public bko wd() {
        return ayn.aqk;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ayk ayk2 = (ayk)object;
        return Objects.equals(this.Ee, ayk2.Ee);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.Ee == null ? 0 : this.Ee.hashCode());
        return n;
    }

    public String toString() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        if (!this.Ee.isEmpty()) {
            arrayList.add((CallSite)((Object)("data=" + String.valueOf(this.xa()))));
        }
        return "PPalette{" + String.join((CharSequence)", ", arrayList) + "}";
    }
}
