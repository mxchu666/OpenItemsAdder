package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class di
extends Record {
    private final int mu;
    private final int mv;

    public di(int n, int n2) {
        this.mu = n;
        this.mv = n2;
    }

    public boolean m(int n) {
        return n >= this.mu && n <= this.mv;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{di.class, "min;max", "mu", "mv"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{di.class, "min;max", "mu", "mv"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{di.class, "min;max", "mu", "mv"}, this, object);
    }

    public int dO() {
        return this.mu;
    }

    public int dP() {
        return this.mv;
    }
}
