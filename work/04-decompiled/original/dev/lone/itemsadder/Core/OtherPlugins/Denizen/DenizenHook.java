package dev.lone.itemsadder.Core.OtherPlugins.Denizen;

import com.denizenscript.denizen.objects.ItemTag;
import com.denizenscript.denizen.objects.LocationTag;
import com.denizenscript.denizen.scripts.commands.BukkitCommandRegistry;
import com.denizenscript.denizencore.DenizenCore;
import com.denizenscript.denizencore.objects.core.ElementTag;
import com.denizenscript.denizencore.scripts.commands.AbstractCommand;
import dev.lone.itemsadder.Core.OtherPlugins.Denizen.SetCustomBlock;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.qm;
import java.util.Map;

public class DenizenHook {
    public static void hook() {
        try {
            ItemTag.tagProcessor.registerTag(ElementTag.class, "is_ia_item", (attribute, itemTag) -> new ElementTag(d.g().isCustomItem(itemTag.getItemStack())), new String[0]);
            ItemTag.tagProcessor.registerTag(ElementTag.class, "is_ia_block", (attribute, itemTag) -> new ElementTag(d.g().b(itemTag.getItemStack())), new String[0]);
            ItemTag.tagProcessor.registerTag(ElementTag.class, "ia_namespaced_id", (attribute, itemTag) -> {
                qm qm2 = d.g().a(itemTag.getItemStack());
                if (qm2 == null) {
                    attribute.echoError("Not a custom ItemAdder item.");
                    return null;
                }
                return new ElementTag(qm2.getNamespacedID());
            }, new String[0]);
            LocationTag.tagProcessor.registerTag(ElementTag.class, "is_ia_block", (attribute, locationTag) -> new ElementTag(d.isCustomBlock(locationTag.getBlock())), new String[0]);
            LocationTag.tagProcessor.registerTag(ElementTag.class, "ia_namespaced_id", (attribute, locationTag) -> {
                ms ms2 = d.g().b(locationTag.getBlock());
                if (!ms2.isCustomBlock(locationTag.getBlock())) {
                    attribute.echoError("Not a custom ItemAdder block.");
                    return null;
                }
                return new ElementTag(ms2.Y(locationTag.getBlock()));
            }, new String[0]);
            ItemTag.tagProcessor.registerMechanism("ia_namespaced_id", true, ElementTag.class, (itemTag, mechanism, elementTag) -> {
                qm qm2 = d.g().e(elementTag.asString());
                if (qm2 == null) {
                    mechanism.echoError("Not a custom ItemAdder item: " + elementTag.asString());
                    return;
                }
                itemTag.setItemStack(qm2.mP());
            }, new String[0]);
            BukkitCommandRegistry.registerCommand(SetCustomBlock.class);
        }
        catch (Throwable throwable) {
            bce.error("Error while hooking into Denizen", throwable);
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
            bce.error("Error while unhooking from Denizen", throwable);
        }
    }
}
