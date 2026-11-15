package itemsadder.m;

import itemsadder.m.aaf;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.wu;
import itemsadder.m.ww;
import itemsadder.m.wx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class xb
extends wu
implements ai {
    private static final String OP = "cave_decorator";
    public static List md = new ArrayList();
    public static Map OQ = new HashMap();
    public int OR;
    public int OS;

    public xb(World world) {
        super(world);
    }

    @Override
    protected String ra() {
        return OP;
    }

    @Override
    public void hn() {
    }

    @Override
    public void rN() {
        ai.super.unregister();
        super.rN();
    }

    public void a(ww ww2) {
        super.a(ww2);
        if (this.Ow.size() == 1) {
            this.OR = ww2.Om;
            this.OS = ww2.Ol;
        } else {
            this.OR = Math.min(this.OR, ww2.Om);
            this.OS = Math.max(this.OS, ww2.Ol);
        }
    }

    public boolean a(List list, Chunk chunk, Random random, ww ww2) {
        double d = bcy.Ds();
        if (ww2.On != -1.0 && d * 100.0 > ww2.On) {
            return false;
        }
        int n = ww2.Oj > 0 ? random.nextInt(ww2.Oj) + 1 : 1;
        int n2 = 0;
        int n3 = list.size();
        if (n3 == 0) {
            return false;
        }
        boolean bl = false;
        int n4 = random.nextInt(n3);
        for (int i = 0; i < n3 && n2 < n; ++i) {
            Block block;
            int n5;
            Block block2 = (Block)list.get(n4);
            if (++n4 == n3) {
                n4 = 0;
            }
            if ((n5 = block2.getY()) < ww2.Om || n5 > ww2.Ol) continue;
            Block block3 = block2.getRelative(BlockFace.DOWN);
            if (!ww2.Oq && aaf.aN(block3)) continue;
            Block block4 = block = ww2.OD == wx.CEILING ? block2.getRelative(BlockFace.UP) : block3;
            if (!block.getType().isSolid()) continue;
            if (this.aJ(block2) && ww2.aF(block2) && ww2.z(block.getType())) {
                ww2.aG(block2);
                bl = true;
                ++n2;
            }
            if (!bl || !ae.ei) continue;
            bce.log("Spawned " + ww2.Oi.getNamespacedID() + " cave decoration at " + bcc.bs(block2) + " in world " + chunk.getWorld().getName() + " " + bcc.bt(block2) + " - scanned " + list.size() + " AIR blocks.");
        }
        return bl;
    }

    private boolean aJ(Block block) {
        return block.getType().isAir() || aaf.tg().D(block.getType());
    }
}
