package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class EventBridge_9
extends Builder_14 {
    public int mh = 1;

    public EventBridge_9(int n) {
        this.mh = n;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        int n = ItemStackBridge_2.al(itemStack);
        ItemStackBuilder_4.g(itemStack, this.mh);
        int n2 = ItemStackBridge_2.al(itemStack);
        return n != n2 ? ItemStackBuilder_3.ml() : ItemStackBuilder_3.mk();
    }
}
