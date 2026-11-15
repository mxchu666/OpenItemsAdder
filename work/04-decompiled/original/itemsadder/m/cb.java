package itemsadder.m;

import com.google.common.collect.ImmutableList;
import itemsadder.m.ca;
import itemsadder.m.o;
import itemsadder.m.ug;
import itemsadder.m.uh;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class cb
extends uh {
    @Generated
    private ImmutableList iv;
    @Generated
    private Integer iw;
    @Generated
    private Integer ix;
    @Generated
    private Integer iy;
    @Generated
    private o iz;

    @Generated
    public cb a(@Nullable ImmutableList immutableList) {
        this.iv = immutableList;
        return this.bN();
    }

    @Generated
    public cb c(@Nullable Integer n) {
        this.iw = n;
        return this.bN();
    }

    @Generated
    public cb d(@Nullable Integer n) {
        this.ix = n;
        return this.bN();
    }

    @Generated
    public cb e(@Nullable Integer n) {
        this.iy = n;
        return this.bN();
    }

    @Generated
    public cb a(@Nullable o o2) {
        this.iz = o2;
        return this.bN();
    }

    @Generated
    protected abstract cb bN();

    @Generated
    public abstract ca bO();

    @Override
    @Generated
    public String toString() {
        return "CropLoot.CropLootBuilder(super=" + super.toString() + ", triggers=" + String.valueOf(this.iv) + ", ageMin=" + this.iw + ", ageMax=" + this.ix + ", decreaseAge=" + this.iy + ", itemRulesMatcher=" + String.valueOf(this.iz) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ ug bP() {
        return this.bO();
    }

    @Override
    @Generated
    protected /* synthetic */ uh bQ() {
        return this.bN();
    }
}
