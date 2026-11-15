package itemsadder.m;

import java.util.WeakHashMap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

class PlayerQuitListener_2
implements Listener {
    final /* synthetic */ WeakHashMap azn;

    PlayerQuitListener_2(WeakHashMap weakHashMap) {
        this.azn = weakHashMap;
    }

    @EventHandler
    public void c(PlayerQuitEvent playerQuitEvent) {
        this.azn.remove(playerQuitEvent.getPlayer().getUniqueId());
    }
}
