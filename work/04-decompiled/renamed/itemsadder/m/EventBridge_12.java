package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_3;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class EventBridge_12
extends Builder_14 {
    public final String DJ;

    public EventBridge_12(String string) {
        this.DJ = string;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        LocationBridge_3.a(player.getLocation(), SoundCategory.MASTER, this.DJ);
        return ItemStackBuilder_3.ml();
    }
}
