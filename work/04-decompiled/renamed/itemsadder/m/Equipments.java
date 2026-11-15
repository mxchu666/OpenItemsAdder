package itemsadder.m;

import itemsadder.m.Assets;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Json;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfNamespacedKey_2;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;

final class Equipments {
    private Equipments() {
    }

    static void a(Collection collection, Map map, List list, List list2) {
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : collection) {
            String string;
            if (!pluginFileConfigurationHolder.gP("equipments") || (string = pluginFileConfigurationHolder.az("info.namespace", null)) == null) continue;
            ConfigurationSection configurationSection = pluginFileConfigurationHolder.hi("equipments");
            assert (configurationSection != null);
            for (String string2 : configurationSection.getKeys(false)) {
                Object object;
                if (!configurationSection.getString(string2 + ".renderer", "armor").equals("armor")) {
                    CommandSenderBridge_5.warn("For now only 'armor' renderer is supported for equipments. More will be implemented in the future. Skipping equipment '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                NamespacedKey namespacedKey = new NamespacedKey(string, string2);
                Object object2 = PluginFileConfigurationHolder.a(configurationSection.getString(string2 + ".layer_1"), false, () -> CommandSenderBridge_5.error("Missing 'layer_1' property for equipment '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh()));
                if (object2 == null || (object = PluginFileConfigurationHolder.a(configurationSection.getString(string2 + ".layer_2"), false, () -> CommandSenderBridge_5.error("Missing 'layer_2' property for equipment '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh()))) == null) continue;
                if (Assets.a(list, list2, Json.g(string, (String)object2)) == null) {
                    CommandSenderBridge_5.error("Can't find layer_1 '" + (String)object2 + "' texture file for equipment '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                if (Assets.a(list, list2, Json.g(string, (String)object)) == null) {
                    CommandSenderBridge_5.error("Can't find layer_2 '" + (String)object + "' texture file for equipment '" + string2 + "'. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                if (!((String)object2).contains(":")) {
                    object2 = string + ":" + (String)object2;
                }
                if (!((String)object).contains(":")) {
                    object = string + ":" + (String)object;
                }
                map.put(namespacedKey, new RecordOfNamespacedKey_2(namespacedKey, (String)object2, (String)object));
                CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "[Items] Registered equipment '" + string2 + "' with layers: " + (String)object2 + ", " + (String)object + ". File: " + pluginFileConfigurationHolder.nh());
            }
        }
    }
}
