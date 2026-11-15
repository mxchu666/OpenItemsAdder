package itemsadder.m;

import dev.lone.itemsadder.api.CustomBlock;
import itemsadder.m.BlockStateBridge;
import org.bukkit.block.BlockState;

public class BlockStateBridge_2
extends BlockStateBridge {
    String namespacedId;

    public BlockStateBridge_2(String string) {
        this.namespacedId = string;
    }

    @Override
    public boolean b(BlockState blockState) {
        CustomBlock customBlock = CustomBlock.byAlreadyPlaced(blockState.getBlock());
        if (customBlock == null) {
            return false;
        }
        return customBlock.getNamespacedID().equals(this.namespacedId);
    }
}
