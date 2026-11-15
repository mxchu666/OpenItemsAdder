package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import dev.lone.itemsadder.Main;
import itemsadder.m.afz;
import itemsadder.m.aow;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bdb;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.px;
import itemsadder.m.py;
import itemsadder.m.pz;
import itemsadder.m.qa;
import itemsadder.m.qb;
import itemsadder.m.qc;
import itemsadder.m.qm;
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

public class pw
implements Listener {
    private static final int EL = 5;
    private static final int EM = 10;
    private static final int EN = 300;
    private static final NamespacedKey EO = new NamespacedKey((Plugin)Main.rS(), "custom_trident");
    private static final bdb EP = new bdb(16, 16, 16);
    private static pw EQ;
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
            pw.register();
        } else {
            pw.unregister();
        }
    }

    public static void register() {
        if (EQ == null) {
            EQ = new pw();
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
        bev.b(this, (Plugin)Main.rS());
        this.ER.add(new px(this, PacketAdapter.params().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.SPAWN_ENTITY})));
        this.ER.add(new py(this, PacketAdapter.params().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.COLLECT})));
        this.ER.add(new pz(this, PacketAdapter.params().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.ENTITY_DESTROY})));
        this.ER.forEach(aow::b);
        this.iT.scheduleAtFixedRate(() -> {
            try {
                Iterator iterator = this.ES.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = iterator.next();
                    qb qb2 = (qb)entry.getValue();
                    if (qb2 == null) continue;
                    Trident trident = qb2.Fa;
                    if (!qb2.my().mz() && !trident.isValid()) {
                        iterator.remove();
                        continue;
                    }
                    if (trident.isOnGround() && !qb2.my().mz()) continue;
                    ItemDisplay itemDisplay = qb2.EZ;
                    if (qb2.my() == qc.LOYAL_PICKING_UP) {
                        if ((qb2.mv() > 300 || trident.isDead() || qb2.mw()) && (qb2.Fb == null || !qb2.Fb.getWorld().equals((Object)trident.getWorld()) || trident.getLocation().distance(qb2.Fb.getLocation()) <= 3.0)) {
                            iterator.remove();
                            this.ET.remove(trident.getEntityId());
                            aow.uN().T((Entity)itemDisplay);
                            if (!trident.isValid() || qb2.mw()) {
                                return;
                            }
                            bcp.i(() -> {
                                trident.remove();
                                ItemStack itemStack = afz.c((Projectile)qb2.Fa);
                                if (itemStack == null) {
                                    bce.warn("TridentHandler: ItemStack is null for trident " + trident.getEntityId() + ". This should not happen, please report this issue.");
                                    return;
                                }
                                bdf.b(trident.getLocation(), itemStack);
                            });
                            continue;
                        }
                    } else if (qb2.my() == qc.PICKING_UP) {
                        if (qb2.Fb != null && !qb2.Fb.getWorld().equals((Object)trident.getWorld())) continue;
                        Location location = itemDisplay.getLocation();
                        Location location2 = pw.e((Entity)qb2.mx(), (Entity)itemDisplay);
                        if (!location.getWorld().equals((Object)location2.getWorld())) continue;
                        double d = location.distance(location2);
                        double d2 = Math.min(0.5, d);
                        Location location3 = location.clone().add(location2.toVector().subtract(location.toVector()).normalize().multiply(d2));
                        location3.setYaw(location2.getYaw());
                        location3.setPitch(location2.getPitch());
                        aow.uN().a((Entity)itemDisplay, location3);
                        if (!(d <= 1.0)) continue;
                        iterator.remove();
                        bcp.i(() -> bbs.ac(trident.getLocation()));
                        continue;
                    }
                    aow.uN().a((Entity)itemDisplay, pw.L(trident.getLocation()));
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }, 0L, TimeUnit.MILLISECONDS.toNanos(50L), TimeUnit.NANOSECONDS);
    }

    private void av() {
        bev.b(this);
        this.ER.forEach(aow::c);
        this.iT.shutdownNow();
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(ProjectileLaunchEvent projectileLaunchEvent) {
        Projectile projectile = projectileLaunchEvent.getEntity();
        if (!(projectile instanceof Trident)) {
            return;
        }
        Trident trident = (Trident)projectile;
        projectile = afz.c((Projectile)trident);
        if (projectile == null) {
            bce.warn("TridentHandler: ItemStack is null for trident " + trident.getEntityId() + ". This should not happen, please report this issue.");
            return;
        }
        qm qm2 = d.g().a((ItemStack)projectile);
        if (qm2 == null) {
            return;
        }
        qb qb2 = this.a(trident, (ItemStack)projectile);
        trident.getWorld().playSound(trident.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0f, 1.0f);
        bcp.b(new qa(this, trident, qb2), 1L, 1L);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void d(ProjectileHitEvent projectileHitEvent) {
        Projectile projectile = projectileHitEvent.getEntity();
        if (!(projectile instanceof Trident)) {
            return;
        }
        Trident trident = (Trident)projectile;
        this.a(trident, (T qb2, U itemStack) -> {
            ItemDisplay itemDisplay = qb2.EZ;
            aow.uN().a((Entity)itemDisplay, pw.L(trident.getLocation()));
            int n = bbs.aA(afz.c((Projectile)trident));
            if (n > 0) {
                if (projectileHitEvent.getEntity().getShooter() instanceof Entity) {
                    qb2.a(qc.LOYAL_PICKING_UP);
                }
            } else {
                @NotNull Collection collection = projectileHitEvent.getEntity().getWorld().getNearbyEntities(projectileHitEvent.getEntity().getLocation(), (double)pw.EP.ha, (double)pw.EP.gW, (double)pw.EP.hc, entity -> entity instanceof Trident && entity.getPersistentDataContainer().has(EO, PersistentDataType.STRING));
                if (collection.size() > 10) {
                    bce.warn("Too many custom tridents in the area (" + bcc.b(projectileHitEvent.getEntity().getLocation(), true) + "). Trident thrown by " + String.valueOf(projectileHitEvent.getEntity().getShooter()) + ". Dropping the item instead.");
                    projectileHitEvent.getEntity().remove();
                    bdf.b(projectileHitEvent.getEntity().getLocation(), itemStack);
                }
            }
        });
    }

    private qb a(Trident trident, ItemStack itemStack) {
        LivingEntity livingEntity;
        if (this.ES.containsKey(trident)) {
            return (qb)this.ES.get(trident);
        }
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            throw new IllegalArgumentException("CustomItem not found for ItemStack: " + String.valueOf(itemStack));
        }
        trident.getPersistentDataContainer().set(EO, PersistentDataType.STRING, (Object)qm2.getNamespacedID());
        Location location = trident.getLocation();
        Object object = trident.getShooter();
        if (object instanceof LivingEntity) {
            livingEntity = (LivingEntity)object;
            object = location.getDirection().normalize().multiply(-10);
            location.add((Vector)object);
            location.add(0.0, 100.0, 0.0);
        }
        livingEntity = aow.uN().b(pw.L(location), itemDisplay -> {
            itemDisplay.setDisplayWidth(2.0f);
            itemDisplay.setTeleportDuration(1);
            itemDisplay.setItemDisplayTransform(ItemDisplay.ItemDisplayTransform.HEAD);
            itemDisplay.setItemStack(itemStack);
        });
        object = new qb(trident, (ItemDisplay)livingEntity, trident.getShooter() instanceof LivingEntity ? (LivingEntity)trident.getShooter() : null);
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
        ItemStack itemStack = afz.c((Projectile)trident);
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return;
        }
        qb qb2 = (qb)this.ES.get(trident);
        if (qb2 != null) {
            biConsumer.accept(qb2, itemStack);
        }
    }

    private static Location L(Location location) {
        float f2 = -location.getYaw() + 180.0f;
        float f3 = location.getPitch();
        location.setPitch(bcc.D(f3));
        location.setYaw(bcc.D(f2));
        return location;
    }

    public void a(Trident trident) {
        this.ES.remove(trident);
        this.ET.remove(trident.getEntityId());
    }
}
