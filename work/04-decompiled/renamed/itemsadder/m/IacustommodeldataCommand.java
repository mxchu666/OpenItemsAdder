package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginCommand_2;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class IacustommodeldataCommand
extends PluginCommand_2 {
    public IacustommodeldataCommand() {
        Main.cM("iacustommodeldata").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!PluginCommand_2.a(1, stringArray)) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.YELLOW) + "/iacustommodeldata " + String.valueOf(ChatColor.AQUA) + "<itemNameInConfig>");
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.GOLD) + "Example: " + String.valueOf(ChatColor.YELLOW) + "/iacustommodeldata " + String.valueOf(ChatColor.AQUA) + "sword1");
            return true;
        }
        if (ItemStackRegistry.g().f(stringArray[0])) {
            ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(stringArray[0]);
            CommandSenderBridge_5.f(commandSender, itemStackBuilder_4.getNamespacedID() + " -> " + String.valueOf(itemStackBuilder_4.getType()) + " {CustomModelData: " + itemStackBuilder_4.fX() + "}");
        } else {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[0]));
        }
        return true;
    }
}
