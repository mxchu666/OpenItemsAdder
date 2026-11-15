package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Map;

final class cf
extends Record {
    private final Map awQ;
    private final Map awR;

    private cf(Map map, Map map2) {
        this.awQ = map;
        this.awR = map2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{cf.class, "defaults;blocks", "awQ", "awR"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{cf.class, "defaults;blocks", "awQ", "awR"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{cf.class, "defaults;blocks", "awQ", "awR"}, this, object);
    }

    public Map AM() {
        return this.awQ;
    }

    public Map AN() {
        return this.awR;
    }
}
