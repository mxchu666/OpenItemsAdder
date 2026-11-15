package itemsadder.m;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PlayerLocationHolder;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public abstract class EntityDamageListenerBase
implements Listener {
    private static EntityDamageListenerBase aji;
    static final double ajj = 4.0;
    protected static final double ajk = 50.0;
    protected Object2ObjectOpenHashMap ajl = new Object2ObjectOpenHashMap();

    public static void register() {
        if (aji != null) {
            throw new IllegalStateException("OrbitCamera is already registered!");
        }
        aji = (EntityDamageListenerBase)NmsWrapperFactory.n(EntityDamageListenerBase.class);
        aji.au();
    }

    public static EntityDamageListenerBase ul() {
        if (aji == null) {
            throw new IllegalStateException("OrbitCamera is not registered yet!");
        }
        return aji;
    }

    public static void O() {
        if (aji == null) {
            return;
        }
        aji.um();
        aji = null;
    }

    protected abstract void um();

    protected abstract void au();

    public abstract boolean i(Player var1, Location var2);

    public void aN(Player player) {
        PlayerLocationHolder playerLocationHolder = (PlayerLocationHolder)this.ajl.remove((Object)player);
        if (playerLocationHolder != null) {
            this.a(playerLocationHolder);
        }
    }

    protected abstract void a(PlayerLocationHolder var1);

    @EventHandler
    public void d(EntityDamageEvent entityDamageEvent) {
        Entity entity = entityDamageEvent.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player)entity;
        this.aN(player);
    }

    @EventHandler
    public void b(PlayerChangedWorldEvent playerChangedWorldEvent) {
        this.aN(playerChangedWorldEvent.getPlayer());
    }

    @EventHandler
    public void a(PlayerTeleportEvent playerTeleportEvent) {
        this.aN(playerTeleportEvent.getPlayer());
    }

    @EventHandler
    public void a(PlayerDeathEvent playerDeathEvent) {
        this.aN(playerDeathEvent.getPlayer());
    }

    @EventHandler
    public void a(PlayerQuitEvent playerQuitEvent) {
        this.aN(playerQuitEvent.getPlayer());
    }

    @EventHandler
    public void b(PlayerToggleSneakEvent playerToggleSneakEvent) {
        this.aN(playerToggleSneakEvent.getPlayer());
    }

    protected static boolean bU(Player player) {
        Location location = player.getEyeLocation();
        for (double d = -1.0; d <= 1.0; d += 1.0) {
            for (double d2 = -1.0; d2 <= 1.0; d2 += 1.0) {
                for (double d3 = -1.0; d3 <= 1.0; d3 += 1.0) {
                    Location location2 = location.clone().add(d, d2, d3);
                    Block block = location2.getBlock();
                    if (!block.getType().isSolid()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    protected static Location a(Location location, float f, float f2) {
        double d = -Math.toRadians(f) + 1.5707963267948966;
        double d2 = Math.toRadians(90.0 + (double)f2);
        d2 = Math.max(0.001, Math.min(3.1405926535897932, d2));
        double d3 = Math.sin(d2);
        double d4 = Math.cos(d2);
        double d5 = Math.cos(d);
        double d6 = Math.sin(d);
        double d7 = location.getX() + 4.0 * d3 * d5;
        double d8 = location.getY() + 4.0 * d4;
        double d9 = location.getZ() + 4.0 * d3 * d6;
        Location location2 = new Location(location.getWorld(), d7, d8, d9);
        return EntityDamageListenerBase.b(location, location2);
    }

    private static Location b(Location location, Location location2) {
        Location location3;
        Vector vector = location2.toVector().subtract(location.toVector());
        double d = vector.length();
        if (d < 1.0E-6) {
            return location2;
        }
        vector.normalize();
        double d2 = 0.2;
        Location location4 = location.clone();
        for (double d3 = d2; d3 <= d && EntityDamageListenerBase.W(location3 = location.clone().add(vector.clone().multiply(d3))); d3 += d2) {
            location4 = location3.clone();
        }
        return location4;
    }

    private static boolean W(Location location) {
        location = location.clone();
        location.add(0.0, 1.6, 0.0);
        double d = 0.05;
        double d2 = 0.3 + d;
        BoundingBox boundingBox = new BoundingBox(location.getX() - d2, location.getY() - d2, location.getZ() - d2, location.getX() + d2, location.getY() + d2, location.getZ() + d2);
        int n = (int)Math.floor(boundingBox.getMinX());
        int n2 = (int)Math.floor(boundingBox.getMaxX());
        int n3 = (int)Math.floor(boundingBox.getMinY());
        int n4 = (int)Math.floor(boundingBox.getMaxY());
        int n5 = (int)Math.floor(boundingBox.getMinZ());
        int n6 = (int)Math.floor(boundingBox.getMaxZ());
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                for (int k = n5; k <= n6; ++k) {
                    BoundingBox boundingBox2;
                    Block block = location.getWorld().getBlockAt(i, j, k);
                    if (!block.getType().isSolid() || !(boundingBox2 = block.getBoundingBox()).overlaps(boundingBox)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    protected static float s(float f) {
        while (f > 180.0f) {
            f -= 360.0f;
        }
        while (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public abstract void a(Object var1, Player var2);

    public abstract void b(Player var1, int ... var2);
}
