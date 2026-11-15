package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;

final class o {
    private static final String arq = "_iainternal:item_context/";

    o() {
    }

    static p a(Map map, Collection collection, Collection collection2) {
        TreeMap treeMap = new TreeMap();
        map.forEach((string, jSONObject) -> treeMap.put(o.el(string), jSONObject));
        Set set = o.b(collection, treeMap);
        Set set2 = o.b(collection2, treeMap);
        TreeSet treeSet = new TreeSet(set);
        treeSet.retainAll(set2);
        TreeMap<String, Set> treeMap2 = new TreeMap<String, Set>();
        for (String string2 : collection) {
            String string3 = o.el(string2);
            Set set3 = o.a(string3, treeMap::get);
            if (set3.isEmpty()) continue;
            treeMap2.put(string3, set3);
        }
        return new p(treeMap, set, set2, treeSet, treeMap2);
    }

    static String el(String string) {
        Object object = string.trim();
        if (((String)object).endsWith(".json")) {
            object = ((String)object).substring(0, ((String)object).length() - ".json".length());
        }
        if (!((String)object).contains(":")) {
            object = "minecraft:" + (String)object;
        }
        return object;
    }

    static String em(String string) {
        String string2 = o.el(string);
        int n = string2.indexOf(58);
        return "assets/" + string2.substring(0, n) + "/models/" + string2.substring(n + 1) + ".json";
    }

    private static Set b(Collection collection, Map map) {
        TreeSet treeSet = new TreeSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String string : collection) {
            o.a(o.el(string), map, treeSet, hashSet, hashSet2);
        }
        return treeSet;
    }

    private static void a(String string, Map map, Set set, Set set2, Set set3) {
        if (set2.contains(string)) {
            return;
        }
        if (!set3.add(string)) {
            throw new IllegalStateException("Model parent cycle detected at '" + string + "'");
        }
        JSONObject jSONObject = (JSONObject)map.get(string);
        if (jSONObject != null) {
            set.add(string);
            String string2 = jSONObject.getString("parent");
            if (string2 != null && !string2.isBlank()) {
                o.a(o.el(string2), map, set, set2, set3);
            }
        }
        set3.remove(string);
        set2.add(string);
    }

    static Set a(String string2, Function function) {
        Object object2;
        TreeMap treeMap;
        JSONObject jSONObject;
        ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
        HashSet<String> hashSet = new HashSet<String>();
        String string3 = o.el(string2);
        while (hashSet.add(string3) && (jSONObject = (JSONObject)function.apply(string3)) != null) {
            arrayList.add(jSONObject);
            treeMap = jSONObject.getString("parent");
            if (treeMap == null || ((String)((Object)treeMap)).isBlank()) break;
            string3 = o.el(treeMap);
        }
        jSONObject = null;
        for (JSONObject jSONObject2 : arrayList) {
            Object object3 = jSONObject2.get("elements");
            if (!(object3 instanceof JSONArray)) continue;
            object2 = (JSONArray)object3;
            jSONObject = object2;
            break;
        }
        if (jSONObject == null || jSONObject.isEmpty()) {
            return Set.of();
        }
        treeMap = new TreeMap();
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            object2 = ((JSONObject)arrayList.get(i)).getJSONObject("textures");
            if (object2 == null) continue;
            object2.forEach((string, object) -> {
                String string2;
                if (object instanceof String) {
                    String string3;
                    v0 = string3 = (String)object;
                } else if (object instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject)object;
                    v0 = jSONObject.getString("sprite");
                } else {
                    v0 = string2 = null;
                }
                if (string2 != null) {
                    treeMap.put(string, string2);
                }
            });
        }
        TreeSet<String> treeSet = new TreeSet<String>();
        for (Object object3 : jSONObject) {
            JSONObject jSONObject3;
            Iterator iterator;
            if (!(object3 instanceof JSONObject) || !((iterator = (jSONObject3 = (JSONObject)object3).get("faces")) instanceof JSONObject)) continue;
            JSONObject jSONObject4 = (JSONObject)iterator;
            iterator = jSONObject4.values().iterator();
            while (iterator.hasNext()) {
                String string4;
                JSONObject jSONObject5;
                String string5;
                Object e = iterator.next();
                if (!(e instanceof JSONObject) || (string5 = (jSONObject5 = (JSONObject)e).getString("texture")) == null || !string5.startsWith("#") || (string4 = o.a(string5.substring(1), treeMap)) == null) continue;
                treeSet.add(string4);
            }
        }
        return treeSet;
    }

    private static String a(String string, Map map) {
        HashSet<String> hashSet = new HashSet<String>();
        while (hashSet.add(string)) {
            String string2 = (String)map.get(string);
            if (string2 == null) {
                return string;
            }
            if (!string2.startsWith("#")) {
                return null;
            }
            string = string2.substring(1);
        }
        return string;
    }

    private static String en(String string) {
        String string2 = o.el(string);
        int n = string2.indexOf(58);
        return arq + string2.substring(0, n) + "/" + string2.substring(n + 1);
    }
}
