package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.google.common.collect.ImmutableMap;
import dev.lone.itemsadder.Core.OtherPlugins.ExecutableItems.ExecutableItemsHook;
import dev.lone.itemsadder.Core.OtherPlugins.enchants.AeWrapper;
import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.f;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.BarColorBarStyleHolder;
import itemsadder.m.BiomeHolder;
import itemsadder.m.BoolData_2;
import itemsadder.m.BoolDoubleData;
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.Builder_15;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ComponentsNbtFile;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ConfigurationSectionBridge_3;
import itemsadder.m.Consumable;
import itemsadder.m.Durability;
import itemsadder.m.Error_2;
import itemsadder.m.HeadEnum;
import itemsadder.m.HiddenEnum;
import itemsadder.m.ItemStackBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_32;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_13;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBridge_13;
import itemsadder.m.MaterialBridge_14;
import itemsadder.m.MaterialBridge_15;
import itemsadder.m.MaterialBridge_9;
import itemsadder.m.NamespacedKeyBridge_3;
import itemsadder.m.Opaque131;
import itemsadder.m.Opaque133;
import itemsadder.m.Opaque140;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PermissibleBridge_4;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfString_2;
import itemsadder.m.RecordOfValue_26;
import itemsadder.m.ReplaceEnum_2;
import itemsadder.m.Resource;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.SpecificPropertiesPotion;
import itemsadder.m.WorldBridge_4;
import itemsadder.m.YamlConfigurationBridge_2;
import itemsadder.m.rlSwitchMap_2;
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

public class ConfigurationSectionBridge_4 {
    private final ItemStackRegistry JY;
    HashMap JZ = new HashMap();
    public boolean Ka = false;

    public ConfigurationSectionBridge_4(ItemStackRegistry itemStackRegistry) {
        this.JY = itemStackRegistry;
    }

