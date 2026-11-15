package itemsadder.m;

import itemsadder.m.dk;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;

public final class dj
extends Record {
    private final dk mw;
    private final List mx;

    public dj(dk dk2, List list) {
        this.mw = dk2;
        this.mx = list;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{dj.class, "method;types", "mw", "mx"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{dj.class, "method;types", "mw", "mx"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{dj.class, "method;types", "mw", "mx"}, this, object);
    }

    public dk dQ() {
        return this.mw;
    }

    public List dR() {
        return this.mx;
    }
}
