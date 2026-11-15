package itemsadder.m;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import itemsadder.m.bay;
import itemsadder.m.bdf;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.rb;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class ky
implements Listener {
    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    private void a(BlockDestroyEvent blockDestroyEvent) {
        Block block = blockDestroyEvent.getBlock();
        if (rb.ax(block)) {
            ms ms2 = d.g().b(block);
            String string = ms2.aa(block);
            if (string == null) {
                return;
            }
            rb rb2 = (rb)d.g().a(rb.class, string);
            if (rb2 == null) {
                return;
            }
            blockDestroyEvent.setCancelled(true);
            if (bay.bn(block)) {
                rb2.N(block.getLocation());
            } else {
                ItemStack itemStack = rb2.mP();
                bdf.b(block.getLocation(), itemStack.clone());
            }
            ms2.a(block, true, true);
        }
    }
}
