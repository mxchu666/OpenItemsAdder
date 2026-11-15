package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ij;
import itemsadder.m.iv;
import itemsadder.m.iw;
import itemsadder.m.jc;
import itemsadder.m.of;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class ix
extends iv {
    public final of wM;

    public ix(int n, float f, of of2, iw iw2) {
        super(n, f, iw2);
        this.wM = of2;
    }

    public ix kk() {
        return new ix(this.wI, this.wJ, this.wM, this.wL);
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
                if (f2 != this.wJ) {
                    return;
                }
            }
            case LESS: {
                if (!(f2 < this.wJ)) {
                    return;
                }
            }
            case MORE: {
                if (!(f2 > this.wJ)) {
                    return;
                }
            }
            case LESS_EQUAL: {
                if (!(f2 <= this.wJ)) {
                    return;
                }
            }
            case MORE_EQUAL: {
                if (f2 >= this.wJ) break;
                return;
            }
        }
        this.wM.a(null, null, null, player);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            bce.log("PotionEffectPlayerByValueOverTime " + this.wM.Do.getName());
        }
    }

    @Override
    public /* synthetic */ jc ki() {
        return this.kk();
    }
}
