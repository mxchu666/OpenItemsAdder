package itemsadder.m;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.b;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Minecraft_4 {
    public static JSONObject Bq() {
        Map map = Minecraft_4.BC();
        JSONObject jSONObject = map.computeIfAbsent("minecraft", string -> new JSONObject());
        Minecraft_4.H(jSONObject);
        return jSONObject;
    }

    public static Map BC() {
        return Minecraft_4.N(ItemStackRegistry.C());
    }

    static Map N(List list) {
        LinkedHashMap<String, JSONObject> linkedHashMap = new LinkedHashMap<String, JSONObject>();
        for (File file : list) {
            File file2 = new File(file, "sounds.json");
            if (!file2.exists()) continue;
            try {
                JSONObject jSONObject = c.N(file2);
                if (!Minecraft_4.I(jSONObject)) {
                    CommandSenderBridge_5.error("Error opening a custom sounds file. Make sure it's valid or delete it. File: " + ColorBridge.iP(file2.getAbsolutePath()));
                    continue;
                }
                JSONObject jSONObject2 = linkedHashMap.computeIfAbsent(file.getName(), string -> new JSONObject());
                c.d(jSONObject2, jSONObject);
            }
            catch (JSONException jSONException) {
                CommandSenderBridge_5.error("Malformed JSON file. File: " + ColorBridge.iP(file2.getAbsolutePath()));
                CommandSenderBridge_5.error(jSONException.getMessage());
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Error opening a custom sounds file. Make sure it's valid or delete it. File: " + ColorBridge.iP(file2.getAbsolutePath()), throwable);
            }
        }
        return linkedHashMap;
    }

    public static void H(JSONObject jSONObject) {
        if (!MaterialBarColorHolder.fl) {
            return;
        }
        b b2 = new b("internal/custom_blocks_sounds.json");
        if (!b2.BN()) {
            for (Map.Entry entry : b2.BQ().entrySet()) {
                String string = (String)entry.getKey();
                if (string.endsWith(".step")) {
                    if (!MaterialBarColorHolder.fm) continue;
                    Minecraft_4.a(jSONObject, entry, string);
                    continue;
                }
                if (!MaterialBarColorHolder.fn) continue;
                Minecraft_4.a(jSONObject, entry, string);
            }
        }
    }

    private static boolean I(JSONObject jSONObject) {
        String string = "Refer to the wiki: https://a.devs.beer/ia-wiki-sounds";
        boolean bl = true;
        for (Map.Entry entry : jSONObject.entrySet()) {
            if (!(entry.getValue() instanceof JSONObject)) {
                CommandSenderBridge_5.error("Custom sound '" + (String)entry.getKey() + "' has invalid value. " + string);
                bl = false;
                continue;
            }
            JSONObject jSONObject2 = (JSONObject)entry.getValue();
            if (jSONObject2.containsKey("sounds")) continue;
            CommandSenderBridge_5.error("Custom sound '" + (String)entry.getKey() + "' has no 'sounds' property. " + string);
            bl = false;
        }
        return bl;
    }

    private static void a(JSONObject jSONObject, Map.Entry entry, String string) {
        if (string.startsWith("block.")) {
            if (jSONObject.containsKey(string)) {
                JSONObject jSONObject2 = (JSONObject)jSONObject.get(string);
                Minecraft_4.c(jSONObject, "internal." + string, jSONObject2);
            }
            Minecraft_4.c(jSONObject, string, entry.getValue());
        } else {
            Minecraft_4.c(jSONObject, string, entry.getValue());
        }
    }

    private static void c(JSONObject jSONObject, String string, Object object) {
        jSONObject.put((Object)string, object);
    }
}
