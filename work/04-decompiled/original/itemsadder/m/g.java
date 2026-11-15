package itemsadder.m;

import itemsadder.m.ad;
import itemsadder.m.b;
import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.ro;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;

final class g {
    private g() {
    }

    static void a(Collection collection, Map map, List list, List list2) {
        for (bbf bbf2 : collection) {
            String string;
            if (!bbf2.gP("equipments") || (string = bbf2.az("info.namespace", null)) == null) continue;
            ConfigurationSection configurationSection = bbf2.hi("equipments");
            assert (configurationSection != null);
            for (String string2 : configurationSection.getKeys(false)) {
                Object object;
                if (!configurationSection.getString(string2 + ".renderer", "armor").equals("armor")) {
                    bce.warn("For now only 'armor' renderer is supported for equipments. More will be implemented in the future. Skipping equipment '" + string2 + "'. File: " + bbf2.nh());
                    continue;
                }
                NamespacedKey namespacedKey = new NamespacedKey(string, string2);
                Object object2 = bbf.a(configurationSection.getString(string2 + ".layer_1"), false, () -> bce.error("Missing 'layer_1' property for equipment '" + string2 + "'. File: " + bbf2.nh()));
                if (object2 == null || (object = bbf.a(configurationSection.getString(string2 + ".layer_2"), false, () -> bce.error("Missing 'layer_2' property for equipment '" + string2 + "'. File: " + bbf2.nh()))) == null) continue;
                if (b.a(list, list2, ad.g(string, (String)object2)) == null) {
                    bce.error("Can't find layer_1 '" + (String)object2 + "' texture file for equipment '" + string2 + "'. File: " + bbf2.nh());
                    continue;
                }
                if (b.a(list, list2, ad.g(string, (String)object)) == null) {
                    bce.error("Can't find layer_2 '" + (String)object + "' texture file for equipment '" + string2 + "'. File: " + bbf2.nh());
                    continue;
                }
                if (!((String)object2).contains(":")) {
                    object2 = string + ":" + (String)object2;
                }
                if (!((String)object).contains(":")) {
                    object = string + ":" + (String)object;
                }
                map.put(namespacedKey, new ro(namespacedKey, (String)object2, (String)object));
                bce.log(String.valueOf(ChatColor.AQUA) + "[Items] Registered equipment '" + string2 + "' with layers: " + (String)object2 + ", " + (String)object + ". File: " + bbf2.nh());
            }
        }
    }
}
