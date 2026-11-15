package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.r;
import itemsadder.m.ae;
import itemsadder.m.axi;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.bbr;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.h;
import itemsadder.m.th;
import itemsadder.m.tj;
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

public class tf {
    private static final Map Kn = new HashMap();
    private static final Map Ko = new HashMap();

    public static File py() {
        return new File(Main.rS().getDataFolder(), "storage" + File.separator + "cache" + File.separator + "tmp_ogg");
    }

    public static bbf pz() {
        File file = tf.py();
        @Nullable bbf bbf2 = new bbf((Plugin)Main.rS(), true, "storage/cache/tmp_ogg/info.yml", false, false);
        if (!file.exists() && !file.mkdirs()) {
            bce.error("Failed to create tmp folder for ogg sounds: " + file.getAbsolutePath());
        }
        return bbf2;
    }

    public static bbg a(bbf bbf2, File file) {
        return bbf2.hk(bcy.iW(file.getAbsolutePath()));
    }

    public static bbg k(File file) {
        return tf.pz().hk(bcy.iW(file.getAbsolutePath()));
    }

    @Nullable
    public static Float b(bbf bbf2, File file) {
        bbg bbg2 = tf.a(bbf2, file);
        if (bbg2.a("last_modified", 0L) >= file.lastModified() && bbg2.gP("duration")) {
            return bbg2.a("duration", (Float)null);
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
            d d2 = d.g();
            for (bbf bbf2 : d2.b()) {
                bbf bbf3;
                String string2 = bbf2.gV("info.namespace");
                d2.Z.add(string2);
                try {
                    bbf3 = bbf2.g('~');
                }
                catch (IOException | InvalidConfigurationException throwable) {
                    bce.error("[Items] Failed to load sounds config file: " + bbf2.qd(), throwable);
                    Kn.clear();
                    return;
                }
                List list2 = bbf3.gR("sounds");
                if (list2.isEmpty()) {
                    if (!Main.KO.gY("debug.items.log-items-loading")) continue;
                    bce.log(String.valueOf(ChatColor.YELLOW) + "    No sound found in file " + bbf2.qd());
                    continue;
                }
                bbr.bf("Sounds '" + string2 + "'...");
                for (String string3 : list2) {
                    Object object;
                    Object object2;
                    bbg bbg2 = bbf2.hj("sounds." + string3);
                    assert (bbg2 != null);
                    if (!bbg2.C("enabled", true)) {
                        if (!Main.KO.gY("debug.items.log-items-loading-disabled")) continue;
                        bce.log("    Ignored disabled sound: " + string3 + ", namespace: " + string2);
                        continue;
                    }
                    if (Main.KO.gY("debug.items.log-items-loading")) {
                        bce.log("    Loading sound: " + string3);
                    }
                    if (!r.ez(string3)) {
                        bce.error("[Items] Non [a-z0-9_.-] character in sound '" + string2 + ":" + string3 + "' in yml file: " + bbf2.nh());
                        r.ym();
                        continue;
                    }
                    @Nullable String string4 = bbg2.az("settings.subtitle", null);
                    @Nullable Boolean bl = bbg2.a("settings.replace", (Boolean)null);
                    @Nullable Float f2 = bbg2.a("settings.volume", (Float)null);
                    @Nullable Float f3 = bbg2.a("settings.pitch", (Float)null);
                    @Nullable Integer n = bbg2.c("settings.weight", (Integer)null);
                    @Nullable Boolean bl2 = bbg2.a("settings.stream", (Boolean)null);
                    @Nullable Integer n2 = bbg2.c("settings.attenuation_distance", (Integer)null);
                    @Nullable Boolean bl3 = bbg2.a("settings.preload", (Boolean)null);
                    @Nullable Float f4 = bbg2.a("settings.duration_seconds", (Float)null);
                    @Nullable Integer n3 = bbg2.c("settings.bitrate_quality", ae.dl ? Integer.valueOf(ae.dm) : null);
                    @Nullable Boolean bl4 = bbg2.a("settings.mono", (Boolean)null);
                    Boolean bl5 = null;
                    if (bbg2.gP("jukebox")) {
                        bl5 = bbg2.C("jukebox.enabled", true);
                    }
                    @Nullable String string5 = bbg2.az("jukebox.description", null);
                    @Nullable Integer n4 = bbg2.t("jukebox.comparator_output", 15);
                    th th2 = new th(string2, string3).cm(string4).d(bl).e(bl5).cn(string5).i(n4);
                    Set set = bbg2.aX(false);
                    Object object3 = set.iterator();
                    while (object3.hasNext()) {
                        Boolean bl6;
                        Integer n5;
                        Float f5;
                        Boolean bl7;
                        Integer n6;
                        Boolean bl8;
                        Integer n7;
                        Float f6;
                        object2 = (String)object3.next();
                        if (!((String)object2).startsWith("variant")) continue;
                        object = bbg2.hj((String)object2);
                        assert (object != null);
                        @Nullable String string6 = ((bbg)object).az("path", null);
                        if (string6 == null) {
                            bce.error("[Items] No path found for sound '" + string2 + ":" + string3 + "' in yml file: " + bbf2.nh());
                            continue;
                        }
                        if (!r.ex(string6)) {
                            bce.error("[Items] Non [a-z0-9_.-] character in sound '" + string2 + ":" + string3 + "' in yml file: " + bbf2.nh());
                            r.ym();
                            continue;
                        }
                        @Nullable Float f7 = ((bbg)object).a("volume", f2);
                        tj tj2 = tf.a(bbf2, string2, string3, th2, string6, f7, f6 = ((bbg)object).a("pitch", f3), n7 = ((bbg)object).c("weight", n), bl8 = ((bbg)object).a("stream", bl2), n6 = ((bbg)object).c("attenuation_distance", n2), bl7 = ((bbg)object).a("preload", bl3), f5 = ((bbg)object).a("duration_seconds", f4), n5 = ((bbg)object).c("bitrate_quality", n3), bl6 = ((bbg)object).a("mono", bl4));
                        if (tj2 == null || ((bbg)object).fo("duration_seconds")) continue;
                        tf.a(tj2, string2, string3, bbf2);
                    }
                    object2 = bbg2.hm("path");
                    if (object2 instanceof String) {
                        object3 = (String)object2;
                        tf.a(bbf2, string2, string3, bbg2, f2, f3, n, bl2, n2, bl3, f4, n3, bl4, th2, (String)object3);
                    }
                    if (!(object3 = bbg2.hg("paths")).isEmpty()) {
                        object2 = object3.iterator();
                        while (object2.hasNext()) {
                            object = (String)object2.next();
                            tf.a(bbf2, string2, string3, bbg2, f2, f3, n, bl2, n2, bl3, f4, n3, bl4, th2, (String)object);
                        }
                    }
                    if (th2.Kx == null || th2.Kx.isEmpty()) {
                        bce.error("[Items] Failed to find any variant for sound '" + string2 + ":" + string3 + "' in yml file: " + bbf2.nh());
                        continue;
                    }
                    tf.G("Loaded sound: " + string3 + ". File: " + bbf2.nh());
                    Ko.computeIfAbsent(string2, string -> new ArrayList()).add(th2.pJ());
                }
            }
            tf.pA().forEach((string, list) -> axi.vC().aoJ.D(list.stream().filter(tg2 -> Boolean.TRUE == tg2.Ku && tg2.Kx != null && !tg2.Kx.isEmpty()).toList()));
        }
        finally {
            Kn.clear();
        }
    }

