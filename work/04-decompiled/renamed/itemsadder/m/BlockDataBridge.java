package itemsadder.m;

import itemsadder.m.BlockStateBridge;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;

public class BlockDataBridge
extends BlockStateBridge {
    BlockData vC;

    public BlockDataBridge(BlockData blockData) {
        this.vC = blockData;
    }

    @Override
    public boolean b(BlockState blockState) {
        if (this.vC == null) {
            return false;
        }
        return blockState.getType() == this.vC.getMaterial() && this.vC.matches(blockState.getBlockData());
    }
}
