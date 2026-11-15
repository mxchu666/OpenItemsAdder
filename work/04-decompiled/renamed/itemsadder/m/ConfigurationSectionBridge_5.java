package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BoolData_3;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.FurnaceStartSmeltListener;
import itemsadder.m.ItemStackBridge_34;
import itemsadder.m.ItemStackBridge_35;
import itemsadder.m.ItemStackBridge_37;
import itemsadder.m.ItemStackBridge_39;
import itemsadder.m.ItemStackBridge_41;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBridge_18;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.Opaque021;
import itemsadder.m.Opaque138;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.PrepareAnvilListener;
import itemsadder.m.PrepareItemCraftListener;
import itemsadder.m.PrepareSmithingListener;
import itemsadder.m.RecipeChoiceItemStackHolder;
import itemsadder.m.RecipeChoiceItemStackHolder_2;
import itemsadder.m.RecipeChoiceItemStackHolder_3;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.SoundCategoryBridge_3;
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

public class ConfigurationSectionBridge_5 {
    boolean Kg;
    List Kh = Collections.synchronizedList(new ArrayList());
    List Ki = Collections.synchronizedList(new ArrayList());
    List Kj = Collections.synchronizedList(new ArrayList());

    public void a(ItemStackRegistry itemStackRegistry, Map map, @Nullable PrepareAnvilListener prepareAnvilListener) {
        this.Kg = true;
        if (MaterialBarColorHolder.eZ) {
            for (PluginFileConfigurationHolder pluginFileConfigurationHolder : map.values()) {
                Object object;
                Object object2;
                Object object3;
                Object object4;
                String string;
                ConfigurationSectionBridge configurationSectionBridge;
                List list;
                String string2 = pluginFileConfigurationHolder.gV("info.namespace");
                List list2 = pluginFileConfigurationHolder.gR("recipes");
                if (list2 == null) {
                    if (!Main.KO.gY("debug.recipes.log-recipes-loading")) continue;
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No recipes found in file " + pluginFileConfigurationHolder.qd());
                    continue;
                }
                if (MaterialBarColorHolder.fa) {
                    list = pluginFileConfigurationHolder.gR("recipes.crafting_table");
                    for (String string3 : list) {
                        Object object52;
                        Object object6;
                        Object object72;
                        Object object8;
                        Object object92;
                        HashMap hashMap;
                        configurationSectionBridge = pluginFileConfigurationHolder.hj("recipes.crafting_table." + string3);
                        if (!configurationSectionBridge.C("enabled", true)) {
                            if (!Main.KO.gY("debug.recipes.log-recipes-loading-disabled")) continue;
                            CommandSenderBridge_5.log("    Ignored disabled crafting_table recipe: " + string3);
                            continue;
                        }
                        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                            CommandSenderBridge_5.log(String.valueOf(ChatColor.WHITE) + "Loading crafting_table recipe: " + string3);
                        }
                        int n = configurationSectionBridge.t("result.amount", 1);
                        boolean bl = configurationSectionBridge.C("shapeless", false);
                        string = configurationSectionBridge.gV("result.item");
                        object4 = itemStackRegistry.q(string);
                        if (object4 == null) {
                            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "[Recipes] '" + string3 + "'. Result item '" + string + "' not found. File " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                        object4.setAmount(n);
                        if (bl) {
                            Object object102;
                            object3 = configurationSectionBridge.hi("ingredients");
                            if (object3 == null) {
                                CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Missing 'ingredients' attribute. File: " + pluginFileConfigurationHolder.nh());
                                continue;
                            }
                            object2 = new ArrayList();
                            boolean bl2 = false;
                            boolean bl3 = false;
                            for (Object object102 : object3.getKeys(false)) {
                                hashMap = ConfigurationSectionBridge_5.a(itemStackRegistry, object3, (String)object102, string3, pluginFileConfigurationHolder);
                                object92 = (ItemStackBridge_37)((Opaque021)((Object)hashMap)).aAX;
                                object8 = (String)((Opaque021)((Object)hashMap)).aAY;
                                if (object92 != null) {
                                    object72 = new RecipeChoiceItemStackHolder_2(Character.valueOf(((String)object102).charAt(0)), (ItemStackBridge_37)object92);
                                    object6 = object2.iterator();
                                    while (object6.hasNext()) {
                                        object52 = (RecipeChoiceItemStackHolder_2)object6.next();
                                        if (!((RecipeChoiceItemStackHolder_2)object52).e(object72.getItem())) continue;
                                        CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Duplicate ingredient '" + (String)object8 + "'. File: " + pluginFileConfigurationHolder.nh());
                                        bl3 = true;
                                    }
                                    object2.add(object72);
                                    continue;
                                }
                                CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Ingredient '" + (String)object8 + "' not found. File: " + pluginFileConfigurationHolder.nh());
                                bl2 = true;
                            }
                            if (bl2 || bl3) continue;
                            object = new HashMap();
                            if (configurationSectionBridge.gP("return_items.replace")) {
                                object102 = configurationSectionBridge.hi("return_items.replace");
                                for (Object object92 : object102.getKeys(false)) {
                                    object8 = itemStackRegistry.q((String)object92);
                                    if (object8 == null) {
                                        CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Replace item not found '" + (String)object92 + "'. File: " + pluginFileConfigurationHolder.nh());
                                        continue;
                                    }
                                    object72 = itemStackRegistry.q(object102.getString((String)object92));
                                    if (object72 == null) {
                                        CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Replacement item not found '" + object102.getString((String)object92) + "'. File: " + pluginFileConfigurationHolder.nh());
                                        continue;
                                    }
                                    ((HashMap)object).put(object8, object72);
                                }
                            }
                            object102 = new HashMap();
                            if (configurationSectionBridge.gP("return_items.decrement_durability")) {
                                hashMap = configurationSectionBridge.hi("return_items.decrement_durability");
                                object92 = hashMap.getKeys(false).iterator();
                                while (object92.hasNext()) {
                                    object8 = (String)object92.next();
                                    ((HashMap)object102).put(itemStackRegistry.q(hashMap.getString((String)object8 + ".item")), hashMap.getInt((String)object8 + ".amount"));
                                }
                            }
                            hashMap = new HashMap();
                            if (configurationSectionBridge.gP("return_items.increment_durability")) {
                                object92 = configurationSectionBridge.hi("return_items.increment_durability");
                                for (Object object72 : object92.getKeys(false)) {
                                    hashMap.put(itemStackRegistry.q(object92.getString((String)object72 + ".item")), object92.getInt((String)object72 + ".amount"));
                                }
                            }
                            try {
                                object92 = new ItemStackBridge_35(pluginFileConfigurationHolder, configurationSectionBridge.CM(), configurationSectionBridge.az("permission", null), (HashMap)object, (HashMap)object102, hashMap, new SoundCategoryBridge_3(configurationSectionBridge.az("return_items.play_sound.name", ""), configurationSectionBridge.a("return_items.play_sound.volume", 0.3f), configurationSectionBridge.a("return_items.play_sound.pitch", 1.0f), configurationSectionBridge.az("return_items.play_sound.category", null), configurationSectionBridge.C("return_items.play_sound.stop_previous", true)), (ItemStack)object4, (List)object2);
                                this.Kh.add(new Opaque138((NamespacedKeyItemStackHolder)object92, string2, string3));
                            }
                            catch (Throwable throwable) {
                                CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Failed to load. File: " + pluginFileConfigurationHolder.nh(), throwable);
                            }
                            continue;
                        }
                        int n2 = 0;
                        object2 = configurationSectionBridge.aZ(false).iterator();
                        while (object2.hasNext()) {
                            String string4 = (String)object2.next();
                            if (!string4.startsWith("pattern")) continue;
                            ArrayList<RecipeChoiceItemStackHolder_2> arrayList = new ArrayList<RecipeChoiceItemStackHolder_2>();
                            object = configurationSectionBridge.hi("ingredients");
                            if (object == null) {
                                CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Missing 'ingredients' attribute. File: " + pluginFileConfigurationHolder.nh());
                                continue;
                            }
                            boolean bl4 = false;
                            for (Object object92 : object.getKeys(false)) {
                                object8 = ConfigurationSectionBridge_5.a(itemStackRegistry, (ConfigurationSection)object, (String)object92, string3, pluginFileConfigurationHolder);
                                object72 = (ItemStackBridge_37)((Opaque021)object8).aAX;
                                object6 = (String)((Opaque021)object8).aAY;
                                if (object72 != null) {
                                    arrayList.add(new RecipeChoiceItemStackHolder_2(Character.valueOf(((String)object92).charAt(0)), (ItemStackBridge_37)object72));
                                    continue;
                                }
                                CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Ingredient not found '" + (String)object6 + "'. File: " + pluginFileConfigurationHolder.nh());
                                bl4 = true;
                            }
                            if (bl4) continue;
                            hashMap = new HashMap();
                            if (configurationSectionBridge.gP("return_items.replace")) {
                                object92 = configurationSectionBridge.hi("return_items.replace");
                                for (Object object72 : object92.getKeys(false)) {
                                    object6 = itemStackRegistry.q((String)object72);
                                    if (object6 == null) {
                                        CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Replace item not found '" + (String)object72 + "'. File: " + pluginFileConfigurationHolder.nh());
                                        continue;
                                    }
                                    object52 = itemStackRegistry.q(object92.getString((String)object72));
                                    if (object52 == null) {
                                        CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Replacement item not found '" + object92.getString((String)object72) + "'. File: " + pluginFileConfigurationHolder.nh());
                                        continue;
                                    }
                                    hashMap.put(object6, object52);
                                }
                            }
                            object92 = new HashMap();
                            if (configurationSectionBridge.gP("return_items.decrement_durability")) {
                                object8 = configurationSectionBridge.hi("return_items.decrement_durability");
                                object72 = object8.getKeys(false).iterator();
                                while (object72.hasNext()) {
                                    object6 = (String)object72.next();
                                    ((HashMap)object92).put(itemStackRegistry.q(object8.getString(object6 + ".item")), object8.getInt(object6 + ".amount"));
                                }
                            }
                            object8 = new HashMap();
                            if (configurationSectionBridge.gP("return_items.increment_durability")) {
                                object72 = configurationSectionBridge.hi("return_items.increment_durability");
                                for (Object object52 : object72.getKeys(false)) {
                                    ((HashMap)object8).put(itemStackRegistry.q(object72.getString((String)object52 + ".item")), object72.getInt((String)object52 + ".amount"));
                                }
                            }
                            try {
                                object72 = configurationSectionBridge.hg(string4).toArray(new String[0]);
                                object6 = new ItemStackBridge_35(pluginFileConfigurationHolder, configurationSectionBridge.CM(), configurationSectionBridge.az("permission_suffix", configurationSectionBridge.az("permission", null)), hashMap, (HashMap)object92, (HashMap)object8, new SoundCategoryBridge_3(configurationSectionBridge.az("return_items.play_sound.name", ""), configurationSectionBridge.a("return_items.play_sound.volume", 0.3f), configurationSectionBridge.a("return_items.play_sound.pitch", 1.0f), configurationSectionBridge.az("return_items.play_sound.category", null), configurationSectionBridge.C("return_items.play_sound.stop_previous", true)), (ItemStack)object4, (String[])object72, arrayList);
                                object52 = string3 + "_" + n2;
                                this.Kh.add(new Opaque138((NamespacedKeyItemStackHolder)object6, string2, (String)object52));
                                ++n2;
                            }
                            catch (Throwable throwable) {
                                CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Failed to load. File: " + pluginFileConfigurationHolder.nh(), throwable);
                            }
                        }
                    }
                }
                if (MaterialBarColorHolder.fb) {
                    list = pluginFileConfigurationHolder.gR("recipes.cooking");
                    for (String string3 : list) {
                        configurationSectionBridge = pluginFileConfigurationHolder.hj("recipes.cooking." + string3);
                        if (!configurationSectionBridge.C("enabled", true)) {
                            if (!Main.KO.gY("debug.recipes.log-recipes-loading-disabled")) continue;
                            CommandSenderBridge_5.log("    Ignored disabled cooking recipe: " + string3);
                            continue;
                        }
                        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                            CommandSenderBridge_5.log(String.valueOf(ChatColor.WHITE) + "Loading cooking recipe: " + string3);
                        }
                        for (String string5 : configurationSectionBridge.hg("machines")) {
                            string = configurationSectionBridge.gV("result.item");
                            object4 = itemStackRegistry.q(string);
                            if (object4 == null) {
                                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "[Recipes] '" + string3 + "'. Result item '" + string + "' not found. File " + pluginFileConfigurationHolder.nh());
                                continue;
                            }
                            object4.setAmount(configurationSectionBridge.t("result.amount", 1));
                            object3 = configurationSectionBridge.az("ingredient.item", "");
                            object2 = itemStackRegistry.d((String)object3, pluginFileConfigurationHolder.nh());
                            if (object2 != null) {
                                MaterialBridge_18 materialBridge_18 = new MaterialBridge_18(pluginFileConfigurationHolder, configurationSectionBridge.CM(), configurationSectionBridge.az("permission_suffix", configurationSectionBridge.az("permission", "")), (ItemStack)object4, new RecipeChoiceItemStackHolder(object2), configurationSectionBridge.a("exp", -1.0f), configurationSectionBridge.t("cook_time", 200));
                                Material material = PluginFileConfigurationHolder.b(string5, null);
                                if (material == null) {
                                    CommandSenderBridge_5.error("[Recipes] '" + string3 + "'. Invalid furnace type '" + string5 + "'. File: " + pluginFileConfigurationHolder.nh());
                                    continue;
                                }
                                materialBridge_18.w(material);
                                this.Ki.add(new Opaque138(materialBridge_18, string2, string3));
                                continue;
                            }
                            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "[Recipes] '" + string3 + "'. Ingredient item '" + (String)object3 + "' not found. File " + pluginFileConfigurationHolder.nh());
                        }
                    }
                }
                if (MaterialBarColorHolder.fd) {
                    list = pluginFileConfigurationHolder.gR("recipes.smithing");
                    for (String string3 : list) {
                        String string6;
                        Object object11;
                        String string7;
                        ItemStack itemStack;
                        configurationSectionBridge = pluginFileConfigurationHolder.hj("recipes.smithing." + string3);
                        assert (configurationSectionBridge != null);
                        if (!configurationSectionBridge.C("enabled", true)) {
                            if (!Main.KO.gY("debug.recipes.log-recipes-loading-disabled")) continue;
                            CommandSenderBridge_5.log("    Ignored disabled smithing recipe: " + string3);
                            continue;
                        }
                        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                            CommandSenderBridge_5.log(String.valueOf(ChatColor.WHITE) + "Loading smithing recipe: " + string3);
                        }
                        if ((itemStack = itemStackRegistry.q(string7 = configurationSectionBridge.gV("result.item"))) == null) {
                            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "[Recipes] '" + string3 + "'. Result item '" + string7 + "' not found. File " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                        itemStack.setAmount(configurationSectionBridge.t("result.amount", 1));
                        string = configurationSectionBridge.az("template", "");
                        object4 = itemStackRegistry.d(string, null);
                        if (object4 == null) {
                            CommandSenderBridge_5.warn("[Recipes] '" + string3 + "'. Template item '" + string + "' not found. File " + pluginFileConfigurationHolder.nh());
                        }
                        if ((object2 = itemStackRegistry.d((String)(object3 = configurationSectionBridge.az("base", "")), null)) == null) {
                            CommandSenderBridge_5.warn("[Recipes] '" + string3 + "'. Base item '" + (String)object3 + "' not found. File " + pluginFileConfigurationHolder.nh());
                        }
                        if ((object11 = itemStackRegistry.d(string6 = configurationSectionBridge.az("addition", ""), null)) == null) {
                            CommandSenderBridge_5.warn("[Recipes] '" + string3 + "'. Addition item '" + (String)object3 + "' not found. File " + pluginFileConfigurationHolder.nh());
                        }
                        object = null;
                        if (object2 != null && object11 != null) {
                            object = new ItemStackBridge_41(pluginFileConfigurationHolder, configurationSectionBridge.CM(), configurationSectionBridge.az("permission_suffix", configurationSectionBridge.az("permission", "")), itemStack, new RecipeChoiceItemStackHolder_3(object4), new RecipeChoiceItemStackHolder_3(object2), new RecipeChoiceItemStackHolder_3(object11), new BoolData_3(configurationSectionBridge.C("result.move_attributes.name", false), configurationSectionBridge.C("result.move_attributes.lore", false), configurationSectionBridge.C("result.move_attributes.enchants", true), configurationSectionBridge.C("result.move_attributes.durability", false), configurationSectionBridge.C("result.move_attributes.custom_model_data", false), configurationSectionBridge.C("result.move_attributes.material", false), configurationSectionBridge.C("result.move_attributes.other_nbt", true)));
                        }
                        if (object == null) continue;
                        this.Kj.add(new Opaque138((NamespacedKeyItemStackHolder)object, string2, string3));
                    }
                }
                if (!MaterialBarColorHolder.fc) continue;
                list = pluginFileConfigurationHolder.gR("recipes.anvil_repair");
                for (String string3 : list) {
                    String string8;
                    ItemStack itemStack;
                    configurationSectionBridge = pluginFileConfigurationHolder.hj("recipes.anvil_repair." + string3);
                    if (!configurationSectionBridge.C("enabled", true)) {
                        if (!Main.KO.gY("debug.recipes.log-recipes-loading-disabled")) continue;
                        CommandSenderBridge_5.log("    Ignored disabled anvil_repair recipe: " + string3);
                        continue;
                    }
                    if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
                        CommandSenderBridge_5.log(String.valueOf(ChatColor.WHITE) + "Loading anvil_repair recipe: " + string3);
                    }
                    if ((itemStack = itemStackRegistry.q(string8 = configurationSectionBridge.gV("item"))) == null) {
                        CommandSenderBridge_5.warn("[Recipes] '" + string3 + "'. Result item '" + string8 + "' not found. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    string = configurationSectionBridge.gV("ingredient");
                    object4 = itemStackRegistry.q(string);
                    if (object4 == null) {
                        CommandSenderBridge_5.warn("[Recipes] '" + string3 + "'. Ingredient item '" + string + "' not found. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    object3 = new ItemStackBridge_34(pluginFileConfigurationHolder, configurationSectionBridge.CM(), configurationSectionBridge.az("permission_suffix", configurationSectionBridge.az("permission", "")), itemStack, (ItemStack)object4);
                    prepareAnvilListener.a((ItemStackBridge_34)object3, string2, string3);
                }
            }
        }
    }

