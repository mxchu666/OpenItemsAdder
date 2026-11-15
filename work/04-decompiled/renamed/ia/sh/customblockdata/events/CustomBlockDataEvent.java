package ia.sh.customblockdata.events;

import ia.sh.customblockdata.CustomBlockData;
import java.util.Arrays;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
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
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CustomBlockDataEvent
extends Event
implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    @NotNull
    final Plugin plugin;
    @NotNull
    final Block block;
    @NotNull
    final CustomBlockData cbd;
    @NotNull
    final Event bukkitEvent;
    boolean isCancelled = false;

    protected CustomBlockDataEvent(@NotNull Plugin plugin, @NotNull Block block, @NotNull Event event) {
        this.plugin = plugin;
        this.block = block;
        this.bukkitEvent = event;
        this.cbd = new CustomBlockData(block, plugin);
    }

    @NotNull
    public Block getBlock() {
        return this.block;
    }

    @NotNull
    public Event getBukkitEvent() {
        return this.bukkitEvent;
    }

    @NotNull
    public CustomBlockData getCustomBlockData() {
        return this.cbd;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean bl) {
        this.isCancelled = bl;
    }

    @NotNull
    public Reason getReason() {
        if (this.bukkitEvent == null) {
            return Reason.UNKNOWN;
        }
        for (Reason reason : Reason.values()) {
            if (reason == Reason.UNKNOWN || !reason.eventClasses.stream().anyMatch(clazz -> clazz.equals(this.bukkitEvent.getClass()))) continue;
            return reason;
        }
        return Reason.UNKNOWN;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static enum Reason {
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
        private Reason(Class<? extends Event> ... classArray) {
            this.eventClasses = Arrays.asList(classArray);
        }

        @NotNull
        public List<Class<? extends Event>> getApplicableEvents() {
            return this.eventClasses;
        }
    }
}
