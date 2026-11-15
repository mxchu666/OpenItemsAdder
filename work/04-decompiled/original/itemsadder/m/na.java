package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.aqp;
import itemsadder.m.bbs;
import itemsadder.m.bcn;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.bfo;
import itemsadder.m.bfp;
import itemsadder.m.d;
import itemsadder.m.mx;
import itemsadder.m.my;
import itemsadder.m.qf;
import itemsadder.m.qg;
import itemsadder.m.qh;
import itemsadder.m.qm;
import itemsadder.m.rj;
import itemsadder.m.rk;
import itemsadder.m.rl;
import itemsadder.m.w;
import itemsadder.m.zi;
import itemsadder.m.zj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class na
implements ai {
    private static na Cl;
    final d Cm;
    public final HashMap Cn = new HashMap();
    public final mx Co = new mx();

    @Nullable
    public static na md() {
        return Cl;
    }

    public na(Plugin plugin, d d2) {
        if (Cl != null) {
            na.Cl.Co.mc();
            Cl.unregister();
        }
        Cl = this;
        this.Cm = d2;
        bev.a(this, plugin);
        bcp.a(bukkitRunnable -> {
            for (Map.Entry entry : this.Co.Ch.entrySet()) {
                Iterator iterator = ((HashMap)entry.getValue()).entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry2 = iterator.next();
                    rk rk2 = (rk)entry2.getValue();
                    qm qm2 = rk2.Ij;
                    long l = rk2.Ii;
                    if (qm2 == null) continue;
                    for (Map.Entry entry3 : qm2.Gd.Ce.entrySet()) {
                        if (System.currentTimeMillis() - l <= (Long)entry3.getValue()) continue;
                        iterator.remove();
                    }
                }
            }
        }, 12000L, 24000L);
    }

    public void me() {
        if (ae.ff && this.Cm.B()) {
            bcp.a(bukkitRunnable -> {
                if (this.Co.Ch.isEmpty()) {
                    return;
                }
                for (Map.Entry entry : this.Co.Ch.entrySet()) {
                    Player player;
                    HashMap hashMap = (HashMap)entry.getValue();
                    if (hashMap.isEmpty() || (player = Bukkit.getPlayer((UUID)((UUID)entry.getKey()))) == null || !player.isOnline()) continue;
                    for (Map.Entry entry2 : hashMap.entrySet()) {
                        qm qm2;
                        rk rk2 = (rk)entry2.getValue();
                        if (!rk2.oj() || (qm2 = rk2.Ij) == null || !qm2.mV()) continue;
                        boolean bl = this.b((LivingEntity)player, qm2);
                        rk2.a(!bl, player);
                    }
                }
            }, 1L, (long)ae.fg);
        }
    }

    public void a(my my2) {
        List list = this.Cn.getOrDefault(my2.Cj, new ArrayList());
        list.add(my2);
        this.Cn.put(my2.Cj, list);
    }

    void a(Event event, qm qm2, ItemStack itemStack) {
        if (qm2 == null) {
            return;
        }
        List list = (List)this.Cn.get(event.getClass());
        if (list == null) {
            return;
        }
        for (my my2 : list) {
            my2.Ck.execute(event, qm2, itemStack);
        }
    }

    public boolean a(LivingEntity livingEntity, qm qm2) {
        boolean bl;
        if (!qm2.mV()) {
            return true;
        }
        Player player = (Player)livingEntity;
        rj rj2 = qm2.nj();
        if (rj2 == null) {
            return false;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        rk rk2 = (rk)bcn.a(this.Co.Ch, (Object)livingEntity.getUniqueId(), (Object)qm2.Gi, (T n) -> {
            atomicBoolean.set(true);
            return new rk(qm2, this.Cm.ao.d(player, rj2.Id));
        });
        boolean bl2 = bl = atomicBoolean.get() || rk2.lt();
        if (bl) {
            rk2.oi();
            if (rj2.Ic == rl.VANILLA) {
                aqp.uW().c(player, qm2, (int)(qm2.mU() / 50L));
            }
        }
        rk2.ol();
        rk2.a(true, player);
        return bl;
    }

    public boolean b(LivingEntity livingEntity, qm qm2) {
        if (!qm2.mV()) {
            return true;
        }
        Player player = (Player)livingEntity;
        rj rj2 = qm2.nj();
        if (rj2 == null) {
            return false;
        }
        boolean bl = true;
        rk rk2 = (rk)bcn.a(this.Co.Ch, (Object)livingEntity.getUniqueId(), (Object)qm2.Gi, (T n) -> new rk(qm2, this.Cm.ao.d(player, rj2.Id)));
        if (!rk2.lt()) {
            if (qm2.nk() == rl.TITLE && rk2.In >= 80) {
                return true;
            }
            bl = false;
            long l = rk2.oe();
            switch (rj2.Ic) {
                case HIDDEN: 
                case VANILLA: {
                    break;
                }
                case TITLE: {
                    if (!rk2.og()) break;
                    player.sendTitle(" ", Main.PQ.ir("please-wait-events-cooldown").replace("{interval}", rk2.of()), rk2.oh() ? 15 : 0, 25, 0);
                    break;
                }
                case HUD: {
                    float f2 = rj2.Ie.floatValue() - (float)l * rj2.Ie.floatValue() / (float)qm2.mU();
                    rk2.a(f2, player);
                    break;
                }
                case BOSSBAR: {
                    float f3 = 1.0f - (float)l / (float)qm2.mU();
                    BossBar bossBar = this.Co.Ci.computeIfAbsent(player, player2 -> {
                        BossBar bossBar = Bukkit.createBossBar((String)Main.PQ.ir("cooldown-bossbar-title"), (BarColor)rj2.ob(), (BarStyle)rj2.oc(), (BarFlag[])new BarFlag[0]);
                        bossBar.setProgress((double)f3);
                        bossBar.addPlayer(player);
                        return bossBar;
                    });
                    bossBar.setProgress((double)f3);
                }
            }
            rk2.ok();
        }
        return bl;
    }

    static void j(PlayerInteractEvent playerInteractEvent) {
        if ((playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || playerInteractEvent.getAction() == Action.LEFT_CLICK_AIR) && playerInteractEvent.useInteractedBlock() == Event.Result.DENY && playerInteractEvent.useItemInHand() != Event.Result.DENY) {
            playerInteractEvent.setUseInteractedBlock(Event.Result.DEFAULT);
        }
    }

    private boolean k(PlayerInteractEvent playerInteractEvent) {
        return playerInteractEvent.useInteractedBlock() == Event.Result.DENY && playerInteractEvent.useItemInHand() == Event.Result.DENY;
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    void l(PlayerInteractEvent playerInteractEvent) {
        if (this.k(playerInteractEvent)) {
            return;
        }
        ItemStack itemStack = playerInteractEvent.getItem();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        na.j(playerInteractEvent);
        this.a((Event)playerInteractEvent, qm2, itemStack);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void d(PlayerAnimationEvent playerAnimationEvent) {
        if (playerAnimationEvent.getAnimationType() == PlayerAnimationType.ARM_SWING) {
            if (w.bN.i(playerAnimationEvent.getPlayer())) {
                return;
            }
            if (w.bN.k(playerAnimationEvent.getPlayer())) {
                return;
            }
            if (w.bN.l(playerAnimationEvent.getPlayer())) {
                return;
            }
            ItemStack itemStack = playerAnimationEvent.getPlayer().getItemInHand();
            qm qm2 = this.Cm.a(itemStack);
            if (qm2 == null) {
                return;
            }
            bfo bfo2 = new bfo(playerAnimationEvent.getPlayer(), 6.2);
            if (bfo2.a(bfp.ENTITY) && bfo2.EE()) {
                if (bfo2.ED().getLocation().distance(playerAnimationEvent.getPlayer().getLocation()) < 3.3) {
                    return;
                }
                PlayerInteractEvent playerInteractEvent = new PlayerInteractEvent(playerAnimationEvent.getPlayer(), Action.LEFT_CLICK_AIR, playerAnimationEvent.getPlayer().getItemInHand(), null, playerAnimationEvent.getPlayer().getFacing());
                this.a((Event)playerInteractEvent, qm2, itemStack);
            }
        }
    }

    @EventHandler(ignoreCancelled=true)
    void a(PlayerEditBookEvent playerEditBookEvent) {
        ItemStack itemStack = playerEditBookEvent.getPlayer().getInventory().getItem(playerEditBookEvent.getSlot());
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)playerEditBookEvent, qm2, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void b(EntityShootBowEvent entityShootBowEvent) {
        if (entityShootBowEvent.getEntity().getType() != EntityType.PLAYER) {
            return;
        }
        ItemStack itemStack = entityShootBowEvent.getBow();
        qh qh2 = (qh)this.Cm.a(qh.class, itemStack);
        if (qh2 == null) {
            return;
        }
        this.a((Event)entityShootBowEvent, (qm)qh2, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void a(zi zi2) {
        ItemStack itemStack = zi2.sy();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)zi2, qm2, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void a(ProjectileLaunchEvent projectileLaunchEvent) {
        if (!(projectileLaunchEvent.getEntity().getShooter() instanceof Player)) {
            return;
        }
        ItemStack itemStack = bbs.c(projectileLaunchEvent.getEntity());
        if (itemStack == null) {
            return;
        }
        qm qm2 = this.Cm.a(itemStack);
        this.a((Event)projectileLaunchEvent, qm2, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void a(PlayerFishEvent playerFishEvent) {
        ItemStack itemStack = this.Cm.a(playerFishEvent.getPlayer(), Material.FISHING_ROD);
        if (itemStack == null) {
            return;
        }
        qm qm2 = this.Cm.a(itemStack);
        this.a((Event)playerFishEvent, qm2, itemStack);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void b(PlayerItemConsumeEvent playerItemConsumeEvent) {
        ItemStack itemStack = playerItemConsumeEvent.getItem();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)playerItemConsumeEvent, qm2, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void b(FoodLevelChangeEvent foodLevelChangeEvent) {
        if (bev.c(foodLevelChangeEvent)) {
            return;
        }
        if (foodLevelChangeEvent.getItem() == null) {
            return;
        }
        ItemStack itemStack = foodLevelChangeEvent.getItem();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)foodLevelChangeEvent, qm2, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void e(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        Player player;
        ItemStack itemStack;
        qm qm2;
        if (bev.h(entityDamageByEntityEvent)) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof Player && (qm2 = this.Cm.a(itemStack = (player = (Player)entityDamageByEntityEvent.getDamager()).getInventory().getItemInMainHand())) != null) {
            this.a((Event)entityDamageByEntityEvent, qm2, itemStack);
        }
        if (entityDamageByEntityEvent.getEntity() instanceof Player) {
            ItemStack itemStack2;
            Object object2;
            player = (Player)entityDamageByEntityEvent.getEntity();
            for (Object object2 : bbs.aAq) {
                ItemStack itemStack3 = player.getInventory().getItem(object2);
                qm qm3 = this.Cm.a(itemStack3);
                if (qm3 == null) continue;
                this.a(qg.a(player, entityDamageByEntityEvent.getDamager(), true, object2), qm3, itemStack3);
            }
            itemStack = player.getInventory().getItemInMainHand();
            qm qm4 = this.Cm.a(itemStack);
            if (qm4 != null) {
                this.a(qg.a(player, entityDamageByEntityEvent.getDamager(), false, EquipmentSlot.HAND), qm4, itemStack);
            }
            if ((object2 = this.Cm.a(itemStack2 = player.getInventory().getItemInOffHand())) != null) {
                this.a(qg.a(player, entityDamageByEntityEvent.getDamager(), false, EquipmentSlot.OFF_HAND), (qm)object2, itemStack2);
            }
        }
    }

    @EventHandler(ignoreCancelled=true)
    void c(PlayerInteractEntityEvent playerInteractEntityEvent) {
        Player player = playerInteractEntityEvent.getPlayer();
        ItemStack itemStack = playerInteractEntityEvent.getHand() == EquipmentSlot.HAND ? player.getInventory().getItemInMainHand() : player.getInventory().getItemInOffHand();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)playerInteractEntityEvent, qm2, itemStack);
    }

    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    void f(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        if (blockBreakEvent.getPlayer().getGameMode() == GameMode.CREATIVE) {
            return;
        }
        ItemStack itemStack = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)blockBreakEvent, qm2, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void d(PlayerDropItemEvent playerDropItemEvent) {
        ItemStack itemStack = playerDropItemEvent.getItemDrop().getItemStack();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)playerDropItemEvent, qm2, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void a(zj zj2) {
        ItemStack itemStack = zj2.getItemStack();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        bcp.i(() -> this.a((Event)zj2, qm2, itemStack));
    }

    @EventHandler(ignoreCancelled=true)
    void a(PlayerPickupItemEvent playerPickupItemEvent) {
        ItemStack itemStack = playerPickupItemEvent.getItem().getItemStack();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)playerPickupItemEvent, qm2, itemStack);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void h(BlockPlaceEvent blockPlaceEvent) {
        if (!blockPlaceEvent.canBuild() || bev.k(blockPlaceEvent)) {
            return;
        }
        ItemStack itemStack = blockPlaceEvent.getItemInHand();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)blockPlaceEvent, qm2, itemStack);
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void a(BlockMultiPlaceEvent blockMultiPlaceEvent) {
        if (blockMultiPlaceEvent.isCancelled() || !blockMultiPlaceEvent.canBuild()) {
            return;
        }
        ItemStack itemStack = blockMultiPlaceEvent.getItemInHand();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)blockMultiPlaceEvent, qm2, itemStack);
    }

    @EventHandler
    void e(InventoryClickEvent inventoryClickEvent) {
        ItemStack itemStack;
        qm qm2;
        if (inventoryClickEvent.getCurrentItem() == null || inventoryClickEvent.getCurrentItem().getType() == Material.AIR) {
            qm2 = this.Cm.a(inventoryClickEvent.getCursor());
            itemStack = inventoryClickEvent.getCursor();
        } else {
            qm2 = this.Cm.a(inventoryClickEvent.getCurrentItem());
            itemStack = inventoryClickEvent.getCurrentItem();
        }
        if (qm2 != null) {
            this.a((Event)inventoryClickEvent, qm2, itemStack);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void b(PlayerBucketEmptyEvent playerBucketEmptyEvent) {
        ItemStack itemStack = null;
        if (playerBucketEmptyEvent.getPlayer().getInventory().getItemInMainHand().getType() == Material.WATER_BUCKET) {
            itemStack = playerBucketEmptyEvent.getPlayer().getInventory().getItemInMainHand();
        } else if (playerBucketEmptyEvent.getPlayer().getInventory().getItemInOffHand().getType() == Material.WATER_BUCKET) {
            itemStack = playerBucketEmptyEvent.getPlayer().getInventory().getItemInOffHand();
        }
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)playerBucketEmptyEvent, qm2, itemStack);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void b(PlayerBucketFillEvent playerBucketFillEvent) {
        ItemStack itemStack = null;
        if (playerBucketFillEvent.getPlayer().getInventory().getItemInMainHand().getType() == Material.BUCKET) {
            itemStack = playerBucketFillEvent.getPlayer().getInventory().getItemInMainHand();
        } else if (playerBucketFillEvent.getPlayer().getInventory().getItemInOffHand().getType() == Material.BUCKET) {
            itemStack = playerBucketFillEvent.getPlayer().getInventory().getItemInOffHand();
        }
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)playerBucketFillEvent, qm2, itemStack);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void a(PlayerItemBreakEvent playerItemBreakEvent) {
        ItemStack itemStack = playerItemBreakEvent.getBrokenItem();
        qm qm2 = this.Cm.a(itemStack);
        if (qm2 == null) {
            return;
        }
        this.a((Event)playerItemBreakEvent, qm2, itemStack);
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    void b(EntityDeathEvent entityDeathEvent) {
        if (entityDeathEvent.getEntity().getKiller() != null && entityDeathEvent.getEntity().getLastDamageCause() != null && (entityDeathEvent.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK || entityDeathEvent.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
            Player player = entityDeathEvent.getEntity().getKiller();
            ItemStack itemStack = player.getItemInHand();
            qm qm2 = this.Cm.a(itemStack);
            if (qm2 == null) {
                return;
            }
            this.a(new qf(player, entityDeathEvent.getEntity()), qm2, itemStack);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void d(PlayerQuitEvent playerQuitEvent) {
        this.Co.aU(playerQuitEvent.getPlayer());
    }
}
