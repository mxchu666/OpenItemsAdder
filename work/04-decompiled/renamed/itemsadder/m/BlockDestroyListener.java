package itemsadder.m;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.MaterialBridge_9;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class BlockDestroyListener
implements Listener {
    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    private void a(BlockDestroyEvent blockDestroyEvent) {
        Block block = blockDestroyEvent.getBlock();
        if (MaterialBridge_9.ax(block)) {
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            String string = blockBridge_9.aa(block);
            if (string == null) {
                return;
            }
            MaterialBridge_9 materialBridge_9 = (MaterialBridge_9)ItemStackRegistry.g().a(MaterialBridge_9.class, string);
            if (materialBridge_9 == null) {
                return;
            }
            blockDestroyEvent.setCancelled(true);
            if (BlockBridge_2.bn(block)) {
                materialBridge_9.N(block.getLocation());
            } else {
                ItemStack itemStack = materialBridge_9.mP();
                LocationBridge_4.b(block.getLocation(), itemStack.clone());
            }
            blockBridge_9.a(block, true, true);
        }
    }
}
