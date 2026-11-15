package itemsadder.m;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BlockDestroyListener_2
implements Listener {
    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    private void a(BlockDestroyEvent blockDestroyEvent) {
        BlockBridge_9 blockBridge_9;
        String string;
        Block block = blockDestroyEvent.getBlock();
        if (block.getType() == Material.TRIPWIRE && (string = (blockBridge_9 = ItemStackRegistry.g().b(block)).Y(block)) != null) {
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string);
            if (locationBridgeBuilder_2 == null) {
                return;
            }
            blockDestroyEvent.setCancelled(true);
            BukkitTaskBridge.c(() -> locationBridgeBuilder_2.ar(block), 1L);
        }
    }
}
