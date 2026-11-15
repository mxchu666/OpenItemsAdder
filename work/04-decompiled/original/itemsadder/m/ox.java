package itemsadder.m;

import itemsadder.m.bbi;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.ra;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class ox {
    public boolean DZ;
    public Material bE;
    public ra Ea;

    public ox(Material material) {
        this.DZ = false;
        this.bE = material;
    }

    public ox(ra ra2) {
        this.DZ = true;
        this.Ea = ra2;
    }

    public static ox by(String string) {
        if (!d.g().f(string)) {
            Material material = (Material)bbi.e(string.toUpperCase(), Material.class);
            if (material == null) {
                throw new IllegalArgumentException("Unknown item/material: " + string);
            }
            return new ox(material);
        }
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            throw new IllegalArgumentException("Unknown item/material: " + string);
        }
        if (qm2 instanceof ra) {
            return new ox((ra)qm2);
        }
        throw new IllegalArgumentException("Item is not placeable: " + string);
    }

    public boolean ap(Block block) {
        if (this.DZ) {
            if (ql.av(block)) {
                ms ms2 = d.g().b(block);
                if (!ms2.isCustomBlock(block)) {
                    return false;
                }
                ra ra2 = (ra)d.g().e(ms2.Y(block));
                if (ra2 == null) {
                    return false;
                }
                return ra2.equals(this.Ea);
            }
        } else {
            return block.getType().equals((Object)this.bE);
        }
        return false;
    }

    public String mj() {
        if (this.DZ) {
            return this.Ea.Gh;
        }
        return this.bE.toString();
    }
}
