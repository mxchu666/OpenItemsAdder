package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.bej;
import itemsadder.m.bel;
import itemsadder.m.bem;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

final class bek
extends AbstractSet {
    final /* synthetic */ bec aCw;

    bek(bec bec2) {
        this.aCw = bec2;
    }

    @Override
    public final int size() {
        return this.aCw.tK;
    }

    @Override
    public final void clear() {
        this.aCw.clear();
    }

    @Override
    public final Iterator iterator() {
        return new bej(this.aCw);
    }

    @Override
    public final boolean contains(Object object) {
        return this.aCw.containsKey(object);
    }

    @Override
    public final boolean remove(Object object) {
        return this.aCw.b(bec.K(object), object, null, false, true) != null;
    }

    @Override
    public final Spliterator spliterator() {
        return new bel(this.aCw, 0, -1, 0, 0);
    }

    @Override
    public Object[] toArray() {
        return this.aCw.e(new Object[this.aCw.tK]);
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.aCw.e(this.aCw.d(objectArray));
    }

    @Override
    public final void forEach(Consumer consumer) {
        if (consumer == null) {
            throw new NullPointerException();
        }
        if (this.aCw.tK > 0) {
            bem[] bemArray = this.aCw.aCh;
            if (this.aCw.aCh != null) {
                int n = this.aCw.aCj;
                for (bem bem2 : bemArray) {
                    while (bem2 != null) {
                        consumer.accept(bem2.aCy);
                        bem2 = bem2.aCo;
                    }
                }
                if (this.aCw.aCj != n) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
}
