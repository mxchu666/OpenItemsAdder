package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.PlayerWrapper_6;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class PlayerBridge_14
implements PlayerWrapper_6 {
    public final int wP;
    public final float wQ;
    public final int wR;
    public final int wS;
    protected int wK = 0;

    public PlayerBridge_14(int n, float f, int n2, int n3) {
        this.wP = n;
        this.wQ = f;
        this.wR = n2;
        this.wS = n3;
    }

    public PlayerBridge_14 km() {
        return new PlayerBridge_14(this.wP, this.wQ, this.wR, this.wS);
    }

    @Override
    public void a(PlayerBridge_8 playerBridge_8, Player player, int n) {
        if (this.b(playerBridge_8, player, n)) {
            this.c(playerBridge_8, player, n);
        }
    }

    boolean b(PlayerBridge_8 playerBridge_8, Player player, int n) {
        if (player.getGameMode() == GameMode.CREATIVE) {
            return false;
        }
        if (!playerBridge_8.g(player.getWorld())) {
            return false;
        }
        this.wK += n;
        if (this.wK < this.wP) {
            return false;
        }
        this.wK = 0;
        return this.wR == -1 || this.wS == -1 || player.getLocation().getBlock().getLightFromSky() >= this.wR && player.getLocation().getBlock().getLightFromSky() <= this.wS;
    }

    void c(PlayerBridge_8 playerBridge_8, Player player, int n) {
        float f = playerBridge_8.jW();
        playerBridge_8.k(f + this.wQ);
        ItemStackRegistry.g().ao.al(player);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            CommandSenderBridge_5.log("GenericOverTime " + this.wQ);
        }
    }

    @Override
    public /* synthetic */ PlayerWrapper_6 kn() {
        return this.km();
    }
}
