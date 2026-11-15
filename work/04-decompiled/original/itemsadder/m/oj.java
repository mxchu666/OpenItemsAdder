package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.jl;
import itemsadder.m.js;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class oj
extends ou {
    final js Dw;
    private final int Dx;
    private final int Dy;

    public oj(js js2, int n, int n2) {
        this.Dw = js2;
        this.Dx = n;
        this.Dy = n2;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        bce.warn("replace_furniture action cannot be used on this event type.");
        return pa.l(itemStack);
    }

    @Override
    public pa j(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerInteractEvent, playerInteractEvent.getPlayer(), qm2, itemStack);
    }

    public pa a(PlayerInteractAtEntityEvent playerInteractAtEntityEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerInteractAtEntityEvent, playerInteractAtEntityEvent.getPlayer(), qm2, itemStack);
    }

    public pa a(Event event, Player player, qm qm2, ItemStack itemStack) {
        Entity entity = jl.ao(player);
        if (entity == null) {
            return this.a(event, qm2, itemStack, player);
        }
        if (bcc.b(entity.getLocation().getBlock(), player)) {
            int n;
            if (this.Dy > 0) {
                if (itemStack.getAmount() < this.Dy) {
                    return pa.l(itemStack);
                }
                bbs.i(itemStack, this.Dy);
            }
            if (this.Dx > 0) {
                n = bbs.al(itemStack);
                if ((n -= this.Dx) <= 0) {
                    return pa.l(itemStack);
                }
                bbs.d(itemStack, n);
            }
            return (n = (int)(js.a(this.Dw.zk, qm2, entity) ? 1 : 0)) != 0 ? pa.ml() : pa.mk();
        }
        return pa.mk();
    }
}
