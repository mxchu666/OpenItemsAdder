package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.resourcepack.f;
import itemsadder.m.BlockBridge_12;
import itemsadder.m.BlockBridge_13;
import itemsadder.m.BlockEnum;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridgeBuilder_3;
import itemsadder.m.LocationBridge_13;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBlockDataHolder;
import itemsadder.m.PlayerBridge_21;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RealEnum;
import itemsadder.m.RecordOfValue_21;
import itemsadder.m.StringIntegerBooleanData;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.Nullable;

public class MaterialBridge_13 {
    public static boolean c(ConfigurationSectionBridge configurationSectionBridge) {
        return configurationSectionBridge.gP("specific_properties.block.placed_model") || configurationSectionBridge.gP("behaviours.block.placed_model");
    }

    public static ItemStackBuilder_4 a(ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, Material material, boolean bl) {
        Integer n;
        Object object;
        ConfigurationSection configurationSection;
        Object object22;
        int n2;
        ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj("specific_properties.block");
        if (configurationSectionBridge2 == null) {
            configurationSectionBridge2 = configurationSectionBridge.hj("behaviours.block");
        }
        if (configurationSectionBridge2 == null) {
            throw new IllegalArgumentException("[Items] '" + string + ":" + string2 + "'. Error: Missing 'specific_properties.block' or 'behaviours.block' section. File: " + pluginFileConfigurationHolder.nh());
        }
        RealEnum realEnum = RealEnum.valueOf(configurationSectionBridge2.gV("placed_model.type"));
        if (realEnum == RealEnum.ENTITY && !Version.isAtLeast((Version)Version.v1_21_4)) {
            throw new IllegalStateException("[Items] '" + string + ":" + string2 + "'. Error: placed_model.type ENTITY requires Minecraft server and clients 1.21.4+. No legacy Custom Model Data fallback is available. File: " + pluginFileConfigurationHolder.nh());
        }
        if (!realEnum.pg()) {
            n2 = -1;
        } else if (bl && material == Material.PAPER && realEnum != RealEnum.TILE) {
            n2 = f.xl().a(realEnum, string, string2);
            material = realEnum.p(MaterialBlockDataHolder.ao(n2));
        } else {
            n2 = f.xl().a(material, realEnum, string, string2);
        }
        if (realEnum == RealEnum.FIRE) {
            if (n2 == -1 && realEnum.pg()) {
                throw new IllegalArgumentException("[Items] '" + string + ":" + string2 + "'. Error: This fire block would have a block id > than 15.");
            }
            return new BlockBridge_12(pluginFileConfigurationHolder, string, string2, material, n2);
        }
        if (n2 == -1 && realEnum.pg()) {
            throw new IllegalStateException("[Items] '" + string + ":" + string2 + "'. Error: Block would have a block id > than the max limit for blocks of type '" + String.valueOf((Object)realEnum) + "'. In order to add more blocks please use another type of block (REAL, REAL_NOTE, REAL_TRANSPARENT or TILE).");
        }
        ArrayList<StringIntegerBooleanData> arrayList = new ArrayList<StringIntegerBooleanData>();
        ConfigurationSection configurationSection2 = configurationSectionBridge2.hi("placed_model.custom_variants");
        if (configurationSection2 != null) {
            for (Object object22 : configurationSection2.getKeys(false)) {
                configurationSection = configurationSection2.getConfigurationSection((String)object22);
                object = configurationSection.getString("model", null);
                if (object == null) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: Missing 'model' for 'custom_variant' '" + (String)object22 + "'. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                n = (Integer)configurationSection.get("x", null);
                Integer n3 = (Integer)configurationSection.get("y", null);
                if (n != null && n % 90 != 0) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Invalid 'x' for '" + (String)object + "' block model. Allowed values: 0,90,180,270. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                if (n3 != null && n3 % 90 != 0) {
                    CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Invalid 'y' for '" + (String)object + "' block model. Allowed values: 0,90,180,270. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                if (!((String)object).contains(":")) {
                    object = string + ":" + (String)object;
                }
                arrayList.add(new StringIntegerBooleanData((String)object, (Integer)configurationSection.get("weight", null), n, n3, (Boolean)configurationSection.get("uvlock", null)));
            }
        } else {
            arrayList = null;
        }
        Material material2 = MaterialBridge_13.a(configurationSectionBridge2, realEnum, MaterialBarColorHolder.cP, (T string3) -> CommandSenderBridge_5.warn("[Items] '" + string + ":" + string2 + "'. Invalid fallback_vanilla_block '" + string3 + "': it must be a solid, occluding, non-interactable vanilla block without gravity. Using " + String.valueOf(MaterialBarColorHolder.cP) + ". File: " + pluginFileConfigurationHolder.nh()));
        object22 = new LocationBridgeBuilder_2(pluginFileConfigurationHolder, string, string2, material, n2, realEnum, BlockEnum.valueOf(configurationSectionBridge2.az("placed_model.break_particles", "VANILLA")), configurationSectionBridge2.C("drop_when_mined", !configurationSectionBridge2.C("cancel_drop", false)), configurationSectionBridge2.t("light_level", -1), configurationSectionBridge2.hg("break_tools_blacklist"), configurationSectionBridge2.hg("break_tools_whitelist"), configurationSectionBridge2.hg("events_tools_blacklist"), configurationSectionBridge2.hg("events_tools_whitelist"), configurationSectionBridge2.a("hardness", 0.5f) + 0.2f, configurationSectionBridge2.C("placed_model.shift_up", false), configurationSectionBridge2.C("placed_model.placeable_on_other_real_wire", false), configurationSectionBridge2.C("placed_model.placeable_on_water", false), configurationSectionBridge2.C("placed_model.placeable_on_lava", false), configurationSectionBridge2.t("placed_model.rotx", 0), configurationSectionBridge2.t("placed_model.roty", 0), arrayList);
        ((LocationBridgeBuilder_2)object22).FA = material2;
        ((LocationBridgeBuilder_2)object22).ak(bl);
        ((LocationBridgeBuilder_2)object22).a(configurationSectionBridge2.az("sound.break.name", null), configurationSectionBridge2.a("sound.break.volume", 1.0f), configurationSectionBridge2.a("sound.break.pitch", 0.8f));
        ((LocationBridgeBuilder_2)object22).b(configurationSectionBridge2.az("sound.place.name", null), configurationSectionBridge2.a("sound.place.volume", 1.0f), configurationSectionBridge2.a("sound.place.pitch", 0.8f));
        ((LocationBridgeBuilder_2)object22).c(configurationSectionBridge2.az("sound.hit.name", null), configurationSectionBridge2.a("sound.hit.volume", 0.25f), configurationSectionBridge2.a("sound.hit.pitch", 0.5f));
        ((LocationBridgeBuilder_2)object22).d(configurationSectionBridge2.az("sound.step.name", null), configurationSectionBridge2.a("sound.step.volume", 0.15f), configurationSectionBridge2.a("sound.step.pitch", 1.0f));
        ((LocationBridgeBuilder_2)object22).e(configurationSectionBridge2.az("sound.fall.name", null), configurationSectionBridge2.a("sound.fall.volume", 0.5f), configurationSectionBridge2.a("sound.fall.pitch", 0.75f));
        ((LocationBridgeBuilder_2)object22).ah(configurationSectionBridge2.C("no_explosion", false));
        ((LocationBridgeBuilder_2)object22).m(configurationSectionBridge2.a("blast_resistance", -1.0f));
        if (configurationSectionBridge2.gP("permission_suffix.break")) {
            ((BlockBridge_13)object22).bc(configurationSectionBridge2.az("permission_suffix.break", null));
        }
        if (configurationSectionBridge2.gP("permission_suffix.place")) {
            ((BlockBridge_13)object22).bd(configurationSectionBridge2.az("permission_suffix.place", null));
        }
        if (configurationSectionBridge2.gP("drop_on_silk_touch")) {
            ((LocationBridgeBuilder_2)object22).ai(configurationSectionBridge2.C("drop_on_silk_touch", true));
        }
        if (configurationSectionBridge2.gP("drop_on_shears")) {
            ((LocationBridgeBuilder_2)object22).aj(configurationSectionBridge2.C("drop_on_shears", true));
        }
        if ((configurationSection = configurationSectionBridge2.hi("primeable")) != null) {
            object = LocationBridge_13.pk();
            ((LocationBridgeBuilder_3)object).at(configurationSection.getInt("radius", 3));
            ((LocationBridgeBuilder_3)object).au(configurationSection.getInt("fuse_ticks", 80));
            ((LocationBridgeBuilder_3)object).o(configurationSection.getDouble("damage_multiplier", 1.0));
            ((LocationBridgeBuilder_3)object).ax(configurationSection.getBoolean("waterproof", true));
            ((LocationBridgeBuilder_3)object).ay(configurationSection.getBoolean("incendiary", false));
            n = configurationSection.getConfigurationSection("triggers");
            if (n != null) {
                int n4 = 0;
                if (n.getBoolean("explosion", false)) {
                    n4 = LocationBridge_13.o(n4, 8);
                }
                if (n.getBoolean("fire", false)) {
                    n4 = LocationBridge_13.o(n4, 4);
                }
                if (n.getBoolean("flaming_projectile", false)) {
                    n4 = LocationBridge_13.o(n4, 1);
                }
                if (n.getBoolean("redstone", false)) {
                    n4 = LocationBridge_13.o(n4, 2);
                }
                ((LocationBridgeBuilder_3)object).av(n4);
                @Nullable ArrayList<RecordOfValue_21> arrayList2 = new ArrayList<RecordOfValue_21>();
                if (n.contains("tools")) {
                    List list = n.getStringList("tools");
                    for (String string4 : list) {
                        arrayList2.add(RecordOfValue_21.E(string4));
                    }
                }
                if (!arrayList2.isEmpty()) {
                    ((LocationBridgeBuilder_3)object).b(new PlayerBridge_21(arrayList2));
                }
            }
            ((LocationBridgeBuilder_2)object22).a(((LocationBridgeBuilder_3)object).pl());
        }
        ItemStackRegistry.g().S.add(object22);
        ItemStackRegistry.g().T.put(((ItemStackBuilder_4)object22).getNamespacedID(), object22);
        if (realEnum.pg()) {
            ItemStackRegistry.g().U.put(n2, object22);
        }
        return object22;
    }

    static Material a(ConfigurationSectionBridge configurationSectionBridge, RealEnum realEnum, Material material, @Nullable Consumer consumer) {
        return MaterialBridge_13.a(configurationSectionBridge, realEnum, material, consumer, RealEnum::q);
    }

    static Material a(ConfigurationSectionBridge configurationSectionBridge, RealEnum realEnum, Material material, @Nullable Consumer consumer, Predicate predicate) {
        if (realEnum != RealEnum.ENTITY || !configurationSectionBridge.gP("fallback_vanilla_block")) {
            return material;
        }
        Material material2 = configurationSectionBridge.a("fallback_vanilla_block", (Material)null);
        if (material2 != null && predicate.test(material2)) {
            return material2;
        }
        if (consumer != null) {
            consumer.accept(configurationSectionBridge.az("fallback_vanilla_block", ""));
        }
        return material;
    }
}
