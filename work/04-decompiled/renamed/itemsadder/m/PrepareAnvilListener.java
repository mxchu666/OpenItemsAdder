package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting.CustomCraftingWrapper;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_34;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.NamespacedKeyWrapper;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.PluginContract;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;
import org.bukkit.plugin.Plugin;

public class PrepareAnvilListener
implements PluginContract,
NamespacedKeyWrapper {
    public final ArrayList Ms = new ArrayList();
    final WeakHashMap Mt = new WeakHashMap();

    public PrepareAnvilListener(Plugin plugin) {
        ListenerBridge.a(this, plugin);
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        this.Ms.clear();
        this.Mt.clear();
    }

    @Override
    public String ra() {
        return "Anvil";
    }

    public void a(ItemStackBridge_34 itemStackBridge_34, String string, String string2) {
        this.Ms.add(itemStackBridge_34);
        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
            if (itemStackBridge_34.qO() != null) {
                CommandSenderBridge_5.log("Registered anvil recipe " + String.valueOf(itemStackBridge_34.qQ()) + " for: " + itemStackBridge_34.qO().getNamespacedID());
            } else {
                CommandSenderBridge_5.log("Registered anvil recipe " + String.valueOf(itemStackBridge_34.qQ()) + " for: " + String.valueOf(itemStackBridge_34.qN().getType()));
            }
        }
    }

    public ItemStackBridge_34 P(ItemStack itemStack) {
        for (ItemStackBridge_34 itemStackBridge_34 : this.Ms) {
            if (!(ItemStackBuilder_4.isCustomItem(itemStackBridge_34.rb()) ? ItemStackBuilder_4.isCustomItem(itemStack) && ItemStackBuilder_4.b(itemStackBridge_34.rb(), itemStack) : !ItemStackBuilder_4.isCustomItem(itemStack) && itemStack.getType() == itemStackBridge_34.rb().getType())) continue;
            return itemStackBridge_34;
        }
        return null;
    }

    @Override
    public List w(ItemStackBuilder_4 itemStackBuilder_4) {
        ArrayList<ItemStackBridge_34> arrayList = new ArrayList<ItemStackBridge_34>();
        for (ItemStackBridge_34 itemStackBridge_34 : this.Ms) {
            if (!itemStackBuilder_4.l(itemStackBridge_34.qO())) continue;
            arrayList.add(itemStackBridge_34);
        }
        return arrayList;
    }

    @Override
    public List x(ItemStackBuilder_4 itemStackBuilder_4) {
        ArrayList<ItemStackBridge_34> arrayList = new ArrayList<ItemStackBridge_34>();
        for (ItemStackBridge_34 itemStackBridge_34 : this.Ms) {
            if (!itemStackBuilder_4.l(itemStackBridge_34.qO())) continue;
            arrayList.add(itemStackBridge_34);
        }
        return arrayList;
    }

    public Set y(ItemStackBuilder_4 itemStackBuilder_4) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.w(itemStackBuilder_4));
        linkedHashSet.addAll(this.x(itemStackBuilder_4));
        return linkedHashSet;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PrepareAnvilEvent prepareAnvilEvent) {
        int n;
        double d;
        AnvilInventory anvilInventory = prepareAnvilEvent.getInventory();
        ItemStack itemStack = anvilInventory.getItem(0);
        ItemStack itemStack2 = anvilInventory.getItem(1);
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return;
        }
        if (itemStack2 == null || itemStack2.getType() == Material.AIR) {
            return;
        }
        if (itemStack2.getType() == Material.ENCHANTED_BOOK) {
            return;
        }
        if (Main.PE && CustomCraftingWrapper.inst().isCustomCraftingRecipe(prepareAnvilEvent)) {
            return;
        }
        Player player = (Player)prepareAnvilEvent.getView().getPlayer();
        boolean bl = ItemStackBuilder_4.b(itemStack, itemStack2);
        if (!bl && itemStack.getType() == itemStack2.getType()) {
            if (ItemStackBuilder_4.isCustomItem(itemStack) || ItemStackBuilder_4.isCustomItem(itemStack2)) {
                this.c(prepareAnvilEvent);
            }
            return;
        }
        if (bl) {
            BukkitTaskBridge.c(() -> {
                ItemStack itemStack = ItemStackBridge_2.a(anvilInventory);
                if (ItemStackBuilder_4.b(anvilInventory.getItem(0), itemStack)) {
                    anvilInventory.setItem(2, itemStack);
                    prepareAnvilEvent.setResult(itemStack);
                } else {
                    prepareAnvilEvent.setResult(null);
                }
            }, 1L);
            return;
        }
        ItemStackBridge_34 itemStackBridge_34 = this.P(itemStack);
        if (itemStackBridge_34 == null) {
            if (ItemStackBuilder_4.isCustomItem(itemStack) || ItemStackBuilder_4.isCustomItem(itemStack2)) {
                this.c(prepareAnvilEvent);
            }
            return;
        }
        if (!itemStackBridge_34.O(itemStack2)) {
            if (ItemStackBuilder_4.b(itemStack, prepareAnvilEvent.getResult())) {
                this.c(prepareAnvilEvent);
            }
            return;
        }
        if (!s.a(prepareAnvilEvent.getView().getPlayer(), itemStackBridge_34)) {
            this.c(prepareAnvilEvent);
            PlayerQuitListenerBase.a(player, itemStackBridge_34);
            return;
        }
        ItemStack itemStack3 = itemStack.clone();
        if (!ItemStackBridge_2.av(itemStack3)) {
            this.c(prepareAnvilEvent);
            return;
        }
        int n2 = ItemStackBuilder_4.E(itemStack3);
        double d2 = (double)n2 / 4.0;
        int n3 = n2 - ItemStackBridge_2.al(itemStack3);
        int n4 = (int)((double)n3 / d2);
        if (n4 == 0) {
            n4 = (int)Math.ceil((double)n3 / d2);
        }
        if (itemStack2.getAmount() > 4) {
            d = n3;
            n = n4;
        } else {
            d = d2 * (double)itemStack2.getAmount();
            n = itemStack2.getAmount();
        }
        if (d > d2 * 2.0 && (double)ItemStackBridge_2.al(itemStack3) + d > (double)n2) {
            d = n3;
            n = n4;
        }
        if ((double)ItemStackBridge_2.al(itemStack3) + d > (double)n2) {
            d = d2 * 1.0;
            n = 1;
        }
        if (d > d2 * 3.0) {
            n = 4;
        }
        this.Mt.put(player, n);
        ItemStackBridge_2.e(itemStack3, (int)d + 1);
        prepareAnvilEvent.setResult(itemStack3);
        int n5 = n;
        BukkitTaskBridge.c(() -> {
            ItemStack itemStack2 = anvilInventory.getItem(0);
            if (itemStack2 != null && (ItemStackBuilder_4.isCustomItem(itemStackBridge_34.rb()) && ItemStackBuilder_4.b(itemStack2, itemStack3) || itemStack2.getType() == itemStack3.getType())) {
                Repairable repairable = (Repairable)itemStack3.getItemMeta();
                anvilInventory.setRepairCost(repairable.getRepairCost() + n5);
                repairable.setRepairCost(repairable.getRepairCost() * 2 + 1);
                itemStack3.setItemMeta((ItemMeta)repairable);
                anvilInventory.setItem(2, itemStack3);
                prepareAnvilEvent.setResult(itemStack3);
            } else {
                prepareAnvilEvent.setResult(null);
            }
        }, 1L);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void f(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getInventory().getType() != InventoryType.ANVIL) {
            return;
        }
        if (inventoryClickEvent.getRawSlot() != 2) {
            return;
        }
        Inventory inventory = inventoryClickEvent.getInventory();
        if (inventory instanceof AnvilInventory) {
            AnvilInventory anvilInventory = (AnvilInventory)inventory;
            this.a(inventoryClickEvent, anvilInventory);
            this.b(inventoryClickEvent, anvilInventory);
        }
    }

    private void a(InventoryClickEvent inventoryClickEvent, AnvilInventory anvilInventory) {
        ItemStack itemStack = anvilInventory.getItem(0);
        ItemStack itemStack2 = anvilInventory.getItem(1);
        ItemStack itemStack3 = anvilInventory.getItem(2);
        if (itemStack3 == null || itemStack3.getType() == Material.AIR) {
            return;
        }
        if (itemStack2 == null || itemStack2.getType() == Material.ENCHANTED_BOOK) {
            return;
        }
        if (!ItemStackBridge_2.i(inventoryClickEvent)) {
            return;
        }
        Integer n = (Integer)this.Mt.get(inventoryClickEvent.getWhoClicked());
        this.Mt.remove(inventoryClickEvent.getWhoClicked());
        if (n == null) {
            return;
        }
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return;
        }
        ItemStack itemStack4 = itemStack2.clone();
        itemStack4.setAmount(itemStack4.getAmount() - n);
        BukkitTaskBridge.c(() -> {
            ItemStack itemStack2 = anvilInventory.getItem(2);
            if ((itemStack2 == null || itemStack2.getType() == Material.AIR) && anvilInventory.getLocation() != null) {
                Material material = anvilInventory.getLocation().getBlock().getType();
                if (material == Material.ANVIL || material == Material.CHIPPED_ANVIL || material == Material.DAMAGED_ANVIL) {
                    anvilInventory.setItem(1, itemStack4);
                } else {
                    LocationBridge_4.b(anvilInventory.getLocation(), itemStack4);
                }
            }
        }, 2L);
    }

    void b(InventoryClickEvent inventoryClickEvent, AnvilInventory anvilInventory) {
        ItemStack itemStack = anvilInventory.getItem(0);
        ItemStack itemStack2 = inventoryClickEvent.getCursor();
        if (itemStack == null) {
            return;
        }
        if (itemStack2 == null || itemStack2.getType() == Material.AIR) {
            return;
        }
        if (itemStack2.getType() == Material.ENCHANTED_BOOK) {
            return;
        }
        if (!ItemStackBridge_2.i(inventoryClickEvent)) {
            return;
        }
        if (itemStack.getType() == itemStack2.getType() && !ItemStackBuilder_4.b(itemStack, itemStack2)) {
            inventoryClickEvent.setCancelled(true);
            BukkitTaskBridge.c(() -> {
                anvilInventory.setItem(2, null);
                ((Player)inventoryClickEvent.getWhoClicked()).updateInventory();
            }, 0L);
        }
    }

    void c(PrepareAnvilEvent prepareAnvilEvent) {
        ItemStack itemStack;
        if (Main.PD && (itemStack = prepareAnvilEvent.getInventory().getItem(1)) != null && itemStack.getType() != Material.AIR && itemStack.hasItemMeta() && new NItem(itemStack).hasKey("isHyperStone")) {
            return;
        }
        itemStack = (Player)prepareAnvilEvent.getView().getPlayer();
        prepareAnvilEvent.setResult(null);
        prepareAnvilEvent.getInventory().setItem(2, new ItemStack(Material.AIR));
        prepareAnvilEvent.setResult(new ItemStack(Material.AIR));
        BukkitTaskBridge.c(() -> PrepareAnvilListener.a(prepareAnvilEvent, (Player)itemStack), 1L);
    }

    private static /* synthetic */ void a(PrepareAnvilEvent prepareAnvilEvent, Player player) {
        prepareAnvilEvent.setResult(null);
        prepareAnvilEvent.getInventory().setItem(2, new ItemStack(Material.AIR));
        prepareAnvilEvent.setResult(new ItemStack(Material.AIR));
        player.updateInventory();
    }
}
