package itemsadder.m;

import itemsadder.m.amc;
import itemsadder.m.hb;
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

class amd
extends PathfinderGoalTarget {
    private int afj;
    private final boolean ahU;
    @Nullable
    private final hb[] ahV;
    @Nullable
    private final hb[] ahW;
    final /* synthetic */ hb[] ahX;
    final /* synthetic */ hb[] ahY;

    amd(amc amc2, EntityInsentient entityInsentient, boolean bl, hb[] hbArray, hb[] hbArray2) {
        this.ahX = hbArray;
        this.ahY = hbArray2;
        super(entityInsentient, bl);
        this.ahU = this.ahX != null;
        this.ahV = this.ahY;
        this.ahW = this.ahX;
    }

    public boolean ub() {
        int n = this.e.ey();
        EntityLiving entityLiving = this.e.ew();
        if (n != this.afj && entityLiving != null) {
            if (entityLiving.ap() == EntityTypes.bU && amd.a((Entity)this.e).P().c(GameRules.Q)) {
                return false;
            }
            if (this.ahV != null) {
                for (hb hb2 : this.ahV) {
                    if (hb2 == null || !hb2.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityLiving.getBukkitLivingEntity())) continue;
                    return false;
                }
            }
            return this.a(entityLiving, PathfinderTargetCondition.a().d().e());
        }
        return false;
    }

    public void uc() {
        this.e.setTarget(this.e.ew(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.g = this.e.e();
        this.afj = this.e.ey();
        this.h = 300;
        if (this.ahU) {
            this.ud();
        }
        super.d();
    }

    private void ud() {
        double d = this.l();
        AxisAlignedBB axisAlignedBB = AxisAlignedBB.a((Vec3D)this.e.dv()).c(d, 10.0, d);
        List list = this.e.ai().a(this.e.getClass(), axisAlignedBB, IEntitySelector.f);
        for (EntityInsentient entityInsentient : list) {
            if (this.e == entityInsentient || entityInsentient.e() != null || this.e instanceof EntityTameableAnimal && ((EntityTameableAnimal)this.e).U_() != ((EntityTameableAnimal)entityInsentient).U_() || entityInsentient.t((Entity)this.e.ew())) continue;
            boolean bl = false;
            if (this.ahW != null) {
                for (hb hb2 : this.ahW) {
                    if (hb2 == null || !hb2.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityInsentient.getBukkitLivingEntity())) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) continue;
            this.a(entityInsentient, this.e.ew());
        }
    }

    private void a(EntityInsentient entityInsentient, EntityLiving entityLiving) {
        entityInsentient.setTarget(entityLiving, EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
    }
}
