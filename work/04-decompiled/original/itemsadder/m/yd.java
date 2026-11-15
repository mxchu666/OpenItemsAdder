package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ii;
import itemsadder.m.jg;
import itemsadder.m.za;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class yd
extends za {
    public yd() {
        Main.cM("iahud").setExecutor((CommandExecutor)this);
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
        if (stringArray.length == 0) {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iahud <hud>. Example: /iahud magiccraft:mana_bar");
            return true;
        }
        for (ii ii2 : ((jg)d.g().ao.wW.get((Object)player)).xe) {
            if (!ii2.getNamespacedID().equals(stringArray[0])) continue;
            ii2.setVisible(!ii2.isVisible());
        }
        d.g().ao.al(player);
        return true;
    }
}
