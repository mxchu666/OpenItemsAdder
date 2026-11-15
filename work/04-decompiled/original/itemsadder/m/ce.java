package itemsadder.m;

import dev.lone.itemsadder.Main;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import itemsadder.m.ae;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.bl;
import itemsadder.m.bq;
import itemsadder.m.br;
import itemsadder.m.bx;
import itemsadder.m.cf;
import itemsadder.m.cg;
import itemsadder.m.ci;
import itemsadder.m.cj;
import itemsadder.m.co;
import itemsadder.m.d;
import itemsadder.m.w;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.BoundingBox;
import org.jctools.maps.NonBlockingHashMapLong;
import org.jetbrains.annotations.Nullable;

public final class ce
implements Listener {
    public static int iA = 1400;
    private static int iB;
    private static final double iC = 0.25;
    public static int iD;
    public static boolean iE;
    public static int iF;
    private static final int iG = 1200;
    private static boolean iH;
    private static final int iI = 500;
    private static final double iJ = 30.0;
    private static final int iK = 10;
    private static final double iL = 40.0;
    private static final int iM = 10;
    private static boolean iN;
    private static double iO;
    private static double iP;
    private static int iQ;
    private final Map iR = new ConcurrentHashMap();
    private final co iS;
    private ScheduledExecutorService iT;
    private BukkitTask iU;
    private static Long iV;

    public ce(co co2) {
        this.iS = co2;
        bev.b(this, (Plugin)Main.rS());
    }

    public void bT() {
        iA = ae.dW;
        iE = ae.dX;
        iF = ae.dY;
        iH = ae.dT;
        iB = ae.dZ;
        iD = ae.ea;
        iN = ae.dU;
        iO = ae.dV;
        iP = iO * iO;
        iQ = Math.min(500, (int)((float)iA / 6.0f));
        if (this.iT != null && !this.iT.isShutdown()) {
            this.iT.shutdownNow();
        }
        this.iT = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, "ItemsAdder-Crops-Stream-Tick");
            thread.setDaemon(true);
            return thread;
        });
        if (this.iU != null) {
            this.iU.cancel();
        }
        this.iU = bcp.c(bukkitRunnable -> this.bV(), 1L, 1L);
        Bukkit.getOnlinePlayers().forEach(this::E);
    }

    public void bU() {
        if (this.iU != null) {
            this.iU.cancel();
            this.iU = null;
        }
        ScheduledExecutorService scheduledExecutorService = this.iT;
        this.iT = null;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            try {
                if (!scheduledExecutorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                    scheduledExecutorService.shutdownNow();
                    scheduledExecutorService.awaitTermination(1L, TimeUnit.SECONDS);
                }
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        for (Map.Entry entry : this.iR.entrySet()) {
            cg cg2 = (cg)entry.getValue();
            cg2.cp();
            cg2.ch();
        }
        this.iR.clear();
    }

    public void bV() {
        int n = Bukkit.getCurrentTick();
        int n2 = 0;
        for (Player player : Bukkit.getOnlinePlayers()) {
            cg cg2 = this.F(player);
            if (cg2 != null) {
                cg2.co();
            }
            if (co.L(player) || cg2 == null) continue;
            this.iS.b(player, cg2);
            if (cg2.jE.get() || cg2.jA.get()) continue;
            boolean bl = cg2.jC.get();
            boolean bl2 = cg2.jB.get() || bl;
            int n3 = n2++;
            if (!bl2 && n3 % iB != n % iB) continue;
            Location location = player.getLocation();
            double d = location.getY() - (double)player.getWorld().getHighestBlockYAt(location);
            boolean bl3 = cg2.jD.getAndSet(false);
            if (bl3 || bl || !w.bN.i(player) && d < 9.0) {
                this.b(player, bl3);
            }
            if (!cg2.jA.compareAndSet(false, true)) continue;
            ci ci2 = this.iS.kO.z(player);
            if (ci2 == null) {
                cg2.jA.set(false);
                continue;
            }
            cf cf2 = new cf(player, cg2, ci2, location, player.getEyeLocation(), d, n, n3, cg2.jB.get(), cg2.jf);
            if (this.c(() -> {
                boolean bl = false;
                try {
                    bl = this.a(cf2);
                }
                finally {
                    if (!bl) {
                        cg2.jA.set(false);
                    }
                }
            })) continue;
            cg2.jA.set(false);
        }
    }

    private boolean c(Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService = this.iT;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            return false;
        }
        try {
            scheduledExecutorService.execute(() -> {
                try {
                    runnable.run();
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
            return true;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            return false;
        }
    }

    void E(Player player) {
        this.iR.putIfAbsent(player.getUniqueId(), new cg(player));
    }

    @Nullable
    cg F(Player player) {
        return (cg)this.iR.get(player.getUniqueId());
    }

    public void G(Player player) {
        cg cg2 = this.F(player);
        if (cg2 != null) {
            cg2.jB.set(true);
        }
    }

    public void a(Player player, int n, int n2, World world) {
        this.c(() -> {
            ci ci2 = this.iS.kO.A(player);
            if (ci2 != null) {
                ci2.b(n, n2, world);
            }
        });
    }

    public void H(Player player) {
        cg cg2 = this.F(player);
        if (cg2 != null) {
            this.a(player, cg2);
        } else {
            this.c(() -> this.iS.kO.B(player));
        }
    }

    private void a(Player player, cg cg2) {
        long l = ++cg2.jf;
        cg2.jE.set(true);
        if (!this.c(() -> {
            try {
                this.iS.kO.B(player);
            }
            finally {
                if (cg2.jf == l) {
                    cg2.jE.set(false);
                    cg2.jB.set(true);
                }
            }
        })) {
            this.iS.kO.B(player);
            if (cg2.jf == l) {
                cg2.jE.set(false);
            }
        }
    }

    private boolean a(cf cf2) {
        boolean bl;
        long l;
        boolean bl2;
        Player player = cf2.bW();
        cg cg2 = cf2.bX();
        int n = cf2.cd();
        boolean bl3 = bl2 = cg2.jB.getAndSet(false) || cf2.ce();
        if (cf2.cc() % 1200 == 0) {
            cf2.bY().cB();
        }
        double d = cf2.cb();
        if (!bl2 && d > 30.0 && n % 10 != cf2.cc() % 10) {
            return false;
        }
        boolean bl4 = d >= 9.0;
        Location location = cf2.bZ();
        cg2.jw.setWorld(location.getWorld());
        cg2.jw.set(location.getX(), location.getY(), location.getZ());
        cg2.jw.setYaw(location.getYaw());
        cg2.jw.setPitch(location.getPitch());
        cg2.jx.setWorld(location.getWorld());
        if (!bl2 && !bl4) {
            float f = cg2.cg();
            if (f > 15.0f) {
                byte by = cg2.jM;
                cg2.jM = (byte)(by + 1);
                if (by >= 5) {
                    cg2.jN = (byte)20;
                    return false;
                }
            } else {
                cg2.jM = 0;
            }
            if (cg2.jN > 0) {
                cg2.jN = (byte)(cg2.jN - 1);
                return false;
            }
        }
        if (cg2.jz != 0L && (l = (long)cf2.cc() - cg2.jz) > 0L && cg2.jv.getWorld().equals((Object)cg2.jw.getWorld())) {
            double d2 = cg2.jv.distanceSquared(cg2.jw);
            double d3 = Math.sqrt(d2) / (double)l;
            if (d2 > 10000.0) {
                cg2.jv.set(cg2.jw.getX(), cg2.jw.getY(), cg2.jw.getZ());
            } else {
                double d4 = d3 * 20.0;
                if (!bl2 && d4 > 40.0 && n % 10 != cf2.cc() % 10) {
                    return false;
                }
            }
        }
        int n2 = cg2.jw.getBlockX() >> 4;
        int n3 = cg2.jw.getBlockZ() >> 4;
        boolean bl5 = cg2.jv.getWorld() != cg2.jw.getWorld() || cg2.jz == 0L;
        boolean bl6 = bl5 || cg2.jG != n2 || cg2.jH != n3;
        float f = bcc.D(cg2.jw.getYaw() - cg2.jv.getYaw());
        float f2 = cg2.jw.getPitch() - cg2.jv.getPitch();
        boolean bl7 = Math.abs(f) >= 5.0f || Math.abs(f2) >= 5.0f;
        boolean bl8 = bl = cg2.jv.getWorld() == cg2.jw.getWorld() && cg2.jv.distanceSquared(cg2.jw) < 0.25;
        if (!bl2 && iH ? !bl6 && !bl7 : !bl2 && !bl6 && bl) {
            return false;
        }
        cg2.jG = n2;
        cg2.jH = n3;
        cg2.jv.setWorld(cg2.jw.getWorld());
        cg2.jv.set(cg2.jw.getX(), cg2.jw.getY(), cg2.jw.getZ());
        cg2.jv.setYaw(cg2.jw.getYaw());
        cg2.jv.setPitch(cg2.jw.getPitch());
        cg2.jz = cf2.cc();
        bcp.i(() -> this.b(cf2));
        return true;
    }

    private void b(cf cf2) {
        cg cg2 = cf2.bX();
        Player player = cf2.bW();
        if (this.iR.get(player.getUniqueId()) != cg2 || !player.isOnline() || player.getWorld() != cf2.bZ().getWorld() || cg2.jf != cf2.cf()) {
            cg2.jA.set(false);
            return;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        this.iS.kO.b(cf2.bZ(), iD, objectArrayList);
        if (!this.c(() -> this.a(cf2, objectArrayList))) {
            cg2.jA.set(false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(cf cf2, ObjectArrayList objectArrayList) {
        cg cg2 = cf2.bX();
        try {
            boolean bl;
            boolean bl2;
            UUID uUID;
            bq bq22;
            if (this.iR.get(cf2.bW().getUniqueId()) != cg2 || cg2.jf != cf2.cf()) {
                return;
            }
            Player player = cf2.bW();
            Location location = cf2.bZ();
            boolean bl3 = cf2.cb() >= 9.0;
            ci ci2 = cf2.bY();
            ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
            this.iS.kO.a(cg2.jw.getBlockX(), cg2.jw.getBlockZ(), iD, (List)objectArrayList, cg2.jF);
            LongOpenHashSet longOpenHashSet = new LongOpenHashSet(cg2.jF.size());
            for (bq bq22 : cg2.jF) {
                longOpenHashSet.add(br.d(bq22.bo(), bq22.bm(), bq22.bp()));
            }
            int n = 0;
            bq22 = new ObjectOpenHashSet();
            NonBlockingHashMapLong nonBlockingHashMapLong = ci2.cA();
            if (nonBlockingHashMapLong != null && !nonBlockingHashMapLong.isEmpty()) {
                for (Object object : nonBlockingHashMapLong.entrySet()) {
                    if (object == null || longOpenHashSet.contains(((Long)object.getKey()).longValue())) continue;
                    uUID = ((cj)object.getValue()).kg.getUniqueId();
                    bq22.add(uUID);
                    ++n;
                }
            }
            ObjectIterator objectIterator = bq22.iterator();
            while (objectIterator.hasNext()) {
                Object object;
                object = (UUID)objectIterator.next();
                ci2.c((UUID)object);
            }
            if (n > 0) {
                // empty if block
            }
            boolean bl4 = bl2 = cg2.jF.size() > iQ;
            if (!cg2.jK && bl2) {
                cg2.jL = (short)10;
            }
            if (bl2) {
                if (cg2.jL > 0) {
                    cg2.jL = (short)(cg2.jL - 1);
                    bl = false;
                } else {
                    bl = true;
                }
            } else {
                bl = false;
                cg2.jL = 0;
            }
            cg2.jK = bl2;
            uUID = cg2.jF;
            for (int i = 0; i < uUID.size(); ++i) {
                boolean bl5;
                int n2;
                bq bq3 = (bq)uUID.get(i);
                cg2.jx.set((double)bq3.bo(), (double)bq3.bm(), (double)bq3.bp());
                Location location2 = cg2.jx;
                double d = bcc.h(location2, cg2.jw);
                if (d > (double)(iD * iD) || !bl3 && iH && ci2.cz() > 500 && !ce.a(cf2.ca(), location2, 0.1)) continue;
                if (bl && iN && d > iP) {
                    int n3;
                    n2 = location2.getBlockX();
                    boolean bl6 = bl5 = (n2 + (n3 = location2.getBlockZ())) % 2 == 0;
                    if (!bl5) continue;
                }
                if (objectOpenHashSet.size() >= iA) continue;
                n2 = iE && bl && (bcc.h(location2, location) >= (double)iF || this.a(location2, location)) ? 1 : 0;
                @Nullable cj cj2 = ci2.j(location2);
                if (cj2 != null) {
                    boolean bl7;
                    bl5 = cj2.c(bq3);
                    boolean bl8 = bl7 = bl5 || cj2.b(bq3);
                    if (cj2.b(bl7, n2 != 0, bl)) {
                        bx bx2 = ce.a(bq3, (ObjectArrayList)uUID, i, location2);
                        if (bx2 == null) continue;
                        ci2.a(cj2, bx2, bq3.bk(), n2 != 0, cg2.jw, bl7, bl5);
                    }
                    if (cj2.cH() && cj2.cD()) {
                        ci2.a(cj2, cg2.jw, true, false);
                    }
                } else {
                    bx bx3 = ce.a(bq3, (ObjectArrayList)uUID, i, location2);
                    if (bx3 == null) continue;
                    cj2 = ci2.a(false, bx3, bx3.hD, bq3.bk(), location2, n2 != 0, cg2.jw);
                    if (cj2 == null) {
                        // empty if block
                    }
                }
                if (cj2 == null) continue;
                objectOpenHashSet.add((Object)cj2.kg.getUniqueId());
            }
            ci2.a((Set)objectOpenHashSet);
        }
        finally {
            cg2.jA.set(false);
        }
    }

    public static void I(Player player) {
        ce.a(player, false);
    }

    public static void a(Player player, boolean bl) {
        ce ce2 = d.g().v().kQ;
        cg cg2 = ce2.F(player);
        if (cg2 == null) {
            return;
        }
        cg2.jC.set(true);
        if (bl) {
            cg2.jD.set(true);
        }
    }

    private void b(Player player, boolean bl2) {
        boolean bl3;
        ItemDisplay itemDisplay;
        cg cg2 = this.F(player);
        if (cg2 == null) {
            return;
        }
        cg2.jC.set(false);
        if (player.getGameMode() == GameMode.SPECTATOR || player.getGameMode() == GameMode.ADVENTURE || co.L(player)) {
            cg2.ch();
            return;
        }
        cg2.cq();
        ci ci2 = this.iS.kO.A(player);
        if (ci2 == null) {
            return;
        }
        cj cj2 = ci2.K(player);
        if (cj2 == null || !((itemDisplay = cj2.kg) instanceof ItemDisplay)) {
            cg2.cr();
            return;
        }
        ItemDisplay itemDisplay2 = itemDisplay;
        itemDisplay = cj2.cI().cJ();
        Location location = itemDisplay2.getLocation().getBlock().getLocation();
        Block block = ci2.cw();
        boolean bl4 = ae.ed && block != null && !this.iS.kO.g(block.getRelative(BlockFace.UP));
        boolean bl5 = bl3 = cg2.jk.size() == 12 && cg2.jl != null && cg2.jl.getWorld() == location.getWorld() && (!ae.ed || cg2.ci());
        if (!bl3) {
            cg2.ch();
            bl.a(player, (BoundingBox)itemDisplay, cg2.jk);
            cg2.a((BoundingBox)itemDisplay, bl4);
        } else if (bl2 || cg2.ju || !location.equals((Object)cg2.jl) || !itemDisplay.equals((Object)cg2.jm) || cg2.jt != bl4) {
            bl.b(player, (BoundingBox)itemDisplay, cg2.jk);
            cg2.a((BoundingBox)itemDisplay, bl4);
        } else {
            return;
        }
        cg2.ju = false;
        cg2.jl = location;
        cg2.jm = itemDisplay;
    }

    private boolean a(Location location, Location location2) {
        double d2;
        double d3;
        double d4 = Math.toRadians(location2.getYaw());
        double d5 = -Math.sin(d4);
        double d6 = Math.cos(d4);
        double d7 = location.getX() - location2.getX();
        double d8 = d7 * d7 + (d3 = location.getZ() - location2.getZ()) * d3;
        double d9 = d8 - (d2 = d7 * d5 + d3 * d6) * d2;
        return d9 >= 9.0;
    }

    private static bx a(bq bq2, ObjectArrayList objectArrayList, int n, Location location) {
        bx bx2 = (bx)d.g().ab.get(bq2.bj());
        if (bx2 == null) {
            if (System.currentTimeMillis() - iV < 10000L) {
                return null;
            }
            iV = System.currentTimeMillis();
            bce.warn("Unknown crop '" + bq2.bj() + "' found at " + bcc.ae(location) + ". This warning will be shown only once every 10 seconds to avoid spam.");
            int n2 = 1;
            String string = bq2.bj();
            while (n + 1 < objectArrayList.size() && ((bq)objectArrayList.get(n + 1)).bj().equals(string)) {
                ++n;
                ++n2;
            }
            if (n2 > 1) {
                bce.iA("Also skipped " + (n2 - 1) + " additional crops with the same id '" + string + "'");
            }
            return null;
        }
        return bx2;
    }

    static boolean a(Location location, Location location2, double d2) {
        double d3;
        double d4 = Math.toRadians(location.getYaw());
        double d5 = -Math.sin(d4);
        double d6 = Math.cos(d4);
        double d7 = location.getX() - d5 * 2.0;
        double d8 = location.getZ() - d6 * 2.0;
        double d9 = location2.getX() - d7;
        double d10 = Math.sqrt(d9 * d9 + (d3 = location2.getZ() - d8) * d3);
        if (d10 < 1.0E-6) {
            return true;
        }
        double d11 = d5 * (d9 / d10) + d6 * (d3 / d10);
        return d11 >= d2;
    }

    @EventHandler
    private void a(PlayerToggleSneakEvent playerToggleSneakEvent) {
        ce.I(playerToggleSneakEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PlayerMoveEvent playerMoveEvent) {
        Location location = playerMoveEvent.getFrom();
        Location location2 = playerMoveEvent.getTo();
        if (location.getX() == location2.getX() && location.getY() == location2.getY() && location.getZ() == location2.getZ()) {
            return;
        }
        cg cg2 = this.F(playerMoveEvent.getPlayer());
        if (cg2 != null) {
            cg2.cj();
        }
    }

    @EventHandler
    private void c(PlayerJoinEvent playerJoinEvent) {
        bcp.c(() -> {
            if (!playerJoinEvent.getPlayer().isOnline()) {
                return;
            }
            this.E(playerJoinEvent.getPlayer());
        }, 40L);
    }

    @EventHandler
    private void c(PlayerQuitEvent playerQuitEvent) {
        cg cg2 = (cg)this.iR.remove(playerQuitEvent.getPlayer().getUniqueId());
        if (cg2 != null) {
            if (cg2.jn != null) {
                cg2.jn.remove();
                cg2.jn = null;
            }
            ++cg2.jf;
            if (!this.c(() -> {
                cg2.p(false);
                this.iS.kO.B(playerQuitEvent.getPlayer());
            })) {
                this.iS.kO.B(playerQuitEvent.getPlayer());
            }
        }
    }

    @EventHandler
    private void a(PlayerChangedWorldEvent playerChangedWorldEvent) {
        cg cg2 = this.F(playerChangedWorldEvent.getPlayer());
        if (cg2 != null) {
            cg2.cp();
            cg2.ch();
            this.a(playerChangedWorldEvent.getPlayer(), cg2);
        }
    }

    static {
        iE = true;
        iF = 7;
        iV = 0L;
    }
}
