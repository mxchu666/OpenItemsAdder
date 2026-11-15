package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomFurniture;
import dev.lone.itemsadder.api.Events.CustomBlockBreakEvent;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import itemsadder.m.BlockBreakListener;
import itemsadder.m.BlockBreakListener_2;
import itemsadder.m.BlockBridge_13;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockDataNoteBlockHolder;
import itemsadder.m.BlockHolder;
import itemsadder.m.BlockHolder_2;
import itemsadder.m.BlockPhysicsListener;
import itemsadder.m.BlockPhysicsListener_2;
import itemsadder.m.BlockPlaceListener_2;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityHolder;
import itemsadder.m.EnumWrappersHolder;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_13;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBlockDataHolder;
import itemsadder.m.NamespacedKeyEntityTypeHolder;
import itemsadder.m.PickItemPacketListener;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PlayerInteractListener_4;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.PluginContract;
import itemsadder.m.RealEnum;
import itemsadder.m.VersionHelper_3;
import itemsadder.m.WorldBridge_14;
import itemsadder.m.WrappedBlockDataHelper;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;
import java.util.WeakHashMap;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public final class BlockIgniteListener
implements PluginContract {
    private static BlockIgniteListener Bm;
    private static final BlockFace[] Bn;
    @Nullable
    private BlockBreakListener Bo;
    @Nullable
    private BlockBreakListener_2 Bp;
    @Nullable
    private BlockPhysicsListener_2 Bq;
    @Nullable
    private PlayerInteractListener_4 Br;
    @Nullable
    private BlockPhysicsListener Bs;
    WeakHashMap Bt = new WeakHashMap();

    BlockIgniteListener() {
        Bm = this;
        this.register();
    }

    private void register() {
        if (!(MaterialBarColorHolder.cH || MaterialBarColorHolder.cG || MaterialBarColorHolder.cJ || MaterialBarColorHolder.cK)) {
            return;
        }
        if (MaterialBarColorHolder.cH) {
            this.Bo = new BlockBreakListener();
            this.Bo.register((Plugin)Main.rS());
        }
        if (MaterialBarColorHolder.cG) {
            this.Bp = new BlockBreakListener_2();
            this.Bp.register((Plugin)Main.rS());
        }
        if (MaterialBarColorHolder.cI) {
            this.Bq = new BlockPhysicsListener_2();
            this.Bq.register((Plugin)Main.rS());
        }
        if (MaterialBarColorHolder.cJ) {
            this.Br = new PlayerInteractListener_4();
            this.Br.register((Plugin)Main.rS());
        }
        if (MaterialBarColorHolder.cK) {
            this.Bs = new BlockPhysicsListener();
            this.Bs.register((Plugin)Main.rS());
        }
        ListenerBridge.a(this, (Plugin)Main.rS());
        if (Version.isAtLeast((Version)Version.v1_21_4) && VersionHelper_3.b(PacketType.Play.Client.class, "PICK_ITEM_FROM_BLOCK") != null) {
            ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)new PickItemPacketListener(this, PacketAdapter.params((Plugin)Main.rS(), (PacketType[])new PacketType[]{PacketType.Play.Client.PICK_ITEM_FROM_BLOCK, PacketType.Play.Client.PICK_ITEM}).optionSync()));
        }
    }

    public static BlockIgniteListener lH() {
        return new BlockIgniteListener();
    }

    public static BlockIgniteListener lI() {
        return Bm;
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        PluginContract.a(this.Bo);
        PluginContract.a(this.Bp);
        PluginContract.a(this.Bq);
        PluginContract.a(this.Br);
        PluginContract.a(this.Bs);
    }

    public static boolean g(Material material) {
        return switch (material) {
            case Material.BROWN_MUSHROOM_BLOCK, Material.RED_MUSHROOM_BLOCK, Material.MUSHROOM_STEM, Material.CHORUS_PLANT -> true;
            default -> false;
        };
    }

    public boolean a(Block block, boolean bl, boolean bl2, boolean bl3) {
        return this.a(block, bl, bl2, bl3, false);
    }

    public boolean a(Block block, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        BlockBridge_9 blockBridge_9;
        Material material = block.getType();
        if (bl2 && !BlockIgniteListener.g(material) && material != Material.AIR && material != Material.CAVE_AIR) {
            return false;
        }
        if (!bl) {
            blockBridge_9 = ItemStackRegistry.g().b(block);
            if (blockBridge_9 == null) {
                return false;
            }
            if (blockBridge_9.isCustomBlock(block)) {
                if (bl3) {
                    LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
                    if (locationBridgeBuilder_2 != null) {
                        locationBridgeBuilder_2.FD.ay(block);
                    }
                } else {
                    BlockHolder_2.a(block, block.getBlockData());
                }
                return true;
            }
            if (bl4) {
                return false;
            }
        }
        if (bl3) {
            if (material != Material.NOTE_BLOCK) {
                BlockHolder_2.tN().be(block);
            } else {
                blockBridge_9 = (NoteBlock)block.getBlockData();
                blockBridge_9.setInstrument(Instrument.PIANO);
                BlockHolder_2.tN().setBlockData(block, (BlockData)blockBridge_9);
            }
        }
        if (material != Material.NOTE_BLOCK) {
            BlockHolder.a(BlockDataNoteBlockHolder.f(material), block.getLocation());
        }
        return false;
    }

    public static void w(Block block) {
        BlockIgniteListener.a(block, null);
    }

    private static void a(Block block, @Nullable WrappedBlockDataHelper wrappedBlockDataHelper) {
        NoteBlock noteBlock;
        Material material = block.getType();
        if (material != Material.NOTE_BLOCK) {
            BlockHolder_2.tN().be(block);
        } else {
            noteBlock = (NoteBlock)block.getBlockData();
            noteBlock.setInstrument(Instrument.PIANO);
            BlockHolder_2.tN().setBlockData(block, (BlockData)noteBlock);
        }
        noteBlock = BlockDataNoteBlockHolder.f(material);
        if (noteBlock == null) {
            return;
        }
        if (wrappedBlockDataHelper == null) {
            BlockHolder.a((BlockData)noteBlock, block.getLocation());
        } else {
            wrappedBlockDataHelper.a(block.getX(), block.getY(), block.getZ(), WrappedBlockData.createData((Object)noteBlock));
        }
    }

    public void B(Location location) {
        List list = EnumWrappersHolder.vC().aoJ.aa(location);
        if (list.isEmpty()) {
            return;
        }
        Collection collection = LocationBridge_2.ad(location);
        WrappedBlockDataHelper wrappedBlockDataHelper = new WrappedBlockDataHelper(collection);
        for (Location location2 : list) {
            WrappedBlockData wrappedBlockData = WrappedBlockData.createData((Object)location2.getBlock().getBlockData());
            wrappedBlockDataHelper.a(location2.toVector(), wrappedBlockData);
        }
        wrappedBlockDataHelper.uZ();
    }

    public void a(Location location, boolean bl) {
        for (double d = location.getX() - 5.0; d < location.getX() + 5.0; d += 1.0) {
            for (double d2 = location.getY() - 5.0; d2 < location.getY() + 5.0; d2 += 1.0) {
                for (double d3 = location.getZ() - 5.0; d3 < location.getZ() + 5.0; d3 += 1.0) {
                    this.a(location.getWorld().getBlockAt((int)d, (int)d2, (int)d3), false, true, bl);
                }
            }
        }
    }

    public void C(Location location) {
        this.a(location, false);
    }

    boolean x(Block block) {
        return this.a(block, false);
    }

    boolean a(Block block, boolean bl) {
        boolean bl2 = false;
        for (BlockFace blockFace : Bn) {
            if (!this.a(block.getRelative(blockFace), false, true, true, bl)) continue;
            bl2 = true;
        }
        return bl2;
    }

    boolean y(Block block) {
        for (BlockFace blockFace : Bn) {
            if (!LocationBridgeBuilder_2.j(block.getRelative(blockFace).getType())) continue;
            return true;
        }
        return false;
    }

    boolean z(Block block) {
        for (BlockFace blockFace : Bn) {
            Block block2 = block.getRelative(blockFace);
            if (!LocationBridgeBuilder_2.av(block2) || !ItemStackRegistry.g().b(block2).isCustomBlock(block2)) continue;
            return true;
        }
        return false;
    }

    private static boolean a(BlockPhysicsEvent blockPhysicsEvent, Material material) {
        Material material2 = blockPhysicsEvent.getBlock().getType();
        Material material3 = blockPhysicsEvent.getSourceBlock().getType();
        return BlockIgniteListener.a(blockPhysicsEvent.getChangedType(), material2, material3, material);
    }

    private static boolean a(Material material, Material material2, Material material3, Material material4) {
        if (material4 != null && (material == material4 || material2 == material4 || material3 == material4)) {
            return false;
        }
        if (material == Material.WATER || material2 == Material.WATER || material3 == Material.WATER) {
            return true;
        }
        return material == Material.LAVA || material2 == Material.LAVA || material3 == Material.LAVA;
    }

    private void b(BlockPhysicsEvent blockPhysicsEvent) {
        if (!MaterialBarColorHolder.cH) {
            return;
        }
        Block block = blockPhysicsEvent.getBlock();
        if (WorldBridge_14.q(block.getX() >> 4, block.getZ() >> 4)) {
            blockPhysicsEvent.setCancelled(true);
            return;
        }
        Material material = block.getType();
        Material material2 = blockPhysicsEvent.getSourceBlock().getType();
        if (blockPhysicsEvent.getChangedType() == Material.CHORUS_PLANT || material == Material.CHORUS_PLANT || material2 == Material.CHORUS_PLANT) {
            blockPhysicsEvent.setCancelled(true);
            this.x(blockPhysicsEvent.getSourceBlock());
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            if (blockBridge_9.T(block)) {
                LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
                if (blockPhysicsEvent.getSourceBlock().getType() == Material.WATER) {
                    blockBridge_9.c(block, true);
                    blockPhysicsEvent.getSourceBlock().setType(Material.AIR, false);
                    LocationBridge_4.b(block.getLocation(), locationBridgeBuilder_2);
                    BukkitTaskBridge.c(() -> block.setType(Material.AIR, false), 2L);
                    return;
                }
            }
            return;
        }
        if (BlockIgniteListener.b(blockPhysicsEvent.getSourceBlock(), material2)) {
            blockPhysicsEvent.setCancelled(true);
        }
    }

    public static boolean b(Block block, Material material) {
        if (!BlockIgniteListener.g(material) && material != Material.AIR && material != Material.CAVE_AIR) {
            return false;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (blockBridge_9 == null) {
            return false;
        }
        if (blockBridge_9.isCustomBlock(block)) {
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
            if (locationBridgeBuilder_2 != null) {
                locationBridgeBuilder_2.FD.ay(block);
            }
            return true;
        }
        return false;
    }

    private boolean c(BlockPhysicsEvent blockPhysicsEvent) {
        if (!MaterialBarColorHolder.cG) {
            return false;
        }
        if (blockPhysicsEvent.getChangedType() == null || blockPhysicsEvent.getSourceBlock() == null) {
            return false;
        }
        if (!BlockBreakListener_2.h(blockPhysicsEvent.getChangedType())) {
            return false;
        }
        if (BlockIgniteListener.a(blockPhysicsEvent, null)) {
            return false;
        }
        blockPhysicsEvent.setCancelled(true);
        this.a(blockPhysicsEvent.getBlock(), false, false, true);
        return true;
    }

    public static void a(ChunkLoadEvent chunkLoadEvent, BlockBridge_9 blockBridge_9) {
        Chunk chunk = chunkLoadEvent.getChunk();
        if (BlockIgniteListener.f(MaterialBarColorHolder.ep, chunkLoadEvent.isNewChunk())) {
            BlockIgniteListener.b(chunk, blockBridge_9);
        }
        if (MaterialBarColorHolder.en) {
            if (MaterialBarColorHolder.eo && !chunkLoadEvent.isNewChunk()) {
                return;
            }
            List list = EnumWrappersHolder.vC().aoJ.A(chunk);
            if (list.isEmpty()) {
                return;
            }
            int n = 0;
            for (Location location : list) {
                if (blockBridge_9.G(location)) continue;
                Block block = location.getBlock();
                LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.a(block.getBlockData());
                if (locationBridgeBuilder_2 != null) {
                    blockBridge_9.e(block, locationBridgeBuilder_2.getNamespacedID());
                    if (!MaterialBarColorHolder.dB) continue;
                    CommandSenderBridge_5.log("Converted vanilla block " + block.getBlockData().getAsString(true) + " to " + locationBridgeBuilder_2.Gh + " | " + LocationBridge_2.ae(block.getLocation()));
                    ++n;
                    continue;
                }
                if (!MaterialBarColorHolder.dB) continue;
                CommandSenderBridge_5.log("No custom block found for vanilla block " + LocationBridge_2.ae(block.getLocation()));
            }
            if (MaterialBarColorHolder.dB && n > 0) {
                CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "Converted vanilla blocks: " + n);
            }
        } else if (MaterialBarColorHolder.er) {
            if (MaterialBarColorHolder.eq && !chunkLoadEvent.isNewChunk()) {
                return;
            }
            if (blockBridge_9.BT.t(chunk)) {
                return;
            }
            List list = EnumWrappersHolder.vC().aoJ.A(chunk);
            if (list.isEmpty()) {
                return;
            }
            WrappedBlockDataHelper wrappedBlockDataHelper = null;
            for (Location location : list) {
                if (blockBridge_9.G(location)) continue;
                Block block = location.getBlock();
                if (wrappedBlockDataHelper == null) {
                    Collection collection = VersionHelper_3.sZ() ? chunk.getPlayersSeeingChunk() : LocationBridge_2.ad(location);
                    wrappedBlockDataHelper = new WrappedBlockDataHelper(collection);
                }
                BlockIgniteListener.a(block, wrappedBlockDataHelper);
                if (!MaterialBarColorHolder.dC) continue;
                CommandSenderBridge_5.log("Fixed glitched block at " + LocationBridge_2.ae(block.getLocation()));
            }
            if (wrappedBlockDataHelper != null) {
                wrappedBlockDataHelper.uZ();
                blockBridge_9.BT.s(chunk);
            }
        }
    }

    static boolean f(boolean bl, boolean bl2) {
        return bl && !bl2;
    }

    private static void b(Chunk chunk, BlockBridge_9 blockBridge_9) {
        WrappedBlockDataHelper[] wrappedBlockDataHelperArray = new WrappedBlockDataHelper[1];
        blockBridge_9.a(chunk, (T string, U location) -> {
            boolean bl;
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h((String)string);
            if (locationBridgeBuilder_2 == null) {
                return;
            }
            MaterialBlockDataHolder materialBlockDataHolder = locationBridgeBuilder_2.FD;
            Block block = location.getBlock();
            BlockData blockData = materialBlockDataHolder.pb();
            boolean bl2 = blockData == null ? block.getType() != materialBlockDataHolder.pc() : (bl = !blockData.equals((Object)block.getBlockData()));
            if (!bl) {
                return;
            }
            if (blockData == null) {
                materialBlockDataHolder.ay(block);
                return;
            }
            materialBlockDataHolder.i(block, false);
            if (wrappedBlockDataHelperArray[0] == null) {
                Collection collection = VersionHelper_3.sZ() ? chunk.getPlayersSeeingChunk() : LocationBridge_2.ad(location);
                wrappedBlockDataHelperArray[0] = new WrappedBlockDataHelper(collection);
            }
            wrappedBlockDataHelperArray[0].a(block.getX(), block.getY(), block.getZ(), WrappedBlockData.createData((Object)blockData));
        });
        if (wrappedBlockDataHelperArray[0] != null) {
            wrappedBlockDataHelperArray[0].uZ();
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockIgniteEvent blockIgniteEvent) {
        if (blockIgniteEvent.getCause() == BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL) {
            return;
        }
        Block block = blockIgniteEvent.getBlock().getRelative(BlockFace.DOWN);
        if (LocationBridgeBuilder_2.av(block) && ItemStackRegistry.isCustomBlock(block)) {
            blockIgniteEvent.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void d(BlockPhysicsEvent blockPhysicsEvent) {
        if (!this.c(blockPhysicsEvent)) {
            this.b(blockPhysicsEvent);
        }
    }

    @EventHandler
    private void a(CustomBlockBreakEvent customBlockBreakEvent) {
        if (customBlockBreakEvent.isCancelled()) {
            return;
        }
        this.C(customBlockBreakEvent.getBlock().getLocation());
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void c(BlockPlaceEvent blockPlaceEvent) {
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        if (BlockPlaceListener_2.aI(blockPlaceEvent.getPlayer())) {
            return;
        }
        if (!LocationBridgeBuilder_2.j(blockPlaceEvent.getBlockPlaced().getType())) {
            return;
        }
        Material material = blockPlaceEvent.getBlockPlaced().getType();
        if (!MaterialBarColorHolder.cG || !LocationBridgeBuilder_2.h(material) || MaterialBarColorHolder.cI && LocationBridgeBuilder_2.m(material) || MaterialBarColorHolder.cH && LocationBridgeBuilder_2.l(material)) {
            return;
        }
        blockPlaceEvent.setCancelled(true);
        Block block = blockPlaceEvent.getBlockPlaced();
        if (blockPlaceEvent.getBlockPlaced().getType() == Material.CHORUS_PLANT) {
            for (Block block2 : LocationBridge_4.b(blockPlaceEvent.getBlock(), false, true)) {
                BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block2);
                if (!blockBridge_9.isCustomBlock(block2)) continue;
                blockPlaceEvent.setCancelled(true);
                this.C(block2.getLocation());
                return;
            }
        }
        BukkitTaskBridge.c(() -> {
            BlockHolder_2.tN().d(block, material);
            blockPlaceEvent.getBlock().setBlockData(BlockDataNoteBlockHolder.f(material), false);
            if (blockPlaceEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
                ItemStackBridge_2.j(blockPlaceEvent);
            }
        }, 0L);
        if (!this.y(block)) {
            return;
        }
        Location location = block.getLocation();
        if (blockPlaceEvent.getBlockPlaced().getType() != Material.NOTE_BLOCK) {
            this.C(location);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockExplodeEvent blockExplodeEvent) {
        if (BlockHolder.tl().a((Event)blockExplodeEvent)) {
            return;
        }
        this.a(blockExplodeEvent.blockList(), blockExplodeEvent.getBlock().getLocation().add(0.5, 0.5, 0.5), null);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(EntityExplodeEvent entityExplodeEvent) {
        UUID uUID = entityExplodeEvent.getEntity().getUniqueId();
        if (BlockHolder.tl().a((Event)entityExplodeEvent)) {
            this.Bt.remove(uUID);
            return;
        }
        this.a(entityExplodeEvent.blockList(), entityExplodeEvent.getLocation(), uUID);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(ExplosionPrimeEvent explosionPrimeEvent) {
        this.Bt.put(explosionPrimeEvent.getEntity().getUniqueId(), Float.valueOf(explosionPrimeEvent.getRadius()));
    }

    void a(List list, Location location, @Nullable UUID uUID) {
        LocationBridgeBuilder_2 locationBridgeBuilder_2;
        float f;
        float f2 = f = uUID == null ? 1.0f : this.Bt.getOrDefault(uUID, Float.valueOf(1.0f)).floatValue();
        if (uUID != null) {
            this.Bt.remove(uUID);
        }
        LongOpenHashSet longOpenHashSet = null;
        IdentityHashMap<Block, LocationBridgeBuilder_2> identityHashMap = null;
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Block block = (Block)listIterator.next();
            locationBridgeBuilder_2 = this.d(block);
            if (locationBridgeBuilder_2 == null) continue;
            if (locationBridgeBuilder_2.FI) {
                listIterator.remove();
                locationBridgeBuilder_2.ar(block);
                if (longOpenHashSet == null) {
                    longOpenHashSet = new LongOpenHashSet();
                }
                longOpenHashSet.add(BlockIgniteListener.d(block.getX(), block.getY(), block.getZ()));
                continue;
            }
            if (locationBridgeBuilder_2.mJ() > 0.0f) {
                float f3 = f * (0.7f + ColorBridge.Bl.nextFloat() * 0.6f);
                if ((f3 -= (locationBridgeBuilder_2.mJ() + 0.3f) * 0.3f) <= 0.0f) {
                    listIterator.remove();
                    locationBridgeBuilder_2.ar(block);
                    if (longOpenHashSet == null) {
                        longOpenHashSet = new LongOpenHashSet();
                    }
                    longOpenHashSet.add(BlockIgniteListener.d(block.getX(), block.getY(), block.getZ()));
                    continue;
                }
            }
            if (identityHashMap == null) {
                identityHashMap = new IdentityHashMap<Block, LocationBridgeBuilder_2>();
            }
            identityHashMap.put(block, locationBridgeBuilder_2);
        }
        if (longOpenHashSet != null) {
            double d = location.getX();
            double d2 = location.getY();
            double d3 = location.getZ();
            listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                Block block = (Block)listIterator.next();
                if (!BlockIgniteListener.a(d, d2, d3, block.getX(), block.getY(), block.getZ(), longOpenHashSet)) continue;
                listIterator.remove();
            }
        }
        if (identityHashMap == null) {
            return;
        }
        listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Block block = (Block)listIterator.next();
            locationBridgeBuilder_2 = (LocationBridgeBuilder_2)identityHashMap.get(block);
            if (locationBridgeBuilder_2 == null) continue;
            LocationBridge_13 locationBridge_13 = locationBridgeBuilder_2.mK();
            if (locationBridge_13 != null && locationBridge_13.as(8)) {
                locationBridge_13.a(locationBridgeBuilder_2, block.getLocation());
                listIterator.remove();
                continue;
            }
            listIterator.remove();
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            blockBridge_9.a(block, true, true);
            List list2 = ItemStackRegistry.g().aq.e(block, locationBridgeBuilder_2);
            if (list2 != null && !list2.isEmpty()) {
                list2.forEach(itemStackBridgeImpl -> itemStackBridgeImpl.U(block.getLocation()));
                continue;
            }
            if (!locationBridgeBuilder_2.mG()) continue;
            LocationBridge_4.b(block.getLocation(), locationBridgeBuilder_2);
        }
    }

    @Nullable
    private LocationBridgeBuilder_2 d(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (!blockBridge_9.isCustomBlock(block)) {
            return null;
        }
        BlockBridge_13 blockBridge_13 = (BlockBridge_13)ItemStackRegistry.g().e(blockBridge_9.Y(block));
        if (blockBridge_13 == null || blockBridge_13.Hq == RealEnum.FIRE) {
            return null;
        }
        return (LocationBridgeBuilder_2)blockBridge_13;
    }

    static boolean a(double d, double d2, double d3, int n, int n2, int n3, LongOpenHashSet longOpenHashSet) {
        double d4;
        double d5;
        double d6;
        double d7;
        int n4;
        int n5;
        int n6 = Location.locToBlock((double)d);
        int n7 = Location.locToBlock((double)d2);
        int n8 = Location.locToBlock((double)d3);
        if (n6 == n && n7 == n2 && n8 == n3) {
            return false;
        }
        if (longOpenHashSet.contains(BlockIgniteListener.d(n6, n7, n8))) {
            return true;
        }
        double d8 = (double)n + 0.5 - d;
        double d9 = (double)n2 + 0.5 - d2;
        double d10 = (double)n3 + 0.5 - d3;
        int n9 = d8 > 0.0 ? 1 : (n5 = d8 < 0.0 ? -1 : 0);
        int n10 = d9 > 0.0 ? 1 : (n4 = d9 < 0.0 ? -1 : 0);
        int n11 = d10 > 0.0 ? 1 : (d10 < 0.0 ? -1 : 0);
        double d11 = n5 == 0 ? Double.POSITIVE_INFINITY : 1.0 / Math.abs(d8);
        double d12 = n4 == 0 ? Double.POSITIVE_INFINITY : 1.0 / Math.abs(d9);
        double d13 = d7 = n11 == 0 ? Double.POSITIVE_INFINITY : 1.0 / Math.abs(d10);
        double d14 = n5 > 0 ? ((double)(n6 + 1) - d) / d8 : (d6 = n5 < 0 ? (d - (double)n6) / -d8 : Double.POSITIVE_INFINITY);
        double d15 = n4 > 0 ? ((double)(n7 + 1) - d2) / d9 : (d5 = n4 < 0 ? (d2 - (double)n7) / -d9 : Double.POSITIVE_INFINITY);
        double d16 = n11 > 0 ? ((double)(n8 + 1) - d3) / d10 : (d4 = n11 < 0 ? (d3 - (double)n8) / -d10 : Double.POSITIVE_INFINITY);
        do {
            boolean bl;
            double d17;
            if ((d17 = Math.min(d6, Math.min(d5, d4))) > 1.0) {
                return false;
            }
            boolean bl2 = d6 == d17;
            boolean bl3 = d5 == d17;
            boolean bl4 = bl = d4 == d17;
            if (bl2) {
                n6 += n5;
                d6 += d11;
            }
            if (bl3) {
                n7 += n4;
                d5 += d12;
            }
            if (bl) {
                n8 += n11;
                d4 += d7;
            }
            if (n6 != n || n7 != n2 || n8 != n3) continue;
            return false;
        } while (!longOpenHashSet.contains(BlockIgniteListener.d(n6, n7, n8)));
        return true;
    }

    static long d(int n, int n2, int n3) {
        return (long)(n & 0x3FFFFFF) << 38 | (long)(n3 & 0x3FFFFFF) << 12 | (long)n2 & 0xFFFL;
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void b(BlockPistonExtendEvent blockPistonExtendEvent) {
        for (Block block : blockPistonExtendEvent.getBlocks()) {
            BlockBridge_9 blockBridge_9;
            if (!LocationBridgeBuilder_2.av(block) || !(blockBridge_9 = ItemStackRegistry.g().b(block)).isCustomBlock(block)) continue;
            blockPistonExtendEvent.setCancelled(true);
            LocationBridge_4.b(blockPistonExtendEvent.getBlock().getLocation(), new ItemStack(blockPistonExtendEvent.getBlock().getType()));
            blockPistonExtendEvent.getBlock().setType(Material.AIR);
            return;
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockPistonRetractEvent blockPistonRetractEvent) {
        for (Block block : blockPistonRetractEvent.getBlocks()) {
            BlockBridge_9 blockBridge_9;
            if (!LocationBridgeBuilder_2.av(block) || !(blockBridge_9 = ItemStackRegistry.g().b(block)).isCustomBlock(block)) continue;
            blockPistonRetractEvent.setCancelled(true);
            LocationBridge_4.b(blockPistonRetractEvent.getBlock().getLocation(), new ItemStack(blockPistonRetractEvent.getBlock().getType()));
            blockPistonRetractEvent.getBlock().setType(Material.AIR);
            return;
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void d(BlockPlaceEvent blockPlaceEvent) {
        if (ListenerBridge.k(blockPlaceEvent)) {
            return;
        }
        if (!blockPlaceEvent.getBlockPlaced().getType().toString().contains("REDSTONE")) {
            return;
        }
        Block block = blockPlaceEvent.getBlockPlaced();
        if (!this.y(block)) {
            return;
        }
        BukkitTaskBridge.c(() -> this.C(block.getLocation()), 5L);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void e(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        if (!blockBreakEvent.getBlock().getType().toString().contains("REDSTONE")) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (!this.y(block)) {
            return;
        }
        BukkitTaskBridge.c(() -> this.a(block.getLocation(), true), 20L);
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void a(InventoryCreativeEvent inventoryCreativeEvent) {
        if (inventoryCreativeEvent.getWhoClicked().getGameMode() != GameMode.CREATIVE) {
            return;
        }
        if (!(inventoryCreativeEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        ItemStack itemStack = inventoryCreativeEvent.getCursor();
        if (inventoryCreativeEvent.getSlotType() == InventoryType.SlotType.QUICKBAR && inventoryCreativeEvent.getClick() == ClickType.CREATIVE && inventoryCreativeEvent.getAction() == InventoryAction.PLACE_ALL) {
            NamespacedKeyEntityTypeHolder namespacedKeyEntityTypeHolder;
            ItemStackBuilder_4 itemStackBuilder_4;
            CustomFurniture customFurniture;
            Entity entity;
            Player player = (Player)inventoryCreativeEvent.getWhoClicked();
            if (PlayerJoinListener_9.bN.p(player)) {
                return;
            }
            if (LocationBridgeBuilder_2.k(itemStack.getType())) {
                Block block = PlayerHolder_4.bZ(player);
                BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
                if (blockBridge_9.isCustomBlock(block)) {
                    LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
                    if (locationBridgeBuilder_2 == null) {
                        return;
                    }
                    if (locationBridgeBuilder_2.FD != null && !locationBridgeBuilder_2.FD.o(itemStack.getType())) {
                        return;
                    }
                    this.a(inventoryCreativeEvent, locationBridgeBuilder_2);
                }
            } else if ((itemStack.getType() == Material.BARRIER || itemStack.getType() == Material.ARMOR_STAND || EntityHolder.J(itemStack.getType())) && (entity = NamespacedKeyEntityTypeHolder.ao(player)) != null && (customFurniture = CustomFurniture.byAlreadySpawned(entity)) != null && (itemStackBuilder_4 = ItemStackRegistry.g().a(customFurniture.getItemStack())) != null && (namespacedKeyEntityTypeHolder = (NamespacedKeyEntityTypeHolder)itemStackBuilder_4.Ge.bn("furniture")) != null) {
                this.a(inventoryCreativeEvent, itemStackBuilder_4);
            }
        }
    }

    private void a(InventoryCreativeEvent inventoryCreativeEvent, ItemStackBuilder_4 itemStackBuilder_4) {
        int n;
        inventoryCreativeEvent.setCancelled(true);
        inventoryCreativeEvent.setCursor(ItemStackBridge_2.Dc());
        HumanEntity humanEntity = inventoryCreativeEvent.getWhoClicked();
        PlayerInventory playerInventory = humanEntity.getInventory();
        for (n = 0; n <= 8; ++n) {
            if (ItemStackBridge_2.at(playerInventory.getItem(n)) || !LocationBridgeBuilder_2.b(playerInventory.getItem(n), (ItemStack)itemStackBuilder_4)) continue;
            playerInventory.setHeldItemSlot(n);
            playerInventory.setItem(n, (ItemStack)itemStackBuilder_4);
            return;
        }
        if (ItemStackBridge_2.at(playerInventory.getItemInMainHand())) {
            playerInventory.setItemInMainHand((ItemStack)itemStackBuilder_4);
        } else {
            for (n = 0; n <= 8; ++n) {
                if (!ItemStackBridge_2.at(playerInventory.getItem(n))) continue;
                playerInventory.setHeldItemSlot(n);
                playerInventory.setItem(n, (ItemStack)itemStackBuilder_4);
                return;
            }
            playerInventory.setItemInMainHand((ItemStack)itemStackBuilder_4);
        }
    }

    static {
        Bn = new BlockFace[]{BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH, BlockFace.EAST, BlockFace.UP, BlockFace.DOWN};
    }
}
