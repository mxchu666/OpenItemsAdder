package itemsadder.m;

import itemsadder.m.BlockWrapper_3;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.NmsWrapperFactory;
import java.util.Collection;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

@Deprecated
public final class BlockHolder_2 {
    private final BlockWrapper_3 abL = (BlockWrapper_3)NmsWrapperFactory.n(BlockWrapper_3.class);
    public static BlockHolder_2 abM;

    BlockHolder_2() {
    }

    public static BlockHolder_2 tM() {
        if (abM == null) {
            abM = new BlockHolder_2();
        }
        return abM;
    }

    public static BlockWrapper_3 tN() {
        return BlockHolder_2.tM().abL;
    }

    public static void a(Block block, BlockData blockData) {
        Location location = block.getLocation();
        Collection collection = LocationBridge_2.ad(location);
        for (Player player : collection) {
            player.sendBlockChange(location, blockData);
        }
    }
}
