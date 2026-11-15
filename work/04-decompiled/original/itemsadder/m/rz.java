package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.aaf;
import itemsadder.m.aah;
import itemsadder.m.abk;
import itemsadder.m.ahd;
import itemsadder.m.bce;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.rg;
import itemsadder.m.sb;
import itemsadder.m.sd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Particle;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.block.data.type.Tripwire;
import org.jetbrains.annotations.Nullable;

public class rz {
    static final BlockFace[] IV;
    static final Cache IW;
    public final ql IX;
    public final int id;
    public final rg IY;
    public Material IZ;
    public qm Ja;
    public boolean Jb;
    public boolean Jc;
    public boolean Jd;
    public boolean Je;
    private int Jf;
    private int Jg;
    @Nullable
    public final List Jh;
    private sb Ji = sb.NONE;
    Map Jj = new HashMap();
    private boolean Jk = false;
    @Nullable
    private BlockData vC;
    private Material Jl;
    @Deprecated
    @Nullable
    private final HashMap Jm;
    @Nullable
    private Object Jn;
    private static final HashMap Jo;
    private static final String[] Jp;
    private static final HashMap Jq;
    private static final Map Jr;

    public static void mc() {
        IW.invalidateAll();
    }

    public rz(ql ql2, int n, rg rg2, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n2, int n3, @Nullable List list) {
        Jo.put(Material.CLAY, Instrument.FLUTE);
        Jo.put(Material.GOLD_BLOCK, Instrument.BELL);
        Jo.put(Material.PACKED_ICE, Instrument.CHIME);
        Jo.put(Material.BONE_BLOCK, Instrument.XYLOPHONE);
        Jo.put(Material.IRON_BLOCK, Instrument.IRON_XYLOPHONE);
        Jo.put(Material.SOUL_SAND, Instrument.COW_BELL);
        Jo.put(Material.PUMPKIN, Instrument.DIDGERIDOO);
        Jo.put(Material.EMERALD_BLOCK, Instrument.BIT);
        Jo.put(Material.HAY_BLOCK, Instrument.BANJO);
        Jo.put(Material.GLOWSTONE, Instrument.PLING);
        int n4 = Jp.length;
        for (int i = 0; i < n4; ++i) {
            Jq.put(Jp[i], Instrument.values()[i]);
        }
        this.IX = ql2;
        this.id = n;
        this.Jb = bl;
        this.Jc = bl2;
        this.Jd = bl3;
        this.Je = bl4;
        this.Jf = n2;
        this.Jg = n3;
        this.Jh = list;
        this.IY = !ql2.getType().isBlock() && rg2 == rg.BLOCK ? rg.ITEM : rg2;
        this.Jl = ql2.Hq == sd.ENTITY ? Material.BARRIER : rz.ao(n);
        this.Jm = new HashMap();
        if (ql2.Hq == sd.ENTITY) {
            this.vC = Material.BARRIER.createBlockData();
        } else if (ql2.Hq == sd.TILE) {
            this.Jl = Material.SPAWNER;
        } else if (ql2.Hq == sd.REAL_NOTE) {
            this.vC = rz.a(n, ql2.Hq);
            this.vC = rz.ar(n);
        } else if (ql2.Hq == sd.REAL_WIRE) {
            this.vC = rz.aq(n);
        } else if (ql2.Hq == sd.REAL || ql2.Hq == sd.REAL_TRANSPARENT) {
            this.vC = rz.a(n, ql2, this.Jl, this.Jm);
        } else {
            try {
                throw new Exception("Not implemented");
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (this.vC == null && ql2.nC()) {
            bce.error(String.format("&cFailed to load BlockData of &b%s&c with internal id &b%d&c, type &b%s&c. &eTry to delete storage/xx_ids_cache.yml file and restart.", new Object[]{ql2.getNamespacedID(), n, ql2.Hq}));
        }
    }

    public void a(sb sb2) {
        if (sb2 == null) {
            sb2 = sb.NONE;
        }
        this.Ji = sb2;
    }

    public sb oV() {
        return this.Ji;
    }

    public boolean oW() {
        return this.Ji != null && this.Ji != sb.NONE;
    }

    public boolean oX() {
        return this.Jk;
    }

    public void aw(boolean bl) {
        this.Jk = bl;
    }

    public void am(int n) {
        this.Jf = n;
    }

    public void an(int n) {
        this.Jg = n;
    }

    public int oY() {
        return this.Jf;
    }

    public int oZ() {
        return this.Jg;
    }

    public static Material ao(int n) {
        if (n >= 0 && n < 63) {
            return Material.BROWN_MUSHROOM_BLOCK;
        }
        if (n >= 64 && n < 127) {
            return Material.RED_MUSHROOM_BLOCK;
        }
        if (n >= 128 && n < 191) {
            return Material.MUSHROOM_STEM;
        }
        if (n >= 192 && n < 255) {
            return Material.CHORUS_PLANT;
        }
        if (n >= 256 && n <= 1006) {
            return Material.NOTE_BLOCK;
        }
        if (n >= 1007 && n < 1136) {
            return Material.TRIPWIRE;
        }
        return Material.SPAWNER;
    }

    public static sd ap(int n) {
        if (n >= 0 && n < 63) {
            return sd.REAL;
        }
        if (n >= 64 && n < 127) {
            return sd.REAL;
        }
        if (n >= 128 && n < 191) {
            return sd.REAL;
        }
        if (n >= 192 && n < 255) {
            return sd.REAL_TRANSPARENT;
        }
        if (n >= 256 && n <= 1006) {
            return sd.REAL_NOTE;
        }
        if (n >= 1007 && n < 1136) {
            return sd.REAL_WIRE;
        }
        return sd.TILE;
    }

    @Nullable
    public static BlockData a(int n, sd sd2) {
        Map map = (Map)Jr.get((Object)sd2);
        if (map != null) {
            return (BlockData)map.get(n);
        }
        return null;
    }

    @Nullable
    public static Integer a(BlockData blockData, sd sd2) {
        Map map = (Map)Jr.get((Object)sd2);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (!((BlockData)entry.getValue()).matches(blockData)) continue;
                return (Integer)entry.getKey();
            }
        }
        return null;
    }

