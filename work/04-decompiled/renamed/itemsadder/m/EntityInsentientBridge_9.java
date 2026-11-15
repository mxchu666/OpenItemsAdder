package itemsadder.m;

import itemsadder.m.BlockNms_1_21_4_24;
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

class EntityInsentientBridge_9
extends PathfinderGoalTarget {
    private int afj;
    private final boolean agE;
    @Nullable
    private final EntityTypeBridge[] agF;
    @Nullable
    private final EntityTypeBridge[] agG;
    final /* synthetic */ EntityTypeBridge[] agH;
    final /* synthetic */ EntityTypeBridge[] agI;

    EntityInsentientBridge_9(BlockNms_1_21_4_24 blockNms_1_21_4_24, EntityInsentient entityInsentient, boolean bl, EntityTypeBridge[] entityTypeBridgeArray, EntityTypeBridge[] entityTypeBridgeArray2) {
        this.agH = entityTypeBridgeArray;
        this.agI = entityTypeBridgeArray2;
        super(entityInsentient, bl);
        this.agE = this.agH != null;
        this.agF = this.agI;
        this.agG = this.agH;
    }

    public boolean ub() {
        int n = this.e.eq();
        EntityLiving entityLiving = this.e.ep();
        if (n != this.afj && entityLiving != null) {
            if (entityLiving.aq() == EntityTypes.bR && EntityInsentientBridge_9.a((Entity)this.e).O().b(GameRules.P)) {
                return false;
            }
            if (this.agF != null) {
                for (EntityTypeBridge entityTypeBridge : this.agF) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityLiving.getBukkitLivingEntity())) continue;
                    return false;
                }
            }
            return this.a(entityLiving, PathfinderTargetCondition.a().d().e());
        }
        return false;
    }

    public void uc() {
        this.e.setTarget(this.e.ep(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY, true);
        this.g = this.e.O_();
        this.afj = this.e.eq();
        this.h = 300;
        if (this.agE) {
            this.ud();
        }
        super.d();
    }

    private void ud() {
        double d = this.l();
        AxisAlignedBB axisAlignedBB = AxisAlignedBB.a((Vec3D)this.e.dt()).c(d, 10.0, d);
        List list = this.e.dV().a(this.e.getClass(), axisAlignedBB, IEntitySelector.f);
        for (EntityInsentient entityInsentient : list) {
            if (this.e == entityInsentient || entityInsentient.O_() != null || this.e instanceof EntityTameableAnimal && ((EntityTameableAnimal)this.e).ag_() != ((EntityTameableAnimal)entityInsentient).ag_() || entityInsentient.s((Entity)this.e.ep())) continue;
            boolean bl = false;
            if (this.agG != null) {
                for (EntityTypeBridge entityTypeBridge : this.agG) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityInsentient.getBukkitLivingEntity())) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) continue;
            this.a(entityInsentient, this.e.ep());
        }
    }

    private void a(EntityInsentient entityInsentient, EntityLiving entityLiving) {
        entityInsentient.setTarget(entityLiving, EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY, true);
    }
}
