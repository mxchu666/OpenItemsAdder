package itemsadder.m;

import itemsadder.m.Opaque136;
import lombok.Generated;
import org.bukkit.entity.EntityType;

public class EntityTypeBridge_6
extends Opaque136 {
    final EntityType LO;

    public EntityTypeBridge_6(EntityType entityType, boolean bl) {
        super(bl);
        this.LO = entityType;
    }

    @Generated
    public EntityType getType() {
        return this.LO;
    }
}
