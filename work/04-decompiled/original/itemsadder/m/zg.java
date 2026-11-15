package itemsadder.m;

import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.TradeSelectEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.plugin.Plugin;

public class zg
implements Listener {
    public void register(Plugin plugin) {
        bev.a(this, plugin);
    }

    @EventHandler
    private void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getClickedInventory() == null) {
            return;
        }
        if (inventoryClickEvent.getClickedInventory().getType() != InventoryType.MERCHANT) {
            return;
        }
        if (inventoryClickEvent.getSlotType() != InventoryType.SlotType.CRAFTING) {
            return;
        }
        if (inventoryClickEvent.getCursor().getType() == Material.AIR) {
            return;
        }
        if (d.g().aM.az((Player)inventoryClickEvent.getWhoClicked())) {
            return;
        }
        MerchantInventory merchantInventory = (MerchantInventory)inventoryClickEvent.getClickedInventory();
        MerchantRecipe merchantRecipe = merchantInventory.getSelectedRecipe();
        if (merchantRecipe == null) {
            merchantRecipe = merchantInventory.getMerchant().getRecipe(0);
        }
        if (inventoryClickEvent.getSlot() >= merchantRecipe.getIngredients().size()) {
            return;
        }
        ItemStack itemStack = (ItemStack)merchantRecipe.getIngredients().get(inventoryClickEvent.getSlot());
        if (qm.isCustomItem(inventoryClickEvent.getCursor()) && !qm.isCustomItem(itemStack)) {
            inventoryClickEvent.setCancelled(true);
        }
    }

    @EventHandler
    private void a(TradeSelectEvent tradeSelectEvent) {
        if (d.g().aM.az((Player)tradeSelectEvent.getWhoClicked())) {
            return;
        }
        MerchantInventory merchantInventory = tradeSelectEvent.getInventory();
        MerchantRecipe merchantRecipe = merchantInventory.getSelectedRecipe();
        if (merchantRecipe == null) {
            merchantRecipe = merchantInventory.getMerchant().getRecipe(0);
        }
        ItemStack itemStack = (ItemStack)merchantRecipe.getIngredients().getFirst();
        ItemStack itemStack2 = null;
        for (ItemStack itemStack3 : tradeSelectEvent.getWhoClicked().getInventory().getStorageContents()) {
            if (itemStack3 == null || itemStack3.getType() != itemStack.getType()) continue;
            itemStack2 = itemStack3;
            break;
        }
        if (itemStack2 == null) {
            return;
        }
        if (qm.isCustomItem(itemStack2) && !qm.isCustomItem(itemStack)) {
            tradeSelectEvent.setCancelled(true);
        }
    }
}
