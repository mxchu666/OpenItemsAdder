package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EqualEnum;
import itemsadder.m.IntFloatRefData;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.PlayerWrapper_7;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerBridge_12
extends IntFloatRefData {
    public final float wF;
    public final float wG;

    public PlayerBridge_12(int n, float f, float f2, EqualEnum equalEnum) {
        super(n, f2, equalEnum);
        this.wF = f;
        this.wG = f2;
    }

    @Override
    public PlayerWrapper_7 ki() {
        return new PlayerBridge_12(this.wI, this.wF, this.wG, this.wL);
    }

    @Override
    public void a(PlayerBridge_8 playerBridge_8, Player player, int n) {
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        this.wK += n;
        if (this.wK < this.wI) {
            return;
        }
        this.wK = 0;
        float f = ItemStackRegistry.g().an.b(player, playerBridge_8.jX(), playerBridge_8.jY());
        switch (this.wL) {
            case EQUAL: {
                if (f != this.wG) {
                    return;
                }
            }
            case LESS: {
                if (!(f < this.wG)) {
                    return;
                }
            }
            case MORE: {
                if (!(f > this.wG)) {
                    return;
                }
            }
            case LESS_EQUAL: {
                if (!(f <= this.wG)) {
                    return;
                }
            }
            case MORE_EQUAL: {
                if (f >= this.wG) break;
                return;
            }
        }
        EntityDamageEvent entityDamageEvent = new EntityDamageEvent((Entity)player, EntityDamageEvent.DamageCause.STARVATION, (double)this.wF);
        player.setLastDamageCause(entityDamageEvent);
        if (!entityDamageEvent.isCancelled()) {
            player.damage((double)this.wF);
        }
        if (Main.KO.gY("debug.huds.log-triggers")) {
            CommandSenderBridge_5.log("DamagePlayerByValue " + this.wF);
        }
    }
}
