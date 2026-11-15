package dev.lone.itemsadder.resourcepack;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.api.Events.ItemsAdderPackCompressedEvent$PackEntry;
import dev.lone.itemsadder.resourcepack.ad;
import dev.lone.itemsadder.resourcepack.bm;
import dev.lone.itemsadder.resourcepack.bn;
import dev.lone.itemsadder.resourcepack.bo;
import dev.lone.itemsadder.resourcepack.bp;
import dev.lone.itemsadder.resourcepack.bs;
import dev.lone.itemsadder.resourcepack.bt;
import dev.lone.itemsadder.resourcepack.bu;
import dev.lone.itemsadder.resourcepack.bw;
import dev.lone.itemsadder.resourcepack.bx;
import dev.lone.itemsadder.resourcepack.by;
import dev.lone.itemsadder.resourcepack.ca;
import dev.lone.itemsadder.resourcepack.cb;
import dev.lone.itemsadder.resourcepack.cc;
import dev.lone.itemsadder.resourcepack.cd;
import dev.lone.itemsadder.resourcepack.ce;
import dev.lone.itemsadder.resourcepack.cf;
import dev.lone.itemsadder.resourcepack.cg;
import itemsadder.m.ColorBridge;
import itemsadder.m.VersionHelper_2;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

final class bq {
    private final Map avP;
    private final bo avQ;
    private final cg avR;
    private final BiFunction avS;
    private final LinkedHashSet avT = new LinkedHashSet();
    private final Map avU = new HashMap();
    private final Map avV = new HashMap();

    private bq(Map map, bo bo2, cg cg2, BiFunction biFunction) {
        this.avP = map;
        this.avQ = bo2;
        this.avR = cg2;
        this.avS = biFunction;
    }

    private void Aa() {
        List<String> list = this.avP.entrySet().stream().filter(entry -> !((ItemsAdderPackCompressedEvent$PackEntry)entry.getValue()).isRemoved()).map(Map.Entry::getKey).filter(bm::fK).distinct().sorted().toList();
        if (list.isEmpty()) {
            return;
        }
        for (String object2 : list) {
            this.fQ(object2);
        }
        JSONObject jSONObject = this.Ab();
        HashSet hashSet = new HashSet();
        this.a(jSONObject, hashSet);
    }

    private void fQ(String string) {
        String string2;
        String string3;
        if (string.startsWith("/") || string.contains("\\") || bm.fJ(string)) {
            this.a(cb.ERROR, "SHADER_PATH_INVALID", bm.fN(string), string, string, 0, 0, "Shader resource path contains traversal, a backslash, or a leading slash.", List.of(string));
        }
        if (!bm.u(string3 = bm.fO(string), false)) {
            this.a(cb.ERROR, string.equals(string.toLowerCase(Locale.ROOT)) ? "SHADER_RESOURCE_LOCATION_INVALID" : "SHADER_PATH_CASE_MISMATCH", bm.fN(string), string, string, 0, 0, "Shader path is not a valid lowercase resource location: " + string3, List.of(string));
        }
        if ((string2 = this.fR(string)) == null) {
            return;
        }
        if (string2.isEmpty()) {
            this.a(cb.ERROR, "SHADER_FILE_EMPTY", bm.fN(string), string, string, 1, 1, "Shader file is empty.", List.of(string));
            return;
        }
        if (string.endsWith(".json")) {
            this.al(string, string2);
        } else {
            cd cd2 = bm.fN(string);
            ca ca2 = bm.a(string2, string, cd2);
            this.avV.put(string, ca2);
            ca2.AB().forEach(this::a);
            if (!(cd2 != cd.VERTEX && cd2 != cd.FRAGMENT || ca2.AD())) {
                this.a(cb.ERROR, "SHADER_MAIN_MISSING", cd2, string, string, 1, 1, "Shader stage does not declare main().", List.of(string));
            }
        }
    }

