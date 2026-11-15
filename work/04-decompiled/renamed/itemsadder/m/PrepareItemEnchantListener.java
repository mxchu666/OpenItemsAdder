package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class PrepareItemEnchantListener
implements PluginContract {
    final ItemStackRegistry Aw;

    public PrepareItemEnchantListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.Aw = itemStackRegistry;
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void a(PrepareItemEnchantEvent prepareItemEnchantEvent) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.Aw.a(prepareItemEnchantEvent.getItem());
        if (itemStackBuilder_4 == null) {
            return;
        }
        if (itemStackBuilder_4.isBlockAllEnchants()) {
            prepareItemEnchantEvent.setCancelled(true);
            return;
        }
        ArrayList arrayList = itemStackBuilder_4.mT();
        if (arrayList == null) {
            return;
        }
        ArrayList<EnchantmentOffer> arrayList2 = new ArrayList<EnchantmentOffer>();
        for (EnchantmentOffer enchantmentOffer : prepareItemEnchantEvent.getOffers()) {
            if (enchantmentOffer == null) continue;
            if (!arrayList.contains(enchantmentOffer.getEnchantment())) {
                arrayList2.add(enchantmentOffer);
                continue;
            }
            if (arrayList2.size() == 0) continue;
            enchantmentOffer.setEnchantment(((EnchantmentOffer)arrayList2.get(0)).getEnchantment());
            enchantmentOffer.setEnchantmentLevel(((EnchantmentOffer)arrayList2.get(0)).getEnchantmentLevel());
            enchantmentOffer.setCost(((EnchantmentOffer)arrayList2.get(0)).getCost());
        }
        if (arrayList2.size() == 0) {
            prepareItemEnchantEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void a(EnchantItemEvent enchantItemEvent) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.Aw.a(enchantItemEvent.getItem());
        if (itemStackBuilder_4 == null) {
            return;
        }
        ArrayList arrayList = itemStackBuilder_4.mT();
        if (arrayList == null) {
            return;
        }
        for (Enchantment enchantment : arrayList) {
            enchantItemEvent.getEnchantsToAdd().remove(enchantment);
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void a(PrepareAnvilEvent prepareAnvilEvent) {
        ItemMeta itemMeta3;
        ItemMeta itemMeta2;
        AnvilInventory anvilInventory = prepareAnvilEvent.getInventory();
        ItemStack itemStack = prepareAnvilEvent.getResult();
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return;
        }
        ItemStack itemStack2 = anvilInventory.getItem(1);
        if (itemStack2 == null || itemStack2.getType() == Material.AIR) {
            return;
        }
        ItemStack itemStack3 = anvilInventory.getItem(0);
        if (itemStack3 == null) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = this.Aw.a(itemStack3);
        if (itemStackBuilder_4 == null) {
            return;
        }
        ArrayList arrayList = itemStackBuilder_4.mT();
        if (arrayList == null) {
            return;
        }
        if (itemStack2.getType() == Material.ENCHANTED_BOOK) {
            if (itemStackBuilder_4.isBlockAllEnchants()) {
                PrepareItemEnchantListener.b(prepareAnvilEvent);
                return;
            }
            itemMeta2 = (EnchantmentStorageMeta)itemStack2.getItemMeta();
            for (ItemMeta itemMeta3 : arrayList) {
                if (!itemMeta2.hasStoredEnchant((Enchantment)itemMeta3)) continue;
                PrepareItemEnchantListener.b(prepareAnvilEvent);
                return;
            }
        }
        itemMeta2 = itemStack3.getItemMeta();
        ItemMeta itemMeta4 = itemStack2.getItemMeta();
        itemMeta3 = itemStack.getItemMeta();
        for (Enchantment enchantment : arrayList) {
            if (itemMeta2.hasEnchant(enchantment)) {
                itemMeta3.addEnchant(enchantment, itemMeta2.getEnchantLevel(enchantment), true);
                continue;
            }
            if (itemMeta4.hasEnchant(enchantment)) {
                itemMeta3.addEnchant(enchantment, itemMeta4.getEnchantLevel(enchantment), true);
                continue;
            }
            itemMeta3.removeEnchant(enchantment);
        }
        itemStack.setItemMeta(itemMeta3);
    }

    private static void b(PrepareAnvilEvent prepareAnvilEvent) {
        prepareAnvilEvent.setResult(null);
    }
}
