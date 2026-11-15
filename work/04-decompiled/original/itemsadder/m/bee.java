package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.beh;
import java.util.Iterator;
import java.util.Map;

final class bee
extends beh
implements Iterator {
    bee(bec bec2) {
        super(bec2);
    }

    public final Map.Entry Eb() {
        return this.Ed();
    }

    public /* synthetic */ Object next() {
        return this.Eb();
    }
}
