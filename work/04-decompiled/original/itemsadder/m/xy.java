package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.qm;
import itemsadder.m.za;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class xy
extends za {
    public xy() {
        Main.cM("iadurability").setExecutor((CommandExecutor)this);
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
        if (!s.c((Permissible)player, "ia.admin.iadurability")) {
            return true;
        }
        if (!za.a(1, stringArray)) {
            bce.f((CommandSender)player, Main.PQ.ir("wrong-command-usage"));
            bce.f((CommandSender)player, bcy.gH("&e/iadurability &b<amount>"));
            bce.f((CommandSender)player, bcy.gH("&6Example: &e/iadurability &b300"));
            return true;
        }
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (!bbs.ap(itemStack)) {
            bce.f(commandSender, Main.PQ.ir("cannot-set-durability"));
            return true;
        }
        if (!qm.F(itemStack)) {
            bce.f(commandSender, Main.PQ.ir("set-durability-successfully"));
            bbs.d(itemStack, Integer.parseInt(stringArray[0]));
            return true;
        }
        qm.d(itemStack, Integer.parseInt(stringArray[0]));
        bce.f(commandSender, Main.PQ.ir("set-durability-successfully"));
        return true;
    }
}
