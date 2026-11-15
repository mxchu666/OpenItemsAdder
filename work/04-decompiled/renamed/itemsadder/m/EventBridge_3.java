package itemsadder.m;

import itemsadder.m.EntityBridgeImpl;
import itemsadder.m.EventBridgeBuilderImpl_3;
import itemsadder.m.EventBridgeBuilder_3;
import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.RecordOfValue_4;
import itemsadder.m.SoundCategoryBridge;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class EventBridge_3
extends EntityBridgeImpl {
    @Nullable
    public final String gL;
    @Nullable
    public final EntityType gM;
    @Nullable
    public final Integer gN;

    public static EventBridgeBuilder_3 Z(String string) {
        EntityType entityType = (EntityType)SoundCategoryBridge.e(string.toUpperCase(), EntityType.class);
        if (entityType != null) {
            return new EventBridgeBuilderImpl_3().a(entityType);
        }
        if (LivingEntityRegistry.db().lJ.containsKey(string)) {
            return new EventBridgeBuilderImpl_3().aa(string);
        }
        throw new IllegalArgumentException("Invalid entity id: " + string);
    }

    int ba() {
        return this.gN != null ? this.gN : MaterialBarColorHolder.dR;
    }

    @Override
    public RecordOfValue_4 a(Event event, LivingEntityBuilder livingEntityBuilder, Player player) {
        return this.a(event, livingEntityBuilder);
    }

    @Override
    public RecordOfValue_4 a(Event event, LivingEntityBuilder livingEntityBuilder) {
        Location location = livingEntityBuilder.getLocation();
        boolean bl = false;
        int n = this.ba();
        int n2 = 0;
        if (this.gM != null) {
            for (Entity entity : location.getChunk().getEntities()) {
                if (entity.getType() != this.gM || ++n2 < n) continue;
                return RecordOfValue_4.aM();
            }
            location.getWorld().spawnEntity(location, this.gM);
            bl = true;
        } else {
            for (Entity entity : location.getChunk().getEntities()) {
                if (!LivingEntityRegistry.db().f(entity) || ++n2 < n) continue;
                return RecordOfValue_4.aM();
            }
            LivingEntityBuilder livingEntityBuilder2 = LivingEntityRegistry.db().a(this.gL, location, true);
            if (livingEntityBuilder2 != null) {
                bl = true;
            }
        }
        if (bl) {
            return RecordOfValue_4.aN();
        }
        return RecordOfValue_4.aN();
    }

    @Generated
    protected EventBridge_3(EventBridgeBuilder_3 eventBridgeBuilder_3) {
        super(eventBridgeBuilder_3);
        this.gL = eventBridgeBuilder_3.gL;
        this.gM = eventBridgeBuilder_3.gM;
        this.gN = eventBridgeBuilder_3.gN;
    }
}
