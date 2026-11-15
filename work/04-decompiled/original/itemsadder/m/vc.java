package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting.CustomCraftingWrapper;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.ai;
import itemsadder.m.asf;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.qm;
import itemsadder.m.uy;
import itemsadder.m.vb;
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

public class vc
implements ai,
uy {
    public final ArrayList Ms = new ArrayList();
    final WeakHashMap Mt = new WeakHashMap();

    public vc(Plugin plugin) {
        bev.a(this, plugin);
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        this.Ms.clear();
        this.Mt.clear();
    }

    @Override
    public String ra() {
        return "Anvil";
    }

    public void a(vb vb2, String string, String string2) {
        this.Ms.add(vb2);
        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
            if (vb2.qO() != null) {
                bce.log("Registered anvil recipe " + String.valueOf(vb2.qQ()) + " for: " + vb2.qO().getNamespacedID());
            } else {
                bce.log("Registered anvil recipe " + String.valueOf(vb2.qQ()) + " for: " + String.valueOf(vb2.qN().getType()));
            }
        }
    }

    public vb P(ItemStack itemStack) {
        for (vb vb2 : this.Ms) {
            if (!(qm.isCustomItem(vb2.rb()) ? qm.isCustomItem(itemStack) && qm.b(vb2.rb(), itemStack) : !qm.isCustomItem(itemStack) && itemStack.getType() == vb2.rb().getType())) continue;
            return vb2;
        }
        return null;
    }

    @Override
    public List w(qm qm2) {
        ArrayList<vb> arrayList = new ArrayList<vb>();
        for (vb vb2 : this.Ms) {
            if (!qm2.l(vb2.qO())) continue;
            arrayList.add(vb2);
        }
        return arrayList;
    }

    @Override
    public List x(qm qm2) {
        ArrayList<vb> arrayList = new ArrayList<vb>();
        for (vb vb2 : this.Ms) {
            if (!qm2.l(vb2.qO())) continue;
            arrayList.add(vb2);
        }
        return arrayList;
    }

    public Set y(qm qm2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.w(qm2));
        linkedHashSet.addAll(this.x(qm2));
        return linkedHashSet;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PrepareAnvilEvent prepareAnvilEvent) {
        int n;
        double d2;
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
        boolean bl = qm.b(itemStack, itemStack2);
        if (!bl && itemStack.getType() == itemStack2.getType()) {
            if (qm.isCustomItem(itemStack) || qm.isCustomItem(itemStack2)) {
                this.c(prepareAnvilEvent);
            }
            return;
        }
        if (bl) {
            bcp.c(() -> {
                ItemStack itemStack = bbs.a(anvilInventory);
                if (qm.b(anvilInventory.getItem(0), itemStack)) {
                    anvilInventory.setItem(2, itemStack);
                    prepareAnvilEvent.setResult(itemStack);
                } else {
                    prepareAnvilEvent.setResult(null);
                }
            }, 1L);
            return;
        }
        vb vb2 = this.P(itemStack);
        if (vb2 == null) {
            if (qm.isCustomItem(itemStack) || qm.isCustomItem(itemStack2)) {
                this.c(prepareAnvilEvent);
            }
            return;
        }
        if (!vb2.O(itemStack2)) {
            if (qm.b(itemStack, prepareAnvilEvent.getResult())) {
                this.c(prepareAnvilEvent);
            }
            return;
        }
        if (!s.a(prepareAnvilEvent.getView().getPlayer(), vb2)) {
            this.c(prepareAnvilEvent);
            asf.a(player, vb2);
            return;
        }
        ItemStack itemStack3 = itemStack.clone();
        if (!bbs.av(itemStack3)) {
            this.c(prepareAnvilEvent);
            return;
        }
        int n2 = qm.E(itemStack3);
        double d3 = (double)n2 / 4.0;
        int n3 = n2 - bbs.al(itemStack3);
        int n4 = (int)((double)n3 / d3);
        if (n4 == 0) {
            n4 = (int)Math.ceil((double)n3 / d3);
        }
        if (itemStack2.getAmount() > 4) {
            d2 = n3;
            n = n4;
        } else {
            d2 = d3 * (double)itemStack2.getAmount();
            n = itemStack2.getAmount();
        }
        if (d2 > d3 * 2.0 && (double)bbs.al(itemStack3) + d2 > (double)n2) {
            d2 = n3;
            n = n4;
        }
        if ((double)bbs.al(itemStack3) + d2 > (double)n2) {
            d2 = d3 * 1.0;
            n = 1;
        }
        if (d2 > d3 * 3.0) {
            n = 4;
        }
        this.Mt.put(player, n);
        bbs.e(itemStack3, (int)d2 + 1);
        prepareAnvilEvent.setResult(itemStack3);
        int n5 = n;
        bcp.c(() -> {
            ItemStack itemStack2 = anvilInventory.getItem(0);
            if (itemStack2 != null && (qm.isCustomItem(vb2.rb()) && qm.b(itemStack2, itemStack3) || itemStack2.getType() == itemStack3.getType())) {
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
        if (!bbs.i(inventoryClickEvent)) {
            return;
        }
        Integer n = (Integer)this.Mt.get(inventoryClickEvent.getWhoClicked());
        this.Mt.remove(inventoryClickEvent.getWhoClicked());
        if (n == null) {
            return;
        }
        if (!qm.isCustomItem(itemStack)) {
            return;
        }
        ItemStack itemStack4 = itemStack2.clone();
        itemStack4.setAmount(itemStack4.getAmount() - n);
        bcp.c(() -> {
            ItemStack itemStack2 = anvilInventory.getItem(2);
            if ((itemStack2 == null || itemStack2.getType() == Material.AIR) && anvilInventory.getLocation() != null) {
                Material material = anvilInventory.getLocation().getBlock().getType();
                if (material == Material.ANVIL || material == Material.CHIPPED_ANVIL || material == Material.DAMAGED_ANVIL) {
                    anvilInventory.setItem(1, itemStack4);
                } else {
                    bdf.b(anvilInventory.getLocation(), itemStack4);
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
        if (!bbs.i(inventoryClickEvent)) {
            return;
        }
        if (itemStack.getType() == itemStack2.getType() && !qm.b(itemStack, itemStack2)) {
            inventoryClickEvent.setCancelled(true);
            bcp.c(() -> {
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
        bcp.c(() -> vc.a(prepareAnvilEvent, (Player)itemStack), 1L);
    }

    private static /* synthetic */ void a(PrepareAnvilEvent prepareAnvilEvent, Player player) {
        prepareAnvilEvent.setResult(null);
        prepareAnvilEvent.getInventory().setItem(2, new ItemStack(Material.AIR));
        prepareAnvilEvent.setResult(new ItemStack(Material.AIR));
        player.updateInventory();
    }
}
