package itemsadder.m;

import itemsadder.m.aab;
import itemsadder.m.arn;
import itemsadder.m.arp;
import java.util.HashSet;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public final class aro {
    private static aro amg;
    private final arn amh = (arn)aab.n(arn.class);

    aro() {
    }

    private static aro vh() {
        if (amg == null) {
            amg = new aro();
        }
        return amg;
    }

    @Nullable
    public static Vector c(Location location, Location location2) {
        return aro.b(location, location2, true);
    }

    @Nullable
    public static Vector b(Location location, Location location2, boolean bl) {
        return aro.vh().amh.a(location, location2, bl);
    }

    @Nullable
    public static Vector b(Location location, double d) {
        return aro.a(location, d, true);
    }

    @Nullable
    public static Vector a(Location location, double d, boolean bl) {
        Location location2 = location.clone();
        location2.add(location.getDirection().normalize().multiply(d));
        return aro.b(location, location2, bl);
    }

    public static arp a(Entity entity, HashSet hashSet) {
        return aro.vh().amh.a(entity, hashSet);
    }
}
