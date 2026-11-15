package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerInventoryPlayerHolder;
import itemsadder.m.PluginCommand_2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class IaremoveCommand
extends PluginCommand_2 {
    public IaremoveCommand() {
        Main.cM("iaremove").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!PluginCommand_2.a(2, stringArray)) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&e/iaremove &b<player> <itemNameInConfig> [amount] [silent]"));
            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&6Example: &e/iaremove &bNotch sword2 1"));
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
            ItemStack itemStack = ItemStackRegistry.g().e(stringArray[1]).mP();
            int n = 1;
            if (stringArray.length > 2) {
                n = ColorBridge.w(stringArray[2], 1);
            }
            itemStack.setAmount(n);
            int n2 = IaremoveCommand.b(player, itemStack);
            player.updateInventory();
            if (!bl) {
                CommandSenderBridge_5.f(commandSender, Main.PQ.ir("removed-item").replace("{item}", stringArray[1] + "x" + n2).replace("{player}", player.getDisplayName()));
                CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("lost-item").replace("{item}", stringArray[1] + "x" + n2));
            }
        } else if (!bl) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[1]));
        }
        return true;
    }

    public static int b(Player player, ItemStack itemStack) {
        int n = 0;
        PlayerInventoryPlayerHolder playerInventoryPlayerHolder = new PlayerInventoryPlayerHolder(player);
        for (int i = 0; i < playerInventoryPlayerHolder.Dd(); ++i) {
            ItemStackBridge_3 itemStackBridge_3 = playerInventoryPlayerHolder.bJ(i);
            if (itemStackBridge_3 == null || itemStackBridge_3.aAy || !ItemStackBuilder_4.b(itemStackBridge_3.aAx, itemStack)) continue;
            while (playerInventoryPlayerHolder.bG(i) > 0 && itemStack.getAmount() > 0) {
                playerInventoryPlayerHolder.bH(i);
                itemStack.setAmount(itemStack.getAmount() - 1);
                ++n;
            }
        }
        playerInventoryPlayerHolder.applyChanges();
        return n;
    }
}
