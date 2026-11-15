package itemsadder.m;

import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import itemsadder.m.IntBoolDataImpl_11;
import lombok.Generated;

@Generated
public abstract class Builder_12
extends IntBoolDataBuilder {
    @Generated
    private int vu;
    @Generated
    private int vv;

    @Generated
    public Builder_12 T(int n) {
        this.vu = n;
        return this.ju();
    }

    @Generated
    public Builder_12 U(int n) {
        this.vv = n;
        return this.ju();
    }

    @Generated
    protected abstract Builder_12 ju();

    @Generated
    public abstract IntBoolDataImpl_11 jv();

    @Override
    @Generated
    public String toString() {
        return "RandomTeleportTimed.RandomTeleportTimedBuilder(super=" + super.toString() + ", minDelay=" + this.vu + ", maxDelay=" + this.vv + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.jv();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.ju();
    }
}
