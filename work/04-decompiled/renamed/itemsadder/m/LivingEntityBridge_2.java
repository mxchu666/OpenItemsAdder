package itemsadder.m;

import itemsadder.m.BlockNms_26_1_1_24;
import itemsadder.m.EntityTypeBridge;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.bukkit.event.entity.EntityTargetEvent;
import org.jetbrains.annotations.Nullable;

class LivingEntityBridge_2
extends TargetGoal {
    private int afj;
    private final boolean ail;
    @Nullable
    private final EntityTypeBridge[] aim;
    @Nullable
    private final EntityTypeBridge[] ain;
    final /* synthetic */ EntityTypeBridge[] aio;
    final /* synthetic */ EntityTypeBridge[] aip;

    LivingEntityBridge_2(BlockNms_26_1_1_24 blockNms_26_1_1_24, Mob mob, boolean bl, EntityTypeBridge[] entityTypeBridgeArray, EntityTypeBridge[] entityTypeBridgeArray2) {
        this.aio = entityTypeBridgeArray;
        this.aip = entityTypeBridgeArray2;
        super(mob, bl);
        this.ail = this.aio != null;
        this.aim = this.aip;
        this.ain = this.aio;
    }

    public boolean uj() {
        int n = this.mob.getLastHurtByMobTimestamp();
        LivingEntity livingEntity = this.mob.getLastHurtByMob();
        if (n != this.afj && livingEntity != null) {
            if (livingEntity.getType() == EntityType.PLAYER && ((Boolean)LivingEntityBridge_2.getServerLevel((Entity)this.mob).getGameRules().get(GameRules.UNIVERSAL_ANGER)).booleanValue()) {
                return false;
            }
            if (this.aim != null) {
                for (EntityTypeBridge entityTypeBridge : this.aim) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((org.bukkit.entity.LivingEntity)this.mob.getBukkitLivingEntity(), (org.bukkit.entity.LivingEntity)livingEntity.getBukkitLivingEntity())) continue;
                    return false;
                }
            }
            return this.canAttack(livingEntity, TargetingConditions.forCombat().ignoreLineOfSight().ignoreInvisibilityTesting());
        }
        return false;
    }

    public void hn() {
        this.mob.setTarget(this.mob.getLastHurtByMob(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.targetMob = this.mob.getTarget();
        this.afj = this.mob.getLastHurtByMobTimestamp();
        this.unseenMemoryTicks = 300;
        if (this.ail) {
            this.ud();
        }
        super.start();
    }

    private void ud() {
        double d = this.getFollowDistance();
        AABB aABB = AABB.unitCubeFromLowerCorner((Vec3)this.mob.position()).inflate(d, 10.0, d);
        List list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), aABB, EntitySelector.NO_SPECTATORS);
        for (Mob mob : list) {
            if (this.mob == mob || mob.getTarget() != null || this.mob instanceof TamableAnimal && ((TamableAnimal)this.mob).getOwner() != ((TamableAnimal)mob).getOwner() || mob.isAlliedTo((Entity)this.mob.getLastHurtByMob())) continue;
            boolean bl = false;
            if (this.ain != null) {
                for (EntityTypeBridge entityTypeBridge : this.ain) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((org.bukkit.entity.LivingEntity)this.mob.getBukkitLivingEntity(), (org.bukkit.entity.LivingEntity)mob.getBukkitLivingEntity())) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) continue;
            this.a(mob, this.mob.getLastHurtByMob());
        }
    }

    private void a(Mob mob, LivingEntity livingEntity) {
        mob.setTarget(livingEntity, EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
    }
}
