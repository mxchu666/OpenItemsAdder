package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import dev.lone.itemsadder.Main;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import itemsadder.m.ae;
import itemsadder.m.aor;
import itemsadder.m.aot;
import itemsadder.m.aou;
import itemsadder.m.aow;
import itemsadder.m.ap;
import itemsadder.m.arg;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.ey;
import itemsadder.m.ez;
import itemsadder.m.fa;
import itemsadder.m.fd;
import itemsadder.m.fe;
import itemsadder.m.ff;
import itemsadder.m.fg;
import itemsadder.m.fh;
import itemsadder.m.fi;
import itemsadder.m.fj;
import itemsadder.m.fk;
import itemsadder.m.fl;
import itemsadder.m.fm;
import itemsadder.m.fn;
import itemsadder.m.fq;
import itemsadder.m.ft;
import itemsadder.m.zw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public final class fc
implements Listener {
    private static final double rR = Math.cos(Math.toRadians(80.0));
    private static final int rS = Math.max(1, Math.min(4, Runtime.getRuntime().availableProcessors() / 2));
    static final int rT = 64;
    private static final int rU = 32;
    private static final double rV = -4096.0;
    private final fm rW;
    private final fa rX;
    private final Map rY = new ConcurrentHashMap();
    private final Map rZ = new ConcurrentHashMap();
    private final fk sa = new fk();
    private final Map sb = new ConcurrentHashMap();
    private final ConcurrentLinkedQueue sc = new ConcurrentLinkedQueue();
    private final Set sd = ConcurrentHashMap.newKeySet();
    private ExecutorService se;
    private BukkitTask kH;
    private BlockData sf;
    private BlockData[] sg = new BlockData[0];
    private WrappedBlockData sh;
    private WrappedBlockData[] si = new WrappedBlockData[0];
    private boolean registered;
    private volatile int sj;

    public fc(fm fm2, fa fa2) {
        this.rW = fm2;
        this.rX = fa2;
    }

    public void hn() {
        Object object;
        this.bU();
        if (!ae.cL || this.rX.hf() == 0 || !aow.uN().ut()) {
            return;
        }
        this.sf = Material.BARRIER.createBlockData();
        this.sh = WrappedBlockData.createData((Object)this.sf);
        this.sg = new BlockData[this.rX.hg()];
        this.si = new WrappedBlockData[this.rX.hg()];
        for (int i = 0; i < this.rX.hg(); ++i) {
            object = this.rX.t(i).createBlockData();
            this.sg[i] = object;
            this.si[i] = WrappedBlockData.createData((Object)object);
        }
        ++this.sj;
        AtomicInteger atomicInteger = new AtomicInteger();
        object = new ThreadPoolExecutor(rS, rS, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(Math.max(1, Bukkit.getMaxPlayers())), runnable -> {
            Thread thread = new Thread(runnable, "ItemsAdder-Entity-Blocks-" + atomicInteger.incrementAndGet());
            thread.setDaemon(true);
            return thread;
        }, new ThreadPoolExecutor.AbortPolicy());
        ((ThreadPoolExecutor)object).prestartAllCoreThreads();
        this.se = object;
        if (!this.registered) {
            bev.b(this, (Plugin)Main.rS());
            this.registered = true;
        }
        aow.a((PacketListener)new fd(this, (Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Server.MAP_CHUNK));
        int n = this.sj;
        bcp.c(() -> {
            if (this.sj == n && this.se != null) {
                Bukkit.getOnlinePlayers().forEach(this::ai);
            }
        }, 1L);
        this.kH = bcp.c(bukkitRunnable -> this.bV(), 1L, 1L);
    }

    public void bU() {
        ++this.sj;
        if (this.kH != null) {
            this.kH.cancel();
            this.kH = null;
        }
        if (this.registered) {
            bev.b(this);
            this.registered = false;
        }
        aow.l(this);
        if (this.sh != null) {
            Bukkit.getOnlinePlayers().forEach(this::aj);
        }
        for (fj fj2 : this.rY.values()) {
            Player player = Bukkit.getPlayer((UUID)fj2.sL);
            if (player != null) {
                this.a(player, fj2.sM);
            }
            ++fj2.sT;
        }
        this.rY.clear();
        this.rZ.clear();
        this.sa.clear();
        this.sb.clear();
        ExecutorService executorService = this.se;
        this.se = null;
        if (executorService != null) {
            executorService.shutdownNow();
            try {
                executorService.awaitTermination(1L, TimeUnit.SECONDS);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        this.sc.clear();
        this.sd.clear();
        this.sf = null;
        this.sg = new BlockData[0];
        this.sh = null;
        this.si = new WrappedBlockData[0];
    }

    public void a(UUID uUID, int n, int n2) {
        int n3 = ae.cM + 16;
        double d = (double)n3 * (double)n3;
        int n4 = fc.f((double)n + 0.5 - (double)n3);
        int n5 = fc.f((double)n + 0.5 + (double)n3);
        int n6 = fc.f((double)n2 + 0.5 - (double)n3);
        int n7 = fc.f((double)n2 + 0.5 + (double)n3);
        for (int i = n4; i <= n5; ++i) {
            for (int j = n6; j <= n7; ++j) {
                for (fj fj2 : this.sa.a(uUID, fc.c(i, j))) {
                    double d2;
                    double d3;
                    if (!uUID.equals(fj2.hr) || !((d3 = fj2.jO - (double)n - 0.5) * d3 + (d2 = fj2.jQ - (double)n2 - 0.5) * d2 <= d)) continue;
                    fj2.sO.set(true);
                    fj2.sN.set(true);
                }
            }
        }
    }

    public void b(UUID uUID, int n, int n2) {
        this.a(uUID, (n << 4) + 8, (n2 << 4) + 8);
    }

    void a(World world, int n, int n2, int n3, int n4) {
        if (this.se == null || !world.isChunkLoaded(n >> 4, n3 >> 4)) {
            return;
        }
        boolean bl = n4 >= 0;
        long l = ez.f(n, n2, n3);
        int n5 = n >> 4;
        int n6 = n3 >> 4;
        int n7 = Bukkit.getServer().getViewDistance() + 1;
        Location location = new Location(world, (double)n, (double)n2, (double)n3);
        BlockData blockData = bl ? null : world.getBlockAt(n, n2, n3).getBlockData();
        for (Player player : world.getPlayers()) {
            boolean bl2;
            Location location2 = player.getLocation();
            if (Math.abs((location2.getBlockX() >> 4) - n5) > n7 || Math.abs((location2.getBlockZ() >> 4) - n6) > n7) continue;
            fj fj2 = (fj)this.rY.get(player.getUniqueId());
            boolean bl3 = bl2 = fj2 != null && world.getUID().equals(fj2.hr) && fj2.sM.tr.contains(l);
            if (!bl && fj2 != null) {
                fj2.sM.tr.remove(l);
                fj2.sM.ts.remove(l);
            }
            player.sendBlockChange(location, bl ? (bl2 ? this.sf : this.sg[n4]) : blockData);
        }
    }

    private void a(Player player, UUID uUID, int n, int n2) {
        if (this.se == null || !player.isOnline()) {
            return;
        }
        World world = player.getWorld();
        if (!world.getUID().equals(uUID) || !world.isChunkLoaded(n, n2)) {
            return;
        }
        fn fn2 = this.rW.c(world.getUID(), n, n2);
        if (fn2 == null) {
            return;
        }
        fj fj2 = (fj)this.rY.get(player.getUniqueId());
        LongOpenHashSet longOpenHashSet = fj2 != null && world.getUID().equals(fj2.hr) ? fj2.sM.tr : null;
        arg arg2 = new arg(List.of(player));
        this.a(arg2, fn2, n, n2, true, longOpenHashSet);
        arg2.uZ();
    }

    private void ai(Player player) {
        this.a(player, true, true);
    }

    private void aj(Player player) {
        this.a(player, false, false);
    }

    private void a(Player player, boolean bl, boolean bl2) {
        if (!player.isOnline()) {
            return;
        }
        Location location = player.getLocation();
        int n = location.getBlockX() >> 4;
        int n2 = location.getBlockZ() >> 4;
        int n3 = Bukkit.getServer().getViewDistance();
        ft ft2 = this.rW.b(player.getWorld().getUID(), n - n3, n + n3, n2 - n3, n2 + n3);
        fj fj2 = (fj)this.rY.get(player.getUniqueId());
        LongOpenHashSet longOpenHashSet = bl2 && fj2 != null && player.getWorld().getUID().equals(fj2.hr) ? fj2.sM.tr : null;
        arg arg2 = new arg(List.of(player));
        for (int i = 0; i < ft2.hT(); ++i) {
            fn fn2 = ft2.M(i);
            if (fn2 == null) continue;
            this.a(arg2, fn2, ft2.N(i), ft2.O(i), bl, longOpenHashSet);
        }
        arg2.uZ();
    }

    private void a(arg arg2, fn fn2, int n, int n2, boolean bl, LongOpenHashSet longOpenHashSet) {
        for (int i = 0; i < fn2.hL(); ++i) {
            int n3 = fn2.C(i);
            fq fq2 = fn2.D(i);
            for (int j = 0; j < fq2.size(); ++j) {
                int n4 = fq2.F(j) & 0xFFF;
                int n5 = n << 4 | n4 & 0xF;
                int n6 = n3 << 4 | n4 >>> 8;
                int n7 = n2 << 4 | n4 >>> 4 & 0xF;
                long l = ez.f(n5, n6, n7);
                arg2.a(n5, n6, n7, !bl || longOpenHashSet != null && longOpenHashSet.contains(l) ? this.sh : this.si[fq2.G(j)]);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(UUID uUID, int n, int n2, int n3, int n4, byte by) {
        if (by == 0) {
            return;
        }
        long l = ez.f(n, n2, n3);
        int n5 = Bukkit.getCurrentTick();
        int n6 = ae.cM;
        double d = (double)n6 * (double)n6;
        int n7 = fc.f((double)n + 0.5 - (double)n6);
        int n8 = fc.f((double)n + 0.5 + (double)n6);
        int n9 = fc.f((double)n3 + 0.5 - (double)n6);
        int n10 = fc.f((double)n3 + 0.5 + (double)n6);
        ff ff2 = (ff)this.sb.get(uUID);
        fe fe2 = ff2 == null ? fe.sn : ff2.hs();
        for (int i = n7; i <= n8; ++i) {
            for (int j = n9; j <= n10; ++j) {
                for (fj fj2 : this.sa.a(uUID, fc.c(i, j))) {
                    Player player;
                    double d2;
                    double d3;
                    if (!uUID.equals(fj2.hr) || (d3 = fj2.jO - (double)n - 0.5) * d3 + (d2 = fj2.jQ - (double)n3 - 0.5) * d2 > d || (player = Bukkit.getPlayer((UUID)fj2.sL)) == null || !player.isOnline() || !fj2.sP.compareAndSet(false, true)) continue;
                    try {
                        Location location = player.getEyeLocation();
                        Vector vector = location.getDirection();
                        if (ey.a(l, by, location.getX(), location.getY(), location.getZ(), vector.getX(), vector.getZ(), (double)n6 * (double)n6, rR) < 0.0) continue;
                        this.a(fj2, uUID, location.getX(), location.getZ());
                        fl fl2 = fj2.sM;
                        synchronized (fl2) {
                            boolean bl;
                            int n11;
                            int n12;
                            int n13;
                            fl fl3;
                            block19: {
                                fl3 = fj2.sM;
                                n13 = this.a(fe2, l, n4, (byte)0);
                                n12 = fl3.g(l);
                                n11 = n12 < 0 ? -1 : fl3.te[n12];
                                bl = n12 >= 0;
                                n12 = fl3.b(l, n13, n5);
                                if (n12 >= 0) break block19;
                                continue;
                            }
                            if (fl3.tr.add(l)) {
                                player.sendBlockChange(new Location(player.getWorld(), (double)n, (double)n2, (double)n3), this.sf);
                            }
                            aot aot2 = this.rX.p(n12);
                            if (bl && fl3.ti[n12]) {
                                if (n11 != n13) {
                                    aow.uN().a(player, aot2.ux(), this.q(n13));
                                }
                            } else if (fl3.ti[n12]) {
                                aow.uN().a(player, aot2.ux(), (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5);
                                aow.uN().a(player, aot2.ux(), this.q(n13));
                            } else {
                                aow.uN().a(player, aot2, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, this.q(n13));
                                fl3.ti[n12] = true;
                            }
                        }
                    }
                    finally {
                        fj2.sP.set(false);
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(UUID uUID, int n, int n2, int n3, int n4, int n5) {
        boolean bl;
        long l = ez.f(n, n2, n3);
        Map map = this.sb;
        synchronized (map) {
            ff ff2 = (ff)this.sb.get(uUID);
            if (ff2 == null) {
                if (n5 < 0) {
                    return;
                }
                ff2 = new ff();
                this.sb.put(uUID, ff2);
            }
            bl = ff2.a(l, n4, n5);
            if (ff2.isEmpty()) {
                this.sb.remove(uUID);
            }
        }
        if (bl) {
            this.a(uUID, n, n3);
        }
    }

    private void bV() {
        this.ho();
        this.hp();
        int n = Bukkit.getCurrentTick();
        int n2 = Math.max(1, ae.cQ);
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!this.y(player)) {
                this.ak(player);
                continue;
            }
            fj fj2 = this.rY.computeIfAbsent(player.getUniqueId(), uUID -> {
                fj fj2 = new fj(player, this.rX.hf(), ae.cN);
                Location location = player.getEyeLocation();
                this.a(fj2, fj2.hr, location.getX(), location.getZ());
                return fj2;
            });
            if (n >= fj2.sU) {
                fj2.sN.set(true);
            }
            if (!fj2.hr.equals(player.getWorld().getUID())) {
                this.a(player, fj2);
                fj2.hr = player.getWorld().getUID();
                Location location = player.getEyeLocation();
                this.a(fj2, fj2.hr, location.getX(), location.getZ());
            }
            if (!fj2.sN.get() || !fj2.sO.get() && Math.floorMod(player.getUniqueId().hashCode(), n2) != n % n2 || !fj2.sP.compareAndSet(false, true)) continue;
            if (!fj2.sN.compareAndSet(true, false)) {
                fj2.sP.set(false);
                continue;
            }
            fj2.sO.set(false);
            this.a(player, fj2, n);
        }
    }

    private void ho() {
        fh fh2;
        while ((fh2 = (fh)this.sc.poll()) != null) {
            try {
                this.a(fh2.sD, fh2.sE, fh2.sF);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                fh2.sF.sN.set(true);
                fh2.sF.sP.set(false);
            }
        }
    }

    private void hp() {
        for (fi fi2 : this.sd) {
            Player player;
            if (!this.sd.remove(fi2) || fi2.hw() != this.sj || (player = Bukkit.getPlayer((UUID)fi2.hu())) == null) continue;
            this.a(player, fi2.bu(), fi2.hG(), fi2.hH());
        }
    }

    private void a(Player player, fj fj2, int n) {
        Location location = player.getEyeLocation();
        Vector vector = location.getDirection();
        this.a(fj2, fj2.hr, location.getX(), location.getZ());
        fj2.w(location);
        int n2 = ae.cM;
        int n3 = n2 + 15 >> 4;
        int n4 = location.getBlockX() >> 4;
        int n5 = location.getBlockZ() >> 4;
        fg fg2 = new fg(player.getUniqueId(), fj2.hr, fj2.sT, this.sj, n, location.getX(), location.getY(), location.getZ(), vector.getX(), vector.getZ(), n4, n5, n3);
        ExecutorService executorService = this.se;
        if (executorService == null) {
            fj2.sN.set(true);
            fj2.sP.set(false);
            return;
        }
        try {
            executorService.execute(() -> this.a(fj2, fg2));
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            fj2.sN.set(true);
            fj2.sP.set(false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(fj fj2, fg fg2) {
        if (fj2.sT != fg2.ss || this.sj != fg2.st) {
            fj2.sN.set(true);
            fj2.sP.set(false);
            return;
        }
        try {
            ft ft2 = this.rW.b(fg2.sr, fg2.sA - fg2.sC, fg2.sA + fg2.sC, fg2.sB - fg2.sC, fg2.sB + fg2.sC);
            if (fj2.sT != fg2.ss || this.sj != fg2.st || !this.rW.a(fg2.sr, ft2)) {
                fj2.sN.set(true);
                fj2.sP.set(false);
                return;
            }
            ff ff2 = (ff)this.sb.get(fg2.sr);
            fe fe2 = ff2 == null ? fe.sn : ff2.hs();
            fl fl2 = fj2.sM;
            synchronized (fl2) {
                ey.a(ft2, fj2.sM, fg2.sv, fg2.sw, fg2.sx, fg2.sy, fg2.sz, (double)ae.cM * (double)ae.cM, rR);
                fc.a(fj2.sM, fe2.sl);
            }
            this.sc.add(new fh(fg2, ft2, fj2));
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            fj2.sN.set(true);
            fj2.sP.set(false);
        }
    }

    static void a(fl fl2, long[] lArray) {
        int n = fl2.tw;
        block0: for (int i = 0; i < n; ++i) {
            if (fl2.tn[i] == 0) continue;
            long[] lArray2 = lArray;
            int n2 = lArray2.length;
            for (int j = 0; j < n2; ++j) {
                long l = fl2.tl[i];
                long l2 = lArray2[j];
                if (!fc.a(l, fl2.tn[i], l2)) continue;
                int n3 = ez.c(l);
                int n4 = ez.d(l);
                int n5 = ez.e(l);
                int n6 = fl2.tm[i];
                double d = fl2.to[i];
                byte by = fl2.tn[i];
                fl2.tn[i] = 0;
                for (int k = 0; k < 3; ++k) {
                    for (int i2 = 0; i2 < 3; ++i2) {
                        if (i2 == 0 && k == 0) continue;
                        fl2.a(by == 1 ? ez.f(n3 + i2, n4 + k, n5) : ez.f(n3 + i2, n4, n5 + k), n6, (byte)0, d);
                    }
                }
                continue block0;
            }
        }
    }

    private static boolean a(long l, byte by, long l2) {
        int n = ez.c(l2) - ez.c(l);
        int n2 = ez.e(l2) - ez.e(l);
        int n3 = ez.d(l2) - ez.d(l);
        return switch (by) {
            case 1 -> {
                if (n >= 0 && n < 3 && n3 >= 0 && n3 < 3 && n2 == 0) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (n >= 0 && n < 3 && n2 >= 0 && n2 < 3 && n3 == 0) {
                    yield true;
                }
                yield false;
            }
            default -> false;
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(fg fg2, ft ft2, fj fj2) {
        Player player = Bukkit.getPlayer((UUID)fg2.sq);
        if (!(player != null && player.isOnline() && this.rY.get(fg2.sq) == fj2 && fj2.sT == fg2.ss && this.sj == fg2.st && player.getWorld().getUID().equals(fg2.sr) && this.rW.a(fg2.sr, ft2))) {
            if (player != null && player.isOnline() && this.rY.get(fg2.sq) == fj2) {
                fj2.sN.set(true);
            }
            fj2.sP.set(false);
            return;
        }
        fl fl2 = fj2.sM;
        synchronized (fl2) {
            if (this.a(player, fj2.sM, ft2, fg2.su, fj2.sQ)) {
                fj2.sN.set(true);
                fj2.sO.set(true);
            }
            fj2.sU = fj2.sM.ty == 0 ? Integer.MAX_VALUE : fg2.su + Math.max(1, ae.cR);
        }
        fj2.sP.set(false);
    }

    private boolean a(Player player, fl fl2, ft ft2, int n, ArrayList arrayList) {
        int n2;
        int n3;
        byte by2;
        long l;
        int n4;
        aor aor2 = aow.uN();
        ff ff2 = (ff)this.sb.get(player.getWorld().getUID());
        fe fe2 = ff2 == null ? fe.sn : ff2.hs();
        arrayList.clear();
        boolean bl = false;
        boolean bl2 = false;
        for (n4 = 0; n4 < fl2.tw; ++n4) {
            int by;
            l = fl2.tl[n4];
            by2 = fl2.tn[n4];
            fl2.tp[n4] = by = fl2.d(l, by2);
            if (by < 0) continue;
            n3 = this.a(fe2, l, fl2.tm[n4], by2);
            int n5 = fl2.te[by];
            fl2.a(by, n3, by2, n);
            if (n5 == n3) continue;
            arrayList.add(new aou(this.rX.p(by), 0.0, 0.0, 0.0, this.q(n3), false, false));
        }
        for (n4 = 0; n4 < fl2.tw; ++n4) {
            int n6;
            l = fl2.tl[n4];
            by2 = fl2.tn[n4];
            if (fl2.tp[n4] >= 0 || (n3 = fl2.a(l, n6 = this.a(fe2, l, fl2.tm[n4], by2), by2, n)) < 0) continue;
            bl2 = true;
            fl2.tp[n4] = n3;
            aot aot2 = this.rX.p(n3);
            double d = fc.a(l, by2);
            double d2 = fc.b(l, by2);
            double d3 = fc.c(l, by2);
            if (fl2.ti[n3]) {
                arrayList.add(new aou(aot2, d, d2, d3, this.q(n6), false, true));
                continue;
            }
            arrayList.add(new aou(aot2, d, d2, d3, this.q(n6), true, false));
            fl2.ti[n3] = true;
        }
        n4 = 0;
        for (n2 = 0; n2 < fl2.tw; ++n2) {
            long l2 = fl2.tl[n2];
            byte by = fl2.tn[n2];
            if (fl2.tp[n2] >= 0) continue;
            while (n4 < fl2.hf() && (!fl2.th[n4] || fl2.w(n4))) {
                ++n4;
            }
            if (n4 == fl2.hf()) break;
            n3 = this.a(fe2, l2, fl2.tm[n2], by);
            int n7 = fl2.a(n4, l2, n3, by, n);
            bl2 = true;
            arrayList.add(new aou(this.rX.p(n4), fc.a(l2, by), fc.b(l2, by), fc.c(l2, by), n7 == n3 ? null : this.q(n3), false, true));
            ++n4;
        }
        for (n2 = 0; n2 < fl2.hf(); ++n2) {
            boolean bl3;
            if (!fl2.th[n2] || fl2.w(n2)) continue;
            aot aot3 = this.rX.p(n2);
            by2 = fc.a(fl2, fl2.td[n2], fl2.tk[n2]) ? 1 : 0;
            if (fc.a(fl2, n2, by2 != 0, bl3 = fc.b(fl2, fl2.td[n2], fl2.tk[n2]))) {
                bl = true;
                continue;
            }
            if (by2 == 0 && !bl3) {
                arrayList.add(new aou(aot3, 0.0, -4096.0, 0.0, this.rX.he(), false, true));
            }
            fl2.e(n2, n);
            bl2 = true;
            if (by2 == 0 && !bl3) continue;
            fl2.f(n2, aot3.ux());
        }
        this.a(fl2, n);
        if (bl2) {
            this.a(player, fl2, ft2);
        }
        if (!arrayList.isEmpty() || fl2.tx > 0) {
            aor2.a(player, arrayList, fl2.tq, fl2.tx);
        }
        arrayList.clear();
        fl2.tx = 0;
        return bl;
    }

    private void a(Player player, fl fl2, ft ft2) {
        long l;
        LongOpenHashSet longOpenHashSet = fl2.ts;
        longOpenHashSet.clear();
        for (int i = 0; i < fl2.hf(); ++i) {
            if (!fl2.th[i]) continue;
            fc.a(longOpenHashSet, fl2.td[i], fl2.tk[i]);
        }
        LongIterator longIterator = longOpenHashSet.iterator();
        while (longIterator.hasNext()) {
            if (fc.a(ft2, longIterator.nextLong())) continue;
            longIterator.remove();
        }
        World world = player.getWorld();
        arg arg2 = null;
        LongIterator longIterator2 = fl2.tr.iterator();
        while (longIterator2.hasNext()) {
            WrappedBlockData wrappedBlockData;
            l = longIterator2.nextLong();
            if (longOpenHashSet.contains(l)) continue;
            int n = ez.c(l);
            int n2 = ez.d(l);
            int n3 = ez.e(l);
            int n4 = fc.b(ft2, l);
            if (n4 < 0) {
                n4 = fc.a(this.rW.c(world.getUID(), n >> 4, n3 >> 4), n, n2, n3);
            }
            if (n4 < 0 && !world.isChunkLoaded(n >> 4, n3 >> 4)) continue;
            WrappedBlockData wrappedBlockData2 = wrappedBlockData = n4 >= 0 ? this.si[n4] : WrappedBlockData.createData((Object)world.getBlockAt(n, n2, n3).getBlockData());
            if (arg2 == null) {
                arg2 = new arg(List.of(player));
            }
            arg2.a(n, n2, n3, wrappedBlockData);
        }
        longIterator = longOpenHashSet.iterator();
        while (longIterator.hasNext()) {
            l = longIterator.nextLong();
            if (fl2.tr.contains(l)) continue;
            if (arg2 == null) {
                arg2 = new arg(List.of(player));
            }
            arg2.a(ez.c(l), ez.d(l), ez.e(l), this.sh);
        }
        if (arg2 != null) {
            arg2.uZ();
        }
        fl2.tr.clear();
        fl2.tr.addAll((LongCollection)longOpenHashSet);
        longOpenHashSet.clear();
    }

    private static boolean a(ft ft2, long l) {
        return fc.b(ft2, l) >= 0;
    }

    private static int b(ft ft2, long l) {
        int n = ez.c(l);
        int n2 = ez.d(l);
        int n3 = ez.e(l);
        return fc.a(ft2.g(n >> 4, n3 >> 4), n, n2, n3);
    }

    private static int a(fn fn2, int n, int n2, int n3) {
        if (fn2 == null) {
            return -1;
        }
        fq fq2 = fn2.E(n2 >> 4);
        return fq2 == null ? -1 : fq2.a(fm.g(n, n2, n3));
    }

    static void a(LongOpenHashSet longOpenHashSet, long l, byte by) {
        if (by == 0) {
            longOpenHashSet.add(l);
            return;
        }
        int n = ez.c(l);
        int n2 = ez.d(l);
        int n3 = ez.e(l);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                longOpenHashSet.add(by == 1 ? ez.f(n + j, n2 + i, n3) : ez.f(n + j, n2, n3 + i));
            }
        }
    }

    static boolean a(fl fl2, long l, byte by) {
        if (by != 0) {
            return false;
        }
        for (int i = 0; i < fl2.tw; ++i) {
            if (fl2.tn[i] == 0 || !fc.a(fl2.tl[i], fl2.tn[i], l)) continue;
            return true;
        }
        return false;
    }

    static boolean b(fl fl2, long l, byte by) {
        if (by == 0) {
            return false;
        }
        int n = ez.c(l);
        int n2 = ez.d(l);
        int n3 = ez.e(l);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                long l2;
                long l3 = l2 = by == 1 ? ez.f(n + j, n2 + i, n3) : ez.f(n + j, n2, n3 + i);
                if (!fl2.e(l2, (byte)0)) continue;
                return true;
            }
        }
        return false;
    }

    static boolean a(fl fl2, int n, boolean bl, boolean bl2) {
        return (bl || bl2) && fl2.x(n);
    }

    private int a(fe fe2, long l, int n, byte by) {
        if (by != 0) {
            return fa.a(n, by);
        }
        return fa.b(n, fe2.f(l));
    }

    private Object q(int n) {
        return this.rX.r(n);
    }

    private static double a(long l, byte by) {
        return (double)ez.c(l) + (by != 0 ? 1.5 : 0.5);
    }

    private static double b(long l, byte by) {
        return (double)ez.d(l) + (by == 1 ? 1.5 : 0.5);
    }

    private static double c(long l, byte by) {
        return (double)ez.e(l) + (by == 2 ? 1.5 : 0.5);
    }

    private void a(fl fl2, int n) {
        int n2 = Math.min(32, Math.max(1, fl2.hf() / 16));
        int n3 = Math.max(0, ae.cR);
        for (int i = 0; i < fl2.hf(); ++i) {
            if (!fl2.ti[i] || fl2.th[i] || fl2.ty <= n2 && n - fl2.tg[i] < n3) continue;
            fl2.f(i, this.rX.p(i).ux());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(Player player, fl fl2) {
        fl fl3 = fl2;
        synchronized (fl3) {
            for (int i = 0; i < fl2.hf(); ++i) {
                if (!fl2.ti[i]) continue;
                fl2.f(i, this.rX.p(i).ux());
            }
            if (fl2.tx > 0) {
                aow.uN().a(player, fl2.tq, fl2.tx);
            }
            fl2.clear();
        }
    }

    private void a(Player player, fj fj2) {
        ++fj2.sT;
        this.a(player, fj2.sM);
        fj2.sN.set(true);
    }

    private boolean y(Player player) {
        return !zw.UQ || this.rZ.computeIfAbsent(player.getUniqueId(), uUID -> ap.y(player)) != false;
    }

    private void a(fj fj2, UUID uUID, double d, double d2) {
        fj2.jO = d;
        fj2.jQ = d2;
        long l = fc.c(fc.f(d), fc.f(d2));
        if (uUID.equals(fj2.sR) && l == fj2.sS) {
            return;
        }
        this.sa.a(uUID, l, fj2);
        if (fj2.sR != null) {
            this.sa.b(fj2.sR, fj2.sS, fj2);
        }
        fj2.sR = uUID;
        fj2.sS = l;
    }

    private void a(fj fj2) {
        if (fj2.sR == null) {
            return;
        }
        this.sa.b(fj2.sR, fj2.sS, fj2);
        fj2.sR = null;
    }

    static int f(double d) {
        return (int)Math.floor(d / 64.0);
    }

    static long c(int n, int n2) {
        return (long)n << 32 ^ (long)n2 & 0xFFFFFFFFL;
    }

    private void ak(Player player) {
        fj fj2 = (fj)this.rY.remove(player.getUniqueId());
        if (fj2 == null) {
            return;
        }
        this.a(fj2);
        ++fj2.sT;
        this.a(player, fj2.sM);
    }

    @EventHandler
    private void a(PlayerMoveEvent playerMoveEvent) {
        fj fj2 = (fj)this.rY.get(playerMoveEvent.getPlayer().getUniqueId());
        if (fj2 != null) {
            Location location = playerMoveEvent.getTo();
            UUID uUID = location.getWorld().getUID();
            if (uUID.equals(fj2.hr)) {
                this.a(fj2, uUID, location.getX(), location.getZ());
            }
            if (fj2.v(location)) {
                fj2.sN.set(true);
            }
        }
    }

    @EventHandler
    private void b(PlayerTeleportEvent playerTeleportEvent) {
        fj fj2 = (fj)this.rY.get(playerTeleportEvent.getPlayer().getUniqueId());
        if (fj2 != null) {
            Location location = playerTeleportEvent.getTo();
            UUID uUID = location.getWorld().getUID();
            if (uUID.equals(fj2.hr)) {
                this.a(fj2, uUID, location.getX(), location.getZ());
            }
            fj2.sN.set(true);
        }
    }

    @EventHandler
    private void a(PlayerRespawnEvent playerRespawnEvent) {
        this.ak(playerRespawnEvent.getPlayer());
    }

    @EventHandler
    private void a(PlayerChangedWorldEvent playerChangedWorldEvent) {
        this.ak(playerChangedWorldEvent.getPlayer());
    }

    @EventHandler
    private void c(PlayerQuitEvent playerQuitEvent) {
        this.ak(playerQuitEvent.getPlayer());
        this.rZ.remove(playerQuitEvent.getPlayer().getUniqueId());
    }
}
