package itemsadder.m;

import itemsadder.m.StringClassBoolData;
import java.util.ArrayList;
import java.util.List;

public class Opaque145 {
    StringClassBoolData gK;
    List NK;
    List NL;
    long NM = System.currentTimeMillis();
    boolean NN;

    Opaque145() {
        this.NK = new ArrayList();
        this.NL = new ArrayList();
    }

    public StringClassBoolData ry() {
        return this.gK;
    }

    public List rz() {
        return this.NK;
    }

    public List rA() {
        return this.NL;
    }

    public long rB() {
        return System.currentTimeMillis() - this.NM;
    }

    public boolean rC() {
        return this.NK == null || this.NK.isEmpty();
    }

    public boolean rD() {
        return this.NN;
    }
}
