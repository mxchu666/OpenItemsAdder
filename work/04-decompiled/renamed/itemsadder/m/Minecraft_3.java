package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.g;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBridge_8;
import itemsadder.m.Parent_2;
import java.io.File;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class Minecraft_3 {
    @Nullable
    MaterialBridge_8 axR;
    private final boolean axS;

    public Minecraft_3(MaterialBridge_8 materialBridge_8) {
        this.axS = materialBridge_8.getModelPath().startsWith("minecraft:");
        if (this.axS) {
            return;
        }
        this.axR = materialBridge_8;
    }

    @Nullable
    public g Bn() {
        String string;
        Object object;
        if (this.axS || this.axR == null) {
            return null;
        }
        String string2 = this.axR.getModelPath();
        if (string2.contains(":")) {
            object = string2.split(":");
            string = object[0] + "/models/" + object[1] + ".json";
        } else {
            string = this.axR.getNamespace() + "/models/" + string2 + ".json";
        }
        if (string.contains("ia_auto")) {
            return null;
        }
        object = ItemStackRegistry.s(string);
        if (object == null) {
            CommandSenderBridge_5.error("Model file '" + string + "' not found in any pack for item '" + this.axR.getNamespacedID() + "'. File: " + (this.axR.Hb != null ? this.axR.Hb.nh() : "unknown"));
            return null;
        }
        try {
            JSONObject jSONObject = c.N((File)object);
            g g2 = new Parent_2("assets/" + string).C(jSONObject);
            if ((this.axR.Hc == Material.POTION || this.axR.Hc == Material.SPLASH_POTION || this.axR.Hc == Material.LINGERING_POTION) && jSONObject.containsKey("elements")) {
                JSONArray jSONArray = jSONObject.getJSONArray("elements");
                for (Object e2 : jSONArray) {
                    String[] stringArray;
                    JSONObject jSONObject2 = (JSONObject)e2;
                    if (!jSONObject2.containsKey("faces")) continue;
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("faces");
                    for (String string3 : stringArray = new String[]{"down", "east", "north", "south", "up", "west"}) {
                        if (!jSONObject3.containsKey(string3)) continue;
                        jSONObject3.getJSONObject(string3).put((Object)"tintindex", (Object)0);
                    }
                }
            }
            return g2;
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Failed to validate model: " + ColorBridge.I((File)object));
            CommandSenderBridge_5.error(throwable.getMessage());
            return null;
        }
    }
}
