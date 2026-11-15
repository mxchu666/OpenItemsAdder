package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.wu;
import itemsadder.m.wv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public class xa
extends wu {
    public static final String ON = "block_populator";
    public static List md = new ArrayList();
    public final Map OO = new HashMap();

    public xa(World world) {
        super(world);
    }

    @Override
    protected String ra() {
        return ON;
    }

    public void a(wv wv2) {
        super.a(wv2);
        this.OO.computeIfAbsent(wv2.Oi.Gi, n -> new ArrayList()).add(wv2);
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
        this.OO.clear();
    }

    public void populate(@NotNull World world, @NotNull Random random, @NotNull Chunk chunk) {
        for (wv wv2 : this.Ow) {
            if (wv2.On != -1.0 && random.nextDouble() * 100.0 > wv2.On) continue;
            this.a(random, wv2, chunk);
        }
    }

    private void a(@NotNull Random random, wv wv2, @NotNull Chunk chunk) {
        for (int i = 0; i < wv2.OA; ++i) {
            this.a(chunk, random, wv2);
        }
    }

    private void a(Chunk chunk, Random random, wv wv2) {
        int n = random.nextInt(16);
        int n2 = bcy.a(random, wv2.Om, wv2.Ol);
        n2 = this.ay(n2);
        int n3 = random.nextInt(16);
        for (int i = 0; i < wv2.Oj; ++i) {
            int n4 = n + random.nextInt(Math.max(wv2.Oj / 2, 2)) - wv2.Oj / 4;
            int n5 = n2 + random.nextInt(Math.max(wv2.Oj / 4, 2)) - wv2.Oj / 8;
            n5 = this.ay(n5);
            int n6 = n3 + random.nextInt(Math.max(wv2.Oj / 2, 2)) - wv2.Oj / 4;
            Block block = chunk.getBlock(n4 &= 0xF, n5, n6 &= 0xF);
            this.a(block, chunk, wv2);
        }
    }

    private void a(Block block, Chunk chunk, wv wv2) {
        if (wv2.aH(block) && wv2.aF(block)) {
            wv2.aG(block);
            if (ae.ek) {
                bce.log("Spawned " + wv2.Oi.getNamespacedID() + " custom block at " + bcc.bs(block) + " in world " + chunk.getWorld().getName() + " " + bcc.bt(block));
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