    private void al(String string, String string2) {
        try {
            JSONObject jSONObject = JSON.parseObject((String)string2);
            if (jSONObject == null) {
                throw new IllegalArgumentException("expected a JSON object");
            }
            if (bm.fL(string)) {
                this.a(string, jSONObject, "vertex");
                this.a(string, jSONObject, "fragment");
            }
            if (bm.fM(string)) {
                Object object = jSONObject.get("passes");
                if (!(object instanceof JSONArray)) {
                    this.a(cb.ERROR, "SHADER_POST_PASSES_INVALID", cd.PROGRAM, string, string, 1, 1, "Post-processing JSON must contain a passes array.", List.of(string));
                    return;
                }
                JSONArray jSONArray = (JSONArray)object;
                for (Object e : jSONArray) {
                    String string3;
                    JSONObject jSONObject2;
                    Object object2;
                    if (e instanceof JSONObject && (object2 = (jSONObject2 = (JSONObject)e).get("name")) instanceof String && bm.u(string3 = (String)object2, true)) continue;
                    this.a(cb.ERROR, "SHADER_RESOURCE_LOCATION_INVALID", cd.PROGRAM, string, string, 1, 1, "Post-processing pass has an invalid program resource location.", List.of(string));
                }
            }
        }
        catch (Throwable throwable) {
            this.a(cb.ERROR, "SHADER_JSON_MALFORMED", cd.PROGRAM, string, string, 1, 1, bm.a(throwable), List.of(string));
        }
    }

    private void a(String string, JSONObject jSONObject, String string2) {
        String string3;
        Object object = jSONObject.get(string2);
        if (object == null) {
            this.a(cb.ERROR, "SHADER_PROGRAM_STAGE_MISSING", cd.PROGRAM, string, string, 1, 1, "Shader program JSON is missing its " + string2 + " stage.", List.of(string));
            return;
        }
        if (!(object instanceof String) || !bm.u(string3 = (String)object, true)) {
            this.a(cb.ERROR, "SHADER_RESOURCE_LOCATION_INVALID", cd.PROGRAM, string, string, 1, 1, "Invalid " + string2 + " shader resource location.", List.of(string));
        }
    }

    private JSONObject Ab() {
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = (ItemsAdderPackCompressedEvent$PackEntry)this.avP.get("pack.mcmeta");
        if (itemsAdderPackCompressedEvent$PackEntry == null || itemsAdderPackCompressedEvent$PackEntry.isRemoved()) {
            return null;
        }
        try {
            return JSON.parseObject((String)bm.c(itemsAdderPackCompressedEvent$PackEntry));
        }
        catch (Throwable throwable) {
            this.a(cb.ERROR, "SHADER_PACK_META_MALFORMED", cd.NONE, "pack.mcmeta", "pack.mcmeta", 1, 1, bm.a(throwable), List.of());
            return null;
        }
    }

    private void a(JSONObject jSONObject, Set set) {
        Object object;
        boolean bl = false;
        if (jSONObject != null) {
            object = ad.a(this.avP, jSONObject);
            for (Version version : VersionHelper_2.go) {
                try {
                    this.a(new bw(version, (Map)object.apply(version)), set);
                    bl = true;
                }
                catch (Throwable throwable) {
                    this.a(cb.ERROR, "SHADER_OVERLAY_INVALID", cd.NONE, "pack.mcmeta", "pack.mcmeta", 1, 1, bm.a(throwable), List.of());
                    break;
                }
            }
        }
        if (!bl) {
            object = new LinkedHashMap();
            this.avP.values().stream().filter(itemsAdderPackCompressedEvent$PackEntry -> !itemsAdderPackCompressedEvent$PackEntry.isRemoved()).forEach(arg_0 -> bq.b((Map)object, arg_0));
            this.a(new bw(Version.UNKNOWN, (Map)object), set);
        }
    }

    private void a(bw bw2, Set set) {
        Object object;
        Map.Entry entry22;
        HashMap hashMap = new HashMap();
        bw2.Ax().keySet().forEach(string -> hashMap.putIfAbsent(string.toLowerCase(Locale.ROOT), string));
        LinkedHashMap<String, bt> linkedHashMap = new LinkedHashMap<String, bt>();
        for (Map.Entry entry22 : bw2.Ax().entrySet()) {
            object = bm.fN((String)entry22.getKey());
            if (object != cd.VERTEX && object != cd.FRAGMENT) continue;
            linkedHashMap.put((String)entry22.getKey(), this.a((cd)((Object)object), (String)entry22.getKey(), bw2, hashMap, new ArrayDeque(), new HashSet(), 0));
        }
        Set set2 = this.a(bw2, hashMap);
        entry22 = new HashSet();
        object = set2.iterator();
        while (object.hasNext()) {
            by object2 = (by)object.next();
            bt bt2 = linkedHashMap.computeIfAbsent(object2.Ay(), string -> this.a(cd.VERTEX, (String)string, bw2, hashMap, new ArrayDeque(), new HashSet(), 0));
            bt bt3 = linkedHashMap.computeIfAbsent(object2.Az(), string -> this.a(cd.FRAGMENT, (String)string, bw2, hashMap, new ArrayDeque(), new HashSet(), 0));
            if (bt2 == null || bt3 == null || !bt2.Ao() || !bt3.Ao()) continue;
            entry22.add(object2.Ay());
            entry22.add(object2.Az());
            if (!this.a(bw2, object2.Ay()) || !this.a(bw2, object2.Az())) continue;
            this.a(bw2, List.of(bt2, bt3), set);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (entry22.contains(entry.getKey()) || !((bt)entry.getValue()).Ao() || !this.a(bw2, (String)entry.getKey())) continue;
            this.a(bw2, List.of((bt)entry.getValue()), set);
        }
        if (bw2.Aw() != Version.UNKNOWN && bw2.Aw().getPackVersion() < Version.v1_21_3.getPackVersion()) {
            this.a(bw2);
        }
    }

