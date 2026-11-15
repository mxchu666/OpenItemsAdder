package itemsadder.m;

import itemsadder.m.biz;
import itemsadder.m.bjm;
import itemsadder.m.bjz;
import itemsadder.m.bka;
import itemsadder.m.bkh;

final class bkj
extends bjz {
    static final /* synthetic */ boolean aFL;
    final /* synthetic */ biz aFM;

    bkj(biz biz2) {
        this.aFM = biz2;
    }

    @Override
    protected bjm a(bka bka2) {
        return this.aFM;
    }

    @Override
    protected void a(bka bka2, bjm bjm2, boolean bl) {
        if (bl) {
            return;
        }
        if (!aFL && bjm2 != this.aFM) {
            throw new AssertionError();
        }
    }

    static {
        aFL = !bkh.class.desiredAssertionStatus();
    }
}
