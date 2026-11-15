package itemsadder.m;

import itemsadder.m.BlockRegistry;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PluginContract;
import itemsadder.m.SurfaceEnum;
import itemsadder.m.WorldBridge_7;
import itemsadder.m.WorldBridge_9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class WorldBridge_12
extends WorldBridge_7
implements PluginContract {
    private static final String OP = "cave_decorator";
    public static List md = new ArrayList();
    public static Map OQ = new HashMap();
    public int OR;
    public int OS;

    public WorldBridge_12(World world) {
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
        PluginContract.super.unregister();
        super.rN();
    }

    public void a(WorldBridge_9 worldBridge_9) {
        super.a(worldBridge_9);
        if (this.Ow.size() == 1) {
            this.OR = worldBridge_9.Om;
            this.OS = worldBridge_9.Ol;
        } else {
            this.OR = Math.min(this.OR, worldBridge_9.Om);
            this.OS = Math.max(this.OS, worldBridge_9.Ol);
        }
    }

    public boolean a(List list, Chunk chunk, Random random, WorldBridge_9 worldBridge_9) {
        double d = ColorBridge.Ds();
        if (worldBridge_9.On != -1.0 && d * 100.0 > worldBridge_9.On) {
            return false;
        }
        int n = worldBridge_9.Oj > 0 ? random.nextInt(worldBridge_9.Oj) + 1 : 1;
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
            if ((n5 = block2.getY()) < worldBridge_9.Om || n5 > worldBridge_9.Ol) continue;
            Block block3 = block2.getRelative(BlockFace.DOWN);
            if (!worldBridge_9.Oq && BlockRegistry.aN(block3)) continue;
            Block block4 = block = worldBridge_9.OD == SurfaceEnum.CEILING ? block2.getRelative(BlockFace.UP) : block3;
            if (!block.getType().isSolid()) continue;
            if (this.aJ(block2) && worldBridge_9.aF(block2) && worldBridge_9.z(block.getType())) {
                worldBridge_9.aG(block2);
                bl = true;
                ++n2;
            }
            if (!bl || !MaterialBarColorHolder.ei) continue;
            CommandSenderBridge_5.log("Spawned " + worldBridge_9.Oi.getNamespacedID() + " cave decoration at " + LocationBridge_2.bs(block2) + " in world " + chunk.getWorld().getName() + " " + LocationBridge_2.bt(block2) + " - scanned " + list.size() + " AIR blocks.");
        }
        return bl;
    }

    private boolean aJ(Block block) {
        return block.getType().isAir() || BlockRegistry.tg().D(block.getType());
    }
}
