package itemsadder.m;

import com.comphenix.protocol.wrappers.WrappedBlockData;
import itemsadder.m.BlockHolder_2;
import itemsadder.m.BlockWrapper;
import itemsadder.m.BlockWrapper_3;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_3;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.WrappedBlockDataHelper;
import java.util.ArrayList;
import java.util.Collection;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

public final class BlockHolder {
    private final BlockWrapper VJ = (BlockWrapper)NmsWrapperFactory.n(BlockWrapper.class);
    private static BlockHolder VK;
    private static final WrappedBlockData VL;
    private static final BlockData VM;
    public static final BlockFace[] VN;

    BlockHolder() {
    }

    public static BlockHolder tk() {
        if (VK == null) {
            VK = new BlockHolder();
        }
        return VK;
    }

    public static BlockWrapper tl() {
        return BlockHolder.tk().VJ;
    }

    public static void a(Collection collection, Block block) {
        Collection collection2 = LocationBridge_2.ad(block.getLocation());
        WrappedBlockDataHelper wrappedBlockDataHelper = new WrappedBlockDataHelper(collection2);
        BlockWrapper_3 blockWrapper_3 = BlockHolder_2.tN();
        for (Block block2 : collection) {
            wrappedBlockDataHelper.a(block2.getLocation().toVector(), VL);
            blockWrapper_3.bf(block2);
        }
        wrappedBlockDataHelper.uZ();
    }

    public static void aU(Block block) {
        BlockHolder_2.tN().bf(block);
        for (Player player : LocationBridge_2.ad(block.getLocation())) {
            player.sendBlockChange(block.getLocation(), VM);
        }
    }

    public static void aV(Block block) {
        block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, (Object)block.getType());
        block.setType(Material.AIR, false);
    }

    public static void b(Collection collection, Block block) {
        Collection collection2 = LocationBridge_2.ad(block.getLocation());
        WrappedBlockDataHelper wrappedBlockDataHelper = new WrappedBlockDataHelper(collection2);
        ArrayList<Block> arrayList = new ArrayList<Block>();
        for (Block block2 : collection) {
            for (BlockFace blockFace : VN) {
                Block block3 = block2.getRelative(blockFace);
                if (arrayList.contains(block3)) continue;
                arrayList.add(block3);
                wrappedBlockDataHelper.a(block3.getLocation().toVector(), WrappedBlockData.createData((Object)block3.getBlockData()));
            }
        }
        wrappedBlockDataHelper.uZ();
    }

    public static void aW(Block block) {
        BlockHolder.a(block.getLocation(), block.getBlockData());
    }

    public static void a(Location location, BlockData blockData) {
        location.getWorld().spawnParticle(Particle.BLOCK, location.clone().add(0.5, 0.5, 0.5), 40, 0.2333333333333333, 0.2333333333333333, 0.2333333333333333, 0.09, (Object)blockData);
    }

    public static void a(BlockData blockData, Location location) {
        if (blockData != null) {
            for (Player player : LocationBridge_2.ad(location)) {
                player.sendBlockChange(location, blockData);
            }
        }
    }

    public static void t(Block block) {
        LocationBridge_3.a(block.getLocation(), BlockHolder.tl().F(block.getType()), SoundCategory.BLOCKS, 1.0f, 0.8f);
    }

    static {
        VL = WrappedBlockData.createData((Material)Material.AIR);
        VM = Bukkit.createBlockData((Material)Material.AIR);
        VN = new BlockFace[]{BlockFace.DOWN, BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.UP, BlockFace.WEST};
    }
}
