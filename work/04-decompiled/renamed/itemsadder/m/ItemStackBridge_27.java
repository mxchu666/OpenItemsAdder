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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItemStackBridge_27
extends Builder_14 {
    public final PotionEffectType DK;
    public final int DL;
    public final int DM;
    private final boolean DN;
    private final boolean DO;
    private final boolean DP;

    public ItemStackBridge_27(PotionEffectType potionEffectType, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.DK = potionEffectType;
        this.DL = n;
        this.DM = n2;
        this.DN = bl;
        this.DO = bl2;
        this.DP = bl3;
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
        if (entity instanceof LivingEntity && ((LivingEntity)entity).addPotionEffect(new PotionEffect(this.DK, this.DM, this.DL, this.DN, this.DO, this.DP))) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }
}
