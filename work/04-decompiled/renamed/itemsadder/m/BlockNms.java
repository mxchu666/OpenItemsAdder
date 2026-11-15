package itemsadder.m;

import itemsadder.m.AirEnum;
import itemsadder.m.BlockRegistry;
import itemsadder.m.InstrumentByteStringData;
import itemsadder.m.MaterialBlockDataHolder;
import java.util.HashMap;
import org.bukkit.Chunk;
import org.bukkit.HeightMap;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public interface BlockNms {
    public static final HashMap Vo = new HashMap();

    public Class tj();

    public boolean a(Block var1, AirEnum var2);

    public boolean aK(Block var1);

    public boolean B(Material var1);

    public boolean aL(Block var1);

    public boolean aJ(Block var1);

    public boolean aN(Block var1);

    public boolean aQ(Block var1);

    public int a(Chunk var1, int var2, int var3, HeightMap var4);

    public void a(BlockRegistry var1);

    public int C(Material var1);

    default public Instrument aR(Block block) {
        return MaterialBlockDataHolder.aB(block);
    }

    @Nullable
    public InstrumentByteStringData aS(Block var1);

    @Nullable
    public InstrumentByteStringData c(Block var1, byte var2);

    default public Instrument aT(Block block) {
        return this.aR(block.getRelative(BlockFace.DOWN));
    }

    public boolean D(Material var1);

    public void bH(@Nullable Player var1);
}
