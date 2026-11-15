package itemsadder.m;

import itemsadder.m.gc;
import itemsadder.m.hc;
import lombok.Generated;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class hb {
    EntityType vh;
    @Nullable
    gc uS;

    public boolean test(LivingEntity livingEntity, LivingEntity livingEntity2) {
        if (this.vh != null && livingEntity2.getType() != this.vh) {
            return false;
        }
        return this.uS == null || this.uS.test(livingEntity, livingEntity2);
    }

    @Generated
    hb(EntityType entityType, @Nullable gc gc2) {
        this.vh = entityType;
        this.uS = gc2;
    }

    @Generated
    public static hc iQ() {
        return new hc();
    }
}
