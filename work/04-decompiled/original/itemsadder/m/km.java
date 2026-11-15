package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jr;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class km
implements ai {
    private final d zm;

    public km(Plugin plugin, d d2) {
        this.zm = d2;
        bev.a(this, plugin);
        d2.ar.a(new my(InventoryClickEvent.class, this::a));
    }

    @EventHandler(ignoreCancelled=true)
    private void a(FurnaceBurnEvent furnaceBurnEvent) {
        qm qm2 = this.zm.a(furnaceBurnEvent.getFuel());
        if (qm2 == null) {
            return;
        }
        jr jr2 = (jr)qm2.Ge.bn("fuel");
        if (jr2 == null) {
            return;
        }
        if (!jr2.l(furnaceBurnEvent.getBlock())) {
            Furnace furnace = (Furnace)furnaceBurnEvent.getBlock().getState();
            furnaceBurnEvent.setCancelled(true);
            furnaceBurnEvent.setBurning(false);
            furnace.getInventory().setFuel(null);
            if (furnace.getInventory().getViewers().isEmpty()) {
                if (furnace.getInventory().getResult() == null || furnace.getInventory().getResult().getType() == Material.AIR) {
                    furnace.getInventory().setResult(furnaceBurnEvent.getFuel());
                } else {
                    bdf.b(furnaceBurnEvent.getBlock().getLocation(), furnaceBurnEvent.getFuel());
                }
            } else {
                bdf.b(furnaceBurnEvent.getBlock().getLocation(), furnaceBurnEvent.getFuel());
            }
            return;
        }
        furnaceBurnEvent.setBurnTime((int)jr2.yc);
    }

    @mz
    private void a(InventoryClickEvent inventoryClickEvent, qm qm2, ItemStack itemStack) {
        if (inventoryClickEvent.getInventory() instanceof FurnaceInventory) {
            if (!qm2.Ge.bm("fuel")) {
                return;
            }
            jr jr2 = (jr)qm2.Ge.bn("fuel");
            if (jr2 == null) {
                return;
            }
            if (!jr2.l(inventoryClickEvent.getInventory().getLocation().getBlock())) {
                if (inventoryClickEvent.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                    inventoryClickEvent.setCancelled(true);
                    return;
                }
                if (inventoryClickEvent.getSlotType() == InventoryType.SlotType.FUEL) {
                    inventoryClickEvent.setCancelled(true);
                    return;
                }
            }
        }
    }
}
