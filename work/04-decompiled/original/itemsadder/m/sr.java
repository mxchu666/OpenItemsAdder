package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbr;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.dd;
import itemsadder.m.de;
import itemsadder.m.df;
import itemsadder.m.dg;
import itemsadder.m.dh;
import itemsadder.m.di;
import itemsadder.m.dk;
import itemsadder.m.dl;
import itemsadder.m.dm;
import itemsadder.m.dp;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;

public class sr {
    public static void aR() {
        dd.dx().clear();
        d d2 = d.g();
        for (bbf bbf2 : d2.b()) {
            String string = bbf2.gV("info.namespace");
            d2.Z.add(string);
            List list = bbf2.gR("entities_populators");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No entity populator found in file " + bbf2.qd());
                continue;
            }
            bbr.bf("Entities Populators '" + string + "'...");
            for (String string2 : list) {
                Object object;
                Object object2;
                int n;
                Object object3;
                Object object4;
                Object object52;
                bbg bbg2 = bbf2.hj("entities_populators." + string2);
                assert (bbg2 != null);
                if (!bbg2.C("enabled", true)) {
                    if (!Main.KO.gY("debug.items.log-items-loading-disabled")) continue;
                    bce.log("    Ignored disabled entities_populators: " + string2 + ", namespace: " + string);
                    continue;
                }
                if (Main.KO.gY("debug.items.log-items-loading")) {
                    bce.log("    Loading entities_populators: " + string2);
                }
                if (!r.ez(string2)) {
                    bce.error("[Entities] Non [a-z0-9_.-] character in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    r.ym();
                    continue;
                }
                String string3 = bbg2.gV("entity");
                if (string3 == null) {
                    bce.error("[Entities] Missing entity in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    continue;
                }
                dp dp2 = da.db().am(string3);
                if (dp2 == null) {
                    bce.error("[Entities] Invalid entity '" + string3 + "' in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    continue;
                }
                float f2 = bbg2.a("chance", 15.0f);
                int n2 = bbg2.t("amount", 1);
                List list2 = bbg2.hg("worlds");
                ArrayList<NamespacedKey> arrayList = new ArrayList<NamespacedKey>();
                for (Object object52 : bbg2.hg("biomes")) {
                    object4 = bbf.a((String)object52, "minecraft", true, arg_0 -> sr.a((String)object52, string, string2, bbf2, arg_0));
                    if (object4 == null) continue;
                    arrayList.add((NamespacedKey)object4);
                }
                ArrayList arrayList2 = new ArrayList();
                object52 = bbg2.a(dm.class, "weather", arrayList2);
                if (!arrayList2.isEmpty()) {
                    bce.error("[Entities] Invalid weather in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    object4 = arrayList2.iterator();
                    while (object4.hasNext()) {
                        object3 = (String)object4.next();
                        bce.error("[Entities] - " + (String)object3);
                    }
                }
                object4 = new ArrayList();
                if (bbg2.hm("time") instanceof ConfigurationSection) {
                    object3 = bbg2.hj("time");
                    assert (object3 != null);
                    for (String string4 : ((bbg)object3).aX(false)) {
                        int n3;
                        n = ((bbg)object3).t(string4 + ".min", 0);
                        if (n > (n3 = ((bbg)object3).t(string4 + ".max", 0))) {
                            bce.error("[Entities] Invalid time in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                            continue;
                        }
                        object4.add(new di(n, n3));
                    }
                }
                object3 = null;
                if (bbg2.hm("light_level") instanceof ConfigurationSection) {
                    object2 = bbg2.hj("light_level");
                    assert (object2 != null);
                    int n4 = ((bbg)object2).t("min", 0);
                    if (n4 > (n = ((bbg)object2).t("max", 0))) {
                        bce.error("[Entities] Invalid light level in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                        continue;
                    }
                    object3 = new di(n4, n);
                }
                object2 = new dl();
                if (bbg2.hm("spawn_logic") instanceof ConfigurationSection) {
                    object = bbg2.hj("spawn_logic");
                    assert (object != null);
                    if (!((bbg)object).gP("method")) {
                        bce.error("[Entities] Missing method in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                        continue;
                    }
                    ((dl)object2).a((dk)((bbg)object).a("method", (Class)dk.class, (Enum)null));
                    if (((dl)object2).dQ() == null) {
                        bce.error("[Entities] Invalid method in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                        continue;
                    }
                    ((dl)object2).g(((bbg)object).hW("types"));
                    if (((dl)object2).dR().isEmpty()) {
                        bce.error("[Entities] Missing types in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                        continue;
                    }
                } else {
                    bce.warn("[Entities] Missing spawn_logic in entities_populators '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    continue;
                }
                object = null;
                if (bbg2.hm("location_range") instanceof ConfigurationSection) {
                    bbg bbg3 = bbg2.hj("location_range");
                    assert (bbg3 != null);
                    object = new dg(new dh(bbg3.c("x.min", (Integer)null), bbg3.c("y.min", (Integer)null), bbg3.c("z.min", (Integer)null)), new dh(bbg3.c("x.max", (Integer)null), bbg3.c("y.max", (Integer)null), bbg3.c("z.max", (Integer)null)));
                }
                df df2 = de.dz().b(dp2).e(f2).l(n2).c(arrayList).d(list2).a(((dl)object2).dT()).a((dg)object).e((List)object52).f((List)object4).a((di)object3);
                try {
                    dd.dx().a(df2.dK());
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    bce.error("[Entities] Failed to register entities_populators '" + string + ":" + string2 + "'. " + illegalArgumentException.getMessage() + " File:" + bbf2.nh());
                    continue;
                }
                bce.iA("Loaded entities_populators: " + string2 + ". File: " + bbf2.nh());
            }
        }
    }

    private static /* synthetic */ void a(String string, String string2, String string3, bbf bbf2, String string4) {
        bce.error("[Entities] Invalid biome namespaced ID '" + string + "' in entities_populators '" + string2 + ":" + string3 + "' in yml file: " + bbf2.nh());
    }
}
