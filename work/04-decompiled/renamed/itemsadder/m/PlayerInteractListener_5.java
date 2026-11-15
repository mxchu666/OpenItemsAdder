package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BarColorBarStyleHolder;
import itemsadder.m.BoolDoubleData;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ClassRefData;
import itemsadder.m.EntityAndBlockEnum;
import itemsadder.m.HandlerListItemStackHolder;
import itemsadder.m.HiddenEnum;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackPlayerHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque022;
import itemsadder.m.PlayerBridge_19;
import itemsadder.m.PlayerBridge_25;
import itemsadder.m.PlayerEntityHolder_2;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.PlayerLivingEntityHolder;
import itemsadder.m.PlayerLocationHolder_2;
import itemsadder.m.PluginContract;
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

public class PlayerInteractListener_5
implements PluginContract {
    private static PlayerInteractListener_5 Cl;
    final ItemStackRegistry Cm;
    public final HashMap Cn = new HashMap();
    public final PlayerBridge_19 Co = new PlayerBridge_19();

    @Nullable
    public static PlayerInteractListener_5 md() {
        return Cl;
    }

    public PlayerInteractListener_5(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        if (Cl != null) {
            PlayerInteractListener_5.Cl.Co.mc();
            Cl.unregister();
        }
        Cl = this;
        this.Cm = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        BukkitTaskBridge.a(bukkitRunnable -> {
            for (Map.Entry entry : this.Co.Ch.entrySet()) {
                Iterator iterator = ((HashMap)entry.getValue()).entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry2 = iterator.next();
                    PlayerBridge_25 playerBridge_25 = (PlayerBridge_25)entry2.getValue();
                    ItemStackBuilder_4 itemStackBuilder_4 = playerBridge_25.Ij;
                    long l = playerBridge_25.Ii;
                    if (itemStackBuilder_4 == null) continue;
                    for (Map.Entry entry3 : itemStackBuilder_4.Gd.Ce.entrySet()) {
                        if (System.currentTimeMillis() - l <= (Long)entry3.getValue()) continue;
                        iterator.remove();
                    }
                }
            }
        }, 12000L, 24000L);
    }

    public void me() {
        if (MaterialBarColorHolder.ff && this.Cm.B()) {
            BukkitTaskBridge.a(bukkitRunnable -> {
                if (this.Co.Ch.isEmpty()) {
                    return;
                }
                for (Map.Entry entry : this.Co.Ch.entrySet()) {
                    Player player;
                    HashMap hashMap = (HashMap)entry.getValue();
                    if (hashMap.isEmpty() || (player = Bukkit.getPlayer((UUID)((UUID)entry.getKey()))) == null || !player.isOnline()) continue;
                    for (Map.Entry entry2 : hashMap.entrySet()) {
                        ItemStackBuilder_4 itemStackBuilder_4;
                        PlayerBridge_25 playerBridge_25 = (PlayerBridge_25)entry2.getValue();
                        if (!playerBridge_25.oj() || (itemStackBuilder_4 = playerBridge_25.Ij) == null || !itemStackBuilder_4.mV()) continue;
                        boolean bl = this.b((LivingEntity)player, itemStackBuilder_4);
                        playerBridge_25.a(!bl, player);
                    }
                }
            }, 1L, (long)MaterialBarColorHolder.fg);
        }
    }

    public void a(ClassRefData classRefData) {
        List list = this.Cn.getOrDefault(classRefData.Cj, new ArrayList());
        list.add(classRefData);
        this.Cn.put(classRefData.Cj, list);
    }

    void a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (itemStackBuilder_4 == null) {
            return;
        }
        List list = (List)this.Cn.get(event.getClass());
        if (list == null) {
            return;
        }
        for (ClassRefData classRefData : list) {
            classRefData.Ck.execute(event, itemStackBuilder_4, itemStack);
        }
    }

    public boolean a(LivingEntity livingEntity, ItemStackBuilder_4 itemStackBuilder_4) {
        boolean bl;
        if (!itemStackBuilder_4.mV()) {
            return true;
        }
        Player player = (Player)livingEntity;
        BarColorBarStyleHolder barColorBarStyleHolder = itemStackBuilder_4.nj();
        if (barColorBarStyleHolder == null) {
            return false;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        PlayerBridge_25 playerBridge_25 = (PlayerBridge_25)Opaque022.a(this.Co.Ch, (Object)livingEntity.getUniqueId(), (Object)itemStackBuilder_4.Gi, (T n) -> {
            atomicBoolean.set(true);
            return new PlayerBridge_25(itemStackBuilder_4, this.Cm.ao.d(player, barColorBarStyleHolder.Id));
        });
        boolean bl2 = bl = atomicBoolean.get() || playerBridge_25.lt();
        if (bl) {
            playerBridge_25.oi();
            if (barColorBarStyleHolder.Ic == HiddenEnum.VANILLA) {
                PlayerHolder_4.uW().c(player, itemStackBuilder_4, (int)(itemStackBuilder_4.mU() / 50L));
            }
        }
        playerBridge_25.ol();
        playerBridge_25.a(true, player);
        return bl;
    }

    public boolean b(LivingEntity livingEntity, ItemStackBuilder_4 itemStackBuilder_4) {
        if (!itemStackBuilder_4.mV()) {
            return true;
        }
        Player player = (Player)livingEntity;
        BarColorBarStyleHolder barColorBarStyleHolder = itemStackBuilder_4.nj();
        if (barColorBarStyleHolder == null) {
            return false;
        }
        boolean bl = true;
        PlayerBridge_25 playerBridge_25 = (PlayerBridge_25)Opaque022.a(this.Co.Ch, (Object)livingEntity.getUniqueId(), (Object)itemStackBuilder_4.Gi, (T n) -> new PlayerBridge_25(itemStackBuilder_4, this.Cm.ao.d(player, barColorBarStyleHolder.Id)));
        if (!playerBridge_25.lt()) {
            if (itemStackBuilder_4.nk() == HiddenEnum.TITLE && playerBridge_25.In >= 80) {
                return true;
            }
            bl = false;
            long l = playerBridge_25.oe();
            switch (barColorBarStyleHolder.Ic) {
                case HIDDEN: 
                case VANILLA: {
                    break;
                }
                case TITLE: {
                    if (!playerBridge_25.og()) break;
                    player.sendTitle(" ", Main.PQ.ir("please-wait-events-cooldown").replace("{interval}", playerBridge_25.of()), playerBridge_25.oh() ? 15 : 0, 25, 0);
                    break;
                }
                case HUD: {
                    float f = barColorBarStyleHolder.Ie.floatValue() - (float)l * barColorBarStyleHolder.Ie.floatValue() / (float)itemStackBuilder_4.mU();
                    playerBridge_25.a(f, player);
                    break;
                }
                case BOSSBAR: {
                    float f = 1.0f - (float)l / (float)itemStackBuilder_4.mU();
                    BossBar bossBar = this.Co.Ci.computeIfAbsent(player, player2 -> {
                        BossBar bossBar = Bukkit.createBossBar((String)Main.PQ.ir("cooldown-bossbar-title"), (BarColor)barColorBarStyleHolder.ob(), (BarStyle)barColorBarStyleHolder.oc(), (BarFlag[])new BarFlag[0]);
                        bossBar.setProgress((double)f);
                        bossBar.addPlayer(player);
                        return bossBar;
                    });
                    bossBar.setProgress((double)f);
                }
            }
            playerBridge_25.ok();
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
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        PlayerInteractListener_5.j(playerInteractEvent);
        this.a((Event)playerInteractEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void d(PlayerAnimationEvent playerAnimationEvent) {
        if (playerAnimationEvent.getAnimationType() == PlayerAnimationType.ARM_SWING) {
            if (PlayerJoinListener_9.bN.i(playerAnimationEvent.getPlayer())) {
                return;
            }
            if (PlayerJoinListener_9.bN.k(playerAnimationEvent.getPlayer())) {
                return;
            }
            if (PlayerJoinListener_9.bN.l(playerAnimationEvent.getPlayer())) {
                return;
            }
            ItemStack itemStack = playerAnimationEvent.getPlayer().getItemInHand();
            ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
            if (itemStackBuilder_4 == null) {
                return;
            }
            PlayerLocationHolder_2 playerLocationHolder_2 = new PlayerLocationHolder_2(playerAnimationEvent.getPlayer(), 6.2);
            if (playerLocationHolder_2.a(EntityAndBlockEnum.ENTITY) && playerLocationHolder_2.EE()) {
                if (playerLocationHolder_2.ED().getLocation().distance(playerAnimationEvent.getPlayer().getLocation()) < 3.3) {
                    return;
                }
                PlayerInteractEvent playerInteractEvent = new PlayerInteractEvent(playerAnimationEvent.getPlayer(), Action.LEFT_CLICK_AIR, playerAnimationEvent.getPlayer().getItemInHand(), null, playerAnimationEvent.getPlayer().getFacing());
                this.a((Event)playerInteractEvent, itemStackBuilder_4, itemStack);
            }
        }
    }

    @EventHandler(ignoreCancelled=true)
    void a(PlayerEditBookEvent playerEditBookEvent) {
        ItemStack itemStack = playerEditBookEvent.getPlayer().getInventory().getItem(playerEditBookEvent.getSlot());
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)playerEditBookEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void b(EntityShootBowEvent entityShootBowEvent) {
        if (entityShootBowEvent.getEntity().getType() != EntityType.PLAYER) {
            return;
        }
        ItemStack itemStack = entityShootBowEvent.getBow();
        BoolDoubleData boolDoubleData = (BoolDoubleData)this.Cm.a(BoolDoubleData.class, itemStack);
        if (boolDoubleData == null) {
            return;
        }
        this.a((Event)entityShootBowEvent, (ItemStackBuilder_4)boolDoubleData, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void a(HandlerListItemStackHolder handlerListItemStackHolder) {
        ItemStack itemStack = handlerListItemStackHolder.sy();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)handlerListItemStackHolder, itemStackBuilder_4, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void a(ProjectileLaunchEvent projectileLaunchEvent) {
        if (!(projectileLaunchEvent.getEntity().getShooter() instanceof Player)) {
            return;
        }
        ItemStack itemStack = ItemStackBridge_2.c(projectileLaunchEvent.getEntity());
        if (itemStack == null) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        this.a((Event)projectileLaunchEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void a(PlayerFishEvent playerFishEvent) {
        ItemStack itemStack = this.Cm.a(playerFishEvent.getPlayer(), Material.FISHING_ROD);
        if (itemStack == null) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        this.a((Event)playerFishEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void b(PlayerItemConsumeEvent playerItemConsumeEvent) {
        ItemStack itemStack = playerItemConsumeEvent.getItem();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)playerItemConsumeEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void b(FoodLevelChangeEvent foodLevelChangeEvent) {
        if (ListenerBridge.c(foodLevelChangeEvent)) {
            return;
        }
        if (foodLevelChangeEvent.getItem() == null) {
            return;
        }
        ItemStack itemStack = foodLevelChangeEvent.getItem();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)foodLevelChangeEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void e(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        Player player;
        ItemStack itemStack;
        ItemStackBuilder_4 itemStackBuilder_4;
        if (ListenerBridge.h(entityDamageByEntityEvent)) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof Player && (itemStackBuilder_4 = this.Cm.a(itemStack = (player = (Player)entityDamageByEntityEvent.getDamager()).getInventory().getItemInMainHand())) != null) {
            this.a((Event)entityDamageByEntityEvent, itemStackBuilder_4, itemStack);
        }
        if (entityDamageByEntityEvent.getEntity() instanceof Player) {
            ItemStack itemStack2;
            Object object2;
            player = (Player)entityDamageByEntityEvent.getEntity();
            for (Object object2 : ItemStackBridge_2.aAq) {
                ItemStack itemStack3 = player.getInventory().getItem(object2);
                ItemStackBuilder_4 itemStackBuilder_42 = this.Cm.a(itemStack3);
                if (itemStackBuilder_42 == null) continue;
                this.a(PlayerEntityHolder_2.a(player, entityDamageByEntityEvent.getDamager(), true, object2), itemStackBuilder_42, itemStack3);
            }
            itemStack = player.getInventory().getItemInMainHand();
            ItemStackBuilder_4 itemStackBuilder_43 = this.Cm.a(itemStack);
            if (itemStackBuilder_43 != null) {
                this.a(PlayerEntityHolder_2.a(player, entityDamageByEntityEvent.getDamager(), false, EquipmentSlot.HAND), itemStackBuilder_43, itemStack);
            }
            if ((object2 = this.Cm.a(itemStack2 = player.getInventory().getItemInOffHand())) != null) {
                this.a(PlayerEntityHolder_2.a(player, entityDamageByEntityEvent.getDamager(), false, EquipmentSlot.OFF_HAND), (ItemStackBuilder_4)object2, itemStack2);
            }
        }
    }

    @EventHandler(ignoreCancelled=true)
    void c(PlayerInteractEntityEvent playerInteractEntityEvent) {
        Player player = playerInteractEntityEvent.getPlayer();
        ItemStack itemStack = playerInteractEntityEvent.getHand() == EquipmentSlot.HAND ? player.getInventory().getItemInMainHand() : player.getInventory().getItemInOffHand();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)playerInteractEntityEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    void f(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        if (blockBreakEvent.getPlayer().getGameMode() == GameMode.CREATIVE) {
            return;
        }
        ItemStack itemStack = blockBreakEvent.getPlayer().getInventory().getItemInMainHand();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)blockBreakEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void d(PlayerDropItemEvent playerDropItemEvent) {
        ItemStack itemStack = playerDropItemEvent.getItemDrop().getItemStack();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)playerDropItemEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(ignoreCancelled=true)
    void a(ItemStackPlayerHolder itemStackPlayerHolder) {
        ItemStack itemStack = itemStackPlayerHolder.getItemStack();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        BukkitTaskBridge.i(() -> this.a((Event)itemStackPlayerHolder, itemStackBuilder_4, itemStack));
    }

    @EventHandler(ignoreCancelled=true)
    void a(PlayerPickupItemEvent playerPickupItemEvent) {
        ItemStack itemStack = playerPickupItemEvent.getItem().getItemStack();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)playerPickupItemEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    void h(BlockPlaceEvent blockPlaceEvent) {
        if (!blockPlaceEvent.canBuild() || ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        ItemStack itemStack = blockPlaceEvent.getItemInHand();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)blockPlaceEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void a(BlockMultiPlaceEvent blockMultiPlaceEvent) {
        if (blockMultiPlaceEvent.isCancelled() || !blockMultiPlaceEvent.canBuild()) {
            return;
        }
        ItemStack itemStack = blockMultiPlaceEvent.getItemInHand();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)blockMultiPlaceEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler
    void e(InventoryClickEvent inventoryClickEvent) {
        ItemStack itemStack;
        ItemStackBuilder_4 itemStackBuilder_4;
        if (inventoryClickEvent.getCurrentItem() == null || inventoryClickEvent.getCurrentItem().getType() == Material.AIR) {
            itemStackBuilder_4 = this.Cm.a(inventoryClickEvent.getCursor());
            itemStack = inventoryClickEvent.getCursor();
        } else {
            itemStackBuilder_4 = this.Cm.a(inventoryClickEvent.getCurrentItem());
            itemStack = inventoryClickEvent.getCurrentItem();
        }
        if (itemStackBuilder_4 != null) {
            this.a((Event)inventoryClickEvent, itemStackBuilder_4, itemStack);
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
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)playerBucketEmptyEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void b(PlayerBucketFillEvent playerBucketFillEvent) {
        ItemStack itemStack = null;
        if (playerBucketFillEvent.getPlayer().getInventory().getItemInMainHand().getType() == Material.BUCKET) {
            itemStack = playerBucketFillEvent.getPlayer().getInventory().getItemInMainHand();
        } else if (playerBucketFillEvent.getPlayer().getInventory().getItemInOffHand().getType() == Material.BUCKET) {
            itemStack = playerBucketFillEvent.getPlayer().getInventory().getItemInOffHand();
        }
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)playerBucketFillEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void a(PlayerItemBreakEvent playerItemBreakEvent) {
        ItemStack itemStack = playerItemBreakEvent.getBrokenItem();
        ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        this.a((Event)playerItemBreakEvent, itemStackBuilder_4, itemStack);
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    void b(EntityDeathEvent entityDeathEvent) {
        if (entityDeathEvent.getEntity().getKiller() != null && entityDeathEvent.getEntity().getLastDamageCause() != null && (entityDeathEvent.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK || entityDeathEvent.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
            Player player = entityDeathEvent.getEntity().getKiller();
            ItemStack itemStack = player.getItemInHand();
            ItemStackBuilder_4 itemStackBuilder_4 = this.Cm.a(itemStack);
            if (itemStackBuilder_4 == null) {
                return;
            }
            this.a(new PlayerLivingEntityHolder(player, entityDeathEvent.getEntity()), itemStackBuilder_4, itemStack);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void d(PlayerQuitEvent playerQuitEvent) {
        this.Co.aU(playerQuitEvent.getPlayer());
    }
}
