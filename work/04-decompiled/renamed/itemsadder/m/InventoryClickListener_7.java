package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
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

public class InventoryClickListener_7
implements Listener {
    public void register(Plugin plugin) {
        ListenerBridge.a(this, plugin);
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
        if (ItemStackRegistry.g().aM.az((Player)inventoryClickEvent.getWhoClicked())) {
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
        if (ItemStackBuilder_4.isCustomItem(inventoryClickEvent.getCursor()) && !ItemStackBuilder_4.isCustomItem(itemStack)) {
            inventoryClickEvent.setCancelled(true);
        }
    }

    @EventHandler
    private void a(TradeSelectEvent tradeSelectEvent) {
        if (ItemStackRegistry.g().aM.az((Player)tradeSelectEvent.getWhoClicked())) {
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
        if (ItemStackBuilder_4.isCustomItem(itemStack2) && !ItemStackBuilder_4.isCustomItem(itemStack)) {
            tradeSelectEvent.setCancelled(true);
        }
    }
}
