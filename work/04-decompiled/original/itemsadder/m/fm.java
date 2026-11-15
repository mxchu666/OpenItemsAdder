package itemsadder.m;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import itemsadder.m.ae;
import itemsadder.m.d;
import itemsadder.m.fn;
import itemsadder.m.fo;
import itemsadder.m.fp;
import itemsadder.m.fq;
import itemsadder.m.fs;
import itemsadder.m.ft;
import itemsadder.m.mk;
import itemsadder.m.ms;
import itemsadder.m.ql;
import itemsadder.m.sd;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;

public final class fm {
    private static final int tz = Integer.MIN_VALUE;
    static final int[] tA = new int[]{0, 0, 0, 0, -1, 1};
    static final int[] tB = new int[]{-1, 1, 0, 0, 0, 0};
    static final int[] tC = new int[]{0, 0, -1, 1, 0, 0};
    private final Map tD = new HashMap();

    public void a(mk mk2) {
        this.clear();
        if (!ae.cL || d.g().V.hg() == 0) {
            return;
        }
        for (World world : Bukkit.getWorlds()) {
            for (Chunk chunk : world.getLoadedChunks()) {
                ms ms2 = mk2.n(chunk);
                if (ms2 == null) continue;
                this.a(chunk, ms2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Chunk chunk, ms ms2) {
        if (!ae.cL || d.g().V.hg() == 0) {
            return;
        }
        HashMap<Integer, fo> hashMap = new HashMap<Integer, fo>();
        ms2.a(chunk, (T string, U location) -> {
            int n2 = fm.aP(string);
            if (n2 != -1) {
                hashMap.computeIfAbsent(location.getBlockY() >> 4, n -> new fo()).a(fm.g(location.getBlockX(), location.getBlockY(), location.getBlockZ()), n2);
            }
        });
        fm fm2 = this;
        synchronized (fm2) {
            UUID uUID2 = chunk.getWorld().getUID();
            long l = fm.a(chunk.getX(), chunk.getZ());
            if (hashMap.isEmpty()) {
                Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID2);
                if (long2ObjectOpenHashMap == null) {
                    return;
                }
                long2ObjectOpenHashMap.remove(l);
                this.a(uUID2, long2ObjectOpenHashMap);
            } else {
                hashMap.forEach((n, fo2) -> fo2.a(chunk.getWorld(), chunk.getX(), (int)n, chunk.getZ()));
                Long2ObjectOpenHashMap long2ObjectOpenHashMap = this.tD.computeIfAbsent(uUID2, uUID -> new Long2ObjectOpenHashMap());
                long2ObjectOpenHashMap.put(l, (Object)fn.c(hashMap));
            }
        }
        d.g().X.b(chunk.getWorld().getUID(), chunk.getX(), chunk.getZ());
    }

    public void a(World world, int n, int n2, int n3, int n4, int n5, String string) {
        if (!world.isChunkLoaded(n, n2)) {
            return;
        }
        int n6 = fm.aP(string);
        this.a(world.getUID(), n, n2, n4 >> 4, fm.g(n3, n4, n5), n6, (byte)0);
        byte by = this.a(world, n3, n4, n5, n6 != -1 ? Boolean.TRUE : null);
        d.g().X.a(world, n3, n4, n5, n6 == -1 ? -1 : fm.B(n6));
        if (n6 != -1) {
            d.g().X.a(world.getUID(), n3, n4, n5, fm.B(n6), by);
        }
        d.g().X.a(world.getUID(), n3, n5);
    }

    public void a(World world, int n, int n2, int n3, int n4, int n5) {
        this.a(world.getUID(), n, n2, n4 >> 4, fm.g(n3, n4, n5), -1, (byte)0);
        this.a(world, n3, n4, n5, Boolean.FALSE);
        d.g().X.a(world, n3, n4, n5, -1);
        d.g().X.a(world.getUID(), n3, n5);
    }

    public synchronized void b(World world, int n, int n2) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(world.getUID());
        if (long2ObjectOpenHashMap == null) {
            return;
        }
        long2ObjectOpenHashMap.remove(fm.a(n, n2));
        this.a(world.getUID(), long2ObjectOpenHashMap);
        d.g().X.b(world.getUID(), n, n2);
    }

    public synchronized void f(World world) {
        this.tD.remove(world.getUID());
    }

    public synchronized fn c(UUID uUID, int n, int n2) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        return long2ObjectOpenHashMap == null ? null : (fn)long2ObjectOpenHashMap.get(fm.a(n, n2));
    }

