package itemsadder.m;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.ad;
import dev.lone.itemsadder.resourcepack.ak;
import dev.lone.itemsadder.resourcepack.bk;
import dev.lone.itemsadder.resourcepack.generator.file.data.a;
import dev.lone.itemsadder.resourcepack.generator.file.data.g;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public class azr {
    private static final Set ayf = Set.of(Double.valueOf(-45.0), Double.valueOf(-22.5), Double.valueOf(0.0), Double.valueOf(22.5), Double.valueOf(45.0));
    private static final Set ayg = ConcurrentHashMap.newKeySet();
    private static final Set ayh = ConcurrentHashMap.newKeySet();
    private static final Set ayi = ConcurrentHashMap.newKeySet();
    private static final Map ayj = new ConcurrentHashMap();
    final String ayk;
    private final Consumer ayl;

    public azr(String string) {
        this(string, bce::warn);
    }

    azr(String string, Consumer consumer) {
        this.ayk = string;
        this.ayl = consumer;
    }

    public static void Bu() {
        ayg.clear();
        ayh.clear();
        ayi.clear();
        ayj.clear();
    }

    public static void c(Predicate predicate) {
        azr.a(predicate, bce::error);
    }

    static void a(Predicate predicate, Consumer consumer) {
        try {
            ayj.entrySet().stream().filter(entry -> !predicate.test((String)entry.getKey())).sorted(Map.Entry.comparingByKey()).map(azr::l).forEach(consumer);
        }
        finally {
            ayj.clear();
        }
    }

    public g C(JSONObject jSONObject) {
        this.D(jSONObject);
        String string = this.E(jSONObject);
        if (string != null) {
            if (this.F(jSONObject)) {
                jSONObject.clear();
                jSONObject.put((Object)"parent", (Object)"minecraft:item/air");
            } else {
                this.n(jSONObject, string);
                return new g(this.ayk, jSONObject);
            }
        }
        if (ae.dp) {
            this.G(jSONObject);
        }
        g g2 = new g(this.ayk, jSONObject);
        if (jSONObject.containsKey("textures")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("textures");
            for (Map.Entry entry : jSONObject2.entrySet()) {
                String string2;
                Object object = entry.getValue();
                if (!(object instanceof String) || a.gf(string2 = (String)object)) continue;
                object = r.eA(string2);
                if (object != null) {
                    bce.error("Texture '" + string2 + "' has invalid characters: '" + bcy.Q(object) + "'. Do not use special or UPPERCASE characters. File: " + bcy.iP(this.Bv()));
                    continue;
                }
                String string3 = ad.a(string2, ak.TEXTURES, "png");
                if (ad.eQ(string2) && d.g().B.R(string2) || d.b(string2)) {
                    if (string2.contains("item/") || string2.contains("block/")) continue;
                    g2.aw(string3, string2);
                    continue;
                }
                File file = d.s(string3);
                if (file != null) {
                    g2.e(file, string2);
                    continue;
                }
                String string4 = bcy.iP(this.Bv());
                azr.au(string2, string4);
                g2.gm(string2);
            }
        }
        return g2;
    }

    private void D(JSONObject jSONObject) {
        JSONObject jSONObject2;
        block6: {
            block5: {
                String string = jSONObject.getString("parent");
                Object object = jSONObject.get("textures");
                if (!(object instanceof JSONObject)) break block5;
                jSONObject2 = (JSONObject)object;
                if (!jSONObject.containsKey("elements") && !jSONObject2.containsKey("layer0") && ("item/generated".equals(string) || "minecraft:item/generated".equals(string))) break block6;
            }
            return;
        }
        Object object = jSONObject2.get("0");
        if (!(object instanceof String)) {
            return;
        }
        jSONObject2.put((Object)"layer0", object);
        String string = bcy.iP(this.Bv());
        String string2 = "Model: " + string + "\nReason: item/generated requires 'layer0' when the model has no elements\nItemsAdder copied texture '0' to 'layer0'.";
        bk.k("Repaired model textures", string2);
        if (ayi.add(g.gl(this.ayk))) {
            this.ayl.accept("Model used texture '0' where item/generated requires 'layer0'; repaired automatically. File: " + string);
        }
    }

    private String E(JSONObject jSONObject) {
        Object object2;
        Object object3 = jSONObject.get("textures");
        if (object3 != null && !(object3 instanceof JSONObject)) {
            return "'textures' must be a JSON object";
        }
        if (object3 instanceof JSONObject && (object2 = (JSONObject)object3).values().stream().anyMatch(object -> !(object instanceof String))) {
            return "texture values must be strings";
        }
        object2 = jSONObject.get("elements");
        if (object2 == null) {
            return null;
        }
        if (!(object2 instanceof JSONArray)) {
            return "'elements' must be a JSON array";
        }
        JSONArray jSONArray = (JSONArray)object2;
        for (int i2 = 0; i2 < jSONArray.size(); ++i2) {
            Object object4 = jSONArray.get(i2);
            if (!(object4 instanceof JSONObject)) {
                return "element " + i2 + " must be a JSON object";
            }
            JSONObject jSONObject2 = (JSONObject)object4;
            if (!azr.z(jSONObject2.get("from"))) {
                return "element " + i2 + " has a missing or invalid 'from' vector";
            }
            if (!azr.z(jSONObject2.get("to"))) {
                return "element " + i2 + " has a missing or invalid 'to' vector";
            }
            object4 = jSONObject2.get("faces");
            if (object4 != null && !(object4 instanceof JSONObject)) {
                return "element " + i2 + " has invalid 'faces'";
            }
            if (!(object4 instanceof JSONObject)) continue;
            JSONObject jSONObject3 = (JSONObject)object4;
            for (Map.Entry entry : jSONObject3.entrySet()) {
                Object v2 = entry.getValue();
                if (!(v2 instanceof JSONObject)) {
                    return "element " + i2 + " has an invalid '" + (String)entry.getKey() + "' face";
                }
                JSONObject jSONObject4 = (JSONObject)v2;
                if (!jSONObject4.containsKey("texture") || jSONObject4.get("texture") instanceof String) continue;
                return "element " + i2 + " face '" + (String)entry.getKey() + "' has an invalid texture reference";
            }
        }
        return null;
    }

    private static boolean z(Object object2) {
        JSONArray jSONArray;
        if (!(object2 instanceof JSONArray) || (jSONArray = (JSONArray)object2).size() != 3) {
            return false;
        }
        return jSONArray.stream().allMatch(object -> {
            Number number;
            return object instanceof Number && Double.isFinite((number = (Number)object).doubleValue());
        });
    }

    private boolean F(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        Object object2 = jSONObject.get("textures");
        if (!(object2 instanceof JSONObject) || !(jSONObject2 = (JSONObject)object2).isEmpty() || !((object2 = jSONObject.get("elements")) instanceof JSONArray) || (jSONArray = (JSONArray)object2).isEmpty() || jSONArray.stream().anyMatch(object -> {
            JSONObject jSONObject;
            return !(object instanceof JSONObject) || !(jSONObject = (JSONObject)object).isEmpty();
        })) {
            return false;
        }
        return ad.r(this.Bw());
    }

    private void n(JSONObject jSONObject, String string) {
        String string2 = bcy.iP(this.Bv());
        String string3 = "Model: " + string2 + "\nReason: " + string + "\nThe generated pack contains an ItemsAdder missing-texture model instead.";
        bk.k("Malformed models", string3);
        if (ayh.add(g.gl(this.ayk))) {
            this.ayl.accept("Malformed model replaced with the ItemsAdder missing texture: " + string + ". File: " + string2);
        }
        jSONObject.clear();
        jSONObject.put((Object)"parent", (Object)"minecraft:item/generated");
        jSONObject.put((Object)"textures", (Object)new JSONObject().fluentPut("layer0", (Object)"minecraft:item/iamissing").fluentPut("particle", (Object)"minecraft:item/iamissing"));
    }

    static void au(String string2, String string3) {
        ayj.computeIfAbsent(string2, string -> ConcurrentHashMap.newKeySet()).add(string3);
    }

    private static String l(Map.Entry entry) {
        ArrayList arrayList = new ArrayList((Collection)entry.getValue());
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder("Texture '").append((String)entry.getKey()).append("' not found; referenced by ").append(arrayList.size()).append(" model").append(arrayList.size() == 1 ? "" : "s").append(":");
        arrayList.forEach(string -> stringBuilder.append("\n  - ").append((String)string));
        stringBuilder.append("\n  ").append(azr.gb((String)entry.getKey()));
        String string2 = stringBuilder.toString();
        bk.k("Missing textures", string2);
        return string2;
    }

    static String gb(String string) {
        if (string.contains(":textures/")) {
            return "Resource locations normally omit 'textures/' after the namespace";
        }
        int n2 = string.indexOf(58);
        if (n2 <= 0) {
            return "Check the namespace and path for typos";
        }
        if (Main.rS() == null) {
            return "Check the namespace and path for typos";
        }
        String string2 = string.substring(0, n2);
        String string3 = string.substring(n2 + 1);
        try {
            String string4 = null;
            int n3 = Integer.MAX_VALUE;
            for (File file : d.C()) {
                int n4;
                String string5;
                String string6;
                String string7 = file.getName();
                if (string7.equals(string2) || d.s(string6 = ad.a(string5 = string7 + ":" + string3, ak.TEXTURES, "png")) == null || (n4 = azr.av(string2, string7)) >= n3) continue;
                string4 = string7;
                n3 = n4;
            }
            if (string4 != null && n3 <= 3) {
                return "Possible namespace typo: did you mean '" + string4 + ":" + string3 + "'?";
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        return "Check the namespace and path for typos";
    }

    private static int av(String string, String string2) {
        int n2;
        int[] nArray = new int[string2.length() + 1];
        for (n2 = 0; n2 < nArray.length; ++n2) {
            nArray[n2] = n2;
        }
        for (n2 = 1; n2 <= string.length(); ++n2) {
            int n3 = nArray[0];
            nArray[0] = n2;
            for (int i2 = 1; i2 <= string2.length(); ++i2) {
                int n4 = nArray[i2];
                nArray[i2] = Math.min(Math.min(nArray[i2] + 1, nArray[i2 - 1] + 1), n3 + (string.charAt(n2 - 1) == string2.charAt(i2 - 1) ? 0 : 1));
                n3 = n4;
            }
        }
        return nArray[string2.length()];
    }

    private void G(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("elements");
        if (jSONArray == null) {
            return;
        }
        LinkedHashSet<Double> linkedHashSet = new LinkedHashSet<Double>();
        for (int i2 = 0; i2 < jSONArray.size(); ++i2) {
            Number number;
            Object object;
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2).getJSONObject("rotation");
            if (jSONObject2 == null || !((object = jSONObject2.get("angle")) instanceof Number) || ayf.contains((number = (Number)object).doubleValue())) continue;
            linkedHashSet.add(number.doubleValue());
        }
        String string = g.gl(this.ayk);
        if (!linkedHashSet.isEmpty() && ayg.add(string)) {
            this.ayl.accept("Model uses non-standard element rotation angles " + String.valueOf(linkedHashSet) + ". Clients older than Minecraft 1.21.6 only support -45, -22.5, 0, 22.5 and 45 degrees; Minecraft 1.21.6 and newer support 0.5-degree steps. File: " + bcy.iP(this.Bv()));
        }
    }

    private String Bv() {
        File file = this.Bw();
        return file == null ? this.ayk : file.getPath();
    }

    @Nullable
    private File Bw() {
        String string = bcy.iR(this.ayk);
        int n2 = string.indexOf("assets/");
        if (n2 < 0 || Main.rS() == null) {
            File file = new File(this.ayk);
            return file.isFile() ? file : null;
        }
        try {
            return d.s(string.substring(n2));
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }
}
