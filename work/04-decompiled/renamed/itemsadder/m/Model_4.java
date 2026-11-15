package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBridge_10;
import itemsadder.m.MaterialBridge_12;
import itemsadder.m.Minecraft_2;

public class Model_4
extends Minecraft_2 {
    public Model_4(MaterialBridge_10 materialBridge_10) {
        super(materialBridge_10);
    }

    @Override
    void a(MaterialBridge_12 materialBridge_12) {
        throw new IllegalArgumentException("Shield graphics cannot be created with textures. Use models instead: " + this.awZ.nL());
    }

    @Override
    void AR() {
        d d2 = new d(this.awZ.nM());
        JSONObject jSONObject = d2.BR();
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        String string = this.bW("blocking");
        if (string == null) {
            CommandSenderBridge_5.error("Shield graphics must have 'blocking' status model for blocking animation: " + this.awZ.nL());
        }
        jSONObject2.fluentPut("on_true", (Object)new JSONObject().fluentPut("model", (Object)string).fluentPut("type", (Object)"model")).fluentPut("on_false", (Object)new JSONObject().fluentPut("model", (Object)this.axa.axe).fluentPut("type", (Object)"model"));
        if (this.awZ.nK()) {
            CommandSenderBridge_5.warn("'" + String.valueOf(this.awZ.nM()) + "' do not support icons yet. Create the 'item_model' manually. Skipping icon generation for: " + this.awZ.nL());
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }
}
