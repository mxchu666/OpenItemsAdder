package itemsadder.m;

import itemsadder.m.bio;
import itemsadder.m.bip;
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

public final class biq
implements Listener {
    private final Plugin aEi;

    public biq(Plugin plugin) {
        this.aEi = plugin;
    }

    @EventHandler
    public void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getInventory().getHolder() instanceof bio && inventoryClickEvent.getClickedInventory() != null) {
            bio bio2 = (bio)inventoryClickEvent.getInventory().getHolder();
            boolean bl = inventoryClickEvent.isCancelled();
            inventoryClickEvent.setCancelled(true);
            bio2.k(inventoryClickEvent);
            if (!bl && !inventoryClickEvent.isCancelled()) {
                inventoryClickEvent.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void a(InventoryDragEvent inventoryDragEvent) {
        if (inventoryDragEvent.getInventory().getHolder() instanceof bio) {
            bio bio2 = (bio)inventoryDragEvent.getInventory().getHolder();
            boolean bl = inventoryDragEvent.isCancelled();
            inventoryDragEvent.setCancelled(true);
            bio2.c(inventoryDragEvent);
            if (!bl && !inventoryDragEvent.isCancelled()) {
                inventoryDragEvent.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void a(InventoryOpenEvent inventoryOpenEvent) {
        if (inventoryOpenEvent.getInventory().getHolder() instanceof bio) {
            bio bio2 = (bio)inventoryOpenEvent.getInventory().getHolder();
            bio2.c(inventoryOpenEvent);
        }
    }

    @EventHandler
    public void a(InventoryCloseEvent inventoryCloseEvent) {
        bio bio2;
        if (inventoryCloseEvent.getInventory().getHolder() instanceof bio && (bio2 = (bio)inventoryCloseEvent.getInventory().getHolder()).c(inventoryCloseEvent)) {
            Bukkit.getScheduler().runTask(this.aEi, () -> bio2.cG((Player)inventoryCloseEvent.getPlayer()));
        }
    }

    @EventHandler
    public void b(PluginDisableEvent pluginDisableEvent) {
        if (pluginDisableEvent.getPlugin() == this.aEi) {
            bip.EX();
            bip.EY().set(false);
        }
    }
}
