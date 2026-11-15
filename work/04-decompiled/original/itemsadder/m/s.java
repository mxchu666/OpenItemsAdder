package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.azg;
import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.rd;
import itemsadder.m.v;
import java.util.Collection;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.configuration.ConfigurationSection;

final class s {
    private s() {
    }

    static void a(Collection collection, HashMap hashMap, HashMap hashMap2) {
        for (bbf bbf2 : collection) {
            if (!bbf2.gP("armors_rendering") && !bbf2.gP("legacy_armor_renderings")) continue;
            boolean bl = false;
            String string = bbf2.az("info.namespace", null);
            ConfigurationSection configurationSection = bbf2.k("armors_rendering", "legacy_armor_renderings");
            for (String string2 : configurationSection.getKeys(false)) {
                Object object;
                Color color = bcy.iL(configurationSection.getString(string2 + ".color", null));
                if (color == null) {
                    bce.error(String.valueOf(ChatColor.RED) + "'color' property missing for legacy_armor_rendering '" + string2 + "'. File: " + bbf2.nh());
                    continue;
                }
                int n = color.asRGB();
                if (hashMap.containsKey(n)) {
                    bce.warn(String.valueOf(ChatColor.YELLOW) + "legacy_armor_rendering '" + string2 + "' is using the same color as another render '" + ((rd)hashMap.get(n)).getNamespacedID() + "'. Trying to generate a new similar color...");
                    object = azg.b(n, hashMap);
                    if (object == null) {
                        bce.error(String.valueOf(ChatColor.RED) + "Failed to find a proper color for legacy_armor_rendering '" + string2 + "'. Decide another color. File: " + bbf2.nh());
                    } else {
                        bce.error(String.valueOf(ChatColor.GREEN) + "Fixed color for armors_render '" + string2 + "'. ");
                        n = (Integer)object;
                        color = bcy.bQ(n);
                        if (bbf2.gP("legacy_armor_rendering." + string2)) {
                            bbf2.d("legacy_armor_rendering." + string2 + ".color", bcy.bP(n));
                        } else if (bbf2.gP("armors_rendering." + string2)) {
                            bbf2.d("armors_rendering." + string2 + ".color", bcy.bP(n));
                        }
                        bl = true;
                    }
                }
                object = new rd(bbf2, string, string2, color, configurationSection.getString(string2 + ".layer_1", null), configurationSection.getString(string2 + ".layer_2", null), configurationSection.getString(string2 + ".emissive_1", null), configurationSection.getString(string2 + ".emissive_2", null), configurationSection.getBoolean(string2 + ".use_color", false), configurationSection.getInt(string2 + ".animation.speed", 24), configurationSection.getBoolean(string2 + ".animation.interpolation", false), configurationSection.getInt(string2 + ".emissive_type", 1));
                hashMap.put(n, object);
                hashMap2.put(((v)object).getNamespacedID(), object);
                if (!ae.dz) continue;
                bce.log(String.valueOf(ChatColor.AQUA) + "[Items] Registered legacy_armor_rendering '" + string2 + "', color " + String.valueOf(((rd)object).HC));
            }
            if (!bl) continue;
            bbf2.save();
            bbf2.reload();
        }
    }
}
