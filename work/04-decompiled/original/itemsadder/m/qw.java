package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.ra;
import itemsadder.m.sc;
import itemsadder.m.sd;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Fire;

public class qw
extends ra {
    public sc Hl;

    public qw(bbf bbf2, String string, String string2, Material material, int n) {
        super(bbf2, string, string2, material, sd.FIRE);
        this.Hl = new sc(n);
    }

    @Override
    public boolean f(Block block, boolean bl) {
        if (!block.getRelative(BlockFace.DOWN).getType().isSolid()) {
            return false;
        }
        Fire fire = (Fire)Bukkit.createBlockData((Material)Material.FIRE);
        fire.setAge(this.Hl.kh);
        ms ms2 = d.g().b(block);
        ms2.e(block, this.getNamespacedID());
        ms2.b(block, 0);
        block.setBlockData((BlockData)fire, bl);
        return true;
    }

    @Override
    public boolean as(Block block) {
        return this.f(block, false);
    }

    @Override
    public boolean M(Location location) {
        return this.as(location.getBlock());
    }

    @Override
    public boolean ar(Block block) {
        return this.as(block);
    }

    @Override
    public boolean e(Block block, boolean bl) {
        return this.f(block, bl);
    }

    public static int getAge(Block block) {
        Integer n;
        ms ms2 = d.g().b(block);
        if (ms2.T(block) && (n = ms2.ae(block)) != null) {
            return n;
        }
        return 0;
    }

    public static void setAge(Block block, int n) {
        ms ms2 = d.g().b(block);
        ms2.b(block, n);
    }
}
