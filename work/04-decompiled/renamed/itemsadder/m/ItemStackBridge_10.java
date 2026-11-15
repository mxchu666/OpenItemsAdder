package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_10
extends Builder_14 {
    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        if (event instanceof Cancellable) {
            ((Cancellable)event).setCancelled(true);
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }

    @Override
    public ItemStackBuilder_3 j(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (playerInteractEvent.getClickedBlock() != null) {
            playerInteractEvent.setCancelled(true);
            return ItemStackBuilder_3.m(itemStack);
        }
        return ItemStackBuilder_3.l(itemStack);
    }

    @Override
    public ItemStackBuilder_3 a(PlayerPickupItemEvent playerPickupItemEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        playerPickupItemEvent.setCancelled(true);
        playerPickupItemEvent.getItem().setPickupDelay(40);
        return ItemStackBuilder_3.m(itemStack);
    }
}
