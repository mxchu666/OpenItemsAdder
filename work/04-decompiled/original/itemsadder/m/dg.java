package itemsadder.m;

import itemsadder.m.dh;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;

public final class dg
extends Record {
    @Nullable
    private final dh mp;
    @Nullable
    private final dh mq;

    public dg(@Nullable dh dh2, @Nullable dh dh3) {
        this.mp = dh2;
        this.mq = dh3;
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
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{dg.class, "min;max", "mp", "mq"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{dg.class, "min;max", "mp", "mq"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{dg.class, "min;max", "mp", "mq"}, this, object);
    }

    @Nullable
    public dh dL() {
        return this.mp;
    }

    @Nullable
    public dh dM() {
        return this.mq;
    }
}
