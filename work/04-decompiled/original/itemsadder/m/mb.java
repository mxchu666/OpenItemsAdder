package itemsadder.m;

import itemsadder.m.aaf;
import itemsadder.m.ai;
import itemsadder.m.bcc;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.qw;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Fire;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;

public final class mb
implements ai {
    Random Bl = new Random();

    public void register(Plugin plugin) {
        bev.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(BlockPhysicsEvent blockPhysicsEvent) {
        if (blockPhysicsEvent.getBlock().getType() == Material.FIRE) {
            blockPhysicsEvent.setCancelled(true);
            if (!d.g().k()) {
                return;
            }
            Block block = blockPhysicsEvent.getBlock();
            Fire fire = (Fire)blockPhysicsEvent.getBlock().getBlockData();
            ms ms2 = d.g().b(block);
            Material material = block.getRelative(BlockFace.DOWN).getType();
            if (material != Material.NETHERRACK && material != Material.MAGMA_BLOCK && material != Material.LAVA) {
                int n;
                if (ms2.T(block)) {
                    Integer n2 = ms2.ae(block);
                    n = n2 == null ? 1 : n2;
                    n = Math.min(15, n + this.Bl.nextInt(3) / 2);
                    ms2.b(block, n);
                } else {
                    n = fire.getAge();
                    ms2.b(block, fire.getAge());
                }
                if (n >= 15 && this.Bl.nextInt(4) == 0 && !material.isFlammable()) {
                    ms2.c(block, true);
                    return;
                }
                boolean bl = false;
                for (BlockFace blockFace : bdf.aBw) {
                    if (!block.getRelative(blockFace).getType().isFlammable()) continue;
                    bl = true;
                    break;
                }
                if (!(bl || n <= 3 && block.getRelative(BlockFace.DOWN).getType().isSolid())) {
                    ms2.a(block, true, true);
                    return;
                }
            }
            if (ms2.isCustomBlock(block)) {
                qw qw2;
                try {
                    qw2 = (qw)d.g().e(ms2.Y(block));
                }
                catch (ClassCastException classCastException) {
                    return;
                }
                if (qw2 == null) {
                    return;
                }
                fire.setAge(qw2.Hl.kh);
                block.setBlockData((BlockData)fire);
            } else if (fire.getAge() > 0) {
                fire.setAge(0);
                block.setBlockData((BlockData)fire);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(BlockSpreadEvent blockSpreadEvent) {
        if (blockSpreadEvent.getNewState().getType() != Material.FIRE) {
            return;
        }
        Block block = blockSpreadEvent.getSource();
        Block block2 = blockSpreadEvent.getBlock();
        ms ms2 = d.g().b(block);
        if (ms2.isCustomBlock(block)) {
            blockSpreadEvent.setCancelled(true);
            Fire fire = (Fire)blockSpreadEvent.getNewState().getBlockData();
            ms ms3 = d.g().b(block2);
            ms3.b(block2, fire.getAge());
            qw qw2 = (qw)d.g().e(ms2.Y(block));
            if (qw2 == null) {
                return;
            }
            fire.setAge(qw2.Hl.kh);
            ms3.e(block2, qw2.getNamespacedID());
            block2.setBlockData((BlockData)fire);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(BlockBurnEvent blockBurnEvent) {
        Block block = blockBurnEvent.getIgnitingBlock();
        if (block == null) {
            return;
        }
        Block block2 = blockBurnEvent.getBlock();
        ms ms2 = d.g().b(block);
        if (ms2.isCustomBlock(block)) {
            blockBurnEvent.setCancelled(true);
            qw qw2 = (qw)d.g().e(ms2.Y(block));
            if (qw2 == null) {
                return;
            }
            Fire fire = (Fire)block.getBlockData();
            int n = fire.getAge();
            if (this.Bl.nextInt(n + 10) < 5 && !aaf.aK(block2)) {
                block2.setType(Material.FIRE);
                if (block2.getBlockData() instanceof Fire) {
                    Fire fire2 = (Fire)block2.getBlockData();
                    ms ms3 = d.g().b(block2);
                    ms3.b(block2, 0);
                    fire2.setAge(qw2.Hl.kh);
                    ms3.e(block2, qw2.getNamespacedID());
                    block2.setBlockData((BlockData)fire2);
                }
            } else if (block2.getType() != Material.TNT) {
                block2.setType(Material.AIR);
            } else {
                if (!bcc.bq(block2)) {
                    return;
                }
                block2.setType(Material.AIR);
                block2.getWorld().spawn(block2.getLocation(), TNTPrimed.class);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(BlockFadeEvent blockFadeEvent) {
        if (blockFadeEvent.getBlock().getType() != Material.FIRE) {
            return;
        }
        d.g().b(blockFadeEvent.getBlock()).ag(blockFadeEvent.getBlock());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void g(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }
        if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        if (playerInteractEvent.getClickedBlock() == null || playerInteractEvent.getClickedBlock().getType() != Material.FIRE) {
            return;
        }
        if (bcc.a(playerInteractEvent.getClickedBlock(), playerInteractEvent.getPlayer())) {
            d.g().b(playerInteractEvent.getClickedBlock()).ag(playerInteractEvent.getClickedBlock());
        }
    }
}
