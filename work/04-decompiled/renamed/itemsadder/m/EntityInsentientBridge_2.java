package itemsadder.m;

import itemsadder.m.BlockNms_1_21_1_24;
import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalTarget;
import net.minecraft.world.level.GameRules;
import org.bukkit.event.entity.EntityTargetEvent;

class EntityInsentientBridge_2
extends PathfinderGoalTarget {
    private int afC;
    final /* synthetic */ float afD;

    EntityInsentientBridge_2(BlockNms_1_21_1_24 blockNms_1_21_1_24, EntityInsentient entityInsentient, boolean bl, float f) {
        this.afD = f;
        super(entityInsentient, bl);
    }

    public boolean ub() {
        int n = this.e.ej();
        EntityLiving entityLiving = this.e.ei();
        if (n != this.afC && entityLiving != null) {
            if (entityLiving.am() == EntityTypes.by && this.e.dO().ab().b(GameRules.O)) {
                return false;
            }
            this.afC = n;
            if (this.e.dR().i() < this.afD) {
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
        this.e.setTarget(this.e.ei(), EntityTargetEvent.TargetReason.TARGET_ATTACKED_ENTITY, true);
        this.g = this.e.p();
        this.h = 300;
        super.d();
    }

    private boolean ui() {
        double d = this.e.dt() + (this.e.dR().j() - 0.5) * 32.0;
        double d2 = this.e.dv() + (double)(this.e.dR().a(16) - 8);
        double d3 = this.e.dz() + (this.e.dR().j() - 0.5) * 32.0;
        return this.e.b(d, d2, d3, true);
    }
}
