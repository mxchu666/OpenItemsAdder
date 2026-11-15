package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.za;
import itemsadder.m.zl;
import itemsadder.m.zo;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class xp
extends za {
    public xp() {
        Main.cM("ia").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        zo zo2 = d.g().bi;
        if (!d.g().u || zo2 == null) {
            return true;
        }
        if (stringArray.length == 0) {
            if (!(commandSender instanceof Player)) {
                return xp.a(commandSender);
            }
            zo2.Ue.bw((Player)commandSender);
        } else {
            String string2;
            zl zl2;
            Player player;
            if (!s.c((Permissible)commandSender, "ia.user.ia.categories")) {
                return true;
            }
            if (stringArray.length == 2) {
                if (!s.c((Permissible)commandSender, "ia.user.ia.categories.others")) {
                    return true;
                }
                player = Bukkit.getPlayer((String)stringArray[1]);
                if (player == null) {
                    bce.g(commandSender, "player-offline");
                    return true;
                }
            } else {
                if (!(commandSender instanceof Player)) {
                    return xp.a(commandSender);
                }
                player = (Player)commandSender;
            }
            if ((zl2 = zo2.Ue.dn(string2 = stringArray[0])) != null) {
                if (zl2.getPermission() == null || commandSender.hasPermission(zl2.getPermission())) {
                    zl2.k(player, true);
                } else {
                    bce.f(commandSender, Main.PQ.ir("no-permission"));
                }
            } else {
                bce.f(commandSender, Main.PQ.ir("unknown-category").replace("{name}", string2));
            }
        }
        return true;
    }

    public static boolean a(CommandSender commandSender) {
        bce.iy("command-ingame-only");
        return true;
    }
}
