package itemsadder.m;

import itemsadder.m.EntityTypeBridgeBuilder;
import itemsadder.m.Predicate_2;
import lombok.Generated;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class EntityTypeBridge {
    EntityType vh;
    @Nullable
    Predicate_2 uS;

    public boolean test(LivingEntity livingEntity, LivingEntity livingEntity2) {
        if (this.vh != null && livingEntity2.getType() != this.vh) {
            return false;
        }
        return this.uS == null || this.uS.test(livingEntity, livingEntity2);
    }

    @Generated
    EntityTypeBridge(EntityType entityType, @Nullable Predicate_2 predicate_2) {
        this.vh = entityType;
        this.uS = predicate_2;
    }

    @Generated
    public static EntityTypeBridgeBuilder iQ() {
        return new EntityTypeBridgeBuilder();
    }
}
