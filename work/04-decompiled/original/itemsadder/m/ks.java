package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.aaf;
import itemsadder.m.afj;
import itemsadder.m.ai;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.kd;
import itemsadder.m.ms;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.FluidLevelChangeEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ks
implements ai {
    private final d zt;

    public ks(Plugin plugin, d d2) {
        this.zt = d2;
        bev.a(this, plugin);
        d2.ar.a(new my(PlayerInteractEvent.class, this::f));
        d2.ar.a(new my(PlayerItemConsumeEvent.class, this::a));
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockPistonExtendEvent blockPistonExtendEvent) {
        for (Block block : blockPistonExtendEvent.getBlocks()) {
            ms ms2;
            if (!kd.m(block) || !(ms2 = this.zt.a(block.getChunk())).T(block)) continue;
            blockPistonExtendEvent.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(EntityChangeBlockEvent entityChangeBlockEvent) {
        if (entityChangeBlockEvent.getEntityType() != EntityType.FALLING_BLOCK) {
            return;
        }
        if (!entityChangeBlockEvent.getTo().isSolid()) {
            return;
        }
        this.n(entityChangeBlockEvent.getBlock());
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerBucketFillEvent playerBucketFillEvent) {
        String string;
        Block block = playerBucketFillEvent.getBlock();
        String string2 = this.n(block);
        if (string2 != null && (string = (String)d.g().bf.get(string2)) != null) {
            playerBucketFillEvent.setItemStack(d.g().q(string));
            this.n(block);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockPlaceEvent blockPlaceEvent) {
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        this.n(blockPlaceEvent.getBlockReplacedState().getBlock());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(BlockFromToEvent blockFromToEvent) {
        Block block = blockFromToEvent.getBlock();
        Block block2 = blockFromToEvent.getToBlock();
        if (block.getType() != Material.WATER || !aaf.aJ(block2)) {
            return;
        }
        ms ms2 = this.zt.a(block.getChunk());
        String string = ms2.ab(block);
        if (string == null) {
            return;
        }
        blockFromToEvent.setCancelled(true);
        if (!(block.getBlockData() instanceof Levelled)) {
            return;
        }
        Levelled levelled = (Levelled)block.getBlockData();
        if (levelled.getLevel() == 0) {
            Levelled levelled2 = (Levelled)Material.WATER.createBlockData();
            levelled2.setLevel(1);
            block2.setBlockData((BlockData)levelled2, false);
            String string2 = ms2.ac(block);
            String[] stringArray = string.split(":");
            ms2.c(block2, string);
            ms2.d(block2, string2);
            afj.tG().a(block2, stringArray[0], stringArray[1]);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(FluidLevelChangeEvent fluidLevelChangeEvent) {
        Block block = fluidLevelChangeEvent.getBlock();
        if (block.getType() != Material.WATER) {
            return;
        }
        ms ms2 = this.zt.a(block.getChunk());
        String string = ms2.ab(block);
        if (string != null) {
            if (block.getBlockData() instanceof Levelled && fluidLevelChangeEvent.getNewData() instanceof Levelled) {
                fluidLevelChangeEvent.setCancelled(true);
            } else if (fluidLevelChangeEvent.getNewData().getMaterial().isAir()) {
                this.n(block);
            }
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void a(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getItem() != null && (playerInteractEvent.getItem().getType() == Material.GLASS_BOTTLE || playerInteractEvent.getItem().getType() == Material.POTION)) {
            ms ms2;
            Block block;
            if (d.g().isCustomItem(playerInteractEvent.getItem())) {
                return;
            }
            if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK && (block = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace())).getType() == Material.WATER && (ms2 = this.zt.b(block)).ab(block) != null) {
                playerInteractEvent.setCancelled(true);
            }
        }
    }

    @mz
    private void a(PlayerItemConsumeEvent playerItemConsumeEvent, qm qm2, ItemStack itemStack) {
        if (!qm2.Ge.bm("liquid_bucket")) {
            return;
        }
        playerItemConsumeEvent.setCancelled(true);
    }

    @mz
    private void f(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        Object object;
        if (playerInteractEvent.useInteractedBlock() == Event.Result.DENY) {
            return;
        }
        if (bbs.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK || playerInteractEvent.getClickedBlock() == null) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace());
        if (!aaf.aJ(block)) {
            return;
        }
        if (!qm2.Ge.bm("liquid_bucket")) {
            return;
        }
        if (!bcc.b(block, playerInteractEvent.getPlayer())) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        kd kd2 = (kd)qm2.Ge.bn("liquid_bucket");
        if (kd2.kU().getNamespacedID().equals(afj.tG().bd(block)) && block.getBlockData() instanceof Levelled && (object = (Levelled)block.getBlockData()).getLevel() == 0) {
            afj.tG().a(block, kd2.kU().getNamespace(), kd2.kU().getId());
            return;
        }
        if (afj.tG().M(kd2.kU().getNamespace(), kd2.kU().getId()) == null) {
            bce.a((CommandSender)playerInteractEvent.getPlayer(), "liquid-not-completely-registered", string -> string.replace("{liquid}", kd2.kU().getNamespacedID()));
            bce.error("Fluid " + kd2.kU().getNamespacedID() + " is not completely registered. Please restart the server.");
            return;
        }
        object = this.zt.b(block);
        if (((ms)object).o(block.getChunk())) {
            for (String string2 : ((ms)object).p(block.getChunk())) {
                if (kd2.kU().getNamespacedID().equals(string2)) continue;
                bce.f((CommandSender)playerInteractEvent.getPlayer(), Main.PQ.ir("liquid-bucket-place-near-error"));
                return;
            }
        }
        for (String string2 : bdf.c(block.getLocation(), 1)) {
            ms ms2 = this.zt.a((Chunk)string2);
            for (String string3 : ms2.p((Chunk)string2)) {
                if (kd2.kU().getNamespacedID().equals(string3)) continue;
                bce.f((CommandSender)playerInteractEvent.getPlayer(), Main.PQ.ir("liquid-bucket-place-near-error"));
                return;
            }
        }
        ((ms)object).c(block, kd2.kU().getNamespacedID());
        ((ms)object).d(block, afj.a(block, Biome.PLAINS).getKey().toString());
        if (!kd2.kU().getNamespacedID().equals(afj.tG().bd(block))) {
            afj.tG().a(block, kd2.kU().getNamespace(), kd2.kU().getId());
        }
        bcp.c(() -> block.setType(Material.WATER), 2L);
        if (playerInteractEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
            bbs.aj(playerInteractEvent.getItem());
            playerInteractEvent.getPlayer().getInventory().addItem(new ItemStack[]{new ItemStack(Material.BUCKET)});
        }
    }

    private String n(Block block) {
        ms ms2 = this.zt.a(block.getChunk());
        if (!ms2.T(block)) {
            return null;
        }
        String string = ms2.ac(block);
        if (string == null) {
            return null;
        }
        String string2 = ms2.ab(block);
        String[] stringArray = string.split(":");
        String[] stringArray2 = string2.split(":");
        afj.tG().a(block.getLocation(), stringArray[0], stringArray[1], false);
        ms2.ag(block);
        this.a(block, stringArray2);
        return string2;
    }

    private void a(Block block, String[] stringArray) {
        for (BlockFace blockFace : bdf.aBu) {
            String string;
            Block block2 = block.getRelative(blockFace);
            if (block2.getType() != Material.WATER || (string = this.zt.a(block2.getChunk()).ab(block2)) == null) continue;
            afj.tG().a(block2, stringArray[0], stringArray[1]);
            break;
        }
    }
}
