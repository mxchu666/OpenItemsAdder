package itemsadder.m;

import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridge_2;
import java.util.Objects;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class PlayerBridge_7 {
    public Player iW;
    private final LivingEntityBuilder nG;
    private boolean nH;
    private boolean nI;
    private boolean nJ;
    double nK;
    double nL;
    private boolean nM;
    boolean nN;

    public PlayerBridge_7(Player player, LivingEntityBuilder livingEntityBuilder) {
        this.iW = player;
        this.nG = livingEntityBuilder;
        this.nH = true;
    }

    public boolean fl() {
        return this.nH || this.nM;
    }

    public synchronized boolean fm() {
        return this.nI;
    }

    public synchronized boolean fn() {
        return this.nJ;
    }

    public void fo() {
        Location location = this.iW.getLocation();
        if (Objects.equals(location.getWorld(), this.nG.ed().getWorld())) {
            double d = location.distance(this.nG.ed());
            this.nK = this.nG.et().pF != null ? Math.max(d - (double)this.nG.et().pF.aBp, 0.0) : d;
            this.nL = LocationBridge_2.h(location, this.nG.ed());
        } else {
            this.nK = -1.0;
            this.nL = -1.0;
        }
        this.nM = LivingEntityRegistry.db().b((LivingEntity)this.iW, this.nG);
    }

    public void fp() {
        if (!this.iW.getWorld().equals((Object)this.nG.cE())) {
            this.nH = false;
            this.nI = false;
            this.nJ = false;
            return;
        }
        if (this.nK == -1.0) {
            this.nH = false;
            this.nI = false;
            this.nJ = false;
        } else {
            this.nH = this.d(this.nK);
            if (this.nH) {
                this.nI = !this.fq();
                this.nJ = !this.fq();
            } else {
                this.nI = false;
                this.nJ = false;
            }
        }
    }

    boolean fq() {
        int n = this.nG.ec().qh;
        boolean bl = false;
        if (this.nK >= 70.0) {
            bl = n % 9 != 0;
        } else if (this.nK >= 60.0) {
            bl = n % 8 != 0;
        } else if (this.nK >= 50.0) {
            bl = n % 6 != 0;
        } else if (this.nK >= 30.0) {
            bl = n % 2 != 0;
        }
        return bl;
    }

    boolean d(double d) {
        if (d <= 2.0) {
            return true;
        }
        if (d >= this.nG.nz) {
            return false;
        }
        return this.nG.ae(this.iW);
    }

    public boolean fr() {
        return this.nK >= 0.0 && this.nK <= 30.0;
    }

    public boolean fs() {
        return this.nN;
    }
}
