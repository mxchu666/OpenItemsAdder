package itemsadder.m;

import itemsadder.m.BlockNms_1_21_1_24;
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

class EntityInsentientBridge
extends PathfinderGoalTarget {
    private int afj;
    private final boolean afk;
    @Nullable
    private final EntityTypeBridge[] afl;
    @Nullable
    private final EntityTypeBridge[] afm;
    final /* synthetic */ EntityTypeBridge[] afn;
    final /* synthetic */ EntityTypeBridge[] afo;

    EntityInsentientBridge(BlockNms_1_21_1_24 blockNms_1_21_1_24, EntityInsentient entityInsentient, boolean bl, EntityTypeBridge[] entityTypeBridgeArray, EntityTypeBridge[] entityTypeBridgeArray2) {
        this.afn = entityTypeBridgeArray;
        this.afo = entityTypeBridgeArray2;
        super(entityInsentient, bl);
        this.afk = this.afn != null;
        this.afl = this.afo;
        this.afm = this.afn;
    }

    public boolean ub() {
        int n = this.e.ej();
        EntityLiving entityLiving = this.e.ei();
        if (n != this.afj && entityLiving != null) {
            if (entityLiving.am() == EntityTypes.by && this.e.dO().ab().b(GameRules.O)) {
                return false;
            }
            if (this.afl != null) {
                for (EntityTypeBridge entityTypeBridge : this.afl) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityLiving.getBukkitLivingEntity())) continue;
                    return false;
                }
            }
            return this.a(entityLiving, PathfinderTargetCondition.a().d().e());
        }
        return false;
    }

    public void uc() {
        this.e.setTarget(this.e.ei(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY, true);
        this.g = this.e.p();
        this.afj = this.e.ej();
        this.h = 300;
        if (this.afk) {
            this.ud();
        }
        super.d();
    }

    private void ud() {
        double d = this.l();
        AxisAlignedBB axisAlignedBB = AxisAlignedBB.a((Vec3D)this.e.dm()).c(d, 10.0, d);
        List list = this.e.dO().a(this.e.getClass(), axisAlignedBB, IEntitySelector.f);
        for (EntityInsentient entityInsentient : list) {
            if (this.e == entityInsentient || entityInsentient.p() != null || this.e instanceof EntityTameableAnimal && ((EntityTameableAnimal)this.e).T_() != ((EntityTameableAnimal)entityInsentient).T_() || entityInsentient.s((Entity)this.e.ei())) continue;
            boolean bl = false;
            if (this.afm != null) {
                for (EntityTypeBridge entityTypeBridge : this.afm) {
                    if (entityTypeBridge == null || !entityTypeBridge.test((LivingEntity)this.e.getBukkitLivingEntity(), (LivingEntity)entityInsentient.getBukkitLivingEntity())) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) continue;
            this.a(entityInsentient, this.e.ei());
        }
    }

    private void a(EntityInsentient entityInsentient, EntityLiving entityLiving) {
        entityInsentient.setTarget(entityLiving, EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY, true);
    }
}
