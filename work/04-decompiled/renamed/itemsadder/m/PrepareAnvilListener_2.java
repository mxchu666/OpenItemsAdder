package itemsadder.m;

import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PrepareAnvilListener_2
implements PluginContract {
    public PrepareAnvilListener_2(Plugin plugin) {
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.HIGH)
    private void a(PrepareAnvilEvent prepareAnvilEvent) {
        ItemStack itemStack = prepareAnvilEvent.getInventory().getItem(1);
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return;
        }
        ItemStack itemStack2 = prepareAnvilEvent.getInventory().getItem(0);
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack2);
        if (itemStackBuilder_4 != null) {
            if (prepareAnvilEvent.getInventory().getRepairCost() > 1) {
                prepareAnvilEvent.getInventory().setRepairCost(prepareAnvilEvent.getInventory().getRepairCost() - 1);
            }
            ItemStack itemStack3 = prepareAnvilEvent.getResult();
            ItemStackBuilder_4 itemStackBuilder_42 = ItemStackRegistry.g().a(itemStack3);
            if (itemStackBuilder_42 == null) {
                return;
            }
            Component component = ItemStackBridge_2.ah(itemStack3);
            Component component2 = ItemStackBridge_2.ah(itemStackBuilder_42);
            if (component2 == null || component == null) {
                return;
            }
            if (component2.equals((Object)component)) {
                ItemStackBridge_2.a(itemStack3, component2);
            }
        }
    }
}
