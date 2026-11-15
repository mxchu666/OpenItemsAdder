package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Generated;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBridge_10;
import itemsadder.m.MaterialBridge_11;
import itemsadder.m.MaterialBridge_12;
import itemsadder.m.Minecraft;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public abstract class Minecraft_2
extends Generated {
    public Minecraft_2(MaterialBridge_10 materialBridge_10) {
        super(materialBridge_10);
    }

    @Override
    void AQ() {
        this.axb = new HashMap();
        MaterialBridge_10 materialBridge_10 = this.awZ;
        if (materialBridge_10 instanceof MaterialBridge_12) {
            MaterialBridge_12 materialBridge_12 = (MaterialBridge_12)materialBridge_10;
            this.a(materialBridge_12);
        } else {
            materialBridge_10 = this.awZ;
            if (materialBridge_10 instanceof MaterialBridge_11) {
                MaterialBridge_11 materialBridge_11 = (MaterialBridge_11)materialBridge_10;
                this.a(materialBridge_11);
            }
        }
    }

    void a(MaterialBridge_12 materialBridge_12) {
        e e2 = e.R(this.awZ.nM());
        if (e2.BN()) {
            throw new IllegalArgumentException("Original model of material '" + String.valueOf(this.awZ.nM()) + "' has errors", e2.BO());
        }
        Map map = materialBridge_12.oD();
        map.forEach((string, string2) -> {
            string = string.toLowerCase().trim();
            JSONObject jSONObject = e2.BR();
            JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
            jSONObject2.put((Object)"layer0", string2);
            Minecraft minecraft = new Minecraft(this.awZ.bW((String)string), this.awZ.bV((String)string), jSONObject);
            if (string.equals("normal")) {
                this.axa = minecraft;
            } else {
                this.axb.put(string, minecraft);
            }
        });
    }

    void a(MaterialBridge_11 materialBridge_11) {
        Map map = materialBridge_11.oB();
        map.forEach((string, string2) -> {
            string = string.toLowerCase().trim();
            String string3 = this.awZ.bV((String)string);
            String string4 = this.awZ.bW((String)string);
            JSONObject jSONObject = null;
            File file = ItemStackRegistry.s(string3);
            if (file != null && file.exists()) {
                CommandSenderBridge_5.iA("Using model asset file: " + file.getAbsolutePath());
                try {
                    jSONObject = c.N(file);
                }
                catch (IOException iOException) {
                    throw new IllegalArgumentException("Failed to load JSON model: " + ColorBridge.I(file), iOException);
                }
            } else {
                if (!string4.startsWith("minecraft:")) {
                    CommandSenderBridge_5.iA("Model asset file not found: " + string3);
                    throw new IllegalArgumentException("Model asset file not found: " + string3);
                }
                if (!ItemStackRegistry.g().B.Q(string4)) {
                    throw new IllegalArgumentException("Model '" + string4 + "' is not a valid vanilla model. Item: " + this.awZ.nL());
                }
            }
            Minecraft minecraft = new Minecraft(string4, string3, jSONObject);
            if (string.equals("normal")) {
                this.axa = minecraft;
            } else {
                this.axb.put(string, minecraft);
            }
        });
    }

    @Nullable
    String bW(String string) {
        return this.an(string, null);
    }

    @Nullable
    String an(String string, @Nullable String string2) {
        return this.axb.entrySet().stream().filter(entry -> ((String)entry.getKey()).equals(string)).map(entry -> ((Minecraft)entry.getValue()).axe).findFirst().orElse(string2);
    }
}
