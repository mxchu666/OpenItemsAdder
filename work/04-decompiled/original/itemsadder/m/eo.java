package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CitizensHook;
import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.MythicMobsHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomEntityDeathEvent;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import itemsadder.m.ae;
import itemsadder.m.afz;
import itemsadder.m.aow;
import itemsadder.m.aqp;
import itemsadder.m.as;
import itemsadder.m.av;
import itemsadder.m.ax;
import itemsadder.m.bcc;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.cz;
import itemsadder.m.da;
import itemsadder.m.dn;
import itemsadder.m.dt;
import itemsadder.m.ek;
import itemsadder.m.ep;
import itemsadder.m.eq;
import itemsadder.m.er;
import itemsadder.m.es;
import itemsadder.m.et;
import itemsadder.m.eu;
import itemsadder.m.w;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDismountEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.world.ChunkEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.plugin.Plugin;

public class eo
implements Listener {
    public void register(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents((Listener)this, plugin);
        Bukkit.getPluginManager().registerEvents((Listener)new ep(), plugin);
        aow.b((PacketListener)new er());
        if (Version.isOlderThan((Version)Version.v1_21_3)) {
            aow.b((PacketListener)new et());
        }
        aow.b((PacketListener)new es());
        aow.b((PacketListener)new eu());
        aow.b((PacketListener)new eq());
    }

    private static void a(Player player, int n) {
        dn dn2 = da.db().U(player);
        if (dn2 == null) {
            return;
        }
        bcp.a(dn2::dY, n != 0, (long)n);
    }

    public static void a(ChunkEvent chunkEvent, boolean bl) {
        if (bl && !bcc.B(chunkEvent.getChunk())) {
            return;
        }
        for (Entity entity : chunkEvent.getChunk().getEntities()) {
            eo.l(entity);
        }
    }

    private static void l(Entity entity) {
        if (entity instanceof LivingEntity) {
            if (entity instanceof ArmorStand && Objects.equals(entity.getCustomName(), "IA_mount")) {
                entity.remove();
                return;
            }
            if (entity.getType() == EntityType.PLAYER || entity.getType() == EntityType.ITEM_FRAME || entity.getType() == EntityType.ITEM) {
                return;
            }
            da.db().a((LivingEntity)entity);
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void b(EntityDismountEvent entityDismountEvent) {
        if (entityDismountEvent.getEntity() instanceof LivingEntity && da.db().b((LivingEntity)entityDismountEvent.getEntity())) {
            entityDismountEvent.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void c(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        Object object;
        dn dn2 = da.db().e(entityDamageByEntityEvent.getEntity().getUniqueId());
        if (dn2 != null) {
            Object object2;
            if (dn2.mG && entityDamageByEntityEvent.getDamager() instanceof Player && !dn2.Z((Player)entityDamageByEntityEvent.getDamager())) {
                entityDamageByEntityEvent.setCancelled(true);
                return;
            }
            dn2.a(entityDamageByEntityEvent.getEntity(), ax.ATTACKED, as2 -> as2.a(entityDamageByEntityEvent, dn2));
            if (dn2.eg() instanceof Player && (object = da.db().V((Player)dn2.eg())) != null && ((cz)object).renderer.eQ() != null && ((cz)object).renderer.eQ().oR) {
                da.db().X((Player)dn2.eg());
            }
            if ((object2 = entityDamageByEntityEvent.getDamager()) instanceof Player) {
                object = (Player)object2;
                object2 = da.db().V((Player)object);
                if (object2 != null && object2.renderer.eQ() != null && object2.renderer.eQ().oS) {
                    da.db().X((Player)object);
                    return;
                }
                if (da.db().b((LivingEntity)object, dn2)) {
                    entityDamageByEntityEvent.setCancelled(true);
                    return;
                }
            }
            dn2.eq();
        }
        if ((object = da.db().e(entityDamageByEntityEvent.getDamager().getUniqueId())) != null) {
            ((dn)object).a(entityDamageByEntityEvent.getDamager(), ax.ATTACK, arg_0 -> eo.a(entityDamageByEntityEvent, (dn)object, arg_0));
            ((dn)object).a(((dn)object).fb(), 0);
            ((dn)object).eT();
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void a(EntityDamageEvent entityDamageEvent) {
        if (entityDamageEvent instanceof EntityDamageByEntityEvent) {
            return;
        }
        if (entityDamageEvent.getEntity().getType() == EntityType.PLAYER) {
            if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION && entityDamageEvent.getEntity() instanceof Player && da.db().c((LivingEntity)entityDamageEvent.getEntity()) != null) {
                entityDamageEvent.setCancelled(true);
            }
            return;
        }
        dn dn2 = da.db().e(entityDamageEvent.getEntity().getUniqueId());
        if (dn2 == null) {
            return;
        }
        dn2.a(entityDamageEvent.getEntity(), ax.DAMAGED, as2 -> as2.a(entityDamageEvent, dn2));
        boolean bl = entityDamageEvent.getCause().equals((Object)EntityDamageEvent.DamageCause.FIRE) || entityDamageEvent.getCause().equals((Object)EntityDamageEvent.DamageCause.FIRE_TICK) || entityDamageEvent.getCause().equals((Object)EntityDamageEvent.DamageCause.HOT_FLOOR) || entityDamageEvent.getCause().equals((Object)EntityDamageEvent.DamageCause.LAVA);
        dn2.playDamageEffect(bl);
    }

    @EventHandler(ignoreCancelled=true)
    private void b(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        bcp.c(() -> {
            if (!player.isOnline()) {
                return;
            }
            da.db().Q(playerJoinEvent.getPlayer());
        }, 50L);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PlayerQuitEvent playerQuitEvent) {
        da.db().X(playerQuitEvent.getPlayer());
        da.db().removePassenger((LivingEntity)playerQuitEvent.getPlayer());
        da.db().R(playerQuitEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PlayerGameModeChangeEvent playerGameModeChangeEvent) {
        da.db().X(playerGameModeChangeEvent.getPlayer());
    }

    @EventHandler
    private void b(PlayerChangedWorldEvent playerChangedWorldEvent) {
        da.db().removePassenger((LivingEntity)playerChangedWorldEvent.getPlayer());
        da.db().X(playerChangedWorldEvent.getPlayer());
        da.db().a(playerChangedWorldEvent.getFrom(), playerChangedWorldEvent.getPlayer());
        da.db().S(playerChangedWorldEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true)
    private void a(PlayerTeleportEvent playerTeleportEvent) {
        if (!playerTeleportEvent.getFrom().getWorld().equals((Object)playerTeleportEvent.getTo().getWorld())) {
            return;
        }
        if (aqp.d(playerTeleportEvent)) {
            return;
        }
        da.db().removePassenger((LivingEntity)playerTeleportEvent.getPlayer());
        da.db().X(playerTeleportEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true)
    private void a(PlayerPortalEvent playerPortalEvent) {
        ek ek2 = da.db().c((LivingEntity)playerPortalEvent.getPlayer());
        if (ek2 != null) {
            playerPortalEvent.setCancelled(true);
        }
    }

    @EventHandler
    private void a(EntityPortalEvent entityPortalEvent) {
        dn dn2 = da.db().h(entityPortalEvent.getEntity());
        if (dn2 != null) {
            dn2.en();
        }
    }

    @EventHandler
    private void a(EntityPortalExitEvent entityPortalExitEvent) {
        dn dn2;
        if (entityPortalExitEvent.getTo() != null && entityPortalExitEvent.getEntity() instanceof LivingEntity && (dn2 = da.db().h(entityPortalExitEvent.getEntity())) != null) {
            if (!dn2.mG) {
                dn2.e(dn2.cE());
            }
            dn2.el();
        }
    }

    @EventHandler
    private void a(EntityDeathEvent entityDeathEvent) {
        dn dn2;
        LivingEntity livingEntity = entityDeathEvent.getEntity();
        if (livingEntity.getType() == EntityType.PLAYER) {
            da.db().removePassenger(livingEntity);
        } else if (da.db().f((Entity)livingEntity) && (dn2 = da.db().e(livingEntity.getUniqueId())) != null) {
            dn2.a((Entity)livingEntity, ax.DEATH, as2 -> as2.a(entityDeathEvent, dn2));
            dn2.eR();
            if (!dn2.my.ob) {
                entityDeathEvent.getDrops().clear();
            }
            dn2.eI();
            dn2.eS();
            dn2.er();
            dn2.a(dn2.fc(), 0, () -> {
                bcp.i(() -> bev.b(new CustomEntityDeathEvent(livingEntity, dn2)));
                da.db().a(dn2, true, true);
            });
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void b(PlayerInteractEntityEvent playerInteractEntityEvent) {
        dn dn2;
        Entity entity = playerInteractEntityEvent.getRightClicked();
        if (da.db().f(entity) && (dn2 = da.db().e(entity.getUniqueId())) != null) {
            dn2.a(entity, ax.INTERACT, as2 -> as2.a(playerInteractEntityEvent, dn2));
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void a(EntityCombustEvent entityCombustEvent) {
        if (entityCombustEvent instanceof EntityCombustByBlockEvent || entityCombustEvent instanceof EntityCombustByEntityEvent) {
            return;
        }
        Entity entity = entityCombustEvent.getEntity();
        if (!afz.K(entity)) {
            return;
        }
        dn dn2 = da.db().e(entity.getUniqueId());
        if (dn2 != null && !dn2.my.oa) {
            entityCombustEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(PlayerAnimationEvent playerAnimationEvent) {
        if (playerAnimationEvent.getAnimationType() != PlayerAnimationType.ARM_SWING) {
            return;
        }
        Player player = playerAnimationEvent.getPlayer();
        if (player.getOpenInventory().getType() != InventoryType.CRAFTING && player.getOpenInventory().getType() != InventoryType.CREATIVE) {
            return;
        }
        if (player.getGameMode() == GameMode.ADVENTURE || player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        if (w.bN.g(player)) {
            return;
        }
        if (w.bN.l(player)) {
            return;
        }
        dn dn2 = da.db().T(player);
        if (dn2 == null) {
            return;
        }
        if (da.db().b((LivingEntity)player, dn2)) {
            return;
        }
        aqp.uW().h(player, (Entity)dn2.eg());
        eo.a(player, 0);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void b(PlayerToggleSneakEvent playerToggleSneakEvent) {
        Player player = playerToggleSneakEvent.getPlayer();
        cz cz2 = da.db().V(player);
        if (cz2 == null) {
            return;
        }
        dt dt2 = cz2.renderer.eQ();
        if (dt2 != null && dt2.oQ) {
            da.db().a(cz2);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerItemHeldEvent playerItemHeldEvent) {
        eo.a(playerItemHeldEvent.getPlayer(), 2);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent) {
        eo.a(playerSwapHandItemsEvent.getPlayer(), 5);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(PlayerDropItemEvent playerDropItemEvent) {
        eo.a(playerDropItemEvent.getPlayer(), 0);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getWhoClicked() instanceof Player) {
            eo.a((Player)inventoryClickEvent.getWhoClicked(), 0);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerDeathEvent playerDeathEvent) {
        da.db().X(playerDeathEvent.getEntity());
    }

    @EventHandler
    private void a(ItemsAdderLoadDataEvent itemsAdderLoadDataEvent) {
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (!(entity instanceof LivingEntity)) continue;
                da.db().a((LivingEntity)entity);
            }
        }
        if (Main.PK && ae.dL) {
            CitizensHook.reload();
        }
        if (Main.PP) {
            MythicMobsHook.reload();
        }
        Bukkit.getOnlinePlayers().forEach(player -> {
            da.db().removePassenger((LivingEntity)player);
            da.db().W((Player)player);
            da.db().X((Player)player);
        });
    }

    @EventHandler
    private void a(ChunkUnloadEvent chunkUnloadEvent) {
        for (Entity entity : chunkUnloadEvent.getChunk().getEntities()) {
            if (!(entity instanceof LivingEntity) || entity.getType() == EntityType.PLAYER || entity.getType() == EntityType.ITEM_FRAME || entity.getType() == EntityType.ITEM || !da.db().f(entity)) continue;
            da.db().i(entity);
        }
    }

    @EventHandler
    private void a(WorldLoadEvent worldLoadEvent) {
        for (Entity entity : worldLoadEvent.getWorld().getEntities()) {
            eo.l(entity);
        }
    }

    @EventHandler
    private void b(WorldUnloadEvent worldUnloadEvent) {
        da.db().a(worldUnloadEvent.getWorld());
    }

    private static /* synthetic */ av a(EntityDamageByEntityEvent entityDamageByEntityEvent, dn dn2, as as2) {
        return as2.a(entityDamageByEntityEvent, dn2);
    }
}
