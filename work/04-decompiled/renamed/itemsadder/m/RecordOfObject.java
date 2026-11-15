package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class RecordOfObject
extends Record {
    private final Object aod;
    private final Object aoe;

    private RecordOfObject(Object object, Object object2) {
        this.aod = object;
        this.aoe = object2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfObject.class, "original;installed", "aod", "aoe"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfObject.class, "original;installed", "aod", "aoe"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfObject.class, "original;installed", "aod", "aoe"}, this, object);
    }

    public Object vy() {
        return this.aod;
    }

    public Object vz() {
        return this.aoe;
    }
}
