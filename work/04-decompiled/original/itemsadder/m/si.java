package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.resourcepack.f;
import itemsadder.m.ae;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.o;
import itemsadder.m.p;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.qw;
import itemsadder.m.ra;
import itemsadder.m.re;
import itemsadder.m.rg;
import itemsadder.m.rz;
import itemsadder.m.sd;
import itemsadder.m.se;
import itemsadder.m.sf;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.Nullable;

public class si {
    public static boolean c(bbg bbg2) {
        return bbg2.gP("specific_properties.block.placed_model") || bbg2.gP("behaviours.block.placed_model");
    }

    public static qm a(bbg bbg2, bbf bbf2, String string, String string2, Material material, boolean bl) {
        Integer n;
        Object object;
        ConfigurationSection configurationSection;
        Object object22;
        int n2;
        bbg bbg3 = bbg2.hj("specific_properties.block");
        if (bbg3 == null) {
            bbg3 = bbg2.hj("behaviours.block");
        }
        if (bbg3 == null) {
            throw new IllegalArgumentException("[Items] '" + string + ":" + string2 + "'. Error: Missing 'specific_properties.block' or 'behaviours.block' section. File: " + bbf2.nh());
        }
        sd sd2 = sd.valueOf(bbg3.gV("placed_model.type"));
        if (sd2 == sd.ENTITY && !Version.isAtLeast((Version)Version.v1_21_4)) {
            throw new IllegalStateException("[Items] '" + string + ":" + string2 + "'. Error: placed_model.type ENTITY requires Minecraft server and clients 1.21.4+. No legacy Custom Model Data fallback is available. File: " + bbf2.nh());
        }
        if (!sd2.pg()) {
            n2 = -1;
        } else if (bl && material == Material.PAPER && sd2 != sd.TILE) {
            n2 = f.xl().a(sd2, string, string2);
            material = sd2.p(rz.ao(n2));
        } else {
            n2 = f.xl().a(material, sd2, string, string2);
        }
        if (sd2 == sd.FIRE) {
            if (n2 == -1 && sd2.pg()) {
                throw new IllegalArgumentException("[Items] '" + string + ":" + string2 + "'. Error: This fire block would have a block id > than 15.");
            }
            return new qw(bbf2, string, string2, material, n2);
        }
        if (n2 == -1 && sd2.pg()) {
            throw new IllegalStateException("[Items] '" + string + ":" + string2 + "'. Error: Block would have a block id > than the max limit for blocks of type '" + String.valueOf((Object)sd2) + "'. In order to add more blocks please use another type of block (REAL, REAL_NOTE, REAL_TRANSPARENT or TILE).");
        }
        ArrayList<re> arrayList = new ArrayList<re>();
        ConfigurationSection configurationSection2 = bbg3.hi("placed_model.custom_variants");
        if (configurationSection2 != null) {
            for (Object object22 : configurationSection2.getKeys(false)) {
                configurationSection = configurationSection2.getConfigurationSection((String)object22);
                object = configurationSection.getString("model", null);
                if (object == null) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Error: Missing 'model' for 'custom_variant' '" + (String)object22 + "'. File: " + bbf2.nh());
                    continue;
                }
                n = (Integer)configurationSection.get("x", null);
                Integer n3 = (Integer)configurationSection.get("y", null);
                if (n != null && n % 90 != 0) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Invalid 'x' for '" + (String)object + "' block model. Allowed values: 0,90,180,270. File: " + bbf2.nh());
                    continue;
                }
                if (n3 != null && n3 % 90 != 0) {
                    bce.error("[Items] '" + string + ":" + string2 + "'. Invalid 'y' for '" + (String)object + "' block model. Allowed values: 0,90,180,270. File: " + bbf2.nh());
                    continue;
                }
                if (!((String)object).contains(":")) {
                    object = string + ":" + (String)object;
                }
                arrayList.add(new re((String)object, (Integer)configurationSection.get("weight", null), n, n3, (Boolean)configurationSection.get("uvlock", null)));
            }
        } else {
            arrayList = null;
        }
        Material material2 = si.a(bbg3, sd2, ae.cP, (T string3) -> bce.warn("[Items] '" + string + ":" + string2 + "'. Invalid fallback_vanilla_block '" + string3 + "': it must be a solid, occluding, non-interactable vanilla block without gravity. Using " + String.valueOf(ae.cP) + ". File: " + bbf2.nh()));
        object22 = new ql(bbf2, string, string2, material, n2, sd2, rg.valueOf(bbg3.az("placed_model.break_particles", "VANILLA")), bbg3.C("drop_when_mined", !bbg3.C("cancel_drop", false)), bbg3.t("light_level", -1), bbg3.hg("break_tools_blacklist"), bbg3.hg("break_tools_whitelist"), bbg3.hg("events_tools_blacklist"), bbg3.hg("events_tools_whitelist"), bbg3.a("hardness", 0.5f) + 0.2f, bbg3.C("placed_model.shift_up", false), bbg3.C("placed_model.placeable_on_other_real_wire", false), bbg3.C("placed_model.placeable_on_water", false), bbg3.C("placed_model.placeable_on_lava", false), bbg3.t("placed_model.rotx", 0), bbg3.t("placed_model.roty", 0), arrayList);
        ((ql)object22).FA = material2;
        ((ql)object22).ak(bl);
        ((ql)object22).a(bbg3.az("sound.break.name", null), bbg3.a("sound.break.volume", 1.0f), bbg3.a("sound.break.pitch", 0.8f));
        ((ql)object22).b(bbg3.az("sound.place.name", null), bbg3.a("sound.place.volume", 1.0f), bbg3.a("sound.place.pitch", 0.8f));
        ((ql)object22).c(bbg3.az("sound.hit.name", null), bbg3.a("sound.hit.volume", 0.25f), bbg3.a("sound.hit.pitch", 0.5f));
        ((ql)object22).d(bbg3.az("sound.step.name", null), bbg3.a("sound.step.volume", 0.15f), bbg3.a("sound.step.pitch", 1.0f));
        ((ql)object22).e(bbg3.az("sound.fall.name", null), bbg3.a("sound.fall.volume", 0.5f), bbg3.a("sound.fall.pitch", 0.75f));
        ((ql)object22).ah(bbg3.C("no_explosion", false));
        ((ql)object22).m(bbg3.a("blast_resistance", -1.0f));
        if (bbg3.gP("permission_suffix.break")) {
            ((ra)object22).bc(bbg3.az("permission_suffix.break", null));
        }
        if (bbg3.gP("permission_suffix.place")) {
            ((ra)object22).bd(bbg3.az("permission_suffix.place", null));
        }
        if (bbg3.gP("drop_on_silk_touch")) {
            ((ql)object22).ai(bbg3.C("drop_on_silk_touch", true));
        }
        if (bbg3.gP("drop_on_shears")) {
            ((ql)object22).aj(bbg3.C("drop_on_shears", true));
        }
        if ((configurationSection = bbg3.hi("primeable")) != null) {
            object = se.pk();
            ((sf)object).at(configurationSection.getInt("radius", 3));
            ((sf)object).au(configurationSection.getInt("fuse_ticks", 80));
            ((sf)object).o(configurationSection.getDouble("damage_multiplier", 1.0));
            ((sf)object).ax(configurationSection.getBoolean("waterproof", true));
            ((sf)object).ay(configurationSection.getBoolean("incendiary", false));
            n = configurationSection.getConfigurationSection("triggers");
            if (n != null) {
                int n4 = 0;
                if (n.getBoolean("explosion", false)) {
                    n4 = se.o(n4, 8);
                }
                if (n.getBoolean("fire", false)) {
                    n4 = se.o(n4, 4);
                }
                if (n.getBoolean("flaming_projectile", false)) {
                    n4 = se.o(n4, 1);
                }
                if (n.getBoolean("redstone", false)) {
                    n4 = se.o(n4, 2);
                }
                ((sf)object).av(n4);
                @Nullable ArrayList<p> arrayList2 = new ArrayList<p>();
                if (n.contains("tools")) {
                    List list = n.getStringList("tools");
                    for (String string4 : list) {
                        arrayList2.add(p.E(string4));
                    }
                }
                if (!arrayList2.isEmpty()) {
                    ((sf)object).b(new o(arrayList2));
                }
            }
            ((ql)object22).a(((sf)object).pl());
        }
        d.g().S.add(object22);
        d.g().T.put(((qm)object22).getNamespacedID(), object22);
        if (sd2.pg()) {
            d.g().U.put(n2, object22);
        }
        return object22;
    }

    static Material a(bbg bbg2, sd sd2, Material material, @Nullable Consumer consumer) {
        return si.a(bbg2, sd2, material, consumer, sd::q);
    }

    static Material a(bbg bbg2, sd sd2, Material material, @Nullable Consumer consumer, Predicate predicate) {
        if (sd2 != sd.ENTITY || !bbg2.gP("fallback_vanilla_block")) {
            return material;
        }
        Material material2 = bbg2.a("fallback_vanilla_block", (Material)null);
        if (material2 != null && predicate.test(material2)) {
            return material2;
        }
        if (consumer != null) {
            consumer.accept(bbg2.az("fallback_vanilla_block", ""));
        }
        return material;
    }
}
