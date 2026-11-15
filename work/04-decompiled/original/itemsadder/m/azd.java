package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ayr;
import itemsadder.m.bce;
import itemsadder.m.rc;
import itemsadder.m.rq;

public class azd
extends ayr {
    public azd(rc rc2) {
        super(rc2);
    }

    @Override
    void a(rq rq2) {
        throw new IllegalArgumentException("Trident graphics cannot be created with textures. Use models instead: " + this.awZ.nL());
    }

    @Override
    void AR() {
        d d2 = new d(this.awZ.nM());
        JSONObject jSONObject = d2.BR();
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("fallback");
        String string = this.bW("throwing");
        if (string == null) {
            bce.error("Trident graphics must have 'throwing' status model for throwing animation: " + this.awZ.nL());
        }
        JSONObject jSONObject4 = new JSONObject().fluentPut("model", (Object)string).fluentPut("type", (Object)"model");
        JSONObject jSONObject5 = new JSONObject().fluentPut("model", (Object)this.axa.axe).fluentPut("type", (Object)"model");
        azd.b(jSONObject3, jSONObject4);
        azd.b(jSONObject3, jSONObject5);
        jSONObject3.fluentPut("on_true", (Object)jSONObject4).fluentPut("on_false", (Object)jSONObject5);
        if (this.awZ.nJ() != null) {
            this.a(jSONObject2, this.awZ.nJ());
        } else {
            this.a(jSONObject2, this.axa.axe);
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }

    static void b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = jSONObject.getJSONObject("transformation");
        if (jSONObject3 != null) {
            jSONObject2.put((Object)"transformation", (Object)c.a(jSONObject3));
        }
    }
}
