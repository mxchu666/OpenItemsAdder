package itemsadder.m;

import itemsadder.m.Implemented_2;
import itemsadder.m.InstanceHolder_6;
import itemsadder.m.Opaque035;
import itemsadder.m.Opaque037;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

final class Opaque036
extends AbstractSet {
    final /* synthetic */ Implemented_2 aCn;

    Opaque036(Implemented_2 implemented_2) {
        this.aCn = implemented_2;
    }

    @Override
    public final int size() {
        return this.aCn.tK;
    }

    @Override
    public final void clear() {
        this.aCn.clear();
    }

    @Override
    public final Iterator iterator() {
        return new Opaque035(this.aCn);
    }

    @Override
    public final boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        Object k = entry.getKey();
        InstanceHolder_6 instanceHolder_6 = this.aCn.L(k);
        return instanceHolder_6 != null && instanceHolder_6.equals(entry);
    }

    @Override
    public final boolean remove(Object object) {
        if (object instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry)object;
            Object k = entry.getKey();
            Object v = entry.getValue();
            return this.aCn.b(Implemented_2.K(k), k, v, true, true) != null;
        }
        return false;
    }

    @Override
    public final Spliterator spliterator() {
        return new Opaque037(this.aCn, 0, -1, 0, 0);
    }

    @Override
    public final void forEach(Consumer consumer) {
        if (consumer == null) {
            throw new NullPointerException();
        }
        if (this.aCn.tK > 0) {
            InstanceHolder_6[] instanceHolder_6Array = this.aCn.aCh;
            if (this.aCn.aCh != null) {
                int n = this.aCn.aCj;
                for (InstanceHolder_6 instanceHolder_6 : instanceHolder_6Array) {
                    while (instanceHolder_6 != null) {
                        consumer.accept(instanceHolder_6);
                        instanceHolder_6 = instanceHolder_6.aCo;
                    }
                }
                if (this.aCn.aCj != n) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
}
