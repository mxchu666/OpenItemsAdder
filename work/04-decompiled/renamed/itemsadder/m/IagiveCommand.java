package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginCommand_2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class IagiveCommand
extends PluginCommand_2 {
    public IagiveCommand() {
        Main.cM("iagive").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!PluginCommand_2.a(2, stringArray)) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&e/iagive &b<player> <itemNameInConfig> [amount] [silent]"));
            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&6Example: &e/iagive &bNotch sword2 3"));
            return true;
        }
        boolean bl = stringArray.length == 4 && stringArray[3].equalsIgnoreCase("silent");
        Player player = Bukkit.getPlayer((String)stringArray[0]);
        if (player == null) {
            if (!bl) {
                CommandSenderBridge_5.f(commandSender, Main.PQ.ir("player-offline"));
            }
            return true;
        }
        if (ItemStackRegistry.g().f(stringArray[1])) {
            ItemStack itemStack = ItemStackRegistry.g().m(stringArray[1]);
            int n = 1;
            if (stringArray.length > 2) {
                n = ColorBridge.w(stringArray[2], 1);
            }
            itemStack.setAmount(n);
            ItemStackBridge_2.f(player, itemStack);
            if (!bl) {
                CommandSenderBridge_5.f(commandSender, Main.PQ.ir("given-item").replace("{item}", stringArray[1]).replace("{player}", player.getDisplayName()));
                CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("obtained-item").replace("{item}", itemStack.getItemMeta().getDisplayName()));
            }
        } else if (!bl) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[1]));
        }
        return true;
    }
}
