package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PluginFileConfigurationHolder;

public class Durability {
    public static boolean c(ConfigurationSectionBridge configurationSectionBridge) {
        return configurationSectionBridge.fo("durability");
    }

    public static boolean b(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2) {
        boolean bl;
        boolean bl2 = configurationSectionBridge.C("durability.disappear_when_broken", true);
        boolean bl3 = configurationSectionBridge.C("durability.unbreakable", false);
        boolean bl4 = configurationSectionBridge.gP("durability.durability") || configurationSectionBridge.gP("durability.custom_durability");
        boolean bl5 = bl = configurationSectionBridge.gP("durability.max_durability") || configurationSectionBridge.gP("durability.max_custom_durability");
        if (bl4 || bl) {
            int n = configurationSectionBridge.t("durability.max_durability", configurationSectionBridge.t("durability.max_custom_durability", itemStackBuilder_4.getType().getMaxDurability()));
            int n2 = configurationSectionBridge.t("durability.custom_durability", configurationSectionBridge.t("durability.durability", n));
            if (bl && !bl4) {
                n2 = n;
            }
            if (bl4 && !bl) {
                n = ItemStackBridge_2.E(itemStackBuilder_4);
            }
            if (n <= 0) {
                CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: 'max_durability' must be > 0. File: " + pluginFileConfigurationHolder.nh());
                return false;
            }
            if (n2 < 0) {
                CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "' - Error: 'durability' must >= 0. File: " + pluginFileConfigurationHolder.nh());
                return false;
            }
            if (n2 > n) {
                CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "' - Error: 'durability' must be <= 'max_durability'. File: " + pluginFileConfigurationHolder.nh());
                return false;
            }
            itemStackBuilder_4.a(n2, n, bl2, bl3);
        } else {
            itemStackBuilder_4.a(null, null, bl2, bl3);
        }
        return true;
    }
}
