package itemsadder.m;

import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import itemsadder.m.IntBoolDataImpl_7;
import java.util.function.Predicate;
import lombok.Generated;

@Generated
public abstract class Builder_10
extends IntBoolDataBuilder {
    @Generated
    private Predicate uZ;
    @Generated
    private double vm;
    @Generated
    private int vq;

    @Generated
    public Builder_10 b(Predicate predicate) {
        this.uZ = predicate;
        return this.je();
    }

    @Generated
    public Builder_10 k(double d) {
        this.vm = d;
        return this.je();
    }

    @Generated
    public Builder_10 S(int n) {
        this.vq = n;
        return this.je();
    }

    @Generated
    protected abstract Builder_10 je();

    @Generated
    public abstract IntBoolDataImpl_7 jf();

    @Override
    @Generated
    public String toString() {
        return "MoveToBlockGoal.MoveToBlockGoalBuilder(super=" + super.toString() + ", bukkitPredicate=" + String.valueOf(this.uZ) + ", speedModifier=" + this.vm + ", searchRange=" + this.vq + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.jf();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.je();
    }
}
