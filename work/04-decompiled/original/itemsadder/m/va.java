package itemsadder.m;

import itemsadder.m.asg;
import itemsadder.m.bev;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class va
implements Listener {
    public va(Plugin plugin) {
        bev.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    public void c(PlayerJoinEvent playerJoinEvent) {
        asg.cg(playerJoinEvent.getPlayer());
    }
}
