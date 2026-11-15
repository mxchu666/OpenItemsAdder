package dev.lone.itemsadder.resourcepack;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.at;
import dev.lone.itemsadder.resourcepack.generator.file.data.d;
import dev.lone.itemsadder.resourcepack.i;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBridge_10;
import itemsadder.m.VersionHelper_2;
import java.util.HashMap;
import java.util.Map;

public final class h {
    public void a(HashMap hashMap, i i3, String string, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject().fluentPut("type", (Object)"range_dispatch").fluentPut("property", (Object)"custom_model_data").fluentPut("index", (Object)0);
        d d2 = this.a(i3, string);
        if (d2 == null) {
            return;
        }
        jSONObject3.put((Object)"fallback", (Object)this.a(string, d2));
        JSONArray jSONArray = new JSONArray();
        jSONObject3.put((Object)"entries", (Object)jSONArray);
        jSONObject2.put((Object)"model", (Object)jSONObject3);
        this.a(i3, string, jSONObject, d2, jSONArray);
        jSONObject2.put((Object)"oversized_in_gui", (Object)true);
        hashMap.computeIfAbsent(i3, i2 -> new HashMap()).put(string, at.w(jSONObject2));
    }

    private d a(i i2, String string) {
        if (string.equals("crossbow")) {
            d d2 = d.e(string, Version.v1_21_4);
            if (!d2.BN()) {
                return d2;
            }
        } else if (string.equals("bow")) {
            d d3 = d.e(string, Version.v1_21_4);
            if (!d3.BN()) {
                return d3;
            }
        } else {
            d d4 = d.e(string, i2.baseVersion);
            if (!d4.BN()) {
                return d4;
            }
            d4 = d.e(string, VersionHelper_2.ax());
            if (!d4.BN()) {
                return d4;
            }
        }
        CommandSenderBridge_5.error("Failed to load fallback model for material " + string + ". Skipping 1.21.4+ compatibility file creation.");
        return null;
    }

