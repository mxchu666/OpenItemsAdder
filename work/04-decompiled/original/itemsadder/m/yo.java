package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.za;
import itemsadder.m.zn;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class yo
extends za {
    public yo() {
        Main.cM("iarecipe").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        qm qm2;
        Player player;
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!s.c((Permissible)commandSender, "ia.user.iarecipe")) {
            return true;
        }
        if (stringArray.length == 2) {
            if (!s.c((Permissible)commandSender, "ia.user.iarecipe.others")) {
                return true;
            }
            player = Bukkit.getPlayer((String)stringArray[1]);
            if (player == null) {
                bce.g(commandSender, "player-offline");
                return true;
            }
        } else {
            if (!(commandSender instanceof Player)) {
                bce.iy("command-ingame-only");
                return true;
            }
            player = (Player)commandSender;
        }
        if (stringArray.length == 0) {
            qm2 = d.g().a(bbs.cA(player));
            if (qm2 == null) {
                player.sendMessage(Main.PQ.ir("iarecipe-no-custom-item"));
                return true;
            }
        } else {
            qm2 = d.g().e(stringArray[0]);
            if (qm2 == null) {
                player.sendMessage(Main.PQ.ir("iarecipe-wrong-usage"));
                return true;
            }
        }
        ((zn)d.g().bi.Ue.Td.get(qm2.getNamespacedID())).a(null, null, player, true);
        return true;
    }
}
