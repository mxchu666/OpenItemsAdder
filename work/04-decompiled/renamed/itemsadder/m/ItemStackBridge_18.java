package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_18
extends Builder_14 {
    public final ItemStack CQ;

    public ItemStackBridge_18(ItemStack itemStack, int n) {
        this.CQ = itemStack.clone();
        this.CQ.setAmount(n);
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        MmoItemsHook.injectMmoItem(this.CQ);
        ItemStackBridge_2.f(player, this.CQ);
        return ItemStackBuilder_3.ml();
    }
}
