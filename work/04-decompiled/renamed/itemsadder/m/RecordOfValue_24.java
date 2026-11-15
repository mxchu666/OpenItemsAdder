package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class RecordOfValue_24
extends Record {
    private final boolean Iv;
    private final boolean Iw;
    private final int Ix;

    public RecordOfValue_24(boolean bl, boolean bl2, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("'elytra.firework.cooldown_ticks' must be non-negative.");
        }
        this.Iv = bl;
        this.Iw = bl2;
        this.Ix = n;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_24.class, "enabled;consume;cooldownTicks", "Iv", "Iw", "Ix"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_24.class, "enabled;consume;cooldownTicks", "Iv", "Iw", "Ix"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_24.class, "enabled;consume;cooldownTicks", "Iv", "Iw", "Ix"}, this, object);
    }

    public boolean ou() {
        return this.Iv;
    }

    public boolean mq() {
        return this.Iw;
    }

    public int fD() {
        return this.Ix;
    }
}
