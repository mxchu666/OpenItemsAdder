package itemsadder.m;

import itemsadder.m.Predicate_2;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.entity.EntityType;

public final class RecordOfEntityType
extends Record {
    private final EntityType uR;
    private final Predicate_2 uS;

    public RecordOfEntityType(EntityType entityType, Predicate_2 predicate_2) {
        this.uR = entityType;
        this.uS = predicate_2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfEntityType.class, "entityType;selector", "uR", "uS"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfEntityType.class, "entityType;selector", "uR", "uS"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfEntityType.class, "entityType;selector", "uR", "uS"}, this, object);
    }

    public EntityType ip() {
        return this.uR;
    }

    public Predicate_2 iq() {
        return this.uS;
    }
}
