package itemsadder.m;

import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class ns
extends ou {
    public final int CO;
    public final float CP;

    public ns(int n, float f) {
        this.CO = n;
        this.CP = f;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        int n = player.getFoodLevel();
        float f = player.getSaturation();
        int n2 = Math.min(n + this.CO, 20);
        float f2 = Math.min(f + this.CP, (float)n2);
        player.setFoodLevel(n2);
        player.setSaturation(f2);
        if (n == n2 && f == f2) {
            return pa.mk();
        }
        return pa.ml();
    }
}
