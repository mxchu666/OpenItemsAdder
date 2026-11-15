package itemsadder.m;

import itemsadder.m.biw;
import itemsadder.m.bjm;
import itemsadder.m.bjz;
import itemsadder.m.bka;
import itemsadder.m.bkh;

final class bki
extends bjz {
    static final /* synthetic */ boolean aFJ;
    final /* synthetic */ biw aFK;

    bki(biw biw2) {
        this.aFK = biw2;
    }

    @Override
    protected bjm a(bka bka2) {
        return this.aFK;
    }

    @Override
    protected void a(bka bka2, bjm bjm2, boolean bl) {
        if (bl) {
            return;
        }
        if (!aFJ && bjm2 != this.aFK) {
            throw new AssertionError();
        }
    }

    static {
        aFJ = !bkh.class.desiredAssertionStatus();
    }
}
