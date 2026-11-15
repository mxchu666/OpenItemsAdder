package itemsadder.m;

import itemsadder.m.EntityTypeRefData;
import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import itemsadder.m.Predicate_2;
import lombok.Generated;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class EntityTypeRefDataBuilder
extends IntBoolDataBuilder {
    @Generated
    private EntityType nS;
    @Generated
    private Predicate_2 uQ;

    @Generated
    public EntityTypeRefDataBuilder c(EntityType entityType) {
        this.nS = entityType;
        return this.in();
    }

    @Generated
    public EntityTypeRefDataBuilder a(@Nullable Predicate_2 predicate_2) {
        this.uQ = predicate_2;
        return this.in();
    }

    @Generated
    protected abstract EntityTypeRefDataBuilder in();

    @Generated
    public abstract EntityTypeRefData io();

    @Override
    @Generated
    public String toString() {
        return "AbstractTargetEntityGoal.AbstractTargetEntityGoalBuilder(super=" + super.toString() + ", entityType=" + String.valueOf(this.nS) + ", bukkitTargetSelector=" + String.valueOf(this.uQ) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.io();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.in();
    }
}
