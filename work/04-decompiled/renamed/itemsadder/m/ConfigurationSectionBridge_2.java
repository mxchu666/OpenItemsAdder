package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BlockBridge_10;
import itemsadder.m.Builder_14;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.Consumer_3;
import itemsadder.m.EffectBridge;
import itemsadder.m.EventBridge_10;
import itemsadder.m.EventBridge_11;
import itemsadder.m.EventBridge_12;
import itemsadder.m.EventBridge_4;
import itemsadder.m.EventBridge_5;
import itemsadder.m.EventBridge_6;
import itemsadder.m.EventBridge_7;
import itemsadder.m.EventBridge_8;
import itemsadder.m.EventBridge_9;
import itemsadder.m.HostileEnum;
import itemsadder.m.InfoNamespace_3;
import itemsadder.m.ItemStackBridge_10;
import itemsadder.m.ItemStackBridge_11;
import itemsadder.m.ItemStackBridge_12;
import itemsadder.m.ItemStackBridge_13;
import itemsadder.m.ItemStackBridge_14;
import itemsadder.m.ItemStackBridge_15;
import itemsadder.m.ItemStackBridge_16;
import itemsadder.m.ItemStackBridge_17;
import itemsadder.m.ItemStackBridge_18;
import itemsadder.m.ItemStackBridge_19;
import itemsadder.m.ItemStackBridge_20;
import itemsadder.m.ItemStackBridge_21;
import itemsadder.m.ItemStackBridge_22;
import itemsadder.m.ItemStackBridge_23;
import itemsadder.m.ItemStackBridge_24;
import itemsadder.m.ItemStackBridge_25;
import itemsadder.m.ItemStackBridge_26;
import itemsadder.m.ItemStackBridge_27;
import itemsadder.m.ItemStackBridge_28;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBridge_5;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.Opaque022;
import itemsadder.m.Opaque124;
import itemsadder.m.Opaque140;
import itemsadder.m.ParticleBridge;
import itemsadder.m.PlayerBridge_20;
import itemsadder.m.PlayerBridge_22;
import itemsadder.m.PlayerBridge_23;
import itemsadder.m.PlayerInteractListener_5;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.PotionEffectTypeBridge;
import itemsadder.m.PotionEffectTypeBridge_2;
import itemsadder.m.RelativeEnum;
import itemsadder.m.SoundCategoryBridge;
import itemsadder.m.SoundCategoryBridge_3;
import itemsadder.m.StopIfLastSuccessEnum;
import itemsadder.m.StringClassBoolData;
import itemsadder.m.SuccessEnum_2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class ConfigurationSectionBridge_2 {
    public static boolean Cb;
    final ItemStackBuilder_4 Cc;
    public final HashMap Cd = new HashMap();
    public final HashMap Ce = new HashMap();

    public ConfigurationSectionBridge_2(ItemStackBuilder_4 itemStackBuilder_4) {
        this.Cc = itemStackBuilder_4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(ItemStackRegistry itemStackRegistry) {
        ConfigurationSectionBridge configurationSectionBridge = this.Cc.np();
        ConfigurationSection configurationSection = configurationSectionBridge.hi("events");
        if (configurationSection == null) {
            return;
        }
        BlockBreakEnum[] blockBreakEnumArray = BlockBreakEnum.values();
        int n = blockBreakEnumArray.length;
        int n2 = 0;
        while (true) {
            block58: {
                ConfigurationSection configurationSection2;
                if (n2 >= n) {
                    return;
                }
                BlockBreakEnum blockBreakEnum = blockBreakEnumArray[n2];
                if (!configurationSection.contains(blockBreakEnum.toString())) break block58;
                if (configurationSection.contains(String.valueOf((Object)blockBreakEnum) + ".cooldown")) {
                    this.Ce.put(blockBreakEnum, (long)(configurationSection.getInt(String.valueOf((Object)blockBreakEnum) + ".cooldown", 0) / 20) * 1000L);
                }
                if ((configurationSection2 = configurationSection.getConfigurationSection(blockBreakEnum.toString())) == null) break block58;
                for (String string : PluginFileConfigurationHolder.a(configurationSection2, "")) {
                    ConfigurationSection configurationSection3;
                    block57: {
                        Iterator iterator;
                        Object object;
                        Object object2;
                        block88: {
                            Object object3;
                            block78: {
                                Object object4;
                                block63: {
                                    Object object5;
                                    Object object6;
                                    block59: {
                                        block92: {
                                            block91: {
                                                block90: {
                                                    block89: {
                                                        block87: {
                                                            block86: {
                                                                block85: {
                                                                    block84: {
                                                                        block83: {
                                                                            block82: {
                                                                                ItemStackBridge_26 itemStackBridge_26;
                                                                                block81: {
                                                                                    block80: {
                                                                                        block79: {
                                                                                            block77: {
                                                                                                block76: {
                                                                                                    block75: {
                                                                                                        block74: {
                                                                                                            block73: {
                                                                                                                block72: {
                                                                                                                    block71: {
                                                                                                                        block70: {
                                                                                                                            block69: {
                                                                                                                                block68: {
                                                                                                                                    block67: {
                                                                                                                                        block66: {
                                                                                                                                            block65: {
                                                                                                                                                block64: {
                                                                                                                                                    block62: {
                                                                                                                                                        block61: {
                                                                                                                                                            block60: {
                                                                                                                                                                configurationSection3 = configurationSection2.getConfigurationSection(string);
                                                                                                                                                                if (configurationSection3 == null) break block59;
                                                                                                                                                                if (!string.startsWith("play_sound")) break block60;
                                                                                                                                                                this.a(blockBreakEnum, string, new SoundCategoryBridge_3(configurationSection3.getString("name"), (float)configurationSection3.getDouble("volume", 1.0), (float)configurationSection3.getDouble("pitch", 1.0), configurationSection3.getString("category", null), configurationSection3.getBoolean("stop_previous", true))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                                                break block57;
                                                                                                                                                            }
                                                                                                                                                            if (!string.startsWith("stop_sound")) break block61;
                                                                                                                                                            this.a(blockBreakEnum, string, new EventBridge_12(configurationSection3.getString("name"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                                            break block57;
                                                                                                                                                        }
                                                                                                                                                        if (!string.startsWith("execute_commands")) break block62;
                                                                                                                                                        object4 = PluginFileConfigurationHolder.b(configurationSection3).iterator();
                                                                                                                                                        break block63;
                                                                                                                                                    }
                                                                                                                                                    if (!string.startsWith("play_particle")) break block64;
                                                                                                                                                    object4 = configurationSection3.getString("name");
                                                                                                                                                    object2 = SoundCategoryBridge.id((String)object4);
                                                                                                                                                    if (object2 == null) {
                                                                                                                                                        CommandSenderBridge_5.error("&cUnknown particle &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + ". Available particles: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html");
                                                                                                                                                        continue;
                                                                                                                                                    }
                                                                                                                                                    Object object7 = SoundCategoryBridge.a((Particle)object2);
                                                                                                                                                    if (object2.getDataType() != Void.class && object7 == null) {
                                                                                                                                                        CommandSenderBridge_5.error("&cParticle &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + " is currently not supported by the plugin.");
                                                                                                                                                        continue;
                                                                                                                                                    }
                                                                                                                                                    this.a(blockBreakEnum, string, new ParticleBridge((Particle)object2, object7)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                                    break block57;
                                                                                                                                                }
                                                                                                                                                if (!string.startsWith("shoot_particle")) break block65;
                                                                                                                                                object4 = configurationSection3.getString("name");
                                                                                                                                                object2 = SoundCategoryBridge.id((String)object4);
                                                                                                                                                if (object2 == null) {
                                                                                                                                                    CommandSenderBridge_5.error("&cUnknown particle &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + ". Available particles: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html");
                                                                                                                                                    continue;
                                                                                                                                                }
                                                                                                                                                Object object8 = SoundCategoryBridge.a((Particle)object2);
                                                                                                                                                if (object2.getDataType() != Void.class && object8 == null) {
                                                                                                                                                    CommandSenderBridge_5.error("&cParticle &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + " is currently not supported by the plugin.");
                                                                                                                                                    continue;
                                                                                                                                                }
                                                                                                                                                this.a(blockBreakEnum, string, new PlayerBridge_23((Particle)object2, object8, configurationSection3.getInt("distance", 7))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                                break block57;
                                                                                                                                            }
                                                                                                                                            if (!string.startsWith("play_effect")) break block66;
                                                                                                                                            object4 = configurationSection3.getString("name");
                                                                                                                                            object2 = SoundCategoryBridge.ie((String)object4);
                                                                                                                                            if (object2 == null) {
                                                                                                                                                CommandSenderBridge_5.error("&cUnknown effect &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + ". Available effects: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Effect.html");
                                                                                                                                                continue;
                                                                                                                                            }
                                                                                                                                            this.a(blockBreakEnum, string, new EffectBridge((Effect)object2)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                            break block57;
                                                                                                                                        }
                                                                                                                                        if (!string.startsWith("increment_durability")) break block67;
                                                                                                                                        this.a(blockBreakEnum, string, new EventBridge_9(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                        break block57;
                                                                                                                                    }
                                                                                                                                    if (!string.startsWith("decrement_durability")) break block68;
                                                                                                                                    this.a(blockBreakEnum, string, new EventBridge_6(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                    break block57;
                                                                                                                                }
                                                                                                                                if (!string.startsWith("decrement_usages")) break block69;
                                                                                                                                this.a(blockBreakEnum, string, new ItemStackBridge_13(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                                break block57;
                                                                                                                            }
                                                                                                                            if (!string.startsWith("increment_amount")) break block70;
                                                                                                                            this.a(blockBreakEnum, string, new ItemStackBridge_19(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                            break block57;
                                                                                                                        }
                                                                                                                        if (!string.startsWith("decrement_amount")) break block71;
                                                                                                                        this.a(blockBreakEnum, string, new EventBridge_5(configurationSection3.getInt("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                        break block57;
                                                                                                                    }
                                                                                                                    if (!string.startsWith("drop_exp")) break block72;
                                                                                                                    this.a(blockBreakEnum, string, new ItemStackBridge_14(configurationSection3.getDouble("chance", 0.0), configurationSection3.getInt("min_amount"), configurationSection3.getInt("max_amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                    break block57;
                                                                                                                }
                                                                                                                if (!string.startsWith("drop_item")) break block73;
                                                                                                                object4 = ItemStackRegistry.g().q(configurationSection3.getString("item"));
                                                                                                                if (object4 == null) {
                                                                                                                    CommandSenderBridge_5.error("Invalid item for 'drop_item' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                                                    break;
                                                                                                                }
                                                                                                                this.a(blockBreakEnum, string, new ItemStackBridge_15((ItemStack)object4, configurationSection3.getDouble("chance", 100.0), configurationSection3.getInt("min_amount", 1), configurationSection3.getInt("max_amount", 1))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                                break block57;
                                                                                                            }
                                                                                                            if (!string.startsWith("feed")) break block74;
                                                                                                            this.a(blockBreakEnum, string, new EventBridge_8(configurationSection3.getInt("amount"), (float)configurationSection3.getDouble("saturation", 0.0))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                            break block57;
                                                                                                        }
                                                                                                        if (!string.startsWith("replace_properties")) break block75;
                                                                                                        object4 = configurationSection3.getString("custom_model_data.copy_from_item");
                                                                                                        object2 = itemStackRegistry.e((String)object4);
                                                                                                        if (object2 == null) {
                                                                                                            CommandSenderBridge_5.error("&cUnknown item &e'" + object4 + "'&c for action &e'" + string + "'&c of item &e'" + this.Cc.getNamespacedID() + "'&c. File: " + this.Cc.fz().nh());
                                                                                                            continue;
                                                                                                        }
                                                                                                        this.a(blockBreakEnum, string, new ItemStackBridge_25((ItemStackBuilder_4)object2, configurationSection3.getBoolean("custom_model_data.restorable", false))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                        break block57;
                                                                                                    }
                                                                                                    if (!string.startsWith("give_item")) break block76;
                                                                                                    object4 = configurationSection3.getString("item");
                                                                                                    object2 = itemStackRegistry.f((String)object4, this.Cc.fz().nh());
                                                                                                    if (object2 == null) {
                                                                                                        CommandSenderBridge_5.error("&cUnknown item &e'" + object4 + "'&c for action &e'" + string + "'&c of item &e'" + this.Cc.getNamespacedID() + "&c'. File: " + this.Cc.fz().nh());
                                                                                                        continue;
                                                                                                    }
                                                                                                    this.a(blockBreakEnum, string, new ItemStackBridge_18((ItemStack)object2, configurationSection3.getInt("amount", 1))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                                    break block57;
                                                                                                }
                                                                                                if (!string.startsWith("replace_near_blocks")) break block77;
                                                                                                if (configurationSection3.getString("from") == null && configurationSection3.getStringList("from_multiple").isEmpty()) {
                                                                                                    CommandSenderBridge_5.error("Missing 'from' for 'replace_near_blocks' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                                    break;
                                                                                                }
                                                                                                object4 = new HashSet<String>(configurationSection3.getStringList("from_multiple"));
                                                                                                ((HashSet)object4).add(configurationSection3.getString("from"));
                                                                                                object2 = new ArrayList();
                                                                                                object3 = ((HashSet)object4).iterator();
                                                                                                break block78;
                                                                                            }
                                                                                            if (!string.startsWith("glow_near_blocks")) break block79;
                                                                                            object4 = configurationSection3.getString("material");
                                                                                            if (object4 == null) {
                                                                                                CommandSenderBridge_5.error("Missing 'material' for 'glow_near_blocks' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                                break;
                                                                                            }
                                                                                            try {
                                                                                                object2 = MaterialBridge_5.by(object4);
                                                                                            }
                                                                                            catch (IllegalArgumentException illegalArgumentException) {
                                                                                                CommandSenderBridge_5.error("Invalid 'material' for 'glow_near_blocks' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                                break;
                                                                                            }
                                                                                            this.a(blockBreakEnum, string, new PlayerBridge_20((MaterialBridge_5)object2, configurationSection3.getInt("radius.x"), configurationSection3.getInt("radius.y"), configurationSection3.getInt("radius.z"), configurationSection3.getInt("ticks", 40))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                            break block57;
                                                                                        }
                                                                                        if (!string.startsWith("replace_block")) break block80;
                                                                                        object4 = configurationSection3.getString("from");
                                                                                        if (object4 == null) {
                                                                                            CommandSenderBridge_5.error("Missing 'from' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                            break;
                                                                                        }
                                                                                        try {
                                                                                            object2 = MaterialBridge_5.by((String)object4);
                                                                                        }
                                                                                        catch (IllegalArgumentException illegalArgumentException) {
                                                                                            CommandSenderBridge_5.error("Invalid 'from' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                            break;
                                                                                        }
                                                                                        String string2 = configurationSection3.getString("to");
                                                                                        if (string2 == null) {
                                                                                            CommandSenderBridge_5.error("Missing 'to' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                            break;
                                                                                        }
                                                                                        try {
                                                                                            object = MaterialBridge_5.by(string2);
                                                                                        }
                                                                                        catch (IllegalArgumentException illegalArgumentException) {
                                                                                            CommandSenderBridge_5.error("Invalid 'to' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                            break;
                                                                                        }
                                                                                        this.a(blockBreakEnum, string, new ItemStackBridge_22((MaterialBridge_5)object2, (MaterialBridge_5)object, configurationSection3.getInt("decrement_durability"), configurationSection3.getInt("decrement_amount"), configurationSection3.getBoolean("no_physics", false))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                        break block57;
                                                                                    }
                                                                                    if (!string.startsWith("multiple_break")) break block81;
                                                                                    this.a(blockBreakEnum, string, new BlockBridge_10(configurationSection3.getInt("size"), configurationSection3.getInt("depth", 1) - 1, configurationSection3.getBoolean("vertical", false), configurationSection3.getBoolean("keep_ores"), configurationSection3.getBoolean("drop_all_blocks.enabled"), configurationSection3.getBoolean("drop_all_blocks.need_silk_touch"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                    break block57;
                                                                                }
                                                                                if (!string.startsWith("set_block")) break block82;
                                                                                object4 = RelativeEnum.bv(configurationSection3.getString("target", RelativeEnum.RELATIVE.toString()));
                                                                                object2 = configurationSection3.getString("block");
                                                                                if (SoundCategoryBridge.d((String)object2, Material.class)) {
                                                                                    itemStackBridge_26 = new ItemStackBridge_26(Material.valueOf((String)object2), (RelativeEnum)((Object)object4), configurationSection3.getBoolean("decrement_amount", false));
                                                                                } else {
                                                                                    object = ItemStackRegistry.g().h((String)object2);
                                                                                    if (object != null) {
                                                                                        itemStackBridge_26 = new ItemStackBridge_26((LocationBridgeBuilder_2)object, (RelativeEnum)((Object)object4), configurationSection3.getBoolean("decrement_amount", false));
                                                                                    } else {
                                                                                        CommandSenderBridge_5.error("Invalid block for 'set_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                this.a(blockBreakEnum, string, itemStackBridge_26).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                                break block57;
                                                                            }
                                                                            if (string.startsWith("place_furniture")) {
                                                                                object4 = (NamespacedKeyItemDisplayHolder)ItemStackRegistry.g().c("furniture", configurationSection3.getString("furniture"));
                                                                                if (object4 != null) {
                                                                                    this.a(blockBreakEnum, string, new ItemStackBridge_20((NamespacedKeyItemDisplayHolder)object4, configurationSection3.getBoolean("decrement_amount", false)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3)));
                                                                                    break block57;
                                                                                } else {
                                                                                    CommandSenderBridge_5.error("Invalid furniture '" + configurationSection3.getString("furniture") + "' for 'place_furniture' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (string.startsWith("replace_furniture")) {
                                                                                object4 = configurationSection3.getString("furniture");
                                                                                object4 = Opaque140.i((String)object4, this.Cc.getNamespace());
                                                                                object2 = (NamespacedKeyItemDisplayHolder)ItemStackRegistry.g().c("furniture", (String)object4);
                                                                                if (object2 != null) {
                                                                                    this.a(blockBreakEnum, string, new ItemStackBridge_23((NamespacedKeyItemDisplayHolder)object2, configurationSection3.getInt("decrement_durability", 0), configurationSection3.getInt("decrement_amount", 0)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3)));
                                                                                    break block57;
                                                                                } else {
                                                                                    CommandSenderBridge_5.error("Invalid furniture '" + (String)object4 + "' for 'replace_furniture' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (!string.startsWith("remove_furniture")) break block83;
                                                                            this.a(blockBreakEnum, string, new ItemStackBridge_21()).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                            break block57;
                                                                        }
                                                                        if (!string.startsWith("potion_effect")) break block84;
                                                                        object4 = PluginFileConfigurationHolder.hb(configurationSection3.getString("type"));
                                                                        if (object4 == null) {
                                                                            CommandSenderBridge_5.error("Invalid potion effect 'type' for action '" + string + "' of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                            continue;
                                                                        }
                                                                        this.a(blockBreakEnum, string, new PotionEffectTypeBridge((PotionEffectType)object4, configurationSection3.getInt("amplifier", 1), configurationSection3.getInt("duration", 40), configurationSection3.getBoolean("ambient"), configurationSection3.getBoolean("icon", true), configurationSection3.getBoolean("particles", true))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                        break block57;
                                                                    }
                                                                    if (!string.startsWith("remove_potion_effect")) break block85;
                                                                    object4 = PluginFileConfigurationHolder.hb(configurationSection3.getString("type"));
                                                                    if (object4 == null) {
                                                                        CommandSenderBridge_5.error("Invalid potion effect 'type' for action '" + string + "' of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                                        continue;
                                                                    }
                                                                    this.a(blockBreakEnum, string, new PotionEffectTypeBridge_2((PotionEffectType)object4)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                    break block57;
                                                                }
                                                                if (!string.startsWith("explosion")) break block86;
                                                                this.a(blockBreakEnum, string, new ItemStackBridge_17(configurationSection3.getInt("power", 1), configurationSection3.getBoolean("fire", false), configurationSection3.getBoolean("break_blocks", true))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                                break block57;
                                                            }
                                                            if (!string.startsWith("damage_near_entities")) break block87;
                                                            object4 = configurationSection3.getStringList("entity_groups");
                                                            object2 = new ArrayList<MaterialBridge_5>();
                                                            iterator = object4.iterator();
                                                            break block88;
                                                        }
                                                        if (!string.startsWith("damage_entity_in_sight")) break block89;
                                                        this.a(blockBreakEnum, string, new EventBridge_4((float)configurationSection3.getDouble("damage", 1.0), configurationSection3.getInt("distance", 3))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                        break block57;
                                                    }
                                                    if (!string.startsWith("damage_entity")) break block90;
                                                    this.a(blockBreakEnum, string, new ItemStackBridge_11((float)configurationSection3.getDouble("damage", 1.0))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                    break block57;
                                                }
                                                if (!string.startsWith("target_potion_effect")) break block91;
                                                object4 = PluginFileConfigurationHolder.hb(configurationSection3.getString("type"));
                                                if (object4 == null) {
                                                    CommandSenderBridge_5.error("Invalid potion effect 'type' for action '" + string + "' of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                                    continue;
                                                }
                                                this.a(blockBreakEnum, string, new ItemStackBridge_27((PotionEffectType)object4, configurationSection3.getInt("amplifier", 1), configurationSection3.getInt("duration", 40), configurationSection3.getBoolean("ambient"), configurationSection3.getBoolean("particles", true), configurationSection3.getBoolean("icon", true))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                                break block57;
                                            }
                                            if (!string.startsWith("target_remove_potion_effect")) break block92;
                                            this.a(blockBreakEnum, string, new ItemStackBridge_28(PluginFileConfigurationHolder.hb(configurationSection3.getString("type")))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                            break block57;
                                        }
                                        if (string.startsWith("play_totem_animation")) {
                                            object4 = configurationSection2.getString(string);
                                            object2 = itemStackRegistry.b((String)object4, false);
                                            if (object2 == null) {
                                                CommandSenderBridge_5.error("&cUnknown totem &e" + (String)object4 + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID());
                                                continue;
                                            }
                                            this.a(blockBreakEnum, string, new PlayerBridge_22((ItemStackBuilder_4)object2)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                            break block57;
                                        } else if (string.startsWith("script")) {
                                            StringClassBoolData stringClassBoolData;
                                            object4 = configurationSection3.getString("name");
                                            if (object4 == null) {
                                                CommandSenderBridge_5.error("&cMissing script name for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID());
                                                continue;
                                            }
                                            object4 = ((String)object4).replace(".jspp", "");
                                            object4 = ((String)object4).replace(".js", "");
                                            object2 = object4 = ((String)object4).replace(".java", "");
                                            if (!((String)object2).contains(":")) {
                                                object2 = this.Cc.getNamespace() + ":" + (String)object4;
                                            }
                                            if ((stringClassBoolData = InfoNamespace_3.ck((String)object2)) == null) {
                                                CommandSenderBridge_5.error("&cScript &e" + (String)object2 + "&c not found for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID());
                                                continue;
                                            }
                                            try {
                                                this.a(blockBreakEnum, string, new EventBridge_11((String)object2, stringClassBoolData)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                                            }
                                            catch (Exception exception) {
                                                CommandSenderBridge_5.error("&cError loading script for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID(), exception);
                                            }
                                        }
                                        break block57;
                                    }
                                    if (string.equals("cancel") && (object6 = configurationSection2.get(string)) instanceof Boolean && ((Boolean)(object4 = (Boolean)object6)).booleanValue()) {
                                        this.a(blockBreakEnum, string, new ItemStackBridge_10());
                                        continue;
                                    }
                                    if (!string.startsWith("remove_furniture") || !((object5 = configurationSection2.get(string)) instanceof Boolean) || !((Boolean)(object2 = (Boolean)object5)).booleanValue()) continue;
                                    this.a(blockBreakEnum, string, new ItemStackBridge_21());
                                    continue;
                                }
                                while (object4.hasNext()) {
                                    object2 = (String)object4.next();
                                    if (Opaque124.bb((String)object2)) continue;
                                    ItemStackBridge_16 itemStackBridge_16 = new ItemStackBridge_16(configurationSection3.getString((String)object2 + ".command"), configurationSection3.getBoolean((String)object2 + ".as_console"), configurationSection3.getBoolean((String)object2 + ".silent", true), configurationSection3.getString((String)object2 + ".flow_success_if_message_contains", null));
                                    this.a(blockBreakEnum, string, itemStackBridge_16).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt((String)object2 + ".delay", -1)).b(this.a(configurationSection3));
                                }
                                break block57;
                            }
                            while (object3.hasNext()) {
                                object = (String)object3.next();
                                if (object == null) continue;
                                try {
                                    MaterialBridge_5 materialBridge_5 = MaterialBridge_5.by((String)object);
                                    object2.add(materialBridge_5);
                                }
                                catch (IllegalArgumentException illegalArgumentException) {
                                    CommandSenderBridge_5.error("Invalid 'from' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                    break;
                                }
                            }
                            if ((object3 = configurationSection3.getString("to")) == null) {
                                CommandSenderBridge_5.error("Missing 'to' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                break;
                            }
                            try {
                                object = MaterialBridge_5.by((String)object3);
                            }
                            catch (IllegalArgumentException illegalArgumentException) {
                                CommandSenderBridge_5.error("Invalid 'to' for 'replace_block' action of item '" + this.Cc.getNamespacedID() + "'. File: " + this.Cc.fz().nh());
                                break;
                            }
                            Iterator iterator2 = object2.iterator();
                            while (iterator2.hasNext()) {
                                MaterialBridge_5 materialBridge_5 = (MaterialBridge_5)iterator2.next();
                                this.a(blockBreakEnum, string, new ItemStackBridge_24(materialBridge_5, (MaterialBridge_5)object, configurationSection3.getInt("radius.x"), configurationSection3.getInt("radius.y"), configurationSection3.getInt("radius.z"), configurationSection3.getInt("decrement_durability"), configurationSection3.getInt("decrement_amount"), configurationSection3.getBoolean("no_physics", false))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                            }
                            break block57;
                        }
                        while (iterator.hasNext()) {
                            object = (String)iterator.next();
                            HostileEnum hostileEnum = HostileEnum.bu((String)object);
                            if (hostileEnum == null) {
                                CommandSenderBridge_5.error("&cUnknown entity group &e" + (String)object + "&c for action &e" + string + "&c of item &e" + this.Cc.getNamespacedID() + ". Available entity groups: HOSTILE, PLAYERS, PASSIVE");
                                continue;
                            }
                            object2.add(hostileEnum);
                        }
                        int n3 = configurationSectionBridge.gP(String.valueOf((Object)blockBreakEnum) + "." + string + ".range") ? configurationSection3.getInt("range", 3) : configurationSection3.getInt("radius", 3);
                        this.a(blockBreakEnum, string, new ItemStackBridge_12((float)configurationSection3.getDouble("damage", 1.0), n3, (List)object2)).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                    }
                    if (ItemStackRegistry.g().am == null || !ItemStackRegistry.g().am.isEnabled()) continue;
                    if (string.startsWith("increment_player_stat")) {
                        this.a(blockBreakEnum, string, new EventBridge_10(configurationSection3.getString("name"), (float)configurationSection3.getDouble("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                        continue;
                    }
                    if (!string.startsWith("decrement_player_stat")) continue;
                    this.a(blockBreakEnum, string, new EventBridge_7(configurationSection3.getString("name"), (float)configurationSection3.getDouble("amount"))).bw(configurationSection3.getString("permission", null)).ad(configurationSection3.getInt("delay", -1)).b(this.a(configurationSection3));
                }
            }
            ++n2;
        }
    }

    public Opaque124 a(ConfigurationSection configurationSection) {
        for (StopIfLastSuccessEnum stopIfLastSuccessEnum : StopIfLastSuccessEnum.values()) {
            if (!configurationSection.contains(stopIfLastSuccessEnum.key)) continue;
            String string = null;
            if (!(configurationSection.get(stopIfLastSuccessEnum.key) instanceof Boolean)) {
                string = configurationSection.getString(stopIfLastSuccessEnum.key);
            }
            return new Opaque124(stopIfLastSuccessEnum, string);
        }
        return null;
    }

    public Builder_14 a(BlockBreakEnum blockBreakEnum, String string, Builder_14 builder_14) {
        List<Builder_14> list = this.Cd.containsKey((Object)blockBreakEnum) ? (List)this.Cd.get((Object)blockBreakEnum) : new ArrayList<Builder_14>();
        list.add(builder_14);
        this.Cd.put(blockBreakEnum, list);
        builder_14.bx(string);
        if (!Cb) {
            switch (blockBreakEnum) {
                case WEAR: 
                case UNWEAR: 
                case HELD: 
                case UNHELD: 
                case HELD_OFFHAND: 
                case UNHELD_OFFHAND: {
                    Cb = true;
                }
            }
        }
        return builder_14;
    }

    public boolean a(BlockBreakEnum blockBreakEnum) {
        return this.Cd.containsKey((Object)blockBreakEnum);
    }

    public List b(BlockBreakEnum blockBreakEnum) {
        if (this.a(blockBreakEnum)) {
            return (List)this.Cd.get((Object)blockBreakEnum);
        }
        return new ArrayList();
    }

    @Deprecated
    public List a(LivingEntity livingEntity, BlockBreakEnum blockBreakEnum) {
        if (this.a(blockBreakEnum)) {
            if (this.Cc.mW() && !livingEntity.hasPermission(this.Cc.Gr)) {
                CommandSenderBridge_5.f((CommandSender)livingEntity, Main.PQ.ir("no-permission-detail").replace("{permission}", this.Cc.Gr));
                return new ArrayList();
            }
            if (!(livingEntity instanceof Player && !PlayerInteractListener_5.md().a(livingEntity, this.Cc) || livingEntity instanceof Player && (!this.Cc.bg((Player)livingEntity) || this.Cc instanceof LocationBridgeBuilder_2 && !((LocationBridgeBuilder_2)this.Cc).q(((Player)livingEntity).getItemInHand())))) {
                return (List)this.Cd.get((Object)blockBreakEnum);
            }
        }
        return new ArrayList();
    }

    public void a(Entity entity, BlockBreakEnum blockBreakEnum, Consumer_3 consumer_3) {
        Player player;
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        if (entity instanceof Player) {
            player = (Player)entity;
            if (blockBreakEnum == BlockBreakEnum.HELD) {
                ItemStackRegistry.g().ar.Co.a(this.Cc, player, true);
            } else if (blockBreakEnum == BlockBreakEnum.UNHELD) {
                ItemStackRegistry.g().ar.Co.a(this.Cc, player, false);
            }
            if (blockBreakEnum == BlockBreakEnum.PLACED_BLOCK_INTERACT || blockBreakEnum == BlockBreakEnum.PLACED_BLOCK_BREAK || blockBreakEnum == BlockBreakEnum.PLACED_FURNITURE_BREAK || blockBreakEnum == BlockBreakEnum.PLACED_FURNITURE_INTERACT || blockBreakEnum == BlockBreakEnum.PLACED_ARMORSTAND_INTERACT) {
                ItemStackRegistry.g().ar.Co.a(this.Cc, player, false, 25);
            }
        }
        if (this.a(blockBreakEnum)) {
            if (entity instanceof Player) {
                EquipmentSlot equipmentSlot;
                player = (Player)entity;
                if (Cb && (equipmentSlot = BlockBreakEnum.a(this.Cc, blockBreakEnum)) != null) {
                    if (blockBreakEnum == BlockBreakEnum.WEAR || blockBreakEnum == BlockBreakEnum.HELD || blockBreakEnum == BlockBreakEnum.HELD_OFFHAND) {
                        ItemStackRegistry.g().ay.Ew.a((HumanEntity)player, this.Cc, equipmentSlot);
                    } else {
                        ItemStackRegistry.g().ay.Ew.a((HumanEntity)player, equipmentSlot);
                    }
                }
            }
            if (this.Cc.mW() && !entity.hasPermission(this.Cc.Gr)) {
                CommandSenderBridge_5.f((CommandSender)entity, Main.PQ.ir("no-permission-detail").replace("{permission}", this.Cc.Gr));
                return;
            }
            boolean bl = entity instanceof Player;
            if (!(bl && !PlayerInteractListener_5.md().a((LivingEntity)entity, this.Cc) || bl && (!this.Cc.bg((Player)entity) || this.Cc instanceof LocationBridgeBuilder_2 && !((LocationBridgeBuilder_2)this.Cc).q(((Player)entity).getItemInHand())))) {
                boolean bl2 = false;
                SuccessEnum_2 successEnum_2 = null;
                boolean bl3 = false;
                boolean bl4 = false;
                List list = null;
                List list2 = null;
                List list3 = (List)this.Cd.get((Object)blockBreakEnum);
                block14: for (Builder_14 builder_14 : list3) {
                    if (builder_14.aE() && !builder_14.c(entity)) {
                        if (bl2) continue;
                        CommandSenderBridge_5.f((CommandSender)entity, Main.PQ.ir("no-permission-detail").replace("{permission}", builder_14.gx));
                        bl2 = true;
                        continue;
                    }
                    if (builder_14.aD()) {
                        BukkitTaskBridge.c(() -> consumer_3.accept(builder_14), builder_14.mi());
                        continue;
                    }
                    if (list3.size() <= 1) {
                        consumer_3.accept(builder_14);
                        continue;
                    }
                    Opaque124 opaque124 = builder_14.mh();
                    if (opaque124 != null && successEnum_2 != null) {
                        switch (opaque124.xm) {
                            case STOP_IF_LAST_SUCCESS: {
                                if (successEnum_2 != SuccessEnum_2.SUCCESS) break;
                                return;
                            }
                            case STOP_IF_LAST_FAIL: {
                                if (successEnum_2 != SuccessEnum_2.FAILED) break;
                                return;
                            }
                            case SKIP_IF_LAST_SUCCESS: {
                                if (successEnum_2 != SuccessEnum_2.SUCCESS) break;
                                continue block14;
                            }
                            case SKIP_IF_LAST_FAIL: {
                                if (successEnum_2 != SuccessEnum_2.FAILED) break;
                                continue block14;
                            }
                            case STOP_IF_ANY_SUCCESS: {
                                if (!bl4) break;
                                return;
                            }
                            case STOP_IF_ANY_FAIL: {
                                if (!bl3) break;
                                return;
                            }
                            case SKIP_IF_ANY_SUCCESS: {
                                if (!bl4) break;
                                continue block14;
                            }
                            case SKIP_IF_ANY_FAIL: {
                                if (!bl3) break;
                                continue block14;
                            }
                            case STOP_IF_SUCCESS: {
                                if (!bl4 || !Opaque022.c(list2, opaque124.xn)) break;
                                return;
                            }
                            case STOP_IF_FAIL: {
                                if (!bl3 || !Opaque022.c(list, opaque124.xn)) break;
                                return;
                            }
                            case SKIP_IF_SUCCESS: {
                                if (!bl4 || !Opaque022.c(list2, opaque124.xn)) break;
                                continue block14;
                            }
                            case SKIP_IF_FAIL: {
                                if (!bl3 || !Opaque022.c(list, opaque124.xn)) break;
                                continue block14;
                            }
                        }
                    }
                    ItemStackBuilder_3 itemStackBuilder_3 = consumer_3.accept(builder_14);
                    successEnum_2 = itemStackBuilder_3.Ec;
                    if (itemStackBuilder_3.Ec == SuccessEnum_2.SUCCESS) {
                        bl4 = true;
                        list2 = Opaque022.b(list2, (Object)builder_14.aF());
                        continue;
                    }
                    if (itemStackBuilder_3.Ec != SuccessEnum_2.FAILED) continue;
                    bl3 = true;
                    list = Opaque022.b(list, (Object)builder_14.aF());
                }
            }
        }
    }

    public boolean c(BlockBreakEnum blockBreakEnum) {
        return this.Ce.containsKey((Object)blockBreakEnum);
    }

    public Long d(BlockBreakEnum blockBreakEnum) {
        if (this.c(blockBreakEnum)) {
            return (Long)this.Ce.get((Object)blockBreakEnum);
        }
        return 0L;
    }

    public void h(ItemStackBuilder_4 itemStackBuilder_4) {
        this.a(itemStackBuilder_4, false);
    }

    public void a(ItemStackBuilder_4 itemStackBuilder_4, boolean bl) {
        for (Map.Entry entry : this.Cd.entrySet()) {
            if (bl && itemStackBuilder_4.Gd.Cd.containsKey(entry.getKey())) continue;
            itemStackBuilder_4.Gd.Cd.put((BlockBreakEnum)((Object)entry.getKey()), (List)entry.getValue());
        }
        itemStackBuilder_4.i(this.Cc.Gq);
        itemStackBuilder_4.Gr = this.Cc.Gr;
    }
}
