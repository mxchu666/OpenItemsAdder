package itemsadder.m;

import itemsadder.m.BlockNms_1_21_6_24;
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

class EntityInsentientBridge_13
extends PathfinderGoalTarget {
    private int afj;
    private final boolean ahm;
    @Nullable
    private final EntityTypeBridge[] ahn;
    @Nullable
    private final EntityTypeBridge[] aho;
    final /* synthetic */ EntityTypeBridge[] ahp;
    final /* synthetic */ EntityTypeBridge[] ahq;

    EntityInsentientBridge_13(BlockNms_1_21_6_24 blockNms_1_21_6_24, EntityInsentient entityInsentient, boolean bl, EntityTypeBridge[] entityTypeBridgeArray, EntityTypeBridge[] entityTypeBridgeArray2) {
        this.ahp = entityTypeBridgeArray;
        this.ahq = entityTypeBridgeArray2;
        super(entityInsentient, bl);
        this.ahm = this.ahp != null;
        this.ahn = this.ahq;
        this.aho = this.ahp;
    }

    public boolean ub() {
        int n = this.e.ey();
        EntityLiving entityLiving = this.e.ew();
        if (n != this.afj && entityLiving != null) {
            if (entityLiving.ap() == EntityTypes.bU && EntityInsentientBridge_13.a((Entity)this.e).P().c(GameRules.Q)) {
                return false;
            }
            if (this.ahn != null) {
                for (EntityTypeBridge entityTypeBridge : this.ahn) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityLiving.getBukkitLivingEntity())) continue;
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
        if (this.ahm) {
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
            if (this.aho != null) {
                for (EntityTypeBridge entityTypeBridge : this.aho) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityInsentient.getBukkitLivingEntity())) continue;
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
