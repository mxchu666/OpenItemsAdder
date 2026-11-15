package itemsadder.m;

import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import itemsadder.m.IntBoolDataImpl_10;
import lombok.Generated;

@Generated
public abstract class Builder_11
extends IntBoolDataBuilder {
    @Generated
    private boolean uU;
    @Generated
    private float mg;

    @Generated
    public Builder_11 X(boolean bl) {
        this.uU = bl;
        return this.jq();
    }

    @Generated
    public Builder_11 i(float f) {
        this.mg = f;
        return this.jq();
    }

    @Generated
    protected abstract Builder_11 jq();

    @Generated
    public abstract IntBoolDataImpl_10 jr();

    @Override
    @Generated
    public String toString() {
        return "RandomTeleportOnHit.RandomTeleportOnHitBuilder(super=" + super.toString() + ", checkVisibility=" + this.uU + ", chance=" + this.mg + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.jr();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.jq();
    }
}
