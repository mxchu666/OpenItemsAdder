package itemsadder.m;

import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockDestroyListener;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.MaterialBridge_9;
import itemsadder.m.PluginContract;
import itemsadder.m.VersionHelper;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class BlockPlaceListener
implements PluginContract {
    final Plugin zG;
    final ItemStackRegistry zH;

    public BlockPlaceListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.zG = plugin;
        this.zH = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        if (VersionHelper.Va) {
            try {
                ListenerBridge.a(new BlockDestroyListener(), plugin);
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.warn("Failed to register Paper event listener for tripwires.", throwable);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(BlockPlaceEvent blockPlaceEvent) {
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        if (!this.zH.d(blockPlaceEvent.getItemInHand())) {
            return;
        }
        MaterialBridge_9 materialBridge_9 = (MaterialBridge_9)this.zH.a(blockPlaceEvent.getItemInHand());
        materialBridge_9.aw(blockPlaceEvent.getBlockPlaced());
        BlockBridge_9 blockBridge_9 = this.zH.b(blockPlaceEvent.getBlockPlaced());
        blockBridge_9.b(blockPlaceEvent.getBlockPlaced(), materialBridge_9.getNamespacedID());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (!this.a(block, blockBreakEvent)) {
            this.a(block.getRelative(BlockFace.UP), blockBreakEvent);
        }
    }

    private boolean a(Block block, BlockBreakEvent blockBreakEvent) {
        if (MaterialBridge_9.ax(block)) {
            BlockBridge_9 blockBridge_9 = this.zH.b(block);
            String string = blockBridge_9.aa(block);
            if (string == null) {
                return false;
            }
            blockBreakEvent.setDropItems(false);
            MaterialBridge_9 materialBridge_9 = (MaterialBridge_9)this.zH.a(MaterialBridge_9.class, string);
            if (materialBridge_9 != null) {
                if (blockBreakEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
                    if (BlockBridge_2.bn(block)) {
                        materialBridge_9.b(blockBreakEvent.getPlayer().getItemInHand(), block.getLocation());
                    } else {
                        ItemStack itemStack = materialBridge_9.mP();
                        LocationBridge_4.b(block.getLocation(), itemStack.clone());
                    }
                }
            } else {
                CommandSenderBridge_5.warn(blockBreakEvent.getPlayer().getName() + " mined unknown crop " + string + " " + LocationBridge_4.ai(block.getLocation()));
            }
            blockBridge_9.ag(block);
            return true;
        }
        return false;
    }

    @EventHandler(ignoreCancelled=true)
    private void b(BlockFromToEvent blockFromToEvent) {
        if (blockFromToEvent.getBlock().getType() != Material.WATER) {
            return;
        }
        Location location = blockFromToEvent.getToBlock().getLocation();
        Block block = blockFromToEvent.getToBlock();
        if (MaterialBridge_9.ax(block)) {
            ItemStack itemStack;
            BlockBridge_9 blockBridge_9 = this.zH.b(block);
            String string = blockBridge_9.aa(block);
            if (string == null) {
                return;
            }
            blockFromToEvent.setCancelled(true);
            MaterialBridge_9 materialBridge_9 = (MaterialBridge_9)this.zH.a(MaterialBridge_9.class, string);
            if (materialBridge_9 != null) {
                if (BlockBridge_2.bn(block)) {
                    materialBridge_9.N(block.getLocation());
                } else {
                    itemStack = materialBridge_9.mP();
                    itemStack.setAmount(1);
                    LocationBridge_4.b(location, itemStack);
                }
            } else {
                CommandSenderBridge_5.warn("Someone mined unknown crop " + string + " " + LocationBridge_4.ai(block.getLocation()));
            }
            blockFromToEvent.getToBlock().setType(Material.WATER);
            itemStack = (Levelled)blockFromToEvent.getToBlock().getBlockData();
            itemStack.setLevel(1);
            blockFromToEvent.getToBlock().setBlockData((BlockData)itemStack);
            blockBridge_9.ag(block);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void a(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.useInteractedBlock() == Event.Result.DENY) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock();
        if (playerInteractEvent.getAction() == Action.PHYSICAL && block != null && block.getType() == Material.FARMLAND) {
            Block block2 = block.getRelative(BlockFace.UP);
            if (MaterialBridge_9.ax(block2)) {
                BlockBridge_9 blockBridge_9 = this.zH.b(block2);
                String string = blockBridge_9.aa(block2);
                if (string == null) {
                    return;
                }
                playerInteractEvent.setCancelled(true);
                MaterialBridge_9 materialBridge_9 = (MaterialBridge_9)this.zH.e(string);
                if (materialBridge_9 != null) {
                    if (!BlockBridge_2.bn(block2)) {
                        ItemStack itemStack = materialBridge_9.mP();
                        itemStack.setAmount(1);
                        LocationBridge_4.b(block2.getLocation(), itemStack);
                    } else {
                        materialBridge_9.N(block2.getLocation());
                    }
                } else {
                    CommandSenderBridge_5.warn("Someone mined unknown crop '" + string + "' " + LocationBridge_4.ai(block2.getLocation()));
                }
                blockBridge_9.a(block2, true, true);
                block.setType(Material.DIRT);
            }
            return;
        }
        if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (block == null) {
                return;
            }
            if (block.getType() == Material.SWEET_BERRY_BUSH) {
                if (!BlockBridge_2.bn(block)) {
                    if (playerInteractEvent.getItem() == null || playerInteractEvent.getItem().getType() != Material.BONE_MEAL) {
                        if (ItemStackRegistry.e(block)) {
                            playerInteractEvent.setCancelled(true);
                        }
                        return;
                    }
                    return;
                }
                BlockBridge_9 blockBridge_9 = this.zH.b(block);
                String string = blockBridge_9.aa(block);
                if (string == null) {
                    return;
                }
                playerInteractEvent.setCancelled(true);
                BlockBridge_2.setAge(block, 1);
                MaterialBridge_9 materialBridge_9 = (MaterialBridge_9)this.zH.e(string);
                if (materialBridge_9 != null) {
                    materialBridge_9.N(block.getLocation());
                } else {
                    CommandSenderBridge_5.warn(playerInteractEvent.getPlayer().getName() + " mined unknown crop " + string + " " + LocationBridge_4.ai(block.getLocation()));
                }
            }
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void a(EntityDamageByBlockEvent entityDamageByBlockEvent) {
        if (entityDamageByBlockEvent.getCause() != EntityDamageEvent.DamageCause.CONTACT) {
            return;
        }
        if (entityDamageByBlockEvent.getDamager() == null) {
            return;
        }
        if (this.zH.b(entityDamageByBlockEvent.getDamager()).aa(entityDamageByBlockEvent.getDamager()) != null) {
            entityDamageByBlockEvent.setCancelled(true);
            entityDamageByBlockEvent.setDamage(0.0);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockPistonExtendEvent blockPistonExtendEvent) {
        for (Block block : blockPistonExtendEvent.getBlocks()) {
            if (!MaterialBridge_9.ax(block)) continue;
            BlockBridge_9 blockBridge_9 = this.zH.b(block);
            String string = blockBridge_9.aa(block);
            if (string == null) {
                return;
            }
            MaterialBridge_9 materialBridge_9 = (MaterialBridge_9)this.zH.e(string);
            if (materialBridge_9 != null) {
                if (!BlockBridge_2.bn(block)) {
                    ItemStack itemStack = materialBridge_9.mP();
                    itemStack.setAmount(1);
                    LocationBridge_4.b(block.getLocation(), itemStack);
                } else {
                    materialBridge_9.N(block.getLocation());
                }
            } else {
                CommandSenderBridge_5.warn("A piston has broken an unknown crop '" + string + "' " + LocationBridge_4.ai(block.getLocation()));
            }
            blockBridge_9.a(block, true, true);
        }
    }
}
