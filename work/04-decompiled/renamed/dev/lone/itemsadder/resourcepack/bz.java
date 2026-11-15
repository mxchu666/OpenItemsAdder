package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.cb;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;

final class bz
extends Record {
    private final List awB;

    bz(List list) {
        this.awB = list;
    }

    long AA() {
        return this.awB.stream().filter(bs2 -> bs2.Ag() == cb.ERROR).count();
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bz.class, "diagnostics", "awB"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bz.class, "diagnostics", "awB"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bz.class, "diagnostics", "awB"}, this, object);
    }

    public List AB() {
        return this.awB;
    }
}
