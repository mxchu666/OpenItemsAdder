package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_40;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

@Deprecated
public class InventoryClickListener_6
implements Listener {
    @EventHandler(ignoreCancelled=true)
    private void b(InventoryClickEvent inventoryClickEvent) {
        if (Main.PE) {
            return;
        }
        if (inventoryClickEvent.getInventory().getType() == InventoryType.GRINDSTONE) {
            Inventory inventory = inventoryClickEvent.getInventory();
            int n = inventoryClickEvent.getSlot();
            if (ItemStackBridge_2.i(inventoryClickEvent)) {
                if (n == 0 || n == 1) {
                    BukkitTaskBridge.c(() -> ItemStackBridge_40.a((InventoryEvent)inventoryClickEvent, (T itemStack) -> inventory.setItem(2, itemStack)), 5L);
                } else {
                    ItemStackBridge_40.a((InventoryEvent)inventoryClickEvent, (T itemStack) -> inventory.setItem(2, itemStack));
                }
            } else if (inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT || inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT) {
                BukkitTaskBridge.c(() -> ItemStackBridge_40.a((InventoryEvent)inventoryClickEvent, (T itemStack) -> inventory.setItem(2, itemStack)), 5L);
            }
        }
    }
}
