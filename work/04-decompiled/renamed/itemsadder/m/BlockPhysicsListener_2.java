package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockHolder;
import itemsadder.m.BlockHolder_2;
import itemsadder.m.BlockPlaceListener_2;
import itemsadder.m.BlockRegistry;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ColorBridge;
import itemsadder.m.InstrumentByteStringData;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.MaterialBlockDataHolder;
import itemsadder.m.PlacedEnum;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PluginContract;
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

public final class BlockPhysicsListener_2
implements PluginContract {
    public void register(Plugin plugin) {
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void d(BlockPhysicsEvent blockPhysicsEvent) {
        if (blockPhysicsEvent.getBlock().getType() != Material.NOTE_BLOCK) {
            return;
        }
        if (BlockPhysicsListener_2.H(blockPhysicsEvent.getBlock())) {
            return;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(blockPhysicsEvent.getBlock());
        if (blockBridge_9.isCustomBlock(blockPhysicsEvent.getBlock())) {
            blockPhysicsEvent.setCancelled(true);
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(blockPhysicsEvent.getBlock()));
            if (locationBridgeBuilder_2 != null) {
                BukkitTaskBridge.i(() -> locationBridgeBuilder_2.ar(blockPhysicsEvent.getBlock()));
                BlockPhysicsListener_2.D(blockPhysicsEvent.getBlock());
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
        InstrumentByteStringData instrumentByteStringData;
        byte by;
        if (BlockPhysicsListener_2.H(notePlayEvent.getBlock())) {
            return;
        }
        if (ItemStackRegistry.isCustomBlock(notePlayEvent.getBlock())) {
            notePlayEvent.setCancelled(true);
            return;
        }
        notePlayEvent.setCancelled(true);
        boolean bl = false;
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(notePlayEvent.getBlock());
        if (blockBridge_9.T(notePlayEvent.getBlock()) && (by = blockBridge_9.b(notePlayEvent.getBlock(), (byte)0)) != -1) {
            BlockRegistry.tg().c(notePlayEvent.getBlock(), by);
            notePlayEvent.setInstrument(BlockRegistry.c(by));
            bl = true;
        }
        if (!bl && (instrumentByteStringData = BlockRegistry.tg().aS(notePlayEvent.getBlock())) != null) {
            by = instrumentByteStringData.Vp.getType();
            notePlayEvent.setInstrument(BlockRegistry.c(by));
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
        boolean bl = ItemStackRegistry.g().a(block.getChunk()).isCustomBlock(block);
        if (playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            BlockPhysicsListener_2.D(block);
            if (!bl && ItemStackBridge_2.W(block.getRelative(BlockFace.UP).getType())) {
                BlockRegistry.tg().aS(block);
            }
            return;
        }
        if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                return;
            }
            if (BlockPhysicsListener_2.H(block)) {
                return;
            }
            if (playerInteractEvent.getPlayer().isSneaking() || bl) {
                if (ListenerBridge.Ek()) {
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
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (block.getType() == Material.NOTE_BLOCK) {
            if (blockBreakEvent.getPlayer().getGameMode() == GameMode.SURVIVAL && ItemStackRegistry.isCustomBlock(block)) {
                return;
            }
            ItemStackRegistry.g().b(block).ag(block);
            return;
        }
        @Nullable Block block2 = block.getRelative(BlockFace.UP);
        if (block2.getType() != Material.NOTE_BLOCK) {
            block2 = block.getRelative(BlockFace.DOWN);
        }
        if (block2.getType() != Material.NOTE_BLOCK) {
            return;
        }
        if (ItemStackRegistry.isCustomBlock(block2) && !ItemStackRegistry.b(block2.getLocation())) {
            this.G(block2);
            ItemStackRegistry.g().aT.B(blockBreakEvent.getBlock().getLocation());
        } else {
            Block block3 = block2;
            BukkitTaskBridge.c(() -> {
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
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        Block block2 = blockPlaceEvent.getBlockPlaced();
        Block block3 = block2.getRelative(BlockFace.UP);
        if (block3.getType() == Material.NOTE_BLOCK) {
            ItemStackRegistry.g().aT.B(block2.getLocation());
        }
        if (BlockPlaceListener_2.aI(blockPlaceEvent.getPlayer())) {
            return;
        }
        boolean bl2 = bl = block2.getType() == Material.NOTE_BLOCK;
        if (bl) {
            if (ItemStackRegistry.isCustomBlock(block2)) {
                BukkitTaskBridge.c(() -> this.G(block2), 1L);
                return;
            }
            if (BlockPhysicsListener_2.a(block2, blockPlaceEvent.getItemInHand(), (NoteBlock)block2.getBlockData())) {
                BukkitTaskBridge.c(() -> this.E(block2), 1L);
            } else {
                BlockPhysicsListener_2.I(block2);
                return;
            }
        }
        if (block3.getType() == Material.NOTE_BLOCK) {
            if (ItemStackRegistry.isCustomBlock(block3)) {
                BukkitTaskBridge.c(() -> this.G(block3), 1L);
            } else {
                BukkitTaskBridge.c(() -> this.E(block3), 1L);
            }
        }
        if ((block = block2.getRelative(BlockFace.DOWN)).getType() == Material.NOTE_BLOCK) {
            if (ItemStackRegistry.isCustomBlock(block)) {
                BukkitTaskBridge.c(() -> this.G(block), 1L);
            } else {
                BukkitTaskBridge.c(() -> this.E(block), 1L);
            }
        }
    }

    private boolean a(Block block, ItemStack itemStack, PlayerInteractEvent playerInteractEvent, EquipmentSlot equipmentSlot) {
        PersistentDataContainer persistentDataContainer;
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return false;
        }
        Block block2 = block.getRelative(playerInteractEvent.getBlockFace());
        if (LocationBridge_2.e(playerInteractEvent.getPlayer(), block2) || playerInteractEvent.useItemInHand() == Event.Result.DENY) {
            return false;
        }
        if (Main.PG && itemStack.hasItemMeta() && (persistentDataContainer = itemStack.getItemMeta().getPersistentDataContainer()).has(new NamespacedKey("slimefun", "slimefun_item"))) {
            return false;
        }
        if (ItemStackRegistry.g().b(itemStack)) {
            playerInteractEvent.setCancelled(true);
            if (BlockRegistry.aJ(block2) && ItemStackRegistry.g().aE.a(playerInteractEvent.getPlayer(), itemStack, block2, block, playerInteractEvent.getBlockFace(), false) == PlacedEnum.PLACED) {
                if (playerInteractEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
                    itemStack.setAmount(itemStack.getAmount() - 1);
                }
                if (playerInteractEvent.getPlayer().isSneaking() && block.getType() == Material.NOTE_BLOCK) {
                    PlayerHolder_4.a(playerInteractEvent.getPlayer(), equipmentSlot);
                }
                LocationBridge_2.a(block2, playerInteractEvent.getPlayer(), block, itemStack);
                return true;
            }
            return true;
        }
        return PlayerHolder_4.uW().a(playerInteractEvent.getPlayer(), equipmentSlot, playerInteractEvent.getClickedBlock(), ColorBridge.r(playerInteractEvent), playerInteractEvent.getBlockFace());
    }

    public void h(PlayerInteractEvent playerInteractEvent) {
        Block block;
        if (playerInteractEvent.getHand() != EquipmentSlot.OFF_HAND && (block = playerInteractEvent.getClickedBlock()).getType() == Material.NOTE_BLOCK) {
            playerInteractEvent.setCancelled(true);
            this.a(block, playerInteractEvent.getAction(), true);
            BlockPhysicsListener_2.D(block);
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void f(BlockPlaceEvent blockPlaceEvent) {
        BlockBridge_9 blockBridge_9;
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        if (BlockPlaceListener_2.aI(blockPlaceEvent.getPlayer())) {
            return;
        }
        Block block = blockPlaceEvent.getBlock();
        if (block.getType() == Material.NOTE_BLOCK && (blockBridge_9 = ItemStackRegistry.g().b(block)).isCustomBlock(block)) {
            blockPlaceEvent.setCancelled(true);
        }
    }

    public static void D(Block block) {
        for (BlockFace blockFace : LocationBridge_4.aBw) {
            Observer observer;
            Block block2 = block.getRelative(blockFace);
            if (block2.getType() != Material.OBSERVER || !(observer = (Observer)block2.getBlockData()).getFacing().getOppositeFace().equals((Object)blockFace)) continue;
            BlockHolder.tl().k(block2, true);
            BlockHolder.tl().aY(block2);
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
        BlockHolder_2.tN().a(block, (BlockData)noteBlock, true);
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (!blockBridge_9.T(block) && (instrument = BlockRegistry.tg().aT(block)) != null) {
            blockBridge_9.a(block, (int)instrument.getType());
        }
        if (bl) {
            ListenerBridge.b((Event)new NotePlayEvent(block, noteBlock.getInstrument(), noteBlock.getNote()));
        }
    }

    private void E(Block block) {
        Instrument instrument = BlockRegistry.tg().aT(block);
        this.a(block, instrument.getType());
    }

    private void a(Block block, byte by) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        blockBridge_9.a(block, (int)by);
        this.F(block);
    }

    private void F(Block block) {
        NoteBlock noteBlock = (NoteBlock)block.getBlockData();
        noteBlock.setInstrument(Instrument.PIANO);
        block.setBlockData((BlockData)noteBlock, false);
    }

    private void G(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
        if (locationBridgeBuilder_2 == null) {
            return;
        }
        locationBridgeBuilder_2.ar(block);
    }

    private static boolean a(Block block, ItemStack itemStack, NoteBlock noteBlock) {
        if (itemStack.getType() == Material.NOTE_BLOCK) {
            return true;
        }
        return noteBlock.getInstrument() == MaterialBlockDataHolder.aA(block.getRelative(BlockFace.DOWN)) && noteBlock.getNote().getId() == 0;
    }

    private static boolean H(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        return blockBridge_9.af(block);
    }

    private static void I(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        blockBridge_9.b(block, true);
    }
}
