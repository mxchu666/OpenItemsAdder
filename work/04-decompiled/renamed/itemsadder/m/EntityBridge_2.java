package itemsadder.m;

import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityBridge_2
extends EntityDamageByEntityEvent {
    public EntityBridge_2(Entity entity, Entity entity2, EntityDamageEvent.DamageCause damageCause, double d) {
        super(entity, entity2, damageCause, d);
    }
}
