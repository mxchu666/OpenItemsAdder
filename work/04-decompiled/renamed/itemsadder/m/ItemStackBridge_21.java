package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.NamespacedKeyEntityTypeHolder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_21
extends Builder_14 {
    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        CommandSenderBridge_5.warn("remove_furniture action cannot be used on this event type.");
        return ItemStackBuilder_3.l(itemStack);
    }

    @Override
    public ItemStackBuilder_3 j(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerInteractEvent, playerInteractEvent.getPlayer(), itemStackBuilder_4, itemStack);
    }

    public ItemStackBuilder_3 a(PlayerInteractAtEntityEvent playerInteractAtEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerInteractAtEntityEvent, playerInteractAtEntityEvent.getPlayer(), itemStackBuilder_4, itemStack);
    }

    public ItemStackBuilder_3 a(Event event, Player player, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Entity entity = NamespacedKeyEntityTypeHolder.ao(player);
        if (entity == null) {
            return this.a(event, itemStackBuilder_4, itemStack, player);
        }
        ItemStackRegistry.g().aC.a(entity, player, false, true, false);
        return ItemStackBuilder_3.ml();
    }
}
