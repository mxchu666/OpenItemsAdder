package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBridge_12;
import itemsadder.m.NamespacedKeyBridge_3;
import itemsadder.m.Opaque140;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfNamespacedKey;
import itemsadder.m.RecordOfNamespacedKey_2;
import itemsadder.m.RecordOfValue_24;
import java.util.function.Predicate;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.Nullable;

public final class ConfigurationSectionBridge_3 {
    private ConfigurationSectionBridge_3() {
    }

    public static boolean c(ConfigurationSectionBridge configurationSectionBridge) {
        return configurationSectionBridge.fo("elytra");
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string2, String string3) {
        if (!Version.isAtLeast((Version)Version.v1_21_3)) {
            throw new IllegalArgumentException("'elytra' is only available in 1.21.2+. File: " + pluginFileConfigurationHolder.nh());
        }
        ConfigurationSection configurationSection = configurationSectionBridge.hi("elytra");
        if (configurationSection == null) {
            throw new IllegalArgumentException("'elytra' must be a section. File: " + pluginFileConfigurationHolder.nh());
        }
        NamespacedKey namespacedKey = new NamespacedKey(string2, string3);
        RecordOfNamespacedKey recordOfNamespacedKey = ConfigurationSectionBridge_3.a(configurationSection, string2, namespacedKey, ConfigurationSectionBridge_3.o(itemStackBuilder_4), (T string) -> ItemStackRegistry.t(string) != null);
        NamespacedKeyBridge_3.a(itemStackBuilder_4, configurationSectionBridge, pluginFileConfigurationHolder, string2, string3, namespacedKey);
        itemStackBuilder_4.a(recordOfNamespacedKey);
        if (itemStackBuilder_4.FX != null) {
            itemStackBuilder_4.FX.a(recordOfNamespacedKey);
        }
        ItemStackRegistry.g().F().put(namespacedKey, RecordOfNamespacedKey_2.a(namespacedKey, recordOfNamespacedKey.oo()));
    }

    static RecordOfNamespacedKey a(ConfigurationSection configurationSection, String string, NamespacedKey namespacedKey, @Nullable String string2, Predicate predicate) {
        String string3 = ConfigurationSectionBridge_3.a(configurationSection.get("wings_texture"), string, "elytra.wings_texture", false);
        if (!predicate.test(string3)) {
            throw new IllegalArgumentException("Can't find 'elytra.wings_texture' texture '" + string3 + "'.");
        }
        String string4 = ConfigurationSectionBridge_3.a(configurationSection.get("broken_item_texture"), string, "elytra.broken_item_texture", true);
        String string5 = ConfigurationSectionBridge_3.a(string2, string4, predicate);
        if (string4 != null && string5 == null) {
            throw new IllegalArgumentException("Can't find 'elytra.broken_item_texture' texture '" + string4 + "'.");
        }
        int n = ConfigurationSectionBridge_3.a(configurationSection, "max_flight_ticks", 0);
        int n2 = ConfigurationSectionBridge_3.a(configurationSection, "firework.cooldown_ticks", 0);
        double d = ConfigurationSectionBridge_3.a(configurationSection, "durability_damage_multiplier", 1.0);
        double d2 = ConfigurationSectionBridge_3.a(configurationSection, "collision_damage_multiplier", 1.0);
        return new RecordOfNamespacedKey(namespacedKey, string3, string5, n, new RecordOfValue_24(configurationSection.getBoolean("firework.enabled", true), configurationSection.getBoolean("firework.consume", true), n2), d, d2);
    }

    @Nullable
    static String a(@Nullable String string, @Nullable String string2, Predicate predicate) {
        if (string2 != null) {
            return predicate.test(string2) ? string2 : null;
        }
        if (string == null) {
            return null;
        }
        String string3 = string.replaceFirst("\\.png$", "") + "_broken";
        return predicate.test(string3) ? string3 : null;
    }

    private static int a(ConfigurationSection configurationSection, String string, int n) {
        Number number;
        Object object = configurationSection.get(string);
        if (object == null) {
            return n;
        }
        if (!(object instanceof Number) || !Double.isFinite((number = (Number)object).doubleValue()) || number.doubleValue() < 0.0 || number.doubleValue() != Math.rint(number.doubleValue()) || number.doubleValue() > 2.147483647E9) {
            throw new IllegalArgumentException("'elytra." + string + "' must be a non-negative integer.");
        }
        return number.intValue();
    }

    private static double a(ConfigurationSection configurationSection, String string, double d) {
        Number number;
        Object object = configurationSection.get(string);
        if (object == null) {
            return d;
        }
        if (!(object instanceof Number) || !Double.isFinite((number = (Number)object).doubleValue()) || number.doubleValue() < 0.0) {
            throw new IllegalArgumentException("'elytra." + string + "' must be a non-negative finite number.");
        }
        return number.doubleValue();
    }

    @Nullable
    private static String a(@Nullable Object object, String string, String string2, boolean bl) {
        String string3;
        if (object == null && bl) {
            return null;
        }
        if (!(object instanceof String) || (string3 = (String)object).isBlank()) {
            throw new IllegalArgumentException("'" + string2 + "' must be a resource path.");
        }
        String string4 = Opaque140.i(string3.replaceFirst("\\.png$", ""), string);
        if (string4 == null) {
            throw new IllegalArgumentException("'" + string2 + "' has invalid resource path '" + string3 + "'.");
        }
        return string4;
    }

    @Nullable
    private static String o(ItemStackBuilder_4 itemStackBuilder_4) {
        Object object = itemStackBuilder_4.FX;
        if (object instanceof MaterialBridge_12) {
            MaterialBridge_12 materialBridge_12 = (MaterialBridge_12)object;
            String string = (String)(object = materialBridge_12.oD()).get("normal");
            if (string == null) {
                string = (String)object.get("layer0");
            }
            if (string == null) {
                string = object.values().stream().findFirst().orElse(null);
            }
            return string;
        }
        if (itemStackBuilder_4.FX != null || itemStackBuilder_4.getTextures() == null || itemStackBuilder_4.getTextures().isEmpty()) {
            return null;
        }
        return (String)itemStackBuilder_4.getTextures().getFirst();
    }
}
