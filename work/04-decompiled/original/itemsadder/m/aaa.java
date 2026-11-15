package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.u;
import itemsadder.m.bce;
import itemsadder.m.bdc;
import itemsadder.m.bdd;
import itemsadder.m.zw;
import itemsadder.m.zx;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class aaa {
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
        Va = zw.sZ();
        Vb = Bukkit.getVersion().contains("Purpur");
        Vc = Va;
        zw.UO = Va && zw.du("net.kyori.adventure.text.TextComponent") == zx.SERVER_JAR;
        zw.UQ = Bukkit.getPluginManager().getPlugin("ViaVersion") != null && zw.ds("com.viaversion.viaversion.api.Via");
    }

    public static boolean te() {
        if (!zw.ds("org.spigotmc.SpigotConfig")) {
            aaa.dv(String.valueOf(ChatColor.RED) + "You are using a server which has no SpigotAPI available. CraftBukkit and similar are not supported. \n" + String.valueOf(ChatColor.DARK_GRAY) + "Please use Spigot or Paper.\n" + String.valueOf(ChatColor.DARK_GRAY) + "Download: https://itemsadder.devs.beer/faq/download-spigot");
            return false;
        }
        if (!aaa.tc()) {
            bce.error("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
            bce.error(" ");
            bce.error(" ");
            bce.error(" ");
            bce.error("This server version is not supported: " + Version.get().getName());
            bce.error("Use one of the supported versions: " + aaa.td());
            bce.error(" ");
            bce.error(" ");
            bce.error(" ");
            bce.error("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550");
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
        bdd bdd2 = bdc.aH("ProtocolLib", string);
        if (bdd2 != bdd.INSTALLED_IS_SAME && bdd2 != bdd.INSTALLED_IS_NEWER) {
            aaa.dv("Please update ProtocolLib: https://github.com/dmulloy2/ProtocolLib/releases/download/dev-build/ProtocolLib.jar");
            return false;
        }
        if (Version.isAtLeast((Version)Version.v1_21_11)) {
            u.sj();
        }
        if (Bukkit.getPluginManager().isPluginEnabled("LoneLibs")) {
            bce.warn("LoneLibs is enabled. This plugin is not needed anymore and it's recommended to remove it (if you are not using it for other plugins).");
        }
        return true;
    }

    private static void dv(String string) {
        bce.error(" ");
        bce.error(" ");
        bce.error(" ");
        bce.error(string);
        bce.error(" ");
        bce.error(" ");
        bce.error(" ");
        Main.bU();
    }

    static {
        Vd = Arrays.asList(Version.v1_20_6, Version.v1_21, Version.v1_21_1, Version.v1_21_3, Version.v1_21_4, Version.v1_21_5, Version.v1_21_6, Version.v1_21_7, Version.v1_21_8, Version.v1_21_10, Version.v1_21_11, Version.v26_1_1, Version.v26_1_2, Version.v26_2);
    }
}
