package itemsadder.m;

import itemsadder.m.bjs;
import java.util.AbstractList;
import java.util.List;

public final class bjr
extends AbstractList {
    private final List aFw;
    private final bjs aFx;

    public bjr(List list, bjs bjs2) {
        this.aFw = list;
        this.aFx = bjs2;
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
