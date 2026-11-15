package itemsadder.m;

import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class oc
extends ou {
    public final Particle Dg;
    @Nullable
    public final Object Dh;

    public oc(Particle particle, @Nullable Object object) {
        this.Dg = particle;
        this.Dh = object;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        player.getWorld().spawnParticle(this.Dg, player.getEyeLocation(), 40, 0.0, 0.0, 0.0, 0.0, this.Dh);
        return pa.ml();
    }

    @Override
    public pa a(ProjectileHitEvent projectileHitEvent, qm qm2, ItemStack itemStack) {
        if (projectileHitEvent.getHitEntity() != null) {
            projectileHitEvent.getHitEntity().getWorld().spawnParticle(this.Dg, projectileHitEvent.getHitEntity().getLocation(), 40, 0.0, 0.0, 0.0, 0.0, this.Dh);
        } else {
            projectileHitEvent.getHitBlock().getWorld().spawnParticle(this.Dg, projectileHitEvent.getHitBlock().getLocation(), 40, 0.0, 0.0, 0.0, 0.0, this.Dh);
        }
        return pa.ml();
    }
}
