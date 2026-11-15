package itemsadder.m;

import itemsadder.m.afz;
import itemsadder.m.aow;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.br;
import itemsadder.m.bx;
import itemsadder.m.by;
import itemsadder.m.ce;
import itemsadder.m.cj;
import itemsadder.m.ck;
import itemsadder.m.cl;
import itemsadder.m.d;
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

public class ci {
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
    private volatile cl kd;
    @Nullable
    private Block ke;

    public ci(Player player, int n) {
        this.jY = player;
        jS = n + 20;
    }

    private static long a(int n, int n2) {
        return (long)n << 32 ^ (long)n2 & 0xFFFFFFFFL;
    }

    public void a(cj cj2) {
        if (cj2.cG()) {
            return;
        }
        cj2.r(true);
        int n = cj2.kn.ha >> 4;
        int n2 = cj2.kn.hc >> 4;
        this.kb.computeIfAbsent(ci.a(n, n2), l -> new ConcurrentLinkedQueue()).add(cj2);
        this.jZ.put(cj2.kg.getUniqueId(), cj2);
        this.ka.put(br.a(cj2.kn), (Object)cj2);
    }

    private void b(cj cj2) {
        cj2.r(false);
        int n = cj2.kn.ha >> 4;
        int n2 = cj2.kn.hc >> 4;
        long l = ci.a(n, n2);
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue)this.kb.get(l);
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.removeIf(cj3 -> cj3 == cj2);
            if (concurrentLinkedQueue.isEmpty()) {
                this.kb.remove(l, concurrentLinkedQueue);
            }
        }
        this.ka.remove(br.c(cj2.kp), (Object)cj2);
    }

    private List a(Location location, double d) {
        int n = location.getBlockX() >> 4;
        int n2 = location.getBlockZ() >> 4;
        ArrayList<cj> arrayList = new ArrayList<cj>();
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue)this.kb.get(ci.a(n + i, n2 + j));
                if (concurrentLinkedQueue == null) continue;
                for (cj cj2 : concurrentLinkedQueue) {
                    double d2 = cj2.kn.Dy().distanceSquared((Vector3fc)new Vector3f((float)location.getX(), (float)location.getY(), (float)location.getZ()));
                    if (!(d2 <= (d + 2.0) * (d + 2.0))) continue;
                    arrayList.add(cj2);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public cj K(Player player) {
        return this.c(player, true);
    }

    @Nullable
    cj c(Player player, boolean bl) {
        cj cj2;
        Location location = player.getEyeLocation();
        Vector vector = location.getDirection();
        Vector vector2 = location.toVector();
        double d = player.getGameMode() == GameMode.CREATIVE ? Objects.requireNonNull(player.getAttribute(Attribute.PLAYER_BLOCK_INTERACTION_RANGE)).getValue() : 4.5;
        RayTraceResult rayTraceResult = player.getWorld().rayTraceBlocks(location, vector, d, FluidCollisionMode.NEVER, true);
        this.ke = rayTraceResult == null ? null : rayTraceResult.getHitBlock();
        double d2 = rayTraceResult == null ? d * d : rayTraceResult.getHitPosition().distanceSquared(vector2);
        long l = player.getWorld().getFullTime();
        if (bl && this.kd != null && this.kd.kz != null && this.kd.kz.kf && l - this.kd.kA < 3L && this.kd.ky == d && this.kd.kw.distanceSquared(vector2) < 0.04 && (double)this.kd.kx.angle(vector) < Math.toRadians(2.5) && (cj2 = this.kd.kz.ko.a(vector2, vector, d2)) != null) {
            return this.kd.kz;
        }
        cj2 = null;
        for (cj cj3 : this.a(location, d)) {
            Vector vector3;
            if (!cj3.cG() || (vector3 = cj3.ko.a(vector2, vector, d2)) == null) continue;
            double d3 = vector3.distanceSquared(vector2);
            cj2 = cj3;
            d2 = d3;
        }
        this.kd = cj2 == null ? null : new cl(vector2, vector, d, cj2, l);
        return cj2;
    }

    @Nullable
    Block cw() {
        return this.ke;
    }

    public void a(Location location, String string, byte by) {
        Location location2 = this.jY.getLocation();
        boolean bl = ce.iE && bcc.h(location, location2) >= (double)ce.iF;
        this.a(true, null, string, by, location, bl, location2);
    }

    @Nullable
    public cj a(boolean bl, @Nullable bx bx2, String string, byte by2, Location location, boolean bl2, @Nullable Location location2) {
        cj cj2 = null;
        if (bl) {
            cj2 = this.j(location);
        }
        if (cj2 == null && (cj2 = (cj)this.kc.poll()) == null && this.jZ.size() < jS) {
            cj2 = this.cx();
        }
        if (cj2 == null) {
            return null;
        }
        boolean bl3 = bcc.a(location, cj2.kn);
        if (bl3) {
            if (!cj2.a(by2, string, bl2, false)) {
                cj2.cC();
                this.a(cj2);
                return cj2;
            }
        } else {
            cj2.k(location);
        }
        if (bx2 == null) {
            bx2 = (bx)d.g().ab.get(string);
        }
        if (bx2 == null) {
            return null;
        }
        cj2.namespacedId = string;
        cj2.kh = by2;
        cj2.cC();
        this.a(cj2, bx2, by2, bl2, location2, true, true);
        if (!bl3) {
            aow.uN().a((Entity)cj2.kg, this.jY, location);
        }
        this.a(cj2);
        return cj2;
    }

    private cj cx() {
        Location location = this.jY.getLocation().clone().add(0.0, -1000.0, 0.0);
        ItemDisplay itemDisplay2 = aow.uN().b(location, itemDisplay -> {
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
        aow.uN().h((Entity)itemDisplay2, this.jY);
        return new cj(itemDisplay2, location, null, 0);
    }

    public void a(cj cj2, Location location, boolean bl, boolean bl2) {
        double d2 = cj2.getLocation().getX();
        double d3 = cj2.getLocation().getZ();
        double d4 = location.getX();
        double d5 = location.getZ();
        float f2 = -((float)FastMath.atan2((double)(d5 - d3), (double)(d4 - d2)) - 1.5707964f);
        long l = this.jY.getWorld().getTime();
        float f3 = Math.abs(cj2.kk - f2);
        if (bl2 || f3 > jU || l - cj2.kl >= 5L) {
            afz.tK().a(cj2.kg, jW, new Quaternionf().rotationY(f2));
            cj2.kk = f2;
            cj2.kl = l;
            if (bl) {
                aow.uN().c((Entity)cj2.kg, this.jY, true);
            }
        }
    }

    public void a(cj cj2, bx bx2, byte by2, boolean bl, @Nullable Location location, boolean bl2, boolean bl3) {
        by by3 = bx2.a(by2);
        if (by3 == null) {
            by3 = bx2.f(0);
        }
        if (by3 == null) {
            bce.warn("Crop with namespaced ID " + bx2.hD + " has no age status for age " + by2 + " or 0, cannot update display!");
            return;
        }
        ItemDisplay itemDisplay = cj2.kg;
        if (bl2) {
            double d2 = cj2.getLocation().getX() + 0.5;
            double d3 = cj2.getLocation().getY();
            double d4 = cj2.getLocation().getZ() + 0.5;
            double d5 = by3.bJ() != null ? (double)by3.bJ().floatValue() : (double)bx2.hI.aBp;
            double d6 = by3.bK() != null ? (double)by3.bK().floatValue() : (double)bx2.hI.aBq;
            double d7 = by3.bI() != null ? (double)by3.bI().floatValue() : (double)bx2.hI.aBr;
            cj2.a(new ck(d2 - d5 / 2.0, d3, d4 - d7 / 2.0, d2 + d5 / 2.0, d3 + d6, d4 + d7 / 2.0));
        }
        if (bl3) {
            Vector3f vector3f = jW;
            if (bx2.hN && !bx2.hO) {
                vector3f = jX;
            }
            afz.tK().a(itemDisplay, vector3f, new Quaternionf().identity());
        }
        if (bl && by3.bH() != null) {
            cj2.q(true);
            if (location != null) {
                this.a(cj2, location, false, true);
            }
            itemDisplay.setItemStack(by3.bH());
            aow.uN().c((Entity)itemDisplay, this.jY, true);
        } else {
            if (cj2.cH()) {
                Vector3f vector3f = jW;
                if (bx2.hN && !bx2.hO) {
                    vector3f = jX;
                }
                afz.tK().a(itemDisplay, vector3f, new Quaternionf().identity());
                cj2.s(false);
            }
            itemDisplay.setItemStack(by3.bG());
            aow.uN().c((Entity)itemDisplay, this.jY, true);
        }
        cj2.kh = by2;
        cj2.namespacedId = bx2.hD;
    }

    public cj b(UUID uUID) {
        return (cj)this.jZ.get(uUID);
    }

    public void c(UUID uUID) {
        this.c((cj)this.jZ.get(uUID));
    }

    public void i(Location location) {
        this.c((cj)this.ka.get(br.c(location)));
    }

    public void a(Set set) {
        for (UUID uUID : this.jZ.keySet()) {
            if (set.contains(uUID)) continue;
            this.c(uUID);
        }
    }

    private void c(@Nullable cj cj2) {
        if (cj2 == null || !this.jZ.remove(cj2.kg.getUniqueId(), cj2)) {
            return;
        }
        this.b(cj2);
        Location location = this.jY.getLocation().clone().add(0.0, -1000.0, 0.0);
        aow.uN().a((Entity)cj2.kg, this.jY, location);
        cj2.k(location);
        cj2.kg.setItemStack(null);
        aow.uN().c((Entity)cj2.kg, this.jY, true);
        this.kc.add(cj2);
    }

    public void l(Chunk chunk) {
        for (cj cj2 : this.jZ.values()) {
            if (!cj2.cF().equals((Object)chunk)) continue;
            this.c(cj2.kg.getUniqueId());
        }
    }

    public void b(int n, int n2, World world) {
        for (cj cj2 : this.jZ.values()) {
            if (!cj2.cE().equals((Object)world) || (int)((double)cj2.kn.ha) >> 4 != n || (int)((double)cj2.kn.hc) >> 4 != n2) continue;
            this.c(cj2.kg.getUniqueId());
        }
    }

    public void cy() {
        for (cj cj2 : this.jZ.values()) {
            aow.uN().i((Entity)cj2.kg, this.jY);
        }
        for (cj cj2 : this.kc) {
            aow.uN().i((Entity)cj2.kg, this.jY);
        }
        this.jZ.clear();
        this.ka.clear();
        this.kb.clear();
        this.kc.clear();
    }

    @Nullable
    public cj j(Location location) {
        return (cj)this.ka.get(br.c(location));
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
        for (cj cj2 : this.kc) {
            if (cj2.ki > l || !this.kc.remove(cj2)) continue;
            aow.uN().i((Entity)cj2.kg, this.jY);
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
