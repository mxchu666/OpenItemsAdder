package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class ItemStackBridge_28
extends Builder_14 {
    public final PotionEffectType DQ;

    public ItemStackBridge_28(PotionEffectType potionEffectType) {
        this.DQ = potionEffectType;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return ItemStackBuilder_3.ml();
    }

    @Override
    public ItemStackBuilder_3 a(EntityDamageByEntityEvent entityDamageByEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.G(entityDamageByEntityEvent.getEntity());
    }

    @Override
    public ItemStackBuilder_3 a(PlayerInteractEntityEvent playerInteractEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.G(playerInteractEntityEvent.getRightClicked());
    }

    @Override
    public ItemStackBuilder_3 a(ProjectileHitEvent projectileHitEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.G(projectileHitEvent.getHitEntity());
    }

    private ItemStackBuilder_3 G(Entity entity) {
        LivingEntity livingEntity;
        if (entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).hasPotionEffect(this.DQ)) {
            livingEntity.removePotionEffect(this.DQ);
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }
}
