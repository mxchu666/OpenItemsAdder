package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.hu;
import lombok.Generated;

@Generated
public abstract class hv
extends fz {
    @Generated
    private boolean uU;
    @Generated
    private float mg;

    @Generated
    public hv X(boolean bl) {
        this.uU = bl;
        return this.jq();
    }

    @Generated
    public hv i(float f) {
        this.mg = f;
        return this.jq();
    }

    @Generated
    protected abstract hv jq();

    @Generated
    public abstract hu jr();

    @Override
    @Generated
    public String toString() {
        return "RandomTeleportOnHit.RandomTeleportOnHitBuilder(super=" + super.toString() + ", checkVisibility=" + this.uU + ", chance=" + this.mg + ")";
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.jr();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.jq();
    }
}
