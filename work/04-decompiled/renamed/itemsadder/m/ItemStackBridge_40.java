package itemsadder.m;

import itemsadder.m.HeadEnum;
import itemsadder.m.InventoryClickListener_6;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PluginContract;
import itemsadder.m.PrepareGrindstoneListener;
import itemsadder.m.PrepareGrindstoneListener_2;
import itemsadder.m.VersionHelper_3;
import java.util.function.Consumer;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ItemStackBridge_40
implements PluginContract {
    public ItemStackBridge_40(Plugin plugin) {
        ListenerBridge.a(this, plugin);
        if (VersionHelper_3.ds("com.destroystokyo.paper.event.inventory.PrepareGrindstoneEvent")) {
            ListenerBridge.a(new PrepareGrindstoneListener(), plugin);
        } else if (VersionHelper_3.ds("org.bukkit.event.inventory.PrepareGrindstoneEvent")) {
            ListenerBridge.a(new PrepareGrindstoneListener_2(), plugin);
        } else {
            ListenerBridge.a(new InventoryClickListener_6(), plugin);
        }
    }

    static void a(InventoryEvent inventoryEvent, Consumer consumer) {
        Inventory inventory = inventoryEvent.getInventory();
        ItemStack itemStack = inventory.getItem(0);
        ItemStack itemStack2 = inventory.getItem(1);
        if (ItemStackBridge_2.at(itemStack2)) {
            ItemStack itemStack3 = inventory.getItem(2);
            ItemStackBridge_40.a(itemStack, itemStack3, consumer);
        } else {
            ItemStackBridge_40.a(itemStack, itemStack2, inventory, consumer);
        }
    }

    static void a(ItemStack itemStack, ItemStack itemStack2, Inventory inventory, Consumer consumer) {
        if (!ItemStackBuilder_4.isCustomItem(itemStack) && !ItemStackBuilder_4.isCustomItem(itemStack2)) {
            return;
        }
        if (!ItemStackBuilder_4.b(itemStack, itemStack2)) {
            consumer.accept(ItemStackBridge_2.Dc());
        } else {
            ItemStack itemStack3 = inventory.getItem(2);
            ItemStackBridge_40.a(itemStack, itemStack3, consumer);
        }
    }

    private static void a(ItemStack itemStack, ItemStack itemStack2, Consumer consumer) {
        if (itemStack2 == null) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack2);
        if (itemStackBuilder_4 == null) {
            return;
        }
        ItemStackBuilder_4.a(itemStackBuilder_4, itemStack2);
        if (MaterialBarColorHolder.eg) {
            ItemStackBuilder_4.b(itemStack2, HeadEnum.MAINHAND);
        }
        if (itemStack2.equals((Object)itemStack)) {
            consumer.accept(ItemStackBridge_2.Dc());
        } else {
            consumer.accept(itemStack2);
        }
    }
}
