package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.ha;
import itemsadder.m.hb;
import java.util.Arrays;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class hd
extends fz {
    @Generated
    private hb[] vf;
    @Generated
    private hb[] vg;

    @Generated
    public hd a(@Nullable hb[] hbArray) {
        this.vf = hbArray;
        return this.iS();
    }

    @Generated
    public hd b(@Nullable hb[] hbArray) {
        this.vg = hbArray;
        return this.iS();
    }

    @Generated
    protected abstract hd iS();

    @Generated
    public abstract ha iT();

    @Override
    @Generated
    public String toString() {
        return "HurtByTargetGoal.HurtByTargetGoalBuilder(super=" + super.toString() + ", ignoreDamageFromEntities=" + Arrays.deepToString(this.vf) + ", alertOthersBukkitTypes=" + Arrays.deepToString(this.vg) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.iT();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.iS();
    }
}
