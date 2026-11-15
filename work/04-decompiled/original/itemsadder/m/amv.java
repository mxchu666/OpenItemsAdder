package itemsadder.m;

import itemsadder.m.amu;
import itemsadder.m.hb;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityTypes;
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

class amv
extends TargetGoal {
    private int afj;
    private final boolean aiS;
    @Nullable
    private final hb[] aiT;
    @Nullable
    private final hb[] aiU;
    final /* synthetic */ hb[] aiV;
    final /* synthetic */ hb[] aiW;

    amv(amu amu2, Mob mob, boolean bl, hb[] hbArray, hb[] hbArray2) {
        this.aiV = hbArray;
        this.aiW = hbArray2;
        super(mob, bl);
        this.aiS = this.aiV != null;
        this.aiT = this.aiW;
        this.aiU = this.aiV;
    }

    public boolean uj() {
        int n = this.mob.getLastHurtByMobTimestamp();
        LivingEntity livingEntity = this.mob.getLastHurtByMob();
        if (n != this.afj && livingEntity != null) {
            if (livingEntity.getType() == EntityTypes.PLAYER && ((Boolean)amv.getServerLevel((Entity)this.mob).getGameRules().get(GameRules.UNIVERSAL_ANGER)).booleanValue()) {
                return false;
            }
            if (this.aiT != null) {
                for (hb hb2 : this.aiT) {
                    if (hb2 == null || !hb2.test((org.bukkit.entity.LivingEntity)this.mob.getBukkitLivingEntity(), (org.bukkit.entity.LivingEntity)livingEntity.getBukkitLivingEntity())) continue;
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
        if (this.aiS) {
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
            if (this.aiU != null) {
                for (hb hb2 : this.aiU) {
                    if (hb2 == null || !hb2.test((org.bukkit.entity.LivingEntity)this.mob.getBukkitLivingEntity(), (org.bukkit.entity.LivingEntity)mob.getBukkitLivingEntity())) continue;
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
