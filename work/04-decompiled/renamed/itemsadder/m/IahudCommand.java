package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_15;
import itemsadder.m.PluginCommand_2;
import itemsadder.m.WorldBridge_4;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IahudCommand
extends PluginCommand_2 {
    public IahudCommand() {
        Main.cM("iahud").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            CommandSenderBridge_5.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        if (stringArray.length == 0) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iahud <hud>. Example: /iahud magiccraft:mana_bar");
            return true;
        }
        for (WorldBridge_4 worldBridge_4 : ((PlayerBridge_15)ItemStackRegistry.g().ao.wW.get((Object)player)).xe) {
            if (!worldBridge_4.getNamespacedID().equals(stringArray[0])) continue;
            worldBridge_4.setVisible(!worldBridge_4.isVisible());
        }
        ItemStackRegistry.g().ao.al(player);
        return true;
    }
}
