package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class RecordOfString_4
extends Record {
    private final String gT;
    private final byte gU;

    public RecordOfString_4(String string, byte by) {
        this.gT = string;
        this.gU = by;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfString_4.class, "namespacedId;age", "gT", "gU"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfString_4.class, "namespacedId;age", "gT", "gU"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfString_4.class, "namespacedId;age", "gT", "gU"}, this, object);
    }

    public String bj() {
        return this.gT;
    }

    public byte bk() {
        return this.gU;
    }
}
