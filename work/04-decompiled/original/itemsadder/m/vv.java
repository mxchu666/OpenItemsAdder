package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.qm;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;

public class vv
implements ai {
    @EventHandler(ignoreCancelled=true)
    private void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getInventory().getType() != InventoryType.BEACON) {
            return;
        }
        if (inventoryClickEvent.getSlot() == 0) {
            if (qm.isCustomItem(inventoryClickEvent.getCursor())) {
                inventoryClickEvent.setCancelled(true);
            }
        } else if (inventoryClickEvent.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY && qm.isCustomItem(inventoryClickEvent.getCurrentItem())) {
            inventoryClickEvent.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void a(InventoryDragEvent inventoryDragEvent) {
        if (inventoryDragEvent.getInventory().getType() != InventoryType.BEACON) {
            return;
        }
        if (inventoryDragEvent.getRawSlots().contains(0) && (qm.isCustomItem(inventoryDragEvent.getCursor()) || qm.isCustomItem(inventoryDragEvent.getOldCursor()))) {
            inventoryDragEvent.setCancelled(true);
        }
    }
}
