package ia.sh.customblockdata.events;

import ia.sh.customblockdata.events.CustomBlockDataEvent;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomBlockDataRemoveEvent
extends CustomBlockDataEvent {
    public CustomBlockDataRemoveEvent(@NotNull Plugin plugin, @NotNull Block block, @Nullable Event event) {
        super(plugin, block, event);
    }
}
