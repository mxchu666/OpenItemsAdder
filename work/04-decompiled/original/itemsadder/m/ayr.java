package itemsadder.m;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.generator.file.data.e;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ayo;
import itemsadder.m.ayp;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.rc;
import itemsadder.m.rp;
import itemsadder.m.rq;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public abstract class ayr
extends ayo {
    public ayr(rc rc2) {
        super(rc2);
    }

    @Override
    void AQ() {
        this.axb = new HashMap();
        rc rc2 = this.awZ;
        if (rc2 instanceof rq) {
            rq rq2 = (rq)rc2;
            this.a(rq2);
        } else {
            rc2 = this.awZ;
            if (rc2 instanceof rp) {
                rp rp2 = (rp)rc2;
                this.a(rp2);
            }
        }
    }

    void a(rq rq2) {
        e e2 = e.R(this.awZ.nM());
        if (e2.BN()) {
            throw new IllegalArgumentException("Original model of material '" + String.valueOf(this.awZ.nM()) + "' has errors", e2.BO());
        }
        Map map = rq2.oD();
        map.forEach((string, string2) -> {
            string = string.toLowerCase().trim();
            JSONObject jSONObject = e2.BR();
            JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
            jSONObject2.put((Object)"layer0", string2);
            ayp ayp2 = new ayp(this.awZ.bW((String)string), this.awZ.bV((String)string), jSONObject);
            if (string.equals("normal")) {
                this.axa = ayp2;
            } else {
                this.axb.put(string, ayp2);
            }
        });
    }

    void a(rp rp2) {
        Map map = rp2.oB();
        map.forEach((string, string2) -> {
            string = string.toLowerCase().trim();
            String string3 = this.awZ.bV((String)string);
            String string4 = this.awZ.bW((String)string);
            JSONObject jSONObject = null;
            File file = d.s(string3);
            if (file != null && file.exists()) {
                bce.iA("Using model asset file: " + file.getAbsolutePath());
                try {
                    jSONObject = c.N(file);
                }
                catch (IOException iOException) {
                    throw new IllegalArgumentException("Failed to load JSON model: " + bcy.I(file), iOException);
                }
            } else {
                if (!string4.startsWith("minecraft:")) {
                    bce.iA("Model asset file not found: " + string3);
                    throw new IllegalArgumentException("Model asset file not found: " + string3);
                }
                if (!d.g().B.Q(string4)) {
                    throw new IllegalArgumentException("Model '" + string4 + "' is not a valid vanilla model. Item: " + this.awZ.nL());
                }
            }
            ayp ayp2 = new ayp(string4, string3, jSONObject);
            if (string.equals("normal")) {
                this.axa = ayp2;
            } else {
                this.axb.put(string, ayp2);
            }
        });
    }

    @Nullable
    String bW(String string) {
        return this.an(string, null);
    }

    @Nullable
    String an(String string, @Nullable String string2) {
        return this.axb.entrySet().stream().filter(entry -> ((String)entry.getKey()).equals(string)).map(entry -> ((ayp)entry.getValue()).axe).findFirst().orElse(string2);
    }
}
