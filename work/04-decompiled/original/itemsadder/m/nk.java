package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class nk
extends ou {
    public int mh = 1;

    public nk(int n) {
        this.mh = n;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        int n = bbs.al(itemStack);
        qm.a(itemStack, this.mh, (LivingEntity)player, false, true);
        if (bbs.al(itemStack) == n) {
            return pa.l(itemStack);
        }
        return pa.ml();
    }
}
