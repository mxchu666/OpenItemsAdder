package itemsadder.m;

import itemsadder.m.aqa;
import itemsadder.m.bce;
import itemsadder.m.dx;
import itemsadder.m.eb;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class ee
extends eb {
    public dx pR;
    public Particle pS;
    public float pT;
    public int pU;
    float pV;
    float pW;
    float pX;
    static final /* synthetic */ boolean pY;

    public ee(dx dx2, String string, float f, int n, float f2, float f3, float f4) {
        this.pR = dx2;
        this.pS = aqa.uU().dM(string);
        if (this.pS == null) {
            bce.error("Unknown particle '" + string + "' for locator " + dx2.getNamespacedID());
        }
        this.pT = f;
        this.pU = n;
        this.pV = f2;
        this.pW = f3;
        this.pX = f4;
    }

    @Override
    public void t(Location location) {
        if (this.pS == null) {
            return;
        }
        for (Player player : location.getWorld().getPlayers()) {
            if (!(location.distance(player.getLocation()) < 32.0)) continue;
            this.b(player, location.getX(), location.getY(), location.getZ());
        }
    }

    public void a(Location location, double d, double d2, double d3) {
        if (this.pS == null) {
            return;
        }
        for (Player player : location.getWorld().getPlayers()) {
            if (!(location.distance(player.getLocation()) < 32.0)) continue;
            this.b(player, d, d2, d3);
        }
    }

    public void a(Player player, double d, double d2, double d3) {
        if (this.pS == null) {
            return;
        }
        this.b(player, d, d2, d3);
    }

    private void b(Player player, double d, double d2, double d3) {
        Object object = ee.a(this.pS.getDataType());
        if (object != null) {
            player.spawnParticle(this.pS, d, d2, d3, this.pU, (double)this.pV, (double)this.pW, (double)this.pX, (double)this.pT, object);
        } else {
            player.spawnParticle(this.pS, d, d2, d3, this.pU, (double)this.pV, (double)this.pW, (double)this.pX, (double)this.pT);
        }
    }

    private static Object a(Class clazz) {
        return clazz == Color.class ? Color.WHITE : null;
    }

    static {
        boolean bl = pY = !ee.class.desiredAssertionStatus();
        if (!(pY || ee.a(Color.class) == Color.WHITE && ee.a(Void.class) == null)) {
            throw new AssertionError();
        }
    }
}
