package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerInteractListener;
import itemsadder.m.PluginCommand;
import itemsadder.m.PluginCommand_2;
import java.util.Map;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class CropsCommand
extends PluginCommand_2 {
    public static Map Sv = new WeakHashMap();

    public CropsCommand() {
        Main.cM("crops").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length == 0 || stringArray.length > 3) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /crops <enable|disable> [player]. Example: /crops enable LoneDev");
            return true;
        }
        boolean bl = stringArray[0].equalsIgnoreCase("enable");
        boolean bl2 = s.c((Permissible)commandSender, "ia.admin.crops.others");
        if (bl && !bl2 && System.currentTimeMillis() - Sv.getOrDefault(commandSender, 0L) < 10000L) {
            CommandSenderBridge_5.g(commandSender, "please-wait-command-cooldown");
            return true;
        }
        Player player = null;
        if (stringArray.length == 1) {
            if (!(commandSender instanceof Player)) {
                return PluginCommand.a(commandSender);
            }
            player = (Player)commandSender;
        } else if (stringArray.length == 2) {
            if (!bl2) {
                return true;
            }
            player = Bukkit.getPlayer((String)stringArray[1]);
            if (player == null) {
                CommandSenderBridge_5.g(commandSender, "player-offline");
                return true;
            }
        }
        assert (player != null);
        if (bl) {
            ItemStackRegistry.g().v().kO.C(player);
            PlayerInteractListener.d(player, false);
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("crops-view-enabled"));
        } else {
            ItemStackRegistry.g().v().kO.D(player);
            PlayerInteractListener.d(player, true);
            ItemStackRegistry.g().v().kQ.H(player);
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("crops-view-disabled"));
        }
        Sv.put(player, System.currentTimeMillis());
        return true;
    }
}
