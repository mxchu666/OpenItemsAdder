package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bda;
import itemsadder.m.ou;
import itemsadder.m.ox;
import itemsadder.m.oy;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class ok
extends ou {
    final oy Dz;

    public ok(oy oy2) {
        this.Dz = oy2;
    }

    public ok(ox ox2, ox ox3, int n, int n2, int n3, int n4, int n5, boolean bl) {
        this(new oy(ox2, ox3, new bda(Math.max(n - 1, 1), Math.max(n2 - 1, 1), Math.max(n3 - 1, 1)), n4, n5, bl));
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        return this.a(player, itemStack, player.getLocation().getBlock());
    }

    @Override
    public pa a(Event event, Block block, qm qm2, ItemStack itemStack, Player player) {
        return this.a(player, itemStack, block);
    }

    private pa a(Player player, ItemStack itemStack, Block block) {
        if (block == null) {
            return pa.mk();
        }
        if (itemStack == null || itemStack.getType() == Material.AIR || bbs.G(itemStack) || qm.G(itemStack)) {
            return pa.mk();
        }
        boolean bl = false;
        float f = -(this.Dz.Eb.aBp / 2.0f);
        while (f < this.Dz.Eb.aBp) {
            float f2 = -(this.Dz.Eb.aBq / 2.0f);
            while (f2 < this.Dz.Eb.aBq) {
                float f3 = -(this.Dz.Eb.aBr / 2.0f);
                while (f3 < this.Dz.Eb.aBr) {
                    Block block2 = block.getLocation().add((double)f, (double)f2, (double)f3).getBlock();
                    if (this.Dz.DU.ap(block2) && bcc.b(block, player)) {
                        bl = true;
                        this.Dz.ao(block2);
                    }
                    f3 = (float)((double)f3 + 0.5);
                }
                f2 = (float)((double)f2 + 0.5);
            }
            f = (float)((double)f + 0.5);
        }
        if (this.Dz.DW > 0 && bl) {
            qm.a(itemStack, this.Dz.DW, (LivingEntity)player);
        }
        if (this.Dz.DX > 0) {
            bbs.i(itemStack, this.Dz.DX);
        }
        return bl ? pa.ml() : pa.mk();
    }
}
