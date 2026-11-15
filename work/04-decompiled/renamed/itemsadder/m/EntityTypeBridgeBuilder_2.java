package itemsadder.m;

import itemsadder.m.EntityTypeBridge_2;
import itemsadder.m.EntityTypeRefData;
import itemsadder.m.EntityTypeRefDataBuilder;
import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import lombok.Generated;
import org.bukkit.entity.EntityType;

@Generated
public abstract class EntityTypeBridgeBuilder_2
extends EntityTypeRefDataBuilder {
    @Generated
    private EntityType nS;
    @Generated
    private float vj;
    @Generated
    private float mg;
    @Generated
    private boolean vl;

    @Generated
    public EntityTypeBridgeBuilder_2 e(EntityType entityType) {
        this.nS = entityType;
        return this.iW();
    }

    @Generated
    public EntityTypeBridgeBuilder_2 g(float f) {
        this.vj = f;
        return this.iW();
    }

    @Generated
    public EntityTypeBridgeBuilder_2 h(float f) {
        this.mg = f;
        return this.iW();
    }

    @Generated
    public EntityTypeBridgeBuilder_2 U(boolean bl) {
        this.vl = bl;
        return this.iW();
    }

    @Generated
    protected abstract EntityTypeBridgeBuilder_2 iW();

    @Generated
    public abstract EntityTypeBridge_2 iX();

    @Override
    @Generated
    public String toString() {
        return "LookAtEntityGoal.LookAtEntityGoalBuilder(super=" + super.toString() + ", entityType=" + String.valueOf(this.nS) + ", range=" + this.vj + ", chance=" + this.mg + ", lookForward=" + this.vl + ")";
    }

    @Override
    @Generated
    public /* synthetic */ EntityTypeRefData io() {
        return this.iX();
    }

    @Override
    @Generated
    protected /* synthetic */ EntityTypeRefDataBuilder in() {
        return this.iW();
    }

    @Override
    @Generated
    public /* synthetic */ EntityTypeRefDataBuilder c(EntityType entityType) {
        return this.e(entityType);
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.iX();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.iW();
    }
}
