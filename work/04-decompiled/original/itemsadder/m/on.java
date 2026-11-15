package itemsadder.m;

import itemsadder.m.abk;
import itemsadder.m.aqp;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.nd;
import itemsadder.m.oo;
import itemsadder.m.pa;
import itemsadder.m.ql;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class on
extends nd {
    final ql DD;
    final Material DE;
    private final oo DF;

    public on(ql ql2, oo oo2, boolean bl) {
        super(bl);
        this.DD = ql2;
        this.DF = oo2;
        this.DE = null;
    }

    public on(Material material, oo oo2, boolean bl) {
        super(bl);
        this.DE = material;
        this.DF = oo2;
        this.DD = null;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        return this.a(event, player, itemStack, player.getLocation().getBlock());
    }

    @Override
    public pa a(Event event, Block block, qm qm2, ItemStack itemStack, Player player) {
        return this.a(event, player, itemStack, block);
    }

    @Override
    public pa j(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        if (playerInteractEvent.getClickedBlock() == null) {
            return pa.l(itemStack);
        }
        if (itemStack == null || itemStack.getType() == Material.AIR || bbs.G(itemStack) || qm.G(itemStack)) {
            return pa.l(itemStack);
        }
        bcp.c(() -> {
            Player player = playerInteractEvent.getPlayer();
            Block block = this.DF == oo.CLICKED ? playerInteractEvent.getClickedBlock() : playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace());
            boolean bl = false;
            if (this.DD != null) {
                bl = d.g().aE.a(playerInteractEvent, this.DD, this.DD.mP(), false, false);
            } else if (this.DE != null && bcc.b(block, player)) {
                block.setType(this.DE);
                abk.t(block);
                bl = true;
            }
            if (bl && this.Cq) {
                bbs.aj(itemStack);
            }
        }, 2L);
        return pa.m(itemStack);
    }

    private pa a(Event event, Player player, ItemStack itemStack, Block block) {
        if (itemStack == null || itemStack.getType() == Material.AIR || bbs.G(itemStack) || qm.G(itemStack)) {
            return pa.mk();
        }
        Block block2 = aqp.bZ(player);
        if (bcc.b(block2, player)) {
            boolean bl = false;
            if (this.DD != null) {
                bl = this.DD.as(block2);
                if (bl) {
                    this.DD.xu.HQ.a(block2.getLocation(), SoundCategory.BLOCKS);
                }
            } else if (this.DE != null) {
                block2.setType(this.DE);
                abk.t(block2);
                bl = true;
            }
            if (bl) {
                aqp.a(player, EquipmentSlot.HAND);
                if (this.Cq) {
                    bbs.aj(itemStack);
                }
                return pa.ml();
            }
        }
        return pa.mk();
    }
}
