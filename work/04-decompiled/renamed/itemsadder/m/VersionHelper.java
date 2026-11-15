package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.u;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.InstalledIsNewerEnum;
import itemsadder.m.Opaque027;
import itemsadder.m.ServerJarEnum;
import itemsadder.m.VersionHelper_3;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class VersionHelper {
    public static boolean Va = false;
    public static boolean Vb = false;
    public static boolean Vc;
    private static final List Vd;

    private static boolean tc() {
        return Vd.contains(Version.get());
    }

    private static String td() {
        return Vd.stream().map(version -> version.getName()).reduce((string, string2) -> string + ", " + string2).orElse("");
    }

    public static void init() {
        Va = VersionHelper_3.sZ();
        Vb = Bukkit.getVersion().contains("Purpur");
        Vc = Va;
        VersionHelper_3.UO = Va && VersionHelper_3.du("net.kyori.adventure.text.TextComponent") == ServerJarEnum.SERVER_JAR;
        VersionHelper_3.UQ = Bukkit.getPluginManager().getPlugin("ViaVersion") != null && VersionHelper_3.ds("com.viaversion.viaversion.api.Via");
    }

    public static boolean te() {
        if (!VersionHelper_3.ds("org.spigotmc.SpigotConfig")) {
            VersionHelper.dv(String.valueOf(ChatColor.RED) + "You are using a server which has no SpigotAPI available. CraftBukkit and similar are not supported. \n" + String.valueOf(ChatColor.DARK_GRAY) + "Please use Spigot or Paper.\n" + String.valueOf(ChatColor.DARK_GRAY) + "Download: https://itemsadder.devs.beer/faq/download-spigot");
            return false;
        }
        if (!VersionHelper.tc()) {
            CommandSenderBridge_5.error("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error("This server version is not supported: " + Version.get().getName());
            CommandSenderBridge_5.error("Use one of the supported versions: " + VersionHelper.td());
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error(" ");
            CommandSenderBridge_5.error("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
            Main.bU();
            return false;
        }
        String string = "5.3.0";
        if (Version.isAtLeast((Version)Version.v1_21_11)) {
            string = "5.5.0";
        } else if (Version.isAtLeast((Version)Version.v1_21_3)) {
            string = "5.4.0";
        } else if (Version.isNewerThan((Version)Version.v1_21_3)) {
            string = "5.3.0";
        }
        InstalledIsNewerEnum installedIsNewerEnum = Opaque027.aH("ProtocolLib", string);
        if (installedIsNewerEnum != InstalledIsNewerEnum.INSTALLED_IS_SAME && installedIsNewerEnum != InstalledIsNewerEnum.INSTALLED_IS_NEWER) {
            VersionHelper.dv("Please update ProtocolLib: https://github.com/dmulloy2/ProtocolLib/releases/download/dev-build/ProtocolLib.jar");
            return false;
        }
        if (Version.isAtLeast((Version)Version.v1_21_11)) {
            u.sj();
        }
        if (Bukkit.getPluginManager().isPluginEnabled("LoneLibs")) {
            CommandSenderBridge_5.warn("LoneLibs is enabled. This plugin is not needed anymore and it's recommended to remove it (if you are not using it for other plugins).");
        }
        return true;
    }

    private static void dv(String string) {
        CommandSenderBridge_5.error(" ");
        CommandSenderBridge_5.error(" ");
        CommandSenderBridge_5.error(" ");
        CommandSenderBridge_5.error(string);
        CommandSenderBridge_5.error(" ");
        CommandSenderBridge_5.error(" ");
        CommandSenderBridge_5.error(" ");
        Main.bU();
    }

    static {
        Vd = Arrays.asList(Version.v1_20_6, Version.v1_21, Version.v1_21_1, Version.v1_21_3, Version.v1_21_4, Version.v1_21_5, Version.v1_21_6, Version.v1_21_7, Version.v1_21_8, Version.v1_21_10, Version.v1_21_11, Version.v26_1_1, Version.v26_1_2, Version.v26_2);
    }
}
