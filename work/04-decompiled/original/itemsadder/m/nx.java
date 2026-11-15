package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class nx
extends ou {
    final String CV;
    final float CW;

    public nx(String string, float f) {
        this.CV = string;
        this.CW = f;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        float f2 = d.g().an.b(player, this.CV, 0.0f);
        float f3 = f2 + this.CW;
        d.g().ao.c(player, this.CV, f3);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            bce.log("IncrementPlayerStatValue " + this.CV + ": " + this.CW);
        }
        if (f2 != f3) {
            return pa.ml();
        }
        return pa.mk();
    }
}
