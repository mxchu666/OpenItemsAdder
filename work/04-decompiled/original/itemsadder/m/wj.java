package itemsadder.m;

import itemsadder.m.wk;
import java.util.ArrayList;
import java.util.List;

public class wj {
    wk gK;
    List NK;
    List NL;
    long NM = System.currentTimeMillis();
    boolean NN;

    wj() {
        this.NK = new ArrayList();
        this.NL = new ArrayList();
    }

    public wk ry() {
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
