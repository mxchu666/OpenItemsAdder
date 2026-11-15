package itemsadder.m;

import itemsadder.m.LocationBridge_13;
import itemsadder.m.PlayerBridge_21;
import lombok.Generated;

@Generated
public class LocationBridgeBuilder_3 {
    @Generated
    private PlayerBridge_21 Jz;
    @Generated
    private int Cv;
    @Generated
    private double JB;
    @Generated
    private boolean JC;
    @Generated
    private boolean JD;
    @Generated
    private int JE;
    @Generated
    private int JF;

    @Generated
    LocationBridgeBuilder_3() {
    }

    @Generated
    public LocationBridgeBuilder_3 b(PlayerBridge_21 playerBridge_21) {
        this.Jz = playerBridge_21;
        return this;
    }

    @Generated
    public LocationBridgeBuilder_3 at(int n) {
        this.Cv = n;
        return this;
    }

    @Generated
    public LocationBridgeBuilder_3 o(double d) {
        this.JB = d;
        return this;
    }

    @Generated
    public LocationBridgeBuilder_3 ax(boolean bl) {
        this.JC = bl;
        return this;
    }

    @Generated
    public LocationBridgeBuilder_3 ay(boolean bl) {
        this.JD = bl;
        return this;
    }

    @Generated
    public LocationBridgeBuilder_3 au(int n) {
        this.JE = n;
        return this;
    }

    @Generated
    public LocationBridgeBuilder_3 av(int n) {
        this.JF = n;
        return this;
    }

    @Generated
    public LocationBridge_13 pl() {
        return new LocationBridge_13(this.Jz, this.Cv, this.JB, this.JC, this.JD, this.JE, this.JF);
    }

    @Generated
    public String toString() {
        return "PrimeableSettings.PrimeableSettingsBuilder(itemsMatcher=" + String.valueOf(this.Jz) + ", radius=" + this.Cv + ", damageMultiplier=" + this.JB + ", waterproof=" + this.JC + ", incendiary=" + this.JD + ", fuseTicks=" + this.JE + ", triggers=" + this.JF + ")";
    }
}
