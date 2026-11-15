package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class EventBridge_5
extends Builder_14 {
    public final int Cx;

    public EventBridge_5(int n) {
        this.Cx = n;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        ItemStackBridge_2.i(itemStack, this.Cx);
        return ItemStackBuilder_3.ml();
    }
}
