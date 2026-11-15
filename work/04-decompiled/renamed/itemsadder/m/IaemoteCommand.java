package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PlayEnum;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class IaemoteCommand
implements CommandExecutor {
    public IaemoteCommand() {
        Main.cM("iaemote").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string2, @NotNull String[] stringArray) {
        if (!MaterialBarColorHolder.dL) {
            CommandSenderBridge_5.g(commandSender, "custom-entities-disabled");
            return true;
        }
        if (!MaterialBarColorHolder.dM) {
            CommandSenderBridge_5.g(commandSender, "emotes-disabled");
            return true;
        }
        if (stringArray.length > 0) {
            if (LivingEntityRegistry.db().dc()) {
                Player player;
                if (stringArray.length > 1) {
                    if (!commandSender.hasPermission("ia.user.iaemote.others")) {
                        CommandSenderBridge_5.f(commandSender, Main.PQ.ir("no-permission-detail").replace("{permission}", "ia.user.iaemote.others"));
                        return true;
                    }
                    player = Bukkit.getPlayer((String)stringArray[1]);
                } else if (commandSender instanceof Player) {
                    player = (Player)commandSender;
                } else {
                    CommandSenderBridge_5.iy("command-ingame-only");
                    return true;
                }
                if (player == null) {
                    CommandSenderBridge_5.f(commandSender, Main.PQ.ir("player-offline"));
                    return true;
                }
                if (stringArray[0].equalsIgnoreCase("stop-now")) {
                    LivingEntityRegistry.db().X(player);
                    return true;
                }
                if (stringArray[0].equalsIgnoreCase("stop")) {
                    LivingEntityRegistry.db().Y(player);
                    return true;
                }
                if (s.b((Permissible)commandSender, s.cZ(stringArray[0]), true)) {
                    if (stringArray[0].equals("idle")) {
                        CommandSenderBridge_5.g(commandSender, "this-animation-cannot-be-used-as-emote");
                        return true;
                    }
                    PlayEnum playEnum = LivingEntityRegistry.db().b(player, stringArray[0]);
                    if (playEnum == PlayEnum.UNKNOWN_EMOTE) {
                        CommandSenderBridge_5.a(commandSender, "unknown-emote", string -> string.replace("{emote}", stringArray[0]));
                    }
                }
            } else {
                CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + "FATAL ERROR! Can't find player model.");
                CommandSenderBridge_5.error("FATAL ERROR! Can't find player model.");
            }
        } else {
            CommandSenderBridge_5.g(commandSender, "no-emote-specified");
        }
        return true;
    }
}
