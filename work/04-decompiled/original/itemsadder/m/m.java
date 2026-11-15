package itemsadder.m;

import itemsadder.m.d;
import itemsadder.m.l;
import itemsadder.m.qm;
import org.bukkit.inventory.ItemStack;

public class m
extends l {
    String namespacedId;

    public m(String string) {
        this.namespacedId = string;
    }

    @Override
    public boolean e(ItemStack itemStack) {
        if (itemStack == null || itemStack.getType().isAir()) {
            return false;
        }
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return false;
        }
        return qm2.getNamespacedID().equals(this.namespacedId);
    }
}
