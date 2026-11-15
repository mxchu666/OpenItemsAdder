package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_31;
import itemsadder.m.PluginCommand_2;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class IarecipeCommand
extends PluginCommand_2 {
    public IarecipeCommand() {
        Main.cM("iarecipe").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        ItemStackBuilder_4 itemStackBuilder_4;
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
                CommandSenderBridge_5.g(commandSender, "player-offline");
                return true;
            }
        } else {
            if (!(commandSender instanceof Player)) {
                CommandSenderBridge_5.iy("command-ingame-only");
                return true;
            }
            player = (Player)commandSender;
        }
        if (stringArray.length == 0) {
            itemStackBuilder_4 = ItemStackRegistry.g().a(ItemStackBridge_2.cA(player));
            if (itemStackBuilder_4 == null) {
                player.sendMessage(Main.PQ.ir("iarecipe-no-custom-item"));
                return true;
            }
        } else {
            itemStackBuilder_4 = ItemStackRegistry.g().e(stringArray[0]);
            if (itemStackBuilder_4 == null) {
                player.sendMessage(Main.PQ.ir("iarecipe-wrong-usage"));
                return true;
            }
        }
        ((PlayerBridge_31)ItemStackRegistry.g().bi.Ue.Td.get(itemStackBuilder_4.getNamespacedID())).a(null, null, player, true);
        return true;
    }
}
