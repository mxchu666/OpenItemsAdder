package itemsadder.m;

import com.destroystokyo.paper.event.inventory.PrepareGrindstoneEvent;
import itemsadder.m.ItemStackBridge_40;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;

public class PrepareGrindstoneListener
implements Listener {
    @EventHandler
    private void a(PrepareGrindstoneEvent prepareGrindstoneEvent) {
        ItemStackBridge_40.a((InventoryEvent)prepareGrindstoneEvent, arg_0 -> ((PrepareGrindstoneEvent)prepareGrindstoneEvent).setResult(arg_0));
    }
}
