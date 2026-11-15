package itemsadder.m;

import itemsadder.m.ItemDisplayTridentHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.ProjectileLaunchListener;
import java.util.function.Consumer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Trident;
import org.bukkit.scheduler.BukkitRunnable;

class TridentBridge
implements Consumer {
    int CT = 0;
    final /* synthetic */ Trident EX;
    final /* synthetic */ ItemDisplayTridentHolder EY;

    TridentBridge(ProjectileLaunchListener projectileLaunchListener, Trident trident, ItemDisplayTridentHolder itemDisplayTridentHolder) {
        this.EX = trident;
        this.EY = itemDisplayTridentHolder;
    }

    public void a(BukkitRunnable bukkitRunnable) {
        ++this.CT;
        if (this.CT >= 20 || this.EX.isOnGround() || !this.EX.isValid()) {
            bukkitRunnable.cancel();
            return;
        }
        PacketListenerRegistry.uN().a((Entity)this.EY.EZ, ProjectileLaunchListener.L(this.EX.getLocation()));
    }

    public /* synthetic */ void accept(Object object) {
        this.a((BukkitRunnable)object);
    }
}
