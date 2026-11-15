package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;

final class cc
extends Record {
    private final String awJ;
    private final int awK;
    private final List awL;

    cc(String string, int n, List list) {
        this.awJ = string;
        this.awK = n;
        this.awL = list;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{cc.class, "file;line;includeStack", "awJ", "awK", "awL"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{cc.class, "file;line;includeStack", "awJ", "awK", "awL"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{cc.class, "file;line;includeStack", "awJ", "awK", "awL"}, this, object);
    }

    public String AI() {
        return this.awJ;
    }

    public int Ad() {
        return this.awK;
    }

    public List Al() {
        return this.awL;
    }
}
