package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import itemsadder.m.BreakEnum;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.EnumWrappersHolder;
import itemsadder.m.FloatData_2;
import itemsadder.m.ItemStackBridge_32;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder;
import itemsadder.m.LocationBridge_14;
import itemsadder.m.LocationBridge_7;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBridge_10;
import itemsadder.m.MaterialBridge_12;
import itemsadder.m.PlayerBridgeBuilder;
import itemsadder.m.PlayerBridge_21;
import itemsadder.m.PlayerBridge_6;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfItemStack;
import itemsadder.m.RecordOfList_2;
import itemsadder.m.RecordOfString_8;
import itemsadder.m.RecordOfValue_21;
import itemsadder.m.RecordOfValue_25;
import itemsadder.m.Resource;
import itemsadder.m.VectorBridge_2;
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

public class Crops {
    public static final String JL = "minecraft:block/crop";
    static List JM = new ArrayList();
    static List JN = new ArrayList();

    public static void aR() {
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : ItemStackRegistry.g().b()) {
            Crops.e(pluginFileConfigurationHolder);
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

    private static void e(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        ConfigurationSectionBridge configurationSectionBridge = pluginFileConfigurationHolder.hj("crops");
        if (configurationSectionBridge == null) {
            return;
        }
        String string = pluginFileConfigurationHolder.gV("info.namespace");
        if (string == null) {
            throw new IllegalArgumentException("[Items] Missing 'info.namespace'. File: " + pluginFileConfigurationHolder.nh());
        }
        Set set = configurationSectionBridge.aX(false);
        if (!set.isEmpty() && !Version.isAtLeast((Version)Version.v1_21_4)) {
            CommandSenderBridge_5.error("[Items] Crops are only supported on Minecraft 1.21.4 or higher! Skipping loading crops. File: " + pluginFileConfigurationHolder.nh());
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
                ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj(string2);
                assert (configurationSectionBridge2 != null);
                LocationBridgeBuilder locationBridgeBuilder = LocationBridge_7.bF();
                locationBridgeBuilder.ac(string + ":" + string2);
                ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(configurationSectionBridge2.gV("seed"));
                if (itemStackBuilder_4 == null) {
                    throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: Missing or invalid 'seed' entry. File: " + pluginFileConfigurationHolder.nh());
                }
                locationBridgeBuilder.b(itemStackBuilder_4).o(configurationSectionBridge2.C("drop_seed_if_immature", true)).a(configurationSectionBridge2.b("avg_seconds_per_stage", MaterialBarColorHolder.dS)).h(configurationSectionBridge2.t("min_light", 9)).b(configurationSectionBridge2.fo("required_spacing") ? Integer.valueOf(configurationSectionBridge2.t("required_spacing", 1)) : null).a((float)configurationSectionBridge2.b("multipliers.bonemeal", 1.5)).b(configurationSectionBridge2.b("multipliers.max_moisture", 0.5)).b((float)configurationSectionBridge2.b("multipliers.rain", 1.5)).c((float)configurationSectionBridge2.b("multipliers.thunder", -1.0)).d((float)configurationSectionBridge2.b("multipliers.snow", -1.5));
                ConfigurationSectionBridge configurationSectionBridge3 = configurationSectionBridge2.hj("default_hitbox");
                if (configurationSectionBridge3 != null) {
                    float f = (float)configurationSectionBridge3.b("width", 1.0);
                    float f2 = (float)configurationSectionBridge3.b("length", 1.0);
                    float f3 = (float)configurationSectionBridge3.b("height", 1.0);
                    locationBridgeBuilder.a(new VectorBridge_2(f, f3, f2));
                } else {
                    locationBridgeBuilder.a(new VectorBridge_2(1.0f, 1.0f, 1.0f));
                }
                HashMap<Byte, Object> hashMap = new HashMap<Byte, Object>();
                byte by = configurationSectionBridge2.t("max_age", 7);
                HashMap<Byte, ItemStack> hashMap2 = new HashMap<Byte, ItemStack>();
                HashMap<Byte, ItemStack> hashMap3 = new HashMap<Byte, ItemStack>();
                if (configurationSectionBridge2.fo("models_by_items") && configurationSectionBridge2.fo("models_by_textures")) {
                    throw new IllegalArgumentException("Crop '" + string + ":" + string2 + "'. Warning: Contains both 'models_by_items' and 'models_by_textures' sections. Only one is allowed. File: " + pluginFileConfigurationHolder.nh());
                }
                if (configurationSectionBridge2.fo("models_by_items")) {
                    var14_19 = configurationSectionBridge2.gV("models_by_items.items_id_prefix");
                    if (var14_19 == null) {
                        throw new IllegalArgumentException("Crop '" + string + ":" + string2 + "'. Error: Missing 'models_by_items.items_id_prefix' entry. File: " + pluginFileConfigurationHolder.nh());
                    }
                    for (byte by2 = 0; by2 <= by; by2 = (byte)(by2 + 1)) {
                        object8 = var14_19 + by2;
                        object7 = ItemStackRegistry.g().e((String)object8);
                        if (object7 == null) {
                            throw new IllegalArgumentException("Crop '" + string + ":" + string2 + "'. Error: Unknown item '" + (String)object8 + "' generated from 'models_by_items.items_id_prefix'. File: " + pluginFileConfigurationHolder.nh());
                        }
                        hashMap2.put(by2, ((ItemStackBuilder_4)object7).mP());
                        JN.add(object7);
                        if (!MaterialBarColorHolder.dX) continue;
                        object622 = var14_19 + by2 + "_billboard";
                        ItemStackBuilder_4 itemStackBuilder_42 = ItemStackRegistry.g().e((String)object622);
                        if (itemStackBuilder_42 == null) continue;
                        hashMap3.put(by2, itemStackBuilder_42.mP());
                        JN.add(itemStackBuilder_42);
                    }
                } else if (configurationSectionBridge2.fo("models_by_textures")) {
                    var14_19 = configurationSectionBridge2.aC("models_by_textures.parent", JL);
                    try {
                        var14_19 = Resource.t(var14_19, string);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        throw new IllegalArgumentException("[Crops] '" + string + ":" + string2 + "'. Error: Invalid 'parent' '" + var14_19 + "'." + illegalArgumentException.getMessage() + ". File: " + pluginFileConfigurationHolder.nh());
                    }
                    if (var14_19.equalsIgnoreCase(JL)) {
                        locationBridgeBuilder.n(true);
                    }
                    object5 = configurationSectionBridge2.aC("models_by_textures.model_texture_key", "crop");
                    object8 = configurationSectionBridge2.gV("models_by_textures.textures_prefix");
                    if (object8 == null) {
                        throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: Missing 'models_by_textures.textures_prefix' entry. File: " + pluginFileConfigurationHolder.nh());
                    }
                    if (!((String)object8).contains(":")) {
                        object8 = string + ":" + (String)object8;
                    }
                    if (((String)object8).endsWith(".png")) {
                        object8 = ((String)object8).substring(0, ((String)object8).length() - 4);
                    }
                    object7 = configurationSectionBridge2.aC("models_by_textures.billboard_parent", "minecraft:block/crop_billboard");
                    object622 = configurationSectionBridge2.aC("models_by_textures.billboard_model_texture_key", "crop");
                    object4 = configurationSectionBridge2.gV("models_by_textures.billboard_textures_prefix");
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
                    for (byte by3 = 0; by3 <= by; by3 = (byte)(by3 + 1)) {
                        object3 = string + ":" + string2 + "_" + by3;
                        object2 = string + ":" + string2 + "_" + by3 + "_billboard";
                        object = new MaterialBridge_12((String)object3, Material.PAPER, var14_19, Map.of(object5, (String)object8 + by3), null, null, null, null, null);
                        JM.add(object);
                        MaterialBridge_12 materialBridge_12 = new MaterialBridge_12((String)object2, Material.PAPER, (String)object7, Map.of(object622, (String)object4 + by3), null, null, null, null, null);
                        JM.add(materialBridge_12);
                        ItemStack itemStack = new ItemStack(Material.PAPER);
                        PlayerHolder_2.tX().d(itemStack, ((MaterialBridge_10)object).nF());
                        hashMap2.put(by3, itemStack);
                        ItemStack itemStack2 = new ItemStack(Material.PAPER);
                        PlayerHolder_2.tX().d(itemStack2, materialBridge_12.nF());
                        hashMap3.put(by3, itemStack2);
                    }
                } else {
                    throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: Missing 'stages.id_prefix' entry. File: " + pluginFileConfigurationHolder.nh());
                }
                float f = (float)configurationSectionBridge2.b("hitbox_auto_height_step", 0.0);
                object5 = new HashMap();
                object8 = configurationSectionBridge2.hj("hitboxes");
                if (object8 != null) {
                    for (Object object622 : ((ConfigurationSectionBridge)object8).CK()) {
                        try {
                            byte by4 = Byte.parseByte((String)object622);
                            ConfigurationSectionBridge configurationSectionBridge4 = ((ConfigurationSectionBridge)object8).hj((String)object622);
                            object3 = null;
                            object2 = null;
                            object = null;
                            if (configurationSectionBridge4 != null) {
                                if (configurationSectionBridge4.fo("width")) {
                                    object3 = Float.valueOf((float)configurationSectionBridge4.hs("width"));
                                }
                                if (configurationSectionBridge4.fo("length")) {
                                    object2 = Float.valueOf((float)configurationSectionBridge4.hs("length"));
                                }
                                if (configurationSectionBridge4.fo("height")) {
                                    object = Float.valueOf((float)configurationSectionBridge4.hs("height"));
                                }
                            }
                            object5.put(by4, new FloatData_2((Float)object3, (Float)object2, (Float)object));
                        }
                        catch (NumberFormatException numberFormatException) {
                            CommandSenderBridge_5.warn("[Items] Invalid hitbox stage '" + (String)object622 + "' in crop '" + string + ":" + string2 + "'");
                        }
                    }
                }
                if (by > 127) {
                    throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: 'max_age' cannot be higher than 127 (current: " + by + "). File: " + pluginFileConfigurationHolder.nh());
                }
                for (byte by5 = 0; by5 <= by; by5 = (byte)(by5 + 1)) {
                    object622 = (FloatData_2)object5.get(by5);
                    Float f4 = null;
                    Float f5 = null;
                    object3 = null;
                    if (object622 != null) {
                        f4 = ((FloatData_2)object622).JP;
                        f5 = ((FloatData_2)object622).JQ;
                        object3 = ((FloatData_2)object622).JR;
                    } else if (f != 0.0f) {
                        object3 = Float.valueOf(f * (float)by5);
                        if (((Float)object3).floatValue() < 0.1f) {
                            object3 = Float.valueOf(0.1f);
                        }
                        if (((Float)object3).floatValue() > 1.0f) {
                            object3 = Float.valueOf(1.0f);
                        }
                    }
                    object2 = new RecordOfItemStack((ItemStack)hashMap2.get(by5), (ItemStack)hashMap3.get(by5), f4, f5, (Float)object3);
                    hashMap.put(by5, object2);
                }
                locationBridgeBuilder.g(by);
                locationBridgeBuilder.a(ImmutableMap.copyOf(hashMap));
                object7 = configurationSectionBridge2.gV("bottom_block");
                if (object7 != null) {
                    object622 = ItemStackRegistry.g().h((String)object7);
                    if (object622 != null) {
                        locationBridgeBuilder.ag(((ItemStackBuilder_4)object622).getNamespacedID());
                    } else {
                        object4 = ConfigurationSectionBridge.b((String)object7, null);
                        if (object4 == null) {
                            throw new IllegalArgumentException("'" + string + ":" + string2 + "'. Error: Invalid 'bottom_block' '" + (String)object7 + "'. File: " + pluginFileConfigurationHolder.nh());
                        }
                        locationBridgeBuilder.b((Material)object4);
                        locationBridgeBuilder.m(object4 == Material.FARMLAND);
                    }
                }
                locationBridgeBuilder.ad(configurationSectionBridge2.gV("place_sound"));
                locationBridgeBuilder.ae(configurationSectionBridge2.gV("break_sound"));
                locationBridgeBuilder.af(configurationSectionBridge2.gV("interact_sound"));
                locationBridgeBuilder.b(Crops.b(configurationSectionBridge2, string, string2, pluginFileConfigurationHolder));
                object622 = locationBridgeBuilder.bL();
                ItemStackRegistry.g().ab.put(((LocationBridge_7)object622).hD, object622);
                ItemStackRegistry.g().ac.put(itemStackBuilder_4, object622);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                CommandSenderBridge_5.warn("[Items] " + illegalArgumentException.getMessage());
            }
        }
    }

