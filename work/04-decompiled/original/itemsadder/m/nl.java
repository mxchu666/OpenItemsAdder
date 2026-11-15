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

public class nl
extends ou {
    final String Cy;
    final float Cz;

    public nl(String string, float f) {
        this.Cy = string;
        this.Cz = f;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        float f2 = d.g().an.b(player, this.Cy, 0.0f);
        d.g().ao.c(player, this.Cy, f2 -= this.Cz);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            bce.log("DecrementPlayerStatValue " + this.Cy + ": " + this.Cz);
        }
        return pa.ml();
    }
}
