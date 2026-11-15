package itemsadder.m;

import itemsadder.m.BlockNms_1_21_6_24;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.level.GameRules;
import org.bukkit.event.entity.EntityTargetEvent;

class EntityInsentientBridge_14
extends PathfinderGoalTarget {
    private int afC;
    final /* synthetic */ float ahB;

    EntityInsentientBridge_14(BlockNms_1_21_6_24 blockNms_1_21_6_24, EntityInsentient entityInsentient, boolean bl, float f) {
        this.ahB = f;
        super(entityInsentient, bl);
    }

    public boolean ub() {
        int n = this.e.ey();
        EntityLiving entityLiving = this.e.ew();
        if (n != this.afC && entityLiving != null) {
            if (entityLiving.ap() == EntityTypes.bU && EntityInsentientBridge_14.a((Entity)this.e).P().c(GameRules.Q)) {
                return false;
            }
            this.afC = n;
            if (this.e.ec().i() < this.ahB) {
                return this.ui();
            }
            return true;
        }
        return false;
    }

    public boolean c() {
        return false;
    }

    public void uc() {
        this.e.setTarget(this.e.ew(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.g = this.e.e();
        this.h = 300;
        super.d();
    }

    private boolean ui() {
        double d = this.e.dC() + (this.e.ec().j() - 0.5) * 32.0;
        double d2 = this.e.dE() + (double)(this.e.ec().a(16) - 8);
        double d3 = this.e.dI() + (this.e.ec().j() - 0.5) * 32.0;
        return this.e.b(d, d2, d3, true);
    }
}
