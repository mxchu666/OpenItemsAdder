package itemsadder.m;

import itemsadder.m.EntityTypeBridge_3;
import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import lombok.Generated;

@Generated
public abstract class EntityTypeBridgeBuilder_3
extends IntBoolDataBuilder {
    @Generated
    private double vm;
    @Generated
    private int vA;
    @Generated
    private float vB;

    @Generated
    public EntityTypeBridgeBuilder_3 m(double d) {
        this.vm = d;
        return this.jD();
    }

    @Generated
    public EntityTypeBridgeBuilder_3 W(int n) {
        this.vA = n;
        return this.jD();
    }

    @Generated
    public EntityTypeBridgeBuilder_3 j(float f) {
        this.vB = f;
        return this.jD();
    }

    @Generated
    protected abstract EntityTypeBridgeBuilder_3 jD();

    @Generated
    public abstract EntityTypeBridge_3 jE();

    @Override
    @Generated
    public String toString() {
        return "RangedBowAttackGoal.RangedBowAttackGoalBuilder(super=" + super.toString() + ", speedModifier=" + this.vm + ", attackIntervalMin=" + this.vA + ", attackRadius=" + this.vB + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.jE();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.jD();
    }
}
