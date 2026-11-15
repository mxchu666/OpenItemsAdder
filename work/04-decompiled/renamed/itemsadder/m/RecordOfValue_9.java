package itemsadder.m;

import itemsadder.m.LocationBridge_7;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class RecordOfValue_9
extends Record {
    private final int hx;
    private final int hy;
    private final int hz;
    private final LocationBridge_7 hA;
    private final byte hB;

    public RecordOfValue_9(int n, int n2, int n3, LocationBridge_7 locationBridge_7, byte by) {
        this.hx = n;
        this.hy = n2;
        this.hz = n3;
        this.hA = locationBridge_7;
        this.hB = by;
    }

    public String bj() {
        return this.hA.hD;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_9.class, "relX;y;relZ;cropInfo;nextAge", "hx", "hy", "hz", "hA", "hB"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_9.class, "relX;y;relZ;cropInfo;nextAge", "hx", "hy", "hz", "hA", "hB"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_9.class, "relX;y;relZ;cropInfo;nextAge", "hx", "hy", "hz", "hA", "hB"}, this, object);
    }

    public int bl() {
        return this.hx;
    }

    public int bm() {
        return this.hy;
    }

    public int bn() {
        return this.hz;
    }

    public LocationBridge_7 bv() {
        return this.hA;
    }

    public byte bw() {
        return this.hB;
    }
}
