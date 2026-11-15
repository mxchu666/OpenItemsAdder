package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.KabKab;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque109;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PluginFileConfigurationHolder;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

final class Dictionary {
    private Dictionary() {
    }

    static void a(PluginFileConfigurationHolder pluginFileConfigurationHolder, Opaque109 opaque109) {
        ConfigurationSection configurationSection = pluginFileConfigurationHolder.hi("dictionary");
        if (configurationSection == null) {
            if (Main.KO.gY("debug.other.log-dictionaries-loading")) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No dictionary found in file " + pluginFileConfigurationHolder.nh());
            }
            return;
        }
        if (!pluginFileConfigurationHolder.gP("info.dictionary-lang")) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.RED) + "Error: No 'info.lang' property specified in file: " + pluginFileConfigurationHolder.nh());
            return;
        }
        String string = pluginFileConfigurationHolder.gV("info.dictionary-lang");
        if (string.equals("en")) {
            for (String string2 : configurationSection.getKeys(true)) {
                if (!(configurationSection.get(string2) instanceof String)) continue;
                opaque109.l(string2, configurationSection.getString(string2));
            }
        } else if (string.equals(MaterialBarColorHolder.cF)) {
            for (String string3 : configurationSection.getKeys(true)) {
                if (!(configurationSection.get(string3) instanceof String)) continue;
                opaque109.k(string3, configurationSection.getString(string3));
            }
        } else if (Main.KO.gY("debug.other.log-dictionaries-loading")) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    Dictionary lang '" + string + "' not supported in file " + pluginFileConfigurationHolder.nh());
        }
    }

    static void a(PluginFileConfigurationHolder pluginFileConfigurationHolder, KabKab kabKab) {
        ConfigurationSection configurationSection = pluginFileConfigurationHolder.hi("minecraft_lang_overwrite");
        if (configurationSection == null) {
            if (Main.KO.gY("debug.other.log-minecraft_lang_overwrite-loading")) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No 'minecraft_lang_overwrite' found in file " + pluginFileConfigurationHolder.qd());
            }
            return;
        }
        for (String string : configurationSection.getKeys(false)) {
            ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection(string);
            if (configurationSection2 == null || !configurationSection2.getBoolean("enabled", true)) continue;
            List list = configurationSection2.getStringList("languages").contains("ALL") ? KabKab.LQ : configurationSection2.getStringList("languages");
            for (String string2 : list) {
                ConfigurationSection configurationSection3 = configurationSection2.getConfigurationSection("entries");
                if (configurationSection3 == null) continue;
                for (String string3 : configurationSection3.getKeys(true)) {
                    if (!(configurationSection3.get(string3) instanceof String)) continue;
                    kabKab.d(string2, string3, ColorBridge.gH(PermissibleBridge_2.replaceFontImages(configurationSection3.getString(string3))));
                }
            }
        }
    }
}
