package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.utils.json.c;

public final class ayw {
    private ayw() {
    }

    public static JSONObject l(JSONObject jSONObject, String string) {
        JSONObject jSONObject2 = c.a(jSONObject);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("textures");
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
            jSONObject2.put((Object)"textures", (Object)jSONObject3);
        }
        jSONObject3.put((Object)"layer0", (Object)string);
        return jSONObject2;
    }

    public static JSONObject ar(String string, String string2) {
        JSONObject jSONObject = new JSONObject().fluentPut("type", (Object)"minecraft:model").fluentPut("model", (Object)string);
        JSONObject jSONObject2 = new JSONObject().fluentPut("type", (Object)"minecraft:model").fluentPut("model", (Object)string2);
        return new JSONObject().fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"minecraft:condition").fluentPut("property", (Object)"minecraft:broken").fluentPut("on_false", (Object)jSONObject).fluentPut("on_true", (Object)jSONObject2));
    }
}
