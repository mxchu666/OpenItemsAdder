package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
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

public class lo
implements ai {
    final d Aw;

    public lo(Plugin plugin, d d2) {
        this.Aw = d2;
        bev.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void a(PrepareItemEnchantEvent prepareItemEnchantEvent) {
        qm qm2 = this.Aw.a(prepareItemEnchantEvent.getItem());
        if (qm2 == null) {
            return;
        }
        if (qm2.isBlockAllEnchants()) {
            prepareItemEnchantEvent.setCancelled(true);
            return;
        }
        ArrayList arrayList = qm2.mT();
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
        qm qm2 = this.Aw.a(enchantItemEvent.getItem());
        if (qm2 == null) {
            return;
        }
        ArrayList arrayList = qm2.mT();
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
        qm qm2 = this.Aw.a(itemStack3);
        if (qm2 == null) {
            return;
        }
        ArrayList arrayList = qm2.mT();
        if (arrayList == null) {
            return;
        }
        if (itemStack2.getType() == Material.ENCHANTED_BOOK) {
            if (qm2.isBlockAllEnchants()) {
                lo.b(prepareAnvilEvent);
                return;
            }
            itemMeta2 = (EnchantmentStorageMeta)itemStack2.getItemMeta();
            for (ItemMeta itemMeta3 : arrayList) {
                if (!itemMeta2.hasStoredEnchant((Enchantment)itemMeta3)) continue;
                lo.b(prepareAnvilEvent);
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
