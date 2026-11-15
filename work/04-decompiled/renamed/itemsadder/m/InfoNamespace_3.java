package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.Opaque145;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.StringClassBoolData;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;

public class InfoNamespace_3 {
    static Map Kl = new HashMap();

    public static void az(boolean bl) {
        if (bl) {
            InfoNamespace_3.px();
        }
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        for (PluginFileConfigurationHolder pluginFileConfigurationHolder : itemStackRegistry.b()) {
            String string = pluginFileConfigurationHolder.gV("info.namespace");
            itemStackRegistry.Z.add(string);
            List list = pluginFileConfigurationHolder.gR("scripts");
            if (list == null) {
                if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No script found in file " + pluginFileConfigurationHolder.qd());
                continue;
            }
            BossBarBridge_2.bf("Scripts '" + string + "'...");
            for (String string2 : list) {
                Object object;
                Object object2;
                ConfigurationSectionBridge configurationSectionBridge = pluginFileConfigurationHolder.hj("scripts." + string2);
                assert (configurationSectionBridge != null);
                if (!configurationSectionBridge.C("enabled", true)) {
                    if (!Main.KO.gY("debug.items.log-items-loading-disabled")) continue;
                    CommandSenderBridge_5.log("    Ignored disabled script: " + string2 + ", namespace: " + string);
                    continue;
                }
                if (Main.KO.gY("debug.items.log-items-loading")) {
                    CommandSenderBridge_5.log("    Loading script: " + string2);
                }
                if (!r.ex(string2)) {
                    CommandSenderBridge_5.error("[Items] Non [a-z0-9_.-] character in script '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    r.ym();
                    continue;
                }
                String string3 = configurationSectionBridge.gV("path");
                if (string3 == null) {
                    CommandSenderBridge_5.error("[Items] No path found for script '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                String[] stringArray = new String[]{".java", ".jspp", ".js"};
                File file = null;
                Object object3 = stringArray;
                int n = ((String[])object3).length;
                for (int i = 0; i < n && !(file = new File(new File(ItemStackRegistry.l, string), (String)(object2 = string3.endsWith((String)(object = object3[i])) ? string3 : string3 + (String)object))).exists(); ++i) {
                }
                if (!file.exists()) {
                    CommandSenderBridge_5.error("[Items] Script '" + string + ":" + string2 + "' not found in yml file: " + pluginFileConfigurationHolder.nh());
                    continue;
                }
                object3 = string + ":" + string2;
                if (Kl.containsKey(object3)) {
                    CommandSenderBridge_5.warn("[Scripts] '" + (String)object3 + "' is already loaded. Skipping (" + String.valueOf(file) + ")");
                    continue;
                }
                String string4 = null;
                FileTime fileTime = null;
                try {
                    string4 = Files.readString(file.toPath());
                    fileTime = Files.getLastModifiedTime(file.toPath(), new LinkOption[0]);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                if (string4 == null) continue;
                object = object3;
                if (file.getName().endsWith(".java")) {
                    if (((String)object).contains(":")) {
                        object = ((String)object).substring(((String)object).indexOf(58) + 1);
                    }
                } else {
                    object = ((String)object).replace(":", "_").replace("-", "_").replace(".", "_");
                }
                try {
                    object2 = ItemStackRegistry.g().A.a(file, string4, (String)object, fileTime);
                    if (!((Opaque145)object2).rC()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Object object4 : ((Opaque145)object2).rz()) {
                            stringBuilder.append((String)object4).append("\n");
                        }
                        CommandSenderBridge_5.warn("Errors compiling script: " + String.valueOf(file) + "\n" + String.valueOf(stringBuilder));
                        for (Object object4 : ((Opaque145)object2).rA()) {
                            if (object4 == null) continue;
                            CommandSenderBridge_5.warn("Trace: " + ((Throwable)object4).getMessage());
                            for (StackTraceElement stackTraceElement : ((Throwable)object4).getStackTrace()) {
                                CommandSenderBridge_5.warn("    at " + String.valueOf(stackTraceElement));
                            }
                        }
                        if (!((Opaque145)object2).rD()) continue;
                        CommandSenderBridge_5.error("[Scripts] '" + (String)object3 + "' is disabled due to serious compilation errors");
                        configurationSectionBridge.d("enabled", false);
                        pluginFileConfigurationHolder.save();
                        continue;
                    }
                    Kl.put(object3, ((Opaque145)object2).ry());
                    CommandSenderBridge_5.log("[Scripts] '" + (String)object3 + "' loaded in " + ((Opaque145)object2).rB() + "ms");
                }
                catch (Exception exception) {
                    CommandSenderBridge_5.warn("Unexpected exception compiling script: " + String.valueOf(file), exception);
                }
            }
        }
    }

    public static void px() {
        Kl.clear();
    }

    public static StringClassBoolData ck(String string) {
        return (StringClassBoolData)Kl.get(string);
    }
}
