package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.gs;
import java.util.function.Predicate;
import lombok.Generated;

@Generated
public abstract class gt
extends fz {
    @Generated
    private Predicate uZ;

    @Generated
    public gt a(Predicate predicate) {
        this.uZ = predicate;
        return this.iI();
    }

    @Generated
    protected abstract gt iI();

    @Generated
    public abstract gs iJ();

    @Override
    @Generated
    public String toString() {
        return "EatBlockGoal.EatBlockGoalBuilder(super=" + super.toString() + ", bukkitPredicate=" + String.valueOf(this.uZ) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.iJ();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.iI();
    }
}
