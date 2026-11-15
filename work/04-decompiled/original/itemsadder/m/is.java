package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ij;
import itemsadder.m.iq;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;

public class is
implements iq {
    public final float wE;

    public is(float f) {
        this.wE = f;
    }

    public is kh() {
        return new is(this.wE);
    }

    @Override
    public void a(ij ij2, Player player, PlayerRespawnEvent playerRespawnEvent) {
        float f2 = ij2.jW();
        float f3 = f2 + this.wE;
        if (f3 > ij2.jZ()) {
            f3 = ij2.jZ();
        }
        ij2.k(f3);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            bce.log("IncrementOnPlayerRespawn " + f3);
        }
        d.g().ao.al(player);
    }

    @Override
    public /* synthetic */ iq kf() {
        return this.kh();
    }
}
