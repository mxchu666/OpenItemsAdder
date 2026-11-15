package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import itemsadder.m.ayp;
import itemsadder.m.ayr;
import itemsadder.m.bce;
import itemsadder.m.rc;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ayt
extends ayr {
    public ayt(rc rc2) {
        super(rc2);
    }

    @Override
    void AR() {
        d d2 = new d(this.awZ.nM());
        JSONObject jSONObject = d2.BR();
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        jSONObject2.getJSONObject("on_false").put((Object)"model", (Object)this.axa.axe);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("on_true");
        JSONArray jSONArray = jSONObject3.getJSONArray("entries");
        jSONArray.clear();
        List<Map.Entry> list = this.axb.entrySet().stream().filter(entry -> ((String)entry.getKey()).startsWith("pulling_")).sorted(Comparator.comparingInt(entry -> Integer.parseInt(((String)entry.getKey()).substring("pulling_".length())))).toList();
        String string = this.bW("pulling_0");
        if (string != null) {
            JSONObject jSONObject4 = jSONObject3.getJSONObject("fallback");
            jSONObject4.put((Object)"model", (Object)string);
        }
        int n = list.size() - 1;
        int n2 = 0;
        for (Map.Entry entry2 : list) {
            if (((String)entry2.getKey()).equals("pulling_0")) continue;
            double d3 = (double)(n2 + 1) / (double)(n + 1);
            jSONArray.fluentAdd((Object)new JSONObject().fluentPut("threshold", (Object)d3).fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)((ayp)entry2.getValue()).axe)));
            ++n2;
        }
        if (this.awZ.nK()) {
            bce.warn("'" + String.valueOf(this.awZ.nM()) + "' do not support icons yet. Create the 'item_model' manually. Skipping icon generation for: " + this.awZ.nL());
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }
}
