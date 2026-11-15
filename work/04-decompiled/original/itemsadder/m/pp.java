package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.Glow;
import itemsadder.m.aaf;
import itemsadder.m.ae;
import itemsadder.m.afz;
import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.mv;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.pq;
import itemsadder.m.qf;
import itemsadder.m.qg;
import itemsadder.m.qm;
import itemsadder.m.r;
import itemsadder.m.zj;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class pp
implements ai {
    public pq Ew = new pq();

    public pp(Plugin plugin, d d2) {
        bev.a(this, plugin);
        d2.ar.a(new my(EntityDamageByEntityEvent.class, this::b));
        d2.ar.a(new my(qg.class, this::c));
        d2.ar.a(new my(qf.class, this::c));
        d2.ar.a(new my(PlayerInteractEntityEvent.class, this::b));
        d2.ar.a(new my(PlayerInteractEvent.class, this::l));
        d2.ar.a(new my(BlockBreakEvent.class, this::b));
        d2.ar.a(new my(PlayerDropItemEvent.class, this::b));
        d2.ar.a(new my(zj.class, this::c));
        d2.ar.a(new my(PlayerPickupItemEvent.class, this::b));
        d2.ar.a(new my(PlayerBucketEmptyEvent.class, this::b));
        d2.ar.a(new my(PlayerBucketFillEvent.class, this::b));
        d2.ar.a(new my(PlayerItemBreakEvent.class, this::b));
    }

    public void mr() {
        if (mv.Cb) {
            this.Ew.register();
        }
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        this.Ew.unregister();
    }

    @mz
    private void b(EntityDamageByEntityEvent entityDamageByEntityEvent, qm qm2, ItemStack itemStack) {
        if (!(entityDamageByEntityEvent.getDamager() instanceof LivingEntity)) {
            return;
        }
        if (bev.Ek()) {
            return;
        }
        qm2.a((LivingEntity)entityDamageByEntityEvent.getDamager(), jj.ATTACK, ou2 -> ou2.a(entityDamageByEntityEvent, qm2, itemStack));
    }

    @mz
    private void c(qg qg2, qm qm2, ItemStack itemStack) {
        if (qg2.Fl) {
            jj.EQUIPPED_ARMOR_ITEM_PLAYER_DAMAGED_BY_ENTITY.a(qg2, qm2, itemStack);
        } else if (qg2.Fm == EquipmentSlot.HAND) {
            jj.HOLDING_ITEM_PLAYER_DAMAGED_BY_ENTITY.a(qg2, qm2, itemStack);
        } else if (qg2.Fm == EquipmentSlot.OFF_HAND) {
            jj.HOLDING_ITEM_OFFHAND_PLAYER_DAMAGED_BY_ENTITY.a(qg2, qm2, itemStack);
        }
    }

    @mz
    private void c(qf qf2, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)qf2.Fi, jj.KILL, ou2 -> ou2.b(qf2, qm2, itemStack));
    }

    @mz
    private void b(PlayerInteractEntityEvent playerInteractEntityEvent, qm qm2, ItemStack itemStack) {
        ItemFrame itemFrame;
        qm2.a((LivingEntity)playerInteractEntityEvent.getPlayer(), jj.INTERACT_ENTITY, ou2 -> ou2.a(playerInteractEntityEvent, qm2, itemStack));
        Entity entity = playerInteractEntityEvent.getRightClicked();
        EntityType entityType = entity.getType();
        if (afz.i(entityType) && (itemFrame = (ItemFrame)entity).getItem().getType().isAir()) {
            qm2.a((LivingEntity)playerInteractEntityEvent.getPlayer(), jj.ITEM_FRAME_PUT_ITEM, ou2 -> ou2.a(playerInteractEntityEvent, qm2, itemStack));
            qm2.a((LivingEntity)playerInteractEntityEvent.getPlayer(), jj.UNHELD, ou2 -> ou2.a(playerInteractEntityEvent, qm2, itemStack));
            qm2.a((LivingEntity)playerInteractEntityEvent.getPlayer(), jj.UNHELD_OFFHAND, ou2 -> ou2.a(playerInteractEntityEvent, qm2, itemStack));
        }
    }

    @mz
    private void l(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        Player player = playerInteractEvent.getPlayer();
        if (playerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (player.isSneaking()) {
                qm2.a(jj.INTERACT_LEFT_SHIFT, playerInteractEvent, itemStack);
                if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                    qm2.a(jj.INTERACT_MAINHAND_LEFT_SHIFT, playerInteractEvent, itemStack);
                } else {
                    qm2.a(jj.INTERACT_OFFHAND_LEFT_SHIFT, playerInteractEvent, itemStack);
                }
            } else {
                qm2.a(jj.INTERACT_LEFT, playerInteractEvent, itemStack);
                if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                    qm2.a(jj.INTERACT_MAINHAND_LEFT, playerInteractEvent, itemStack);
                } else {
                    qm2.a(jj.INTERACT_OFFHAND_LEFT, playerInteractEvent, itemStack);
                }
            }
        } else if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (playerInteractEvent.getClickedBlock() != null && playerInteractEvent.getClickedBlock().getType() != Material.AIR && aaf.aO(playerInteractEvent.getClickedBlock()) && playerInteractEvent.getClickedBlock().getType() != Material.NOTE_BLOCK) {
                return;
            }
            if (player.isSneaking()) {
                qm2.a(jj.INTERACT_RIGHT_SHIFT, playerInteractEvent, itemStack);
                if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                    qm2.a(jj.INTERACT_MAINHAND_RIGHT_SHIFT, playerInteractEvent, itemStack);
                } else {
                    qm2.a(jj.INTERACT_OFFHAND_RIGHT_SHIFT, playerInteractEvent, itemStack);
                }
            } else {
                qm2.a(jj.INTERACT_RIGHT, playerInteractEvent, itemStack);
                if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                    qm2.a(jj.INTERACT_MAINHAND_RIGHT, playerInteractEvent, itemStack);
                } else {
                    qm2.a(jj.INTERACT_OFFHAND_RIGHT, playerInteractEvent, itemStack);
                }
            }
        }
    }

    @mz
    private void b(BlockBreakEvent blockBreakEvent, qm qm2, ItemStack itemStack) {
        if (qm.G(itemStack)) {
            blockBreakEvent.setCancelled(true);
            return;
        }
        qm2.a((LivingEntity)blockBreakEvent.getPlayer(), jj.BLOCK_BREAK, ou2 -> ou2.a(blockBreakEvent, qm2, itemStack));
    }

    @mz
    private void b(PlayerDropItemEvent playerDropItemEvent, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)playerDropItemEvent.getPlayer(), jj.DROP, ou2 -> ou2.a(playerDropItemEvent, qm2, itemStack));
        playerDropItemEvent.getItemDrop().setItemStack(itemStack);
        if (qm2.nt()) {
            playerDropItemEvent.getItemDrop().setCustomNameVisible(true);
            playerDropItemEvent.getItemDrop().setCustomName(itemStack.getItemMeta().getDisplayName());
        }
        if (qm2.mX() != null) {
            Glow.set((Entity)playerDropItemEvent.getItemDrop(), qm2.mX());
        }
    }

    @mz
    private void c(zj zj2, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)zj2.getPlayer(), jj.UNHELD, ou2 -> ou2.b(zj2, qm2, itemStack));
    }

    @mz
    private void b(PlayerPickupItemEvent playerPickupItemEvent, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)playerPickupItemEvent.getPlayer(), jj.PICKUP, ou2 -> ou2.a(playerPickupItemEvent, qm2, itemStack));
        if (bbs.c(playerPickupItemEvent)) {
            qm2.a((LivingEntity)playerPickupItemEvent.getPlayer(), jj.HELD, ou2 -> ou2.a(playerPickupItemEvent, qm2, itemStack));
        }
        playerPickupItemEvent.getItem().setItemStack(itemStack);
    }

    @mz
    private void b(PlayerBucketEmptyEvent playerBucketEmptyEvent, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)playerBucketEmptyEvent.getPlayer(), jj.BUCKET_EMPTY, ou2 -> ou2.a(playerBucketEmptyEvent, qm2, itemStack));
    }

    @mz
    private void b(PlayerBucketFillEvent playerBucketFillEvent, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)playerBucketFillEvent.getPlayer(), jj.BUCKET_FILL, ou2 -> ou2.a(playerBucketFillEvent, qm2, itemStack));
    }

    @mz
    private void b(PlayerItemBreakEvent playerItemBreakEvent, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)playerItemBreakEvent.getPlayer(), jj.UNHELD, ou2 -> ou2.a(playerItemBreakEvent, qm2, itemStack));
        qm2.a((LivingEntity)playerItemBreakEvent.getPlayer(), jj.ITEM_BREAK, ou2 -> ou2.a(playerItemBreakEvent, qm2, itemStack));
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(PlayerItemDamageEvent playerItemDamageEvent) {
        ItemStack itemStack = playerItemDamageEvent.getItem();
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return;
        }
        if (!qm2.nl() && bbs.al(itemStack) - playerItemDamageEvent.getDamage() <= 0) {
            playerItemDamageEvent.setCancelled(true);
            bbs.d(itemStack, 0);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getAction() == InventoryAction.NOTHING) {
            return;
        }
        if (inventoryClickEvent.getClick() == ClickType.LEFT || inventoryClickEvent.getClick() == ClickType.RIGHT) {
            if (inventoryClickEvent.getSlotType() == InventoryType.SlotType.QUICKBAR || inventoryClickEvent.getSlotType() == InventoryType.SlotType.ARMOR || inventoryClickEvent.getSlot() == 40) {
                Player player = (Player)inventoryClickEvent.getWhoClicked();
                ItemStack itemStack = inventoryClickEvent.getCursor();
                @Nullable qm qm2 = d.g().a(itemStack);
                ItemStack itemStack2 = inventoryClickEvent.getCurrentItem();
                qm qm3 = d.g().a(itemStack2);
                if (qm2 != null) {
                    qm2.a((LivingEntity)player, jj.WEAR, ou2 -> ou2.e(inventoryClickEvent, qm2, itemStack));
                    if (inventoryClickEvent.getSlotType() == InventoryType.SlotType.QUICKBAR && inventoryClickEvent.getSlot() == player.getInventory().getHeldItemSlot()) {
                        qm2.a((LivingEntity)player, jj.HELD, ou2 -> ou2.e(inventoryClickEvent, qm2, itemStack));
                    } else if (inventoryClickEvent.getSlot() == 40) {
                        qm2.a((LivingEntity)player, jj.HELD_OFFHAND, ou2 -> ou2.e(inventoryClickEvent, qm2, itemStack));
                    }
                }
                if (qm3 != null) {
                    qm3.a((LivingEntity)player, jj.UNWEAR, ou2 -> ou2.e(inventoryClickEvent, qm3, itemStack2));
                    if (inventoryClickEvent.getSlotType() == InventoryType.SlotType.QUICKBAR && inventoryClickEvent.getSlot() == player.getInventory().getHeldItemSlot()) {
                        qm3.a((LivingEntity)player, jj.UNHELD, ou2 -> ou2.e(inventoryClickEvent, qm3, itemStack));
                    } else if (inventoryClickEvent.getSlot() == 40) {
                        qm3.a((LivingEntity)player, jj.UNHELD_OFFHAND, ou2 -> ou2.e(inventoryClickEvent, qm3, itemStack));
                    }
                }
            }
            if (ae.fK) {
                r.a(inventoryClickEvent);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent) {
        ItemStack itemStack = playerSwapHandItemsEvent.getMainHandItem();
        ItemStack itemStack2 = playerSwapHandItemsEvent.getOffHandItem();
        qm qm2 = d.g().a(itemStack);
        qm qm3 = d.g().a(itemStack2);
        if (qm2 != null) {
            qm2.a((LivingEntity)playerSwapHandItemsEvent.getPlayer(), jj.UNHELD_OFFHAND, ou2 -> ou2.a(playerSwapHandItemsEvent, qm2, itemStack));
            qm2.a((LivingEntity)playerSwapHandItemsEvent.getPlayer(), jj.HELD, ou2 -> ou2.a(playerSwapHandItemsEvent, qm2, itemStack));
        }
        if (qm3 != null) {
            qm3.a((LivingEntity)playerSwapHandItemsEvent.getPlayer(), jj.UNHELD, ou2 -> ou2.a(playerSwapHandItemsEvent, qm3, itemStack2));
            qm3.a((LivingEntity)playerSwapHandItemsEvent.getPlayer(), jj.HELD_OFFHAND, ou2 -> ou2.a(playerSwapHandItemsEvent, qm3, itemStack2));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerItemHeldEvent playerItemHeldEvent) {
        ItemStack itemStack = playerItemHeldEvent.getPlayer().getInventory().getItem(playerItemHeldEvent.getPreviousSlot());
        ItemStack itemStack2 = playerItemHeldEvent.getPlayer().getInventory().getItem(playerItemHeldEvent.getNewSlot());
        qm qm2 = d.g().a(itemStack);
        qm qm3 = d.g().a(itemStack2);
        if (qm2 != null) {
            jj.UNHELD.a(playerItemHeldEvent, qm2, itemStack, playerItemHeldEvent.getPlayer());
        }
        if (qm3 != null) {
            jj.HELD.a(playerItemHeldEvent, qm3, itemStack2, playerItemHeldEvent.getPlayer());
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void g(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        ItemFrame itemFrame;
        ItemStack itemStack;
        Entity entity = entityDamageByEntityEvent.getEntity();
        if (!(entityDamageByEntityEvent.getDamager() instanceof LivingEntity)) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager().getType() != EntityType.PLAYER) {
            return;
        }
        if (qm.G(((Player)entityDamageByEntityEvent.getDamager()).getInventory().getItemInMainHand())) {
            entityDamageByEntityEvent.setCancelled(true);
            return;
        }
        if (afz.i(entity.getType()) && qm.isCustomItem(itemStack = (itemFrame = (ItemFrame)entity).getItem())) {
            qm qm2 = d.g().a(itemStack);
            if (qm2 == null) {
                return;
            }
            qm2.a((LivingEntity)entityDamageByEntityEvent.getDamager(), jj.ITEM_FRAME_REMOVE_ITEM, ou2 -> ou2.a(entityDamageByEntityEvent, qm2, itemStack));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(PlayerArmorStandManipulateEvent playerArmorStandManipulateEvent) {
        this.a(playerArmorStandManipulateEvent, playerArmorStandManipulateEvent.getPlayerItem(), jj.ARMOR_STAND_PUT_ITEM, true);
        this.a(playerArmorStandManipulateEvent, playerArmorStandManipulateEvent.getArmorStandItem(), jj.ARMOR_STAND_REMOVE_ITEM, false);
    }

    private void a(PlayerArmorStandManipulateEvent playerArmorStandManipulateEvent, ItemStack itemStack, jj jj2, boolean bl) {
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return;
        }
        qm2.a((LivingEntity)playerArmorStandManipulateEvent.getPlayer(), jj2, ou2 -> ou2.a((PlayerInteractEntityEvent)playerArmorStandManipulateEvent, qm2, itemStack));
        if (mv.Cb) {
            if (bl) {
                qm2.a((LivingEntity)playerArmorStandManipulateEvent.getPlayer(), jj.UNHELD, ou2 -> ou2.a((PlayerInteractEntityEvent)playerArmorStandManipulateEvent, qm2, itemStack));
                qm2.a((LivingEntity)playerArmorStandManipulateEvent.getPlayer(), jj.UNHELD_OFFHAND, ou2 -> ou2.a((PlayerInteractEntityEvent)playerArmorStandManipulateEvent, qm2, itemStack));
            } else {
                qm2.a((LivingEntity)playerArmorStandManipulateEvent.getPlayer(), jj.HELD, ou2 -> ou2.a((PlayerInteractEntityEvent)playerArmorStandManipulateEvent, qm2, itemStack));
            }
        }
    }
}
