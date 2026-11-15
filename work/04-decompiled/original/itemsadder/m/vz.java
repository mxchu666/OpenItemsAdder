package itemsadder.m;

import com.destroystokyo.paper.event.inventory.PrepareGrindstoneEvent;
import itemsadder.m.vx;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;

public class vz
implements Listener {
    @EventHandler
    private void a(PrepareGrindstoneEvent prepareGrindstoneEvent) {
        vx.a((InventoryEvent)prepareGrindstoneEvent, arg_0 -> ((PrepareGrindstoneEvent)prepareGrindstoneEvent).setResult(arg_0));
    }
}
