package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bci;
import itemsadder.m.bcp;
import itemsadder.m.jl;
import itemsadder.m.js;
import itemsadder.m.nd;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class nz
extends nd {
    final js Dd;

    public nz(js js2, boolean bl) {
        super(bl);
        this.Dd = js2;
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
        bci bci2 = jl.ap(playerInteractEvent.getPlayer());
        if (bci2 != null) {
            return pa.mk();
        }
        if (bcc.b(playerInteractEvent.getClickedBlock(), playerInteractEvent.getPlayer())) {
            if (playerInteractEvent.getPlayer().getGameMode() != GameMode.CREATIVE && this.Cq) {
                bbs.aj(itemStack);
            }
            bcp.c(() -> {
                Block block = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace());
                this.Dd.a(this.Dd.zk.mP(), block.getLocation(), block, playerInteractEvent.getHand(), playerInteractEvent.getPlayer(), null, playerInteractEvent.getBlockFace());
            }, 2L);
        }
        return pa.m(itemStack);
    }

    private pa a(Event event, Player player, ItemStack itemStack, Block block) {
        bci bci2 = jl.ap(player);
        if (bci2 != null) {
            return pa.mk();
        }
        if (bcc.b(block, player)) {
            this.Dd.a(this.Dd.zk.mP(), block.getLocation(), block, null, player, null, null);
            if (player.getGameMode() != GameMode.CREATIVE && this.Cq) {
                bbs.aj(itemStack);
            }
            return pa.ml();
        }
        return pa.mk();
    }
}
