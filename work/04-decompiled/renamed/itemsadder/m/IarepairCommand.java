package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PluginCommand_2;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class IarepairCommand
extends PluginCommand_2 {
    public IarepairCommand() {
        Main.cM("iarepair").setExecutor((CommandExecutor)this);
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
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (!ItemStackBuilder_4.F(itemStack)) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("cannot-repair"));
            return true;
        }
        ItemStackBuilder_4.I(itemStack);
        CommandSenderBridge_5.f(commandSender, Main.PQ.ir("repaired-successfully"));
        return true;
    }
}
