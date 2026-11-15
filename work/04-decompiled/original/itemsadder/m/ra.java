package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.qm;
import itemsadder.m.qz;
import itemsadder.m.sd;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Nullable;

public abstract class ra
extends qm
implements qz {
    public final sd Hq;
    @Nullable
    String yn;
    @Nullable
    String yo;

    public ra(bbf bbf2, String string, String string2, Material material, sd sd2) {
        super(bbf2, string, string2, material);
        this.Hq = sd2;
    }

    public boolean nC() {
        return this.Hq != sd.TILE;
    }

    @Override
    public boolean ar(Block block) {
        return this.as(block);
    }

    @Override
    public boolean e(Block block, boolean bl) {
        return this.f(block, bl);
    }

    @Nullable
    public String kL() {
        return this.yn;
    }

    public void bc(String string) {
        this.yn = string;
    }

    @Nullable
    public String kM() {
        return this.yo;
    }

    public void bd(String string) {
        this.yo = string;
    }
}
