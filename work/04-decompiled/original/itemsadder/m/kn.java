package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.api.Events.FurnitureInteractEvent;
import dev.lone.itemsadder.api.Events.FurniturePlaceEvent;
import dev.lone.itemsadder.api.Events.FurniturePreUnsitEvent;
import dev.lone.itemsadder.api.Events.FurnitureUnsitEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.aaf;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bci;
import itemsadder.m.bck;
import itemsadder.m.bcv;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.j;
import itemsadder.m.jj;
import itemsadder.m.jl;
import itemsadder.m.js;
import itemsadder.m.jw;
import itemsadder.m.jx;
import itemsadder.m.lq;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import itemsadder.m.w;
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

public class kn
extends lq {
    public kn(Plugin plugin) {
        d d2 = d.g();
        bev.a(this, plugin);
        d2.ar.a(new my(BlockPlaceEvent.class, this::a));
        d2.ar.a(new my(BlockMultiPlaceEvent.class, this::a));
        d2.ar.a(new my(PlayerInteractEvent.class, this::b));
        d2.ar.a(new my(InventoryClickEvent.class, this::b));
    }

    @mz
    void a(BlockPlaceEvent blockPlaceEvent, qm qm2, ItemStack itemStack) {
        if (!qm2.Ge.bm("furniture")) {
            return;
        }
        blockPlaceEvent.setCancelled(true);
        Block block = blockPlaceEvent.getBlockPlaced();
        Player player = blockPlaceEvent.getPlayer();
        if (!blockPlaceEvent.getPlayer().isSneaking() && (aaf.aO(blockPlaceEvent.getBlockAgainst()) || d.a(blockPlaceEvent.getBlockAgainst()))) {
            return;
        }
        if (jl.ao(player) != null) {
            return;
        }
        js js2 = (js)qm2.Ge.bn("furniture");
        if (!s.e((HumanEntity)player, js2.kM())) {
            return;
        }
        if (!bev.b((Event)new FurniturePlaceEvent(player, js2))) {
            return;
        }
        Entity entity = js2.a(itemStack, block, blockPlaceEvent.getHand(), player, this, w.bN.f(player));
        if (entity != null) {
            d.g().aC.aw(player);
        }
    }

    @mz
    void b(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
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
        if (!qm2.Ge.bm("furniture")) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock();
        if (!playerInteractEvent.getPlayer().isSneaking() && block != null && (aaf.aO(block) || d.a(block))) {
            return;
        }
        playerInteractEvent.setUseInteractedBlock(Event.Result.DENY);
        playerInteractEvent.setUseItemInHand(Event.Result.DENY);
        if (block == null) {
            return;
        }
        Block block2 = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace());
        if (!bcc.b(block2, player = playerInteractEvent.getPlayer())) {
            return;
        }
        if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND && d.g().hasBehaviour(playerInteractEvent.getPlayer().getItemInHand(), "furniture")) {
            return;
        }
        bci bci2 = jl.ap(player);
        if (bci2 != null && ((Location)bci2.aAY).getBlock().getRelative(playerInteractEvent.getBlockFace().getOppositeFace()).getType() != Material.BARRIER && !playerInteractEvent.getPlayer().isSneaking()) {
            return;
        }
        js js2 = (js)qm2.Ge.bn("furniture");
        if (!s.e((HumanEntity)player, js2.kM())) {
            return;
        }
        if (js2.kI() && bcc.e(player, block2)) {
            return;
        }
        if (!bev.b((Event)new FurniturePlaceEvent(player, js2))) {
            return;
        }
        Entity entity = js2.a(itemStack, block2, playerInteractEvent.getHand(), player, this, playerInteractEvent.getBlockFace());
        if (entity != null) {
            d.g().aC.aw(player);
        }
    }

    boolean d(PlayerInteractEvent playerInteractEvent) {
        if (bbs.q(playerInteractEvent)) {
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
        if (d.g().aC.ax(playerInteractEvent.getPlayer())) {
            return false;
        }
        Entity entity = jl.ao(playerInteractEvent.getPlayer());
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
        if (bbs.d((PlayerInteractEntityEvent)playerInteractAtEntityEvent)) {
            return;
        }
        if (d.g().aC.ax(playerInteractAtEntityEvent.getPlayer())) {
            return;
        }
        Entity entity = playerInteractAtEntityEvent.getRightClicked();
        if (playerInteractAtEntityEvent.getRightClicked() instanceof ArmorStand || playerInteractAtEntityEvent.getRightClicked() instanceof ItemFrame) {
            this.a(entity, playerInteractAtEntityEvent.getPlayer(), (Cancellable)playerInteractAtEntityEvent, null, () -> !playerInteractAtEntityEvent.getPlayer().isSneaking() && !playerInteractAtEntityEvent.getPlayer().isInsideVehicle() && ProtectionPlugins.canSitOnFurniture(playerInteractAtEntityEvent.getPlayer(), entity, (Cancellable)playerInteractAtEntityEvent));
        }
        jj jj2 = null;
        if (entity instanceof ArmorStand) {
            if (!ProtectionPlugins.canInteract_furniture(playerInteractAtEntityEvent)) {
                playerInteractAtEntityEvent.setCancelled(true);
                return;
            }
            object = (ArmorStand)entity;
            itemStack = object.getHelmet();
            jj2 = jj.PLACED_ARMORSTAND_INTERACT;
        } else if (entity instanceof ItemFrame) {
            if (!ProtectionPlugins.canInteract_furniture(playerInteractAtEntityEvent)) {
                playerInteractAtEntityEvent.setCancelled(true);
                return;
            }
            itemStack = js.o(entity);
            jj2 = jj.PLACED_ITEMFRAME_INTERACT;
        } else {
            itemStack = null;
        }
        object = d.g().a(itemStack);
        if (object == null) {
            return;
        }
        js js2 = (js)((qm)object).Ge.bn("furniture");
        if (js2 == null) {
            return;
        }
        if (!bev.b((Event)new FurnitureInteractEvent(playerInteractAtEntityEvent.getPlayer(), entity, Action.RIGHT_CLICK_AIR, js2))) {
            playerInteractAtEntityEvent.setCancelled(true);
            return;
        }
        ((qm)object).a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), jj.PLACED_FURNITURE_INTERACT, arg_0 -> kn.b(playerInteractAtEntityEvent, (qm)object, itemStack, arg_0));
        ((qm)object).a((LivingEntity)playerInteractAtEntityEvent.getPlayer(), jj2, arg_0 -> kn.a(playerInteractAtEntityEvent, (qm)object, itemStack, arg_0));
        if (!playerInteractAtEntityEvent.isCancelled() && js2.kK() && entity instanceof ItemFrame && playerInteractAtEntityEvent.getPlayer().isSneaking()) {
            ItemFrame itemFrame = (ItemFrame)entity;
            itemFrame.setRotation(itemFrame.getRotation().rotateClockwise());
            bcv.a(entity.getLocation(), "entity.item_frame.rotate_item", SoundCategory.BLOCKS);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void a(PlayerInteractEvent playerInteractEvent) {
        if (bbs.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (playerInteractEvent.getClickedBlock() == null) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        if (w.bN.k(player)) {
            return;
        }
        Entity entity = jl.ao(player);
        if (entity == null) {
            return;
        }
        if (d.g().aC.ax(player)) {
            return;
        }
        if (playerInteractEvent.getClickedBlock().getType() == Material.BARRIER) {
            ItemStack itemStack = js.o(entity);
            this.a(itemStack, playerInteractEvent, entity);
            this.a(entity, player, (Cancellable)playerInteractEvent, playerInteractEvent.getClickedBlock(), () -> !player.isSneaking() && !player.isInsideVehicle() && ProtectionPlugins.canSitOnFurniture(player, entity, (Cancellable)playerInteractEvent));
        } else if (entity.getType() == EntityType.ITEM_DISPLAY) {
            qm qm2;
            ItemStack itemStack = js.o(entity);
            this.a(itemStack, playerInteractEvent, entity);
            if (qm.isCustomItem(itemStack) && (qm2 = d.g().a(itemStack)) != null && qm2.Ge.bm("furniture_sit") && ProtectionPlugins.canSitOnFurniture(player, entity, (Cancellable)playerInteractEvent)) {
                this.a(entity, player, (Cancellable)playerInteractEvent, null);
            }
        }
    }

    private void a(ItemStack itemStack, PlayerInteractEvent playerInteractEvent, Entity entity) {
        if (!qm.isCustomItem(itemStack)) {
            return;
        }
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return;
        }
        js js2 = (js)qm2.Ge.bn("furniture");
        if (!bev.b((Event)new FurnitureInteractEvent(playerInteractEvent.getPlayer(), entity, playerInteractEvent.getAction(), js2))) {
            playerInteractEvent.setUseInteractedBlock(Event.Result.DENY);
            return;
        }
        qm2.a((LivingEntity)playerInteractEvent.getPlayer(), jj.PLACED_FURNITURE_INTERACT, (Object ou2) -> {
            pa pa2 = ou2.j(playerInteractEvent, qm2, itemStack);
            if (pa2.Ed != null) {
                js.a(entity, pa2.Ed);
            }
            return pa2;
        });
        this.a(qm2, itemStack, playerInteractEvent, entity, jj.PLACED_ARMORSTAND_INTERACT);
        this.a(qm2, itemStack, playerInteractEvent, entity, jj.PLACED_ITEMFRAME_INTERACT);
        jw jw2 = (jw)qm2.Ge.bn("furniture_consumable");
        if (jw2 != null) {
            jw2.a(playerInteractEvent.getPlayer(), entity, jw2, qm2);
        }
    }

    private void a(qm qm2, ItemStack itemStack, PlayerInteractEvent playerInteractEvent, Entity entity, jj jj2) {
        if (qm2.Gd.a(jj2)) {
            qm2.a((LivingEntity)playerInteractEvent.getPlayer(), jj2, (Object ou2) -> {
                pa pa2 = ou2.j(playerInteractEvent, qm2, itemStack);
                if (pa2.Ed != null) {
                    js.a(entity, pa2.Ed);
                }
                return pa2;
            });
        }
    }

    private boolean a(Entity entity, Player player, Cancellable cancellable, @Nullable Block block) {
        return this.a(entity, player, cancellable, block, null);
    }

    private boolean a(Entity entity, Player player, Cancellable cancellable, @Nullable Block block, bck bck2) {
        ItemStack itemStack = js.o(entity);
        if (!qm.isCustomItem(itemStack)) {
            return false;
        }
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return false;
        }
        if (!qm2.Ge.bm("furniture_sit") || !qm2.Ge.bm("furniture")) {
            return false;
        }
        if (bck2 != null && !((Boolean)bck2.call()).booleanValue()) {
            return false;
        }
        cancellable.setCancelled(true);
        js js2 = (js)qm2.Ge.bn("furniture");
        if (js2 == null) {
            return false;
        }
        if (!j.V().d(player)) {
            if (block != null && !entity.getBoundingBox().contains(block.getBoundingBox().clone().expand(-0.3))) {
                return false;
            }
            if (js2.xr != entity.getType()) {
                return false;
            }
            jx jx2 = (jx)qm2.Ge.bn("furniture_sit");
            return j.V().a(player, entity, block, jx2.kQ(), js2.kG(), false, true, jx2.kR(), jx2.kS());
        }
        return false;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void b(EntityDismountEvent entityDismountEvent) {
        Object object;
        if (entityDismountEvent.getDismounted() instanceof ArmorStand && entityDismountEvent.getEntity().getType() == EntityType.PLAYER && (object = entityDismountEvent.getEntity()) instanceof Player) {
            Player player = (Player)object;
            if (j.V().d((Player)entityDismountEvent.getEntity())) {
                js js2;
                object = js.p(entityDismountEvent.getDismounted());
                if (object != null && (js2 = (js)object.Ge.bn("furniture")) != null && !bev.b((Event)new FurniturePreUnsitEvent(player, entityDismountEvent.getDismounted(), js2))) {
                    entityDismountEvent.setCancelled(true);
                    return;
                }
                j.V().c((Player)entityDismountEvent.getEntity());
                entityDismountEvent.getEntity().teleport(entityDismountEvent.getEntity().getLocation().add(0.0, 0.5, 0.0));
                bev.b((Event)new FurnitureUnsitEvent(player, entityDismountEvent.getDismounted(), null));
            }
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void a(PlayerArmorStandManipulateEvent playerArmorStandManipulateEvent) {
        ItemStack itemStack = playerArmorStandManipulateEvent.getRightClicked().getHelmet();
        if (!qm.isCustomItem(itemStack)) {
            return;
        }
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return;
        }
        if (!qm2.Ge.bm("furniture")) {
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
        if (!j.V().d((Player)entityDamageEvent.getEntity())) {
            return;
        }
        entityDamageEvent.setCancelled(true);
    }

    @mz
    private void b(InventoryClickEvent inventoryClickEvent, qm qm2, @Nullable ItemStack itemStack) {
        if (inventoryClickEvent.getInventory() instanceof HorseInventory) {
            if (qm2.getType() != Material.LEATHER_HORSE_ARMOR) {
                return;
            }
            if (qm2.Ge.BZ.size() > 0) {
                inventoryClickEvent.setCancelled(true);
            }
        }
    }

    private static /* synthetic */ pa a(PlayerInteractAtEntityEvent playerInteractAtEntityEvent, qm qm2, ItemStack itemStack, ou ou2) {
        return ou2.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, qm2, itemStack);
    }

    private static /* synthetic */ pa b(PlayerInteractAtEntityEvent playerInteractAtEntityEvent, qm qm2, ItemStack itemStack, ou ou2) {
        return ou2.a((PlayerInteractEntityEvent)playerInteractAtEntityEvent, qm2, itemStack);
    }
}
