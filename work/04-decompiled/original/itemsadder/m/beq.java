package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.bem;
import itemsadder.m.beo;
import itemsadder.m.bep;
import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

final class beq
extends AbstractCollection {
    final /* synthetic */ bec aCF;

    beq(bec bec2) {
        this.aCF = bec2;
    }

    @Override
    public final int size() {
        return this.aCF.tK;
    }

    @Override
    public final void clear() {
        this.aCF.clear();
    }

    @Override
    public final Iterator iterator() {
        return new beo(this.aCF);
    }

    @Override
    public final boolean contains(Object object) {
        return this.aCF.containsValue(object);
    }

    @Override
    public final Spliterator spliterator() {
        return new bep(this.aCF, 0, -1, 0, 0);
    }

    @Override
    public Object[] toArray() {
        return this.aCF.f(new Object[this.aCF.tK]);
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.aCF.f(this.aCF.d(objectArray));
    }

    @Override
    public final void forEach(Consumer consumer) {
        if (consumer == null) {
            throw new NullPointerException();
        }
        if (this.aCF.tK > 0) {
            bem[] bemArray = this.aCF.aCh;
            if (this.aCF.aCh != null) {
                int n = this.aCF.aCj;
                for (bem bem2 : bemArray) {
                    while (bem2 != null) {
                        consumer.accept(bem2.LG);
                        bem2 = bem2.aCo;
                    }
                }
                if (this.aCF.aCj != n) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
}
