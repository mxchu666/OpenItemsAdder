package itemsadder.m;

import itemsadder.m.OFunction;
import java.util.AbstractList;
import java.util.List;

public final class Opaque094
extends AbstractList {
    private final List aFw;
    private final OFunction aFx;

    public Opaque094(List list, OFunction oFunction) {
        this.aFw = list;
        this.aFx = oFunction;
    }

    @Override
    public Object get(int n) {
        return this.aFx.O(this.aFw.get(n));
    }

    @Override
    public int size() {
        return this.aFw.size();
    }
}
