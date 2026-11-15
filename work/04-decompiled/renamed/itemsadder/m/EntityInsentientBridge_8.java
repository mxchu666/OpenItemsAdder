package itemsadder.m;

import itemsadder.m.BlockNms_1_21_3_24;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.level.GameRules;
import org.bukkit.event.entity.EntityTargetEvent;

class EntityInsentientBridge_8
extends PathfinderGoalTarget {
    private int afC;
    final /* synthetic */ float agC;

    EntityInsentientBridge_8(BlockNms_1_21_3_24 blockNms_1_21_3_24, EntityInsentient entityInsentient, boolean bl, float f) {
        this.agC = f;
        super(entityInsentient, bl);
    }

    public boolean ub() {
        int n = this.e.er();
        EntityLiving entityLiving = this.e.eq();
        if (n != this.afC && entityLiving != null) {
            if (entityLiving.aq() == EntityTypes.bS && EntityInsentientBridge_8.a((Entity)this.e).N().b(GameRules.P)) {
                return false;
            }
            this.afC = n;
            if (this.e.dZ().i() < this.agC) {
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
        this.e.setTarget(this.e.eq(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY, true);
        this.g = this.e.O_();
        this.h = 300;
        super.d();
    }

    private boolean ui() {
        double d = this.e.dB() + (this.e.dZ().j() - 0.5) * 32.0;
        double d2 = this.e.dD() + (double)(this.e.dZ().a(16) - 8);
        double d3 = this.e.dH() + (this.e.dZ().j() - 0.5) * 32.0;
        return this.e.b(d, d2, d3, true);
    }
}
