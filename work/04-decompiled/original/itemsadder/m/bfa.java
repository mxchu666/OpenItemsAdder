package itemsadder.m;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class bfa
extends BlockPlaceEvent {
    public bfa(Block block, BlockState blockState, Block block2, ItemStack itemStack, Player player, boolean bl) {
        super(block, blockState, block2, itemStack, player, bl);
    }
}
