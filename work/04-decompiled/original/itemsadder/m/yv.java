package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import dev.lone.itemsadder.utils.json.a;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.za;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class yv
extends za {
    public yv() {
        Main.cM("iatag").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        boolean bl;
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            bce.warn(Main.PQ.ir("command-ingame-only"));
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
        qm qm2 = d.g().a(itemStack);
        if (qm2 != null) {
            player.sendMessage(String.valueOf(ChatColor.DARK_GREEN) + "Custom Item: " + String.valueOf(ChatColor.GRAY) + qm2.getNamespacedID());
            player.sendMessage(String.valueOf(ChatColor.DARK_GREEN) + "File: " + String.valueOf(ChatColor.GRAY) + qm2.nh());
        } else {
            player.sendMessage(String.valueOf(ChatColor.DARK_GREEN) + "Not a Custom Item: " + String.valueOf(ChatColor.GRAY) + String.valueOf(itemStack.getType()));
        }
        NItem nItem = new NItem(itemStack);
        boolean bl2 = bcy.e(stringArray, "pretty-print");
        String string2 = "NBT data for the item in " + player.getName() + "'s hand:";
        String string3 = bl2 ? a.jg(nItem.toString()) : nItem.toString();
        boolean bl3 = bcy.e(stringArray, "show-in-console");
        boolean bl4 = bl = bcy.e(stringArray, "show-in-chat") || !bl3;
        if (bl) {
            player.sendMessage(string2);
            player.sendMessage(string3);
        }
        if (commandSender.hasPermission("ia.admin.iatag.show-in-console")) {
            if (bl3) {
                player.sendMessage(String.valueOf(ChatColor.GRAY) + "(NBT data sent to console)");
                bce.log(string2);
                bce.log(string3);
            }
        } else {
            player.sendMessage(String.valueOf(ChatColor.RED) + "You don't have permission to show the NBT data in the console.");
        }
        return true;
    }
}
