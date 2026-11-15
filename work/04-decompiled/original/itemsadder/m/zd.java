package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.afz;
import itemsadder.m.ai;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.zi;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;

public class zd
implements ai {
    private final Plugin SM;

    public zd(Plugin plugin) {
        this.SM = plugin;
        bev.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.LOWEST)
    void b(PlayerPickupItemEvent playerPickupItemEvent) {
        if (!playerPickupItemEvent.getItem().hasMetadata("IAProjectileNamespacedID")) {
            return;
        }
        qm qm2 = d.g().e(((MetadataValue)playerPickupItemEvent.getItem().getMetadata("IAProjectileNamespacedID").get(0)).asString());
        if (qm2 == null) {
            return;
        }
        playerPickupItemEvent.getItem().setItemStack(qm2.mP());
    }

    @EventHandler(priority=EventPriority.MONITOR)
    void b(ProjectileHitEvent projectileHitEvent) {
        if (projectileHitEvent.getHitEntity() == null) {
            return;
        }
        if (!projectileHitEvent.getEntity().doesBounce()) {
            return;
        }
        if (!(projectileHitEvent.getHitEntity() instanceof ArmorStand)) {
            return;
        }
        if (((ArmorStand)projectileHitEvent.getHitEntity()).isVisible() || projectileHitEvent.getHitEntity().isInvulnerable()) {
            return;
        }
        if (!projectileHitEvent.getEntity().hasMetadata("Bounce")) {
            projectileHitEvent.getEntity().setMetadata("Bounce", (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)1));
        } else {
            projectileHitEvent.getEntity().setMetadata("Bounce", (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)(((MetadataValue)projectileHitEvent.getEntity().getMetadata("Bounce").get(0)).asInt() + 1)));
        }
        if (((MetadataValue)projectileHitEvent.getEntity().getMetadata("Bounce").get(0)).asInt() > 5) {
            afz.a(projectileHitEvent.getEntity());
        }
    }

    @EventHandler(ignoreCancelled=true)
    void a(EntityShootBowEvent entityShootBowEvent) {
        if (entityShootBowEvent.getEntity().getType() != EntityType.PLAYER) {
            return;
        }
        Entity entity = entityShootBowEvent.getProjectile();
        entity.setMetadata("playerName", (MetadataValue)new FixedMetadataValue(this.SM, (Object)entityShootBowEvent.getEntity().getName()));
        bev.b((Event)new zi(entityShootBowEvent.getEntity(), entityShootBowEvent.getBow(), entityShootBowEvent.getConsumable(), entityShootBowEvent.getProjectile(), entityShootBowEvent.getHand(), entityShootBowEvent.getForce(), entityShootBowEvent.shouldConsumeItem()));
    }

    @EventHandler(ignoreCancelled=true)
    void c(ProjectileLaunchEvent projectileLaunchEvent) {
        ProjectileSource projectileSource = projectileLaunchEvent.getEntity().getShooter();
        if (!(projectileSource instanceof Entity)) {
            return;
        }
        if (((Entity)projectileSource).getType() != EntityType.PLAYER) {
            return;
        }
        Projectile projectile = projectileLaunchEvent.getEntity();
        projectile.setMetadata("playerName", (MetadataValue)new FixedMetadataValue(this.SM, (Object)((Entity)projectileSource).getName()));
    }
}
