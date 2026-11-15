package itemsadder.m;

import com.comphenix.protocol.wrappers.WrappedBlockData;
import itemsadder.m.aab;
import itemsadder.m.abl;
import itemsadder.m.ahd;
import itemsadder.m.ahe;
import itemsadder.m.arg;
import itemsadder.m.bcc;
import itemsadder.m.bcv;
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

public final class abk {
    private final abl VJ = (abl)aab.n(abl.class);
    private static abk VK;
    private static final WrappedBlockData VL;
    private static final BlockData VM;
    public static final BlockFace[] VN;

    abk() {
    }

    public static abk tk() {
        if (VK == null) {
            VK = new abk();
        }
        return VK;
    }

    public static abl tl() {
        return abk.tk().VJ;
    }

    public static void a(Collection collection, Block block) {
        Collection collection2 = bcc.ad(block.getLocation());
        arg arg2 = new arg(collection2);
        ahe ahe2 = ahd.tN();
        for (Block block2 : collection) {
            arg2.a(block2.getLocation().toVector(), VL);
            ahe2.bf(block2);
        }
        arg2.uZ();
    }

    public static void aU(Block block) {
        ahd.tN().bf(block);
        for (Player player : bcc.ad(block.getLocation())) {
            player.sendBlockChange(block.getLocation(), VM);
        }
    }

    public static void aV(Block block) {
        block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, (Object)block.getType());
        block.setType(Material.AIR, false);
    }

    public static void b(Collection collection, Block block) {
        Collection collection2 = bcc.ad(block.getLocation());
        arg arg2 = new arg(collection2);
        ArrayList<Block> arrayList = new ArrayList<Block>();
        for (Block block2 : collection) {
            for (BlockFace blockFace : VN) {
                Block block3 = block2.getRelative(blockFace);
                if (arrayList.contains(block3)) continue;
                arrayList.add(block3);
                arg2.a(block3.getLocation().toVector(), WrappedBlockData.createData((Object)block3.getBlockData()));
            }
        }
        arg2.uZ();
    }

    public static void aW(Block block) {
        abk.a(block.getLocation(), block.getBlockData());
    }

    public static void a(Location location, BlockData blockData) {
        location.getWorld().spawnParticle(Particle.BLOCK, location.clone().add(0.5, 0.5, 0.5), 40, 0.2333333333333333, 0.2333333333333333, 0.2333333333333333, 0.09, (Object)blockData);
    }

    public static void a(BlockData blockData, Location location) {
        if (blockData != null) {
            for (Player player : bcc.ad(location)) {
                player.sendBlockChange(location, blockData);
            }
        }
    }

    public static void t(Block block) {
        bcv.a(block.getLocation(), abk.tl().F(block.getType()), SoundCategory.BLOCKS, 1.0f, 0.8f);
    }

    static {
        VL = WrappedBlockData.createData((Material)Material.AIR);
        VM = Bukkit.createBlockData((Material)Material.AIR);
        VN = new BlockFace[]{BlockFace.DOWN, BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.UP, BlockFace.WEST};
    }
}
