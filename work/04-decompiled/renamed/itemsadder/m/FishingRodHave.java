package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBridge_10;
import itemsadder.m.Minecraft;
import itemsadder.m.Minecraft_2;

public class FishingRodHave
extends Minecraft_2 {
    public FishingRodHave(MaterialBridge_10 materialBridge_10) {
        super(materialBridge_10);
    }

    @Override
    void AR() {
        d d2 = new d(this.awZ.nM());
        JSONObject jSONObject = d2.BR();
        Minecraft minecraft = (Minecraft)this.axb.get("cast");
        if (minecraft == null) {
            throw new IllegalArgumentException("Fishing rod must have 'cast' status model");
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        jSONObject2.getJSONObject("on_false").put((Object)"model", (Object)this.axa.axe);
        jSONObject2.getJSONObject("on_true").put((Object)"model", (Object)minecraft.axe);
        if (this.awZ.nK()) {
            CommandSenderBridge_5.warn("'" + String.valueOf(this.awZ.nM()) + "' do not support icons yet. Create the 'item_model' manually. Skipping icon generation for: " + this.awZ.nL());
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }
}
