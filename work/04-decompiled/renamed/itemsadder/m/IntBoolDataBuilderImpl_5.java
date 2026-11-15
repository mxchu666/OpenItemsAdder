package itemsadder.m;

import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import itemsadder.m.IntBoolDataImpl_3;
import java.util.function.Predicate;
import lombok.Generated;

@Generated
public abstract class IntBoolDataBuilderImpl_5
extends IntBoolDataBuilder {
    @Generated
    private Predicate uZ;

    @Generated
    public IntBoolDataBuilderImpl_5 a(Predicate predicate) {
        this.uZ = predicate;
        return this.iI();
    }

    @Generated
    protected abstract IntBoolDataBuilderImpl_5 iI();

    @Generated
    public abstract IntBoolDataImpl_3 iJ();

    @Override
    @Generated
    public String toString() {
        return "EatBlockGoal.EatBlockGoalBuilder(super=" + super.toString() + ", bukkitPredicate=" + String.valueOf(this.uZ) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.iJ();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.iI();
    }
}
