package itemsadder.m;

import itemsadder.m.ListenerBridge;
import itemsadder.m.PlayerHolder_5;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener_8
implements Listener {
    public PlayerJoinListener_8(Plugin plugin) {
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void c(PlayerJoinEvent playerJoinEvent) {
        PlayerHolder_5.cg(playerJoinEvent.getPlayer());
    }
}
