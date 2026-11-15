package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.pj;
import itemsadder.m.pk;
import itemsadder.m.pl;
import itemsadder.m.pt;
import itemsadder.m.qm;
import itemsadder.m.rm;
import itemsadder.m.zw;
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

public final class pi
implements ai {
    private final d Eh;
    final pk Ei = new pk();
    @Nullable
    private final ai Ej;

    public pi(Plugin plugin, d d2) {
        this.Eh = d2;
        bev.a(this, plugin);
        this.Ej = this.mn();
        bcp.a(this::bV, 1L);
    }

    @Nullable
    private ai mn() {
        if (!zw.sZ()) {
            return null;
        }
        try {
            return new pt(this);
        }
        catch (LinkageError | RuntimeException throwable) {
            bce.warn("Failed to register Paper Elytra boost compatibility. Falling back to Bukkit interaction handling. " + String.valueOf(throwable));
            return null;
        }
    }

    @Override
    public void unregister() {
        this.Ei.clear();
        ai.a(this.Ej);
        ai.super.unregister();
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
            this.Ei.a(player.getUniqueId(), ((qm)object).getNamespacedID());
            pi.a((Event)entityToggleGlideEvent, player, (qm)object, pi.bb(player), jj.GLIDE_START);
        } else {
            object = this.Ei.i(player.getUniqueId());
            if (object != null) {
                this.a((Event)entityToggleGlideEvent, player, (pl)object);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void o(PlayerInteractEvent playerInteractEvent) {
        if (this.Ej != null || playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR && playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK || playerInteractEvent.getItem() == null || playerInteractEvent.getItem().getType() != Material.FIREWORK_ROCKET) {
            return;
        }
        pj pj2 = this.a(playerInteractEvent.getPlayer(), playerInteractEvent.getItem(), (Event)playerInteractEvent);
        if (!pj2.mo()) {
            return;
        }
        if (!pj2.mp()) {
            playerInteractEvent.setCancelled(true);
            return;
        }
        if (!pj2.mq() && playerInteractEvent.getHand() != null) {
            this.a(playerInteractEvent.getPlayer(), playerInteractEvent.getHand(), playerInteractEvent.getItem().clone());
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerItemDamageEvent playerItemDamageEvent) {
        qm qm2 = this.ba(playerItemDamageEvent.getPlayer());
        qm qm3 = this.Eh.a(playerItemDamageEvent.getItem());
        if (qm2 == null || qm3 == null || !qm2.getNamespacedID().equals(qm3.getNamespacedID())) {
            return;
        }
        pl pl2 = this.Ei.c(playerItemDamageEvent.getPlayer().getUniqueId(), qm2.getNamespacedID());
        playerItemDamageEvent.setDamage(pl2 == null ? qm2.nn().al(playerItemDamageEvent.getDamage()) : pl2.a(playerItemDamageEvent.getDamage(), qm2.nn().os()));
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
        entityDamageEvent.setDamage(((qm)object).nn().n(entityDamageEvent.getDamage()));
        pi.a((Event)entityDamageEvent, player, (qm)object, pi.bb(player), jj.ELYTRA_COLLISION);
    }

    @EventHandler
    private void b(PlayerDeathEvent playerDeathEvent) {
        this.Ei.i(playerDeathEvent.getEntity().getUniqueId());
    }

    @EventHandler
    private void c(PlayerQuitEvent playerQuitEvent) {
        this.Ei.i(playerQuitEvent.getPlayer().getUniqueId());
    }

    pj a(Player player, ItemStack itemStack, Event event) {
        qm qm2 = this.ba(player);
        if (qm2 == null || !player.isGliding()) {
            return pj.En;
        }
        pl pl2 = this.Ei.b(player.getUniqueId(), qm2.getNamespacedID());
        rm rm2 = qm2.nn();
        pj pj2 = pi.a(rm2, pl2.Er);
        if (!pj2.mp()) {
            return pj2;
        }
        pl2.Er = rm2.or().fD();
        pi.a(event, player, qm2, pi.bb(player), jj.ELYTRA_BOOST);
        return pj2;
    }

    static pj a(rm rm2, int n) {
        if (!rm2.or().ou() || n > 0) {
            return new pj(true, false, rm2.or().mq());
        }
        return new pj(true, true, rm2.or().mq());
    }

    private void a(Player player, EquipmentSlot equipmentSlot, ItemStack itemStack) {
        bcp.c(() -> {
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
            qm qm2;
            Map.Entry entry = iterator.next();
            Player player = Bukkit.getPlayer((UUID)((UUID)entry.getKey()));
            pl pl2 = (pl)entry.getValue();
            qm qm3 = qm2 = player == null ? null : this.ba(player);
            if (player == null || !player.isOnline() || !player.isGliding() || qm2 == null) {
                iterator.remove();
                if (player == null) continue;
                this.a((Event)new EntityToggleGlideEvent((LivingEntity)player, false), player, pl2);
                continue;
            }
            if (!qm2.getNamespacedID().equals(pl2.Ep)) {
                this.a((Event)new EntityToggleGlideEvent((LivingEntity)player, false), player, pl2);
                pl2 = this.Ei.b((UUID)entry.getKey(), qm2.getNamespacedID());
            }
            ++pl2.Eq;
            if (pl2.Er > 0) {
                --pl2.Er;
            }
            if (!qm2.nn().ak(pl2.Eq)) continue;
            iterator.remove();
            player.setGliding(false);
            this.a((Event)new EntityToggleGlideEvent((LivingEntity)player, false), player, pl2);
        }
    }

    private void a(Event event, Player player, pl pl2) {
        qm qm2 = this.Eh.b(pl2.Ep, false);
        if (qm2 != null) {
            pi.a(event, player, qm2, pi.bb(player), jj.GLIDE_STOP);
        }
    }

    private static void a(Event event, Player player, qm qm2, ItemStack itemStack, jj jj2) {
        qm2.a((LivingEntity)player, jj2, (Object ou2) -> ou2.a(event, qm2, itemStack, player));
    }

    @Nullable
    private qm ba(Player player) {
        qm qm2 = this.Eh.a(pi.bb(player));
        return qm2 != null && qm2.nn() != null ? qm2 : null;
    }

    private static ItemStack bb(Player player) {
        ItemStack itemStack = player.getInventory().getChestplate();
        return itemStack == null ? new ItemStack(Material.AIR) : itemStack;
    }
}
