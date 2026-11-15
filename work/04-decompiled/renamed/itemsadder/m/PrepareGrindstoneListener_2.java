package itemsadder.m;

import itemsadder.m.ItemStackBridge_40;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.PrepareGrindstoneEvent;
import org.bukkit.event.inventory.PrepareInventoryResultEvent;

public class PrepareGrindstoneListener_2
implements Listener {
    @EventHandler
    private void a(PrepareGrindstoneEvent prepareGrindstoneEvent) {
        ItemStackBridge_40.a((InventoryEvent)prepareGrindstoneEvent, arg_0 -> ((PrepareInventoryResultEvent)prepareGrindstoneEvent).setResult(arg_0));
    }
}
