package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class pf
implements ai {
    public pf(d d2) {
        d2.ar.a(new my(PlayerInteractEvent.class, this::k));
        d2.ar.a(new my(PlayerEditBookEvent.class, this::b));
    }

    @mz
    void k(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        if (playerInteractEvent.getItem() == null) {
            return;
        }
        if (playerInteractEvent.getItem().getType() != Material.WRITTEN_BOOK && playerInteractEvent.getItem().getType() != Material.WRITABLE_BOOK) {
            return;
        }
        qm2.a((LivingEntity)playerInteractEvent.getPlayer(), jj.BOOK_READ, ou2 -> ou2.j(playerInteractEvent, qm2, itemStack));
    }

    @mz
    void b(PlayerEditBookEvent playerEditBookEvent, qm qm2, ItemStack itemStack) {
        if (!qm2.Gd.a(jj.BOOK_WRITE)) {
            return;
        }
        bcp.c(() -> {
            qm.a(itemStack, qm2.getNamespace(), qm2.getId());
            qm2.a((LivingEntity)playerEditBookEvent.getPlayer(), jj.BOOK_WRITE, ou2 -> ou2.a(playerEditBookEvent, qm2, itemStack));
        }, 2L);
    }
}
