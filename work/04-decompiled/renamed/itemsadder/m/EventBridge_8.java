package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class EventBridge_8
extends Builder_14 {
    public final int CO;
    public final float CP;

    public EventBridge_8(int n, float f) {
        this.CO = n;
        this.CP = f;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        int n = player.getFoodLevel();
        float f = player.getSaturation();
        int n2 = Math.min(n + this.CO, 20);
        float f2 = Math.min(f + this.CP, (float)n2);
        player.setFoodLevel(n2);
        player.setSaturation(f2);
        if (n == n2 && f == f2) {
            return ItemStackBuilder_3.mk();
        }
        return ItemStackBuilder_3.ml();
    }
}
