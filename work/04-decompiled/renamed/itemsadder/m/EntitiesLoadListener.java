package itemsadder.m;

import itemsadder.m.EntityDismountListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkEvent;
import org.bukkit.event.world.EntitiesLoadEvent;

public class EntitiesLoadListener
implements Listener {
    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(EntitiesLoadEvent entitiesLoadEvent) {
        EntityDismountListener.a((ChunkEvent)entitiesLoadEvent, false);
    }
}
