package itemsadder.m;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.ql;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class mi
implements Listener {
    @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
    private void a(BlockDestroyEvent blockDestroyEvent) {
        ms ms2;
        String string;
        Block block = blockDestroyEvent.getBlock();
        if (block.getType() == Material.TRIPWIRE && (string = (ms2 = d.g().b(block)).Y(block)) != null) {
            ql ql2 = d.g().h(string);
            if (ql2 == null) {
                return;
            }
            blockDestroyEvent.setCancelled(true);
            bcp.c(() -> ql2.ar(block), 1L);
        }
    }
}
