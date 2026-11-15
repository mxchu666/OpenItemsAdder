package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import itemsadder.m.aow;
import itemsadder.m.da;
import itemsadder.m.el;
import itemsadder.m.en;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@Deprecated
public class em {
    private static em rd;
    public BossBar re = Bukkit.createBossBar((String)"", (BarColor)BarColor.WHITE, (BarStyle)BarStyle.SOLID, (BarFlag[])new BarFlag[0]);
    public el rf;
    public el rg;

    public static em gR() {
        if (rd == null) {
            rd = new em();
        }
        return rd;
    }

    em() {
        if (!Main.rS().isEnabled()) {
            return;
        }
        this.rf = new el();
        this.rg = new el();
        Bukkit.getScheduler().runTaskTimer((Plugin)Main.rS(), this::gT, 10L, 10L);
        aow.b((PacketListener)new en(this, (Plugin)Main.rS(), PacketType.Play.Client.POSITION_LOOK, PacketType.Play.Client.LOOK, PacketType.Play.Client.POSITION));
    }

    public void af(Player player) {
        this.re.addPlayer(player);
    }

    public void ag(Player player) {
        this.re.removePlayer(player);
    }

    public void gS() {
        this.re.removeAll();
    }

    public void gT() {
        this.re.setTitle("AnimPackets/s: " + this.rf.rb + " | Mobs: " + da.db().dd());
    }
}
