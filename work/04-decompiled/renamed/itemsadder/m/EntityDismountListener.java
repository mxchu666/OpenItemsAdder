package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Core.OtherPlugins.Citizens.CitizensHook;
import dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.MythicMobsHook;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.Events.CustomEntityDeathEvent;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.EntitiesLoadListener;
import itemsadder.m.EntityBridgeImpl;
import itemsadder.m.EntityEquipmentPacketListener;
import itemsadder.m.EntityHolder;
import itemsadder.m.InteractEnum;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LivingEntityArmorStandHolder;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MountPacketListener;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerBukkitTaskHolder;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.RecordOfValue_4;
import itemsadder.m.RespawnPacketListener;
import itemsadder.m.SoundCategoryBridge_2;
import itemsadder.m.SteerVehiclePacketListener;
import itemsadder.m.UseEntityPacketListener;
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

public class EntityDismountListener
implements Listener {
    public void register(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents((Listener)this, plugin);
        Bukkit.getPluginManager().registerEvents((Listener)new EntitiesLoadListener(), plugin);
        PacketListenerRegistry.b((PacketListener)new UseEntityPacketListener());
        if (Version.isOlderThan((Version)Version.v1_21_3)) {
            PacketListenerRegistry.b((PacketListener)new SteerVehiclePacketListener());
        }
        PacketListenerRegistry.b((PacketListener)new MountPacketListener());
        PacketListenerRegistry.b((PacketListener)new RespawnPacketListener());
        PacketListenerRegistry.b((PacketListener)new EntityEquipmentPacketListener());
    }

    private static void a(Player player, int n) {
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().U(player);
        if (livingEntityBuilder == null) {
            return;
        }
        BukkitTaskBridge.a(livingEntityBuilder::dY, n != 0, (long)n);
    }

    public static void a(ChunkEvent chunkEvent, boolean bl) {
        if (bl && !LocationBridge_2.B(chunkEvent.getChunk())) {
            return;
        }
        for (Entity entity : chunkEvent.getChunk().getEntities()) {
            EntityDismountListener.l(entity);
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
            LivingEntityRegistry.db().a((LivingEntity)entity);
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void b(EntityDismountEvent entityDismountEvent) {
        if (entityDismountEvent.getEntity() instanceof LivingEntity && LivingEntityRegistry.db().b((LivingEntity)entityDismountEvent.getEntity())) {
            entityDismountEvent.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void c(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        Object object;
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().e(entityDamageByEntityEvent.getEntity().getUniqueId());
        if (livingEntityBuilder != null) {
            Object object2;
            if (livingEntityBuilder.mG && entityDamageByEntityEvent.getDamager() instanceof Player && !livingEntityBuilder.Z((Player)entityDamageByEntityEvent.getDamager())) {
                entityDamageByEntityEvent.setCancelled(true);
                return;
            }
            livingEntityBuilder.a(entityDamageByEntityEvent.getEntity(), InteractEnum.ATTACKED, entityBridgeImpl -> entityBridgeImpl.a(entityDamageByEntityEvent, livingEntityBuilder));
            if (livingEntityBuilder.eg() instanceof Player && (object = LivingEntityRegistry.db().V((Player)livingEntityBuilder.eg())) != null && ((PlayerBukkitTaskHolder)object).renderer.eQ() != null && ((PlayerBukkitTaskHolder)object).renderer.eQ().oR) {
                LivingEntityRegistry.db().X((Player)livingEntityBuilder.eg());
            }
            if ((object2 = entityDamageByEntityEvent.getDamager()) instanceof Player) {
                object = (Player)object2;
                object2 = LivingEntityRegistry.db().V((Player)object);
                if (object2 != null && object2.renderer.eQ() != null && object2.renderer.eQ().oS) {
                    LivingEntityRegistry.db().X((Player)object);
                    return;
                }
                if (LivingEntityRegistry.db().b((LivingEntity)object, livingEntityBuilder)) {
                    entityDamageByEntityEvent.setCancelled(true);
                    return;
                }
            }
            livingEntityBuilder.eq();
        }
        if ((object = LivingEntityRegistry.db().e(entityDamageByEntityEvent.getDamager().getUniqueId())) != null) {
            ((LivingEntityBuilder)object).a(entityDamageByEntityEvent.getDamager(), InteractEnum.ATTACK, arg_0 -> EntityDismountListener.a(entityDamageByEntityEvent, (LivingEntityBuilder)object, arg_0));
            ((LivingEntityBuilder)object).a(((LivingEntityBuilder)object).fb(), 0);
            ((LivingEntityBuilder)object).eT();
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void a(EntityDamageEvent entityDamageEvent) {
        if (entityDamageEvent instanceof EntityDamageByEntityEvent) {
            return;
        }
        if (entityDamageEvent.getEntity().getType() == EntityType.PLAYER) {
            if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION && entityDamageEvent.getEntity() instanceof Player && LivingEntityRegistry.db().c((LivingEntity)entityDamageEvent.getEntity()) != null) {
                entityDamageEvent.setCancelled(true);
            }
            return;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().e(entityDamageEvent.getEntity().getUniqueId());
        if (livingEntityBuilder == null) {
            return;
        }
        livingEntityBuilder.a(entityDamageEvent.getEntity(), InteractEnum.DAMAGED, entityBridgeImpl -> entityBridgeImpl.a(entityDamageEvent, livingEntityBuilder));
        boolean bl = entityDamageEvent.getCause().equals((Object)EntityDamageEvent.DamageCause.FIRE) || entityDamageEvent.getCause().equals((Object)EntityDamageEvent.DamageCause.FIRE_TICK) || entityDamageEvent.getCause().equals((Object)EntityDamageEvent.DamageCause.HOT_FLOOR) || entityDamageEvent.getCause().equals((Object)EntityDamageEvent.DamageCause.LAVA);
        livingEntityBuilder.playDamageEffect(bl);
    }

    @EventHandler(ignoreCancelled=true)
    private void b(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        BukkitTaskBridge.c(() -> {
            if (!player.isOnline()) {
                return;
            }
            LivingEntityRegistry.db().Q(playerJoinEvent.getPlayer());
        }, 50L);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PlayerQuitEvent playerQuitEvent) {
        LivingEntityRegistry.db().X(playerQuitEvent.getPlayer());
        LivingEntityRegistry.db().removePassenger((LivingEntity)playerQuitEvent.getPlayer());
        LivingEntityRegistry.db().R(playerQuitEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PlayerGameModeChangeEvent playerGameModeChangeEvent) {
        LivingEntityRegistry.db().X(playerGameModeChangeEvent.getPlayer());
    }

    @EventHandler
    private void b(PlayerChangedWorldEvent playerChangedWorldEvent) {
        LivingEntityRegistry.db().removePassenger((LivingEntity)playerChangedWorldEvent.getPlayer());
        LivingEntityRegistry.db().X(playerChangedWorldEvent.getPlayer());
        LivingEntityRegistry.db().a(playerChangedWorldEvent.getFrom(), playerChangedWorldEvent.getPlayer());
        LivingEntityRegistry.db().S(playerChangedWorldEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true)
    private void a(PlayerTeleportEvent playerTeleportEvent) {
        if (!playerTeleportEvent.getFrom().getWorld().equals((Object)playerTeleportEvent.getTo().getWorld())) {
            return;
        }
        if (PlayerHolder_4.d(playerTeleportEvent)) {
            return;
        }
        LivingEntityRegistry.db().removePassenger((LivingEntity)playerTeleportEvent.getPlayer());
        LivingEntityRegistry.db().X(playerTeleportEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true)
    private void a(PlayerPortalEvent playerPortalEvent) {
        LivingEntityArmorStandHolder livingEntityArmorStandHolder = LivingEntityRegistry.db().c((LivingEntity)playerPortalEvent.getPlayer());
        if (livingEntityArmorStandHolder != null) {
            playerPortalEvent.setCancelled(true);
        }
    }

    @EventHandler
    private void a(EntityPortalEvent entityPortalEvent) {
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().h(entityPortalEvent.getEntity());
        if (livingEntityBuilder != null) {
            livingEntityBuilder.en();
        }
    }

    @EventHandler
    private void a(EntityPortalExitEvent entityPortalExitEvent) {
        LivingEntityBuilder livingEntityBuilder;
        if (entityPortalExitEvent.getTo() != null && entityPortalExitEvent.getEntity() instanceof LivingEntity && (livingEntityBuilder = LivingEntityRegistry.db().h(entityPortalExitEvent.getEntity())) != null) {
            if (!livingEntityBuilder.mG) {
                livingEntityBuilder.e(livingEntityBuilder.cE());
            }
            livingEntityBuilder.el();
        }
    }

    @EventHandler
    private void a(EntityDeathEvent entityDeathEvent) {
        LivingEntityBuilder livingEntityBuilder;
        LivingEntity livingEntity = entityDeathEvent.getEntity();
        if (livingEntity.getType() == EntityType.PLAYER) {
            LivingEntityRegistry.db().removePassenger(livingEntity);
        } else if (LivingEntityRegistry.db().f((Entity)livingEntity) && (livingEntityBuilder = LivingEntityRegistry.db().e(livingEntity.getUniqueId())) != null) {
            livingEntityBuilder.a((Entity)livingEntity, InteractEnum.DEATH, entityBridgeImpl -> entityBridgeImpl.a(entityDeathEvent, livingEntityBuilder));
            livingEntityBuilder.eR();
            if (!livingEntityBuilder.my.ob) {
                entityDeathEvent.getDrops().clear();
            }
            livingEntityBuilder.eI();
            livingEntityBuilder.eS();
            livingEntityBuilder.er();
            livingEntityBuilder.a(livingEntityBuilder.fc(), 0, () -> {
                BukkitTaskBridge.i(() -> ListenerBridge.b(new CustomEntityDeathEvent(livingEntity, livingEntityBuilder)));
                LivingEntityRegistry.db().a(livingEntityBuilder, true, true);
            });
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void b(PlayerInteractEntityEvent playerInteractEntityEvent) {
        LivingEntityBuilder livingEntityBuilder;
        Entity entity = playerInteractEntityEvent.getRightClicked();
        if (LivingEntityRegistry.db().f(entity) && (livingEntityBuilder = LivingEntityRegistry.db().e(entity.getUniqueId())) != null) {
            livingEntityBuilder.a(entity, InteractEnum.INTERACT, entityBridgeImpl -> entityBridgeImpl.a(playerInteractEntityEvent, livingEntityBuilder));
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void a(EntityCombustEvent entityCombustEvent) {
        if (entityCombustEvent instanceof EntityCombustByBlockEvent || entityCombustEvent instanceof EntityCombustByEntityEvent) {
            return;
        }
        Entity entity = entityCombustEvent.getEntity();
        if (!EntityHolder.K(entity)) {
            return;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().e(entity.getUniqueId());
        if (livingEntityBuilder != null && !livingEntityBuilder.my.oa) {
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
        if (PlayerJoinListener_9.bN.g(player)) {
            return;
        }
        if (PlayerJoinListener_9.bN.l(player)) {
            return;
        }
        LivingEntityBuilder livingEntityBuilder = LivingEntityRegistry.db().T(player);
        if (livingEntityBuilder == null) {
            return;
        }
        if (LivingEntityRegistry.db().b((LivingEntity)player, livingEntityBuilder)) {
            return;
        }
        PlayerHolder_4.uW().h(player, (Entity)livingEntityBuilder.eg());
        EntityDismountListener.a(player, 0);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void b(PlayerToggleSneakEvent playerToggleSneakEvent) {
        Player player = playerToggleSneakEvent.getPlayer();
        PlayerBukkitTaskHolder playerBukkitTaskHolder = LivingEntityRegistry.db().V(player);
        if (playerBukkitTaskHolder == null) {
            return;
        }
        SoundCategoryBridge_2 soundCategoryBridge_2 = playerBukkitTaskHolder.renderer.eQ();
        if (soundCategoryBridge_2 != null && soundCategoryBridge_2.oQ) {
            LivingEntityRegistry.db().a(playerBukkitTaskHolder);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerItemHeldEvent playerItemHeldEvent) {
        EntityDismountListener.a(playerItemHeldEvent.getPlayer(), 2);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent) {
        EntityDismountListener.a(playerSwapHandItemsEvent.getPlayer(), 5);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(PlayerDropItemEvent playerDropItemEvent) {
        EntityDismountListener.a(playerDropItemEvent.getPlayer(), 0);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getWhoClicked() instanceof Player) {
            EntityDismountListener.a((Player)inventoryClickEvent.getWhoClicked(), 0);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerDeathEvent playerDeathEvent) {
        LivingEntityRegistry.db().X(playerDeathEvent.getEntity());
    }

    @EventHandler
    private void a(ItemsAdderLoadDataEvent itemsAdderLoadDataEvent) {
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (!(entity instanceof LivingEntity)) continue;
                LivingEntityRegistry.db().a((LivingEntity)entity);
            }
        }
        if (Main.PK && MaterialBarColorHolder.dL) {
            CitizensHook.reload();
        }
        if (Main.PP) {
            MythicMobsHook.reload();
        }
        Bukkit.getOnlinePlayers().forEach(player -> {
            LivingEntityRegistry.db().removePassenger((LivingEntity)player);
            LivingEntityRegistry.db().W((Player)player);
            LivingEntityRegistry.db().X((Player)player);
        });
    }

    @EventHandler
    private void a(ChunkUnloadEvent chunkUnloadEvent) {
        for (Entity entity : chunkUnloadEvent.getChunk().getEntities()) {
            if (!(entity instanceof LivingEntity) || entity.getType() == EntityType.PLAYER || entity.getType() == EntityType.ITEM_FRAME || entity.getType() == EntityType.ITEM || !LivingEntityRegistry.db().f(entity)) continue;
            LivingEntityRegistry.db().i(entity);
        }
    }

    @EventHandler
    private void a(WorldLoadEvent worldLoadEvent) {
        for (Entity entity : worldLoadEvent.getWorld().getEntities()) {
            EntityDismountListener.l(entity);
        }
    }

    @EventHandler
    private void b(WorldUnloadEvent worldUnloadEvent) {
        LivingEntityRegistry.db().a(worldUnloadEvent.getWorld());
    }

    private static /* synthetic */ RecordOfValue_4 a(EntityDamageByEntityEvent entityDamageByEntityEvent, LivingEntityBuilder livingEntityBuilder, EntityBridgeImpl entityBridgeImpl) {
        return entityBridgeImpl.a(entityDamageByEntityEvent, livingEntityBuilder);
    }
}
