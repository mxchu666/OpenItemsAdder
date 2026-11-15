package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PluginCommand_2;
import itemsadder.m.PluginContract;
import itemsadder.m.SoundBridge;
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

public class IaplaytotemanimationCommand
extends PluginCommand_2
implements PluginContract {
    public IaplaytotemanimationCommand() {
        Main.cM("iaplaytotemanimation").setExecutor((CommandExecutor)this);
        ListenerBridge.a(this, (Plugin)Main.rS());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length < 2) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaplaytotemanimation <totem> <player> [silent]. Example: /iaplaytotemanimation totem LoneDev");
            return true;
        }
        boolean bl = stringArray.length == 3 && stringArray[2].equalsIgnoreCase("silent");
        Player player = Bukkit.getPlayer((String)stringArray[1]);
        if (player == null) {
            if (!bl) {
                CommandSenderBridge_5.g(commandSender, "player-offline");
            }
            return true;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(stringArray[0]);
        if (itemStackBuilder_4 == null) {
            if (!bl) {
                CommandSenderBridge_5.f(commandSender, Main.PQ.ir("item-not-found").replace("{item}", stringArray[0]));
            }
            return true;
        }
        SoundBridge.b(Sound.ITEM_TOTEM_USE, player, SoundCategory.PLAYERS, 20L, () -> PlayerHolder_4.e(player, itemStackBuilder_4));
        if (!bl) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("played-totem-animation").replace("{totem}", itemStackBuilder_4.getNamespacedID()).replace("{player}", player.getName()));
        }
        return true;
    }
}