    private JSONObject a(String string, d d2) {
        JSONObject jSONObject = d2.BQ().getJSONObject("model");
        if (string.contains("leather_")) {
            jSONObject.fluentPut("type", (Object)"model").fluentPut("model", (Object)("item/" + string)).put((Object)"tints", (Object)new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("type", (Object)"dye").fluentPut("default", (Object)-6265536)));
        }
        return jSONObject;
    }

    private void a(i i2, String string, JSONObject jSONObject, d d2, JSONArray jSONArray) {
        Object object;
        Object object2;
        JSONObject jSONObject2;
        Object object3;
        JSONArray jSONArray2 = jSONObject.getJSONArray("overrides");
        if (jSONArray2 == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        HashMap hashMap2 = new HashMap();
        for (Object object4 : jSONArray2) {
            int n;
            object3 = (JSONObject)object4;
            jSONObject2 = object3.getJSONObject("predicate");
            if (jSONObject2 == null || !jSONObject2.containsKey("custom_model_data") || (n = jSONObject2.getIntValue("custom_model_data")) < 0) continue;
            object2 = this.a(n, hashMap2, jSONArray, d2);
            object = object2.getJSONObject("model");
            String string2 = object3.getString("model");
            boolean bl = this.a(i2, string, jSONObject2, string2, (JSONObject)object2, (JSONObject)object);
            if (n > 0 && !bl) {
                this.a(string, n, string2, (JSONObject)object2, (JSONObject)object);
            }
            if (!ItemStackRegistry.g().Y.containsKey(string2)) continue;
            hashMap.put(string2, object2);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            object3 = (String)entry.getKey();
            jSONObject2 = ((JSONObject)entry.getValue()).getJSONObject("model");
            ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)ItemStackRegistry.g().Y.get(object3);
            object2 = itemStackBuilder_4.FX;
            if (object2 != null) {
                if (((MaterialBridge_10)object2).nJ() != null) {
                    CommandSenderBridge_5.iA("--- model has graphics.icon, using as special. Icon: " + ((MaterialBridge_10)object2).mR());
                    this.a(jSONObject2, ((MaterialBridge_10)object2).nJ());
                    continue;
                }
            } else {
                object = itemStackBuilder_4.mS();
                if (object != null && !((String)object).isEmpty()) {
                    this.a(jSONObject2, (String)object);
                    CommandSenderBridge_5.iA("--- model has icon, using as special. Icon: " + (String)object);
                    continue;
                }
            }
            if (!"minecraft:display_context".equals(jSONObject2.getString("property"))) continue;
            this.a(jSONObject2, (String)object3);
        }
    }

    void a(JSONObject jSONObject, String string) {
        JSONObject jSONObject2 = c.a(jSONObject);
        if (jSONObject2.containsKey("fallback")) {
            jSONObject2 = jSONObject2.getJSONObject("fallback");
        }
        jSONObject.clear();
        jSONObject.fluentPut("type", (Object)"select").fluentPut("property", (Object)"display_context").fluentPut("cases", (Object)new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)string)).fluentPut("when", (Object)new JSONArray().fluentAdd((Object)"gui").fluentAdd((Object)"ground").fluentAdd((Object)"fixed")))).fluentPut("fallback", (Object)jSONObject2);
    }

    private JSONObject a(int n, Map map, JSONArray jSONArray, d d2) {
        JSONObject jSONObject = (JSONObject)map.get(n);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject().fluentPut("threshold", (Object)n);
        JSONObject jSONObject3 = d2.BR().getJSONObject("model").clone();
        if (jSONObject3.containsKey("on_true")) {
            jSONObject3.getJSONObject("on_true").computeIfPresent((Object)"entries", (string, object) -> {
                ((JSONArray)object).clear();
                return object;
            });
        }
        jSONObject2.put((Object)"model", (Object)jSONObject3);
        jSONArray.add((Object)jSONObject2);
        map.put(n, jSONObject2);
        return jSONObject2;
    }

    private boolean a(i i2, String string, JSONObject jSONObject, String string2, JSONObject jSONObject2, JSONObject jSONObject3) {
        return switch (string) {
            case "shield" -> this.a(i2, jSONObject, string2, jSONObject3);
            case "bow" -> this.a(jSONObject, string2, jSONObject3);
            case "crossbow" -> this.b(jSONObject, string2, jSONObject3);
            case "fishing_rod" -> this.c(jSONObject, string2, jSONObject3);
            case "trident" -> this.d(jSONObject, string2, jSONObject3);
            default -> false;
        };
    }

    private void a(String string, int n, String string2, JSONObject jSONObject, JSONObject jSONObject2) {
        if ("player_head".equals(string)) {
            jSONObject2.put((Object)"base", (Object)string2);
            return;
        }
        jSONObject.fluentPut("model", (Object)jSONObject2);
        jSONObject2.fluentPut("type", (Object)"model").fluentPut("model", (Object)string2);
        if (string.contains("leather_")) {
            try {
                int n2 = ItemStackRegistry.g().a(n);
                jSONObject2.fluentPut("tints", (Object)new JSONArray().fluentAdd((Object)new JSONObject().fluentPut("type", (Object)"dye").fluentPut("default", (Object)n2)));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private boolean a(i i2, JSONObject jSONObject, String string, JSONObject jSONObject2) {
        if (!jSONObject.containsKey("blocking") || jSONObject.getInteger("blocking") == 0) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("on_false");
            jSONObject3.put((Object)"type", (Object)"model");
            jSONObject3.put((Object)"model", (Object)string);
            if (i2.baseVersion.ordinal() >= Version.v26_1_1.ordinal()) {
                jSONObject3.fluentPut("transformation", (Object)new JSONObject().fluentPut("left_rotation", (Object)new JSONArray().fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)1.0)).fluentPut("right_rotation", (Object)new JSONArray().fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)1.0)).fluentPut("scale", (Object)new JSONArray().fluentAdd((Object)1.0).fluentAdd((Object)-1.0).fluentAdd((Object)-1.0)).fluentPut("translation", (Object)new JSONArray().fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)0.0)));
            }
        } else if (jSONObject.getInteger("blocking") == 1) {
            JSONObject jSONObject4 = jSONObject2.getJSONObject("on_true");
            jSONObject4.put((Object)"type", (Object)"model");
            jSONObject4.put((Object)"model", (Object)string);
            if (i2.baseVersion.ordinal() >= Version.v26_1_1.ordinal()) {
                jSONObject4.fluentPut("transformation", (Object)new JSONObject().fluentPut("left_rotation", (Object)new JSONArray().fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)1.0)).fluentPut("right_rotation", (Object)new JSONArray().fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)1.0)).fluentPut("scale", (Object)new JSONArray().fluentAdd((Object)1.0).fluentAdd((Object)-1.0).fluentAdd((Object)-1.0)).fluentPut("translation", (Object)new JSONArray().fluentAdd((Object)0.0).fluentAdd((Object)0.0).fluentAdd((Object)0.0)));
            }
        } else {
            CommandSenderBridge_5.error("Invalid blocking value for shield model override: " + jSONObject.getInteger("blocking"));
            return true;
        }
        return true;
    }

    private boolean a(JSONObject jSONObject, String string, JSONObject jSONObject2) {
        JSONObject jSONObject3 = jSONObject2.getJSONObject("on_true");
        JSONArray jSONArray = jSONObject3.getJSONArray("entries");
        if (jSONObject.containsKey("pulling") && jSONObject.getInteger("pulling") == 1 && jSONObject.containsKey("pull")) {
            jSONArray.add((Object)new JSONObject().fluentPut("threshold", (Object)jSONObject.getFloat("pull")).fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)string)));
        } else {
            if (!jSONObject.containsKey("pulling") || jSONObject.getInteger("pulling") != 1) {
                jSONObject2.getJSONObject("on_false").put((Object)"model", (Object)string);
            }
            jSONObject2.getJSONObject("on_true").getJSONObject("fallback").put((Object)"model", (Object)string);
        }
        return true;
    }

    private boolean b(JSONObject jSONObject, String string, JSONObject jSONObject2) {
        JSONObject jSONObject3 = jSONObject2.getJSONObject("on_true");
        JSONArray jSONArray = jSONObject3.getJSONArray("entries");
        if (jSONObject.containsKey("pulling") && jSONObject.getInteger("pulling") == 1 && jSONObject.containsKey("pull")) {
            jSONArray.add((Object)new JSONObject().fluentPut("threshold", (Object)jSONObject.getFloat("pull")).fluentPut("model", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)string)));
        } else {
            JSONObject jSONObject4 = jSONObject2.getJSONObject("on_false");
            JSONArray jSONArray2 = jSONObject4.getJSONArray("cases");
            if (jSONObject.containsKey("charged") && jSONObject.getInteger("charged") == 1) {
                boolean bl = jSONObject.containsKey("firework") && jSONObject.getInteger("firework") == 1;
                String string2 = bl ? "rocket" : "arrow";
                for (Object e : jSONArray2) {
                    JSONObject jSONObject5 = (JSONObject)e;
                    if (!jSONObject5.getString("when").equals(string2)) continue;
                    jSONObject5.put((Object)"model", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)string));
                    break;
                }
            } else if (!jSONObject.containsKey("pulling")) {
                jSONObject4.put((Object)"model", (Object)string);
                jSONObject4.put((Object)"fallback", (Object)new JSONObject().fluentPut("type", (Object)"model").fluentPut("model", (Object)string));
                jSONObject3.getJSONObject("fallback").put((Object)"model", (Object)string);
            }
        }
        return true;
    }

    private boolean c(JSONObject jSONObject, String string, JSONObject jSONObject2) {
        jSONObject2.put((Object)"type", (Object)"minecraft:condition");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("on_true");
        JSONObject jSONObject4 = jSONObject2.getJSONObject("on_false");
        if (jSONObject.containsKey("cast") && jSONObject.getInteger("cast") == 1) {
            jSONObject3.fluentPut("model", (Object)string).fluentPut("type", (Object)"model");
        } else {
            jSONObject4.fluentPut("model", (Object)string).fluentPut("type", (Object)"model");
        }
        return true;
    }

    boolean d(JSONObject jSONObject, String string, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONObject jSONObject4 = jSONObject2.getJSONObject("fallback");
        if (!jSONObject.containsKey("throwing") || jSONObject.getInteger("throwing") == 0) {
            jSONObject3 = jSONObject4.getJSONObject("on_false");
        } else if (jSONObject.getInteger("throwing") == 1) {
            jSONObject3 = jSONObject4.getJSONObject("on_true");
        } else {
            CommandSenderBridge_5.error("Invalid throwing value for trident model override: " + jSONObject.getInteger("throwing"));
            return true;
        }
        jSONObject3.remove((Object)"base");
        jSONObject3.put((Object)"type", (Object)"model");
        jSONObject3.put((Object)"model", (Object)string);
        return true;
    }
}
