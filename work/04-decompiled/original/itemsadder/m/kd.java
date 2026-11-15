package itemsadder.m;

import itemsadder.m.ki;
import itemsadder.m.qm;
import itemsadder.m.sh;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class kd
extends ki {
    public static final String yM = "liquid_bucket";
    sh yN;

    public kd(qm qm2, sh sh2) {
        super(qm2);
        this.yN = sh2;
    }

    public sh kU() {
        return this.yN;
    }

    public static boolean m(Block block) {
        return kd.c(block.getType());
    }

    public static boolean c(Material material) {
        return material == Material.WATER;
    }
}
