package itemsadder.m;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBridge_4
extends BlockPlaceEvent {
    public BlockBridge_4(Block block, BlockState blockState, Block block2, ItemStack itemStack, Player player, boolean bl) {
        super(block, blockState, block2, itemStack, player, bl);
    }
}
