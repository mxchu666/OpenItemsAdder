package itemsadder.m;

import itemsadder.m.BlockRegistry;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.WorldBridge_10;
import itemsadder.m.WorldBridge_7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.HeightMap;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.NotNull;

public class WorldBridge_13
extends WorldBridge_7 {
    public static final String OT = "surface_decorator";
    public static List md = new ArrayList();
    private final boolean OU;
    public Map OO = new HashMap();

    public WorldBridge_13(World world) {
        super(world);
        this.OU = world.getEnvironment() == World.Environment.NETHER;
    }

    @Override
    protected String ra() {
        return OT;
    }

    @Override
    public void hn() {
        World world = this.cE();
        if (world == null) {
            CommandSenderBridge_5.error("World is null in SurfaceDecorator. This is a bug.");
            return;
        }
        world.getPopulators().add(this);
    }

    @Override
    public void rN() {
        World world = this.cE();
        if (world == null) {
            CommandSenderBridge_5.error("World is null in SurfaceDecorator. This is a bug.");
            return;
        }
        super.rN();
    }

    public void a(WorldBridge_10 worldBridge_10) {
        super.a(worldBridge_10);
        this.OO.computeIfAbsent(worldBridge_10.Oi.Gi, n -> new ArrayList()).add(worldBridge_10);
    }

    public void populate(@NotNull World world, @NotNull Random random, @NotNull Chunk chunk) {
        for (WorldBridge_10 worldBridge_10 : this.Ow) {
            this.a(chunk, random, worldBridge_10);
        }
    }

    private boolean a(Chunk chunk, Random random, WorldBridge_10 worldBridge_10) {
        double d = ColorBridge.Ds();
        if (worldBridge_10.On != -1.0 && d * 100.0 > worldBridge_10.On) {
            return false;
        }
        int n = random.nextInt(15);
        int n2 = random.nextInt(15);
        boolean bl = false;
        boolean bl2 = false;
        int n3 = 0;
        Block block = null;
        Block block2 = null;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        for (int i = 0; i < worldBridge_10.Oj; ++i) {
            while (!bl2 && n3 < 8) {
                ++n3;
                n4 = n + random.nextInt(WorldBridge_13.p(worldBridge_10.Oj / 2, 1)) - worldBridge_10.Oj / 4;
                n4 = WorldBridge_13.az(n4);
                n6 = n2 + random.nextInt(WorldBridge_13.p(worldBridge_10.Oj / 2, 1)) - worldBridge_10.Oj / 4;
                n6 = WorldBridge_13.az(n6);
                n5 = this.OU ? (int)((float)chunk.getWorld().getMaxHeight() / 4.0f) : BlockRegistry.a(chunk, n4 &= 0xF, n6 &= 0xF, HeightMap.MOTION_BLOCKING_NO_LEAVES) + 1;
                if (n5 > worldBridge_10.Ol || n5 < worldBridge_10.Om) {
                    bl2 = false;
                    continue;
                }
                block = chunk.getBlock(n4, n5, n6);
                block2 = block.getRelative(BlockFace.DOWN);
                if (!worldBridge_10.Oq && BlockRegistry.aN(block2)) {
                    bl2 = false;
                    continue;
                }
                bl2 = this.aJ(block) && worldBridge_10.aF(block) && worldBridge_10.z(block2.getType());
            }
            if (bl2) {
                worldBridge_10.aG(block);
                if (MaterialBarColorHolder.eh) {
                    CommandSenderBridge_5.log("Spawned " + worldBridge_10.Oi.getNamespacedID() + " surface decoration at " + LocationBridge_2.bs(chunk.getBlock(n4, n5, n6)) + " in world " + chunk.getWorld().getName() + " " + LocationBridge_2.bt(chunk.getBlock(n4, n5, n6)));
                }
            }
            n3 = 0;
            bl2 = false;
        }
        return bl;
    }

    private boolean aJ(Block block) {
        return block.getType().isAir() || BlockRegistry.tg().D(block.getType());
    }

    public static int p(int n, int n2) {
        if (n <= 0) {
            return n2;
        }
        return n;
    }

    public static int az(int n) {
        if (n < 0) {
            return 0;
        }
        return Math.min(n, 15);
    }
}
