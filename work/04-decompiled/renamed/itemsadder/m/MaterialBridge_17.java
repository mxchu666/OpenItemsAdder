package itemsadder.m;

import itemsadder.m.ItemStackBridge_33;
import org.bukkit.Material;

public class MaterialBridge_17
extends ItemStackBridge_33 {
    final Material LN;

    public MaterialBridge_17(Material material) {
        this.LN = material;
    }

    public Material nM() {
        return this.LN;
    }
}
