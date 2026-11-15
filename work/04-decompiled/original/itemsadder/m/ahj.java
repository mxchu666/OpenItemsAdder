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
import org.bukkit.craftbukkit.v1_21_R2.CraftChunk;
import org.bukkit.craftbukkit.v1_21_R2.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_21_R2.util.CraftMagicNumbers;

public class ahj
implements ahe {
    private static final IBlockData abV = CraftMagicNumbers.getBlock((Material)Material.AIR).m();
    private static final IBlockData abW = ((CraftBlockData)Bukkit.createBlockData((String)"chorus_plant[down=true,east=true,north=true,south=true,up=true,west=true]")).getState();

    public static Chunk y(org.bukkit.Chunk chunk) {
        return (Chunk)((CraftChunk)chunk).getHandle(ChunkStatus.n);
    }

    @Override
    public void be(Block block) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        Chunk chunk = ahj.y(block.getChunk());
        if (block.getType() == Material.CHORUS_PLANT) {
            this.a(blockPosition, chunk, abW);
        } else {
            this.a(blockPosition, chunk, CraftMagicNumbers.getBlock((Material)block.getType()).m());
        }
    }

    @Override
    public boolean d(Block block, Material material) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        Chunk chunk = ahj.y(block.getChunk());
        IBlockData iBlockData = CraftMagicNumbers.getBlock((Material)material).m();
        return this.a(blockPosition, chunk, iBlockData);
    }

    @Override
    public boolean setBlockData(Block block, BlockData blockData) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        Chunk chunk = ahj.y(block.getChunk());
        IBlockData iBlockData = ((CraftBlockData)blockData).getState();
        return this.a(blockPosition, chunk, iBlockData);
    }

    @Override
    public boolean bf(Block block) {
        BlockPosition blockPosition = new BlockPosition(block.getX(), block.getY(), block.getZ());
        Chunk chunk = ahj.y(block.getChunk());
        return this.a(blockPosition, chunk, abV);
    }

    private boolean a(BlockPosition blockPosition, Chunk chunk, IBlockData iBlockData) {
        return chunk.setBlockState(blockPosition, iBlockData, false, false) != null;
    }
}