    public static BlockData aq(int n) {
        if (n < 1007) {
            return null;
        }
        Tripwire tripwire = (Tripwire)IW.getIfPresent(n);
        if (tripwire != null) {
            return tripwire;
        }
        Material material = rz.ao(n);
        tripwire = (Tripwire)Bukkit.createBlockData((Material)material);
        int n2 = n - 1007;
        for (int i = 0; i < IV.length; ++i) {
            BlockFace blockFace = IV[IV.length - 1 - i];
            if (blockFace == BlockFace.DOWN) {
                tripwire.setAttached((n2 & 1 << i) != 0);
                continue;
            }
            if (blockFace == BlockFace.UP) {
                tripwire.setDisarmed((n2 & 1 << i) != 0);
                continue;
            }
            if (blockFace == BlockFace.SELF) {
                tripwire.setPowered((n2 & 1 << i) != 0);
                continue;
            }
            tripwire.setFace(blockFace, (n2 & 1 << i) != 0);
        }
        IW.put(n, tripwire);
        return tripwire;
    }

    public static BlockData ar(int n) {
        boolean bl;
        if (n < 256) {
            return null;
        }
        NoteBlock noteBlock = (NoteBlock)IW.getIfPresent(n);
        if (noteBlock != null) {
            return noteBlock;
        }
        int n2 = n - 256;
        noteBlock = (NoteBlock)Bukkit.createBlockData((Material)Material.NOTE_BLOCK);
        boolean bl2 = bl = n2 >= 375;
        if (bl) {
            n2 -= 375;
        }
        int n3 = (n2 += 25) / 25;
        int n4 = n2 - 25 * n3;
        noteBlock.setInstrument(aaf.c((byte)n3));
        noteBlock.setNote(new Note(n4));
        noteBlock.setPowered(bl);
        IW.put(n, noteBlock);
        return noteBlock;
    }

