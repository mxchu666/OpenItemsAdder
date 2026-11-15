package itemsadder.m;

import com.google.common.collect.ImmutableList;
import itemsadder.m.LocationBridgeBuilder_4;
import itemsadder.m.LocationBridge_14;
import itemsadder.m.PlayerBridge_21;
import itemsadder.m.PlayerBridge_6;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class PlayerBridgeBuilder
extends LocationBridgeBuilder_4 {
    @Generated
    private ImmutableList iv;
    @Generated
    private Integer iw;
    @Generated
    private Integer ix;
    @Generated
    private Integer iy;
    @Generated
    private PlayerBridge_21 iz;

    @Generated
    public PlayerBridgeBuilder a(@Nullable ImmutableList immutableList) {
        this.iv = immutableList;
        return this.bN();
    }

    @Generated
    public PlayerBridgeBuilder c(@Nullable Integer n) {
        this.iw = n;
        return this.bN();
    }

    @Generated
    public PlayerBridgeBuilder d(@Nullable Integer n) {
        this.ix = n;
        return this.bN();
    }

    @Generated
    public PlayerBridgeBuilder e(@Nullable Integer n) {
        this.iy = n;
        return this.bN();
    }

    @Generated
    public PlayerBridgeBuilder a(@Nullable PlayerBridge_21 playerBridge_21) {
        this.iz = playerBridge_21;
        return this.bN();
    }

    @Generated
    protected abstract PlayerBridgeBuilder bN();

    @Generated
    public abstract PlayerBridge_6 bO();

    @Override
    @Generated
    public String toString() {
        return "CropLoot.CropLootBuilder(super=" + super.toString() + ", triggers=" + String.valueOf(this.iv) + ", ageMin=" + this.iw + ", ageMax=" + this.ix + ", decreaseAge=" + this.iy + ", itemRulesMatcher=" + String.valueOf(this.iz) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ LocationBridge_14 bP() {
        return this.bO();
    }

    @Override
    @Generated
    protected /* synthetic */ LocationBridgeBuilder_4 bQ() {
        return this.bN();
    }
}
