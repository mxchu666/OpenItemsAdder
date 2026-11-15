package itemsadder.m;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public interface ahu {
    public void c(Player var1, float var2);

    default public void a(Player player, GameMode gameMode) {
        this.c(player, gameMode.getValue());
    }

    default public void bR(Player player) {
        this.a(player, player.getGameMode());
    }

    public void bS(Player var1);

    public void a(Player var1, boolean var2, boolean var3, float var4);
}
