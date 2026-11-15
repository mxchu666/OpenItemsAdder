package itemsadder.m;

import com.google.common.collect.ImmutableMap;
import itemsadder.m.bda;
import itemsadder.m.bx;
import itemsadder.m.qm;
import lombok.Generated;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers detected
 */
@Generated
public class bz {
    @Generated
    private String namespacedId;
    @Generated
    private qm hE;
    @Generated
    private String hF;
    @Generated
    private String hG;
    @Generated
    private String hH;
    @Generated
    private bda hI;
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
    bz() {
    }

    @Generated
    public bz ac(String string) {
        this.namespacedId = string;
        return this;
    }

    @Generated
    public bz b(qm qm2) {
        this.hE = qm2;
        return this;
    }

    @Generated
    public bz ad(String string) {
        this.hF = string;
        return this;
    }

    @Generated
    public bz ae(String string) {
        this.hG = string;
        return this;
    }

    @Generated
    public bz af(String string) {
        this.hH = string;
        return this;
    }

    @Generated
    public bz a(bda bda2) {
        this.hI = bda2;
        return this;
    }

    @Generated
    public bz a(ImmutableMap immutableMap) {
        this.hJ = immutableMap;
        return this;
    }

    @Generated
    public bz g(int n) {
        this.hK = n;
        return this;
    }

    @Generated
    public bz ag(String string) {
        this.hL = string;
        return this;
    }

    @Generated
    public bz b(Material material) {
        this.hM = material;
        return this;
    }

    @Generated
    public bz m(boolean bl) {
        this.hN = bl;
        return this;
    }

    @Generated
    public bz n(boolean bl) {
        this.hO = bl;
        return this;
    }

    @Generated
    public bz a(double d) {
        this.ig = d;
        this.if = true;
        return this;
    }

    @Generated
    public bz h(int n) {
        this.ii = n;
        this.ih = true;
        return this;
    }

    @Generated
    public bz b(@Nullable Integer n) {
        this.hR = n;
        return this;
    }

    @Generated
    public bz a(float f) {
        this.ik = f;
        this.ij = true;
        return this;
    }

    @Generated
    public bz b(double d) {
        this.im = d;
        this.il = true;
        return this;
    }

    @Generated
    public bz b(float f) {
        this.io = f;
        this.in = true;
        return this;
    }

    @Generated
    public bz c(float f) {
        this.iq = f;
        this.ip = true;
        return this;
    }

    @Generated
    public bz d(float f) {
        this.is = f;
        this.ir = true;
        return this;
    }

    @Generated
    public bz o(boolean bl) {
        this.iu = bl;
        this.it = true;
        return this;
    }

    @Generated
    public bz b(@Nullable ImmutableMap immutableMap) {
        this.hY = immutableMap;
        return this;
    }

    @Generated
    public bx bL() {
        double d = this.ig;
        if (!this.if) {
            d = bx.bx();
        }
        int n = this.ii;
        if (!this.ih) {
            n = bx.by();
        }
        float f = this.ik;
        if (!this.ij) {
            f = bx.bz();
        }
        double d2 = this.im;
        if (!this.il) {
            d2 = bx.bA();
        }
        float f2 = this.io;
        if (!this.in) {
            f2 = bx.bB();
        }
        float f3 = this.iq;
        if (!this.ip) {
            f3 = bx.bC();
        }
        float f4 = this.is;
        if (!this.ir) {
            f4 = bx.bD();
        }
        boolean bl = this.iu;
        if (!this.it) {
            bl = bx.bE();
        }
        return new bx(this.namespacedId, this.hE, this.hF, this.hG, this.hH, this.hI, this.hJ, this.hK, this.hL, this.hM, this.hN, this.hO, d, n, this.hR, f, d2, f2, f3, f4, bl, this.hY);
    }

    @Generated
    public String toString() {
        return "CropInfo.CropInfoBuilder(namespacedId=" + this.namespacedId + ", seed=" + String.valueOf(this.hE) + ", placeSound=" + this.hF + ", breakSound=" + this.hG + ", interactSound=" + this.hH + ", hitbox=" + String.valueOf(this.hI) + ", ageStatuses=" + String.valueOf(this.hJ) + ", maxAge=" + this.hK + ", requiredCustomBottomBlockId=" + this.hL + ", requireBottomBlockMaterial=" + String.valueOf(this.hM) + ", requiresFarmlandBottom=" + this.hN + ", usesGameCropModel=" + this.hO + ", avgSecondsPerStage$value=" + this.ig + ", minLight$value=" + this.ii + ", requiredSpacing=" + this.hR + ", bonemealGrowthMultiplier$value=" + this.ik + ", maxGrowthMoistureMultiplier$value=" + this.im + ", rainGrowthMultiplier$value=" + this.io + ", thunderGrowthMultiplier$value=" + this.iq + ", snowGrowthMultiplier$value=" + this.is + ", dropSeedIfImmature$value=" + this.iu + ", loots=" + String.valueOf(this.hY) + ")";
    }
}
