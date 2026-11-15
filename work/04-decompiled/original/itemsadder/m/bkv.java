package itemsadder.m;

import itemsadder.m.bjv;
import itemsadder.m.bko;

public final class bkv
extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    public final Object aGd;
    public final bko aGe;

    public bkv(bjv bjv2) {
        this(bjv2, bjv2.wd());
    }

    public bkv(Object object, bko bko2) {
        this.aGd = object;
        this.aGe = bko2;
    }

    public bkv(String string, bjv bjv2) {
        this(string, bjv2, bjv2.wd());
    }

    public bkv(String string, Object object, bko bko2) {
        super(string);
        this.aGd = object;
        this.aGe = bko2;
    }

    public Object Gx() {
        return this.aGd;
    }

    public bko Gy() {
        return this.aGe;
    }
}
