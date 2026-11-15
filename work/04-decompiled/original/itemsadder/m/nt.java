package itemsadder.m;

import dev.lone.itemsadder.Core.OtherPlugins.mmoitems.MmoItemsHook;
import itemsadder.m.bbs;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class nt
extends ou {
    public final ItemStack CQ;

    public nt(ItemStack itemStack, int n) {
        this.CQ = itemStack.clone();
        this.CQ.setAmount(n);
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        MmoItemsHook.injectMmoItem(this.CQ);
        bbs.f(player, this.CQ);
        return pa.ml();
    }
}
