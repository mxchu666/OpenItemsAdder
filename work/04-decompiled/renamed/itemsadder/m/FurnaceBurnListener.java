package itemsadder.m;

import itemsadder.m.BlockBridge_6;
import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
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

public class FurnaceBurnListener
implements PluginContract {
    private final ItemStackRegistry zm;

    public FurnaceBurnListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.zm = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(InventoryClickEvent.class, this::a));
    }

    @EventHandler(ignoreCancelled=true)
    private void a(FurnaceBurnEvent furnaceBurnEvent) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.zm.a(furnaceBurnEvent.getFuel());
        if (itemStackBuilder_4 == null) {
            return;
        }
        BlockBridge_6 blockBridge_6 = (BlockBridge_6)itemStackBuilder_4.Ge.bn("fuel");
        if (blockBridge_6 == null) {
            return;
        }
        if (!blockBridge_6.l(furnaceBurnEvent.getBlock())) {
            Furnace furnace = (Furnace)furnaceBurnEvent.getBlock().getState();
            furnaceBurnEvent.setCancelled(true);
            furnaceBurnEvent.setBurning(false);
            furnace.getInventory().setFuel(null);
            if (furnace.getInventory().getViewers().isEmpty()) {
                if (furnace.getInventory().getResult() == null || furnace.getInventory().getResult().getType() == Material.AIR) {
                    furnace.getInventory().setResult(furnaceBurnEvent.getFuel());
                } else {
                    LocationBridge_4.b(furnaceBurnEvent.getBlock().getLocation(), furnaceBurnEvent.getFuel());
                }
            } else {
                LocationBridge_4.b(furnaceBurnEvent.getBlock().getLocation(), furnaceBurnEvent.getFuel());
            }
            return;
        }
        furnaceBurnEvent.setBurnTime((int)blockBridge_6.yc);
    }

    @PluginContract_19
    private void a(InventoryClickEvent inventoryClickEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (inventoryClickEvent.getInventory() instanceof FurnaceInventory) {
            if (!itemStackBuilder_4.Ge.bm("fuel")) {
                return;
            }
            BlockBridge_6 blockBridge_6 = (BlockBridge_6)itemStackBuilder_4.Ge.bn("fuel");
            if (blockBridge_6 == null) {
                return;
            }
            if (!blockBridge_6.l(inventoryClickEvent.getInventory().getLocation().getBlock())) {
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
