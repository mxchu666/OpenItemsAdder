package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.asg;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbi;
import itemsadder.m.bce;
import itemsadder.m.bci;
import itemsadder.m.d;
import itemsadder.m.od;
import itemsadder.m.uv;
import itemsadder.m.uw;
import itemsadder.m.vb;
import itemsadder.m.vc;
import itemsadder.m.vd;
import itemsadder.m.ve;
import itemsadder.m.vg;
import itemsadder.m.vj;
import itemsadder.m.vk;
import itemsadder.m.vm;
import itemsadder.m.vp;
import itemsadder.m.vr;
import itemsadder.m.wb;
import itemsadder.m.wc;
import itemsadder.m.wd;
import itemsadder.m.we;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemorySection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.Nullable;

public class td {
    boolean Kg;
    List Kh = Collections.synchronizedList(new ArrayList());
    List Ki = Collections.synchronizedList(new ArrayList());
    List Kj = Collections.synchronizedList(new ArrayList());

    public void a(d d2, Map map, @Nullable vc vc2) {
        this.Kg = true;
        if (ae.eZ) {
            for (bbf bbf2 : map.values()) {
                Object object;
                Object object2;
                Object object3;
                Object object4;
                String string;
                bbg bbg2;
                List list;
                String string2 = bbf2.gV("info.namespace");
                List list2 = bbf2.gR("recipes");
                if (list2 == null) {
                    if (!Main.KO.gY("debug.recipes.log-recipes-loading")) continue;
                    bce.log(String.valueOf(ChatColor.YELLOW) + "    No recipes found in file " + bbf2.qd());
                    continue;
                }
                if (ae.fa) {
                    list = bbf2.gR("recipes.crafting_table");
                    for (String string3 : list) {
                        Object object52;
                        Object object6;
                        Object object72;
                        Object object8;
                        Object object92;
                        HashMap hashMap;
                        bbg2 = bbf2.hj("recipes.crafting_table." + string3);
                        if (!bbg2.C("enabled", true)) {
                            if (!Main.KO.gY("debug.recipes.log-recipes-loading-disabled")) continue;
                            bce.log("    Ignored disabled crafting_table recipe: " + string3);
                            continue;
                        }
                        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                            bce.log(String.valueOf(ChatColor.WHITE) + "Loading crafting_table recipe: " + string3);
                        }
                        int n = bbg2.t("result.amount", 1);
                        boolean bl = bbg2.C("shapeless", false);
                        string = bbg2.gV("result.item");
                        object4 = d2.q(string);
                        if (object4 == null) {
                            bce.log(String.valueOf(ChatColor.YELLOW) + "[Recipes] '" + string3 + "'. Result item '" + string + "' not found. File " + bbf2.nh());
                            continue;
                        }
                        object4.setAmount(n);
                        if (bl) {
                            Object object102;
                            object3 = bbg2.hi("ingredients");
                            if (object3 == null) {
                                bce.error("[Recipes] '" + string3 + "'. Missing 'ingredients' attribute. File: " + bbf2.nh());
                                continue;
                            }
                            object2 = new ArrayList();
                            boolean bl2 = false;
                            boolean bl3 = false;
                            for (Object object102 : object3.getKeys(false)) {
                                hashMap = td.a(d2, object3, (String)object102, string3, bbf2);
                                object92 = (vp)((bci)((Object)hashMap)).aAX;
                                object8 = (String)((bci)((Object)hashMap)).aAY;
                                if (object92 != null) {
                                    object72 = new vj(Character.valueOf(((String)object102).charAt(0)), (vp)object92);
                                    object6 = object2.iterator();
                                    while (object6.hasNext()) {
                                        object52 = (vj)object6.next();
                                        if (!((vj)object52).e(object72.getItem())) continue;
                                        bce.error("[Recipes] '" + string3 + "'. Duplicate ingredient '" + (String)object8 + "'. File: " + bbf2.nh());
                                        bl3 = true;
                                    }
                                    object2.add(object72);
                                    continue;
                                }
                                bce.error("[Recipes] '" + string3 + "'. Ingredient '" + (String)object8 + "' not found. File: " + bbf2.nh());
                                bl2 = true;
                            }
                            if (bl2 || bl3) continue;
                            object = new HashMap();
                            if (bbg2.gP("return_items.replace")) {
                                object102 = bbg2.hi("return_items.replace");
                                for (Object object92 : object102.getKeys(false)) {
                                    object8 = d2.q((String)object92);
                                    if (object8 == null) {
                                        bce.error("[Recipes] '" + string3 + "'. Replace item not found '" + (String)object92 + "'. File: " + bbf2.nh());
                                        continue;
                                    }
                                    object72 = d2.q(object102.getString((String)object92));
                                    if (object72 == null) {
                                        bce.error("[Recipes] '" + string3 + "'. Replacement item not found '" + object102.getString((String)object92) + "'. File: " + bbf2.nh());
                                        continue;
                                    }
                                    ((HashMap)object).put(object8, object72);
                                }
                            }
                            object102 = new HashMap();
                            if (bbg2.gP("return_items.decrement_durability")) {
                                hashMap = bbg2.hi("return_items.decrement_durability");
                                object92 = hashMap.getKeys(false).iterator();
                                while (object92.hasNext()) {
                                    object8 = (String)object92.next();
                                    ((HashMap)object102).put(d2.q(hashMap.getString((String)object8 + ".item")), hashMap.getInt((String)object8 + ".amount"));
                                }
                            }
                            hashMap = new HashMap();
                            if (bbg2.gP("return_items.increment_durability")) {
                                object92 = bbg2.hi("return_items.increment_durability");
                                for (Object object72 : object92.getKeys(false)) {
                                    hashMap.put(d2.q(object92.getString((String)object72 + ".item")), object92.getInt((String)object72 + ".amount"));
                                }
                            }
                            try {
                                object92 = new vk(bbf2, bbg2.CM(), bbg2.az("permission", null), (HashMap)object, (HashMap)object102, hashMap, new od(bbg2.az("return_items.play_sound.name", ""), bbg2.a("return_items.play_sound.volume", 0.3f), bbg2.a("return_items.play_sound.pitch", 1.0f), bbg2.az("return_items.play_sound.category", null), bbg2.C("return_items.play_sound.stop_previous", true)), (ItemStack)object4, (List)object2);
                                this.Kh.add(new uv((uw)object92, string2, string3));
                            }
                            catch (Throwable throwable) {
                                bce.error("[Recipes] '" + string3 + "'. Failed to load. File: " + bbf2.nh(), throwable);
                            }
                            continue;
                        }
                        int n2 = 0;
                        object2 = bbg2.aZ(false).iterator();
                        while (object2.hasNext()) {
                            String string4 = (String)object2.next();
                            if (!string4.startsWith("pattern")) continue;
                            ArrayList<vj> arrayList = new ArrayList<vj>();
                            object = bbg2.hi("ingredients");
                            if (object == null) {
                                bce.error("[Recipes] '" + string3 + "'. Missing 'ingredients' attribute. File: " + bbf2.nh());
                                continue;
                            }
                            boolean bl4 = false;
                            for (Object object92 : object.getKeys(false)) {
                                object8 = td.a(d2, (ConfigurationSection)object, (String)object92, string3, bbf2);
                                object72 = (vp)((bci)object8).aAX;
                                object6 = (String)((bci)object8).aAY;
                                if (object72 != null) {
                                    arrayList.add(new vj(Character.valueOf(((String)object92).charAt(0)), (vp)object72));
                                    continue;
                                }
                                bce.error("[Recipes] '" + string3 + "'. Ingredient not found '" + (String)object6 + "'. File: " + bbf2.nh());
                                bl4 = true;
                            }
                            if (bl4) continue;
                            hashMap = new HashMap();
                            if (bbg2.gP("return_items.replace")) {
                                object92 = bbg2.hi("return_items.replace");
                                for (Object object72 : object92.getKeys(false)) {
                                    object6 = d2.q((String)object72);
                                    if (object6 == null) {
                                        bce.error("[Recipes] '" + string3 + "'. Replace item not found '" + (String)object72 + "'. File: " + bbf2.nh());
                                        continue;
                                    }
                                    object52 = d2.q(object92.getString((String)object72));
                                    if (object52 == null) {
                                        bce.error("[Recipes] '" + string3 + "'. Replacement item not found '" + object92.getString((String)object72) + "'. File: " + bbf2.nh());
                                        continue;
                                    }
                                    hashMap.put(object6, object52);
                                }
                            }
                            object92 = new HashMap();
                            if (bbg2.gP("return_items.decrement_durability")) {
                                object8 = bbg2.hi("return_items.decrement_durability");
                                object72 = object8.getKeys(false).iterator();
                                while (object72.hasNext()) {
                                    object6 = (String)object72.next();
                                    ((HashMap)object92).put(d2.q(object8.getString(object6 + ".item")), object8.getInt(object6 + ".amount"));
                                }
                            }
                            object8 = new HashMap();
                            if (bbg2.gP("return_items.increment_durability")) {
                                object72 = bbg2.hi("return_items.increment_durability");
                                for (Object object52 : object72.getKeys(false)) {
                                    ((HashMap)object8).put(d2.q(object72.getString((String)object52 + ".item")), object72.getInt((String)object52 + ".amount"));
                                }
                            }
                            try {
                                object72 = bbg2.hg(string4).toArray(new String[0]);
                                object6 = new vk(bbf2, bbg2.CM(), bbg2.az("permission_suffix", bbg2.az("permission", null)), hashMap, (HashMap)object92, (HashMap)object8, new od(bbg2.az("return_items.play_sound.name", ""), bbg2.a("return_items.play_sound.volume", 0.3f), bbg2.a("return_items.play_sound.pitch", 1.0f), bbg2.az("return_items.play_sound.category", null), bbg2.C("return_items.play_sound.stop_previous", true)), (ItemStack)object4, (String[])object72, arrayList);
                                object52 = string3 + "_" + n2;
                                this.Kh.add(new uv((uw)object6, string2, (String)object52));
                                ++n2;
                            }
                            catch (Throwable throwable) {
                                bce.error("[Recipes] '" + string3 + "'. Failed to load. File: " + bbf2.nh(), throwable);
                            }
                        }
                    }
                }
                if (ae.fb) {
                    list = bbf2.gR("recipes.cooking");
                    for (String string3 : list) {
                        bbg2 = bbf2.hj("recipes.cooking." + string3);
                        if (!bbg2.C("enabled", true)) {
                            if (!Main.KO.gY("debug.recipes.log-recipes-loading-disabled")) continue;
                            bce.log("    Ignored disabled cooking recipe: " + string3);
                            continue;
                        }
                        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                            bce.log(String.valueOf(ChatColor.WHITE) + "Loading cooking recipe: " + string3);
                        }
                        for (String string5 : bbg2.hg("machines")) {
                            string = bbg2.gV("result.item");
                            object4 = d2.q(string);
                            if (object4 == null) {
                                bce.log(String.valueOf(ChatColor.YELLOW) + "[Recipes] '" + string3 + "'. Result item '" + string + "' not found. File " + bbf2.nh());
                                continue;
                            }
                            object4.setAmount(bbg2.t("result.amount", 1));
                            object3 = bbg2.az("ingredient.item", "");
                            object2 = d2.d((String)object3, bbf2.nh());
                            if (object2 != null) {
                                ve ve2 = new ve(bbf2, bbg2.CM(), bbg2.az("permission_suffix", bbg2.az("permission", "")), (ItemStack)object4, new vd(object2), bbg2.a("exp", -1.0f), bbg2.t("cook_time", 200));
                                Material material = bbf.b(string5, null);
                                if (material == null) {
                                    bce.error("[Recipes] '" + string3 + "'. Invalid furnace type '" + string5 + "'. File: " + bbf2.nh());
                                    continue;
                                }
                                ve2.w(material);
                                this.Ki.add(new uv(ve2, string2, string3));
                                continue;
                            }
                            bce.log(String.valueOf(ChatColor.YELLOW) + "[Recipes] '" + string3 + "'. Ingredient item '" + (String)object3 + "' not found. File " + bbf2.nh());
                        }
                    }
                }
                if (ae.fd) {
                    list = bbf2.gR("recipes.smithing");
                    for (String string3 : list) {
                        String string6;
                        Object object11;
                        String string7;
                        ItemStack itemStack;
                        bbg2 = bbf2.hj("recipes.smithing." + string3);
                        assert (bbg2 != null);
                        if (!bbg2.C("enabled", true)) {
                            if (!Main.KO.gY("debug.recipes.log-recipes-loading-disabled")) continue;
                            bce.log("    Ignored disabled smithing recipe: " + string3);
                            continue;
                        }
                        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                            bce.log(String.valueOf(ChatColor.WHITE) + "Loading smithing recipe: " + string3);
                        }
                        if ((itemStack = d2.q(string7 = bbg2.gV("result.item"))) == null) {
                            bce.log(String.valueOf(ChatColor.YELLOW) + "[Recipes] '" + string3 + "'. Result item '" + string7 + "' not found. File " + bbf2.nh());
                            continue;
                        }
                        itemStack.setAmount(bbg2.t("result.amount", 1));
                        string = bbg2.az("template", "");
                        object4 = d2.d(string, null);
                        if (object4 == null) {
                            bce.warn("[Recipes] '" + string3 + "'. Template item '" + string + "' not found. File " + bbf2.nh());
                        }
                        if ((object2 = d2.d((String)(object3 = bbg2.az("base", "")), null)) == null) {
                            bce.warn("[Recipes] '" + string3 + "'. Base item '" + (String)object3 + "' not found. File " + bbf2.nh());
                        }
                        if ((object11 = d2.d(string6 = bbg2.az("addition", ""), null)) == null) {
                            bce.warn("[Recipes] '" + string3 + "'. Addition item '" + (String)object3 + "' not found. File " + bbf2.nh());
                        }
                        object = null;
                        if (object2 != null && object11 != null) {
                            object = new wc(bbf2, bbg2.CM(), bbg2.az("permission_suffix", bbg2.az("permission", "")), itemStack, new wb(object4), new wb(object2), new wb(object11), new wd(bbg2.C("result.move_attributes.name", false), bbg2.C("result.move_attributes.lore", false), bbg2.C("result.move_attributes.enchants", true), bbg2.C("result.move_attributes.durability", false), bbg2.C("result.move_attributes.custom_model_data", false), bbg2.C("result.move_attributes.material", false), bbg2.C("result.move_attributes.other_nbt", true)));
                        }
                        if (object == null) continue;
                        this.Kj.add(new uv((uw)object, string2, string3));
                    }
                }
                if (!ae.fc) continue;
                list = bbf2.gR("recipes.anvil_repair");
                for (String string3 : list) {
                    String string8;
                    ItemStack itemStack;
                    bbg2 = bbf2.hj("recipes.anvil_repair." + string3);
                    if (!bbg2.C("enabled", true)) {
                        if (!Main.KO.gY("debug.recipes.log-recipes-loading-disabled")) continue;
                        bce.log("    Ignored disabled anvil_repair recipe: " + string3);
                        continue;
                    }
                    if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                        bce.log(String.valueOf(ChatColor.WHITE) + "Loading anvil_repair recipe: " + string3);
                    }
                    if ((itemStack = d2.q(string8 = bbg2.gV("item"))) == null) {
                        bce.warn("[Recipes] '" + string3 + "'. Result item '" + string8 + "' not found. File: " + bbf2.nh());
                        continue;
                    }
                    string = bbg2.gV("ingredient");
                    object4 = d2.q(string);
                    if (object4 == null) {
                        bce.warn("[Recipes] '" + string3 + "'. Ingredient item '" + string + "' not found. File: " + bbf2.nh());
                        continue;
                    }
                    object3 = new vb(bbf2, bbg2.CM(), bbg2.az("permission_suffix", bbg2.az("permission", "")), itemStack, (ItemStack)object4);
                    vc2.a((vb)object3, string2, string3);
                }
            }
        }
    }

    public void a(@Nullable vm vm2, @Nullable vg vg2, @Nullable we we2) {
        if (!this.Kg) {
            throw new RuntimeException("bro you should first preload the recipes.");
        }
        int n = this.Kh.size() + this.Ki.size() + this.Kj.size();
        bce.log("Registering " + n + " recipes...");
        if (ae.fa) {
            uv.a(vm2, this.Kh);
        }
        if (ae.fb) {
            uv.a(vg2, this.Ki);
        }
        if (we2 != null && ae.fd) {
            uv.a(we2, this.Kj);
        }
        this.Kh.clear();
        this.Ki.clear();
        this.Kj.clear();
        d.g().aW.qV();
        asg.vq().g(d.g().aW.qZ());
        asg.vq().vm();
        asg.vq().vo();
        bce.log("Registered " + n + " recipes.");
    }

    private static bci a(d d2, ConfigurationSection configurationSection, String string, String string2, bbf bbf2) {
        String string3;
        vp vp2 = null;
        if (configurationSection.get(string) instanceof MemorySection) {
            String string4;
            string3 = configurationSection.getString(string + ".item", null);
            if (string3 == null) {
                bce.error("[Recipes] '" + string2 + "'. Missing 'item' property for ingredient '" + string + "'. File: " + bbf2.nh());
                return bci.e(vp2, string3);
            }
            Material material = (Material)bbi.e(string3, Material.class);
            if (material == null) {
                bce.error("[Recipes] '" + string2 + "'. Item '" + string3 + "' not found for ingredient '" + string + "'. File: " + bbf2.nh());
                return bci.e(vp2, string3);
            }
            if ((material == Material.POTION || material == Material.SPLASH_POTION) && (string4 = configurationSection.getString(string + ".potion_type", null)) != null) {
                PotionType potionType = bbf.gL(string4);
                if (potionType == null) {
                    bce.error("[Recipes] '" + string2 + "'. Invalid potion type '" + string4 + "' for ingredient '" + string + "'. File: " + bbf2.nh());
                    return bci.e(vp2, string3);
                }
                ItemStack itemStack = new ItemStack(material);
                PotionMeta potionMeta = (PotionMeta)itemStack.getItemMeta();
                potionMeta.setBasePotionType(potionType);
                itemStack.setItemMeta((ItemMeta)potionMeta);
                vp2 = new vr(itemStack);
            }
        } else {
            string3 = configurationSection.getString(string);
        }
        if (vp2 == null) {
            vp2 = d2.n(string3);
        }
        return bci.e(vp2, string3);
    }
}
