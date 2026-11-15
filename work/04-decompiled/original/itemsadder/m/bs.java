package itemsadder.m;

import itemsadder.m.bn;
import itemsadder.m.bt;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class bs
extends Record {
    private final bt ho;
    private final int hp;
    private final bn hq;

    public bs(bt bt2, int n, bn bn2) {
        this.ho = bt2;
        this.hp = n;
        this.hq = bn2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bs.class, "key;version;view", "ho", "hp", "hq"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bs.class, "key;version;view", "ho", "hp", "hq"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bs.class, "key;version;view", "ho", "hp", "hq"}, this, object);
    }

    public bt br() {
        return this.ho;
    }

    public int bs() {
        return this.hp;
    }

    public bn bh() {
        return this.hq;
    }
}
