package itemsadder.m;

import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
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

public class PlayerDeathListener
implements PluginContract {
    HashMap zr = new HashMap();

    public PlayerDeathListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void b(PlayerDeathEvent playerDeathEvent) {
        ItemStackRegistry itemStackRegistry = ItemStackRegistry.g();
        Player player = playerDeathEvent.getEntity();
        this.zr.remove(player.getUniqueId());
        Iterator iterator = playerDeathEvent.getDrops().iterator();
        while (iterator.hasNext()) {
            ItemStack itemStack = (ItemStack)iterator.next();
            ItemStackBuilder_4 itemStackBuilder_4 = itemStackRegistry.a(itemStack);
            if (itemStackBuilder_4 == null || !itemStackBuilder_4.Ge.bm("keep_on_death")) continue;
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
                ItemStackBridge_2.f(player, itemStack);
            }
        }
        this.zr.remove(player.getUniqueId());
    }
}
