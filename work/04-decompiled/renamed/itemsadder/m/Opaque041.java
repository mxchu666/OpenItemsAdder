package itemsadder.m;

import itemsadder.m.Implemented_2;
import itemsadder.m.InstanceHolder_6;
import itemsadder.m.Opaque040;
import itemsadder.m.Opaque042;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

final class Opaque041
extends AbstractSet {
    final /* synthetic */ Implemented_2 aCw;

    Opaque041(Implemented_2 implemented_2) {
        this.aCw = implemented_2;
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
        return new Opaque040(this.aCw);
    }

    @Override
    public final boolean contains(Object object) {
        return this.aCw.containsKey(object);
    }

    @Override
    public final boolean remove(Object object) {
        return this.aCw.b(Implemented_2.K(object), object, null, false, true) != null;
    }

    @Override
    public final Spliterator spliterator() {
        return new Opaque042(this.aCw, 0, -1, 0, 0);
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
            InstanceHolder_6[] instanceHolder_6Array = this.aCw.aCh;
            if (this.aCw.aCh != null) {
                int n = this.aCw.aCj;
                for (InstanceHolder_6 instanceHolder_6 : instanceHolder_6Array) {
                    while (instanceHolder_6 != null) {
                        consumer.accept(instanceHolder_6.aCy);
                        instanceHolder_6 = instanceHolder_6.aCo;
                    }
                }
                if (this.aCw.aCj != n) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
}
