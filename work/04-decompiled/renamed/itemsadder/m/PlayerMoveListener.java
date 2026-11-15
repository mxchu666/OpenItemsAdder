package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import dev.lone.itemsadder.Main;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import itemsadder.m.Builder_5;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ENTITYBlockViewer;
import itemsadder.m.InstanceHolder_9;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_12;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.MaterialBridge_3;
import itemsadder.m.Opaque115;
import itemsadder.m.Opaque116;
import itemsadder.m.Opaque118;
import itemsadder.m.Opaque119;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_46;
import itemsadder.m.PlayerJoinListener_2;
import itemsadder.m.PlayerWrapper_4;
import itemsadder.m.RecordOfUUID_2;
import itemsadder.m.RecordOfUUID_3;
import itemsadder.m.RecordOfValue;
import itemsadder.m.RecordOfValueBuilder_2;
import itemsadder.m.RecordOfValue_16;
import itemsadder.m.RecordOfValue_17;
import itemsadder.m.RecordOfValue_2;
import itemsadder.m.VersionHelper_3;
import itemsadder.m.WorldBridge_2;
import itemsadder.m.WrappedBlockDataHelper;
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

public final class PlayerMoveListener
implements Listener {
    private static final double rR = Math.cos(Math.toRadians(80.0));
    private static final int rS = Math.max(1, Math.min(4, Runtime.getRuntime().availableProcessors() / 2));
    static final int rT = 64;
    private static final int rU = 32;
    private static final double rV = -4096.0;
    private final WorldBridge_2 rW;
    private final MaterialBridge_3 rX;
    private final Map rY = new ConcurrentHashMap();
    private final Map rZ = new ConcurrentHashMap();
    private final Opaque119 sa = new Opaque119();
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

    public PlayerMoveListener(WorldBridge_2 worldBridge_2, MaterialBridge_3 materialBridge_3) {
        this.rW = worldBridge_2;
        this.rX = materialBridge_3;
    }

    public void hn() {
        Object object;
        this.bU();
        if (!MaterialBarColorHolder.cL || this.rX.hf() == 0 || !PacketListenerRegistry.uN().ut()) {
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
            ListenerBridge.b(this, (Plugin)Main.rS());
            this.registered = true;
        }
        PacketListenerRegistry.a((PacketListener)new PacketListener_46(this, (Plugin)Main.rS(), ListenerPriority.NORMAL, PacketType.Play.Server.MAP_CHUNK));
        int n = this.sj;
        BukkitTaskBridge.c(() -> {
            if (this.sj == n && this.se != null) {
                Bukkit.getOnlinePlayers().forEach(this::ai);
            }
        }, 1L);
        this.kH = BukkitTaskBridge.c(bukkitRunnable -> this.bV(), 1L, 1L);
    }

    public void bU() {
        ++this.sj;
        if (this.kH != null) {
            this.kH.cancel();
            this.kH = null;
        }
        if (this.registered) {
            ListenerBridge.b(this);
            this.registered = false;
        }
        PacketListenerRegistry.l(this);
        if (this.sh != null) {
            Bukkit.getOnlinePlayers().forEach(this::aj);
        }
        for (LocationBridge_12 locationBridge_12 : this.rY.values()) {
            Player player = Bukkit.getPlayer((UUID)locationBridge_12.sL);
            if (player != null) {
                this.a(player, locationBridge_12.sM);
            }
            ++locationBridge_12.sT;
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
        int n3 = MaterialBarColorHolder.cM + 16;
        double d = (double)n3 * (double)n3;
        int n4 = PlayerMoveListener.f((double)n + 0.5 - (double)n3);
        int n5 = PlayerMoveListener.f((double)n + 0.5 + (double)n3);
        int n6 = PlayerMoveListener.f((double)n2 + 0.5 - (double)n3);
        int n7 = PlayerMoveListener.f((double)n2 + 0.5 + (double)n3);
        for (int i = n4; i <= n5; ++i) {
            for (int j = n6; j <= n7; ++j) {
                for (LocationBridge_12 locationBridge_12 : this.sa.a(uUID, PlayerMoveListener.c(i, j))) {
                    double d2;
                    double d3;
                    if (!uUID.equals(locationBridge_12.hr) || !((d3 = locationBridge_12.jO - (double)n - 0.5) * d3 + (d2 = locationBridge_12.jQ - (double)n2 - 0.5) * d2 <= d)) continue;
                    locationBridge_12.sO.set(true);
                    locationBridge_12.sN.set(true);
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
        long l = Opaque116.f(n, n2, n3);
        int n5 = n >> 4;
        int n6 = n3 >> 4;
        int n7 = Bukkit.getServer().getViewDistance() + 1;
        Location location = new Location(world, (double)n, (double)n2, (double)n3);
        BlockData blockData = bl ? null : world.getBlockAt(n, n2, n3).getBlockData();
        for (Player player : world.getPlayers()) {
            boolean bl2;
            Location location2 = player.getLocation();
            if (Math.abs((location2.getBlockX() >> 4) - n5) > n7 || Math.abs((location2.getBlockZ() >> 4) - n6) > n7) continue;
            LocationBridge_12 locationBridge_12 = (LocationBridge_12)this.rY.get(player.getUniqueId());
            boolean bl3 = bl2 = locationBridge_12 != null && world.getUID().equals(locationBridge_12.hr) && locationBridge_12.sM.tr.contains(l);
            if (!bl && locationBridge_12 != null) {
                locationBridge_12.sM.tr.remove(l);
                locationBridge_12.sM.ts.remove(l);
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
        Builder_5 builder_5 = this.rW.c(world.getUID(), n, n2);
        if (builder_5 == null) {
            return;
        }
        LocationBridge_12 locationBridge_12 = (LocationBridge_12)this.rY.get(player.getUniqueId());
        LongOpenHashSet longOpenHashSet = locationBridge_12 != null && world.getUID().equals(locationBridge_12.hr) ? locationBridge_12.sM.tr : null;
        WrappedBlockDataHelper wrappedBlockDataHelper = new WrappedBlockDataHelper(List.of(player));
        this.a(wrappedBlockDataHelper, builder_5, n, n2, true, longOpenHashSet);
        wrappedBlockDataHelper.uZ();
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
        InstanceHolder_9 instanceHolder_9 = this.rW.b(player.getWorld().getUID(), n - n3, n + n3, n2 - n3, n2 + n3);
        LocationBridge_12 locationBridge_12 = (LocationBridge_12)this.rY.get(player.getUniqueId());
        LongOpenHashSet longOpenHashSet = bl2 && locationBridge_12 != null && player.getWorld().getUID().equals(locationBridge_12.hr) ? locationBridge_12.sM.tr : null;
        WrappedBlockDataHelper wrappedBlockDataHelper = new WrappedBlockDataHelper(List.of(player));
        for (int i = 0; i < instanceHolder_9.hT(); ++i) {
            Builder_5 builder_5 = instanceHolder_9.M(i);
            if (builder_5 == null) continue;
            this.a(wrappedBlockDataHelper, builder_5, instanceHolder_9.N(i), instanceHolder_9.O(i), bl, longOpenHashSet);
        }
        wrappedBlockDataHelper.uZ();
    }

    private void a(WrappedBlockDataHelper wrappedBlockDataHelper, Builder_5 builder_5, int n, int n2, boolean bl, LongOpenHashSet longOpenHashSet) {
        for (int i = 0; i < builder_5.hL(); ++i) {
            int n3 = builder_5.C(i);
            RecordOfValueBuilder_2 recordOfValueBuilder_2 = builder_5.D(i);
            for (int j = 0; j < recordOfValueBuilder_2.size(); ++j) {
                int n4 = recordOfValueBuilder_2.F(j) & 0xFFF;
                int n5 = n << 4 | n4 & 0xF;
                int n6 = n3 << 4 | n4 >>> 8;
                int n7 = n2 << 4 | n4 >>> 4 & 0xF;
                long l = Opaque116.f(n5, n6, n7);
                wrappedBlockDataHelper.a(n5, n6, n7, !bl || longOpenHashSet != null && longOpenHashSet.contains(l) ? this.sh : this.si[recordOfValueBuilder_2.G(j)]);
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
        long l = Opaque116.f(n, n2, n3);
        int n5 = Bukkit.getCurrentTick();
        int n6 = MaterialBarColorHolder.cM;
        double d = (double)n6 * (double)n6;
        int n7 = PlayerMoveListener.f((double)n + 0.5 - (double)n6);
        int n8 = PlayerMoveListener.f((double)n + 0.5 + (double)n6);
        int n9 = PlayerMoveListener.f((double)n3 + 0.5 - (double)n6);
        int n10 = PlayerMoveListener.f((double)n3 + 0.5 + (double)n6);
        Opaque118 opaque118 = (Opaque118)this.sb.get(uUID);
        RecordOfValue_16 recordOfValue_16 = opaque118 == null ? RecordOfValue_16.sn : opaque118.hs();
        for (int i = n7; i <= n8; ++i) {
            for (int j = n9; j <= n10; ++j) {
                for (LocationBridge_12 locationBridge_12 : this.sa.a(uUID, PlayerMoveListener.c(i, j))) {
                    Player player;
                    double d2;
                    double d3;
                    if (!uUID.equals(locationBridge_12.hr) || (d3 = locationBridge_12.jO - (double)n - 0.5) * d3 + (d2 = locationBridge_12.jQ - (double)n3 - 0.5) * d2 > d || (player = Bukkit.getPlayer((UUID)locationBridge_12.sL)) == null || !player.isOnline() || !locationBridge_12.sP.compareAndSet(false, true)) continue;
                    try {
                        Location location = player.getEyeLocation();
                        Vector vector = location.getDirection();
                        if (Opaque115.a(l, by, location.getX(), location.getY(), location.getZ(), vector.getX(), vector.getZ(), (double)n6 * (double)n6, rR) < 0.0) continue;
                        this.a(locationBridge_12, uUID, location.getX(), location.getZ());
                        ENTITYBlockViewer eNTITYBlockViewer = locationBridge_12.sM;
                        synchronized (eNTITYBlockViewer) {
                            boolean bl;
                            int n11;
                            int n12;
                            int n13;
                            ENTITYBlockViewer eNTITYBlockViewer2;
                            block19: {
                                eNTITYBlockViewer2 = locationBridge_12.sM;
                                n13 = this.a(recordOfValue_16, l, n4, (byte)0);
                                n12 = eNTITYBlockViewer2.g(l);
                                n11 = n12 < 0 ? -1 : eNTITYBlockViewer2.te[n12];
                                bl = n12 >= 0;
                                n12 = eNTITYBlockViewer2.b(l, n13, n5);
                                if (n12 >= 0) break block19;
                                continue;
                            }
                            if (eNTITYBlockViewer2.tr.add(l)) {
                                player.sendBlockChange(new Location(player.getWorld(), (double)n, (double)n2, (double)n3), this.sf);
                            }
                            RecordOfValue recordOfValue = this.rX.p(n12);
                            if (bl && eNTITYBlockViewer2.ti[n12]) {
                                if (n11 != n13) {
                                    PacketListenerRegistry.uN().a(player, recordOfValue.ux(), this.q(n13));
                                }
                            } else if (eNTITYBlockViewer2.ti[n12]) {
                                PacketListenerRegistry.uN().a(player, recordOfValue.ux(), (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5);
                                PacketListenerRegistry.uN().a(player, recordOfValue.ux(), this.q(n13));
                            } else {
                                PacketListenerRegistry.uN().a(player, recordOfValue, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, this.q(n13));
                                eNTITYBlockViewer2.ti[n12] = true;
                            }
                        }
                    }
                    finally {
                        locationBridge_12.sP.set(false);
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
        long l = Opaque116.f(n, n2, n3);
        Map map = this.sb;
        synchronized (map) {
            Opaque118 opaque118 = (Opaque118)this.sb.get(uUID);
            if (opaque118 == null) {
                if (n5 < 0) {
                    return;
                }
                opaque118 = new Opaque118();
                this.sb.put(uUID, opaque118);
            }
            bl = opaque118.a(l, n4, n5);
            if (opaque118.isEmpty()) {
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
        int n2 = Math.max(1, MaterialBarColorHolder.cQ);
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!this.y(player)) {
                this.ak(player);
                continue;
            }
            LocationBridge_12 locationBridge_12 = this.rY.computeIfAbsent(player.getUniqueId(), uUID -> {
                LocationBridge_12 locationBridge_12 = new LocationBridge_12(player, this.rX.hf(), MaterialBarColorHolder.cN);
                Location location = player.getEyeLocation();
                this.a(locationBridge_12, locationBridge_12.hr, location.getX(), location.getZ());
                return locationBridge_12;
            });
            if (n >= locationBridge_12.sU) {
                locationBridge_12.sN.set(true);
            }
            if (!locationBridge_12.hr.equals(player.getWorld().getUID())) {
                this.a(player, locationBridge_12);
                locationBridge_12.hr = player.getWorld().getUID();
                Location location = player.getEyeLocation();
                this.a(locationBridge_12, locationBridge_12.hr, location.getX(), location.getZ());
            }
            if (!locationBridge_12.sN.get() || !locationBridge_12.sO.get() && Math.floorMod(player.getUniqueId().hashCode(), n2) != n % n2 || !locationBridge_12.sP.compareAndSet(false, true)) continue;
            if (!locationBridge_12.sN.compareAndSet(true, false)) {
                locationBridge_12.sP.set(false);
                continue;
            }
            locationBridge_12.sO.set(false);
            this.a(player, locationBridge_12, n);
        }
    }

    private void ho() {
        RecordOfValue_17 recordOfValue_17;
        while ((recordOfValue_17 = (RecordOfValue_17)this.sc.poll()) != null) {
            try {
                this.a(recordOfValue_17.sD, recordOfValue_17.sE, recordOfValue_17.sF);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                recordOfValue_17.sF.sN.set(true);
                recordOfValue_17.sF.sP.set(false);
            }
        }
    }

    private void hp() {
        for (RecordOfUUID_3 recordOfUUID_3 : this.sd) {
            Player player;
            if (!this.sd.remove(recordOfUUID_3) || recordOfUUID_3.hw() != this.sj || (player = Bukkit.getPlayer((UUID)recordOfUUID_3.hu())) == null) continue;
            this.a(player, recordOfUUID_3.bu(), recordOfUUID_3.hG(), recordOfUUID_3.hH());
        }
    }

    private void a(Player player, LocationBridge_12 locationBridge_12, int n) {
        Location location = player.getEyeLocation();
        Vector vector = location.getDirection();
        this.a(locationBridge_12, locationBridge_12.hr, location.getX(), location.getZ());
        locationBridge_12.w(location);
        int n2 = MaterialBarColorHolder.cM;
        int n3 = n2 + 15 >> 4;
        int n4 = location.getBlockX() >> 4;
        int n5 = location.getBlockZ() >> 4;
        RecordOfUUID_2 recordOfUUID_2 = new RecordOfUUID_2(player.getUniqueId(), locationBridge_12.hr, locationBridge_12.sT, this.sj, n, location.getX(), location.getY(), location.getZ(), vector.getX(), vector.getZ(), n4, n5, n3);
        ExecutorService executorService = this.se;
        if (executorService == null) {
            locationBridge_12.sN.set(true);
            locationBridge_12.sP.set(false);
            return;
        }
        try {
            executorService.execute(() -> this.a(locationBridge_12, recordOfUUID_2));
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            locationBridge_12.sN.set(true);
            locationBridge_12.sP.set(false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(LocationBridge_12 locationBridge_12, RecordOfUUID_2 recordOfUUID_2) {
        if (locationBridge_12.sT != recordOfUUID_2.ss || this.sj != recordOfUUID_2.st) {
            locationBridge_12.sN.set(true);
            locationBridge_12.sP.set(false);
            return;
        }
        try {
            InstanceHolder_9 instanceHolder_9 = this.rW.b(recordOfUUID_2.sr, recordOfUUID_2.sA - recordOfUUID_2.sC, recordOfUUID_2.sA + recordOfUUID_2.sC, recordOfUUID_2.sB - recordOfUUID_2.sC, recordOfUUID_2.sB + recordOfUUID_2.sC);
            if (locationBridge_12.sT != recordOfUUID_2.ss || this.sj != recordOfUUID_2.st || !this.rW.a(recordOfUUID_2.sr, instanceHolder_9)) {
                locationBridge_12.sN.set(true);
                locationBridge_12.sP.set(false);
                return;
            }
            Opaque118 opaque118 = (Opaque118)this.sb.get(recordOfUUID_2.sr);
            RecordOfValue_16 recordOfValue_16 = opaque118 == null ? RecordOfValue_16.sn : opaque118.hs();
            ENTITYBlockViewer eNTITYBlockViewer = locationBridge_12.sM;
            synchronized (eNTITYBlockViewer) {
                Opaque115.a(instanceHolder_9, locationBridge_12.sM, recordOfUUID_2.sv, recordOfUUID_2.sw, recordOfUUID_2.sx, recordOfUUID_2.sy, recordOfUUID_2.sz, (double)MaterialBarColorHolder.cM * (double)MaterialBarColorHolder.cM, rR);
                PlayerMoveListener.a(locationBridge_12.sM, recordOfValue_16.sl);
            }
            this.sc.add(new RecordOfValue_17(recordOfUUID_2, instanceHolder_9, locationBridge_12));
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            locationBridge_12.sN.set(true);
            locationBridge_12.sP.set(false);
        }
    }

    static void a(ENTITYBlockViewer eNTITYBlockViewer, long[] lArray) {
        int n = eNTITYBlockViewer.tw;
        block0: for (int i = 0; i < n; ++i) {
            if (eNTITYBlockViewer.tn[i] == 0) continue;
            long[] lArray2 = lArray;
            int n2 = lArray2.length;
            for (int j = 0; j < n2; ++j) {
                long l = eNTITYBlockViewer.tl[i];
                long l2 = lArray2[j];
                if (!PlayerMoveListener.a(l, eNTITYBlockViewer.tn[i], l2)) continue;
                int n3 = Opaque116.c(l);
                int n4 = Opaque116.d(l);
                int n5 = Opaque116.e(l);
                int n6 = eNTITYBlockViewer.tm[i];
                double d = eNTITYBlockViewer.to[i];
                byte by = eNTITYBlockViewer.tn[i];
                eNTITYBlockViewer.tn[i] = 0;
                for (int k = 0; k < 3; ++k) {
                    for (int i2 = 0; i2 < 3; ++i2) {
                        if (i2 == 0 && k == 0) continue;
                        eNTITYBlockViewer.a(by == 1 ? Opaque116.f(n3 + i2, n4 + k, n5) : Opaque116.f(n3 + i2, n4, n5 + k), n6, (byte)0, d);
                    }
                }
                continue block0;
            }
        }
    }

    private static boolean a(long l, byte by, long l2) {
        int n = Opaque116.c(l2) - Opaque116.c(l);
        int n2 = Opaque116.e(l2) - Opaque116.e(l);
        int n3 = Opaque116.d(l2) - Opaque116.d(l);
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
    private void a(RecordOfUUID_2 recordOfUUID_2, InstanceHolder_9 instanceHolder_9, LocationBridge_12 locationBridge_12) {
        Player player = Bukkit.getPlayer((UUID)recordOfUUID_2.sq);
        if (!(player != null && player.isOnline() && this.rY.get(recordOfUUID_2.sq) == locationBridge_12 && locationBridge_12.sT == recordOfUUID_2.ss && this.sj == recordOfUUID_2.st && player.getWorld().getUID().equals(recordOfUUID_2.sr) && this.rW.a(recordOfUUID_2.sr, instanceHolder_9))) {
            if (player != null && player.isOnline() && this.rY.get(recordOfUUID_2.sq) == locationBridge_12) {
                locationBridge_12.sN.set(true);
            }
            locationBridge_12.sP.set(false);
            return;
        }
        ENTITYBlockViewer eNTITYBlockViewer = locationBridge_12.sM;
        synchronized (eNTITYBlockViewer) {
            if (this.a(player, locationBridge_12.sM, instanceHolder_9, recordOfUUID_2.su, locationBridge_12.sQ)) {
                locationBridge_12.sN.set(true);
                locationBridge_12.sO.set(true);
            }
            locationBridge_12.sU = locationBridge_12.sM.ty == 0 ? Integer.MAX_VALUE : recordOfUUID_2.su + Math.max(1, MaterialBarColorHolder.cR);
        }
        locationBridge_12.sP.set(false);
    }

    private boolean a(Player player, ENTITYBlockViewer eNTITYBlockViewer, InstanceHolder_9 instanceHolder_9, int n, ArrayList arrayList) {
        int n2;
        int n3;
        byte by2;
        long l;
        int n4;
        PlayerWrapper_4 playerWrapper_4 = PacketListenerRegistry.uN();
        Opaque118 opaque118 = (Opaque118)this.sb.get(player.getWorld().getUID());
        RecordOfValue_16 recordOfValue_16 = opaque118 == null ? RecordOfValue_16.sn : opaque118.hs();
        arrayList.clear();
        boolean bl = false;
        boolean bl2 = false;
        for (n4 = 0; n4 < eNTITYBlockViewer.tw; ++n4) {
            int by;
            l = eNTITYBlockViewer.tl[n4];
            by2 = eNTITYBlockViewer.tn[n4];
            eNTITYBlockViewer.tp[n4] = by = eNTITYBlockViewer.d(l, by2);
            if (by < 0) continue;
            n3 = this.a(recordOfValue_16, l, eNTITYBlockViewer.tm[n4], by2);
            int n5 = eNTITYBlockViewer.te[by];
            eNTITYBlockViewer.a(by, n3, by2, n);
            if (n5 == n3) continue;
            arrayList.add(new RecordOfValue_2(this.rX.p(by), 0.0, 0.0, 0.0, this.q(n3), false, false));
        }
        for (n4 = 0; n4 < eNTITYBlockViewer.tw; ++n4) {
            int n6;
            l = eNTITYBlockViewer.tl[n4];
            by2 = eNTITYBlockViewer.tn[n4];
            if (eNTITYBlockViewer.tp[n4] >= 0 || (n3 = eNTITYBlockViewer.a(l, n6 = this.a(recordOfValue_16, l, eNTITYBlockViewer.tm[n4], by2), by2, n)) < 0) continue;
            bl2 = true;
            eNTITYBlockViewer.tp[n4] = n3;
            RecordOfValue recordOfValue = this.rX.p(n3);
            double d = PlayerMoveListener.a(l, by2);
            double d2 = PlayerMoveListener.b(l, by2);
            double d3 = PlayerMoveListener.c(l, by2);
            if (eNTITYBlockViewer.ti[n3]) {
                arrayList.add(new RecordOfValue_2(recordOfValue, d, d2, d3, this.q(n6), false, true));
                continue;
            }
            arrayList.add(new RecordOfValue_2(recordOfValue, d, d2, d3, this.q(n6), true, false));
            eNTITYBlockViewer.ti[n3] = true;
        }
        n4 = 0;
        for (n2 = 0; n2 < eNTITYBlockViewer.tw; ++n2) {
            long l2 = eNTITYBlockViewer.tl[n2];
            byte by = eNTITYBlockViewer.tn[n2];
            if (eNTITYBlockViewer.tp[n2] >= 0) continue;
            while (n4 < eNTITYBlockViewer.hf() && (!eNTITYBlockViewer.th[n4] || eNTITYBlockViewer.w(n4))) {
                ++n4;
            }
            if (n4 == eNTITYBlockViewer.hf()) break;
            n3 = this.a(recordOfValue_16, l2, eNTITYBlockViewer.tm[n2], by);
            int n7 = eNTITYBlockViewer.a(n4, l2, n3, by, n);
            bl2 = true;
            arrayList.add(new RecordOfValue_2(this.rX.p(n4), PlayerMoveListener.a(l2, by), PlayerMoveListener.b(l2, by), PlayerMoveListener.c(l2, by), n7 == n3 ? null : this.q(n3), false, true));
            ++n4;
        }
        for (n2 = 0; n2 < eNTITYBlockViewer.hf(); ++n2) {
            boolean bl3;
            if (!eNTITYBlockViewer.th[n2] || eNTITYBlockViewer.w(n2)) continue;
            RecordOfValue recordOfValue = this.rX.p(n2);
            by2 = PlayerMoveListener.a(eNTITYBlockViewer, eNTITYBlockViewer.td[n2], eNTITYBlockViewer.tk[n2]) ? 1 : 0;
            if (PlayerMoveListener.a(eNTITYBlockViewer, n2, by2 != 0, bl3 = PlayerMoveListener.b(eNTITYBlockViewer, eNTITYBlockViewer.td[n2], eNTITYBlockViewer.tk[n2]))) {
                bl = true;
                continue;
            }
            if (by2 == 0 && !bl3) {
                arrayList.add(new RecordOfValue_2(recordOfValue, 0.0, -4096.0, 0.0, this.rX.he(), false, true));
            }
            eNTITYBlockViewer.e(n2, n);
            bl2 = true;
            if (by2 == 0 && !bl3) continue;
            eNTITYBlockViewer.f(n2, recordOfValue.ux());
        }
        this.a(eNTITYBlockViewer, n);
        if (bl2) {
            this.a(player, eNTITYBlockViewer, instanceHolder_9);
        }
        if (!arrayList.isEmpty() || eNTITYBlockViewer.tx > 0) {
            playerWrapper_4.a(player, arrayList, eNTITYBlockViewer.tq, eNTITYBlockViewer.tx);
        }
        arrayList.clear();
        eNTITYBlockViewer.tx = 0;
        return bl;
    }

    private void a(Player player, ENTITYBlockViewer eNTITYBlockViewer, InstanceHolder_9 instanceHolder_9) {
        long l;
        LongOpenHashSet longOpenHashSet = eNTITYBlockViewer.ts;
        longOpenHashSet.clear();
        for (int i = 0; i < eNTITYBlockViewer.hf(); ++i) {
            if (!eNTITYBlockViewer.th[i]) continue;
            PlayerMoveListener.a(longOpenHashSet, eNTITYBlockViewer.td[i], eNTITYBlockViewer.tk[i]);
        }
        LongIterator longIterator = longOpenHashSet.iterator();
        while (longIterator.hasNext()) {
            if (PlayerMoveListener.a(instanceHolder_9, longIterator.nextLong())) continue;
            longIterator.remove();
        }
        World world = player.getWorld();
        WrappedBlockDataHelper wrappedBlockDataHelper = null;
        LongIterator longIterator2 = eNTITYBlockViewer.tr.iterator();
        while (longIterator2.hasNext()) {
            WrappedBlockData wrappedBlockData;
            l = longIterator2.nextLong();
            if (longOpenHashSet.contains(l)) continue;
            int n = Opaque116.c(l);
            int n2 = Opaque116.d(l);
            int n3 = Opaque116.e(l);
            int n4 = PlayerMoveListener.b(instanceHolder_9, l);
            if (n4 < 0) {
                n4 = PlayerMoveListener.a(this.rW.c(world.getUID(), n >> 4, n3 >> 4), n, n2, n3);
            }
            if (n4 < 0 && !world.isChunkLoaded(n >> 4, n3 >> 4)) continue;
            WrappedBlockData wrappedBlockData2 = wrappedBlockData = n4 >= 0 ? this.si[n4] : WrappedBlockData.createData((Object)world.getBlockAt(n, n2, n3).getBlockData());
            if (wrappedBlockDataHelper == null) {
                wrappedBlockDataHelper = new WrappedBlockDataHelper(List.of(player));
            }
            wrappedBlockDataHelper.a(n, n2, n3, wrappedBlockData);
        }
        longIterator = longOpenHashSet.iterator();
        while (longIterator.hasNext()) {
            l = longIterator.nextLong();
            if (eNTITYBlockViewer.tr.contains(l)) continue;
            if (wrappedBlockDataHelper == null) {
                wrappedBlockDataHelper = new WrappedBlockDataHelper(List.of(player));
            }
            wrappedBlockDataHelper.a(Opaque116.c(l), Opaque116.d(l), Opaque116.e(l), this.sh);
        }
        if (wrappedBlockDataHelper != null) {
            wrappedBlockDataHelper.uZ();
        }
        eNTITYBlockViewer.tr.clear();
        eNTITYBlockViewer.tr.addAll((LongCollection)longOpenHashSet);
        longOpenHashSet.clear();
    }

    private static boolean a(InstanceHolder_9 instanceHolder_9, long l) {
        return PlayerMoveListener.b(instanceHolder_9, l) >= 0;
    }

    private static int b(InstanceHolder_9 instanceHolder_9, long l) {
        int n = Opaque116.c(l);
        int n2 = Opaque116.d(l);
        int n3 = Opaque116.e(l);
        return PlayerMoveListener.a(instanceHolder_9.g(n >> 4, n3 >> 4), n, n2, n3);
    }

    private static int a(Builder_5 builder_5, int n, int n2, int n3) {
        if (builder_5 == null) {
            return -1;
        }
        RecordOfValueBuilder_2 recordOfValueBuilder_2 = builder_5.E(n2 >> 4);
        return recordOfValueBuilder_2 == null ? -1 : recordOfValueBuilder_2.a(WorldBridge_2.g(n, n2, n3));
    }

    static void a(LongOpenHashSet longOpenHashSet, long l, byte by) {
        if (by == 0) {
            longOpenHashSet.add(l);
            return;
        }
        int n = Opaque116.c(l);
        int n2 = Opaque116.d(l);
        int n3 = Opaque116.e(l);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                longOpenHashSet.add(by == 1 ? Opaque116.f(n + j, n2 + i, n3) : Opaque116.f(n + j, n2, n3 + i));
            }
        }
    }

    static boolean a(ENTITYBlockViewer eNTITYBlockViewer, long l, byte by) {
        if (by != 0) {
            return false;
        }
        for (int i = 0; i < eNTITYBlockViewer.tw; ++i) {
            if (eNTITYBlockViewer.tn[i] == 0 || !PlayerMoveListener.a(eNTITYBlockViewer.tl[i], eNTITYBlockViewer.tn[i], l)) continue;
            return true;
        }
        return false;
    }

    static boolean b(ENTITYBlockViewer eNTITYBlockViewer, long l, byte by) {
        if (by == 0) {
            return false;
        }
        int n = Opaque116.c(l);
        int n2 = Opaque116.d(l);
        int n3 = Opaque116.e(l);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                long l2;
                long l3 = l2 = by == 1 ? Opaque116.f(n + j, n2 + i, n3) : Opaque116.f(n + j, n2, n3 + i);
                if (!eNTITYBlockViewer.e(l2, (byte)0)) continue;
                return true;
            }
        }
        return false;
    }

    static boolean a(ENTITYBlockViewer eNTITYBlockViewer, int n, boolean bl, boolean bl2) {
        return (bl || bl2) && eNTITYBlockViewer.x(n);
    }

    private int a(RecordOfValue_16 recordOfValue_16, long l, int n, byte by) {
        if (by != 0) {
            return MaterialBridge_3.a(n, by);
        }
        return MaterialBridge_3.b(n, recordOfValue_16.f(l));
    }

    private Object q(int n) {
        return this.rX.r(n);
    }

    private static double a(long l, byte by) {
        return (double)Opaque116.c(l) + (by != 0 ? 1.5 : 0.5);
    }

    private static double b(long l, byte by) {
        return (double)Opaque116.d(l) + (by == 1 ? 1.5 : 0.5);
    }

    private static double c(long l, byte by) {
        return (double)Opaque116.e(l) + (by == 2 ? 1.5 : 0.5);
    }

    private void a(ENTITYBlockViewer eNTITYBlockViewer, int n) {
        int n2 = Math.min(32, Math.max(1, eNTITYBlockViewer.hf() / 16));
        int n3 = Math.max(0, MaterialBarColorHolder.cR);
        for (int i = 0; i < eNTITYBlockViewer.hf(); ++i) {
            if (!eNTITYBlockViewer.ti[i] || eNTITYBlockViewer.th[i] || eNTITYBlockViewer.ty <= n2 && n - eNTITYBlockViewer.tg[i] < n3) continue;
            eNTITYBlockViewer.f(i, this.rX.p(i).ux());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(Player player, ENTITYBlockViewer eNTITYBlockViewer) {
        ENTITYBlockViewer eNTITYBlockViewer2 = eNTITYBlockViewer;
        synchronized (eNTITYBlockViewer2) {
            for (int i = 0; i < eNTITYBlockViewer.hf(); ++i) {
                if (!eNTITYBlockViewer.ti[i]) continue;
                eNTITYBlockViewer.f(i, this.rX.p(i).ux());
            }
            if (eNTITYBlockViewer.tx > 0) {
                PacketListenerRegistry.uN().a(player, eNTITYBlockViewer.tq, eNTITYBlockViewer.tx);
            }
            eNTITYBlockViewer.clear();
        }
    }

    private void a(Player player, LocationBridge_12 locationBridge_12) {
        ++locationBridge_12.sT;
        this.a(player, locationBridge_12.sM);
        locationBridge_12.sN.set(true);
    }

    private boolean y(Player player) {
        return !VersionHelper_3.UQ || this.rZ.computeIfAbsent(player.getUniqueId(), uUID -> PlayerJoinListener_2.y(player)) != false;
    }

    private void a(LocationBridge_12 locationBridge_12, UUID uUID, double d, double d2) {
        locationBridge_12.jO = d;
        locationBridge_12.jQ = d2;
        long l = PlayerMoveListener.c(PlayerMoveListener.f(d), PlayerMoveListener.f(d2));
        if (uUID.equals(locationBridge_12.sR) && l == locationBridge_12.sS) {
            return;
        }
        this.sa.a(uUID, l, locationBridge_12);
        if (locationBridge_12.sR != null) {
            this.sa.b(locationBridge_12.sR, locationBridge_12.sS, locationBridge_12);
        }
        locationBridge_12.sR = uUID;
        locationBridge_12.sS = l;
    }

    private void a(LocationBridge_12 locationBridge_12) {
        if (locationBridge_12.sR == null) {
            return;
        }
        this.sa.b(locationBridge_12.sR, locationBridge_12.sS, locationBridge_12);
        locationBridge_12.sR = null;
    }

    static int f(double d) {
        return (int)Math.floor(d / 64.0);
    }

    static long c(int n, int n2) {
        return (long)n << 32 ^ (long)n2 & 0xFFFFFFFFL;
    }

    private void ak(Player player) {
        LocationBridge_12 locationBridge_12 = (LocationBridge_12)this.rY.remove(player.getUniqueId());
        if (locationBridge_12 == null) {
            return;
        }
        this.a(locationBridge_12);
        ++locationBridge_12.sT;
        this.a(player, locationBridge_12.sM);
    }

    @EventHandler
    private void a(PlayerMoveEvent playerMoveEvent) {
        LocationBridge_12 locationBridge_12 = (LocationBridge_12)this.rY.get(playerMoveEvent.getPlayer().getUniqueId());
        if (locationBridge_12 != null) {
            Location location = playerMoveEvent.getTo();
            UUID uUID = location.getWorld().getUID();
            if (uUID.equals(locationBridge_12.hr)) {
                this.a(locationBridge_12, uUID, location.getX(), location.getZ());
            }
            if (locationBridge_12.v(location)) {
                locationBridge_12.sN.set(true);
            }
        }
    }

    @EventHandler
    private void b(PlayerTeleportEvent playerTeleportEvent) {
        LocationBridge_12 locationBridge_12 = (LocationBridge_12)this.rY.get(playerTeleportEvent.getPlayer().getUniqueId());
        if (locationBridge_12 != null) {
            Location location = playerTeleportEvent.getTo();
            UUID uUID = location.getWorld().getUID();
            if (uUID.equals(locationBridge_12.hr)) {
                this.a(locationBridge_12, uUID, location.getX(), location.getZ());
            }
            locationBridge_12.sN.set(true);
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
