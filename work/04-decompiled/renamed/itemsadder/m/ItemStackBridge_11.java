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

public class ItemStackBridge_11
extends Builder_14 {
    public final float Cr;

    public ItemStackBridge_11(float f) {
        this.Cr = f;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.d((Entity)player, (Entity)player);
    }

    @Override
    public ItemStackBuilder_3 a(EntityDamageByEntityEvent entityDamageByEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.d(entityDamageByEntityEvent.getDamager(), entityDamageByEntityEvent.getEntity());
    }

    @Override
    public ItemStackBuilder_3 a(PlayerInteractEntityEvent playerInteractEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.d((Entity)playerInteractEntityEvent.getPlayer(), playerInteractEntityEvent.getRightClicked());
    }

    @Override
    public ItemStackBuilder_3 a(ProjectileHitEvent projectileHitEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.d((Entity)projectileHitEvent.getEntity(), projectileHitEvent.getHitEntity());
    }

    private ItemStackBuilder_3 d(Entity entity, Entity entity2) {
        if (entity2 == null) {
            return ItemStackBuilder_3.mk();
        }
        ((LivingEntity)entity2).damage((double)this.Cr, entity);
        return ItemStackBuilder_3.ml();
    }
}
