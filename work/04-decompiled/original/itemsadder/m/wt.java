package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.axi;
import itemsadder.m.ql;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

public abstract class wt {
    public String oz;
    public final ql Oi;
    public final int Oj;
    public final String Ok;
    public final int Ol;
    public final int Om;
    public final double On;
    public final HashSet Oo;
    public final HashSet Op;
    public boolean Oq;
    public final List Or;
    public final boolean Os;

    protected wt(String string, String string2, @NotNull List list, ql ql2, int n, int n2, int n3, double d) {
        this.oz = string;
        this.Ok = string2;
        this.Ol = n2;
        this.Om = n3;
        if (n3 >= n2) {
            throw new IllegalArgumentException("min_height must be less than max_height");
        }
        this.Oi = ql2;
        this.Oj = n;
        this.On = d;
        this.Oo = new HashSet();
        this.Op = new HashSet();
        this.Or = list;
        this.Os = list.contains("*");
    }

    public void c(Object object) {
        this.Oo.add(object);
    }

    public boolean cK(String string) {
        NamespacedKey namespacedKey = axi.dQ(string);
        if (namespacedKey == null) {
            return false;
        }
        Object object = axi.vC().j(namespacedKey);
        if (object == null) {
            return false;
        }
        this.c(object);
        return true;
    }

    public void y(Material material) {
        this.Op.add(material);
        if (material == Material.WATER || material == Material.LAVA) {
            this.Oq = true;
        }
    }

    public boolean z(Material material) {
        if (this.Op.isEmpty()) {
            return true;
        }
        return this.Op.contains(material);
    }

    public boolean aF(Block block) {
        if (this.Oo.isEmpty()) {
            return true;
        }
        Object object = axi.vC().bg(block);
        if (object == null) {
            return false;
        }
        return this.Oo.contains(object);
    }

    protected boolean j(World world) {
        if (!ae.eT.x(world)) {
            return false;
        }
        if (this.Os) {
            return true;
        }
        if (this.Or.contains(world.getName())) {
            return true;
        }
        for (String string : this.Or) {
            if (!FilenameUtils.wildcardMatch((String)world.getName(), (String)string)) continue;
            return true;
        }
        return false;
    }

    public void aG(Block block) {
        this.Oi.a(null, block, true, false, false, false);
    }

    public abstract void k(World var1);
}
