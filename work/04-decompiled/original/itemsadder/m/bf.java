package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomEntity;
import itemsadder.m.as;
import itemsadder.m.av;
import itemsadder.m.bce;
import itemsadder.m.bg;
import itemsadder.m.bh;
import itemsadder.m.d;
import itemsadder.m.dn;
import itemsadder.m.wk;
import itemsadder.m.wl;
import lombok.Generated;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class bf
extends as {
    final String gJ;
    final wk gK;

    @Override
    public av a(Event event, dn dn2, @Nullable Player player) {
        try {
            wl wl2 = d.g().A.a(this.gK, (Plugin)Main.rS(), event, player, CustomEntity.byAlreadySpawned((Entity)dn2.eh()));
            if (wl2.rH()) {
                if (wl2.rG() != null) {
                    bce.warn("Error executing script: " + this.gJ);
                    for (String string : wl2.rG()) {
                        bce.warn(string);
                    }
                } else if (wl2.rF() != null) {
                    bce.warn("Error executing script: " + this.gJ);
                    bce.warn("StackTrace: ", wl2.rF());
                }
                return av.aM();
            }
            if (wl2.rE() > 1000L) {
                bce.warn("[Scripts] '" + this.gJ + "' took too long to execute: " + wl2.rE() + "ms");
                return av.aM();
            }
        }
        catch (Exception exception) {
            bce.warn("Unexpected executing script: " + this.gJ);
            exception.printStackTrace();
            return av.aM();
        }
        return av.aN();
    }

    @Override
    public av a(Event event, dn dn2) {
        return this.a(event, dn2, null);
    }

    @Generated
    protected bf(bg bg2) {
        super(bg2);
        this.gJ = bg2.gJ;
        this.gK = bg2.gK;
    }

    @Generated
    public static bg aW() {
        return new bh();
    }
}
