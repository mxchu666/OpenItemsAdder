package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.bei;
import itemsadder.m.bem;
import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;

final class bep
extends bei
implements Spliterator {
    bep(bec bec2, int n, int n2, int n3, int n4) {
        super(bec2, n, n2, n3, n4);
    }

    public bep Eh() {
        bep bep2;
        int n = this.aCr;
        int n2 = this.Ee();
        int n3 = n + n2 >>> 1;
        if (n >= n3 || this.aCp != null) {
            bep2 = null;
        } else {
            this.aCr = n3;
            bep bep3 = new bep(this.aCt, n, this.aCr, this.aCv >>>= 1, this.aCq);
            bep2 = bep3;
        }
        return bep2;
    }

    public void forEachRemaining(Consumer consumer) {
        int n;
        int n2;
        if (consumer == null) {
            throw new NullPointerException();
        }
        bec bec2 = this.aCt;
        bem[] bemArray = bec2.aCh;
        int n3 = this.aCu;
        if (n3 < 0) {
            n2 = this.aCq = bec2.aCj;
            this.aCu = bemArray == null ? 0 : bemArray.length;
            n3 = this.aCu;
        } else {
            n2 = this.aCq;
        }
        if (bemArray != null && bemArray.length >= n3 && (n = this.aCr) >= 0 && (n < (this.aCr = n3) || this.aCp != null)) {
            bem bem2 = this.aCp;
            this.aCp = null;
            do {
                if (bem2 == null) {
                    bem2 = bemArray[n++];
                    continue;
                }
                consumer.accept(bem2.LG);
                bem2 = bem2.aCo;
            } while (bem2 != null || n < n3);
            if (bec2.aCj != n2) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public boolean tryAdvance(Consumer consumer) {
        int n;
        if (consumer == null) {
            throw new NullPointerException();
        }
        bem[] bemArray = this.aCt.aCh;
        if (bemArray != null && bemArray.length >= (n = this.Ee()) && this.aCr >= 0) {
            while (this.aCp != null || this.aCr < n) {
                if (this.aCp == null) {
                    this.aCp = bemArray[this.aCr++];
                    continue;
                }
                Object object = this.aCp.LG;
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
        return this.aCu < 0 || this.aCv == this.aCt.tK ? 64 : 0;
    }

    public /* synthetic */ Spliterator trySplit() {
        return this.Eh();
    }
}
