package itemsadder.m;

import itemsadder.m.LocationWrapper;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.NothingEnum;
import java.util.HashSet;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public final class LocationHolder {
    private static LocationHolder amg;
    private final LocationWrapper amh = (LocationWrapper)NmsWrapperFactory.n(LocationWrapper.class);

    LocationHolder() {
    }

    private static LocationHolder vh() {
        if (amg == null) {
            amg = new LocationHolder();
        }
        return amg;
    }

    @Nullable
    public static Vector c(Location location, Location location2) {
        return LocationHolder.b(location, location2, true);
    }

    @Nullable
    public static Vector b(Location location, Location location2, boolean bl) {
        return LocationHolder.vh().amh.a(location, location2, bl);
    }

    @Nullable
    public static Vector b(Location location, double d) {
        return LocationHolder.a(location, d, true);
    }

    @Nullable
    public static Vector a(Location location, double d, boolean bl) {
        Location location2 = location.clone();
        location2.add(location.getDirection().normalize().multiply(d));
        return LocationHolder.b(location, location2, bl);
    }

    public static NothingEnum a(Entity entity, HashSet hashSet) {
        return LocationHolder.vh().amh.a(entity, hashSet);
    }
}
