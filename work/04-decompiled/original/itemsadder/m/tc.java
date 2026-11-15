package itemsadder.m;

import itemsadder.m.aiq;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.qm;
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

public class tc {
    public static boolean r(qm qm2) {
        return qm2.getType() == Material.POTION || qm2.getType() == Material.SPLASH_POTION || qm2.getType() == Material.LINGERING_POTION;
    }

    public static void a(qm qm2, bbg bbg2, bbf bbf2) {
        String string;
        int n;
        String string2 = bbg2.az("specific_properties.potion.type", null);
        PotionType potionType = null;
        if (string2 != null && (potionType = bbf.gL(string2)) == null) {
            bce.error("[Items] '" + qm2.getNamespacedID() + "'. Unknown 'type: '" + string2 + "' for potion. File: " + bbf2.nh());
        }
        if ((n = bcy.iN(string = bbg2.az("specific_properties.potion.color", "WHITE"))) == -1) {
            bce.error("[Items] '" + qm2.getNamespacedID() + "'. Missing potion.color '" + string + ". File: " + bbf2.nh());
        }
        PotionMeta potionMeta = (PotionMeta)qm2.getItemMeta();
        potionMeta.clearCustomEffects();
        potionMeta.setBasePotionType(potionType);
        if (bbg2.gP("specific_properties.potion.effects")) {
            ConfigurationSection configurationSection = bbg2.hi("specific_properties.potion.effects");
            for (String string3 : configurationSection.getKeys(false)) {
                String string4 = configurationSection.getString(string3 + ".type", null);
                if (string4 == null) {
                    bce.error("[Items] '" + qm2.getNamespacedID() + "'. Missing 'type' for custom potion effect. File: " + bbf2.nh());
                    continue;
                }
                PotionEffectType potionEffectType = null;
                if (!string4.contains(":")) {
                    potionEffectType = bbf.hb(string4);
                } else {
                    String[] stringArray = string4.split(":");
                    potionEffectType = PotionEffectType.getByKey((NamespacedKey)new NamespacedKey(stringArray[0], stringArray[1]));
                }
                if (potionEffectType == null) {
                    bce.error("[Items] '" + qm2.getNamespacedID() + "'. Unknown 'type' for custom potion effect. File: " + bbf2.nh());
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
        qm2.setItemMeta((ItemMeta)potionMeta);
        if (qm2.getType() == Material.POTION) {
            aiq.tX().Z(qm2);
        }
    }
}
