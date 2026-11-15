package itemsadder.m;

import itemsadder.m.aaf;
import itemsadder.m.ae;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.wu;
import itemsadder.m.wy;
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

public class xc
extends wu {
    public static final String OT = "surface_decorator";
    public static List md = new ArrayList();
    private final boolean OU;
    public Map OO = new HashMap();

    public xc(World world) {
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
            bce.error("World is null in SurfaceDecorator. This is a bug.");
            return;
        }
        world.getPopulators().add(this);
    }

    @Override
    public void rN() {
        World world = this.cE();
        if (world == null) {
            bce.error("World is null in SurfaceDecorator. This is a bug.");
            return;
        }
        super.rN();
    }

    public void a(wy wy2) {
        super.a(wy2);
        this.OO.computeIfAbsent(wy2.Oi.Gi, n -> new ArrayList()).add(wy2);
    }

    public void populate(@NotNull World world, @NotNull Random random, @NotNull Chunk chunk) {
        for (wy wy2 : this.Ow) {
            this.a(chunk, random, wy2);
        }
    }

    private boolean a(Chunk chunk, Random random, wy wy2) {
        double d = bcy.Ds();
        if (wy2.On != -1.0 && d * 100.0 > wy2.On) {
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
        for (int i = 0; i < wy2.Oj; ++i) {
            while (!bl2 && n3 < 8) {
                ++n3;
                n4 = n + random.nextInt(xc.p(wy2.Oj / 2, 1)) - wy2.Oj / 4;
                n4 = xc.az(n4);
                n6 = n2 + random.nextInt(xc.p(wy2.Oj / 2, 1)) - wy2.Oj / 4;
                n6 = xc.az(n6);
                n5 = this.OU ? (int)((float)chunk.getWorld().getMaxHeight() / 4.0f) : aaf.a(chunk, n4 &= 0xF, n6 &= 0xF, HeightMap.MOTION_BLOCKING_NO_LEAVES) + 1;
                if (n5 > wy2.Ol || n5 < wy2.Om) {
                    bl2 = false;
                    continue;
                }
                block = chunk.getBlock(n4, n5, n6);
                block2 = block.getRelative(BlockFace.DOWN);
                if (!wy2.Oq && aaf.aN(block2)) {
                    bl2 = false;
                    continue;
                }
                bl2 = this.aJ(block) && wy2.aF(block) && wy2.z(block2.getType());
            }
            if (bl2) {
                wy2.aG(block);
                if (ae.eh) {
                    bce.log("Spawned " + wy2.Oi.getNamespacedID() + " surface decoration at " + bcc.bs(chunk.getBlock(n4, n5, n6)) + " in world " + chunk.getWorld().getName() + " " + bcc.bt(chunk.getBlock(n4, n5, n6)));
                }
            }
            n3 = 0;
            bl2 = false;
        }
        return bl;
    }

    private boolean aJ(Block block) {
        return block.getType().isAir() || aaf.tg().D(block.getType());
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
