package itemsadder.m;

import itemsadder.m.aow;
import itemsadder.m.pw;
import itemsadder.m.qb;
import java.util.function.Consumer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Trident;
import org.bukkit.scheduler.BukkitRunnable;

class qa
implements Consumer {
    int CT = 0;
    final /* synthetic */ Trident EX;
    final /* synthetic */ qb EY;

    qa(pw pw2, Trident trident, qb qb2) {
        this.EX = trident;
        this.EY = qb2;
    }

    public void a(BukkitRunnable bukkitRunnable) {
        ++this.CT;
        if (this.CT >= 20 || this.EX.isOnGround() || !this.EX.isValid()) {
            bukkitRunnable.cancel();
            return;
        }
        aow.uN().a((Entity)this.EY.EZ, pw.L(this.EX.getLocation()));
    }

    public /* synthetic */ void accept(Object object) {
        this.a((BukkitRunnable)object);
    }
}
