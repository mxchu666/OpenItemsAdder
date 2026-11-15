package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.za;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class yc
extends za {
    public yc() {
        Main.cM("iagive").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!za.a(2, stringArray)) {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            bce.f(commandSender, bcy.gH("&e/iagive &b<player> <itemNameInConfig> [amount] [silent]"));
            bce.f(commandSender, bcy.gH("&6Example: &e/iagive &bNotch sword2 3"));
            return true;
        }
        boolean bl = stringArray.length == 4 && stringArray[3].equalsIgnoreCase("silent");
        Player player = Bukkit.getPlayer((String)stringArray[0]);
        if (player == null) {
            if (!bl) {
                bce.f(commandSender, Main.PQ.ir("player-offline"));
            }
            return true;
        }
        if (d.g().f(stringArray[1])) {
            ItemStack itemStack = d.g().m(stringArray[1]);
            int n = 1;
            if (stringArray.length > 2) {
                n = bcy.w(stringArray[2], 1);
            }
            itemStack.setAmount(n);
            bbs.f(player, itemStack);
            if (!bl) {
                bce.f(commandSender, Main.PQ.ir("given-item").replace("{item}", stringArray[1]).replace("{player}", player.getDisplayName()));
                bce.f((CommandSender)player, Main.PQ.ir("obtained-item").replace("{item}", itemStack.getItemMeta().getDisplayName()));
            }
        } else if (!bl) {
            bce.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[1]));
        }
        return true;
    }
}
