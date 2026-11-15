package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockDataNoteBlockHolder;
import itemsadder.m.BlockDestroyListener_2;
import itemsadder.m.BlockHolder_2;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.PluginContract;
import itemsadder.m.VersionHelper;
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

public final class PlayerInteractListener_4
implements PluginContract {
    WeakHashMap Bv = new WeakHashMap();

    public void register(Plugin plugin) {
        ListenerBridge.a(this, plugin);
        if (VersionHelper.Va) {
            try {
                ListenerBridge.a(new BlockDestroyListener_2(), plugin);
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.warn("Failed to register Paper event listener for tripwires.", throwable);
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
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            if (blockBridge_9.isCustomBlock(block)) {
                LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
                if (locationBridgeBuilder_2 == null) {
                    return;
                }
                Material material2 = block.getType();
                if (material == Material.NOTE_BLOCK) {
                    BukkitTaskBridge.c(() -> {
                        if (block.getType() != material2 || !locationBridgeBuilder_2.getNamespacedID().equals(blockBridge_9.Y(block))) {
                            return;
                        }
                        locationBridgeBuilder_2.e(block, false);
                    }, 5L);
                } else {
                    locationBridgeBuilder_2.e(block, false);
                }
            } else {
                Tripwire tripwire = (Tripwire)block.getBlockData();
                if (tripwire.isAttached() || material == Material.TRIPWIRE_HOOK) {
                    BlockHolder_2.tN().d(block, Material.AIR);
                    BukkitTaskBridge.c(() -> {
                        for (Player player : LocationBridge_2.a(block.getLocation(), 10)) {
                            if (!this.Bv.containsKey(player) || this.Bv.containsKey(player) && System.currentTimeMillis() - (Long)this.Bv.get(player) > 1000L) {
                                CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("tripwires-disabled"));
                            }
                            this.Bv.put(player, System.currentTimeMillis());
                        }
                    }, 2L);
                } else {
                    BlockHolder_2.tN().d(block, Material.TRIPWIRE);
                    BukkitTaskBridge.c(() -> {
                        for (Player player : LocationBridge_2.a(block.getLocation(), 32)) {
                            player.sendBlockChange(block.getLocation(), BlockDataNoteBlockHolder.AG);
                        }
                    }, 2L);
                }
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void g(BlockPlaceEvent blockPlaceEvent) {
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        Block block = blockPlaceEvent.getBlock();
        if (block.getType() == Material.TRIPWIRE) {
            blockPlaceEvent.setCancelled(true);
            ItemStackBridge_2.aj(blockPlaceEvent.getItemInHand());
            BukkitTaskBridge.c(() -> block.setBlockData(BlockDataNoteBlockHolder.AG, false), 2L);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void a(PlayerBucketEmptyEvent playerBucketEmptyEvent) {
        Block block = playerBucketEmptyEvent.getBlock();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (blockBridge_9.isCustomBlock(block)) {
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
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            if (blockBridge_9.isCustomBlock(block)) {
                blockDropItemEvent.getItems().clear();
                blockDropItemEvent.setCancelled(true);
            }
        }
    }
}
