package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import itemsadder.m.Minecraft;
import java.util.Map;

public class RefMapJSONObjectData {
    public final Minecraft axh;
    public final Map axi;
    public final JSONObject axj;
    public final JSONObject axk;

    RefMapJSONObjectData(Minecraft minecraft, Map map, JSONObject jSONObject, JSONObject jSONObject2) {
        this.axj = jSONObject;
        this.axk = jSONObject2;
        this.axh = minecraft;
        this.axi = map;
    }
}
