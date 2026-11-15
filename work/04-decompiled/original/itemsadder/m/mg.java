package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.aaf;
import itemsadder.m.aaj;
import itemsadder.m.abk;
import itemsadder.m.ahd;
import itemsadder.m.ai;
import itemsadder.m.aqp;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.lh;
import itemsadder.m.li;
import itemsadder.m.ms;
import itemsadder.m.ql;
import itemsadder.m.rz;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.block.data.type.Observer;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public final class mg
implements ai {
    public void register(Plugin plugin) {
        bev.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void d(BlockPhysicsEvent blockPhysicsEvent) {
        if (blockPhysicsEvent.getBlock().getType() != Material.NOTE_BLOCK) {
            return;
        }
        if (mg.H(blockPhysicsEvent.getBlock())) {
            return;
        }
        ms ms2 = d.g().b(blockPhysicsEvent.getBlock());
        if (ms2.isCustomBlock(blockPhysicsEvent.getBlock())) {
            blockPhysicsEvent.setCancelled(true);
            ql ql2 = d.g().h(ms2.Y(blockPhysicsEvent.getBlock()));
            if (ql2 != null) {
                bcp.i(() -> ql2.ar(blockPhysicsEvent.getBlock()));
                mg.D(blockPhysicsEvent.getBlock());
            } else {
                NoteBlock noteBlock = (NoteBlock)blockPhysicsEvent.getBlock().getBlockData();
                int n = noteBlock.getNote().getId();
                n = n == 0 ? 24 : (int)((byte)(n - 1));
                noteBlock.setNote(new Note(n));
                blockPhysicsEvent.getBlock().setBlockData((BlockData)noteBlock, false);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(NotePlayEvent notePlayEvent) {
        aaj aaj2;
        byte by;
        if (mg.H(notePlayEvent.getBlock())) {
            return;
        }
        if (d.isCustomBlock(notePlayEvent.getBlock())) {
            notePlayEvent.setCancelled(true);
            return;
        }
        notePlayEvent.setCancelled(true);
        boolean bl = false;
        ms ms2 = d.g().b(notePlayEvent.getBlock());
        if (ms2.T(notePlayEvent.getBlock()) && (by = ms2.b(notePlayEvent.getBlock(), (byte)0)) != -1) {
            aaf.tg().c(notePlayEvent.getBlock(), by);
            notePlayEvent.setInstrument(aaf.c(by));
            bl = true;
        }
        if (!bl && (aaj2 = aaf.tg().aS(notePlayEvent.getBlock())) != null) {
            by = aaj2.Vp.getType();
            notePlayEvent.setInstrument(aaf.c(by));
        }
        this.F(notePlayEvent.getBlock());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(PlayerInteractEvent playerInteractEvent) {
        Block block = playerInteractEvent.getClickedBlock();
        if (block == null || block.getType() != Material.NOTE_BLOCK) {
            return;
        }
        if (playerInteractEvent.useInteractedBlock() == Event.Result.DENY || playerInteractEvent.useItemInHand() == Event.Result.DENY) {
            return;
        }
        boolean bl = d.g().a(block.getChunk()).isCustomBlock(block);
        if (playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            mg.D(block);
            if (!bl && bbs.W(block.getRelative(BlockFace.UP).getType())) {
                aaf.tg().aS(block);
            }
            return;
        }
        if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                return;
            }
            if (mg.H(block)) {
                return;
            }
            if (playerInteractEvent.getPlayer().isSneaking() || bl) {
                if (bev.Ek()) {
                    return;
                }
                if (!this.a(block, playerInteractEvent.getPlayer().getInventory().getItemInMainHand(), playerInteractEvent, EquipmentSlot.HAND)) {
                    this.a(block, playerInteractEvent.getPlayer().getInventory().getItemInOffHand(), playerInteractEvent, EquipmentSlot.OFF_HAND);
                }
            } else {
                this.h(playerInteractEvent);
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (block.getType() == Material.NOTE_BLOCK) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL && d.isCustomBlock(block)) {
                return;
            }
            d.g().b(block).ag(block);
            return;
        }
        @Nullable Block block2 = block.getRelative(BlockFace.UP);
        if (block2.getType() != Material.NOTE_BLOCK) {
            block2 = block.getRelative(BlockFace.DOWN);
        }
        if (block2.getType() != Material.NOTE_BLOCK) {
            return;
        }
        if (d.isCustomBlock(block2) && !d.b(block2.getLocation())) {
            this.G(block2);
            d.g().aT.B(blockBreakEvent.getBlock().getLocation());
        } else {
            Block block3 = block2;
            bcp.c(() -> {
                if (block3.getType() == Material.NOTE_BLOCK) {
                    this.E(block3);
                }
            }, 1L);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void e(BlockPlaceEvent blockPlaceEvent) {
        Block block;
        boolean bl;
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        Block block2 = blockPlaceEvent.getBlockPlaced();
        Block block3 = block2.getRelative(BlockFace.UP);
        if (block3.getType() == Material.NOTE_BLOCK) {
            d.g().aT.B(block2.getLocation());
        }
        if (lh.aI(blockPlaceEvent.getPlayer())) {
            return;
        }
        boolean bl2 = bl = block2.getType() == Material.NOTE_BLOCK;
        if (bl) {
            if (d.isCustomBlock(block2)) {
                bcp.c(() -> this.G(block2), 1L);
                return;
            }
            if (mg.a(block2, blockPlaceEvent.getItemInHand(), (NoteBlock)block2.getBlockData())) {
                bcp.c(() -> this.E(block2), 1L);
            } else {
                mg.I(block2);
                return;
            }
        }
        if (block3.getType() == Material.NOTE_BLOCK) {
            if (d.isCustomBlock(block3)) {
                bcp.c(() -> this.G(block3), 1L);
            } else {
                bcp.c(() -> this.E(block3), 1L);
            }
        }
        if ((block = block2.getRelative(BlockFace.DOWN)).getType() == Material.NOTE_BLOCK) {
            if (d.isCustomBlock(block)) {
                bcp.c(() -> this.G(block), 1L);
            } else {
                bcp.c(() -> this.E(block), 1L);
            }
        }
    }

    private boolean a(Block block, ItemStack itemStack, PlayerInteractEvent playerInteractEvent, EquipmentSlot equipmentSlot) {
        PersistentDataContainer persistentDataContainer;
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return false;
        }
        Block block2 = block.getRelative(playerInteractEvent.getBlockFace());
        if (bcc.e(playerInteractEvent.getPlayer(), block2) || playerInteractEvent.useItemInHand() == Event.Result.DENY) {
            return false;
        }
        if (Main.PG && itemStack.hasItemMeta() && (persistentDataContainer = itemStack.getItemMeta().getPersistentDataContainer()).has(new NamespacedKey("slimefun", "slimefun_item"))) {
            return false;
        }
        if (d.g().b(itemStack)) {
            playerInteractEvent.setCancelled(true);
            if (aaf.aJ(block2) && d.g().aE.a(playerInteractEvent.getPlayer(), itemStack, block2, block, playerInteractEvent.getBlockFace(), false) == li.PLACED) {
                if (playerInteractEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
                    itemStack.setAmount(itemStack.getAmount() - 1);
                }
                if (playerInteractEvent.getPlayer().isSneaking() && block.getType() == Material.NOTE_BLOCK) {
                    aqp.a(playerInteractEvent.getPlayer(), equipmentSlot);
                }
                bcc.a(block2, playerInteractEvent.getPlayer(), block, itemStack);
                return true;
            }
            return true;
        }
        return aqp.uW().a(playerInteractEvent.getPlayer(), equipmentSlot, playerInteractEvent.getClickedBlock(), bcy.r(playerInteractEvent), playerInteractEvent.getBlockFace());
    }

    public void h(PlayerInteractEvent playerInteractEvent) {
        Block block;
        if (playerInteractEvent.getHand() != EquipmentSlot.OFF_HAND && (block = playerInteractEvent.getClickedBlock()).getType() == Material.NOTE_BLOCK) {
            playerInteractEvent.setCancelled(true);
            this.a(block, playerInteractEvent.getAction(), true);
            mg.D(block);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void f(BlockPlaceEvent blockPlaceEvent) {
        ms ms2;
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        if (lh.aI(blockPlaceEvent.getPlayer())) {
            return;
        }
        Block block = blockPlaceEvent.getBlock();
        if (block.getType() == Material.NOTE_BLOCK && (ms2 = d.g().b(block)).isCustomBlock(block)) {
            blockPlaceEvent.setCancelled(true);
        }
    }

    public static void D(Block block) {
        for (BlockFace blockFace : bdf.aBw) {
            Observer observer;
            Block block2 = block.getRelative(blockFace);
            if (block2.getType() != Material.OBSERVER || !(observer = (Observer)block2.getBlockData()).getFacing().getOppositeFace().equals((Object)blockFace)) continue;
            abk.tl().k(block2, true);
            abk.tl().aY(block2);
        }
    }

    private void a(Block block, Action action, boolean bl) {
        Instrument instrument;
        NoteBlock noteBlock = (NoteBlock)block.getBlockData();
        int n = noteBlock.getNote().getId();
        if (action == Action.RIGHT_CLICK_BLOCK) {
            ++n;
        }
        if (n > 24) {
            n = 0;
        }
        noteBlock.setInstrument(Instrument.PIANO);
        noteBlock.setNote(new Note(n));
        ahd.tN().a(block, (BlockData)noteBlock, true);
        ms ms2 = d.g().b(block);
        if (!ms2.T(block) && (instrument = aaf.tg().aT(block)) != null) {
            ms2.a(block, (int)instrument.getType());
        }
        if (bl) {
            bev.b((Event)new NotePlayEvent(block, noteBlock.getInstrument(), noteBlock.getNote()));
        }
    }

    private void E(Block block) {
        Instrument instrument = aaf.tg().aT(block);
        this.a(block, instrument.getType());
    }

    private void a(Block block, byte by) {
        ms ms2 = d.g().b(block);
        ms2.a(block, (int)by);
        this.F(block);
    }

    private void F(Block block) {
        NoteBlock noteBlock = (NoteBlock)block.getBlockData();
        noteBlock.setInstrument(Instrument.PIANO);
        block.setBlockData((BlockData)noteBlock, false);
    }

    private void G(Block block) {
        ms ms2 = d.g().b(block);
        ql ql2 = d.g().h(ms2.Y(block));
        if (ql2 == null) {
            return;
        }
        ql2.ar(block);
    }

    private static boolean a(Block block, ItemStack itemStack, NoteBlock noteBlock) {
        if (itemStack.getType() == Material.NOTE_BLOCK) {
            return true;
        }
        return noteBlock.getInstrument() == rz.aA(block.getRelative(BlockFace.DOWN)) && noteBlock.getNote().getId() == 0;
    }

    private static boolean H(Block block) {
        ms ms2 = d.g().b(block);
        return ms2.af(block);
    }

    private static void I(Block block) {
        ms ms2 = d.g().b(block);
        ms2.b(block, true);
    }
}
