package itemsadder.m;

import itemsadder.m.bdq;

public class bdr
extends bdq {
    int pU;

    public int DN() {
        ++this.pU;
        return this.pU;
    }

    public void DO() {
        ++this.pU;
    }

    public int DP() {
        return this.pU;
    }
}
