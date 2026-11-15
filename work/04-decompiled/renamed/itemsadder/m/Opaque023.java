package itemsadder.m;

import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class Opaque023
extends BukkitRunnable {
    final /* synthetic */ Consumer aBb;

    Opaque023(Consumer consumer) {
        this.aBb = consumer;
    }

    public void run() {
        this.aBb.accept(this);
    }
}
