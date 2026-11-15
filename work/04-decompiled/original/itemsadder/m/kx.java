package itemsadder.m;

import itemsadder.m.aaa;
import itemsadder.m.ai;
import itemsadder.m.bay;
import itemsadder.m.bce;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.ky;
import itemsadder.m.ms;
import itemsadder.m.rb;
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

public class kx
implements ai {
    final Plugin zG;
    final d zH;

    public kx(Plugin plugin, d d2) {
        this.zG = plugin;
        this.zH = d2;
        bev.a(this, plugin);
        if (aaa.Va) {
            try {
                bev.a(new ky(), plugin);
            }
            catch (Throwable throwable) {
                bce.warn("Failed to register Paper event listener for tripwires.", throwable);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(BlockPlaceEvent blockPlaceEvent) {
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        if (!this.zH.d(blockPlaceEvent.getItemInHand())) {
            return;
        }
        rb rb2 = (rb)this.zH.a(blockPlaceEvent.getItemInHand());
        rb2.aw(blockPlaceEvent.getBlockPlaced());
        ms ms2 = this.zH.b(blockPlaceEvent.getBlockPlaced());
        ms2.b(blockPlaceEvent.getBlockPlaced(), rb2.getNamespacedID());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (!this.a(block, blockBreakEvent)) {
            this.a(block.getRelative(BlockFace.UP), blockBreakEvent);
        }
    }

    private boolean a(Block block, BlockBreakEvent blockBreakEvent) {
        if (rb.ax(block)) {
            ms ms2 = this.zH.b(block);
            String string = ms2.aa(block);
            if (string == null) {
                return false;
            }
            blockBreakEvent.setDropItems(false);
            rb rb2 = (rb)this.zH.a(rb.class, string);
            if (rb2 != null) {
                if (blockBreakEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
                    if (bay.bn(block)) {
                        rb2.b(blockBreakEvent.getPlayer().getItemInHand(), block.getLocation());
                    } else {
                        ItemStack itemStack = rb2.mP();
                        bdf.b(block.getLocation(), itemStack.clone());
                    }
                }
            } else {
                bce.warn(blockBreakEvent.getPlayer().getName() + " mined unknown crop " + string + " " + bdf.ai(block.getLocation()));
            }
            ms2.ag(block);
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
        if (rb.ax(block)) {
            ItemStack itemStack;
            ms ms2 = this.zH.b(block);
            String string = ms2.aa(block);
            if (string == null) {
                return;
            }
            blockFromToEvent.setCancelled(true);
            rb rb2 = (rb)this.zH.a(rb.class, string);
            if (rb2 != null) {
                if (bay.bn(block)) {
                    rb2.N(block.getLocation());
                } else {
                    itemStack = rb2.mP();
                    itemStack.setAmount(1);
                    bdf.b(location, itemStack);
                }
            } else {
                bce.warn("Someone mined unknown crop " + string + " " + bdf.ai(block.getLocation()));
            }
            blockFromToEvent.getToBlock().setType(Material.WATER);
            itemStack = (Levelled)blockFromToEvent.getToBlock().getBlockData();
            itemStack.setLevel(1);
            blockFromToEvent.getToBlock().setBlockData((BlockData)itemStack);
            ms2.ag(block);
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
            if (rb.ax(block2)) {
                ms ms2 = this.zH.b(block2);
                String string = ms2.aa(block2);
                if (string == null) {
                    return;
                }
                playerInteractEvent.setCancelled(true);
                rb rb2 = (rb)this.zH.e(string);
                if (rb2 != null) {
                    if (!bay.bn(block2)) {
                        ItemStack itemStack = rb2.mP();
                        itemStack.setAmount(1);
                        bdf.b(block2.getLocation(), itemStack);
                    } else {
                        rb2.N(block2.getLocation());
                    }
                } else {
                    bce.warn("Someone mined unknown crop '" + string + "' " + bdf.ai(block2.getLocation()));
                }
                ms2.a(block2, true, true);
                block.setType(Material.DIRT);
            }
            return;
        }
        if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (block == null) {
                return;
            }
            if (block.getType() == Material.SWEET_BERRY_BUSH) {
                if (!bay.bn(block)) {
                    if (playerInteractEvent.getItem() == null || playerInteractEvent.getItem().getType() != Material.BONE_MEAL) {
                        if (d.e(block)) {
                            playerInteractEvent.setCancelled(true);
                        }
                        return;
                    }
                    return;
                }
                ms ms3 = this.zH.b(block);
                String string = ms3.aa(block);
                if (string == null) {
                    return;
                }
                playerInteractEvent.setCancelled(true);
                bay.setAge(block, 1);
                rb rb3 = (rb)this.zH.e(string);
                if (rb3 != null) {
                    rb3.N(block.getLocation());
                } else {
                    bce.warn(playerInteractEvent.getPlayer().getName() + " mined unknown crop " + string + " " + bdf.ai(block.getLocation()));
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
            if (!rb.ax(block)) continue;
            ms ms2 = this.zH.b(block);
            String string = ms2.aa(block);
            if (string == null) {
                return;
            }
            rb rb2 = (rb)this.zH.e(string);
            if (rb2 != null) {
                if (!bay.bn(block)) {
                    ItemStack itemStack = rb2.mP();
                    itemStack.setAmount(1);
                    bdf.b(block.getLocation(), itemStack);
                } else {
                    rb2.N(block.getLocation());
                }
            } else {
                bce.warn("A piston has broken an unknown crop '" + string + "' " + bdf.ai(block.getLocation()));
            }
            ms2.a(block, true, true);
        }
    }
}
