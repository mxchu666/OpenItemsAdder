package itemsadder.m;

import dev.lone.itemsadder.api.CustomBlock;
import itemsadder.m.gn;
import org.bukkit.block.BlockState;

public class go
extends gn {
    String namespacedId;

    public go(String string) {
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
