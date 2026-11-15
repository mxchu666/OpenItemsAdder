package itemsadder.m;

import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class bct
extends BukkitRunnable {
    final /* synthetic */ Consumer aBe;

    bct(Consumer consumer) {
        this.aBe = consumer;
    }

    public void run() {
        this.aBe.accept(this);
    }
}
