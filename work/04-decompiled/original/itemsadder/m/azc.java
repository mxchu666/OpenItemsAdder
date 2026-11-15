package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ayp;
import itemsadder.m.ayr;
import itemsadder.m.rc;
import itemsadder.m.rp;
import itemsadder.m.rq;
import org.jetbrains.annotations.Nullable;

public class azc
extends ayr {
    public azc(rc rc2) {
        super(rc2);
    }

    @Override
    void a(rq rq2) {
        String string = (String)rq2.oD().get("normal");
        if (string == null) {
            throw new IllegalArgumentException("Spear graphics must have a 'normal' texture: " + this.awZ.nL());
        }
        JSONObject jSONObject = e.R(this.awZ.nM()).BR();
        azc.m(jSONObject, string);
        this.axa = new ayp(this.awZ.nH(), this.awZ.nG(), jSONObject);
        JSONObject jSONObject2 = e.gj("spear_in_hand").BR();
        azc.m(jSONObject2, rq2.oD().getOrDefault("in_hand", string));
        this.axb.put("in_hand", new ayp(this.awZ.bW("in_hand"), this.awZ.bV("in_hand"), jSONObject2));
    }

    @Override
    void a(rp rp2) {
        super.a(rp2);
        if (this.axb.containsKey("in_hand")) {
            return;
        }
        String[] stringArray = this.awZ.nL().split(":", 2);
        String string = stringArray[0] + ":item/ia_auto/" + stringArray[1] + "_in_hand";
        String string2 = "assets/" + stringArray[0] + "/models/item/ia_auto/" + stringArray[1] + "_in_hand.json";
        JSONObject jSONObject = e.gj("spear_in_hand").BR();
        this.axb.put("in_hand", new ayp(string, string2, azc.a(this.axa.axe, this.axa.axg, jSONObject)));
    }

    @Override
    void AR() {
        JSONObject jSONObject = new d(this.awZ.nM()).BR();
        String string = this.awZ.nJ() != null ? this.awZ.nJ() : this.axa.axe;
        azc.b(jSONObject.getJSONObject("model"), string, this.an("in_hand", this.axa.axe));
        this.z(jSONObject);
        this.axd = jSONObject;
    }

    static void b(JSONObject jSONObject, String string, String string2) {
        jSONObject.getJSONArray("cases").getJSONObject(0).getJSONObject("model").put((Object)"model", (Object)string);
        jSONObject.getJSONObject("fallback").put((Object)"model", (Object)string2);
    }

    static void m(JSONObject jSONObject, String string) {
        jSONObject.put((Object)"textures", (Object)new JSONObject().fluentPut("layer0", (Object)string));
    }

    static JSONObject a(String string, @Nullable JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = jSONObject == null ? null : jSONObject.getJSONObject("display");
        JSONObject jSONObject4 = jSONObject2.getJSONObject("display");
        JSONObject jSONObject5 = new JSONObject();
        azc.a(jSONObject5, jSONObject3, jSONObject4, "firstperson_righthand", -20, 90, 10);
        azc.a(jSONObject5, jSONObject3, jSONObject4, "firstperson_lefthand", -20, -90, -10);
        azc.a(jSONObject5, jSONObject3, jSONObject4, "thirdperson_righthand", 5, 270, 5);
        azc.a(jSONObject5, jSONObject3, jSONObject4, "thirdperson_lefthand", 5, -270, -5);
        return new JSONObject().fluentPut("parent", (Object)string).fluentPut("display", (Object)jSONObject5);
    }

    private static void a(JSONObject jSONObject, @Nullable JSONObject jSONObject2, JSONObject jSONObject3, String string, int n, int n2, int n3) {
        JSONObject jSONObject4 = jSONObject2 == null ? null : jSONObject2.getJSONObject(string);
        JSONObject jSONObject5 = c.a(jSONObject4 != null ? jSONObject4 : jSONObject3.getJSONObject(string));
        jSONObject5.put((Object)"rotation", (Object)new JSONArray().fluentAdd((Object)n).fluentAdd((Object)n2).fluentAdd((Object)n3));
        jSONObject.put((Object)string, (Object)jSONObject5);
    }
}
