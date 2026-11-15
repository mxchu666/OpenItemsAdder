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

public class EventBridge_10
extends Builder_14 {
    final String CV;
    final float CW;

    public EventBridge_10(String string, float f) {
        this.CV = string;
        this.CW = f;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        float f = ItemStackRegistry.g().an.b(player, this.CV, 0.0f);
        float f2 = f + this.CW;
        ItemStackRegistry.g().ao.c(player, this.CV, f2);
        if (Main.KO.gY("debug.huds.log-triggers")) {
            CommandSenderBridge_5.log("IncrementPlayerStatValue " + this.CV + ": " + this.CW);
        }
        if (f != f2) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }
}
