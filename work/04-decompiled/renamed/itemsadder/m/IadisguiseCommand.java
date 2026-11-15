package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.IaentityCommand;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.MaterialBarColorHolder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class IadisguiseCommand
implements CommandExecutor {
    public IadisguiseCommand() {
        Main.cM("iadisguise").setExecutor((CommandExecutor)this);
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!MaterialBarColorHolder.dL) {
            CommandSenderBridge_5.g(commandSender, "custom-entities-disabled");
            return true;
        }
        if (stringArray.length > 0) {
            String string3 = stringArray[0];
            if (!IaentityCommand.dm(string3)) {
                CommandSenderBridge_5.a(commandSender, "unknown-entity", string2 -> string2.replace("{entity}", string3));
                return true;
            }
            if (commandSender instanceof Player) {
                Player player = (Player)commandSender;
                boolean bl = LivingEntityRegistry.db().c(player, string3);
                if (!bl) {
                    CommandSenderBridge_5.a(commandSender, "disguise-failed", string2 -> {
                        string2 = string2.replace("{entity}", string3);
                        return string2;
                    });
                }
                return true;
            }
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("command-ingame-only"));
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
