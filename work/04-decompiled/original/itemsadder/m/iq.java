package itemsadder.m;

import itemsadder.m.ij;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public interface iq {
    default public void a(ij ij2, Player player, FoodLevelChangeEvent foodLevelChangeEvent) {
    }

    public iq kf();

    default public void a(ij ij2, Player player, PlayerRespawnEvent playerRespawnEvent) {
    }
}
