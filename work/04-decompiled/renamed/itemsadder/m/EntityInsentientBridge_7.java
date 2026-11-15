package itemsadder.m;

import itemsadder.m.BlockNms_1_21_3_24;
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

class EntityInsentientBridge_7
extends PathfinderGoalTarget {
    private int afj;
    private final boolean agn;
    @Nullable
    private final EntityTypeBridge[] ago;
    @Nullable
    private final EntityTypeBridge[] agp;
    final /* synthetic */ EntityTypeBridge[] agq;
    final /* synthetic */ EntityTypeBridge[] agr;

    EntityInsentientBridge_7(BlockNms_1_21_3_24 blockNms_1_21_3_24, EntityInsentient entityInsentient, boolean bl, EntityTypeBridge[] entityTypeBridgeArray, EntityTypeBridge[] entityTypeBridgeArray2) {
        this.agq = entityTypeBridgeArray;
        this.agr = entityTypeBridgeArray2;
        super(entityInsentient, bl);
        this.agn = this.agq != null;
        this.ago = this.agr;
        this.agp = this.agq;
    }

    public boolean ub() {
        int n = this.e.er();
        EntityLiving entityLiving = this.e.eq();
        if (n != this.afj && entityLiving != null) {
            if (entityLiving.aq() == EntityTypes.bS && EntityInsentientBridge_7.a((Entity)this.e).N().b(GameRules.P)) {
                return false;
            }
            if (this.ago != null) {
                for (EntityTypeBridge entityTypeBridge : this.ago) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityLiving.getBukkitLivingEntity())) continue;
                    return false;
                }
            }
            return this.a(entityLiving, PathfinderTargetCondition.a().d().e());
        }
        return false;
    }

    public void uc() {
        this.e.setTarget(this.e.eq(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY, true);
        this.g = this.e.O_();
        this.afj = this.e.er();
        this.h = 300;
        if (this.agn) {
            this.ud();
        }
        super.d();
    }

    private void ud() {
        double d = this.l();
        AxisAlignedBB axisAlignedBB = AxisAlignedBB.a((Vec3D)this.e.du()).c(d, 10.0, d);
        List list = this.e.dW().a(this.e.getClass(), axisAlignedBB, IEntitySelector.f);
        for (EntityInsentient entityInsentient : list) {
            if (this.e == entityInsentient || entityInsentient.O_() != null || this.e instanceof EntityTameableAnimal && ((EntityTameableAnimal)this.e).ah_() != ((EntityTameableAnimal)entityInsentient).ah_() || entityInsentient.s((Entity)this.e.eq())) continue;
            boolean bl = false;
            if (this.agp != null) {
                for (EntityTypeBridge entityTypeBridge : this.agp) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityInsentient.getBukkitLivingEntity())) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) continue;
            this.a(entityInsentient, this.e.eq());
        }
    }

    private void a(EntityInsentient entityInsentient, EntityLiving entityLiving) {
        entityInsentient.setTarget(entityLiving, EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY, true);
    }
}
