package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.FloatData;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ListFloatData;
import itemsadder.m.Opaque002;
import itemsadder.m.Opaque003;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfPotionEffectType;
import itemsadder.m.SetData;
import itemsadder.m.StringData;
import java.util.ArrayList;
import java.util.HashSet;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.Nullable;

public class Consumable {
    public static boolean c(ConfigurationSectionBridge configurationSectionBridge) {
        return configurationSectionBridge.gP("food") || configurationSectionBridge.gP("consumable");
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder, String string2, String string3) {
        ConfigurationSectionBridge configurationSectionBridge2 = configurationSectionBridge.hj("food");
        if (configurationSectionBridge2 == null) {
            configurationSectionBridge2 = configurationSectionBridge.hj("consumable");
        }
        assert (configurationSectionBridge2 != null);
        boolean bl = Version.isNewerThan((Version)Version.v1_21_1);
        @Nullable String string4 = configurationSectionBridge2.gV("animation");
        @Nullable String string5 = configurationSectionBridge2.az("sound", null);
        @Nullable Boolean bl2 = configurationSectionBridge2.a("particles", (Boolean)null);
        ArrayList<Opaque003> arrayList = null;
        ConfigurationSectionBridge configurationSectionBridge3 = configurationSectionBridge2.hj("effects");
        if (bl) {
            if (string4 != null) {
                string4 = string4.toLowerCase();
                switch (string4) {
                    case "none": 
                    case "eat": 
                    case "drink": 
                    case "block": 
                    case "bow": 
                    case "spear": 
                    case "crossbow": 
                    case "spyglass": 
                    case "toot_horn": 
                    case "brush": {
                        break;
                    }
                    default: {
                        CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown 'animation' value '" + string4 + "'. File: " + pluginFileConfigurationHolder.nh());
                        string4 = null;
                    }
                }
            }
            if (string5 == null && string4 != null && string4.equalsIgnoreCase("drink")) {
                string5 = "entity.generic.drink";
                if (bl2 == null) {
                    bl2 = false;
                }
            }
            if (configurationSectionBridge3 != null) {
                arrayList = new ArrayList<Opaque003>();
                for (String string6 : configurationSectionBridge2.gR("effects")) {
                    PotionEffectType potionEffectType;
                    Object object;
                    ArrayList<RecordOfPotionEffectType> arrayList2;
                    ConfigurationSectionBridge configurationSectionBridge4 = configurationSectionBridge3.hj(string6);
                    assert (configurationSectionBridge4 != null);
                    if (string6.startsWith("apply_status_effects")) {
                        if (configurationSectionBridge4.gR("effects").isEmpty()) {
                            CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'apply_status_effects' is missing 'effects' property. File: " + pluginFileConfigurationHolder.nh());
                        }
                        arrayList2 = new ArrayList<RecordOfPotionEffectType>();
                        for (Object object2 : configurationSectionBridge4.gR("effects")) {
                            object = configurationSectionBridge4.hj("effects." + (String)object2);
                            potionEffectType = PluginFileConfigurationHolder.hb(((ConfigurationSectionBridge)object).gV("potion"));
                            if (potionEffectType == null) {
                                CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown 'potion' effect type '" + ((ConfigurationSectionBridge)object).gV("potion") + "'. File: " + pluginFileConfigurationHolder.nh());
                                continue;
                            }
                            arrayList2.add(new RecordOfPotionEffectType(potionEffectType, ((ConfigurationSectionBridge)object).gW("duration"), ((ConfigurationSectionBridge)object).gW("amplifier"), ((ConfigurationSectionBridge)object).hq("ambient"), ((ConfigurationSectionBridge)object).C("particles", true), ((ConfigurationSectionBridge)object).C("icon", ((ConfigurationSectionBridge)object).C("show_icon", true))));
                        }
                        arrayList.add(new ListFloatData(arrayList2, configurationSectionBridge4.a("probability", 1.0f)));
                        continue;
                    }
                    if (string6.startsWith("remove_status_effects")) {
                        Object object2;
                        arrayList2 = configurationSectionBridge4.hg("effects");
                        if (!arrayList2.isEmpty()) continue;
                        CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'remove_status_effects' is missing 'effects' property. File: " + pluginFileConfigurationHolder.nh());
                        HashSet hashSet = new HashSet();
                        object2 = arrayList2.iterator();
                        while (object2.hasNext()) {
                            object = (String)object2.next();
                            potionEffectType = PluginFileConfigurationHolder.hb((String)object);
                            if (potionEffectType == null) {
                                CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown 'potion' effect type '" + configurationSectionBridge4.gV("potion") + "'. File: " + pluginFileConfigurationHolder.nh());
                                continue;
                            }
                            hashSet.add(potionEffectType);
                        }
                        arrayList.add(new SetData(hashSet));
                        continue;
                    }
                    if (string6.startsWith("play_sound")) {
                        if (configurationSectionBridge4.gP("sound")) {
                            arrayList.add(new StringData(configurationSectionBridge4.az("sound", null)));
                            continue;
                        }
                        CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'play_sound' is missing 'sound' property. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    if (string6.startsWith("teleport_randomly")) {
                        if (arrayList.stream().noneMatch(opaque003 -> opaque003 instanceof FloatData)) {
                            arrayList.add(new FloatData(configurationSectionBridge4.a("diameter", 5.0f)));
                            continue;
                        }
                        CommandSenderBridge_5.warn("[Items] '" + string2 + ":" + string3 + "'. Warning: 'teleport_randomly' is already set. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    if (string6.startsWith("clear_all_status_effects")) {
                        if (arrayList.stream().noneMatch(opaque003 -> opaque003 instanceof Opaque002)) {
                            arrayList.add(new Opaque002());
                            continue;
                        }
                        CommandSenderBridge_5.warn("[Items] '" + string2 + ":" + string3 + "'. Warning: 'clear_all_status_effects' is already set. File: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: Unknown effect type '" + string6 + "'. File: " + pluginFileConfigurationHolder.nh());
                }
            }
        } else {
            if (string4 != null) {
                CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'animation' is only available in 1.21.2+. File: " + pluginFileConfigurationHolder.nh());
            }
            if (string5 != null) {
                CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'sound' is only available in 1.21.2+. File: " + pluginFileConfigurationHolder.nh());
            }
            if (bl2 != null && bl2.booleanValue()) {
                CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: 'particles' is only available in 1.21.2+. File: " + pluginFileConfigurationHolder.nh());
            }
            if (configurationSectionBridge3 != null && configurationSectionBridge2.gR("effects").stream().anyMatch(string -> string.startsWith("remove_status_effect") || string.startsWith("teleport_randomly") || string.startsWith("clear_all_status_effects"))) {
                CommandSenderBridge_5.error("[Items] '" + string2 + ":" + string3 + "'. Error: some consumable 'effects' are only available in 1.21.2+. File: " + pluginFileConfigurationHolder.nh());
            }
        }
        itemStackBuilder_4.a(itemStackBuilder_4, configurationSectionBridge2.gW("nutrition"), configurationSectionBridge2.a("saturation", configurationSectionBridge2.gX("saturation_modifier")), configurationSectionBridge2.hq("can_always_eat"), configurationSectionBridge2.t("consume_seconds", configurationSectionBridge2.t("eat_seconds", 2)), string4, string5, bl2, arrayList);
    }
}
