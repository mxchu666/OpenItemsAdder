package itemsadder.m;

import itemsadder.m.av;
import itemsadder.m.dn;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface be {
    public av a(Event var1, dn var2, Player var3);

    public av a(Event var1, dn var2);

    default public av a(PlayerInteractEvent playerInteractEvent, dn dn2) {
        return this.a((Event)playerInteractEvent, dn2, playerInteractEvent.getPlayer());
    }

    default public av a(EntityDamageByEntityEvent entityDamageByEntityEvent, dn dn2) {
        return this.a((Event)entityDamageByEntityEvent, dn2, (Player)entityDamageByEntityEvent.getDamager());
    }

    default public av a(EntityDamageEvent entityDamageEvent, dn dn2) {
        return this.a((Event)entityDamageEvent, dn2);
    }

    default public av a(EntityDeathEvent entityDeathEvent, dn dn2) {
        return this.a((Event)entityDeathEvent, dn2, entityDeathEvent.getEntity().getKiller());
    }

    default public av a(PlayerInteractEntityEvent playerInteractEntityEvent, dn dn2) {
        return this.a((Event)playerInteractEntityEvent, dn2, playerInteractEntityEvent.getPlayer());
    }

    default public av a(ProjectileHitEvent projectileHitEvent, dn dn2) {
        return this.a((Event)projectileHitEvent, dn2);
    }
}
