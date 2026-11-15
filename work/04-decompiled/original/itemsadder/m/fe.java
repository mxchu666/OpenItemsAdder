package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;

final class fe
extends Record {
    private final long[] sl;
    private final byte[] sm;
    private static final fe sn = new fe(new long[0], new byte[0]);

    private fe(long[] lArray, byte[] byArray) {
        this.sl = lArray;
        this.sm = byArray;
    }

    private int f(long l) {
        int n = Arrays.binarySearch(this.sl, l);
        return n < 0 ? -1 : this.sm[n];
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{fe.class, "blockKeys;stages", "sl", "sm"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{fe.class, "blockKeys;stages", "sl", "sm"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{fe.class, "blockKeys;stages", "sl", "sm"}, this, object);
    }

    public long[] hq() {
        return this.sl;
    }

    public byte[] hr() {
        return this.sm;
    }
}
