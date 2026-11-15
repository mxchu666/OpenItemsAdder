package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_41;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.NamespacedKeyWrapper;
import itemsadder.m.Opaque139;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.PluginContract;
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

public class PrepareSmithingListener
implements PluginContract,
NamespacedKeyWrapper {
    public final List Nt = new ArrayList();
    public final Map Nu = new HashMap();
    private final ItemStackRegistry Nv;

    public PrepareSmithingListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.Nv = itemStackRegistry;
        ListenerBridge.a(this, plugin);
    }

    @Override
    public String ra() {
        return "Smithing";
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        this.Nt.clear();
    }

    public void a(ItemStackBridge_41 itemStackBridge_41, String string, String string2) {
        NamespacedKey namespacedKey = new NamespacedKey(string, string2.toLowerCase());
        try {
            namespacedKey = this.a(this.Nu, itemStackBridge_41, namespacedKey, string, string2);
        }
        catch (Opaque139 opaque139) {
            // empty catch block
        }
        itemStackBridge_41.e(namespacedKey);
        SmithingTransformRecipe smithingTransformRecipe = new SmithingTransformRecipe(namespacedKey, itemStackBridge_41.qN(), itemStackBridge_41.Ni.Nf, itemStackBridge_41.Nj.Nf, itemStackBridge_41.Nk.Nf);
        itemStackBridge_41.a((Recipe)smithingTransformRecipe);
        this.Nt.add(itemStackBridge_41);
        this.Nv.aW.a((NamespacedKeyItemStackHolder)itemStackBridge_41);
        this.Nv.aW.a(itemStackBridge_41);
        if (Main.KO.gY("debug.recipes.log-recipes-loading")) {
            if (itemStackBridge_41.qO() != null) {
                CommandSenderBridge_5.log("Registered smithing recipe " + String.valueOf(itemStackBridge_41.qQ()) + " for: " + itemStackBridge_41.qO().getNamespacedID());
            } else {
                CommandSenderBridge_5.log("Registered smithing recipe " + String.valueOf(itemStackBridge_41.qQ()) + " for: " + String.valueOf(itemStackBridge_41.qN().getType()));
            }
        }
    }

    @Override
    public List w(ItemStackBuilder_4 itemStackBuilder_4) {
        return this.Nv.aW.a(ItemStackBridge_41.class, itemStackBuilder_4);
    }

    @Override
    public List x(ItemStackBuilder_4 itemStackBuilder_4) {
        return this.Nv.aW.b(ItemStackBridge_41.class, itemStackBuilder_4);
    }

    public Set y(ItemStackBuilder_4 itemStackBuilder_4) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.w(itemStackBuilder_4));
        linkedHashSet.addAll(this.x(itemStackBuilder_4));
        return linkedHashSet;
    }

    public ItemStackBridge_41 c(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3) {
        for (ItemStackBridge_41 itemStackBridge_41 : this.Nt) {
            if (!itemStackBridge_41.b(itemStack, itemStack2, itemStack3)) continue;
            return itemStackBridge_41;
        }
        return null;
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PrepareSmithingEvent prepareSmithingEvent) {
        ItemStackBridge_41 itemStackBridge_41;
        HumanEntity humanEntity = prepareSmithingEvent.getView().getPlayer();
        if (!(humanEntity instanceof Player)) {
            return;
        }
        Player player = (Player)humanEntity;
        humanEntity = prepareSmithingEvent.getInventory();
        if (humanEntity.getType() == InventoryType.SMITHING && (itemStackBridge_41 = this.c(PrepareSmithingListener.a((SmithingInventory)humanEntity), PrepareSmithingListener.b((SmithingInventory)humanEntity), PrepareSmithingListener.c((SmithingInventory)humanEntity))) != null) {
            if (!s.a((HumanEntity)player, itemStackBridge_41)) {
                prepareSmithingEvent.setResult(new ItemStack(Material.AIR));
                BukkitTaskBridge.c(() -> PlayerQuitListenerBase.b(player, itemStackBridge_41), 5L);
            } else {
                prepareSmithingEvent.setResult(itemStackBridge_41.T(PrepareSmithingListener.b((SmithingInventory)humanEntity)));
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
