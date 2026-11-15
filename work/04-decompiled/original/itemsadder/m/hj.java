package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.hi;
import lombok.Generated;

@Generated
public abstract class hj
extends fz {
    @Generated
    private double vm;
    @Generated
    private boolean vn;

    @Generated
    public hj j(double d) {
        this.vm = d;
        return this.ja();
    }

    @Generated
    public hj V(boolean bl) {
        this.vn = bl;
        return this.ja();
    }

    @Generated
    protected abstract hj ja();

    @Generated
    public abstract hi jb();

    @Override
    @Generated
    public String toString() {
        return "MeleeAttackGoal.MeleeAttackGoalBuilder(super=" + super.toString() + ", speedModifier=" + this.vm + ", pauseWhenIdle=" + this.vn + ")";
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.jb();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.ja();
    }
}
