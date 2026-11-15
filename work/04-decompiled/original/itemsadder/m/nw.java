package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class nw
extends ou {
    public int mh = 1;

    public nw(int n) {
        this.mh = n;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        int n = bbs.al(itemStack);
        qm.g(itemStack, this.mh);
        int n2 = bbs.al(itemStack);
        return n != n2 ? pa.ml() : pa.mk();
    }
}
