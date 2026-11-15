package itemsadder.m;

import com.google.common.collect.ImmutableMap;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_7;
import itemsadder.m.VectorBridge_2;
import lombok.Generated;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers detected
 */
@Generated
public class LocationBridgeBuilder {
    @Generated
    private String namespacedId;
    @Generated
    private ItemStackBuilder_4 hE;
    @Generated
    private String hF;
    @Generated
    private String hG;
    @Generated
    private String hH;
    @Generated
    private VectorBridge_2 hI;
    @Generated
    private ImmutableMap hJ;
    @Generated
    private int hK;
    @Generated
    private String hL;
    @Generated
    private Material hM;
    @Generated
    private boolean hN;
    @Generated
    private boolean hO;
    @Generated
    private boolean if;
    @Generated
    private double ig;
    @Generated
    private boolean ih;
    @Generated
    private int ii;
    @Generated
    private Integer hR;
    @Generated
    private boolean ij;
    @Generated
    private float ik;
    @Generated
    private boolean il;
    @Generated
    private double im;
    @Generated
    private boolean in;
    @Generated
    private float io;
    @Generated
    private boolean ip;
    @Generated
    private float iq;
    @Generated
    private boolean ir;
    @Generated
    private float is;
    @Generated
    private boolean it;
    @Generated
    private boolean iu;
    @Generated
    private ImmutableMap hY;

    @Generated
    LocationBridgeBuilder() {
    }

    @Generated
    public LocationBridgeBuilder ac(String string) {
        this.namespacedId = string;
        return this;
    }

    @Generated
    public LocationBridgeBuilder b(ItemStackBuilder_4 itemStackBuilder_4) {
        this.hE = itemStackBuilder_4;
        return this;
    }

    @Generated
    public LocationBridgeBuilder ad(String string) {
        this.hF = string;
        return this;
    }

    @Generated
    public LocationBridgeBuilder ae(String string) {
        this.hG = string;
        return this;
    }

    @Generated
    public LocationBridgeBuilder af(String string) {
        this.hH = string;
        return this;
    }

    @Generated
    public LocationBridgeBuilder a(VectorBridge_2 vectorBridge_2) {
        this.hI = vectorBridge_2;
        return this;
    }

    @Generated
    public LocationBridgeBuilder a(ImmutableMap immutableMap) {
        this.hJ = immutableMap;
        return this;
    }

    @Generated
    public LocationBridgeBuilder g(int n) {
        this.hK = n;
        return this;
    }

    @Generated
    public LocationBridgeBuilder ag(String string) {
        this.hL = string;
        return this;
    }

    @Generated
    public LocationBridgeBuilder b(Material material) {
        this.hM = material;
        return this;
    }

    @Generated
    public LocationBridgeBuilder m(boolean bl) {
        this.hN = bl;
        return this;
    }

    @Generated
    public LocationBridgeBuilder n(boolean bl) {
        this.hO = bl;
        return this;
    }

    @Generated
    public LocationBridgeBuilder a(double d) {
        this.ig = d;
        this.if = true;
        return this;
    }

    @Generated
    public LocationBridgeBuilder h(int n) {
        this.ii = n;
        this.ih = true;
        return this;
    }

    @Generated
    public LocationBridgeBuilder b(@Nullable Integer n) {
        this.hR = n;
        return this;
    }

    @Generated
    public LocationBridgeBuilder a(float f) {
        this.ik = f;
        this.ij = true;
        return this;
    }

    @Generated
    public LocationBridgeBuilder b(double d) {
        this.im = d;
        this.il = true;
        return this;
    }

    @Generated
    public LocationBridgeBuilder b(float f) {
        this.io = f;
        this.in = true;
        return this;
    }

    @Generated
    public LocationBridgeBuilder c(float f) {
        this.iq = f;
        this.ip = true;
        return this;
    }

    @Generated
    public LocationBridgeBuilder d(float f) {
        this.is = f;
        this.ir = true;
        return this;
    }

    @Generated
    public LocationBridgeBuilder o(boolean bl) {
        this.iu = bl;
        this.it = true;
        return this;
    }

    @Generated
    public LocationBridgeBuilder b(@Nullable ImmutableMap immutableMap) {
        this.hY = immutableMap;
        return this;
    }

    @Generated
    public LocationBridge_7 bL() {
        double d = this.ig;
        if (!this.if) {
            d = LocationBridge_7.bx();
        }
        int n = this.ii;
        if (!this.ih) {
            n = LocationBridge_7.by();
        }
        float f = this.ik;
        if (!this.ij) {
            f = LocationBridge_7.bz();
        }
        double d2 = this.im;
        if (!this.il) {
            d2 = LocationBridge_7.bA();
        }
        float f2 = this.io;
        if (!this.in) {
            f2 = LocationBridge_7.bB();
        }
        float f3 = this.iq;
        if (!this.ip) {
            f3 = LocationBridge_7.bC();
        }
        float f4 = this.is;
        if (!this.ir) {
            f4 = LocationBridge_7.bD();
        }
        boolean bl = this.iu;
        if (!this.it) {
            bl = LocationBridge_7.bE();
        }
        return new LocationBridge_7(this.namespacedId, this.hE, this.hF, this.hG, this.hH, this.hI, this.hJ, this.hK, this.hL, this.hM, this.hN, this.hO, d, n, this.hR, f, d2, f2, f3, f4, bl, this.hY);
    }

    @Generated
    public String toString() {
        return "CropInfo.CropInfoBuilder(namespacedId=" + this.namespacedId + ", seed=" + String.valueOf(this.hE) + ", placeSound=" + this.hF + ", breakSound=" + this.hG + ", interactSound=" + this.hH + ", hitbox=" + String.valueOf(this.hI) + ", ageStatuses=" + String.valueOf(this.hJ) + ", maxAge=" + this.hK + ", requiredCustomBottomBlockId=" + this.hL + ", requireBottomBlockMaterial=" + String.valueOf(this.hM) + ", requiresFarmlandBottom=" + this.hN + ", usesGameCropModel=" + this.hO + ", avgSecondsPerStage$value=" + this.ig + ", minLight$value=" + this.ii + ", requiredSpacing=" + this.hR + ", bonemealGrowthMultiplier$value=" + this.ik + ", maxGrowthMoistureMultiplier$value=" + this.im + ", rainGrowthMultiplier$value=" + this.io + ", thunderGrowthMultiplier$value=" + this.iq + ", snowGrowthMultiplier$value=" + this.is + ", dropSeedIfImmature$value=" + this.iu + ", loots=" + String.valueOf(this.hY) + ")";
    }
}
