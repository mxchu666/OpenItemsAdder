package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class PotionEffectTypeBridge_2
extends Builder_14 {
    public final PotionEffectType Du;

    public PotionEffectTypeBridge_2(PotionEffectType potionEffectType) {
        this.Du = potionEffectType;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        if (player.hasPotionEffect(this.Du)) {
            player.removePotionEffect(this.Du);
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }
}
