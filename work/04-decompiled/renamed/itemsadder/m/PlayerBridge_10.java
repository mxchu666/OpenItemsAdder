package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.KfFunction;
import itemsadder.m.PlayerBridge_8;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerBridge_10
implements KfFunction,
Cloneable {
    public final float wD;

    public PlayerBridge_10(float f) {
        this.wD = f;
    }

    public PlayerBridge_10 kg() {
        return new PlayerBridge_10(this.wD);
    }

    @Override
    public void a(PlayerBridge_8 playerBridge_8, Player player, FoodLevelChangeEvent foodLevelChangeEvent) {
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (player.getFoodLevel() >= foodLevelChangeEvent.getFoodLevel()) {
            return;
        }
        int n = foodLevelChangeEvent.getFoodLevel() - player.getFoodLevel();
        float f = playerBridge_8.jW();
        float f2 = f + this.wD * (float)n;
        if (f2 > playerBridge_8.jZ()) {
            f2 = playerBridge_8.jZ();
        }
        playerBridge_8.k(f2);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            CommandSenderBridge_5.log("IncrementBasedOnFoodLevel " + this.wD * (float)n);
        }
        ItemStackRegistry.g().ao.al(player);
    }

    @Override
    public /* synthetic */ KfFunction kf() {
        return this.kg();
    }
}
