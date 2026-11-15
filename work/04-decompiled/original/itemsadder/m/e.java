package itemsadder.m;

import itemsadder.m.bbr;
import itemsadder.m.d;
import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class e
implements Consumer {
    final String bm = bbr.getTitle();

    e(d d2) {
    }

    public void a(BukkitRunnable bukkitRunnable) {
        if (this.bm.equals(bbr.getTitle())) {
            bbr.io(this.bm);
        }
    }

    public /* synthetic */ void accept(Object object) {
        this.a((BukkitRunnable)object);
    }
}
