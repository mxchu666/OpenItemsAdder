package itemsadder.m;

import itemsadder.m.ahd;
import itemsadder.m.ai;
import itemsadder.m.bay;
import itemsadder.m.bbs;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
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

public final class mf
implements ai {
    public void register(Plugin plugin) {
        bev.a(this, plugin);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    protected void a(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        if (mf.h(blockBreakEvent.getBlock().getType())) {
            ItemStack itemStack = blockBreakEvent.getPlayer().getItemInHand();
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                for (ItemStack itemStack2 : blockBreakEvent.getBlock().getDrops(itemStack)) {
                    bdf.b(blockBreakEvent.getBlock().getLocation(), itemStack2);
                }
            }
            blockBreakEvent.setCancelled(true);
            ahd.tN().a(blockBreakEvent.getBlock(), Material.AIR, true);
            if (blockBreakEvent.getPlayer().getGameMode() != GameMode.CREATIVE && bbs.ap(itemStack)) {
                bbs.a(itemStack, 1, true, true);
            }
        } else if (blockBreakEvent.getBlock().getType() == Material.PISTON && d.g().aT.y(blockBreakEvent.getBlock())) {
            for (Block block : bdf.b(blockBreakEvent.getBlock(), false, true)) {
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
            if (!bay.S(blockState.getType())) {
                blockState.getLocation().getBlock().setType(blockState.getType());
            }
            d.g().aT.a(blockState.getBlock(), true, true, true);
        }
    }

    public static boolean h(Material material) {
        return material == Material.BROWN_MUSHROOM_BLOCK || material == Material.RED_MUSHROOM_BLOCK || material == Material.MUSHROOM_STEM;
    }
}
