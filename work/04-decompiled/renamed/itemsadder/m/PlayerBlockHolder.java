package itemsadder.m;

import itemsadder.m.BoundingBoxBuilder;
import itemsadder.m.ChunkLoadListener;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityHolder;
import itemsadder.m.ItemDisplayLocationHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_7;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerToggleSneakListener;
import itemsadder.m.RecordOfItemStack;
import itemsadder.m.RecordOfVector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.commons.math3.util.FastMath;
import org.bukkit.Chunk;
import org.bukkit.FluidCollisionMode;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.jctools.maps.NonBlockingHashMapLong;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public class PlayerBlockHolder {
    public static int jS;
    private static final float jT;
    private static final float jU;
    private static final int jV = 5;
    private static final Vector3f jW;
    private static final Vector3f jX;
    private final Player jY;
    private final Map jZ = new ConcurrentHashMap();
    private final NonBlockingHashMapLong ka = new NonBlockingHashMapLong();
    private final Map kb = new ConcurrentHashMap();
    private final ConcurrentLinkedDeque kc = new ConcurrentLinkedDeque();
    @Nullable
    private volatile RecordOfVector kd;
    @Nullable
    private Block ke;

    public PlayerBlockHolder(Player player, int n) {
        this.jY = player;
        jS = n + 20;
    }

    private static long a(int n, int n2) {
        return (long)n << 32 ^ (long)n2 & 0xFFFFFFFFL;
    }

    public void a(ItemDisplayLocationHolder itemDisplayLocationHolder) {
        if (itemDisplayLocationHolder.cG()) {
            return;
        }
        itemDisplayLocationHolder.r(true);
        int n = itemDisplayLocationHolder.kn.ha >> 4;
        int n2 = itemDisplayLocationHolder.kn.hc >> 4;
        this.kb.computeIfAbsent(PlayerBlockHolder.a(n, n2), l -> new ConcurrentLinkedQueue()).add(itemDisplayLocationHolder);
        this.jZ.put(itemDisplayLocationHolder.kg.getUniqueId(), itemDisplayLocationHolder);
        this.ka.put(ChunkLoadListener.a(itemDisplayLocationHolder.kn), (Object)itemDisplayLocationHolder);
    }

    private void b(ItemDisplayLocationHolder itemDisplayLocationHolder) {
        itemDisplayLocationHolder.r(false);
        int n = itemDisplayLocationHolder.kn.ha >> 4;
        int n2 = itemDisplayLocationHolder.kn.hc >> 4;
        long l = PlayerBlockHolder.a(n, n2);
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue)this.kb.get(l);
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.removeIf(itemDisplayLocationHolder2 -> itemDisplayLocationHolder2 == itemDisplayLocationHolder);
            if (concurrentLinkedQueue.isEmpty()) {
                this.kb.remove(l, concurrentLinkedQueue);
            }
        }
        this.ka.remove(ChunkLoadListener.c(itemDisplayLocationHolder.kp), (Object)itemDisplayLocationHolder);
    }

    private List a(Location location, double d) {
        int n = location.getBlockX() >> 4;
        int n2 = location.getBlockZ() >> 4;
        ArrayList<ItemDisplayLocationHolder> arrayList = new ArrayList<ItemDisplayLocationHolder>();
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue)this.kb.get(PlayerBlockHolder.a(n + i, n2 + j));
                if (concurrentLinkedQueue == null) continue;
                for (ItemDisplayLocationHolder itemDisplayLocationHolder : concurrentLinkedQueue) {
                    double d2 = itemDisplayLocationHolder.kn.Dy().distanceSquared((Vector3fc)new Vector3f((float)location.getX(), (float)location.getY(), (float)location.getZ()));
                    if (!(d2 <= (d + 2.0) * (d + 2.0))) continue;
                    arrayList.add(itemDisplayLocationHolder);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public ItemDisplayLocationHolder K(Player player) {
        return this.c(player, true);
    }

    @Nullable
    ItemDisplayLocationHolder c(Player player, boolean bl) {
        ItemDisplayLocationHolder itemDisplayLocationHolder;
        Location location = player.getEyeLocation();
        Vector vector = location.getDirection();
        Vector vector2 = location.toVector();
        double d = player.getGameMode() == GameMode.CREATIVE ? Objects.requireNonNull(player.getAttribute(Attribute.PLAYER_BLOCK_INTERACTION_RANGE)).getValue() : 4.5;
        RayTraceResult rayTraceResult = player.getWorld().rayTraceBlocks(location, vector, d, FluidCollisionMode.NEVER, true);
        this.ke = rayTraceResult == null ? null : rayTraceResult.getHitBlock();
        double d2 = rayTraceResult == null ? d * d : rayTraceResult.getHitPosition().distanceSquared(vector2);
        long l = player.getWorld().getFullTime();
        if (bl && this.kd != null && this.kd.kz != null && this.kd.kz.kf && l - this.kd.kA < 3L && this.kd.ky == d && this.kd.kw.distanceSquared(vector2) < 0.04 && (double)this.kd.kx.angle(vector) < Math.toRadians(2.5) && (itemDisplayLocationHolder = this.kd.kz.ko.a(vector2, vector, d2)) != null) {
            return this.kd.kz;
        }
        itemDisplayLocationHolder = null;
        for (ItemDisplayLocationHolder itemDisplayLocationHolder2 : this.a(location, d)) {
            Vector vector3;
            if (!itemDisplayLocationHolder2.cG() || (vector3 = itemDisplayLocationHolder2.ko.a(vector2, vector, d2)) == null) continue;
            double d3 = vector3.distanceSquared(vector2);
            itemDisplayLocationHolder = itemDisplayLocationHolder2;
            d2 = d3;
        }
        this.kd = itemDisplayLocationHolder == null ? null : new RecordOfVector(vector2, vector, d, itemDisplayLocationHolder, l);
        return itemDisplayLocationHolder;
    }

    @Nullable
    Block cw() {
        return this.ke;
    }

    public void a(Location location, String string, byte by) {
        Location location2 = this.jY.getLocation();
        boolean bl = PlayerToggleSneakListener.iE && LocationBridge_2.h(location, location2) >= (double)PlayerToggleSneakListener.iF;
        this.a(true, null, string, by, location, bl, location2);
    }

    @Nullable
    public ItemDisplayLocationHolder a(boolean bl, @Nullable LocationBridge_7 locationBridge_7, String string, byte by, Location location, boolean bl2, @Nullable Location location2) {
        ItemDisplayLocationHolder itemDisplayLocationHolder = null;
        if (bl) {
            itemDisplayLocationHolder = this.j(location);
        }
        if (itemDisplayLocationHolder == null && (itemDisplayLocationHolder = (ItemDisplayLocationHolder)this.kc.poll()) == null && this.jZ.size() < jS) {
            itemDisplayLocationHolder = this.cx();
        }
        if (itemDisplayLocationHolder == null) {
            return null;
        }
        boolean bl3 = LocationBridge_2.a(location, itemDisplayLocationHolder.kn);
        if (bl3) {
            if (!itemDisplayLocationHolder.a(by, string, bl2, false)) {
                itemDisplayLocationHolder.cC();
                this.a(itemDisplayLocationHolder);
                return itemDisplayLocationHolder;
            }
        } else {
            itemDisplayLocationHolder.k(location);
        }
        if (locationBridge_7 == null) {
            locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(string);
        }
        if (locationBridge_7 == null) {
            return null;
        }
        itemDisplayLocationHolder.namespacedId = string;
        itemDisplayLocationHolder.kh = by;
        itemDisplayLocationHolder.cC();
        this.a(itemDisplayLocationHolder, locationBridge_7, by, bl2, location2, true, true);
        if (!bl3) {
            PacketListenerRegistry.uN().a((Entity)itemDisplayLocationHolder.kg, this.jY, location);
        }
        this.a(itemDisplayLocationHolder);
        return itemDisplayLocationHolder;
    }

    private ItemDisplayLocationHolder cx() {
        Location location = this.jY.getLocation().clone().add(0.0, -1000.0, 0.0);
        ItemDisplay itemDisplay2 = PacketListenerRegistry.uN().b(location, itemDisplay -> {
            itemDisplay.setItemDisplayTransform(ItemDisplay.ItemDisplayTransform.FIXED);
            Transformation transformation = itemDisplay.getTransformation();
            transformation.getTranslation().set((Vector3fc)jW);
            itemDisplay.setTransformation(transformation);
            itemDisplay.setInvisible(true);
            itemDisplay.setViewRange(0.7f);
            itemDisplay.setDisplayHeight(0.7f);
            itemDisplay.setDisplayWidth(0.7f);
            itemDisplay.setInterpolationDelay(0);
            itemDisplay.setInterpolationDuration(0);
            itemDisplay.setTeleportDuration(0);
            itemDisplay.setShadowRadius(0.0f);
            itemDisplay.setShadowStrength(0.0f);
            itemDisplay.setGlowColorOverride(null);
        });
        PacketListenerRegistry.uN().h((Entity)itemDisplay2, this.jY);
        return new ItemDisplayLocationHolder(itemDisplay2, location, null, 0);
    }

    public void a(ItemDisplayLocationHolder itemDisplayLocationHolder, Location location, boolean bl, boolean bl2) {
        double d = itemDisplayLocationHolder.getLocation().getX();
        double d2 = itemDisplayLocationHolder.getLocation().getZ();
        double d3 = location.getX();
        double d4 = location.getZ();
        float f = -((float)FastMath.atan2((double)(d4 - d2), (double)(d3 - d)) - 1.5707964f);
        long l = this.jY.getWorld().getTime();
        float f2 = Math.abs(itemDisplayLocationHolder.kk - f);
        if (bl2 || f2 > jU || l - itemDisplayLocationHolder.kl >= 5L) {
            EntityHolder.tK().a(itemDisplayLocationHolder.kg, jW, new Quaternionf().rotationY(f));
            itemDisplayLocationHolder.kk = f;
            itemDisplayLocationHolder.kl = l;
            if (bl) {
                PacketListenerRegistry.uN().c((Entity)itemDisplayLocationHolder.kg, this.jY, true);
            }
        }
    }

    public void a(ItemDisplayLocationHolder itemDisplayLocationHolder, LocationBridge_7 locationBridge_7, byte by, boolean bl, @Nullable Location location, boolean bl2, boolean bl3) {
        RecordOfItemStack recordOfItemStack = locationBridge_7.a(by);
        if (recordOfItemStack == null) {
            recordOfItemStack = locationBridge_7.f(0);
        }
        if (recordOfItemStack == null) {
            CommandSenderBridge_5.warn("Crop with namespaced ID " + locationBridge_7.hD + " has no age status for age " + by + " or 0, cannot update display!");
            return;
        }
        ItemDisplay itemDisplay = itemDisplayLocationHolder.kg;
        if (bl2) {
            double d = itemDisplayLocationHolder.getLocation().getX() + 0.5;
            double d2 = itemDisplayLocationHolder.getLocation().getY();
            double d3 = itemDisplayLocationHolder.getLocation().getZ() + 0.5;
            double d4 = recordOfItemStack.bJ() != null ? (double)recordOfItemStack.bJ().floatValue() : (double)locationBridge_7.hI.aBp;
            double d5 = recordOfItemStack.bK() != null ? (double)recordOfItemStack.bK().floatValue() : (double)locationBridge_7.hI.aBq;
            double d6 = recordOfItemStack.bI() != null ? (double)recordOfItemStack.bI().floatValue() : (double)locationBridge_7.hI.aBr;
            itemDisplayLocationHolder.a(new BoundingBoxBuilder(d - d4 / 2.0, d2, d3 - d6 / 2.0, d + d4 / 2.0, d2 + d5, d3 + d6 / 2.0));
        }
        if (bl3) {
            Vector3f vector3f = jW;
            if (locationBridge_7.hN && !locationBridge_7.hO) {
                vector3f = jX;
            }
            EntityHolder.tK().a(itemDisplay, vector3f, new Quaternionf().identity());
        }
        if (bl && recordOfItemStack.bH() != null) {
            itemDisplayLocationHolder.q(true);
            if (location != null) {
                this.a(itemDisplayLocationHolder, location, false, true);
            }
            itemDisplay.setItemStack(recordOfItemStack.bH());
            PacketListenerRegistry.uN().c((Entity)itemDisplay, this.jY, true);
        } else {
            if (itemDisplayLocationHolder.cH()) {
                Vector3f vector3f = jW;
                if (locationBridge_7.hN && !locationBridge_7.hO) {
                    vector3f = jX;
                }
                EntityHolder.tK().a(itemDisplay, vector3f, new Quaternionf().identity());
                itemDisplayLocationHolder.s(false);
            }
            itemDisplay.setItemStack(recordOfItemStack.bG());
            PacketListenerRegistry.uN().c((Entity)itemDisplay, this.jY, true);
        }
        itemDisplayLocationHolder.kh = by;
        itemDisplayLocationHolder.namespacedId = locationBridge_7.hD;
    }

    public ItemDisplayLocationHolder b(UUID uUID) {
        return (ItemDisplayLocationHolder)this.jZ.get(uUID);
    }

    public void c(UUID uUID) {
        this.c((ItemDisplayLocationHolder)this.jZ.get(uUID));
    }

    public void i(Location location) {
        this.c((ItemDisplayLocationHolder)this.ka.get(ChunkLoadListener.c(location)));
    }

    public void a(Set set) {
        for (UUID uUID : this.jZ.keySet()) {
            if (set.contains(uUID)) continue;
            this.c(uUID);
        }
    }

    private void c(@Nullable ItemDisplayLocationHolder itemDisplayLocationHolder) {
        if (itemDisplayLocationHolder == null || !this.jZ.remove(itemDisplayLocationHolder.kg.getUniqueId(), itemDisplayLocationHolder)) {
            return;
        }
        this.b(itemDisplayLocationHolder);
        Location location = this.jY.getLocation().clone().add(0.0, -1000.0, 0.0);
        PacketListenerRegistry.uN().a((Entity)itemDisplayLocationHolder.kg, this.jY, location);
        itemDisplayLocationHolder.k(location);
        itemDisplayLocationHolder.kg.setItemStack(null);
        PacketListenerRegistry.uN().c((Entity)itemDisplayLocationHolder.kg, this.jY, true);
        this.kc.add(itemDisplayLocationHolder);
    }

    public void l(Chunk chunk) {
        for (ItemDisplayLocationHolder itemDisplayLocationHolder : this.jZ.values()) {
            if (!itemDisplayLocationHolder.cF().equals((Object)chunk)) continue;
            this.c(itemDisplayLocationHolder.kg.getUniqueId());
        }
    }

    public void b(int n, int n2, World world) {
        for (ItemDisplayLocationHolder itemDisplayLocationHolder : this.jZ.values()) {
            if (!itemDisplayLocationHolder.cE().equals((Object)world) || (int)((double)itemDisplayLocationHolder.kn.ha) >> 4 != n || (int)((double)itemDisplayLocationHolder.kn.hc) >> 4 != n2) continue;
            this.c(itemDisplayLocationHolder.kg.getUniqueId());
        }
    }

    public void cy() {
        for (ItemDisplayLocationHolder itemDisplayLocationHolder : this.jZ.values()) {
            PacketListenerRegistry.uN().i((Entity)itemDisplayLocationHolder.kg, this.jY);
        }
        for (ItemDisplayLocationHolder itemDisplayLocationHolder : this.kc) {
            PacketListenerRegistry.uN().i((Entity)itemDisplayLocationHolder.kg, this.jY);
        }
        this.jZ.clear();
        this.ka.clear();
        this.kb.clear();
        this.kc.clear();
    }

    @Nullable
    public ItemDisplayLocationHolder j(Location location) {
        return (ItemDisplayLocationHolder)this.ka.get(ChunkLoadListener.c(location));
    }

    public int cz() {
        return this.jZ.size();
    }

    public NonBlockingHashMapLong cA() {
        return this.ka;
    }

    public void cB() {
        if (this.kc.isEmpty()) {
            return;
        }
        int n = 0;
        long l = System.currentTimeMillis() - 5000L;
        for (ItemDisplayLocationHolder itemDisplayLocationHolder : this.kc) {
            if (itemDisplayLocationHolder.ki > l || !this.kc.remove(itemDisplayLocationHolder)) continue;
            PacketListenerRegistry.uN().i((Entity)itemDisplayLocationHolder.kg, this.jY);
            ++n;
        }
    }

    static {
        jT = (float)Math.toRadians(15.0);
        jU = jT * 0.55f;
        jW = new Vector3f(0.5f, 0.5f, 0.5f);
        jX = new Vector3f(0.5f, 0.44f, 0.5f);
    }
}
