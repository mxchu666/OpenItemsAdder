package itemsadder.m;

import itemsadder.m.RecordOfList;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class RecordOfValue_8
extends Record {
    private final int hu;
    private final int hv;
    private final RecordOfList hw;

    public RecordOfValue_8(int n, int n2, RecordOfList recordOfList) {
        this.hu = n;
        this.hv = n2;
        this.hw = recordOfList;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_8.class, "x;z;view", "hu", "hv", "hw"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_8.class, "x;z;view", "hu", "hv", "hw"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_8.class, "x;z;view", "hu", "hv", "hw"}, this, object);
    }

    public int bo() {
        return this.hu;
    }

    public int bp() {
        return this.hv;
    }

    public RecordOfList bh() {
        return this.hw;
    }
}
