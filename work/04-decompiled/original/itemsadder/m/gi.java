package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.ga;
import itemsadder.m.gb;
import itemsadder.m.gh;
import lombok.Generated;

@Generated
public abstract class gi
extends gb {
    @Generated
    private float uW;
    @Generated
    private double uX;
    @Generated
    private double uY;

    @Generated
    public gi f(float f) {
        this.uW = f;
        return this.iw();
    }

    @Generated
    public gi h(double d) {
        this.uX = d;
        return this.iw();
    }

    @Generated
    public gi i(double d) {
        this.uY = d;
        return this.iw();
    }

    @Generated
    protected abstract gi iw();

    @Generated
    public abstract gh ix();

    @Override
    @Generated
    public String toString() {
        return "AvoidEntityGoal.AvoidEntityGoalBuilder(super=" + super.toString() + ", maxDistance=" + this.uW + ", walkSpeedModifier=" + this.uX + ", sprintSpeedModifier=" + this.uY + ")";
    }

    @Override
    @Generated
    public /* synthetic */ ga io() {
        return this.ix();
    }

    @Override
    @Generated
    protected /* synthetic */ gb in() {
        return this.iw();
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.ix();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.iw();
    }
}
