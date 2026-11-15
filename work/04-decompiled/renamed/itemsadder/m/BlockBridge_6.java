package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.Opaque126;
import java.util.HashSet;
import org.bukkit.block.Block;

public class BlockBridge_6
extends Opaque126 {
    public static final String yb = "fuel";
    public short yc;
    public HashSet yd;

    public BlockBridge_6(ItemStackBuilder_4 itemStackBuilder_4, short s) {
        super(itemStackBuilder_4);
        this.yc = s;
        this.yd = new HashSet();
    }

    public boolean l(Block block) {
        if (this.yd.isEmpty()) {
            return true;
        }
        return this.yd.contains(block.getType());
    }
}
