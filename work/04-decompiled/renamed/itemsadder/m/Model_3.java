package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBridge_10;
import itemsadder.m.Minecraft;
import itemsadder.m.Minecraft_2;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Model_3
extends Minecraft_2 {
    public Model_3(MaterialBridge_10 materialBridge_10) {
        super(materialBridge_10);
    }

    @Override
    void AR() {
        d d2 = new d(this.awZ.nM());
        JSONObject jSONObject = d2.BR();
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("fallback");
        jSONObject3.getJSONObject("on_false").put((Object)"model", (Object)this.axa.axe);
        JSONObject jSONObject4 = jSONObject3.getJSONObject("on_true");
        JSONArray jSONArray = jSONObject4.getJSONArray("entries");
        jSONArray.clear();
        List<Map.Entry> list = this.axb.entrySet().stream().filter(entry -> ((String)entry.getKey()).startsWith("pulling_")).sorted(Comparator.comparingInt(entry -> Integer.parseInt(((String)entry.getKey()).substring("pulling_".length())))).toList();
        String string = this.bW("pulling_0");
        if (string != null) {
            JSONObject jSONObject5 = jSONObject4.getJSONObject("fallback");
            jSONObject5.put((Object)"model", (Object)string);
        }
        int n = list.size() - 1;
        int n2 = 0;
        for (Map.Entry object2 : list) {
            if (((String)object2.getKey()).equals("pulling_0")) continue;
            double string2 = (double)(n2 + 1) / (double)(n + 1);
            jSONArray.fluentAdd((Object)new JSONObject().fluentPut("threshold", (Object)string2).fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)((Minecraft)object2.getValue()).axe)));
            ++n2;
        }
        JSONArray jSONArray2 = jSONObject2.getJSONArray("cases");
        jSONArray2.clear();
        String string2 = this.an("arrow", this.axa.axe);
        String string3 = this.an("rocket", this.axa.axe);
        jSONArray2.fluentAdd((Object)new JSONObject().fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)string2)).fluentPut("when", (Object)"arrow")).fluentAdd((Object)new JSONObject().fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)string3)).fluentPut("when", (Object)"rocket"));
        if (this.awZ.nK()) {
            CommandSenderBridge_5.warn("'" + String.valueOf(this.awZ.nM()) + "' do not support icons yet. Create the 'item_model' manually. Skipping icon generation for: " + this.awZ.nL());
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }
}
