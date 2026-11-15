package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class vw
implements ai {
    @EventHandler(ignoreCancelled=true)
    private void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getInventory().getType() != InventoryType.STONECUTTER) {
            return;
        }
        if (inventoryClickEvent.getSlot() != 1) {
            return;
        }
        if (qm.isCustomItem(inventoryClickEvent.getInventory().getStorageContents()[0])) {
            inventoryClickEvent.getInventory().setItem(1, new ItemStack(Material.AIR));
            inventoryClickEvent.getWhoClicked().closeInventory();
        }
    }
}
