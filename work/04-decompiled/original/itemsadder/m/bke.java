package itemsadder.m;

import itemsadder.m.biz;
import itemsadder.m.bjm;
import itemsadder.m.bjz;
import itemsadder.m.bka;
import itemsadder.m.bkc;

final class bke
extends bjz {
    static final /* synthetic */ boolean aFE;
    final /* synthetic */ biz aFF;

    bke(biz biz2) {
        this.aFF = biz2;
    }

    @Override
    protected bjm a(bka bka2) {
        return this.aFF;
    }

    @Override
    protected void a(bka bka2, bjm bjm2, boolean bl) {
        if (bl) {
            return;
        }
        if (!aFE && bjm2 != this.aFF) {
            throw new AssertionError();
        }
    }

    static {
        aFE = !bkc.class.desiredAssertionStatus();
    }
}
