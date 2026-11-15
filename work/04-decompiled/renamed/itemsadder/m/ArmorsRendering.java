package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.ColorBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.InstanceRegistry_9;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque140;
import itemsadder.m.PluginFileConfigurationHolder;
import java.util.Collection;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.configuration.ConfigurationSection;

final class ArmorsRendering {
    private ArmorsRendering() {
    }

    static void a(Collection collection, HashMap hashMap, HashMap hashMap2) {
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : collection) {
            if (!pluginFileConfigurationHolder.gP("armors_rendering") && !pluginFileConfigurationHolder.gP("legacy_armor_renderings")) continue;
            boolean bl = false;
            String string = pluginFileConfigurationHolder.az("info.namespace", null);
            ConfigurationSection configurationSection = pluginFileConfigurationHolder.k("armors_rendering", "legacy_armor_renderings");
            for (String string2 : configurationSection.getKeys(false)) {
                Object object;
                Color color = ColorBridge.iL(configurationSection.getString(string2 + ".color", null));
                if (color == null) {
                    CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "'color' property missing for legacy_armor_rendering '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                int n = color.asRGB();
                if (hashMap.containsKey(n)) {
                    CommandSenderBridge_5.warn(String.valueOf(ChatColor.YELLOW) + "legacy_armor_rendering '" + string2 + "' is using the same color as another render '" + ((ColorBridge_2)hashMap.get(n)).getNamespacedID() + "'. Trying to generate a new similar color...");
                    object = InstanceRegistry_9.b(n, hashMap);
                    if (object == null) {
                        CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "Failed to find a proper color for legacy_armor_rendering '" + string2 + "'. Decide another color. File: " + pluginFileConfigurationHolder.nh());
                    } else {
                        CommandSenderBridge_5.error(String.valueOf(ChatColor.GREEN) + "Fixed color for armors_render '" + string2 + "'. ");
                        n = (Integer)object;
                        color = ColorBridge.bQ(n);
                        if (pluginFileConfigurationHolder.gP("legacy_armor_rendering." + string2)) {
                            pluginFileConfigurationHolder.d("legacy_armor_rendering." + string2 + ".color", ColorBridge.bP(n));
                        } else if (pluginFileConfigurationHolder.gP("armors_rendering." + string2)) {
                            pluginFileConfigurationHolder.d("armors_rendering." + string2 + ".color", ColorBridge.bP(n));
                        }
                        bl = true;
                    }
                }
                object = new ColorBridge_2(pluginFileConfigurationHolder, string, string2, color, configurationSection.getString(string2 + ".layer_1", null), configurationSection.getString(string2 + ".layer_2", null), configurationSection.getString(string2 + ".emissive_1", null), configurationSection.getString(string2 + ".emissive_2", null), configurationSection.getBoolean(string2 + ".use_color", false), configurationSection.getInt(string2 + ".animation.speed", 24), configurationSection.getBoolean(string2 + ".animation.interpolation", false), configurationSection.getInt(string2 + ".emissive_type", 1));
                hashMap.put(n, object);
                hashMap2.put(((Opaque140)object).getNamespacedID(), object);
                if (!MaterialBarColorHolder.dz) continue;
                CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Items] Registered legacy_armor_rendering '" + string2 + "', color " + String.valueOf(((ColorBridge_2)object).HC));
            }
            if (!bl) continue;
            pluginFileConfigurationHolder.save();
            pluginFileConfigurationHolder.reload();
        }
    }
}
