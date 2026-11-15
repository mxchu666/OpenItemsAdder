package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import itemsadder.m.ayp;
import itemsadder.m.ayr;
import itemsadder.m.bce;
import itemsadder.m.rc;

public class ayx
extends ayr {
    public ayx(rc rc2) {
        super(rc2);
    }

    @Override
    void AR() {
        d d2 = new d(this.awZ.nM());
        JSONObject jSONObject = d2.BR();
        ayp ayp2 = (ayp)this.axb.get("cast");
        if (ayp2 == null) {
            throw new IllegalArgumentException("Fishing rod must have 'cast' status model");
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        jSONObject2.getJSONObject("on_false").put((Object)"model", (Object)this.axa.axe);
        jSONObject2.getJSONObject("on_true").put((Object)"model", (Object)ayp2.axe);
        if (this.awZ.nK()) {
            bce.warn("'" + String.valueOf(this.awZ.nM()) + "' do not support icons yet. Create the 'item_model' manually. Skipping icon generation for: " + this.awZ.nL());
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }
}