    private boolean a(bw bw2, String string) {
        return bw2.Aw() == Version.UNKNOWN || string.startsWith("assets/minecraft/shaders/core/") && (string.endsWith(".vsh") || string.endsWith(".fsh")) && this.i(bw2.Aw(), string) != null;
    }

    private void a(bw bw2) {
        Object object;
        String string2;
        Map.Entry entry2;
        HashSet<String> hashSet = new HashSet<String>();
        for (Map.Entry entry2 : bw2.Ax().entrySet()) {
            if (!bm.fL((String)entry2.getKey()) || (string2 = this.fR((String)entry2.getValue())) == null) continue;
            try {
                object = JSON.parseObject((String)string2);
                hashSet.add(bm.h((String)entry2.getKey(), object.getString("vertex"), ".vsh"));
                hashSet.add(bm.h((String)entry2.getKey(), object.getString("fragment"), ".fsh"));
            }
            catch (Throwable throwable) {}
        }
        hashSet.remove(null);
        Set set = bw2.Ax().keySet().stream().filter(string -> string.endsWith(".vsh") || string.endsWith(".fsh")).collect(Collectors.toSet());
        entry2 = set.iterator();
        while (entry2.hasNext()) {
            string2 = (String)entry2.next();
            object = bm.ei(string2);
            if ("minecraft".equals(object)) continue;
            String string3 = string2.substring(0, string2.length() - 4) + ".json";
            if (bw2.Ax().containsKey(string3) || hashSet.contains(string2)) continue;
            this.a(cb.ERROR, "SHADER_PROGRAM_JSON_MISSING", bm.fN(string2), string2, (String)bw2.Ax().get(string2), 0, 0, "Legacy clients require a shader program JSON for this custom shader.", List.of(string2));
        }
    }

    private Set a(bw bw2, Map map) {
        Object object;
        String string;
        Object object2;
        LinkedHashSet<by> linkedHashSet = new LinkedHashSet<by>();
        for (String object3 : bw2.Ax().keySet()) {
            if (!object3.endsWith(".vsh")) continue;
            object2 = object3.substring(0, object3.length() - 4) + ".fsh";
            if (!bw2.Ax().containsKey(object2)) continue;
            linkedHashSet.add(new by(object3, (String)object2));
        }
        if (bw2.Aw() != Version.UNKNOWN) {
            for (String string2 : bw2.Ax().keySet()) {
                if (!string2.startsWith("assets/minecraft/shaders/core/") || !string2.endsWith(".vsh") && !string2.endsWith(".fsh")) continue;
                object2 = string2.substring(0, string2.length() - 4);
                string = (String)object2 + ".vsh";
                object = (String)object2 + ".fsh";
                if (this.i(bw2.Aw(), string) == null || this.i(bw2.Aw(), (String)object) == null) continue;
                linkedHashSet.add(new by(string, (String)object));
            }
        }
        if (bw2.Aw() != Version.UNKNOWN && bw2.Aw().getPackVersion() >= Version.v1_21_3.getPackVersion()) {
            return linkedHashSet;
        }
        for (Map.Entry entry : bw2.Ax().entrySet()) {
            if (!bm.fL((String)entry.getKey()) || (object2 = this.fR((String)entry.getValue())) == null) continue;
            try {
                string = JSON.parseObject((String)object2);
                object = bm.h((String)entry.getKey(), string.getString("vertex"), ".vsh");
                String string3 = bm.h((String)entry.getKey(), string.getString("fragment"), ".fsh");
                object = this.a((String)object, bw2, map, cd.VERTEX, (String)entry.getKey());
                string3 = this.a(string3, bw2, map, cd.FRAGMENT, (String)entry.getKey());
                if (object == null || string3 == null) continue;
                linkedHashSet.add(new by((String)object, string3));
            }
            catch (Throwable throwable) {}
        }
        return linkedHashSet;
    }

