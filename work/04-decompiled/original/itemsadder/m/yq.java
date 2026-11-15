package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbu;
import itemsadder.m.bbv;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.za;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class yq
extends za {
    public yq() {
        Main.cM("iaremove").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!za.a(2, stringArray)) {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            bce.f(commandSender, bcy.gH("&e/iaremove &b<player> <itemNameInConfig> [amount] [silent]"));
            bce.f(commandSender, bcy.gH("&6Example: &e/iaremove &bNotch sword2 1"));
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
            ItemStack itemStack = d.g().e(stringArray[1]).mP();
            int n = 1;
            if (stringArray.length > 2) {
                n = bcy.w(stringArray[2], 1);
            }
            itemStack.setAmount(n);
            int n2 = yq.b(player, itemStack);
            player.updateInventory();
            if (!bl) {
                bce.f(commandSender, Main.PQ.ir("removed-item").replace("{item}", stringArray[1] + "x" + n2).replace("{player}", player.getDisplayName()));
                bce.f((CommandSender)player, Main.PQ.ir("lost-item").replace("{item}", stringArray[1] + "x" + n2));
            }
        } else if (!bl) {
            bce.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[1]));
        }
        return true;
    }

    public static int b(Player player, ItemStack itemStack) {
        int n = 0;
        bbu bbu2 = new bbu(player);
        for (int i = 0; i < bbu2.Dd(); ++i) {
            bbv bbv2 = bbu2.bJ(i);
            if (bbv2 == null || bbv2.aAy || !qm.b(bbv2.aAx, itemStack)) continue;
            while (bbu2.bG(i) > 0 && itemStack.getAmount() > 0) {
                bbu2.bH(i);
                itemStack.setAmount(itemStack.getAmount() - 1);
                ++n;
            }
        }
        bbu2.applyChanges();
        return n;
    }
}
