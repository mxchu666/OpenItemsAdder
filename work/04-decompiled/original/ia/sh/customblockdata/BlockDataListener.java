package ia.sh.customblockdata;

import ia.sh.customblockdata.CustomBlockData;
import ia.sh.customblockdata.events.CustomBlockDataMoveEvent;
import ia.sh.customblockdata.events.CustomBlockDataRemoveEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.plugin.Plugin;

final class BlockDataListener
implements Listener {
    private final Plugin plugin;
    private final Predicate<Block> customDataPredicate;

    public BlockDataListener(Plugin plugin) {
        this.plugin = plugin;
        this.customDataPredicate = block -> CustomBlockData.hasCustomBlockData(block, plugin);
    }

    private CustomBlockData getCbd(BlockEvent blockEvent) {
        return this.getCbd(blockEvent.getBlock());
    }

    private CustomBlockData getCbd(Block block) {
        return new CustomBlockData(block, this.plugin);
    }

    private void callAndRemove(BlockEvent blockEvent) {
        if (this.callEvent(blockEvent)) {
            this.getCbd(blockEvent).clear();
        }
    }

    private boolean callEvent(BlockEvent blockEvent) {
        return this.callEvent(blockEvent.getBlock(), (Event)blockEvent);
    }

    private boolean callEvent(Block block, Event event) {
        if (!CustomBlockData.hasCustomBlockData(block, this.plugin) || CustomBlockData.isProtected(block, this.plugin)) {
            return false;
        }
        CustomBlockDataRemoveEvent customBlockDataRemoveEvent = new CustomBlockDataRemoveEvent(this.plugin, block, event);
        Bukkit.getPluginManager().callEvent((Event)customBlockDataRemoveEvent);
        return !customBlockDataRemoveEvent.isCancelled();
    }

    private void callAndRemoveBlockStateList(List<BlockState> list, Event event) {
        list.stream().map(BlockState::getBlock).filter(this.customDataPredicate).forEach(block -> this.callAndRemove((Block)block, event));
    }

    private void callAndRemoveBlockList(List<Block> list, Event event) {
        list.stream().filter(this.customDataPredicate).forEach(block -> this.callAndRemove((Block)block, event));
    }

    private void callAndRemove(Block block, Event event) {
        if (this.callEvent(block, event)) {
            this.getCbd(block).clear();
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onBreak(BlockBreakEvent blockBreakEvent) {
        this.callAndRemove((BlockEvent)blockBreakEvent);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onPlace(BlockPlaceEvent blockPlaceEvent) {
        if (!CustomBlockData.isDirty(blockPlaceEvent.getBlock())) {
            this.callAndRemove((BlockEvent)blockPlaceEvent);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onEntity(EntityChangeBlockEvent entityChangeBlockEvent) {
        if (entityChangeBlockEvent.getTo() != entityChangeBlockEvent.getBlock().getType()) {
            this.callAndRemove(entityChangeBlockEvent.getBlock(), (Event)entityChangeBlockEvent);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onExplode(BlockExplodeEvent blockExplodeEvent) {
        this.callAndRemoveBlockList(blockExplodeEvent.blockList(), (Event)blockExplodeEvent);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onExplode(EntityExplodeEvent entityExplodeEvent) {
        this.callAndRemoveBlockList(entityExplodeEvent.blockList(), (Event)entityExplodeEvent);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onBurn(BlockBurnEvent blockBurnEvent) {
        this.callAndRemove((BlockEvent)blockBurnEvent);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onPiston(BlockPistonExtendEvent blockPistonExtendEvent) {
        this.onPiston(blockPistonExtendEvent.getBlocks(), (BlockPistonEvent)blockPistonExtendEvent);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onPiston(BlockPistonRetractEvent blockPistonRetractEvent) {
        this.onPiston(blockPistonRetractEvent.getBlocks(), (BlockPistonEvent)blockPistonRetractEvent);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onFade(BlockFadeEvent blockFadeEvent) {
        if (blockFadeEvent.getBlock().getType() == Material.FIRE) {
            return;
        }
        if (blockFadeEvent.getNewState().getType() != blockFadeEvent.getBlock().getType()) {
            this.callAndRemove((BlockEvent)blockFadeEvent);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onStructure(StructureGrowEvent structureGrowEvent) {
        this.callAndRemoveBlockStateList(structureGrowEvent.getBlocks(), (Event)structureGrowEvent);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onFertilize(BlockFertilizeEvent blockFertilizeEvent) {
        this.callAndRemoveBlockStateList(blockFertilizeEvent.getBlocks(), (Event)blockFertilizeEvent);
    }

    private void onPiston(List<Block> list, BlockPistonEvent blockPistonEvent) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        BlockFace blockFace = blockPistonEvent.getDirection();
        list.stream().filter(this.customDataPredicate).forEach(block -> {
            CustomBlockData customBlockData = new CustomBlockData((Block)block, this.plugin);
            if (customBlockData.isEmpty() || customBlockData.isProtected()) {
                return;
            }
            PistonMoveReaction pistonMoveReaction = block.getPistonMoveReaction();
            if (pistonMoveReaction == PistonMoveReaction.BREAK) {
                this.callAndRemove((Block)block, (Event)blockPistonEvent);
                return;
            }
            Block block2 = block.getRelative(blockFace);
            CustomBlockDataMoveEvent customBlockDataMoveEvent = new CustomBlockDataMoveEvent(this.plugin, (Block)block, block2, (Event)blockPistonEvent);
            Bukkit.getPluginManager().callEvent((Event)customBlockDataMoveEvent);
            if (customBlockDataMoveEvent.isCancelled()) {
                return;
            }
            linkedHashMap.put(block2, customBlockData);
        });
        Utils.reverse(linkedHashMap).forEach((block, customBlockData) -> {
            customBlockData.copyTo((Block)block, this.plugin);
            customBlockData.clear();
        });
    }

    private static final class Utils {
        private Utils() {
        }

        private static <K, V> Map<K, V> reverse(Map<K, V> map) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList<K> arrayList = new ArrayList<K>(map.keySet());
            Collections.reverse(arrayList);
            arrayList.forEach(object -> linkedHashMap.put(object, map.get(object)));
            return linkedHashMap;
        }
    }
}
