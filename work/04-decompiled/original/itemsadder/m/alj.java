package itemsadder.m;

import itemsadder.m.ale;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.level.GameRules;
import org.bukkit.event.entity.EntityTargetEvent;

class alj
extends PathfinderGoalTarget {
    private int afC;
    final /* synthetic */ float agT;

    alj(ale ale2, EntityInsentient entityInsentient, boolean bl, float f) {
        this.agT = f;
        super(entityInsentient, bl);
    }

    public boolean ub() {
        int n = this.e.eq();
        EntityLiving entityLiving = this.e.ep();
        if (n != this.afC && entityLiving != null) {
            if (entityLiving.aq() == EntityTypes.bR && alj.a((Entity)this.e).O().b(GameRules.P)) {
                return false;
            }
            this.afC = n;
            if (this.e.dY().i() < this.agT) {
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
        this.e.setTarget(this.e.ep(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY, true);
        this.g = this.e.O_();
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
