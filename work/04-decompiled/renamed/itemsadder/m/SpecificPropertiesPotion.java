package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PluginFileConfigurationHolder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class SpecificPropertiesPotion {
    public static boolean r(ItemStackBuilder_4 itemStackBuilder_4) {
        return itemStackBuilder_4.getType() == Material.POTION || itemStackBuilder_4.getType() == Material.SPLASH_POTION || itemStackBuilder_4.getType() == Material.LINGERING_POTION;
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        String string;
        int n;
        String string2 = configurationSectionBridge.az("specific_properties.potion.type", null);
        PotionType potionType = null;
        if (string2 != null && (potionType = PluginFileConfigurationHolder.gL(string2)) == null) {
            CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Unknown 'type: '" + string2 + "' for potion. File: " + pluginFileConfigurationHolder.nh());
        }
        if ((n = ColorBridge.iN(string = configurationSectionBridge.az("specific_properties.potion.color", "WHITE"))) == -1) {
            CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Missing potion.color '" + string + ". File: " + pluginFileConfigurationHolder.nh());
        }
        PotionMeta potionMeta = (PotionMeta)itemStackBuilder_4.getItemMeta();
        potionMeta.clearCustomEffects();
        potionMeta.setBasePotionType(potionType);
        if (configurationSectionBridge.gP("specific_properties.potion.effects")) {
            ConfigurationSection configurationSection = configurationSectionBridge.hi("specific_properties.potion.effects");
            for (String string3 : configurationSection.getKeys(false)) {
                String string4 = configurationSection.getString(string3 + ".type", null);
                if (string4 == null) {
                    CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Missing 'type' for custom potion effect. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                PotionEffectType potionEffectType = null;
                if (!string4.contains(":")) {
                    potionEffectType = PluginFileConfigurationHolder.hb(string4);
                } else {
                    String[] stringArray = string4.split(":");
                    potionEffectType = PotionEffectType.getByKey((NamespacedKey)new NamespacedKey(stringArray[0], stringArray[1]));
                }
                if (potionEffectType == null) {
                    CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Unknown 'type' for custom potion effect. File: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                int n2 = configurationSection.getInt(string3 + ".duration", 0);
                int n3 = configurationSection.getInt(string3 + ".amplifier", 0);
                boolean bl = configurationSection.getBoolean(string3 + ".ambient", false);
                boolean bl2 = configurationSection.getBoolean(string3 + ".particles", true);
                boolean bl3 = configurationSection.getBoolean(string3 + ".icon", true);
                potionMeta.addCustomEffect(new PotionEffect(potionEffectType, n2, n3, bl, bl2, bl3), false);
            }
        } else {
            potionMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ADDITIONAL_TOOLTIP});
        }
        if (n != -1) {
            potionMeta.setColor(Color.fromRGB((int)n));
        }
        itemStackBuilder_4.setItemMeta((ItemMeta)potionMeta);
        if (itemStackBuilder_4.getType() == Material.POTION) {
            PlayerHolder_2.tX().Z(itemStackBuilder_4);
        }
    }
}