    private static void a(bbf bbf2, String string, String string2, bbg bbg2, @Nullable Float f2, @Nullable Float f3, @Nullable Integer n, @Nullable Boolean bl, @Nullable Integer n2, @Nullable Boolean bl2, @Nullable Float f4, @Nullable Integer n3, @Nullable Boolean bl3, th th2, String string3) {
        tj tj2 = tf.a(bbf2, string, string2, th2, string3, f2, f3, n, bl, n2, bl2, f4, n3, bl3);
        if (tj2 != null && !bbg2.fo("settings.duration_seconds")) {
            tf.a(tj2, string, string2, bbf2);
        }
    }

    private static void a(tj tj2, String string, String string2, bbf bbf2) {
        block10: {
            if (tj2.KI == null || tj2.KI.floatValue() == 0.0f) {
                if (Kn.containsKey(tj2.KB)) {
                    tf.G("Sound Duration '" + string + ":" + string2 + "': " + String.valueOf(Kn.get(tj2.KB)) + " seconds (cached)");
                    tj2.e((Float)Kn.get(tj2.KB));
                    return;
                }
                Float f2 = tf.b(tf.pz(), tj2.KB);
                if (f2 != null) {
                    tf.G("Sound Duration '" + string + ":" + string2 + "': " + f2 + " seconds (cached disk)");
                    Kn.put(tj2.KB, f2);
                    tj2.e(f2);
                    return;
                }
                if (h.M().P()) {
                    try {
                        float f3 = (float)h.M().d(tj2.KB);
                        tf.G("Sound Duration: " + f3 + " seconds");
                        if (f3 > 0.0f) {
                            tj2.e(Float.valueOf(f3));
                            Kn.put(tj2.KB, Float.valueOf(f3));
                            break block10;
                        }
                        bce.error("[Items] Invalid sound duration for '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    }
                    catch (IOException | InterruptedException exception) {
                        bce.warn("[Items] Failed to get sound duration for '" + string + ":" + string2 + "' in yml file: " + bbf2.nh(), exception);
                    }
                } else if (h.M().Q()) {
                    bce.warn("[Items] Ffmpeg is installing. Wait a moment and reload the server to calculate sound duration for '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    tj2.e(Float.valueOf(1337.0f));
                } else {
                    bce.error("[Items] Ffmpeg not available. Can't calculate sound duration for '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
                    bce.error("[Items] Alternatively set 'duration_seconds' manually in the sound config.");
                    tj2.e(Float.valueOf(1337.0f));
                }
            }
        }
    }

    public static void f(bbf bbf2) {
        for (String string : bbf2.CK()) {
            bbg bbg2 = bbf2.hj(string);
            assert (bbg2 != null);
            String string2 = bbg2.gV("path_source");
            if (string2 == null) {
                bce.error("Failed to find path_source for " + string);
                bbg2.d(string, (Object)null);
                continue;
            }
            String string3 = bbg2.gV("path_destination");
            if (string3 == null) {
                bce.error("Failed to find path_destination for " + string);
                bbg2.d(string, (Object)null);
                continue;
            }
            File file = new File(string2);
            if (file.exists()) continue;
            tf.G("Deleting cache file " + string + " because the original file doesn't exist anymore.");
            File file2 = new File(string3);
            try {
                Files.deleteIfExists(file2.toPath());
            }
            catch (Exception exception) {
                bce.error("Failed to delete cache file " + string + ". " + exception.getMessage());
            }
            bbg2.d(string, (Object)null);
        }
        bbf2.save();
    }

    private static @Nullable tj a(bbf bbf2, String string, String string2, th th2, String string3, @Nullable Float f2, @Nullable Float f3, @Nullable Integer n, @Nullable Boolean bl, @Nullable Integer n2, @Nullable Boolean bl2, @Nullable Float f4, @Nullable Integer n3, @Nullable Boolean bl3) {
        if (!r.ex(string3)) {
            bce.error("[Items] Non [a-z0-9_.-] character in sound '" + string + ":" + string2 + "' in yml file: " + bbf2.nh());
            r.ym();
            return null;
        }
        File file = tf.a(string2, string, string3, bbf2);
        if (file == null) {
            return null;
        }
        if (string3.endsWith(".ogg")) {
            string3 = string3.substring(0, string3.length() - 4);
        }
        tj tj2 = new tj(string3, file, f2, f3, n, bl, n2, bl2, f4, n3, bl3);
        th2.a(tj2);
        return tj2;
    }

    private static File a(String string, String string2, String string3, bbf bbf2) {
        String[] stringArray;
        if (!r.ex(string3)) {
            bce.error("[Items] Non [a-z0-9_.-] character in sound '" + string2 + ":" + string + "' in yml file: " + bbf2.nh());
            r.ym();
            return null;
        }
        if (string3.endsWith(".ogg")) {
            string3 = string3.substring(0, string3.length() - 4);
        }
        if ((stringArray = string3.split(":")).length > 1 && !stringArray[0].equals(string2)) {
            bce.error("[Items] Namespace mismatch in sound '" + string2 + ":" + string + "' ('" + string3 + "'). No need to specify anything or use the correct one. File: " + bbf2.nh());
            return null;
        }
        String string4 = stringArray.length > 1 ? stringArray[1] : stringArray[0];
        File file = d.s("assets/" + string2 + "/sounds/" + string4 + ".ogg");
        if (file == null || !file.exists()) {
            bce.error("[Items] Sound file not found: " + string3 + ". File: " + bbf2.nh());
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
