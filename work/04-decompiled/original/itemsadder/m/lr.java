package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.qt;
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

public class lr
implements ai {
    final Plugin Ay;
    final d Az;

    public lr(Plugin plugin, d d2) {
        this.Ay = plugin;
        this.Az = d2;
        bev.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(EnchantItemEvent enchantItemEvent) {
        Integer n = (Integer)enchantItemEvent.getEnchantsToAdd().get(Enchantment.SHARPNESS);
        if (n == null) {
            return;
        }
        qm qm2 = this.Az.a(enchantItemEvent.getItem());
        if (qm2 != null && qm2.hasCustomDurability()) {
            enchantItemEvent.getItem().addUnsafeEnchantment(Enchantment.SHARPNESS, n.intValue());
            qm.b(enchantItemEvent.getItem(), qt.MAINHAND);
            enchantItemEvent.getInventory().setItem(0, enchantItemEvent.getItem());
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void d(InventoryClickEvent inventoryClickEvent) {
        if (ae.eg) {
            if (inventoryClickEvent.getInventory().getType() != InventoryType.ANVIL) {
                return;
            }
            if (!bbs.i(inventoryClickEvent)) {
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
            qm qm2 = this.Az.a((ItemStack)inventory);
            if (qm2 != null && !qm2.hasCustomDurability()) {
                return;
            }
            EnchantmentStorageMeta enchantmentStorageMeta = (EnchantmentStorageMeta)itemStack.getItemMeta();
            if (enchantmentStorageMeta.getStoredEnchants().containsKey(Enchantment.SHARPNESS)) {
                qm.b((ItemStack)inventory, qt.MAINHAND);
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
        qm qm2 = this.Az.a(itemStack);
        if (qm2 == null) {
            return;
        }
        ItemStack itemStack3 = prepareAnvilEvent.getResult();
        if (itemStack3 == null) {
            return;
        }
        if (ae.eg) {
            qm.b(itemStack3, qt.MAINHAND);
        }
        prepareAnvilEvent.setResult(itemStack3);
    }
}
