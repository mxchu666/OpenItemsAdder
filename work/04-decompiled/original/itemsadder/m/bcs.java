package itemsadder.m;

import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class bcs
extends BukkitRunnable {
    final /* synthetic */ Consumer aBd;

    bcs(Consumer consumer) {
        this.aBd = consumer;
    }

    public void run() {
        this.aBd.accept(this);
    }
}
