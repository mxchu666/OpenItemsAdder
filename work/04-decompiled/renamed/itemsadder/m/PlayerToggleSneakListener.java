package itemsadder.m;

import dev.lone.itemsadder.Main;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ChunkLoadListener;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemDisplayLocationHolder;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBoundingBoxHolder;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_7;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PlayerBlockHolder;
import itemsadder.m.PlayerBridge_5;
import itemsadder.m.PlayerInteractListener;
import itemsadder.m.PlayerJoinListener_9;
import itemsadder.m.RecordOfPlayer;
import itemsadder.m.RecordOfValue_6;
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

public final class PlayerToggleSneakListener
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
    private final PlayerInteractListener iS;
    private ScheduledExecutorService iT;
    private BukkitTask iU;
    private static Long iV;

    public PlayerToggleSneakListener(PlayerInteractListener playerInteractListener) {
        this.iS = playerInteractListener;
        ListenerBridge.b(this, (Plugin)Main.rS());
    }

    public void bT() {
        iA = MaterialBarColorHolder.dW;
        iE = MaterialBarColorHolder.dX;
        iF = MaterialBarColorHolder.dY;
        iH = MaterialBarColorHolder.dT;
        iB = MaterialBarColorHolder.dZ;
        iD = MaterialBarColorHolder.ea;
        iN = MaterialBarColorHolder.dU;
        iO = MaterialBarColorHolder.dV;
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
        this.iU = BukkitTaskBridge.c(bukkitRunnable -> this.bV(), 1L, 1L);
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
            LocationBoundingBoxHolder locationBoundingBoxHolder = (LocationBoundingBoxHolder)entry.getValue();
            locationBoundingBoxHolder.cp();
            locationBoundingBoxHolder.ch();
        }
        this.iR.clear();
    }

    public void bV() {
        int n = Bukkit.getCurrentTick();
        int n2 = 0;
        for (Player player : Bukkit.getOnlinePlayers()) {
            LocationBoundingBoxHolder locationBoundingBoxHolder = this.F(player);
            if (locationBoundingBoxHolder != null) {
                locationBoundingBoxHolder.co();
            }
            if (PlayerInteractListener.L(player) || locationBoundingBoxHolder == null) continue;
            this.iS.b(player, locationBoundingBoxHolder);
            if (locationBoundingBoxHolder.jE.get() || locationBoundingBoxHolder.jA.get()) continue;
            boolean bl = locationBoundingBoxHolder.jC.get();
            boolean bl2 = locationBoundingBoxHolder.jB.get() || bl;
            int n3 = n2++;
            if (!bl2 && n3 % iB != n % iB) continue;
            Location location = player.getLocation();
            double d = location.getY() - (double)player.getWorld().getHighestBlockYAt(location);
            boolean bl3 = locationBoundingBoxHolder.jD.getAndSet(false);
            if (bl3 || bl || !PlayerJoinListener_9.bN.i(player) && d < 9.0) {
                this.b(player, bl3);
            }
            if (!locationBoundingBoxHolder.jA.compareAndSet(false, true)) continue;
            PlayerBlockHolder playerBlockHolder = this.iS.kO.z(player);
            if (playerBlockHolder == null) {
                locationBoundingBoxHolder.jA.set(false);
                continue;
            }
            RecordOfPlayer recordOfPlayer = new RecordOfPlayer(player, locationBoundingBoxHolder, playerBlockHolder, location, player.getEyeLocation(), d, n, n3, locationBoundingBoxHolder.jB.get(), locationBoundingBoxHolder.jf);
            if (this.c(() -> {
                boolean bl = false;
                try {
                    bl = this.a(recordOfPlayer);
                }
                finally {
                    if (!bl) {
                        locationBoundingBoxHolder.jA.set(false);
                    }
                }
            })) continue;
            locationBoundingBoxHolder.jA.set(false);
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
        this.iR.putIfAbsent(player.getUniqueId(), new LocationBoundingBoxHolder(player));
    }

    @Nullable
    LocationBoundingBoxHolder F(Player player) {
        return (LocationBoundingBoxHolder)this.iR.get(player.getUniqueId());
    }

    public void G(Player player) {
        LocationBoundingBoxHolder locationBoundingBoxHolder = this.F(player);
        if (locationBoundingBoxHolder != null) {
            locationBoundingBoxHolder.jB.set(true);
        }
    }

    public void a(Player player, int n, int n2, World world) {
        this.c(() -> {
            PlayerBlockHolder playerBlockHolder = this.iS.kO.A(player);
            if (playerBlockHolder != null) {
                playerBlockHolder.b(n, n2, world);
            }
        });
    }

    public void H(Player player) {
        LocationBoundingBoxHolder locationBoundingBoxHolder = this.F(player);
        if (locationBoundingBoxHolder != null) {
            this.a(player, locationBoundingBoxHolder);
        } else {
            this.c(() -> this.iS.kO.B(player));
        }
    }

    private void a(Player player, LocationBoundingBoxHolder locationBoundingBoxHolder) {
        long l = ++locationBoundingBoxHolder.jf;
        locationBoundingBoxHolder.jE.set(true);
        if (!this.c(() -> {
            try {
                this.iS.kO.B(player);
            }
            finally {
                if (locationBoundingBoxHolder.jf == l) {
                    locationBoundingBoxHolder.jE.set(false);
                    locationBoundingBoxHolder.jB.set(true);
                }
            }
        })) {
            this.iS.kO.B(player);
            if (locationBoundingBoxHolder.jf == l) {
                locationBoundingBoxHolder.jE.set(false);
            }
        }
    }

    private boolean a(RecordOfPlayer recordOfPlayer) {
        boolean bl;
        long l;
        boolean bl2;
        Player player = recordOfPlayer.bW();
        LocationBoundingBoxHolder locationBoundingBoxHolder = recordOfPlayer.bX();
        int n = recordOfPlayer.cd();
        boolean bl3 = bl2 = locationBoundingBoxHolder.jB.getAndSet(false) || recordOfPlayer.ce();
        if (recordOfPlayer.cc() % 1200 == 0) {
            recordOfPlayer.bY().cB();
        }
        double d = recordOfPlayer.cb();
        if (!bl2 && d > 30.0 && n % 10 != recordOfPlayer.cc() % 10) {
            return false;
        }
        boolean bl4 = d >= 9.0;
        Location location = recordOfPlayer.bZ();
        locationBoundingBoxHolder.jw.setWorld(location.getWorld());
        locationBoundingBoxHolder.jw.set(location.getX(), location.getY(), location.getZ());
        locationBoundingBoxHolder.jw.setYaw(location.getYaw());
        locationBoundingBoxHolder.jw.setPitch(location.getPitch());
        locationBoundingBoxHolder.jx.setWorld(location.getWorld());
        if (!bl2 && !bl4) {
            float f = locationBoundingBoxHolder.cg();
            if (f > 15.0f) {
                byte by = locationBoundingBoxHolder.jM;
                locationBoundingBoxHolder.jM = (byte)(by + 1);
                if (by >= 5) {
                    locationBoundingBoxHolder.jN = (byte)20;
                    return false;
                }
            } else {
                locationBoundingBoxHolder.jM = 0;
            }
            if (locationBoundingBoxHolder.jN > 0) {
                locationBoundingBoxHolder.jN = (byte)(locationBoundingBoxHolder.jN - 1);
                return false;
            }
        }
        if (locationBoundingBoxHolder.jz != 0L && (l = (long)recordOfPlayer.cc() - locationBoundingBoxHolder.jz) > 0L && locationBoundingBoxHolder.jv.getWorld().equals((Object)locationBoundingBoxHolder.jw.getWorld())) {
            double d2 = locationBoundingBoxHolder.jv.distanceSquared(locationBoundingBoxHolder.jw);
            double d3 = Math.sqrt(d2) / (double)l;
            if (d2 > 10000.0) {
                locationBoundingBoxHolder.jv.set(locationBoundingBoxHolder.jw.getX(), locationBoundingBoxHolder.jw.getY(), locationBoundingBoxHolder.jw.getZ());
            } else {
                double d4 = d3 * 20.0;
                if (!bl2 && d4 > 40.0 && n % 10 != recordOfPlayer.cc() % 10) {
                    return false;
                }
            }
        }
        int n2 = locationBoundingBoxHolder.jw.getBlockX() >> 4;
        int n3 = locationBoundingBoxHolder.jw.getBlockZ() >> 4;
        boolean bl5 = locationBoundingBoxHolder.jv.getWorld() != locationBoundingBoxHolder.jw.getWorld() || locationBoundingBoxHolder.jz == 0L;
        boolean bl6 = bl5 || locationBoundingBoxHolder.jG != n2 || locationBoundingBoxHolder.jH != n3;
        float f = LocationBridge_2.D(locationBoundingBoxHolder.jw.getYaw() - locationBoundingBoxHolder.jv.getYaw());
        float f2 = locationBoundingBoxHolder.jw.getPitch() - locationBoundingBoxHolder.jv.getPitch();
        boolean bl7 = Math.abs(f) >= 5.0f || Math.abs(f2) >= 5.0f;
        boolean bl8 = bl = locationBoundingBoxHolder.jv.getWorld() == locationBoundingBoxHolder.jw.getWorld() && locationBoundingBoxHolder.jv.distanceSquared(locationBoundingBoxHolder.jw) < 0.25;
        if (!bl2 && iH ? !bl6 && !bl7 : !bl2 && !bl6 && bl) {
            return false;
        }
        locationBoundingBoxHolder.jG = n2;
        locationBoundingBoxHolder.jH = n3;
        locationBoundingBoxHolder.jv.setWorld(locationBoundingBoxHolder.jw.getWorld());
        locationBoundingBoxHolder.jv.set(locationBoundingBoxHolder.jw.getX(), locationBoundingBoxHolder.jw.getY(), locationBoundingBoxHolder.jw.getZ());
        locationBoundingBoxHolder.jv.setYaw(locationBoundingBoxHolder.jw.getYaw());
        locationBoundingBoxHolder.jv.setPitch(locationBoundingBoxHolder.jw.getPitch());
        locationBoundingBoxHolder.jz = recordOfPlayer.cc();
        BukkitTaskBridge.i(() -> this.b(recordOfPlayer));
        return true;
    }

    private void b(RecordOfPlayer recordOfPlayer) {
        LocationBoundingBoxHolder locationBoundingBoxHolder = recordOfPlayer.bX();
        Player player = recordOfPlayer.bW();
        if (this.iR.get(player.getUniqueId()) != locationBoundingBoxHolder || !player.isOnline() || player.getWorld() != recordOfPlayer.bZ().getWorld() || locationBoundingBoxHolder.jf != recordOfPlayer.cf()) {
            locationBoundingBoxHolder.jA.set(false);
            return;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        this.iS.kO.b(recordOfPlayer.bZ(), iD, objectArrayList);
        if (!this.c(() -> this.a(recordOfPlayer, objectArrayList))) {
            locationBoundingBoxHolder.jA.set(false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(RecordOfPlayer recordOfPlayer, ObjectArrayList objectArrayList) {
        LocationBoundingBoxHolder locationBoundingBoxHolder = recordOfPlayer.bX();
        try {
            boolean bl;
            boolean bl2;
            UUID uUID;
            RecordOfValue_6 recordOfValue_62;
            if (this.iR.get(recordOfPlayer.bW().getUniqueId()) != locationBoundingBoxHolder || locationBoundingBoxHolder.jf != recordOfPlayer.cf()) {
                return;
            }
            Player player = recordOfPlayer.bW();
            Location location = recordOfPlayer.bZ();
            boolean bl3 = recordOfPlayer.cb() >= 9.0;
            PlayerBlockHolder playerBlockHolder = recordOfPlayer.bY();
            ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
            this.iS.kO.a(locationBoundingBoxHolder.jw.getBlockX(), locationBoundingBoxHolder.jw.getBlockZ(), iD, (List)objectArrayList, locationBoundingBoxHolder.jF);
            LongOpenHashSet longOpenHashSet = new LongOpenHashSet(locationBoundingBoxHolder.jF.size());
            for (RecordOfValue_6 recordOfValue_62 : locationBoundingBoxHolder.jF) {
                longOpenHashSet.add(ChunkLoadListener.d(recordOfValue_62.bo(), recordOfValue_62.bm(), recordOfValue_62.bp()));
            }
            int n = 0;
            recordOfValue_62 = new ObjectOpenHashSet();
            NonBlockingHashMapLong nonBlockingHashMapLong = playerBlockHolder.cA();
            if (nonBlockingHashMapLong != null && !nonBlockingHashMapLong.isEmpty()) {
                for (Object object : nonBlockingHashMapLong.entrySet()) {
                    if (object == null || longOpenHashSet.contains(((Long)object.getKey()).longValue())) continue;
                    uUID = ((ItemDisplayLocationHolder)object.getValue()).kg.getUniqueId();
                    recordOfValue_62.add(uUID);
                    ++n;
                }
            }
            ObjectIterator objectIterator = recordOfValue_62.iterator();
            while (objectIterator.hasNext()) {
                Object object;
                object = (UUID)objectIterator.next();
                playerBlockHolder.c((UUID)object);
            }
            if (n > 0) {
                // empty if block
            }
            boolean bl4 = bl2 = locationBoundingBoxHolder.jF.size() > iQ;
            if (!locationBoundingBoxHolder.jK && bl2) {
                locationBoundingBoxHolder.jL = (short)10;
            }
            if (bl2) {
                if (locationBoundingBoxHolder.jL > 0) {
                    locationBoundingBoxHolder.jL = (short)(locationBoundingBoxHolder.jL - 1);
                    bl = false;
                } else {
                    bl = true;
                }
            } else {
                bl = false;
                locationBoundingBoxHolder.jL = 0;
            }
            locationBoundingBoxHolder.jK = bl2;
            uUID = locationBoundingBoxHolder.jF;
            for (int i = 0; i < uUID.size(); ++i) {
                boolean bl5;
                int n2;
                RecordOfValue_6 recordOfValue_63 = (RecordOfValue_6)uUID.get(i);
                locationBoundingBoxHolder.jx.set((double)recordOfValue_63.bo(), (double)recordOfValue_63.bm(), (double)recordOfValue_63.bp());
                Location location2 = locationBoundingBoxHolder.jx;
                double d = LocationBridge_2.h(location2, locationBoundingBoxHolder.jw);
                if (d > (double)(iD * iD) || !bl3 && iH && playerBlockHolder.cz() > 500 && !PlayerToggleSneakListener.a(recordOfPlayer.ca(), location2, 0.1)) continue;
                if (bl && iN && d > iP) {
                    int n3;
                    n2 = location2.getBlockX();
                    boolean bl6 = bl5 = (n2 + (n3 = location2.getBlockZ())) % 2 == 0;
                    if (!bl5) continue;
                }
                if (objectOpenHashSet.size() >= iA) continue;
                n2 = iE && bl && (LocationBridge_2.h(location2, location) >= (double)iF || this.a(location2, location)) ? 1 : 0;
                @Nullable ItemDisplayLocationHolder itemDisplayLocationHolder = playerBlockHolder.j(location2);
                if (itemDisplayLocationHolder != null) {
                    boolean bl7;
                    bl5 = itemDisplayLocationHolder.c(recordOfValue_63);
                    boolean bl8 = bl7 = bl5 || itemDisplayLocationHolder.b(recordOfValue_63);
                    if (itemDisplayLocationHolder.b(bl7, n2 != 0, bl)) {
                        LocationBridge_7 locationBridge_7 = PlayerToggleSneakListener.a(recordOfValue_63, (ObjectArrayList)uUID, i, location2);
                        if (locationBridge_7 == null) continue;
                        playerBlockHolder.a(itemDisplayLocationHolder, locationBridge_7, recordOfValue_63.bk(), n2 != 0, locationBoundingBoxHolder.jw, bl7, bl5);
                    }
                    if (itemDisplayLocationHolder.cH() && itemDisplayLocationHolder.cD()) {
                        playerBlockHolder.a(itemDisplayLocationHolder, locationBoundingBoxHolder.jw, true, false);
                    }
                } else {
                    LocationBridge_7 locationBridge_7 = PlayerToggleSneakListener.a(recordOfValue_63, (ObjectArrayList)uUID, i, location2);
                    if (locationBridge_7 == null) continue;
                    itemDisplayLocationHolder = playerBlockHolder.a(false, locationBridge_7, locationBridge_7.hD, recordOfValue_63.bk(), location2, n2 != 0, locationBoundingBoxHolder.jw);
                    if (itemDisplayLocationHolder == null) {
                        // empty if block
                    }
                }
                if (itemDisplayLocationHolder == null) continue;
                objectOpenHashSet.add((Object)itemDisplayLocationHolder.kg.getUniqueId());
            }
            playerBlockHolder.a((Set)objectOpenHashSet);
        }
        finally {
            locationBoundingBoxHolder.jA.set(false);
        }
    }

    public static void I(Player player) {
        PlayerToggleSneakListener.a(player, false);
    }

    public static void a(Player player, boolean bl) {
        PlayerToggleSneakListener playerToggleSneakListener = ItemStackRegistry.g().v().kQ;
        LocationBoundingBoxHolder locationBoundingBoxHolder = playerToggleSneakListener.F(player);
        if (locationBoundingBoxHolder == null) {
            return;
        }
        locationBoundingBoxHolder.jC.set(true);
        if (bl) {
            locationBoundingBoxHolder.jD.set(true);
        }
    }

    private void b(Player player, boolean bl) {
        boolean bl2;
        ItemDisplay itemDisplay;
        LocationBoundingBoxHolder locationBoundingBoxHolder = this.F(player);
        if (locationBoundingBoxHolder == null) {
            return;
        }
        locationBoundingBoxHolder.jC.set(false);
        if (player.getGameMode() == GameMode.SPECTATOR || player.getGameMode() == GameMode.ADVENTURE || PlayerInteractListener.L(player)) {
            locationBoundingBoxHolder.ch();
            return;
        }
        locationBoundingBoxHolder.cq();
        PlayerBlockHolder playerBlockHolder = this.iS.kO.A(player);
        if (playerBlockHolder == null) {
            return;
        }
        ItemDisplayLocationHolder itemDisplayLocationHolder = playerBlockHolder.K(player);
        if (itemDisplayLocationHolder == null || !((itemDisplay = itemDisplayLocationHolder.kg) instanceof ItemDisplay)) {
            locationBoundingBoxHolder.cr();
            return;
        }
        ItemDisplay itemDisplay2 = itemDisplay;
        itemDisplay = itemDisplayLocationHolder.cI().cJ();
        Location location = itemDisplay2.getLocation().getBlock().getLocation();
        Block block = playerBlockHolder.cw();
        boolean bl3 = MaterialBarColorHolder.ed && block != null && !this.iS.kO.g(block.getRelative(BlockFace.UP));
        boolean bl4 = bl2 = locationBoundingBoxHolder.jk.size() == 12 && locationBoundingBoxHolder.jl != null && locationBoundingBoxHolder.jl.getWorld() == location.getWorld() && (!MaterialBarColorHolder.ed || locationBoundingBoxHolder.ci());
        if (!bl2) {
            locationBoundingBoxHolder.ch();
            PlayerBridge_5.a(player, (BoundingBox)itemDisplay, locationBoundingBoxHolder.jk);
            locationBoundingBoxHolder.a((BoundingBox)itemDisplay, bl3);
        } else if (bl || locationBoundingBoxHolder.ju || !location.equals((Object)locationBoundingBoxHolder.jl) || !itemDisplay.equals((Object)locationBoundingBoxHolder.jm) || locationBoundingBoxHolder.jt != bl3) {
            PlayerBridge_5.b(player, (BoundingBox)itemDisplay, locationBoundingBoxHolder.jk);
            locationBoundingBoxHolder.a((BoundingBox)itemDisplay, bl3);
        } else {
            return;
        }
        locationBoundingBoxHolder.ju = false;
        locationBoundingBoxHolder.jl = location;
        locationBoundingBoxHolder.jm = itemDisplay;
    }

    private boolean a(Location location, Location location2) {
        double d;
        double d2;
        double d3 = Math.toRadians(location2.getYaw());
        double d4 = -Math.sin(d3);
        double d5 = Math.cos(d3);
        double d6 = location.getX() - location2.getX();
        double d7 = d6 * d6 + (d2 = location.getZ() - location2.getZ()) * d2;
        double d8 = d7 - (d = d6 * d4 + d2 * d5) * d;
        return d8 >= 9.0;
    }

    private static LocationBridge_7 a(RecordOfValue_6 recordOfValue_6, ObjectArrayList objectArrayList, int n, Location location) {
        LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfValue_6.bj());
        if (locationBridge_7 == null) {
            if (System.currentTimeMillis() - iV < 10000L) {
                return null;
            }
            iV = System.currentTimeMillis();
            CommandSenderBridge_5.warn("Unknown crop '" + recordOfValue_6.bj() + "' found at " + LocationBridge_2.ae(location) + ". This warning will be shown only once every 10 seconds to avoid spam.");
            int n2 = 1;
            String string = recordOfValue_6.bj();
            while (n + 1 < objectArrayList.size() && ((RecordOfValue_6)objectArrayList.get(n + 1)).bj().equals(string)) {
                ++n;
                ++n2;
            }
            if (n2 > 1) {
                CommandSenderBridge_5.iA("Also skipped " + (n2 - 1) + " additional crops with the same id '" + string + "'");
            }
            return null;
        }
        return locationBridge_7;
    }

    static boolean a(Location location, Location location2, double d) {
        double d2;
        double d3 = Math.toRadians(location.getYaw());
        double d4 = -Math.sin(d3);
        double d5 = Math.cos(d3);
        double d6 = location.getX() - d4 * 2.0;
        double d7 = location.getZ() - d5 * 2.0;
        double d8 = location2.getX() - d6;
        double d9 = Math.sqrt(d8 * d8 + (d2 = location2.getZ() - d7) * d2);
        if (d9 < 1.0E-6) {
            return true;
        }
        double d10 = d4 * (d8 / d9) + d5 * (d2 / d9);
        return d10 >= d;
    }

    @EventHandler
    private void a(PlayerToggleSneakEvent playerToggleSneakEvent) {
        PlayerToggleSneakListener.I(playerToggleSneakEvent.getPlayer());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void a(PlayerMoveEvent playerMoveEvent) {
        Location location = playerMoveEvent.getFrom();
        Location location2 = playerMoveEvent.getTo();
        if (location.getX() == location2.getX() && location.getY() == location2.getY() && location.getZ() == location2.getZ()) {
            return;
        }
        LocationBoundingBoxHolder locationBoundingBoxHolder = this.F(playerMoveEvent.getPlayer());
        if (locationBoundingBoxHolder != null) {
            locationBoundingBoxHolder.cj();
        }
    }

    @EventHandler
    private void c(PlayerJoinEvent playerJoinEvent) {
        BukkitTaskBridge.c(() -> {
            if (!playerJoinEvent.getPlayer().isOnline()) {
                return;
            }
            this.E(playerJoinEvent.getPlayer());
        }, 40L);
    }

    @EventHandler
    private void c(PlayerQuitEvent playerQuitEvent) {
        LocationBoundingBoxHolder locationBoundingBoxHolder = (LocationBoundingBoxHolder)this.iR.remove(playerQuitEvent.getPlayer().getUniqueId());
        if (locationBoundingBoxHolder != null) {
            if (locationBoundingBoxHolder.jn != null) {
                locationBoundingBoxHolder.jn.remove();
                locationBoundingBoxHolder.jn = null;
            }
            ++locationBoundingBoxHolder.jf;
            if (!this.c(() -> {
                locationBoundingBoxHolder.p(false);
                this.iS.kO.B(playerQuitEvent.getPlayer());
            })) {
                this.iS.kO.B(playerQuitEvent.getPlayer());
            }
        }
    }

    @EventHandler
    private void a(PlayerChangedWorldEvent playerChangedWorldEvent) {
        LocationBoundingBoxHolder locationBoundingBoxHolder = this.F(playerChangedWorldEvent.getPlayer());
        if (locationBoundingBoxHolder != null) {
            locationBoundingBoxHolder.cp();
            locationBoundingBoxHolder.ch();
            this.a(playerChangedWorldEvent.getPlayer(), locationBoundingBoxHolder);
        }
    }

    static {
        iE = true;
        iF = 7;
        iV = 0L;
    }
}
