package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.v;
import org.bukkit.Color;
import org.jetbrains.annotations.Nullable;

public class rd
extends v {
    public final bbf HB;
    public Color HC;
    @Nullable
    public String HD;
    @Nullable
    public String HE;
    @Nullable
    public String HF;
    @Nullable
    public String HG;
    public int HH;
    public boolean HI;
    public int HJ;
    public boolean HK;

    public rd(bbf bbf2, String string, String string2, Color color, @Nullable String string3, @Nullable String string4, @Nullable String string5, @Nullable String string6, boolean bl, int n, boolean bl2, int n2) {
        super(string, string2);
        this.HB = bbf2;
        this.HC = color;
        this.HD = this.bX(string3);
        this.HE = this.bX(string4);
        this.HF = this.bX(string5);
        this.HG = this.bX(string6);
        this.HI = bl;
        this.HJ = n;
        this.HK = bl2;
        this.HH = n2;
    }

    private String bX(String string) {
        String string2;
        if (string == null) {
            return null;
        }
        if ((string = string.replace(".png", "")).contains(":")) {
            String[] stringArray = string.split(":");
            string2 = stringArray[0];
            string = stringArray[1];
        } else {
            string2 = this.bL;
        }
        return "assets/" + string2 + "/textures/" + string + ".png";
    }

    @Nullable
    public String bY(String string) {
        if (string == null) {
            return null;
        }
        return string.replace("assets/", "").replace("/textures", ":textures");
    }
}
