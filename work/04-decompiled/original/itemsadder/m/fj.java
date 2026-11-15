package itemsadder.m;

import itemsadder.m.fl;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bukkit.Location;
import org.bukkit.entity.Player;

final class fj {
    private final UUID sL;
    private final fl sM;
    private final AtomicBoolean sN = new AtomicBoolean(true);
    private final AtomicBoolean sO = new AtomicBoolean();
    private final AtomicBoolean sP = new AtomicBoolean();
    private final ArrayList sQ = new ArrayList();
    private UUID hr;
    private UUID sR;
    private long sS;
    private volatile double jO;
    private volatile double jQ;
    private volatile int sT;
    private volatile int sU = Integer.MAX_VALUE;
    private int sV = Integer.MIN_VALUE;
    private int sW;
    private int sX;
    private int sY;
    private int sZ;

    private fj(Player player, int n, int n2) {
        this.sL = player.getUniqueId();
        this.hr = player.getWorld().getUID();
        this.sM = new fl(n, n2);
    }

    private boolean v(Location location) {
        int n = fj.g(location.getX() * 2.0);
        int n2 = fj.g(location.getY() * 2.0);
        int n3 = fj.g(location.getZ() * 2.0);
        int n4 = fj.g(location.getYaw() / 5.0f);
        int n5 = fj.g(location.getPitch() / 5.0f);
        if (n == this.sV && n2 == this.sW && n3 == this.sX && n4 == this.sY && n5 == this.sZ) {
            return false;
        }
        this.sV = n;
        this.sW = n2;
        this.sX = n3;
        this.sY = n4;
        this.sZ = n5;
        return true;
    }

    private void w(Location location) {
        this.v(location);
    }

    private static int g(double d) {
        int n = (int)d;
        return d < (double)n ? n - 1 : n;
    }
}
