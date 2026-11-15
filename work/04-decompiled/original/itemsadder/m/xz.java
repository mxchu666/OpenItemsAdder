package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.ae;
import itemsadder.m.bce;
import itemsadder.m.da;
import itemsadder.m.dc;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class xz
implements CommandExecutor {
    public xz() {
        Main.cM("iaemote").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string2, @NotNull String[] stringArray) {
        if (!ae.dL) {
            bce.g(commandSender, "custom-entities-disabled");
            return true;
        }
        if (!ae.dM) {
            bce.g(commandSender, "emotes-disabled");
            return true;
        }
        if (stringArray.length > 0) {
            if (da.db().dc()) {
                Player player;
                if (stringArray.length > 1) {
                    if (!commandSender.hasPermission("ia.user.iaemote.others")) {
                        bce.f(commandSender, Main.PQ.ir("no-permission-detail").replace("{permission}", "ia.user.iaemote.others"));
                        return true;
                    }
                    player = Bukkit.getPlayer((String)stringArray[1]);
                } else if (commandSender instanceof Player) {
                    player = (Player)commandSender;
                } else {
                    bce.iy("command-ingame-only");
                    return true;
                }
                if (player == null) {
                    bce.f(commandSender, Main.PQ.ir("player-offline"));
                    return true;
                }
                if (stringArray[0].equalsIgnoreCase("stop-now")) {
                    da.db().X(player);
                    return true;
                }
                if (stringArray[0].equalsIgnoreCase("stop")) {
                    da.db().Y(player);
                    return true;
                }
                if (s.b((Permissible)commandSender, s.cZ(stringArray[0]), true)) {
                    if (stringArray[0].equals("idle")) {
                        bce.g(commandSender, "this-animation-cannot-be-used-as-emote");
                        return true;
                    }
                    dc dc2 = da.db().b(player, stringArray[0]);
                    if (dc2 == dc.UNKNOWN_EMOTE) {
                        bce.a(commandSender, "unknown-emote", string -> string.replace("{emote}", stringArray[0]));
                    }
                }
            } else {
                bce.f(commandSender, String.valueOf(ChatColor.RED) + "FATAL ERROR! Can't find player model.");
                bce.error("FATAL ERROR! Can't find player model.");
            }
        } else {
            bce.g(commandSender, "no-emote-specified");
        }
        return true;
    }
}
