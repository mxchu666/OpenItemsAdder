package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PluginContract;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryClickListener_4
implements PluginContract {
    @EventHandler(ignoreCancelled=true)
    private void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getInventory().getType() != InventoryType.BEACON) {
            return;
        }
        if (inventoryClickEvent.getSlot() == 0) {
            if (ItemStackBuilder_4.isCustomItem(inventoryClickEvent.getCursor())) {
                inventoryClickEvent.setCancelled(true);
            }
        } else if (inventoryClickEvent.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY && ItemStackBuilder_4.isCustomItem(inventoryClickEvent.getCurrentItem())) {
            inventoryClickEvent.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void a(InventoryDragEvent inventoryDragEvent) {
        if (inventoryDragEvent.getInventory().getType() != InventoryType.BEACON) {
            return;
        }
        if (inventoryDragEvent.getRawSlots().contains(0) && (ItemStackBuilder_4.isCustomItem(inventoryDragEvent.getCursor()) || ItemStackBuilder_4.isCustomItem(inventoryDragEvent.getOldCursor()))) {
            inventoryDragEvent.setCancelled(true);
        }
    }
}
