package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.bev;
import itemsadder.m.pd;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.Plugin;

public class pc
implements Listener {
    private final Map Ee = new HashMap();

    public void register() {
        bev.b(this, (Plugin)Main.rS());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(InventoryClickEvent inventoryClickEvent) {
        HumanEntity humanEntity = inventoryClickEvent.getWhoClicked();
        if (humanEntity instanceof Player) {
            Player player = (Player)humanEntity;
            if (inventoryClickEvent.getClick() != ClickType.NUMBER_KEY || inventoryClickEvent.getAction() != InventoryAction.HOTBAR_SWAP || inventoryClickEvent.getSlotType() != InventoryType.SlotType.QUICKBAR) {
                return;
            }
            this.aY(player);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent) {
        this.aY(playerSwapHandItemsEvent.getPlayer());
    }

    private void aY(Player player2) {
        long l = System.currentTimeMillis();
        pd pd2 = this.Ee.computeIfAbsent(player2, player -> new pd());
        while (!pd2.Ef.isEmpty() && l - (Long)pd2.Ef.peek() > (long)ae.fE) {
            pd2.Ef.poll();
        }
        pd2.Ef.add(l);
        if (pd2.Ef.size() > ae.fF) {
            player2.kickPlayer("Kicked for spamming quickbar clicks.");
            this.Ee.remove(player2);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.Ee.remove(playerQuitEvent.getPlayer());
    }
}
