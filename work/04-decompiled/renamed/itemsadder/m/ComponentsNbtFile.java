package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfValue_23;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import org.apache.commons.io.FileUtils;

public class ComponentsNbtFile {
    public static boolean c(ConfigurationSectionBridge configurationSectionBridge) {
        return configurationSectionBridge.fo("components_nbt_file") || configurationSectionBridge.fo("nbt");
    }

    public static void a(ItemStackBuilder_4 itemStackBuilder_4, ConfigurationSectionBridge configurationSectionBridge, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        String string;
        if (configurationSectionBridge.gP("nbt") && configurationSectionBridge.gP("components_nbt_file")) {
            CommandSenderBridge_5.warn("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Both 'nbt' and 'components_nbt_file' are set. 'nbt' will be ignored. File: " + pluginFileConfigurationHolder.nh());
        }
        if ((string = configurationSectionBridge.gV("components_nbt_file")) != null) {
            File file = new File(pluginFileConfigurationHolder.getFile().getParent(), string);
            if (file.exists()) {
                String string2 = null;
                try {
                    string2 = FileUtils.readFileToString((File)file, (Charset)StandardCharsets.UTF_8);
                }
                catch (IOException iOException) {
                    CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Error reading 'components_nbt_file' property. File: " + pluginFileConfigurationHolder.nh());
                    CommandSenderBridge_5.error("Error: " + iOException.getMessage());
                }
                if (string2 != null) {
                    try {
                        c.ji(string2);
                    }
                    catch (ExecutionException executionException) {
                        CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Error parsing 'components_nbt_file' property. File: " + pluginFileConfigurationHolder.nh());
                        CommandSenderBridge_5.error("Error: " + executionException.getMessage());
                    }
                    try {
                        itemStackBuilder_4.bE(ComponentsNbtFile.a(itemStackBuilder_4, string2, pluginFileConfigurationHolder));
                    }
                    catch (Exception exception) {
                        CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Error injecting 'components_nbt_file' property. File: " + pluginFileConfigurationHolder.nh());
                        CommandSenderBridge_5.error("Error: " + exception.getMessage());
                    }
                }
            } else {
                CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Error: 'components_nbt_file' not found. File: " + pluginFileConfigurationHolder.nh());
            }
        } else {
            String string3 = configurationSectionBridge.az("nbt", null);
            if (string3 != null) {
                try {
                    itemStackBuilder_4.bE(ComponentsNbtFile.a(itemStackBuilder_4, string3, pluginFileConfigurationHolder));
                }
                catch (Exception exception) {
                    CommandSenderBridge_5.error("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Error injecting 'nbt' property. File: " + pluginFileConfigurationHolder.nh());
                    CommandSenderBridge_5.error("Error: " + exception.getMessage());
                }
            }
        }
    }

    private static String a(ItemStackBuilder_4 itemStackBuilder_4, String string, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        boolean bl;
        float f;
        RecordOfValue_23 recordOfValue_23 = itemStackBuilder_4.nv();
        int n = recordOfValue_23 != null ? recordOfValue_23.nT() : 0;
        String string2 = ComponentsNbtFile.a(string, n, f = recordOfValue_23 != null ? recordOfValue_23.nU() : 0.0f, bl = Version.isNewerThan((Version)Version.v1_21_1));
        if (!string2.equals(string)) {
            CommandSenderBridge_5.warn("[Items] '" + itemStackBuilder_4.getNamespacedID() + "'. Incomplete or version-incompatible 'food'/'consumable' component. Using nutrition=" + n + " and saturation=" + f + (bl ? "." : "; unsupported 1.21.2+ consumable properties were ignored.") + " File: " + pluginFileConfigurationHolder.nh());
        }
        return string2;
    }

    static String a(String string, int n, float f, boolean bl) {
        try {
            JSONObject jSONObject = JSON.parseObject((String)string);
            JSONObject jSONObject2 = jSONObject.getJSONObject("components");
            if (jSONObject2 == null) {
                return string;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("minecraft:food");
            if (jSONObject3 == null) {
                jSONObject3 = jSONObject2.getJSONObject("food");
            }
            boolean bl2 = false;
            if (!bl) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject("minecraft:consumable");
                String string2 = "minecraft:consumable";
                if (jSONObject4 == null) {
                    jSONObject4 = jSONObject2.getJSONObject("consumable");
                    string2 = "consumable";
                }
                if (jSONObject4 != null) {
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                        jSONObject2.put((Object)"minecraft:food", (Object)jSONObject3);
                    }
                    if (!jSONObject3.containsKey("eat_seconds") && jSONObject4.containsKey("consume_seconds")) {
                        jSONObject3.put((Object)"eat_seconds", jSONObject4.get("consume_seconds"));
                    }
                    jSONObject2.remove((Object)string2);
                    bl2 = true;
                }
            }
            if (jSONObject3 == null) {
                return bl2 ? JSON.toJSONString((Object)jSONObject) : string;
            }
            if (!jSONObject3.containsKey("nutrition")) {
                jSONObject3.put((Object)"nutrition", (Object)n);
                bl2 = true;
            }
            if (!jSONObject3.containsKey("saturation")) {
                jSONObject3.put((Object)"saturation", (Object)Float.valueOf(f));
                bl2 = true;
            }
            return bl2 ? JSON.toJSONString((Object)jSONObject) : string;
        }
        catch (RuntimeException runtimeException) {
            return string;
        }
    }
}
