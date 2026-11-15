package itemsadder.m;

import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.jl;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class og
extends ou {
    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        bce.warn("remove_furniture action cannot be used on this event type.");
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
        d.g().aC.a(entity, player, false, true, false);
        return pa.ml();
    }
}
