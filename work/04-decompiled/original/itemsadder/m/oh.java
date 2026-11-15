package itemsadder.m;

import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class oh
extends ou {
    public final PotionEffectType Du;

    public oh(PotionEffectType potionEffectType) {
        this.Du = potionEffectType;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        if (player.hasPotionEffect(this.Du)) {
            player.removePotionEffect(this.Du);
            return pa.ml();
        }
        return pa.mk();
    }
}
