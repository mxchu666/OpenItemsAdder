package itemsadder.m;

import dev.lone.itemsadder.api.Events.CustomBlockInteractEvent;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockHolder_2;
import itemsadder.m.BlockPlaceListener_2;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
import itemsadder.m.RealEnum;
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

public final class BlockBreakListener
implements PluginContract {
    public void register(Plugin plugin) {
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        if (blockBreakEvent.getBlock().getType() != Material.CHORUS_PLANT) {
            return;
        }
        if (blockBreakEvent.getBlock().getRelative(BlockFace.UP).getType() == Material.CHORUS_PLANT || blockBreakEvent.getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
            blockBreakEvent.getBlock().setType(Material.AIR, true);
        } else {
            blockBreakEvent.setCancelled(true);
            BlockHolder_2.tN().d(blockBreakEvent.getBlock(), Material.AIR);
            ItemStackRegistry.g().aT.C(blockBreakEvent.getBlock().getLocation());
        }
    }

    @EventHandler(priority=EventPriority.LOWEST, ignoreCancelled=true)
    private void a(ItemSpawnEvent itemSpawnEvent) {
        if (itemSpawnEvent.getEntity().getItemStack().getType() != Material.CHORUS_FRUIT) {
            return;
        }
        if (ItemStackRegistry.isCustomBlock(itemSpawnEvent.getLocation().getBlock()) || ItemStackRegistry.g().aT.z(itemSpawnEvent.getLocation().getBlock())) {
            itemSpawnEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void b(ProjectileHitEvent projectileHitEvent) {
        if (projectileHitEvent.getHitBlock() == null || projectileHitEvent.getHitBlock().getType() != Material.CHORUS_PLANT) {
            return;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(projectileHitEvent.getHitBlock());
        if (!blockBridge_9.isCustomBlock(projectileHitEvent.getHitBlock())) {
            return;
        }
        if (EntityHolder.b(projectileHitEvent.getEntity())) {
            EntityHolder.a(projectileHitEvent.getEntity());
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void b(CustomBlockInteractEvent customBlockInteractEvent) {
        if (customBlockInteractEvent.getItem() == null || customBlockInteractEvent.getItem().getType() != Material.WATER_BUCKET) {
            return;
        }
        if (customBlockInteractEvent.internal.Hq == RealEnum.REAL_TRANSPARENT || customBlockInteractEvent.internal.Hq == RealEnum.REAL_WIRE) {
            customBlockInteractEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerBucketEmptyEvent playerBucketEmptyEvent) {
        if (playerBucketEmptyEvent.getBlockClicked().getType() != Material.CHORUS_PLANT) {
            return;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(playerBucketEmptyEvent.getBlockClicked());
        if (!blockBridge_9.isCustomBlock(playerBucketEmptyEvent.getBlockClicked())) {
            return;
        }
        playerBucketEmptyEvent.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(BlockPlaceEvent blockPlaceEvent) {
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        if (BlockPlaceListener_2.aI(blockPlaceEvent.getPlayer())) {
            return;
        }
        if (blockPlaceEvent.getBlockPlaced().getType() != Material.CHORUS_PLANT) {
            return;
        }
        BlockHolder_2.tN().be(blockPlaceEvent.getBlock());
    }
}
