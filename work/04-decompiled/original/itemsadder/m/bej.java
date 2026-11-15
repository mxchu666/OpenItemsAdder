package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.beh;
import java.util.Iterator;

final class bej
extends beh
implements Iterator {
    bej(bec bec2) {
        super(bec2);
    }

    public final Object next() {
        return this.Ed().aCy;
    }
}
