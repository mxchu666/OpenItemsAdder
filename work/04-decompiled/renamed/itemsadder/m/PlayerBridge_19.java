package itemsadder.m;

import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PlayerBridge_25;
import java.util.HashMap;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class PlayerBridge_19 {
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

    public void a(@Nullable ItemStackBuilder_4 itemStackBuilder_4, Player player, boolean bl) {
        PlayerBridge_25 playerBridge_25;
        if (itemStackBuilder_4 == null) {
            return;
        }
        HashMap hashMap = (HashMap)this.Ch.get(player.getUniqueId());
        if (hashMap != null && (playerBridge_25 = (PlayerBridge_25)hashMap.get(itemStackBuilder_4.Gi)) != null) {
            playerBridge_25.a(bl, player);
        }
    }

    public void a(@Nullable ItemStackBuilder_4 itemStackBuilder_4, Player player, boolean bl, int n) {
        PlayerBridge_25 playerBridge_25;
        if (itemStackBuilder_4 == null) {
            return;
        }
        HashMap hashMap = (HashMap)this.Ch.get(player.getUniqueId());
        if (hashMap != null && (playerBridge_25 = (PlayerBridge_25)hashMap.get(itemStackBuilder_4.Gi)) != null) {
            BukkitTaskBridge.c(() -> playerBridge_25.a(bl, player), n);
        }
    }
}
