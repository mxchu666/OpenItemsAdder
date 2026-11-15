package itemsadder.m;

import itemsadder.m.BlockNms_1_21_5_24;
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

class EntityInsentientBridge_11
extends PathfinderGoalTarget {
    private int afj;
    private final boolean agV;
    @Nullable
    private final EntityTypeBridge[] agW;
    @Nullable
    private final EntityTypeBridge[] agX;
    final /* synthetic */ EntityTypeBridge[] agY;
    final /* synthetic */ EntityTypeBridge[] agZ;

    EntityInsentientBridge_11(BlockNms_1_21_5_24 blockNms_1_21_5_24, EntityInsentient entityInsentient, boolean bl, EntityTypeBridge[] entityTypeBridgeArray, EntityTypeBridge[] entityTypeBridgeArray2) {
        this.agY = entityTypeBridgeArray;
        this.agZ = entityTypeBridgeArray2;
        super(entityInsentient, bl);
        this.agV = this.agY != null;
        this.agW = this.agZ;
        this.agX = this.agY;
    }

    public boolean ub() {
        int n = this.e.et();
        EntityLiving entityLiving = this.e.er();
        if (n != this.afj && entityLiving != null) {
            if (entityLiving.an() == EntityTypes.bT && EntityInsentientBridge_11.a((Entity)this.e).O().c(GameRules.Q)) {
                return false;
            }
            if (this.agW != null) {
                for (EntityTypeBridge entityTypeBridge : this.agW) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityLiving.getBukkitLivingEntity())) continue;
                    return false;
                }
            }
            return this.a(entityLiving, PathfinderTargetCondition.a().d().e());
        }
        return false;
    }

    public void uc() {
        this.e.setTarget(this.e.er(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.g = this.e.e();
        this.afj = this.e.et();
        this.h = 300;
        if (this.agV) {
            this.ud();
        }
        super.d();
    }

    private void ud() {
        double d = this.l();
        AxisAlignedBB axisAlignedBB = AxisAlignedBB.a((Vec3D)this.e.dt()).c(d, 10.0, d);
        List list = this.e.dV().a(this.e.getClass(), axisAlignedBB, IEntitySelector.f);
        for (EntityInsentient entityInsentient : list) {
            if (this.e == entityInsentient || entityInsentient.e() != null || this.e instanceof EntityTameableAnimal && ((EntityTameableAnimal)this.e).T_() != ((EntityTameableAnimal)entityInsentient).T_() || entityInsentient.s((Entity)this.e.er())) continue;
            boolean bl = false;
            if (this.agX != null) {
                for (EntityTypeBridge entityTypeBridge : this.agX) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityInsentient.getBukkitLivingEntity())) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) continue;
            this.a(entityInsentient, this.e.er());
        }
    }

    private void a(EntityInsentient entityInsentient, EntityLiving entityLiving) {
        entityInsentient.setTarget(entityLiving, EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
    }
}
