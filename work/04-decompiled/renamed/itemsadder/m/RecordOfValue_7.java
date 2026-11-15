package itemsadder.m;

import itemsadder.m.RecordOfList;
import itemsadder.m.RecordOfUUID;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class RecordOfValue_7
extends Record {
    private final RecordOfUUID ho;
    private final int hp;
    private final RecordOfList hq;

    public RecordOfValue_7(RecordOfUUID recordOfUUID, int n, RecordOfList recordOfList) {
        this.ho = recordOfUUID;
        this.hp = n;
        this.hq = recordOfList;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_7.class, "key;version;view", "ho", "hp", "hq"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_7.class, "key;version;view", "ho", "hp", "hq"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_7.class, "key;version;view", "ho", "hp", "hq"}, this, object);
    }

    public RecordOfUUID br() {
        return this.ho;
    }

    public int bs() {
        return this.hp;
    }

    public RecordOfList bh() {
        return this.hq;
    }
}
