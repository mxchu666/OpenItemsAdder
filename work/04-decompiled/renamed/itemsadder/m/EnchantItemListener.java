package itemsadder.m;

import itemsadder.m.HeadEnum;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PluginContract;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.plugin.Plugin;

public class EnchantItemListener
implements PluginContract {
    final Plugin Ay;
    final ItemStackRegistry Az;

    public EnchantItemListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.Ay = plugin;
        this.Az = itemStackRegistry;
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(EnchantItemEvent enchantItemEvent) {
        Integer n = (Integer)enchantItemEvent.getEnchantsToAdd().get(Enchantment.SHARPNESS);
        if (n == null) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = this.Az.a(enchantItemEvent.getItem());
        if (itemStackBuilder_4 != null && itemStackBuilder_4.hasCustomDurability()) {
            enchantItemEvent.getItem().addUnsafeEnchantment(Enchantment.SHARPNESS, n.intValue());
            ItemStackBuilder_4.b(enchantItemEvent.getItem(), HeadEnum.MAINHAND);
            enchantItemEvent.getInventory().setItem(0, enchantItemEvent.getItem());
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void d(InventoryClickEvent inventoryClickEvent) {
        if (MaterialBarColorHolder.eg) {
            if (inventoryClickEvent.getInventory().getType() != InventoryType.ANVIL) {
                return;
            }
            if (!ItemStackBridge_2.i(inventoryClickEvent)) {
                return;
            }
            if (inventoryClickEvent.getSlot() != 2) {
                return;
            }
            Inventory inventory = inventoryClickEvent.getInventory();
            if (!(inventory instanceof AnvilInventory)) {
                return;
            }
            AnvilInventory anvilInventory = (AnvilInventory)inventory;
            inventory = anvilInventory.getItem(2);
            if (inventory == null) {
                return;
            }
            ItemStack itemStack = anvilInventory.getItem(1);
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                return;
            }
            if (itemStack.getType() != Material.ENCHANTED_BOOK) {
                return;
            }
            ItemStackBuilder_4 itemStackBuilder_4 = this.Az.a((ItemStack)inventory);
            if (itemStackBuilder_4 != null && !itemStackBuilder_4.hasCustomDurability()) {
                return;
            }
            EnchantmentStorageMeta enchantmentStorageMeta = (EnchantmentStorageMeta)itemStack.getItemMeta();
            if (enchantmentStorageMeta.getStoredEnchants().containsKey(Enchantment.SHARPNESS)) {
                ItemStackBuilder_4.b((ItemStack)inventory, HeadEnum.MAINHAND);
            }
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void a(PrepareAnvilEvent prepareAnvilEvent) {
        AnvilInventory anvilInventory = prepareAnvilEvent.getInventory();
        ItemStack itemStack = anvilInventory.getItem(0);
        ItemStack itemStack2 = anvilInventory.getItem(1);
        if (itemStack2 == null || itemStack2.getType() == Material.AIR) {
            return;
        }
        if (itemStack2.getType() != Material.ENCHANTED_BOOK) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = this.Az.a(itemStack);
        if (itemStackBuilder_4 == null) {
            return;
        }
        ItemStack itemStack3 = prepareAnvilEvent.getResult();
        if (itemStack3 == null) {
            return;
        }
        if (MaterialBarColorHolder.eg) {
            ItemStackBuilder_4.b(itemStack3, HeadEnum.MAINHAND);
        }
        prepareAnvilEvent.setResult(itemStack3);
    }
}
