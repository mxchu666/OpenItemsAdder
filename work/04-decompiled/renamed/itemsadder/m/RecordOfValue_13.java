package itemsadder.m;

import itemsadder.m.Opaque110;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public final class RecordOfValue_13
extends Record {
    @Nullable
    private final Opaque110 mp;
    @Nullable
    private final Opaque110 mq;

    public RecordOfValue_13(@Nullable Opaque110 opaque110, @Nullable Opaque110 opaque1102) {
        this.mp = opaque110;
        this.mq = opaque1102;
    }

    public boolean o(Location location) {
        if (this.mp != null) {
            if (this.mp.mr != null && location.getBlockX() < this.mp.mr) {
                return false;
            }
            if (this.mp.ms != null && location.getBlockY() < this.mp.ms) {
                return false;
            }
            if (this.mp.mt != null && location.getBlockZ() < this.mp.mt) {
                return false;
            }
        }
        if (this.mq != null) {
            if (this.mq.mr != null && location.getBlockX() > this.mq.mr) {
                return false;
            }
            if (this.mq.ms != null && location.getBlockY() > this.mq.ms) {
                return false;
            }
            if (this.mq.mt != null && location.getBlockZ() > this.mq.mt) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_13.class, "min;max", "mp", "mq"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_13.class, "min;max", "mp", "mq"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_13.class, "min;max", "mp", "mq"}, this, object);
    }

    @Nullable
    public Opaque110 dL() {
        return this.mp;
    }

    @Nullable
    public Opaque110 dM() {
        return this.mq;
    }
}
