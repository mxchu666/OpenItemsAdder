package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.wu;
import itemsadder.m.wz;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public class xd
extends wu {
    public static final String OV = "tree_populator";
    public static List md = new ArrayList();
    public static HashSet OW = new HashSet();

    public xd(World world) {
        super(world);
    }

    @Override
    protected String ra() {
        return OV;
    }

    public void populate(@NotNull World world, @NotNull Random random, @NotNull Chunk chunk) {
        for (wz wz2 : this.Ow) {
            for (int i = 0; i < wz2.OH; ++i) {
                this.a(chunk, random, wz2);
            }
        }
    }

    public static boolean q(int n, int n2) {
        return OW.contains(xd.r(n, n2));
    }

    @Override
    public void hn() {
        World world = this.cE();
        if (world == null) {
            bce.error("World is null in WorldTreePopulator. This is a bug.");
            return;
        }
        world.getPopulators().add(this);
    }

    @Override
    public void rN() {
        World world = this.cE();
        if (world == null) {
            bce.error("World is null in WorldTreePopulator. This is a bug.");
            return;
        }
        super.rN();
    }

    private static int r(int n, int n2) {
        return n2 ^ n << 16;
    }

    private boolean a(Chunk chunk, Random random, wz wz2) {
        double d = bcy.Ds();
        if (wz2.On != -1.0 && d * 100.0 > wz2.On) {
            return false;
        }
        int n = random.nextInt(15);
        int n2 = 1;
        if (wz2.Om != 0 || wz2.Ol != 0) {
            n2 = bcy.a(random, wz2.Om, wz2.Ol);
        }
        n2 = this.aA(n2);
        int n3 = random.nextInt(15);
        OW.add(xd.r(chunk.getX(), chunk.getZ()));
        boolean bl = false;
        for (int i = 0; i < wz2.Oj; ++i) {
            int n4 = n + random.nextInt(this.p(wz2.Oj / 2, 1)) - wz2.Oj / 4;
            n4 = this.az(n4);
            int n5 = n2 + random.nextInt(this.p(wz2.Oj / 4, 1)) - wz2.Oj / 8;
            n5 = this.aA(n5);
            int n6 = n3 + random.nextInt(this.p(wz2.Oj / 2, 1)) - wz2.Oj / 4;
            n6 = this.az(n6);
            Block block = chunk.getBlock(n4 &= 0xF, n5, n6 &= 0xF);
            if (!wz2.aF(block) || !wz2.aI(block) || !ae.el) continue;
            bce.log("Spawned " + wz2.Oi.getNamespacedID() + " tree at " + bcc.bs(block) + " in world " + chunk.getWorld().getName() + " " + bcc.bt(block));
        }
        OW.remove(xd.r(chunk.getX(), chunk.getZ()));
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
