package itemsadder.m;

import itemsadder.m.ahe;
import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.chunk.Chunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_20_R4.CraftChunk;
import org.bukkit.craftbukkit.v1_20_R4.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_20_R4.util.CraftMagicNumbers;

public class ahf
implements ahe {
    private static final IBlockData abN = CraftMagicNumbers.getBlock((Material)Material.AIR).o();
    private static final IBlockData abO = ((CraftBlockData)Bukkit.createBlockData((String)"chorus_plant[down=true,east=true,north=true,south=true,up=true,west=true]")).getState();

    @Override
    public void be(Block block) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        Chunk chunk = ahf.y(block.getChunk());
        if (block.getType() == Material.CHORUS_PLANT) {
            this.a(blockPosition, chunk, abO);
        } else {
            this.a(blockPosition, chunk, CraftMagicNumbers.getBlock((Material)block.getType()).o());
        }
    }

    @Override
    public boolean d(Block block, Material material) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        Chunk chunk = ahf.y(block.getChunk());
        IBlockData iBlockData = CraftMagicNumbers.getBlock((Material)material).o();
        return this.a(blockPosition, chunk, iBlockData);
    }

    @Override
    public boolean setBlockData(Block block, BlockData blockData) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        Chunk chunk = ahf.y(block.getChunk());
        IBlockData iBlockData = ((CraftBlockData)blockData).getState();
        return this.a(blockPosition, chunk, iBlockData);
    }

    public static Chunk y(org.bukkit.Chunk chunk) {
        return (Chunk)((CraftChunk)chunk).getHandle(ChunkStatus.n);
    }

    @Override
    public boolean bf(Block block) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        Chunk chunk = ahf.y(block.getChunk());
        return this.a(blockPosition, chunk, abN);
    }

    private boolean a(BlockPosition blockPosition, Chunk chunk, IBlockData iBlockData) {
        return chunk.setBlockState(blockPosition, iBlockData, false, false) != null;
    }
}
