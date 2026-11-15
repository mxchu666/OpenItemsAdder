package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ij;
import itemsadder.m.iq;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class ip
implements iq,
Cloneable {
    public final float wC;

    public ip(float f) {
        this.wC = f;
    }

    public ip ke() {
        return new ip(this.wC);
    }

    @Override
    public void a(ij ij2, Player player, FoodLevelChangeEvent foodLevelChangeEvent) {
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (foodLevelChangeEvent.getFoodLevel() >= player.getFoodLevel()) {
            return;
        }
        int n = player.getFoodLevel() - foodLevelChangeEvent.getFoodLevel();
        float f2 = ij2.jW();
        if (f2 - this.wC * (float)n < ij2.jY()) {
            if (f2 > 0.0f) {
                ij2.k(ij2.jY());
                if (Main.KO.gY("debug.huds.log-triggers")) {
                    bce.log("DecrementBasedOnFoodLevel " + this.wC);
                }
            }
        } else {
            ij2.k(f2 - this.wC * (float)n);
            if (Main.KO.gY("debug.huds.log-triggers")) {
                bce.log("DecrementBasedOnFoodLevel " + this.wC * (float)n);
            }
        }
        d.g().ao.al(player);
    }

    @Override
    public /* synthetic */ iq kf() {
        return this.ke();
    }
}
