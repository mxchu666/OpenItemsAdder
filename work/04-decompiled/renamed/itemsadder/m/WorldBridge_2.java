package itemsadder.m;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.Builder_5;
import itemsadder.m.InstanceHolder_9;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque120;
import itemsadder.m.RealEnum;
import itemsadder.m.RecordOfValueBuilder_2;
import itemsadder.m.RecordOfValue_18;
import itemsadder.m.WorldBridge_3;
import itemsadder.m.WorldSaveListener;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;

public final class WorldBridge_2 {
    private static final int tz = Integer.MIN_VALUE;
    static final int[] tA = new int[]{0, 0, 0, 0, -1, 1};
    static final int[] tB = new int[]{-1, 1, 0, 0, 0, 0};
    static final int[] tC = new int[]{0, 0, -1, 1, 0, 0};
    private final Map tD = new HashMap();

    public void a(WorldSaveListener worldSaveListener) {
        this.clear();
        if (!MaterialBarColorHolder.cL || ItemStackRegistry.g().V.hg() == 0) {
            return;
        }
        for (World world : Bukkit.getWorlds()) {
            for (Chunk chunk : world.getLoadedChunks()) {
                BlockBridge_9 blockBridge_9 = worldSaveListener.n(chunk);
                if (blockBridge_9 == null) continue;
                this.a(chunk, blockBridge_9);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Chunk chunk, BlockBridge_9 blockBridge_9) {
        if (!MaterialBarColorHolder.cL || ItemStackRegistry.g().V.hg() == 0) {
            return;
        }
        HashMap<Integer, WorldBridge_3> hashMap = new HashMap<Integer, WorldBridge_3>();
        blockBridge_9.a(chunk, (T string, U location) -> {
            int n2 = WorldBridge_2.aP(string);
            if (n2 != -1) {
                hashMap.computeIfAbsent(location.getBlockY() >> 4, n -> new WorldBridge_3()).a(WorldBridge_2.g(location.getBlockX(), location.getBlockY(), location.getBlockZ()), n2);
            }
        });
        WorldBridge_2 worldBridge_2 = this;
        synchronized (worldBridge_2) {
            UUID uUID2 = chunk.getWorld().getUID();
            long l = WorldBridge_2.a(chunk.getX(), chunk.getZ());
            if (hashMap.isEmpty()) {
                Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID2);
                if (long2ObjectOpenHashMap == null) {
                    return;
                }
                long2ObjectOpenHashMap.remove(l);
                this.a(uUID2, long2ObjectOpenHashMap);
            } else {
                hashMap.forEach((n, worldBridge_3) -> worldBridge_3.a(chunk.getWorld(), chunk.getX(), (int)n, chunk.getZ()));
                Long2ObjectOpenHashMap long2ObjectOpenHashMap = this.tD.computeIfAbsent(uUID2, uUID -> new Long2ObjectOpenHashMap());
                long2ObjectOpenHashMap.put(l, (Object)Builder_5.c(hashMap));
            }
        }
        ItemStackRegistry.g().X.b(chunk.getWorld().getUID(), chunk.getX(), chunk.getZ());
    }

    public void a(World world, int n, int n2, int n3, int n4, int n5, String string) {
        if (!world.isChunkLoaded(n, n2)) {
            return;
        }
        int n6 = WorldBridge_2.aP(string);
        this.a(world.getUID(), n, n2, n4 >> 4, WorldBridge_2.g(n3, n4, n5), n6, (byte)0);
        byte by = this.a(world, n3, n4, n5, n6 != -1 ? Boolean.TRUE : null);
        ItemStackRegistry.g().X.a(world, n3, n4, n5, n6 == -1 ? -1 : WorldBridge_2.B(n6));
        if (n6 != -1) {
            ItemStackRegistry.g().X.a(world.getUID(), n3, n4, n5, WorldBridge_2.B(n6), by);
        }
        ItemStackRegistry.g().X.a(world.getUID(), n3, n5);
    }

    public void a(World world, int n, int n2, int n3, int n4, int n5) {
        this.a(world.getUID(), n, n2, n4 >> 4, WorldBridge_2.g(n3, n4, n5), -1, (byte)0);
        this.a(world, n3, n4, n5, Boolean.FALSE);
        ItemStackRegistry.g().X.a(world, n3, n4, n5, -1);
        ItemStackRegistry.g().X.a(world.getUID(), n3, n5);
    }

    public synchronized void b(World world, int n, int n2) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(world.getUID());
        if (long2ObjectOpenHashMap == null) {
            return;
        }
        long2ObjectOpenHashMap.remove(WorldBridge_2.a(n, n2));
        this.a(world.getUID(), long2ObjectOpenHashMap);
        ItemStackRegistry.g().X.b(world.getUID(), n, n2);
    }

