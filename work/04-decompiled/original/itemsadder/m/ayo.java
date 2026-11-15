package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ayp;
import itemsadder.m.ayq;
import itemsadder.m.rc;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public abstract class ayo {
    final rc awZ;
    ayp axa;
    Map axb;
    @Nullable
    JSONObject axc;
    JSONObject axd;

    public ayo(rc rc2) {
        this.awZ = rc2;
    }

    void AP() {
        if (!this.awZ.nK()) {
            return;
        }
        e e2 = e.gj("generated");
        if (e2.BN()) {
            throw new IllegalArgumentException("Original model has errors: " + e2.getPath(), e2.BO());
        }
        JSONObject jSONObject = e2.BR();
        JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
            jSONObject.put((Object)"textures", (Object)jSONObject2);
        }
        jSONObject2.put((Object)"layer0", (Object)this.awZ.mR());
        this.axc = jSONObject;
    }

    void a(JSONObject jSONObject, String string) {
        JSONObject jSONObject2 = c.a(jSONObject);
        if (jSONObject2.containsKey("fallback")) {
            jSONObject2 = jSONObject2.getJSONObject("fallback");
        }
        jSONObject.clear();
        jSONObject.fluentPut("type", (Object)"select").fluentPut("property", (Object)"display_context").fluentPut("cases", (Object)new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)string)).fluentPut("when", (Object)new JSONArray().fluentAdd((Object)"gui").fluentAdd((Object)"ground").fluentAdd((Object)"fixed")))).fluentPut("fallback", (Object)jSONObject2);
    }

    abstract void AQ();

    abstract void AR();

    public ayq AS() {
        this.AQ();
        this.AR();
        this.AP();
        return new ayq(this.axa, this.axb, this.axc, this.axd);
    }

    void z(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (this.awZ.nN() != null) {
            jSONObject.put((Object)"hand_animation_on_swap", (Object)this.awZ.nN());
        }
        if (this.awZ.nO() != null) {
            jSONObject.put((Object)"oversized_in_gui", (Object)this.awZ.nO());
        }
        if (this.awZ.nP() != null && (jSONObject2 = jSONObject.getJSONObject("model")) != null) {
            JSONArray jSONArray = new JSONArray();
            jSONObject2.put((Object)"tints", (Object)jSONArray);
            jSONArray.add((Object)new JSONObject().fluentPut("type", (Object)"custom_model_data").fluentPut("default", (Object)this.awZ.nP()));
            if (this.awZ.nQ() != null) {
                jSONArray.add((Object)new JSONObject().fluentPut("type", (Object)"custom_model_data").fluentPut("default", (Object)this.awZ.nQ()));
            }
        }
    }
}
