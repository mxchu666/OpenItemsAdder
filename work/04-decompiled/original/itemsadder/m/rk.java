package itemsadder.m;

import itemsadder.m.d;
import itemsadder.m.ij;
import itemsadder.m.qm;
import itemsadder.m.rl;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class rk {
    public final ij Ih;
    public long Ii;
    public final qm Ij;
    long Ik;
    private boolean Il;
    private long Im;
    private int jc;
    public int In;

    public rk(qm qm2, ij ij2) {
        this.Ih = ij2;
        this.Ij = qm2;
        this.Ik = qm2.mU();
        this.Il = true;
        this.oi();
    }

    public long od() {
        long l = this.Ik - this.oe();
        if (l < 0L) {
            return 0L;
        }
        return l;
    }

    public long oe() {
        return System.currentTimeMillis() - this.Ii;
    }

    public boolean lt() {
        return this.oe() >= this.Ik;
    }

    public String of() {
        long l = this.od();
        this.Im = TimeUnit.MILLISECONDS.toSeconds(l);
        return rk.j(l);
    }

    static String j(long l) {
        long l2 = TimeUnit.MILLISECONDS.toSeconds(Math.max(0L, l));
        long l3 = TimeUnit.SECONDS.toHours(l2);
        long l4 = TimeUnit.SECONDS.toMinutes(l2) % 60L;
        return l3 > 0L ? String.format(Locale.ROOT, "%d:%02d:%02d", l3, l4, l2 % 60L) : String.format(Locale.ROOT, "%02d:%02d", l4, l2 % 60L);
    }

    public boolean og() {
        return TimeUnit.MILLISECONDS.toSeconds(this.Ik - this.oe()) != this.Im;
    }

    public boolean oh() {
        return this.jc++ == 0;
    }

    public void a(float f2, Player player) {
        this.Ih.k(f2);
        d.g().ao.al(player);
    }

    public void oi() {
        this.Ii = System.currentTimeMillis();
    }

    public void a(boolean bl, Player player) {
        this.Il = bl;
        if (bl && this.lt()) {
            return;
        }
        if (this.Ij.nk() == rl.HUD) {
            ij ij2 = d.g().ao.d(player, this.Ij.nj().Id);
            if (ij2 == null) {
                return;
            }
            if (bl && ij2.jW() == 0.0f) {
                return;
            }
            ij2.setVisible(bl);
            d.g().ao.al(player);
        } else if (this.Ij.nk() == rl.TITLE) {
            if (!bl) {
                player.sendTitle(" ", " ", 0, 0, 0);
            }
        } else {
            BossBar bossBar = d.g().ar.Co.aT(player);
            if (bossBar != null) {
                if (bl && bossBar.getProgress() == 0.0) {
                    return;
                }
                if (bl) {
                    bossBar.show();
                } else {
                    d.g().ar.Co.aU(player);
                    bossBar.hide();
                }
            }
        }
    }

    public boolean oj() {
        return this.Il;
    }

    public void ok() {
        ++this.In;
    }

    public void ol() {
        this.In = 0;
    }
}
