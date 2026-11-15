package itemsadder.m;

import itemsadder.m.aks;
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
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.phys.AxisAlignedBB;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityTargetEvent;
import org.jetbrains.annotations.Nullable;

class akt
extends PathfinderGoalTarget {
    private int afj;
    private final boolean afW;
    @Nullable
    private final hb[] afX;
    @Nullable
    private final hb[] afY;
    final /* synthetic */ hb[] afZ;
    final /* synthetic */ hb[] aga;

    akt(aks aks2, EntityInsentient entityInsentient, boolean bl, hb[] hbArray, hb[] hbArray2) {
        this.afZ = hbArray;
        this.aga = hbArray2;
        super(entityInsentient, bl);
        this.afW = this.afZ != null;
        this.afX = this.aga;
        this.afY = this.afZ;
    }

    public boolean ub() {
        int n = this.e.eM();
        EntityLiving entityLiving = this.e.eK();
        if (n != this.afj && entityLiving != null) {
            if (entityLiving.ay() == EntityTypes.cb && ((Boolean)akt.a((Entity)this.e).U().a(GameRules.af)).booleanValue()) {
                return false;
            }
            if (this.afX != null) {
                for (hb hb2 : this.afX) {
                    if (hb2 == null || !hb2.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityLiving.getBukkitLivingEntity())) continue;
                    return false;
                }
            }
            return this.a(entityLiving, PathfinderTargetCondition.a().d().e());
        }
        return false;
    }

    public void uc() {
        this.e.setTarget(this.e.eK(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.g = this.e.ag_();
        this.afj = this.e.eM();
        this.h = 300;
        if (this.afW) {
            this.ud();
        }
        super.d();
    }

    private void ud() {
        double d = this.l();
        AxisAlignedBB axisAlignedBB = AxisAlignedBB.a((Vec3D)this.e.dI()).c(d, 10.0, d);
        List list = this.e.ao().a(this.e.getClass(), axisAlignedBB, IEntitySelector.f);
        for (EntityInsentient entityInsentient : list) {
            if (this.e == entityInsentient || entityInsentient.ag_() != null || this.e instanceof EntityTameableAnimal && ((EntityTameableAnimal)this.e).U_() != ((EntityTameableAnimal)entityInsentient).U_() || entityInsentient.t((Entity)this.e.eK())) continue;
            boolean bl = false;
            if (this.afY != null) {
                for (hb hb2 : this.afY) {
                    if (hb2 == null || !hb2.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityInsentient.getBukkitLivingEntity())) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) continue;
            this.a(entityInsentient, this.e.eK());
        }
    }

    private void a(EntityInsentient entityInsentient, EntityLiving entityLiving) {
        entityInsentient.setTarget(entityLiving, EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
    }
}
