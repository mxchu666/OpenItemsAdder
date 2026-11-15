package itemsadder.m;

import itemsadder.m.LocationBridge_2;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

public interface BlockWrapper_3 {
    public void be(Block var1);

    public boolean d(Block var1, Material var2);

    default public boolean a(Block block, Material material, boolean bl) {
        boolean bl2 = this.d(block, material);
        if (bl2 && bl) {
            Location location = block.getLocation();
            BlockData blockData = block.getBlockData();
            this.b(location, blockData);
        }
        return bl2;
    }

    public boolean setBlockData(Block var1, BlockData var2);

    default public boolean a(Block block, BlockData blockData, boolean bl) {
        boolean bl2 = this.setBlockData(block, blockData);
        if (bl2 && bl) {
            Location location = block.getLocation();
            this.b(location, blockData);
        }
        return bl2;
    }

    public boolean bf(Block var1);

    default public boolean l(Block block, boolean bl) {
        boolean bl2 = this.bf(block);
        if (bl2 && bl) {
            Location location = block.getLocation();
            BlockData blockData = block.getBlockData();
            this.b(location, blockData);
        }
        return bl2;
    }

    default public void b(Location location, BlockData blockData) {
        for (Player player : LocationBridge_2.ad(location)) {
            player.sendBlockChange(location, blockData);
        }
    }
}
