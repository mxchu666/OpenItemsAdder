package itemsadder.m;

import java.util.WeakHashMap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

class bat
implements Listener {
    final /* synthetic */ WeakHashMap azn;

    bat(WeakHashMap weakHashMap) {
        this.azn = weakHashMap;
    }

    @EventHandler
    public void c(PlayerQuitEvent playerQuitEvent) {
        this.azn.remove(playerQuitEvent.getPlayer().getUniqueId());
    }
}
