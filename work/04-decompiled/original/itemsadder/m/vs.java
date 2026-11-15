package itemsadder.m;

import itemsadder.m.vp;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class vs
extends vp {
    public final Material Ne;

    public vs(Material material) {
        this.Ne = material;
    }

    @Override
    public ItemStack rt() {
        return new ItemStack(this.Ne);
    }
}
