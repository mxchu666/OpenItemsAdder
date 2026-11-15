package itemsadder.m;

import itemsadder.m.EntityTypeRefData;
import itemsadder.m.EntityTypeRefDataBuilder;
import itemsadder.m.EntityTypeRefDataImpl;
import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import lombok.Generated;

@Generated
public abstract class Builder_6
extends EntityTypeRefDataBuilder {
    @Generated
    private int uT;
    @Generated
    private boolean uU;
    @Generated
    private boolean uV;

    @Generated
    public Builder_6 R(int n) {
        this.uT = n;
        return this.is();
    }

    @Generated
    public Builder_6 S(boolean bl) {
        this.uU = bl;
        return this.is();
    }

    @Generated
    public Builder_6 T(boolean bl) {
        this.uV = bl;
        return this.is();
    }

    @Generated
    protected abstract Builder_6 is();

    @Generated
    public abstract EntityTypeRefDataImpl it();

    @Override
    @Generated
    public String toString() {
        return "AttackTargetGoal.AttackTargetGoalBuilder(super=" + super.toString() + ", interval=" + this.uT + ", checkVisibility=" + this.uU + ", checkCanNavigate=" + this.uV + ")";
    }

    @Override
    @Generated
    public /* synthetic */ EntityTypeRefData io() {
        return this.it();
    }

    @Override
    @Generated
    protected /* synthetic */ EntityTypeRefDataBuilder in() {
        return this.is();
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.it();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.is();
    }
}
