package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class pj
extends Record {
    private final boolean Ek;
    private final boolean El;
    private final boolean Em;
    static final pj En = new pj(false, true, true);

    pj(boolean bl, boolean bl2, boolean bl3) {
        this.Ek = bl;
        this.El = bl2;
        this.Em = bl3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{pj.class, "handled;allowed;consume", "Ek", "El", "Em"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{pj.class, "handled;allowed;consume", "Ek", "El", "Em"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{pj.class, "handled;allowed;consume", "Ek", "El", "Em"}, this, object);
    }

    public boolean mo() {
        return this.Ek;
    }

    public boolean mp() {
        return this.El;
    }

    public boolean mq() {
        return this.Em;
    }
}
