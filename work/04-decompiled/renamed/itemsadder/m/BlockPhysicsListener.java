package itemsadder.m;

import itemsadder.m.BlockBridge_12;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockRegistry;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.PluginContract;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Fire;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;

public final class BlockPhysicsListener
implements PluginContract {
    Random Bl = new Random();

    public void register(Plugin plugin) {
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(BlockPhysicsEvent blockPhysicsEvent) {
        if (blockPhysicsEvent.getBlock().getType() == Material.FIRE) {
            blockPhysicsEvent.setCancelled(true);
            if (!ItemStackRegistry.g().k()) {
                return;
            }
            Block block = blockPhysicsEvent.getBlock();
            Fire fire = (Fire)blockPhysicsEvent.getBlock().getBlockData();
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            Material material = block.getRelative(BlockFace.DOWN).getType();
            if (material != Material.NETHERRACK && material != Material.MAGMA_BLOCK && material != Material.LAVA) {
                int n;
                if (blockBridge_9.T(block)) {
                    Integer n2 = blockBridge_9.ae(block);
                    n = n2 == null ? 1 : n2;
                    n = Math.min(15, n + this.Bl.nextInt(3) / 2);
                    blockBridge_9.b(block, n);
                } else {
                    n = fire.getAge();
                    blockBridge_9.b(block, fire.getAge());
                }
                if (n >= 15 && this.Bl.nextInt(4) == 0 && !material.isFlammable()) {
                    blockBridge_9.c(block, true);
                    return;
                }
                boolean bl = false;
                for (BlockFace blockFace : LocationBridge_4.aBw) {
                    if (!block.getRelative(blockFace).getType().isFlammable()) continue;
                    bl = true;
                    break;
                }
                if (!(bl || n <= 3 && block.getRelative(BlockFace.DOWN).getType().isSolid())) {
                    blockBridge_9.a(block, true, true);
                    return;
                }
            }
            if (blockBridge_9.isCustomBlock(block)) {
                BlockBridge_12 blockBridge_12;
                try {
                    blockBridge_12 = (BlockBridge_12)ItemStackRegistry.g().e(blockBridge_9.Y(block));
                }
                catch (ClassCastException classCastException) {
                    return;
                }
                if (blockBridge_12 == null) {
                    return;
                }
                fire.setAge(blockBridge_12.Hl.kh);
                block.setBlockData((BlockData)fire);
            } else if (fire.getAge() > 0) {
                fire.setAge(0);
                block.setBlockData((BlockData)fire);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(BlockSpreadEvent blockSpreadEvent) {
        if (blockSpreadEvent.getNewState().getType() != Material.FIRE) {
            return;
        }
        Block block = blockSpreadEvent.getSource();
        Block block2 = blockSpreadEvent.getBlock();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (blockBridge_9.isCustomBlock(block)) {
            blockSpreadEvent.setCancelled(true);
            Fire fire = (Fire)blockSpreadEvent.getNewState().getBlockData();
            BlockBridge_9 blockBridge_92 = ItemStackRegistry.g().b(block2);
            blockBridge_92.b(block2, fire.getAge());
            BlockBridge_12 blockBridge_12 = (BlockBridge_12)ItemStackRegistry.g().e(blockBridge_9.Y(block));
            if (blockBridge_12 == null) {
                return;
            }
            fire.setAge(blockBridge_12.Hl.kh);
            blockBridge_92.e(block2, blockBridge_12.getNamespacedID());
            block2.setBlockData((BlockData)fire);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(BlockBurnEvent blockBurnEvent) {
        Block block = blockBurnEvent.getIgnitingBlock();
        if (block == null) {
            return;
        }
        Block block2 = blockBurnEvent.getBlock();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (blockBridge_9.isCustomBlock(block)) {
            blockBurnEvent.setCancelled(true);
            BlockBridge_12 blockBridge_12 = (BlockBridge_12)ItemStackRegistry.g().e(blockBridge_9.Y(block));
            if (blockBridge_12 == null) {
                return;
            }
            Fire fire = (Fire)block.getBlockData();
            int n = fire.getAge();
            if (this.Bl.nextInt(n + 10) < 5 && !BlockRegistry.aK(block2)) {
                block2.setType(Material.FIRE);
                if (block2.getBlockData() instanceof Fire) {
                    Fire fire2 = (Fire)block2.getBlockData();
                    BlockBridge_9 blockBridge_92 = ItemStackRegistry.g().b(block2);
                    blockBridge_92.b(block2, 0);
                    fire2.setAge(blockBridge_12.Hl.kh);
                    blockBridge_92.e(block2, blockBridge_12.getNamespacedID());
                    block2.setBlockData((BlockData)fire2);
                }
            } else if (block2.getType() != Material.TNT) {
                block2.setType(Material.AIR);
            } else {
                if (!LocationBridge_2.bq(block2)) {
                    return;
                }
                block2.setType(Material.AIR);
                block2.getWorld().spawn(block2.getLocation(), TNTPrimed.class);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(BlockFadeEvent blockFadeEvent) {
        if (blockFadeEvent.getBlock().getType() != Material.FIRE) {
            return;
        }
        ItemStackRegistry.g().b(blockFadeEvent.getBlock()).ag(blockFadeEvent.getBlock());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void g(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }
        if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        if (playerInteractEvent.getClickedBlock() == null || playerInteractEvent.getClickedBlock().getType() != Material.FIRE) {
            return;
        }
        if (LocationBridge_2.a(playerInteractEvent.getClickedBlock(), playerInteractEvent.getPlayer())) {
            ItemStackRegistry.g().b(playerInteractEvent.getClickedBlock()).ag(playerInteractEvent.getClickedBlock());
        }
    }
}
