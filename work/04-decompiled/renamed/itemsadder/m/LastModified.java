package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.BossBarBridge_2;
import itemsadder.m.BukkitTaskHolder;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ConfigurationSectionBridge;
import itemsadder.m.EnumWrappersHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecordOfStringBuilder;
import itemsadder.m.RecordOfStringBuilder_2;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class LastModified {
    private static final Map Kn = new HashMap();
    private static final Map Ko = new HashMap();

    public static File py() {
        return new File(Main.rS().getDataFolder(), "storage" + File.separator + "cache" + File.separator + "tmp_ogg");
    }

    public static PluginFileConfigurationHolder pz() {
        File file = LastModified.py();
        @Nullable PluginFileConfigurationHolder pluginFileConfigurationHolder = new PluginFileConfigurationHolder((Plugin)Main.rS(), true, "storage/cache/tmp_ogg/info.yml", false, false);
        if (!file.exists() && !file.mkdirs()) {
            CommandSenderBridge_5.error("Failed to create tmp folder for ogg sounds: " + file.getAbsolutePath());
        }
        return pluginFileConfigurationHolder;
    }

    public static ConfigurationSectionBridge a(PluginFileConfigurationHolder pluginFileConfigurationHolder, File file) {
        return pluginFileConfigurationHolder.hk(ColorBridge.iW(file.getAbsolutePath()));
    }

    public static ConfigurationSectionBridge k(File file) {
        return LastModified.pz().hk(ColorBridge.iW(file.getAbsolutePath()));
    }

    @Nullable
    public static Float b(PluginFileConfigurationHolder pluginFileConfigurationHolder, File file) {
        ConfigurationSectionBridge configurationSectionBridge = LastModified.a(pluginFileConfigurationHolder, file);
        if (configurationSectionBridge.a("last_modified", 0L) >= file.lastModified() && configurationSectionBridge.gP("duration")) {
            return configurationSectionBridge.a("duration", (Float)null);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void aR() {
        try {
            Kn.clear();
            Ko.clear();
            ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
            for (PluginFileConfigurationHolder pluginFileConfigurationHolder : itemStackRegistry.b()) {
                PluginFileConfigurationHolder pluginFileConfigurationHolder2;
                String string2 = pluginFileConfigurationHolder.gV("info.namespace");
                itemStackRegistry.Z.add(string2);
                try {
                    pluginFileConfigurationHolder2 = pluginFileConfigurationHolder.g('~');
                }
                catch (IOException | InvalidConfigurationException throwable) {
                    CommandSenderBridge_5.error("[Items] Failed to load sounds config file: " + pluginFileConfigurationHolder.qd(), throwable);
                    Kn.clear();
                    return;
                }
                List list2 = pluginFileConfigurationHolder2.gR("sounds");
                if (list2.isEmpty()) {
                    if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                    CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "    No sound found in file " + pluginFileConfigurationHolder.qd());
                    continue;
                }
                BossBarBridge_2.bf("Sounds '" + string2 + "'...");
                for (String string3 : list2) {
                    Object object;
                    Object object2;
                    ConfigurationSectionBridge configurationSectionBridge = pluginFileConfigurationHolder.hj("sounds." + string3);
                    assert (configurationSectionBridge != null);
                    if (!configurationSectionBridge.C("enabled", true)) {
                        if (!Main.KO.gY("debug.items.log-items-loading-disabled")) continue;
                        CommandSenderBridge_5.log("    Ignored disabled sound: " + string3 + ", namespace: " + string2);
                        continue;
                    }
                    if (Main.KO.gY("debug.items.log-items-loading")) {
                        CommandSenderBridge_5.log("    Loading sound: " + string3);
                    }
                    if (!r.ez(string3)) {
                        CommandSenderBridge_5.error("[Items] Non [a-z0-9_.-] character in sound '" + string2 + ":" + string3 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                        r.ym();
                        continue;
                    }
                    @Nullable String string4 = configurationSectionBridge.az("settings.subtitle", null);
                    @Nullable Boolean bl = configurationSectionBridge.a("settings.replace", (Boolean)null);
                    @Nullable Float f = configurationSectionBridge.a("settings.volume", (Float)null);
                    @Nullable Float f2 = configurationSectionBridge.a("settings.pitch", (Float)null);
                    @Nullable Integer n = configurationSectionBridge.c("settings.weight", (Integer)null);
                    @Nullable Boolean bl2 = configurationSectionBridge.a("settings.stream", (Boolean)null);
                    @Nullable Integer n2 = configurationSectionBridge.c("settings.attenuation_distance", (Integer)null);
                    @Nullable Boolean bl3 = configurationSectionBridge.a("settings.preload", (Boolean)null);
                    @Nullable Float f3 = configurationSectionBridge.a("settings.duration_seconds", (Float)null);
                    @Nullable Integer n3 = configurationSectionBridge.c("settings.bitrate_quality", MaterialBarColorHolder.dl ? Integer.valueOf(MaterialBarColorHolder.dm) : null);
                    @Nullable Boolean bl4 = configurationSectionBridge.a("settings.mono", (Boolean)null);
                    Boolean bl5 = null;
                    if (configurationSectionBridge.gP("jukebox")) {
                        bl5 = configurationSectionBridge.C("jukebox.enabled", true);
                    }
                    @Nullable String string5 = configurationSectionBridge.az("jukebox.description", null);
                    @Nullable Integer n4 = configurationSectionBridge.t("jukebox.comparator_output", 15);
                    RecordOfStringBuilder recordOfStringBuilder = new RecordOfStringBuilder(string2, string3).cm(string4).d(bl).e(bl5).cn(string5).i(n4);
                    Set set = configurationSectionBridge.aX(false);
                    Object object3 = set.iterator();
                    while (object3.hasNext()) {
                        Boolean bl6;
                        Integer n5;
                        Float f4;
                        Boolean bl7;
                        Integer n6;
                        Boolean bl8;
                        Integer n7;
                        Float f5;
                        object2 = (String)object3.next();
                        if (!((String)object2).startsWith("variant")) continue;
                        object = configurationSectionBridge.hj((String)object2);
                        assert (object != null);
                        @Nullable String string6 = ((ConfigurationSectionBridge)object).az("path", null);
                        if (string6 == null) {
                            CommandSenderBridge_5.error("[Items] No path found for sound '" + string2 + ":" + string3 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                            continue;
                        }
                        if (!r.ex(string6)) {
                            CommandSenderBridge_5.error("[Items] Non [a-z0-9_.-] character in sound '" + string2 + ":" + string3 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                            r.ym();
                            continue;
                        }
                        @Nullable Float f6 = ((ConfigurationSectionBridge)object).a("volume", f);
                        RecordOfStringBuilder_2 recordOfStringBuilder_2 = LastModified.a(pluginFileConfigurationHolder, string2, string3, recordOfStringBuilder, string6, f6, f5 = ((ConfigurationSectionBridge)object).a("pitch", f2), n7 = ((ConfigurationSectionBridge)object).c("weight", n), bl8 = ((ConfigurationSectionBridge)object).a("stream", bl2), n6 = ((ConfigurationSectionBridge)object).c("attenuation_distance", n2), bl7 = ((ConfigurationSectionBridge)object).a("preload", bl3), f4 = ((ConfigurationSectionBridge)object).a("duration_seconds", f3), n5 = ((ConfigurationSectionBridge)object).c("bitrate_quality", n3), bl6 = ((ConfigurationSectionBridge)object).a("mono", bl4));
                        if (recordOfStringBuilder_2 == null || ((ConfigurationSectionBridge)object).fo("duration_seconds")) continue;
                        LastModified.a(recordOfStringBuilder_2, string2, string3, pluginFileConfigurationHolder);
                    }
                    object2 = configurationSectionBridge.hm("path");
                    if (object2 instanceof String) {
                        object3 = (String)object2;
                        LastModified.a(pluginFileConfigurationHolder, string2, string3, configurationSectionBridge, f, f2, n, bl2, n2, bl3, f3, n3, bl4, recordOfStringBuilder, (String)object3);
                    }
                    if (!(object3 = configurationSectionBridge.hg("paths")).isEmpty()) {
                        object2 = object3.iterator();
                        while (object2.hasNext()) {
                            object = (String)object2.next();
                            LastModified.a(pluginFileConfigurationHolder, string2, string3, configurationSectionBridge, f, f2, n, bl2, n2, bl3, f3, n3, bl4, recordOfStringBuilder, (String)object);
                        }
                    }
                    if (recordOfStringBuilder.Kx == null || recordOfStringBuilder.Kx.isEmpty()) {
                        CommandSenderBridge_5.error("[Items] Failed to find any variant for sound '" + string2 + ":" + string3 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                        continue;
                    }
                    LastModified.G("Loaded sound: " + string3 + ". File: " + pluginFileConfigurationHolder.nh());
                    Ko.computeIfAbsent(string2, string -> new ArrayList()).add(recordOfStringBuilder.pJ());
                }
            }
            LastModified.pA().forEach((string, list) -> EnumWrappersHolder.vC().aoJ.D(list.stream().filter(recordOfString_9 -> Boolean.TRUE == recordOfString_9.Ku && recordOfString_9.Kx != null && !recordOfString_9.Kx.isEmpty()).toList()));
        }
        finally {
            Kn.clear();
        }
    }

    private static void a(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, ConfigurationSectionBridge configurationSectionBridge, @Nullable Float f, @Nullable Float f2, @Nullable Integer n, @Nullable Boolean bl, @Nullable Integer n2, @Nullable Boolean bl2, @Nullable Float f3, @Nullable Integer n3, @Nullable Boolean bl3, RecordOfStringBuilder recordOfStringBuilder, String string3) {
        RecordOfStringBuilder_2 recordOfStringBuilder_2 = LastModified.a(pluginFileConfigurationHolder, string, string2, recordOfStringBuilder, string3, f, f2, n, bl, n2, bl2, f3, n3, bl3);
        if (recordOfStringBuilder_2 != null && !configurationSectionBridge.fo("settings.duration_seconds")) {
            LastModified.a(recordOfStringBuilder_2, string, string2, pluginFileConfigurationHolder);
        }
    }

    private static void a(RecordOfStringBuilder_2 recordOfStringBuilder_2, String string, String string2, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        block10: {
            if (recordOfStringBuilder_2.KI == null || recordOfStringBuilder_2.KI.floatValue() == 0.0f) {
                if (Kn.containsKey(recordOfStringBuilder_2.KB)) {
                    LastModified.G("Sound Duration '" + string + ":" + string2 + "': " + String.valueOf(Kn.get(recordOfStringBuilder_2.KB)) + " seconds (cached)");
                    recordOfStringBuilder_2.e((Float)Kn.get(recordOfStringBuilder_2.KB));
                    return;
                }
                Float f = LastModified.b(LastModified.pz(), recordOfStringBuilder_2.KB);
                if (f != null) {
                    LastModified.G("Sound Duration '" + string + ":" + string2 + "': " + f + " seconds (cached disk)");
                    Kn.put(recordOfStringBuilder_2.KB, f);
                    recordOfStringBuilder_2.e(f);
                    return;
                }
                if (BukkitTaskHolder.M().P()) {
                    try {
                        float f2 = (float)BukkitTaskHolder.M().d(recordOfStringBuilder_2.KB);
                        LastModified.G("Sound Duration: " + f2 + " seconds");
                        if (f2 > 0.0f) {
                            recordOfStringBuilder_2.e(Float.valueOf(f2));
                            Kn.put(recordOfStringBuilder_2.KB, Float.valueOf(f2));
                            break block10;
                        }
                        CommandSenderBridge_5.error("[Items] Invalid sound duration for '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    }
                    catch (IOException | InterruptedException exception) {
                        CommandSenderBridge_5.warn("[Items] Failed to get sound duration for '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh(), exception);
                    }
                } else if (BukkitTaskHolder.M().Q()) {
                    CommandSenderBridge_5.warn("[Items] Ffmpeg is installing. Wait a moment and reload the server to calculate sound duration for '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    recordOfStringBuilder_2.e(Float.valueOf(1337.0f));
                } else {
                    CommandSenderBridge_5.error("[Items] Ffmpeg not available. Can't calculate sound duration for '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
                    CommandSenderBridge_5.error("[Items] Alternatively set 'duration_seconds' manually in the sound config.");
                    recordOfStringBuilder_2.e(Float.valueOf(1337.0f));
                }
            }
        }
    }

    public static void f(PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        for (String string : pluginFileConfigurationHolder.CK()) {
            ConfigurationSectionBridge configurationSectionBridge = pluginFileConfigurationHolder.hj(string);
            assert (configurationSectionBridge != null);
            String string2 = configurationSectionBridge.gV("path_source");
            if (string2 == null) {
                CommandSenderBridge_5.error("Failed to find path_source for " + string);
                configurationSectionBridge.d(string, (Object)null);
                continue;
            }
            String string3 = configurationSectionBridge.gV("path_destination");
            if (string3 == null) {
                CommandSenderBridge_5.error("Failed to find path_destination for " + string);
                configurationSectionBridge.d(string, (Object)null);
                continue;
            }
            File file = new File(string2);
            if (file.exists()) continue;
            LastModified.G("Deleting cache file " + string + " because the original file doesn't exist anymore.");
            File file2 = new File(string3);
            try {
                Files.deleteIfExists(file2.toPath());
            }
            catch (Exception exception) {
                CommandSenderBridge_5.error("Failed to delete cache file " + string + ". " + exception.getMessage());
            }
            configurationSectionBridge.d(string, (Object)null);
        }
        pluginFileConfigurationHolder.save();
    }

    private static @Nullable RecordOfStringBuilder_2 a(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, RecordOfStringBuilder recordOfStringBuilder, String string3, @Nullable Float f, @Nullable Float f2, @Nullable Integer n, @Nullable Boolean bl, @Nullable Integer n2, @Nullable Boolean bl2, @Nullable Float f3, @Nullable Integer n3, @Nullable Boolean bl3) {
        if (!r.ex(string3)) {
            CommandSenderBridge_5.error("[Items] Non [a-z0-9_.-] character in sound '" + string + ":" + string2 + "' in yml file: " + pluginFileConfigurationHolder.nh());
            r.ym();
            return null;
        }
        File file = LastModified.a(string2, string, string3, pluginFileConfigurationHolder);
        if (file == null) {
            return null;
        }
        if (string3.endsWith(".ogg")) {
            string3 = string3.substring(0, string3.length() - 4);
        }
        RecordOfStringBuilder_2 recordOfStringBuilder_2 = new RecordOfStringBuilder_2(string3, file, f, f2, n, bl, n2, bl2, f3, n3, bl3);
        recordOfStringBuilder.a(recordOfStringBuilder_2);
        return recordOfStringBuilder_2;
    }

    private static File a(String string, String string2, String string3, PluginFileConfigurationHolder pluginFileConfigurationHolder) {
        String[] stringArray;
        if (!r.ex(string3)) {
            CommandSenderBridge_5.error("[Items] Non [a-z0-9_.-] character in sound '" + string2 + ":" + string + "' in yml file: " + pluginFileConfigurationHolder.nh());
            r.ym();
            return null;
        }
        if (string3.endsWith(".ogg")) {
            string3 = string3.substring(0, string3.length() - 4);
        }
        if ((stringArray = string3.split(":")).length > 1 && !stringArray[0].equals(string2)) {
            CommandSenderBridge_5.error("[Items] Namespace mismatch in sound '" + string2 + ":" + string + "' ('" + string3 + "'). No need to specify anything or use the correct one. File: " + pluginFileConfigurationHolder.nh());
            return null;
        }
        String string4 = stringArray.length > 1 ? stringArray[1] : stringArray[0];
        File file = ItemStackRegistry.s("assets/" + string2 + "/sounds/" + string4 + ".ogg");
        if (file == null || !file.exists()) {
            CommandSenderBridge_5.error("[Items] Sound file not found: " + string3 + ". File: " + pluginFileConfigurationHolder.nh());
            return null;
        }
        return file;
    }

    public static Map pA() {
        return Ko;
    }

    private static void G(String string) {
    }
}
