package itemsadder.m;

import itemsadder.m.vx;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.PrepareGrindstoneEvent;
import org.bukkit.event.inventory.PrepareInventoryResultEvent;

public class wa
implements Listener {
    @EventHandler
    private void a(PrepareGrindstoneEvent prepareGrindstoneEvent) {
        vx.a((InventoryEvent)prepareGrindstoneEvent, arg_0 -> ((PrepareInventoryResultEvent)prepareGrindstoneEvent).setResult(arg_0));
    }
}
