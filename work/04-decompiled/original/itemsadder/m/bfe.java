package itemsadder.m;

import itemsadder.m.abk;
import itemsadder.m.bfd;
import org.bukkit.Location;

public class bfe
implements bfd {
    @Override
    public void e(Location location, int n) {
        abk.tl().c(location.getBlock(), n);
    }

    @Override
    public void aj(Location location) {
        abk.tl().ba(location.getBlock());
    }
}
