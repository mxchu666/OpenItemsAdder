package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.KfFunction;
import itemsadder.m.PlayerBridge_8;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerBridge_11
implements KfFunction {
    public final float wE;

    public PlayerBridge_11(float f) {
        this.wE = f;
    }

    public PlayerBridge_11 kh() {
        return new PlayerBridge_11(this.wE);
    }

    @Override
    public void a(PlayerBridge_8 playerBridge_8, Player player, PlayerRespawnEvent playerRespawnEvent) {
        float f = playerBridge_8.jW();
        float f2 = f + this.wE;
        if (f2 > playerBridge_8.jZ()) {
            f2 = playerBridge_8.jZ();
        }
        playerBridge_8.k(f2);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            CommandSenderBridge_5.log("IncrementOnPlayerRespawn " + f2);
        }
        ItemStackRegistry.g().ao.al(player);
    }

    @Override
    public /* synthetic */ KfFunction kf() {
        return this.kh();
    }
}
