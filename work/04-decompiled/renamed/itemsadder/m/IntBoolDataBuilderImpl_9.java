package itemsadder.m;

import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import itemsadder.m.IntBoolDataImpl_8;
import lombok.Generated;

@Generated
public abstract class IntBoolDataBuilderImpl_9
extends IntBoolDataBuilder {
    @Generated
    private boolean vr;

    @Generated
    public IntBoolDataBuilderImpl_9 W(boolean bl) {
        this.vr = bl;
        return this.ji();
    }

    @Generated
    protected abstract IntBoolDataBuilderImpl_9 ji();

    @Generated
    public abstract IntBoolDataImpl_8 jj();

    @Override
    @Generated
    public String toString() {
        return "OpenDoorGoal.OpenDoorGoalBuilder(super=" + super.toString() + ", closeDoor=" + this.vr + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.jj();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.ji();
    }
}
