package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.fz;
import itemsadder.m.ia;
import lombok.Generated;

@Generated
public abstract class ib
extends fz {
    @Generated
    private double vm;
    @Generated
    private int uT;
    @Generated
    private boolean vy;

    @Generated
    public ib l(double d) {
        this.vm = d;
        return this.jy();
    }

    @Generated
    public ib V(int n) {
        this.uT = n;
        return this.jy();
    }

    @Generated
    public ib Y(boolean bl) {
        this.vy = bl;
        return this.jy();
    }

    @Generated
    protected abstract ib jy();

    @Generated
    public abstract ia jz();

    @Override
    @Generated
    public String toString() {
        return "RandomWanderAround.RandomWanderAroundBuilder(super=" + super.toString() + ", speedModifier=" + this.vm + ", interval=" + this.uT + ", checkNoActionTime=" + this.vy + ")";
    }

    @Override
    @Generated
    public /* synthetic */ fy im() {
        return this.jz();
    }

    @Override
    @Generated
    protected /* synthetic */ fz il() {
        return this.jy();
    }
}
