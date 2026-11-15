package itemsadder.m;

import itemsadder.m.bcp;
import itemsadder.m.qm;
import itemsadder.m.rk;
import java.util.HashMap;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class mx {
    public final HashMap Ch = new HashMap();
    public final HashMap Ci = new HashMap();

    public void mc() {
        this.Ci.clear();
        this.Ch.clear();
    }

    @Nullable
    public BossBar aT(Player player) {
        return (BossBar)this.Ci.get(player);
    }

    public void aU(Player player) {
        this.Ci.remove(player);
    }

    public void a(@Nullable qm qm2, Player player, boolean bl) {
        rk rk2;
        if (qm2 == null) {
            return;
        }
        HashMap hashMap = (HashMap)this.Ch.get(player.getUniqueId());
        if (hashMap != null && (rk2 = (rk)hashMap.get(qm2.Gi)) != null) {
            rk2.a(bl, player);
        }
    }

    public void a(@Nullable qm qm2, Player player, boolean bl, int n) {
        rk rk2;
        if (qm2 == null) {
            return;
        }
        HashMap hashMap = (HashMap)this.Ch.get(player.getUniqueId());
        if (hashMap != null && (rk2 = (rk)hashMap.get(qm2.Gi)) != null) {
            bcp.c(() -> rk2.a(bl, player), n);
        }
    }
}
