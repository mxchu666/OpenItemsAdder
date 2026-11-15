package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import itemsadder.m.aij;
import itemsadder.m.aik;
import itemsadder.m.ail;
import itemsadder.m.aim;
import itemsadder.m.ain;
import itemsadder.m.aio;
import itemsadder.m.aip;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bce;
import itemsadder.m.qm;
import java.util.ArrayList;
import java.util.HashSet;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.Nullable;

public class sj {
    public static boolean c(bbg bbg2) {
        return bbg2.gP("food") || bbg2.gP("consumable");
    }

    public static void a(qm qm2, bbg bbg2, bbf bbf2, String string2, String string3) {
        bbg bbg3 = bbg2.hj("food");
        if (bbg3 == null) {
            bbg3 = bbg2.hj("consumable");
        }
        assert (bbg3 != null);
        boolean bl = Version.isNewerThan((Version)Version.v1_21_1);
        @Nullable String string4 = bbg3.gV("animation");
        @Nullable String string5 = bbg3.az("sound", null);
        @Nullable Boolean bl2 = bbg3.a("particles", (Boolean)null);
        ArrayList<aim> arrayList = null;
        bbg bbg4 = bbg3.hj("effects");
        if (bl) {
            if (string4 != null) {
                string4 = string4.toLowerCase();
                switch (string4) {
                    case "none": 
                    case "eat": 
                    case "drink": 
                    case "block": 
                    case "bow": 
                    case "spear": 
                    case "crossbow": 
                    case "spyglass": 
                    case "toot_horn": 
                    case "brush": {
                        break;
                    }
                    default: {
                        bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown 'animation' value '" + string4 + "'. File: " + bbf2.nh());
                        string4 = null;
                    }
                }
            }
            if (string5 == null && string4 != null && string4.equalsIgnoreCase("drink")) {
                string5 = "entity.generic.drink";
                if (bl2 == null) {
                    bl2 = false;
                }
            }
            if (bbg4 != null) {
                arrayList = new ArrayList<aim>();
                for (String string6 : bbg3.gR("effects")) {
                    PotionEffectType potionEffectType;
                    Object object;
                    ArrayList<aik> arrayList2;
                    bbg bbg5 = bbg4.hj(string6);
                    assert (bbg5 != null);
                    if (string6.startsWith("apply_status_effects")) {
                        if (bbg5.gR("effects").isEmpty()) {
                            bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'apply_status_effects' is missing 'effects' property. File: " + bbf2.nh());
                        }
                        arrayList2 = new ArrayList<aik>();
                        for (Object object2 : bbg5.gR("effects")) {
                            object = bbg5.hj("effects." + (String)object2);
                            potionEffectType = bbf.hb(((bbg)object).gV("potion"));
                            if (potionEffectType == null) {
                                bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown 'potion' effect type '" + ((bbg)object).gV("potion") + "'. File: " + bbf2.nh());
                                continue;
                            }
                            arrayList2.add(new aik(potionEffectType, ((bbg)object).gW("duration"), ((bbg)object).gW("amplifier"), ((bbg)object).hq("ambient"), ((bbg)object).C("particles", true), ((bbg)object).C("icon", ((bbg)object).C("show_icon", true))));
                        }
                        arrayList.add(new aij(arrayList2, bbg5.a("probability", 1.0f)));
                        continue;
                    }
                    if (string6.startsWith("remove_status_effects")) {
                        Object object2;
                        arrayList2 = bbg5.hg("effects");
                        if (!arrayList2.isEmpty()) continue;
                        bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'remove_status_effects' is missing 'effects' property. File: " + bbf2.nh());
                        HashSet hashSet = new HashSet();
                        object2 = arrayList2.iterator();
                        while (object2.hasNext()) {
                            object = (String)object2.next();
                            potionEffectType = bbf.hb((String)object);
                            if (potionEffectType == null) {
                                bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown 'potion' effect type '" + bbg5.gV("potion") + "'. File: " + bbf2.nh());
                                continue;
                            }
                            hashSet.add(potionEffectType);
                        }
                        arrayList.add(new aio(hashSet));
                        continue;
                    }
                    if (string6.startsWith("play_sound")) {
                        if (bbg5.gP("sound")) {
                            arrayList.add(new ain(bbg5.az("sound", null)));
                            continue;
                        }
                        bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'play_sound' is missing 'sound' property. File: " + bbf2.nh());
                        continue;
                    }
                    if (string6.startsWith("teleport_randomly")) {
                        if (arrayList.stream().noneMatch(aim2 -> aim2 instanceof aip)) {
                            arrayList.add(new aip(bbg5.a("diameter", 5.0f)));
                            continue;
                        }
                        bce.warn("[Items] '" + string2 + ":" + string3 + "'. Warning: 'teleport_randomly' is already set. File: " + bbf2.nh());
                        continue;
                    }
                    if (string6.startsWith("clear_all_status_effects")) {
                        if (arrayList.stream().noneMatch(aim2 -> aim2 instanceof ail)) {
                            arrayList.add(new ail());
                            continue;
                        }
                        bce.warn("[Items] '" + string2 + ":" + string3 + "'. Warning: 'clear_all_status_effects' is already set. File: " + bbf2.nh());
                        continue;
                    }
                    bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown effect type '" + string6 + "'. File: " + bbf2.nh());
                }
            }
        } else {
            if (string4 != null) {
                bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'animation' is only available in 1.21.2+. File: " + bbf2.nh());
            }
            if (string5 != null) {
                bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'sound' is only available in 1.21.2+. File: " + bbf2.nh());
            }
            if (bl2 != null && bl2.booleanValue()) {
                bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'particles' is only available in 1.21.2+. File: " + bbf2.nh());
            }
            if (bbg4 != null && bbg3.gR("effects").stream().anyMatch(string -> string.startsWith("remove_status_effect") || string.startsWith("teleport_randomly") || string.startsWith("clear_all_status_effects"))) {
                bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: some consumable 'effects' are only available in 1.21.2+. File: " + bbf2.nh());
            }
        }
        qm2.a(qm2, bbg3.gW("nutrition"), bbg3.a("saturation", bbg3.gX("saturation_modifier")), bbg3.hq("can_always_eat"), bbg3.t("consume_seconds", bbg3.t("eat_seconds", 2)), string4, string5, bl2, arrayList);
    }
}
