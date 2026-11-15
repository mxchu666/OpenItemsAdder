package dev.lone.itemsadder.Core.OtherPlugins.Denizen;

import com.denizenscript.denizen.objects.ItemTag;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizen.scripts.commands.BukkitCommandRegistry;
import com.denizenscript.denizencore.DenizenCore;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizencore.scripts.commands.AbstractCommand;
import dev.lone.itemsadder.Core.OtherPlugins.Denizen.SetCustomBlock;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import java.util.Map;

public class DenizenHook {
    public static void hook() {
        try {
            ItemTag.tagProcessor.registerTag(ElementTag.class, "is_ia_item", (attribute, itemTag) -> new ElementTag(ItemStackRegistry.g().isCustomItem(itemTag.getItemStack())), new String[0]);
            ItemTag.tagProcessor.registerTag(ElementTag.class, "is_ia_block", (attribute, itemTag) -> new ElementTag(ItemStackRegistry.g().b(itemTag.getItemStack())), new String[0]);
            ItemTag.tagProcessor.registerTag(ElementTag.class, "ia_namespaced_id", (attribute, itemTag) -> {
                ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemTag.getItemStack());
                if (itemStackBuilder_4 == null) {
                    attribute.echoError("Not a custom ItemAdder item.");
                    return null;
                }
                return new ElementTag(itemStackBuilder_4.getNamespacedID());
            }, new String[0]);
            LocationTag.tagProcessor.registerTag(ElementTag.class, "is_ia_block", (attribute, locationTag) -> new ElementTag(ItemStackRegistry.isCustomBlock(locationTag.getBlock())), new String[0]);
            LocationTag.tagProcessor.registerTag(ElementTag.class, "ia_namespaced_id", (attribute, locationTag) -> {
                BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(locationTag.getBlock());
                if (!blockBridge_9.isCustomBlock(locationTag.getBlock())) {
                    attribute.echoError("Not a custom ItemAdder block.");
                    return null;
                }
                return new ElementTag(blockBridge_9.Y(locationTag.getBlock()));
            }, new String[0]);
            ItemTag.tagProcessor.registerMechanism("ia_namespaced_id", true, ElementTag.class, (itemTag, mechanism, elementTag) -> {
                ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(elementTag.asString());
                if (itemStackBuilder_4 == null) {
                    mechanism.echoError("Not a custom ItemAdder item: " + elementTag.asString());
                    return;
                }
                itemTag.setItemStack(itemStackBuilder_4.mP());
            }, new String[0]);
            BukkitCommandRegistry.registerCommand(SetCustomBlock.class);
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Error while hooking into Denizen", throwable);
        }
    }

    public static void unhook() {
        try {
            ItemTag.tagProcessor.registeredObjectTags.remove("is_ia_item");
            ItemTag.tagProcessor.registeredObjectTags.remove("is_ia_block");
            ItemTag.tagProcessor.registeredObjectTags.remove("ia_namespaced_id");
            LocationTag.tagProcessor.registeredObjectTags.remove("is_ia_block");
            LocationTag.tagProcessor.registeredObjectTags.remove("ia_namespaced_id");
            ItemTag.tagProcessor.registeredMechanisms.remove("ia_namespaced_id");
            LocationTag.tagProcessor.registeredMechanisms.remove("ia_namespaced_id");
            String string = null;
            for (Map.Entry entry : DenizenCore.commandRegistry.instances.entrySet()) {
                if (!((AbstractCommand)entry.getValue()).getClass().equals(SetCustomBlock.class)) continue;
                string = (String)entry.getKey();
                break;
            }
            if (string != null) {
                DenizenCore.commandRegistry.instances.remove(string);
                DenizenCore.commandRegistry.classes.remove(SetCustomBlock.class);
            }
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Error while unhooking from Denizen", throwable);
        }
    }
}
