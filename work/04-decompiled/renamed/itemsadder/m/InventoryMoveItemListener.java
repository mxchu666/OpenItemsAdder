package itemsadder.m;

import itemsadder.m.BlockBridge_9;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerInteractListener_3;
import itemsadder.m.PluginContract;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;

class InventoryMoveItemListener
implements PluginContract {
    final /* synthetic */ PlayerInteractListener_3 zw;

    InventoryMoveItemListener(PlayerInteractListener_3 playerInteractListener_3) {
        this.zw = playerInteractListener_3;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(InventoryMoveItemEvent inventoryMoveItemEvent) {
        if (inventoryMoveItemEvent.getDestination().getType() == InventoryType.JUKEBOX) {
            Jukebox jukebox = (Jukebox)inventoryMoveItemEvent.getDestination().getHolder();
            Block block = jukebox.getBlock();
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            if (this.zw.zu.containsKey(block) || blockBridge_9.Z(block) != null) {
                this.zw.a(block, blockBridge_9);
                jukebox.eject();
            }
        } else if (inventoryMoveItemEvent.getSource().getType() == InventoryType.JUKEBOX) {
            Block block = ((Jukebox)inventoryMoveItemEvent.getSource().getHolder()).getBlock();
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            if (this.zw.zu.containsKey(block) || blockBridge_9.Z(block) != null) {
                this.zw.a(block, blockBridge_9);
            }
        }
    }
}
