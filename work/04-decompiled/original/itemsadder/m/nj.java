package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class nj
extends ou {
    public final int Cx;

    public nj(int n) {
        this.Cx = n;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        bbs.i(itemStack, this.Cx);
        return pa.ml();
    }
}
