package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.NamespacedKeyEntityTypeHolder;
import itemsadder.m.NamespacedKeyItemDisplayHolder;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_25
extends Builder_14 {
    public final ItemStackBuilder_4 DA;
    public final boolean DB;

    public ItemStackBridge_25(ItemStackBuilder_4 itemStackBuilder_4, boolean bl) {
        this.DA = itemStackBuilder_4;
        this.DB = bl;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return ItemStackBuilder_3.l(itemStack);
        }
        if (ItemStackBuilder_4.C(itemStack) != this.DA.fX()) {
            ItemStackBuilder_4.b(itemStack, this.DA.fX());
            return ItemStackBuilder_3.m(itemStack);
        }
        if (this.DB) {
            ItemStackBuilder_4.b(itemStack, itemStackBuilder_4.fX());
            return ItemStackBuilder_3.m(itemStack);
        }
        return ItemStackBuilder_3.l(itemStack);
    }

    @Override
    public ItemStackBuilder_3 j(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Entity entity = NamespacedKeyEntityTypeHolder.ao(playerInteractEvent.getPlayer());
        if (entity == null) {
            return this.a((Event)playerInteractEvent, itemStackBuilder_4, itemStack, playerInteractEvent.getPlayer());
        }
        boolean bl = NamespacedKeyItemDisplayHolder.a(this.DA, itemStackBuilder_4, entity);
        return bl ? ItemStackBuilder_3.ml() : ItemStackBuilder_3.mk();
    }
}
