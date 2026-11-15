package itemsadder.m;

import itemsadder.m.ij;
import itemsadder.m.ja;
import itemsadder.m.jb;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class iz
extends ja {
    final NamespacedKey wO;

    public iz(NamespacedKey namespacedKey, int n, float f, int n2, int n3) {
        super(n, f, n2, n3);
        this.wO = namespacedKey;
    }

    public iz kl() {
        return new iz(this.wO, this.wP, this.wQ, this.wR, this.wS);
    }

    @Override
    boolean b(ij ij2, Player player, int n) {
        return super.b(ij2, player, n) && player.getLocation().getBlock().getBiome().getKey() != this.wO;
    }

    @Override
    public /* synthetic */ ja km() {
        return this.kl();
    }

    @Override
    public /* synthetic */ jb kn() {
        return this.kl();
    }
}
