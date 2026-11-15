package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class bq
extends Record {
    private final int ha;
    private final int hb;
    private final int hc;
    private final String hd;
    private final byte he;

    public bq(int n, int n2, int n3, String string, byte by) {
        this.ha = n;
        this.hb = n2;
        this.hc = n3;
        this.hd = string;
        this.he = by;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bq.class, "x;y;z;namespacedId;age", "ha", "hb", "hc", "hd", "he"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bq.class, "x;y;z;namespacedId;age", "ha", "hb", "hc", "hd", "he"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bq.class, "x;y;z;namespacedId;age", "ha", "hb", "hc", "hd", "he"}, this, object);
    }

    public int bo() {
        return this.ha;
    }

    public int bm() {
        return this.hb;
    }

    public int bp() {
        return this.hc;
    }

    public String bj() {
        return this.hd;
    }

    public byte bk() {
        return this.he;
    }
}