    @Nullable
    public static MultipleFacing a(int n, @Nullable ql ql2, Material material) {
        return rz.a(n, ql2, material, null);
    }

    @Nullable
    public static MultipleFacing a(int n, @Nullable ql ql2, Material material, HashMap hashMap) {
        BlockData blockData = (BlockData)IW.getIfPresent(n);
        if (blockData != null) {
            return (MultipleFacing)blockData;
        }
        blockData = Bukkit.createBlockData((Material)material);
        if (blockData instanceof MultipleFacing) {
            MultipleFacing multipleFacing = (MultipleFacing)blockData;
            BlockFace[] blockFaceArray = new BlockFace[]{BlockFace.DOWN, BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.UP, BlockFace.WEST};
            for (int i = 0; i < blockFaceArray.length; ++i) {
                multipleFacing.setFace(blockFaceArray[blockFaceArray.length - 1 - i], (n & 1 << i) != 0);
                if (hashMap == null) continue;
                hashMap.put(blockFaceArray[blockFaceArray.length - 1 - i], (n & 1 << i) != 0);
            }
        } else {
            bce.error("Error. !data instanceof MultipleFacing: " + ql2.getNamespacedID() + " | " + String.valueOf(ql2.getType()) + " | " + String.valueOf((Object)ql2.Hq) + " | " + String.valueOf(material) + " | " + n);
            for (int i = 0; i < 15; ++i) {
                bce.error("To fix this error please read this:" + String.valueOf(ChatColor.AQUA) + " https://github.com/LoneDev6/ItemsAdder/issues/186#issuecomment-621268971");
            }
        }
        IW.put(n, blockData);
        return (MultipleFacing)blockData;
    }

    public void n(Material material) {
        this.IZ = material;
    }

    public void n(qm qm2) {
        this.Ja = qm2;
    }

    @Deprecated
    public HashMap pa() {
        return this.Jm;
    }

    @Nullable
    public BlockData pb() {
        return this.vC;
    }

    public Material pc() {
        return this.Jl;
    }

    public boolean o(Material material) {
        return this.IX.Hq.p(this.Jl).equals((Object)material);
    }

    public void i(Block block, boolean bl) {
        if (this.az(block)) {
            return;
        }
        if (this.vC != null) {
            if (bl) {
                block.setBlockData(this.vC, false);
            } else {
                ahd.tN().setBlockData(block, this.vC);
            }
        }
    }

    public void ay(Block block) {
        if (this.az(block)) {
            return;
        }
        if (this.vC != null) {
            ahd.tN().a(block, this.vC, true);
        }
    }

    private boolean az(Block block) {
        if (this.IX.Hq == sd.TILE) {
            abk.tl().f(block, this.IX);
            return true;
        }
        return false;
    }

    public void T(Location location) {
        if (this.IX.Hq == sd.REAL_WIRE) {
            return;
        }
        if (this.IZ != null) {
            location.getWorld().spawnParticle(Particle.BLOCK, location.clone().add(0.5, 0.5, 0.5), 40, 0.2333333333333333, 0.2333333333333333, 0.2333333333333333, 0.09, (Object)this.IZ.createBlockData());
            return;
        }
        if (this.Ja != null) {
            location.getWorld().spawnParticle(Particle.ITEM, location.clone().add(0.5, 0.5, 0.5), 40, 0.2333333333333333, 0.2333333333333333, 0.2333333333333333, 0.09, (Object)this.Ja);
            return;
        }
        switch (this.IY) {
            case BLOCK: {
                location.getWorld().spawnParticle(Particle.BLOCK, location.clone().add(0.5, 0.5, 0.5), 40, 0.2333333333333333, 0.2333333333333333, 0.2333333333333333, 0.09, (Object)this.IX.getType().createBlockData());
                break;
            }
            case ITEM: {
                location.getWorld().spawnParticle(Particle.ITEM, location.clone().add(0.5, 0.5, 0.5), 40, 0.2333333333333333, 0.2333333333333333, 0.2333333333333333, 0.09, (Object)this.IX);
                break;
            }
            case VANILLA: {
                if (this.vC == null) break;
                abk.a(location, this.vC);
            }
        }
    }

