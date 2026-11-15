package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.ga;
import itemsadder.m.gc;
import lombok.Generated;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class gb
extends fz {
    @Generated
    private EntityType nS;
    @Generated
    private gc uQ;

    @Generated
    public gb c(EntityType entityType) {
        this.nS = entityType;
        return this.in();
    }

    @Generated
    public gb a(@Nullable gc gc2) {
        this.uQ = gc2;
        return this.in();
    }

    @Generated
    protected abstract gb in();

    @Generated
    public abstract ga io();

    @Override
    @Generated
    public String toString() {
        return "AbstractTargetEntityGoal.AbstractTargetEntityGoalBuilder(super=" + super.toString() + ", entityType=" + String.valueOf(this.nS) + ", bukkitTargetSelector=" + String.valueOf(this.uQ) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.io();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.in();
    }
}
