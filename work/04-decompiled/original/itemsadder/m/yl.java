package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.za;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class yl
extends za {
    public yl() {
        Main.cM("iaplaysound").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length < 2) {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaplaysound <sound> <player>. Example: /iaplaysound itemsadder:ambient.angelic LoneDev 10 1");
            return true;
        }
        Player player = Bukkit.getPlayer((String)stringArray[1]);
        if (player == null) {
            bce.g(commandSender, "player-offline");
            return true;
        }
        player.playSound(player.getLocation(), stringArray[0], za.a(stringArray, 2, 10.0f), za.a(stringArray, 3, 1.0f));
        return true;
    }
}
