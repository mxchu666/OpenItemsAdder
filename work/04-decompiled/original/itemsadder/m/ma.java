package itemsadder.m;

import dev.lone.itemsadder.api.Events.CustomBlockInteractEvent;
import itemsadder.m.afz;
import itemsadder.m.ahd;
import itemsadder.m.ai;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.lh;
import itemsadder.m.ms;
import itemsadder.m.sd;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.plugin.Plugin;

public final class ma
implements ai {
    public void register(Plugin plugin) {
        bev.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        if (blockBreakEvent.getBlock().getType() != Material.CHORUS_PLANT) {
            return;
        }
        if (blockBreakEvent.getBlock().getRelative(BlockFace.UP).getType() == Material.CHORUS_PLANT || blockBreakEvent.getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
            blockBreakEvent.getBlock().setType(Material.AIR, true);
        } else {
            blockBreakEvent.setCancelled(true);
            ahd.tN().d(blockBreakEvent.getBlock(), Material.AIR);
            d.g().aT.C(blockBreakEvent.getBlock().getLocation());
        }
    }

    @EventHandler(priority=EventPriority.LOWEST, ignoreCancelled=true)
    private void a(ItemSpawnEvent itemSpawnEvent) {
        if (itemSpawnEvent.getEntity().getItemStack().getType() != Material.CHORUS_FRUIT) {
            return;
        }
        if (d.isCustomBlock(itemSpawnEvent.getLocation().getBlock()) || d.g().aT.z(itemSpawnEvent.getLocation().getBlock())) {
            itemSpawnEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void b(ProjectileHitEvent projectileHitEvent) {
        if (projectileHitEvent.getHitBlock() == null || projectileHitEvent.getHitBlock().getType() != Material.CHORUS_PLANT) {
            return;
        }
        ms ms2 = d.g().b(projectileHitEvent.getHitBlock());
        if (!ms2.isCustomBlock(projectileHitEvent.getHitBlock())) {
            return;
        }
        if (afz.b(projectileHitEvent.getEntity())) {
            afz.a(projectileHitEvent.getEntity());
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void b(CustomBlockInteractEvent customBlockInteractEvent) {
        if (customBlockInteractEvent.getItem() == null || customBlockInteractEvent.getItem().getType() != Material.WATER_BUCKET) {
            return;
        }
        if (customBlockInteractEvent.internal.Hq == sd.REAL_TRANSPARENT || customBlockInteractEvent.internal.Hq == sd.REAL_WIRE) {
            customBlockInteractEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerBucketEmptyEvent playerBucketEmptyEvent) {
        if (playerBucketEmptyEvent.getBlockClicked().getType() != Material.CHORUS_PLANT) {
            return;
        }
        ms ms2 = d.g().b(playerBucketEmptyEvent.getBlockClicked());
        if (!ms2.isCustomBlock(playerBucketEmptyEvent.getBlockClicked())) {
            return;
        }
        playerBucketEmptyEvent.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(BlockPlaceEvent blockPlaceEvent) {
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        if (lh.aI(blockPlaceEvent.getPlayer())) {
            return;
        }
        if (blockPlaceEvent.getBlockPlaced().getType() != Material.CHORUS_PLANT) {
            return;
        }
        ahd.tN().be(blockPlaceEvent.getBlock());
    }
}
