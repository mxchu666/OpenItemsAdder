package itemsadder.m;

import itemsadder.m.ItemStackBridge_37;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_39
extends ItemStackBridge_37 {
    private final ItemStack Nd;

    public ItemStackBridge_39(ItemStack itemStack) {
        this.Nd = itemStack;
    }

    @Override
    public ItemStack rt() {
        return this.Nd.clone();
    }
}
