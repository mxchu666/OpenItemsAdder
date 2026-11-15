package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ij;
import itemsadder.m.iv;
import itemsadder.m.iw;
import itemsadder.m.jc;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class it
extends iv {
    public final float wF;
    public final float wG;

    public it(int n, float f, float f2, iw iw2) {
        super(n, f2, iw2);
        this.wF = f;
        this.wG = f2;
    }

    @Override
    public jc ki() {
        return new it(this.wI, this.wF, this.wG, this.wL);
    }

    @Override
    public void a(ij ij2, Player player, int n) {
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        this.wK += n;
        if (this.wK < this.wI) {
            return;
        }
        this.wK = 0;
        float f2 = d.g().an.b(player, ij2.jX(), ij2.jY());
        switch (this.wL) {
            case EQUAL: {
                if (f2 != this.wG) {
                    return;
                }
            }
            case LESS: {
                if (!(f2 < this.wG)) {
                    return;
                }
            }
            case MORE: {
                if (!(f2 > this.wG)) {
                    return;
                }
            }
            case LESS_EQUAL: {
                if (!(f2 <= this.wG)) {
                    return;
                }
            }
            case MORE_EQUAL: {
                if (f2 >= this.wG) break;
                return;
            }
        }
        EntityDamageEvent entityDamageEvent = new EntityDamageEvent((Entity)player, EntityDamageEvent.DamageCause.STARVATION, (double)this.wF);
        player.setLastDamageCause(entityDamageEvent);
        if (!entityDamageEvent.isCancelled()) {
            player.damage((double)this.wF);
        }
        if (Main.KO.gY("debug.huds.log-triggers")) {
            bce.log("DamagePlayerByValue " + this.wF);
        }
    }
}
