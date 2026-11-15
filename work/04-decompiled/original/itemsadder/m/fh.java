package itemsadder.m;

import itemsadder.m.fg;
import itemsadder.m.fj;
import itemsadder.m.ft;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class fh
extends Record {
    private final fg sD;
    private final ft sE;
    private final fj sF;

    private fh(fg fg2, ft ft2, fj fj2) {
        this.sD = fg2;
        this.sE = ft2;
        this.sF = fj2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{fh.class, "frame;snapshot;viewer", "sD", "sE", "sF"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{fh.class, "frame;snapshot;viewer", "sD", "sE", "sF"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{fh.class, "frame;snapshot;viewer", "sD", "sE", "sF"}, this, object);
    }

    public fg hD() {
        return this.sD;
    }

    public ft hE() {
        return this.sE;
    }

    public fj hF() {
        return this.sF;
    }
}
