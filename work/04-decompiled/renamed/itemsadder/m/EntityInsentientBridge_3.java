package itemsadder.m;

import itemsadder.m.BlockNms_1_21_10_24;
import itemsadder.m.EntityTypeBridge;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTameableAnimal;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.IEntitySelector;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.entity.ai.targeting.PathfinderTargetCondition;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.phys.AxisAlignedBB;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityTargetEvent;
import org.jetbrains.annotations.Nullable;

class EntityInsentientBridge_3
extends PathfinderGoalTarget {
    private int afj;
    private final boolean afF;
    @Nullable
    private final EntityTypeBridge[] afG;
    @Nullable
    private final EntityTypeBridge[] afH;
    final /* synthetic */ EntityTypeBridge[] afI;
    final /* synthetic */ EntityTypeBridge[] afJ;

    EntityInsentientBridge_3(BlockNms_1_21_10_24 blockNms_1_21_10_24, EntityInsentient entityInsentient, boolean bl, EntityTypeBridge[] entityTypeBridgeArray, EntityTypeBridge[] entityTypeBridgeArray2) {
        this.afI = entityTypeBridgeArray;
        this.afJ = entityTypeBridgeArray2;
        super(entityInsentient, bl);
        this.afF = this.afI != null;
        this.afG = this.afJ;
        this.afH = this.afI;
    }

    public boolean ub() {
        int n = this.e.eH();
        EntityLiving entityLiving = this.e.eF();
        if (n != this.afj && entityLiving != null) {
            if (entityLiving.ax() == EntityTypes.bX && EntityInsentientBridge_3.a((Entity)this.e).S().c(GameRules.Q)) {
                return false;
            }
            if (this.afG != null) {
                for (EntityTypeBridge entityTypeBridge : this.afG) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityLiving.getBukkitLivingEntity())) continue;
                    return false;
                }
            }
            return this.a(entityLiving, PathfinderTargetCondition.a().d().e());
        }
        return false;
    }

    public void uc() {
        this.e.setTarget(this.e.eF(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.g = this.e.e();
        this.afj = this.e.eH();
        this.h = 300;
        if (this.afF) {
            this.ud();
        }
        super.d();
    }

    private void ud() {
        double d = this.l();
        AxisAlignedBB axisAlignedBB = AxisAlignedBB.a((Vec3D)this.e.dD()).c(d, 10.0, d);
        List list = this.e.an().a(this.e.getClass(), axisAlignedBB, IEntitySelector.f);
        for (EntityInsentient entityInsentient : list) {
            if (this.e == entityInsentient || entityInsentient.e() != null || this.e instanceof EntityTameableAnimal && ((EntityTameableAnimal)this.e).V_() != ((EntityTameableAnimal)entityInsentient).V_() || entityInsentient.t((Entity)this.e.eF())) continue;
            boolean bl = false;
            if (this.afH != null) {
                for (EntityTypeBridge entityTypeBridge : this.afH) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityInsentient.getBukkitLivingEntity())) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) continue;
            this.a(entityInsentient, this.e.eF());
        }
    }

    private void a(EntityInsentient entityInsentient, EntityLiving entityLiving) {
        entityInsentient.setTarget(entityLiving, EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
    }
}
