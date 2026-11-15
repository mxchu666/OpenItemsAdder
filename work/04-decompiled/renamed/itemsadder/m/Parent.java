package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.JsonAsset;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Generated;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBridge_10;
import itemsadder.m.MaterialBridge_12;
import itemsadder.m.Minecraft;
import itemsadder.m.Textures;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class Parent
extends Generated {
    public Parent(MaterialBridge_10 materialBridge_10) {
        super(materialBridge_10);
    }

    @Override
    void AQ() {
        this.axb = new HashMap();
        Object object = this.awZ;
        if (object instanceof MaterialBridge_12) {
            Map map;
            MaterialBridge_12 materialBridge_12 = (MaterialBridge_12)object;
            object = e.R(this.awZ.nM());
            if (((JsonAsset)object).BN()) {
                throw new IllegalArgumentException("Original model of material " + String.valueOf(this.awZ.nM()) + " has errors", ((JsonAsset)object).BO());
            }
            JSONObject jSONObject = ((JsonAsset)object).BR();
            jSONObject.put((Object)"parent", (Object)materialBridge_12.oC());
            JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
                jSONObject.put((Object)"textures", (Object)jSONObject2);
            }
            if (!(map = materialBridge_12.oD()).containsKey("layer0") && !map.containsKey("normal")) {
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
            this.axa = new Minecraft(this.awZ.nH(), this.awZ.nG(), jSONObject);
        } else {
            object = this.awZ.nG();
            @Nullable File file = ItemStackRegistry.s((String)object);
            if (file == null && ItemStackRegistry.g().B.Q(this.awZ.nH())) {
                file = ItemStackRegistry.g().B.S(this.awZ.nH());
            }
            if (file != null && file.exists()) {
                try {
                    JSONObject jSONObject = c.N(file);
                    this.axa = new Minecraft(this.awZ.nH(), this.awZ.nG(), jSONObject);
                }
                catch (IOException iOException) {
                    throw new IllegalArgumentException(iOException);
                }
            } else {
                CommandSenderBridge_5.iA("Model asset file not found: " + (String)object);
                throw new IllegalArgumentException("Model asset file not found: " + (String)object);
            }
        }
        if (this.awZ.nn() != null && this.awZ.nn().op() != null) {
            this.axb.put("broken", new Minecraft(this.awZ.bW("broken"), this.awZ.bV("broken"), Textures.l(this.axa.axg, this.awZ.nn().op())));
        }
    }

    @Override
    void AR() {
        if (this.awZ.nn() != null) {
            Minecraft minecraft = (Minecraft)this.axb.get("broken");
            JSONObject jSONObject = Textures.ar(this.axa.axe, minecraft == null ? this.axa.axe : minecraft.axe);
            if (this.awZ.nJ() != null) {
                this.a(jSONObject.getJSONObject("model"), this.awZ.nJ());
            }
            this.z(jSONObject);
            this.axd = jSONObject;
            return;
        }
        d d2 = new d(this.awZ.nM());
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
