package itemsadder.m;

import java.util.List;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface afk {
    public Object M(String var1, String var2);

    public String bd(Block var1);

    public void a(Block var1, String var2, String var3);

    public void a(Location var1, String var2, String var3, boolean var4);

    public void a(Chunk var1, Player var2);

    default public void a(World world, int n, int n2, Player player) {
        this.a(world.getChunkAt(n >> 4, n2 >> 4), player);
    }

    public boolean z(List var1);
}
