package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.Builder_14;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.Opaque146;
import itemsadder.m.StringClassBoolData;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class EventBridge_11
extends Builder_14 {
    public final String DC;
    StringClassBoolData gK;

    public EventBridge_11(String string, StringClassBoolData stringClassBoolData) {
        this.DC = string;
        this.gK = stringClassBoolData;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        try {
            Opaque146 opaque146 = ItemStackRegistry.g().A.a(this.gK, (Plugin)Main.rS(), event, player, CustomStack.fromInternal(itemStackBuilder_4), itemStack);
            if (opaque146.rH()) {
                if (opaque146.rG() != null) {
                    CommandSenderBridge_5.warn("Error executing script: " + this.DC);
                    for (String string : opaque146.rG()) {
                        CommandSenderBridge_5.warn(string);
                    }
                } else if (opaque146.rF() != null) {
                    CommandSenderBridge_5.warn("Error executing script: " + this.DC);
                    CommandSenderBridge_5.warn("StackTrace: ", opaque146.rF());
                }
                return ItemStackBuilder_3.mk();
            }
            if (opaque146.rE() > 1000L) {
                CommandSenderBridge_5.warn("[Scripts] '" + this.DC + "' took too long to execute: " + opaque146.rE() + "ms");
                return ItemStackBuilder_3.mk();
            }
        }
        catch (Exception exception) {
            CommandSenderBridge_5.warn("Unexpected executing script: " + this.DC);
            exception.printStackTrace();
            return ItemStackBuilder_3.mk();
        }
        return ItemStackBuilder_3.m(itemStack);
    }
}
