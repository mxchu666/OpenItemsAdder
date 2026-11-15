package itemsadder.m;

import itemsadder.m.ChunkLoadListener;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridge_7;
import itemsadder.m.Opaque106;
import itemsadder.m.RecordOfUUID;
import itemsadder.m.RecordOfValue_5;
import itemsadder.m.RecordOfValue_7;
import itemsadder.m.RecordOfValue_9;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Farmland;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.joml.Math;

public final class PluginBukkitTaskHolder
implements Listener {
    private static final int kB = 7;
    private static final int kC = 20;
    private final Plugin kD;
    private final ChunkLoadListener kE;
    private final int kF;
    private ExecutorService kG;
    private BukkitTask kH;
    private volatile boolean kI = false;

    public PluginBukkitTaskHolder(Plugin plugin, ChunkLoadListener chunkLoadListener, int n) {
        this.kD = plugin;
        this.kE = chunkLoadListener;
        this.kF = n;
    }

    public void bT() {
        this.kI = true;
        int n = Math.max((int)1, (int)(this.kF > 0 ? this.kF : Runtime.getRuntime().availableProcessors() - 1));
        if (this.kG != null && !this.kG.isShutdown()) {
            this.kG.shutdownNow();
        }
        this.kG = new ThreadPoolExecutor(n, n, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new Opaque106("ItemsAdder-Crops-Grow-Worker"));
        if (this.kH != null) {
            this.kH.cancel();
        }
        this.kH = Bukkit.getScheduler().runTaskTimer(this.kD, () -> {
            try {
                this.bV();
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }, 20L, 20L);
    }

    public void bU() {
        this.kI = false;
        if (this.kG != null) {
            this.kG.shutdownNow();
        }
        if (this.kH != null) {
            this.kH.cancel();
            this.kH = null;
        }
    }

    public void bV() {
        if (!this.kI || this.kG.isShutdown()) {
            return;
        }
        this.kE.a((T recordOfValue_7) -> {
            List list = recordOfValue_7.bh().bi();
            if (list.isEmpty()) {
                return;
            }
            RecordOfUUID recordOfUUID = recordOfValue_7.br();
            Chunk chunk = recordOfUUID.bt();
            if (chunk == null) {
                return;
            }
            int n = recordOfUUID.bo();
            int n2 = recordOfUUID.bp();
            boolean bl = chunk.getWorld().getPlayers().stream().anyMatch(player -> {
                Chunk chunk = player.getLocation().getChunk();
                int n3 = java.lang.Math.abs(chunk.getX() - n);
                int n4 = java.lang.Math.abs(chunk.getZ() - n2);
                return n3 <= 1 && n4 <= 1;
            });
            if (!bl) {
                return;
            }
            Integer n3 = (Integer)chunk.getWorld().getGameRuleValue(GameRule.RANDOM_TICK_SPEED);
            double d = n3 != null ? (double)n3.intValue() / 3.0 : 1.0;
            this.kG.submit(() -> {
                double d2 = 1.0;
                ArrayList<RecordOfValue_9> arrayList = new ArrayList<RecordOfValue_9>();
                ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                for (RecordOfValue_5 recordOfValue_5 : list) {
                    LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfValue_5.bj());
                    if (recordOfValue_5.bk() >= locationBridge_7.hK) continue;
                    double d3 = Math.clamp((double)(d2 / locationBridge_7.hP * d), (double)0.0, (double)1.0);
                    if (!(threadLocalRandom.nextDouble() < d3)) continue;
                    byte by = (byte)Math.min((int)(recordOfValue_5.bk() + 1), (int)locationBridge_7.hK);
                    arrayList.add(new RecordOfValue_9(recordOfValue_5.bl(), recordOfValue_5.bm(), recordOfValue_5.bn(), locationBridge_7, by));
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                Bukkit.getScheduler().runTask(this.kD, () -> this.a((RecordOfValue_7)recordOfValue_7, arrayList));
            });
        });
    }

    private void a(RecordOfValue_7 recordOfValue_7, List list) {
        int n = recordOfValue_7.bs();
        RecordOfUUID recordOfUUID = recordOfValue_7.br();
        Chunk chunk = recordOfUUID.bt();
        if (chunk == null) {
            return;
        }
        ArrayList<RecordOfValue_9> arrayList = new ArrayList<RecordOfValue_9>(list.size());
        for (RecordOfValue_9 recordOfValue_9 : list) {
            LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(recordOfValue_9.bv().hD);
            Block block = chunk.getBlock(recordOfValue_9.bl(), recordOfValue_9.bm(), recordOfValue_9.bn());
            byte by = block.getRelative(0, 1, 0).getLightLevel();
            if (by < locationBridge_7.hQ) continue;
            int n2 = 0;
            double d = 1.0;
            if (locationBridge_7.hT != 0.0) {
                Block block2 = block.getRelative(0, -1, 0);
                BlockData blockData = block2.getBlockData();
                if (blockData instanceof Farmland) {
                    Farmland farmland = (Farmland)blockData;
                    n2 = farmland.getMoisture();
                }
                d = Math.lerp((double)1.0, (double)locationBridge_7.hT, (double)((double)n2 / 7.0));
            }
            double d2 = this.a(block, locationBridge_7);
            double d3 = d * d2;
            int n3 = (int)d3;
            double d4 = d3 - (double)n3;
            boolean bl = false;
            for (int i = 0; i < n3; ++i) {
                bl = true;
            }
            if (!bl && d4 > 0.0) {
                boolean bl2 = bl = ThreadLocalRandom.current().nextDouble() < d4;
            }
            if (!bl) continue;
            arrayList.add(recordOfValue_9);
            CommandSenderBridge_5.iA("[Crops] Growth accepted at" + String.valueOf(block.getLocation()) + " to age " + recordOfValue_9.bw());
        }
        if (!arrayList.isEmpty()) {
            this.kE.a(recordOfUUID, n, arrayList);
        }
    }

    private double a(Block block, LocationBridge_7 locationBridge_7) {
        World world = block.getWorld();
        if (world.isThundering()) {
            return 1.0 + (double)locationBridge_7.hV;
        }
        if (world.hasStorm()) {
            return block.getTemperature() <= 0.15 ? 1.0 + (double)locationBridge_7.hW : 1.0 + (double)locationBridge_7.hU;
        }
        return 1.0;
    }
}
