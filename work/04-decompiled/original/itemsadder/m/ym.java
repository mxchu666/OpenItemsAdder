package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ai;
import itemsadder.m.aqp;
import itemsadder.m.bce;
import itemsadder.m.bcu;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.za;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ym
extends za
implements ai {
    public ym() {
        Main.cM("iaplaytotemanimation").setExecutor((CommandExecutor)this);
        bev.a(this, (Plugin)Main.rS());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length < 2) {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaplaytotemanimation <totem> <player> [silent]. Example: /iaplaytotemanimation totem LoneDev");
            return true;
        }
        boolean bl = stringArray.length == 3 && stringArray[2].equalsIgnoreCase("silent");
        Player player = Bukkit.getPlayer((String)stringArray[1]);
        if (player == null) {
            if (!bl) {
                bce.g(commandSender, "player-offline");
            }
            return true;
        }
        qm qm2 = d.g().e(stringArray[0]);
        if (qm2 == null) {
            if (!bl) {
                bce.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[0]));
            }
            return true;
        }
        bcu.b(Sound.ITEM_TOTEM_USE, player, SoundCategory.PLAYERS, 20L, () -> aqp.e(player, qm2));
        if (!bl) {
            bce.f(commandSender, Main.PQ.ir("played-totem-animation").replace("{totem}", qm2.getNamespacedID()).replace("{player}", player.getName()));
        }
        return true;
    }
}
