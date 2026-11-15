package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;

final class RecordOfValue_16
extends Record {
    private final long[] sl;
    private final byte[] sm;
    private static final RecordOfValue_16 sn = new RecordOfValue_16(new long[0], new byte[0]);

    private RecordOfValue_16(long[] lArray, byte[] byArray) {
        this.sl = lArray;
        this.sm = byArray;
    }

    private int f(long l) {
        int n = Arrays.binarySearch(this.sl, l);
        return n < 0 ? -1 : this.sm[n];
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_16.class, "blockKeys;stages", "sl", "sm"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_16.class, "blockKeys;stages", "sl", "sm"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_16.class, "blockKeys;stages", "sl", "sm"}, this, object);
    }

    public long[] hq() {
        return this.sl;
    }

    public byte[] hr() {
        return this.sm;
    }
}
