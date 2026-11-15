package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ConfigurationSectionBridge_4;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginFileConfigurationHolder;
import java.util.List;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.Nullable;

public class NamespacedKeyBridge_3 {
    public static boolean c(ConfigurationSectionBridge configurationSectionBridge) {
        return configurationSectionBridge.fo("equipment");
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2) {
        NamespacedKeyBridge_3.b(itemStackBuilder_4, configurationSectionBridge, pluginFileConfigurationHolder, string, string2, null);
    }

    static void a(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, NamespacedKey namespacedKey) {
        NamespacedKeyBridge_3.b(itemStackBuilder_4, configurationSectionBridge, pluginFileConfigurationHolder, string, string2, namespacedKey);
    }

    private static void b(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string2, String string4, @Nullable NamespacedKey namespacedKey) {
        EquipmentSlot equipmentSlot;
        if (!Version.isAtLeast((Version)Version.v1_21_3)) {
            throw new IllegalArgumentException("Error: 'equipment' is only available in 1.21.2+. File: " + pluginFileConfigurationHolder.nh());
        }
        @Nullable ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj("equipment");
        if (configurationSectionBridge2 == null && namespacedKey == null) {
            throw new IllegalArgumentException("Error: 'equipment' must be a section. File: " + pluginFileConfigurationHolder.nh());
        }
        EquipmentSlot equipmentSlot2 = ItemStackBridge_2.ad(itemStackBuilder_4.getType());
        String string5 = configurationSectionBridge2 == null ? null : configurationSectionBridge2.az("slot", namespacedKey == null && equipmentSlot2 != null ? equipmentSlot2.name() : null);
        EquipmentSlot equipmentSlot3 = equipmentSlot = namespacedKey != null ? EquipmentSlot.CHEST : PluginFileConfigurationHolder.a(string5, (T string3) -> CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string4 + "'. Error: Unknown 'equipment.slot' value '" + string3 + "'. File: " + pluginFileConfigurationHolder.nh()));
        if (namespacedKey != null && string5 != null && PluginFileConfigurationHolder.a(string5, (T string) -> {}) != EquipmentSlot.CHEST) {
            throw new IllegalArgumentException("Error: 'elytra' requires 'equipment.slot: CHEST'. File: " + pluginFileConfigurationHolder.nh());
        }
        if (equipmentSlot != null) {
            ConfigurationSection configurationSection;
            Boolean bl;
            NamespacedKey namespacedKey2;
            @Nullable String string6 = configurationSectionBridge2 == null ? null : configurationSectionBridge2.gV("id");
            @Nullable NamespacedKey namespacedKey3 = PluginFileConfigurationHolder.a(string6, string2, true, (T string3) -> CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string4 + "'. Error: Invalid 'equipment.id' value '" + string3 + "'. File: " + pluginFileConfigurationHolder.nh()));
            if (namespacedKey != null && string6 != null && namespacedKey3 == null) {
                throw new IllegalArgumentException("Error: 'elytra' has invalid explicit 'equipment.id: " + string6 + "'. File: " + pluginFileConfigurationHolder.nh());
            }
            if (namespacedKey != null && namespacedKey3 != null && !namespacedKey.equals((Object)namespacedKey3)) {
                throw new IllegalArgumentException("Error: 'elytra' requires 'equipment.id: " + String.valueOf(namespacedKey) + "'. File: " + pluginFileConfigurationHolder.nh());
            }
            NamespacedKey namespacedKey4 = namespacedKey2 = namespacedKey != null ? namespacedKey : namespacedKey3;
            if (namespacedKey2 != null && namespacedKey == null && ItemStackRegistry.g().a(namespacedKey2) == null) {
                throw new IllegalArgumentException("Error: Unknown 'equipment.id' value '" + String.valueOf(namespacedKey2) + "'. File: " + pluginFileConfigurationHolder.nh());
            }
            @Nullable NamespacedKey namespacedKey5 = PluginFileConfigurationHolder.a(configurationSectionBridge2 == null ? null : configurationSectionBridge2.gV("camera_overlay_id"), string2, true, (T string3) -> CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string4 + "'. Error: Unknown 'equipment.camera_overlay_id' value '" + string3 + "'. File: " + pluginFileConfigurationHolder.nh()));
            @Nullable String string7 = PluginFileConfigurationHolder.a(configurationSectionBridge2 == null ? null : configurationSectionBridge2.gV("sound"), true, () -> CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string4 + "'. Error: Unknown 'equipment.sound'. File: " + pluginFileConfigurationHolder.nh()));
            @Nullable List list = PluginFileConfigurationHolder.a(configurationSectionBridge2 == null ? List.of() : configurationSectionBridge2.hg("allowed_entities"), EntityType.class, true, true, (T string3) -> CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string4 + "'. Error: Unknown 'equipment.allowed_entities' value '" + string3 + "'. File: " + pluginFileConfigurationHolder.nh()));
            if (namespacedKey != null && configurationSectionBridge2 != null && configurationSectionBridge2.fo("allowed_entities") && (list == null || !list.contains(EntityType.PLAYER))) {
                throw new IllegalArgumentException("Error: 'elytra' requires 'equipment.allowed_entities' to include PLAYER. File: " + pluginFileConfigurationHolder.nh());
            }
            Boolean bl2 = bl = configurationSectionBridge2 == null ? null : configurationSectionBridge2.a("glider", (Boolean)null);
            if (namespacedKey != null && configurationSectionBridge2 != null && configurationSectionBridge2.fo("glider") && !Boolean.TRUE.equals(bl)) {
                throw new IllegalArgumentException("Error: 'elytra' requires 'equipment.glider: true'. File: " + pluginFileConfigurationHolder.nh());
            }
            itemStackBuilder_4.a(namespacedKey2, equipmentSlot, string7, namespacedKey5, list, configurationSectionBridge2 == null ? null : configurationSectionBridge2.a("dispensable", (Boolean)null), configurationSectionBridge2 == null ? null : configurationSectionBridge2.a("swappable", (Boolean)null), configurationSectionBridge2 == null ? null : configurationSectionBridge2.a("damage_on_hurt", (Boolean)null), NamespacedKeyBridge_3.a(namespacedKey != null, bl));
            ConfigurationSection configurationSection2 = configurationSection = configurationSectionBridge2 == null ? null : configurationSectionBridge2.hi("slot_attribute_modifiers");
            if (configurationSection != null) {
                for (String string8 : configurationSection.getKeys(false)) {
                    ConfigurationSectionBridge_4.a(itemStackBuilder_4, equipmentSlot.name().toLowerCase(), string8, configurationSection);
                }
            }
        }
    }

    @Nullable
    static Boolean a(boolean bl, @Nullable Boolean bl2) {
        return bl ? Boolean.TRUE : bl2;
    }
}
