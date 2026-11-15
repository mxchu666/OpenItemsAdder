package itemsadder.m;

import itemsadder.m.ud;
import lombok.Generated;
import org.bukkit.entity.EntityType;

public class up
extends ud {
    final EntityType LO;

    public up(EntityType entityType, boolean bl) {
        super(bl);
        this.LO = entityType;
    }

    @Generated
    public EntityType getType() {
        return this.LO;
    }
}
