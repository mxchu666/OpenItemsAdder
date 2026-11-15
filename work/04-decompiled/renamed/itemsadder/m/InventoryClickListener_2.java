package itemsadder.m;

import itemsadder.m.ItemStackBridge_4;
import itemsadder.m.PluginBridge_9;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.Plugin;

public final class InventoryClickListener_2
implements Listener {
    private final Plugin aEi;

    public InventoryClickListener_2(Plugin plugin) {
        this.aEi = plugin;
    }

    @EventHandler
    public void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getInventory().getHolder() instanceof ItemStackBridge_4 && inventoryClickEvent.getClickedInventory() != null) {
            ItemStackBridge_4 itemStackBridge_4 = (ItemStackBridge_4)inventoryClickEvent.getInventory().getHolder();
            boolean bl = inventoryClickEvent.isCancelled();
            inventoryClickEvent.setCancelled(true);
            itemStackBridge_4.k(inventoryClickEvent);
            if (!bl && !inventoryClickEvent.isCancelled()) {
                inventoryClickEvent.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void a(InventoryDragEvent inventoryDragEvent) {
        if (inventoryDragEvent.getInventory().getHolder() instanceof ItemStackBridge_4) {
            ItemStackBridge_4 itemStackBridge_4 = (ItemStackBridge_4)inventoryDragEvent.getInventory().getHolder();
            boolean bl = inventoryDragEvent.isCancelled();
            inventoryDragEvent.setCancelled(true);
            itemStackBridge_4.c(inventoryDragEvent);
            if (!bl && !inventoryDragEvent.isCancelled()) {
                inventoryDragEvent.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void a(InventoryOpenEvent inventoryOpenEvent) {
        if (inventoryOpenEvent.getInventory().getHolder() instanceof ItemStackBridge_4) {
            ItemStackBridge_4 itemStackBridge_4 = (ItemStackBridge_4)inventoryOpenEvent.getInventory().getHolder();
            itemStackBridge_4.c(inventoryOpenEvent);
        }
    }

    @EventHandler
    public void a(InventoryCloseEvent inventoryCloseEvent) {
        ItemStackBridge_4 itemStackBridge_4;
        if (inventoryCloseEvent.getInventory().getHolder() instanceof ItemStackBridge_4 && (itemStackBridge_4 = (ItemStackBridge_4)inventoryCloseEvent.getInventory().getHolder()).c(inventoryCloseEvent)) {
            Bukkit.getScheduler().runTask(this.aEi, () -> itemStackBridge_4.cG((Player)inventoryCloseEvent.getPlayer()));
        }
    }

    @EventHandler
    public void b(PluginDisableEvent pluginDisableEvent) {
        if (pluginDisableEvent.getPlugin() == this.aEi) {
            PluginBridge_9.EX();
            PluginBridge_9.EY().set(false);
        }
    }
}
