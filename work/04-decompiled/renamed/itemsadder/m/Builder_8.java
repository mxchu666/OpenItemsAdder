package itemsadder.m;

import itemsadder.m.EntityTypeBridge;
import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import itemsadder.m.IntBoolDataImpl_5;
import java.util.Arrays;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class Builder_8
extends IntBoolDataBuilder {
    @Generated
    private EntityTypeBridge[] vf;
    @Generated
    private EntityTypeBridge[] vg;

    @Generated
    public Builder_8 a(@Nullable EntityTypeBridge[] entityTypeBridgeArray) {
        this.vf = entityTypeBridgeArray;
        return this.iS();
    }

    @Generated
    public Builder_8 b(@Nullable EntityTypeBridge[] entityTypeBridgeArray) {
        this.vg = entityTypeBridgeArray;
        return this.iS();
    }

    @Generated
    protected abstract Builder_8 iS();

    @Generated
    public abstract IntBoolDataImpl_5 iT();

    @Override
    @Generated
    public String toString() {
        return "HurtByTargetGoal.HurtByTargetGoalBuilder(super=" + super.toString() + ", ignoreDamageFromEntities=" + Arrays.deepToString(this.vf) + ", alertOthersBukkitTypes=" + Arrays.deepToString(this.vg) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.iT();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.iS();
    }
}
