package itemsadder.m;

import itemsadder.m.BlockNms_1_21_11_24;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.level.gamerules.GameRules;
import org.bukkit.event.entity.EntityTargetEvent;

class EntityInsentientBridge_6
extends PathfinderGoalTarget {
    private int afC;
    final /* synthetic */ float agl;

    EntityInsentientBridge_6(BlockNms_1_21_11_24 blockNms_1_21_11_24, EntityInsentient entityInsentient, boolean bl, float f) {
        this.agl = f;
        super(entityInsentient, bl);
    }

    public boolean ub() {
        int n = this.e.eM();
        EntityLiving entityLiving = this.e.eK();
        if (n != this.afC && entityLiving != null) {
            if (entityLiving.ay() == EntityTypes.cb && ((Boolean)EntityInsentientBridge_6.a((Entity)this.e).U().a(GameRules.af)).booleanValue()) {
                return false;
            }
            this.afC = n;
            if (this.e.ep().i() < this.agl) {
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
        this.e.setTarget(this.e.eK(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY);
        this.g = this.e.ag_();
        this.h = 300;
        super.d();
    }

    private boolean ui() {
        double d = this.e.dP() + (this.e.ep().j() - 0.5) * 32.0;
        double d2 = this.e.dR() + (double)(this.e.ep().a(16) - 8);
        double d3 = this.e.dV() + (this.e.ep().j() - 0.5) * 32.0;
        return this.e.b(d, d2, d3, true);
    }
}
