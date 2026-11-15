package itemsadder.m;

import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class bcr
extends BukkitRunnable {
    final /* synthetic */ Consumer aBc;

    bcr(Consumer consumer) {
        this.aBc = consumer;
    }

    public void run() {
        this.aBc.accept(this);
    }
}
