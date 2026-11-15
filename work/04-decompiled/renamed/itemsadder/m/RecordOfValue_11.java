package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class RecordOfValue_11
extends Record {
    private final double lc;
    private final String ld;

    RecordOfValue_11(double d, String string) {
        this.lc = d;
        this.ld = string;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_11.class, "distance;direction", "lc", "ld"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_11.class, "distance;direction", "lc", "ld"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_11.class, "distance;direction", "lc", "ld"}, this, object);
    }

    public double cV() {
        return this.lc;
    }

    public String cW() {
        return this.ld;
    }
}
