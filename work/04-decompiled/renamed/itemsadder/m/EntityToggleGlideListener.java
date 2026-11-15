package itemsadder.m;

import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.Opaque128;
import itemsadder.m.Opaque129;
import itemsadder.m.PlayerElytraBoostListener;
import itemsadder.m.PluginContract;
import itemsadder.m.RecordOfNamespacedKey;
import itemsadder.m.RecordOfValue_22;
import itemsadder.m.VersionHelper_3;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public final class EntityToggleGlideListener
implements PluginContract {
    private final ItemStackRegistry Eh;
    final Opaque128 Ei = new Opaque128();
    @Nullable
    private final PluginContract Ej;

    public EntityToggleGlideListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.Eh = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        this.Ej = this.mn();
        BukkitTaskBridge.a(this::bV, 1L);
    }

    @Nullable
    private PluginContract mn() {
        if (!VersionHelper_3.sZ()) {
            return null;
        }
        try {
            return new PlayerElytraBoostListener(this);
        }
        catch (LinkageError | RuntimeException throwable) {
            CommandSenderBridge_5.warn("Failed to register Paper Elytra boost compatibility. Falling back to Bukkit interaction handling. " + String.valueOf(throwable));
            return null;
        }
    }

    @Override
    public void unregister() {
        this.Ei.clear();
        PluginContract.a(this.Ej);
        PluginContract.super.unregister();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(EntityToggleGlideEvent entityToggleGlideEvent) {
        Object object = entityToggleGlideEvent.getEntity();
        if (!(object instanceof Player)) {
            return;
        }
        Player player = (Player)object;
        if (entityToggleGlideEvent.isGliding()) {
            object = this.ba(player);
            if (object == null) {
                return;
            }
            this.Ei.a(player.getUniqueId(), ((ItemStackBuilder_4)object).getNamespacedID());
            EntityToggleGlideListener.a((Event)entityToggleGlideEvent, player, (ItemStackBuilder_4)object, EntityToggleGlideListener.bb(player), BlockBreakEnum.GLIDE_START);
        } else {
            object = this.Ei.i(player.getUniqueId());
            if (object != null) {
                this.a((Event)entityToggleGlideEvent, player, (Opaque129)object);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void o(PlayerInteractEvent playerInteractEvent) {
        if (this.Ej != null || playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR && playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK || playerInteractEvent.getItem() == null || playerInteractEvent.getItem().getType() != Material.FIREWORK_ROCKET) {
            return;
        }
        RecordOfValue_22 recordOfValue_22 = this.a(playerInteractEvent.getPlayer(), playerInteractEvent.getItem(), (Event)playerInteractEvent);
        if (!recordOfValue_22.mo()) {
            return;
        }
        if (!recordOfValue_22.mp()) {
            playerInteractEvent.setCancelled(true);
            return;
        }
        if (!recordOfValue_22.mq() && playerInteractEvent.getHand() != null) {
            this.a(playerInteractEvent.getPlayer(), playerInteractEvent.getHand(), playerInteractEvent.getItem().clone());
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerItemDamageEvent playerItemDamageEvent) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.ba(playerItemDamageEvent.getPlayer());
        ItemStackBuilder_4 itemStackBuilder_42 = this.Eh.a(playerItemDamageEvent.getItem());
        if (itemStackBuilder_4 == null || itemStackBuilder_42 == null || !itemStackBuilder_4.getNamespacedID().equals(itemStackBuilder_42.getNamespacedID())) {
            return;
        }
        Opaque129 opaque129 = this.Ei.c(playerItemDamageEvent.getPlayer().getUniqueId(), itemStackBuilder_4.getNamespacedID());
        playerItemDamageEvent.setDamage(opaque129 == null ? itemStackBuilder_4.nn().al(playerItemDamageEvent.getDamage()) : opaque129.a(playerItemDamageEvent.getDamage(), itemStackBuilder_4.nn().os()));
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void c(EntityDamageEvent entityDamageEvent) {
        Object object;
        if (entityDamageEvent.getCause() != EntityDamageEvent.DamageCause.FLY_INTO_WALL || !((object = entityDamageEvent.getEntity()) instanceof Player)) {
            return;
        }
        Player player = (Player)object;
        object = this.ba(player);
        if (object == null) {
            return;
        }
        entityDamageEvent.setDamage(((ItemStackBuilder_4)object).nn().n(entityDamageEvent.getDamage()));
        EntityToggleGlideListener.a((Event)entityDamageEvent, player, (ItemStackBuilder_4)object, EntityToggleGlideListener.bb(player), BlockBreakEnum.ELYTRA_COLLISION);
    }

    @EventHandler
    private void b(PlayerDeathEvent playerDeathEvent) {
        this.Ei.i(playerDeathEvent.getEntity().getUniqueId());
    }

    @EventHandler
    private void c(PlayerQuitEvent playerQuitEvent) {
        this.Ei.i(playerQuitEvent.getPlayer().getUniqueId());
    }

    RecordOfValue_22 a(Player player, ItemStack itemStack, Event event) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.ba(player);
        if (itemStackBuilder_4 == null || !player.isGliding()) {
            return RecordOfValue_22.En;
        }
        Opaque129 opaque129 = this.Ei.b(player.getUniqueId(), itemStackBuilder_4.getNamespacedID());
        RecordOfNamespacedKey recordOfNamespacedKey = itemStackBuilder_4.nn();
        RecordOfValue_22 recordOfValue_22 = EntityToggleGlideListener.a(recordOfNamespacedKey, opaque129.Er);
        if (!recordOfValue_22.mp()) {
            return recordOfValue_22;
        }
        opaque129.Er = recordOfNamespacedKey.or().fD();
        EntityToggleGlideListener.a(event, player, itemStackBuilder_4, EntityToggleGlideListener.bb(player), BlockBreakEnum.ELYTRA_BOOST);
        return recordOfValue_22;
    }

    static RecordOfValue_22 a(RecordOfNamespacedKey recordOfNamespacedKey, int n) {
        if (!recordOfNamespacedKey.or().ou() || n > 0) {
            return new RecordOfValue_22(true, false, recordOfNamespacedKey.or().mq());
        }
        return new RecordOfValue_22(true, true, recordOfNamespacedKey.or().mq());
    }

    private void a(Player player, EquipmentSlot equipmentSlot, ItemStack itemStack) {
        BukkitTaskBridge.c(() -> {
            ItemStack itemStack2;
            ItemStack itemStack3 = itemStack2 = equipmentSlot == EquipmentSlot.HAND ? player.getInventory().getItemInMainHand() : player.getInventory().getItemInOffHand();
            if (itemStack2.getType().isAir() && itemStack.getAmount() == 1) {
                if (equipmentSlot == EquipmentSlot.HAND) {
                    player.getInventory().setItemInMainHand(itemStack);
                } else {
                    player.getInventory().setItemInOffHand(itemStack);
                }
            } else if (itemStack2.isSimilar(itemStack) && itemStack2.getAmount() == itemStack.getAmount() - 1) {
                itemStack2.setAmount(itemStack2.getAmount() + 1);
            }
        }, 1L);
    }

    private void bV() {
        Iterator iterator = this.Ei.Eo.entrySet().iterator();
        while (iterator.hasNext()) {
            ItemStackBuilder_4 itemStackBuilder_4;
            Map.Entry entry = iterator.next();
            Player player = Bukkit.getPlayer((UUID)((UUID)entry.getKey()));
            Opaque129 opaque129 = (Opaque129)entry.getValue();
            ItemStackBuilder_4 itemStackBuilder_42 = itemStackBuilder_4 = player == null ? null : this.ba(player);
            if (player == null || !player.isOnline() || !player.isGliding() || itemStackBuilder_4 == null) {
                iterator.remove();
                if (player == null) continue;
                this.a((Event)new EntityToggleGlideEvent((LivingEntity)player, false), player, opaque129);
                continue;
            }
            if (!itemStackBuilder_4.getNamespacedID().equals(opaque129.Ep)) {
                this.a((Event)new EntityToggleGlideEvent((LivingEntity)player, false), player, opaque129);
                opaque129 = this.Ei.b((UUID)entry.getKey(), itemStackBuilder_4.getNamespacedID());
            }
            ++opaque129.Eq;
            if (opaque129.Er > 0) {
                --opaque129.Er;
            }
            if (!itemStackBuilder_4.nn().ak(opaque129.Eq)) continue;
            iterator.remove();
            player.setGliding(false);
            this.a((Event)new EntityToggleGlideEvent((LivingEntity)player, false), player, opaque129);
        }
    }

    private void a(Event event, Player player, Opaque129 opaque129) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.Eh.b(opaque129.Ep, false);
        if (itemStackBuilder_4 != null) {
            EntityToggleGlideListener.a(event, player, itemStackBuilder_4, EntityToggleGlideListener.bb(player), BlockBreakEnum.GLIDE_STOP);
        }
    }

    private static void a(Event event, Player player, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, BlockBreakEnum blockBreakEnum) {
        itemStackBuilder_4.a((LivingEntity)player, blockBreakEnum, (Object builder_14) -> builder_14.a(event, itemStackBuilder_4, itemStack, player));
    }

    @Nullable
    private ItemStackBuilder_4 ba(Player player) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.Eh.a(EntityToggleGlideListener.bb(player));
        return itemStackBuilder_4 != null && itemStackBuilder_4.nn() != null ? itemStackBuilder_4 : null;
    }

    private static ItemStack bb(Player player) {
        ItemStack itemStack = player.getInventory().getChestplate();
        return itemStack == null ? new ItemStack(Material.AIR) : itemStack;
    }
}
