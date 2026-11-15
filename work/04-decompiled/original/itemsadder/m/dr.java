package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class dr
extends Record {
    private final String ov;
    private final double ow;
    private final int ox;

    public dr(String string, double d, int n) {
        this.ov = string;
        this.ow = d;
        this.ox = n;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{dr.class, "sound;chancePerTick;cooldownTicks", "ov", "ow", "ox"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{dr.class, "sound;chancePerTick;cooldownTicks", "ov", "ow", "ox"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{dr.class, "sound;chancePerTick;cooldownTicks", "ov", "ow", "ox"}, this, object);
    }

    public String fB() {
        return this.ov;
    }

    public double fC() {
        return this.ow;
    }

    public int fD() {
        return this.ox;
    }
}
