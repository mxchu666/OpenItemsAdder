package itemsadder.m;

import itemsadder.m.EntityTypeRefData;
import itemsadder.m.EntityTypeRefDataBuilder;
import itemsadder.m.EntityTypeRefDataImpl_2;
import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import lombok.Generated;

@Generated
public abstract class Builder_7
extends EntityTypeRefDataBuilder {
    @Generated
    private float uW;
    @Generated
    private double uX;
    @Generated
    private double uY;

    @Generated
    public Builder_7 f(float f) {
        this.uW = f;
        return this.iw();
    }

    @Generated
    public Builder_7 h(double d) {
        this.uX = d;
        return this.iw();
    }

    @Generated
    public Builder_7 i(double d) {
        this.uY = d;
        return this.iw();
    }

    @Generated
    protected abstract Builder_7 iw();

    @Generated
    public abstract EntityTypeRefDataImpl_2 ix();

    @Override
    @Generated
    public String toString() {
        return "AvoidEntityGoal.AvoidEntityGoalBuilder(super=" + super.toString() + ", maxDistance=" + this.uW + ", walkSpeedModifier=" + this.uX + ", sprintSpeedModifier=" + this.uY + ")";
    }

    @Override
    @Generated
    public /* synthetic */ EntityTypeRefData io() {
        return this.ix();
    }

    @Override
    @Generated
    protected /* synthetic */ EntityTypeRefDataBuilder in() {
        return this.iw();
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.ix();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.iw();
    }
}
