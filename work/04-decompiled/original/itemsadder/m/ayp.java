package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import org.jetbrains.annotations.Nullable;

public class ayp {
    public final String axe;
    public final String axf;
    @Nullable
    public final JSONObject axg;

    public ayp(String string, String string2, @Nullable JSONObject jSONObject) {
        this.axe = string;
        this.axf = string2;
        this.axg = jSONObject;
    }

    public boolean AT() {
        return this.axe.startsWith("minecraft:") && this.axg == null;
    }
}
