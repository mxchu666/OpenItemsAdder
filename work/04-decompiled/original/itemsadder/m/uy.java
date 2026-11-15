package itemsadder.m;

import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.ry;
import itemsadder.m.ub;
import itemsadder.m.uw;
import itemsadder.m.uz;
import itemsadder.m.vc;
import itemsadder.m.vg;
import itemsadder.m.vm;
import itemsadder.m.we;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.Nullable;

public interface uy {
    public String ra();

    public void a(uw var1, String var2, String var3);

    public List w(qm var1);

    public List x(qm var1);

    default public Set f(ql ql2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List list = (List)d.g().aq.Ld.get(ql2);
        if (list != null) {
            for (ub ub2 : list) {
                for (ry ry2 : ub2.qx()) {
                    if (!ry2.oQ() || ql2.l(ry2.oP())) continue;
                    Set set = uy.b(ry2.oP(), true);
                    linkedHashSet.addAll(set);
                }
            }
        }
        return linkedHashSet;
    }

    public static Set b(qm qm2, boolean bl) {
        d d2 = d.g();
        vm vm2 = d2.aX;
        vg vg2 = d2.aY;
        vc vc2 = d2.ba;
        we we2 = d2.aZ;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (vm2 != null) {
            linkedHashSet.addAll(vm2.y(qm2));
        }
        if (vg2 != null) {
            linkedHashSet.addAll(vg2.y(qm2));
        }
        if (vc2 != null) {
            linkedHashSet.addAll(vc2.y(qm2));
        }
        if (we2 != null) {
            linkedHashSet.addAll(we2.y(qm2));
        }
        if (qm2 instanceof ql) {
            ql ql2 = (ql)qm2;
            if (vm2 != null) {
                linkedHashSet.addAll(vm2.f(ql2));
            }
            if (vg2 != null) {
                linkedHashSet.addAll(vg2.f(ql2));
            }
            if (vc2 != null) {
                linkedHashSet.addAll(vc2.f(ql2));
            }
            if (we2 != null) {
                linkedHashSet.addAll(we2.f(ql2));
            }
        }
        if (bl) {
            boolean bl2 = false;
            for (uw uw2 : linkedHashSet) {
                if (qm2.l(uw2.qO())) {
                    bl2 = false;
                    break;
                }
                bl2 = true;
            }
            if (bl2 || linkedHashSet.isEmpty()) {
                uw uw2;
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                uw2 = d2.aW.s(qm2);
                if (!linkedHashSet.contains(uw2)) {
                    linkedHashSet2.add(uw2);
                }
                linkedHashSet2.addAll(linkedHashSet);
                return linkedHashSet2;
            }
        }
        return linkedHashSet;
    }

    default public NamespacedKey a(Map map, uw uw2, NamespacedKey namespacedKey, String string, String string2) {
        @Nullable uw uw3 = (uw)map.get(namespacedKey.toString());
        if (uw3 != null) {
            if (uw2.nP != null && uw3.nP != null) {
                String string3 = uw2.nP.getFile().getName().replace(".yml", "");
                namespacedKey = new NamespacedKey(string.toLowerCase(), string2.toLowerCase() + "_" + string3);
                bce.warn("[Recipes] Duplicate '" + uw2.LY + "'. Registering it anyway with new name '" + String.valueOf(namespacedKey) + "'. Files: " + uw3.nP.nh() + " and " + uw2.nP.nh());
                return namespacedKey;
            }
            bce.error("[Recipes] '" + uw2.LY + "' already exists. Can't register it. No config file for some reason? Wtf? Is it an internal ItemAdder recipe?");
            throw new uz("Recipe already exists. Unexpected error!");
        }
        return namespacedKey;
    }
}