    public static String a(Instrument instrument) {
        return Jp[instrument.getType()];
    }

    @Nullable
    public static Instrument cc(String string) {
        return (Instrument)Jq.get(string);
    }

    @Deprecated
    public static Instrument aA(Block block) {
        return aaf.tg().aR(block);
    }

    @Deprecated
    public static Instrument aB(Block block) {
        if (block.getType() == Material.AIR) {
            return Instrument.PIANO;
        }
        Instrument instrument = Instrument.PIANO;
        if (Jo.containsKey(block.getType())) {
            instrument = (Instrument)Jo.get(block.getType());
        } else if (aaf.a(block, Tag.WOOL)) {
            instrument = Instrument.GUITAR;
        } else if (aaf.a(block, aah.STONE)) {
            instrument = Instrument.BASS_DRUM;
        } else if (aaf.a(block, aah.SAND)) {
            instrument = Instrument.SNARE_DRUM;
        } else if (aaf.a(block, aah.SHATTERABLE)) {
            instrument = Instrument.STICKS;
        } else if (aaf.a(block, aah.WOOD)) {
            instrument = Instrument.BASS_GUITAR;
        }
        return instrument;
    }

    public Object pd() {
        return this.Jn;
    }

    public void b(Object object) {
        this.Jn = object;
    }

    public void a(BlockFace blockFace, ql ql2) {
        this.Jj.put(blockFace, ql2);
    }

    public ql a(BlockFace blockFace) {
        ql ql2 = (ql)this.Jj.get(blockFace);
        if (ql2 == null) {
            return this.IX;
        }
        return ql2;
    }

    public ql n(int n, int n2) {
        for (Map.Entry entry : this.Jj.entrySet()) {
            if (((ql)entry.getValue()).FD == null || ((ql)entry.getValue()).FD.Jg != n2 || ((ql)entry.getValue()).FD.Jf != n) continue;
            return (ql)entry.getValue();
        }
        return null;
    }

    static {
        int n;
        IV = new BlockFace[]{BlockFace.DOWN, BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.UP, BlockFace.WEST, BlockFace.SELF};
        IW = CacheBuilder.newBuilder().expireAfterWrite(10L, TimeUnit.MINUTES).build();
        Jo = new HashMap();
        Jp = new String[]{"harp", "basedrum", "snare", "hat", "bass", "flute", "bell", "guitar", "chime", "xylophone", "iron_xylophone", "cow_bell", "didgeridoo", "bit", "banjo", "pling"};
        Jq = new HashMap();
        Jr = new HashMap();
        HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
        for (n = 0; n < 63; ++n) {
            hashMap.put(n, rz.a(n, null, Material.BROWN_MUSHROOM_BLOCK));
        }
        hashMap = new HashMap();
        for (n = 64; n < 127; ++n) {
            hashMap.put(n, rz.a(n, null, Material.RED_MUSHROOM_BLOCK));
        }
        Jr.put(sd.REAL, hashMap);
        hashMap = new HashMap();
        for (n = 128; n < 191; ++n) {
            hashMap.put(n, rz.a(n, null, Material.MUSHROOM_STEM));
        }
        Jr.put(sd.REAL, hashMap);
        hashMap = new HashMap();
        for (n = 193; n < 255; ++n) {
            hashMap.put(n, rz.a(n, null, Material.CHORUS_PLANT));
        }
        Jr.put(sd.REAL_TRANSPARENT, hashMap);
        hashMap = new HashMap();
        for (n = 256; n < 1006; ++n) {
            hashMap.put(n, rz.ar(n));
        }
        Jr.put(sd.REAL_NOTE, hashMap);
        hashMap = new HashMap();
        for (n = 1008; n < 1136; ++n) {
            hashMap.put(n, rz.aq(n));
        }
        Jr.put(sd.REAL_WIRE, hashMap);
    }
}
