package itemsadder.m;

import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.World;
import org.bukkit.block.Block;

class WorldBlockHolder {
    private final World At;
    public Long Au;
    public Block Ae;
    private boolean Av;

    WorldBlockHolder(BlockPosition blockPosition, World world) {
        this.At = world;
        this.Au = System.currentTimeMillis();
        this.Ae = blockPosition.toLocation(world).getBlock();
        this.Av = true;
    }

    public boolean lt() {
        boolean bl = System.currentTimeMillis() - this.Au > 150L || this.Av;
        this.Av = false;
        return bl;
    }

    public void lu() {
        this.Au = System.currentTimeMillis();
    }

    public void a(BlockPosition blockPosition) {
        this.Ae = blockPosition.toLocation(this.At).getBlock();
    }
}
