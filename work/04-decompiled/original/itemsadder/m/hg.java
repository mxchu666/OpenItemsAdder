package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.ga;
import itemsadder.m.gb;
import itemsadder.m.hf;
import lombok.Generated;
import org.bukkit.entity.EntityType;

@Generated
public abstract class hg
extends gb {
    @Generated
    private EntityType nS;
    @Generated
    private float vj;
    @Generated
    private float mg;
    @Generated
    private boolean vl;

    @Generated
    public hg e(EntityType entityType) {
        this.nS = entityType;
        return this.iW();
    }

    @Generated
    public hg g(float f) {
        this.vj = f;
        return this.iW();
    }

    @Generated
    public hg h(float f) {
        this.mg = f;
        return this.iW();
    }

    @Generated
    public hg U(boolean bl) {
        this.vl = bl;
        return this.iW();
    }

    @Generated
    protected abstract hg iW();

    @Generated
    public abstract hf iX();

    @Override
    @Generated
    public String toString() {
        return "LookAtEntityGoal.LookAtEntityGoalBuilder(super=" + super.toString() + ", entityType=" + String.valueOf(this.nS) + ", range=" + this.vj + ", chance=" + this.mg + ", lookForward=" + this.vl + ")";
    }

    @Override
    @Generated
    public /* synthetic */ ga io() {
        return this.iX();
    }

    @Override
    @Generated
    protected /* synthetic */ gb in() {
        return this.iW();
    }

    @Override
    @Generated
    public /* synthetic */ gb c(EntityType entityType) {
        return this.e(entityType);
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.iX();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.iW();
    }
}
