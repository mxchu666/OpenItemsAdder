package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.za;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class yb
extends za {
    public yb() {
        Main.cM("iaget").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            bce.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        if (!za.a(1, stringArray)) {
            bce.f((CommandSender)player, Main.PQ.ir("wrong-command-usage"));
            bce.f((CommandSender)player, String.valueOf(ChatColor.YELLOW) + "/iaget " + String.valueOf(ChatColor.AQUA) + "<itemNameInConfig> [amount]");
            bce.f((CommandSender)player, String.valueOf(ChatColor.GOLD) + "Example: " + String.valueOf(ChatColor.YELLOW) + "/iaget " + String.valueOf(ChatColor.AQUA) + "sword1");
            return true;
        }
        if (d.g().f(stringArray[0])) {
            ItemStack itemStack = d.g().m(stringArray[0]);
            int n = 1;
            if (stringArray.length > 1) {
                n = bcy.w(stringArray[1], 1);
            }
            itemStack.setAmount(n);
            bbs.f(player, itemStack);
            bce.f((CommandSender)player, Main.PQ.ir("obtained-item").replace("{item}", stringArray[0]));
        } else {
            bce.f((CommandSender)player, Main.PQ.ir("item-not-found").replace("{item}", stringArray[0]));
        }
        return true;
    }
}
