package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginCommand_2;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class IagetCommand
extends PluginCommand_2 {
    public IagetCommand() {
        Main.cM("iaget").setExecutor((CommandExecutor)this);
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
        if (!PluginCommand_2.a(1, stringArray)) {
            CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("wrong-command-usage"));
            CommandSenderBridge_5.f((CommandSender)player, String.valueOf(ChatColor.YELLOW) + "/iaget " + String.valueOf(ChatColor.AQUA) + "<itemNameInConfig> [amount]");
            CommandSenderBridge_5.f((CommandSender)player, String.valueOf(ChatColor.GOLD) + "Example: " + String.valueOf(ChatColor.YELLOW) + "/iaget " + String.valueOf(ChatColor.AQUA) + "sword1");
            return true;
        }
        if (ItemStackRegistry.g().f(stringArray[0])) {
            ItemStack itemStack = ItemStackRegistry.g().m(stringArray[0]);
            int n = 1;
            if (stringArray.length > 1) {
                n = ColorBridge.w(stringArray[1], 1);
            }
            itemStack.setAmount(n);
            ItemStackBridge_2.f(player, itemStack);
            CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("obtained-item").replace("{item}", stringArray[0]));
        } else {
            CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("item-not-found").replace("{item}", stringArray[0]));
        }
        return true;
    }
}
