package itemsadder.m;

import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class bfb
extends EntityDamageByEntityEvent {
    public bfb(Entity entity, Entity entity2, EntityDamageEvent.DamageCause damageCause, double d) {
        super(entity, entity2, damageCause, d);
    }
}
