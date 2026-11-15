package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.kf;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class kw
implements ai {
    private final Plugin zE;
    private final d zF;

    public kw(Plugin plugin, d d2) {
        this.zE = plugin;
        this.zF = d2;
        bev.a(this, plugin);
        d2.ar.a(new my(PlayerInteractEvent.class, this::f));
        d2.ar.a(new my(BlockPlaceEvent.class, this::b));
    }

    @mz
    private void f(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        if (playerInteractEvent.isCancelled()) {
            return;
        }
        if (bbs.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (!qm2.Ge.bm("sapling")) {
            return;
        }
        kf kf2 = (kf)qm2.Ge.bn("sapling");
        playerInteractEvent.setCancelled(true);
        kf2.a(itemStack, playerInteractEvent.getPlayer(), playerInteractEvent.getClickedBlock().getRelative(BlockFace.UP));
    }

    @mz
    private void b(BlockPlaceEvent blockPlaceEvent, qm qm2, ItemStack itemStack) {
        if (blockPlaceEvent.isCancelled()) {
            return;
        }
        if (!qm2.Ge.bm("sapling")) {
            return;
        }
        kf kf2 = (kf)qm2.Ge.bn("sapling");
        blockPlaceEvent.setCancelled(true);
        kf2.a(itemStack, blockPlaceEvent.getPlayer(), blockPlaceEvent.getBlockPlaced().getLocation().getBlock());
    }
}
