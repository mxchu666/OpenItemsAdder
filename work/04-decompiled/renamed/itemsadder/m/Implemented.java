package itemsadder.m;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

public class Implemented
extends AbstractSet
implements Cloneable,
Set {
    private transient HashMap aCa;

    public Implemented() {
        this.aCa = new HashMap();
    }

    public Implemented(Collection collection) {
        this.aCa = new HashMap(Math.max((int)((float)collection.size() / 0.75f) + 1, 16));
        this.addAll(collection);
    }

    public Implemented(int n, float f) {
        this.aCa = new HashMap(n, f);
    }

    public Implemented(int n) {
        this.aCa = new HashMap(n);
    }

    @Override
    public Iterator iterator() {
        return this.aCa.values().iterator();
    }

    @Override
    public int size() {
        return this.aCa.size();
    }

    @Override
    public boolean isEmpty() {
        return this.aCa.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return this.aCa.containsKey(object.hashCode());
    }

    @Override
    public boolean add(Object object) {
        return this.aCa.put(object.hashCode(), object) == null;
    }

    @Override
    public boolean remove(Object object) {
        return this.aCa.remove(object.hashCode()) != null;
    }

    @Override
    public void clear() {
        this.aCa.clear();
    }

    public Object clone() {
        try {
            Implemented implemented = (Implemented)super.clone();
            implemented.aCa = (HashMap)this.aCa.clone();
            return implemented;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError(cloneNotSupportedException);
        }
    }

    @Override
    public Spliterator spliterator() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Object[] toArray() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        throw new RuntimeException("Not implemented");
    }
}
