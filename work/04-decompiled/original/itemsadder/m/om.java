package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import itemsadder.m.wk;
import itemsadder.m.wl;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class om
extends ou {
    public final String DC;
    wk gK;

    public om(String string, wk wk2) {
        this.DC = string;
        this.gK = wk2;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        try {
            wl wl2 = d.g().A.a(this.gK, (Plugin)Main.rS(), event, player, CustomStack.fromInternal(qm2), itemStack);
            if (wl2.rH()) {
                if (wl2.rG() != null) {
                    bce.warn("Error executing script: " + this.DC);
                    for (String string : wl2.rG()) {
                        bce.warn(string);
                    }
                } else if (wl2.rF() != null) {
                    bce.warn("Error executing script: " + this.DC);
                    bce.warn("StackTrace: ", wl2.rF());
                }
                return pa.mk();
            }
            if (wl2.rE() > 1000L) {
                bce.warn("[Scripts] '" + this.DC + "' took too long to execute: " + wl2.rE() + "ms");
                return pa.mk();
            }
        }
        catch (Exception exception) {
            bce.warn("Unexpected executing script: " + this.DC);
            exception.printStackTrace();
            return pa.mk();
        }
        return pa.m(itemStack);
    }
}
