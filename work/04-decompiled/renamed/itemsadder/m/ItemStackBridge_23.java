package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.NamespacedKeyEntityTypeHolder;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_23
extends Builder_14 {
    final NamespacedKeyItemDisplayHolder Dw;
    private final int Dx;
    private final int Dy;

    public ItemStackBridge_23(NamespacedKeyItemDisplayHolder namespacedKeyItemDisplayHolder, int n, int n2) {
        this.Dw = namespacedKeyItemDisplayHolder;
        this.Dx = n;
        this.Dy = n2;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        CommandSenderBridge_5.warn("replace_furniture action cannot be used on this event type.");
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
        if (LocationBridge_2.b(entity.getLocation().getBlock(), player)) {
            int n;
            if (this.Dy > 0) {
                if (itemStack.getAmount() < this.Dy) {
                    return ItemStackBuilder_3.l(itemStack);
                }
                ItemStackBridge_2.i(itemStack, this.Dy);
            }
            if (this.Dx > 0) {
                n = ItemStackBridge_2.al(itemStack);
                if ((n -= this.Dx) <= 0) {
                    return ItemStackBuilder_3.l(itemStack);
                }
                ItemStackBridge_2.d(itemStack, n);
            }
            return (n = (int)(NamespacedKeyItemDisplayHolder.a(this.Dw.zk, itemStackBuilder_4, entity) ? 1 : 0)) != 0 ? ItemStackBuilder_3.ml() : ItemStackBuilder_3.mk();
        }
        return ItemStackBuilder_3.mk();
    }
}
