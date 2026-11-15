package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.cy;
import itemsadder.m.ur;
import itemsadder.m.xk;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

final class c {
    private c() {
    }

    static void a(bbf bbf2, cy cy2) {
        ConfigurationSection configurationSection = bbf2.hi("dictionary");
        if (configurationSection == null) {
            if (Main.KO.gY("debug.other.log-dictionaries-loading")) {
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No dictionary found in file " + bbf2.nh());
            }
            return;
        }
        if (!bbf2.gP("info.dictionary-lang")) {
            bce.log(String.valueOf(ChatColor.RED) + "Error: No 'info.lang' property specified in file: " + bbf2.nh());
            return;
        }
        String string = bbf2.gV("info.dictionary-lang");
        if (string.equals("en")) {
            for (String string2 : configurationSection.getKeys(true)) {
                if (!(configurationSection.get(string2) instanceof String)) continue;
                cy2.l(string2, configurationSection.getString(string2));
            }
        } else if (string.equals(ae.cF)) {
            for (String string3 : configurationSection.getKeys(true)) {
                if (!(configurationSection.get(string3) instanceof String)) continue;
                cy2.k(string3, configurationSection.getString(string3));
            }
        } else if (Main.KO.gY("debug.other.log-dictionaries-loading")) {
            bce.log(String.valueOf(ChatColor.YELLOW) + "    Dictionary lang '" + string + "' not supported in file " + bbf2.nh());
        }
    }

    static void a(bbf bbf2, ur ur2) {
        ConfigurationSection configurationSection = bbf2.hi("minecraft_lang_overwrite");
        if (configurationSection == null) {
            if (Main.KO.gY("debug.other.log-minecraft_lang_overwrite-loading")) {
                bce.log(String.valueOf(ChatColor.YELLOW) + "    No 'minecraft_lang_overwrite' found in file " + bbf2.qd());
            }
            return;
        }
        for (String string : configurationSection.getKeys(false)) {
            ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection(string);
            if (configurationSection2 == null || !configurationSection2.getBoolean("enabled", true)) continue;
            List list = configurationSection2.getStringList("languages").contains("ALL") ? ur.LQ : configurationSection2.getStringList("languages");
            for (String string2 : list) {
                ConfigurationSection configurationSection3 = configurationSection2.getConfigurationSection("entries");
                if (configurationSection3 == null) continue;
                for (String string3 : configurationSection3.getKeys(true)) {
                    if (!(configurationSection3.get(string3) instanceof String)) continue;
                    ur2.d(string2, string3, bcy.gH(xk.replaceFontImages(configurationSection3.getString(string3))));
                }
            }
        }
    }
}
