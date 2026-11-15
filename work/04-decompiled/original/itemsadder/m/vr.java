package itemsadder.m;

import itemsadder.m.vp;
import org.bukkit.inventory.ItemStack;

public class vr
extends vp {
    private final ItemStack Nd;

    public vr(ItemStack itemStack) {
        this.Nd = itemStack;
    }

    @Override
    public ItemStack rt() {
        return this.Nd.clone();
    }
}
