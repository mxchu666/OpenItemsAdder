package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomBlockPlaceEvent;
import itemsadder.m.ai;
import itemsadder.m.bcp;
import itemsadder.m.bcv;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.se;
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

public class pu
implements ai {
    public static final BlockFace[] EI = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN};

    public pu() {
        bev.a(this, (Plugin)Main.rS());
    }

    static ql a(TNTPrimed tNTPrimed) {
        if (!tNTPrimed.getPersistentDataContainer().has(se.Jt)) {
            return null;
        }
        String string = (String)tNTPrimed.getPersistentDataContainer().get(se.Jt, PersistentDataType.STRING);
        return d.g().h(string);
    }

    static se b(TNTPrimed tNTPrimed) {
        ql ql2 = pu.a(tNTPrimed);
        if (ql2 == null) {
            return null;
        }
        return ql2.mK();
    }

    static se aq(Block block) {
        ql ql2 = d.d(block);
        if (ql2 == null) {
            return null;
        }
        return ql2.mK();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerInteractEvent playerInteractEvent) {
        Block block = playerInteractEvent.getClickedBlock();
        if (block == null) {
            return;
        }
        se se2 = pu.aq(block);
        if (se2 != null && se2.Jz != null) {
            if (!se2.Jz.e(playerInteractEvent.getPlayer())) {
                return;
            }
            bcp.c(() -> se2.a(d.d(block), block.getLocation(), playerInteractEvent.getPlayer()), 1L);
        }
        HashMap<Block, se> hashMap = new HashMap<Block, se>();
        PlayerInventory playerInventory = playerInteractEvent.getPlayer().getInventory();
        if (playerInventory.getItemInMainHand().getType() == Material.FLINT_AND_STEEL || playerInventory.getItemInOffHand().getType() == Material.FLINT_AND_STEEL) {
            if (se2 != null && se2.as(4)) {
                bcp.c(() -> {
                    bcv.a(block.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    bcv.a(block.getLocation(), Sound.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    se2.a(d.d(block), block.getLocation(), playerInteractEvent.getPlayer());
                }, 2L);
            }
            Block block2 = block.getRelative(playerInteractEvent.getBlockFace());
            for (BlockFace blockFace : EI) {
                Block block3 = block2.getRelative(blockFace);
                se se3 = pu.aq(block3);
                if (se3 == null || !se3.as(4)) continue;
                hashMap.put(block3, se3);
            }
            if (!hashMap.isEmpty()) {
                bcp.c(() -> {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        ((se)entry.getValue()).a(d.d((Block)entry.getKey()), ((Block)entry.getKey()).getLocation(), playerInteractEvent.getPlayer());
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
        ql ql2 = d.d(block);
        if (ql2 == null) {
            return;
        }
        se se2 = ql2.mK();
        if (se2 == null) {
            return;
        }
        if (!se2.as(1)) {
            return;
        }
        if (se2.a(ql2, block.getLocation())) {
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
        if (tNTPrimed.getPersistentDataContainer().has(se.Jt)) {
            object = pu.b(tNTPrimed);
            if (object == null) {
                return;
            }
            explosionPrimeEvent.setFire(object.JD);
            explosionPrimeEvent.setRadius((float)object.JA);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(BlockRedstoneEvent blockRedstoneEvent) {
        if (!se.Jy) {
            return;
        }
        if (blockRedstoneEvent.getNewCurrent() <= 0) {
            return;
        }
        for (BlockFace blockFace : EI) {
            Block block = blockRedstoneEvent.getBlock().getRelative(blockFace);
            se se2 = pu.aq(block);
            if (se2 == null || !se2.as(2)) continue;
            se2.a(d.d(block), block.getLocation());
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void i(BlockPlaceEvent blockPlaceEvent) {
        if (!se.Jy) {
            return;
        }
        if (blockPlaceEvent.getBlockPlaced().getType() == Material.REDSTONE_BLOCK) {
            for (BlockFace blockFace : EI) {
                Block block = blockPlaceEvent.getBlockPlaced().getRelative(blockFace);
                se se2 = pu.aq(block);
                if (se2 == null || !se2.as(2)) continue;
                se2.a(d.d(block), block.getLocation());
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void c(CustomBlockPlaceEvent customBlockPlaceEvent) {
        if (!se.Jy) {
            return;
        }
        ql ql2 = customBlockPlaceEvent.internal;
        if (ql2.mK() == null) {
            return;
        }
        se se2 = ql2.mK();
        boolean bl = se2.as(2);
        boolean bl2 = se2.as(4);
        if (!bl && !bl2) {
            return;
        }
        Block block = customBlockPlaceEvent.getBlock();
        for (BlockFace blockFace : EI) {
            Block block2 = block.getRelative(blockFace);
            Material material = block2.getType();
            if (!(bl && material == Material.REDSTONE_BLOCK || bl2 && material == Material.FIRE) && !block2.isBlockPowered()) continue;
            bcp.c(() -> se2.a(ql2, block.getLocation(), customBlockPlaceEvent.getPlayer()), 40L);
            return;
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(BlockPistonExtendEvent blockPistonExtendEvent) {
        if (!se.Jy) {
            return;
        }
        for (Block block : blockPistonExtendEvent.getBlocks()) {
            if (block.getType() != Material.REDSTONE) {
                return;
            }
            for (BlockFace blockFace : EI) {
                Block block2 = block.getRelative(blockFace);
                se se2 = pu.aq(block2);
                if (se2 == null || !se2.as(2)) continue;
                se2.a(d.d(block2), block2.getLocation());
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
        object = pu.b(tNTPrimed);
        if (object == null) {
            return;
        }
        if (object.JB != 1.0) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() * object.JB);
        }
    }
}
