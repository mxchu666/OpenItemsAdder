package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PluginCommand_2
implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        return true;
    }

    protected static void a(CommandSender commandSender, String string) {
        if (commandSender instanceof Player) {
            CommandSenderBridge_5.f(commandSender, string);
        } else {
            CommandSenderBridge_5.warn(string);
        }
    }

    protected boolean a(CommandSender commandSender, Command command) {
        if (!ItemStackRegistry.g().k()) {
            PluginCommand_2.a(commandSender, String.valueOf(ChatColor.YELLOW) + "Plugin is still loading... Please wait before using " + String.valueOf(ChatColor.AQUA) + "/" + command.getName());
            return false;
        }
        return true;
    }

    public static String a(String[] stringArray, int n, String string) {
        if (n > stringArray.length - 1) {
            return string;
        }
        return stringArray[n];
    }

    public static int a(String[] stringArray, int n, int n2) {
        if (n > stringArray.length - 1) {
            return n2;
        }
        return ColorBridge.w(stringArray[n], n2);
    }

    public static float a(String[] stringArray, int n, float f) {
        if (n > stringArray.length - 1) {
            return f;
        }
        return ColorBridge.b(stringArray[n], f);
    }

    public static boolean a(@NotNull String[] stringArray, int n, boolean bl) {
        if (n > stringArray.length - 1) {
            return bl;
        }
        return ColorBridge.E(stringArray[n], bl);
    }

    public static boolean a(int n, String ... stringArray) {
        if (stringArray.length == 0 || stringArray.length < n) {
            return false;
        }
        for (String string : stringArray) {
            if (string != null && !string.isEmpty()) continue;
            return false;
        }
        return true;
    }
}
