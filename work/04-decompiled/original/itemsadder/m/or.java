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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class or
extends ou {
    public final PotionEffectType DK;
    public final int DL;
    public final int DM;
    private final boolean DN;
    private final boolean DO;
    private final boolean DP;

    public or(PotionEffectType potionEffectType, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.DK = potionEffectType;
        this.DL = n;
        this.DM = n2;
        this.DN = bl;
        this.DO = bl2;
        this.DP = bl3;
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
        if (entity instanceof LivingEntity && ((LivingEntity)entity).addPotionEffect(new PotionEffect(this.DK, this.DM, this.DL, this.DN, this.DO, this.DP))) {
            return pa.ml();
        }
        return pa.mk();
    }
}
