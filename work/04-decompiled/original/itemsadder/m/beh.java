package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.bem;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class beh {
    bem aCo;
    bem aCp;
    int aCq;
    int aCr;
    final /* synthetic */ bec aCs;

    beh(bec bec2) {
        this.aCs = bec2;
        this.aCq = bec2.aCj;
        bem[] bemArray = bec2.aCh;
        this.aCo = null;
        this.aCp = null;
        this.aCr = 0;
        if (bemArray != null && bec2.tK > 0) {
            while (this.aCr < bemArray.length && (this.aCo = bemArray[this.aCr++]) == null) {
            }
        }
    }

    public final boolean hasNext() {
        return this.aCo != null;
    }

    final bem Ed() {
        bem bem2 = this.aCo;
        if (this.aCs.aCj != this.aCq) {
            throw new ConcurrentModificationException();
        }
        if (bem2 == null) {
            throw new NoSuchElementException();
        }
        this.aCp = bem2;
        this.aCo = this.aCp.aCo;
        if (this.aCo == null) {
            bem[] bemArray = this.aCs.aCh;
            if (this.aCs.aCh != null) {
                while (this.aCr < bemArray.length && (this.aCo = bemArray[this.aCr++]) == null) {
                }
            }
        }
        return bem2;
    }

    public final void remove() {
        bem bem2 = this.aCp;
        if (bem2 == null) {
            throw new IllegalStateException();
        }
        if (this.aCs.aCj != this.aCq) {
            throw new ConcurrentModificationException();
        }
        this.aCp = null;
        this.aCs.b(bem2.aCx, bem2.aCy, null, false, false);
        this.aCq = this.aCs.aCj;
    }
}
