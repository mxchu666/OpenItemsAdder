package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_42;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_30;
import itemsadder.m.PluginCommand_2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class PluginCommand
extends PluginCommand_2 {
    public PluginCommand() {
        Main.cM("ia").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        ItemStackBridge_42 itemStackBridge_42 = ItemStackRegistry.g().bi;
        if (!ItemStackRegistry.g().u || itemStackBridge_42 == null) {
            return true;
        }
        if (stringArray.length == 0) {
            if (!(commandSender instanceof Player)) {
                return PluginCommand.a(commandSender);
            }
            itemStackBridge_42.Ue.bw((Player)commandSender);
        } else {
            String string2;
            PlayerBridge_30 playerBridge_30;
            Player player;
            if (!s.c((Permissible)commandSender, "ia.user.ia.categories")) {
                return true;
            }
            if (stringArray.length == 2) {
                if (!s.c((Permissible)commandSender, "ia.user.ia.categories.others")) {
                    return true;
                }
                player = Bukkit.getPlayer((String)stringArray[1]);
                if (player == null) {
                    CommandSenderBridge_5.g(commandSender, "player-offline");
                    return true;
                }
            } else {
                if (!(commandSender instanceof Player)) {
                    return PluginCommand.a(commandSender);
                }
                player = (Player)commandSender;
            }
            if ((playerBridge_30 = itemStackBridge_42.Ue.dn(string2 = stringArray[0])) != null) {
                if (playerBridge_30.getPermission() == null || commandSender.hasPermission(playerBridge_30.getPermission())) {
                    playerBridge_30.k(player, true);
                } else {
                    CommandSenderBridge_5.f(commandSender, Main.PQ.ir("no-permission"));
                }
            } else {
                CommandSenderBridge_5.f(commandSender, Main.PQ.ir("unknown-category").replace("{name}", string2));
            }
        }
        return true;
    }

    public static boolean a(CommandSender commandSender) {
        CommandSenderBridge_5.iy("command-ingame-only");
        return true;
    }
}
