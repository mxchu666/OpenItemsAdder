package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bcp;
import itemsadder.m.lg;
import itemsadder.m.ou;
import itemsadder.m.ow;
import itemsadder.m.ox;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class oi
extends ou {
    final ow Dv;

    public oi(ow ow2) {
        this.Dv = ow2;
    }

    public oi(ox ox2, ox ox3, int n, int n2, boolean bl) {
        this(new ow(ox2, ox3, n, n2, bl));
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        return this.a(event, player, qm2, itemStack, player.getLocation().getBlock());
    }

    @Override
    public pa a(Event event, Block block, qm qm2, ItemStack itemStack, Player player) {
        return this.a(event, player, qm2, itemStack, block);
    }

    @Override
    public pa a(lg lg2, qm qm2, ItemStack itemStack) {
        Block block = lg2.getBlock();
        Player player = lg2.getPlayer();
        if (block == null) {
            return pa.mk();
        }
        if (this.Dv.DU.ap(block)) {
            if (!bcc.b(block, player)) {
                return pa.mk();
            }
            lg2.setCancelled(true);
            bcp.c(() -> this.Dv.ao(block), 5L);
            return pa.ml();
        }
        return pa.mk();
    }

    private pa a(Event event, Player player, qm qm2, ItemStack itemStack, Block block) {
        if (block == null) {
            return pa.mk();
        }
        if (itemStack == null || itemStack.getType() == Material.AIR || bbs.G(itemStack) || qm.G(itemStack)) {
            return pa.mk();
        }
        if (!bcc.b(block, player)) {
            return pa.mk();
        }
        if (this.Dv.DU.ap(block)) {
            if (!bcc.b(block, player)) {
                return pa.mk();
            }
            if (event instanceof Cancellable) {
                ((Cancellable)event).setCancelled(true);
            }
            this.Dv.ao(block);
            if (this.Dv.DW > 0) {
                qm.a(itemStack, this.Dv.DW, (LivingEntity)player);
            }
            if (this.Dv.DX > 0) {
                bbs.i(itemStack, this.Dv.DX);
            }
            return pa.ml();
        }
        return pa.mk();
    }
}
