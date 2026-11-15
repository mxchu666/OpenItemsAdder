package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import dev.lone.itemsadder.Main;
import itemsadder.m.abk;
import itemsadder.m.ae;
import itemsadder.m.ahd;
import itemsadder.m.axy;
import itemsadder.m.aya;
import itemsadder.m.ayc;
import itemsadder.m.ayi;
import itemsadder.m.ayk;
import itemsadder.m.bce;
import itemsadder.m.bcn;
import itemsadder.m.bdq;
import itemsadder.m.d;
import itemsadder.m.mn;
import itemsadder.m.mo;
import itemsadder.m.mq;
import itemsadder.m.mr;
import itemsadder.m.mt;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.BiConsumer;
import org.apache.commons.io.FileUtils;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ms {
    private static final long BN = 60000L;
    public final World BO;
    public final int BP;
    final int BQ;
    final int BR;
    final String BS;
    public final mq BT;
    private final Lock BU;
    private long BV;
    private final Map BW = Collections.synchronizedMap(new HashMap());
    final AtomicBoolean BX = new AtomicBoolean();
    public final mn BY;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ms(File file, World world) {
        this.BO = world;
        this.BU = new ReentrantReadWriteLock().writeLock();
        this.BS = file.getName();
        String[] stringArray = this.BS.split("\\.");
        this.BQ = Integer.parseInt(stringArray[1]);
        this.BR = Integer.parseInt(stringArray[2]);
        this.BP = ms.f(world, this.BQ, this.BR);
        try {
            this.BU.lock();
            this.BT = new mq(file.getParentFile());
            this.BT.lV();
            this.BY = new mn(file);
        }
        finally {
            this.BU.unlock();
        }
        this.lU();
    }

    ms() {
        this.BO = null;
        this.BU = new ReentrantReadWriteLock().writeLock();
        this.BS = "dummy";
        this.BQ = 0;
        this.BR = 0;
        this.BP = 0;
        this.BT = null;
        this.BY = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public ayc a(int n, int n2, boolean bl) {
        String string2 = ms.l(n, n2);
        this.bk(string2);
        @Nullable ayc ayc2 = (ayc)this.BY.ja(string2);
        if (ayc2 != null) {
            return ayc2;
        }
        if (!bl && !this.BY.jb(string2)) {
            return null;
        }
        try {
            this.BU.lock();
            bdq bdq2 = new bdq();
            if (bl) {
                long l;
                AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                ayc2 = (ayc)this.BY.a(string2, (Object string) -> {
                    atomicBoolean.set(false);
                    if (ae.dF) {
                        bce.log("Created chunk '" + n + "," + n2 + "' " + this.lO());
                    }
                    return ayc.wt();
                });
                if (atomicBoolean.get() && ae.dF && (l = bdq2.DJ()) >= (long)ae.dG) {
                    bce.log("Loaded chunk '" + n + "," + n2 + "' in " + l + "ms | " + this.lO());
                }
            } else {
                long l;
                try {
                    ayc2 = (ayc)this.BY.jd(string2);
                }
                catch (EOFException eOFException) {
                    ayc2 = ayc.wt();
                    bce.error("Empty chunk will be used to avoid problems for chunk " + string2 + " | " + this.lO());
                }
                if (ayc2 != null && ae.dF && (l = bdq2.DJ()) >= (long)ae.dG) {
                    bce.log("Loaded chunk '" + n + "," + n2 + "' of '" + this.BS + "' in " + l + "ms | " + this.lO());
                }
            }
            ayc ayc3 = ayc2;
            return ayc3;
        }
        catch (Throwable throwable) {
            bce.error("Failed to load chunk '" + n + ", " + n2 + "' | " + this.lO(), throwable);
            bce.error("Empty chunk will be used to avoid problems for chunk " + string2 + " | " + this.lO());
            ayc ayc4 = ayc.wt();
            return ayc4;
        }
        finally {
            this.BU.unlock();
        }
    }

    @Nullable
    private ayc j(int n, int n2) {
        return this.a(n, n2, false);
    }

    @Nullable
    private ayc u(Chunk chunk) {
        return this.j(chunk.getX(), chunk.getZ());
    }

    @NotNull
    private ayc k(int n, int n2) {
        return this.a(n, n2, true);
    }

    @NotNull
    private ayc v(Chunk chunk) {
        return this.k(chunk.getX(), chunk.getZ());
    }

    public boolean i(int n, int n2) {
        return this.j(n, n2) != null;
    }

    public boolean o(Chunk chunk) {
        return this.i(chunk.getX(), chunk.getZ());
    }

    @Nullable
    private aya f(Chunk chunk, int n, int n2, int n3) {
        return this.a(chunk.getX(), chunk.getZ(), n, n2, n3);
    }

    @Nullable
    private aya a(int n, int n2, int n3, int n4, int n5) {
        ayc ayc2 = this.j(n, n2);
        if (ayc2 == null) {
            return null;
        }
        return ayc2.dU(ms.i(n3, n4, n5));
    }

    @Nullable
    private aya I(Location location) {
        if (!location.getWorld().isChunkLoaded(location.getBlockX() >> 4, location.getBlockZ() >> 4)) {
            throw new mo("Chunk is not loaded!");
        }
        return this.a(location.getBlockX() >> 4, location.getBlockZ() >> 4, location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Nullable
    private aya J(Location location) {
        return this.a(location.getBlockX() >> 4, location.getBlockZ() >> 4, location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Nullable
    private aya ai(Block block) {
        return this.a(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    @NotNull
    private aya g(Chunk chunk, int n, int n2, int n3) {
        return this.b(chunk.getX(), chunk.getZ(), n, n2, n3);
    }

    @NotNull
    private aya b(int n, int n2, int n3, int n4, int n5) {
        String string = ms.i(n3, n4, n5);
        ayc ayc2 = this.k(n, n2);
        aya aya2 = ayc2.dU(string);
        if (aya2 != null) {
            return aya2;
        }
        aya2 = aya.wk().aU(0);
        this.BX.set(true);
        ayc2.a(string, aya2);
        return aya2;
    }

    @NotNull
    private aya aj(Block block) {
        return this.b(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    public boolean d(Chunk chunk, int n, int n2, int n3) {
        return this.c(chunk.getX(), chunk.getZ(), n, n2, n3);
    }

    public boolean c(int n, int n2, int n3, int n4, int n5) {
        ayc ayc2 = this.j(n, n2);
        if (ayc2 == null) {
            return false;
        }
        return ayc2.dT(ms.i(n3, n4, n5));
    }

    public boolean T(Block block) {
        return this.c(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    @Nullable
    private axy ak(Block block) {
        aya aya2 = this.ai(block);
        if (aya2 == null) {
            return null;
        }
        return aya2.wo();
    }

    private axy al(Block block) {
        return this.d(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    private axy d(int n, int n2, int n3, int n4, int n5) {
        aya aya2 = this.b(n, n2, n3, n4, n5);
        axy axy2 = aya2.wo();
        if (axy2 != null) {
            return axy2;
        }
        axy2 = axy.vE();
        this.BX.set(true);
        aya2.b(axy2);
        return axy2;
    }

    @Nullable
    public List U(Block block) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        ayi ayi2 = this.W(block);
        if (ayi2 == null) {
            return null;
        }
        if (ayi2.wV() != null && ayi2.wV().size() > 0) {
            for (String string : ayi2.wV()) {
                arrayList.add(NItem.compoundStrToBukkitItem((String)string));
            }
        }
        return arrayList;
    }

    @Nullable
    public ItemStack V(Block block) {
        ayi ayi2 = this.W(block);
        if (ayi2 == null) {
            return null;
        }
        if (ayi2.wV() != null && ayi2.wV().size() > 0) {
            return NItem.compoundStrToBukkitItem((String)((String)ayi2.wV().get(0)));
        }
        return null;
    }

    @Nullable
    ayi W(Block block) {
        aya aya2 = this.ai(block);
        if (aya2 == null) {
            return null;
        }
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return null;
        }
        return axy2.vF();
    }

    public boolean X(Block block) {
        aya aya2 = this.ai(block);
        if (aya2 == null) {
            return false;
        }
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return false;
        }
        return axy2.vH();
    }

    public boolean isCustomBlock(Block block) {
        return this.G(block.getLocation());
    }

    public boolean F(Location location) {
        if (this.E(location) != null) {
            return true;
        }
        aya aya2 = this.I(location);
        if (aya2 == null) {
            return false;
        }
        return aya2.wl() > 0;
    }

    public boolean G(Location location) {
        if (this.E(location) != null) {
            return true;
        }
        aya aya2 = this.J(location);
        if (aya2 == null) {
            return false;
        }
        return aya2.wl() > 0;
    }

    @Nullable
    public String E(Location location) {
        String string;
        if (Main.rS().Pw && d.g().T.containsKey(string = abk.tl().bb(location.getBlock()))) {
            return string;
        }
        return null;
    }

    @Nullable
    public String e(int n, int n2, int n3, int n4, int n5) {
        aya aya2 = this.a(n4, n5, n, n2, n3);
        if (aya2 == null) {
            return null;
        }
        int n6 = aya2.wl();
        if (n6 == 0) {
            return null;
        }
        return this.a(this.j(n4, n5), n6);
    }

    @Nullable
    public String a(int n, int n2, int n3, Chunk chunk) {
        return this.e(n, n2, n3, chunk.getX(), chunk.getZ());
    }

    @Nullable
    public String Y(Block block) {
        String string = this.E(block.getLocation());
        if (string != null) {
            return string;
        }
        return this.e(block.getX(), block.getY(), block.getZ(), block.getX() >> 4, block.getZ() >> 4);
    }

    @Nullable
    public String H(Location location) {
        String string = this.E(location);
        if (string != null) {
            return string;
        }
        return this.e(location.getBlockX(), location.getBlockY(), location.getBlockZ(), location.getBlockX() >> 4, location.getBlockZ() >> 4);
    }

    @Nullable
    private String a(@NotNull ayc ayc2, mr mr2, int n) {
        ayk ayk2;
        if (mr2 == mr.BLOCKS) {
            ayk2 = ayc2.ww();
        } else if (mr2 == mr.BIOMES) {
            ayk2 = ayc2.wz();
        } else if (mr2 == mr.CROPS_SEEDS) {
            ayk2 = ayc2.wC();
        } else {
            throw new RuntimeException("Unknown palette! " + String.valueOf((Object)mr2));
        }
        if (ayk2 != null) {
            return ayk2.L(n);
        }
        return null;
    }

    @Nullable
    private String a(@NotNull ayc ayc2, int n) {
        return this.a(ayc2, mr.BLOCKS, n);
    }

    private int a(ayc ayc2, String string) {
        return this.a(ayc2, mr.BLOCKS, string);
    }

    private int a(ayc ayc2, mr mr2, String string) {
        Integer n;
        ayk ayk2;
        if (mr2 == mr.BLOCKS) {
            ayk2 = ayc2.ww();
        } else if (mr2 == mr.BIOMES) {
            ayk2 = ayc2.wz();
        } else if (mr2 == mr.CROPS_SEEDS) {
            ayk2 = ayc2.wC();
        } else {
            throw new RuntimeException("Unknown palette! " + String.valueOf((Object)mr2));
        }
        if (ayk2 == null) {
            n = 1;
            ayk2 = ayk.wZ();
            this.a(mr2, ayk2, n, string, ayc2);
        } else {
            n = (Integer)bcn.b(ayk2.xa(), (Object)string);
            for (Map.Entry entry : ayk2.xa().entrySet()) {
                if (!((String)entry.getValue()).equals(string)) continue;
                n = (Integer)entry.getKey();
                break;
            }
            if (n == null) {
                n = Math.max(1, ayk2.xb() + 1);
                this.a(mr2, ayk2, n, string, null);
            }
        }
        return n;
    }

    private void a(mr mr2, ayk ayk2, Integer n, String string, @Nullable ayc ayc2) {
        this.BX.set(true);
        ayk2.c(n, string);
        if (ayc2 != null) {
            if (mr2 == mr.BLOCKS) {
                ayc2.a(ayk2);
            } else if (mr2 == mr.BIOMES) {
                ayc2.b(ayk2);
            } else if (mr2 == mr.CROPS_SEEDS) {
                ayc2.c(ayk2);
            } else {
                throw new RuntimeException("Unknown palette! " + String.valueOf((Object)mr2));
            }
        }
    }

    @Nullable
    public String Z(Block block) {
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return null;
        }
        return axy2.vR();
    }

    public void a(Block block, String string) {
        this.BX.set(true);
        axy axy2 = this.al(block);
        axy2.dR(string);
    }

    public void a(int n, int n2, int n3, int n4, int n5, String string) {
        this.BX.set(true);
        axy axy2 = this.d(n, n2, n3, n4, n5);
        axy2.dR(string);
    }

    @Nullable
    public String aa(Block block) {
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return null;
        }
        int n = axy2.vI();
        if (n == 0) {
            return null;
        }
        ayc ayc2 = this.j(block.getX() >> 4, block.getZ() >> 4);
        if (ayc2 == null) {
            return null;
        }
        return this.a(ayc2, mr.CROPS_SEEDS, n);
    }

    public void b(Block block, String string) {
        this.BX.set(true);
        ayc ayc2 = this.k(block.getX() >> 4, block.getZ() >> 4);
        int n = this.a(ayc2, mr.CROPS_SEEDS, string);
        axy axy2 = this.al(block);
        axy2.aP(n);
    }

    public void b(int n, int n2, int n3, int n4, int n5, String string) {
        this.BX.set(true);
        ayc ayc2 = this.k(n, n2);
        int n6 = this.a(ayc2, mr.CROPS_SEEDS, string);
        axy axy2 = this.d(n, n2, n3, n4, n5);
        axy2.aP(n6);
    }

    @Nullable
    public String ab(Block block) {
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return null;
        }
        return axy2.vL() ? this.Y(block) : null;
    }

    public void c(Block block, String string) {
        this.e(block, string);
        this.al(block).aJ(true);
    }

    public List p(Chunk chunk) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (!this.o(chunk)) {
            return arrayList;
        }
        ayc ayc2 = this.u(chunk);
        if (ayc2 == null) {
            return arrayList;
        }
        for (Map.Entry entry : ayc2.wu().entrySet()) {
            aya aya2;
            int n;
            axy axy2 = ((aya)entry.getValue()).wo();
            if (axy2 == null || !axy2.vL() || (n = (aya2 = (aya)entry.getValue()).wl()) == 0) continue;
            arrayList.add(this.a(ayc2, n));
        }
        return arrayList;
    }

    @Nullable
    public List getAllBlocksLocationsList(Chunk chunk) {
        if (!this.o(chunk)) {
            return null;
        }
        ayc ayc2 = this.u(chunk);
        if (ayc2 == null) {
            return null;
        }
        ArrayList<Location> arrayList = new ArrayList<Location>();
        for (Map.Entry entry : ayc2.wu().entrySet()) {
            aya aya2 = (aya)entry.getValue();
            int n = aya2.wl();
            if (n == 0) continue;
            arrayList.add(ms.a(this.BO, chunk, (String)entry.getKey()));
        }
        return arrayList;
    }

    @Nullable
    public Map getAllBlocksLocations(Chunk chunk) {
        if (!this.o(chunk)) {
            return null;
        }
        ayc ayc2 = this.u(chunk);
        if (ayc2 == null) {
            return null;
        }
        HashMap<Location, String> hashMap = new HashMap<Location, String>();
        for (Map.Entry entry : ayc2.wu().entrySet()) {
            aya aya2 = (aya)entry.getValue();
            int n = aya2.wl();
            if (n == 0) continue;
            hashMap.put(ms.a(this.BO, chunk, (String)entry.getKey()), this.a(ayc2, n));
        }
        return hashMap;
    }

    public void a(Chunk chunk, BiConsumer biConsumer) {
        if (!this.o(chunk)) {
            return;
        }
        ayc ayc2 = this.u(chunk);
        if (ayc2 == null) {
            return;
        }
        for (Map.Entry entry : ayc2.wu().entrySet()) {
            aya aya2 = (aya)entry.getValue();
            int n = aya2.wl();
            if (n == 0) continue;
            biConsumer.accept(this.a(ayc2, n), ms.a(this.BO, chunk, (String)entry.getKey()));
        }
    }

    @Nullable
    public String ac(Block block) {
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return null;
        }
        int n = axy2.vO();
        if (n == 0) {
            return null;
        }
        ayc ayc2 = this.j(block.getX() >> 4, block.getZ() >> 4);
        if (ayc2 == null) {
            return null;
        }
        return this.a(ayc2, n);
    }

    public void d(Block block, String string) {
        this.c(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ(), string);
    }

    public void c(int n, int n2, int n3, int n4, int n5, String string) {
        this.BX.set(true);
        ayc ayc2 = this.k(n, n2);
        int n6 = this.a(ayc2, string);
        axy axy2 = this.d(n, n2, n3, n4, n5);
        axy2.aQ(n6);
    }

    @Nullable
    public Byte ad(Block block) {
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return null;
        }
        return (byte)axy2.vU();
    }

    public byte b(Block block, byte by) {
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return by;
        }
        return (byte)axy2.vU();
    }

    public void a(Block block, int n) {
        this.BX.set(true);
        axy axy2 = this.al(block);
        axy2.aR(n);
    }

    public void a(int n, int n2, int n3, int n4, int n5, int n6) {
        this.BX.set(true);
        axy axy2 = this.d(n, n2, n3, n4, n5);
        axy2.aR(n6);
    }

    @Nullable
    public Integer ae(Block block) {
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return null;
        }
        return axy2.vX();
    }

    public void b(Block block, int n) {
        this.BX.set(true);
        axy axy2 = this.al(block);
        axy2.aS(n);
    }

    public void b(int n, int n2, int n3, int n4, int n5, int n6) {
        this.BX.set(true);
        axy axy2 = this.d(n, n2, n3, n4, n5);
        axy2.aS(n6);
    }

    public boolean af(Block block) {
        axy axy2 = this.ak(block);
        if (axy2 == null) {
            return false;
        }
        return axy2.wa();
    }

    public void b(Block block, boolean bl) {
        this.a(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ(), bl);
    }

    public void a(int n, int n2, int n3, int n4, int n5, boolean bl) {
        this.BX.set(true);
        axy axy2 = this.d(n, n2, n3, n4, n5);
        axy2.aK(bl);
    }

    public void d(int n, int n2, int n3, int n4, int n5, String string) {
        this.BX.set(true);
        ayc ayc2 = this.k(n, n2);
        int n6 = this.a(ayc2, string);
        aya aya2 = aya.wk().aU(n6);
        ayc2.a(ms.i(n3, n4, n5), aya2);
        d.g().W.a(this.BO, n, n2, n3, n4, n5, string);
    }

    public void a(Chunk chunk, int n, int n2, int n3, String string) {
        this.d(chunk.getX(), chunk.getZ(), n, n2, n3, string);
    }

    public void e(Block block, String string) {
        this.d(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ(), string);
    }

    public void a(Location location, String string) {
        this.d(location.getBlockX() >> 4, location.getBlockZ() >> 4, location.getBlockX(), location.getBlockY(), location.getBlockZ(), string);
    }

    public void e(Chunk chunk, int n, int n2, int n3) {
        this.f(chunk.getX(), chunk.getZ(), n, n2, n3);
    }

    public void f(int n, int n2, int n3, int n4, int n5) {
        ayc ayc2 = this.j(n, n2);
        if (ayc2 == null) {
            return;
        }
        this.BX.set(true);
        ayc2.dV(ms.i(n3, n4, n5));
        d.g().W.a(this.BO, n, n2, n3, n4, n5);
    }

    public void ag(Block block) {
        this.f(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    public void c(Block block, boolean bl) {
        this.a(block, bl, false);
    }

    public void a(Block block, boolean bl, boolean bl2) {
        if (bl) {
            ahd.tN().l(block, bl2);
        }
        this.f(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ());
    }

    public void q(Chunk chunk) {
        ayc ayc2 = this.u(chunk);
        if (ayc2 == null) {
            return;
        }
        this.BX.set(true);
        ayc2.wu().clear();
        d.g().W.b(this.BO, chunk.getX(), chunk.getZ());
    }

    public void a(Block block, List list) {
        this.BX.set(true);
        ayi ayi2 = ayi.wU();
        ayi2.G(new ArrayList());
        for (int i = 0; i < list.size(); ++i) {
            ayi2.wV().add(NItem.bukkitItemToCompoundStr((ItemStack)((ItemStack)list.get(i))));
        }
        this.al(block).a(ayi2);
    }

    public void a(Block block, ItemStack itemStack) {
        this.a(block.getX() >> 4, block.getZ() >> 4, block.getX(), block.getY(), block.getZ(), itemStack);
    }

    public void a(int n, int n2, int n3, int n4, int n5, ItemStack itemStack) {
        this.BX.set(true);
        ayi ayi2 = ayi.wU();
        ayi2.G(new ArrayList());
        ayi2.wV().add(NItem.bukkitItemToCompoundStr((ItemStack)itemStack));
        this.d(n, n2, n3, n4, n5).a(ayi2);
    }

    public void ah(Block block) {
        aya aya2 = this.ai(block);
        if (aya2 == null) {
            return;
        }
        axy axy2 = aya2.wo();
        if (axy2 == null) {
            return;
        }
        this.BX.set(true);
        axy2.vG();
    }

    public static String w(Chunk chunk) {
        return ms.l(chunk.getX(), chunk.getZ());
    }

    public static String l(int n, int n2) {
        return n + "." + n2;
    }

    public static String m(int n, int n2) {
        return (n >> 4) + "." + (n2 >> 4);
    }

    private static String i(int n, int n2, int n3) {
        return (n & 0xF) + "." + n2 + "." + (n3 & 0xF);
    }

    private static Location a(World world, Chunk chunk, String string) {
        int n = string.indexOf(46);
        int n2 = string.lastIndexOf(46);
        int n3 = Integer.parseInt(string.substring(0, n));
        int n4 = Integer.parseInt(string.substring(n + 1, n2));
        int n5 = Integer.parseInt(string.substring(n2 + 1));
        return new Location(world, (double)(chunk.getX() * 16 + n3), (double)n4, (double)(chunk.getZ() * 16 + n5));
    }

    public static int f(World world, int n, int n2) {
        int n3 = 1;
        n3 = 31 * n3 + world.hashCode();
        n3 = 31 * n3 + n;
        n3 = 31 * n3 + n2;
        return n3;
    }

    public static int g(World world, int n, int n2) {
        int n3 = 1;
        n3 = 31 * n3 + world.hashCode();
        n3 = 31 * n3 + (n >> 5);
        n3 = 31 * n3 + (n2 >> 5);
        return n3;
    }

    public static int x(Chunk chunk) {
        return ms.g(chunk.getWorld(), chunk.getX(), chunk.getZ());
    }

    public void save() {
        this.ag(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ag(boolean bl) {
        try {
            long l;
            this.BU.lock();
            if (this.BT != null) {
                this.BT.lW();
            }
            if (this.BY.aBS.isEmpty()) {
                return;
            }
            if (!this.BX.get()) {
                this.BY.aBS.clear();
                return;
            }
            this.BX.set(false);
            bdq bdq2 = new bdq();
            if (ae.dF && ae.dG == 0) {
                bce.log("Saving region " + this.lO());
            }
            this.BY.h(bl, bl);
            if (ae.dF && (l = bdq2.DJ()) >= (long)ae.dG) {
                bce.log("Saved " + this.BY.aBS.size() + " chunks of " + this.BS + " region in " + l + "ms | " + this.lO());
            }
        }
        catch (IOException iOException) {
            bce.error("Failed to save region '" + this.BQ + "," + this.BR + "' | " + this.lO(), iOException);
        }
        finally {
            if (bl) {
                this.lS();
            }
            this.BU.unlock();
        }
    }

    public int lM() {
        int n = 0;
        boolean bl = false;
        Iterator iterator = this.BY.aBS.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String string = (String)entry.getKey();
            if (!this.bj(string)) continue;
            ++n;
            if (!bl) {
                if (ae.dF) {
                    bce.log(String.valueOf(ChatColor.AQUA) + string + " is expired, so I save the whole region " + this.lO());
                }
                this.ag(false);
                bl = true;
            }
            iterator.remove();
            this.bi(string);
            if (!ae.dF) continue;
            bce.log(String.valueOf(ChatColor.GREEN) + "---- " + string + " is expired, removed it from cache " + this.lO());
        }
        return n;
    }

    public mt lN() {
        if (this.lT()) {
            this.ag(true);
            if (ae.dF) {
                bce.log("Unloaded and saved region " + this.lO());
            }
            this.lS();
            return mt.SAVED;
        }
        int n = this.lM();
        if (n > 0 && ae.dF) {
            bce.log("Saved region (" + n + " chunks) " + this.lO());
        }
        return mt.SAVED_CHUNK;
    }

    private int[] bl(String string) {
        String[] stringArray = string.split("\\.");
        return new int[]{Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1])};
    }

    public void r(Chunk chunk) {
        this.bi(ms.w(chunk));
    }

    public void bi(String string) {
        this.BY.jc(string);
    }

    public String lO() {
        return this.BO.getName() + " -> " + this.BY.aBP.getAbsolutePath().replace(this.BO.getWorldFolder().getAbsolutePath(), "");
    }

    public int lP() {
        return this.BY.aBS.size();
    }

    public String lQ() {
        return this.BS;
    }

    public String lR() {
        return FileUtils.byteCountToDisplaySize((long)this.BY.aBP.length());
    }

    public void lS() {
        this.BY.lS();
    }

    public boolean lT() {
        return System.currentTimeMillis() - this.BV > 60000L;
    }

    void lU() {
        this.BV = System.currentTimeMillis();
    }

    public boolean bj(String string) {
        Long l = (Long)this.BW.get(string);
        if (l == null) {
            return false;
        }
        if (System.currentTimeMillis() - l < 60000L) {
            return false;
        }
        int[] nArray = this.bl(string);
        return !this.BO.isChunkLoaded(nArray[0], nArray[1]);
    }

    void bk(String string) {
        this.lU();
        this.BW.put(string, System.currentTimeMillis());
    }
}
