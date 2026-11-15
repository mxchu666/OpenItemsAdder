package itemsadder.m;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBridge_3
extends BlockBreakEvent {
    public BlockBridge_3(Block block, Player player) {
        super(block, player);
    }
}
