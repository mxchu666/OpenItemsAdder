package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.o;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

final class p {
    private static final String arr = "minecraft:item/iamissing";
    private final Map ars;
    private final Set art;
    private final Set aru;
    private final Set arv;
    private final Map arw;
    private final Map arx;

    private p(Map map, Set set2, Set set3, Set set4, Map map2) {
        boolean bl;
        this.ars = Collections.unmodifiableMap(new TreeMap(map));
        this.art = Collections.unmodifiableSet(new TreeSet(set2));
        this.aru = Collections.unmodifiableSet(new TreeSet(set3));
        this.arv = Collections.unmodifiableSet(new TreeSet(set4));
        TreeMap treeMap = new TreeMap();
        map2.forEach((string, set) -> treeMap.put(string, Collections.unmodifiableSet(new TreeSet(set))));
        this.arw = Collections.unmodifiableMap(treeMap);
        TreeMap<Object, String> treeMap2 = new TreeMap<Object, String>();
        for (Object object : map2.keySet()) {
            treeMap2.putIfAbsent(object, o.en((String)object));
        }
        for (Object object : set4) {
            Object object2 = (JSONObject)map.get(object);
            if (!p.b(object2)) continue;
            treeMap2.put(object, o.en((String)object));
        }
        do {
            bl = false;
            for (Object object2 : set4) {
                String string2;
                if (treeMap2.containsKey(object2)) continue;
                JSONObject jSONObject = (JSONObject)map.get(object2);
                String string3 = string2 = jSONObject == null ? null : jSONObject.getString("parent");
                if ((string2 == null || string2.isBlank() || !treeMap2.containsKey(o.el(string2))) && !p.a((Object)jSONObject, treeMap2.keySet())) continue;
                treeMap2.put(object2, o.en((String)object2));
                bl = true;
            }
        } while (bl);
        this.arx = Collections.unmodifiableMap(treeMap2);
    }

    Set yd() {
        return this.art;
    }

    Set ye() {
        return this.aru;
    }

    Set yf() {
        return this.arv;
    }

    Map yg() {
        return this.arx;
    }

    Map yh() {
        TreeMap<String, JSONObject> treeMap = new TreeMap<String, JSONObject>();
        for (String string : this.art) {
            Set set;
            JSONObject jSONObject = (JSONObject)this.ars.get(string);
            if (jSONObject == null) continue;
            String string2 = jSONObject.getString("parent");
            String string3 = string2 == null || string2.isBlank() ? null : o.el(string2);
            boolean bl = this.arx.containsKey(string);
            boolean bl2 = string3 != null && this.arx.containsKey(string3);
            boolean bl3 = p.a((Object)jSONObject, this.arx.keySet());
            if (!bl && !bl2 && !bl3) continue;
            JSONObject jSONObject2 = p.a(jSONObject);
            if (bl2) {
                jSONObject2.put((Object)"parent", this.arx.get(string3));
            }
            if (bl3) {
                this.t(jSONObject2);
            }
            if ((set = (Set)this.arw.get(string)) != null) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("textures");
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                    jSONObject2.put((Object)"textures", (Object)jSONObject3);
                }
                for (String string4 : set) {
                    jSONObject3.put((Object)string4, (Object)arr);
                }
            }
            treeMap.put(bl ? (String)this.arx.get(string) : string, jSONObject2);
        }
        return treeMap;
    }

    private static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.forEach((string, object) -> jSONObject2.put(string, p.s(object)));
        return jSONObject2;
    }

    private static Object s(Object object2) {
        if (object2 instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject)object2;
            return p.a(jSONObject);
        }
        if (object2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray)object2;
            JSONArray jSONArray2 = new JSONArray();
            jSONArray.forEach(object -> jSONArray2.add(p.s(object)));
            return jSONArray2;
        }
        return object2;
    }

    boolean t(Object object) {
        if (object instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject)object;
            boolean bl = false;
            for (Map.Entry entry : jSONObject.entrySet()) {
                Object v = entry.getValue();
                if ("model".equals(entry.getKey()) && v instanceof String) {
                    String string = (String)v;
                    String string2 = (String)this.arx.get(o.el(string));
                    if (string2 == null) continue;
                    entry.setValue(string2);
                    bl = true;
                    continue;
                }
                if (!this.t(v)) continue;
                bl = true;
            }
            return bl;
        }
        if (object instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray)object;
            boolean bl = false;
            for (Object e : jSONArray) {
                if (!this.t(e)) continue;
                bl = true;
            }
            return bl;
        }
        return false;
    }

    private static boolean b(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject2 = jSONObject == null ? null : jSONObject.getJSONObject("textures");
        if (jSONObject2 == null) {
            return false;
        }
        for (Object e : jSONObject2.values()) {
            String string;
            String string2;
            if (e instanceof JSONObject) {
                JSONObject jSONObject4 = (JSONObject)e;
                string2 = jSONObject4.getString("sprite");
            } else {
                String string3;
                string2 = e instanceof String ? (string3 = (String)e) : null;
            }
            if ((string = string2) == null || string.startsWith("#")) continue;
            return true;
        }
        return false;
    }

    private static boolean a(Object object, Set set) {
        block4: {
            block3: {
                if (!(object instanceof JSONObject)) break block3;
                JSONObject jSONObject = (JSONObject)object;
                for (Map.Entry entry : jSONObject.entrySet()) {
                    String string;
                    Object v = entry.getValue();
                    if ("model".equals(entry.getKey()) && v instanceof String && set.contains(o.el(string = (String)v))) {
                        return true;
                    }
                    if (!p.a(v, set)) continue;
                    return true;
                }
                break block4;
            }
            if (!(object instanceof JSONArray)) break block4;
            JSONArray jSONArray = (JSONArray)object;
            for (Object e : jSONArray) {
                if (!p.a(e, set)) continue;
                return true;
            }
        }
        return false;
    }

    void u(Object object) {
        TreeMap treeMap = new TreeMap();
        this.arx.forEach((string, string2) -> treeMap.put(string2, string));
        p.a(object, treeMap);
    }

    private static void a(Object object2, Map map) {
        if (object2 instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject)object2;
            for (Map.Entry entry : jSONObject.entrySet()) {
                Object v = entry.getValue();
                if (("model".equals(entry.getKey()) || "parent".equals(entry.getKey())) && v instanceof String) {
                    String string = (String)v;
                    entry.setValue(map.getOrDefault(o.el(string), string));
                    continue;
                }
                p.a(v, map);
            }
        } else if (object2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray)object2;
            jSONArray.forEach(object -> p.a(object, map));
        }
    }
}
