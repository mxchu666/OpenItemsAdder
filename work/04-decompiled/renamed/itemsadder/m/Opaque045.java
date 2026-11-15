package itemsadder.m;

import itemsadder.m.Implemented_2;
import itemsadder.m.InstanceHolder_6;
import itemsadder.m.Opaque043;
import itemsadder.m.Opaque044;
import java.util.AbstractCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

final class Opaque045
extends AbstractCollection {
    final /* synthetic */ Implemented_2 aCF;

    Opaque045(Implemented_2 implemented_2) {
        this.aCF = implemented_2;
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
        return new Opaque043(this.aCF);
    }

    @Override
    public final boolean contains(Object object) {
        return this.aCF.containsValue(object);
    }

    @Override
    public final Spliterator spliterator() {
        return new Opaque044(this.aCF, 0, -1, 0, 0);
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
            InstanceHolder_6[] instanceHolder_6Array = this.aCF.aCh;
            if (this.aCF.aCh != null) {
                int n = this.aCF.aCj;
                for (InstanceHolder_6 instanceHolder_6 : instanceHolder_6Array) {
                    while (instanceHolder_6 != null) {
                        consumer.accept(instanceHolder_6.LG);
                        instanceHolder_6 = instanceHolder_6.aCo;
                    }
                }
                if (this.aCF.aCj != n) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
}
