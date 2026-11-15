package itemsadder.m;

import itemsadder.m.cg;
import itemsadder.m.ci;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.Location;
import org.bukkit.entity.Player;

final class cf
extends Record {
    private final Player iW;
    private final cg iX;
    private final ci iY;
    private final Location iZ;
    private final Location ja;
    private final double jb;
    private final int jc;
    private final int jd;
    private final boolean je;
    private final long jf;

    private cf(Player player, cg cg2, ci ci2, Location location, Location location2, double d, int n, int n2, boolean bl, long l) {
        this.iW = player;
        this.iX = cg2;
        this.iY = ci2;
        this.iZ = location;
        this.ja = location2;
        this.jb = d;
        this.jc = n;
        this.jd = n2;
        this.je = bl;
        this.jf = l;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{cf.class, "player;state;pool;location;eyeLocation;distanceFromFloor;currentTick;playerIndex;forceUpdate;lifecycleGeneration", "iW", "iX", "iY", "iZ", "ja", "jb", "jc", "jd", "je", "jf"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{cf.class, "player;state;pool;location;eyeLocation;distanceFromFloor;currentTick;playerIndex;forceUpdate;lifecycleGeneration", "iW", "iX", "iY", "iZ", "ja", "jb", "jc", "jd", "je", "jf"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{cf.class, "player;state;pool;location;eyeLocation;distanceFromFloor;currentTick;playerIndex;forceUpdate;lifecycleGeneration", "iW", "iX", "iY", "iZ", "ja", "jb", "jc", "jd", "je", "jf"}, this, object);
    }

    public Player bW() {
        return this.iW;
    }

    public cg bX() {
        return this.iX;
    }

    public ci bY() {
        return this.iY;
    }

    public Location bZ() {
        return this.iZ;
    }

    public Location ca() {
        return this.ja;
    }

    public double cb() {
        return this.jb;
    }

    public int cc() {
        return this.jc;
    }

    public int cd() {
        return this.jd;
    }

    public boolean ce() {
        return this.je;
    }

    public long cf() {
        return this.jf;
    }
}
