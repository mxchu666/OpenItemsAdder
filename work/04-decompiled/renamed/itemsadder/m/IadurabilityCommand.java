package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PluginCommand_2;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class IadurabilityCommand
extends PluginCommand_2 {
    public IadurabilityCommand() {
        Main.cM("iadurability").setExecutor((CommandExecutor)this);
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
        if (!s.c((Permissible)player, "ia.admin.iadurability")) {
            return true;
        }
        if (!PluginCommand_2.a(1, stringArray)) {
            CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("wrong-command-usage"));
            CommandSenderBridge_5.f((CommandSender)player, ColorBridge.gH("&e/iadurability &b<amount>"));
            CommandSenderBridge_5.f((CommandSender)player, ColorBridge.gH("&6Example: &e/iadurability &b300"));
            return true;
        }
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (!ItemStackBridge_2.ap(itemStack)) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("cannot-set-durability"));
            return true;
        }
        if (!ItemStackBuilder_4.F(itemStack)) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("set-durability-successfully"));
            ItemStackBridge_2.d(itemStack, Integer.parseInt(stringArray[0]));
            return true;
        }
        ItemStackBuilder_4.d(itemStack, Integer.parseInt(stringArray[0]));
        CommandSenderBridge_5.f(commandSender, Main.PQ.ir("set-durability-successfully"));
        return true;
    }
}
