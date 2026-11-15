package ia.sh.customblockdata.events;

import ia.sh.customblockdata.events.CustomBlockDataEvent;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CustomBlockDataMoveEvent
extends CustomBlockDataEvent {
    @NotNull
    private final Block blockTo;

    public CustomBlockDataMoveEvent(@NotNull Plugin plugin, @NotNull Block block, @NotNull Block block2, @NotNull Event event) {
        super(plugin, block, event);
        this.blockTo = block2;
    }

    @NotNull
    public Block getBlockTo() {
        return this.blockTo;
    }
}
