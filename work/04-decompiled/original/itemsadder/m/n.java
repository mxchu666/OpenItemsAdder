package itemsadder.m;

import itemsadder.m.l;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class n
extends l {
    Material bE;

    public n(Material material) {
        this.bE = material;
    }

    @Override
    public boolean e(ItemStack itemStack) {
        return itemStack != null && !itemStack.getType().isAir() && itemStack.getType() == this.bE;
    }
}
