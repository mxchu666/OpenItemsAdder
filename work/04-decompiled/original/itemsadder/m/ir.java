package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ij;
import itemsadder.m.iq;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class ir
implements iq,
Cloneable {
    public final float wD;

    public ir(float f) {
        this.wD = f;
    }

    public ir kg() {
        return new ir(this.wD);
    }

    @Override
    public void a(ij ij2, Player player, FoodLevelChangeEvent foodLevelChangeEvent) {
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (player.getFoodLevel() >= foodLevelChangeEvent.getFoodLevel()) {
            return;
        }
        int n = foodLevelChangeEvent.getFoodLevel() - player.getFoodLevel();
        float f2 = ij2.jW();
        float f3 = f2 + this.wD * (float)n;
        if (f3 > ij2.jZ()) {
            f3 = ij2.jZ();
        }
        ij2.k(f3);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            bce.log("IncrementBasedOnFoodLevel " + this.wD * (float)n);
        }
        d.g().ao.al(player);
    }

    @Override
    public /* synthetic */ iq kf() {
        return this.kg();
    }
}
