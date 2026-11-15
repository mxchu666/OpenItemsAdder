package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.ColorBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.HeadEnum;
import itemsadder.m.InstanceRegistry_9;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBridge_6;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfValue_26;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

public class MaterialBridge_15 {
    public static boolean c(ConfigurationSectionBridge configurationSectionBridge) {
        return configurationSectionBridge.fo("specific_properties.armor") || configurationSectionBridge.fo("equipment.legacy_armor_rendering_id");
    }

    @Nullable
    public static RecordOfValue_26 a(Material material, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2) {
        String string3;
        if (material != null && !ItemStackBridge_2.ae(material)) {
            CommandSenderBridge_5.warn("[Items] '" + string + ":" + string2 + "'. Warning: Trying to create a custom legacy armor using an incompatible material. '" + String.valueOf(material) + "' is not a leather armor material. File: " + pluginFileConfigurationHolder.nh());
            material = null;
        }
        if (material == null && (material = MaterialBridge_6.a(HeadEnum.bQ(string3 = configurationSectionBridge.gP("equipment.slot") ? HeadEnum.bS(configurationSectionBridge.az("equipment.slot", null)) : configurationSectionBridge.az("specific_properties.armor.slot", null)))) == null) {
            CommandSenderBridge_5.error("[Items] '" + string + ":" + string2 + "'. Error: The slot '" + string3 + "' is not a valid armor slot. File: " + pluginFileConfigurationHolder.nh());
            return null;
        }
        boolean bl = false;
        Color color = ColorBridge.iL(configurationSectionBridge.az("specific_properties.armor.color", null));
        MaterialBridge_6 materialBridge_6 = new MaterialBridge_6(pluginFileConfigurationHolder, string, string2, material, color, configurationSectionBridge.C("specific_properties.armor.can_wear", true));
        Object object = configurationSectionBridge.az("specific_properties.armor.custom_armor", configurationSectionBridge.az("equipment.legacy_armor_rendering_id", null));
        if (object != null) {
            ColorBridge_2 colorBridge_2;
            if (!((String)object).contains(":")) {
                object = string + ":" + (String)object;
            }
            if ((colorBridge_2 = (ColorBridge_2)ItemStackRegistry.g().L.get(object)) != null) {
                if (MaterialBarColorHolder.dz) {
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "Set custom_armor '" + (String)object + "' for item '" + materialBridge_6.getNamespacedID() + "'. File: " + materialBridge_6.nh());
                }
                materialBridge_6.a(colorBridge_2);
            } else {
                CommandSenderBridge_5.error("[Items] '" + materialBridge_6.getNamespacedID() + "'. Error: Unknown custom_armor '" + (String)object + "'. File: " + materialBridge_6.nh());
            }
        }
        if (materialBridge_6.mB() == null && color != null) {
            int n = color.asRGB();
            HashMap hashMap = (HashMap)ItemStackRegistry.g().H.get((Object)materialBridge_6.Fs);
            if (hashMap != null && hashMap.containsKey(n)) {
                Integer n2;
                if (MaterialBarColorHolder.dz) {
                    CommandSenderBridge_5.warn(String.valueOf(ChatColor.YELLOW) + "Armor piece " + String.valueOf((Object)materialBridge_6.Fs) + " " + ((ItemStackBuilder_4)hashMap.get(n)).getNamespacedID() + " is using the same color as " + materialBridge_6.getNamespacedID() + ". Trying to generate a new similar color...");
                }
                if ((n2 = InstanceRegistry_9.b(n, hashMap)) == null) {
                    if (MaterialBarColorHolder.dz) {
                        CommandSenderBridge_5.error(String.valueOf(ChatColor.RED) + "Failed to find a proper color for armor piece " + String.valueOf((Object)materialBridge_6.Fs) + " " + materialBridge_6.getNamespacedID() + ". Decide another color. File: " + pluginFileConfigurationHolder.nh());
                    }
                } else {
                    if (MaterialBarColorHolder.dz) {
                        CommandSenderBridge_5.error(String.valueOf(ChatColor.GREEN) + "Fixed color for armor '" + materialBridge_6.getNamespacedID() + "'. File: " + pluginFileConfigurationHolder.nh());
                    }
                    materialBridge_6.setColor(ColorBridge.bQ(n2));
                    configurationSectionBridge.d("specific_properties.armor.color", (Object)ColorBridge.bP(n2));
                    ItemStackRegistry.g().H.computeIfAbsent(materialBridge_6.Fs, headEnum -> new HashMap()).put(n2, materialBridge_6);
                    bl = true;
                }
            } else {
                ItemStackRegistry.g().H.computeIfAbsent(materialBridge_6.Fs, headEnum -> new HashMap()).put(n, materialBridge_6);
            }
        }
        return new RecordOfValue_26(materialBridge_6, bl, material);
    }
}
