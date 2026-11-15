package itemsadder.m;

import itemsadder.m.ItemStackBridge_8;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MaterialBridge_4
extends ItemStackBridge_8 {
    Material bE;

    public MaterialBridge_4(Material material) {
        this.bE = material;
    }

    @Override
    public boolean e(ItemStack itemStack) {
        return itemStack != null && !itemStack.getType().isAir() && itemStack.getType() == this.bE;
    }
}