    public void aR() {
        List list;
        String string2;
        HashMap<CallSite, Object> hashMap = new HashMap<CallSite, Object>();
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : this.JY.b()) {
            string2 = pluginFileConfigurationHolder.gV("info.namespace");
            list = pluginFileConfigurationHolder.gR("items");
            if (list == null) continue;
            for (Iterator iterator : list) {
                boolean bl;
                Object object = pluginFileConfigurationHolder.hj("items." + (String)((Object)iterator));
                assert (object != null);
                if (!((ConfigurationSectionBridge)object).C("enabled", true) || !(bl = ((ConfigurationSectionBridge)object).C("template", false))) continue;
                hashMap.put((CallSite)((Object)(string2 + ":" + (String)((Object)iterator))), object);
            }
        }
        this.JY.a(hashMap);
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : this.JY.b()) {
            Opaque133 opaque1332;
            int n;
            ConfigurationSectionBridge configurationSectionBridge;
            string2 = pluginFileConfigurationHolder.gV("info.namespace");
            this.JY.Z.add(string2);
            list = pluginFileConfigurationHolder.gR("items");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No item found in file " + pluginFileConfigurationHolder.qd());
                continue;
            }
            BossBarBridge_2.bf("Items '" + string2 + "'...");
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
                configurationSectionBridge = pluginFileConfigurationHolder.hj("items." + (String)object);
                assert (configurationSectionBridge != null);
                if (!configurationSectionBridge.C("enabled", true)) {
                    if (!Main.KO.gY("debug.items.log-items-loading-disabled")) continue;
                    CommandSenderBridge_5.log("    Ignored disabled item: " + (String)object + ", namespace: " + string2);
                    continue;
                }
                n = configurationSectionBridge.C("template", false);
                if (n != 0) continue;
                if (Main.KO.gY("debug.items.log-items-loading")) {
                    CommandSenderBridge_5.log("    Loading item: " + (String)object);
                }
                configurationSectionBridge = ConfigurationSectionBridge_4.a(pluginFileConfigurationHolder, configurationSectionBridge, hashMap, string2, (String)object);
                if (!r.ex((String)object)) {
                    CommandSenderBridge_5.error("[Items] Non [a-z0-9_.-] character in custom item name '" + string2 + ":" + (String)object + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    r.ym();
                    continue;
                }
                if ((configurationSectionBridge.fo("resource") ? 1 : 0) + (configurationSectionBridge.fo("graphics") ? 1 : 0) + (configurationSectionBridge.fo("item_model") ? 1 : 0) > 1) {
                    CommandSenderBridge_5.error("[Items] '" + string2 + ":" + (String)object + "'. Error: 'resource', 'graphics' and 'item_model' properties are mutually exclusive. Please use only one of them. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                opaque1332 = configurationSectionBridge.a("resource.material", configurationSectionBridge.gZ("material"));
                String string3 = configurationSectionBridge.az("name", configurationSectionBridge.az("display_name", ConfigurationSectionBridge_4.ci((String)object)));
                Component component = this.JY.bg.ah(string3);
                ItemStackBuilder_4 itemStackBuilder_42 = null;
                if (MaterialBridge_15.c(configurationSectionBridge)) {
                    RecordOfValue_26 recordOfValue_26 = MaterialBridge_15.a((Material)opaque1332, configurationSectionBridge, pluginFileConfigurationHolder, string2, (String)object);
                    if (recordOfValue_26 == null) continue;
                    itemStackBuilder_42 = recordOfValue_26.pu();
                    bl = recordOfValue_26.pv();
                    opaque1332 = recordOfValue_26.pw();
                }
                boolean bl2 = false;
                boolean bl3 = false;
                if (opaque1332 == null) {
                    opaque1332 = Material.PAPER;
                    bl2 = true;
                    bl3 = true;
                }
                if (itemStackBuilder_42 == null) {
                    block108: {
                        if (!opaque1332.isItem()) {
                            CommandSenderBridge_5.error("[Items] '" + string2 + ":" + (String)object + "' - Error: Material " + String.valueOf(ChatColor.AQUA) + String.valueOf(opaque1332) + String.valueOf(ChatColor.RED) + " is not an obtainable material. File: " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                        if (opaque1332 == Material.BOW) {
                            itemStackBuilder_42 = new BoolDoubleData(pluginFileConfigurationHolder, string2, (String)object, (Material)opaque1332, configurationSectionBridge.C("specific_properties.bow.glow_arrows", false), configurationSectionBridge.C("specific_properties.bow.fire_arrows", false), configurationSectionBridge.b("specific_properties.bow.arrow_damage", -1.0));
                        } else if (opaque1332 == Material.CROSSBOW) {
                            itemStackBuilder_42 = new BoolData_2(pluginFileConfigurationHolder, string2, (String)object, (Material)opaque1332, configurationSectionBridge.C("specific_properties.crossbow.glow_arrows", false), configurationSectionBridge.C("specific_properties.crossbow.fire_arrows", false), configurationSectionBridge.b("specific_properties.crossbow.arrow_damage", -1.0), configurationSectionBridge.C("specific_properties.crossbow.multishot", false), configurationSectionBridge.C("specific_properties.crossbow.firework", false));
                        } else {
                            if (MaterialBridge_13.c(configurationSectionBridge)) {
                                try {
                                    if (!bl3 && opaque1332 == Material.PAPER && MaterialBarColorHolder.eS) {
                                        bl2 = true;
                                    }
                                    itemStackBuilder_42 = MaterialBridge_13.a(configurationSectionBridge, pluginFileConfigurationHolder, string2, (String)object, (Material)opaque1332, bl2);
                                    break block108;
                                }
                                catch (IllegalStateException illegalStateException) {
                                    CommandSenderBridge_5.error(illegalStateException.getMessage());
                                    continue;
                                }
                            }
                            if (configurationSectionBridge.gP("specific_properties.seed.crop_block")) {
                                itemStackBuilder_42 = new MaterialBridge_9(pluginFileConfigurationHolder, string2, (String)object, (Material)opaque1332, configurationSectionBridge.gZ("specific_properties.seed.crop_block"));
                                this.JY.I.put(itemStackBuilder_42.Gh, (MaterialBridge_9)itemStackBuilder_42);
                                object8 = new ArrayList();
                                for (Serializable serializable2 : configurationSectionBridge.gR("specific_properties.seed.results")) {
                                    object7 = new ItemStackBridge_32(configurationSectionBridge.t("specific_properties.seed.results." + (String)((Object)serializable2) + ".min_amount", 1), configurationSectionBridge.t("specific_properties.seed.results." + (String)((Object)serializable2) + ".max_amount", 1), configurationSectionBridge.a("specific_properties.seed.results." + (String)((Object)serializable2) + ".chance", 100.0f), configurationSectionBridge.C("specific_properties.seed.results." + (String)((Object)serializable2) + ".ignore_fortune", false));
                                    ((MaterialBridge_9)itemStackBuilder_42).a((ItemStackBridge_32)object7);
                                    object62 = configurationSectionBridge.gV("specific_properties.seed.results." + (String)((Object)serializable2) + ".item");
                                    object8.add(object62);
                                }
                                this.JZ.put(itemStackBuilder_42.getNamespacedID(), object8);
                            } else {
                                itemStackBuilder_42 = new ItemStackBuilder_4(pluginFileConfigurationHolder, string2, (String)object, (Material)opaque1332);
                            }
                        }
                    }
                    if (Consumable.c(configurationSectionBridge)) {
                        Consumable.a(itemStackBuilder_42, configurationSectionBridge, pluginFileConfigurationHolder, string2, (String)object);
                    }
                }
                if (configurationSectionBridge.gP("tooltip_style")) {
                    try {
                        if (!Version.isAtLeast((Version)Version.v1_21_3)) {
                            throw new Error_2("[Items] '" + string2 + ":" + (String)object + "'. Error: 'tooltip_style' is only available in 1.21.2+. File: " + pluginFileConfigurationHolder.nh());
                        }
                        object8 = PluginFileConfigurationHolder.a(configurationSectionBridge.gV("tooltip_style"), string2, false, arg_0 -> ConfigurationSectionBridge_4.a(string2, (String)object, pluginFileConfigurationHolder, arg_0));
                        if (object8 != null) {
                            object5 = ItemStackRegistry.s(ItemStackRegistry.g(null, String.valueOf(object8) + "_background"));
                            if (object5 == null) {
                                throw new Error_2("Can't find background '" + String.valueOf(object8) + "' texture file for item '" + itemStackBuilder_42.getNamespacedID() + "'. File: " + pluginFileConfigurationHolder.nh());
                            }
                            serializable2 = ItemStackRegistry.s(ItemStackRegistry.g(null, String.valueOf(object8) + "_frame"));
                            if (serializable2 == null) {
                                throw new Error_2("Can't find frame '" + String.valueOf(object8) + "' texture file for item '" + itemStackBuilder_42.getNamespacedID() + "'. File: " + pluginFileConfigurationHolder.nh());
                            }
                            itemStackBuilder_42.b((NamespacedKey)object8);
                            ItemStackRegistry.g().G().add(object8);
                        }
                    }
                    catch (Error_2 error_2) {
                        CommandSenderBridge_5.error(error_2.getMessage());
                    }
                }
                if (NamespacedKeyBridge_3.c(configurationSectionBridge) && !ConfigurationSectionBridge_3.c(configurationSectionBridge)) {
                    try {
                        NamespacedKeyBridge_3.a(itemStackBuilder_42, configurationSectionBridge, pluginFileConfigurationHolder, string2, (String)object);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        CommandSenderBridge_5.error("[Items] '" + string2 + ":" + (String)object + "'. " + illegalArgumentException.getMessage());
                    }
                }
                if (configurationSectionBridge.gP("jukebox_disc")) {
                    if (!Version.isAtLeast((Version)Version.v1_21_1)) {
                        CommandSenderBridge_5.error("[Items] '" + string2 + ":" + (String)object + "'. Error: 'jukebox_playable' is only available in 1.21.1+. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    object8 = PluginFileConfigurationHolder.a(configurationSectionBridge.gV("jukebox_disc.song"), string2, false, arg_0 -> ConfigurationSectionBridge_4.e(string2, (String)object, pluginFileConfigurationHolder, arg_0));
                    if (object8 != null) {
                        itemStackBuilder_42.c((NamespacedKey)object8);
                    }
                }
                itemStackBuilder_42.b(configurationSectionBridge);
                itemStackBuilder_42.c(component);
                itemStackBuilder_42.b(component);
                if (ComponentsNbtFile.c(configurationSectionBridge)) {
                    ComponentsNbtFile.a(itemStackBuilder_42, configurationSectionBridge, pluginFileConfigurationHolder);
                }
                if (Durability.c(configurationSectionBridge) && !Durability.b(itemStackBuilder_42, configurationSectionBridge, pluginFileConfigurationHolder, string2, (String)object) || !Resource.b(itemStackBuilder_42, configurationSectionBridge, pluginFileConfigurationHolder, string2, (String)object)) continue;
                if (ConfigurationSectionBridge_3.c(configurationSectionBridge)) {
                    try {
                        ConfigurationSectionBridge_3.a(itemStackBuilder_42, configurationSectionBridge, pluginFileConfigurationHolder, string2, (String)object);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        CommandSenderBridge_5.error("[Items] '" + string2 + ":" + (String)object + "'. Error: " + illegalArgumentException.getMessage());
                        continue;
                    }
                }
                if (SpecificPropertiesPotion.r(itemStackBuilder_42)) {
                    SpecificPropertiesPotion.a(itemStackBuilder_42, configurationSectionBridge, pluginFileConfigurationHolder);
                } else if (itemStackBuilder_42.getType() == Material.LEATHER_HORSE_ARMOR) {
                    object8 = configurationSectionBridge.az("specific_properties.leather_horse_armor.color", "WHITE");
                    int n3 = ColorBridge.iN((String)object8);
                    if (n3 == -1) {
                        CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_42.getNamespacedID() + "'. Missing leather_horse_armor.color '" + (String)object8 + "'. File: " + pluginFileConfigurationHolder.nh());
                    }
                    itemStackBuilder_42.Gv = configurationSectionBridge.C("specific_properties.leather_horse_armor.can_be_recolored_in_crafting_table", false);
                    serializable2 = (LeatherArmorMeta)itemStackBuilder_42.getItemMeta();
                    serializable2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "generic.armor", 0.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.BODY));
                    serializable2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                    if (n3 != -1) {
                        serializable2.setColor(Color.fromRGB((int)n3));
                    }
                    serializable2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_DYE});
                    itemStackBuilder_42.setItemMeta((ItemMeta)serializable2);
                } else if (itemStackBuilder_42.getType() == Material.WRITTEN_BOOK) {
                    ItemStackBridge.f(itemStackBuilder_42, PluginBridge_6.u(component));
                    ItemStackBridge.e(itemStackBuilder_42, configurationSectionBridge.az("specific_properties.book.author", " "));
                    ItemStackBridge.a(itemStackBuilder_42, BookMeta.Generation.valueOf((String)configurationSectionBridge.az("specific_properties.book.generation", "TATTERED")));
                    if (configurationSectionBridge.gP("specific_properties.book.pages")) {
                        ItemStackBridge.c(itemStackBuilder_42, configurationSectionBridge.hV("specific_properties.book.pages"));
                    } else {
                        ItemStackBridge.c(itemStackBuilder_42, new ArrayList());
                    }
                }
                itemStackBuilder_42.bK(configurationSectionBridge.az("permission_suffix", configurationSectionBridge.gV("permission")));
                itemStackBuilder_42.i(configurationSectionBridge.t("events_cooldown", configurationSectionBridge.t("events_settings.cooldown.ticks", -1)));
                object8 = configurationSectionBridge.az("events_settings.cooldown.indicator", "TITLE");
                object5 = (HiddenEnum)SoundCategoryBridge.b((String)object8, HiddenEnum.class, HiddenEnum.VANILLA);
                if (object5 == HiddenEnum.VANILLA && Version.isOlderThan((Version)Version.v1_21_3)) {
                    object5 = HiddenEnum.HIDDEN;
                }
                if (!Main.KO.gY("huds.enabled")) {
                    object5 = HiddenEnum.HIDDEN;
                }
                switch (rlSwitchMap_2.Kc[((Enum)object5).ordinal()]) {
                    case 1: {
                        if (!Main.KO.gY("huds.enabled")) break;
                        serializable2 = null;
                        object7 = configurationSectionBridge.gV("events_settings.cooldown.custom_hud");
                        if (object7 == null) {
                            object7 = "_iainternal:small_cooldown_bar";
                        }
                        if ((object62 = (WorldBridge_4)this.JY.am.vF.get(object7)) instanceof PlayerBridge_8) {
                            serializable2 = Float.valueOf(((PlayerBridge_8)object62).jZ());
                        }
                        if (object62 != null) {
                            itemStackBuilder_42.a(new BarColorBarStyleHolder((HiddenEnum)((Object)object5), (String)object7, (Float)serializable2));
                            break;
                        }
                        CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_42.getNamespacedID() + "'. Unknown cooldown hud '" + object7 + "'. File: " + pluginFileConfigurationHolder.nh());
                        break;
                    }
                    case 2: {
                        serializable2 = (BarColor)configurationSectionBridge.a("events_settings.cooldown.bossbar.color", BarColor.class, (Enum)MaterialBarColorHolder.fh);
                        object7 = (BarStyle)configurationSectionBridge.a("events_settings.cooldown.bossbar.style", BarStyle.class, (Enum)MaterialBarColorHolder.fi);
                        itemStackBuilder_42.a(new BarColorBarStyleHolder((HiddenEnum)((Object)object5), (BarColor)serializable2, (BarStyle)object7));
                        break;
                    }
                    default: {
                        itemStackBuilder_42.a(new BarColorBarStyleHolder((HiddenEnum)((Object)object5)));
                    }
                }
                itemStackBuilder_42.bH(configurationSectionBridge.az("all_actions_permission", null));
                if (configurationSectionBridge.gP("events_needed_player_stats")) {
                    serializable2 = configurationSectionBridge.hi("events_needed_player_stats");
                    for (Object object62 : serializable2.getKeys(false)) {
                        itemStackBuilder_42.s((String)object62, serializable2.getString((String)object62));
                    }
                }
                if (configurationSectionBridge.C("drop.glow.enabled", false) && (serializable2 = configurationSectionBridge.az("drop.glow.color", null)) != null) {
                    itemStackBuilder_42.bO((String)((Object)serializable2));
                }
                itemStackBuilder_42.ar(configurationSectionBridge.C("drop.show_name", false));
                if (configurationSectionBridge.gP("enchants")) {
                    serializable2 = new HashMap();
                    object7 = (ArrayList)configurationSectionBridge.hg("enchants");
                    object62 = ((ArrayList)object7).iterator();
                    while (object62.hasNext()) {
                        object4 = (String)object62.next();
                        object3 = ((String)object4).split(":");
                        object2 = null;
                        int n4 = 1;
                        ItemFlag itemFlag = object3[0];
                        if (((ItemFlag)object3).length == 1) {
                            object2 = SoundCategoryBridge.ij((String)itemFlag);
                        } else if (((ItemFlag)object3).length == 2) {
                            if (ColorBridge.iJ((String)object3[1])) {
                                object2 = SoundCategoryBridge.ij((String)itemFlag);
                                n4 = ColorBridge.w((String)object3[1], 1);
                            } else {
                                object2 = Enchantment.getByKey((NamespacedKey)new NamespacedKey((String)itemFlag, (String)object3[1]));
                            }
                        } else if (((ItemFlag)object3).length == 3) {
                            object2 = Enchantment.getByKey((NamespacedKey)new NamespacedKey((String)itemFlag, (String)object3[1]));
                            n4 = ColorBridge.w((String)object3[2], 1);
                        }
                        if (object2 == null) {
                            if (Main.PJ && MaterialBarColorHolder.eW) {
                                try {
                                    if (!AeWrapper.isCustomEnchant((String)itemFlag)) continue;
                                    AeWrapper.applyEnchant(itemStackBuilder_42, (String)itemFlag, n4);
                                    itemStackBuilder_42.mZ();
                                }
                                catch (Throwable throwable) {
                                    CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_42.getNamespacedID() + "'. Error applying AdvancedEnchantments enchant '" + (String)itemFlag + "'.", throwable);
                                }
                                continue;
                            }
                            CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_42.getNamespacedID() + "'. Unknown vanilla/custom enchant '" + (String)itemFlag + "'. File: " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                        serializable2.put(object2, n4);
                    }
                    itemStackBuilder_42.addUnsafeEnchantments((Map)((Object)serializable2));
                    itemStackBuilder_42.c(ImmutableMap.copyOf(serializable2));
                    itemStackBuilder_42.mZ();
                }
                if (configurationSectionBridge.gP("lore")) {
                    serializable2 = new ArrayList();
                    for (Object object62 : configurationSectionBridge.hg("lore")) {
                        object4 = this.JY.bg.ai((String)object62);
                        serializable2.add(object4);
                    }
                    ItemStackBridge_2.a(itemStackBuilder_42.mQ(), serializable2);
                    itemStackBuilder_42.na();
                }
                boolean bl4 = false;
                if (configurationSectionBridge.gP("item_flags")) {
                    object7 = new HashSet();
                    object62 = configurationSectionBridge.hg("item_flags").iterator();
                    while (object62.hasNext()) {
                        object4 = (String)object62.next();
                        object3 = SoundCategoryBridge.ic((String)object4);
                        if (object3 != null) {
                            object7.add(object3);
                            continue;
                        }
                        CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_42.getNamespacedID() + "'.  Unknown item flag '" + (String)object4 + "'. File: " + pluginFileConfigurationHolder.nh());
                    }
                    if (object7.contains(ItemFlag.HIDE_ATTRIBUTES)) {
                        bl4 = true;
                    }
                    itemStackBuilder_42.b((Set)object7);
                }
                if (!configurationSectionBridge.gP("attribute_modifiers")) {
                    if (Main.KO.gY("debug.recipes.log-attribute-modifiers-loading")) {
                        CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No attribute_modifiers found for item " + itemStackBuilder_42.getNamespacedID());
                    }
                } else {
                    object7 = configurationSectionBridge.hi("attribute_modifiers");
                    if (object7 != null) {
                        ConfigurationSectionBridge_4.a(itemStackBuilder_42, (ConfigurationSection)object7);
                    }
                }
                if (bl4 && !Version.isAtLeast((Version)Version.v1_21_5)) {
                    PlayerHolder_2.tX().ab(itemStackBuilder_42);
                }
                if (configurationSectionBridge.C("auto_update.enabled", MaterialBarColorHolder.fI)) {
                    object7 = Opaque131.oE().au(configurationSectionBridge.C("auto_update.fix_unstackable_items_on_click", MaterialBarColorHolder.fK)).a((ReplaceEnum_2)configurationSectionBridge.a("auto_update.enchantment_mode", ReplaceEnum_2.class, MaterialBarColorHolder.fJ));
                    itemStackBuilder_42.a(((Builder_15)object7).oI());
                }
                itemStackBuilder_42.h(configurationSectionBridge.c("max_stack_size", (Integer)null));
                itemStackBuilder_42.al(configurationSectionBridge.C("fire_resistant", false));
                itemStackBuilder_42.am(configurationSectionBridge.C("hide_tooltip", false));
                itemStackBuilder_42.ah(configurationSectionBridge.t("durability.repair_cost", 0));
                object7 = configurationSectionBridge.a("glint", configurationSectionBridge.a("enchantment_glint_override", (Boolean)null));
                if (object7 != null) {
                    itemStackBuilder_42.an((Boolean)object7);
                }
                if ((n2 = configurationSectionBridge.t("durability.usages", -1)) != -1) {
                    itemStackBuilder_42.ag(n2);
                    itemStackBuilder_42.af(n2);
                    itemStackBuilder_42.mY();
                }
                MmoItemsHook.injectMmoItem(itemStackBuilder_42, configurationSectionBridge.az("mmoitem.type", null), configurationSectionBridge.az("mmoitem.id", null), configurationSectionBridge.C("mmoitem.use_mmoitem_displayname", false));
                if (Main.PI && (object4 = configurationSectionBridge.az("executableitem.id", null)) != null) {
                    try {
                        object3 = ExecutableItemsHook.getExecutableItem((String)object4);
                        itemStackBuilder_42.r((ItemStack)object3);
                    }
                    catch (NullPointerException nullPointerException) {
                        CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_42.getNamespacedID() + "'. Error loading ExecutableItems. Please check if the ExecutableItem of id '" + (String)object4 + "' exists in ExecutableItems plugin. File: " + pluginFileConfigurationHolder.nh());
                    }
                }
                if (!(itemStackBuilder_42.ng() || itemStackBuilder_42.nc() && itemStackBuilder_42.fX() != 0)) {
                    if (!configurationSectionBridge.gP("resource.model_id") && !configurationSectionBridge.gP("resource.custom_model_data")) {
                        itemStackBuilder_42.ae(f.xl().a((Material)opaque1332, string2, (String)object));
                    } else {
                        itemStackBuilder_42.ae(f.xl().a((Material)opaque1332, string2, (String)object, configurationSectionBridge.t("resource.custom_model_data", configurationSectionBridge.gW("resource.model_id")), false, pluginFileConfigurationHolder.nh()));
                    }
                }
                if (Main.KO.gY("debug.items.log-items-loading")) {
                    CommandSenderBridge_5.log("      Assigned custom_model_data: " + itemStackBuilder_42.fX());
                }
                if (configurationSectionBridge.gP("blocked_enchants")) {
                    object4 = new ArrayList();
                    object3 = (ArrayList)configurationSectionBridge.hg("blocked_enchants");
                    object2 = ((ArrayList)object3).iterator();
                    while (object2.hasNext()) {
                        String string4 = (String)object2.next();
                        if (string4.equalsIgnoreCase("all")) {
                            itemStackBuilder_42.aq(true);
                            break;
                        }
                        ((ArrayList)object4).add(Enchantment.getByName((String)string4));
                    }
                    itemStackBuilder_42.a((ArrayList)object4);
                }
                itemStackBuilder_42.as(configurationSectionBridge.C("show_in_ia_gui", true));
                if (MaterialBarColorHolder.fj) {
                    PermissibleBridge_2.z(itemStackBuilder_42);
                }
                if (MaterialBarColorHolder.fk) {
                    PermissibleBridge_4.z(itemStackBuilder_42);
                }
                ItemStackBuilder_4.m(itemStackBuilder_42);
                this.JY.C.put(itemStackBuilder_42.getNamespacedID(), itemStackBuilder_42);
                this.JY.E.put(itemStackBuilder_42.getId(), itemStackBuilder_42);
                this.JY.D.put(itemStackBuilder_42.Gi, itemStackBuilder_42);
                this.JY.N.computeIfAbsent(itemStackBuilder_42.getType(), material -> new ArrayList()).add(itemStackBuilder_42);
                this.JY.O.computeIfAbsent(itemStackBuilder_42.getType(), material -> new HashMap()).put(itemStackBuilder_42.getNamespacedID(), itemStackBuilder_42);
                this.JY.M.computeIfAbsent(itemStackBuilder_42.getNamespace(), string -> new HashMap()).put(itemStackBuilder_42.getId(), itemStackBuilder_42);
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                CommandSenderBridge_5.log("Loaded item: " + itemStackBuilder_42.getNamespacedID());
            }
            if (bl) {
                pluginFileConfigurationHolder.save();
                pluginFileConfigurationHolder.reload();
            }
            if (!pluginFileConfigurationHolder.gP("liquids")) continue;
            if (MaterialBarColorHolder.cS) {
                for (Object object : pluginFileConfigurationHolder.gR("liquids")) {
                    configurationSectionBridge = pluginFileConfigurationHolder.hi("liquids." + (String)object);
                    n = ColorBridge.iN(configurationSectionBridge.getString("color"));
                    opaque1332 = new Opaque133(string2, (String)object, n);
                    this.JY.af.put(opaque1332.getNamespacedID(), opaque1332);
                    if (!Main.KO.gY("debug.other.log-liquids-loading")) continue;
                    CommandSenderBridge_5.log("Loaded liquid: " + opaque1332.getNamespacedID());
                }
                continue;
            }
            CommandSenderBridge_5.warn("Liquids load skipped. Enable them in config.yml if you want to load them. File: " + pluginFileConfigurationHolder.nh());
        }
        f.xl().xt();
        LocationBridge_13.pi();
        if (this.JY.m()) {
            this.JY.C.forEach((string, itemStackBuilder_4) -> this.JY.a((Plugin)null, (ItemStackBuilder_4)itemStackBuilder_4));
        }
        ArrayList<RecordOfString_2> arrayList = new ArrayList<RecordOfString_2>(this.JY.af.values().stream().map(opaque133 -> new RecordOfString_2(opaque133.getNamespace(), opaque133.getId(), opaque133.getColor())).toList());
        this.Ka = BiomeHolder.tG().z(arrayList);
    }

    @NotNull
    public static ConfigurationSectionBridge a(PluginFileConfigurationHolder pluginFileConfigurationHolder, ConfigurationSectionBridge configurationSectionBridge, Map map, String string2, String string3) {
        String string4 = configurationSectionBridge.az("variant_of", null);
        if (string4 != null) {
            ConfigurationSectionBridge configurationSectionBridge2 = (ConfigurationSectionBridge)map.get(string4 = Opaque140.i(string4, string2));
            if (configurationSectionBridge2 != null) {
                try {
                    YamlConfiguration yamlConfiguration = YamlConfigurationBridge_2.f(configurationSectionBridge2);
                    YamlConfiguration yamlConfiguration2 = YamlConfigurationBridge_2.f(configurationSectionBridge);
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
                    return new ConfigurationSectionBridge((ConfigurationSection)yamlConfiguration2);
                }
                catch (InvalidConfigurationException invalidConfigurationException) {
                    throw new RuntimeException(invalidConfigurationException);
                }
            }
            CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown template '" + string4 + "'. File: " + pluginFileConfigurationHolder.nh());
            throw new IllegalArgumentException("Unknown template  '" + string4 + "'. File: " + pluginFileConfigurationHolder.nh());
        }
        return configurationSectionBridge;
    }

    public void ps() {
        for (ItemStackBuilder_4 itemStackBuilder_4 : this.JY.F.values()) {
            itemStackBuilder_4.Ge.a(this.JY);
        }
        for (ItemStackBuilder_4 itemStackBuilder_4 : this.JY.F.values()) {
            itemStackBuilder_4.Gd.b(this.JY);
        }
        for (ItemStackBuilder_4 itemStackBuilder_4 : this.JY.C.values()) {
            itemStackBuilder_4.Ge.a(this.JY);
        }
        for (ItemStackBuilder_4 itemStackBuilder_4 : this.JY.C.values()) {
            itemStackBuilder_4.Gd.b(this.JY);
            this.q(itemStackBuilder_4);
            this.p(itemStackBuilder_4);
        }
        for (ItemStackBuilder_4 itemStackBuilder_4 : new ArrayList(ItemStackRegistry.g().S)) {
            MaterialBridge_14.d((LocationBridgeBuilder_2)itemStackBuilder_4);
        }
    }

    public void p(ItemStackBuilder_4 itemStackBuilder_4) {
        if (itemStackBuilder_4 instanceof MaterialBridge_9) {
            if (!this.JZ.containsKey(itemStackBuilder_4.getNamespacedID())) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Seed '" + itemStackBuilder_4.getNamespacedID() + "' has no results (file '" + itemStackBuilder_4.nh() + "' )");
                return;
            }
            int n = 0;
            for (String string : (List)this.JZ.get(itemStackBuilder_4.getNamespacedID())) {
                ItemStack itemStack = this.JY.q(string);
                if (itemStack == null) {
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Seed '" + itemStackBuilder_4.getNamespacedID() + "' has unknown item result '" + string + "'. File: " + itemStackBuilder_4.nh());
                    continue;
                }
                ((ItemStackBridge_32)((MaterialBridge_9)itemStackBuilder_4).nD().get(n)).M(itemStack);
                ++n;
            }
            ((MaterialBridge_9)itemStackBuilder_4).nD().removeIf(itemStackBridge_32 -> itemStackBridge_32.getItemStack() == null);
        }
    }

    public void q(ItemStackBuilder_4 itemStackBuilder_4) {
        if ((itemStackBuilder_4.np().gP("behaviours.block.placed_model.break_particles_material") || itemStackBuilder_4.np().gP("specific_properties.block.placed_model.break_particles_material")) && itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
            String string = itemStackBuilder_4.np().az("behaviours.block.placed_model.break_particles_material", itemStackBuilder_4.np().az("specific_properties.block.placed_model.break_particles_material", ""));
            assert (string != null);
            if (SoundCategoryBridge.d(string.toUpperCase(), Material.class)) {
                if (Material.valueOf((String)string.toUpperCase()).isBlock()) {
                    ((LocationBridgeBuilder_2)itemStackBuilder_4).FD.n(Material.valueOf((String)string.toUpperCase()));
                } else {
                    CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Invalid break_particles_material '" + string + "' for item '" + itemStackBuilder_4.getNamespacedID() + "'. It's an ITEM, not a BLOCK. Please use a BLOCK material name. File: " + itemStackBuilder_4.nh());
                }
            } else if (this.JY.f(string)) {
                ((LocationBridgeBuilder_2)itemStackBuilder_4).FD.n(this.JY.e(string));
            } else {
                CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Invalid break_particles_material '" + string + "' for item '" + itemStackBuilder_4.getNamespacedID() + "' please make sure it's a vanilla material or a custom item. File: " + itemStackBuilder_4.nh());
            }
        }
    }

    static void a(ItemStackBuilder_4 itemStackBuilder_4, @NotNull ConfigurationSection configurationSection) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = itemStackBuilder_4.b(ItemFlag.HIDE_ATTRIBUTES);
        for (String string : configurationSection.getKeys(false)) {
            ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection(string);
            Set set = configurationSection2.getKeys(true);
            for (String string2 : set) {
                if (!ConfigurationSectionBridge_4.a(itemStackBuilder_4, string, string2, configurationSection2)) continue;
                if (string2.contains("attackDamage") || string2.contains("attack_damage")) {
                    bl2 = true;
                }
                if (!string2.contains("attackSpeed") && !string2.contains("attack_speed")) continue;
                bl = true;
            }
        }
        if (MaterialBarColorHolder.eg && !bl3 && ItemStackBridge_2.ae(itemStackBuilder_4) && (bl2 || bl)) {
            PlayerHolder_2.tX().ab(itemStackBuilder_4);
            ItemStackBuilder_4.a(itemStackBuilder_4, HeadEnum.MAINHAND);
        }
    }

    static boolean a(ItemStackBuilder_4 itemStackBuilder_4, String string, String string2, ConfigurationSection configurationSection) {
        String string3;
        double d;
        if (string2.endsWith("operation") || string2.endsWith("value")) {
            return false;
        }
        Object object = configurationSection.get(string2);
        if (object instanceof ConfigurationSection) {
            ConfigurationSection configurationSection2 = (ConfigurationSection)object;
            if (!configurationSection2.contains("value")) {
                return false;
            }
            d = configurationSection2.getDouble("value", 0.0);
            string3 = configurationSection2.getString("operation", "add");
        } else {
            d = configurationSection.getDouble(string2, 0.0);
            string3 = "add";
        }
        itemStackBuilder_4.a(string2, string, d, string3);
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

    private static /* synthetic */ void e(String string, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string3) {
        CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'jukebox_disc.song' value '" + string3 + "'. File: " + pluginFileConfigurationHolder.nh());
    }

    private static /* synthetic */ void a(String string, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string3) {
        CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Invalid 'tooltip_style' value '" + string3 + "'. File: " + pluginFileConfigurationHolder.nh());
    }
}
