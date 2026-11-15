package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.WorldBridge_7;
import itemsadder.m.WorldBridge_8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public class ChunkBridge_3
extends WorldBridge_7 {
    public static final String ON = "block_populator";
    public static List md = new ArrayList();
    public final Map OO = new HashMap();

    public ChunkBridge_3(World world) {
        super(world);
    }

    @Override
    protected String ra() {
        return ON;
    }

    public void a(WorldBridge_8 worldBridge_8) {
        super.a(worldBridge_8);
        this.OO.computeIfAbsent(worldBridge_8.Oi.Gi, n -> new ArrayList()).add(worldBridge_8);
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
        this.OO.clear();
    }

    public void populate(@NotNull World world, @NotNull Random random, @NotNull Chunk chunk) {
        for (WorldBridge_8 worldBridge_8 : this.Ow) {
            if (worldBridge_8.On != -1.0 && random.nextDouble() * 100.0 > worldBridge_8.On) continue;
            this.a(random, worldBridge_8, chunk);
        }
    }

    private void a(@NotNull Random random, WorldBridge_8 worldBridge_8, @NotNull Chunk chunk) {
        for (int i = 0; i < worldBridge_8.OA; ++i) {
            this.a(chunk, random, worldBridge_8);
        }
    }

    private void a(Chunk chunk, Random random, WorldBridge_8 worldBridge_8) {
        int n = random.nextInt(16);
        int n2 = ColorBridge.a(random, worldBridge_8.Om, worldBridge_8.Ol);
        n2 = this.ay(n2);
        int n3 = random.nextInt(16);
        for (int i = 0; i < worldBridge_8.Oj; ++i) {
            int n4 = n + random.nextInt(Math.max(worldBridge_8.Oj / 2, 2)) - worldBridge_8.Oj / 4;
            int n5 = n2 + random.nextInt(Math.max(worldBridge_8.Oj / 4, 2)) - worldBridge_8.Oj / 8;
            n5 = this.ay(n5);
            int n6 = n3 + random.nextInt(Math.max(worldBridge_8.Oj / 2, 2)) - worldBridge_8.Oj / 4;
            Block block = chunk.getBlock(n4 &= 0xF, n5, n6 &= 0xF);
            this.a(block, chunk, worldBridge_8);
        }
    }

    private void a(Block block, Chunk chunk, WorldBridge_8 worldBridge_8) {
        if (worldBridge_8.aH(block) && worldBridge_8.aF(block)) {
            worldBridge_8.aG(block);
            if (MaterialBarColorHolder.ek) {
                CommandSenderBridge_5.log("Spawned " + worldBridge_8.Oi.getNamespacedID() + " custom block at " + LocationBridge_2.bs(block) + " in world " + chunk.getWorld().getName() + " " + LocationBridge_2.bt(block));
            }
        }
    }

    int ay(int n) {
        if (n > this.Oy) {
            return this.Oy;
        }
        if (n < this.Ox) {
            return this.Ox;
        }
        return n;
    }
}
