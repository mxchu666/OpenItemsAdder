package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class RecordOfValue_10
extends Record {
    private final double jO;
    private final double jP;
    private final double jQ;
    private final double jR;

    private RecordOfValue_10(double d, double d2, double d3, double d4) {
        this.jO = d;
        this.jP = d2;
        this.jQ = d3;
        this.jR = d4;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_10.class, "eyeX;eyeY;eyeZ;realRange", "jO", "jP", "jQ", "jR"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_10.class, "eyeX;eyeY;eyeZ;realRange", "jO", "jP", "jQ", "jR"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_10.class, "eyeX;eyeY;eyeZ;realRange", "jO", "jP", "jQ", "jR"}, this, object);
    }

    public double cs() {
        return this.jO;
    }

    public double ct() {
        return this.jP;
    }

    public double cu() {
        return this.jQ;
    }

    public double cv() {
        return this.jR;
    }
}
