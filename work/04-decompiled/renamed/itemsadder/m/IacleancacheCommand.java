package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.f;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.PluginCommand_2;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IacleancacheCommand
extends PluginCommand_2 {
    public IacleancacheCommand() {
        Main.cM("iacleancache").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string2, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length > 0) {
            if ((stringArray[0].equals("items") || stringArray[0].equals("blocks")) && !f.xl().xp()) {
                CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + "Cannot clean IDs because the latest content load did not complete successfully.");
                return true;
            }
            switch (stringArray[0]) {
                case "items": {
                    int n = f.xl().h(commandSender);
                    if (!(commandSender instanceof Player)) {
                        CommandSenderBridge_5.f(commandSender, " ");
                        CommandSenderBridge_5.f(commandSender, " ");
                    }
                    CommandSenderBridge_5.g(commandSender, "ia-cleancache-regenerate-pack");
                    if (!(commandSender instanceof Player)) {
                        CommandSenderBridge_5.f(commandSender, " ");
                        CommandSenderBridge_5.f(commandSender, " ");
                    }
                    if (n > 0) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"iareload");
                    }
                    return true;
                }
                case "blocks": {
                    int n = f.xl().xE();
                    if (!(commandSender instanceof Player)) {
                        CommandSenderBridge_5.f(commandSender, " ");
                        CommandSenderBridge_5.f(commandSender, " ");
                    }
                    CommandSenderBridge_5.a(commandSender, "ia-cleancache-removed-blocks", (Object string) -> {
                        string = string.replace("{count}", String.valueOf(n));
                        return string;
                    });
                    CommandSenderBridge_5.g(commandSender, "ia-cleancache-regenerate-pack");
                    if (!(commandSender instanceof Player)) {
                        CommandSenderBridge_5.f(commandSender, " ");
                        CommandSenderBridge_5.f(commandSender, " ");
                    }
                    if (n > 0) {
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"iareload");
                    }
                    return true;
                }
            }
        }
        commandSender.sendMessage(Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iacleancache <items|blocks>");
        return true;
    }
}
