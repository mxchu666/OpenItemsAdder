package itemsadder.m;

import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilder;
import itemsadder.m.IntBoolDataImpl_12;
import lombok.Generated;

@Generated
public abstract class Builder_13
extends IntBoolDataBuilder {
    @Generated
    private double vm;
    @Generated
    private int uT;
    @Generated
    private boolean vy;

    @Generated
    public Builder_13 l(double d) {
        this.vm = d;
        return this.jy();
    }

    @Generated
    public Builder_13 V(int n) {
        this.uT = n;
        return this.jy();
    }

    @Generated
    public Builder_13 Y(boolean bl) {
        this.vy = bl;
        return this.jy();
    }

    @Generated
    protected abstract Builder_13 jy();

    @Generated
    public abstract IntBoolDataImpl_12 jz();

    @Override
    @Generated
    public String toString() {
        return "RandomWanderAround.RandomWanderAroundBuilder(super=" + super.toString() + ", speedModifier=" + this.vm + ", interval=" + this.uT + ", checkNoActionTime=" + this.vy + ")";
    }

    @Override
    @Generated
    public /* synthetic */ IntBoolData im() {
        return this.jz();
    }

    @Override
    @Generated
    protected /* synthetic */ IntBoolDataBuilder il() {
        return this.jy();
    }
}
