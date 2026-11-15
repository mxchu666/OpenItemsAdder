package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.aaa;
import itemsadder.m.ahd;
import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.ls;
import itemsadder.m.mi;
import itemsadder.m.ms;
import itemsadder.m.ql;
import java.util.WeakHashMap;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Tripwire;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public final class mh
implements ai {
    WeakHashMap Bv = new WeakHashMap();

    public void register(Plugin plugin) {
        bev.a(this, plugin);
        if (aaa.Va) {
            try {
                bev.a(new mi(), plugin);
            }
            catch (Throwable throwable) {
                bce.warn("Failed to register Paper event listener for tripwires.", throwable);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void i(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() == Action.PHYSICAL) {
            if (playerInteractEvent.getClickedBlock().getType() != Material.TRIPWIRE) {
                return;
            }
            playerInteractEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void d(BlockPhysicsEvent blockPhysicsEvent) {
        Block block = blockPhysicsEvent.getBlock();
        if (block.getType() == Material.TRIPWIRE) {
            Material material = blockPhysicsEvent.getSourceBlock().getType();
            blockPhysicsEvent.setCancelled(true);
            ms ms2 = d.g().b(block);
            if (ms2.isCustomBlock(block)) {
                ql ql2 = d.g().h(ms2.Y(block));
                if (ql2 == null) {
                    return;
                }
                Material material2 = block.getType();
                if (material == Material.NOTE_BLOCK) {
                    bcp.c(() -> {
                        if (block.getType() != material2 || !ql2.getNamespacedID().equals(ms2.Y(block))) {
                            return;
                        }
                        ql2.e(block, false);
                    }, 5L);
                } else {
                    ql2.e(block, false);
                }
            } else {
                Tripwire tripwire = (Tripwire)block.getBlockData();
                if (tripwire.isAttached() || material == Material.TRIPWIRE_HOOK) {
                    ahd.tN().d(block, Material.AIR);
                    bcp.c(() -> {
                        for (Player player : bcc.a(block.getLocation(), 10)) {
                            if (!this.Bv.containsKey(player) || this.Bv.containsKey(player) && System.currentTimeMillis() - (Long)this.Bv.get(player) > 1000L) {
                                bce.f((CommandSender)player, Main.PQ.ir("tripwires-disabled"));
                            }
                            this.Bv.put(player, System.currentTimeMillis());
                        }
                    }, 2L);
                } else {
                    ahd.tN().d(block, Material.TRIPWIRE);
                    bcp.c(() -> {
                        for (Player player : bcc.a(block.getLocation(), 32)) {
                            player.sendBlockChange(block.getLocation(), ls.AG);
                        }
                    }, 2L);
                }
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void g(BlockPlaceEvent blockPlaceEvent) {
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        Block block = blockPlaceEvent.getBlock();
        if (block.getType() == Material.TRIPWIRE) {
            blockPlaceEvent.setCancelled(true);
            bbs.aj(blockPlaceEvent.getItemInHand());
            bcp.c(() -> block.setBlockData(ls.AG, false), 2L);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void a(PlayerBucketEmptyEvent playerBucketEmptyEvent) {
        Block block = playerBucketEmptyEvent.getBlock();
        ms ms2 = d.g().b(block);
        if (ms2.isCustomBlock(block)) {
            playerBucketEmptyEvent.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void b(BlockFromToEvent blockFromToEvent) {
        if (blockFromToEvent.getToBlock().getType() == Material.TRIPWIRE) {
            blockFromToEvent.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void a(BlockDropItemEvent blockDropItemEvent) {
        if (blockDropItemEvent.getItems().size() > 0 && blockDropItemEvent.getBlockState().getType() == Material.TRIPWIRE) {
            Block block = blockDropItemEvent.getBlock();
            ms ms2 = d.g().b(block);
            if (ms2.isCustomBlock(block)) {
                blockDropItemEvent.getItems().clear();
                blockDropItemEvent.setCancelled(true);
            }
        }
    }
}
