package itemsadder.m;

import itemsadder.m.aqp;
import itemsadder.m.bcu;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class oe
extends ou {
    public final qm Dn;

    public oe(qm qm2) {
        this.Dn = qm2;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        bcu.b(Sound.ITEM_TOTEM_USE, player, SoundCategory.PLAYERS, 20L, () -> aqp.e(player, this.Dn));
        return pa.ml();
    }
}
