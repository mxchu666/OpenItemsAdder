package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class RecordOfValue_25
extends Record {
    private final int IM;
    private final int IN;
    private final float IO;

    public RecordOfValue_25(int n) {
        this(n, n, 100.0f);
    }

    public RecordOfValue_25(int n, int n2, float f) {
        this.IM = n;
        this.IN = n2;
        this.IO = f;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_25.class, "minAmount;maxAmount;chance", "IM", "IN", "IO"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_25.class, "minAmount;maxAmount;chance", "IM", "IN", "IO"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_25.class, "minAmount;maxAmount;chance", "IM", "IN", "IO"}, this, object);
    }

    public int oN() {
        return this.IM;
    }

    public int oO() {
        return this.IN;
    }

    public float dB() {
        return this.IO;
    }
}
