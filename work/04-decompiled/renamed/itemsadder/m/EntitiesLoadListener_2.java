package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.api.CustomFurniture;
import dev.lone.itemsadder.api.Events.FurnitureBreakEvent;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.Builder_14;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.EntityBridge_3;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.NamespacedKeyEntityTypeHolder;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import itemsadder.m.NamespacedKeyVectorHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerBridge_16;
import itemsadder.m.PlayerEntityHolder;
import itemsadder.m.PlayerJoinListener_3;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.PluginContract;
import itemsadder.m.RecordOfValue_20;
import java.lang.runtime.SwitchBootstraps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.world.EntitiesLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EntitiesLoadListener_2
implements PluginContract {
    private static final long zx = 20L;
    public final WeakHashMap zy = new WeakHashMap();
    private final WeakHashMap zz = new WeakHashMap();
    private final WeakHashMap zA = new WeakHashMap();
    private final WeakHashMap zB = new WeakHashMap();
    public final HashMap zC = new HashMap();
    private final HashMap zD = new HashMap();

    public EntitiesLoadListener_2(Plugin plugin) {
        ListenerBridge.a(this, plugin);
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        this.at();
    }

    public void a(Entity entity, boolean bl) {
        this.a(entity, null, bl, false, true);
    }

    public void b(Entity entity, @Nullable Player player, boolean bl) {
        this.a(entity, player, bl, true, true);
    }

    public void a(Entity entity, @Nullable Player player, boolean bl, boolean bl2, boolean bl3) {
        if (!bl2) {
            this.a(entity, player, bl, bl3);
            return;
        }
        if (entity == null) {
            return;
        }
        EntitiesLoadListener_2.a((Map)this.zC, (Map)this.zD, entity.getEntityId(), player, () -> this.a(entity, player, bl, bl3));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void a(Map map, Map map2, int n, @Nullable Player player, Runnable runnable) {
        boolean bl;
        boolean bl2 = bl = !map.containsKey(n);
        if (!bl && map.get(n) != player) {
            return;
        }
        if (bl) {
            map.put(n, player);
        }
        try {
            runnable.run();
        }
        finally {
            if (bl && map.get(n) == player) {
                map.remove(n);
                map2.remove(n);
            }
        }
    }

    private void a(Entity entity, @Nullable Player player, boolean bl, boolean bl2) {
        ItemFrame itemFrame;
        Object object;
        if (entity == null || !entity.isValid()) {
            return;
        }
        Entity entity2 = entity;
        Objects.requireNonNull(entity2);
        Object object2 = entity2;
        int n = 0;
        ItemStack itemStack = switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ArmorStand.class, ItemFrame.class, ItemDisplay.class}, (Object)object2, n)) {
            case 0 -> {
                object = (ArmorStand)object2;
                yield object.getHelmet().clone();
            }
            case 1 -> {
                itemFrame = (ItemFrame)object2;
                yield itemFrame.getItem().clone();
            }
            case 2 -> {
                ItemDisplay var10_11 = (ItemDisplay)object2;
                yield var10_11.getItemStack().clone();
            }
            default -> throw new RuntimeException("Unknown furniture entity type " + String.valueOf(entity.getClass()));
        };
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return;
        }
        object2 = ItemStackRegistry.g().a(itemStack);
        if (object2 == null) {
            entity.remove();
            return;
        }
        if (!((ItemStackBuilder_4)object2).Ge.bm("vehicle") && !((ItemStackBuilder_4)object2).Ge.bm("furniture")) {
            return;
        }
        if (((ItemStackBuilder_4)object2).Ge.bm("vehicle") && (player == null || ProtectionPlugins.canRemoveVehicle(player, entity, itemStack)) || ((ItemStackBuilder_4)object2).Ge.bm("furniture") && (player == null || EntitiesLoadListener_2.c((Entity)player, entity))) {
            ItemDisplay itemDisplay;
            ItemFrame itemFrame2;
            ArmorStand armorStand;
            NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder = (NamespacedKeyItemDisplayHolder)((ItemStackBuilder_4)object2).Ge.bn("furniture");
            if (namespacedKeyItemDisplayHolder != null && player != null) {
                if (!s.d((HumanEntity)player, namespacedKeyItemDisplayHolder.kL())) {
                    return;
                }
                if (!ListenerBridge.b((Event)new FurnitureBreakEvent(player, entity, namespacedKeyItemDisplayHolder))) {
                    return;
                }
            }
            object = new PlayerEntityHolder(player, entity);
            Entity entity3 = entity;
            Objects.requireNonNull(entity3);
            itemFrame = entity3;
            int n2 = 0;
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ArmorStand.class, ItemFrame.class, ItemDisplay.class}, (Object)itemFrame, n2)) {
                case 0: {
                    armorStand = (ArmorStand)itemFrame;
                    ((ItemStackBuilder_4)object2).a((LivingEntity)player, BlockBreakEnum.PLACED_ARMORSTAND_BREAK, arg_0 -> EntitiesLoadListener_2.e((PlayerEntityHolder)((Object)object), (ItemStackBuilder_4)object2, itemStack, arg_0));
                    break;
                }
                case 1: {
                    itemFrame2 = itemFrame;
                    ((ItemStackBuilder_4)object2).a((LivingEntity)player, BlockBreakEnum.PLACED_ITEMFRAME_BREAK, arg_0 -> EntitiesLoadListener_2.d((PlayerEntityHolder)((Object)object), (ItemStackBuilder_4)object2, itemStack, arg_0));
                    break;
                }
                case 2: {
                    itemDisplay = (ItemDisplay)itemFrame;
                    ((ItemStackBuilder_4)object2).a((LivingEntity)player, BlockBreakEnum.PLACED_ITEMFRAME_BREAK, arg_0 -> EntitiesLoadListener_2.c((PlayerEntityHolder)((Object)object), (ItemStackBuilder_4)object2, itemStack, arg_0));
                    break;
                }
            }
            ((ItemStackBuilder_4)object2).a((LivingEntity)player, BlockBreakEnum.PLACED_FURNITURE_BREAK, arg_0 -> EntitiesLoadListener_2.b((PlayerEntityHolder)((Object)object), (ItemStackBuilder_4)object2, itemStack, arg_0));
            if (((PlayerEntityHolder)((Object)object)).isCancelled()) {
                return;
            }
            int n3 = 0;
            if (namespacedKeyItemDisplayHolder != null) {
                n3 = namespacedKeyItemDisplayHolder.kH();
                if (namespacedKeyItemDisplayHolder.kI()) {
                    namespacedKeyItemDisplayHolder.s(entity);
                }
                if (bl && !namespacedKeyItemDisplayHolder.kJ()) {
                    bl = false;
                }
            }
            if (n3 > 0) {
                BlockBridge_2.bk(entity.getLocation().getBlock());
            }
            if (bl) {
                ItemStack itemStack2 = namespacedKeyItemDisplayHolder == null ? itemStack : ((ItemStackBuilder_4)object2).mP();
                itemStack2.setAmount(1);
                armorStand = new NItem(itemStack2);
                if (armorStand.hasKey("IAOrigName")) {
                    armorStand.setCustomName(armorStand.getString("IAOrigName"));
                    armorStand.remove("IAOrigName");
                    armorStand.save();
                }
                if (EntityHolder.i(entity.getType())) {
                    itemFrame2 = entity.getLocation().clone();
                    itemDisplay = LocationBridge_2.a(itemFrame2.getDirection());
                    if (itemDisplay == BlockFace.DOWN) {
                        itemFrame2.add(0.0, -1.0, 0.0);
                    }
                    LocationBridge_4.b((Location)itemFrame2, itemStack2);
                } else {
                    LocationBridge_4.b(entity.getLocation(), itemStack2);
                }
            }
            entity.remove();
            if (player != null) {
                PacketListenerRegistry.f(player, entity.getEntityId());
                PlayerJoinListener_3.V().c(player);
                PlayerJoinListener_3.V().a(entity);
                NamespacedKeyEntityTypeHolder namespacedKeyEntityTypeHolder = ((ItemStackBuilder_4)object2).Ge.mb();
                if (namespacedKeyEntityTypeHolder != null && bl2) {
                    namespacedKeyEntityTypeHolder.xu.HP.f(player, entity.getLocation());
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean c(Entity entity, Entity entity2) {
        if (entity == entity2) {
            return false;
        }
        if (entity2 instanceof ItemDisplay) {
            ArmorStand armorStand2 = (ArmorStand)entity2.getWorld().spawn(entity2.getLocation(), ArmorStand.class, armorStand -> {
                armorStand.setVisible(false);
                armorStand.setRemoveWhenFarAway(true);
            });
            try {
                boolean bl = LocationBridge_2.f(entity, (Entity)armorStand2);
                return bl;
            }
            finally {
                armorStand2.remove();
            }
        }
        return LocationBridge_2.f(entity, entity2);
    }

    public void f(Entity entity, @Nullable Player player) {
        int n = entity.getEntityId();
        Object object = new Object();
        this.zC.put(n, player);
        this.zD.put(n, object);
        BukkitTaskBridge.c(() -> EntitiesLoadListener_2.a((Map)this.zC, (Map)this.zD, n, player, object), 20L);
    }

    static void a(Map map, Map map2, int n, @Nullable Player player, Object object) {
        if (map2.get(n) != object || map.get(n) != player) {
            return;
        }
        map.remove(n);
        map2.remove(n);
    }

    public boolean g(Entity entity, @Nullable Player player) {
        return this.zC.containsKey(entity.getEntityId()) && this.zC.get(entity.getEntityId()) != player;
    }

    public void aw(Player player) {
        this.zA.put(player, System.currentTimeMillis());
    }

    public boolean ax(Player player) {
        if (!this.zA.containsKey(player)) {
            return false;
        }
        int n = Math.max(200, player.getPing() + 200);
        return System.currentTimeMillis() - (Long)this.zA.get(player) < (long)n;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(EntitiesLoadEvent entitiesLoadEvent) {
        this.l(entitiesLoadEvent.getEntities());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(ItemsAdderLoadDataEvent itemsAdderLoadDataEvent) {
        for (World world : Bukkit.getWorlds()) {
            this.l(world.getEntities());
        }
    }

    private void l(@NotNull List list) {
        for (Entity entity : list) {
            if (!(entity instanceof ArmorStand) && !(entity instanceof ItemFrame) && !(entity instanceof ItemDisplay) || entity.isCustomNameVisible() || entity.getCustomName() == null) continue;
            if (NamespacedKeyItemDisplayHolder.w(entity)) {
                NamespacedKeyItemDisplayHolder.v(entity);
                continue;
            }
            if (!NamespacedKeyVectorHolder.D(entity)) continue;
            NamespacedKeyVectorHolder.C(entity);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void d(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (ListenerBridge.h(entityDamageByEntityEvent)) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof Player && entityDamageByEntityEvent.getEntity() instanceof ArmorStand && NamespacedKeyItemDisplayHolder.w(entityDamageByEntityEvent.getEntity())) {
            entityDamageByEntityEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(PlayerAnimationEvent playerAnimationEvent) {
        RecordOfValue_20 recordOfValue_20;
        if (playerAnimationEvent.getAnimationType() != PlayerAnimationType.ARM_SWING) {
            return;
        }
        Player player = playerAnimationEvent.getPlayer();
        if (player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        int n = Math.max(200, player.getPing() + 200);
        if (this.zz.containsKey(player) && System.currentTimeMillis() - (Long)this.zz.get(player) < (long)n) {
            return;
        }
        if (this.zy.containsKey(player) && System.currentTimeMillis() - (Long)this.zy.get(player) < (long)n) {
            return;
        }
        if (this.zA.containsKey(player) && System.currentTimeMillis() - (Long)this.zA.get(player) < (long)n) {
            return;
        }
        if (PlayerJoinListener_9.bN.l(player)) {
            return;
        }
        if (player.getOpenInventory().getType() != InventoryType.CRAFTING && player.getOpenInventory().getType() != InventoryType.CREATIVE) {
            return;
        }
        if (PlayerJoinListener_9.bN.h(player)) {
            return;
        }
        Entity entity = NamespacedKeyEntityTypeHolder.ao(player);
        if (entity != null) {
            if (PlayerJoinListener_9.bN.b(playerAnimationEvent.getPlayer(), entity)) {
                return;
            }
            this.zz.put(player, System.currentTimeMillis());
            if (this.g(entity, player)) {
                return;
            }
            if (player.getGameMode() == GameMode.ADVENTURE && CustomFurniture.byAlreadySpawned(entity) != null) {
                return;
            }
            this.f(entity, player);
            BukkitTaskBridge.c(() -> {
                if (!PlayerJoinListener_9.bN.p(player)) {
                    boolean bl = true;
                    if (player.getGameMode() != GameMode.CREATIVE && (entity instanceof ArmorStand || entity instanceof ItemDisplay)) {
                        EntityBridge_3 entityBridge_3 = this.zB.computeIfAbsent(player, player -> new EntityBridge_3());
                        bl = entityBridge_3.a(entity, Math.max(800L, (long)n * 2L));
                    }
                    if (bl) {
                        this.a(entity, playerAnimationEvent.getPlayer(), player.getGameMode() != GameMode.CREATIVE || NamespacedKeyVectorHolder.D(entity), false, true);
                    }
                }
            }, 2L);
        }
        if ((recordOfValue_20 = PlayerBridge_16.aq(player)) != null) {
            this.zz.put(player, System.currentTimeMillis());
            if (this.g((Entity)recordOfValue_20.kD().eg(), player)) {
                return;
            }
            PlayerBridge_16.a(player, recordOfValue_20);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    void b(HangingBreakByEntityEvent hangingBreakByEntityEvent) {
        if (!(hangingBreakByEntityEvent.getRemover() instanceof Player)) {
            return;
        }
        if (((Player)hangingBreakByEntityEvent.getRemover()).getGameMode() != GameMode.CREATIVE) {
            return;
        }
        Hanging hanging = hangingBreakByEntityEvent.getEntity();
        if (!EntityHolder.i(hanging.getType())) {
            return;
        }
        this.b((Entity)hanging, (Player)hangingBreakByEntityEvent.getRemover(), false);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        Player player = blockBreakEvent.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            return;
        }
        Entity entity = NamespacedKeyEntityTypeHolder.ao(player);
        if (entity != null) {
            blockBreakEvent.setCancelled(true);
        } else {
            this.zy.put(blockBreakEvent.getPlayer(), System.currentTimeMillis());
        }
        RecordOfValue_20 recordOfValue_20 = PlayerBridge_16.aq(player);
        if (recordOfValue_20 != null) {
            blockBreakEvent.setCancelled(true);
            PlayerBridge_16.a(player, recordOfValue_20);
        }
    }

    private static /* synthetic */ ItemStackBuilder_3 b(PlayerEntityHolder playerEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Builder_14 builder_14) {
        return builder_14.b(playerEntityHolder, itemStackBuilder_4, itemStack);
    }

    private static /* synthetic */ ItemStackBuilder_3 c(PlayerEntityHolder playerEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Builder_14 builder_14) {
        return builder_14.b(playerEntityHolder, itemStackBuilder_4, itemStack);
    }

    private static /* synthetic */ ItemStackBuilder_3 d(PlayerEntityHolder playerEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Builder_14 builder_14) {
        return builder_14.b(playerEntityHolder, itemStackBuilder_4, itemStack);
    }

    private static /* synthetic */ ItemStackBuilder_3 e(PlayerEntityHolder playerEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Builder_14 builder_14) {
        return builder_14.b(playerEntityHolder, itemStackBuilder_4, itemStack);
    }
}
