package itemsadder.m;

import net.minecraft.world.level.chunk.Chunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import org.bukkit.craftbukkit.v1_20_R4.CraftChunk;

public class axk {
    public static Chunk y(org.bukkit.Chunk chunk) {
        return (Chunk)((CraftChunk)chunk).getHandle(ChunkStatus.n);
    }
}
