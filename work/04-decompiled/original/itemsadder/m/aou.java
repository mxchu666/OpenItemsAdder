package itemsadder.m;

import itemsadder.m.aot;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class aou
extends Record {
    private final aot akc;
    private final double akd;
    private final double ake;
    private final double akf;
    private final Object akg;
    private final boolean akh;
    private final boolean aki;

    public aou(aot aot2, double d, double d2, double d3, Object object, boolean bl, boolean bl2) {
        this.akc = aot2;
        this.akd = d;
        this.ake = d2;
        this.akf = d3;
        this.akg = object;
        this.akh = bl;
        this.aki = bl2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{aou.class, "identity;x;y;z;metadata;spawn;teleport", "akc", "akd", "ake", "akf", "akg", "akh", "aki"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{aou.class, "identity;x;y;z;metadata;spawn;teleport", "akc", "akd", "ake", "akf", "akg", "akh", "aki"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{aou.class, "identity;x;y;z;metadata;spawn;teleport", "akc", "akd", "ake", "akf", "akg", "akh", "aki"}, this, object);
    }

    public aot uz() {
        return this.akc;
    }

    public double uA() {
        return this.akd;
    }

    public double uB() {
        return this.ake;
    }

    public double uC() {
        return this.akf;
    }

    public Object uD() {
        return this.akg;
    }

    public boolean uE() {
        return this.akh;
    }

    public boolean uF() {
        return this.aki;
    }
}
