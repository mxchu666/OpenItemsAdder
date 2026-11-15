package itemsadder.m;

import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.RecordOfValue_4;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface EventWrapper {
    public RecordOfValue_4 a(Event var1, LivingEntityBuilder var2, Player var3);

    public RecordOfValue_4 a(Event var1, LivingEntityBuilder var2);

    default public RecordOfValue_4 a(PlayerInteractEvent playerInteractEvent, LivingEntityBuilder livingEntityBuilder) {
        return this.a((Event)playerInteractEvent, livingEntityBuilder, playerInteractEvent.getPlayer());
    }

    default public RecordOfValue_4 a(EntityDamageByEntityEvent entityDamageByEntityEvent, LivingEntityBuilder livingEntityBuilder) {
        return this.a((Event)entityDamageByEntityEvent, livingEntityBuilder, (Player)entityDamageByEntityEvent.getDamager());
    }

    default public RecordOfValue_4 a(EntityDamageEvent entityDamageEvent, LivingEntityBuilder livingEntityBuilder) {
        return this.a((Event)entityDamageEvent, livingEntityBuilder);
    }

    default public RecordOfValue_4 a(EntityDeathEvent entityDeathEvent, LivingEntityBuilder livingEntityBuilder) {
        return this.a((Event)entityDeathEvent, livingEntityBuilder, entityDeathEvent.getEntity().getKiller());
    }

    default public RecordOfValue_4 a(PlayerInteractEntityEvent playerInteractEntityEvent, LivingEntityBuilder livingEntityBuilder) {
        return this.a((Event)playerInteractEntityEvent, livingEntityBuilder, playerInteractEntityEvent.getPlayer());
    }

    default public RecordOfValue_4 a(ProjectileHitEvent projectileHitEvent, LivingEntityBuilder livingEntityBuilder) {
        return this.a((Event)projectileHitEvent, livingEntityBuilder);
    }
}
