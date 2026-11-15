package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.Consumer_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque013;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.VersionHelper_3;
import java.util.logging.Level;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class CommandSenderBridge_5 {
    public static Component aAT = PluginBridge_6.gF("[ItemsAdder] ");
    public static String aAU = "[ItemsAdder] ";
    private static final Opaque013 aAV = new Opaque013(aAU);

    public static void w(Component component) {
        aAT = component;
        aAV.gz(PluginBridge_6.u(component));
    }

    public static void ix(String string) {
        aAV.gz(string);
    }

    public static void b(CommandSender commandSender, String string) {
        CommandSenderBridge_5.a(commandSender, string, null);
    }

    public static void a(CommandSender commandSender, String string, @Nullable Throwable throwable) {
        CommandSenderBridge_5.log(string);
        if (commandSender != null && commandSender != Bukkit.getConsoleSender()) {
            CommandSenderBridge_5.f(commandSender, string);
        }
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public static void log(String string) {
        aAV.a(Level.INFO, string);
    }

    public static void a(String string, Level level) {
        aAV.a(level, string);
    }

    public static void error(String string) {
        if (ChatColor.stripColor((String)string).equals(string)) {
            aAV.a(Level.SEVERE, String.valueOf(ChatColor.RED) + string);
        } else {
            aAV.a(Level.SEVERE, string);
        }
    }

    public static void error(String string, @Nullable Throwable throwable) {
        if (ChatColor.stripColor((String)string).equals(string)) {
            aAV.a(Level.SEVERE, String.valueOf(ChatColor.RED) + string);
        } else {
            aAV.a(Level.SEVERE, string);
        }
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public static void c(CommandSender commandSender, String string) {
        CommandSenderBridge_5.b(commandSender, string, null);
    }

    public static void b(CommandSender commandSender, String string, @Nullable Throwable throwable) {
        if (commandSender instanceof Player) {
            CommandSenderBridge_5.f(commandSender, string);
        } else if (ChatColor.stripColor((String)string).equals(string)) {
            aAV.a(Level.SEVERE, String.valueOf(ChatColor.RED) + string);
        } else {
            aAV.a(Level.SEVERE, string);
        }
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public static void warn(String string) {
        if (ChatColor.stripColor((String)string).equals(string)) {
            aAV.a(Level.WARNING, String.valueOf(ChatColor.YELLOW) + string);
        } else {
            aAV.a(Level.WARNING, string);
        }
    }

    public static void d(CommandSender commandSender, String string) {
        CommandSenderBridge_5.warn(string);
        CommandSenderBridge_5.f(commandSender, String.valueOf(net.md_5.bungee.api.ChatColor.YELLOW) + string);
    }

    public static void warn(String string, @Nullable Throwable throwable) {
        CommandSenderBridge_5.warn(string);
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public static void e(CommandSender commandSender, String string) {
        commandSender.sendMessage(string);
    }

    public static void a(CommandSender commandSender, Component component) {
        if (VersionHelper_3.sZ()) {
            commandSender.sendMessage(component);
        } else {
            commandSender.spigot().sendMessage(PluginBridge_6.s(component));
        }
    }

    public static void f(CommandSender commandSender, String string) {
        CommandSenderBridge_5.a(commandSender, aAT.append(PluginBridge_6.gF(string)));
    }

    public static void g(CommandSender commandSender, String string) {
        CommandSenderBridge_5.a(commandSender, aAT.append(Main.PQ.it(string)));
    }

    public static void a(CommandSender commandSender, String string, Consumer_2 consumer_2) {
        String string2 = Main.PQ.is(string);
        if (string2 == null) {
            CommandSenderBridge_5.c(commandSender, "Localized message not found for path: " + string);
            CommandSenderBridge_5.a(commandSender, aAT.append(PluginBridge_6.gK(string)));
            return;
        }
        if (consumer_2 != null) {
            string2 = (String)consumer_2.accept(string2);
        }
        CommandSenderBridge_5.a(commandSender, aAT.append(PluginBridge_6.gK(string2)));
    }

    public static void iy(String string) {
        String string2 = PluginBridge_6.u(Main.PQ.it(string));
        if (ChatColor.stripColor((String)string2).equals(string2)) {
            aAV.a(Level.WARNING, String.valueOf(ChatColor.YELLOW) + string2);
        } else {
            aAV.a(Level.WARNING, string2);
        }
    }

    public static void iz(String string) {
        CommandSenderBridge_5.log(string);
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.isOp()) continue;
            CommandSenderBridge_5.a((CommandSender)player, aAT.append((Component)Component.text((String)string)));
        }
    }

    public static void Dj() {
        if (MaterialBarColorHolder.ck) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "\n" + String.valueOf(ChatColor.AQUA) + "                                               " + String.valueOf(ChatColor.DARK_GREEN) + "    ItemsAdder" + String.valueOf(ChatColor.GRAY) + " " + String.valueOf(Main.l(Main.rS().getFile()).get("version")) + "\n" + String.valueOf(ChatColor.AQUA) + "  ___  ___        __        __   __   ___  __  " + String.valueOf(ChatColor.DARK_GREEN) + "    ProtocolLib" + String.valueOf(ChatColor.GRAY) + " " + Bukkit.getPluginManager().getPlugin("ProtocolLib").getDescription().getVersion() + "\n" + String.valueOf(ChatColor.AQUA) + "|  |  |__   |\\/| /__`  /\\  |  \\ |  \\ |__  |__) " + String.valueOf(ChatColor.DARK_GRAY) + "    " + Bukkit.getServer().getName() + " " + Bukkit.getServer().getVersion() + "\n" + String.valueOf(ChatColor.AQUA) + "|  |  |___  |  | .__/ /--\\ |__/ |__/ |___ |  \\ " + String.valueOf(ChatColor.DARK_GRAY) + "    Build Date: " + String.valueOf(Main.l(Main.rS().getFile()).get("build-timestamp")) + "\n" + String.valueOf(ChatColor.AQUA) + "                                               " + String.valueOf(ChatColor.DARK_GRAY) + "    Java Version: " + System.getProperty("java.version") + "\n" + String.valueOf(ChatColor.AQUA) + "                                               " + String.valueOf(ChatColor.DARK_GRAY) + "    OS: " + System.getProperty("os.name") + " " + System.getProperty("os.version") + String.valueOf(ChatColor.AQUA) + "                                               ");
        }
    }

    public static void iA(String string) {
        if (VersionHelper_3.sW()) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.AQUA) + "### [DEV MODE LOG] " + String.valueOf(ChatColor.RESET) + string);
        }
    }

    public static void b(String string, Throwable throwable) {
        if (VersionHelper_3.sW()) {
            aAV.a(Level.INFO, String.valueOf(ChatColor.RED) + "### [DEV MODE LOG] " + String.valueOf(ChatColor.RESET) + string, throwable);
        }
    }

    public static void iB(String string) {
        if (VersionHelper_3.sW()) {
            CommandSenderBridge_5.warn(String.valueOf(ChatColor.RED) + "### [DEV MODE LOG] " + String.valueOf(ChatColor.RESET) + string);
        }
    }
}
