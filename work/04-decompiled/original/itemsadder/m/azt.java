package itemsadder.m;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.b;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class azt {
    public static JSONObject Bq() {
        Map map = azt.BC();
        JSONObject jSONObject = map.computeIfAbsent("minecraft", string -> new JSONObject());
        azt.H(jSONObject);
        return jSONObject;
    }

    public static Map BC() {
        return azt.N(d.C());
    }

    static Map N(List list) {
        LinkedHashMap<String, JSONObject> linkedHashMap = new LinkedHashMap<String, JSONObject>();
        for (File file : list) {
            File file2 = new File(file, "sounds.json");
            if (!file2.exists()) continue;
            try {
                JSONObject jSONObject = c.N(file2);
                if (!azt.I(jSONObject)) {
                    bce.error("Error opening a custom sounds file. Make sure it's valid or delete it. File: " + bcy.iP(file2.getAbsolutePath()));
                    continue;
                }
                JSONObject jSONObject2 = linkedHashMap.computeIfAbsent(file.getName(), string -> new JSONObject());
                c.d(jSONObject2, jSONObject);
            }
            catch (JSONException jSONException) {
                bce.error("Malformed JSON file. File: " + bcy.iP(file2.getAbsolutePath()));
                bce.error(jSONException.getMessage());
            }
            catch (Throwable throwable) {
                bce.error("Error opening a custom sounds file. Make sure it's valid or delete it. File: " + bcy.iP(file2.getAbsolutePath()), throwable);
            }
        }
        return linkedHashMap;
    }

    public static void H(JSONObject jSONObject) {
        if (!ae.fl) {
            return;
        }
        b b2 = new b("internal/custom_blocks_sounds.json");
        if (!b2.BN()) {
            for (Map.Entry entry : b2.BQ().entrySet()) {
                String string = (String)entry.getKey();
                if (string.endsWith(".step")) {
                    if (!ae.fm) continue;
                    azt.a(jSONObject, entry, string);
                    continue;
                }
                if (!ae.fn) continue;
                azt.a(jSONObject, entry, string);
            }
        }
    }

    private static boolean I(JSONObject jSONObject) {
        String string = "Refer to the wiki: https://a.devs.beer/ia-wiki-sounds";
        boolean bl = true;
        for (Map.Entry entry : jSONObject.entrySet()) {
            if (!(entry.getValue() instanceof JSONObject)) {
                bce.error("Custom sound '" + (String)entry.getKey() + "' has invalid value. " + string);
                bl = false;
                continue;
            }
            JSONObject jSONObject2 = (JSONObject)entry.getValue();
            if (jSONObject2.containsKey("sounds")) continue;
            bce.error("Custom sound '" + (String)entry.getKey() + "' has no 'sounds' property. " + string);
            bl = false;
        }
        return bl;
    }

    private static void a(JSONObject jSONObject, Map.Entry entry, String string) {
        if (string.startsWith("block.")) {
            if (jSONObject.containsKey(string)) {
                JSONObject jSONObject2 = (JSONObject)jSONObject.get(string);
                azt.c(jSONObject, "internal." + string, jSONObject2);
            }
            azt.c(jSONObject, string, entry.getValue());
        } else {
            azt.c(jSONObject, string, entry.getValue());
        }
    }

    private static void c(JSONObject jSONObject, String string, Object object) {
        jSONObject.put((Object)string, object);
    }
}
