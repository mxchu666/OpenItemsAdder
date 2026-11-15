package itemsadder.m;

import itemsadder.m.Implemented_2;
import itemsadder.m.InstanceHolder_6;

class Opaque039 {
    final Implemented_2 aCt;
    InstanceHolder_6 aCp;
    int aCr;
    int aCu;
    int aCv;
    int aCq;

    Opaque039(Implemented_2 implemented_2, int n, int n2, int n3, int n4) {
        this.aCt = implemented_2;
        this.aCr = n;
        this.aCu = n2;
        this.aCv = n3;
        this.aCq = n4;
    }

    final int Ee() {
        int n = this.aCu;
        if (n < 0) {
            Implemented_2 implemented_2 = this.aCt;
            this.aCv = implemented_2.tK;
            this.aCq = implemented_2.aCj;
            InstanceHolder_6[] instanceHolder_6Array = implemented_2.aCh;
            this.aCu = instanceHolder_6Array == null ? 0 : instanceHolder_6Array.length;
            n = this.aCu;
        }
        return n;
    }

    public final long estimateSize() {
        this.Ee();
        return this.aCv;
    }
}
