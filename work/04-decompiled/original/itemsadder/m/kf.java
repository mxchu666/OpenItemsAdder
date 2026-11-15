package itemsadder.m;

import itemsadder.m.aaf;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.ki;
import itemsadder.m.qm;
import itemsadder.m.wz;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class kf
extends ki {
    public static final String yR = "sapling";
    private final wz yS;

    public kf(qm qm2, wz wz2) {
        super(qm2);
        this.yS = wz2;
    }

    public wz kV() {
        return this.yS;
    }

    public void a(ItemStack itemStack, Player player, Block block) {
        if (this.yS == null) {
            return;
        }
        if (!bcc.b(block, player)) {
            return;
        }
        if (aaf.aJ(block)) {
            block.setType(Material.AIR, false);
        }
        if (this.yS.j(block, false)) {
            bbs.aj(itemStack);
        }
    }
}