    private void a(bw bw2, List list, Set set) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(bw2.Aw().name());
        arrayList.addAll(list.stream().map(bt::Aj).toList());
        if (!set.add(arrayList)) {
            return;
        }
        bn bn2 = this.avQ.M(list);
        if (list.size() == 2 && bn2.zW().stream().noneMatch(bp2 -> bp2.zX().equals("link") && !bp2.rC())) {
            this.a(bw2, list);
        }
        if (!bn2.P()) {
            this.a(cb.WARNING, "SHADER_COMPILER_UNAVAILABLE", cd.NONE, null, null, 0, 0, "Native GLSL compiler unavailable; static validation completed. " + bn2.zV(), List.of());
            return;
        }
        for (bp bp3 : bn2.zW()) {
            this.a(list, bp3);
        }
    }

    private void a(bw bw2, List list) {
        cf cf2 = bm.a((bt)list.get(0));
        cf cf3 = bm.a((bt)list.get(1));
        this.a(bw2, (bt)list.get(0), cf2.AM(), (bt)list.get(1), cf3.AN());
        this.a(bw2, (bt)list.get(1), cf3.AM(), (bt)list.get(0), cf2.AN());
    }

    private void a(bw bw2, bt bt2, Map map, bt bt3, Map map2) {
        for (String string : map.keySet()) {
            if (!map2.containsKey(string)) continue;
            boolean bl = bw2.Ax().containsKey(bt2.Aj());
            bt bt4 = bl ? bt2 : bt3;
            ce ce2 = bl ? (ce)map.get(string) : (ce)map2.get(string);
            cc cc2 = ce2.Ad() > 0 && ce2.Ad() <= bt4.An().size() ? (cc)bt4.An().get(ce2.Ad() - 1) : null;
            this.a(cb.ERROR, "SHADER_UNIFORM_BLOCK_LINK_INCOMPATIBLE", bt4.Ai(), bt4.Aj(), cc2 == null ? bt4.Aj() : cc2.AI(), cc2 == null ? ce2.Ad() : cc2.Ad(), ce2.Ae(), "Uniform '" + string + "' is declared in the default uniform block of " + bt2.Aj() + " and inside a named uniform block of " + bt3.Aj() + "; the Minecraft client linker rejects this combination.", List.of());
        }
    }

    private void a(List list, bp bp2) {
        String string = bp2.zZ();
        if (string == null || string.isBlank()) {
            if (!bp2.rC()) {
                cd cd2 = bp2.zY() >= 0 ? ((bt)list.get(bp2.zY())).Ai() : cd.PROGRAM;
                this.a(cb.ERROR, bm.fH(bp2.zX()), cd2, bp2.zY() >= 0 ? ((bt)list.get(bp2.zY())).Aj() : null, null, 0, 0, "glslang rejected the shader without an info log.", List.of());
            }
            return;
        }
        if (bp2.zX().equals("link")) {
            ArrayList<String> arrayList = new ArrayList<String>();
            for (String string2 : string.replace('\r', '\n').split("\n")) {
                bx bx2;
                String string3 = string2.trim();
                if (string3.isEmpty() || (bx2 = bm.fF(string3)).Ag() == cb.WARNING || bx2.xY().isBlank()) continue;
                arrayList.add(bx2.xY());
            }
            this.a(cb.ERROR, "SHADER_LINK_FAILED", cd.PROGRAM, null, null, 0, 0, arrayList.isEmpty() ? "glslang rejected the shader without an info log." : String.join((CharSequence)"\n", arrayList), List.of());
            return;
        }
        for (String string4 : string.replace('\r', '\n').split("\n")) {
            cc cc2;
            bx bx3;
            String string5 = string4.trim();
            if (string5.isEmpty() || string5.matches("(?i)^(?:ERROR:\\s*)?[0-9]+ compilation errors?.*$") || (bx3 = bm.fF(string5)).Ag() == cb.WARNING) continue;
            int n2 = bp2.zY();
            bt bt2 = n2 >= 0 && n2 < list.size() ? (bt)list.get(n2) : null;
            cc cc3 = cc2 = bt2 != null && bx3.Ad() > 0 && bx3.Ad() <= bt2.An().size() ? (cc)bt2.An().get(bx3.Ad() - 1) : null;
            cb cb2 = bx3.Ag() != null ? bx3.Ag() : (bp2.rC() ? cb.WARNING : cb.ERROR);
            this.a(cb2, bp2.rC() ? "SHADER_COMPILER_WARNING" : bm.fH(bp2.zX()), bt2 == null ? cd.PROGRAM : bt2.Ai(), bt2 == null ? null : bt2.Aj(), (String)(cc2 == null ? (bt2 == null ? null : bt2.Aj()) : cc2.AI()), cc2 == null ? bx3.Ad() : cc2.Ad(), bx3.Ae(), bx3.xY(), cc2 == null ? List.of() : cc2.Al());
        }
    }

    private bt a(cd cd2, String string, bw bw2, Map map, Deque deque, Set set, int n2) {
        String string2;
        String string4;
        String string5 = (String)bw2.Ax().get(string);
        String string6 = string4 = string5 == null ? string : string5;
        if (n2 > 32) {
            this.a(cb.ERROR, "SHADER_IMPORT_DEPTH_EXCEEDED", cd2, string, string4, 0, 0, "Shader import depth exceeds 32.", List.copyOf(deque));
            return new bt(cd2, string, "", List.of(), false, 0);
        }
        if (deque.contains(string)) {
            ArrayList<String> arrayList = new ArrayList<String>(deque);
            arrayList.add(string);
            this.a(cb.ERROR, "SHADER_IMPORT_CIRCULAR", cd2, string, string4, 0, 0, "Circular #moj_import detected.", arrayList);
            return new bt(cd2, string, "", List.of(), false, 0);
        }
        String string7 = string2 = string5 == null ? this.i(bw2.Aw(), string) : this.fR(string5);
        if (string2 == null) {
            return new bt(cd2, string, "", List.of(), false, 0);
        }
        String string8 = string5 == null ? bw2.Aw().name() + ":" + string : string5;
        ca ca2 = this.avV.computeIfAbsent(string8, string3 -> bm.a(string2, string4, cd2));
        HashMap hashMap = new HashMap();
        ca2.AC().forEach(bu2 -> hashMap.put(bu2.Ad(), bu2));
        String[] stringArray = string2.split("\n", -1);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        boolean bl = true;
        int n3 = ca2.Ap();
        int n4 = -1;
        String string9 = null;
        deque.addLast(string);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            bu bu3;
            if (ca2.AF().contains(i2 + 1)) {
                if (cd2 == cd.INCLUDE) {
                    bm.a(stringBuilder, arrayList, "", string4, i2 + 1, deque);
                    continue;
                }
                if (n4 < 0) {
                    n4 = stringBuilder.length();
                    string9 = stringArray[i2];
                }
            }
            if ((bu3 = (bu)hashMap.get(i2 + 1)) == null || !bu3.As()) {
                bm.a(stringBuilder, arrayList, stringArray[i2], string4, i2 + 1, deque);
                continue;
            }
            String string10 = this.a(string, bu3);
            if (string10 == null) {
                bl = false;
                continue;
            }
            String string11 = this.a(string10, bw2, map, cd2, string4);
            if (string11 == null) {
                bl = false;
                continue;
            }
            if (set.contains(string11) && !deque.contains(string11)) {
                bm.a(stringBuilder, arrayList, "", string4, i2 + 1, deque);
                continue;
            }
            set.add(string11);
            bt bt2 = this.a(cd.INCLUDE, string11, bw2, map, deque, set, n2 + 1);
            stringBuilder.append(bt2.Am());
            arrayList.addAll(bt2.An());
            bl &= bt2.Ao();
            n3 = Math.max(n3, bt2.Ap());
        }
        deque.removeLast();
        if (n4 >= 0 && n3 > ca2.Ap()) {
            stringBuilder.replace(n4, n4 + string9.length(), bm.s(string9, n3));
        }
        return new bt(cd2, string, stringBuilder.toString(), List.copyOf(arrayList), bl, n3);
    }

    private String i(Version version, String string) {
        String string2 = version.name() + ":" + string;
        if (this.avU.containsKey(string2)) {
            return (String)this.avU.get(string2);
        }
        String string3 = this.avR.read(version, string);
        this.avU.put(string2, string3);
        return string3;
    }

    private String a(String string, bw bw2, Map map, cd cd2, String string2) {
        if (string == null) {
            return null;
        }
        if (bw2.Ax().containsKey(string)) {
            return string;
        }
        String string3 = (String)map.get(string.toLowerCase(Locale.ROOT));
        if (string3 != null) {
            this.a(cb.ERROR, "SHADER_PATH_CASE_MISMATCH", cd2, string2, string2, 0, 0, "Resource path case mismatch: requested '" + string + "', actual '" + string3 + "'.", List.of(string2));
            return null;
        }
        if ("minecraft".equals(bm.ei(string)) && this.i(bw2.Aw(), string) != null) {
            return string;
        }
        boolean bl = "minecraft".equals(bm.ei(string));
        this.a(bl ? cb.INFO : cb.ERROR, bl ? "SHADER_VALIDATION_PARTIAL" : "SHADER_IMPORT_MISSING", cd2, string2, string2, 0, 0, bl ? "Compilation skipped because " + bm.fO(string) + " is not available in the vanilla shader cache for " + bw2.Aw().getName() + "." : "Missing shader import or stage: " + string, List.of(string2, string));
        return null;
    }

    private String a(String string, bu bu2) {
        String string2 = bu2.Aq();
        if (bm.fJ(string2) || string2.startsWith("/") || string2.contains("\\")) {
            this.a(cb.ERROR, "SHADER_IMPORT_PATH_TRAVERSAL", bm.fN(string), string, string, bu2.Ad(), bu2.Ae(), "Import path traversal is not allowed.", List.of(string));
            return null;
        }
        if (bu2.Ar()) {
            int n2 = string.lastIndexOf(47);
            return bm.fI(string.substring(0, n2 + 1) + string2);
        }
        String string3 = "minecraft";
        String string4 = string2;
        int n3 = string2.indexOf(58);
        if (n3 >= 0) {
            string3 = string2.substring(0, n3);
            string4 = string2.substring(n3 + 1);
        }
        if (!bm.u(string3 + ":" + string4, false)) {
            this.a(cb.ERROR, "SHADER_RESOURCE_LOCATION_INVALID", bm.fN(string), string, string, bu2.Ad(), bu2.Ae(), "Malformed #moj_import resource location.", List.of(string));
            return null;
        }
        return "assets/" + string3 + "/shaders/include/" + string4;
    }

    private String fR(String string) {
        if (string == null) {
            return null;
        }
        if (this.avU.containsKey(string)) {
            return (String)this.avU.get(string);
        }
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = (ItemsAdderPackCompressedEvent$PackEntry)this.avP.get(string);
        if (itemsAdderPackCompressedEvent$PackEntry == null) {
            return null;
        }
        try {
            String string2 = bm.c(itemsAdderPackCompressedEvent$PackEntry);
            this.avU.put(string, string2);
            return string2;
        }
        catch (Throwable throwable) {
            this.a(cb.ERROR, "SHADER_FILE_UNREADABLE", bm.fN(string), string, string, 0, 0, bm.a(throwable), List.of(string));
            return null;
        }
    }

    private void a(cb cb2, String string, cd cd2, String string2, String string3, int n2, int n3, String string4, List list) {
        this.avT.add(new bs(cb2, string, cd2, string2, this.fS(string3), n2, n3, string4, list));
    }

    private void a(bs bs2) {
        this.avT.add(new bs(bs2.Ag(), bs2.Ah(), bs2.Ai(), bs2.Aj(), this.fS(bs2.Ak()), bs2.Ad(), bs2.Ae(), bs2.xY(), bs2.Al()));
    }

    private String fS(String string) {
        if (string == null) {
            return null;
        }
        ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry = (ItemsAdderPackCompressedEvent$PackEntry)this.avP.get(string);
        String string2 = itemsAdderPackCompressedEvent$PackEntry == null ? null : (String)this.avS.apply(itemsAdderPackCompressedEvent$PackEntry, string);
        return string2 == null ? string : string2;
    }

    private static /* synthetic */ void b(Map map, ItemsAdderPackCompressedEvent$PackEntry itemsAdderPackCompressedEvent$PackEntry) {
        String string = ColorBridge.iR(itemsAdderPackCompressedEvent$PackEntry.getPath());
        int n = string.indexOf("assets/");
        if (n >= 0) {
            map.put(string.substring(n), string);
        }
    }
}
