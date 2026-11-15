package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.bee;
import itemsadder.m.beg;
import itemsadder.m.bem;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

final class bef
extends AbstractSet {
    final /* synthetic */ bec aCn;

    bef(bec bec2) {
        this.aCn = bec2;
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
        return new bee(this.aCn);
    }

    @Override
    public final boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        Object k = entry.getKey();
        bem bem2 = this.aCn.L(k);
        return bem2 != null && bem2.equals(entry);
    }

    @Override
    public final boolean remove(Object object) {
        if (object instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry)object;
            Object k = entry.getKey();
            Object v = entry.getValue();
            return this.aCn.b(bec.K(k), k, v, true, true) != null;
        }
        return false;
    }

    @Override
    public final Spliterator spliterator() {
        return new beg(this.aCn, 0, -1, 0, 0);
    }

    @Override
    public final void forEach(Consumer consumer) {
        if (consumer == null) {
            throw new NullPointerException();
        }
        if (this.aCn.tK > 0) {
            bem[] bemArray = this.aCn.aCh;
            if (this.aCn.aCh != null) {
                int n = this.aCn.aCj;
                for (bem bem2 : bemArray) {
                    while (bem2 != null) {
                        consumer.accept(bem2);
                        bem2 = bem2.aCo;
                    }
                }
                if (this.aCn.aCj != n) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
}
