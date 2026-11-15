package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class vu
implements ai {
    public vu(Plugin plugin) {
        bev.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.HIGH)
    private void a(PrepareAnvilEvent prepareAnvilEvent) {
        ItemStack itemStack = prepareAnvilEvent.getInventory().getItem(1);
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return;
        }
        ItemStack itemStack2 = prepareAnvilEvent.getInventory().getItem(0);
        qm qm2 = d.g().a(itemStack2);
        if (qm2 != null) {
            if (prepareAnvilEvent.getInventory().getRepairCost() > 1) {
                prepareAnvilEvent.getInventory().setRepairCost(prepareAnvilEvent.getInventory().getRepairCost() - 1);
            }
            ItemStack itemStack3 = prepareAnvilEvent.getResult();
            qm qm3 = d.g().a(itemStack3);
            if (qm3 == null) {
                return;
            }
            Component component = bbs.ah(itemStack3);
            Component component2 = bbs.ah(qm3);
            if (component2 == null || component == null) {
                return;
            }
            if (component2.equals((Object)component)) {
                bbs.a(itemStack3, component2);
            }
        }
    }
}
