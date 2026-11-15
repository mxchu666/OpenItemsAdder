package itemsadder.m;

import itemsadder.m.Implemented_2;
import itemsadder.m.InstanceHolder_6;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class Opaque038 {
    InstanceHolder_6 aCo;
    InstanceHolder_6 aCp;
    int aCq;
    int aCr;
    final /* synthetic */ Implemented_2 aCs;

    Opaque038(Implemented_2 implemented_2) {
        this.aCs = implemented_2;
        this.aCq = implemented_2.aCj;
        InstanceHolder_6[] instanceHolder_6Array = implemented_2.aCh;
        this.aCo = null;
        this.aCp = null;
        this.aCr = 0;
        if (instanceHolder_6Array != null && implemented_2.tK > 0) {
            while (this.aCr < instanceHolder_6Array.length && (this.aCo = instanceHolder_6Array[this.aCr++]) == null) {
            }
        }
    }

    public final boolean hasNext() {
        return this.aCo != null;
    }

    final InstanceHolder_6 Ed() {
        InstanceHolder_6 instanceHolder_6 = this.aCo;
        if (this.aCs.aCj != this.aCq) {
            throw new ConcurrentModificationException();
        }
        if (instanceHolder_6 == null) {
            throw new NoSuchElementException();
        }
        this.aCp = instanceHolder_6;
        this.aCo = this.aCp.aCo;
        if (this.aCo == null) {
            InstanceHolder_6[] instanceHolder_6Array = this.aCs.aCh;
            if (this.aCs.aCh != null) {
                while (this.aCr < instanceHolder_6Array.length && (this.aCo = instanceHolder_6Array[this.aCr++]) == null) {
                }
            }
        }
        return instanceHolder_6;
    }

    public final void remove() {
        InstanceHolder_6 instanceHolder_6 = this.aCp;
        if (instanceHolder_6 == null) {
            throw new IllegalStateException();
        }
        if (this.aCs.aCj != this.aCq) {
            throw new ConcurrentModificationException();
        }
        this.aCp = null;
        this.aCs.b(instanceHolder_6.aCx, instanceHolder_6.aCy, null, false, false);
        this.aCq = this.aCs.aCj;
    }
}
