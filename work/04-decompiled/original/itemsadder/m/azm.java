package itemsadder.m;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.generator.file.data.b;
import itemsadder.m.bce;
import itemsadder.m.fw;
import java.util.Collection;

public class azm {
    private final Collection axZ;
    public JSONArray aya;
    public JSONArray ayb = null;

    public azm(Collection collection) {
        this.axZ = collection;
        b.a("internal/negative_spaces.json", b2 -> {
            this.aya = b2.BP();
        }, b2 -> bce.error("Unable to read negative_spaces.json file from the plugin Jar. Try to redownload the plugin. Error: " + String.valueOf(b2.BO())));
        if (Main.KO.gY("resource-pack.custom-font.enabled") && Main.KO.gY("resource-pack.thin-font.enabled")) {
            bce.error("Please enable custom-font or thin-font, do no enable both. Check your config.yml");
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
                    bce.error("Invalid property 'resource-pack.custom-font.shift' in config.yml.", throwable);
                }
                this.ayb.add((Object)jSONObject);
            }
            catch (Throwable throwable) {
                bce.error("Misconfigured custom-font in config.yml", throwable);
            }
        } else if (Main.KO.gY("resource-pack.thin-font.enabled")) {
            b.a("internal/thin-font.json", b2 -> {
                this.ayb = b2.BP();
            }, b2 -> bce.error("Error reading thin-font font plugin jar. Try to redownload the plugin. Error: " + String.valueOf(b2.BO())));
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
        for (fw fw2 : this.axZ) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((Object)"file", (Object)fw2.ib());
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.add((Object)fw2.Q(false));
            jSONObject.put((Object)"chars", (Object)jSONArray2);
            jSONObject.put((Object)"height", (Object)fw2.getHeight());
            jSONObject.put((Object)"ascent", (Object)fw2.ie());
            jSONObject.put((Object)"type", (Object)"bitmap");
            jSONArray.add((Object)jSONObject);
        }
        return jSONArray;
    }
}
