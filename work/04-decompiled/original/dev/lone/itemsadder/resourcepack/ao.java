package dev.lone.itemsadder.resourcepack;

import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.resourcepack.ad;
import dev.lone.itemsadder.resourcepack.ai;
import dev.lone.itemsadder.resourcepack.al;
import dev.lone.itemsadder.resourcepack.au;
import dev.lone.itemsadder.resourcepack.generator.file.data.g;
import dev.lone.itemsadder.resourcepack.o;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

final class ao {
    private final Map atK;
    private final Set atL;
    private final Set atM;
    private final Predicate atN;
    private final Function atO;
    private final Map atP = new HashMap();
    private final Map atQ = new HashMap();
    private final Map atR = new HashMap();
    final /* synthetic */ ad atS;

    private ao(ad ad2, Predicate predicate, Function function) {
        this.atS = ad2;
        this.atN = predicate;
        this.atO = function;
        this.atL = ad2.asC.keySet().stream().map(g::gl).map(o::el).collect(Collectors.toUnmodifiableSet());
        this.atM = Set.copyOf(ad2.asB.yg().values());
        HashMap hashMap = new HashMap();
        ad2.asE.forEach((string, jSONObject) -> {
            ++ad2.asJ.atp;
            String string2 = o.el(g.gl(string));
            String string3 = o.em(string2);
            int n2 = string.equals("ia_overlay_modern_atlas/" + string3) ? 2 : (string.equals(string3) ? 1 : 0);
            hashMap.merge(string2, new ai((JSONObject)jSONObject, n2), (ai2, ai3) -> ai3.ze() > ai2.ze() ? ai3 : ai2);
        });
        this.atK = hashMap.entrySet().stream().collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, entry -> ((ai)entry.getValue()).zf()));
    }

    private au fq(String string) {
        ++this.atS.asJ.atu;
        String string2 = o.el(string);
        au au2 = (au)this.atQ.get(string2);
        if (au2 != null) {
            return au2;
        }
        ++this.atS.asJ.atv;
        JSONObject jSONObject = (JSONObject)this.atK.get(string2);
        au au3 = jSONObject != null ? new au(jSONObject, this.fs(string2)) : new au(jSONObject, (jSONObject = (JSONObject)this.atO.apply(string2)) == null ? al.ORIGINAL_UNRESOLVED : al.CACHED_VANILLA_ASSET);
        this.atQ.put(string2, au3);
        this.atS.asJ.atw = Math.max(this.atS.asJ.atw, this.atQ.size());
        return au3;
    }

    private boolean fr(String string) {
        String string2 = o.el(string);
        return this.atR.computeIfAbsent(string2, this.atN::test);
    }

    private al fs(String string) {
        ++this.atS.asJ.ats;
        String string2 = o.el(string);
        al al2 = (al)((Object)this.atP.get(string2));
        if (al2 != null) {
            return al2;
        }
        ++this.atS.asJ.att;
        al al3 = this.atM.contains(string2) ? al.PLANNER_ITEM_VARIANT : (this.atS.asL.contains(string2) ? al.GENERATED_ITEMSADDER_ENTRY : al.SELECTED_PACK_ENTRY);
        this.atP.put(string2, al3);
        return al3;
    }

    private boolean ft(String string) {
        return this.atL.contains(string);
    }
}
