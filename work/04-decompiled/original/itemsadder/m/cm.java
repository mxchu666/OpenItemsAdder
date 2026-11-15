package itemsadder.m;

import itemsadder.m.bce;
import itemsadder.m.bp;
import itemsadder.m.br;
import itemsadder.m.bs;
import itemsadder.m.bt;
import itemsadder.m.bv;
import itemsadder.m.bx;
import itemsadder.m.cn;
import itemsadder.m.d;
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

public final class cm
implements Listener {
    private static final int kB = 7;
    private static final int kC = 20;
    private final Plugin kD;
    private final br kE;
    private final int kF;
    private ExecutorService kG;
    private BukkitTask kH;
    private volatile boolean kI = false;

    public cm(Plugin plugin, br br2, int n) {
        this.kD = plugin;
        this.kE = br2;
        this.kF = n;
    }

    public void bT() {
        this.kI = true;
        int n = Math.max((int)1, (int)(this.kF > 0 ? this.kF : Runtime.getRuntime().availableProcessors() - 1));
        if (this.kG != null && !this.kG.isShutdown()) {
            this.kG.shutdownNow();
        }
        this.kG = new ThreadPoolExecutor(n, n, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new cn("ItemsAdder-Crops-Grow-Worker"));
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
        this.kE.a((T bs2) -> {
            List list = bs2.bh().bi();
            if (list.isEmpty()) {
                return;
            }
            bt bt2 = bs2.br();
            Chunk chunk = bt2.bt();
            if (chunk == null) {
                return;
            }
            int n = bt2.bo();
            int n2 = bt2.bp();
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
            double d2 = n3 != null ? (double)n3.intValue() / 3.0 : 1.0;
            this.kG.submit(() -> {
                double d3 = 1.0;
                ArrayList<bv> arrayList = new ArrayList<bv>();
                ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                for (bp bp2 : list) {
                    bx bx2 = (bx)d.g().ab.get(bp2.bj());
                    if (bp2.bk() >= bx2.hK) continue;
                    double d4 = Math.clamp((double)(d3 / bx2.hP * d2), (double)0.0, (double)1.0);
                    if (!(threadLocalRandom.nextDouble() < d4)) continue;
                    byte by2 = (byte)Math.min((int)(bp2.bk() + 1), (int)bx2.hK);
                    arrayList.add(new bv(bp2.bl(), bp2.bm(), bp2.bn(), bx2, by2));
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                Bukkit.getScheduler().runTask(this.kD, () -> this.a((bs)bs2, arrayList));
            });
        });
    }

    private void a(bs bs2, List list) {
        int n = bs2.bs();
        bt bt2 = bs2.br();
        Chunk chunk = bt2.bt();
        if (chunk == null) {
            return;
        }
        ArrayList<bv> arrayList = new ArrayList<bv>(list.size());
        for (bv bv2 : list) {
            bx bx2 = (bx)d.g().ab.get(bv2.bv().hD);
            Block block = chunk.getBlock(bv2.bl(), bv2.bm(), bv2.bn());
            byte by2 = block.getRelative(0, 1, 0).getLightLevel();
            if (by2 < bx2.hQ) continue;
            int n2 = 0;
            double d2 = 1.0;
            if (bx2.hT != 0.0) {
                Block block2 = block.getRelative(0, -1, 0);
                BlockData blockData = block2.getBlockData();
                if (blockData instanceof Farmland) {
                    Farmland farmland = (Farmland)blockData;
                    n2 = farmland.getMoisture();
                }
                d2 = Math.lerp((double)1.0, (double)bx2.hT, (double)((double)n2 / 7.0));
            }
            double d3 = this.a(block, bx2);
            double d4 = d2 * d3;
            int n3 = (int)d4;
            double d5 = d4 - (double)n3;
            boolean bl = false;
            for (int i = 0; i < n3; ++i) {
                bl = true;
            }
            if (!bl && d5 > 0.0) {
                boolean bl2 = bl = ThreadLocalRandom.current().nextDouble() < d5;
            }
            if (!bl) continue;
            arrayList.add(bv2);
            bce.iA("[Crops] Growth accepted at" + String.valueOf(block.getLocation()) + " to age " + bv2.bw());
        }
        if (!arrayList.isEmpty()) {
            this.kE.a(bt2, n, arrayList);
        }
    }

    private double a(Block block, bx bx2) {
        World world = block.getWorld();
        if (world.isThundering()) {
            return 1.0 + (double)bx2.hV;
        }
        if (world.hasStorm()) {
            return block.getTemperature() <= 0.15 ? 1.0 + (double)bx2.hW : 1.0 + (double)bx2.hU;
        }
        return 1.0;
    }
}
