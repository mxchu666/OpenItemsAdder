package itemsadder.m;

import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import itemsadder.m.IntBoolDataImpl_6;
import lombok.Generated;

@Generated
public abstract class Builder_9
extends IntBoolDataBuilder {
    @Generated
    private double vm;
    @Generated
    private boolean vn;

    @Generated
    public Builder_9 j(double d) {
        this.vm = d;
        return this.ja();
    }

    @Generated
    public Builder_9 V(boolean bl) {
        this.vn = bl;
        return this.ja();
    }

    @Generated
    protected abstract Builder_9 ja();

    @Generated
    public abstract IntBoolDataImpl_6 jb();

    @Override
    @Generated
    public String toString() {
        return "MeleeAttackGoal.MeleeAttackGoalBuilder(super=" + super.toString() + ", speedModifier=" + this.vm + ", pauseWhenIdle=" + this.vn + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.jb();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.ja();
    }
}
