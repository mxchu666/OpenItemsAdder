package itemsadder.m;

import itemsadder.m.biw;
import itemsadder.m.bjm;
import itemsadder.m.bjz;
import itemsadder.m.bka;
import itemsadder.m.bkc;

final class bkd
extends bjz {
    static final /* synthetic */ boolean aFC;
    final /* synthetic */ biw aFD;

    bkd(biw biw2) {
        this.aFD = biw2;
    }

    @Override
    protected bjm a(bka bka2) {
        return this.aFD;
    }

    @Override
    protected void a(bka bka2, bjm bjm2, boolean bl) {
        if (bl) {
            return;
        }
        if (!aFC && bjm2 != this.aFD) {
            throw new AssertionError();
        }
    }

    static {
        aFC = !bkc.class.desiredAssertionStatus();
    }
}
