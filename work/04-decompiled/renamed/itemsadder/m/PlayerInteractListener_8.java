package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.PluginCommand_2;
import itemsadder.m.PluginContract;
import itemsadder.m.WorldBridge_11;
import java.util.WeakHashMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class PlayerInteractListener_8
extends PluginCommand_2
implements PluginContract {
    WeakHashMap SG = new WeakHashMap();

    public PlayerInteractListener_8() {
        Main.cM("iaspawntree").setExecutor((CommandExecutor)this);
        ListenerBridge.a(this, (Plugin)Main.rS());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            CommandSenderBridge_5.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        if (stringArray.length == 0) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaspawntree <namespace>. Example: /iaspawntree example");
            return true;
        }
        if (WorldBridge_11.Oz.containsKey(stringArray[0])) {
            this.SG.put(player, stringArray[0]);
            CommandSenderBridge_5.g((CommandSender)player, "rightclick-a-block");
        } else {
            CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("tree-not-found").replace("{item}", stringArray[0]));
        }
        return true;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void p(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        WorldBridge_11 worldBridge_11 = (WorldBridge_11)WorldBridge_11.Oz.get(this.SG.get(playerInteractEvent.getPlayer()));
        if (worldBridge_11 == null) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock().getRelative(BlockFace.UP);
        if (!LocationBridge_2.b(block, playerInteractEvent.getPlayer())) {
            return;
        }
        if (!block.getType().isOccluding()) {
            block.setType(Material.AIR, false);
        }
        if (worldBridge_11.j(block, false)) {
            CommandSenderBridge_5.g((CommandSender)playerInteractEvent.getPlayer(), "spawned-tree");
        } else {
            CommandSenderBridge_5.g((CommandSender)playerInteractEvent.getPlayer(), "spawned-tree-error");
        }
        this.SG.remove(playerInteractEvent.getPlayer());
    }
}
