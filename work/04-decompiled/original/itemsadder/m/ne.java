package itemsadder.m;

import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ne
extends ou {
    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        if (event instanceof Cancellable) {
            ((Cancellable)event).setCancelled(true);
            return pa.ml();
        }
        return pa.mk();
    }

    @Override
    public pa j(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        if (playerInteractEvent.getClickedBlock() != null) {
            playerInteractEvent.setCancelled(true);
            return pa.m(itemStack);
        }
        return pa.l(itemStack);
    }

    @Override
    public pa a(PlayerPickupItemEvent playerPickupItemEvent, qm qm2, ItemStack itemStack) {
        playerPickupItemEvent.setCancelled(true);
        playerPickupItemEvent.getItem().setPickupDelay(40);
        return pa.m(itemStack);
    }
}
