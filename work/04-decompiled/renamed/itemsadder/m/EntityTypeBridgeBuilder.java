package itemsadder.m;

import itemsadder.m.EntityTypeBridge;
import itemsadder.m.Predicate_2;
import lombok.Generated;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

@Generated
public class EntityTypeBridgeBuilder {
    @Generated
    private EntityType vh;
    @Generated
    private Predicate_2 uS;

    @Generated
    EntityTypeBridgeBuilder() {
    }

    @Generated
    public EntityTypeBridgeBuilder d(EntityType entityType) {
        this.vh = entityType;
        return this;
    }

    @Generated
    public EntityTypeBridgeBuilder b(@Nullable Predicate_2 predicate_2) {
        this.uS = predicate_2;
        return this;
    }

    @Generated
    public EntityTypeBridge iR() {
        return new EntityTypeBridge(this.vh, this.uS);
    }

    @Generated
    public String toString() {
        return "HurtByTargetGoal.Entry.EntryBuilder(type=" + String.valueOf(this.vh) + ", selector=" + String.valueOf(this.uS) + ")";
    }
}
