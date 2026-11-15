package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.Opaque113;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_45;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@Deprecated
public class PlayerHolder_6 {
    private static PlayerHolder_6 rd;
    public BossBar re = Bukkit.createBossBar((String)"", (BarColor)BarColor.WHITE, (BarStyle)BarStyle.SOLID, (BarFlag[])new BarFlag[0]);
    public Opaque113 rf;
    public Opaque113 rg;

    public static PlayerHolder_6 gR() {
        if (rd == null) {
            rd = new PlayerHolder_6();
        }
        return rd;
    }

    PlayerHolder_6() {
        if (!Main.rS().isEnabled()) {
            return;
        }
        this.rf = new Opaque113();
        this.rg = new Opaque113();
        Bukkit.getScheduler().runTaskTimer((Plugin)Main.rS(), this::gT, 10L, 10L);
        PacketListenerRegistry.b((PacketListener)new PacketListener_45(this, (Plugin)Main.rS(), PacketType.Play.Client.POSITION_LOOK, PacketType.Play.Client.LOOK, PacketType.Play.Client.POSITION));
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
        this.re.setTitle("AnimPackets/s: " + this.rf.rb + " | Mobs: " + LivingEntityRegistry.db().dd());
    }
}