    static ImmutableMap b(ConfigurationSectionBridge configurationSectionBridge, String string, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        HashMap<BreakEnum, List> hashMap = new HashMap<BreakEnum, List>();
        ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj("loots");
        if (configurationSectionBridge2 != null) {
            for (Object object : configurationSectionBridge2.CK()) {
                Object object2;
                Object object32;
                Object object4;
                Object object52;
                ConfigurationSectionBridge object6 = configurationSectionBridge2.hj((String)object);
                assert (object6 != null);
                PlayerBridgeBuilder playerBridgeBuilder = PlayerBridge_6.bM();
                if (object6.hm("age") instanceof Integer) {
                    playerBridgeBuilder.c(object6.c("age", (Integer)null));
                    playerBridgeBuilder.d(object6.c("age", (Integer)null));
                } else {
                    playerBridgeBuilder.c(object6.c("age_range.min", (Integer)null));
                    playerBridgeBuilder.d(object6.c("age_range.max", (Integer)null));
                }
                playerBridgeBuilder.e(object6.c("decrease_age", (Integer)null));
                HashSet<NamespacedKey> hashSet = new HashSet<NamespacedKey>();
                for (Object object52 : object6.hg("biomes")) {
                    object4 = EnumWrappersHolder.vC().aoJ.dO(((String)object52).toUpperCase());
                    if (object4 != null) {
                        hashSet.add((NamespacedKey)object4);
                        continue;
                    }
                    CommandSenderBridge_5.warn("[Items] '" + string + ":" + string2 + "' has unknown biome '" + (String)object52 + "' in loot.biomes. File: " + pluginFileConfigurationHolder.nh());
                }
                playerBridgeBuilder.a(hashSet);
                ArrayList arrayList = new ArrayList();
                if (object6.fo("tools")) {
                    object52 = object6.hg("tools");
                    object4 = object52.iterator();
                    while (object4.hasNext()) {
                        object32 = (String)object4.next();
                        arrayList.add(RecordOfValue_21.E((String)object32));
                    }
                }
                if (!arrayList.isEmpty()) {
                    playerBridgeBuilder.a(new PlayerBridge_21(arrayList));
                }
                object52 = new ArrayList<Object>();
                if (object6.fo("triggers")) {
                    for (Object object32 : object6.hg("triggers")) {
                        try {
                            object2 = BreakEnum.valueOf(((String)object32).toUpperCase(Locale.ROOT));
                            object52.add(object2);
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            CommandSenderBridge_5.warn("[Items] '" + string + ":" + string2 + "' has unknown 'trigger' '" + (String)object32 + "'. File: " + pluginFileConfigurationHolder.nh());
                        }
                    }
                } else {
                    object4 = (BreakEnum)object6.a("trigger", BreakEnum.class, BreakEnum.BREAK);
                    object52.add(object4);
                }
                playerBridgeBuilder.a(ImmutableList.copyOf(object52));
                object4 = playerBridgeBuilder.bO();
                ((LocationBridge_14)object4).aA(object6.C("stop_on_first_success", object6.C("drop_only_first", false)));
                object32 = object52.iterator();
                while (object32.hasNext()) {
                    object2 = (BreakEnum)((Object)object32.next());
                    hashMap.computeIfAbsent((BreakEnum)((Object)object2), breakEnum -> new ArrayList()).add(object4);
                }
                object6.hg("worlds").forEach(((PlayerBridge_6)object4)::cv);
                if (object6.gP("commands")) {
                    object32 = object6.hj("commands");
                    assert (object32 != null);
                    for (String string3 : ((ConfigurationSectionBridge)object32).CK()) {
                        ConfigurationSectionBridge configurationSectionBridge3 = ((ConfigurationSectionBridge)object32).hj(string3);
                        assert (configurationSectionBridge3 != null);
                        ArrayList<RecordOfString_8> arrayList2 = new ArrayList<RecordOfString_8>();
                        for (String string4 : configurationSectionBridge3.CK()) {
                            if (string4.equals("chance")) continue;
                            ConfigurationSectionBridge configurationSectionBridge4 = configurationSectionBridge3.hj(string4);
                            assert (configurationSectionBridge4 != null);
                            arrayList2.add(new RecordOfString_8(configurationSectionBridge4.gV("command"), configurationSectionBridge4.C("as_console", true), configurationSectionBridge4.C("silent", false)));
                        }
                        ((LocationBridge_14)object4).a(new RecordOfList_2(arrayList2, configurationSectionBridge3.gW("chance")));
                    }
                }
                if (object6.gP("exp_drop")) {
                    Crops.b(object6, "exp_drop", (PlayerBridge_6)object4, pluginFileConfigurationHolder);
                }
                if (object6.gP("exp_drops")) {
                    object32 = object6.hj("exp_drops");
                    assert (object32 != null);
                    for (String string3 : ((ConfigurationSectionBridge)object32).CK()) {
                        Crops.b((ConfigurationSectionBridge)object32, string3, (PlayerBridge_6)object4, pluginFileConfigurationHolder);
                    }
                }
                if (object6.gP("item_drop")) {
                    Crops.a(object6, "item_drop", (PlayerBridge_6)object4, pluginFileConfigurationHolder);
                }
                if (!object6.gP("item_drops")) continue;
                object32 = object6.hj("item_drops");
                assert (object32 != null);
                for (String string3 : object6.gR("item_drops")) {
                    Crops.a((ConfigurationSectionBridge)object32, string3, (PlayerBridge_6)object4, pluginFileConfigurationHolder);
                }
            }
        }
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (Map.Entry entry : hashMap.entrySet()) {
            builder.put((BreakEnum)((Object)entry.getKey()), ImmutableList.copyOf((Collection)entry.getValue()));
        }
        return builder.build();
    }

