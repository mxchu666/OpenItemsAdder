package itemsadder.m;

import itemsadder.m.eo;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkEvent;
import org.bukkit.event.world.EntitiesLoadEvent;

public class ep
implements Listener {
    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(EntitiesLoadEvent entitiesLoadEvent) {
        eo.a((ChunkEvent)entitiesLoadEvent, false);
    }
}
