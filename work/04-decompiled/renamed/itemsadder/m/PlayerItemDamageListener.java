package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.Glow;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BlockRegistry;
import itemsadder.m.ClassRefData;
import itemsadder.m.ConfigurationSectionBridge_2;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackPlayerHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PlayerEntityHolder_2;
import itemsadder.m.PlayerJoinListener_6;
import itemsadder.m.PlayerJoinListener_7;
import itemsadder.m.PlayerLivingEntityHolder;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
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

public class PlayerItemDamageListener
implements PluginContract {
    public PlayerJoinListener_6 Ew = new PlayerJoinListener_6();

    public PlayerItemDamageListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(EntityDamageByEntityEvent.class, this::b));
        itemStackRegistry.ar.a(new ClassRefData(PlayerEntityHolder_2.class, this::c));
        itemStackRegistry.ar.a(new ClassRefData(PlayerLivingEntityHolder.class, this::c));
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEntityEvent.class, this::b));
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEvent.class, this::l));
        itemStackRegistry.ar.a(new ClassRefData(BlockBreakEvent.class, this::b));
        itemStackRegistry.ar.a(new ClassRefData(PlayerDropItemEvent.class, this::b));
        itemStackRegistry.ar.a(new ClassRefData(ItemStackPlayerHolder.class, this::c));
        itemStackRegistry.ar.a(new ClassRefData(PlayerPickupItemEvent.class, this::b));
        itemStackRegistry.ar.a(new ClassRefData(PlayerBucketEmptyEvent.class, this::b));
        itemStackRegistry.ar.a(new ClassRefData(PlayerBucketFillEvent.class, this::b));
        itemStackRegistry.ar.a(new ClassRefData(PlayerItemBreakEvent.class, this::b));
    }

    public void mr() {
        if (ConfigurationSectionBridge_2.Cb) {
            this.Ew.register();
        }
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        this.Ew.unregister();
    }

    @PluginContract_19
    private void b(EntityDamageByEntityEvent entityDamageByEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (!(entityDamageByEntityEvent.getDamager() instanceof LivingEntity)) {
            return;
        }
        if (ListenerBridge.Ek()) {
            return;
        }
        itemStackBuilder_4.a((LivingEntity)entityDamageByEntityEvent.getDamager(), BlockBreakEnum.ATTACK, builder_14 -> builder_14.a(entityDamageByEntityEvent, itemStackBuilder_4, itemStack));
    }

    @PluginContract_19
    private void c(PlayerEntityHolder_2 playerEntityHolder_2, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (playerEntityHolder_2.Fl) {
            BlockBreakEnum.EQUIPPED_ARMOR_ITEM_PLAYER_DAMAGED_BY_ENTITY.a(playerEntityHolder_2, itemStackBuilder_4, itemStack);
        } else if (playerEntityHolder_2.Fm == EquipmentSlot.HAND) {
            BlockBreakEnum.HOLDING_ITEM_PLAYER_DAMAGED_BY_ENTITY.a(playerEntityHolder_2, itemStackBuilder_4, itemStack);
        } else if (playerEntityHolder_2.Fm == EquipmentSlot.OFF_HAND) {
            BlockBreakEnum.HOLDING_ITEM_OFFHAND_PLAYER_DAMAGED_BY_ENTITY.a(playerEntityHolder_2, itemStackBuilder_4, itemStack);
        }
    }

    @PluginContract_19
    private void c(PlayerLivingEntityHolder playerLivingEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)playerLivingEntityHolder.Fi, BlockBreakEnum.KILL, builder_14 -> builder_14.b(playerLivingEntityHolder, itemStackBuilder_4, itemStack));
    }

    @PluginContract_19
    private void b(PlayerInteractEntityEvent playerInteractEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        ItemFrame itemFrame;
        itemStackBuilder_4.a((LivingEntity)playerInteractEntityEvent.getPlayer(), BlockBreakEnum.INTERACT_ENTITY, builder_14 -> builder_14.a(playerInteractEntityEvent, itemStackBuilder_4, itemStack));
        Entity entity = playerInteractEntityEvent.getRightClicked();
        EntityType entityType = entity.getType();
        if (EntityHolder.i(entityType) && (itemFrame = (ItemFrame)entity).getItem().getType().isAir()) {
            itemStackBuilder_4.a((LivingEntity)playerInteractEntityEvent.getPlayer(), BlockBreakEnum.ITEM_FRAME_PUT_ITEM, builder_14 -> builder_14.a(playerInteractEntityEvent, itemStackBuilder_4, itemStack));
            itemStackBuilder_4.a((LivingEntity)playerInteractEntityEvent.getPlayer(), BlockBreakEnum.UNHELD, builder_14 -> builder_14.a(playerInteractEntityEvent, itemStackBuilder_4, itemStack));
            itemStackBuilder_4.a((LivingEntity)playerInteractEntityEvent.getPlayer(), BlockBreakEnum.UNHELD_OFFHAND, builder_14 -> builder_14.a(playerInteractEntityEvent, itemStackBuilder_4, itemStack));
        }
    }

    @PluginContract_19
    private void l(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Player player = playerInteractEvent.getPlayer();
        if (playerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (player.isSneaking()) {
                itemStackBuilder_4.a(BlockBreakEnum.INTERACT_LEFT_SHIFT, playerInteractEvent, itemStack);
                if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                    itemStackBuilder_4.a(BlockBreakEnum.INTERACT_MAINHAND_LEFT_SHIFT, playerInteractEvent, itemStack);
                } else {
                    itemStackBuilder_4.a(BlockBreakEnum.INTERACT_OFFHAND_LEFT_SHIFT, playerInteractEvent, itemStack);
                }
            } else {
                itemStackBuilder_4.a(BlockBreakEnum.INTERACT_LEFT, playerInteractEvent, itemStack);
                if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                    itemStackBuilder_4.a(BlockBreakEnum.INTERACT_MAINHAND_LEFT, playerInteractEvent, itemStack);
                } else {
                    itemStackBuilder_4.a(BlockBreakEnum.INTERACT_OFFHAND_LEFT, playerInteractEvent, itemStack);
                }
            }
        } else if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (playerInteractEvent.getClickedBlock() != null && playerInteractEvent.getClickedBlock().getType() != Material.AIR && BlockRegistry.aO(playerInteractEvent.getClickedBlock()) && playerInteractEvent.getClickedBlock().getType() != Material.NOTE_BLOCK) {
                return;
            }
            if (player.isSneaking()) {
                itemStackBuilder_4.a(BlockBreakEnum.INTERACT_RIGHT_SHIFT, playerInteractEvent, itemStack);
                if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                    itemStackBuilder_4.a(BlockBreakEnum.INTERACT_MAINHAND_RIGHT_SHIFT, playerInteractEvent, itemStack);
                } else {
                    itemStackBuilder_4.a(BlockBreakEnum.INTERACT_OFFHAND_RIGHT_SHIFT, playerInteractEvent, itemStack);
                }
            } else {
                itemStackBuilder_4.a(BlockBreakEnum.INTERACT_RIGHT, playerInteractEvent, itemStack);
                if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                    itemStackBuilder_4.a(BlockBreakEnum.INTERACT_MAINHAND_RIGHT, playerInteractEvent, itemStack);
                } else {
                    itemStackBuilder_4.a(BlockBreakEnum.INTERACT_OFFHAND_RIGHT, playerInteractEvent, itemStack);
                }
            }
        }
    }

    @PluginContract_19
    private void b(BlockBreakEvent blockBreakEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (ItemStackBuilder_4.G(itemStack)) {
            blockBreakEvent.setCancelled(true);
            return;
        }
        itemStackBuilder_4.a((LivingEntity)blockBreakEvent.getPlayer(), BlockBreakEnum.BLOCK_BREAK, builder_14 -> builder_14.a(blockBreakEvent, itemStackBuilder_4, itemStack));
    }

    @PluginContract_19
    private void b(PlayerDropItemEvent playerDropItemEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)playerDropItemEvent.getPlayer(), BlockBreakEnum.DROP, builder_14 -> builder_14.a(playerDropItemEvent, itemStackBuilder_4, itemStack));
        playerDropItemEvent.getItemDrop().setItemStack(itemStack);
        if (itemStackBuilder_4.nt()) {
            playerDropItemEvent.getItemDrop().setCustomNameVisible(true);
            playerDropItemEvent.getItemDrop().setCustomName(itemStack.getItemMeta().getDisplayName());
        }
        if (itemStackBuilder_4.mX() != null) {
            Glow.set((Entity)playerDropItemEvent.getItemDrop(), itemStackBuilder_4.mX());
        }
    }

    @PluginContract_19
    private void c(ItemStackPlayerHolder itemStackPlayerHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)itemStackPlayerHolder.getPlayer(), BlockBreakEnum.UNHELD, builder_14 -> builder_14.b(itemStackPlayerHolder, itemStackBuilder_4, itemStack));
    }

    @PluginContract_19
    private void b(PlayerPickupItemEvent playerPickupItemEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)playerPickupItemEvent.getPlayer(), BlockBreakEnum.PICKUP, builder_14 -> builder_14.a(playerPickupItemEvent, itemStackBuilder_4, itemStack));
        if (ItemStackBridge_2.c(playerPickupItemEvent)) {
            itemStackBuilder_4.a((LivingEntity)playerPickupItemEvent.getPlayer(), BlockBreakEnum.HELD, builder_14 -> builder_14.a(playerPickupItemEvent, itemStackBuilder_4, itemStack));
        }
        playerPickupItemEvent.getItem().setItemStack(itemStack);
    }

    @PluginContract_19
    private void b(PlayerBucketEmptyEvent playerBucketEmptyEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)playerBucketEmptyEvent.getPlayer(), BlockBreakEnum.BUCKET_EMPTY, builder_14 -> builder_14.a(playerBucketEmptyEvent, itemStackBuilder_4, itemStack));
    }

    @PluginContract_19
    private void b(PlayerBucketFillEvent playerBucketFillEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)playerBucketFillEvent.getPlayer(), BlockBreakEnum.BUCKET_FILL, builder_14 -> builder_14.a(playerBucketFillEvent, itemStackBuilder_4, itemStack));
    }

    @PluginContract_19
    private void b(PlayerItemBreakEvent playerItemBreakEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)playerItemBreakEvent.getPlayer(), BlockBreakEnum.UNHELD, builder_14 -> builder_14.a(playerItemBreakEvent, itemStackBuilder_4, itemStack));
        itemStackBuilder_4.a((LivingEntity)playerItemBreakEvent.getPlayer(), BlockBreakEnum.ITEM_BREAK, builder_14 -> builder_14.a(playerItemBreakEvent, itemStackBuilder_4, itemStack));
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(PlayerItemDamageEvent playerItemDamageEvent) {
        ItemStack itemStack = playerItemDamageEvent.getItem();
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        if (!itemStackBuilder_4.nl() && ItemStackBridge_2.al(itemStack) - playerItemDamageEvent.getDamage() <= 0) {
            playerItemDamageEvent.setCancelled(true);
            ItemStackBridge_2.d(itemStack, 0);
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
                @Nullable ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
                ItemStack itemStack2 = inventoryClickEvent.getCurrentItem();
                ItemStackBuilder_4 itemStackBuilder_42 = ItemStackRegistry.g().a(itemStack2);
                if (itemStackBuilder_4 != null) {
                    itemStackBuilder_4.a((LivingEntity)player, BlockBreakEnum.WEAR, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_4, itemStack));
                    if (inventoryClickEvent.getSlotType() == InventoryType.SlotType.QUICKBAR && inventoryClickEvent.getSlot() == player.getInventory().getHeldItemSlot()) {
                        itemStackBuilder_4.a((LivingEntity)player, BlockBreakEnum.HELD, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_4, itemStack));
                    } else if (inventoryClickEvent.getSlot() == 40) {
                        itemStackBuilder_4.a((LivingEntity)player, BlockBreakEnum.HELD_OFFHAND, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_4, itemStack));
                    }
                }
                if (itemStackBuilder_42 != null) {
                    itemStackBuilder_42.a((LivingEntity)player, BlockBreakEnum.UNWEAR, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_42, itemStack2));
                    if (inventoryClickEvent.getSlotType() == InventoryType.SlotType.QUICKBAR && inventoryClickEvent.getSlot() == player.getInventory().getHeldItemSlot()) {
                        itemStackBuilder_42.a((LivingEntity)player, BlockBreakEnum.UNHELD, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_42, itemStack));
                    } else if (inventoryClickEvent.getSlot() == 40) {
                        itemStackBuilder_42.a((LivingEntity)player, BlockBreakEnum.UNHELD_OFFHAND, builder_14 -> builder_14.e(inventoryClickEvent, itemStackBuilder_42, itemStack));
                    }
                }
            }
            if (MaterialBarColorHolder.fK) {
                PlayerJoinListener_7.a(inventoryClickEvent);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent) {
        ItemStack itemStack = playerSwapHandItemsEvent.getMainHandItem();
        ItemStack itemStack2 = playerSwapHandItemsEvent.getOffHandItem();
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        ItemStackBuilder_4 itemStackBuilder_42 = ItemStackRegistry.g().a(itemStack2);
        if (itemStackBuilder_4 != null) {
            itemStackBuilder_4.a((LivingEntity)playerSwapHandItemsEvent.getPlayer(), BlockBreakEnum.UNHELD_OFFHAND, builder_14 -> builder_14.a(playerSwapHandItemsEvent, itemStackBuilder_4, itemStack));
            itemStackBuilder_4.a((LivingEntity)playerSwapHandItemsEvent.getPlayer(), BlockBreakEnum.HELD, builder_14 -> builder_14.a(playerSwapHandItemsEvent, itemStackBuilder_4, itemStack));
        }
        if (itemStackBuilder_42 != null) {
            itemStackBuilder_42.a((LivingEntity)playerSwapHandItemsEvent.getPlayer(), BlockBreakEnum.UNHELD, builder_14 -> builder_14.a(playerSwapHandItemsEvent, itemStackBuilder_42, itemStack2));
            itemStackBuilder_42.a((LivingEntity)playerSwapHandItemsEvent.getPlayer(), BlockBreakEnum.HELD_OFFHAND, builder_14 -> builder_14.a(playerSwapHandItemsEvent, itemStackBuilder_42, itemStack2));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerItemHeldEvent playerItemHeldEvent) {
        ItemStack itemStack = playerItemHeldEvent.getPlayer().getInventory().getItem(playerItemHeldEvent.getPreviousSlot());
        ItemStack itemStack2 = playerItemHeldEvent.getPlayer().getInventory().getItem(playerItemHeldEvent.getNewSlot());
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        ItemStackBuilder_4 itemStackBuilder_42 = ItemStackRegistry.g().a(itemStack2);
        if (itemStackBuilder_4 != null) {
            BlockBreakEnum.UNHELD.a(playerItemHeldEvent, itemStackBuilder_4, itemStack, playerItemHeldEvent.getPlayer());
        }
        if (itemStackBuilder_42 != null) {
            BlockBreakEnum.HELD.a(playerItemHeldEvent, itemStackBuilder_42, itemStack2, playerItemHeldEvent.getPlayer());
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
        if (ItemStackBuilder_4.G(((Player)entityDamageByEntityEvent.getDamager()).getInventory().getItemInMainHand())) {
            entityDamageByEntityEvent.setCancelled(true);
            return;
        }
        if (EntityHolder.i(entity.getType()) && ItemStackBuilder_4.isCustomItem(itemStack = (itemFrame = (ItemFrame)entity).getItem())) {
            ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
            if (itemStackBuilder_4 == null) {
                return;
            }
            itemStackBuilder_4.a((LivingEntity)entityDamageByEntityEvent.getDamager(), BlockBreakEnum.ITEM_FRAME_REMOVE_ITEM, builder_14 -> builder_14.a(entityDamageByEntityEvent, itemStackBuilder_4, itemStack));
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void b(PlayerArmorStandManipulateEvent playerArmorStandManipulateEvent) {
        this.a(playerArmorStandManipulateEvent, playerArmorStandManipulateEvent.getPlayerItem(), BlockBreakEnum.ARMOR_STAND_PUT_ITEM, true);
        this.a(playerArmorStandManipulateEvent, playerArmorStandManipulateEvent.getArmorStandItem(), BlockBreakEnum.ARMOR_STAND_REMOVE_ITEM, false);
    }

    private void a(PlayerArmorStandManipulateEvent playerArmorStandManipulateEvent, ItemStack itemStack, BlockBreakEnum blockBreakEnum, boolean bl) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        itemStackBuilder_4.a((LivingEntity)playerArmorStandManipulateEvent.getPlayer(), blockBreakEnum, builder_14 -> builder_14.a((PlayerInteractEntityEvent)playerArmorStandManipulateEvent, itemStackBuilder_4, itemStack));
        if (ConfigurationSectionBridge_2.Cb) {
            if (bl) {
                itemStackBuilder_4.a((LivingEntity)playerArmorStandManipulateEvent.getPlayer(), BlockBreakEnum.UNHELD, builder_14 -> builder_14.a((PlayerInteractEntityEvent)playerArmorStandManipulateEvent, itemStackBuilder_4, itemStack));
                itemStackBuilder_4.a((LivingEntity)playerArmorStandManipulateEvent.getPlayer(), BlockBreakEnum.UNHELD_OFFHAND, builder_14 -> builder_14.a((PlayerInteractEntityEvent)playerArmorStandManipulateEvent, itemStackBuilder_4, itemStack));
            } else {
                itemStackBuilder_4.a((LivingEntity)playerArmorStandManipulateEvent.getPlayer(), BlockBreakEnum.HELD, builder_14 -> builder_14.a((PlayerInteractEntityEvent)playerArmorStandManipulateEvent, itemStackBuilder_4, itemStack));
            }
        }
    }
}
