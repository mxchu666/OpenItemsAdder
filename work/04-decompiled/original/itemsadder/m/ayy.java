package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.JsonAsset;
import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ayo;
import itemsadder.m.ayp;
import itemsadder.m.ayw;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.rc;
import itemsadder.m.rq;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class ayy
extends ayo {
    public ayy(rc rc2) {
        super(rc2);
    }

    @Override
    void AQ() {
        this.axb = new HashMap();
        Object object = this.awZ;
        if (object instanceof rq) {
            Map map;
            rq rq2 = (rq)object;
            object = e.R(this.awZ.nM());
            if (((JsonAsset)object).BN()) {
                throw new IllegalArgumentException("Original model of material " + String.valueOf(this.awZ.nM()) + " has errors", ((JsonAsset)object).BO());
            }
            JSONObject jSONObject = ((JsonAsset)object).BR();
            jSONObject.put((Object)"parent", (Object)rq2.oC());
            JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
                jSONObject.put((Object)"textures", (Object)jSONObject2);
            }
            if (!(map = rq2.oD()).containsKey("layer0") && !map.containsKey("normal")) {
                jSONObject2.remove((Object)"layer0");
            }
            if (!map.containsKey("layer1")) {
                jSONObject2.remove((Object)"layer1");
            }
            Object object2 = map.entrySet().iterator();
            while (object2.hasNext()) {
                Map.Entry entry = object2.next();
                String string = (String)entry.getKey();
                String string2 = (String)entry.getValue();
                if ((string = string.toLowerCase().trim()).equals("normal")) {
                    string = "layer0";
                }
                jSONObject2.put((Object)string, (Object)string2);
            }
            if (!map.containsKey("particle") && (object2 = (String)map.values().stream().findFirst().orElse(null)) != null) {
                jSONObject2.put((Object)"particle", object2);
            }
            this.axa = new ayp(this.awZ.nH(), this.awZ.nG(), jSONObject);
        } else {
            object = this.awZ.nG();
            @Nullable File file = d.s((String)object);
            if (file == null && d.g().B.Q(this.awZ.nH())) {
                file = d.g().B.S(this.awZ.nH());
            }
            if (file != null && file.exists()) {
                try {
                    JSONObject jSONObject = c.N(file);
                    this.axa = new ayp(this.awZ.nH(), this.awZ.nG(), jSONObject);
                }
                catch (IOException iOException) {
                    throw new IllegalArgumentException(iOException);
                }
            } else {
                bce.iA("Model asset file not found: " + (String)object);
                throw new IllegalArgumentException("Model asset file not found: " + (String)object);
            }
        }
        if (this.awZ.nn() != null && this.awZ.nn().op() != null) {
            this.axb.put("broken", new ayp(this.awZ.bW("broken"), this.awZ.bV("broken"), ayw.l(this.axa.axg, this.awZ.nn().op())));
        }
    }

    @Override
    void AR() {
        if (this.awZ.nn() != null) {
            ayp ayp2 = (ayp)this.axb.get("broken");
            JSONObject jSONObject = ayw.ar(this.axa.axe, ayp2 == null ? this.axa.axe : ayp2.axe);
            if (this.awZ.nJ() != null) {
                this.a(jSONObject.getJSONObject("model"), this.awZ.nJ());
            }
            this.z(jSONObject);
            this.axd = jSONObject;
            return;
        }
        dev.lone.itemsadder.resourcepack.generator.file.data.d d2 = new dev.lone.itemsadder.resourcepack.generator.file.data.d(this.awZ.nM());
        JSONObject jSONObject = d2.BR();
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        if (!jSONObject2.getString("type").equals("minecraft:model")) {
            throw new IllegalArgumentException("Unsupported material " + String.valueOf(this.awZ.nM()) + " for now. Use another one or suggest it on GitHub.");
        }
        jSONObject2.put((Object)"model", (Object)this.axa.axe);
        if (this.awZ.nJ() != null) {
            this.a(jSONObject2, this.awZ.nJ());
        }
        this.z(jSONObject);
        this.axd = jSONObject;
    }
}
