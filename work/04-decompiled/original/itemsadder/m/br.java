package itemsadder.m;

import com.comphenix.protocol.wrappers.WrappedBlockData;
import dev.lone.itemsadder.Main;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import itemsadder.m.arg;
import itemsadder.m.bcc;
import itemsadder.m.bcp;
import itemsadder.m.bdb;
import itemsadder.m.bm;
import itemsadder.m.bo;
import itemsadder.m.bp;
import itemsadder.m.bq;
import itemsadder.m.bs;
import itemsadder.m.bt;
import itemsadder.m.bu;
import itemsadder.m.bv;
import itemsadder.m.bw;
import itemsadder.m.bx;
import itemsadder.m.ce;
import itemsadder.m.ci;
import itemsadder.m.co;
import itemsadder.m.d;
import itemsadder.m.yp;
import java.lang.invoke.LambdaMetafactory;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class br
implements Listener {
    private final Plugin hf;
    private final NamespacedKey hg;
    private final ConcurrentHashMap hh = new ConcurrentHashMap();
    private final ConcurrentHashMap hi = new ConcurrentHashMap();
    private final ConcurrentHashMap hj = new ConcurrentHashMap();
    private final Map hk = new ConcurrentHashMap();
    private final Map hl = new ConcurrentHashMap();
    private static final WrappedBlockData hm = WrappedBlockData.createData((Material)Material.AIR);
    @NotNull
    private static final BlockData hn = Material.AIR.createBlockData();

    public br(Plugin plugin) {
        this.hf = plugin;
        this.hg = new NamespacedKey(plugin, "ia_crops");
        Bukkit.getPluginManager().registerEvents((Listener)this, plugin);
        this.hk.put((byte)0, Material.WHEAT.createBlockData("[age=0]"));
        this.hk.put((byte)1, Material.WHEAT.createBlockData("[age=1]"));
        this.hk.put((byte)2, Material.WHEAT.createBlockData("[age=2]"));
        this.hk.put((byte)3, Material.WHEAT.createBlockData("[age=3]"));
        this.hk.put((byte)4, Material.WHEAT.createBlockData("[age=4]"));
        this.hk.put((byte)5, Material.WHEAT.createBlockData("[age=5]"));
        this.hk.put((byte)6, Material.WHEAT.createBlockData("[age=6]"));
        this.hk.put((byte)7, Material.WHEAT.createBlockData("[age=7]"));
        this.hk.forEach((by2, blockData) -> this.hl.put(by2, WrappedBlockData.createData((Object)blockData)));
    }

    @Nullable
    public ci z(Player player) {
        ci ci2 = (ci)this.hj.get(player);
        if (ci2 != null) {
            return ci2;
        }
        if (player.isOnline() && !yp.SE) {
            ci2 = new ci(player, ce.iA);
            this.hj.put(player, ci2);
            return ci2;
        }
        return null;
    }

    @Nullable
    public ci A(Player player) {
        return (ci)this.hj.get(player);
    }

    public void B(Player player) {
        ci ci2 = (ci)this.hj.remove(player);
        if (ci2 != null) {
            ci2.cy();
        }
    }

    public bm c(Chunk chunk) {
        bt bt2 = bt.k(chunk);
        return this.hh.computeIfAbsent(bt2, (Function<bt, bw>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, a(org.bukkit.Chunk itemsadder.m.bt ), (Litemsadder/m/bt;)Litemsadder/m/bw;)((br)this, (Chunk)chunk)).hC;
    }

    public bm a(int n, int n2, World world) {
        bt bt2 = new bt(world.getUID(), n, n2);
        return this.hh.computeIfAbsent(bt2, (Function<bt, bw>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, a(org.bukkit.World int int itemsadder.m.bt ), (Litemsadder/m/bt;)Litemsadder/m/bw;)((br)this, (World)world, (int)n, (int)n2)).hC;
    }

    public void d(Chunk chunk) {
        bt bt2 = bt.k(chunk);
        this.hh.remove(bt2);
        chunk.getPersistentDataContainer().remove(this.hg);
    }

    @Nullable
    public bo f(Block block) {
        return this.c(block.getChunk()).c(block.getX() & 0xF, block.getY(), block.getZ() & 0xF);
    }

    public void a(Chunk chunk, int n, int n2, int n3, String string, byte by2) {
        bm bm2 = this.c(chunk);
        bm2.a(n & 0xF, n2, n3 & 0xF, string, by2);
        this.e(chunk);
        Block block = br.c(chunk, n, n2, n3).getBlock();
        this.b(block, string, by2);
    }

    public boolean g(@NotNull Block block) {
        return this.a(block.getX(), block.getY(), block.getZ(), block.getWorld(), true);
    }

    public boolean a(bdb bdb2, Chunk chunk) {
        return this.a(bdb2.ha, bdb2.gW, bdb2.hc, chunk.getWorld(), true);
    }

    public boolean a(int n, int n2, int n3, World world, boolean bl) {
        int n4 = n >> 4;
        int n5 = n3 >> 4;
        int n6 = n & 0xF;
        int n7 = n3 & 0xF;
        bt bt2 = new bt(world.getUID(), n4, n5);
        bw bw2 = (bw)this.hh.get(bt2);
        if (bw2 != null) {
            return bw2.hC.c(n6, n2, n7) != null;
        }
        if (!bl && !world.isChunkLoaded(n4, n5)) {
            return false;
        }
        Chunk chunk = world.getChunkAt(n4, n5);
        bm bm2 = this.i(chunk);
        return bm2.c(n6, n2, n7) != null;
    }

    public boolean a(Chunk chunk, int n, int n2, int n3) {
        bm bm2 = this.c(chunk);
        boolean bl = bm2.b(n & 0xF, n2, n3 & 0xF);
        if (bl) {
            this.e(chunk);
            Location location = br.c(chunk, n, n2, n3);
            for (Player player : bcc.ad(location)) {
                if (co.L(player)) {
                    this.a(player, location, null);
                    continue;
                }
                d.g().v().kQ.G(player);
            }
        }
        return bl;
    }

    public void a(Block block, String string, int n) {
        this.a(block, string, (byte)n);
    }

    public void a(Block block, String string, byte by2) {
        this.a(block.getChunk(), block.getX() & 0xF, block.getY(), block.getZ() & 0xF, string, by2);
    }

    public boolean h(Block block) {
        return this.a(block.getChunk(), block.getX() & 0xF, block.getY(), block.getZ() & 0xF);
    }

    public bo b(Chunk chunk, int n, int n2, int n3) {
        return this.c(chunk).c(n & 0xF, n2, n3 & 0xF);
    }

    public void e(Chunk chunk) {
        bw bw2 = (bw)this.hh.get(bt.k(chunk));
        if (bw2 != null) {
            bw2.ch = true;
        }
    }

    public void f(Chunk chunk) {
        bw bw2 = (bw)this.hh.get(bt.k(chunk));
        if (bw2 == null || !bw2.ch) {
            return;
        }
        this.a(chunk, bw2.hC);
        bw2.ch = false;
        for (Player player : chunk.getWorld().getPlayers()) {
            if (!this.hj.containsKey(player)) continue;
            d.g().v().kQ.a(player, chunk.getX(), chunk.getZ(), chunk.getWorld());
        }
    }

    public void bq() {
        for (Map.Entry player : this.hh.entrySet()) {
            Chunk chunk;
            bt bt2 = (bt)player.getKey();
            bw bw2 = (bw)player.getValue();
            if (!bw2.ch || (chunk = bt2.bt()) == null) continue;
            this.a(chunk, bw2.hC);
            bw2.ch = false;
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            this.B(player);
        }
    }

    public void g(Chunk chunk) {
        bt bt2 = bt.k(chunk);
        this.hh.remove(bt2);
    }

    public int a(Location location, int n, ObjectArrayList objectArrayList) {
        int n2 = location.getBlockX();
        int n3 = location.getBlockZ();
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        this.b(location, n, objectArrayList2);
        return this.a(n2, n3, n, (List)objectArrayList2, objectArrayList);
    }

    public void b(Location location, int n, ObjectArrayList objectArrayList) {
        objectArrayList.clear();
        World world = location.getWorld();
        int n2 = location.getBlockX();
        int n3 = location.getBlockZ();
        int n4 = n2 - n >> 4;
        int n5 = n2 + n >> 4;
        int n6 = n3 - n >> 4;
        int n7 = n3 + n >> 4;
        for (int i = n4; i <= n5; ++i) {
            for (int j = n6; j <= n7; ++j) {
                bm bm2;
                if (!world.isChunkLoaded(i, j) || (bm2 = this.c(world.getChunkAt(i, j))) == null) continue;
                objectArrayList.add((Object)new bu(i, j, bm2.bh()));
            }
        }
    }

    public int a(int n, int n2, int n3, List list, ObjectArrayList objectArrayList) {
        int n4;
        int n5;
        int n6;
        objectArrayList.clear();
        int[] nArray = new int[]{ce.iF, 16, 32, 64, n3};
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        int n7 = n3 * n3;
        for (Object object : list) {
            int n8 = ((bu)object).bo();
            int n9 = ((bu)object).bp();
            for (bp bp2 : ((bu)object).bh().bi()) {
                int n10;
                int n11 = (n8 << 4) + bp2.bl();
                n6 = n11 - n;
                n4 = n6 * n6 + (n5 = (n10 = (n9 << 4) + bp2.bn()) - n2) * n5;
                if (n4 > n7) continue;
                objectArrayList2.add((Object)new bq(n11, bp2.bm(), n10, bp2.bj(), bp2.bk()));
            }
        }
        Object object = false;
        for (Object object2 : (Object)nArray) {
            reference var14_17 = object2 * object2;
            for (bq bq2 : objectArrayList2) {
                n6 = bq2.bo() - n;
                n4 = n6 * n6 + (n5 = bq2.bp() - n2) * n5;
                if (n4 < object || n4 > var14_17) continue;
                objectArrayList.add((Object)bq2);
            }
            object = var14_17;
        }
        return objectArrayList.size();
    }

    public void a(BiConsumer biConsumer) {
        for (Map.Entry entry : this.hh.entrySet()) {
            Chunk chunk = ((bt)entry.getKey()).bt();
            if (chunk == null) continue;
            biConsumer.accept(chunk, ((bw)entry.getValue()).hC);
        }
    }

    public void a(Consumer consumer) {
        for (Map.Entry entry : this.hh.entrySet()) {
            bt bt2 = (bt)entry.getKey();
            Chunk chunk = bt2.bt();
            if (chunk == null) continue;
            bw bw2 = (bw)entry.getValue();
            int n = this.hi.getOrDefault(bt2, 0);
            consumer.accept(new bs(bt2, n, bw2.hC.bh()));
        }
    }

    public void a(bt bt2, int n, Iterable iterable) {
        int n2 = this.hi.getOrDefault(bt2, 0);
        if (n2 != n) {
            return;
        }
        Chunk chunk = bt2.bt();
        if (chunk == null) {
            return;
        }
        for (bv bv2 : iterable) {
            this.a(chunk, bv2.hx, bv2.hy, bv2.hz, bv2.bj(), bv2.hB);
        }
    }

    public static boolean h(Chunk chunk) {
        return chunk.getPersistentDataContainer().has(new NamespacedKey((Plugin)Main.rS(), "ia_crops"), PersistentDataType.BYTE_ARRAY);
    }

    private bm i(Chunk chunk) {
        byte[] byArray = (byte[])chunk.getPersistentDataContainer().get(this.hg, PersistentDataType.BYTE_ARRAY);
        if (byArray == null) {
            return new bm();
        }
        return bm.b(byArray);
    }

    private void a(Chunk chunk, bm bm2) {
        chunk.getPersistentDataContainer().set(this.hg, PersistentDataType.BYTE_ARRAY, (Object)bm2.bg());
    }

    @EventHandler
    public void a(ChunkLoadEvent chunkLoadEvent) {
        this.j(chunkLoadEvent.getChunk());
    }

    @EventHandler(ignoreCancelled=true)
    public void a(ChunkUnloadEvent chunkUnloadEvent) {
        bt bt2 = bt.k(chunkUnloadEvent.getChunk());
        this.hi.merge(bt2, 1, Integer::sum);
        this.f(chunkUnloadEvent.getChunk());
        this.g(chunkUnloadEvent.getChunk());
    }

    @EventHandler
    public void b(PluginDisableEvent pluginDisableEvent) {
        if (pluginDisableEvent.getPlugin() == this.hf) {
            this.bq();
            this.hh.clear();
        }
    }

    public void j(Chunk chunk) {
        this.c(chunk);
    }

    public void a(Player player, Chunk chunk) {
        if (co.L(player)) {
            arg arg2 = new arg(List.of(player));
            for (bp bp2 : this.c(chunk).bh().bi()) {
                bx bx2 = (bx)d.g().ab.get(bp2.bj());
                if (bx2 == null) continue;
                byte by2 = this.a(bx2, bp2.bk());
                arg2.a(bp2.b(chunk).toVector(), (WrappedBlockData)this.hl.get(by2));
            }
            arg2.uZ();
        } else {
            d.g().v().kQ.G(player);
        }
    }

    public byte a(bx bx2, byte by2) {
        if (bx2.hK <= 0) {
            return 0;
        }
        double d2 = (double)by2 / (double)bx2.hK;
        int n = Math.min(this.hl.size(), Math.max(0, (int)Math.round(d2 * 7.0)));
        return (byte)n;
    }

    public void a(Player player, Location location, @Nullable bo bo2) {
        if (bo2 == null) {
            player.sendBlockChange(location, hn);
            return;
        }
        bx bx2 = (bx)d.g().ab.get(bo2.bj());
        if (bx2 == null) {
            return;
        }
        BlockData blockData = (BlockData)this.hk.get(this.a(bx2, bo2.bk()));
        player.sendBlockChange(location, blockData);
    }

    public void C(Player player) {
        if (!co.L(player)) {
            return;
        }
        arg arg2 = new arg(List.of(player));
        d.g().v().kO.a((T chunk, U bm2) -> {
            Location location = new Location(chunk.getWorld(), (double)((chunk.getX() << 4) + 8), 0.0, (double)((chunk.getZ() << 4) + 8));
            if (player.getLocation().distance(location) > 128.0) {
                return;
            }
            for (bp bp2 : bm2.bh().bi()) {
                arg2.a(bp2.b((Chunk)chunk).toVector(), hm);
            }
        });
        bcp.h(() -> arg2.uZ());
    }

    public void D(Player player) {
        if (co.L(player)) {
            return;
        }
        arg arg2 = new arg(List.of(player));
        d.g().v().kO.a((T chunk, U bm2) -> {
            Location location = new Location(chunk.getWorld(), (double)((chunk.getX() << 4) + 8), 0.0, (double)((chunk.getZ() << 4) + 8));
            if (player.getLocation().distance(location) > 128.0) {
                return;
            }
            for (bp bp2 : bm2.bh().bi()) {
                bx bx2 = (bx)d.g().ab.get(bp2.bj());
                if (bx2 == null) continue;
                byte by2 = this.a(bx2, bp2.bk());
                arg2.a(bp2.b((Chunk)chunk).toVector(), (WrappedBlockData)this.hl.get(by2));
            }
        });
        bcp.h(() -> arg2.uZ());
    }

    public void b(Block block, String string, byte by2) {
        Location location = block.getLocation();
        for (Player player : bcc.ad(block.getLocation())) {
            if (co.L(player)) {
                this.a(player, location, new bo(string, by2));
                continue;
            }
            d.g().v().kQ.G(player);
        }
    }

    static long d(int n, int n2, int n3) {
        return (long)(n & 0x3FFFFFF) << 38 | (long)(n3 & 0x3FFFFFF) << 12 | (long)(n2 & 0xFFF);
    }

    static long c(Location location) {
        return br.d(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public static long a(bdb bdb2) {
        return br.d(bdb2.ha, bdb2.gW, bdb2.hc);
    }

    static bdb a(long l) {
        int n = (int)(l >> 38);
        int n2 = (int)(l & 0xFFFL);
        int n3 = (int)(l >> 12 & 0x3FFFFFFL);
        if ((n & 0x2000000) != 0) {
            n |= 0xFC000000;
        }
        if ((n2 & 0x800) != 0) {
            n2 |= 0xFFFFF000;
        }
        if ((n3 & 0x2000000) != 0) {
            n3 |= 0xFC000000;
        }
        return new bdb(n, n2, n3);
    }

    public static Location c(Chunk chunk, int n, int n2, int n3) {
        return new Location(chunk.getWorld(), (double)((chunk.getX() << 4) + (n & 0xF)), (double)n2, (double)((chunk.getZ() << 4) + (n3 & 0xF)));
    }

    public static void a(World world, BoundingBox boundingBox, Location location) {
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 0.5f);
        Vector vector = boundingBox.getMin().subtract(location.toVector());
        Vector vector2 = boundingBox.getMax().subtract(location.toVector());
        Vector[] vectorArray = new Vector[]{new Vector(vector.getX(), vector.getY(), vector.getZ()), new Vector(vector2.getX(), vector.getY(), vector.getZ()), new Vector(vector2.getX(), vector2.getY(), vector.getZ()), new Vector(vector.getX(), vector2.getY(), vector.getZ()), new Vector(vector.getX(), vector.getY(), vector2.getZ()), new Vector(vector2.getX(), vector.getY(), vector2.getZ()), new Vector(vector2.getX(), vector2.getY(), vector2.getZ()), new Vector(vector.getX(), vector2.getY(), vector2.getZ())};
        int n = 20;
        for (int i = 0; i < 4; ++i) {
            br.a(world, vectorArray[i], vectorArray[(i + 1) % 4], location, n, dustOptions);
            br.a(world, vectorArray[i + 4], vectorArray[(i + 1) % 4 + 4], location, n, dustOptions);
            br.a(world, vectorArray[i], vectorArray[i + 4], location, n, dustOptions);
        }
    }

    public static void e(Entity entity) {
        br.a(entity.getWorld(), entity.getBoundingBox(), entity.getLocation());
    }

    public static void a(World world, Vector vector, Vector vector2, Location location, int n, Particle.DustOptions dustOptions) {
        Vector vector3 = vector2.clone().subtract(vector).divide(new Vector(n, n, n));
        for (int i = 0; i <= n; ++i) {
            Vector vector4 = vector.clone().add(vector3.clone().multiply(i));
            Location location2 = location.clone().add(vector4);
            world.spawnParticle(Particle.DUST, location2, 1, (Object)dustOptions);
        }
    }

    private /* synthetic */ bw a(World world, int n, int n2, bt bt2) {
        Chunk chunk = world.getChunkAt(n, n2);
        bm bm2 = this.i(chunk);
        bw bw2 = new bw(bm2);
        bw2.hp = this.hi.getOrDefault(bt2, 0);
        return bw2;
    }

    private /* synthetic */ bw a(Chunk chunk, bt bt2) {
        bm bm2 = this.i(chunk);
        bw bw2 = new bw(bm2);
        bw2.hp = this.hi.getOrDefault(bt2, 0);
        return bw2;
    }
}
