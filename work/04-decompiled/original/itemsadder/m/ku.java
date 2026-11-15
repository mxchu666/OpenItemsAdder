package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.d;
import itemsadder.m.kt;
import itemsadder.m.ms;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;

class ku
implements ai {
    final /* synthetic */ kt zw;

    ku(kt kt2) {
        this.zw = kt2;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(InventoryMoveItemEvent inventoryMoveItemEvent) {
        if (inventoryMoveItemEvent.getDestination().getType() == InventoryType.JUKEBOX) {
            Jukebox jukebox = (Jukebox)inventoryMoveItemEvent.getDestination().getHolder();
            Block block = jukebox.getBlock();
            ms ms2 = d.g().b(block);
            if (this.zw.zu.containsKey(block) || ms2.Z(block) != null) {
                this.zw.a(block, ms2);
                jukebox.eject();
            }
        } else if (inventoryMoveItemEvent.getSource().getType() == InventoryType.JUKEBOX) {
            Block block = ((Jukebox)inventoryMoveItemEvent.getSource().getHolder()).getBlock();
            ms ms3 = d.g().b(block);
            if (this.zw.zu.containsKey(block) || ms3.Z(block) != null) {
                this.zw.a(block, ms3);
            }
        }
    }
}
