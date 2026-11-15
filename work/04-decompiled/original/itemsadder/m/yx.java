package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.da;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class yx
implements CommandExecutor {
    public yx() {
        Main.cM("iaundisguise").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!ae.dL) {
            bce.f(commandSender, String.valueOf(ChatColor.YELLOW) + "custom-entities is disabled in config.yml");
            return true;
        }
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;
            if (da.db().W(player)) {
                bce.g(commandSender, "undisguised");
            } else {
                bce.g(commandSender, "not-disguised");
            }
        } else {
            bce.f(commandSender, Main.PQ.ir("command-ingame-only"));
            return true;
        }
        return true;
    }
}
