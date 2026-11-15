package itemsadder.m;

import itemsadder.m.PlayerInteractListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.Chunk;
import org.bukkit.scheduler.BukkitRunnable;

class Opaque107
extends BukkitRunnable {
    final /* synthetic */ AtomicInteger kY;
    final /* synthetic */ List kZ;
    final /* synthetic */ PlayerInteractListener la;

    Opaque107(PlayerInteractListener playerInteractListener, AtomicInteger atomicInteger, List list) {
        this.kY = atomicInteger;
        this.kZ = list;
        this.la = playerInteractListener;
    }

    public void run() {
        if (!this.la.cU() || this.kY.get() >= this.kZ.size()) {
            this.cancel();
            return;
        }
        Chunk chunk = (Chunk)this.kZ.get(this.kY.getAndIncrement());
        this.la.kO.j(chunk);
    }
}
