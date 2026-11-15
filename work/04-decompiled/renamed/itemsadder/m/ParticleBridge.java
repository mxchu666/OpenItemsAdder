package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ParticleBridge
extends Builder_14 {
    public final Particle Dg;
    @Nullable
    public final Object Dh;

    public ParticleBridge(Particle particle, @Nullable Object object) {
        this.Dg = particle;
        this.Dh = object;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        player.getWorld().spawnParticle(this.Dg, player.getEyeLocation(), 40, 0.0, 0.0, 0.0, 0.0, this.Dh);
        return ItemStackBuilder_3.ml();
    }

    @Override
    public ItemStackBuilder_3 a(ProjectileHitEvent projectileHitEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (projectileHitEvent.getHitEntity() != null) {
            projectileHitEvent.getHitEntity().getWorld().spawnParticle(this.Dg, projectileHitEvent.getHitEntity().getLocation(), 40, 0.0, 0.0, 0.0, 0.0, this.Dh);
        } else {
            projectileHitEvent.getHitBlock().getWorld().spawnParticle(this.Dg, projectileHitEvent.getHitBlock().getLocation(), 40, 0.0, 0.0, 0.0, 0.0, this.Dh);
        }
        return ItemStackBuilder_3.ml();
    }
}
