package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.WorldBridge_11;
import itemsadder.m.WorldBridge_7;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public class WorldBridge_14
extends WorldBridge_7 {
    public static final String OV = "tree_populator";
    public static List md = new ArrayList();
    public static HashSet OW = new HashSet();

    public WorldBridge_14(World world) {
        super(world);
    }

    @Override
    protected String ra() {
        return OV;
    }

    public void populate(@NotNull World world, @NotNull Random random, @NotNull Chunk chunk) {
        for (WorldBridge_11 worldBridge_11 : this.Ow) {
            for (int i = 0; i < worldBridge_11.OH; ++i) {
                this.a(chunk, random, worldBridge_11);
            }
        }
    }

    public static boolean q(int n, int n2) {
        return OW.contains(WorldBridge_14.r(n, n2));
    }

    @Override
    public void hn() {
        World world = this.cE();
        if (world == null) {
            CommandSenderBridge_5.error("World is null in WorldTreePopulator. This is a bug.");
            return;
        }
        world.getPopulators().add(this);
    }

    @Override
    public void rN() {
        World world = this.cE();
        if (world == null) {
            CommandSenderBridge_5.error("World is null in WorldTreePopulator. This is a bug.");
            return;
        }
        super.rN();
    }

    private static int r(int n, int n2) {
        return n2 ^ n << 16;
    }

    private boolean a(Chunk chunk, Random random, WorldBridge_11 worldBridge_11) {
        double d = ColorBridge.Ds();
        if (worldBridge_11.On != -1.0 && d * 100.0 > worldBridge_11.On) {
            return false;
        }
        int n = random.nextInt(15);
        int n2 = 1;
        if (worldBridge_11.Om != 0 || worldBridge_11.Ol != 0) {
            n2 = ColorBridge.a(random, worldBridge_11.Om, worldBridge_11.Ol);
        }
        n2 = this.aA(n2);
        int n3 = random.nextInt(15);
        OW.add(WorldBridge_14.r(chunk.getX(), chunk.getZ()));
        boolean bl = false;
        for (int i = 0; i < worldBridge_11.Oj; ++i) {
            int n4 = n + random.nextInt(this.p(worldBridge_11.Oj / 2, 1)) - worldBridge_11.Oj / 4;
            n4 = this.az(n4);
            int n5 = n2 + random.nextInt(this.p(worldBridge_11.Oj / 4, 1)) - worldBridge_11.Oj / 8;
            n5 = this.aA(n5);
            int n6 = n3 + random.nextInt(this.p(worldBridge_11.Oj / 2, 1)) - worldBridge_11.Oj / 4;
            n6 = this.az(n6);
            Block block = chunk.getBlock(n4 &= 0xF, n5, n6 &= 0xF);
            if (!worldBridge_11.aF(block) || !worldBridge_11.aI(block) || !MaterialBarColorHolder.el) continue;
            CommandSenderBridge_5.log("Spawned " + worldBridge_11.Oi.getNamespacedID() + " tree at " + LocationBridge_2.bs(block) + " in world " + chunk.getWorld().getName() + " " + LocationBridge_2.bt(block));
        }
        OW.remove(WorldBridge_14.r(chunk.getX(), chunk.getZ()));
        return bl;
    }

    int p(int n, int n2) {
        if (n <= 0) {
            return n2;
        }
        return n;
    }

    int az(int n) {
        if (n < 0) {
            return 0;
        }
        return Math.min(n, 15);
    }

    int aA(int n) {
        if (n > this.Oy) {
            return this.Oy;
        }
        if (n < this.Ox) {
            return this.Ox;
        }
        return n;
    }
}
