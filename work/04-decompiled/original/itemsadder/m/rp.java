package itemsadder.m;

import itemsadder.m.rc;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public final class rp
extends rc {
    private final Map IC;

    public rp(String string, Material material, String string2, @Nullable String string3, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Integer n, @Nullable Integer n2) {
        super(string, material, string3, bl, bl2, n, n2);
        this.IC = new HashMap();
        this.IC.put("normal", string2);
    }

    public rp(String string, Material material, Map map, @Nullable String string2, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Integer n, @Nullable Integer n2) {
        super(string, material, string2, bl, bl2, n, n2);
        this.IC = map;
    }

    @Override
    public String nG() {
        return this.bV(null);
    }

    @Override
    public String bV(@Nullable String string) {
        String string2;
        if (string == null) {
            string = "normal";
        }
        if ((string2 = (String)this.IC.get(string)) == null) {
            throw new NullPointerException("Can't find status '" + string + "' model for " + this.Hu);
        }
        String string3 = string2.split(":")[0];
        String string4 = string2.split(":")[1];
        return "assets/" + string3 + "/models/" + string4 + ".json";
    }

    @Override
    public String nH() {
        String string = (String)this.IC.get("normal");
        if (string == null) {
            throw new NullPointerException("Model location 'normal' is null for " + this.Hu);
        }
        return string;
    }

    @Override
    public String bW(String string) {
        return (String)this.IC.get(string);
    }

    @Generated
    public Map oB() {
        return this.IC;
    }
}
