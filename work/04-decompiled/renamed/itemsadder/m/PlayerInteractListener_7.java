package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_13;
import itemsadder.m.LocationBridge_3;
import itemsadder.m.PluginContract;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class PlayerInteractListener_7
implements PluginContract {
    public static final BlockFace[] EI = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN};

    public PlayerInteractListener_7() {
        ListenerBridge.a(this, (Plugin)Main.rS());
    }

    static LocationBridgeBuilder_2 a(TNTPrimed tNTPrimed) {
        if (!tNTPrimed.getPersistentDataContainer().has(LocationBridge_13.Jt)) {
            return null;
        }
        String string = (String)tNTPrimed.getPersistentDataContainer().get(LocationBridge_13.Jt, PersistentDataType.STRING);
        return ItemStackRegistry.g().h(string);
    }

    static LocationBridge_13 b(TNTPrimed tNTPrimed) {
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = PlayerInteractListener_7.a(tNTPrimed);
        if (locationBridgeBuilder_2 == null) {
            return null;
        }
        return locationBridgeBuilder_2.mK();
    }

    static LocationBridge_13 aq(Block block) {
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.d(block);
        if (locationBridgeBuilder_2 == null) {
            return null;
        }
        return locationBridgeBuilder_2.mK();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerInteractEvent playerInteractEvent) {
        Block block = playerInteractEvent.getClickedBlock();
        if (block == null) {
            return;
        }
        LocationBridge_13 locationBridge_13 = PlayerInteractListener_7.aq(block);
        if (locationBridge_13 != null && locationBridge_13.Jz != null) {
            if (!locationBridge_13.Jz.e(playerInteractEvent.getPlayer())) {
                return;
            }
            BukkitTaskBridge.c(() -> locationBridge_13.a(ItemStackRegistry.d(block), block.getLocation(), playerInteractEvent.getPlayer()), 1L);
        }
        HashMap<Block, LocationBridge_13> hashMap = new HashMap<Block, LocationBridge_13>();
        PlayerInventory playerInventory = playerInteractEvent.getPlayer().getInventory();
        if (playerInventory.getItemInMainHand().getType() == Material.FLINT_AND_STEEL || playerInventory.getItemInOffHand().getType() == Material.FLINT_AND_STEEL) {
            if (locationBridge_13 != null && locationBridge_13.as(4)) {
                BukkitTaskBridge.c(() -> {
                    LocationBridge_3.a(block.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    LocationBridge_3.a(block.getLocation(), Sound.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    locationBridge_13.a(ItemStackRegistry.d(block), block.getLocation(), playerInteractEvent.getPlayer());
                }, 2L);
            }
            Block block2 = block.getRelative(playerInteractEvent.getBlockFace());
            for (BlockFace blockFace : EI) {
                Block block3 = block2.getRelative(blockFace);
                LocationBridge_13 locationBridge_132 = PlayerInteractListener_7.aq(block3);
                if (locationBridge_132 == null || !locationBridge_132.as(4)) continue;
                hashMap.put(block3, locationBridge_132);
            }
            if (!hashMap.isEmpty()) {
                BukkitTaskBridge.c(() -> {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        ((LocationBridge_13)entry.getValue()).a(ItemStackRegistry.d((Block)entry.getKey()), ((Block)entry.getKey()).getLocation(), playerInteractEvent.getPlayer());
                    }
                }, 40L);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(ProjectileHitEvent projectileHitEvent) {
        Block block = projectileHitEvent.getHitBlock();
        if (block == null) {
            return;
        }
        if (projectileHitEvent.getEntity().getFireTicks() <= 0) {
            return;
        }
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.d(block);
        if (locationBridgeBuilder_2 == null) {
            return;
        }
        LocationBridge_13 locationBridge_13 = locationBridgeBuilder_2.mK();
        if (locationBridge_13 == null) {
            return;
        }
        if (!locationBridge_13.as(1)) {
            return;
        }
        if (locationBridge_13.a(locationBridgeBuilder_2, block.getLocation())) {
            projectileHitEvent.setCancelled(true);
            projectileHitEvent.getEntity().teleport(projectileHitEvent.getEntity().getLocation().add(0.0, 0.1, 0.0));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(ExplosionPrimeEvent explosionPrimeEvent) {
        Object object = explosionPrimeEvent.getEntity();
        if (!(object instanceof TNTPrimed)) {
            return;
        }
        TNTPrimed tNTPrimed = (TNTPrimed)object;
        if (tNTPrimed.getPersistentDataContainer().has(LocationBridge_13.Jt)) {
            object = PlayerInteractListener_7.b(tNTPrimed);
            if (object == null) {
                return;
            }
            explosionPrimeEvent.setFire(object.JD);
            explosionPrimeEvent.setRadius((float)object.JA);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(BlockRedstoneEvent blockRedstoneEvent) {
        if (!LocationBridge_13.Jy) {
            return;
        }
        if (blockRedstoneEvent.getNewCurrent() <= 0) {
            return;
        }
        for (BlockFace blockFace : EI) {
            Block block = blockRedstoneEvent.getBlock().getRelative(blockFace);
            LocationBridge_13 locationBridge_13 = PlayerInteractListener_7.aq(block);
            if (locationBridge_13 == null || !locationBridge_13.as(2)) continue;
            locationBridge_13.a(ItemStackRegistry.d(block), block.getLocation());
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void i(BlockPlaceEvent blockPlaceEvent) {
        if (!LocationBridge_13.Jy) {
            return;
        }
        if (blockPlaceEvent.getBlockPlaced().getType() == Material.REDSTONE_BLOCK) {
            for (BlockFace blockFace : EI) {
                Block block = blockPlaceEvent.getBlockPlaced().getRelative(blockFace);
                LocationBridge_13 locationBridge_13 = PlayerInteractListener_7.aq(block);
                if (locationBridge_13 == null || !locationBridge_13.as(2)) continue;
                locationBridge_13.a(ItemStackRegistry.d(block), block.getLocation());
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void c(CustomBlockPlaceEvent customBlockPlaceEvent) {
        if (!LocationBridge_13.Jy) {
            return;
        }
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = customBlockPlaceEvent.internal;
        if (locationBridgeBuilder_2.mK() == null) {
            return;
        }
        LocationBridge_13 locationBridge_13 = locationBridgeBuilder_2.mK();
        boolean bl = locationBridge_13.as(2);
        boolean bl2 = locationBridge_13.as(4);
        if (!bl && !bl2) {
            return;
        }
        Block block = customBlockPlaceEvent.getBlock();
        for (BlockFace blockFace : EI) {
            Block block2 = block.getRelative(blockFace);
            Material material = block2.getType();
            if (!(bl && material == Material.REDSTONE_BLOCK || bl2 && material == Material.FIRE) && !block2.isBlockPowered()) continue;
            BukkitTaskBridge.c(() -> locationBridge_13.a(locationBridgeBuilder_2, block.getLocation(), customBlockPlaceEvent.getPlayer()), 40L);
            return;
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(BlockPistonExtendEvent blockPistonExtendEvent) {
        if (!LocationBridge_13.Jy) {
            return;
        }
        for (Block block : blockPistonExtendEvent.getBlocks()) {
            if (block.getType() != Material.REDSTONE) {
                return;
            }
            for (BlockFace blockFace : EI) {
                Block block2 = block.getRelative(blockFace);
                LocationBridge_13 locationBridge_13 = PlayerInteractListener_7.aq(block2);
                if (locationBridge_13 == null || !locationBridge_13.as(2)) continue;
                locationBridge_13.a(ItemStackRegistry.d(block2), block2.getLocation());
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void c(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (entityDamageByEntityEvent.getCause() != EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
            return;
        }
        Object object = entityDamageByEntityEvent.getDamager();
        if (!(object instanceof TNTPrimed)) {
            return;
        }
        TNTPrimed tNTPrimed = (TNTPrimed)object;
        object = PlayerInteractListener_7.b(tNTPrimed);
        if (object == null) {
            return;
        }
        if (object.JB != 1.0) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() * object.JB);
        }
    }
}
