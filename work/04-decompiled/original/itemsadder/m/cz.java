package itemsadder.m;

import itemsadder.m.aad;
import itemsadder.m.ana;
import itemsadder.m.aqp;
import itemsadder.m.bcp;
import itemsadder.m.bcv;
import itemsadder.m.dn;
import itemsadder.m.dt;
import itemsadder.m.du;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Nullable;

public class cz {
    public Player iW;
    public dn renderer;
    private final boolean li;
    public AtomicBoolean lj;
    @Nullable
    private Float lk;
    @Nullable
    private Float ll;
    @Nullable
    BukkitTask lm;
    @Nullable
    du ln;

    public cz(Player player, dn dn2, boolean bl) {
        this.iW = player;
        this.renderer = dn2;
        this.li = bl;
        this.lj = new AtomicBoolean();
    }

    public void cY() {
        dt dt2;
        if (this.renderer.mN != null && this.renderer.mN.qb != null && this.renderer.mN.qb.oN) {
            ana.ul().i(this.iW, this.iW.getLocation().add(0.0, 1.5, 0.0));
        }
        aad.tf().bC(this.iW);
        this.renderer.eO();
        if (this.li && (dt2 = this.renderer.mN.qb) != null) {
            if (!dt2.oM) {
                bcp.i(() -> aqp.bY(this.iW));
            } else {
                this.lk = Float.valueOf(this.iW.getWalkSpeed());
                this.ll = Float.valueOf(this.iW.getFlySpeed());
                if (dt2.oW != null) {
                    this.iW.setWalkSpeed(dt2.oW.floatValue());
                }
                if (dt2.oX != null) {
                    this.iW.setFlySpeed(dt2.oX.floatValue());
                }
                this.ln = dt2.fM();
                if (this.ln != null) {
                    if (this.ln.fR() > 0.0f) {
                        this.lm = bcp.b(bukkitRunnable -> bcv.a(this.iW.getLocation(), this.ln.fN(), this.ln.fO(), this.ln.fP(), this.ln.fQ()), 0L, (long)(this.ln.fR() * 20.0f));
                    } else {
                        bcv.a(this.iW.getLocation(), this.ln.fN(), this.ln.fO(), this.ln.fP(), this.ln.fQ());
                    }
                }
            }
        }
        if (this.renderer.my.fu() > 0.0f) {
            if (this.ll == null) {
                this.ll = Float.valueOf(this.iW.getFlySpeed());
            }
            this.iW.setFlySpeed(this.renderer.my.fu());
            this.iW.setAllowFlight(true);
            this.iW.setFlying(true);
        }
    }

    public void cZ() {
        ana.ul().aN(this.iW);
        if (this.lk != null) {
            this.iW.setWalkSpeed(this.lk.floatValue());
        }
        if (this.ll != null) {
            this.iW.setFlySpeed(this.ll.floatValue());
        }
        aad.tf().bD(this.iW);
        if (this.lj.get()) {
            return;
        }
        this.lj.set(true);
        if (this.li) {
            aqp.bX(this.iW);
        }
        if (this.renderer.my.fu() > 0.0f) {
            this.iW.setAllowFlight(false);
            this.iW.setFlying(false);
            this.iW.setFlySpeed(this.ll != null ? this.ll.floatValue() : 0.1f);
        }
        if (this.lm != null) {
            this.lm.cancel();
            this.lm = null;
            if (this.ln != null) {
                bcv.a(this.iW.getLocation(), this.ln.fO(), this.ln.fN());
            }
        }
        this.iW.updateInventory();
    }
}
