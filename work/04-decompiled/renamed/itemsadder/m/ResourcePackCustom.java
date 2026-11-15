package itemsadder.m;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.generator.file.data.b;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.PermissibleBridge;
import java.util.Collection;

public class ResourcePackCustom {
    private final Collection axZ;
    public JSONArray aya;
    public JSONArray ayb = null;

    public ResourcePackCustom(Collection collection) {
        this.axZ = collection;
        b.a("internal/negative_spaces.json", b2 -> {
            this.aya = b2.BP();
        }, b2 -> CommandSenderBridge_5.error("Unable to read negative_spaces.json file from the plugin Jar. Try to redownload the plugin. Error: " + String.valueOf(b2.BO())));
        if (Main.KO.gY("resource-pack.custom-font.enabled") && Main.KO.gY("resource-pack.thin-font.enabled")) {
            CommandSenderBridge_5.error("Please enable custom-font or thin-font, do no enable both. Check your config.yml");
        } else if (Main.KO.gY("resource-pack.custom-font.enabled")) {
            this.ayb = new JSONArray();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put((Object)"type", (Object)"ttf");
                jSONObject.put((Object)"file", (Object)Main.KO.gV("resource-pack.custom-font.name"));
                jSONObject.put((Object)"oversample", (Object)Float.valueOf(Main.KO.a("resource-pack.custom-font.oversample", 2.0f)));
                jSONObject.put((Object)"size", (Object)Float.valueOf(Main.KO.a("resource-pack.custom-font.size", 11.0f)));
                try {
                    jSONObject.put((Object)"shift", (Object)JSON.parseArray((String)Main.KO.az("resource-pack.custom-font.shift", "[0,0]")));
                }
                catch (Throwable throwable) {
                    CommandSenderBridge_5.error("Invalid property 'resource-pack.custom-font.shift' in config.yml.", throwable);
                }
                this.ayb.add((Object)jSONObject);
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Misconfigured custom-font in config.yml", throwable);
            }
        } else if (Main.KO.gY("resource-pack.thin-font.enabled")) {
            b.a("internal/thin-font.json", b2 -> {
                this.ayb = b2.BP();
            }, b2 -> CommandSenderBridge_5.error("Error reading thin-font font plugin jar. Try to redownload the plugin. Error: " + String.valueOf(b2.BO())));
        }
    }

    public JSONObject Bq() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONObject.put((Object)"providers", (Object)this.b(jSONArray));
        if (this.ayb != null) {
            jSONArray.addAll((Collection)this.ayb);
        }
        if (this.aya != null) {
            jSONArray.addAll((Collection)this.aya);
        }
        return jSONObject;
    }

    private JSONArray b(JSONArray jSONArray) {
        for (PermissibleBridge permissibleBridge : this.axZ) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((Object)"file", (Object)permissibleBridge.ib());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.add((Object)permissibleBridge.Q(false));
            jSONObject.put((Object)"chars", (Object)jSONArray2);
            jSONObject.put((Object)"height", (Object)permissibleBridge.getHeight());
            jSONObject.put((Object)"ascent", (Object)permissibleBridge.ie());
            jSONObject.put((Object)"type", (Object)"bitmap");
            jSONArray.add((Object)jSONObject);
        }
        return jSONArray;
    }
}
