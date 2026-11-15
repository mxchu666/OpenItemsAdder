package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import itemsadder.m.ayy;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.rc;
import org.bukkit.Material;

public class ays
extends ayy {
    public ays(rc rc2) {
        super(rc2);
    }

    @Override
    void AR() {
        d d2 = new d(Material.PAPER);
        JSONObject jSONObject = d2.BR();
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        if (!jSONObject2.getString("type").equals("minecraft:model")) {
            throw new IllegalArgumentException("Unsupported material " + String.valueOf(this.awZ.nM()) + " for now. Use another one or suggest it on GitHub.");
        }
        jSONObject2.put((Object)"model", (Object)this.axa.axe);
        if (bbs.ae(this.awZ.nM())) {
            jSONObject2.put((Object)"tints", (Object)new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("default", (Object)-6265536).fluentPut("type", (Object)"dye")));
        }
        if (this.awZ.nK()) {
            bce.warn("'" + String.valueOf(this.awZ.nM()) + "' do not support icons yet. Create the 'item_model' manually. Skipping icon generation for: " + this.awZ.nL());
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }
}
