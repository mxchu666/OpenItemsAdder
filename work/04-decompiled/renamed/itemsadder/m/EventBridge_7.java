package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.Builder_14;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

public class EventBridge_7
extends Builder_14 {
    final String Cy;
    final float Cz;

    public EventBridge_7(String string, float f) {
        this.Cy = string;
        this.Cz = f;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        float f = ItemStackRegistry.g().an.b(player, this.Cy, 0.0f);
        ItemStackRegistry.g().ao.c(player, this.Cy, f -= this.Cz);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            CommandSenderBridge_5.log("DecrementPlayerStatValue " + this.Cy + ": " + this.Cz);
        }
        return ItemStackBuilder_3.ml();
    }
}
