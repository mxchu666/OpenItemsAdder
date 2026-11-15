package itemsadder.m;

import itemsadder.m.PlayerBridge_8;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public interface KfFunction {
    default public void a(PlayerBridge_8 playerBridge_8, Player player, FoodLevelChangeEvent foodLevelChangeEvent) {
    }

    public KfFunction kf();

    default public void a(PlayerBridge_8 playerBridge_8, Player player, PlayerRespawnEvent playerRespawnEvent) {
    }
}
