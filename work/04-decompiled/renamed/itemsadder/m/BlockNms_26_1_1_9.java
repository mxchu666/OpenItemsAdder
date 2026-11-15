package itemsadder.m;

import itemsadder.m.BlockWrapper_3;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.CraftChunk;
import org.bukkit.craftbukkit.block.data.CraftBlockData;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;

public class BlockNms_26_1_1_9
implements BlockWrapper_3 {
    private static final BlockState ach = CraftMagicNumbers.getBlock((Material)Material.AIR).defaultBlockState();
    private static final BlockState aci = ((CraftBlockData)Bukkit.createBlockData((String)"chorus_plant[down=true,east=true,north=true,south=true,up=true,west=true]")).getState();

    public static LevelChunk z(Chunk chunk) {
        return (LevelChunk)((CraftChunk)chunk).getHandle(ChunkStatus.FULL);
    }

    @Override
    public void be(Block block) {
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        LevelChunk levelChunk = BlockNms_26_1_1_9.z(block.getChunk());
        if (block.getType() == Material.CHORUS_PLANT) {
            this.a(blockPos, levelChunk, aci);
        } else {
            this.a(blockPos, levelChunk, CraftMagicNumbers.getBlock((Material)block.getType()).defaultBlockState());
        }
    }

    @Override
    public boolean d(Block block, Material material) {
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        LevelChunk levelChunk = BlockNms_26_1_1_9.z(block.getChunk());
        BlockState blockState = CraftMagicNumbers.getBlock((Material)material).defaultBlockState();
        return this.a(blockPos, levelChunk, blockState);
    }

    @Override
    public boolean setBlockData(Block block, BlockData blockData) {
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        LevelChunk levelChunk = BlockNms_26_1_1_9.z(block.getChunk());
        BlockState blockState = ((CraftBlockData)blockData).getState();
        return this.a(blockPos, levelChunk, blockState);
    }

    @Override
    public boolean bf(Block block) {
        BlockPos blockPos = new BlockPos(block.getX(), block.getY(), block.getZ());
        LevelChunk levelChunk = BlockNms_26_1_1_9.z(block.getChunk());
        return this.a(blockPos, levelChunk, ach);
    }

    private boolean a(BlockPos blockPos, LevelChunk levelChunk, BlockState blockState) {
        return levelChunk.setBlockState(blockPos, blockState, 0) != null;
    }
}
