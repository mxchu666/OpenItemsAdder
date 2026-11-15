package itemsadder.m;

import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class bcq
extends BukkitRunnable {
    final /* synthetic */ Consumer aBb;

    bcq(Consumer consumer) {
        this.aBb = consumer;
    }

    public void run() {
        this.aBb.accept(this);
    }
}
