package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.ai;
import itemsadder.m.asf;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.uw;
import itemsadder.m.uy;
import itemsadder.m.uz;
import itemsadder.m.wc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.inventory.SmithingTransformRecipe;
import org.bukkit.plugin.Plugin;

public class we
implements ai,
uy {
    public final List Nt = new ArrayList();
    public final Map Nu = new HashMap();
    private final d Nv;

    public we(Plugin plugin, d d2) {
        this.Nv = d2;
        bev.a(this, plugin);
    }

    @Override
    public String ra() {
        return "Smithing";
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        this.Nt.clear();
    }

    public void a(wc wc2, String string, String string2) {
        NamespacedKey namespacedKey = new NamespacedKey(string, string2.toLowerCase());
        try {
            namespacedKey = this.a(this.Nu, wc2, namespacedKey, string, string2);
        }
        catch (uz uz2) {
            // empty catch block
        }
        wc2.e(namespacedKey);
        SmithingTransformRecipe smithingTransformRecipe = new SmithingTransformRecipe(namespacedKey, wc2.qN(), wc2.Ni.Nf, wc2.Nj.Nf, wc2.Nk.Nf);
        wc2.a((Recipe)smithingTransformRecipe);
        this.Nt.add(wc2);
        this.Nv.aW.a((uw)wc2);
        this.Nv.aW.a(wc2);
        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
            if (wc2.qO() != null) {
                bce.log("Registered smithing recipe " + String.valueOf(wc2.qQ()) + " for: " + wc2.qO().getNamespacedID());
            } else {
                bce.log("Registered smithing recipe " + String.valueOf(wc2.qQ()) + " for: " + String.valueOf(wc2.qN().getType()));
            }
        }
    }

    @Override
    public List w(qm qm2) {
        return this.Nv.aW.a(wc.class, qm2);
    }

    @Override
    public List x(qm qm2) {
        return this.Nv.aW.b(wc.class, qm2);
    }

    public Set y(qm qm2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.w(qm2));
        linkedHashSet.addAll(this.x(qm2));
        return linkedHashSet;
    }

    public wc c(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3) {
        for (wc wc2 : this.Nt) {
            if (!wc2.b(itemStack, itemStack2, itemStack3)) continue;
            return wc2;
        }
        return null;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PrepareSmithingEvent prepareSmithingEvent) {
        wc wc2;
        HumanEntity humanEntity = prepareSmithingEvent.getView().getPlayer();
        if (!(humanEntity instanceof Player)) {
            return;
        }
        Player player = (Player)humanEntity;
        humanEntity = prepareSmithingEvent.getInventory();
        if (humanEntity.getType() == InventoryType.SMITHING && (wc2 = this.c(we.a((SmithingInventory)humanEntity), we.b((SmithingInventory)humanEntity), we.c((SmithingInventory)humanEntity))) != null) {
            if (!s.a((HumanEntity)player, wc2)) {
                prepareSmithingEvent.setResult(new ItemStack(Material.AIR));
                bcp.c(() -> asf.b(player, wc2), 5L);
            } else {
                prepareSmithingEvent.setResult(wc2.T(we.b((SmithingInventory)humanEntity)));
            }
        }
    }

    private static ItemStack a(SmithingInventory smithingInventory) {
        return smithingInventory.getItem(0);
    }

    private static ItemStack b(SmithingInventory smithingInventory) {
        return smithingInventory.getItem(1);
    }

    private static void a(SmithingInventory smithingInventory, ItemStack itemStack) {
        smithingInventory.setItem(1, itemStack);
    }

    private static ItemStack c(SmithingInventory smithingInventory) {
        return smithingInventory.getItem(2);
    }

    private static void b(SmithingInventory smithingInventory, ItemStack itemStack) {
        smithingInventory.setItem(2, itemStack);
    }

    private boolean g(InventoryClickEvent inventoryClickEvent) {
        return inventoryClickEvent.getRawSlot() == 3;
    }
}
