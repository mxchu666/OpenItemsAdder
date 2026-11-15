package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.MaterialBarColorHolder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IaundisguiseCommand
implements CommandExecutor {
    public IaundisguiseCommand() {
        Main.cM("iaundisguise").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!MaterialBarColorHolder.dL) {
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.YELLOW) + "custom-entities is disabled in config.yml");
            return true;
        }
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;
            if (LivingEntityRegistry.db().W(player)) {
                CommandSenderBridge_5.g(commandSender, "undisguised");
            } else {
                CommandSenderBridge_5.g(commandSender, "not-disguised");
            }
        } else {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("command-ingame-only"));
            return true;
        }
        return true;
    }
}
