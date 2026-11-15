package itemsadder.m;

import itemsadder.m.MaterialBridge_10;
import java.util.Map;
import lombok.Generated;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public final class MaterialBridge_12
extends MaterialBridge_10 {
    private final String ID;
    private final Map IE;

    public MaterialBridge_12(String string, Material material, String string2, Map map, @Nullable String string3, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Integer n, @Nullable Integer n2) {
        super(string, material, string3, bl, bl2, n, n2);
        this.ID = string2;
        this.IE = map;
    }

    @Override
    public String nG() {
        String string = this.Hu.split(":")[0];
        String string2 = this.Hu.split(":")[1];
        return "assets/" + string + "/models/item/ia_auto/" + string2 + ".json";
    }

    @Override
    public String bV(@Nullable String string) {
        if (string == null || string.isEmpty() || string.equals("normal")) {
            return this.nG();
        }
        String string2 = this.Hu.split(":")[0];
        String string3 = this.Hu.split(":")[1];
        return "assets/" + string2 + "/models/item/ia_auto/" + string3 + "_" + string + ".json";
    }

    @Override
    public String nH() {
        String string = this.Hu.split(":")[0];
        String string2 = this.Hu.split(":")[1];
        return string + ":item/ia_auto/" + string2;
    }

    @Override
    public String bW(String string) {
        if (string == null || string.isEmpty() || string.equals("normal")) {
            return this.nH();
        }
        String string2 = this.Hu.split(":")[0];
        String string3 = this.Hu.split(":")[1];
        return string2 + ":item/ia_auto/" + string3 + "_" + string;
    }

    @Generated
    public String oC() {
        return this.ID;
    }

    @Generated
    public Map oD() {
        return this.IE;
    }
}
