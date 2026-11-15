package itemsadder.m;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class bez
extends BlockBreakEvent {
    public bez(Block block, Player player) {
        super(block, player);
    }
}
