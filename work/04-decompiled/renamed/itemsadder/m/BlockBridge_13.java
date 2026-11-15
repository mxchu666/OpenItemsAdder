package itemsadder.m;

import itemsadder.m.BlockWrapper_4;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RealEnum;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Nullable;

public abstract class BlockBridge_13
extends ItemStackBuilder_4
implements BlockWrapper_4 {
    public final RealEnum Hq;
    @Nullable
    String yn;
    @Nullable
    String yo;

    public BlockBridge_13(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, Material material, RealEnum realEnum) {
        super(pluginFileConfigurationHolder, string, string2, material);
        this.Hq = realEnum;
    }

    public boolean nC() {
        return this.Hq != RealEnum.TILE;
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
