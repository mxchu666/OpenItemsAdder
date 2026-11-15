package itemsadder.m;

import itemsadder.m.BlockBridge_13;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.IntData_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RealEnum;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Fire;

public class BlockBridge_12
extends BlockBridge_13 {
    public IntData_4 Hl;

    public BlockBridge_12(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, Material material, int n) {
        super(pluginFileConfigurationHolder, string, string2, material, RealEnum.FIRE);
        this.Hl = new IntData_4(n);
    }

    @Override
    public boolean f(Block block, boolean bl) {
        if (!block.getRelative(BlockFace.DOWN).getType().isSolid()) {
            return false;
        }
        Fire fire = (Fire)Bukkit.createBlockData((Material)Material.FIRE);
        fire.setAge(this.Hl.kh);
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        blockBridge_9.e(block, this.getNamespacedID());
        blockBridge_9.b(block, 0);
        block.setBlockData((BlockData)fire, bl);
        return true;
    }

    @Override
    public boolean as(Block block) {
        return this.f(block, false);
    }

    @Override
    public boolean M(Location location) {
        return this.as(location.getBlock());
    }

    @Override
    public boolean ar(Block block) {
        return this.as(block);
    }

    @Override
    public boolean e(Block block, boolean bl) {
        return this.f(block, bl);
    }

    public static int getAge(Block block) {
        Integer n;
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (blockBridge_9.T(block) && (n = blockBridge_9.ae(block)) != null) {
            return n;
        }
        return 0;
    }

    public static void setAge(Block block, int n) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        blockBridge_9.b(block, n);
    }
}
