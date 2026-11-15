package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.bj;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class y
extends Record {
    private final bj arS;
    private final String arT;

    private y(bj bj2, String string) {
        this.arS = bj2;
        this.arT = string;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{y.class, "status;reason", "arS", "arT"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{y.class, "status;reason", "arS", "arT"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{y.class, "status;reason", "arS", "arT"}, this, object);
    }

    public bj yv() {
        return this.arS;
    }

    public String xQ() {
        return this.arT;
    }
}
