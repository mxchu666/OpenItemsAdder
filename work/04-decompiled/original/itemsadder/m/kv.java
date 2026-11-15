package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Core.OtherPlugins.ProtectionPlugins.ProtectionPlugins;
import dev.lone.itemsadder.api.CustomFurniture;
import dev.lone.itemsadder.api.Events.FurnitureBreakEvent;
import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import dev.lone.itemsadder.s;
import itemsadder.m.afz;
import itemsadder.m.ai;
import itemsadder.m.aow;
import itemsadder.m.bay;
import itemsadder.m.bcc;
import itemsadder.m.bcp;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.j;
import itemsadder.m.jj;
import itemsadder.m.jl;
import itemsadder.m.jn;
import itemsadder.m.jp;
import itemsadder.m.js;
import itemsadder.m.kh;
import itemsadder.m.le;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qd;
import itemsadder.m.qm;
import itemsadder.m.w;
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

public class kv
implements ai {
    private static final long zx = 20L;
    public final WeakHashMap zy = new WeakHashMap();
    private final WeakHashMap zz = new WeakHashMap();
    private final WeakHashMap zA = new WeakHashMap();
    private final WeakHashMap zB = new WeakHashMap();
    public final HashMap zC = new HashMap();
    private final HashMap zD = new HashMap();

    public kv(Plugin plugin) {
        bev.a(this, plugin);
    }

    @Override
    public void unregister() {
        ai.super.unregister();
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
        kv.a((Map)this.zC, (Map)this.zD, entity.getEntityId(), player, () -> this.a(entity, player, bl, bl3));
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
        if (!qm.isCustomItem(itemStack)) {
            return;
        }
        object2 = d.g().a(itemStack);
        if (object2 == null) {
            entity.remove();
            return;
        }
        if (!((qm)object2).Ge.bm("vehicle") && !((qm)object2).Ge.bm("furniture")) {
            return;
        }
        if (((qm)object2).Ge.bm("vehicle") && (player == null || ProtectionPlugins.canRemoveVehicle(player, entity, itemStack)) || ((qm)object2).Ge.bm("furniture") && (player == null || kv.c((Entity)player, entity))) {
            ItemDisplay itemDisplay;
            ItemFrame itemFrame2;
            ArmorStand armorStand;
            js js2 = (js)((qm)object2).Ge.bn("furniture");
            if (js2 != null && player != null) {
                if (!s.d((HumanEntity)player, js2.kL())) {
                    return;
                }
                if (!bev.b((Event)new FurnitureBreakEvent(player, entity, js2))) {
                    return;
                }
            }
            object = new qd(player, entity);
            Entity entity3 = entity;
            Objects.requireNonNull(entity3);
            itemFrame = entity3;
            int n2 = 0;
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{ArmorStand.class, ItemFrame.class, ItemDisplay.class}, (Object)itemFrame, n2)) {
                case 0: {
                    armorStand = (ArmorStand)itemFrame;
                    ((qm)object2).a((LivingEntity)player, jj.PLACED_ARMORSTAND_BREAK, arg_0 -> kv.e((qd)((Object)object), (qm)object2, itemStack, arg_0));
                    break;
                }
                case 1: {
                    itemFrame2 = itemFrame;
                    ((qm)object2).a((LivingEntity)player, jj.PLACED_ITEMFRAME_BREAK, arg_0 -> kv.d((qd)((Object)object), (qm)object2, itemStack, arg_0));
                    break;
                }
                case 2: {
                    itemDisplay = (ItemDisplay)itemFrame;
                    ((qm)object2).a((LivingEntity)player, jj.PLACED_ITEMFRAME_BREAK, arg_0 -> kv.c((qd)((Object)object), (qm)object2, itemStack, arg_0));
                    break;
                }
            }
            ((qm)object2).a((LivingEntity)player, jj.PLACED_FURNITURE_BREAK, arg_0 -> kv.b((qd)((Object)object), (qm)object2, itemStack, arg_0));
            if (((qd)((Object)object)).isCancelled()) {
                return;
            }
            int n3 = 0;
            if (js2 != null) {
                n3 = js2.kH();
                if (js2.kI()) {
                    js2.s(entity);
                }
                if (bl && !js2.kJ()) {
                    bl = false;
                }
            }
            if (n3 > 0) {
                bay.bk(entity.getLocation().getBlock());
            }
            if (bl) {
                ItemStack itemStack2 = js2 == null ? itemStack : ((qm)object2).mP();
                itemStack2.setAmount(1);
                armorStand = new NItem(itemStack2);
                if (armorStand.hasKey("IAOrigName")) {
                    armorStand.setCustomName(armorStand.getString("IAOrigName"));
                    armorStand.remove("IAOrigName");
                    armorStand.save();
                }
                if (afz.i(entity.getType())) {
                    itemFrame2 = entity.getLocation().clone();
                    itemDisplay = bcc.a(itemFrame2.getDirection());
                    if (itemDisplay == BlockFace.DOWN) {
                        itemFrame2.add(0.0, -1.0, 0.0);
                    }
                    bdf.b((Location)itemFrame2, itemStack2);
                } else {
                    bdf.b(entity.getLocation(), itemStack2);
                }
            }
            entity.remove();
            if (player != null) {
                aow.f(player, entity.getEntityId());
                j.V().c(player);
                j.V().a(entity);
                jl jl2 = ((qm)object2).Ge.mb();
                if (jl2 != null && bl2) {
                    jl2.xu.HP.f(player, entity.getLocation());
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
                boolean bl = bcc.f(entity, (Entity)armorStand2);
                return bl;
            }
            finally {
                armorStand2.remove();
            }
        }
        return bcc.f(entity, entity2);
    }

    public void f(Entity entity, @Nullable Player player) {
        int n = entity.getEntityId();
        Object object = new Object();
        this.zC.put(n, player);
        this.zD.put(n, object);
        bcp.c(() -> kv.a((Map)this.zC, (Map)this.zD, n, player, object), 20L);
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
            if (js.w(entity)) {
                js.v(entity);
                continue;
            }
            if (!kh.D(entity)) continue;
            kh.C(entity);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    private void d(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (bev.h(entityDamageByEntityEvent)) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof Player && entityDamageByEntityEvent.getEntity() instanceof ArmorStand && js.w(entityDamageByEntityEvent.getEntity())) {
            entityDamageByEntityEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(PlayerAnimationEvent playerAnimationEvent) {
        jp jp2;
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
        if (w.bN.l(player)) {
            return;
        }
        if (player.getOpenInventory().getType() != InventoryType.CRAFTING && player.getOpenInventory().getType() != InventoryType.CREATIVE) {
            return;
        }
        if (w.bN.h(player)) {
            return;
        }
        Entity entity = jl.ao(player);
        if (entity != null) {
            if (w.bN.b(playerAnimationEvent.getPlayer(), entity)) {
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
            bcp.c(() -> {
                if (!w.bN.p(player)) {
                    boolean bl = true;
                    if (player.getGameMode() != GameMode.CREATIVE && (entity instanceof ArmorStand || entity instanceof ItemDisplay)) {
                        le le2 = this.zB.computeIfAbsent(player, player -> new le());
                        bl = le2.a(entity, Math.max(800L, (long)n * 2L));
                    }
                    if (bl) {
                        this.a(entity, playerAnimationEvent.getPlayer(), player.getGameMode() != GameMode.CREATIVE || kh.D(entity), false, true);
                    }
                }
            }, 2L);
        }
        if ((jp2 = jn.aq(player)) != null) {
            this.zz.put(player, System.currentTimeMillis());
            if (this.g((Entity)jp2.kD().eg(), player)) {
                return;
            }
            jn.a(player, jp2);
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
        if (!afz.i(hanging.getType())) {
            return;
        }
        this.b((Entity)hanging, (Player)hangingBreakByEntityEvent.getRemover(), false);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        Player player = blockBreakEvent.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            return;
        }
        Entity entity = jl.ao(player);
        if (entity != null) {
            blockBreakEvent.setCancelled(true);
        } else {
            this.zy.put(blockBreakEvent.getPlayer(), System.currentTimeMillis());
        }
        jp jp2 = jn.aq(player);
        if (jp2 != null) {
            blockBreakEvent.setCancelled(true);
            jn.a(player, jp2);
        }
    }

    private static /* synthetic */ pa b(qd qd2, qm qm2, ItemStack itemStack, ou ou2) {
        return ou2.b(qd2, qm2, itemStack);
    }

    private static /* synthetic */ pa c(qd qd2, qm qm2, ItemStack itemStack, ou ou2) {
        return ou2.b(qd2, qm2, itemStack);
    }

    private static /* synthetic */ pa d(qd qd2, qm qm2, ItemStack itemStack, ou ou2) {
        return ou2.b(qd2, qm2, itemStack);
    }

    private static /* synthetic */ pa e(qd qd2, qm qm2, ItemStack itemStack, ou ou2) {
        return ou2.b(qd2, qm2, itemStack);
    }
}
