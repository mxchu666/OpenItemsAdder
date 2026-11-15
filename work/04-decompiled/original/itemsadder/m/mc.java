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
import itemsadder.m.abk;
import itemsadder.m.ae;
import itemsadder.m.afz;
import itemsadder.m.ahd;
import itemsadder.m.ai;
import itemsadder.m.aqp;
import itemsadder.m.arg;
import itemsadder.m.axi;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcy;
import itemsadder.m.bdf;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jl;
import itemsadder.m.lh;
import itemsadder.m.ls;
import itemsadder.m.ma;
import itemsadder.m.mb;
import itemsadder.m.md;
import itemsadder.m.mf;
import itemsadder.m.mg;
import itemsadder.m.mh;
import itemsadder.m.ms;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.ra;
import itemsadder.m.rz;
import itemsadder.m.sd;
import itemsadder.m.se;
import itemsadder.m.w;
import itemsadder.m.xd;
import itemsadder.m.zw;
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

public final class mc
implements ai {
    private static mc Bm;
    private static final BlockFace[] Bn;
    @Nullable
    private ma Bo;
    @Nullable
    private mf Bp;
    @Nullable
    private mg Bq;
    @Nullable
    private mh Br;
    @Nullable
    private mb Bs;
    WeakHashMap Bt = new WeakHashMap();

    mc() {
        Bm = this;
        this.register();
    }

    private void register() {
        if (!(ae.cH || ae.cG || ae.cJ || ae.cK)) {
            return;
        }
        if (ae.cH) {
            this.Bo = new ma();
            this.Bo.register((Plugin)Main.rS());
        }
        if (ae.cG) {
            this.Bp = new mf();
            this.Bp.register((Plugin)Main.rS());
        }
        if (ae.cI) {
            this.Bq = new mg();
            this.Bq.register((Plugin)Main.rS());
        }
        if (ae.cJ) {
            this.Br = new mh();
            this.Br.register((Plugin)Main.rS());
        }
        if (ae.cK) {
            this.Bs = new mb();
            this.Bs.register((Plugin)Main.rS());
        }
        bev.a(this, (Plugin)Main.rS());
        if (Version.isAtLeast((Version)Version.v1_21_4) && zw.b(PacketType.Play.Client.class, "PICK_ITEM_FROM_BLOCK") != null) {
            ProtocolLibrary.getProtocolManager().addPacketListener((PacketListener)new md(this, PacketAdapter.params((Plugin)Main.rS(), (PacketType[])new PacketType[]{PacketType.Play.Client.PICK_ITEM_FROM_BLOCK, PacketType.Play.Client.PICK_ITEM}).optionSync()));
        }
    }

    public static mc lH() {
        return new mc();
    }

    public static mc lI() {
        return Bm;
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        ai.a(this.Bo);
        ai.a(this.Bp);
        ai.a(this.Bq);
        ai.a(this.Br);
        ai.a(this.Bs);
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
        ms ms2;
        Material material = block.getType();
        if (bl2 && !mc.g(material) && material != Material.AIR && material != Material.CAVE_AIR) {
            return false;
        }
        if (!bl) {
            ms2 = d.g().b(block);
            if (ms2 == null) {
                return false;
            }
            if (ms2.isCustomBlock(block)) {
                if (bl3) {
                    ql ql2 = d.g().h(ms2.Y(block));
                    if (ql2 != null) {
                        ql2.FD.ay(block);
                    }
                } else {
                    ahd.a(block, block.getBlockData());
                }
                return true;
            }
            if (bl4) {
                return false;
            }
        }
        if (bl3) {
            if (material != Material.NOTE_BLOCK) {
                ahd.tN().be(block);
            } else {
                ms2 = (NoteBlock)block.getBlockData();
                ms2.setInstrument(Instrument.PIANO);
                ahd.tN().setBlockData(block, (BlockData)ms2);
            }
        }
        if (material != Material.NOTE_BLOCK) {
            abk.a(ls.f(material), block.getLocation());
        }
        return false;
    }

    public static void w(Block block) {
        mc.a(block, null);
    }

    private static void a(Block block, @Nullable arg arg2) {
        NoteBlock noteBlock;
        Material material = block.getType();
        if (material != Material.NOTE_BLOCK) {
            ahd.tN().be(block);
        } else {
            noteBlock = (NoteBlock)block.getBlockData();
            noteBlock.setInstrument(Instrument.PIANO);
            ahd.tN().setBlockData(block, (BlockData)noteBlock);
        }
        noteBlock = ls.f(material);
        if (noteBlock == null) {
            return;
        }
        if (arg2 == null) {
            abk.a((BlockData)noteBlock, block.getLocation());
        } else {
            arg2.a(block.getX(), block.getY(), block.getZ(), WrappedBlockData.createData((Object)noteBlock));
        }
    }

    public void B(Location location) {
        List list = axi.vC().aoJ.aa(location);
        if (list.isEmpty()) {
            return;
        }
        Collection collection = bcc.ad(location);
        arg arg2 = new arg(collection);
        for (Location location2 : list) {
            WrappedBlockData wrappedBlockData = WrappedBlockData.createData((Object)location2.getBlock().getBlockData());
            arg2.a(location2.toVector(), wrappedBlockData);
        }
        arg2.uZ();
    }

    public void a(Location location, boolean bl) {
        for (double d2 = location.getX() - 5.0; d2 < location.getX() + 5.0; d2 += 1.0) {
            for (double d3 = location.getY() - 5.0; d3 < location.getY() + 5.0; d3 += 1.0) {
                for (double d4 = location.getZ() - 5.0; d4 < location.getZ() + 5.0; d4 += 1.0) {
                    this.a(location.getWorld().getBlockAt((int)d2, (int)d3, (int)d4), false, true, bl);
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
            if (!ql.j(block.getRelative(blockFace).getType())) continue;
            return true;
        }
        return false;
    }

    boolean z(Block block) {
        for (BlockFace blockFace : Bn) {
            Block block2 = block.getRelative(blockFace);
            if (!ql.av(block2) || !d.g().b(block2).isCustomBlock(block2)) continue;
            return true;
        }
        return false;
    }

    private static boolean a(BlockPhysicsEvent blockPhysicsEvent, Material material) {
        Material material2 = blockPhysicsEvent.getBlock().getType();
        Material material3 = blockPhysicsEvent.getSourceBlock().getType();
        return mc.a(blockPhysicsEvent.getChangedType(), material2, material3, material);
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
        if (!ae.cH) {
            return;
        }
        Block block = blockPhysicsEvent.getBlock();
        if (xd.q(block.getX() >> 4, block.getZ() >> 4)) {
            blockPhysicsEvent.setCancelled(true);
            return;
        }
        Material material = block.getType();
        Material material2 = blockPhysicsEvent.getSourceBlock().getType();
        if (blockPhysicsEvent.getChangedType() == Material.CHORUS_PLANT || material == Material.CHORUS_PLANT || material2 == Material.CHORUS_PLANT) {
            blockPhysicsEvent.setCancelled(true);
            this.x(blockPhysicsEvent.getSourceBlock());
            ms ms2 = d.g().b(block);
            if (ms2.T(block)) {
                ql ql2 = d.g().h(ms2.Y(block));
                if (blockPhysicsEvent.getSourceBlock().getType() == Material.WATER) {
                    ms2.c(block, true);
                    blockPhysicsEvent.getSourceBlock().setType(Material.AIR, false);
                    bdf.b(block.getLocation(), ql2);
                    bcp.c(() -> block.setType(Material.AIR, false), 2L);
                    return;
                }
            }
            return;
        }
        if (mc.b(blockPhysicsEvent.getSourceBlock(), material2)) {
            blockPhysicsEvent.setCancelled(true);
        }
    }

    public static boolean b(Block block, Material material) {
        if (!mc.g(material) && material != Material.AIR && material != Material.CAVE_AIR) {
            return false;
        }
        ms ms2 = d.g().b(block);
        if (ms2 == null) {
            return false;
        }
        if (ms2.isCustomBlock(block)) {
            ql ql2 = d.g().h(ms2.Y(block));
            if (ql2 != null) {
                ql2.FD.ay(block);
            }
            return true;
        }
        return false;
    }

    private boolean c(BlockPhysicsEvent blockPhysicsEvent) {
        if (!ae.cG) {
            return false;
        }
        if (blockPhysicsEvent.getChangedType() == null || blockPhysicsEvent.getSourceBlock() == null) {
            return false;
        }
        if (!mf.h(blockPhysicsEvent.getChangedType())) {
            return false;
        }
        if (mc.a(blockPhysicsEvent, null)) {
            return false;
        }
        blockPhysicsEvent.setCancelled(true);
        this.a(blockPhysicsEvent.getBlock(), false, false, true);
        return true;
    }

    public static void a(ChunkLoadEvent chunkLoadEvent, ms ms2) {
        Chunk chunk = chunkLoadEvent.getChunk();
        if (mc.f(ae.ep, chunkLoadEvent.isNewChunk())) {
            mc.b(chunk, ms2);
        }
        if (ae.en) {
            if (ae.eo && !chunkLoadEvent.isNewChunk()) {
                return;
            }
            List list = axi.vC().aoJ.A(chunk);
            if (list.isEmpty()) {
                return;
            }
            int n = 0;
            for (Location location : list) {
                if (ms2.G(location)) continue;
                Block block = location.getBlock();
                ql ql2 = d.a(block.getBlockData());
                if (ql2 != null) {
                    ms2.e(block, ql2.getNamespacedID());
                    if (!ae.dB) continue;
                    bce.log("Converted vanilla block " + block.getBlockData().getAsString(true) + " to " + ql2.Gh + " | " + bcc.ae(block.getLocation()));
                    ++n;
                    continue;
                }
                if (!ae.dB) continue;
                bce.log("No custom block found for vanilla block " + bcc.ae(block.getLocation()));
            }
            if (ae.dB && n > 0) {
                bce.log(String.valueOf(ChatColor.GREEN) + "Converted vanilla blocks: " + n);
            }
        } else if (ae.er) {
            if (ae.eq && !chunkLoadEvent.isNewChunk()) {
                return;
            }
            if (ms2.BT.t(chunk)) {
                return;
            }
            List list = axi.vC().aoJ.A(chunk);
            if (list.isEmpty()) {
                return;
            }
            arg arg2 = null;
            for (Location location : list) {
                if (ms2.G(location)) continue;
                Block block = location.getBlock();
                if (arg2 == null) {
                    Collection collection = zw.sZ() ? chunk.getPlayersSeeingChunk() : bcc.ad(location);
                    arg2 = new arg(collection);
                }
                mc.a(block, arg2);
                if (!ae.dC) continue;
                bce.log("Fixed glitched block at " + bcc.ae(block.getLocation()));
            }
            if (arg2 != null) {
                arg2.uZ();
                ms2.BT.s(chunk);
            }
        }
    }

    static boolean f(boolean bl, boolean bl2) {
        return bl && !bl2;
    }

    private static void b(Chunk chunk, ms ms2) {
        arg[] argArray = new arg[1];
        ms2.a(chunk, (T string, U location) -> {
            boolean bl;
            ql ql2 = d.g().h((String)string);
            if (ql2 == null) {
                return;
            }
            rz rz2 = ql2.FD;
            Block block = location.getBlock();
            BlockData blockData = rz2.pb();
            boolean bl2 = blockData == null ? block.getType() != rz2.pc() : (bl = !blockData.equals((Object)block.getBlockData()));
            if (!bl) {
                return;
            }
            if (blockData == null) {
                rz2.ay(block);
                return;
            }
            rz2.i(block, false);
            if (argArray[0] == null) {
                Collection collection = zw.sZ() ? chunk.getPlayersSeeingChunk() : bcc.ad(location);
                argArray[0] = new arg(collection);
            }
            argArray[0].a(block.getX(), block.getY(), block.getZ(), WrappedBlockData.createData((Object)blockData));
        });
        if (argArray[0] != null) {
            argArray[0].uZ();
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockIgniteEvent blockIgniteEvent) {
        if (blockIgniteEvent.getCause() == BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL) {
            return;
        }
        Block block = blockIgniteEvent.getBlock().getRelative(BlockFace.DOWN);
        if (ql.av(block) && d.isCustomBlock(block)) {
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
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        if (lh.aI(blockPlaceEvent.getPlayer())) {
            return;
        }
        if (!ql.j(blockPlaceEvent.getBlockPlaced().getType())) {
            return;
        }
        Material material = blockPlaceEvent.getBlockPlaced().getType();
        if (!ae.cG || !ql.h(material) || ae.cI && ql.m(material) || ae.cH && ql.l(material)) {
            return;
        }
        blockPlaceEvent.setCancelled(true);
        Block block = blockPlaceEvent.getBlockPlaced();
        if (blockPlaceEvent.getBlockPlaced().getType() == Material.CHORUS_PLANT) {
            for (Block block2 : bdf.b(blockPlaceEvent.getBlock(), false, true)) {
                ms ms2 = d.g().b(block2);
                if (!ms2.isCustomBlock(block2)) continue;
                blockPlaceEvent.setCancelled(true);
                this.C(block2.getLocation());
                return;
            }
        }
        bcp.c(() -> {
            ahd.tN().d(block, material);
            blockPlaceEvent.getBlock().setBlockData(ls.f(material), false);
            if (blockPlaceEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
                bbs.j(blockPlaceEvent);
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
        if (abk.tl().a((Event)blockExplodeEvent)) {
            return;
        }
        this.a(blockExplodeEvent.blockList(), blockExplodeEvent.getBlock().getLocation().add(0.5, 0.5, 0.5), null);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(EntityExplodeEvent entityExplodeEvent) {
        UUID uUID = entityExplodeEvent.getEntity().getUniqueId();
        if (abk.tl().a((Event)entityExplodeEvent)) {
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
        ql ql2;
        float f2;
        float f3 = f2 = uUID == null ? 1.0f : this.Bt.getOrDefault(uUID, Float.valueOf(1.0f)).floatValue();
        if (uUID != null) {
            this.Bt.remove(uUID);
        }
        LongOpenHashSet longOpenHashSet = null;
        IdentityHashMap<Block, ql> identityHashMap = null;
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Block block = (Block)listIterator.next();
            ql2 = this.d(block);
            if (ql2 == null) continue;
            if (ql2.FI) {
                listIterator.remove();
                ql2.ar(block);
                if (longOpenHashSet == null) {
                    longOpenHashSet = new LongOpenHashSet();
                }
                longOpenHashSet.add(mc.d(block.getX(), block.getY(), block.getZ()));
                continue;
            }
            if (ql2.mJ() > 0.0f) {
                float f4 = f2 * (0.7f + bcy.Bl.nextFloat() * 0.6f);
                if ((f4 -= (ql2.mJ() + 0.3f) * 0.3f) <= 0.0f) {
                    listIterator.remove();
                    ql2.ar(block);
                    if (longOpenHashSet == null) {
                        longOpenHashSet = new LongOpenHashSet();
                    }
                    longOpenHashSet.add(mc.d(block.getX(), block.getY(), block.getZ()));
                    continue;
                }
            }
            if (identityHashMap == null) {
                identityHashMap = new IdentityHashMap<Block, ql>();
            }
            identityHashMap.put(block, ql2);
        }
        if (longOpenHashSet != null) {
            double d2 = location.getX();
            double d3 = location.getY();
            double d4 = location.getZ();
            listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                Block block = (Block)listIterator.next();
                if (!mc.a(d2, d3, d4, block.getX(), block.getY(), block.getZ(), longOpenHashSet)) continue;
                listIterator.remove();
            }
        }
        if (identityHashMap == null) {
            return;
        }
        listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Block block = (Block)listIterator.next();
            ql2 = (ql)identityHashMap.get(block);
            if (ql2 == null) continue;
            se se2 = ql2.mK();
            if (se2 != null && se2.as(8)) {
                se2.a(ql2, block.getLocation());
                listIterator.remove();
                continue;
            }
            listIterator.remove();
            ms ms2 = d.g().b(block);
            ms2.a(block, true, true);
            List list2 = d.g().aq.e(block, ql2);
            if (list2 != null && !list2.isEmpty()) {
                list2.forEach(ub2 -> ub2.U(block.getLocation()));
                continue;
            }
            if (!ql2.mG()) continue;
            bdf.b(block.getLocation(), ql2);
        }
    }

    @Nullable
    private ql d(Block block) {
        ms ms2 = d.g().b(block);
        if (!ms2.isCustomBlock(block)) {
            return null;
        }
        ra ra2 = (ra)d.g().e(ms2.Y(block));
        if (ra2 == null || ra2.Hq == sd.FIRE) {
            return null;
        }
        return (ql)ra2;
    }

    static boolean a(double d2, double d3, double d4, int n, int n2, int n3, LongOpenHashSet longOpenHashSet) {
        double d5;
        double d6;
        double d7;
        double d8;
        int n4;
        int n5;
        int n6 = Location.locToBlock((double)d2);
        int n7 = Location.locToBlock((double)d3);
        int n8 = Location.locToBlock((double)d4);
        if (n6 == n && n7 == n2 && n8 == n3) {
            return false;
        }
        if (longOpenHashSet.contains(mc.d(n6, n7, n8))) {
            return true;
        }
        double d9 = (double)n + 0.5 - d2;
        double d10 = (double)n2 + 0.5 - d3;
        double d11 = (double)n3 + 0.5 - d4;
        int n9 = d9 > 0.0 ? 1 : (n5 = d9 < 0.0 ? -1 : 0);
        int n10 = d10 > 0.0 ? 1 : (n4 = d10 < 0.0 ? -1 : 0);
        int n11 = d11 > 0.0 ? 1 : (d11 < 0.0 ? -1 : 0);
        double d12 = n5 == 0 ? Double.POSITIVE_INFINITY : 1.0 / Math.abs(d9);
        double d13 = n4 == 0 ? Double.POSITIVE_INFINITY : 1.0 / Math.abs(d10);
        double d14 = d8 = n11 == 0 ? Double.POSITIVE_INFINITY : 1.0 / Math.abs(d11);
        double d15 = n5 > 0 ? ((double)(n6 + 1) - d2) / d9 : (d7 = n5 < 0 ? (d2 - (double)n6) / -d9 : Double.POSITIVE_INFINITY);
        double d16 = n4 > 0 ? ((double)(n7 + 1) - d3) / d10 : (d6 = n4 < 0 ? (d3 - (double)n7) / -d10 : Double.POSITIVE_INFINITY);
        double d17 = n11 > 0 ? ((double)(n8 + 1) - d4) / d11 : (d5 = n11 < 0 ? (d4 - (double)n8) / -d11 : Double.POSITIVE_INFINITY);
        do {
            boolean bl;
            double d18;
            if ((d18 = Math.min(d7, Math.min(d6, d5))) > 1.0) {
                return false;
            }
            boolean bl2 = d7 == d18;
            boolean bl3 = d6 == d18;
            boolean bl4 = bl = d5 == d18;
            if (bl2) {
                n6 += n5;
                d7 += d12;
            }
            if (bl3) {
                n7 += n4;
                d6 += d13;
            }
            if (bl) {
                n8 += n11;
                d5 += d8;
            }
            if (n6 != n || n7 != n2 || n8 != n3) continue;
            return false;
        } while (!longOpenHashSet.contains(mc.d(n6, n7, n8)));
        return true;
    }

    static long d(int n, int n2, int n3) {
        return (long)(n & 0x3FFFFFF) << 38 | (long)(n3 & 0x3FFFFFF) << 12 | (long)n2 & 0xFFFL;
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void b(BlockPistonExtendEvent blockPistonExtendEvent) {
        for (Block block : blockPistonExtendEvent.getBlocks()) {
            ms ms2;
            if (!ql.av(block) || !(ms2 = d.g().b(block)).isCustomBlock(block)) continue;
            blockPistonExtendEvent.setCancelled(true);
            bdf.b(blockPistonExtendEvent.getBlock().getLocation(), new ItemStack(blockPistonExtendEvent.getBlock().getType()));
            blockPistonExtendEvent.getBlock().setType(Material.AIR);
            return;
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BlockPistonRetractEvent blockPistonRetractEvent) {
        for (Block block : blockPistonRetractEvent.getBlocks()) {
            ms ms2;
            if (!ql.av(block) || !(ms2 = d.g().b(block)).isCustomBlock(block)) continue;
            blockPistonRetractEvent.setCancelled(true);
            bdf.b(blockPistonRetractEvent.getBlock().getLocation(), new ItemStack(blockPistonRetractEvent.getBlock().getType()));
            blockPistonRetractEvent.getBlock().setType(Material.AIR);
            return;
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void d(BlockPlaceEvent blockPlaceEvent) {
        if (bev.k(blockPlaceEvent)) {
            return;
        }
        if (!blockPlaceEvent.getBlockPlaced().getType().toString().contains("REDSTONE")) {
            return;
        }
        Block block = blockPlaceEvent.getBlockPlaced();
        if (!this.y(block)) {
            return;
        }
        bcp.c(() -> this.C(block.getLocation()), 5L);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void e(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        if (!blockBreakEvent.getBlock().getType().toString().contains("REDSTONE")) {
            return;
        }
        Block block = blockBreakEvent.getBlock();
        if (!this.y(block)) {
            return;
        }
        bcp.c(() -> this.a(block.getLocation(), true), 20L);
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
            jl jl2;
            qm qm2;
            CustomFurniture customFurniture;
            Entity entity;
            Player player = (Player)inventoryCreativeEvent.getWhoClicked();
            if (w.bN.p(player)) {
                return;
            }
            if (ql.k(itemStack.getType())) {
                Block block = aqp.bZ(player);
                ms ms2 = d.g().b(block);
                if (ms2.isCustomBlock(block)) {
                    ql ql2 = d.g().h(ms2.Y(block));
                    if (ql2 == null) {
                        return;
                    }
                    if (ql2.FD != null && !ql2.FD.o(itemStack.getType())) {
                        return;
                    }
                    this.a(inventoryCreativeEvent, ql2);
                }
            } else if ((itemStack.getType() == Material.BARRIER || itemStack.getType() == Material.ARMOR_STAND || afz.J(itemStack.getType())) && (entity = jl.ao(player)) != null && (customFurniture = CustomFurniture.byAlreadySpawned(entity)) != null && (qm2 = d.g().a(customFurniture.getItemStack())) != null && (jl2 = (jl)qm2.Ge.bn("furniture")) != null) {
                this.a(inventoryCreativeEvent, qm2);
            }
        }
    }

    private void a(InventoryCreativeEvent inventoryCreativeEvent, qm qm2) {
        int n;
        inventoryCreativeEvent.setCancelled(true);
        inventoryCreativeEvent.setCursor(bbs.Dc());
        HumanEntity humanEntity = inventoryCreativeEvent.getWhoClicked();
        PlayerInventory playerInventory = humanEntity.getInventory();
        for (n = 0; n <= 8; ++n) {
            if (bbs.at(playerInventory.getItem(n)) || !ql.b(playerInventory.getItem(n), (ItemStack)qm2)) continue;
            playerInventory.setHeldItemSlot(n);
            playerInventory.setItem(n, (ItemStack)qm2);
            return;
        }
        if (bbs.at(playerInventory.getItemInMainHand())) {
            playerInventory.setItemInMainHand((ItemStack)qm2);
        } else {
            for (n = 0; n <= 8; ++n) {
                if (!bbs.at(playerInventory.getItem(n))) continue;
                playerInventory.setHeldItemSlot(n);
                playerInventory.setItem(n, (ItemStack)qm2);
                return;
            }
            playerInventory.setItemInMainHand((ItemStack)qm2);
        }
    }

    static {
        Bn = new BlockFace[]{BlockFace.SOUTH, BlockFace.WEST, BlockFace.NORTH, BlockFace.EAST, BlockFace.UP, BlockFace.DOWN};
    }
}
