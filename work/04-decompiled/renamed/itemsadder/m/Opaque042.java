package itemsadder.m;

import itemsadder.m.Implemented_2;
import itemsadder.m.InstanceHolder_6;
import itemsadder.m.Opaque039;
import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;

final class Opaque042
extends Opaque039
implements Spliterator {
    Opaque042(Implemented_2 implemented_2, int n, int n2, int n3, int n4) {
        super(implemented_2, n, n2, n3, n4);
    }

    public Opaque042 Ef() {
        Opaque042 opaque042;
        int n = this.aCr;
        int n2 = this.Ee();
        int n3 = n + n2 >>> 1;
        if (n >= n3 || this.aCp != null) {
            opaque042 = null;
        } else {
            this.aCr = n3;
            Opaque042 opaque0422 = new Opaque042(this.aCt, n, this.aCr, this.aCv >>>= 1, this.aCq);
            opaque042 = opaque0422;
        }
        return opaque042;
    }

    public void forEachRemaining(Consumer consumer) {
        int n;
        int n2;
        if (consumer == null) {
            throw new NullPointerException();
        }
        Implemented_2 implemented_2 = this.aCt;
        InstanceHolder_6[] instanceHolder_6Array = implemented_2.aCh;
        int n3 = this.aCu;
        if (n3 < 0) {
            n2 = this.aCq = implemented_2.aCj;
            this.aCu = instanceHolder_6Array == null ? 0 : instanceHolder_6Array.length;
            n3 = this.aCu;
        } else {
            n2 = this.aCq;
        }
        if (instanceHolder_6Array != null && instanceHolder_6Array.length >= n3 && (n = this.aCr) >= 0 && (n < (this.aCr = n3) || this.aCp != null)) {
            InstanceHolder_6 instanceHolder_6 = this.aCp;
            this.aCp = null;
            do {
                if (instanceHolder_6 == null) {
                    instanceHolder_6 = instanceHolder_6Array[n++];
                    continue;
                }
                consumer.accept(instanceHolder_6.aCy);
                instanceHolder_6 = instanceHolder_6.aCo;
            } while (instanceHolder_6 != null || n < n3);
            if (implemented_2.aCj != n2) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public boolean tryAdvance(Consumer consumer) {
        int n;
        if (consumer == null) {
            throw new NullPointerException();
        }
        InstanceHolder_6[] instanceHolder_6Array = this.aCt.aCh;
        if (instanceHolder_6Array != null && instanceHolder_6Array.length >= (n = this.Ee()) && this.aCr >= 0) {
            while (this.aCp != null || this.aCr < n) {
                if (this.aCp == null) {
                    this.aCp = instanceHolder_6Array[this.aCr++];
                    continue;
                }
                Object object = this.aCp.aCy;
                this.aCp = this.aCp.aCo;
                consumer.accept(object);
                if (this.aCt.aCj != this.aCq) {
                    throw new ConcurrentModificationException();
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int characteristics() {
        return (this.aCu < 0 || this.aCv == this.aCt.tK ? 64 : 0) | 1;
    }

    public /* synthetic */ Spliterator trySplit() {
        return this.Ef();
    }
}
