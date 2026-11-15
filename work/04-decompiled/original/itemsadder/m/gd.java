package itemsadder.m;

import itemsadder.m.gc;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.entity.EntityType;

public final class gd
extends Record {
    private final EntityType uR;
    private final gc uS;

    public gd(EntityType entityType, gc gc2) {
        this.uR = entityType;
        this.uS = gc2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{gd.class, "entityType;selector", "uR", "uS"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{gd.class, "entityType;selector", "uR", "uS"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{gd.class, "entityType;selector", "uR", "uS"}, this, object);
    }

    public EntityType ip() {
        return this.uR;
    }

    public gc iq() {
        return this.uS;
    }
}
