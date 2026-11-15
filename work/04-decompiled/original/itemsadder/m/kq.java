package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class kq
implements ai {
    HashMap zr = new HashMap();

    public kq(Plugin plugin, d d2) {
        bev.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void b(PlayerDeathEvent playerDeathEvent) {
        d d2 = d.g();
        Player player = playerDeathEvent.getEntity();
        this.zr.remove(player.getUniqueId());
        Iterator iterator = playerDeathEvent.getDrops().iterator();
        while (iterator.hasNext()) {
            ItemStack itemStack = (ItemStack)iterator.next();
            qm qm2 = d2.a(itemStack);
            if (qm2 == null || !qm2.Ge.bm("keep_on_death")) continue;
            iterator.remove();
            this.zr.computeIfAbsent(player.getUniqueId(), uUID -> new ArrayList()).add(itemStack);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void c(PlayerRespawnEvent playerRespawnEvent) {
        Player player = playerRespawnEvent.getPlayer();
        List list = (List)this.zr.get(player.getUniqueId());
        if (list != null) {
            ItemStack itemStack;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                itemStack = (ItemStack)iterator.next();
                if (!player.getInventory().contains(itemStack)) continue;
                iterator.remove();
            }
            iterator = list.iterator();
            while (iterator.hasNext()) {
                itemStack = (ItemStack)iterator.next();
                iterator.remove();
                bbs.f(player, itemStack);
            }
        }
        this.zr.remove(player.getUniqueId());
    }
}
