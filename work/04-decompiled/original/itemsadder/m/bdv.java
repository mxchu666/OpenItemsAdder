package itemsadder.m;

import itemsadder.m.bds;
import itemsadder.m.bdu;
import itemsadder.m.bdw;
import itemsadder.m.bdx;
import itemsadder.m.bea;
import java.io.IOException;

public class bdv
extends bea {
    private final bdu aBV;
    private boolean aBW;

    public bdv(bdu bdu2, int n, boolean bl) {
        super(n);
        this.aBV = bdu2;
        if (bl) {
            this.init();
        }
    }

    void init() {
        this.write(bds.aBJ);
        this.bV(4);
    }

    void c(String string, int n, int n2) {
        if (this.aBW) {
            throw new IOException("This buffer is locked!");
        }
        byte[] byArray = string.getBytes();
        this.write(bdx.bT(byArray.length));
        this.write(byArray);
        this.write(bdx.bT(n));
        this.write(bdx.bT(n2));
        this.aBV.bS(this.size());
        this.aBV.a(string, new bdw(n, n2));
    }

    public void DV() {
        this.d(bdx.bT(this.size()), bds.aBJ.length);
        this.aBW = true;
    }
}
