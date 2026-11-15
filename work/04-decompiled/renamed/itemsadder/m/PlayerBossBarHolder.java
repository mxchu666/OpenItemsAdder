package itemsadder.m;

import itemsadder.m.BukkitTaskBridge;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class PlayerBossBarHolder {
    final Player zR;
    final BossBar zS;
    long zT;

    public PlayerBossBarHolder(Player player, String string, BarColor barColor, BarStyle barStyle) {
        this.zR = player;
        this.zS = Bukkit.createBossBar((String)string, (BarColor)barColor, (BarStyle)barStyle, (BarFlag[])new BarFlag[0]);
        this.zS.addPlayer(player);
        this.zS.setVisible(false);
    }

    public void gF() {
        this.zS.setVisible(true);
        this.zT = System.currentTimeMillis();
    }

    public void gE() {
        this.zS.setVisible(false);
    }

    public void lh() {
        BukkitTaskBridge.b(() -> {
            if (System.currentTimeMillis() - this.zT <= 2500L) {
                return;
            }
            this.gE();
        }, 60L);
    }

    public void bf(String string) {
        this.zS.setTitle(string);
    }

    public void li() {
        this.zS.removePlayer(this.zR);
    }
}
