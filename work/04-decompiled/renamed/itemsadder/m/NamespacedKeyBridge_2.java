package itemsadder.m;

import itemsadder.m.PlayerBridge_14;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.PlayerWrapper_6;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class NamespacedKeyBridge_2
extends PlayerBridge_14 {
    final NamespacedKey wO;

    public NamespacedKeyBridge_2(NamespacedKey namespacedKey, int n, float f, int n2, int n3) {
        super(n, f, n2, n3);
        this.wO = namespacedKey;
    }

    public NamespacedKeyBridge_2 kl() {
        return new NamespacedKeyBridge_2(this.wO, this.wP, this.wQ, this.wR, this.wS);
    }

    @Override
    boolean b(PlayerBridge_8 playerBridge_8, Player player, int n) {
        return super.b(playerBridge_8, player, n) && player.getLocation().getBlock().getBiome().getKey() != this.wO;
    }

    @Override
    public /* synthetic */ PlayerBridge_14 km() {
        return this.kl();
    }

    @Override
    public /* synthetic */ PlayerWrapper_6 kn() {
        return this.kl();
    }
}
