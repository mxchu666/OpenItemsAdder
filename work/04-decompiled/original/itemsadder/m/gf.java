package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.ga;
import itemsadder.m.gb;
import itemsadder.m.ge;
import lombok.Generated;

@Generated
public abstract class gf
extends gb {
    @Generated
    private int uT;
    @Generated
    private boolean uU;
    @Generated
    private boolean uV;

    @Generated
    public gf R(int n) {
        this.uT = n;
        return this.is();
    }

    @Generated
    public gf S(boolean bl) {
        this.uU = bl;
        return this.is();
    }

    @Generated
    public gf T(boolean bl) {
        this.uV = bl;
        return this.is();
    }

    @Generated
    protected abstract gf is();

    @Generated
    public abstract ge it();

    @Override
    @Generated
    public String toString() {
        return "AttackTargetGoal.AttackTargetGoalBuilder(super=" + super.toString() + ", interval=" + this.uT + ", checkVisibility=" + this.uU + ", checkCanNavigate=" + this.uV + ")";
    }

    @Override
    @Generated
    public /* synthetic */ ga io() {
        return this.it();
    }

    @Override
    @Generated
    protected /* synthetic */ gb in() {
        return this.is();
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.it();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.is();
    }
}
