package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.hx;
import lombok.Generated;

@Generated
public abstract class hy
extends fz {
    @Generated
    private int vu;
    @Generated
    private int vv;

    @Generated
    public hy T(int n) {
        this.vu = n;
        return this.ju();
    }

    @Generated
    public hy U(int n) {
        this.vv = n;
        return this.ju();
    }

    @Generated
    protected abstract hy ju();

    @Generated
    public abstract hx jv();

    @Override
    @Generated
    public String toString() {
        return "RandomTeleportTimed.RandomTeleportTimedBuilder(super=" + super.toString() + ", minDelay=" + this.vu + ", maxDelay=" + this.vv + ")";
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.jv();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.ju();
    }
}
