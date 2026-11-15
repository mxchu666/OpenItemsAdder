package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.Opaque126;
import itemsadder.m.Opaque133;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockBridge_7
extends Opaque126 {
    public static final String yM = "liquid_bucket";
    Opaque133 yN;

    public BlockBridge_7(ItemStackBuilder_4 itemStackBuilder_4, Opaque133 opaque133) {
        super(itemStackBuilder_4);
        this.yN = opaque133;
    }

    public Opaque133 kU() {
        return this.yN;
    }

    public static boolean m(Block block) {
        return BlockBridge_7.c(block.getType());
    }

    public static boolean c(Material material) {
        return material == Material.WATER;
    }
}
