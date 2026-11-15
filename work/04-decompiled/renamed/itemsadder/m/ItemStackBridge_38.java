package itemsadder.m;

import itemsadder.m.ItemStackBridge_37;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_38
extends ItemStackBridge_37 {
    private final ItemStackBuilder_4 Nc;

    public ItemStackBridge_38(ItemStackBuilder_4 itemStackBuilder_4) {
        this.Nc = itemStackBuilder_4;
    }

    public ItemStackBuilder_4 oP() {
        return this.Nc;
    }

    @Override
    public ItemStack rt() {
        return this.Nc.mP();
    }
}
