package itemsadder.m;

import itemsadder.m.aaf;
import itemsadder.m.aah;
import itemsadder.m.aaj;
import itemsadder.m.rz;
import java.util.HashMap;
import org.bukkit.Chunk;
import org.bukkit.HeightMap;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public interface aai {
    public static final HashMap Vo = new HashMap();

    public Class tj();

    public boolean a(Block var1, aah var2);

    public boolean aK(Block var1);

    public boolean B(Material var1);

    public boolean aL(Block var1);

    public boolean aJ(Block var1);

    public boolean aN(Block var1);

    public boolean aQ(Block var1);

    public int a(Chunk var1, int var2, int var3, HeightMap var4);

    public void a(aaf var1);

    public int C(Material var1);

    default public Instrument aR(Block block) {
        return rz.aB(block);
    }

    @Nullable
    public aaj aS(Block var1);

    @Nullable
    public aaj c(Block var1, byte var2);

    default public Instrument aT(Block block) {
        return this.aR(block.getRelative(BlockFace.DOWN));
    }

    public boolean D(Material var1);

    public void bH(@Nullable Player var1);
}
