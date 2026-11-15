package itemsadder.m;

import itemsadder.m.BlockHolder;
import itemsadder.m.LocationWrapper_3;
import org.bukkit.Location;

public class LocationBridge_5
implements LocationWrapper_3 {
    @Override
    public void e(Location location, int n) {
        BlockHolder.tl().c(location.getBlock(), n);
    }

    @Override
    public void aj(Location location) {
        BlockHolder.tl().ba(location.getBlock());
    }
}
