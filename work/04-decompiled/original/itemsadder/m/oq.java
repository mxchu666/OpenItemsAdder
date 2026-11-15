package itemsadder.m;

import itemsadder.m.bcv;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class oq
extends ou {
    public final String DJ;

    public oq(String string) {
        this.DJ = string;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        bcv.a(player.getLocation(), SoundCategory.MASTER, this.DJ);
        return pa.ml();
    }
}
