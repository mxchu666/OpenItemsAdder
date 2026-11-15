package itemsadder.m;

import itemsadder.m.BossBarBridge_2;
import itemsadder.m.ItemStackRegistry;
import java.util.function.Consumer;
import org.bukkit.scheduler.BukkitRunnable;

class BukkitRunnableBridge
implements Consumer {
    final String bm = BossBarBridge_2.getTitle();

    BukkitRunnableBridge(ItemStackRegistry itemStackRegistry) {
    }

    public void a(BukkitRunnable bukkitRunnable) {
        if (this.bm.equals(BossBarBridge_2.getTitle())) {
            BossBarBridge_2.io(this.bm);
        }
    }

    public /* synthetic */ void accept(Object object) {
        this.a((BukkitRunnable)object);
    }
}
