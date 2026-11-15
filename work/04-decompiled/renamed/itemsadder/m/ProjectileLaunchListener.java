package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemDisplayTridentHolder;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_52;
import itemsadder.m.PacketListener_53;
import itemsadder.m.PacketListener_54;
import itemsadder.m.PickingUpEnum;
import itemsadder.m.TridentBridge;
import itemsadder.m.VectorBridge_3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class ProjectileLaunchListener
implements Listener {
    private static final int EL = 5;
    private static final int EM = 10;
    private static final int EN = 300;
    private static final NamespacedKey EO = new NamespacedKey((Plugin)Main.rS(), "custom_trident");
    private static final VectorBridge_3 EP = new VectorBridge_3(16, 16, 16);
    private static ProjectileLaunchListener EQ;
    ScheduledExecutorService iT = Executors.newScheduledThreadPool(1, runnable -> {
        Thread thread = new Thread(runnable, "ItemsAdder-Trident-Tick");
        thread.setDaemon(true);
        return thread;
    });
    List ER = new ArrayList();
    final Map ES = new ConcurrentHashMap();
    final Map ET = new ConcurrentHashMap();

    public static void i(boolean bl) {
        if (bl) {
            ProjectileLaunchListener.register();
        } else {
            ProjectileLaunchListener.unregister();
        }
    }

    public static void register() {
        if (EQ == null) {
            EQ = new ProjectileLaunchListener();
            EQ.au();
        }
    }

    public static void unregister() {
        if (EQ != null) {
            EQ.av();
            EQ = null;
        }
    }

    private void au() {
        ListenerBridge.b(this, (Plugin)Main.rS());
        this.ER.add(new PacketListener_52(this, PacketAdapter.params().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.SPAWN_ENTITY})));
        this.ER.add(new PacketListener_53(this, PacketAdapter.params().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.COLLECT})));
        this.ER.add(new PacketListener_54(this, PacketAdapter.params().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.ENTITY_DESTROY})));
        this.ER.forEach(PacketListenerRegistry::b);
        this.iT.scheduleAtFixedRate(() -> {
            try {
                Iterator iterator = this.ES.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = iterator.next();
                    ItemDisplayTridentHolder itemDisplayTridentHolder = (ItemDisplayTridentHolder)entry.getValue();
                    if (itemDisplayTridentHolder == null) continue;
                    Trident trident = itemDisplayTridentHolder.Fa;
                    if (!itemDisplayTridentHolder.my().mz() && !trident.isValid()) {
                        iterator.remove();
                        continue;
                    }
                    if (trident.isOnGround() && !itemDisplayTridentHolder.my().mz()) continue;
                    ItemDisplay itemDisplay = itemDisplayTridentHolder.EZ;
                    if (itemDisplayTridentHolder.my() == PickingUpEnum.LOYAL_PICKING_UP) {
                        if ((itemDisplayTridentHolder.mv() > 300 || trident.isDead() || itemDisplayTridentHolder.mw()) && (itemDisplayTridentHolder.Fb == null || !itemDisplayTridentHolder.Fb.getWorld().equals((Object)trident.getWorld()) || trident.getLocation().distance(itemDisplayTridentHolder.Fb.getLocation()) <= 3.0)) {
                            iterator.remove();
                            this.ET.remove(trident.getEntityId());
                            PacketListenerRegistry.uN().T((Entity)itemDisplay);
                            if (!trident.isValid() || itemDisplayTridentHolder.mw()) {
                                return;
                            }
                            BukkitTaskBridge.i(() -> {
                                trident.remove();
                                ItemStack itemStack = EntityHolder.c((Projectile)itemDisplayTridentHolder.Fa);
                                if (itemStack == null) {
                                    CommandSenderBridge_5.warn("TridentHandler: ItemStack is null for trident " + trident.getEntityId() + ". This should not happen, please report this issue.");
                                    return;
                                }
                                LocationBridge_4.b(trident.getLocation(), itemStack);
                            });
                            continue;
                        }
                    } else if (itemDisplayTridentHolder.my() == PickingUpEnum.PICKING_UP) {
                        if (itemDisplayTridentHolder.Fb != null && !itemDisplayTridentHolder.Fb.getWorld().equals((Object)trident.getWorld())) continue;
                        Location location = itemDisplay.getLocation();
                        Location location2 = ProjectileLaunchListener.e((Entity)itemDisplayTridentHolder.mx(), (Entity)itemDisplay);
                        if (!location.getWorld().equals((Object)location2.getWorld())) continue;
                        double d = location.distance(location2);
                        double d2 = Math.min(0.5, d);
                        Location location3 = location.clone().add(location2.toVector().subtract(location.toVector()).normalize().multiply(d2));
                        location3.setYaw(location2.getYaw());
                        location3.setPitch(location2.getPitch());
                        PacketListenerRegistry.uN().a((Entity)itemDisplay, location3);
                        if (!(d <= 1.0)) continue;
                        iterator.remove();
                        BukkitTaskBridge.i(() -> ItemStackBridge_2.ac(trident.getLocation()));
                        continue;
                    }
                    PacketListenerRegistry.uN().a((Entity)itemDisplay, ProjectileLaunchListener.L(trident.getLocation()));
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }, 0L, TimeUnit.MILLISECONDS.toNanos(50L), TimeUnit.NANOSECONDS);
    }

    private void av() {
        ListenerBridge.b(this);
        this.ER.forEach(PacketListenerRegistry::c);
        this.iT.shutdownNow();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(ProjectileLaunchEvent projectileLaunchEvent) {
        Projectile projectile = projectileLaunchEvent.getEntity();
        if (!(projectile instanceof Trident)) {
            return;
        }
        Trident trident = (Trident)projectile;
        projectile = EntityHolder.c((Projectile)trident);
        if (projectile == null) {
            CommandSenderBridge_5.warn("TridentHandler: ItemStack is null for trident " + trident.getEntityId() + ". This should not happen, please report this issue.");
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a((ItemStack)projectile);
        if (itemStackBuilder_4 == null) {
            return;
        }
        ItemDisplayTridentHolder itemDisplayTridentHolder = this.a(trident, (ItemStack)projectile);
        trident.getWorld().playSound(trident.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0f, 1.0f);
        BukkitTaskBridge.b(new TridentBridge(this, trident, itemDisplayTridentHolder), 1L, 1L);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void d(ProjectileHitEvent projectileHitEvent) {
        Projectile projectile = projectileHitEvent.getEntity();
        if (!(projectile instanceof Trident)) {
            return;
        }
        Trident trident = (Trident)projectile;
        this.a(trident, (T itemDisplayTridentHolder, U itemStack) -> {
            ItemDisplay itemDisplay = itemDisplayTridentHolder.EZ;
            PacketListenerRegistry.uN().a((Entity)itemDisplay, ProjectileLaunchListener.L(trident.getLocation()));
            int n = ItemStackBridge_2.aA(EntityHolder.c((Projectile)trident));
            if (n > 0) {
                if (projectileHitEvent.getEntity().getShooter() instanceof Entity) {
                    itemDisplayTridentHolder.a(PickingUpEnum.LOYAL_PICKING_UP);
                }
            } else {
                @NotNull Collection collection = projectileHitEvent.getEntity().getWorld().getNearbyEntities(projectileHitEvent.getEntity().getLocation(), (double)ProjectileLaunchListener.EP.ha, (double)ProjectileLaunchListener.EP.gW, (double)ProjectileLaunchListener.EP.hc, entity -> entity instanceof Trident && entity.getPersistentDataContainer().has(EO, PersistentDataType.STRING));
                if (collection.size() > 10) {
                    CommandSenderBridge_5.warn("Too many custom tridents in the area (" + LocationBridge_2.b(projectileHitEvent.getEntity().getLocation(), true) + "). Trident thrown by " + String.valueOf(projectileHitEvent.getEntity().getShooter()) + ". Dropping the item instead.");
                    projectileHitEvent.getEntity().remove();
                    LocationBridge_4.b(projectileHitEvent.getEntity().getLocation(), itemStack);
                }
            }
        });
    }

    private ItemDisplayTridentHolder a(Trident trident, ItemStack itemStack) {
        LivingEntity livingEntity;
        if (this.ES.containsKey(trident)) {
            return (ItemDisplayTridentHolder)this.ES.get(trident);
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            throw new IllegalArgumentException("CustomItem not found for ItemStack: " + String.valueOf(itemStack));
        }
        trident.getPersistentDataContainer().set(EO, PersistentDataType.STRING, (Object)itemStackBuilder_4.getNamespacedID());
        Location location = trident.getLocation();
        Object object = trident.getShooter();
        if (object instanceof LivingEntity) {
            livingEntity = (LivingEntity)object;
            object = location.getDirection().normalize().multiply(-10);
            location.add((Vector)object);
            location.add(0.0, 100.0, 0.0);
        }
        livingEntity = PacketListenerRegistry.uN().b(ProjectileLaunchListener.L(location), itemDisplay -> {
            itemDisplay.setDisplayWidth(2.0f);
            itemDisplay.setTeleportDuration(1);
            itemDisplay.setItemDisplayTransform(ItemDisplay.ItemDisplayTransform.HEAD);
            itemDisplay.setItemStack(itemStack);
        });
        object = new ItemDisplayTridentHolder(trident, (ItemDisplay)livingEntity, trident.getShooter() instanceof LivingEntity ? (LivingEntity)trident.getShooter() : null);
        this.ES.put(trident, object);
        this.ET.put(trident.getEntityId(), trident);
        return object;
    }

    private static Location e(Entity entity, Entity entity2) {
        Location location = entity.getLocation().add(0.0, 0.5, 0.0);
        location.setYaw(entity2.getYaw());
        location.setPitch(entity2.getPitch());
        return location;
    }

    private void a(Trident trident, BiConsumer biConsumer) {
        ItemStack itemStack = EntityHolder.c((Projectile)trident);
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        ItemDisplayTridentHolder itemDisplayTridentHolder = (ItemDisplayTridentHolder)this.ES.get(trident);
        if (itemDisplayTridentHolder != null) {
            biConsumer.accept(itemDisplayTridentHolder, itemStack);
        }
    }

    private static Location L(Location location) {
        float f = -location.getYaw() + 180.0f;
        float f2 = location.getPitch();
        location.setPitch(LocationBridge_2.D(f2));
        location.setYaw(LocationBridge_2.D(f));
        return location;
    }

    public void a(Trident trident) {
        this.ES.remove(trident);
        this.ET.remove(trident.getEntityId());
    }
}
