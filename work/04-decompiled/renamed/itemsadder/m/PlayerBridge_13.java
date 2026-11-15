package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EqualEnum;
import itemsadder.m.IntFloatRefData;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.PlayerWrapper_7;
import itemsadder.m.PotionEffectTypeBridge;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class PlayerBridge_13
extends IntFloatRefData {
    public final PotionEffectTypeBridge wM;

    public PlayerBridge_13(int n, float f, PotionEffectTypeBridge potionEffectTypeBridge, EqualEnum equalEnum) {
        super(n, f, equalEnum);
        this.wM = potionEffectTypeBridge;
    }

    public PlayerBridge_13 kk() {
        return new PlayerBridge_13(this.wI, this.wJ, this.wM, this.wL);
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
                if (f != this.wJ) {
                    return;
                }
            }
            case LESS: {
                if (!(f < this.wJ)) {
                    return;
                }
            }
            case MORE: {
                if (!(f > this.wJ)) {
                    return;
                }
            }
            case LESS_EQUAL: {
                if (!(f <= this.wJ)) {
                    return;
                }
            }
            case MORE_EQUAL: {
                if (f >= this.wJ) break;
                return;
            }
        }
        this.wM.a(null, null, null, player);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            CommandSenderBridge_5.log("PotionEffectPlayerByValueOverTime " + this.wM.Do.getName());
        }
    }

    @Override
    public /* synthetic */ PlayerWrapper_7 ki() {
        return this.kk();
    }
}
