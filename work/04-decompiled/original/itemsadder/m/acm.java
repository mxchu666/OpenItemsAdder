package itemsadder.m;

import itemsadder.m.zu;
import org.bukkit.entity.LivingEntity;

public interface acm
extends zu {
    public boolean eu();

    public float tm();

    public float tn();

    @Override
    default public boolean i(LivingEntity livingEntity) {
        return true;
    }
}
