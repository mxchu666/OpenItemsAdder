package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import itemsadder.m.ayp;
import itemsadder.m.ayr;
import itemsadder.m.bce;
import itemsadder.m.rc;
import itemsadder.m.rq;
import org.jetbrains.annotations.Nullable;

public class ayu
extends ayr {
    public ayu(rc rc2) {
        super(rc2);
    }

    @Override
    void a(rq rq2) {
        super.a(rq2);
        this.ap("open_back", "minecraft:item/template_bundle_open_back");
        this.ap("open_front", "minecraft:item/template_bundle_open_front");
    }

    private void ap(String string, String string2) {
        ayp ayp2 = (ayp)this.axb.get(string);
        if (ayp2 != null && ayp2.axg != null) {
            ayp2.axg.put((Object)"parent", (Object)string2);
        }
    }

    @Override
    void AR() {
        if (this.axa == null) {
            throw new IllegalArgumentException("Bundle must have a 'normal' status model");
        }
        d d2 = new d(this.awZ.nM());
        JSONObject jSONObject = d2.BR();
        ayp ayp2 = (ayp)this.axb.get("filled");
        ayp ayp3 = (ayp)this.axb.get("open_back");
        ayp ayp4 = (ayp)this.axb.get("open_front");
        ayu.a(jSONObject.getJSONObject("model"), this.axa.axe, ayp2 == null ? null : ayp2.axe, ayp3 == null ? null : ayp3.axe, ayp4 == null ? null : ayp4.axe);
        if (this.awZ.nK()) {
            bce.warn("'" + String.valueOf(this.awZ.nM()) + "' do not support icons yet. Create the 'item_model' manually. Skipping icon generation for: " + this.awZ.nL());
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }

    static void a(JSONObject jSONObject, String string, @Nullable String string2, @Nullable String string3, @Nullable String string4) {
        jSONObject.put((Object)"fallback", (Object)ayu.aq(string, string2));
        JSONObject jSONObject2 = jSONObject.getJSONArray("cases").getJSONObject(0).getJSONObject("model");
        jSONObject2.put((Object)"on_false", (Object)ayu.aq(string, string2));
        JSONArray jSONArray = jSONObject2.getJSONObject("on_true").getJSONArray("models");
        if (string3 != null) {
            jSONArray.getJSONObject(0).put((Object)"model", (Object)string3);
        }
        if (string4 != null) {
            jSONArray.getJSONObject(jSONArray.size() - 1).put((Object)"model", (Object)string4);
        }
    }

    private static JSONObject aq(String string, @Nullable String string2) {
        JSONObject jSONObject = ayu.fX(string);
        if (string2 == null) {
            return jSONObject;
        }
        return new JSONObject().fluentPut("type", (Object)"minecraft:range_dispatch").fluentPut("property", (Object)"minecraft:bundle/fullness").fluentPut("entries", (Object)new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("threshold", (Object)1.0E-7).fluentPut("model", (Object)ayu.fX(string2)))).fluentPut("fallback", (Object)jSONObject);
    }

    private static JSONObject fX(String string) {
        return new JSONObject().fluentPut("type", (Object)"minecraft:model").fluentPut("model", (Object)string);
    }
}
