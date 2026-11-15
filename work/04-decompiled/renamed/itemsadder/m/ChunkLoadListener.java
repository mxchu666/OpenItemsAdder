package itemsadder.m;

import com.comphenix.protocol.wrappers.WrappedBlockData;
import dev.lone.itemsadder.Main;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import itemsadder.m.BlockBridge_5;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.IareloadCommand;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_7;
import itemsadder.m.PlayerBlockHolder;
import itemsadder.m.PlayerInteractListener;
import itemsadder.m.PlayerToggleSneakListener;
import itemsadder.m.RecordOfString_4;
import itemsadder.m.RecordOfUUID;
import itemsadder.m.RecordOfValue_5;
import itemsadder.m.RecordOfValue_6;
import itemsadder.m.RecordOfValue_7;
import itemsadder.m.RecordOfValue_8;
import itemsadder.m.RecordOfValue_9;
import itemsadder.m.RefBoolIntData;
import itemsadder.m.VectorBridge_3;
import itemsadder.m.WrappedBlockDataHelper;
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

public final class ChunkLoadListener
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

    public ChunkLoadListener(Plugin plugin) {
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
        this.hk.forEach((by, blockData) -> this.hl.put(by, WrappedBlockData.createData((Object)blockData)));
    }

    @Nullable
    public PlayerBlockHolder z(Player player) {
        PlayerBlockHolder playerBlockHolder = (PlayerBlockHolder)this.hj.get(player);
        if (playerBlockHolder != null) {
            return playerBlockHolder;
        }
        if (player.isOnline() && !IareloadCommand.SE) {
            playerBlockHolder = new PlayerBlockHolder(player, PlayerToggleSneakListener.iA);
            this.hj.put(player, playerBlockHolder);
            return playerBlockHolder;
        }
        return null;
    }

    @Nullable
    public PlayerBlockHolder A(Player player) {
        return (PlayerBlockHolder)this.hj.get(player);
    }

    public void B(Player player) {
        PlayerBlockHolder playerBlockHolder = (PlayerBlockHolder)this.hj.remove(player);
        if (playerBlockHolder != null) {
            playerBlockHolder.cy();
        }
    }

    public BlockBridge_5 c(Chunk chunk) {
        RecordOfUUID recordOfUUID = RecordOfUUID.k(chunk);
        return this.hh.computeIfAbsent(recordOfUUID, (Function<RecordOfUUID, RefBoolIntData>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, a(org.bukkit.Chunk itemsadder.m.RecordOfUUID ), (Litemsadder/m/RecordOfUUID;)Litemsadder/m/RefBoolIntData;)((ChunkLoadListener)this, (Chunk)chunk)).hC;
    }

    public BlockBridge_5 a(int n, int n2, World world) {
        RecordOfUUID recordOfUUID = new RecordOfUUID(world.getUID(), n, n2);
        return this.hh.computeIfAbsent(recordOfUUID, (Function<RecordOfUUID, RefBoolIntData>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, a(org.bukkit.World int int itemsadder.m.RecordOfUUID ), (Litemsadder/m/RecordOfUUID;)Litemsadder/m/RefBoolIntData;)((ChunkLoadListener)this, (World)world, (int)n, (int)n2)).hC;
    }

    public void d(Chunk chunk) {
        RecordOfUUID recordOfUUID = RecordOfUUID.k(chunk);
        this.hh.remove(recordOfUUID);
        chunk.getPersistentDataContainer().remove(this.hg);
    }

    @Nullable
    public RecordOfString_4 f(Block block) {
        return this.c(block.getChunk()).c(block.getX() & 0xF, block.getY(), block.getZ() & 0xF);
    }

    public void a(Chunk chunk, int n, int n2, int n3, String string, byte by) {
        BlockBridge_5 blockBridge_5 = this.c(chunk);
        blockBridge_5.a(n & 0xF, n2, n3 & 0xF, string, by);
        this.e(chunk);
        Block block = ChunkLoadListener.c(chunk, n, n2, n3).getBlock();
        this.b(block, string, by);
    }

    public boolean g(@NotNull Block block) {
        return this.a(block.getX(), block.getY(), block.getZ(), block.getWorld(), true);
    }

    public boolean a(VectorBridge_3 vectorBridge_3, Chunk chunk) {
        return this.a(vectorBridge_3.ha, vectorBridge_3.gW, vectorBridge_3.hc, chunk.getWorld(), true);
    }

    public boolean a(int n, int n2, int n3, World world, boolean bl) {
        int n4 = n >> 4;
        int n5 = n3 >> 4;
        int n6 = n & 0xF;
        int n7 = n3 & 0xF;
        RecordOfUUID recordOfUUID = new RecordOfUUID(world.getUID(), n4, n5);
        RefBoolIntData refBoolIntData = (RefBoolIntData)this.hh.get(recordOfUUID);
        if (refBoolIntData != null) {
            return refBoolIntData.hC.c(n6, n2, n7) != null;
        }
        if (!bl && !world.isChunkLoaded(n4, n5)) {
            return false;
        }
        Chunk chunk = world.getChunkAt(n4, n5);
        BlockBridge_5 blockBridge_5 = this.i(chunk);
        return blockBridge_5.c(n6, n2, n7) != null;
    }

    public boolean a(Chunk chunk, int n, int n2, int n3) {
        BlockBridge_5 blockBridge_5 = this.c(chunk);
        boolean bl = blockBridge_5.b(n & 0xF, n2, n3 & 0xF);
        if (bl) {
            this.e(chunk);
            Location location = ChunkLoadListener.c(chunk, n, n2, n3);
            for (Player player : LocationBridge_2.ad(location)) {
                if (PlayerInteractListener.L(player)) {
                    this.a(player, location, null);
                    continue;
                }
                ItemStackRegistry.g().v().kQ.G(player);
            }
        }
        return bl;
    }

    public void a(Block block, String string, int n) {
        this.a(block, string, (byte)n);
    }

    public void a(Block block, String string, byte by) {
        this.a(block.getChunk(), block.getX() & 0xF, block.getY(), block.getZ() & 0xF, string, by);
    }

    public boolean h(Block block) {
        return this.a(block.getChunk(), block.getX() & 0xF, block.getY(), block.getZ() & 0xF);
    }

    public RecordOfString_4 b(Chunk chunk, int n, int n2, int n3) {
        return this.c(chunk).c(n & 0xF, n2, n3 & 0xF);
    }

    public void e(Chunk chunk) {
        RefBoolIntData refBoolIntData = (RefBoolIntData)this.hh.get(RecordOfUUID.k(chunk));
        if (refBoolIntData != null) {
            refBoolIntData.ch = true;
        }
    }

    public void f(Chunk chunk) {
        RefBoolIntData refBoolIntData = (RefBoolIntData)this.hh.get(RecordOfUUID.k(chunk));
        if (refBoolIntData == null || !refBoolIntData.ch) {
            return;
        }
        this.a(chunk, refBoolIntData.hC);
        refBoolIntData.ch = false;
        for (Player player : chunk.getWorld().getPlayers()) {
            if (!this.hj.containsKey(player)) continue;
            ItemStackRegistry.g().v().kQ.a(player, chunk.getX(), chunk.getZ(), chunk.getWorld());
        }
    }

    public void bq() {
        for (Map.Entry player : this.hh.entrySet()) {
            Chunk chunk;
            RecordOfUUID recordOfUUID = (RecordOfUUID)player.getKey();
            RefBoolIntData refBoolIntData = (RefBoolIntData)player.getValue();
            if (!refBoolIntData.ch || (chunk = recordOfUUID.bt()) == null) continue;
            this.a(chunk, refBoolIntData.hC);
            refBoolIntData.ch = false;
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            this.B(player);
        }
    }

    public void g(Chunk chunk) {
        RecordOfUUID recordOfUUID = RecordOfUUID.k(chunk);
        this.hh.remove(recordOfUUID);
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
                BlockBridge_5 blockBridge_5;
                if (!world.isChunkLoaded(i, j) || (blockBridge_5 = this.c(world.getChunkAt(i, j))) == null) continue;
                objectArrayList.add((Object)new RecordOfValue_8(i, j, blockBridge_5.bh()));
            }
        }
    }

    public int a(int n, int n2, int n3, List list, ObjectArrayList objectArrayList) {
        int n4;
        int n5;
        int n6;
        objectArrayList.clear();
        int[] nArray = new int[]{PlayerToggleSneakListener.iF, 16, 32, 64, n3};
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        int n7 = n3 * n3;
        for (Object object : list) {
            int n8 = ((RecordOfValue_8)object).bo();
            int n9 = ((RecordOfValue_8)object).bp();
            for (RecordOfValue_5 recordOfValue_5 : ((RecordOfValue_8)object).bh().bi()) {
                int n10;
                int n11 = (n8 << 4) + recordOfValue_5.bl();
                n6 = n11 - n;
                n4 = n6 * n6 + (n5 = (n10 = (n9 << 4) + recordOfValue_5.bn()) - n2) * n5;
                if (n4 > n7) continue;
                objectArrayList2.add((Object)new RecordOfValue_6(n11, recordOfValue_5.bm(), n10, recordOfValue_5.bj(), recordOfValue_5.bk()));
            }
        }
        Object object = false;
        for (Object object2 : (Object)nArray) {
            reference var14_17 = object2 * object2;
            for (RecordOfValue_6 recordOfValue_6 : objectArrayList2) {
                n6 = recordOfValue_6.bo() - n;
                n4 = n6 * n6 + (n5 = recordOfValue_6.bp() - n2) * n5;
                if (n4 < object || n4 > var14_17) continue;
                objectArrayList.add((Object)recordOfValue_6);
            }
            object = var14_17;
        }
        return objectArrayList.size();
    }

    public void a(BiConsumer biConsumer) {
        for (Map.Entry entry : this.hh.entrySet()) {
            Chunk chunk = ((RecordOfUUID)entry.getKey()).bt();
            if (chunk == null) continue;
            biConsumer.accept(chunk, ((RefBoolIntData)entry.getValue()).hC);
        }
    }

    public void a(Consumer consumer) {
        for (Map.Entry entry : this.hh.entrySet()) {
            RecordOfUUID recordOfUUID = (RecordOfUUID)entry.getKey();
            Chunk chunk = recordOfUUID.bt();
            if (chunk == null) continue;
            RefBoolIntData refBoolIntData = (RefBoolIntData)entry.getValue();
            int n = this.hi.getOrDefault(recordOfUUID, 0);
            consumer.accept(new RecordOfValue_7(recordOfUUID, n, refBoolIntData.hC.bh()));
        }
    }

    public void a(RecordOfUUID recordOfUUID, int n, Iterable iterable) {
        int n2 = this.hi.getOrDefault(recordOfUUID, 0);
        if (n2 != n) {
            return;
        }
        Chunk chunk = recordOfUUID.bt();
        if (chunk == null) {
            return;
        }
        for (RecordOfValue_9 recordOfValue_9 : iterable) {
            this.a(chunk, recordOfValue_9.hx, recordOfValue_9.hy, recordOfValue_9.hz, recordOfValue_9.bj(), recordOfValue_9.hB);
        }
    }

    public static boolean h(Chunk chunk) {
        return chunk.getPersistentDataContainer().has(new NamespacedKey((Plugin)Main.rS(), "ia_crops"), PersistentDataType.BYTE_ARRAY);
    }

    private BlockBridge_5 i(Chunk chunk) {
        byte[] byArray = (byte[])chunk.getPersistentDataContainer().get(this.hg, PersistentDataType.BYTE_ARRAY);
        if (byArray == null) {
            return new BlockBridge_5();
        }
        return BlockBridge_5.b(byArray);
    }

    private void a(Chunk chunk, BlockBridge_5 blockBridge_5) {
        chunk.getPersistentDataContainer().set(this.hg, PersistentDataType.BYTE_ARRAY, (Object)blockBridge_5.bg());
    }

    @EventHandler
    public void a(ChunkLoadEvent chunkLoadEvent) {
        this.j(chunkLoadEvent.getChunk());
    }

    @EventHandler(ignoreCancelled=true)
    public void a(ChunkUnloadEvent chunkUnloadEvent) {
        RecordOfUUID recordOfUUID = RecordOfUUID.k(chunkUnloadEvent.getChunk());
        this.hi.merge(recordOfUUID, 1, Integer::sum);
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
        if (PlayerInteractListener.L(player)) {
            WrappedBlockDataHelper wrappedBlockDataHelper = new WrappedBlockDataHelper(List.of(player));
            for (RecordOfValue_5 recordOfValue_5 : this.c(chunk).bh().bi()) {
                LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfValue_5.bj());
                if (locationBridge_7 == null) continue;
                byte by = this.a(locationBridge_7, recordOfValue_5.bk());
                wrappedBlockDataHelper.a(recordOfValue_5.b(chunk).toVector(), (WrappedBlockData)this.hl.get(by));
            }
            wrappedBlockDataHelper.uZ();
        } else {
            ItemStackRegistry.g().v().kQ.G(player);
        }
    }

    public byte a(LocationBridge_7 locationBridge_7, byte by) {
        if (locationBridge_7.hK <= 0) {
            return 0;
        }
        double d = (double)by / (double)locationBridge_7.hK;
        int n = Math.min(this.hl.size(), Math.max(0, (int)Math.round(d * 7.0)));
        return (byte)n;
    }

    public void a(Player player, Location location, @Nullable RecordOfString_4 recordOfString_4) {
        if (recordOfString_4 == null) {
            player.sendBlockChange(location, hn);
            return;
        }
        LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfString_4.bj());
        if (locationBridge_7 == null) {
            return;
        }
        BlockData blockData = (BlockData)this.hk.get(this.a(locationBridge_7, recordOfString_4.bk()));
        player.sendBlockChange(location, blockData);
    }

    public void C(Player player) {
        if (!PlayerInteractListener.L(player)) {
            return;
        }
        WrappedBlockDataHelper wrappedBlockDataHelper = new WrappedBlockDataHelper(List.of(player));
        ItemStackRegistry.g().v().kO.a((T chunk, U blockBridge_5) -> {
            Location location = new Location(chunk.getWorld(), (double)((chunk.getX() << 4) + 8), 0.0, (double)((chunk.getZ() << 4) + 8));
            if (player.getLocation().distance(location) > 128.0) {
                return;
            }
            for (RecordOfValue_5 recordOfValue_5 : blockBridge_5.bh().bi()) {
                wrappedBlockDataHelper.a(recordOfValue_5.b((Chunk)chunk).toVector(), hm);
            }
        });
        BukkitTaskBridge.h(() -> wrappedBlockDataHelper.uZ());
    }

    public void D(Player player) {
        if (PlayerInteractListener.L(player)) {
            return;
        }
        WrappedBlockDataHelper wrappedBlockDataHelper = new WrappedBlockDataHelper(List.of(player));
        ItemStackRegistry.g().v().kO.a((T chunk, U blockBridge_5) -> {
            Location location = new Location(chunk.getWorld(), (double)((chunk.getX() << 4) + 8), 0.0, (double)((chunk.getZ() << 4) + 8));
            if (player.getLocation().distance(location) > 128.0) {
                return;
            }
            for (RecordOfValue_5 recordOfValue_5 : blockBridge_5.bh().bi()) {
                LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfValue_5.bj());
                if (locationBridge_7 == null) continue;
                byte by = this.a(locationBridge_7, recordOfValue_5.bk());
                wrappedBlockDataHelper.a(recordOfValue_5.b((Chunk)chunk).toVector(), (WrappedBlockData)this.hl.get(by));
            }
        });
        BukkitTaskBridge.h(() -> wrappedBlockDataHelper.uZ());
    }

    public void b(Block block, String string, byte by) {
        Location location = block.getLocation();
        for (Player player : LocationBridge_2.ad(block.getLocation())) {
            if (PlayerInteractListener.L(player)) {
                this.a(player, location, new RecordOfString_4(string, by));
                continue;
            }
            ItemStackRegistry.g().v().kQ.G(player);
        }
    }

    static long d(int n, int n2, int n3) {
        return (long)(n & 0x3FFFFFF) << 38 | (long)(n3 & 0x3FFFFFF) << 12 | (long)(n2 & 0xFFF);
    }

    static long c(Location location) {
        return ChunkLoadListener.d(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public static long a(VectorBridge_3 vectorBridge_3) {
        return ChunkLoadListener.d(vectorBridge_3.ha, vectorBridge_3.gW, vectorBridge_3.hc);
    }

    static VectorBridge_3 a(long l) {
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
        return new VectorBridge_3(n, n2, n3);
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
            ChunkLoadListener.a(world, vectorArray[i], vectorArray[(i + 1) % 4], location, n, dustOptions);
            ChunkLoadListener.a(world, vectorArray[i + 4], vectorArray[(i + 1) % 4 + 4], location, n, dustOptions);
            ChunkLoadListener.a(world, vectorArray[i], vectorArray[i + 4], location, n, dustOptions);
        }
    }

    public static void e(Entity entity) {
        ChunkLoadListener.a(entity.getWorld(), entity.getBoundingBox(), entity.getLocation());
    }

    public static void a(World world, Vector vector, Vector vector2, Location location, int n, Particle.DustOptions dustOptions) {
        Vector vector3 = vector2.clone().subtract(vector).divide(new Vector(n, n, n));
        for (int i = 0; i <= n; ++i) {
            Vector vector4 = vector.clone().add(vector3.clone().multiply(i));
            Location location2 = location.clone().add(vector4);
            world.spawnParticle(Particle.DUST, location2, 1, (Object)dustOptions);
        }
    }

    private /* synthetic */ RefBoolIntData a(World world, int n, int n2, RecordOfUUID recordOfUUID) {
        Chunk chunk = world.getChunkAt(n, n2);
        BlockBridge_5 blockBridge_5 = this.i(chunk);
        RefBoolIntData refBoolIntData = new RefBoolIntData(blockBridge_5);
        refBoolIntData.hp = this.hi.getOrDefault(recordOfUUID, 0);
        return refBoolIntData;
    }

    private /* synthetic */ RefBoolIntData a(Chunk chunk, RecordOfUUID recordOfUUID) {
        BlockBridge_5 blockBridge_5 = this.i(chunk);
        RefBoolIntData refBoolIntData = new RefBoolIntData(blockBridge_5);
        refBoolIntData.hp = this.hi.getOrDefault(recordOfUUID, 0);
        return refBoolIntData;
    }
}
