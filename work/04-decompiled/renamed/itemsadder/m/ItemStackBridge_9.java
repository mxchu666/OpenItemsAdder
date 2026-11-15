package itemsadder.m;

import itemsadder.m.ItemStackBridge_8;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_9
extends ItemStackBridge_8 {
    String namespacedId;

    public ItemStackBridge_9(String string) {
        this.namespacedId = string;
    }

    @Override
    public boolean e(ItemStack itemStack) {
        if (itemStack == null || itemStack.getType().isAir()) {
            return false;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        return itemStackBuilder_4.getNamespacedID().equals(this.namespacedId);
    }
}
