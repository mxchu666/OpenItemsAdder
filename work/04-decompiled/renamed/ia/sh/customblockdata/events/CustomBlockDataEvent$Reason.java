package ia.sh.customblockdata.events;

import java.util.Arrays;
import java.util.List;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.jetbrains.annotations.NotNull;

public static enum CustomBlockDataEvent.Reason {
    BLOCK_BREAK(BlockBreakEvent.class),
    BLOCK_PLACE(BlockPlaceEvent.class, BlockMultiPlaceEvent.class),
    EXPLOSION(EntityExplodeEvent.class, BlockExplodeEvent.class),
    PISTON(BlockPistonExtendEvent.class, BlockPistonRetractEvent.class),
    BURN(BlockBurnEvent.class),
    ENTITY_CHANGE_BLOCK(EntityChangeBlockEvent.class),
    FADE(BlockFadeEvent.class),
    STRUCTURE_GROW(StructureGrowEvent.class),
    FERTILIZE(BlockFertilizeEvent.class),
    LEAVES_DECAY(LeavesDecayEvent.class),
    UNKNOWN(new Class[]{null});

    @NotNull
    private final List<Class<? extends Event>> eventClasses;

    @SafeVarargs
    private CustomBlockDataEvent.Reason(Class<? extends Event> ... classArray) {
        this.eventClasses = Arrays.asList(classArray);
    }

    @NotNull
    public List<Class<? extends Event>> getApplicableEvents() {
        return this.eventClasses;
    }

    static /* synthetic */ List access$000(CustomBlockDataEvent.Reason reason) {
        return reason.eventClasses;
    }
}
