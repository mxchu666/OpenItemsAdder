package itemsadder.m;

import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class Opaque026
extends BukkitRunnable {
    final /* synthetic */ Consumer aBe;

    Opaque026(Consumer consumer) {
        this.aBe = consumer;
    }

    public void run() {
        this.aBe.accept(this);
    }
}
