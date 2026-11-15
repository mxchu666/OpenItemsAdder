package itemsadder.m;

import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class Opaque025
extends BukkitRunnable {
    final /* synthetic */ Consumer aBd;

    Opaque025(Consumer consumer) {
        this.aBd = consumer;
    }

    public void run() {
        this.aBd.accept(this);
    }
}
