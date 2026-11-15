package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.bem;

class bei {
    final bec aCt;
    bem aCp;
    int aCr;
    int aCu;
    int aCv;
    int aCq;

    bei(bec bec2, int n, int n2, int n3, int n4) {
        this.aCt = bec2;
        this.aCr = n;
        this.aCu = n2;
        this.aCv = n3;
        this.aCq = n4;
    }

    final int Ee() {
        int n = this.aCu;
        if (n < 0) {
            bec bec2 = this.aCt;
            this.aCv = bec2.tK;
            this.aCq = bec2.aCj;
            bem[] bemArray = bec2.aCh;
            this.aCu = bemArray == null ? 0 : bemArray.length;
            n = this.aCu;
        }
        return n;
    }

    public final long estimateSize() {
        this.Ee();
        return this.aCv;
    }
}
