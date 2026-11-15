package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import itemsadder.m.ayr;
import itemsadder.m.bce;
import itemsadder.m.rc;
import itemsadder.m.rq;

public class azb
extends ayr {
    public azb(rc rc2) {
        super(rc2);
    }

    @Override
    void a(rq rq2) {
        throw new IllegalArgumentException("Shield graphics cannot be created with textures. Use models instead: " + this.awZ.nL());
    }

    @Override
    void AR() {
        d d2 = new d(this.awZ.nM());
        JSONObject jSONObject = d2.BR();
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        String string = this.bW("blocking");
        if (string == null) {
            bce.error("Shield graphics must have 'blocking' status model for blocking animation: " + this.awZ.nL());
        }
        jSONObject2.fluentPut("on_true", (Object)new JSONObject().fluentPut("model", (Object)string).fluentPut("type", (Object)"model")).fluentPut("on_false", (Object)new JSONObject().fluentPut("model", (Object)this.axa.axe).fluentPut("type", (Object)"model"));
        if (this.awZ.nK()) {
            bce.warn("'" + String.valueOf(this.awZ.nM()) + "' do not support icons yet. Create the 'item_model' manually. Skipping icon generation for: " + this.awZ.nL());
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }
}
