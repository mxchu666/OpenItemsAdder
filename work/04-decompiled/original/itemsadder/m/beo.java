package itemsadder.m;

import itemsadder.m.bec;
import itemsadder.m.beh;
import java.util.Iterator;

final class beo
extends beh
implements Iterator {
    beo(bec bec2) {
        super(bec2);
    }

    public final Object next() {
        return this.Ed().LG;
    }
}
