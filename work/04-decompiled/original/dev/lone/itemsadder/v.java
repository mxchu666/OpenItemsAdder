package dev.lone.itemsadder;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.time.Instant;

final class v
extends Record {
    private final String RR;
    private final String RS;
    private final String RT;
    private final Instant RU;

    v(String string, String string2, String string3, Instant instant) {
        this.RR = string;
        this.RS = string2;
        this.RT = string3;
        this.RU = instant;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{v.class, "name;tag;ref;date", "RR", "RS", "RT", "RU"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{v.class, "name;tag;ref;date", "RR", "RS", "RT", "RU"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{v.class, "name;tag;ref;date", "RR", "RS", "RT", "RU"}, this, object);
    }

    public String fN() {
        return this.RR;
    }

    public String sk() {
        return this.RS;
    }

    public String sl() {
        return this.RT;
    }

    public Instant sm() {
        return this.RU;
    }
}
