package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.KfFunction;
import itemsadder.m.PlayerBridge_8;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerBridge_9
implements KfFunction,
Cloneable {
    public final float wC;

    public PlayerBridge_9(float f) {
        this.wC = f;
    }

    public PlayerBridge_9 ke() {
        return new PlayerBridge_9(this.wC);
    }

    @Override
    public void a(PlayerBridge_8 playerBridge_8, Player player, FoodLevelChangeEvent foodLevelChangeEvent) {
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (foodLevelChangeEvent.getFoodLevel() >= player.getFoodLevel()) {
            return;
        }
        int n = player.getFoodLevel() - foodLevelChangeEvent.getFoodLevel();
        float f = playerBridge_8.jW();
        if (f - this.wC * (float)n < playerBridge_8.jY()) {
            if (f > 0.0f) {
                playerBridge_8.k(playerBridge_8.jY());
                if (Main.KO.gY("debug.huds.log-triggers")) {
                    CommandSenderBridge_5.log("DecrementBasedOnFoodLevel " + this.wC);
                }
            }
        } else {
            playerBridge_8.k(f - this.wC * (float)n);
            if (Main.KO.gY("debug.huds.log-triggers")) {
                CommandSenderBridge_5.log("DecrementBasedOnFoodLevel " + this.wC * (float)n);
            }
        }
        ItemStackRegistry.g().ao.al(player);
    }

    @Override
    public /* synthetic */ KfFunction kf() {
        return this.ke();
    }
}
