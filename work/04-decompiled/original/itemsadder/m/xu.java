package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.za;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class xu
extends za {
    public xu() {
        Main.cM("iacustommodeldata").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!za.a(1, stringArray)) {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            bce.f(commandSender, String.valueOf(ChatColor.YELLOW) + "/iacustommodeldata " + String.valueOf(ChatColor.AQUA) + "<itemNameInConfig>");
            bce.f(commandSender, String.valueOf(ChatColor.GOLD) + "Example: " + String.valueOf(ChatColor.YELLOW) + "/iacustommodeldata " + String.valueOf(ChatColor.AQUA) + "sword1");
            return true;
        }
        if (d.g().f(stringArray[0])) {
            qm qm2 = d.g().e(stringArray[0]);
            bce.f(commandSender, qm2.getNamespacedID() + " -> " + String.valueOf(qm2.getType()) + " {CustomModelData: " + qm2.fX() + "}");
        } else {
            bce.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[0]));
        }
        return true;
    }
}
