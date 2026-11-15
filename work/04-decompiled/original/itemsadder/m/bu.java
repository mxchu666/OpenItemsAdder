package itemsadder.m;

import itemsadder.m.bn;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class bu
extends Record {
    private final int hu;
    private final int hv;
    private final bn hw;

    public bu(int n, int n2, bn bn2) {
        this.hu = n;
        this.hv = n2;
        this.hw = bn2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bu.class, "x;z;view", "hu", "hv", "hw"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bu.class, "x;z;view", "hu", "hv", "hw"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bu.class, "x;z;view", "hu", "hv", "hw"}, this, object);
    }

    public int bo() {
        return this.hu;
    }

    public int bp() {
        return this.hv;
    }

    public bn bh() {
        return this.hw;
    }
}
