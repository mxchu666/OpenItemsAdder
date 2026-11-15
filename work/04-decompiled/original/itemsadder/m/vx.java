package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.qt;
import itemsadder.m.vy;
import itemsadder.m.vz;
import itemsadder.m.wa;
import itemsadder.m.zw;
import java.util.function.Consumer;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class vx
implements ai {
    public vx(Plugin plugin) {
        bev.a(this, plugin);
        if (zw.ds("com.destroystokyo.paper.event.inventory.PrepareGrindstoneEvent")) {
            bev.a(new vz(), plugin);
        } else if (zw.ds("org.bukkit.event.inventory.PrepareGrindstoneEvent")) {
            bev.a(new wa(), plugin);
        } else {
            bev.a(new vy(), plugin);
        }
    }

    static void a(InventoryEvent inventoryEvent, Consumer consumer) {
        Inventory inventory = inventoryEvent.getInventory();
        ItemStack itemStack = inventory.getItem(0);
        ItemStack itemStack2 = inventory.getItem(1);
        if (bbs.at(itemStack2)) {
            ItemStack itemStack3 = inventory.getItem(2);
            vx.a(itemStack, itemStack3, consumer);
        } else {
            vx.a(itemStack, itemStack2, inventory, consumer);
        }
    }

    static void a(ItemStack itemStack, ItemStack itemStack2, Inventory inventory, Consumer consumer) {
        if (!qm.isCustomItem(itemStack) && !qm.isCustomItem(itemStack2)) {
            return;
        }
        if (!qm.b(itemStack, itemStack2)) {
            consumer.accept(bbs.Dc());
        } else {
            ItemStack itemStack3 = inventory.getItem(2);
            vx.a(itemStack, itemStack3, consumer);
        }
    }

    private static void a(ItemStack itemStack, ItemStack itemStack2, Consumer consumer) {
        if (itemStack2 == null) {
            return;
        }
        qm qm2 = d.g().a(itemStack2);
        if (qm2 == null) {
            return;
        }
        qm.a(qm2, itemStack2);
        if (ae.eg) {
            qm.b(itemStack2, qt.MAINHAND);
        }
        if (itemStack2.equals((Object)itemStack)) {
            consumer.accept(bbs.Dc());
        } else {
            consumer.accept(itemStack2);
        }
    }
}
