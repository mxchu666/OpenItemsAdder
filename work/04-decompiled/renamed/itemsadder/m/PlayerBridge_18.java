package itemsadder.m;

import itemsadder.m.PluginContract;
import java.util.WeakHashMap;
import org.bukkit.entity.Player;

public class PlayerBridge_18
implements PluginContract {
    private WeakHashMap Ax = new WeakHashMap();
    int uT = 200;

    public PlayerBridge_18() {
    }

    public PlayerBridge_18(int n) {
        this.uT = n;
    }

    public boolean aJ(Player player) {
        int n = Math.max(this.uT, player.getPing() + this.uT);
        return System.currentTimeMillis() - this.Ax.getOrDefault(player, 0L) < (long)n;
    }

    public boolean d(Player player, int n) {
        int n2 = Math.max(n, player.getPing() + n);
        return System.currentTimeMillis() - this.Ax.getOrDefault(player, 0L) < (long)n2;
    }

    public void aK(Player player) {
        this.Ax.put(player, System.currentTimeMillis());
    }
}
