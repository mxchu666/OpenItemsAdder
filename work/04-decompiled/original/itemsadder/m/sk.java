package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import itemsadder.m.ae;
import itemsadder.m.aiq;
import itemsadder.m.axi;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bce;
import itemsadder.m.bda;
import itemsadder.m.bx;
import itemsadder.m.by;
import itemsadder.m.bz;
import itemsadder.m.ca;
import itemsadder.m.cb;
import itemsadder.m.cd;
import itemsadder.m.d;
import itemsadder.m.o;
import itemsadder.m.p;
import itemsadder.m.qm;
import itemsadder.m.rc;
import itemsadder.m.rq;
import itemsadder.m.ru;
import itemsadder.m.rw;
import itemsadder.m.rx;
import itemsadder.m.ry;
import itemsadder.m.sl;
import itemsadder.m.st;
import itemsadder.m.ug;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class sk {
    public static final String JL = "minecraft:block/crop";
    static List JM = new ArrayList();
    static List JN = new ArrayList();

    public static void aR() {
        for (bbf bbf2 : d.g().b()) {
            sk.e(bbf2);
        }
    }

    public static void pq() {
        JM.clear();
        JN.clear();
    }

    public static List pr() {
        ArrayList arrayList = new ArrayList(JM);
        JM.clear();
        return arrayList;
    }

    private static void e(bbf bbf2) {
        bbg bbg2 = bbf2.hj("crops");
        if (bbg2 == null) {
            return;
        }
        String string = bbf2.gV("info.namespace");
        if (string == null) {
            throw new IllegalArgumentException("[Items] Missing 'info.namespace'. File: " + bbf2.nh());
        }
        Set set = bbg2.aX(false);
        if (!set.isEmpty() && !Version.isAtLeast((Version)Version.v1_21_4)) {
            bce.error("[Items] Crops are only supported on Minecraft 1.21.4 or higher! Skipping loading crops. File: " + bbf2.nh());
            return;
        }
        for (String string2 : set) {
            try {
                Object object;
                Object object2;
                Object object3;
                Object object4;
                Object object5;
                Object object622;
                Object object7;
                Object object8;
                bbg bbg3 = bbg2.hj(string2);
                assert (bbg3 != null);
                bz bz2 = bx.bF();
                bz2.ac(string + ":" + string2);
                qm qm2 = d.g().e(bbg3.gV("seed"));
                if (qm2 == null) {
                    throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: Missing or invalid 'seed' entry. File: " + bbf2.nh());
                }
                bz2.b(qm2).o(bbg3.C("drop_seed_if_immature", true)).a(bbg3.b("avg_seconds_per_stage", ae.dS)).h(bbg3.t("min_light", 9)).b(bbg3.fo("required_spacing") ? Integer.valueOf(bbg3.t("required_spacing", 1)) : null).a((float)bbg3.b("multipliers.bonemeal", 1.5)).b(bbg3.b("multipliers.max_moisture", 0.5)).b((float)bbg3.b("multipliers.rain", 1.5)).c((float)bbg3.b("multipliers.thunder", -1.0)).d((float)bbg3.b("multipliers.snow", -1.5));
                bbg bbg4 = bbg3.hj("default_hitbox");
                if (bbg4 != null) {
                    float f2 = (float)bbg4.b("width", 1.0);
                    float f3 = (float)bbg4.b("length", 1.0);
                    float f4 = (float)bbg4.b("height", 1.0);
                    bz2.a(new bda(f2, f4, f3));
                } else {
                    bz2.a(new bda(1.0f, 1.0f, 1.0f));
                }
                HashMap<Byte, Object> hashMap = new HashMap<Byte, Object>();
                byte by2 = bbg3.t("max_age", 7);
                HashMap<Byte, ItemStack> hashMap2 = new HashMap<Byte, ItemStack>();
                HashMap<Byte, ItemStack> hashMap3 = new HashMap<Byte, ItemStack>();
                if (bbg3.fo("models_by_items") && bbg3.fo("models_by_textures")) {
                    throw new IllegalArgumentException("Crop '" + string + ":" + string2 + "'. Warning: Contains both 'models_by_items' and 'models_by_textures' sections. Only one is allowed. File: " + bbf2.nh());
                }
                if (bbg3.fo("models_by_items")) {
                    var14_19 = bbg3.gV("models_by_items.items_id_prefix");
                    if (var14_19 == null) {
                        throw new IllegalArgumentException("Crop '" + string + ":" + string2 + "'. Error: Missing 'models_by_items.items_id_prefix' entry. File: " + bbf2.nh());
                    }
                    for (byte by3 = 0; by3 <= by2; by3 = (byte)(by3 + 1)) {
                        object8 = var14_19 + by3;
                        object7 = d.g().e((String)object8);
                        if (object7 == null) {
                            throw new IllegalArgumentException("Crop '" + string + ":" + string2 + "'. Error: Unknown item '" + (String)object8 + "' generated from 'models_by_items.items_id_prefix'. File: " + bbf2.nh());
                        }
                        hashMap2.put(by3, ((qm)object7).mP());
                        JN.add(object7);
                        if (!ae.dX) continue;
                        object622 = var14_19 + by3 + "_billboard";
                        qm qm3 = d.g().e((String)object622);
                        if (qm3 == null) continue;
                        hashMap3.put(by3, qm3.mP());
                        JN.add(qm3);
                    }
                } else if (bbg3.fo("models_by_textures")) {
                    var14_19 = bbg3.aC("models_by_textures.parent", JL);
                    try {
                        var14_19 = st.t(var14_19, string);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        throw new IllegalArgumentException("[Crops] '" + string + ":" + string2 + "'. Error: Invalid 'parent' '" + var14_19 + "'." + illegalArgumentException.getMessage() + ". File: " + bbf2.nh());
                    }
                    if (var14_19.equalsIgnoreCase(JL)) {
                        bz2.n(true);
                    }
                    object5 = bbg3.aC("models_by_textures.model_texture_key", "crop");
                    object8 = bbg3.gV("models_by_textures.textures_prefix");
                    if (object8 == null) {
                        throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: Missing 'models_by_textures.textures_prefix' entry. File: " + bbf2.nh());
                    }
                    if (!((String)object8).contains(":")) {
                        object8 = string + ":" + (String)object8;
                    }
                    if (((String)object8).endsWith(".png")) {
                        object8 = ((String)object8).substring(0, ((String)object8).length() - 4);
                    }
                    object7 = bbg3.aC("models_by_textures.billboard_parent", "minecraft:block/crop_billboard");
                    object622 = bbg3.aC("models_by_textures.billboard_model_texture_key", "crop");
                    object4 = bbg3.gV("models_by_textures.billboard_textures_prefix");
                    if (object4 == null) {
                        object4 = object8;
                    } else {
                        if (!((String)object4).contains(":")) {
                            object4 = string + ":" + (String)object4;
                        }
                        if (((String)object4).endsWith(".png")) {
                            object4 = ((String)object4).substring(0, ((String)object4).length() - 4);
                        }
                    }
                    for (byte by4 = 0; by4 <= by2; by4 = (byte)(by4 + 1)) {
                        object3 = string + ":" + string2 + "_" + by4;
                        object2 = string + ":" + string2 + "_" + by4 + "_billboard";
                        object = new rq((String)object3, Material.PAPER, var14_19, Map.of(object5, (String)object8 + by4), null, null, null, null, null);
                        JM.add(object);
                        rq rq2 = new rq((String)object2, Material.PAPER, (String)object7, Map.of(object622, (String)object4 + by4), null, null, null, null, null);
                        JM.add(rq2);
                        ItemStack itemStack = new ItemStack(Material.PAPER);
                        aiq.tX().d(itemStack, ((rc)object).nF());
                        hashMap2.put(by4, itemStack);
                        ItemStack itemStack2 = new ItemStack(Material.PAPER);
                        aiq.tX().d(itemStack2, rq2.nF());
                        hashMap3.put(by4, itemStack2);
                    }
                } else {
                    throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: Missing 'stages.id_prefix' entry. File: " + bbf2.nh());
                }
                float f5 = (float)bbg3.b("hitbox_auto_height_step", 0.0);
                object5 = new HashMap();
                object8 = bbg3.hj("hitboxes");
                if (object8 != null) {
                    for (Object object622 : ((bbg)object8).CK()) {
                        try {
                            byte by5 = Byte.parseByte((String)object622);
                            bbg bbg5 = ((bbg)object8).hj((String)object622);
                            object3 = null;
                            object2 = null;
                            object = null;
                            if (bbg5 != null) {
                                if (bbg5.fo("width")) {
                                    object3 = Float.valueOf((float)bbg5.hs("width"));
                                }
                                if (bbg5.fo("length")) {
                                    object2 = Float.valueOf((float)bbg5.hs("length"));
                                }
                                if (bbg5.fo("height")) {
                                    object = Float.valueOf((float)bbg5.hs("height"));
                                }
                            }
                            object5.put(by5, new sl((Float)object3, (Float)object2, (Float)object));
                        }
                        catch (NumberFormatException numberFormatException) {
                            bce.warn("[Items] Invalid hitbox stage '" + (String)object622 + "' in crop '" + string + ":" + string2 + "'");
                        }
                    }
                }
                if (by2 > 127) {
                    throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: 'max_age' cannot be higher than 127 (current: " + by2 + "). File: " + bbf2.nh());
                }
                for (byte by6 = 0; by6 <= by2; by6 = (byte)(by6 + 1)) {
                    object622 = (sl)object5.get(by6);
                    Float f6 = null;
                    Float f7 = null;
                    object3 = null;
                    if (object622 != null) {
                        f6 = ((sl)object622).JP;
                        f7 = ((sl)object622).JQ;
                        object3 = ((sl)object622).JR;
                    } else if (f5 != 0.0f) {
                        object3 = Float.valueOf(f5 * (float)by6);
                        if (((Float)object3).floatValue() < 0.1f) {
                            object3 = Float.valueOf(0.1f);
                        }
                        if (((Float)object3).floatValue() > 1.0f) {
                            object3 = Float.valueOf(1.0f);
                        }
                    }
                    object2 = new by((ItemStack)hashMap2.get(by6), (ItemStack)hashMap3.get(by6), f6, f7, (Float)object3);
                    hashMap.put(by6, object2);
                }
                bz2.g(by2);
                bz2.a(ImmutableMap.copyOf(hashMap));
                object7 = bbg3.gV("bottom_block");
                if (object7 != null) {
                    object622 = d.g().h((String)object7);
                    if (object622 != null) {
                        bz2.ag(((qm)object622).getNamespacedID());
                    } else {
                        object4 = bbg.b((String)object7, null);
                        if (object4 == null) {
                            throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: Invalid 'bottom_block' '" + (String)object7 + "'. File: " + bbf2.nh());
                        }
                        bz2.b((Material)object4);
                        bz2.m(object4 == Material.FARMLAND);
                    }
                }
                bz2.ad(bbg3.gV("place_sound"));
                bz2.ae(bbg3.gV("break_sound"));
                bz2.af(bbg3.gV("interact_sound"));
                bz2.b(sk.b(bbg3, string, string2, bbf2));
                object622 = bz2.bL();
                d.g().ab.put(((bx)object622).hD, object622);
                d.g().ac.put(qm2, object622);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                bce.warn("[Items] " + illegalArgumentException.getMessage());
            }
        }
    }

    static ImmutableMap b(bbg bbg2, String string, String string2, bbf bbf2) {
        HashMap<cd, List> hashMap = new HashMap<cd, List>();
        bbg bbg3 = bbg2.hj("loots");
        if (bbg3 != null) {
            for (Object object : bbg3.CK()) {
                Object object2;
                Object object32;
                Object object4;
                Object object52;
                bbg object6 = bbg3.hj((String)object);
                assert (object6 != null);
                cb cb2 = ca.bM();
                if (object6.hm("age") instanceof Integer) {
                    cb2.c(object6.c("age", (Integer)null));
                    cb2.d(object6.c("age", (Integer)null));
                } else {
                    cb2.c(object6.c("age_range.min", (Integer)null));
                    cb2.d(object6.c("age_range.max", (Integer)null));
                }
                cb2.e(object6.c("decrease_age", (Integer)null));
                HashSet<NamespacedKey> hashSet = new HashSet<NamespacedKey>();
                for (Object object52 : object6.hg("biomes")) {
                    object4 = axi.vC().aoJ.dO(((String)object52).toUpperCase());
                    if (object4 != null) {
                        hashSet.add((NamespacedKey)object4);
                        continue;
                    }
                    bce.warn("[Items] '" + string + ":" + string2 + "' has unknown biome '" + (String)object52 + "' in loot.biomes. File: " + bbf2.nh());
                }
                cb2.a(hashSet);
                ArrayList arrayList = new ArrayList();
                if (object6.fo("tools")) {
                    object52 = object6.hg("tools");
                    object4 = object52.iterator();
                    while (object4.hasNext()) {
                        object32 = (String)object4.next();
                        arrayList.add(p.E((String)object32));
                    }
                }
                if (!arrayList.isEmpty()) {
                    cb2.a(new o(arrayList));
                }
                object52 = new ArrayList<Object>();
                if (object6.fo("triggers")) {
                    for (Object object32 : object6.hg("triggers")) {
                        try {
                            object2 = cd.valueOf(((String)object32).toUpperCase(Locale.ROOT));
                            object52.add(object2);
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            bce.warn("[Items] '" + string + ":" + string2 + "' has unknown 'trigger' '" + (String)object32 + "'. File: " + bbf2.nh());
                        }
                    }
                } else {
                    object4 = (cd)object6.a("trigger", cd.class, cd.BREAK);
                    object52.add(object4);
                }
                cb2.a(ImmutableList.copyOf(object52));
                object4 = cb2.bO();
                ((ug)object4).aA(object6.C("stop_on_first_success", object6.C("drop_only_first", false)));
                object32 = object52.iterator();
                while (object32.hasNext()) {
                    object2 = (cd)((Object)object32.next());
                    hashMap.computeIfAbsent((cd)((Object)object2), cd2 -> new ArrayList()).add(object4);
                }
                object6.hg("worlds").forEach(((ca)object4)::cv);
                if (object6.gP("commands")) {
                    object32 = object6.hj("commands");
                    assert (object32 != null);
                    for (String string3 : ((bbg)object32).CK()) {
                        bbg bbg4 = ((bbg)object32).hj(string3);
                        assert (bbg4 != null);
                        ArrayList<rw> arrayList2 = new ArrayList<rw>();
                        for (String string4 : bbg4.CK()) {
                            if (string4.equals("chance")) continue;
                            bbg bbg5 = bbg4.hj(string4);
                            assert (bbg5 != null);
                            arrayList2.add(new rw(bbg5.gV("command"), bbg5.C("as_console", true), bbg5.C("silent", false)));
                        }
                        ((ug)object4).a(new ru(arrayList2, bbg4.gW("chance")));
                    }
                }
                if (object6.gP("exp_drop")) {
                    sk.b(object6, "exp_drop", (ca)object4, bbf2);
                }
                if (object6.gP("exp_drops")) {
                    object32 = object6.hj("exp_drops");
                    assert (object32 != null);
                    for (String string3 : ((bbg)object32).CK()) {
                        sk.b((bbg)object32, string3, (ca)object4, bbf2);
                    }
                }
                if (object6.gP("item_drop")) {
                    sk.a(object6, "item_drop", (ca)object4, bbf2);
                }
                if (!object6.gP("item_drops")) continue;
                object32 = object6.hj("item_drops");
                assert (object32 != null);
                for (String string3 : object6.gR("item_drops")) {
                    sk.a((bbg)object32, string3, (ca)object4, bbf2);
                }
            }
        }
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (Map.Entry entry : hashMap.entrySet()) {
            builder.put((cd)((Object)entry.getKey()), ImmutableList.copyOf((Collection)entry.getValue()));
        }
        return builder.build();
    }

    static void a(bbg bbg2, String string, ca ca2, bbf bbf2) {
        bbg bbg3 = bbg2.hj(string);
        assert (bbg3 != null);
        String string2 = bbg3.gV("item");
        ItemStack itemStack = d.g().o(string2);
        if (itemStack == null) {
            bce.error("Item '" + string2 + "' not found for loot '" + string + "'. File: " + bbf2.nh());
            return;
        }
        ry ry2 = new ry(itemStack, bbg3.t("min_amount", 1), bbg3.t("max_amount", 1), bbg3.a("chance", 100.0f), bbg3.C("ignore_fortune", false));
        if (ry2.oR() > ry2.oS()) {
            bce.error("Invalid loot. 'min_amount' " + ry2.oR() + " greater than 'max_amount' " + ry2.oS() + "! Must be lower. Loot '" + string + "'. File: " + bbf2.nh());
            return;
        }
        ca2.c(ry2);
    }

    static void b(bbg bbg2, String string, ca ca2, bbf bbf2) {
        Object object = bbg2.hm(string);
        if (object instanceof Integer) {
            Integer n = (Integer)object;
            ca2.a(new rx(n));
        } else {
            object = bbg2.hj(string);
            assert (object != null);
            rx rx2 = new rx(((bbg)object).gW("min_amount"), ((bbg)object).gW("max_amount"), ((bbg)object).gX("chance"));
            if (rx2.oN() > rx2.oO()) {
                bce.error("Invalid loot. 'min_amount' " + rx2.oN() + " greater than 'max_amount' " + rx2.oO() + "! Must be lower. Loot '" + string + "'. File: " + bbf2.nh());
                return;
            }
            ca2.a(rx2);
        }
    }
}
