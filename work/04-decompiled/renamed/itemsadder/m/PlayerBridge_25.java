package itemsadder.m;

import itemsadder.m.HiddenEnum;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_8;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class PlayerBridge_25 {
    public final PlayerBridge_8 Ih;
    public long Ii;
    public final ItemStackBuilder_4 Ij;
    long Ik;
    private boolean Il;
    private long Im;
    private int jc;
    public int In;

    public PlayerBridge_25(ItemStackBuilder_4 itemStackBuilder_4, PlayerBridge_8 playerBridge_8) {
        this.Ih = playerBridge_8;
        this.Ij = itemStackBuilder_4;
        this.Ik = itemStackBuilder_4.mU();
        this.Il = true;
        this.oi();
    }

    public long od() {
        long l = this.Ik - this.oe();
        if (l < 0L) {
            return 0L;
        }
        return l;
    }

    public long oe() {
        return System.currentTimeMillis() - this.Ii;
    }

    public boolean lt() {
        return this.oe() >= this.Ik;
    }

    public String of() {
        long l = this.od();
        this.Im = TimeUnit.MILLISECONDS.toSeconds(l);
        return PlayerBridge_25.j(l);
    }

    static String j(long l) {
        long l2 = TimeUnit.MILLISECONDS.toSeconds(Math.max(0L, l));
        long l3 = TimeUnit.SECONDS.toHours(l2);
        long l4 = TimeUnit.SECONDS.toMinutes(l2) % 60L;
        return l3 > 0L ? String.format(Locale.ROOT, "%d:%02d:%02d", l3, l4, l2 % 60L) : String.format(Locale.ROOT, "%02d:%02d", l4, l2 % 60L);
    }

    public boolean og() {
        return TimeUnit.MILLISECONDS.toSeconds(this.Ik - this.oe()) != this.Im;
    }

    public boolean oh() {
        return this.jc++ == 0;
    }

    public void a(float f, Player player) {
        this.Ih.k(f);
        ItemStackRegistry.g().ao.al(player);
    }

    public void oi() {
        this.Ii = System.currentTimeMillis();
    }

    public void a(boolean bl, Player player) {
        this.Il = bl;
        if (bl && this.lt()) {
            return;
        }
        if (this.Ij.nk() == HiddenEnum.HUD) {
            PlayerBridge_8 playerBridge_8 = ItemStackRegistry.g().ao.d(player, this.Ij.nj().Id);
            if (playerBridge_8 == null) {
                return;
            }
            if (bl && playerBridge_8.jW() == 0.0f) {
                return;
            }
            playerBridge_8.setVisible(bl);
            ItemStackRegistry.g().ao.al(player);
        } else if (this.Ij.nk() == HiddenEnum.TITLE) {
            if (!bl) {
                player.sendTitle(" ", " ", 0, 0, 0);
            }
        } else {
            BossBar bossBar = ItemStackRegistry.g().ar.Co.aT(player);
            if (bossBar != null) {
                if (bl && bossBar.getProgress() == 0.0) {
                    return;
                }
                if (bl) {
                    bossBar.show();
                } else {
                    ItemStackRegistry.g().ar.Co.aU(player);
                    bossBar.hide();
                }
            }
        }
    }

    public boolean oj() {
        return this.Il;
    }

    public void ok() {
        ++this.In;
    }

    public void ol() {
        this.In = 0;
    }
}
