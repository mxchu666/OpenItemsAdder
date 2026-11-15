package itemsadder.m;

import itemsadder.m.LivingEntityWrapper_2;
import org.bukkit.entity.LivingEntity;

public interface LivingEntityWrapper
extends LivingEntityWrapper_2 {
    public boolean eu();

    public float tm();

    public float tn();

    @Override
    default public boolean i(LivingEntity livingEntity) {
        return true;
    }
}
