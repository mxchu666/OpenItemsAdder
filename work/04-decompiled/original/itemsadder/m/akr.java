package itemsadder.m;

import itemsadder.m.akm;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.level.GameRules;
import org.bukkit.event.entity.EntityTargetEvent;

class akr
extends PathfinderGoalTarget {
    private int afC;
    final /* synthetic */ float afU;

    akr(akm akm2, EntityInsentient entityInsentient, boolean bl, float f) {
        this.afU = f;
        super(entityInsentient, bl);
    }

    public boolean ub() {
        int n = this.e.eH();
        EntityLiving entityLiving = this.e.eF();
        if (n != this.afC && entityLiving != null) {
            if (entityLiving.ax() == EntityTypes.bX && akr.a((Entity)this.e).S().c(GameRules.Q)) {
                return false;
            }
            this.afC = n;
            if (this.e.ek().i() < this.afU) {
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
        this.e.setTarget(this.e.eF(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.g = this.e.e();
        this.h = 300;
        super.d();
    }

    private boolean ui() {
        double d = this.e.dK() + (this.e.ek().j() - 0.5) * 32.0;
        double d2 = this.e.dM() + (double)(this.e.ek().a(16) - 8);
        double d3 = this.e.dQ() + (this.e.ek().j() - 0.5) * 32.0;
        return this.e.b(d, d2, d3, true);
    }
}
