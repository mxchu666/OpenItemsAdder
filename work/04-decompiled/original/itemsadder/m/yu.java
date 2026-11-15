package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ai;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bev;
import itemsadder.m.wz;
import itemsadder.m.za;
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

public class yu
extends za
implements ai {
    WeakHashMap SG = new WeakHashMap();

    public yu() {
        Main.cM("iaspawntree").setExecutor((CommandExecutor)this);
        bev.a(this, (Plugin)Main.rS());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            bce.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        if (stringArray.length == 0) {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iaspawntree <namespace>. Example: /iaspawntree example");
            return true;
        }
        if (wz.Oz.containsKey(stringArray[0])) {
            this.SG.put(player, stringArray[0]);
            bce.g((CommandSender)player, "rightclick-a-block");
        } else {
            bce.f((CommandSender)player, Main.PQ.ir("tree-not-found").replace("{item}", stringArray[0]));
        }
        return true;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void p(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        wz wz2 = (wz)wz.Oz.get(this.SG.get(playerInteractEvent.getPlayer()));
        if (wz2 == null) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock().getRelative(BlockFace.UP);
        if (!bcc.b(block, playerInteractEvent.getPlayer())) {
            return;
        }
        if (!block.getType().isOccluding()) {
            block.setType(Material.AIR, false);
        }
        if (wz2.j(block, false)) {
            bce.g((CommandSender)playerInteractEvent.getPlayer(), "spawned-tree");
        } else {
            bce.g((CommandSender)playerInteractEvent.getPlayer(), "spawned-tree-error");
        }
        this.SG.remove(playerInteractEvent.getPlayer());
    }
}
