package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.hl;
import java.util.function.Predicate;
import lombok.Generated;

@Generated
public abstract class hm
extends fz {
    @Generated
    private Predicate uZ;
    @Generated
    private double vm;
    @Generated
    private int vq;

    @Generated
    public hm b(Predicate predicate) {
        this.uZ = predicate;
        return this.je();
    }

    @Generated
    public hm k(double d) {
        this.vm = d;
        return this.je();
    }

    @Generated
    public hm S(int n) {
        this.vq = n;
        return this.je();
    }

    @Generated
    protected abstract hm je();

    @Generated
    public abstract hl jf();

    @Override
    @Generated
    public String toString() {
        return "MoveToBlockGoal.MoveToBlockGoalBuilder(super=" + super.toString() + ", bukkitPredicate=" + String.valueOf(this.uZ) + ", speedModifier=" + this.vm + ", searchRange=" + this.vq + ")";
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.jf();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.je();
    }
}
