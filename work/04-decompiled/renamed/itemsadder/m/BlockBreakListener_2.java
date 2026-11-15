package itemsadder.m;

import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockHolder_2;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.PluginContract;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public final class BlockBreakListener_2
implements PluginContract {
    public void register(Plugin plugin) {
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    protected void a(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        if (BlockBreakListener_2.h(blockBreakEvent.getBlock().getType())) {
            ItemStack itemStack = blockBreakEvent.getPlayer().getItemInHand();
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                for (ItemStack itemStack2 : blockBreakEvent.getBlock().getDrops(itemStack)) {
                    LocationBridge_4.b(blockBreakEvent.getBlock().getLocation(), itemStack2);
                }
            }
            blockBreakEvent.setCancelled(true);
            BlockHolder_2.tN().a(blockBreakEvent.getBlock(), Material.AIR, true);
            if (blockBreakEvent.getPlayer().getGameMode() != GameMode.CREATIVE && ItemStackBridge_2.ap(itemStack)) {
                ItemStackBridge_2.a(itemStack, 1, true, true);
            }
        } else if (blockBreakEvent.getBlock().getType() == Material.PISTON && ItemStackRegistry.g().aT.y(blockBreakEvent.getBlock())) {
            for (Block block : LocationBridge_4.b(blockBreakEvent.getBlock(), false, true)) {
                if (block.getType() != Material.PISTON_HEAD) continue;
                if (blockBreakEvent.getPlayer().getGameMode() == GameMode.CREATIVE) {
                    blockBreakEvent.setCancelled(true);
                    blockBreakEvent.getBlock().setType(Material.AIR, false);
                }
                block.setType(Material.AIR, false);
                return;
            }
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    protected void a(StructureGrowEvent structureGrowEvent) {
        if (structureGrowEvent.getSpecies().compareTo((Enum)TreeType.BROWN_MUSHROOM) != 0 && structureGrowEvent.getSpecies().compareTo((Enum)TreeType.RED_MUSHROOM) != 0) {
            return;
        }
        structureGrowEvent.setCancelled(true);
        for (BlockState blockState : structureGrowEvent.getBlocks()) {
            if (!BlockBridge_2.S(blockState.getType())) {
                blockState.getLocation().getBlock().setType(blockState.getType());
            }
            ItemStackRegistry.g().aT.a(blockState.getBlock(), true, true, true);
        }
    }

    public static boolean h(Material material) {
        return material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK || material == Material.MUSHROOM_STEM;
    }
}