    static void a(ConfigurationSectionBridge configurationSectionBridge, String string, PlayerBridge_6 playerBridge_6, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj(string);
        assert (configurationSectionBridge2 != null);
        String string2 = configurationSectionBridge2.gV("item");
        ItemStack itemStack = ItemStackRegistry.g().o(string2);
        if (itemStack == null) {
            CommandSenderBridge_5.error("Item '" + string2 + "' not found for loot '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
            return;
        }
        ItemStackBridge_32 itemStackBridge_32 = new ItemStackBridge_32(itemStack, configurationSectionBridge2.t("min_amount", 1), configurationSectionBridge2.t("max_amount", 1), configurationSectionBridge2.a("chance", 100.0f), configurationSectionBridge2.C("ignore_fortune", false));
        if (itemStackBridge_32.oR() > itemStackBridge_32.oS()) {
            CommandSenderBridge_5.error("Invalid loot. 'min_amount' " + itemStackBridge_32.oR() + " greater than 'max_amount' " + itemStackBridge_32.oS() + "! Must be lower. Loot '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
            return;
        }
        playerBridge_6.c(itemStackBridge_32);
    }

    static void b(ConfigurationSectionBridge configurationSectionBridge, String string, PlayerBridge_6 playerBridge_6, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        Object object = configurationSectionBridge.hm(string);
        if (object instanceof Integer) {
            Integer n = (Integer)object;
            playerBridge_6.a(new RecordOfValue_25(n));
        } else {
            object = configurationSectionBridge.hj(string);
            assert (object != null);
            RecordOfValue_25 recordOfValue_25 = new RecordOfValue_25(((ConfigurationSectionBridge)object).gW("min_amount"), ((ConfigurationSectionBridge)object).gW("max_amount"), ((ConfigurationSectionBridge)object).gX("chance"));
            if (recordOfValue_25.oN() > recordOfValue_25.oO()) {
                CommandSenderBridge_5.error("Invalid loot. 'min_amount' " + recordOfValue_25.oN() + " greater than 'max_amount' " + recordOfValue_25.oO() + "! Must be lower. Loot '" + string + "'. File: " + pluginFileConfigurationHolder.nh());
                return;
            }
            playerBridge_6.a(recordOfValue_25);
        }
    }
}