    public synchronized boolean a(UUID uUID, int n, int n2, int n3, int n4) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        fn fn2 = long2ObjectOpenHashMap == null ? null : (fn)long2ObjectOpenHashMap.get(fm.a(n >> 4, n3 >> 4));
        return fm.a(fn2, n2 >> 4, fm.g(n, n2, n3), n4);
    }

    static boolean a(fn fn2, int n, short s, int n2) {
        if (n2 <= 0 || fn2 == null) {
            return true;
        }
        fq fq2 = fn2.E(n);
        if (fq2 != null && fq2.a(s) >= 0) {
            return true;
        }
        int n3 = 0;
        for (int i = 0; i < fn2.hL(); ++i) {
            if ((n3 += fn2.D(i).size()) < n2) continue;
            return false;
        }
        return true;
    }

    synchronized ft b(UUID uUID, int n, int n2, int n3, int n4) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        int n5 = n4 - n3 + 1;
        fn[] fnArray = new fn[(n2 - n + 1) * n5];
        if (long2ObjectOpenHashMap != null) {
            for (int i = n; i <= n2; ++i) {
                for (int j = n3; j <= n4; ++j) {
                    fnArray[(i - n) * n5 + j - n3] = (fn)long2ObjectOpenHashMap.get(fm.a(i, j));
                }
            }
        }
        return new ft(n, n3, n5, fnArray);
    }

    synchronized boolean a(UUID uUID, ft ft2) {
        return ft2.a((Long2ObjectOpenHashMap)this.tD.get(uUID));
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
        short s = fm.g(n, n2, n3);
        int n9 = this.a(world.getUID(), n7, n8, n2 >> 4, s);
        if (n9 == -1) {
            return 0;
        }
        byte by = fm.a(world, n, n2, n3, n4, n5, n6, bl);
        fp fp3 = new fp(n7, n8, n2 >> 4);
        map.computeIfAbsent(fp3, fp2 -> new fs()).a(s, by);
        return by;
    }

    private synchronized void a(UUID uUID, Map map) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        if (long2ObjectOpenHashMap == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            fp fp2 = (fp)entry.getKey();
            long l = fm.a(fp2.tL, fp2.tM);
            fn fn2 = (fn)long2ObjectOpenHashMap.get(l);
            if (fn2 == null) continue;
            long2ObjectOpenHashMap.put(l, (Object)fn2.a(fp2.tN, (fs)entry.getValue()));
        }
    }

    private synchronized int a(UUID uUID, int n, int n2, int n3, short s) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        fn fn2 = long2ObjectOpenHashMap == null ? null : (fn)long2ObjectOpenHashMap.get(fm.a(n, n2));
        fq fq2 = fn2 == null ? null : fn2.E(n3);
        return fq2 == null ? -1 : fq2.b(s);
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
        return fm.A(n7);
    }

    static byte A(int n) {
        return (byte)(~n & 0x3F);
    }

    private synchronized void a(UUID uUID, int n, int n2, int n3, short s, int n4, byte by) {
        fn fn2;
        Long2ObjectOpenHashMap long2ObjectOpenHashMap = (Long2ObjectOpenHashMap)this.tD.get(uUID);
        long l = fm.a(n, n2);
        fn fn3 = fn2 = long2ObjectOpenHashMap == null ? null : (fn)long2ObjectOpenHashMap.get(l);
        if (fn2 == null && n4 == -1) {
            return;
        }
        fn fn4 = (fn2 == null ? fn.tE : fn2).a(n3, s, n4, by);
        if (fn4.isEmpty()) {
            long2ObjectOpenHashMap.remove(l);
            this.a(uUID, long2ObjectOpenHashMap);
        } else {
            if (long2ObjectOpenHashMap == null) {
                long2ObjectOpenHashMap = new Long2ObjectOpenHashMap();
                this.tD.put(uUID, long2ObjectOpenHashMap);
            }
            long2ObjectOpenHashMap.put(l, (Object)fn4);
        }
    }

    private void a(UUID uUID, Long2ObjectOpenHashMap long2ObjectOpenHashMap) {
        if (long2ObjectOpenHashMap.isEmpty()) {
            this.tD.remove(uUID);
        }
    }

    private static int aP(String string) {
        ql ql2 = d.g().h(string);
        if (ql2 == null || ql2.Hq != sd.ENTITY) {
            return -1;
        }
        return fm.a(ql2.Fz, d.g().V.s(ql2.Fz));
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
