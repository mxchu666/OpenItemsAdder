package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.da;
import itemsadder.m.ya;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class xw
implements CommandExecutor {
    public xw() {
        Main.cM("iadisguise").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!ae.dL) {
            bce.g(commandSender, "custom-entities-disabled");
            return true;
        }
        if (stringArray.length > 0) {
            String string3 = stringArray[0];
            if (!ya.dm(string3)) {
                bce.a(commandSender, "unknown-entity", string2 -> string2.replace("{entity}", string3));
                return true;
            }
            if (commandSender instanceof Player) {
                Player player = (Player)commandSender;
                boolean bl = da.db().c(player, string3);
                if (!bl) {
                    bce.a(commandSender, "disguise-failed", string2 -> {
                        string2 = string2.replace("{entity}", string3);
                        return string2;
                    });
                }
                return true;
            }
            bce.f(commandSender, Main.PQ.ir("command-ingame-only"));
            return true;
        }
        this.d(commandSender);
        return true;
    }

    private void d(CommandSender commandSender) {
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "Command usage:");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "   /iadisguise <name> - Disguise yourself as an entity");
    }
}
