package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.id;
import lombok.Generated;

@Generated
public abstract class ie
extends fz {
    @Generated
    private double vm;
    @Generated
    private int vA;
    @Generated
    private float vB;

    @Generated
    public ie m(double d) {
        this.vm = d;
        return this.jD();
    }

    @Generated
    public ie W(int n) {
        this.vA = n;
        return this.jD();
    }

    @Generated
    public ie j(float f) {
        this.vB = f;
        return this.jD();
    }

    @Generated
    protected abstract ie jD();

    @Generated
    public abstract id jE();

    @Override
    @Generated
    public String toString() {
        return "RangedBowAttackGoal.RangedBowAttackGoalBuilder(super=" + super.toString() + ", speedModifier=" + this.vm + ", attackIntervalMin=" + this.vA + ", attackRadius=" + this.vB + ")";
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.jE();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.jD();
    }
}