    public synchronized void f(World world) {
        this.tD.remove(world.getUID());
    }

    public synchronized Builder_5 c(UUID uUID, int n, int n2) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        return long2ObjectOpenHashMap == null ? null : (Builder_5)long2ObjectOpenHashMap.get(WorldBridge_2.a(n, n2));
    }

    public synchronized boolean a(UUID uUID, int n, int n2, int n3, int n4) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        Builder_5 builder_5 = long2ObjectOpenHashMap == null ? null : (Builder_5)long2ObjectOpenHashMap.get(WorldBridge_2.a(n >> 4, n3 >> 4));
        return WorldBridge_2.a(builder_5, n2 >> 4, WorldBridge_2.g(n, n2, n3), n4);
    }

    static boolean a(Builder_5 builder_5, int n, short s, int n2) {
        if (n2 <= 0 || builder_5 == null) {
            return true;
        }
        RecordOfValueBuilder_2 recordOfValueBuilder_2 = builder_5.E(n);
        if (recordOfValueBuilder_2 != null && recordOfValueBuilder_2.a(s) >= 0) {
            return true;
        }
        int n3 = 0;
        for (int i = 0; i < builder_5.hL(); ++i) {
            if ((n3 += builder_5.D(i).size()) < n2) continue;
            return false;
        }
        return true;
    }

    synchronized InstanceHolder_9 b(UUID uUID, int n, int n2, int n3, int n4) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        int n5 = n4 - n3 + 1;
        Builder_5[] builder_5Array = new Builder_5[(n2 - n + 1) * n5];
        if (long2ObjectOpenHashMap != null) {
            for (int i = n; i <= n2; ++i) {
                for (int j = n3; j <= n4; ++j) {
                    builder_5Array[(i - n) * n5 + j - n3] = (Builder_5)long2ObjectOpenHashMap.get(WorldBridge_2.a(i, j));
                }
            }
        }
        return new InstanceHolder_9(n, n3, n5, builder_5Array);
    }

    synchronized boolean a(UUID uUID, InstanceHolder_9 instanceHolder_9) {
        return instanceHolder_9.a((Long2ObjectOpenHashMap)this.tD.get(uUID));
    }

    public synchronized void clear() {
        this.tD.clear();
    }

    private byte a(World world, int n, int n2, int n3, Boolean bl) {
        HashMap hashMap = new HashMap(4);
        byte by = this.a(world, n, n2, n3, n, n2, n3, bl, hashMap);
        for (int i = 0; i < 6; ++i) {
            this.a(world, n + tA[i], n2 + tB[i], n3 + tC[i], n, n2, n3, bl, hashMap);
        }
        this.a(world.getUID(), hashMap);
        return by;
    }

    private byte a(World world, int n, int n2, int n3, int n4, int n5, int n6, Boolean bl, Map map) {
        int n7 = n >> 4;
        int n8 = n3 >> 4;
        if (!world.isChunkLoaded(n7, n8)) {
            return 0;
        }
        short s = WorldBridge_2.g(n, n2, n3);
        int n9 = this.a(world.getUID(), n7, n8, n2 >> 4, s);
        if (n9 == -1) {
            return 0;
        }
        byte by = WorldBridge_2.a(world, n, n2, n3, n4, n5, n6, bl);
        RecordOfValue_18 recordOfValue_182 = new RecordOfValue_18(n7, n8, n2 >> 4);
        map.computeIfAbsent(recordOfValue_182, recordOfValue_18 -> new Opaque120()).a(s, by);
        return by;
    }

    private synchronized void a(UUID uUID, Map map) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        if (long2ObjectOpenHashMap == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            RecordOfValue_18 recordOfValue_18 = (RecordOfValue_18)entry.getKey();
            long l = WorldBridge_2.a(recordOfValue_18.tL, recordOfValue_18.tM);
            Builder_5 builder_5 = (Builder_5)long2ObjectOpenHashMap.get(l);
            if (builder_5 == null) continue;
            long2ObjectOpenHashMap.put(l, (Object)builder_5.a(recordOfValue_18.tN, (Opaque120)entry.getValue()));
        }
    }

    private synchronized int a(UUID uUID, int n, int n2, int n3, short s) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        Builder_5 builder_5 = long2ObjectOpenHashMap == null ? null : (Builder_5)long2ObjectOpenHashMap.get(WorldBridge_2.a(n, n2));
        RecordOfValueBuilder_2 recordOfValueBuilder_2 = builder_5 == null ? null : builder_5.E(n3);
        return recordOfValueBuilder_2 == null ? -1 : recordOfValueBuilder_2.b(s);
    }

    private static byte a(World world, int n, int n2, int n3, int n4, int n5, int n6, Boolean bl) {
        int n7 = 0;
        for (int i = 0; i < 6; ++i) {
            boolean bl2;
            int n8 = n + tA[i];
            int n9 = n2 + tB[i];
            int n10 = n3 + tC[i];
            if (bl != null && n8 == n4 && n9 == n5 && n10 == n6) {
                bl2 = bl;
            } else if (n9 < world.getMinHeight() || n9 >= world.getMaxHeight()) {
                bl2 = false;
            } else {
                int n11 = n8 >> 4;
                int n12 = n10 >> 4;
                boolean bl3 = bl2 = !world.isChunkLoaded(n11, n12) || world.getBlockAt(n8, n9, n10).getType().isOccluding();
            }
            if (!bl2) continue;
            n7 |= 1 << i;
        }
        return WorldBridge_2.A(n7);
    }

    static byte A(int n) {
        return (byte)(~n & 0x3F);
    }

    private synchronized void a(UUID uUID, int n, int n2, int n3, short s, int n4, byte by) {
        Builder_5 builder_5;
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        long l = WorldBridge_2.a(n, n2);
        Builder_5 builder_52 = builder_5 = long2ObjectOpenHashMap == null ? null : (Builder_5)long2ObjectOpenHashMap.get(l);
        if (builder_5 == null && n4 == -1) {
            return;
        }
        Builder_5 builder_53 = (builder_5 == null ? Builder_5.tE : builder_5).a(n3, s, n4, by);
        if (builder_53.isEmpty()) {
            long2ObjectOpenHashMap.remove(l);
            this.a(uUID, long2ObjectOpenHashMap);
        } else {
            if (long2ObjectOpenHashMap == null) {
                long2ObjectOpenHashMap = new Long2ObjectOpenHashMap();
                this.tD.put(uUID, long2ObjectOpenHashMap);
            }
            long2ObjectOpenHashMap.put(l, (Object)builder_53);
        }
    }

    private void a(UUID uUID, Long2ObjectOpenHashMap long2ObjectOpenHashMap) {
        if (long2ObjectOpenHashMap.isEmpty()) {
            this.tD.remove(uUID);
        }
    }

    private static int aP(String string) {
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string);
        if (locationBridgeBuilder_2 == null || locationBridgeBuilder_2.Hq != RealEnum.ENTITY) {
            return -1;
        }
        return WorldBridge_2.a(locationBridgeBuilder_2.Fz, ItemStackRegistry.g().V.s(locationBridgeBuilder_2.Fz));
    }

    static int a(int n, boolean bl) {
        return bl ? n | Integer.MIN_VALUE : n;
    }

    private static int B(int n) {
        return n & Integer.MAX_VALUE;
    }

    private static boolean s(int n) {
        return (n & Integer.MIN_VALUE) != 0;
    }

    static long a(int n, int n2) {
        return (long)n << 32 ^ (long)n2 & 0xFFFFFFFFL;
    }

    static short g(int n, int n2, int n3) {
        return (short)(n & 0xF | (n3 & 0xF) << 4 | (n2 & 0xF) << 8);
    }
}
