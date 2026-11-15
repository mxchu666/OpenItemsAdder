package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bce;
import itemsadder.m.qm;
import itemsadder.m.rh;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import org.apache.commons.io.FileUtils;

public class tb {
    public static boolean c(bbg bbg2) {
        return bbg2.fo("components_nbt_file") || bbg2.fo("nbt");
    }

    public static void a(qm qm2, bbg bbg2, bbf bbf2) {
        String string;
        if (bbg2.gP("nbt") && bbg2.gP("components_nbt_file")) {
            bce.warn("[Items] '" + qm2.getNamespacedID() + "'. Both 'nbt' and 'components_nbt_file' are set. 'nbt' will be ignored. File: " + bbf2.nh());
        }
        if ((string = bbg2.gV("components_nbt_file")) != null) {
            File file = new File(bbf2.getFile().getParent(), string);
            if (file.exists()) {
                String string2 = null;
                try {
                    string2 = FileUtils.readFileToString((File)file, (Charset)StandardCharsets.UTF_8);
                }
                catch (IOException iOException) {
                    bce.error("[Items] '" + qm2.getNamespacedID() + "'. Error reading 'components_nbt_file' property. File: " + bbf2.nh());
                    bce.error("Error: " + iOException.getMessage());
                }
                if (string2 != null) {
                    try {
                        c.ji(string2);
                    }
                    catch (ExecutionException executionException) {
                        bce.error("[Items] '" + qm2.getNamespacedID() + "'. Error parsing 'components_nbt_file' property. File: " + bbf2.nh());
                        bce.error("Error: " + executionException.getMessage());
                    }
                    try {
                        qm2.bE(tb.a(qm2, string2, bbf2));
                    }
                    catch (Exception exception) {
                        bce.error("[Items] '" + qm2.getNamespacedID() + "'. Error injecting 'components_nbt_file' property. File: " + bbf2.nh());
                        bce.error("Error: " + exception.getMessage());
                    }
                }
            } else {
                bce.error("[Items] '" + qm2.getNamespacedID() + "'. Error: 'components_nbt_file' not found. File: " + bbf2.nh());
            }
        } else {
            String string3 = bbg2.az("nbt", null);
            if (string3 != null) {
                try {
                    qm2.bE(tb.a(qm2, string3, bbf2));
                }
                catch (Exception exception) {
                    bce.error("[Items] '" + qm2.getNamespacedID() + "'. Error injecting 'nbt' property. File: " + bbf2.nh());
                    bce.error("Error: " + exception.getMessage());
                }
            }
        }
    }

    private static String a(qm qm2, String string, bbf bbf2) {
        boolean bl;
        float f;
        rh rh2 = qm2.nv();
        int n = rh2 != null ? rh2.nT() : 0;
        String string2 = tb.a(string, n, f = rh2 != null ? rh2.nU() : 0.0f, bl = Version.isNewerThan((Version)Version.v1_21_1));
        if (!string2.equals(string)) {
            bce.warn("[Items] '" + qm2.getNamespacedID() + "'. Incomplete or version-incompatible 'food'/'consumable' component. Using nutrition=" + n + " and saturation=" + f + (bl ? "." : "; unsupported 1.21.2+ consumable properties were ignored.") + " File: " + bbf2.nh());
        }
        return string2;
    }

    static String a(String string, int n, float f, boolean bl) {
        try {
            JSONObject jSONObject = JSON.parseObject((String)string);
            JSONObject jSONObject2 = jSONObject.getJSONObject("components");
            if (jSONObject2 == null) {
                return string;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("minecraft:food");
            if (jSONObject3 == null) {
                jSONObject3 = jSONObject2.getJSONObject("food");
            }
            boolean bl2 = false;
            if (!bl) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject("minecraft:consumable");
                String string2 = "minecraft:consumable";
                if (jSONObject4 == null) {
                    jSONObject4 = jSONObject2.getJSONObject("consumable");
                    string2 = "consumable";
                }
                if (jSONObject4 != null) {
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                        jSONObject2.put((Object)"minecraft:food", (Object)jSONObject3);
                    }
                    if (!jSONObject3.containsKey("eat_seconds") && jSONObject4.containsKey("consume_seconds")) {
                        jSONObject3.put((Object)"eat_seconds", jSONObject4.get("consume_seconds"));
                    }
                    jSONObject2.remove((Object)string2);
                    bl2 = true;
                }
            }
            if (jSONObject3 == null) {
                return bl2 ? JSON.toJSONString((Object)jSONObject) : string;
            }
            if (!jSONObject3.containsKey("nutrition")) {
                jSONObject3.put((Object)"nutrition", (Object)n);
                bl2 = true;
            }
            if (!jSONObject3.containsKey("saturation")) {
                jSONObject3.put((Object)"saturation", (Object)Float.valueOf(f));
                bl2 = true;
            }
            return bl2 ? JSON.toJSONString((Object)jSONObject) : string;
        }
        catch (RuntimeException runtimeException) {
            return string;
        }
    }
}
