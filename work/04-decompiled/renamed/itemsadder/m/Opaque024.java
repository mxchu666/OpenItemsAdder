package itemsadder.m;

import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class Opaque024
extends BukkitRunnable {
    final /* synthetic */ Consumer aBc;

    Opaque024(Consumer consumer) {
        this.aBc = consumer;
    }

    public void run() {
        this.aBc.accept(this);
    }
}
