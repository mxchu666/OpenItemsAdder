package itemsadder.m;

import itemsadder.m.ItemStackBridge_37;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MaterialBridge_19
extends ItemStackBridge_37 {
    public final Material Ne;

    public MaterialBridge_19(Material material) {
        this.Ne = material;
    }

    @Override
    public ItemStack rt() {
        return new ItemStack(this.Ne);
    }
}
