package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.api.CustomEntity;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityBridgeImpl;
import itemsadder.m.EventBridgeBuilderImpl_2;
import itemsadder.m.EventBridgeBuilder_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.Opaque146;
import itemsadder.m.RecordOfValue_4;
import itemsadder.m.StringClassBoolData;
import lombok.Generated;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class EventBridge_2
extends EntityBridgeImpl {
    final String gJ;
    final StringClassBoolData gK;

    @Override
    public RecordOfValue_4 a(Event event, LivingEntityBuilder livingEntityBuilder, @Nullable Player player) {
        try {
            Opaque146 opaque146 = ItemStackRegistry.g().A.a(this.gK, (Plugin)Main.rS(), event, player, CustomEntity.byAlreadySpawned((Entity)livingEntityBuilder.eh()));
            if (opaque146.rH()) {
                if (opaque146.rG() != null) {
                    CommandSenderBridge_5.warn("Error executing script: " + this.gJ);
                    for (String string : opaque146.rG()) {
                        CommandSenderBridge_5.warn(string);
                    }
                } else if (opaque146.rF() != null) {
                    CommandSenderBridge_5.warn("Error executing script: " + this.gJ);
                    CommandSenderBridge_5.warn("StackTrace: ", opaque146.rF());
                }
                return RecordOfValue_4.aM();
            }
            if (opaque146.rE() > 1000L) {
                CommandSenderBridge_5.warn("[Scripts] '" + this.gJ + "' took too long to execute: " + opaque146.rE() + "ms");
                return RecordOfValue_4.aM();
            }
        }
        catch (Exception exception) {
            CommandSenderBridge_5.warn("Unexpected executing script: " + this.gJ);
            exception.printStackTrace();
            return RecordOfValue_4.aM();
        }
        return RecordOfValue_4.aN();
    }

    @Override
    public RecordOfValue_4 a(Event event, LivingEntityBuilder livingEntityBuilder) {
        return this.a(event, livingEntityBuilder, null);
    }

    @Generated
    protected EventBridge_2(EventBridgeBuilder_2 eventBridgeBuilder_2) {
        super(eventBridgeBuilder_2);
        this.gJ = eventBridgeBuilder_2.gJ;
        this.gK = eventBridgeBuilder_2.gK;
    }

    @Generated
    public static EventBridgeBuilder_2 aW() {
        return new EventBridgeBuilderImpl_2();
    }
}
