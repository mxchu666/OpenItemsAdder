package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent$PackEntry;
import dev.lone.itemsadder.resourcepack.bm;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

final class bl {
    private bl() {
    }

    static boolean d(File file, String string) {
        if (ae.ap() && string.contains("minecraft/shaders/core/") && (string.contains("rendertype_text") || bl.fE(string).equals("text"))) {
            bce.warn("Found shader overlapping an ItemsAdder Texts shader: " + bcy.I(file) + " -> " + bcy.iO(string));
            bce.warn("Disable text-effects to edit these shaders manually.");
            return true;
        }
        if (ae.aq() && string.contains("minecraft/shaders/core/") && string.contains("rendertype_armor_cutout_no_cull")) {
            bce.warn("Found shader overlapping an ItemsAdder Armors shader: " + bcy.I(file) + " -> " + bcy.iO(string));
            bce.warn("Disable emotes to edit these shaders manually.");
            return true;
        }
        return false;
    }

    static void m(Map map) {
        if (!ae.fo) {
            return;
        }
        for (ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry : List.copyOf(map.values())) {
            String string = bcy.iR(itemsAdderPackCompressedEvent$PackEntry.getPath());
            if (itemsAdderPackCompressedEvent$PackEntry.isRemoved() || !bl.fD(string)) continue;
            try {
                JSONObject jSONObject = JSON.parseObject((String)bm.c(itemsAdderPackCompressedEvent$PackEntry));
                boolean bl2 = bl.k(jSONObject, "vertex") | bl.k(jSONObject, "fragment");
                if (!bl2) continue;
                bce.log("[Pack] pre-1.21.2 shader JSON found. Adding 1.21.2+ compatibility. File: " + bcy.iP(string));
                String string2 = "ia_overlay_1_21_2_plus/" + string;
                map.putIfAbsent(string2, ItemsAdderPackCompressedEvent$PackEntry.bytes(string2, jSONObject.toJSONString(new JSONWriter.Feature[0]).getBytes(StandardCharsets.UTF_8)));
            }
            catch (Throwable throwable) {
                bce.warn("Malformed shader JSON. File: " + bcy.iP(string) + ". " + bm.a(throwable));
            }
        }
    }

    private static boolean k(JSONObject jSONObject, String string) {
        String string2;
        Object object = jSONObject.get(string);
        if (!(object instanceof String) || (string2 = (String)object).startsWith("core/") || string2.startsWith("minecraft:core/")) {
            return false;
        }
        jSONObject.put((Object)string, (Object)("core/" + string2));
        return true;
    }

    private static boolean fD(String string) {
        return string.endsWith(".json") && string.contains("assets/minecraft/shaders/core/");
    }

    private static String fE(String string) {
        int n;
        int n2 = string.lastIndexOf(47);
        int n3 = string.lastIndexOf(46);
        return n3 > (n = n2 + 1) ? string.substring(n, n3) : string.substring(n);
    }
}
