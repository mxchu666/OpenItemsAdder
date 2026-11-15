package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.google.common.collect.ImmutableMap;
import dev.lone.itemsadder.Core.OtherPlugins.ExecutableItems.ExecutableItemsHook;
import dev.lone.itemsadder.Core.OtherPlugins.enchants.AeWrapper;
import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.f;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.ae;
import itemsadder.m.afj;
import itemsadder.m.afl;
import itemsadder.m.aiq;
import itemsadder.m.baz;
import itemsadder.m.bbe;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbi;
import itemsadder.m.bbr;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bdj;
import itemsadder.m.d;
import itemsadder.m.ii;
import itemsadder.m.ij;
import itemsadder.m.qh;
import itemsadder.m.qi;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.qt;
import itemsadder.m.rb;
import itemsadder.m.rj;
import itemsadder.m.rl;
import itemsadder.m.rr;
import itemsadder.m.rs;
import itemsadder.m.rt;
import itemsadder.m.ry;
import itemsadder.m.se;
import itemsadder.m.sh;
import itemsadder.m.si;
import itemsadder.m.sj;
import itemsadder.m.sm;
import itemsadder.m.so;
import itemsadder.m.sp;
import itemsadder.m.ss;
import itemsadder.m.st;
import itemsadder.m.sw;
import itemsadder.m.sx;
import itemsadder.m.sz;
import itemsadder.m.ta;
import itemsadder.m.tb;
import itemsadder.m.tc;
import itemsadder.m.v;
import itemsadder.m.xk;
import itemsadder.m.xm;
import java.io.Serializable;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class sv {
    private final d JY;
    HashMap JZ = new HashMap();
    public boolean Ka = false;

    public sv(d d2) {
        this.JY = d2;
    }

    public void aR() {
        List list;
        String string2;
        HashMap<CallSite, Object> hashMap = new HashMap<CallSite, Object>();
        for (bbf bbf2 : this.JY.b()) {
            string2 = bbf2.gV("info.namespace");
            list = bbf2.gR("items");
            if (list == null) continue;
            for (Iterator iterator : list) {
                boolean bl;
                Object object = bbf2.hj("items." + (String)((Object)iterator));
                assert (object != null);
                if (!((bbg)object).C("enabled", true) || !(bl = ((bbg)object).C("template", false))) continue;
                hashMap.put((CallSite)((Object)(string2 + ":" + (String)((Object)iterator))), object);
            }
        }
        this.JY.a(hashMap);
        for (bbf bbf2 : this.JY.b()) {
            sh sh3;
            int n;
            bbg bbg2;
            string2 = bbf2.gV("info.namespace");
            this.JY.Z.add(string2);
            list = bbf2.gR("items");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No item found in file " + bbf2.qd());
                continue;
            }
            bbr.bf("Items '" + string2 + "'...");
            boolean bl = false;
            for (Object object : list) {
                int n2;
                Object object2;
                Object object3;
                Object object4;
                Object object5;
                Object object62;
                Object object7;
                Serializable serializable2;
                Object object8;
                bbg2 = bbf2.hj("items." + (String)object);
                assert (bbg2 != null);
                if (!bbg2.C("enabled", true)) {
                    if (!Main.KO.gY("debug.items.log-items-loading-disabled")) continue;
                    bce.log("    Ignored disabled item: " + (String)object + ", namespace: " + string2);
                    continue;
                }
                n = bbg2.C("template", false);
                if (n != 0) continue;
                if (Main.KO.gY("debug.items.log-items-loading")) {
                    bce.log("    Loading item: " + (String)object);
                }
                bbg2 = sv.a(bbf2, bbg2, hashMap, string2, (String)object);
                if (!r.ex((String)object)) {
                    bce.error("[Items] Non [a-z0-9_.-] character in custom item name '" + string2 + ":" + (String)object + "' in yml file: " + bbf2.nh());
                    r.ym();
                    continue;
                }
                if ((bbg2.fo("resource") ? 1 : 0) + (bbg2.fo("graphics") ? 1 : 0) + (bbg2.fo("item_model") ? 1 : 0) > 1) {
                    bce.error("[Items] '" + string2 + ":" + (String)object + "'. Error: 'resource', 'graphics' and 'item_model' properties are mutually exclusive. Please use only one of them. File: " + bbf2.nh());
                    continue;
                }
                sh3 = bbg2.a("resource.material", bbg2.gZ("material"));
                String string3 = bbg2.az("name", bbg2.az("display_name", sv.ci((String)object)));
                Component component = this.JY.bg.ah(string3);
                qm qm3 = null;
                if (sz.c(bbg2)) {
                    ta ta2 = sz.a((Material)sh3, bbg2, bbf2, string2, (String)object);
                    if (ta2 == null) continue;
                    qm3 = ta2.pu();
                    bl = ta2.pv();
                    sh3 = ta2.pw();
                }
                boolean bl2 = false;
                boolean bl3 = false;
                if (sh3 == null) {
                    sh3 = Material.PAPER;
                    bl2 = true;
                    bl3 = true;
                }
                if (qm3 == null) {
                    block108: {
                        if (!sh3.isItem()) {
                            bce.error("[Items] '" + string2 + ":" + (String)object + "' - Error: Material " + String.valueOf(ChatColor.AQUA) + String.valueOf(sh3) + String.valueOf(ChatColor.RED) + " is not an obtainable material. File: " + bbf2.nh());
                            continue;
                        }
                        if (sh3 == Material.BOW) {
                            qm3 = new qh(bbf2, string2, (String)object, (Material)sh3, bbg2.C("specific_properties.bow.glow_arrows", false), bbg2.C("specific_properties.bow.fire_arrows", false), bbg2.b("specific_properties.bow.arrow_damage", -1.0));
                        } else if (sh3 == Material.CROSSBOW) {
                            qm3 = new qi(bbf2, string2, (String)object, (Material)sh3, bbg2.C("specific_properties.crossbow.glow_arrows", false), bbg2.C("specific_properties.crossbow.fire_arrows", false), bbg2.b("specific_properties.crossbow.arrow_damage", -1.0), bbg2.C("specific_properties.crossbow.multishot", false), bbg2.C("specific_properties.crossbow.firework", false));
                        } else {
                            if (si.c(bbg2)) {
                                try {
                                    if (!bl3 && sh3 == Material.PAPER && ae.eS) {
                                        bl2 = true;
                                    }
                                    qm3 = si.a(bbg2, bbf2, string2, (String)object, (Material)sh3, bl2);
                                    break block108;
                                }
                                catch (IllegalStateException illegalStateException) {
                                    bce.error(illegalStateException.getMessage());
                                    continue;
                                }
                            }
                            if (bbg2.gP("specific_properties.seed.crop_block")) {
                                qm3 = new rb(bbf2, string2, (String)object, (Material)sh3, bbg2.gZ("specific_properties.seed.crop_block"));
                                this.JY.I.put(qm3.Gh, (rb)qm3);
                                object8 = new ArrayList();
                                for (Serializable serializable2 : bbg2.gR("specific_properties.seed.results")) {
                                    object7 = new ry(bbg2.t("specific_properties.seed.results." + (String)((Object)serializable2) + ".min_amount", 1), bbg2.t("specific_properties.seed.results." + (String)((Object)serializable2) + ".max_amount", 1), bbg2.a("specific_properties.seed.results." + (String)((Object)serializable2) + ".chance", 100.0f), bbg2.C("specific_properties.seed.results." + (String)((Object)serializable2) + ".ignore_fortune", false));
                                    ((rb)qm3).a((ry)object7);
                                    object62 = bbg2.gV("specific_properties.seed.results." + (String)((Object)serializable2) + ".item");
                                    object8.add(object62);
                                }
                                this.JZ.put(qm3.getNamespacedID(), object8);
                            } else {
                                qm3 = new qm(bbf2, string2, (String)object, (Material)sh3);
                            }
                        }
                    }
                    if (sj.c(bbg2)) {
                        sj.a(qm3, bbg2, bbf2, string2, (String)object);
                    }
                }
                if (bbg2.gP("tooltip_style")) {
                    try {
                        if (!Version.isAtLeast((Version)Version.v1_21_3)) {
                            throw new sx("[Items] '" + string2 + ":" + (String)object + "'. Error: 'tooltip_style' is only available in 1.21.2+. File: " + bbf2.nh());
                        }
                        object8 = bbf.a(bbg2.gV("tooltip_style"), string2, false, arg_0 -> sv.a(string2, (String)object, bbf2, arg_0));
                        if (object8 != null) {
                            object5 = d.s(d.g(null, String.valueOf(object8) + "_background"));
                            if (object5 == null) {
                                throw new sx("Can't find background '" + String.valueOf(object8) + "' texture file for item '" + qm3.getNamespacedID() + "'. File: " + bbf2.nh());
                            }
                            serializable2 = d.s(d.g(null, String.valueOf(object8) + "_frame"));
                            if (serializable2 == null) {
                                throw new sx("Can't find frame '" + String.valueOf(object8) + "' texture file for item '" + qm3.getNamespacedID() + "'. File: " + bbf2.nh());
                            }
                            qm3.b((NamespacedKey)object8);
                            d.g().G().add(object8);
                        }
                    }
                    catch (sx sx2) {
                        bce.error(sx2.getMessage());
                    }
                }
                if (ss.c(bbg2) && !sp.c(bbg2)) {
                    try {
                        ss.a(qm3, bbg2, bbf2, string2, (String)object);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        bce.error("[Items] '" + string2 + ":" + (String)object + "'. " + illegalArgumentException.getMessage());
                    }
                }
                if (bbg2.gP("jukebox_disc")) {
                    if (!Version.isAtLeast((Version)Version.v1_21_1)) {
                        bce.error("[Items] '" + string2 + ":" + (String)object + "'. Error: 'jukebox_playable' is only available in 1.21.1+. File: " + bbf2.nh());
                        continue;
                    }
                    object8 = bbf.a(bbg2.gV("jukebox_disc.song"), string2, false, arg_0 -> sv.e(string2, (String)object, bbf2, arg_0));
                    if (object8 != null) {
                        qm3.c((NamespacedKey)object8);
                    }
                }
                qm3.b(bbg2);
                qm3.c(component);
                qm3.b(component);
                if (tb.c(bbg2)) {
                    tb.a(qm3, bbg2, bbf2);
                }
                if (so.c(bbg2) && !so.b(qm3, bbg2, bbf2, string2, (String)object) || !st.b(qm3, bbg2, bbf2, string2, (String)object)) continue;
                if (sp.c(bbg2)) {
                    try {
                        sp.a(qm3, bbg2, bbf2, string2, (String)object);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        bce.error("[Items] '" + string2 + ":" + (String)object + "'. Error: " + illegalArgumentException.getMessage());
                        continue;
                    }
                }
                if (tc.r(qm3)) {
                    tc.a(qm3, bbg2, bbf2);
                } else if (qm3.getType() == Material.LEATHER_HORSE_ARMOR) {
                    object8 = bbg2.az("specific_properties.leather_horse_armor.color", "WHITE");
                    int n3 = bcy.iN((String)object8);
                    if (n3 == -1) {
                        bce.error("[Items] '" + qm3.getNamespacedID() + "'. Missing leather_horse_armor.color '" + (String)object8 + "'. File: " + bbf2.nh());
                    }
                    qm3.Gv = bbg2.C("specific_properties.leather_horse_armor.can_be_recolored_in_crafting_table", false);
                    serializable2 = (LeatherArmorMeta)qm3.getItemMeta();
                    serializable2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.BODY));
                    serializable2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                    if (n3 != -1) {
                        serializable2.setColor(Color.fromRGB((int)n3));
                    }
                    serializable2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_DYE});
                    qm3.setItemMeta((ItemMeta)serializable2);
                } else if (qm3.getType() == Material.WRITTEN_BOOK) {
                    baz.f(qm3, bbe.u(component));
                    baz.e(qm3, bbg2.az("specific_properties.book.author", " "));
                    baz.a(qm3, BookMeta.Generation.valueOf((String)bbg2.az("specific_properties.book.generation", "TATTERED")));
                    if (bbg2.gP("specific_properties.book.pages")) {
                        baz.c(qm3, bbg2.hV("specific_properties.book.pages"));
                    } else {
                        baz.c(qm3, new ArrayList());
                    }
                }
                qm3.bK(bbg2.az("permission_suffix", bbg2.gV("permission")));
                qm3.i(bbg2.t("events_cooldown", bbg2.t("events_settings.cooldown.ticks", -1)));
                object8 = bbg2.az("events_settings.cooldown.indicator", "TITLE");
                object5 = (rl)bbi.b((String)object8, rl.class, rl.VANILLA);
                if (object5 == rl.VANILLA && Version.isOlderThan((Version)Version.v1_21_3)) {
                    object5 = rl.HIDDEN;
                }
                if (!Main.KO.gY("huds.enabled")) {
                    object5 = rl.HIDDEN;
                }
                switch (sw.Kc[((Enum)object5).ordinal()]) {
                    case 1: {
                        if (!Main.KO.gY("huds.enabled")) break;
                        serializable2 = null;
                        object7 = bbg2.gV("events_settings.cooldown.custom_hud");
                        if (object7 == null) {
                            object7 = "_iainternal:small_cooldown_bar";
                        }
                        if ((object62 = (ii)this.JY.am.vF.get(object7)) instanceof ij) {
                            serializable2 = Float.valueOf(((ij)object62).jZ());
                        }
                        if (object62 != null) {
                            qm3.a(new rj((rl)((Object)object5), (String)object7, (Float)serializable2));
                            break;
                        }
                        bce.error("[Items] '" + qm3.getNamespacedID() + "'. Unknown cooldown hud '" + object7 + "'. File: " + bbf2.nh());
                        break;
                    }
                    case 2: {
                        serializable2 = (BarColor)bbg2.a("events_settings.cooldown.bossbar.color", BarColor.class, (Enum)ae.fh);
                        object7 = (BarStyle)bbg2.a("events_settings.cooldown.bossbar.style", BarStyle.class, (Enum)ae.fi);
                        qm3.a(new rj((rl)((Object)object5), (BarColor)serializable2, (BarStyle)object7));
                        break;
                    }
                    default: {
                        qm3.a(new rj((rl)((Object)object5)));
                    }
                }
                qm3.bH(bbg2.az("all_actions_permission", null));
                if (bbg2.gP("events_needed_player_stats")) {
                    serializable2 = bbg2.hi("events_needed_player_stats");
                    for (Object object62 : serializable2.getKeys(false)) {
                        qm3.s((String)object62, serializable2.getString((String)object62));
                    }
                }
                if (bbg2.C("drop.glow.enabled", false) && (serializable2 = bbg2.az("drop.glow.color", null)) != null) {
                    qm3.bO((String)((Object)serializable2));
                }
                qm3.ar(bbg2.C("drop.show_name", false));
                if (bbg2.gP("enchants")) {
                    serializable2 = new HashMap();
                    object7 = (ArrayList)bbg2.hg("enchants");
                    object62 = ((ArrayList)object7).iterator();
                    while (object62.hasNext()) {
                        object4 = (String)object62.next();
                        object3 = ((String)object4).split(":");
                        object2 = null;
                        int n4 = 1;
                        ItemFlag itemFlag = object3[0];
                        if (((ItemFlag)object3).length == 1) {
                            object2 = bbi.ij((String)itemFlag);
                        } else if (((ItemFlag)object3).length == 2) {
                            if (bcy.iJ((String)object3[1])) {
                                object2 = bbi.ij((String)itemFlag);
                                n4 = bcy.w((String)object3[1], 1);
                            } else {
                                object2 = Enchantment.getByKey((NamespacedKey)new NamespacedKey((String)itemFlag, (String)object3[1]));
                            }
                        } else if (((ItemFlag)object3).length == 3) {
                            object2 = Enchantment.getByKey((NamespacedKey)new NamespacedKey((String)itemFlag, (String)object3[1]));
                            n4 = bcy.w((String)object3[2], 1);
                        }
                        if (object2 == null) {
                            if (Main.PJ && ae.eW) {
                                try {
                                    if (!AeWrapper.isCustomEnchant((String)itemFlag)) continue;
                                    AeWrapper.applyEnchant(qm3, (String)itemFlag, n4);
                                    qm3.mZ();
                                }
                                catch (Throwable throwable) {
                                    bce.error("[Items] '" + qm3.getNamespacedID() + "'. Error applying AdvancedEnchantments enchant '" + (String)itemFlag + "'.", throwable);
                                }
                                continue;
                            }
                            bce.error("[Items] '" + qm3.getNamespacedID() + "'. Unknown vanilla/custom enchant '" + (String)itemFlag + "'. File: " + bbf2.nh());
                            continue;
                        }
                        serializable2.put(object2, n4);
                    }
                    qm3.addUnsafeEnchantments((Map)((Object)serializable2));
                    qm3.c(ImmutableMap.copyOf(serializable2));
                    qm3.mZ();
                }
                if (bbg2.gP("lore")) {
                    serializable2 = new ArrayList();
                    for (Object object62 : bbg2.hg("lore")) {
                        object4 = this.JY.bg.ai((String)object62);
                        serializable2.add(object4);
                    }
                    bbs.a(qm3.mQ(), serializable2);
                    qm3.na();
                }
                boolean bl4 = false;
                if (bbg2.gP("item_flags")) {
                    object7 = new HashSet();
                    object62 = bbg2.hg("item_flags").iterator();
                    while (object62.hasNext()) {
                        object4 = (String)object62.next();
                        object3 = bbi.ic((String)object4);
                        if (object3 != null) {
                            object7.add(object3);
                            continue;
                        }
                        bce.error("[Items] '" + qm3.getNamespacedID() + "'.  Unknown item flag '" + (String)object4 + "'. File: " + bbf2.nh());
                    }
                    if (object7.contains(ItemFlag.HIDE_ATTRIBUTES)) {
                        bl4 = true;
                    }
                    qm3.b((Set)object7);
                }
                if (!bbg2.gP("attribute_modifiers")) {
                    if (Main.KO.gY("debug.recipes.log-attribute-modifiers-loading")) {
                        bce.log(String.valueOf(ChatColor.YELLOW) + "    No attribute_modifiers found for item " + qm3.getNamespacedID());
                    }
                } else {
                    object7 = bbg2.hi("attribute_modifiers");
                    if (object7 != null) {
                        sv.a(qm3, (ConfigurationSection)object7);
                    }
                }
                if (bl4 && !Version.isAtLeast((Version)Version.v1_21_5)) {
                    aiq.tX().ab(qm3);
                }
                if (bbg2.C("auto_update.enabled", ae.fI)) {
                    object7 = rr.oE().au(bbg2.C("auto_update.fix_unstackable_items_on_click", ae.fK)).a((rs)bbg2.a("auto_update.enchantment_mode", rs.class, ae.fJ));
                    qm3.a(((rt)object7).oI());
                }
                qm3.h(bbg2.c("max_stack_size", (Integer)null));
                qm3.al(bbg2.C("fire_resistant", false));
                qm3.am(bbg2.C("hide_tooltip", false));
                qm3.ah(bbg2.t("durability.repair_cost", 0));
                object7 = bbg2.a("glint", bbg2.a("enchantment_glint_override", (Boolean)null));
                if (object7 != null) {
                    qm3.an((Boolean)object7);
                }
                if ((n2 = bbg2.t("durability.usages", -1)) != -1) {
                    qm3.ag(n2);
                    qm3.af(n2);
                    qm3.mY();
                }
                MmoItemsHook.injectMmoItem(qm3, bbg2.az("mmoitem.type", null), bbg2.az("mmoitem.id", null), bbg2.C("mmoitem.use_mmoitem_displayname", false));
                if (Main.PI && (object4 = bbg2.az("executableitem.id", null)) != null) {
                    try {
                        object3 = ExecutableItemsHook.getExecutableItem((String)object4);
                        qm3.r((ItemStack)object3);
                    }
                    catch (NullPointerException nullPointerException) {
                        bce.error("[Items] '" + qm3.getNamespacedID() + "'. Error loading ExecutableItems. Please check if the ExecutableItem of id '" + (String)object4 + "' exists in ExecutableItems plugin. File: " + bbf2.nh());
                    }
                }
                if (!(qm3.ng() || qm3.nc() && qm3.fX() != 0)) {
                    if (!bbg2.gP("resource.model_id") && !bbg2.gP("resource.custom_model_data")) {
                        qm3.ae(f.xl().a((Material)sh3, string2, (String)object));
                    } else {
                        qm3.ae(f.xl().a((Material)sh3, string2, (String)object, bbg2.t("resource.custom_model_data", bbg2.gW("resource.model_id")), false, bbf2.nh()));
                    }
                }
                if (Main.KO.gY("debug.items.log-items-loading")) {
                    bce.log("      Assigned custom_model_data: " + qm3.fX());
                }
                if (bbg2.gP("blocked_enchants")) {
                    object4 = new ArrayList();
                    object3 = (ArrayList)bbg2.hg("blocked_enchants");
                    object2 = ((ArrayList)object3).iterator();
                    while (object2.hasNext()) {
                        String string4 = (String)object2.next();
                        if (string4.equalsIgnoreCase("all")) {
                            qm3.aq(true);
                            break;
                        }
                        ((ArrayList)object4).add(Enchantment.getByName((String)string4));
                    }
                    qm3.a((ArrayList)object4);
                }
                qm3.as(bbg2.C("show_in_ia_gui", true));
                if (ae.fj) {
                    xk.z(qm3);
                }
                if (ae.fk) {
                    xm.z(qm3);
                }
                qm.m(qm3);
                this.JY.C.put(qm3.getNamespacedID(), qm3);
                this.JY.E.put(qm3.getId(), qm3);
                this.JY.D.put(qm3.Gi, qm3);
                this.JY.N.computeIfAbsent(qm3.getType(), material -> new ArrayList()).add(qm3);
                this.JY.O.computeIfAbsent(qm3.getType(), material -> new HashMap()).put(qm3.getNamespacedID(), qm3);
                this.JY.M.computeIfAbsent(qm3.getNamespace(), string -> new HashMap()).put(qm3.getId(), qm3);
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                bce.log("Loaded item: " + qm3.getNamespacedID());
            }
            if (bl) {
                bbf2.save();
                bbf2.reload();
            }
            if (!bbf2.gP("liquids")) continue;
            if (ae.cS) {
                for (Object object : bbf2.gR("liquids")) {
                    bbg2 = bbf2.hi("liquids." + (String)object);
                    n = bcy.iN(bbg2.getString("color"));
                    sh3 = new sh(string2, (String)object, n);
                    this.JY.af.put(sh3.getNamespacedID(), sh3);
                    if (!Main.KO.gY("debug.other.log-liquids-loading")) continue;
                    bce.log("Loaded liquid: " + sh3.getNamespacedID());
                }
                continue;
            }
            bce.warn("Liquids load skipped. Enable them in config.yml if you want to load them. File: " + bbf2.nh());
        }
        f.xl().xt();
        se.pi();
        if (this.JY.m()) {
            this.JY.C.forEach((string, qm2) -> this.JY.a((Plugin)null, (qm)qm2));
        }
        ArrayList<afl> arrayList = new ArrayList<afl>(this.JY.af.values().stream().map(sh2 -> new afl(sh2.getNamespace(), sh2.getId(), sh2.getColor())).toList());
        this.Ka = afj.tG().z(arrayList);
    }

    @NotNull
    public static bbg a(bbf bbf2, bbg bbg2, Map map, String string2, String string3) {
        String string4 = bbg2.az("variant_of", null);
        if (string4 != null) {
            bbg bbg3 = (bbg)map.get(string4 = v.i(string4, string2));
            if (bbg3 != null) {
                try {
                    YamlConfiguration yamlConfiguration = bdj.f(bbg3);
                    YamlConfiguration yamlConfiguration2 = bdj.f(bbg2);
                    yamlConfiguration.getValues(true).forEach((string, object) -> {
                        if (!yamlConfiguration2.contains(string)) {
                            yamlConfiguration2.set(string, object);
                        }
                    });
                    yamlConfiguration2.set("template", null);
                    if ((yamlConfiguration.contains("graphics.texture") || yamlConfiguration.contains("graphics.textures")) && (yamlConfiguration2.contains("graphics.model") || yamlConfiguration2.contains("graphics.models"))) {
                        yamlConfiguration2.set("graphics.texture", null);
                        yamlConfiguration2.set("graphics.textures", null);
                    }
                    if ((yamlConfiguration.contains("graphics.model") || yamlConfiguration.contains("graphics.models")) && (yamlConfiguration2.contains("graphics.texture") || yamlConfiguration2.contains("graphics.textures"))) {
                        yamlConfiguration2.set("graphics.model", null);
                        yamlConfiguration2.set("graphics.models", null);
                    }
                    return new bbg((ConfigurationSection)yamlConfiguration2);
                }
                catch (InvalidConfigurationException invalidConfigurationException) {
                    throw new RuntimeException(invalidConfigurationException);
                }
            }
            bce.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown template '" + string4 + "'. File: " + bbf2.nh());
            throw new IllegalArgumentException("Unknown template  '" + string4 + "'. File: " + bbf2.nh());
        }
        return bbg2;
    }

    public void ps() {
        for (qm qm2 : this.JY.F.values()) {
            qm2.Ge.a(this.JY);
        }
        for (qm qm2 : this.JY.F.values()) {
            qm2.Gd.b(this.JY);
        }
        for (qm qm2 : this.JY.C.values()) {
            qm2.Ge.a(this.JY);
        }
        for (qm qm2 : this.JY.C.values()) {
            qm2.Gd.b(this.JY);
            this.q(qm2);
            this.p(qm2);
        }
        for (qm qm2 : new ArrayList(d.g().S)) {
            sm.d((ql)qm2);
        }
    }

    public void p(qm qm2) {
        if (qm2 instanceof rb) {
            if (!this.JZ.containsKey(qm2.getNamespacedID())) {
                bce.log(String.valueOf(ChatColor.YELLOW) + "Seed '" + qm2.getNamespacedID() + "' has no results (file '" + qm2.nh() + "' )");
                return;
            }
            int n = 0;
            for (String string : (List)this.JZ.get(qm2.getNamespacedID())) {
                ItemStack itemStack = this.JY.q(string);
                if (itemStack == null) {
                    bce.log(String.valueOf(ChatColor.YELLOW) + "Seed '" + qm2.getNamespacedID() + "' has unknown item result '" + string + "'. File: " + qm2.nh());
                    continue;
                }
                ((ry)((rb)qm2).nD().get(n)).M(itemStack);
                ++n;
            }
            ((rb)qm2).nD().removeIf(ry2 -> ry2.getItemStack() == null);
        }
    }

    public void q(qm qm2) {
        if ((qm2.np().gP("behaviours.block.placed_model.break_particles_material") || qm2.np().gP("specific_properties.block.placed_model.break_particles_material")) && qm2 instanceof ql) {
            String string = qm2.np().az("behaviours.block.placed_model.break_particles_material", qm2.np().az("specific_properties.block.placed_model.break_particles_material", ""));
            assert (string != null);
            if (bbi.d(string.toUpperCase(), Material.class)) {
                if (Material.valueOf((String)string.toUpperCase()).isBlock()) {
                    ((ql)qm2).FD.n(Material.valueOf((String)string.toUpperCase()));
                } else {
                    bce.error("[Items] '" + qm2.getNamespacedID() + "'. Invalid break_particles_material '" + string + "' for item '" + qm2.getNamespacedID() + "'. It's an ITEM, not a BLOCK. Please use a BLOCK material name. File: " + qm2.nh());
                }
            } else if (this.JY.f(string)) {
                ((ql)qm2).FD.n(this.JY.e(string));
            } else {
                bce.error("[Items] '" + qm2.getNamespacedID() + "'. Invalid break_particles_material '" + string + "' for item '" + qm2.getNamespacedID() + "' please make sure it's a vanilla material or a custom item. File: " + qm2.nh());
            }
        }
    }

    static void a(qm qm2, @NotNull ConfigurationSection configurationSection) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = qm2.b(ItemFlag.HIDE_ATTRIBUTES);
        for (String string : configurationSection.getKeys(false)) {
            ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection(string);
            Set set = configurationSection2.getKeys(true);
            for (String string2 : set) {
                if (!sv.a(qm2, string, string2, configurationSection2)) continue;
                if (string2.contains("attackDamage") || string2.contains("attack_damage")) {
                    bl2 = true;
                }
                if (!string2.contains("attackSpeed") && !string2.contains("attack_speed")) continue;
                bl = true;
            }
        }
        if (ae.eg && !bl3 && bbs.ae(qm2) && (bl2 || bl)) {
            aiq.tX().ab(qm2);
            qm.a(qm2, qt.MAINHAND);
        }
    }

    static boolean a(qm qm2, String string, String string2, ConfigurationSection configurationSection) {
        String string3;
        double d2;
        if (string2.endsWith("operation") || string2.endsWith("value")) {
            return false;
        }
        Object object = configurationSection.get(string2);
        if (object instanceof ConfigurationSection) {
            ConfigurationSection configurationSection2 = (ConfigurationSection)object;
            if (!configurationSection2.contains("value")) {
                return false;
            }
            d2 = configurationSection2.getDouble("value", 0.0);
            string3 = configurationSection2.getString("operation", "add");
        } else {
            d2 = configurationSection.getDouble(string2, 0.0);
            string3 = "add";
        }
        qm2.a(string2, string, d2, string3);
        return true;
    }

    private static String ci(String string) {
        String[] stringArray = string.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : stringArray) {
            if (string2.isEmpty()) continue;
            stringBuilder.append(Character.toUpperCase(string2.charAt(0)));
            if (string2.length() > 1) {
                stringBuilder.append(string2.substring(1).toLowerCase());
            }
            stringBuilder.append(" ");
        }
        if (!stringBuilder.isEmpty()) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private static /* synthetic */ void e(String string, String string2, bbf bbf2, String string3) {
        bce.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'jukebox_disc.song' value '" + string3 + "'. File: " + bbf2.nh());
    }

    private static /* synthetic */ void a(String string, String string2, bbf bbf2, String string3) {
        bce.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'tooltip_style' value '" + string3 + "'. File: " + bbf2.nh());
    }
}
