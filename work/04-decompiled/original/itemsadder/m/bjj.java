package itemsadder.m;

import itemsadder.m.bje;
import itemsadder.m.bjk;
import itemsadder.m.bkk;
import itemsadder.m.bko;
import itemsadder.m.bkx;
import itemsadder.m.blf;

public final class bjj
extends bje {
    private final bjk aFf;
    private int aFg = 0;

    public bjj(bkk bkk2) {
        super(bkk2);
        this.aFf = new bjk();
    }

    public bjj(bkk bkk2, int n) {
        super(bkk2);
        this.aFf = new bjk(n);
    }

    @Override
    public void a(int n, Object object, bko bko2, boolean bl) {
        bkk bkk2 = (bkk)this.aEX;
        if (this.aFf.a(this.aFg, object, bkk2, n)) {
            ++this.aFg;
            bkk2.aGC = bkk2.aGG.g(bkx.K(n, 3), (blf)bkk2, bkk2.aGC);
            bko2.a(this, object);
            bkk2.aGC = bkk2.aGG.g(bkx.K(n, 4), (blf)bkk2, bkk2.aGC);
        }
    }
}
