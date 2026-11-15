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
import org.bukkit.potion.PotionEffectType;

public class os
extends ou {
    public final PotionEffectType DQ;

    public os(PotionEffectType potionEffectType) {
        this.DQ = potionEffectType;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        return pa.ml();
    }

    @Override
    public pa a(EntityDamageByEntityEvent entityDamageByEntityEvent, qm qm2, ItemStack itemStack) {
        return this.G(entityDamageByEntityEvent.getEntity());
    }

    @Override
    public pa a(PlayerInteractEntityEvent playerInteractEntityEvent, qm qm2, ItemStack itemStack) {
        return this.G(playerInteractEntityEvent.getRightClicked());
    }

    @Override
    public pa a(ProjectileHitEvent projectileHitEvent, qm qm2, ItemStack itemStack) {
        return this.G(projectileHitEvent.getHitEntity());
    }

    private pa G(Entity entity) {
        LivingEntity livingEntity;
        if (entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).hasPotionEffect(this.DQ)) {
            livingEntity.removePotionEffect(this.DQ);
            return pa.ml();
        }
        return pa.mk();
    }
}
