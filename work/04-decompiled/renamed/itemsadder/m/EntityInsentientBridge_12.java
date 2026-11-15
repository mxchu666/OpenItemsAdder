package itemsadder.m;

import itemsadder.m.BlockNms_1_21_5_24;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.level.GameRules;
import org.bukkit.event.entity.EntityTargetEvent;

class EntityInsentientBridge_12
extends PathfinderGoalTarget {
    private int afC;
    final /* synthetic */ float ahk;

    EntityInsentientBridge_12(BlockNms_1_21_5_24 blockNms_1_21_5_24, EntityInsentient entityInsentient, boolean bl, float f) {
        this.ahk = f;
        super(entityInsentient, bl);
    }

    public boolean ub() {
        int n = this.e.et();
        EntityLiving entityLiving = this.e.er();
        if (n != this.afC && entityLiving != null) {
            if (entityLiving.an() == EntityTypes.bT && EntityInsentientBridge_12.a((Entity)this.e).O().c(GameRules.Q)) {
                return false;
            }
            this.afC = n;
            if (this.e.dY().i() < this.ahk) {
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
        this.e.setTarget(this.e.er(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.g = this.e.e();
        this.h = 300;
        super.d();
    }

    private boolean ui() {
        double d = this.e.dA() + (this.e.dY().j() - 0.5) * 32.0;
        double d2 = this.e.dC() + (double)(this.e.dY().a(16) - 8);
        double d3 = this.e.dG() + (this.e.dY().j() - 0.5) * 32.0;
        return this.e.b(d, d2, d3, true);
    }
}