    public void a(@Nullable PrepareItemCraftListener prepareItemCraftListener, @Nullable FurnaceStartSmeltListener furnaceStartSmeltListener, @Nullable PrepareSmithingListener prepareSmithingListener) {
        if (!this.Kg) {
            throw new RuntimeException("bro you should first preload the recipes.");
        }
        int n = this.Kh.size() + this.Ki.size() + this.Kj.size();
        CommandSenderBridge_5.log("Registering " + n + " recipes...");
        if (MaterialBarColorHolder.fa) {
            Opaque138.a(prepareItemCraftListener, this.Kh);
        }
        if (MaterialBarColorHolder.fb) {
            Opaque138.a(furnaceStartSmeltListener, this.Ki);
        }
        if (prepareSmithingListener != null && MaterialBarColorHolder.fd) {
            Opaque138.a(prepareSmithingListener, this.Kj);
        }
        this.Kh.clear();
        this.Ki.clear();
        this.Kj.clear();
        ItemStackRegistry.g().aW.qV();
        PlayerHolder_5.vq().g(ItemStackRegistry.g().aW.qZ());
        PlayerHolder_5.vq().vm();
        PlayerHolder_5.vq().vo();
        CommandSenderBridge_5.log("Registered " + n + " recipes.");
    }

    private static Opaque021 a(ItemStackRegistry itemStackRegistry, ConfigurationSection configurationSection, String string, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        String string3;
        ItemStackBridge_37 itemStackBridge_37 = null;
        if (configurationSection.get(string) instanceof MemorySection) {
            String string4;
            string3 = configurationSection.getString(string + ".item", null);
            if (string3 == null) {
                CommandSenderBridge_5.error("[Recipes] '" + string2 + "'. Missing 'item' property for ingredient '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
                return Opaque021.e(itemStackBridge_37, string3);
            }
            Material material = (Material)SoundCategoryBridge.e(string3, Material.class);
            if (material == null) {
                CommandSenderBridge_5.error("[Recipes] '" + string2 + "'. Item '" + string3 + "' not found for ingredient '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
                return Opaque021.e(itemStackBridge_37, string3);
            }
            if ((material == Material.POTION || material == Material.SPLASH_POTION) && (string4 = configurationSection.getString(string + ".potion_type", null)) != null) {
                PotionType potionType = PluginFileConfigurationHolder.gL(string4);
                if (potionType == null) {
                    CommandSenderBridge_5.error("[Recipes] '" + string2 + "'. Invalid potion type '" + string4 + "' for ingredient '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
                    return Opaque021.e(itemStackBridge_37, string3);
                }
                ItemStack itemStack = new ItemStack(material);
                PotionMeta potionMeta = (PotionMeta)itemStack.getItemMeta();
                potionMeta.setBasePotionType(potionType);
                itemStack.setItemMeta((ItemMeta)potionMeta);
                itemStackBridge_37 = new ItemStackBridge_39(itemStack);
            }
        } else {
            string3 = configurationSection.getString(string);
        }
        if (itemStackBridge_37 == null) {
            itemStackBridge_37 = itemStackRegistry.n(string3);
        }
        return Opaque021.e(itemStackBridge_37, string3);
    }
}
