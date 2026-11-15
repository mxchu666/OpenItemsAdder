package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import dev.lone.itemsadder.utils.json.a;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginCommand_2;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class IatagCommand
extends PluginCommand_2 {
    public IatagCommand() {
        Main.cM("iatag").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        boolean bl;
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            CommandSenderBridge_5.warn(Main.PQ.ir("command-ingame-only"));
            return true;
        }
        Player player = (Player)commandSender;
        if (!s.c((Permissible)player, "ia.admin.iatag")) {
            return true;
        }
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack.getType() == Material.AIR) {
            return true;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 != null) {
            player.sendMessage(String.valueOf(ChatColor.DARK_GREEN) + "Custom Item: " + String.valueOf(ChatColor.GRAY) + itemStackBuilder_4.getNamespacedID());
            player.sendMessage(String.valueOf(ChatColor.DARK_GREEN) + "File: " + String.valueOf(ChatColor.GRAY) + itemStackBuilder_4.nh());
        } else {
            player.sendMessage(String.valueOf(ChatColor.DARK_GREEN) + "Not a Custom Item: " + String.valueOf(ChatColor.GRAY) + String.valueOf(itemStack.getType()));
        }
        NItem nItem = new NItem(itemStack);
        boolean bl2 = ColorBridge.e(stringArray, "pretty-print");
        String string2 = "NBT data for the item in " + player.getName() + "'s hand:";
        String string3 = bl2 ? a.jg(nItem.toString()) : nItem.toString();
        boolean bl3 = ColorBridge.e(stringArray, "show-in-console");
        boolean bl4 = bl = ColorBridge.e(stringArray, "show-in-chat") || !bl3;
        if (bl) {
            player.sendMessage(string2);
            player.sendMessage(string3);
        }
        if (commandSender.hasPermission("ia.admin.iatag.show-in-console")) {
            if (bl3) {
                player.sendMessage(String.valueOf(ChatColor.GRAY) + "(NBT data sent to console)");
                CommandSenderBridge_5.log(string2);
                CommandSenderBridge_5.log(string3);
            }
        } else {
            player.sendMessage(String.valueOf(ChatColor.RED) + "You don't have permission to show the NBT data in the console.");
        }
        return true;
    }
}
