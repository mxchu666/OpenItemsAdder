package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.api.Events.FurnitureInteractEvent;
import dev.lone.itemsadder.api.Events.FurniturePlaceEvent;
import dev.lone.itemsadder.api.Events.FurniturePreUnsitEvent;
import dev.lone.itemsadder.api.Events.FurnitureUnsitEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BlockRegistry;
import itemsadder.m.Builder_14;
import itemsadder.m.CallFunction;
import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_3;
import itemsadder.m.NamespacedKeyEntityTypeHolder;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.Opaque021;
import itemsadder.m.Opaque125;
import itemsadder.m.PlayerBridge_17;
import itemsadder.m.PlayerBridge_18;
import itemsadder.m.PlayerJoinListener_3;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.PluginContract_19;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDismountEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class PlayerInteractAtEntityListener
extends PlayerBridge_18 {
    public PlayerInteractAtEntityListener(Plugin plugin) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(BlockPlaceEvent.class, this::a));
        itemStackRegistry.ar.a(new ClassRefData(BlockMultiPlaceEvent.class, this::a));
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEvent.class, this::b));
        itemStackRegistry.ar.a(new ClassRefData(InventoryClickEvent.class, this::b));
    }

    @PluginContract_19
    void a(BlockPlaceEvent blockPlaceEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (!itemStackBuilder_4.Ge.bm("furniture")) {
            return;
        }
        blockPlaceEvent.setCancelled(true);
        Block block = blockPlaceEvent.getBlockPlaced();
        Player player = blockPlaceEvent.getPlayer();
        if (!blockPlaceEvent.getPlayer().isSneaking() && (BlockRegistry.aO(blockPlaceEvent.getBlockAgainst()) || ItemStackRegistry.a(blockPlaceEvent.getBlockAgainst()))) {
            return;
        }
        if (NamespacedKeyEntityTypeHolder.ao(player) != null) {
            return;
        }
        NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder = (NamespacedKeyItemDisplayHolder)itemStackBuilder_4.Ge.bn("furniture");
        if (!s.e((HumanEntity)player, namespacedKeyItemDisplayHolder.kM())) {
            return;
        }
        if (!ListenerBridge.b((Event)new FurniturePlaceEvent(player, namespacedKeyItemDisplayHolder))) {
            return;
        }
        Entity entity = namespacedKeyItemDisplayHolder.a(itemStack, block, blockPlaceEvent.getHand(), player, this, PlayerJoinListener_9.bN.f(player));
        if (entity != null) {
            ItemStackRegistry.g().aC.aw(player);
        }
    }

    @PluginContract_19
    void b(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Player player;
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (this.d(playerInteractEvent)) {
            return;
        }
        if (itemStack.getType().isBlock()) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("furniture")) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock();
        if (!playerInteractEvent.getPlayer().isSneaking() && block != null && (BlockRegistry.aO(block) || ItemStackRegistry.a(block))) {
            return;
        }
        playerInteractEvent.setUseInteractedBlock(Event.Result.DENY);
        playerInteractEvent.setUseItemInHand(Event.Result.DENY);
        if (block == null) {
            return;
        }
        Block block2 = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace());
        if (!LocationBridge_2.b(block2, player = playerInteractEvent.getPlayer())) {
            return;
        }
        if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND && ItemStackRegistry.g().hasBehaviour(playerInteractEvent.getPlayer().getItemInHand(), "furniture")) {
            return;
        }
        Opaque021 opaque021 = NamespacedKeyEntityTypeHolder.ap(player);
        if (opaque021 != null && ((Location)opaque021.aAY).getBlock().getRelative(playerInteractEvent.getBlockFace().getOppositeFace()).getType() != Material.BARRIER && !playerInteractEvent.getPlayer().isSneaking()) {
            return;
        }
        NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder = (NamespacedKeyItemDisplayHolder)itemStackBuilder_4.Ge.bn("furniture");
        if (!s.e((HumanEntity)player, namespacedKeyItemDisplayHolder.kM())) {
            return;
        }
        if (namespacedKeyItemDisplayHolder.kI() && LocationBridge_2.e(player, block2)) {
            return;
        }
        if (!ListenerBridge.b((Event)new FurniturePlaceEvent(player, namespacedKeyItemDisplayHolder))) {
            return;
        }
        Entity entity = namespacedKeyItemDisplayHolder.a(itemStack, block2, playerInteractEvent.getHand(), player, this, playerInteractEvent.getBlockFace());
        if (entity != null) {
            ItemStackRegistry.g().aC.aw(player);
        }
    }

    boolean d(PlayerInteractEvent playerInteractEvent) {
        if (ItemStackBridge_2.q(playerInteractEvent)) {
            return false;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return false;
        }
        if (playerInteractEvent.getPlayer().isSneaking()) {
            return false;
        }
        if (playerInteractEvent.getPlayer().isInsideVehicle()) {
            return false;
        }
        if (playerInteractEvent.getClickedBlock().getType() != Material.BARRIER) {
            return false;
        }
        if (ItemStackRegistry.g().aC.ax(playerInteractEvent.getPlayer())) {
            return false;
        }
        Entity entity = NamespacedKeyEntityTypeHolder.ao(playerInteractEvent.getPlayer());
        if (entity == null) {
            return false;
        }
        if (ProtectionPlugins.canSitOnFurniture(playerInteractEvent.getPlayer(), entity, (Cancellable)playerInteractEvent)) {
            return this.a(entity, playerInteractEvent.getPlayer(), (Cancellable)playerInteractEvent, playerInteractEvent.getClickedBlock());
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    @EventHandler(priority=EventPriority.MONITOR)
    void b(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        ItemStack itemStack;
        Object object;
        if (ItemStackBridge_2.d((PlayerInteractEntityEvent)playerInteractAtEntityEvent)) {
            return;
        }
        if (ItemStackRegistry.g().aC.ax(playerInteractAtEntityEvent.getPlayer())) {
            return;
        }
        Entity entity = playerInteractAtEntityEvent.getRightClicked();
        if (playerInteractAtEntityEvent.getRightClicked() instanceof ArmorStand || playerInteractAtEntityEvent.getRightClicked() instanceof ItemFrame) {
            this.a(entity, playerInteractAtEntityEvent.getPlayer(), (Cancellable)playerInteractAtEntityEvent, null, () -> !playerInteractAtEntityEvent.getPlayer().isSneaking() && !playerInteractAtEntityEvent.getPlayer().isInsideVehicle() && ProtectionPlugins.canSitOnFurniture(playerInteractAtEntityEvent.getPlayer(), entity, (Cancellable)playerInteractAtEntityEvent));
        }
        BlockBreakEnum blockBreakEnum = null;
        if (entity instanceof ArmorStand) {
            if (!ProtectionPlugins.canInteract_furniture(playerInteractAtEntityEvent)) {
                playerInteractAtEntityEvent.setCancelled(true);
                return;
            }
            object = (ArmorStand)entity;
            itemStack = object.getHelmet();
            blockBreakEnum = BlockBreakEnum.PLACED_ARMORSTAND_INTERACT;
        } else if (entity instanceof ItemFrame) {
            if (!ProtectionPlugins.canInteract_furniture(playerInteractAtEntityEvent)) {
                playerInteractAtEntityEvent.setCancelled(true);
                return;
            }
            itemStack = NamespacedKeyItemDisplayHolder.o(entity);
            blockBreakEnum = BlockBreakEnum.PLACED_ITEMFRAME_INTERACT;
        } else {
            itemStack = null;
        }
        object = ItemStackRegistry.g().a(itemStack);
        if (object == null) {
            return;
        }
        NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder = (NamespacedKeyItemDisplayHolder)((ItemStackBuilder_4)object).Ge.bn("furniture");
        if (namespacedKeyItemDisplayHolder == null) {
            return;
        }
        if (!ListenerBridge.b((Event)new FurnitureInteractEvent(playerInteractAtEntityEvent.getPlayer(), entity, Action.RIGHT_CLICK_AIR, namespacedKeyItemDisplayHolder))) {
            playerInteractAtEntityEvent.setCancelled(true);
            return;
        }
        ((ItemStackBuilder_4)object).a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), BlockBreakEnum.PLACED_FURNITURE_INTERACT, arg_0 -> PlayerInteractAtEntityListener.b(playerInteractAtEntityEvent, (ItemStackBuilder_4)object, itemStack, arg_0));
        ((ItemStackBuilder_4)object).a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), blockBreakEnum, arg_0 -> PlayerInteractAtEntityListener.a(playerInteractAtEntityEvent, (ItemStackBuilder_4)object, itemStack, arg_0));
        if (!playerInteractAtEntityEvent.isCancelled() && namespacedKeyItemDisplayHolder.kK() && entity instanceof ItemFrame && playerInteractAtEntityEvent.getPlayer().isSneaking()) {
            ItemFrame itemFrame = (ItemFrame)entity;
            itemFrame.setRotation(itemFrame.getRotation().rotateClockwise());
            LocationBridge_3.a(entity.getLocation(), "entity.item_frame.rotate_item", SoundCategory.BLOCKS);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void a(PlayerInteractEvent playerInteractEvent) {
        if (ItemStackBridge_2.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (playerInteractEvent.getClickedBlock() == null) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        if (PlayerJoinListener_9.bN.k(player)) {
            return;
        }
        Entity entity = NamespacedKeyEntityTypeHolder.ao(player);
        if (entity == null) {
            return;
        }
        if (ItemStackRegistry.g().aC.ax(player)) {
            return;
        }
        if (playerInteractEvent.getClickedBlock().getType() == Material.BARRIER) {
            ItemStack itemStack = NamespacedKeyItemDisplayHolder.o(entity);
            this.a(itemStack, playerInteractEvent, entity);
            this.a(entity, player, (Cancellable)playerInteractEvent, playerInteractEvent.getClickedBlock(), () -> !player.isSneaking() && !player.isInsideVehicle() && ProtectionPlugins.canSitOnFurniture(player, entity, (Cancellable)playerInteractEvent));
        } else if (entity.getType() == EntityType.ITEM_DISPLAY) {
            ItemStackBuilder_4 itemStackBuilder_4;
            ItemStack itemStack = NamespacedKeyItemDisplayHolder.o(entity);
            this.a(itemStack, playerInteractEvent, entity);
            if (ItemStackBuilder_4.isCustomItem(itemStack) && (itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack)) != null && itemStackBuilder_4.Ge.bm("furniture_sit") && ProtectionPlugins.canSitOnFurniture(player, entity, (Cancellable)playerInteractEvent)) {
                this.a(entity, player, (Cancellable)playerInteractEvent, null);
            }
        }
    }

    private void a(ItemStack itemStack, PlayerInteractEvent playerInteractEvent, Entity entity) {
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder = (NamespacedKeyItemDisplayHolder)itemStackBuilder_4.Ge.bn("furniture");
        if (!ListenerBridge.b((Event)new FurnitureInteractEvent(playerInteractEvent.getPlayer(), entity, playerInteractEvent.getAction(), namespacedKeyItemDisplayHolder))) {
            playerInteractEvent.setUseInteractedBlock(Event.Result.DENY);
            return;
        }
        itemStackBuilder_4.a((LivingEntity)playerInteractEvent.getPlayer(), BlockBreakEnum.PLACED_FURNITURE_INTERACT, (Object builder_14) -> {
            ItemStackBuilder_3 itemStackBuilder_3 = builder_14.j(playerInteractEvent, itemStackBuilder_4, itemStack);
            if (itemStackBuilder_3.Ed != null) {
                NamespacedKeyItemDisplayHolder.a(entity, itemStackBuilder_3.Ed);
            }
            return itemStackBuilder_3;
        });
        this.a(itemStackBuilder_4, itemStack, playerInteractEvent, entity, BlockBreakEnum.PLACED_ARMORSTAND_INTERACT);
        this.a(itemStackBuilder_4, itemStack, playerInteractEvent, entity, BlockBreakEnum.PLACED_ITEMFRAME_INTERACT);
        PlayerBridge_17 playerBridge_17 = (PlayerBridge_17)itemStackBuilder_4.Ge.bn("furniture_consumable");
        if (playerBridge_17 != null) {
            playerBridge_17.a(playerInteractEvent.getPlayer(), entity, playerBridge_17, itemStackBuilder_4);
        }
    }

    private void a(ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, PlayerInteractEvent playerInteractEvent, Entity entity, BlockBreakEnum blockBreakEnum) {
        if (itemStackBuilder_4.Gd.a(blockBreakEnum)) {
            itemStackBuilder_4.a((LivingEntity)playerInteractEvent.getPlayer(), blockBreakEnum, (Object builder_14) -> {
                ItemStackBuilder_3 itemStackBuilder_3 = builder_14.j(playerInteractEvent, itemStackBuilder_4, itemStack);
                if (itemStackBuilder_3.Ed != null) {
                    NamespacedKeyItemDisplayHolder.a(entity, itemStackBuilder_3.Ed);
                }
                return itemStackBuilder_3;
            });
        }
    }

    private boolean a(Entity entity, Player player, Cancellable cancellable, @Nullable Block block) {
        return this.a(entity, player, cancellable, block, null);
    }

    private boolean a(Entity entity, Player player, Cancellable cancellable, @Nullable Block block, CallFunction callFunction) {
        ItemStack itemStack = NamespacedKeyItemDisplayHolder.o(entity);
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return false;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        if (!itemStackBuilder_4.Ge.bm("furniture_sit") || !itemStackBuilder_4.Ge.bm("furniture")) {
            return false;
        }
        if (callFunction != null && !((Boolean)callFunction.call()).booleanValue()) {
            return false;
        }
        cancellable.setCancelled(true);
        NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder = (NamespacedKeyItemDisplayHolder)itemStackBuilder_4.Ge.bn("furniture");
        if (namespacedKeyItemDisplayHolder == null) {
            return false;
        }
        if (!PlayerJoinListener_3.V().d(player)) {
            if (block != null && !entity.getBoundingBox().contains(block.getBoundingBox().clone().expand(-0.3))) {
                return false;
            }
            if (namespacedKeyItemDisplayHolder.xr != entity.getType()) {
                return false;
            }
            Opaque125 opaque125 = (Opaque125)itemStackBuilder_4.Ge.bn("furniture_sit");
            return PlayerJoinListener_3.V().a(player, entity, block, opaque125.kQ(), namespacedKeyItemDisplayHolder.kG(), false, true, opaque125.kR(), opaque125.kS());
        }
        return false;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void b(EntityDismountEvent entityDismountEvent) {
        Object object;
        if (entityDismountEvent.getDismounted() instanceof ArmorStand && entityDismountEvent.getEntity().getType() == EntityType.PLAYER && (object = entityDismountEvent.getEntity()) instanceof Player) {
            Player player = (Player)object;
            if (PlayerJoinListener_3.V().d((Player)entityDismountEvent.getEntity())) {
                NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder;
                object = NamespacedKeyItemDisplayHolder.p(entityDismountEvent.getDismounted());
                if (object != null && (namespacedKeyItemDisplayHolder = (NamespacedKeyItemDisplayHolder)object.Ge.bn("furniture")) != null && !ListenerBridge.b((Event)new FurniturePreUnsitEvent(player, entityDismountEvent.getDismounted(), namespacedKeyItemDisplayHolder))) {
                    entityDismountEvent.setCancelled(true);
                    return;
                }
                PlayerJoinListener_3.V().c((Player)entityDismountEvent.getEntity());
                entityDismountEvent.getEntity().teleport(entityDismountEvent.getEntity().getLocation().add(0.0, 0.5, 0.0));
                ListenerBridge.b((Event)new FurnitureUnsitEvent(player, entityDismountEvent.getDismounted(), null));
            }
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void a(PlayerArmorStandManipulateEvent playerArmorStandManipulateEvent) {
        ItemStack itemStack = playerArmorStandManipulateEvent.getRightClicked().getHelmet();
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("furniture")) {
            return;
        }
        playerArmorStandManipulateEvent.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void a(EntityDamageEvent entityDamageEvent) {
        if (entityDamageEvent.getEntity().getType() != EntityType.PLAYER) {
            return;
        }
        if (entityDamageEvent.getCause() != EntityDamageEvent.DamageCause.SUFFOCATION) {
            return;
        }
        if (!PlayerJoinListener_3.V().d((Player)entityDamageEvent.getEntity())) {
            return;
        }
        entityDamageEvent.setCancelled(true);
    }

    @PluginContract_19
    private void b(InventoryClickEvent inventoryClickEvent, ItemStackBuilder_4 itemStackBuilder_4, @Nullable ItemStack itemStack) {
        if (inventoryClickEvent.getInventory() instanceof HorseInventory) {
            if (itemStackBuilder_4.getType() != Material.LEATHER_HORSE_ARMOR) {
                return;
            }
            if (itemStackBuilder_4.Ge.BZ.size() > 0) {
                inventoryClickEvent.setCancelled(true);
            }
        }
    }

    private static /* synthetic */ ItemStackBuilder_3 a(PlayerInteractAtEntityEvent playerInteractAtEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Builder_14 builder_14) {
        return builder_14.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, itemStackBuilder_4, itemStack);
    }

    private static /* synthetic */ ItemStackBuilder_3 b(PlayerInteractAtEntityEvent playerInteractAtEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Builder_14 builder_14) {
        return builder_14.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, itemStackBuilder_4, itemStack);
    }
}
