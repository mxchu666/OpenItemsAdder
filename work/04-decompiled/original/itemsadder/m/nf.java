package itemsadder.m;

import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class nf
extends ou {
    public final float Cr;

    public nf(float f) {
        this.Cr = f;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        return this.d((Entity)player, (Entity)player);
    }

    @Override
    public pa a(EntityDamageByEntityEvent entityDamageByEntityEvent, qm qm2, ItemStack itemStack) {
        return this.d(entityDamageByEntityEvent.getDamager(), entityDamageByEntityEvent.getEntity());
    }

    @Override
    public pa a(PlayerInteractEntityEvent playerInteractEntityEvent, qm qm2, ItemStack itemStack) {
        return this.d((Entity)playerInteractEntityEvent.getPlayer(), playerInteractEntityEvent.getRightClicked());
    }

    @Override
    public pa a(ProjectileHitEvent projectileHitEvent, qm qm2, ItemStack itemStack) {
        return this.d((Entity)projectileHitEvent.getEntity(), projectileHitEvent.getHitEntity());
    }

    private pa d(Entity entity, Entity entity2) {
        if (entity2 == null) {
            return pa.mk();
        }
        ((LivingEntity)entity2).damage((double)this.Cr, entity);
        return pa.ml();
    }
}
