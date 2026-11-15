package itemsadder.m;

import itemsadder.m.bx;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class bv
extends Record {
    private final int hx;
    private final int hy;
    private final int hz;
    private final bx hA;
    private final byte hB;

    public bv(int n, int n2, int n3, bx bx2, byte by) {
        this.hx = n;
        this.hy = n2;
        this.hz = n3;
        this.hA = bx2;
        this.hB = by;
    }

    public String bj() {
        return this.hA.hD;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bv.class, "relX;y;relZ;cropInfo;nextAge", "hx", "hy", "hz", "hA", "hB"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bv.class, "relX;y;relZ;cropInfo;nextAge", "hx", "hy", "hz", "hA", "hB"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bv.class, "relX;y;relZ;cropInfo;nextAge", "hx", "hy", "hz", "hA", "hB"}, this, object);
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

    public bx bv() {
        return this.hA;
    }

    public byte bw() {
        return this.hB;
    }
}
