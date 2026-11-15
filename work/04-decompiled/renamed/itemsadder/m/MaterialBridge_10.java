package itemsadder.m;

import itemsadder.m.RecordOfNamespacedKey;
import lombok.Generated;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public abstract class MaterialBridge_10 {
    public static final String Ht = "normal";
    final String Hu;
    @Nullable
    private final String Hv;
    private final Material Hw;
    @Nullable
    private final Boolean Hx;
    @Nullable
    private final Boolean Hy;
    @Nullable
    private final Integer Hz;
    @Nullable
    private final Integer HA;
    @Nullable
    private RecordOfNamespacedKey FZ;

    public MaterialBridge_10(String string, Material material, @Nullable String string2, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Integer n, @Nullable Integer n2) {
        this.Hu = string;
        this.Hv = string2;
        this.Hw = material;
        this.Hx = bl;
        this.Hy = bl2;
        this.Hz = n;
        this.HA = n2;
    }

    public String nE() {
        return "ia_overlay_1_21_4_plus/assets/" + this.Hu.split(":")[0] + "/items/ia_auto/" + this.Hu.split(":")[1] + ".json";
    }

    public String nF() {
        return this.Hu.split(":")[0] + ":ia_auto/" + this.Hu.split(":")[1];
    }

    public abstract String nG();

    public abstract String bV(@Nullable String var1);

    public abstract String nH();

    public abstract String bW(String var1);

    @Nullable
    public String nI() {
        if (this.Hv == null) {
            return null;
        }
        String string = this.Hu.split(":")[0];
        String string2 = this.Hu.split(":")[1];
        return "assets/" + string + "/models/item/ia_auto/" + string2 + "_icon.json";
    }

    public String nJ() {
        if (this.Hv == null) {
            return null;
        }
        String string = this.Hu.split(":")[0];
        String string2 = this.Hu.split(":")[1];
        return string + ":item/ia_auto/" + string2 + "_icon";
    }

    public boolean nK() {
        return this.Hv != null && !this.Hv.isEmpty();
    }

    @Generated
    public String nL() {
        return this.Hu;
    }

    @Nullable
    @Generated
    public String mR() {
        return this.Hv;
    }

    @Generated
    public Material nM() {
        return this.Hw;
    }

    @Nullable
    @Generated
    public Boolean nN() {
        return this.Hx;
    }

    @Nullable
    @Generated
    public Boolean nO() {
        return this.Hy;
    }

    @Nullable
    @Generated
    public Integer nP() {
        return this.Hz;
    }

    @Nullable
    @Generated
    public Integer nQ() {
        return this.HA;
    }

    @Nullable
    @Generated
    public RecordOfNamespacedKey nn() {
        return this.FZ;
    }

    @Generated
    public void a(@Nullable RecordOfNamespacedKey recordOfNamespacedKey) {
        this.FZ = recordOfNamespacedKey;
    }
}
