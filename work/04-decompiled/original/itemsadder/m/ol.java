package itemsadder.m;

import itemsadder.m.jl;
import itemsadder.m.js;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ol
extends ou {
    public final qm DA;
    public final boolean DB;

    public ol(qm qm2, boolean bl) {
        this.DA = qm2;
        this.DB = bl;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return pa.l(itemStack);
        }
        if (qm.C(itemStack) != this.DA.fX()) {
            qm.b(itemStack, this.DA.fX());
            return pa.m(itemStack);
        }
        if (this.DB) {
            qm.b(itemStack, qm2.fX());
            return pa.m(itemStack);
        }
        return pa.l(itemStack);
    }

    @Override
    public pa j(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        Entity entity = jl.ao(playerInteractEvent.getPlayer());
        if (entity == null) {
            return this.a((Event)playerInteractEvent, qm2, itemStack, playerInteractEvent.getPlayer());
        }
        boolean bl = js.a(this.DA, qm2, entity);
        return bl ? pa.ml() : pa.mk();
    }
}
